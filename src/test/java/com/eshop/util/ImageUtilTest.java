package com.eshop.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ImageUtilTest {

    @Test
    void testFullConversion_fromToBase64() {
        String base64 = "iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAIAAACRXR/mAAAAVUlEQVR4nOzOoRHAIAAAsV6vqpKhmZsFMK9AJBPkG/9" +
                "87vOeDuxpFVqFVqFVaBVahVahVWgVWoVWoVVoFVqFVqFVaBVahVahVWgVWoVWoVWsAAAA///iAAEJiuMy0wAAAABJRU5ErkJggg==";

       byte[] bytesImage = ImageUtil.fromBase64(base64);

        assertEquals(base64, ImageUtil.toBase64(bytesImage));
    }

    @Test
    void testFullConversion_toFromBase64() {
        byte[] bytesImage = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 8, 0, 0,
                0, 8, 1, 3, 0, 0, 0, -2, -63, 44, -56, 0, 0, 0, 6, 80, 76, 84, 69, -1, -1, -1, -65, -65, -65, -93, 67,
                118, 57, 0, 0, 0, 14, 73, 68, 65, 84, 8, -41, 99, -8, 0, -123, -4, 16, 8, 0, 46, 0, 3, -3, -93, 105,
                110, -47, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};

        String base64 = ImageUtil.toBase64(bytesImage);

        assertArrayEquals(bytesImage, ImageUtil.fromBase64(base64));
    }
}
