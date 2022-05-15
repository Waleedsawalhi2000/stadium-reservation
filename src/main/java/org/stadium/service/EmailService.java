package org.stadium.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.stadium.dto.EmailDto;
import org.stadium.dto.SchedulerDto;
import org.stadium.dto.SimpleResponse;
import org.stadium.dto.UserDto;
import org.stadium.entity.Scheduler;
import org.stadium.entity.User;
import org.stadium.util.PasswordUtil;

import java.util.Objects;


@Service
public class EmailService {
    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private UserService userService;

    @Autowired
    private SchedulerService service;

    public void checkCodeId(final Integer codeId, final String email) {
        final SchedulerDto ticket = service.findCodeBy(email);
        if (ticket == null) {
            throw new IllegalStateException("This code doesn't exist.");
        }
        if (!Objects.equals(ticket.getValue(), codeId)) {
            throw new IllegalStateException("This code doesn't exist.");
        }
    }

    public User changePassword(final Integer codeId,
                               final String password,
                               final String email) {
        checkCodeId(codeId, email);
        final UserDto user = userService.findByEmail(email);
        user.setPassword(password);
        service.deleteByCode(codeId);
        return userService.update(user, user.getId());
    }

    public SimpleResponse sendPasswordToEmail(final String email) {
        final UserDto user = userService.findByEmail(email);
        if (user == null) {
            throw new IllegalStateException("This email doesn't found.");
        }
        final Scheduler request = service.create(email);
        final String textMessage = String.format("Hi %s %s\nThis is your verification code:- %s", user.getFirstname(), user.getLastname(), request.getValue());
        return sendSimpleMessage(EmailDto.builder().to(request.getUser().getEmail()).subject("Reset Password").text(textMessage).build());
    }

    private SimpleResponse sendSimpleMessage(final EmailDto dto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreplay.waleed2000sawalhi@gmail.com");
        message.setTo(dto.getTo());
        message.setSubject(dto.getSubject());
        message.setText(dto.getText());
        emailSender.send(message);
        return new SimpleResponse("Message Sent!");
    }
}
