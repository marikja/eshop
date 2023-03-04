package com.eshop.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Base64;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ImageUtil {

    public static String toBase64(byte[] image) {
        return Base64.getEncoder().encodeToString(image);
    }

    public static byte[] fromBase64(String image) {
        return Base64.getDecoder().decode(image);
    }
}
