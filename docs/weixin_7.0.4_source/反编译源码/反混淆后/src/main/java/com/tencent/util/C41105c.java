package com.tencent.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

/* renamed from: com.tencent.util.c */
public final class C41105c {
    public static byte[] encode(byte[] bArr) {
        AppMethodBeat.m2504i(86577);
        SecretKey generateSecret = SecretKeyFactory.getInstance("desede").generateSecret(new DESedeKeySpec(Coffee.dSI().getBytes()));
        Cipher instance = Cipher.getInstance("desede/CBC/PKCS5Padding");
        instance.init(1, generateSecret, new IvParameterSpec("68881999".getBytes()));
        byte[] doFinal = instance.doFinal(bArr);
        AppMethodBeat.m2505o(86577);
        return doFinal;
    }
}
