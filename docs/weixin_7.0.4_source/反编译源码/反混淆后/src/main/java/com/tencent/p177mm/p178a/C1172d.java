package com.tencent.p177mm.p178a;

import android.util.Base64;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/* renamed from: com.tencent.mm.a.d */
public final class C1172d {
    private Cipher cbW;
    private Cipher cbX;

    public C1172d(String str) {
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str.getBytes("UTF8")));
            IvParameterSpec ivParameterSpec = new IvParameterSpec("manifest".getBytes("UTF8"));
            this.cbW = Cipher.getInstance("DES/CBC/PKCS5Padding");
            this.cbW.init(1, generateSecret, ivParameterSpec);
            this.cbX = Cipher.getInstance("DES/CBC/PKCS5Padding");
            this.cbX.init(2, generateSecret, ivParameterSpec);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.DESUtil", e, "", new Object[0]);
        }
    }

    /* renamed from: cr */
    public final String mo4400cr(String str) {
        try {
            return new String(this.cbX.doFinal(Base64.decode(str, 0)), "UTF8");
        } catch (Exception e) {
            return "[des]" + str + "|" + e.toString();
        }
    }
}
