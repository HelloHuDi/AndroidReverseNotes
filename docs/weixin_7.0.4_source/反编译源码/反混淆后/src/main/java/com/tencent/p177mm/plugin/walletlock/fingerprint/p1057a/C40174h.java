package com.tencent.p177mm.plugin.walletlock.fingerprint.p1057a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.walletlock.p1319c.C40171g;
import com.tencent.p177mm.plugin.walletlock.p1319c.C43833b;
import com.tencent.p177mm.plugin.walletlock.p1319c.C46388h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.soter.core.p1351c.C30973j;
import com.tencent.soter.p663a.p1105a.C40985a;
import com.tencent.soter.p663a.p1105a.C40986b;
import com.tencent.soter.p663a.p1106b.C16163a;
import com.tencent.soter.p663a.p1106b.C16164b;
import com.tencent.soter.p663a.p1106b.C46744e;

/* renamed from: com.tencent.mm.plugin.walletlock.fingerprint.a.h */
public final class C40174h {
    public C40985a tVi = null;

    /* renamed from: com.tencent.mm.plugin.walletlock.fingerprint.a.h$1 */
    public class C227211 implements C40986b {
        final /* synthetic */ C43833b tVj;

        public C227211(C43833b c43833b) {
            this.tVj = c43833b;
        }

        public final void bxL() {
            AppMethodBeat.m2504i(51490);
            C4990ab.m7418v("MicroMsg.SoterFingerprintAuthManager", "alvinluo onStartAuthentication");
            if (this.tVj != null) {
                this.tVj.cTy();
            }
            AppMethodBeat.m2505o(51490);
        }

        public final void onAuthenticationHelp(int i, CharSequence charSequence) {
            AppMethodBeat.m2504i(51491);
            C4990ab.m7417i("MicroMsg.SoterFingerprintAuthManager", "alvinluo onAuthenticationHelp errCode: %d, errMsg: %s and do nothing", Integer.valueOf(i), charSequence);
            AppMethodBeat.m2505o(51491);
        }

        public final void bxM() {
            AppMethodBeat.m2504i(51492);
            C4990ab.m7416i("MicroMsg.SoterFingerprintAuthManager", "alvinluo onAuthenticationSucceed");
            C40174h.this.tVi = null;
            AppMethodBeat.m2505o(51492);
        }

        public final void onAuthenticationFailed() {
            AppMethodBeat.m2504i(51493);
            C4990ab.m7416i("MicroMsg.SoterFingerprintAuthManager", "alvinluo onAuthenticationFailed");
            if (this.tVj != null) {
                this.tVj.mo26648T(1, "not match");
            }
            AppMethodBeat.m2505o(51493);
        }

        public final void onAuthenticationCancelled() {
            AppMethodBeat.m2504i(51494);
            C4990ab.m7416i("MicroMsg.SoterFingerprintAuthManager", "alvinluo onAuthenticationCancelled");
            C40174h.this.tVi = null;
            AppMethodBeat.m2505o(51494);
        }

        public final void onAuthenticationError(int i, CharSequence charSequence) {
            AppMethodBeat.m2504i(51495);
            C4990ab.m7417i("MicroMsg.SoterFingerprintAuthManager", "alvinluo onAuthenticationError errCode: %d, errMsg: %s", Integer.valueOf(i), charSequence);
            if (10308 == i) {
                C4990ab.m7416i("MicroMsg.SoterFingerprintAuthManager", "py: authentication is frozen, auto cancel now.");
                C40174h c40174h = C40174h.this;
                C4990ab.m7416i("MicroMsg.SoterFingerprintAuthManager", "alvinluo user cancel fingerprint auth");
                if (c40174h.tVi != null) {
                    c40174h.tVi.mo64929rp(true);
                }
            }
            C40174h.this.tVi = null;
            AppMethodBeat.m2505o(51495);
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.fingerprint.a.h$2 */
    public class C227222 implements C16164b<C16163a> {
        final /* synthetic */ C43833b tVj;

        public C227222(C43833b c43833b) {
            this.tVj = c43833b;
        }

        /* renamed from: a */
        public final /* synthetic */ void mo17330a(C46744e c46744e) {
            AppMethodBeat.m2504i(51496);
            C16163a c16163a = (C16163a) c46744e;
            C4990ab.m7417i("MicroMsg.SoterFingerprintAuthManager", "request auth onResult errCode: %d, errMsg: %s", Integer.valueOf(c16163a.errCode), c16163a.aIm);
            if (c16163a.isSuccess()) {
                C40171g.tWY.tXa = (C30973j) c16163a.AvM;
                if (this.tVj != null) {
                    this.tVj.mo26648T(0, "authenticate ok");
                }
                AppMethodBeat.m2505o(51496);
                return;
            }
            C46388h.m87251gm(3, c16163a.errCode);
            if (c16163a.errCode == 25) {
                C4990ab.m7416i("MicroMsg.SoterFingerprintAuthManager", "alvinluo too many trial");
                if (this.tVj != null) {
                    this.tVj.mo26648T(3, "too many trial");
                    AppMethodBeat.m2505o(51496);
                    return;
                }
            } else if (c16163a.errCode == 24) {
                C4990ab.m7416i("MicroMsg.SoterFingerprintAuthManager", "alvinluo user cancelled");
                if (this.tVj != null) {
                    this.tVj.mo26648T(4, "user cancelled");
                    AppMethodBeat.m2505o(51496);
                    return;
                }
            } else if (c16163a.errCode == 18) {
                if (this.tVj != null) {
                    this.tVj.mo26648T(8, "no fingerprint enrolled in system");
                    AppMethodBeat.m2505o(51496);
                    return;
                }
            } else if (this.tVj != null) {
                this.tVj.mo26648T(2, c16163a.aIm);
            }
            AppMethodBeat.m2505o(51496);
        }
    }

    public final void release() {
        AppMethodBeat.m2504i(51497);
        C4990ab.m7416i("MicroMsg.SoterFingerprintAuthManager", "alvinluo release fingerprint auth");
        if (this.tVi != null) {
            this.tVi.mo64929rp(true);
        }
        AppMethodBeat.m2505o(51497);
    }
}
