package com.tencent.mm.sandbox.updater;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;

final class f {
    private static long xwt = 125829120;
    private static long xwu = 314572800;
    ap che = new ap(new a() {
        public final boolean BI() {
            AppMethodBeat.i(28899);
            f.a(f.this, true);
            AppMethodBeat.o(28899);
            return true;
        }
    }, true);
    private boolean initialized = false;
    boolean mgU = false;
    private long xwv = 0;
    private long xww = 0;
    private String xwx = null;
    private j xwy;

    /* renamed from: com.tencent.mm.sandbox.updater.f$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ long xwB;

        AnonymousClass3(long j) {
            this.xwB = j;
        }

        public final void run() {
            AppMethodBeat.i(28901);
            ab.d("MicroMsg.TrafficStatistic", "onDownstreamTraffic downstream : %s", Long.valueOf(this.xwB));
            f.this.xww = f.this.xww + Math.max(0, this.xwB);
            f.a(f.this, false);
            AppMethodBeat.o(28901);
        }
    }

    /* renamed from: com.tencent.mm.sandbox.updater.f$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ long xwA;

        AnonymousClass2(long j) {
            this.xwA = j;
        }

        public final void run() {
            AppMethodBeat.i(28900);
            ab.d("MicroMsg.TrafficStatistic", "onUpstreamTraffic upstream : %s", Long.valueOf(this.xwA));
            f.this.xwv = f.this.xwv + Math.max(0, this.xwA);
            f.a(f.this, false);
            AppMethodBeat.o(28900);
        }
    }

    public f(j jVar) {
        AppMethodBeat.i(28902);
        this.xwy = jVar;
        AppMethodBeat.o(28902);
    }

    public final void ee(String str, int i) {
        AppMethodBeat.i(28903);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(28903);
            return;
        }
        if (!str.equals(this.xwx)) {
            stop();
        }
        ab.i("MicroMsg.TrafficStatistic", "pack size: ".concat(String.valueOf(i)));
        ab.i("MicroMsg.TrafficStatistic", "TRAFFIC_ALERT_LINE before : %s", Long.valueOf(xwt));
        xwt = Math.max((long) (i * 4), xwt);
        xwt = Math.min(xwu, xwt);
        ab.i("MicroMsg.TrafficStatistic", "TRAFFIC_ALERT_LINE after : %s", Long.valueOf(xwt));
        if (!this.initialized) {
            if (this.xwy.mContext != null) {
                this.mgU = at.isWifi(this.xwy.mContext);
            }
            this.che.ae(30000, 30000);
            this.initialized = true;
            this.xwx = str;
        }
        AppMethodBeat.o(28903);
    }

    public final void stop() {
        AppMethodBeat.i(28904);
        pd(true);
        this.che.stopTimer();
        this.initialized = false;
        AppMethodBeat.o(28904);
    }

    private void dnq() {
        AppMethodBeat.i(28905);
        if (this.xwv + this.xww > 0) {
            Intent intent = new Intent();
            intent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
            intent.putExtra("intent_extra_flow_stat_upstream", this.xwv);
            intent.putExtra("intent_extra_flow_stat_downstream", this.xww);
            if (this.xwy.mContext != null) {
                this.mgU = at.isWifi(this.xwy.mContext);
            }
            intent.putExtra("intent_extra_flow_stat_is_wifi", this.mgU);
            if (this.xwy.mContext != null) {
                this.xwy.mContext.sendBroadcast(intent, WXApp.WXAPP_BROADCAST_PERMISSION);
            }
        }
        AppMethodBeat.o(28905);
    }

    /* Access modifiers changed, original: final */
    public final void pd(boolean z) {
        AppMethodBeat.i(28906);
        if ((z || this.xwv + this.xww >= i.ACTION_MINI_PROGRAM_LAUNCH) && dnr() >= xwt && this.xwy.rlf == 2) {
            ab.e("MicroMsg.TrafficStatistic", "checkIfTrafficAlert reach traffic alert line!");
            this.xwy.cancel();
        }
        AppMethodBeat.o(28906);
    }

    public static boolean amb(String str) {
        AppMethodBeat.i(28907);
        if (i.amd(str) > xwt) {
            ab.e("MicroMsg.TrafficStatistic", "overTrafficAlertLine reach traffic alert line!");
            AppMethodBeat.o(28907);
            return true;
        }
        AppMethodBeat.o(28907);
        return false;
    }

    private long dnr() {
        AppMethodBeat.i(28908);
        dnq();
        if (bo.isNullOrNil(this.xwx)) {
            ab.e("MicroMsg.TrafficStatistic", "traffic is null!");
            AppMethodBeat.o(28908);
            return 0;
        }
        long y = i.y(this.xwx, this.xwv, this.xww);
        this.xwv = 0;
        this.xww = 0;
        AppMethodBeat.o(28908);
        return y;
    }
}
