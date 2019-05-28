package com.tencent.liteav.basic.p1169f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.crypto.Cipher;

/* renamed from: com.tencent.liteav.basic.f.a */
public final class C37355a {
    /* renamed from: a */
    private static String f15891a = "RSA";

    /* renamed from: a */
    public static byte[] m62787a(byte[] bArr, PrivateKey privateKey) {
        AppMethodBeat.m2504i(66132);
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(2, privateKey);
        int i = 0;
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i2 = i;
            byte[] doFinal;
            if (length - i2 > 0) {
                if (length - i2 >= instance.getBlockSize()) {
                    doFinal = instance.doFinal(bArr, i2, instance.getBlockSize());
                } else {
                    doFinal = instance.doFinal(bArr, i2, length - i2);
                }
                byteArrayOutputStream.write(doFinal);
                i = instance.getBlockSize() + i2;
            } else {
                doFinal = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                AppMethodBeat.m2505o(66132);
                return doFinal;
            }
        }
    }

    /* renamed from: a */
    public static PrivateKey m62786a(byte[] bArr) {
        AppMethodBeat.m2504i(66133);
        PrivateKey generatePrivate = KeyFactory.getInstance(f15891a).generatePrivate(new PKCS8EncodedKeySpec(bArr));
        AppMethodBeat.m2505o(66133);
        return generatePrivate;
    }
}
