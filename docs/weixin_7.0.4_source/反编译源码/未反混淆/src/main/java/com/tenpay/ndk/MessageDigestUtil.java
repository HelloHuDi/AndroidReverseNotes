package com.tenpay.ndk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MessageDigestUtil {
    private native byte[] doSHA256(byte[] bArr);

    public static String bytesToHex(byte[] bArr) {
        AppMethodBeat.i(49574);
        StringBuilder stringBuilder = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            AppMethodBeat.o(49574);
            return null;
        }
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(toHexString.toUpperCase());
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(49574);
        return stringBuilder2;
    }

    public String getSHA256Hex(byte[] bArr) {
        AppMethodBeat.i(49575);
        String str = null;
        if (bArr != null) {
            try {
                byte[] doSHA256 = doSHA256(bArr);
                if (doSHA256 != null) {
                    str = bytesToHex(doSHA256);
                }
            } catch (Exception e) {
            }
        }
        AppMethodBeat.o(49575);
        return str;
    }
}
