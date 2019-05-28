package com.tencent.mm.plugin.walletlock.fingerprint.a;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.soter.e.b;
import com.tencent.mm.plugin.walletlock.c.g;
import com.tencent.mm.plugin.walletlock.c.h;
import com.tencent.mm.plugin.walletlock.fingerprint.a.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.soter.a.b.e;

public final class c implements f, d {
    private String gHr = null;
    boolean isCancelled = false;
    a tVc = null;
    private a tVd = null;
    private boolean tVe = false;

    public final void a(a aVar, Bundle bundle) {
        AppMethodBeat.i(51472);
        this.gHr = bundle.getString("key_pay_passwd");
        this.tVe = bundle.getBoolean("key_fp_lock_offline_mode");
        ab.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo prepare pwd: %s, isOfflineMode: %b", this.gHr, Boolean.valueOf(this.tVe));
        this.tVc = aVar;
        this.isCancelled = false;
        g.tWY.tWZ = null;
        g.tWY.tXa = null;
        com.tencent.mm.kernel.g.Rg().a(1967, (f) this);
        com.tencent.mm.kernel.g.Rg().a(1548, (f) this);
        if (this.tVe) {
            g.tWY.tWZ = String.valueOf(System.currentTimeMillis());
            nw(false);
            AppMethodBeat.o(51472);
            return;
        }
        final SharedPreferences doB = ah.doB();
        if (doB == null) {
            if (this.tVc != null) {
                this.tVc.aC(2, "system error");
            }
            AppMethodBeat.o(51472);
            return;
        }
        String string = doB.getString("cpu_id", null);
        String string2 = doB.getString("uid", null);
        ab.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo cpuId: %s, uid: %s", string, string2);
        if (bo.isNullOrNil(string) || bo.isNullOrNil(string2)) {
            b.a(true, true, new com.tencent.mm.plugin.soter.d.g() {
                public final void aC(int i, String str) {
                    AppMethodBeat.i(51471);
                    if (c.this.isCancelled) {
                        AppMethodBeat.o(51471);
                    } else if (i == 0) {
                        c.gP(doB.getString("cpu_id", null), doB.getString("uid", null));
                        AppMethodBeat.o(51471);
                    } else {
                        if (c.this.tVc != null) {
                            c.this.tVc.aC(2, "init soter failed");
                        }
                        AppMethodBeat.o(51471);
                    }
                }
            });
            AppMethodBeat.o(51472);
            return;
        }
        gP(string, string2);
        AppMethodBeat.o(51472);
    }

    private void nw(boolean z) {
        AppMethodBeat.i(51473);
        ab.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo prepareAuthKey isNeedChangeAuthKey: %b", Boolean.valueOf(z));
        com.tencent.soter.a.a.a(new com.tencent.soter.a.b.b<com.tencent.soter.a.b.c>() {
            public final /* synthetic */ void a(e eVar) {
                AppMethodBeat.i(51470);
                com.tencent.soter.a.b.c cVar = (com.tencent.soter.a.b.c) eVar;
                ab.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo prepareAuthKey onResult errCode: %d, errMsg: %s, isCancelled: %b", Integer.valueOf(cVar.errCode), cVar.aIm, Boolean.valueOf(c.this.isCancelled));
                if (!c.this.isCancelled) {
                    if (cVar.isSuccess()) {
                        ab.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo update wallet lock auth key success");
                        if (c.this.tVc != null) {
                            c.this.tVc.aC(0, "prepare auth key ok");
                            AppMethodBeat.o(51470);
                            return;
                        }
                    }
                    ab.e("MicroMsg.FingerprintLockOpenDelegate", "alvinluo error when prepare auth key");
                    h.gm(2, cVar.errCode);
                    if (c.this.tVc != null) {
                        c.this.tVc.aC(2, cVar.aIm);
                    }
                }
                AppMethodBeat.o(51470);
            }
        }, z, 3, this.tVe ? null : new g(this.gHr), new com.tencent.mm.plugin.soter.b.f());
        AppMethodBeat.o(51473);
    }

    static void gP(String str, String str2) {
        AppMethodBeat.i(51474);
        com.tencent.mm.kernel.g.Rg().a(new e(str, str2), 0);
        AppMethodBeat.o(51474);
    }

    public final void a(a aVar, String str, String str2, String str3) {
        AppMethodBeat.i(51475);
        ab.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo do open fingerprint lock");
        this.tVd = aVar;
        com.tencent.mm.kernel.g.Rg().a(new f(str2, str3, str), 0);
        AppMethodBeat.o(51475);
    }

    public final void release() {
        AppMethodBeat.i(51476);
        ab.d("MicroMsg.FingerprintLockOpenDelegate", "alvinluo release open delegate");
        this.tVc = null;
        this.tVd = null;
        this.isCancelled = true;
        com.tencent.mm.kernel.g.Rg().b(1967, (f) this);
        com.tencent.mm.kernel.g.Rg().b(1548, (f) this);
        AppMethodBeat.o(51476);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(51477);
        ab.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo fingerprint wallet lock open delegate errType: %d, errCode: %d, errMsg: %s, cgi type: %d", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(mVar.getType()));
        if (this.isCancelled) {
            AppMethodBeat.o(51477);
            return;
        }
        if (mVar instanceof e) {
            if (i == 0 && i2 == 0) {
                e eVar = (e) mVar;
                g.tWY.tWZ = eVar.msn;
                nw(eVar.tVh);
                AppMethodBeat.o(51477);
                return;
            } else if (this.tVc != null) {
                this.tVc.aC(7, "get challenge failed");
                AppMethodBeat.o(51477);
                return;
            }
        } else if (mVar instanceof f) {
            if (i == 0 && i2 == 0) {
                h.nA(true);
                if (this.tVd != null) {
                    this.tVd.aC(0, "open touch lock ok");
                    AppMethodBeat.o(51477);
                    return;
                }
            }
            h.nA(false);
            if (this.tVd != null) {
                this.tVd.aC(6, "open touch lock failed");
            }
        }
        AppMethodBeat.o(51477);
    }
}
