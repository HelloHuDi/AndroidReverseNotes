package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.soter.b.f;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.pluginsdk.wallet.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.soter.a.b.b;
import com.tencent.soter.a.b.c;
import com.tencent.soter.a.b.e;
import java.lang.ref.WeakReference;

public final class n implements j {
    private String gEk = "";
    private a mrH = null;
    private a mrI = null;
    WeakReference<WalletBaseUI> msa = null;

    public final void a(Context context, a aVar, String str) {
        AppMethodBeat.i(41550);
        ab.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: prepare");
        this.msa = new WeakReference((WalletBaseUI) context);
        this.mrH = aVar;
        this.gEk = str;
        ((WalletBaseUI) this.msa.get()).nf(1586);
        ((WalletBaseUI) this.msa.get()).nf(1638);
        com.tencent.mm.plugin.soter.d.a.cvN();
        ab.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: start gen auth key");
        com.tencent.soter.a.a.a(new b<c>() {
            public final /* synthetic */ void a(e eVar) {
                AppMethodBeat.i(41548);
                c cVar = (c) eVar;
                ab.i("MicroMsg.SoterFingerprintOpenDelegate", "alvinluo prepare auth key errCode: %d, errMsg: %s", Integer.valueOf(cVar.errCode), cVar.aIm);
                if (cVar.isSuccess()) {
                    ab.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: update pay auth key success");
                    if (n.this.msa == null || n.this.msa.get() == null) {
                        n.this.aF(-1, "base ui is null");
                        AppMethodBeat.o(41548);
                        return;
                    }
                    ((WalletBaseUI) n.this.msa.get()).a(new com.tencent.mm.plugin.fingerprint.c.a(1), false, false);
                    AppMethodBeat.o(41548);
                    return;
                }
                com.tencent.mm.plugin.soter.d.a.fH(2, cVar.errCode);
                if (cVar.errCode == 12) {
                    ab.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: failed upload: model is null or necessary elements null");
                    com.tencent.mm.plugin.soter.d.a.d(4, -1000223, -1, "gen auth key failed: unexpected! generated but cannot get");
                } else if (cVar.errCode == 5) {
                    com.tencent.mm.plugin.soter.d.a.d(4, -1000223, -1, "gen auth key failed");
                } else if (cVar.errCode == 10) {
                    ab.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: update pay auth key failed. remove");
                    com.tencent.soter.a.a.Ri(1);
                    com.tencent.mm.plugin.soter.d.a.d(5, 4, cVar.errCode, "upload auth key failed");
                } else if (cVar.errCode == 4 || cVar.errCode == 3) {
                    ab.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: gen auth key failed");
                    com.tencent.mm.plugin.soter.d.a.d(2, -1000223, -1, "gen ask failed");
                } else if (cVar.errCode == 9) {
                    ab.e("MicroMsg.SoterFingerprintOpenDelegate", "alvinluo upload ask failed");
                    com.tencent.mm.plugin.soter.d.a.d(3, 4, cVar.errCode, cVar.aIm);
                } else {
                    ab.e("MicroMsg.SoterFingerprintOpenDelegate", "alvinluo unknown error when prepare auth key");
                    com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, cVar.errCode, cVar.aIm);
                }
                n.this.aF(-1, cVar.aIm);
                AppMethodBeat.o(41548);
            }
        }, true, 1, new com.tencent.mm.plugin.fingerprint.c.c(this.gEk, 1), new f());
        AppMethodBeat.o(41550);
    }

    public final void clear() {
        AppMethodBeat.i(41551);
        ab.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: clear");
        if (!(this.msa == null || this.msa.get() == null)) {
            ((WalletBaseUI) this.msa.get()).ng(1586);
            ((WalletBaseUI) this.msa.get()).ng(1638);
        }
        this.mrH = null;
        v.tCn.reset();
        if (!(this.msa == null || this.msa.get() == null)) {
            this.msa.clear();
        }
        AppMethodBeat.o(41551);
    }

    /* Access modifiers changed, original: final */
    public final void aF(int i, String str) {
        AppMethodBeat.i(41552);
        if (this.mrH != null) {
            this.mrH.aC(i, str);
        }
        AppMethodBeat.o(41552);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(41553);
        ab.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: onSceneEnd: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (bo.isNullOrNil(str)) {
            str = ah.getContext().getString(R.string.bv_);
        }
        if (mVar instanceof com.tencent.mm.plugin.fingerprint.c.a) {
            if (i == 0 && i2 == 0) {
                ab.i("MicroMsg.SoterFingerprintOpenDelegate", "get challenge success");
                if (bo.isNullOrNil(((com.tencent.mm.plugin.fingerprint.c.a) mVar).msn)) {
                    aF(-1, str);
                    AppMethodBeat.o(41553);
                    return true;
                }
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(41549);
                        n.this.aF(0, "");
                        AppMethodBeat.o(41549);
                    }
                });
            } else {
                ab.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: failed get challenge");
                aF(i2, str);
                com.tencent.mm.plugin.soter.d.a.d(7, i, i2, "get challenge failed");
                AppMethodBeat.o(41553);
                return true;
            }
        }
        if (mVar instanceof com.tencent.mm.plugin.fingerprint.c.b) {
            if (i2 == 0 && i == 0) {
                ab.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: open success");
                com.tencent.mm.plugin.soter.d.a.cvO();
                com.tencent.mm.plugin.soter.d.a.d(0, 0, 0, "OK");
                aG(0, str);
            } else {
                ab.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: open");
                com.tencent.mm.plugin.soter.d.a.d(8, i, i2, "open fp pay failed");
                aG(-1, str);
            }
            AppMethodBeat.o(41553);
            return true;
        }
        AppMethodBeat.o(41553);
        return false;
    }

    private void aG(int i, String str) {
        AppMethodBeat.i(41554);
        ab.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: callback total");
        clear();
        this.mrI.aC(i, str);
        this.mrI = null;
        AppMethodBeat.o(41554);
    }

    public final void a(a aVar, String str, int i) {
        AppMethodBeat.i(41555);
        ab.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: doOpenFP");
        this.mrI = aVar;
        com.tencent.soter.core.c.j jVar = v.tCn.tCp;
        if (jVar == null) {
            ab.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: signature is null");
            com.tencent.mm.plugin.soter.d.a.d(9, -1000223, -1, "signature is null");
            aF(-1, ah.getContext().getString(R.string.bv_));
        } else if (!(this.msa == null || this.msa.get() == null)) {
            ((WalletBaseUI) this.msa.get()).a(new com.tencent.mm.plugin.fingerprint.c.b(jVar.Avx, jVar.signature, this.gEk, 1), true, true);
            AppMethodBeat.o(41555);
            return;
        }
        AppMethodBeat.o(41555);
    }
}
