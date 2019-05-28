package com.tencent.xweb.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.xwalk.core.Log;

public final class a {
    private static String TAG = "AESUtil";

    public static SecretKey avj(String str) {
        AppMethodBeat.i(3995);
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(avk(str), "AES");
            AppMethodBeat.o(3995);
            return secretKeySpec;
        } catch (Throwable th) {
            Log.e(TAG, "makekey exp:" + th.getMessage());
            AppMethodBeat.o(3995);
            return null;
        }
    }

    private static byte[] a(byte[] bArr, SecretKey secretKey) {
        AppMethodBeat.i(3996);
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), "AES");
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
            instance.init(2, secretKeySpec);
            byte[] doFinal = instance.doFinal(bArr);
            AppMethodBeat.o(3996);
            return doFinal;
        } catch (Throwable th) {
            Log.e(TAG, "decrypt exp:" + th.getMessage());
            AppMethodBeat.o(3996);
            return null;
        }
    }

    public static String a(String str, SecretKey secretKey) {
        AppMethodBeat.i(3997);
        byte[] a = a(avk(str), secretKey);
        String str2;
        if (a == null) {
            str2 = "";
            AppMethodBeat.o(3997);
            return str2;
        }
        str2 = new String(a);
        AppMethodBeat.o(3997);
        return str2;
    }

    private static byte[] avk(String str) {
        AppMethodBeat.i(3998);
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        AppMethodBeat.o(3998);
        return bArr;
    }
}
