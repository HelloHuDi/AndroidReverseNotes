package com.tencent.liteav.basic.p810c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import javax.crypto.Cipher;

/* renamed from: com.tencent.liteav.basic.c.g */
public class C41680g {
    /* renamed from: a */
    public static final byte[] f16937a = "#PART#".getBytes();

    static {
        AppMethodBeat.m2504i(66097);
        AppMethodBeat.m2505o(66097);
    }

    /* renamed from: a */
    public static byte[] m73099a(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.m2504i(66095);
        PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(bArr2));
        Cipher instance = Cipher.getInstance("RSA/None/PKCS1Padding");
        instance.init(2, generatePrivate);
        byte[] doFinal = instance.doFinal(bArr);
        AppMethodBeat.m2505o(66095);
        return doFinal;
    }

    /* renamed from: b */
    public static byte[] m73100b(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.m2504i(66096);
        int length = f16937a.length;
        byte[] a;
        if (length <= 0) {
            a = C41680g.m73099a(bArr, bArr2);
            AppMethodBeat.m2505o(66096);
            return a;
        }
        int length2 = bArr.length;
        ArrayList<Byte> arrayList = new ArrayList(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        int i = 0;
        int i2 = 0;
        while (i < length2) {
            int i3;
            int i4;
            byte b = bArr[i];
            if (i == length2 - 1) {
                a = new byte[(length2 - i2)];
                System.arraycopy(bArr, i2, a, 0, a.length);
                for (byte valueOf : C41680g.m73099a(a, bArr2)) {
                    arrayList.add(Byte.valueOf(valueOf));
                }
                i2 = i + length;
                i = i2 - 1;
                i3 = 0;
            } else {
                if (b == f16937a[0]) {
                    if (length <= 1) {
                        i3 = 1;
                    } else if (i + length < length2) {
                        i4 = 1;
                        i3 = 0;
                        while (i4 < length && f16937a[i4] == bArr[i + i4]) {
                            if (i4 == length - 1) {
                                i3 = 1;
                            }
                            i4++;
                        }
                    }
                }
                i3 = 0;
            }
            if (i3 != 0) {
                a = new byte[(i - i2)];
                System.arraycopy(bArr, i2, a, 0, a.length);
                for (byte valueOf2 : C41680g.m73099a(a, bArr2)) {
                    arrayList.add(Byte.valueOf(valueOf2));
                }
                i += length;
                i3 = i - 1;
                i2 = i;
            } else {
                i3 = i;
            }
            i = i3 + 1;
        }
        byte[] bArr3 = new byte[arrayList.size()];
        int i5 = 0;
        for (Byte byteValue : arrayList) {
            i = i5 + 1;
            bArr3[i5] = byteValue.byteValue();
            i5 = i;
        }
        AppMethodBeat.m2505o(66096);
        return bArr3;
    }
}
