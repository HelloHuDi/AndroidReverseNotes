package com.tencent.p177mm.plugin.ext.p1398a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/* renamed from: com.tencent.mm.plugin.ext.a.a */
public final class C27902a {
    private static char[] fuo = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static SecretKey lPz = null;

    private static void brG() {
        AppMethodBeat.m2504i(20291);
        try {
            if (lPz == null) {
                ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(C27902a.m44379Fu("aced00057372001f6a617661782e63727970746f2e737065632e5365637265744b6579537065635b470b66e230614d0200024c0009616c676f726974686d7400124c6a6176612f6c616e672f537472696e673b5b00036b65797400025b427870740003414553757200025b42acf317f8060854e0020000787000000010402a2173bd6f2542e5e71ee414b2e1e8")));
                lPz = (SecretKey) objectInputStream.readObject();
                objectInputStream.close();
            }
            AppMethodBeat.m2505o(20291);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AESUtil", e, "", new Object[0]);
            AppMethodBeat.m2505o(20291);
        }
    }

    /* renamed from: Ld */
    private static byte[] m44380Ld(String str) {
        AppMethodBeat.m2504i(20292);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(20292);
            return null;
        }
        C27902a.brG();
        Cipher instance = Cipher.getInstance("AES");
        instance.init(1, lPz);
        byte[] doFinal = instance.doFinal(str.getBytes("UTF8"));
        AppMethodBeat.m2505o(20292);
        return doFinal;
    }

    /* renamed from: ii */
    public static String m44382ii(long j) {
        AppMethodBeat.m2504i(20293);
        byte[] Ld = C27902a.m44380Ld(String.valueOf(j));
        if (Ld == null) {
            AppMethodBeat.m2505o(20293);
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(Ld.length * 2);
        for (int i = 0; i < Ld.length; i++) {
            stringBuilder.append(fuo[(Ld[i] & 240) >>> 4]);
            stringBuilder.append(fuo[Ld[i] & 15]);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(20293);
        return stringBuilder2;
    }

    private static String decrypt(String str) {
        AppMethodBeat.m2504i(20294);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(20294);
            return null;
        }
        C27902a.brG();
        Cipher instance = Cipher.getInstance("AES");
        instance.init(2, lPz);
        String str2 = new String(instance.doFinal(C27902a.m44379Fu(str)), "UTF8");
        AppMethodBeat.m2505o(20294);
        return str2;
    }

    /* renamed from: Le */
    public static long m44381Le(String str) {
        AppMethodBeat.m2504i(20295);
        long longValue = Long.valueOf(C27902a.decrypt(str).trim()).longValue();
        AppMethodBeat.m2505o(20295);
        return longValue;
    }

    /* renamed from: Fu */
    private static byte[] m44379Fu(String str) {
        AppMethodBeat.m2504i(20296);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(20296);
            return null;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) Integer.parseInt(str.substring(i * 2, (i * 2) + 2), 16);
        }
        AppMethodBeat.m2505o(20296);
        return bArr;
    }
}
