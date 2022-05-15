package org.stadium.service;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.stadium.dto.MediaDto;
import org.stadium.entity.Media;
import org.stadium.mapper.MediaMapper;
import org.stadium.repository.MediaRepository;

import java.util.Arrays;

@Service
public class MediaService extends AbstractService<Media, MediaDto, Integer> {
    private final MediaRepository repository;


    public MediaService(MediaRepository repository) {
        super(new MediaMapper(), repository);
        this.repository = repository;
    }

    public Media create(final MultipartFile image, final String filename) {
        byte[] bytes = null;
        try {
            bytes = image.getBytes();
        } catch (final Exception exception) {}
        return super.create(MediaDto.builder().image(toByte(bytes)).name(filename).build());
    }

    public InputStreamSource getImage(final String name) {
        final MediaDto dto = mapper.toDto(repository.findMediaByName(name));
        return toByteArray(tobyte(dto.getImage()));
    }


    private Byte[] toByte(final byte[] bytes) {
        final Byte[] result = new Byte[bytes.length];
        Arrays.setAll(result, n -> bytes[n]);
        return result;
    }

    private byte[] tobyte(final Byte[] bytes) {
        final byte[] result = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            result[i] = Byte.valueOf(bytes[i]);
        }
        return result;
    }

    public ByteArrayResource toByteArray(final byte[] bytes) {
        return new ByteArrayResource(bytes);
    }


}
