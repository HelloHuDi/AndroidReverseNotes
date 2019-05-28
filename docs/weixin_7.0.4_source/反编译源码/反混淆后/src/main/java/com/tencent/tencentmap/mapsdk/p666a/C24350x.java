package com.tencent.tencentmap.mapsdk.p666a;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/* renamed from: com.tencent.tencentmap.mapsdk.a.x */
public class C24350x {
    /* renamed from: a */
    static final byte[] f4625a = new byte[]{Byte.MIN_VALUE, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};

    /* renamed from: a */
    public static String m37625a(byte[] bArr) {
        String str;
        AppMethodBeat.m2504i(101242);
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
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
            str = new String(cArr2);
        } catch (Exception e) {
            str = null;
        }
        AppMethodBeat.m2505o(101242);
        return str;
    }

    /* renamed from: a */
    public static String m37624a(File file) {
        String str;
        AppMethodBeat.m2504i(101243);
        Closeable fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            while (true) {
                int read = fileInputStream.read(bArr, 0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                if (read == -1) {
                    break;
                }
                instance.update(bArr, 0, read);
            }
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
            str = new String(cArr2);
            C46764k.m88658a(fileInputStream);
        } catch (Exception e) {
            C36476dy.m60313b(Log.getStackTraceString(e));
            C46764k.m88658a(fileInputStream);
            str = null;
        } catch (Throwable th) {
            C46764k.m88658a(fileInputStream);
            AppMethodBeat.m2505o(101243);
        }
        AppMethodBeat.m2505o(101243);
        return str;
    }
}
