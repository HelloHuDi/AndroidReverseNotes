package com.tencent.mm.booter;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bn;

public class TrafficStatsReceiver extends BroadcastReceiver {
    private long mLastTime = -1;

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(57816);
        ab.d("MicroMsg.TrafficStats", "onRecieve");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        bn.update();
        if (this.mLastTime >= 0) {
            long j = elapsedRealtime - this.mLastTime;
            long dpx = bn.dpx() + bn.dpw();
            long dpv = bn.dpv() + bn.dpu();
            long mv = bn.mv(0) + bn.mu(0);
            long mv2 = bn.mv(0) + bn.mu(0);
            ab.i("MicroMsg.TrafficStats", "Time: %d ms, System - [Mobile: %d, Wifi: %d, Speed: %.2f], WeChat - [Mobile: %d, Wifi: %d, Speed: %.2f]", Long.valueOf(j), Long.valueOf(dpx), Long.valueOf(dpv), Double.valueOf(((double) (dpx + dpv)) / ((double) (j / 1000))), Long.valueOf(mv), Long.valueOf(mv2), Double.valueOf(((double) (mv + mv2)) / ((double) (j / 1000))));
        }
        this.mLastTime = elapsedRealtime;
        AppMethodBeat.o(57816);
    }

    public static void bu(Context context) {
        AppMethodBeat.i(57817);
        ((AlarmManager) context.getSystemService("alarm")).setRepeating(3, SystemClock.elapsedRealtime(), 300000, PendingIntent.getBroadcast(context, 1, new Intent("com.tencent.mm.TrafficStatsReceiver"), 268435456));
        ab.i("MicroMsg.TrafficStats", "Register alarm, interval: %d ms", Long.valueOf(300000));
        AppMethodBeat.o(57817);
    }

    public static void bv(Context context) {
        AppMethodBeat.i(57818);
        ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, 1, new Intent("com.tencent.mm.TrafficStatsReceiver"), 268435456));
        AppMethodBeat.o(57818);
    }
}
