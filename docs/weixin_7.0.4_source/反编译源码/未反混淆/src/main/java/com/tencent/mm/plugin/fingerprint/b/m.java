package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fingerprint.c.b;
import com.tencent.mm.plugin.soter.b.f;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.pluginsdk.wallet.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.soter.a.b.c;
import com.tencent.soter.a.b.e;
import java.lang.ref.WeakReference;

public final class m implements j {
    private String gEk;
    WeakReference<WalletBaseUI> msa;
    private a msb;
    private a msc;

    public final void a(Context context, a aVar, String str) {
        AppMethodBeat.i(41541);
        ab.i("MicroMsg.SoterFaceIdOpenDelegate", "do prepare");
        this.msb = aVar;
        this.gEk = str;
        this.msa = new WeakReference((WalletBaseUI) context);
        ((WalletBaseUI) this.msa.get()).nf(1586);
        ((WalletBaseUI) this.msa.get()).nf(1638);
        bxN();
        AppMethodBeat.o(41541);
    }

    public final void clear() {
        AppMethodBeat.i(41542);
        ab.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: clear");
        if (!(this.msa == null || this.msa.get() == null)) {
            ((WalletBaseUI) this.msa.get()).ng(1586);
            ((WalletBaseUI) this.msa.get()).ng(1638);
        }
        v.tCn.reset();
        if (!(this.msa == null || this.msa.get() == null)) {
            this.msa.clear();
        }
        AppMethodBeat.o(41542);
    }

    public final boolean c(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(41543);
        ab.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: onSceneEnd: errType: %d, errCode: %d, errMsg: %s, scene: %s", Integer.valueOf(i), Integer.valueOf(i2), str, mVar);
        if (bo.isNullOrNil(str)) {
            str = ah.getContext().getString(R.string.bms);
        }
        if (mVar instanceof com.tencent.mm.plugin.fingerprint.c.a) {
            if (i == 0 && i2 == 0) {
                ab.i("MicroMsg.SoterFaceIdOpenDelegate", "get challenge success");
                if (bo.isNullOrNil(((com.tencent.mm.plugin.fingerprint.c.a) mVar).msn)) {
                    aD(-1, str);
                    AppMethodBeat.o(41543);
                    return true;
                }
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(41539);
                        m.this.aD(0, "");
                        AppMethodBeat.o(41539);
                    }
                });
            } else {
                ab.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: failed get challenge");
                aD(i2, str);
                com.tencent.mm.plugin.soter.d.a.e(7, i, i2, "get challenge failed");
                AppMethodBeat.o(41543);
                return true;
            }
        }
        if (mVar instanceof b) {
            if (i2 == 0 && i == 0) {
                ab.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: open success");
                com.tencent.mm.plugin.soter.d.a.cvO();
                com.tencent.mm.plugin.soter.d.a.e(0, 0, 0, "OK");
                aE(0, str);
            } else {
                ab.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: open");
                com.tencent.mm.plugin.soter.d.a.e(8, i, i2, "open fp pay failed");
                aE(-1, str);
            }
            AppMethodBeat.o(41543);
            return true;
        }
        AppMethodBeat.o(41543);
        return false;
    }

    public final void a(a aVar, String str, int i) {
        AppMethodBeat.i(41544);
        ab.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: doOpenFP");
        this.msc = aVar;
        com.tencent.soter.core.c.j jVar = v.tCn.tCp;
        if (jVar == null) {
            ab.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: signature is null");
            com.tencent.mm.plugin.soter.d.a.e(9, -1000223, -1, "signature is null");
            aE(-1, ah.getContext().getString(R.string.bms));
        } else if (!(this.msa == null || this.msa.get() == null)) {
            ((WalletBaseUI) this.msa.get()).a(new b(jVar.Avx, jVar.signature, this.gEk, 2), true, true);
            AppMethodBeat.o(41544);
            return;
        }
        AppMethodBeat.o(41544);
    }

    private void bxN() {
        AppMethodBeat.i(41545);
        com.tencent.soter.a.a.a(new com.tencent.soter.a.b.b<c>() {
            public final /* synthetic */ void a(e eVar) {
                AppMethodBeat.i(41540);
                c cVar = (c) eVar;
                ab.i("MicroMsg.SoterFaceIdOpenDelegate", "alvinluo prepare auth key errCode: %d, errMsg: %s", Integer.valueOf(cVar.errCode), cVar.aIm);
                if (cVar.isSuccess()) {
                    ab.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: update pay auth key success");
                    if (m.this.msa == null || m.this.msa.get() == null) {
                        m.this.aD(-1, "base ui is null");
                        AppMethodBeat.o(41540);
                        return;
                    }
                    ((WalletBaseUI) m.this.msa.get()).a(new com.tencent.mm.plugin.fingerprint.c.a(2), false, false);
                    AppMethodBeat.o(41540);
                    return;
                }
                com.tencent.mm.plugin.soter.d.a.fH(2, cVar.errCode);
                if (cVar.errCode == 12) {
                    ab.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: failed upload: model is null or necessary elements null");
                    com.tencent.mm.plugin.soter.d.a.e(4, -1000223, -1, "gen auth key failed: unexpected! generated but cannot get");
                } else if (cVar.errCode == 5) {
                    com.tencent.mm.plugin.soter.d.a.e(4, -1000223, -1, "gen auth key failed");
                } else if (cVar.errCode == 10) {
                    ab.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: update pay auth key failed. remove");
                    com.tencent.soter.a.a.Ri(1);
                    com.tencent.mm.plugin.soter.d.a.e(5, 4, cVar.errCode, "upload auth key failed");
                } else if (cVar.errCode == 4 || cVar.errCode == 3) {
                    ab.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: gen auth key failed");
                    com.tencent.mm.plugin.soter.d.a.e(2, -1000223, -1, "gen ask failed");
                } else if (cVar.errCode == 9) {
                    ab.e("MicroMsg.SoterFaceIdOpenDelegate", "alvinluo upload ask failed");
                    com.tencent.mm.plugin.soter.d.a.e(3, 4, cVar.errCode, cVar.aIm);
                } else {
                    ab.e("MicroMsg.SoterFaceIdOpenDelegate", "alvinluo unknown error when prepare auth key");
                    com.tencent.mm.plugin.soter.d.a.e(1000, -1000223, cVar.errCode, cVar.aIm);
                }
                m.this.aD(-1, cVar.aIm);
                AppMethodBeat.o(41540);
            }
        }, true, 1, new com.tencent.mm.plugin.fingerprint.c.c(this.gEk, 2), new f());
        AppMethodBeat.o(41545);
    }

    /* Access modifiers changed, original: final */
    public final void aD(int i, String str) {
        AppMethodBeat.i(41546);
        if (this.msb != null) {
            this.msb.aC(i, str);
        }
        AppMethodBeat.o(41546);
    }

    private void aE(int i, String str) {
        AppMethodBeat.i(41547);
        if (this.msc != null) {
            this.msc.aC(i, str);
        }
        AppMethodBeat.o(41547);
    }
}
