package com.tencent.p177mm.sandbox.updater;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;

/* renamed from: com.tencent.mm.sandbox.updater.f */
final class C23488f {
    private static long xwt = 125829120;
    private static long xwu = 314572800;
    C7564ap che = new C7564ap(new C234891(), true);
    private boolean initialized = false;
    boolean mgU = false;
    private long xwv = 0;
    private long xww = 0;
    private String xwx = null;
    private C44215j xwy;

    /* renamed from: com.tencent.mm.sandbox.updater.f$3 */
    class C154173 implements Runnable {
        final /* synthetic */ long xwB;

        C154173(long j) {
            this.xwB = j;
        }

        public final void run() {
            AppMethodBeat.m2504i(28901);
            C4990ab.m7411d("MicroMsg.TrafficStatistic", "onDownstreamTraffic downstream : %s", Long.valueOf(this.xwB));
            C23488f.this.xww = C23488f.this.xww + Math.max(0, this.xwB);
            C23488f.m36320a(C23488f.this, false);
            AppMethodBeat.m2505o(28901);
        }
    }

    /* renamed from: com.tencent.mm.sandbox.updater.f$1 */
    class C234891 implements C5015a {
        C234891() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(28899);
            C23488f.m36320a(C23488f.this, true);
            AppMethodBeat.m2505o(28899);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.sandbox.updater.f$2 */
    class C234902 implements Runnable {
        final /* synthetic */ long xwA;

        C234902(long j) {
            this.xwA = j;
        }

        public final void run() {
            AppMethodBeat.m2504i(28900);
            C4990ab.m7411d("MicroMsg.TrafficStatistic", "onUpstreamTraffic upstream : %s", Long.valueOf(this.xwA));
            C23488f.this.xwv = C23488f.this.xwv + Math.max(0, this.xwA);
            C23488f.m36320a(C23488f.this, false);
            AppMethodBeat.m2505o(28900);
        }
    }

    public C23488f(C44215j c44215j) {
        AppMethodBeat.m2504i(28902);
        this.xwy = c44215j;
        AppMethodBeat.m2505o(28902);
    }

    /* renamed from: ee */
    public final void mo39144ee(String str, int i) {
        AppMethodBeat.m2504i(28903);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(28903);
            return;
        }
        if (!str.equals(this.xwx)) {
            stop();
        }
        C4990ab.m7416i("MicroMsg.TrafficStatistic", "pack size: ".concat(String.valueOf(i)));
        C4990ab.m7417i("MicroMsg.TrafficStatistic", "TRAFFIC_ALERT_LINE before : %s", Long.valueOf(xwt));
        xwt = Math.max((long) (i * 4), xwt);
        xwt = Math.min(xwu, xwt);
        C4990ab.m7417i("MicroMsg.TrafficStatistic", "TRAFFIC_ALERT_LINE after : %s", Long.valueOf(xwt));
        if (!this.initialized) {
            if (this.xwy.mContext != null) {
                this.mgU = C5023at.isWifi(this.xwy.mContext);
            }
            this.che.mo16770ae(30000, 30000);
            this.initialized = true;
            this.xwx = str;
        }
        AppMethodBeat.m2505o(28903);
    }

    public final void stop() {
        AppMethodBeat.m2504i(28904);
        mo39145pd(true);
        this.che.stopTimer();
        this.initialized = false;
        AppMethodBeat.m2505o(28904);
    }

    private void dnq() {
        AppMethodBeat.m2504i(28905);
        if (this.xwv + this.xww > 0) {
            Intent intent = new Intent();
            intent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
            intent.putExtra("intent_extra_flow_stat_upstream", this.xwv);
            intent.putExtra("intent_extra_flow_stat_downstream", this.xww);
            if (this.xwy.mContext != null) {
                this.mgU = C5023at.isWifi(this.xwy.mContext);
            }
            intent.putExtra("intent_extra_flow_stat_is_wifi", this.mgU);
            if (this.xwy.mContext != null) {
                this.xwy.mContext.sendBroadcast(intent, WXApp.WXAPP_BROADCAST_PERMISSION);
            }
        }
        AppMethodBeat.m2505o(28905);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: pd */
    public final void mo39145pd(boolean z) {
        AppMethodBeat.m2504i(28906);
        if ((z || this.xwv + this.xww >= C1625i.ACTION_MINI_PROGRAM_LAUNCH) && dnr() >= xwt && this.xwy.rlf == 2) {
            C4990ab.m7412e("MicroMsg.TrafficStatistic", "checkIfTrafficAlert reach traffic alert line!");
            this.xwy.cancel();
        }
        AppMethodBeat.m2505o(28906);
    }

    public static boolean amb(String str) {
        AppMethodBeat.m2504i(28907);
        if (C44212i.amd(str) > xwt) {
            C4990ab.m7412e("MicroMsg.TrafficStatistic", "overTrafficAlertLine reach traffic alert line!");
            AppMethodBeat.m2505o(28907);
            return true;
        }
        AppMethodBeat.m2505o(28907);
        return false;
    }

    private long dnr() {
        AppMethodBeat.m2504i(28908);
        dnq();
        if (C5046bo.isNullOrNil(this.xwx)) {
            C4990ab.m7412e("MicroMsg.TrafficStatistic", "traffic is null!");
            AppMethodBeat.m2505o(28908);
            return 0;
        }
        long y = C44212i.m79791y(this.xwx, this.xwv, this.xww);
        this.xwv = 0;
        this.xww = 0;
        AppMethodBeat.m2505o(28908);
        return y;
    }
}
