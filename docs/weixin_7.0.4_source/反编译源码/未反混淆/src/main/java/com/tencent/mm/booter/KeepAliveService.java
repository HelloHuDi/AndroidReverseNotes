package com.tencent.mm.booter;

import android.app.job.JobInfo.Builder;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.network.aa;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public class KeepAliveService extends JobService {
    public static long ebQ;

    static {
        AppMethodBeat.i(57765);
        if (d.iW(23)) {
            ebQ = 590000;
            AppMethodBeat.o(57765);
            return;
        }
        ebQ = 50000;
        AppMethodBeat.o(57765);
    }

    public boolean onStartJob(final JobParameters jobParameters) {
        AppMethodBeat.i(57762);
        ab.i("MicroMsg.KeepAliveService", "onStartJob()");
        if (aa.ano() == null) {
            ab.i("MicroMsg.KeepAliveService", "onStarJob() MMPushCore.getAutoAuth() == null");
            b.c(ah.getContext(), "jobservice", true);
        }
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(57760);
                ab.i("MicroMsg.KeepAliveService", "onStartJob() delay");
                KeepAliveService.Ik();
                try {
                    KeepAliveService.this.jobFinished(jobParameters, false);
                    AppMethodBeat.o(57760);
                } catch (Exception e) {
                    ab.e("MicroMsg.KeepAliveService", "onStartJob() jobFinished() Exception=%s", e.getMessage());
                    AppMethodBeat.o(57760);
                }
            }
        }, ebQ);
        ab.i("MicroMsg.KeepAliveService", "onReceive() delay publish PushKeepAliveEvent");
        com.tencent.mm.sdk.g.d.xDG.q(new Runnable() {
            public final void run() {
                AppMethodBeat.i(57761);
                a.xxA.a(new mw(), Looper.getMainLooper());
                ab.i("MicroMsg.KeepAliveService", "onReceive() publish PushKeepAliveEvent");
                AppMethodBeat.o(57761);
            }
        }, 60000);
        AppMethodBeat.o(57762);
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        AppMethodBeat.i(57763);
        ab.i("MicroMsg.KeepAliveService", "onStopJob()");
        AppMethodBeat.o(57763);
        return false;
    }

    public static boolean Ik() {
        AppMethodBeat.i(57764);
        if (com.tencent.mm.kernel.a.Mz().getBoolean("keepaliveserviceswitch", false)) {
            ab.i("MicroMsg.KeepAliveService", "scheduleCoreScheduleJob(), time = %d", Long.valueOf(ebQ));
            try {
                Builder builder = new Builder(1, new ComponentName(ah.getContext(), KeepAliveService.class));
                builder.setMinimumLatency(0);
                builder.setOverrideDeadline(10);
                builder.setRequiredNetworkType(1);
                builder.setRequiresDeviceIdle(false);
                builder.setRequiresCharging(false);
                ((JobScheduler) ah.getContext().getSystemService("jobscheduler")).schedule(builder.build());
            } catch (Exception e) {
                ab.e("MicroMsg.KeepAliveService", "scheduleKeepAliveJob() Exception:%s" + e.getMessage());
            }
            AppMethodBeat.o(57764);
            return true;
        }
        AppMethodBeat.o(57764);
        return false;
    }
}
