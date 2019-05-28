package com.tencent.p177mm.p178a;

import android.content.Context;
import android.util.Base64;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* renamed from: com.tencent.mm.a.m */
public final class C37431m {
    /* renamed from: r */
    public static PublicKey m63089r(Context context, String str) {
        InputStream inputStream = null;
        try {
            inputStream = context.getResources().getAssets().open(str);
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            inputStream.close();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(new String(bArr).replace(IOUtils.LINE_SEPARATOR_UNIX, "").replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", ""), 0)));
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                }
            }
        }
    }

    /* renamed from: a */
    public static byte[] m63088a(byte[] bArr, PublicKey publicKey) {
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(2, publicKey);
        return instance.doFinal(bArr);
    }
}
