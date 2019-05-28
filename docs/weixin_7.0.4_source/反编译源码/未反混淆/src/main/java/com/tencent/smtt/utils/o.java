package com.tencent.smtt.utils;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

public class o {
    protected static final char[] a = "0123456789abcdef".toCharArray();
    private static String b = "";
    private static byte[] c = null;
    private static o f = null;
    private static String g;
    private Cipher d = null;
    private Cipher e = null;

    static {
        AppMethodBeat.i(65274);
        AppMethodBeat.o(65274);
    }

    private o() {
        AppMethodBeat.i(65267);
        g = String.valueOf(new Random().nextInt(89999999) + 10000000) + String.valueOf(new Random().nextInt(89999999) + 10000000) + String.valueOf(new Random().nextInt(89999999) + 10000000);
        String str = "00000000";
        for (int i = 0; i < 12; i++) {
            str = str + String.valueOf(new Random().nextInt(89999999) + 10000000);
        }
        c = (str + g).getBytes();
        this.d = Cipher.getInstance("RSA/ECB/NoPadding");
        this.d.init(1, KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDcEQ3TCNWPBqgIiY7WQ/IqTOTTV2w8aZ/GPm68FK0fAJBemZKtYR3Li46VJ+Hwnor7ZpQnblGWPFaLv5JoPqvavgB0GInuhm+T+syPs1mw0uPLWaqwvZsCfoaIvUuxy5xHJgmWARrK4/9pHyDxRlZte0PCIoR1ko5B8lVVH1X1dQIDAQAB".getBytes(), 0))));
        b = b(this.d.doFinal(c));
        SecretKey generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(g.getBytes()));
        this.e = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        this.e.init(1, generateSecret);
        AppMethodBeat.o(65267);
    }

    public static o a() {
        o oVar = null;
        AppMethodBeat.i(65268);
        try {
            if (f == null) {
                f = new o();
            }
            oVar = f;
            AppMethodBeat.o(65268);
        } catch (Exception e) {
            f = null;
            AppMethodBeat.o(65268);
        }
        return oVar;
    }

    public static byte[] a(byte[] bArr, String str) {
        AppMethodBeat.i(65272);
        SecretKey generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(str.getBytes()));
        Cipher instance = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        instance.init(1, generateSecret);
        byte[] doFinal = instance.doFinal(bArr);
        AppMethodBeat.o(65272);
        return doFinal;
    }

    public static String b(byte[] bArr) {
        AppMethodBeat.i(65270);
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            cArr[i * 2] = a[i2 >>> 4];
            cArr[(i * 2) + 1] = a[i2 & 15];
        }
        String str = new String(cArr);
        AppMethodBeat.o(65270);
        return str;
    }

    public static byte[] b(byte[] bArr, String str) {
        AppMethodBeat.i(65273);
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(str.getBytes()));
            Cipher instance = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            instance.init(2, generateSecret);
            byte[] doFinal = instance.doFinal(bArr);
            AppMethodBeat.o(65273);
            return doFinal;
        } catch (Exception e) {
            AppMethodBeat.o(65273);
            return null;
        }
    }

    public static String c() {
        return g;
    }

    public byte[] a(byte[] bArr) {
        AppMethodBeat.i(65269);
        byte[] doFinal = this.e.doFinal(bArr);
        AppMethodBeat.o(65269);
        return doFinal;
    }

    public String b() {
        return b;
    }

    public byte[] c(byte[] bArr) {
        AppMethodBeat.i(65271);
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(g.getBytes()));
            Cipher instance = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            instance.init(2, generateSecret);
            byte[] doFinal = instance.doFinal(bArr);
            AppMethodBeat.o(65271);
            return doFinal;
        } catch (Exception e) {
            AppMethodBeat.o(65271);
            return null;
        }
    }
}
