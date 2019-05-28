package p077c.p078t.p079m.p080c;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: c.t.m.c.m */
public class C17501m {
    /* renamed from: a */
    private static final byte[] f4042a = new byte[]{(byte) 84, (byte) 101, (byte) 110, (byte) 99, (byte) 101, (byte) 110, (byte) 116, (byte) 76, (byte) 111, (byte) 99, (byte) 97, (byte) 116, (byte) 105, (byte) 111, (byte) 110, (byte) 49};
    /* renamed from: b */
    private static final byte[] f4043b = new byte[0];

    /* renamed from: a */
    private static Cipher m27323a(String str, int i) {
        AppMethodBeat.m2504i(136381);
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes("UTF-8"), "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(i, secretKeySpec, new IvParameterSpec(f4042a));
        AppMethodBeat.m2505o(136381);
        return instance;
    }

    /* renamed from: a */
    private static String m27322a(String str, String str2, int i) {
        AppMethodBeat.m2504i(136382);
        String str3;
        if (i != 1 && i != 2) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("wrong mode.");
            AppMethodBeat.m2505o(136382);
            throw illegalArgumentException;
        } else if (str == null || str.length() == 0) {
            str3 = "";
            AppMethodBeat.m2505o(136382);
            return str3;
        } else {
            byte[] bytes;
            if (i == 1) {
                try {
                    bytes = str.getBytes();
                } catch (Throwable th) {
                    str3 = "";
                    AppMethodBeat.m2505o(136382);
                    return str3;
                }
            } else if (i == 2) {
                bytes = Base64.decode(str.getBytes(), 2);
            } else {
                bytes = null;
            }
            if (bytes == null || bytes.length == 0) {
                str3 = "";
                AppMethodBeat.m2505o(136382);
                return str3;
            }
            bytes = C17501m.m27325a(bytes, str2, i);
            if (i == 1) {
                str3 = Base64.encodeToString(bytes, 2);
                AppMethodBeat.m2505o(136382);
                return str3;
            } else if (i == 2) {
                str3 = new String(bytes);
                AppMethodBeat.m2505o(136382);
                return str3;
            } else {
                AppMethodBeat.m2505o(136382);
                return null;
            }
        }
    }

    /* renamed from: a */
    private static byte[] m27325a(byte[] bArr, String str, int i) {
        AppMethodBeat.m2504i(136383);
        byte[] bArr2;
        if (i != 1 && i != 2) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("wrong mode.");
            AppMethodBeat.m2505o(136383);
            throw illegalArgumentException;
        } else if (bArr == null || bArr.length == 0) {
            bArr2 = f4043b;
            AppMethodBeat.m2505o(136383);
            return bArr2;
        } else {
            try {
                Cipher a = C17501m.m27323a(str, i);
                if (a == null) {
                    bArr2 = f4043b;
                    AppMethodBeat.m2505o(136383);
                    return bArr2;
                }
                bArr2 = a.doFinal(bArr);
                AppMethodBeat.m2505o(136383);
                return bArr2;
            } catch (Throwable th) {
                bArr2 = f4043b;
                AppMethodBeat.m2505o(136383);
                return bArr2;
            }
        }
    }

    /* renamed from: a */
    public static String m27321a(String str, String str2) {
        AppMethodBeat.m2504i(136384);
        String a = C17501m.m27322a(str, str2, 1);
        AppMethodBeat.m2505o(136384);
        return a;
    }

    /* renamed from: b */
    public static String m27326b(String str, String str2) {
        AppMethodBeat.m2504i(136385);
        String a = C17501m.m27322a(str, str2, 2);
        AppMethodBeat.m2505o(136385);
        return a;
    }

    /* renamed from: a */
    public static byte[] m27324a(byte[] bArr, String str) {
        AppMethodBeat.m2504i(136386);
        byte[] a = C17501m.m27325a(bArr, str, 1);
        AppMethodBeat.m2505o(136386);
        return a;
    }

    /* renamed from: b */
    public static byte[] m27327b(byte[] bArr, String str) {
        AppMethodBeat.m2504i(136387);
        byte[] a = C17501m.m27325a(bArr, str, 2);
        AppMethodBeat.m2505o(136387);
        return a;
    }
}
