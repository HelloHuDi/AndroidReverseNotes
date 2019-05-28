package com.tencent.d.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class e {
    public static byte[] atV(String str) {
        AppMethodBeat.i(114611);
        if (str == null) {
            AppMethodBeat.o(114611);
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        char[] toCharArray = str.toCharArray();
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (((byte) "0123456789ABCDEF".indexOf(toCharArray[i2 + 1])) | (((byte) "0123456789ABCDEF".indexOf(toCharArray[i2])) << 4));
        }
        AppMethodBeat.o(114611);
        return bArr;
    }

    public static final String bytesToHexString(byte[] bArr) {
        AppMethodBeat.i(114612);
        if (bArr == null) {
            AppMethodBeat.o(114612);
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() < 2) {
                stringBuffer.append(0);
            }
            stringBuffer.append(toHexString.toUpperCase());
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(114612);
        return stringBuffer2;
    }

    public static byte[] cn(byte[] bArr) {
        AppMethodBeat.i(114613);
        byte[] bArr2 = null;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            bArr2 = instance.digest();
        } catch (Exception | NoSuchAlgorithmException e) {
        }
        AppMethodBeat.o(114613);
        return bArr2;
    }
}
