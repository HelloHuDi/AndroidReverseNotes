package com.tencent.smtt.utils;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.a.a;
import java.security.KeyFactory;
import java.security.Provider;
import java.security.Security;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;

public class p {
    private static final char[] a = "0123456789abcdef".toCharArray();
    private static p b;
    private String c;
    private String d;
    private String e = String.valueOf(new Random().nextInt(89999999) + 10000000);

    static {
        AppMethodBeat.i(65282);
        AppMethodBeat.o(65282);
    }

    private p() {
        AppMethodBeat.i(65275);
        int nextInt = new Random().nextInt(89999999) + 10000000;
        this.c = this.e + String.valueOf(nextInt);
        AppMethodBeat.o(65275);
    }

    public static synchronized p a() {
        p pVar;
        synchronized (p.class) {
            AppMethodBeat.i(65276);
            if (b == null) {
                b = new p();
            }
            pVar = b;
            AppMethodBeat.o(65276);
        }
        return pVar;
    }

    private String b(byte[] bArr) {
        AppMethodBeat.i(65281);
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            cArr[i * 2] = a[i2 >>> 4];
            cArr[(i * 2) + 1] = a[i2 & 15];
        }
        String str = new String(cArr);
        AppMethodBeat.o(65281);
        return str;
    }

    public String a(String str) {
        AppMethodBeat.i(65279);
        byte[] bytes = str.getBytes();
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("RSA/ECB/NoPadding");
        } catch (Exception e) {
            try {
                b();
                cipher = Cipher.getInstance("RSA/ECB/NoPadding");
            } catch (Exception e2) {
            }
        }
        cipher.init(1, KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRB/Q0hTCD+XtnQhpQJefUCAwEAAQ==".getBytes(), 0))));
        String b = b(cipher.doFinal(bytes));
        AppMethodBeat.o(65279);
        return b;
    }

    public byte[] a(byte[] bArr) {
        AppMethodBeat.i(65280);
        byte[] a = a.a(this.e.getBytes(), bArr, 1);
        AppMethodBeat.o(65280);
        return a;
    }

    public void b() {
        AppMethodBeat.i(65277);
        Security.addProvider((Provider) Class.forName("com.android.org.bouncycastle.jce.provider.BouncyCastleProvider", true, ClassLoader.getSystemClassLoader()).newInstance());
        AppMethodBeat.o(65277);
    }

    public String c() {
        AppMethodBeat.i(65278);
        if (this.d == null) {
            byte[] bytes = this.c.getBytes();
            Cipher cipher = null;
            try {
                cipher = Cipher.getInstance("RSA/ECB/NoPadding");
            } catch (Exception e) {
                try {
                    b();
                    cipher = Cipher.getInstance("RSA/ECB/NoPadding");
                } catch (Exception e2) {
                }
            }
            cipher.init(1, KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRB/Q0hTCD+XtnQhpQJefUCAwEAAQ==".getBytes(), 0))));
            this.d = b(cipher.doFinal(bytes));
        }
        String str = this.d;
        AppMethodBeat.o(65278);
        return str;
    }
}
