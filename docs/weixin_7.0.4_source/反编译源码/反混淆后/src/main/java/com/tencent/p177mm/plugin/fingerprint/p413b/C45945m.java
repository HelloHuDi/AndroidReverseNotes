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

/* renamed from: com.tencent.mm.plugin.fingerprint.b.m */
public final class C45945m implements C14992j {
    private String gEk;
    WeakReference<WalletBaseUI> msa;
    private C30157a msb;
    private C30157a msc;

    /* renamed from: com.tencent.mm.plugin.fingerprint.b.m$1 */
    class C119301 implements Runnable {
        C119301() {
        }

        public final void run() {
            AppMethodBeat.m2504i(41539);
            C45945m.this.mo73802aD(0, "");
            AppMethodBeat.m2505o(41539);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fingerprint.b.m$2 */
    class C280492 implements C16164b<C16165c> {
        C280492() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo17330a(C46744e c46744e) {
            AppMethodBeat.m2504i(41540);
            C16165c c16165c = (C16165c) c46744e;
            C4990ab.m7417i("MicroMsg.SoterFaceIdOpenDelegate", "alvinluo prepare auth key errCode: %d, errMsg: %s", Integer.valueOf(c16165c.errCode), c16165c.aIm);
            if (c16165c.isSuccess()) {
                C4990ab.m7416i("MicroMsg.SoterFaceIdOpenDelegate", "hy: update pay auth key success");
                if (C45945m.this.msa == null || C45945m.this.msa.get() == null) {
                    C45945m.this.mo73802aD(-1, "base ui is null");
                    AppMethodBeat.m2505o(41540);
                    return;
                }
                ((WalletBaseUI) C45945m.this.msa.get()).mo39970a(new C43095a(2), false, false);
                AppMethodBeat.m2505o(41540);
                return;
            }
            C46261a.m86642fH(2, c16165c.errCode);
            if (c16165c.errCode == 12) {
                C4990ab.m7412e("MicroMsg.SoterFaceIdOpenDelegate", "hy: failed upload: model is null or necessary elements null");
                C46261a.m86640e(4, -1000223, -1, "gen auth key failed: unexpected! generated but cannot get");
            } else if (c16165c.errCode == 5) {
                C46261a.m86640e(4, -1000223, -1, "gen auth key failed");
            } else if (c16165c.errCode == 10) {
                C4990ab.m7412e("MicroMsg.SoterFaceIdOpenDelegate", "hy: update pay auth key failed. remove");
                C30954a.m49584Ri(1);
                C46261a.m86640e(5, 4, c16165c.errCode, "upload auth key failed");
            } else if (c16165c.errCode == 4 || c16165c.errCode == 3) {
                C4990ab.m7412e("MicroMsg.SoterFaceIdOpenDelegate", "hy: gen auth key failed");
                C46261a.m86640e(2, -1000223, -1, "gen ask failed");
            } else if (c16165c.errCode == 9) {
                C4990ab.m7412e("MicroMsg.SoterFaceIdOpenDelegate", "alvinluo upload ask failed");
                C46261a.m86640e(3, 4, c16165c.errCode, c16165c.aIm);
            } else {
                C4990ab.m7412e("MicroMsg.SoterFaceIdOpenDelegate", "alvinluo unknown error when prepare auth key");
                C46261a.m86640e(1000, -1000223, c16165c.errCode, c16165c.aIm);
            }
            C45945m.this.mo73802aD(-1, c16165c.aIm);
            AppMethodBeat.m2505o(41540);
        }
    }

    /* renamed from: a */
    public final void mo27383a(Context context, C30157a c30157a, String str) {
        AppMethodBeat.m2504i(41541);
        C4990ab.m7416i("MicroMsg.SoterFaceIdOpenDelegate", "do prepare");
        this.msb = c30157a;
        this.gEk = str;
        this.msa = new WeakReference((WalletBaseUI) context);
        ((WalletBaseUI) this.msa.get()).mo39992nf(1586);
        ((WalletBaseUI) this.msa.get()).mo39992nf(1638);
        bxN();
        AppMethodBeat.m2505o(41541);
    }

    public final void clear() {
        AppMethodBeat.m2504i(41542);
        C4990ab.m7416i("MicroMsg.SoterFaceIdOpenDelegate", "hy: clear");
        if (!(this.msa == null || this.msa.get() == null)) {
            ((WalletBaseUI) this.msa.get()).mo39993ng(1586);
            ((WalletBaseUI) this.msa.get()).mo39993ng(1638);
        }
        C35481v.tCn.reset();
        if (!(this.msa == null || this.msa.get() == null)) {
            this.msa.clear();
        }
        AppMethodBeat.m2505o(41542);
    }

    /* renamed from: c */
    public final boolean mo27385c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(41543);
        C4990ab.m7417i("MicroMsg.SoterFaceIdOpenDelegate", "hy: onSceneEnd: errType: %d, errCode: %d, errMsg: %s, scene: %s", Integer.valueOf(i), Integer.valueOf(i2), str, c1207m);
        if (C5046bo.isNullOrNil(str)) {
            str = C4996ah.getContext().getString(C25738R.string.bms);
        }
        if (c1207m instanceof C43095a) {
            if (i == 0 && i2 == 0) {
                C4990ab.m7416i("MicroMsg.SoterFaceIdOpenDelegate", "get challenge success");
                if (C5046bo.isNullOrNil(((C43095a) c1207m).msn)) {
                    mo73802aD(-1, str);
                    AppMethodBeat.m2505o(41543);
                    return true;
                }
                C5004al.m7441d(new C119301());
            } else {
                C4990ab.m7412e("MicroMsg.SoterFaceIdOpenDelegate", "hy: failed get challenge");
                mo73802aD(i2, str);
                C46261a.m86640e(7, i, i2, "get challenge failed");
                AppMethodBeat.m2505o(41543);
                return true;
            }
        }
        if (c1207m instanceof C43096b) {
            if (i2 == 0 && i == 0) {
                C4990ab.m7416i("MicroMsg.SoterFaceIdOpenDelegate", "hy: open success");
                C46261a.cvO();
                C46261a.m86640e(0, 0, 0, "OK");
                m85327aE(0, str);
            } else {
                C4990ab.m7416i("MicroMsg.SoterFaceIdOpenDelegate", "hy: open");
                C46261a.m86640e(8, i, i2, "open fp pay failed");
                m85327aE(-1, str);
            }
            AppMethodBeat.m2505o(41543);
            return true;
        }
        AppMethodBeat.m2505o(41543);
        return false;
    }

    /* renamed from: a */
    public final void mo27384a(C30157a c30157a, String str, int i) {
        AppMethodBeat.m2504i(41544);
        C4990ab.m7416i("MicroMsg.SoterFaceIdOpenDelegate", "hy: doOpenFP");
        this.msc = c30157a;
        C30973j c30973j = C35481v.tCn.tCp;
        if (c30973j == null) {
            C4990ab.m7412e("MicroMsg.SoterFaceIdOpenDelegate", "hy: signature is null");
            C46261a.m86640e(9, -1000223, -1, "signature is null");
            m85327aE(-1, C4996ah.getContext().getString(C25738R.string.bms));
        } else if (!(this.msa == null || this.msa.get() == null)) {
            ((WalletBaseUI) this.msa.get()).mo39970a(new C43096b(c30973j.Avx, c30973j.signature, this.gEk, 2), true, true);
            AppMethodBeat.m2505o(41544);
            return;
        }
        AppMethodBeat.m2505o(41544);
    }

    private void bxN() {
        AppMethodBeat.m2504i(41545);
        C30954a.m49586a(new C280492(), true, 1, new C43097c(this.gEk, 2), new C35151f());
        AppMethodBeat.m2505o(41545);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: aD */
    public final void mo73802aD(int i, String str) {
        AppMethodBeat.m2504i(41546);
        if (this.msb != null) {
            this.msb.mo7375aC(i, str);
        }
        AppMethodBeat.m2505o(41546);
    }

    /* renamed from: aE */
    private void m85327aE(int i, String str) {
        AppMethodBeat.m2504i(41547);
        if (this.msc != null) {
            this.msc.mo7375aC(i, str);
        }
        AppMethodBeat.m2505o(41547);
    }
}
