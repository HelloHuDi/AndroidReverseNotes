package com.tencent.p177mm.plugin.walletlock.fingerprint.p1057a;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.soter.p1301e.C22155b;
import com.tencent.p177mm.plugin.soter.p527b.C35151f;
import com.tencent.p177mm.plugin.soter.p528d.C13722g;
import com.tencent.p177mm.plugin.walletlock.fingerprint.p1057a.C43834d.C29713a;
import com.tencent.p177mm.plugin.walletlock.p1319c.C40171g;
import com.tencent.p177mm.plugin.walletlock.p1319c.C46388h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.soter.p663a.C30954a;
import com.tencent.soter.p663a.p1106b.C16164b;
import com.tencent.soter.p663a.p1106b.C16165c;
import com.tencent.soter.p663a.p1106b.C46744e;

/* renamed from: com.tencent.mm.plugin.walletlock.fingerprint.a.c */
public final class C14374c implements C1202f, C43834d {
    private String gHr = null;
    boolean isCancelled = false;
    C29713a tVc = null;
    private C29713a tVd = null;
    private boolean tVe = false;

    /* renamed from: com.tencent.mm.plugin.walletlock.fingerprint.a.c$1 */
    class C143751 implements C16164b<C16165c> {
        C143751() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo17330a(C46744e c46744e) {
            AppMethodBeat.m2504i(51470);
            C16165c c16165c = (C16165c) c46744e;
            C4990ab.m7417i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo prepareAuthKey onResult errCode: %d, errMsg: %s, isCancelled: %b", Integer.valueOf(c16165c.errCode), c16165c.aIm, Boolean.valueOf(C14374c.this.isCancelled));
            if (!C14374c.this.isCancelled) {
                if (c16165c.isSuccess()) {
                    C4990ab.m7416i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo update wallet lock auth key success");
                    if (C14374c.this.tVc != null) {
                        C14374c.this.tVc.mo26641aC(0, "prepare auth key ok");
                        AppMethodBeat.m2505o(51470);
                        return;
                    }
                }
                C4990ab.m7412e("MicroMsg.FingerprintLockOpenDelegate", "alvinluo error when prepare auth key");
                C46388h.m87251gm(2, c16165c.errCode);
                if (C14374c.this.tVc != null) {
                    C14374c.this.tVc.mo26641aC(2, c16165c.aIm);
                }
            }
            AppMethodBeat.m2505o(51470);
        }
    }

    /* renamed from: a */
    public final void mo26638a(C29713a c29713a, Bundle bundle) {
        AppMethodBeat.m2504i(51472);
        this.gHr = bundle.getString("key_pay_passwd");
        this.tVe = bundle.getBoolean("key_fp_lock_offline_mode");
        C4990ab.m7417i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo prepare pwd: %s, isOfflineMode: %b", this.gHr, Boolean.valueOf(this.tVe));
        this.tVc = c29713a;
        this.isCancelled = false;
        C40171g.tWY.tWZ = null;
        C40171g.tWY.tXa = null;
        C1720g.m3540Rg().mo14539a(1967, (C1202f) this);
        C1720g.m3540Rg().mo14539a(1548, (C1202f) this);
        if (this.tVe) {
            C40171g.tWY.tWZ = String.valueOf(System.currentTimeMillis());
            m22590nw(false);
            AppMethodBeat.m2505o(51472);
            return;
        }
        final SharedPreferences doB = C4996ah.doB();
        if (doB == null) {
            if (this.tVc != null) {
                this.tVc.mo26641aC(2, "system error");
            }
            AppMethodBeat.m2505o(51472);
            return;
        }
        String string = doB.getString("cpu_id", null);
        String string2 = doB.getString("uid", null);
        C4990ab.m7417i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo cpuId: %s, uid: %s", string, string2);
        if (C5046bo.isNullOrNil(string) || C5046bo.isNullOrNil(string2)) {
            C22155b.m33780a(true, true, new C13722g() {
                /* renamed from: aC */
                public final void mo25925aC(int i, String str) {
                    AppMethodBeat.m2504i(51471);
                    if (C14374c.this.isCancelled) {
                        AppMethodBeat.m2505o(51471);
                    } else if (i == 0) {
                        C14374c.m22589gP(doB.getString("cpu_id", null), doB.getString("uid", null));
                        AppMethodBeat.m2505o(51471);
                    } else {
                        if (C14374c.this.tVc != null) {
                            C14374c.this.tVc.mo26641aC(2, "init soter failed");
                        }
                        AppMethodBeat.m2505o(51471);
                    }
                }
            });
            AppMethodBeat.m2505o(51472);
            return;
        }
        C14374c.m22589gP(string, string2);
        AppMethodBeat.m2505o(51472);
    }

    /* renamed from: nw */
    private void m22590nw(boolean z) {
        AppMethodBeat.m2504i(51473);
        C4990ab.m7417i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo prepareAuthKey isNeedChangeAuthKey: %b", Boolean.valueOf(z));
        C30954a.m49586a(new C143751(), z, 3, this.tVe ? null : new C46390g(this.gHr), new C35151f());
        AppMethodBeat.m2505o(51473);
    }

    /* renamed from: gP */
    static void m22589gP(String str, String str2) {
        AppMethodBeat.m2504i(51474);
        C1720g.m3540Rg().mo14541a(new C46389e(str, str2), 0);
        AppMethodBeat.m2505o(51474);
    }

    /* renamed from: a */
    public final void mo26639a(C29713a c29713a, String str, String str2, String str3) {
        AppMethodBeat.m2504i(51475);
        C4990ab.m7416i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo do open fingerprint lock");
        this.tVd = c29713a;
        C1720g.m3540Rg().mo14541a(new C40173f(str2, str3, str), 0);
        AppMethodBeat.m2505o(51475);
    }

    public final void release() {
        AppMethodBeat.m2504i(51476);
        C4990ab.m7410d("MicroMsg.FingerprintLockOpenDelegate", "alvinluo release open delegate");
        this.tVc = null;
        this.tVd = null;
        this.isCancelled = true;
        C1720g.m3540Rg().mo14546b(1967, (C1202f) this);
        C1720g.m3540Rg().mo14546b(1548, (C1202f) this);
        AppMethodBeat.m2505o(51476);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(51477);
        C4990ab.m7417i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo fingerprint wallet lock open delegate errType: %d, errCode: %d, errMsg: %s, cgi type: %d", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(c1207m.getType()));
        if (this.isCancelled) {
            AppMethodBeat.m2505o(51477);
            return;
        }
        if (c1207m instanceof C46389e) {
            if (i == 0 && i2 == 0) {
                C46389e c46389e = (C46389e) c1207m;
                C40171g.tWY.tWZ = c46389e.msn;
                m22590nw(c46389e.tVh);
                AppMethodBeat.m2505o(51477);
                return;
            } else if (this.tVc != null) {
                this.tVc.mo26641aC(7, "get challenge failed");
                AppMethodBeat.m2505o(51477);
                return;
            }
        } else if (c1207m instanceof C40173f) {
            if (i == 0 && i2 == 0) {
                C46388h.m87252nA(true);
                if (this.tVd != null) {
                    this.tVd.mo26641aC(0, "open touch lock ok");
                    AppMethodBeat.m2505o(51477);
                    return;
                }
            }
            C46388h.m87252nA(false);
            if (this.tVd != null) {
                this.tVd.mo26641aC(6, "open touch lock failed");
            }
        }
        AppMethodBeat.m2505o(51477);
    }
}
