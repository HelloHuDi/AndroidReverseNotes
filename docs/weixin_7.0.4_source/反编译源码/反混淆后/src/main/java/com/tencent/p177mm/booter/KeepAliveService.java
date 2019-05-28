package com.tencent.p177mm.booter;

import android.app.job.JobInfo.Builder;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.network.C1892aa;
import com.tencent.p177mm.p230g.p231a.C18335mw;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.booter.KeepAliveService */
public class KeepAliveService extends JobService {
    public static long ebQ;

    /* renamed from: com.tencent.mm.booter.KeepAliveService$2 */
    class C259682 implements Runnable {
        C259682() {
        }

        public final void run() {
            AppMethodBeat.m2504i(57761);
            C4879a.xxA.mo10048a(new C18335mw(), Looper.getMainLooper());
            C4990ab.m7416i("MicroMsg.KeepAliveService", "onReceive() publish PushKeepAliveEvent");
            AppMethodBeat.m2505o(57761);
        }
    }

    static {
        AppMethodBeat.m2504i(57765);
        if (C1443d.m3068iW(23)) {
            ebQ = 590000;
            AppMethodBeat.m2505o(57765);
            return;
        }
        ebQ = 50000;
        AppMethodBeat.m2505o(57765);
    }

    public boolean onStartJob(final JobParameters jobParameters) {
        AppMethodBeat.m2504i(57762);
        C4990ab.m7416i("MicroMsg.KeepAliveService", "onStartJob()");
        if (C1892aa.ano() == null) {
            C4990ab.m7416i("MicroMsg.KeepAliveService", "onStarJob() MMPushCore.getAutoAuth() == null");
            C1324b.m2837c(C4996ah.getContext(), "jobservice", true);
        }
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(57760);
                C4990ab.m7416i("MicroMsg.KeepAliveService", "onStartJob() delay");
                KeepAliveService.m41393Ik();
                try {
                    KeepAliveService.this.jobFinished(jobParameters, false);
                    AppMethodBeat.m2505o(57760);
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.KeepAliveService", "onStartJob() jobFinished() Exception=%s", e.getMessage());
                    AppMethodBeat.m2505o(57760);
                }
            }
        }, ebQ);
        C4990ab.m7416i("MicroMsg.KeepAliveService", "onReceive() delay publish PushKeepAliveEvent");
        C7305d.xDG.mo10160q(new C259682(), 60000);
        AppMethodBeat.m2505o(57762);
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        AppMethodBeat.m2504i(57763);
        C4990ab.m7416i("MicroMsg.KeepAliveService", "onStopJob()");
        AppMethodBeat.m2505o(57763);
        return false;
    }

    /* renamed from: Ik */
    public static boolean m41393Ik() {
        AppMethodBeat.m2504i(57764);
        if (C1668a.m3382Mz().getBoolean("keepaliveserviceswitch", false)) {
            C4990ab.m7417i("MicroMsg.KeepAliveService", "scheduleCoreScheduleJob(), time = %d", Long.valueOf(ebQ));
            try {
                Builder builder = new Builder(1, new ComponentName(C4996ah.getContext(), KeepAliveService.class));
                builder.setMinimumLatency(0);
                builder.setOverrideDeadline(10);
                builder.setRequiredNetworkType(1);
                builder.setRequiresDeviceIdle(false);
                builder.setRequiresCharging(false);
                ((JobScheduler) C4996ah.getContext().getSystemService("jobscheduler")).schedule(builder.build());
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.KeepAliveService", "scheduleKeepAliveJob() Exception:%s" + e.getMessage());
            }
            AppMethodBeat.m2505o(57764);
            return true;
        }
        AppMethodBeat.m2505o(57764);
        return false;
    }
}
