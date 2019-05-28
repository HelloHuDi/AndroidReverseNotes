package com.tencent.xweb.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.xwalk.core.Log;

/* renamed from: com.tencent.xweb.util.a */
public final class C41130a {
    private static String TAG = "AESUtil";

    public static SecretKey avj(String str) {
        AppMethodBeat.m2504i(3995);
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(C41130a.avk(str), "AES");
            AppMethodBeat.m2505o(3995);
            return secretKeySpec;
        } catch (Throwable th) {
            Log.m81046e(TAG, "makekey exp:" + th.getMessage());
            AppMethodBeat.m2505o(3995);
            return null;
        }
    }

    /* renamed from: a */
    private static byte[] m71558a(byte[] bArr, SecretKey secretKey) {
        AppMethodBeat.m2504i(3996);
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), "AES");
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
            instance.init(2, secretKeySpec);
            byte[] doFinal = instance.doFinal(bArr);
            AppMethodBeat.m2505o(3996);
            return doFinal;
        } catch (Throwable th) {
            Log.m81046e(TAG, "decrypt exp:" + th.getMessage());
            AppMethodBeat.m2505o(3996);
            return null;
        }
    }

    /* renamed from: a */
    public static String m71557a(String str, SecretKey secretKey) {
        AppMethodBeat.m2504i(3997);
        byte[] a = C41130a.m71558a(C41130a.avk(str), secretKey);
        String str2;
        if (a == null) {
            str2 = "";
            AppMethodBeat.m2505o(3997);
            return str2;
        }
        str2 = new String(a);
        AppMethodBeat.m2505o(3997);
        return str2;
    }

    private static byte[] avk(String str) {
        AppMethodBeat.m2504i(3998);
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        AppMethodBeat.m2505o(3998);
        return bArr;
    }
}
