package com.tencent.mm.plugin.wear.model.e;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.wear.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import java.io.File;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.crypto.Cipher;

public final class b extends a {
    private byte[] bFT;
    private byte[] tYx;
    private byte[] tYy;

    public final byte[] adl() {
        boolean z = true;
        AppMethodBeat.i(26385);
        if (this.tYy == null || this.tYx == null || this.bFT == null) {
            boolean z2;
            ab.i("MicroMsg.Wear.HttpAuthServer", "try to reload all key");
            try {
                cUC();
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Wear.HttpAuthServer", e, "loadAllKey", new Object[0]);
            }
            String str = "MicroMsg.Wear.HttpAuthServer";
            String str2 = "publicKey %s privateKey %s sessionKey %s";
            Object[] objArr = new Object[3];
            if (this.tYy != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[0] = Boolean.valueOf(z2);
            objArr[1] = Boolean.valueOf(this.tYx != null);
            if (this.bFT == null) {
                z = false;
            }
            objArr[2] = Boolean.valueOf(z);
            ab.i(str, str2, objArr);
        }
        byte[] bArr = this.bFT;
        AppMethodBeat.o(26385);
        return bArr;
    }

    private void cUC() {
        AppMethodBeat.i(26386);
        File file = new File(e.eSk, "wear/key");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, "private.key");
        File file3 = new File(file, "public.key");
        File file4 = new File(file, "session.key");
        if (file2.exists() && file3.exists() && file4.exists()) {
            ab.i("MicroMsg.Wear.HttpAuthServer", "use old keys");
            this.tYy = com.tencent.mm.a.e.f(file3.getAbsolutePath(), 0, BaseClientBuilder.API_PRIORITY_OTHER);
            this.tYx = com.tencent.mm.a.e.f(file2.getAbsolutePath(), 0, BaseClientBuilder.API_PRIORITY_OTHER);
            this.bFT = com.tencent.mm.a.e.f(file4.getAbsolutePath(), 0, BaseClientBuilder.API_PRIORITY_OTHER);
        } else {
            ab.i("MicroMsg.Wear.HttpAuthServer", "recreate keys");
            file2.delete();
            file3.delete();
            file4.delete();
            HashMap cUE = a.cUE();
            RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) cUE.get("RSAPrivateKey");
            this.tYy = ((RSAPublicKey) cUE.get("RSAPublicKey")).getEncoded();
            this.tYx = rSAPrivateKey.getEncoded();
            this.bFT = a.cUF();
            com.tencent.mm.a.e.b(file2.getAbsolutePath(), this.tYx, this.tYx.length);
            com.tencent.mm.a.e.b(file3.getAbsolutePath(), this.tYy, this.tYy.length);
            com.tencent.mm.a.e.b(file4.getAbsolutePath(), this.bFT, this.bFT.length);
        }
        ab.i("MicroMsg.Wear.HttpAuthServer", "publicKey=%s privateKey=%s sessionKey=%s", ag.w(this.tYy), ag.w(this.tYx), ag.w(this.bFT));
        AppMethodBeat.o(26386);
    }

    public final List<Integer> cUA() {
        AppMethodBeat.i(26387);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(10001));
        arrayList.add(Integer.valueOf(10002));
        AppMethodBeat.o(26387);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    public final byte[] p(int i, byte[] bArr) {
        boolean z = true;
        AppMethodBeat.i(26388);
        byte[] bArr2;
        switch (i) {
            case 10001:
                boolean z2;
                ab.i("MicroMsg.Wear.HttpAuthServer", "request public key");
                if (this.tYy == null || this.tYx == null || this.bFT == null) {
                    ab.i("MicroMsg.Wear.HttpAuthServer", "try to reload all key");
                    try {
                        cUC();
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.Wear.HttpAuthServer", e, "loadAllKey", new Object[0]);
                    }
                }
                String str = "MicroMsg.Wear.HttpAuthServer";
                String str2 = "publicKey %s privateKey %s sessionKey %s";
                Object[] objArr = new Object[3];
                if (this.tYy != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objArr[0] = Boolean.valueOf(z2);
                objArr[1] = Boolean.valueOf(this.tYx != null);
                if (this.bFT == null) {
                    z = false;
                }
                objArr[2] = Boolean.valueOf(z);
                ab.i(str, str2, objArr);
                bArr2 = this.tYy;
                AppMethodBeat.o(26388);
                return bArr2;
            case 10002:
                try {
                    PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(this.tYx);
                    KeyFactory instance = KeyFactory.getInstance("RSA");
                    PrivateKey generatePrivate = instance.generatePrivate(pKCS8EncodedKeySpec);
                    Cipher instance2 = Cipher.getInstance(instance.getAlgorithm());
                    instance2.init(2, generatePrivate);
                    bArr2 = a.i(this.bFT, instance2.doFinal(bArr));
                    ab.i("MicroMsg.Wear.HttpAuthServer", "funid %d, randomKey=%s", Integer.valueOf(i), ag.w(r1));
                    AppMethodBeat.o(26388);
                    return bArr2;
                } catch (Exception e2) {
                    ab.printErrStackTrace("MicroMsg.Wear.HttpAuthServer", e2, "sessionKey resp error", new Object[0]);
                    break;
                }
        }
        AppMethodBeat.o(26388);
        return null;
    }
}
