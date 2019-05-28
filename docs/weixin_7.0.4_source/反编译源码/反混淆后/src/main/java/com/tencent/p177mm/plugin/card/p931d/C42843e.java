package com.tencent.p177mm.plugin.card.p931d;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.tencent.mm.plugin.card.d.e */
public final class C42843e {
    /* renamed from: ds */
    public static String m76044ds(String str, String str2) {
        AppMethodBeat.m2504i(88844);
        if (str2 == null || str2.length() <= 0) {
            AppMethodBeat.m2505o(88844);
            return null;
        }
        String str3;
        C1720g.m3534RN();
        try {
            byte[] ay = C42843e.m76043ay(("CbW9HMPiil38ldOjZp5WkwlIfzvLwiX6_" + C1668a.m3383QF() + "_" + str).getBytes());
            byte[] He = C42843e.m76041He(str2);
            SecretKeySpec secretKeySpec = new SecretKeySpec(ay, "AES");
            Cipher instance = Cipher.getInstance("AES");
            instance.init(2, secretKeySpec);
            str3 = new String(instance.doFinal(He));
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.CardDymanicQrcodeOfflineHelper", e, "", new Object[0]);
            str3 = null;
        }
        AppMethodBeat.m2505o(88844);
        return str3;
    }

    /* renamed from: dt */
    public static String m76045dt(String str, String str2) {
        String str3 = null;
        AppMethodBeat.m2504i(88845);
        if (str2 == null || str2.length() <= 0) {
            AppMethodBeat.m2505o(88845);
        } else {
            C1720g.m3534RN();
            try {
                byte[] ay = C42843e.m76043ay(("CbW9HMPiil38ldOjZp5WkwlIfzvLwiX6_" + C1668a.m3383QF() + "_" + str).getBytes());
                byte[] bytes = str2.getBytes();
                SecretKeySpec secretKeySpec = new SecretKeySpec(ay, "AES");
                Cipher instance = Cipher.getInstance("AES");
                instance.init(1, secretKeySpec);
                str3 = C42843e.m76042ax(instance.doFinal(bytes));
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.CardDymanicQrcodeOfflineHelper", e, "", new Object[0]);
            }
            AppMethodBeat.m2505o(88845);
        }
        return str3;
    }

    /* renamed from: ax */
    private static String m76042ax(byte[] bArr) {
        AppMethodBeat.m2504i(88846);
        String str;
        if (bArr == null) {
            str = "";
            AppMethodBeat.m2505o(88846);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            stringBuilder.append("0123456789ABCDEF".charAt((bArr[i] >> 4) & 15)).append("0123456789ABCDEF".charAt(bArr[i] & 15));
        }
        str = stringBuilder.toString();
        AppMethodBeat.m2505o(88846);
        return str;
    }

    /* renamed from: He */
    private static byte[] m76041He(String str) {
        AppMethodBeat.m2504i(88847);
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = Integer.valueOf(str.substring(i * 2, (i * 2) + 2), 16).byteValue();
        }
        AppMethodBeat.m2505o(88847);
        return bArr;
    }

    /* renamed from: ay */
    private static byte[] m76043ay(byte[] bArr) {
        AppMethodBeat.m2504i(88848);
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        SecureRandom instance2 = SecureRandom.getInstance("SHA1PRNG", "Crypto");
        instance2.setSeed(bArr);
        instance.init(128, instance2);
        byte[] encoded = instance.generateKey().getEncoded();
        AppMethodBeat.m2505o(88848);
        return encoded;
    }

    /* renamed from: du */
    public static String m76046du(String str, String str2) {
        AppMethodBeat.m2504i(88849);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(88849);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("&");
        stringBuilder.append(currentTimeMillis);
        stringBuilder.append("&");
        stringBuilder.append(str2);
        try {
            String dv = C42843e.m76047dv(stringBuilder.toString(), str2);
            stringBuilder2.append(str);
            stringBuilder2.append("&");
            stringBuilder2.append(currentTimeMillis);
            stringBuilder2.append("&");
            stringBuilder2.append(dv);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.CardDymanicQrcodeOfflineHelper", e, "", new Object[0]);
        }
        String stringBuilder3 = stringBuilder2.toString();
        AppMethodBeat.m2505o(88849);
        return stringBuilder3;
    }

    /* renamed from: dv */
    private static String m76047dv(String str, String str2) {
        AppMethodBeat.m2504i(88850);
        String encodeToString;
        try {
            Mac instance = Mac.getInstance("HmacSHA256");
            instance.init(new SecretKeySpec(str2.getBytes(), "HmacSHA256"));
            encodeToString = Base64.encodeToString(instance.doFinal(str.getBytes()), 2);
            C4990ab.m7416i("MicroMsg.CardDymanicQrcodeOfflineHelper", "hash is: ".concat(String.valueOf(encodeToString)));
            AppMethodBeat.m2505o(88850);
            return encodeToString;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.CardDymanicQrcodeOfflineHelper", e, "", new Object[0]);
            encodeToString = "";
            AppMethodBeat.m2505o(88850);
            return encodeToString;
        }
    }
}
