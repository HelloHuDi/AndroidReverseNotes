package com.tencent.smtt.utils;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.p1104a.C46734a;
import java.security.KeyFactory;
import java.security.Provider;
import java.security.Security;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;

/* renamed from: com.tencent.smtt.utils.p */
public class C46743p {
    /* renamed from: a */
    private static final char[] f18022a = "0123456789abcdef".toCharArray();
    /* renamed from: b */
    private static C46743p f18023b;
    /* renamed from: c */
    private String f18024c;
    /* renamed from: d */
    private String f18025d;
    /* renamed from: e */
    private String f18026e = String.valueOf(new Random().nextInt(89999999) + 10000000);

    static {
        AppMethodBeat.m2504i(65282);
        AppMethodBeat.m2505o(65282);
    }

    private C46743p() {
        AppMethodBeat.m2504i(65275);
        int nextInt = new Random().nextInt(89999999) + 10000000;
        this.f18024c = this.f18026e + String.valueOf(nextInt);
        AppMethodBeat.m2505o(65275);
    }

    /* renamed from: a */
    public static synchronized C46743p m88599a() {
        C46743p c46743p;
        synchronized (C46743p.class) {
            AppMethodBeat.m2504i(65276);
            if (f18023b == null) {
                f18023b = new C46743p();
            }
            c46743p = f18023b;
            AppMethodBeat.m2505o(65276);
        }
        return c46743p;
    }

    /* renamed from: b */
    private String m88600b(byte[] bArr) {
        AppMethodBeat.m2504i(65281);
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            cArr[i * 2] = f18022a[i2 >>> 4];
            cArr[(i * 2) + 1] = f18022a[i2 & 15];
        }
        String str = new String(cArr);
        AppMethodBeat.m2505o(65281);
        return str;
    }

    /* renamed from: a */
    public String mo75290a(String str) {
        AppMethodBeat.m2504i(65279);
        byte[] bytes = str.getBytes();
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("RSA/ECB/NoPadding");
        } catch (Exception e) {
            try {
                mo75292b();
                cipher = Cipher.getInstance("RSA/ECB/NoPadding");
            } catch (Exception e2) {
            }
        }
        cipher.init(1, KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRB/Q0hTCD+XtnQhpQJefUCAwEAAQ==".getBytes(), 0))));
        String b = m88600b(cipher.doFinal(bytes));
        AppMethodBeat.m2505o(65279);
        return b;
    }

    /* renamed from: a */
    public byte[] mo75291a(byte[] bArr) {
        AppMethodBeat.m2504i(65280);
        byte[] a = C46734a.m88586a(this.f18026e.getBytes(), bArr, 1);
        AppMethodBeat.m2505o(65280);
        return a;
    }

    /* renamed from: b */
    public void mo75292b() {
        AppMethodBeat.m2504i(65277);
        Security.addProvider((Provider) Class.forName("com.android.org.bouncycastle.jce.provider.BouncyCastleProvider", true, ClassLoader.getSystemClassLoader()).newInstance());
        AppMethodBeat.m2505o(65277);
    }

    /* renamed from: c */
    public String mo75293c() {
        AppMethodBeat.m2504i(65278);
        if (this.f18025d == null) {
            byte[] bytes = this.f18024c.getBytes();
            Cipher cipher = null;
            try {
                cipher = Cipher.getInstance("RSA/ECB/NoPadding");
            } catch (Exception e) {
                try {
                    mo75292b();
                    cipher = Cipher.getInstance("RSA/ECB/NoPadding");
                } catch (Exception e2) {
                }
            }
            cipher.init(1, KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRB/Q0hTCD+XtnQhpQJefUCAwEAAQ==".getBytes(), 0))));
            this.f18025d = m88600b(cipher.doFinal(bytes));
        }
        String str = this.f18025d;
        AppMethodBeat.m2505o(65278);
        return str;
    }
}
