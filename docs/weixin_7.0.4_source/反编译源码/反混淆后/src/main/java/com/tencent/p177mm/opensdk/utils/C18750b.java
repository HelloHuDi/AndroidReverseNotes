package com.tencent.p177mm.opensdk.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

/* renamed from: com.tencent.mm.opensdk.utils.b */
public final class C18750b {
    /* renamed from: c */
    public static final String m29302c(byte[] bArr) {
        AppMethodBeat.m2504i(128071);
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            byte[] digest = instance.digest();
            int length = digest.length;
            char[] cArr2 = new char[(length * 2)];
            int i = 0;
            int i2 = 0;
            while (i < length) {
                byte b = digest[i];
                int i3 = i2 + 1;
                cArr2[i2] = cArr[(b >>> 4) & 15];
                int i4 = i3 + 1;
                cArr2[i3] = cArr[b & 15];
                i++;
                i2 = i4;
            }
            String str = new String(cArr2);
            AppMethodBeat.m2505o(128071);
            return str;
        } catch (Exception e) {
            AppMethodBeat.m2505o(128071);
            return null;
        }
    }
}
