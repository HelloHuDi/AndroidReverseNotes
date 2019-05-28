package com.tencent.mm.plugin.card.d;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class e {
    public static String ds(String str, String str2) {
        AppMethodBeat.i(88844);
        if (str2 == null || str2.length() <= 0) {
            AppMethodBeat.o(88844);
            return null;
        }
        String str3;
        g.RN();
        try {
            byte[] ay = ay(("CbW9HMPiil38ldOjZp5WkwlIfzvLwiX6_" + a.QF() + "_" + str).getBytes());
            byte[] He = He(str2);
            SecretKeySpec secretKeySpec = new SecretKeySpec(ay, "AES");
            Cipher instance = Cipher.getInstance("AES");
            instance.init(2, secretKeySpec);
            str3 = new String(instance.doFinal(He));
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.CardDymanicQrcodeOfflineHelper", e, "", new Object[0]);
            str3 = null;
        }
        AppMethodBeat.o(88844);
        return str3;
    }

    public static String dt(String str, String str2) {
        String str3 = null;
        AppMethodBeat.i(88845);
        if (str2 == null || str2.length() <= 0) {
            AppMethodBeat.o(88845);
        } else {
            g.RN();
            try {
                byte[] ay = ay(("CbW9HMPiil38ldOjZp5WkwlIfzvLwiX6_" + a.QF() + "_" + str).getBytes());
                byte[] bytes = str2.getBytes();
                SecretKeySpec secretKeySpec = new SecretKeySpec(ay, "AES");
                Cipher instance = Cipher.getInstance("AES");
                instance.init(1, secretKeySpec);
                str3 = ax(instance.doFinal(bytes));
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.CardDymanicQrcodeOfflineHelper", e, "", new Object[0]);
            }
            AppMethodBeat.o(88845);
        }
        return str3;
    }

    private static String ax(byte[] bArr) {
        AppMethodBeat.i(88846);
        String str;
        if (bArr == null) {
            str = "";
            AppMethodBeat.o(88846);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            stringBuilder.append("0123456789ABCDEF".charAt((bArr[i] >> 4) & 15)).append("0123456789ABCDEF".charAt(bArr[i] & 15));
        }
        str = stringBuilder.toString();
        AppMethodBeat.o(88846);
        return str;
    }

    private static byte[] He(String str) {
        AppMethodBeat.i(88847);
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = Integer.valueOf(str.substring(i * 2, (i * 2) + 2), 16).byteValue();
        }
        AppMethodBeat.o(88847);
        return bArr;
    }

    private static byte[] ay(byte[] bArr) {
        AppMethodBeat.i(88848);
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        SecureRandom instance2 = SecureRandom.getInstance("SHA1PRNG", "Crypto");
        instance2.setSeed(bArr);
        instance.init(128, instance2);
        byte[] encoded = instance.generateKey().getEncoded();
        AppMethodBeat.o(88848);
        return encoded;
    }

    public static String du(String str, String str2) {
        AppMethodBeat.i(88849);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(88849);
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
            String dv = dv(stringBuilder.toString(), str2);
            stringBuilder2.append(str);
            stringBuilder2.append("&");
            stringBuilder2.append(currentTimeMillis);
            stringBuilder2.append("&");
            stringBuilder2.append(dv);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.CardDymanicQrcodeOfflineHelper", e, "", new Object[0]);
        }
        String stringBuilder3 = stringBuilder2.toString();
        AppMethodBeat.o(88849);
        return stringBuilder3;
    }

    private static String dv(String str, String str2) {
        AppMethodBeat.i(88850);
        String encodeToString;
        try {
            Mac instance = Mac.getInstance("HmacSHA256");
            instance.init(new SecretKeySpec(str2.getBytes(), "HmacSHA256"));
            encodeToString = Base64.encodeToString(instance.doFinal(str.getBytes()), 2);
            ab.i("MicroMsg.CardDymanicQrcodeOfflineHelper", "hash is: ".concat(String.valueOf(encodeToString)));
            AppMethodBeat.o(88850);
            return encodeToString;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.CardDymanicQrcodeOfflineHelper", e, "", new Object[0]);
            encodeToString = "";
            AppMethodBeat.o(88850);
            return encodeToString;
        }
    }
}
