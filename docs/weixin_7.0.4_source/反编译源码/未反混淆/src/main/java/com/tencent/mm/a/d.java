package com.tencent.mm.a;

import android.util.Base64;
import com.tencent.mm.sdk.platformtools.ab;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class d {
    private Cipher cbW;
    private Cipher cbX;

    public d(String str) {
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str.getBytes("UTF8")));
            IvParameterSpec ivParameterSpec = new IvParameterSpec("manifest".getBytes("UTF8"));
            this.cbW = Cipher.getInstance("DES/CBC/PKCS5Padding");
            this.cbW.init(1, generateSecret, ivParameterSpec);
            this.cbX = Cipher.getInstance("DES/CBC/PKCS5Padding");
            this.cbX.init(2, generateSecret, ivParameterSpec);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.DESUtil", e, "", new Object[0]);
        }
    }

    public final String cr(String str) {
        try {
            return new String(this.cbX.doFinal(Base64.decode(str, 0)), "UTF8");
        } catch (Exception e) {
            return "[des]" + str + "|" + e.toString();
        }
    }
}
