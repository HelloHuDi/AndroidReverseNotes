package com.tencent.mm.a;

import com.google.android.gms.common.util.AndroidUtilsLight;
import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;

public final class n {
    public static String getSHA1(String str) {
        MessageDigest instance = MessageDigest.getInstance(AndroidUtilsLight.DIGEST_ALGORITHM_SHA1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(str.getBytes("UTF-8"));
        return bytesToHex(instance.digest(byteArrayOutputStream.toByteArray()));
    }

    private static String bytesToHex(byte[] bArr) {
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        int length = bArr.length;
        char[] cArr2 = new char[(length * 2)];
        int i = 0;
        int i2 = 0;
        while (i < length) {
            byte b = bArr[i];
            int i3 = i2 + 1;
            cArr2[i2] = cArr[(b >>> 4) & 15];
            int i4 = i3 + 1;
            cArr2[i3] = cArr[b & 15];
            i++;
            i2 = i4;
        }
        return new String(cArr2);
    }
}
