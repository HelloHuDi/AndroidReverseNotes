package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.walletlock.c.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.soter.a.a.a;
import com.tencent.soter.a.a.b;
import com.tencent.soter.a.b.e;
import com.tencent.soter.core.c.j;

public final class h {
    public a tVi = null;

    /* renamed from: com.tencent.mm.plugin.walletlock.fingerprint.a.h$1 */
    public class AnonymousClass1 implements b {
        final /* synthetic */ com.tencent.mm.plugin.walletlock.c.b tVj;

        public AnonymousClass1(com.tencent.mm.plugin.walletlock.c.b bVar) {
            this.tVj = bVar;
        }

        public final void bxL() {
            AppMethodBeat.i(51490);
            ab.v("MicroMsg.SoterFingerprintAuthManager", "alvinluo onStartAuthentication");
            if (this.tVj != null) {
                this.tVj.cTy();
            }
            AppMethodBeat.o(51490);
        }

        public final void onAuthenticationHelp(int i, CharSequence charSequence) {
            AppMethodBeat.i(51491);
            ab.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo onAuthenticationHelp errCode: %d, errMsg: %s and do nothing", Integer.valueOf(i), charSequence);
            AppMethodBeat.o(51491);
        }

        public final void bxM() {
            AppMethodBeat.i(51492);
            ab.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo onAuthenticationSucceed");
            h.this.tVi = null;
            AppMethodBeat.o(51492);
        }

        public final void onAuthenticationFailed() {
            AppMethodBeat.i(51493);
            ab.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo onAuthenticationFailed");
            if (this.tVj != null) {
                this.tVj.T(1, "not match");
            }
            AppMethodBeat.o(51493);
        }

        public final void onAuthenticationCancelled() {
            AppMethodBeat.i(51494);
            ab.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo onAuthenticationCancelled");
            h.this.tVi = null;
            AppMethodBeat.o(51494);
        }

        public final void onAuthenticationError(int i, CharSequence charSequence) {
            AppMethodBeat.i(51495);
            ab.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo onAuthenticationError errCode: %d, errMsg: %s", Integer.valueOf(i), charSequence);
            if (10308 == i) {
                ab.i("MicroMsg.SoterFingerprintAuthManager", "py: authentication is frozen, auto cancel now.");
                h hVar = h.this;
                ab.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo user cancel fingerprint auth");
                if (hVar.tVi != null) {
                    hVar.tVi.rp(true);
                }
            }
            h.this.tVi = null;
            AppMethodBeat.o(51495);
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.fingerprint.a.h$2 */
    public class AnonymousClass2 implements com.tencent.soter.a.b.b<com.tencent.soter.a.b.a> {
        final /* synthetic */ com.tencent.mm.plugin.walletlock.c.b tVj;

        public AnonymousClass2(com.tencent.mm.plugin.walletlock.c.b bVar) {
            this.tVj = bVar;
        }

        public final /* synthetic */ void a(e eVar) {
            AppMethodBeat.i(51496);
            com.tencent.soter.a.b.a aVar = (com.tencent.soter.a.b.a) eVar;
            ab.i("MicroMsg.SoterFingerprintAuthManager", "request auth onResult errCode: %d, errMsg: %s", Integer.valueOf(aVar.errCode), aVar.aIm);
            if (aVar.isSuccess()) {
                g.tWY.tXa = (j) aVar.AvM;
                if (this.tVj != null) {
                    this.tVj.T(0, "authenticate ok");
                }
                AppMethodBeat.o(51496);
                return;
            }
            com.tencent.mm.plugin.walletlock.c.h.gm(3, aVar.errCode);
            if (aVar.errCode == 25) {
                ab.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo too many trial");
                if (this.tVj != null) {
                    this.tVj.T(3, "too many trial");
                    AppMethodBeat.o(51496);
                    return;
                }
            } else if (aVar.errCode == 24) {
                ab.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo user cancelled");
                if (this.tVj != null) {
                    this.tVj.T(4, "user cancelled");
                    AppMethodBeat.o(51496);
                    return;
                }
            } else if (aVar.errCode == 18) {
                if (this.tVj != null) {
                    this.tVj.T(8, "no fingerprint enrolled in system");
                    AppMethodBeat.o(51496);
                    return;
                }
            } else if (this.tVj != null) {
                this.tVj.T(2, aVar.aIm);
            }
            AppMethodBeat.o(51496);
        }
    }

    public final void release() {
        AppMethodBeat.i(51497);
        ab.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo release fingerprint auth");
        if (this.tVi != null) {
            this.tVi.rp(true);
        }
        AppMethodBeat.o(51497);
    }
}
