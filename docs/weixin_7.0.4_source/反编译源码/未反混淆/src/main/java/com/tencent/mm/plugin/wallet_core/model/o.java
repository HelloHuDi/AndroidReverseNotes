package com.tencent.mm.plugin.wallet_core.model;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.security.PublicKey;
import javax.crypto.Cipher;

public final class o {
    static o tzz;
    private PublicKey tzA = null;

    public final String bw(byte[] bArr) {
        AppMethodBeat.i(46785);
        String str;
        try {
            this.tzA = m.r(ah.getContext(), "lbs_rsa_public_key.pem");
            ab.i("MicroMsg.LocationEncrypt", "getPemPublickKeyFromAsset23 done2");
            PublicKey publicKey = this.tzA;
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, publicKey);
            str = new String(Base64.encode(instance.doFinal(bArr), 0));
            AppMethodBeat.o(46785);
            return str;
        } catch (Exception e) {
            ab.e("MicroMsg.LocationEncrypt", "encry publicKey error %s", e.getMessage());
            str = "";
            AppMethodBeat.o(46785);
            return str;
        }
    }
}
