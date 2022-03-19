package org.car.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {
    private static final BCryptPasswordEncoder encoder = (BCryptPasswordEncoder) SingletonHandler.getInstance(BCryptPasswordEncoder.class);
    private PasswordUtil() {}

    public static String encode(final String password) {
        return encoder.encode(password);
    }

    public static boolean compare(final String password, final String encryptedPassword) {
        return password.equals(encryptedPassword) || encoder.matches(password, encryptedPassword);
    }
}
