package com.tenpay.android.wechat;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tenpay.ndk.Encrypt;
import java.lang.reflect.Field;
import java.security.MessageDigest;

public class TenpayUtil {
    public static byte[] sm4EncryptCBC(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        AppMethodBeat.i(49507);
        if (bArr == null) {
            AppMethodBeat.o(49507);
            return null;
        }
        byte[] sm4BCDEncryptCBC = new Encrypt().sm4BCDEncryptCBC(bArr, bArr2, bArr3);
        AppMethodBeat.o(49507);
        return sm4BCDEncryptCBC;
    }

    public static byte[] sm4DecryptCBC(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        AppMethodBeat.i(49508);
        if (bArr == null) {
            AppMethodBeat.o(49508);
            return null;
        }
        byte[] sm4BCDDecryptCBC = new Encrypt().sm4BCDDecryptCBC(bArr, bArr2, bArr3);
        AppMethodBeat.o(49508);
        return sm4BCDDecryptCBC;
    }

    public static String signWith3Des(String str) {
        AppMethodBeat.i(49509);
        if (str == null) {
            AppMethodBeat.o(49509);
            return null;
        }
        String desedeEncode = new Encrypt().desedeEncode(md5HexDigest(str));
        AppMethodBeat.o(49509);
        return desedeEncode;
    }

    public static String md5HexDigest(String str) {
        String str2;
        AppMethodBeat.i(49510);
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
        AppMethodBeat.o(49510);
        return str2;
    }

    public static final int[] getResourceDeclareStyleableIntArray(Context context, String str) {
        AppMethodBeat.i(49511);
        try {
            for (Field field : Class.forName(context.getPackageName() + ".R$styleable").getFields()) {
                if (field.getName().equals(str)) {
                    int[] iArr = (int[]) field.get(null);
                    AppMethodBeat.o(49511);
                    return iArr;
                }
            }
            AppMethodBeat.o(49511);
            return null;
        } catch (Throwable th) {
            AppMethodBeat.o(49511);
            return null;
        }
    }

    public static final int getResourceDeclareStyleableIndex(Context context, String str) {
        int i = 0;
        AppMethodBeat.i(49512);
        try {
            for (Field field : Class.forName(context.getPackageName() + ".R$styleable").getFields()) {
                if (field.getName().equals(str)) {
                    i = field.getInt(null);
                    AppMethodBeat.o(49512);
                    break;
                }
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.o(49512);
        return i;
    }

    public static boolean invalidateID(String str) {
        AppMethodBeat.i(49513);
        if (str == null) {
            AppMethodBeat.o(49513);
            return false;
        } else if (str.length() != 18) {
            AppMethodBeat.o(49513);
            return false;
        } else {
            int[] iArr = new int[]{7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
            char[] cArr = new char[]{'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
            int i = 0;
            int i2 = 0;
            while (i < str.length() - 1) {
                try {
                    i2 += bo.ank(str.substring(i, i + 1)) * iArr[i];
                    i++;
                } catch (NumberFormatException e) {
                    AppMethodBeat.o(49513);
                    return false;
                }
            }
            i = i2 % 11;
            char charAt = str.charAt(17);
            if (i == 2) {
                if (!(charAt == 'X' || charAt == 'x')) {
                    AppMethodBeat.o(49513);
                    return false;
                }
            } else if (charAt != cArr[i]) {
                AppMethodBeat.o(49513);
                return false;
            }
            AppMethodBeat.o(49513);
            return true;
        }
    }
}
