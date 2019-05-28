package com.tencent.p177mm.plugin.wear.model.p575e;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.plugin.wear.p1624a.C43839a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
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

/* renamed from: com.tencent.mm.plugin.wear.model.e.b */
public final class C22731b extends C46394a {
    private byte[] bFT;
    private byte[] tYx;
    private byte[] tYy;

    public final byte[] adl() {
        boolean z = true;
        AppMethodBeat.m2504i(26385);
        if (this.tYy == null || this.tYx == null || this.bFT == null) {
            boolean z2;
            C4990ab.m7416i("MicroMsg.Wear.HttpAuthServer", "try to reload all key");
            try {
                cUC();
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Wear.HttpAuthServer", e, "loadAllKey", new Object[0]);
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
            C4990ab.m7417i(str, str2, objArr);
        }
        byte[] bArr = this.bFT;
        AppMethodBeat.m2505o(26385);
        return bArr;
    }

    private void cUC() {
        AppMethodBeat.m2504i(26386);
        File file = new File(C6457e.eSk, "wear/key");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, "private.key");
        File file3 = new File(file, "public.key");
        File file4 = new File(file, "session.key");
        if (file2.exists() && file3.exists() && file4.exists()) {
            C4990ab.m7416i("MicroMsg.Wear.HttpAuthServer", "use old keys");
            this.tYy = C1173e.m2571f(file3.getAbsolutePath(), 0, BaseClientBuilder.API_PRIORITY_OTHER);
            this.tYx = C1173e.m2571f(file2.getAbsolutePath(), 0, BaseClientBuilder.API_PRIORITY_OTHER);
            this.bFT = C1173e.m2571f(file4.getAbsolutePath(), 0, BaseClientBuilder.API_PRIORITY_OTHER);
        } else {
            C4990ab.m7416i("MicroMsg.Wear.HttpAuthServer", "recreate keys");
            file2.delete();
            file3.delete();
            file4.delete();
            HashMap cUE = C43839a.cUE();
            RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) cUE.get("RSAPrivateKey");
            this.tYy = ((RSAPublicKey) cUE.get("RSAPublicKey")).getEncoded();
            this.tYx = rSAPrivateKey.getEncoded();
            this.bFT = C43839a.cUF();
            C1173e.m2559b(file2.getAbsolutePath(), this.tYx, this.tYx.length);
            C1173e.m2559b(file3.getAbsolutePath(), this.tYy, this.tYy.length);
            C1173e.m2559b(file4.getAbsolutePath(), this.bFT, this.bFT.length);
        }
        C4990ab.m7417i("MicroMsg.Wear.HttpAuthServer", "publicKey=%s privateKey=%s sessionKey=%s", C4995ag.m7429w(this.tYy), C4995ag.m7429w(this.tYx), C4995ag.m7429w(this.bFT));
        AppMethodBeat.m2505o(26386);
    }

    public final List<Integer> cUA() {
        AppMethodBeat.m2504i(26387);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(10001));
        arrayList.add(Integer.valueOf(10002));
        AppMethodBeat.m2505o(26387);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: p */
    public final byte[] mo9572p(int i, byte[] bArr) {
        boolean z = true;
        AppMethodBeat.m2504i(26388);
        byte[] bArr2;
        switch (i) {
            case 10001:
                boolean z2;
                C4990ab.m7416i("MicroMsg.Wear.HttpAuthServer", "request public key");
                if (this.tYy == null || this.tYx == null || this.bFT == null) {
                    C4990ab.m7416i("MicroMsg.Wear.HttpAuthServer", "try to reload all key");
                    try {
                        cUC();
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.Wear.HttpAuthServer", e, "loadAllKey", new Object[0]);
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
                C4990ab.m7417i(str, str2, objArr);
                bArr2 = this.tYy;
                AppMethodBeat.m2505o(26388);
                return bArr2;
            case 10002:
                try {
                    PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(this.tYx);
                    KeyFactory instance = KeyFactory.getInstance("RSA");
                    PrivateKey generatePrivate = instance.generatePrivate(pKCS8EncodedKeySpec);
                    Cipher instance2 = Cipher.getInstance(instance.getAlgorithm());
                    instance2.init(2, generatePrivate);
                    bArr2 = C43839a.m78618i(this.bFT, instance2.doFinal(bArr));
                    C4990ab.m7417i("MicroMsg.Wear.HttpAuthServer", "funid %d, randomKey=%s", Integer.valueOf(i), C4995ag.m7429w(r1));
                    AppMethodBeat.m2505o(26388);
                    return bArr2;
                } catch (Exception e2) {
                    C4990ab.printErrStackTrace("MicroMsg.Wear.HttpAuthServer", e2, "sessionKey resp error", new Object[0]);
                    break;
                }
        }
        AppMethodBeat.m2505o(26388);
        return null;
    }
}
