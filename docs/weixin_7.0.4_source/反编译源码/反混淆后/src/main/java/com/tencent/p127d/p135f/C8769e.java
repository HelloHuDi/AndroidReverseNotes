package com.tencent.p127d.p135f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.tencent.d.f.e */
public final class C8769e {
    public static byte[] atV(String str) {
        AppMethodBeat.m2504i(114611);
        if (str == null) {
            AppMethodBeat.m2505o(114611);
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        char[] toCharArray = str.toCharArray();
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (((byte) "0123456789ABCDEF".indexOf(toCharArray[i2 + 1])) | (((byte) "0123456789ABCDEF".indexOf(toCharArray[i2])) << 4));
        }
        AppMethodBeat.m2505o(114611);
        return bArr;
    }

    public static final String bytesToHexString(byte[] bArr) {
        AppMethodBeat.m2504i(114612);
        if (bArr == null) {
            AppMethodBeat.m2505o(114612);
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
        AppMethodBeat.m2505o(114612);
        return stringBuffer2;
    }

    /* renamed from: cn */
    public static byte[] m15600cn(byte[] bArr) {
        AppMethodBeat.m2504i(114613);
        byte[] bArr2 = null;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            bArr2 = instance.digest();
        } catch (Exception | NoSuchAlgorithmException e) {
        }
        AppMethodBeat.m2505o(114613);
        return bArr2;
    }
}
