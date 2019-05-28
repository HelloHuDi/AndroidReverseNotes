package com.tencent.soter.core.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.e;
import com.tencent.soter.core.c.f;
import com.tencent.soter.core.c.g;
import com.tencent.soter.core.c.h;
import com.tencent.soter.core.c.i;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.cert.Certificate;

public final class a extends c {
    public a(String str) {
        super(str);
    }

    public final f dQO() {
        AppMethodBeat.i(73050);
        d.i("Soter.CertSoterCore", "soter: start generate ask", new Object[0]);
        f fVar;
        if (dQN()) {
            try {
                KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", this.Avy);
                instance.initialize(com.tencent.soter.core.b.a.eP(e.dQW().Avi + ".addcounter.auto_signed_when_get_pubkey_attk", 16).W(XWalkAppVersion.XWALK_APK_HASH_ALGORITHM).X("PSS").dQU());
                long nanoTime = System.nanoTime();
                instance.generateKeyPair();
                long nC = g.nC(nanoTime);
                d.i("Soter.CertSoterCore", "soter: generate successfully. cost: %d ms", Long.valueOf(nC));
                fVar = new f(0);
                AppMethodBeat.o(73050);
                return fVar;
            } catch (Exception e) {
                Exception exception = e;
                d.e("Soter.CertSoterCore", "soter: generateAppGlobalSecureKey " + exception.toString(), new Object[0]);
                d.a("Soter.CertSoterCore", exception, "soter: generateAppGlobalSecureKey error");
                fVar = new f(4, exception.toString());
                AppMethodBeat.o(73050);
                return fVar;
            } catch (OutOfMemoryError e2) {
                d.a("Soter.CertSoterCore", e2, "soter: out of memory when generate ASK!! maybe no attk inside");
                h.dQX();
            }
        } else {
            d.e("Soter.CertSoterCore", "soter: not support soter", new Object[0]);
            fVar = new f(2);
            AppMethodBeat.o(73050);
            return fVar;
        }
    }

    public final i dQS() {
        AppMethodBeat.i(73051);
        d.i("Soter.CertSoterCore", "soter: start get app global secure key pub", new Object[0]);
        if (dQN()) {
            try {
                KeyStore instance = KeyStore.getInstance(this.Avy);
                instance.load(null);
                try {
                    Certificate[] certificateChain = instance.getCertificateChain(e.dQW().Avi);
                    if (certificateChain != null) {
                        i iVar = new i(certificateChain);
                        AppMethodBeat.o(73051);
                        return iVar;
                    }
                    d.e("Soter.CertSoterCore", "soter: key can not be retrieved", new Object[0]);
                    AppMethodBeat.o(73051);
                    return null;
                } catch (ClassCastException e) {
                    d.e("Soter.CertSoterCore", "soter: cast error: " + e.toString(), new Object[0]);
                    AppMethodBeat.o(73051);
                    return null;
                }
            } catch (Exception e2) {
                d.a("Soter.CertSoterCore", e2, "soter: error when get ask");
            } catch (OutOfMemoryError e3) {
                d.a("Soter.CertSoterCore", e3, "soter: out of memory when getting ask!! maybe no attk inside");
                h.dQX();
            }
        } else {
            d.e("Soter.CertSoterCore", "soter: not support soter", new Object[0]);
            AppMethodBeat.o(73051);
            return null;
        }
    }

    public final Signature auf(String str) {
        AppMethodBeat.i(73052);
        d.d("Monday", "CertSoterCore initAuthKeySignature", new Object[0]);
        if (g.isNullOrNil(str)) {
            d.e("Soter.CertSoterCore", "soter: auth key name is null or nil. abort.", new Object[0]);
            AppMethodBeat.o(73052);
            return null;
        }
        Signature instance = Signature.getInstance("SHA256withRSA/PSS");
        KeyStore instance2 = KeyStore.getInstance(this.Avy);
        instance2.load(null);
        Key key = instance2.getKey(str, null);
        if (key != null) {
            instance.initSign((PrivateKey) key);
            AppMethodBeat.o(73052);
            return instance;
        }
        d.e("Soter.CertSoterCore", "soter: entry not exists", new Object[0]);
        AppMethodBeat.o(73052);
        return null;
    }
}
