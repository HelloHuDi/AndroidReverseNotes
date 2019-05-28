package com.tencent.matrix.resource.p161a.p162a;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.tencent.matrix.resource.a.a.a */
public final class C1093a {
    private static final char[] HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: w */
    public static String m2408w(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            byte[] digest = instance.digest();
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : digest) {
                if (b < (byte) 0 || b > (byte) 15) {
                    stringBuilder.append(HEX_DIGITS[(b >> 4) & 15]).append(HEX_DIGITS[b & 15]);
                } else {
                    stringBuilder.append('0').append(HEX_DIGITS[b]);
                }
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }
}
