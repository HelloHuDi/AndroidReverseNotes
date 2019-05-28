package com.tenpay.android.wechat;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tenpay.ndk.Encrypt;
import java.lang.reflect.Field;
import java.security.MessageDigest;

public class TenpayUtil {
    public static byte[] sm4EncryptCBC(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        AppMethodBeat.m2504i(49507);
        if (bArr == null) {
            AppMethodBeat.m2505o(49507);
            return null;
        }
        byte[] sm4BCDEncryptCBC = new Encrypt().sm4BCDEncryptCBC(bArr, bArr2, bArr3);
        AppMethodBeat.m2505o(49507);
        return sm4BCDEncryptCBC;
    }

    public static byte[] sm4DecryptCBC(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        AppMethodBeat.m2504i(49508);
        if (bArr == null) {
            AppMethodBeat.m2505o(49508);
            return null;
        }
        byte[] sm4BCDDecryptCBC = new Encrypt().sm4BCDDecryptCBC(bArr, bArr2, bArr3);
        AppMethodBeat.m2505o(49508);
        return sm4BCDDecryptCBC;
    }

    public static String signWith3Des(String str) {
        AppMethodBeat.m2504i(49509);
        if (str == null) {
            AppMethodBeat.m2505o(49509);
            return null;
        }
        String desedeEncode = new Encrypt().desedeEncode(md5HexDigest(str));
        AppMethodBeat.m2505o(49509);
        return desedeEncode;
    }

    public static String md5HexDigest(String str) {
        String str2;
        AppMethodBeat.m2504i(49510);
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            char[] cArr2 = new char[32];
            int i = 0;
            int i2 = 0;
            while (i < 16) {
                byte b = digest[i];
                int i3 = i2 + 1;
                cArr2[i2] = cArr[(b >>> 4) & 15];
                int i4 = i3 + 1;
                cArr2[i3] = cArr[b & 15];
                i++;
                i2 = i4;
            }
            str2 = new String(cArr2);
        } catch (Exception e) {
            str2 = null;
        }
        AppMethodBeat.m2505o(49510);
        return str2;
    }

    public static final int[] getResourceDeclareStyleableIntArray(Context context, String str) {
        AppMethodBeat.m2504i(49511);
        try {
            for (Field field : Class.forName(context.getPackageName() + ".R$styleable").getFields()) {
                if (field.getName().equals(str)) {
                    int[] iArr = (int[]) field.get(null);
                    AppMethodBeat.m2505o(49511);
                    return iArr;
                }
            }
            AppMethodBeat.m2505o(49511);
            return null;
        } catch (Throwable th) {
            AppMethodBeat.m2505o(49511);
            return null;
        }
    }

    public static final int getResourceDeclareStyleableIndex(Context context, String str) {
        int i = 0;
        AppMethodBeat.m2504i(49512);
        try {
            for (Field field : Class.forName(context.getPackageName() + ".R$styleable").getFields()) {
                if (field.getName().equals(str)) {
                    i = field.getInt(null);
                    AppMethodBeat.m2505o(49512);
                    break;
                }
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.m2505o(49512);
        return i;
    }

    public static boolean invalidateID(String str) {
        AppMethodBeat.m2504i(49513);
        if (str == null) {
            AppMethodBeat.m2505o(49513);
            return false;
        } else if (str.length() != 18) {
            AppMethodBeat.m2505o(49513);
            return false;
        } else {
            int[] iArr = new int[]{7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
            char[] cArr = new char[]{'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
            int i = 0;
            int i2 = 0;
            while (i < str.length() - 1) {
                try {
                    i2 += C5046bo.ank(str.substring(i, i + 1)) * iArr[i];
                    i++;
                } catch (NumberFormatException e) {
                    AppMethodBeat.m2505o(49513);
                    return false;
                }
            }
            i = i2 % 11;
            char charAt = str.charAt(17);
            if (i == 2) {
                if (!(charAt == 'X' || charAt == 'x')) {
                    AppMethodBeat.m2505o(49513);
                    return false;
                }
            } else if (charAt != cArr[i]) {
                AppMethodBeat.m2505o(49513);
                return false;
            }
            AppMethodBeat.m2505o(49513);
            return true;
        }
    }
}
