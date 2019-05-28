package com.tencent.p177mm.plugin.wallet_core.model;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C37431m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.security.PublicKey;
import javax.crypto.Cipher;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.o */
public final class C43810o {
    static C43810o tzz;
    private PublicKey tzA = null;

    /* renamed from: bw */
    public final String mo69493bw(byte[] bArr) {
        AppMethodBeat.m2504i(46785);
        String str;
        try {
            this.tzA = C37431m.m63089r(C4996ah.getContext(), "lbs_rsa_public_key.pem");
            C4990ab.m7416i("MicroMsg.LocationEncrypt", "getPemPublickKeyFromAsset23 done2");
            PublicKey publicKey = this.tzA;
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, publicKey);
            str = new String(Base64.encode(instance.doFinal(bArr), 0));
            AppMethodBeat.m2505o(46785);
            return str;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.LocationEncrypt", "encry publicKey error %s", e.getMessage());
            str = "";
            AppMethodBeat.m2505o(46785);
            return str;
        }
    }
}
