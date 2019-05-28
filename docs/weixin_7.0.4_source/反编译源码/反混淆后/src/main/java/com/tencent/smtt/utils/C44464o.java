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

/* renamed from: com.tencent.smtt.utils.o */
public class C44464o {
    /* renamed from: a */
    protected static final char[] f17318a = "0123456789abcdef".toCharArray();
    /* renamed from: b */
    private static String f17319b = "";
    /* renamed from: c */
    private static byte[] f17320c = null;
    /* renamed from: f */
    private static C44464o f17321f = null;
    /* renamed from: g */
    private static String f17322g;
    /* renamed from: d */
    private Cipher f17323d = null;
    /* renamed from: e */
    private Cipher f17324e = null;

    static {
        AppMethodBeat.m2504i(65274);
        AppMethodBeat.m2505o(65274);
    }

    private C44464o() {
        AppMethodBeat.m2504i(65267);
        f17322g = String.valueOf(new Random().nextInt(89999999) + 10000000) + String.valueOf(new Random().nextInt(89999999) + 10000000) + String.valueOf(new Random().nextInt(89999999) + 10000000);
        String str = "00000000";
        for (int i = 0; i < 12; i++) {
            str = str + String.valueOf(new Random().nextInt(89999999) + 10000000);
        }
        f17320c = (str + f17322g).getBytes();
        this.f17323d = Cipher.getInstance("RSA/ECB/NoPadding");
        this.f17323d.init(1, KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDcEQ3TCNWPBqgIiY7WQ/IqTOTTV2w8aZ/GPm68FK0fAJBemZKtYR3Li46VJ+Hwnor7ZpQnblGWPFaLv5JoPqvavgB0GInuhm+T+syPs1mw0uPLWaqwvZsCfoaIvUuxy5xHJgmWARrK4/9pHyDxRlZte0PCIoR1ko5B8lVVH1X1dQIDAQAB".getBytes(), 0))));
        f17319b = C44464o.m80458b(this.f17323d.doFinal(f17320c));
        SecretKey generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(f17322g.getBytes()));
        this.f17324e = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        this.f17324e.init(1, generateSecret);
        AppMethodBeat.m2505o(65267);
    }

    /* renamed from: a */
    public static C44464o m80456a() {
        C44464o c44464o = null;
        AppMethodBeat.m2504i(65268);
        try {
            if (f17321f == null) {
                f17321f = new C44464o();
            }
            c44464o = f17321f;
            AppMethodBeat.m2505o(65268);
        } catch (Exception e) {
            f17321f = null;
            AppMethodBeat.m2505o(65268);
        }
        return c44464o;
    }

    /* renamed from: a */
    public static byte[] m80457a(byte[] bArr, String str) {
        AppMethodBeat.m2504i(65272);
        SecretKey generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(str.getBytes()));
        Cipher instance = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        instance.init(1, generateSecret);
        byte[] doFinal = instance.doFinal(bArr);
        AppMethodBeat.m2505o(65272);
        return doFinal;
    }

    /* renamed from: b */
    public static String m80458b(byte[] bArr) {
        AppMethodBeat.m2504i(65270);
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            cArr[i * 2] = f17318a[i2 >>> 4];
            cArr[(i * 2) + 1] = f17318a[i2 & 15];
        }
        String str = new String(cArr);
        AppMethodBeat.m2505o(65270);
        return str;
    }

    /* renamed from: b */
    public static byte[] m80459b(byte[] bArr, String str) {
        AppMethodBeat.m2504i(65273);
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(str.getBytes()));
            Cipher instance = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            instance.init(2, generateSecret);
            byte[] doFinal = instance.doFinal(bArr);
            AppMethodBeat.m2505o(65273);
            return doFinal;
        } catch (Exception e) {
            AppMethodBeat.m2505o(65273);
            return null;
        }
    }

    /* renamed from: c */
    public static String m80460c() {
        return f17322g;
    }

    /* renamed from: a */
    public byte[] mo70637a(byte[] bArr) {
        AppMethodBeat.m2504i(65269);
        byte[] doFinal = this.f17324e.doFinal(bArr);
        AppMethodBeat.m2505o(65269);
        return doFinal;
    }

    /* renamed from: b */
    public String mo70638b() {
        return f17319b;
    }

    /* renamed from: c */
    public byte[] mo70639c(byte[] bArr) {
        AppMethodBeat.m2504i(65271);
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(f17322g.getBytes()));
            Cipher instance = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            instance.init(2, generateSecret);
            byte[] doFinal = instance.doFinal(bArr);
            AppMethodBeat.m2505o(65271);
            return doFinal;
        } catch (Exception e) {
            AppMethodBeat.m2505o(65271);
            return null;
        }
    }
}
