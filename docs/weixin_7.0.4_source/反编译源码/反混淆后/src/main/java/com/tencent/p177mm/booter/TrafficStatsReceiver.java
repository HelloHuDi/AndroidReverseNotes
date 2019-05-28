package com.tencent.p177mm.booter;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C15427bn;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.booter.TrafficStatsReceiver */
public class TrafficStatsReceiver extends BroadcastReceiver {
    private long mLastTime = -1;

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(57816);
        C4990ab.m7410d("MicroMsg.TrafficStats", "onRecieve");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        C15427bn.update();
        if (this.mLastTime >= 0) {
            long j = elapsedRealtime - this.mLastTime;
            long dpx = C15427bn.dpx() + C15427bn.dpw();
            long dpv = C15427bn.dpv() + C15427bn.dpu();
            long mv = C15427bn.m23707mv(0) + C15427bn.m23706mu(0);
            long mv2 = C15427bn.m23707mv(0) + C15427bn.m23706mu(0);
            C4990ab.m7417i("MicroMsg.TrafficStats", "Time: %d ms, System - [Mobile: %d, Wifi: %d, Speed: %.2f], WeChat - [Mobile: %d, Wifi: %d, Speed: %.2f]", Long.valueOf(j), Long.valueOf(dpx), Long.valueOf(dpv), Double.valueOf(((double) (dpx + dpv)) / ((double) (j / 1000))), Long.valueOf(mv), Long.valueOf(mv2), Double.valueOf(((double) (mv + mv2)) / ((double) (j / 1000))));
        }
        this.mLastTime = elapsedRealtime;
        AppMethodBeat.m2505o(57816);
    }

    /* renamed from: bu */
    public static void m16683bu(Context context) {
        AppMethodBeat.m2504i(57817);
        ((AlarmManager) context.getSystemService("alarm")).setRepeating(3, SystemClock.elapsedRealtime(), 300000, PendingIntent.getBroadcast(context, 1, new Intent("com.tencent.mm.TrafficStatsReceiver"), 268435456));
        C4990ab.m7417i("MicroMsg.TrafficStats", "Register alarm, interval: %d ms", Long.valueOf(300000));
        AppMethodBeat.m2505o(57817);
    }

    /* renamed from: bv */
    public static void m16684bv(Context context) {
        AppMethodBeat.m2504i(57818);
        ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, 1, new Intent("com.tencent.mm.TrafficStatsReceiver"), 268435456));
        AppMethodBeat.m2505o(57818);
    }
}
