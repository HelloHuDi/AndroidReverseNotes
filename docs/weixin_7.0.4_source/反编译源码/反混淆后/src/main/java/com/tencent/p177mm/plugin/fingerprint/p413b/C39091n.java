package com.tencent.p177mm.plugin.fingerprint.p413b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.fingerprint.p1261c.C43095a;
import com.tencent.p177mm.plugin.fingerprint.p1261c.C43096b;
import com.tencent.p177mm.plugin.fingerprint.p1261c.C43097c;
import com.tencent.p177mm.plugin.soter.p527b.C35151f;
import com.tencent.p177mm.plugin.soter.p528d.C46261a;
import com.tencent.p177mm.plugin.wallet_core.model.C35481v;
import com.tencent.p177mm.pluginsdk.wallet.C14992j;
import com.tencent.p177mm.pluginsdk.wallet.C30157a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.soter.core.p1351c.C30973j;
import com.tencent.soter.p663a.C30954a;
import com.tencent.soter.p663a.p1106b.C16164b;
import com.tencent.soter.p663a.p1106b.C16165c;
import com.tencent.soter.p663a.p1106b.C46744e;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.fingerprint.b.n */
public final class C39091n implements C14992j {
    private String gEk = "";
    private C30157a mrH = null;
    private C30157a mrI = null;
    WeakReference<WalletBaseUI> msa = null;

    /* renamed from: com.tencent.mm.plugin.fingerprint.b.n$1 */
    class C167651 implements C16164b<C16165c> {
        C167651() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo17330a(C46744e c46744e) {
            AppMethodBeat.m2504i(41548);
            C16165c c16165c = (C16165c) c46744e;
            C4990ab.m7417i("MicroMsg.SoterFingerprintOpenDelegate", "alvinluo prepare auth key errCode: %d, errMsg: %s", Integer.valueOf(c16165c.errCode), c16165c.aIm);
            if (c16165c.isSuccess()) {
                C4990ab.m7416i("MicroMsg.SoterFingerprintOpenDelegate", "hy: update pay auth key success");
                if (C39091n.this.msa == null || C39091n.this.msa.get() == null) {
                    C39091n.this.mo61998aF(-1, "base ui is null");
                    AppMethodBeat.m2505o(41548);
                    return;
                }
                ((WalletBaseUI) C39091n.this.msa.get()).mo39970a(new C43095a(1), false, false);
                AppMethodBeat.m2505o(41548);
                return;
            }
            C46261a.m86642fH(2, c16165c.errCode);
            if (c16165c.errCode == 12) {
                C4990ab.m7412e("MicroMsg.SoterFingerprintOpenDelegate", "hy: failed upload: model is null or necessary elements null");
                C46261a.m86639d(4, -1000223, -1, "gen auth key failed: unexpected! generated but cannot get");
            } else if (c16165c.errCode == 5) {
                C46261a.m86639d(4, -1000223, -1, "gen auth key failed");
            } else if (c16165c.errCode == 10) {
                C4990ab.m7412e("MicroMsg.SoterFingerprintOpenDelegate", "hy: update pay auth key failed. remove");
                C30954a.m49584Ri(1);
                C46261a.m86639d(5, 4, c16165c.errCode, "upload auth key failed");
            } else if (c16165c.errCode == 4 || c16165c.errCode == 3) {
                C4990ab.m7412e("MicroMsg.SoterFingerprintOpenDelegate", "hy: gen auth key failed");
                C46261a.m86639d(2, -1000223, -1, "gen ask failed");
            } else if (c16165c.errCode == 9) {
                C4990ab.m7412e("MicroMsg.SoterFingerprintOpenDelegate", "alvinluo upload ask failed");
                C46261a.m86639d(3, 4, c16165c.errCode, c16165c.aIm);
            } else {
                C4990ab.m7412e("MicroMsg.SoterFingerprintOpenDelegate", "alvinluo unknown error when prepare auth key");
                C46261a.m86639d(1000, -1000223, c16165c.errCode, c16165c.aIm);
            }
            C39091n.this.mo61998aF(-1, c16165c.aIm);
            AppMethodBeat.m2505o(41548);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fingerprint.b.n$2 */
    class C390922 implements Runnable {
        C390922() {
        }

        public final void run() {
            AppMethodBeat.m2504i(41549);
            C39091n.this.mo61998aF(0, "");
            AppMethodBeat.m2505o(41549);
        }
    }

    /* renamed from: a */
    public final void mo27383a(Context context, C30157a c30157a, String str) {
        AppMethodBeat.m2504i(41550);
        C4990ab.m7416i("MicroMsg.SoterFingerprintOpenDelegate", "hy: prepare");
        this.msa = new WeakReference((WalletBaseUI) context);
        this.mrH = c30157a;
        this.gEk = str;
        ((WalletBaseUI) this.msa.get()).mo39992nf(1586);
        ((WalletBaseUI) this.msa.get()).mo39992nf(1638);
        C46261a.cvN();
        C4990ab.m7416i("MicroMsg.SoterFingerprintOpenDelegate", "hy: start gen auth key");
        C30954a.m49586a(new C167651(), true, 1, new C43097c(this.gEk, 1), new C35151f());
        AppMethodBeat.m2505o(41550);
    }

    public final void clear() {
        AppMethodBeat.m2504i(41551);
        C4990ab.m7416i("MicroMsg.SoterFingerprintOpenDelegate", "hy: clear");
        if (!(this.msa == null || this.msa.get() == null)) {
            ((WalletBaseUI) this.msa.get()).mo39993ng(1586);
            ((WalletBaseUI) this.msa.get()).mo39993ng(1638);
        }
        this.mrH = null;
        C35481v.tCn.reset();
        if (!(this.msa == null || this.msa.get() == null)) {
            this.msa.clear();
        }
        AppMethodBeat.m2505o(41551);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: aF */
    public final void mo61998aF(int i, String str) {
        AppMethodBeat.m2504i(41552);
        if (this.mrH != null) {
            this.mrH.mo7375aC(i, str);
        }
        AppMethodBeat.m2505o(41552);
    }

    /* renamed from: c */
    public final boolean mo27385c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(41553);
        C4990ab.m7417i("MicroMsg.SoterFingerprintOpenDelegate", "hy: onSceneEnd: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (C5046bo.isNullOrNil(str)) {
            str = C4996ah.getContext().getString(C25738R.string.bv_);
        }
        if (c1207m instanceof C43095a) {
            if (i == 0 && i2 == 0) {
                C4990ab.m7416i("MicroMsg.SoterFingerprintOpenDelegate", "get challenge success");
                if (C5046bo.isNullOrNil(((C43095a) c1207m).msn)) {
                    mo61998aF(-1, str);
                    AppMethodBeat.m2505o(41553);
                    return true;
                }
                C5004al.m7441d(new C390922());
            } else {
                C4990ab.m7412e("MicroMsg.SoterFingerprintOpenDelegate", "hy: failed get challenge");
                mo61998aF(i2, str);
                C46261a.m86639d(7, i, i2, "get challenge failed");
                AppMethodBeat.m2505o(41553);
                return true;
            }
        }
        if (c1207m instanceof C43096b) {
            if (i2 == 0 && i == 0) {
                C4990ab.m7416i("MicroMsg.SoterFingerprintOpenDelegate", "hy: open success");
                C46261a.cvO();
                C46261a.m86639d(0, 0, 0, "OK");
                m66527aG(0, str);
            } else {
                C4990ab.m7416i("MicroMsg.SoterFingerprintOpenDelegate", "hy: open");
                C46261a.m86639d(8, i, i2, "open fp pay failed");
                m66527aG(-1, str);
            }
            AppMethodBeat.m2505o(41553);
            return true;
        }
        AppMethodBeat.m2505o(41553);
        return false;
    }

    /* renamed from: aG */
    private void m66527aG(int i, String str) {
        AppMethodBeat.m2504i(41554);
        C4990ab.m7416i("MicroMsg.SoterFingerprintOpenDelegate", "hy: callback total");
        clear();
        this.mrI.mo7375aC(i, str);
        this.mrI = null;
        AppMethodBeat.m2505o(41554);
    }

    /* renamed from: a */
    public final void mo27384a(C30157a c30157a, String str, int i) {
        AppMethodBeat.m2504i(41555);
        C4990ab.m7416i("MicroMsg.SoterFingerprintOpenDelegate", "hy: doOpenFP");
        this.mrI = c30157a;
        C30973j c30973j = C35481v.tCn.tCp;
        if (c30973j == null) {
            C4990ab.m7412e("MicroMsg.SoterFingerprintOpenDelegate", "hy: signature is null");
            C46261a.m86639d(9, -1000223, -1, "signature is null");
            mo61998aF(-1, C4996ah.getContext().getString(C25738R.string.bv_));
        } else if (!(this.msa == null || this.msa.get() == null)) {
            ((WalletBaseUI) this.msa.get()).mo39970a(new C43096b(c30973j.Avx, c30973j.signature, this.gEk, 1), true, true);
            AppMethodBeat.m2505o(41555);
            return;
        }
        AppMethodBeat.m2505o(41555);
    }
}
