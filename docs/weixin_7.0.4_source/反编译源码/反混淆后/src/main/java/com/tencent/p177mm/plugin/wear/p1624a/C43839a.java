package com.tencent.p177mm.plugin.wear.p1624a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.tencent.mm.plugin.wear.a.a */
public final class C43839a {
    public static final HashMap<String, Object> cUE() {
        AppMethodBeat.m2504i(26457);
        KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA");
        instance.initialize(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        KeyPair generateKeyPair = instance.generateKeyPair();
        RSAPublicKey rSAPublicKey = (RSAPublicKey) generateKeyPair.getPublic();
        RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) generateKeyPair.getPrivate();
        HashMap hashMap = new HashMap(2);
        hashMap.put("RSAPublicKey", rSAPublicKey);
        hashMap.put("RSAPrivateKey", rSAPrivateKey);
        AppMethodBeat.m2505o(26457);
        return hashMap;
    }

    /* renamed from: i */
    public static final byte[] m78618i(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.m2504i(26458);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
        instance.init(1, secretKeySpec);
        byte[] doFinal = instance.doFinal(bArr);
        AppMethodBeat.m2505o(26458);
        return doFinal;
    }

    public static final byte[] cUF() {
        AppMethodBeat.m2504i(26459);
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init(128);
            byte[] encoded = instance.generateKey().getEncoded();
            AppMethodBeat.m2505o(26459);
            return encoded;
        } catch (NoSuchAlgorithmException e) {
            AppMethodBeat.m2505o(26459);
            return null;
        }
    }
}
