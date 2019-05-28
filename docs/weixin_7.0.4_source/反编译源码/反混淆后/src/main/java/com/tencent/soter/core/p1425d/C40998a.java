package com.tencent.soter.core.p1425d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.p1350b.C24316a;
import com.tencent.soter.core.p1351c.C24321g;
import com.tencent.soter.core.p1351c.C24322h;
import com.tencent.soter.core.p1351c.C30972i;
import com.tencent.soter.core.p1351c.C44476d;
import com.tencent.soter.core.p1351c.C44478f;
import com.tencent.soter.core.p1351c.C46745e;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.cert.Certificate;

/* renamed from: com.tencent.soter.core.d.a */
public final class C40998a extends C46746c {
    public C40998a(String str) {
        super(str);
    }

    public final C44478f dQO() {
        AppMethodBeat.m2504i(73050);
        C44476d.m80484i("Soter.CertSoterCore", "soter: start generate ask", new Object[0]);
        C44478f c44478f;
        if (dQN()) {
            try {
                KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", this.Avy);
                instance.initialize(C24316a.m37479eP(C46745e.dQW().Avi + ".addcounter.auto_signed_when_get_pubkey_attk", 16).mo40403W(XWalkAppVersion.XWALK_APK_HASH_ALGORITHM).mo40404X("PSS").dQU());
                long nanoTime = System.nanoTime();
                instance.generateKeyPair();
                long nC = C24321g.m37491nC(nanoTime);
                C44476d.m80484i("Soter.CertSoterCore", "soter: generate successfully. cost: %d ms", Long.valueOf(nC));
                c44478f = new C44478f(0);
                AppMethodBeat.m2505o(73050);
                return c44478f;
            } catch (Exception e) {
                Exception exception = e;
                C44476d.m80483e("Soter.CertSoterCore", "soter: generateAppGlobalSecureKey " + exception.toString(), new Object[0]);
                C44476d.m80481a("Soter.CertSoterCore", exception, "soter: generateAppGlobalSecureKey error");
                c44478f = new C44478f(4, exception.toString());
                AppMethodBeat.m2505o(73050);
                return c44478f;
            } catch (OutOfMemoryError e2) {
                C44476d.m80481a("Soter.CertSoterCore", e2, "soter: out of memory when generate ASK!! maybe no attk inside");
                C24322h.dQX();
            }
        } else {
            C44476d.m80483e("Soter.CertSoterCore", "soter: not support soter", new Object[0]);
            c44478f = new C44478f(2);
            AppMethodBeat.m2505o(73050);
            return c44478f;
        }
    }

    public final C30972i dQS() {
        AppMethodBeat.m2504i(73051);
        C44476d.m80484i("Soter.CertSoterCore", "soter: start get app global secure key pub", new Object[0]);
        if (dQN()) {
            try {
                KeyStore instance = KeyStore.getInstance(this.Avy);
                instance.load(null);
                try {
                    Certificate[] certificateChain = instance.getCertificateChain(C46745e.dQW().Avi);
                    if (certificateChain != null) {
                        C30972i c30972i = new C30972i(certificateChain);
                        AppMethodBeat.m2505o(73051);
                        return c30972i;
                    }
                    C44476d.m80483e("Soter.CertSoterCore", "soter: key can not be retrieved", new Object[0]);
                    AppMethodBeat.m2505o(73051);
                    return null;
                } catch (ClassCastException e) {
                    C44476d.m80483e("Soter.CertSoterCore", "soter: cast error: " + e.toString(), new Object[0]);
                    AppMethodBeat.m2505o(73051);
                    return null;
                }
            } catch (Exception e2) {
                C44476d.m80481a("Soter.CertSoterCore", e2, "soter: error when get ask");
            } catch (OutOfMemoryError e3) {
                C44476d.m80481a("Soter.CertSoterCore", e3, "soter: out of memory when getting ask!! maybe no attk inside");
                C24322h.dQX();
            }
        } else {
            C44476d.m80483e("Soter.CertSoterCore", "soter: not support soter", new Object[0]);
            AppMethodBeat.m2505o(73051);
            return null;
        }
    }

    public final Signature auf(String str) {
        AppMethodBeat.m2504i(73052);
        C44476d.m80482d("Monday", "CertSoterCore initAuthKeySignature", new Object[0]);
        if (C24321g.isNullOrNil(str)) {
            C44476d.m80483e("Soter.CertSoterCore", "soter: auth key name is null or nil. abort.", new Object[0]);
            AppMethodBeat.m2505o(73052);
            return null;
        }
        Signature instance = Signature.getInstance("SHA256withRSA/PSS");
        KeyStore instance2 = KeyStore.getInstance(this.Avy);
        instance2.load(null);
        Key key = instance2.getKey(str, null);
        if (key != null) {
            instance.initSign((PrivateKey) key);
            AppMethodBeat.m2505o(73052);
            return instance;
        }
        C44476d.m80483e("Soter.CertSoterCore", "soter: entry not exists", new Object[0]);
        AppMethodBeat.m2505o(73052);
        return null;
    }
}
