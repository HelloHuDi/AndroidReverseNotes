package c.t.m.c;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class m {
    private static final byte[] a = new byte[]{(byte) 84, (byte) 101, (byte) 110, (byte) 99, (byte) 101, (byte) 110, (byte) 116, (byte) 76, (byte) 111, (byte) 99, (byte) 97, (byte) 116, (byte) 105, (byte) 111, (byte) 110, (byte) 49};
    private static final byte[] b = new byte[0];

    private static Cipher a(String str, int i) {
        AppMethodBeat.i(136381);
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes("UTF-8"), "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(i, secretKeySpec, new IvParameterSpec(a));
        AppMethodBeat.o(136381);
        return instance;
    }

    private static String a(String str, String str2, int i) {
        AppMethodBeat.i(136382);
        String str3;
        if (i != 1 && i != 2) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("wrong mode.");
            AppMethodBeat.o(136382);
            throw illegalArgumentException;
        } else if (str == null || str.length() == 0) {
            str3 = "";
            AppMethodBeat.o(136382);
            return str3;
        } else {
            byte[] bytes;
            if (i == 1) {
                try {
                    bytes = str.getBytes();
                } catch (Throwable th) {
                    str3 = "";
                    AppMethodBeat.o(136382);
                    return str3;
                }
            } else if (i == 2) {
                bytes = Base64.decode(str.getBytes(), 2);
            } else {
                bytes = null;
            }
            if (bytes == null || bytes.length == 0) {
                str3 = "";
                AppMethodBeat.o(136382);
                return str3;
            }
            bytes = a(bytes, str2, i);
            if (i == 1) {
                str3 = Base64.encodeToString(bytes, 2);
                AppMethodBeat.o(136382);
                return str3;
            } else if (i == 2) {
                str3 = new String(bytes);
                AppMethodBeat.o(136382);
                return str3;
            } else {
                AppMethodBeat.o(136382);
                return null;
            }
        }
    }

    private static byte[] a(byte[] bArr, String str, int i) {
        AppMethodBeat.i(136383);
        byte[] bArr2;
        if (i != 1 && i != 2) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("wrong mode.");
            AppMethodBeat.o(136383);
            throw illegalArgumentException;
        } else if (bArr == null || bArr.length == 0) {
            bArr2 = b;
            AppMethodBeat.o(136383);
            return bArr2;
        } else {
            try {
                Cipher a = a(str, i);
                if (a == null) {
                    bArr2 = b;
                    AppMethodBeat.o(136383);
                    return bArr2;
                }
                bArr2 = a.doFinal(bArr);
                AppMethodBeat.o(136383);
                return bArr2;
            } catch (Throwable th) {
                bArr2 = b;
                AppMethodBeat.o(136383);
                return bArr2;
            }
        }
    }

    public static String a(String str, String str2) {
        AppMethodBeat.i(136384);
        String a = a(str, str2, 1);
        AppMethodBeat.o(136384);
        return a;
    }

    public static String b(String str, String str2) {
        AppMethodBeat.i(136385);
        String a = a(str, str2, 2);
        AppMethodBeat.o(136385);
        return a;
    }

    public static byte[] a(byte[] bArr, String str) {
        AppMethodBeat.i(136386);
        byte[] a = a(bArr, str, 1);
        AppMethodBeat.o(136386);
        return a;
    }

    public static byte[] b(byte[] bArr, String str) {
        AppMethodBeat.i(136387);
        byte[] a = a(bArr, str, 2);
        AppMethodBeat.o(136387);
        return a;
    }
}
