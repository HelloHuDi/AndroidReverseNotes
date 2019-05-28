package com.tencent.p177mm.sandbox.monitor;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelrecovery.C1864a;
import com.tencent.p177mm.sandbox.C15411c;
import com.tencent.p177mm.sandbox.monitor.C30273b.C30274a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.service.MMService;

/* renamed from: com.tencent.mm.sandbox.monitor.ExceptionMonitorService */
public class ExceptionMonitorService extends MMService {
    public static long eRt = 0;
    public static int xvo = 0;
    private static ExceptionMonitorService xvs = null;
    private long xvp = 300000;
    private C7306ak xvq = new C7306ak();
    private Runnable xvr = new C359761();
    private long xvt;

    /* renamed from: com.tencent.mm.sandbox.monitor.ExceptionMonitorService$2 */
    class C359752 implements Runnable {
        C359752() {
        }

        public final void run() {
            AppMethodBeat.m2504i(28788);
            C1864a.aiz();
            AppMethodBeat.m2505o(28788);
        }
    }

    /* renamed from: com.tencent.mm.sandbox.monitor.ExceptionMonitorService$1 */
    class C359761 implements Runnable {
        C359761() {
        }

        public final void run() {
            AppMethodBeat.m2504i(28787);
            C4990ab.m7410d("MicroMsg.CrashMonitorService", "stopSelf");
            ExceptionMonitorService.this.stopSelf();
            AppMethodBeat.m2505o(28787);
        }
    }

    public ExceptionMonitorService() {
        AppMethodBeat.m2504i(28789);
        AppMethodBeat.m2505o(28789);
    }

    public final void onCreate() {
        AppMethodBeat.m2504i(28790);
        super.onCreate();
        xvs = this;
        C15411c.m23691l(hashCode(), this);
        this.xvq.postDelayed(this.xvr, this.xvp);
        AppMethodBeat.m2505o(28790);
    }

    public final void onStart(Intent intent, int i) {
        AppMethodBeat.m2504i(28791);
        super.onStart(intent, i);
        m59183o(intent);
        AppMethodBeat.m2505o(28791);
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        AppMethodBeat.m2504i(28792);
        m59183o(intent);
        AppMethodBeat.m2505o(28792);
        return 1;
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(28793);
        super.onDestroy();
        xvs = null;
        C15411c.m23692m(hashCode(), this);
        this.xvq.removeCallbacks(this.xvr);
        AppMethodBeat.m2505o(28793);
    }

    /* renamed from: o */
    private void m59183o(Intent intent) {
        AppMethodBeat.m2504i(28794);
        if (intent == null) {
            AppMethodBeat.m2505o(28794);
            return;
        }
        this.xvq.removeCallbacks(this.xvr);
        this.xvq.postDelayed(this.xvr, this.xvp);
        String action = intent.getAction();
        C4990ab.m7410d("MicroMsg.CrashMonitorService", "dkcrash handleCommand action:".concat(String.valueOf(action)));
        try {
            String stringExtra = intent.getStringExtra("tag");
            if (stringExtra == null) {
                stringExtra = "exception";
            }
            int intExtra = intent.getIntExtra("exceptionPid", 0);
            stringExtra.equals("exception");
            xvo = intExtra;
            eRt = intent.getLongExtra("exceptionTime", SystemClock.elapsedRealtime());
            String stringExtra2 = intent.getStringExtra("exceptionMsg");
            String stringExtra3 = intent.getStringExtra("userName");
            boolean booleanExtra = intent.getBooleanExtra("exceptionWriteSdcard", true);
            C4990ab.m7410d("MicroMsg.CrashMonitorService", "dkcrash handleCommand. action=" + action + " pid:" + intExtra + " tag=" + stringExtra + ", userName=" + stringExtra3 + ", message" + stringExtra2);
            if (C5046bo.isNullOrNil(stringExtra2)) {
                AppMethodBeat.m2505o(28794);
                return;
            }
            if (C30270a.m48149a(stringExtra3, stringExtra, new C30274a(stringExtra3, stringExtra, C5046bo.anT(), stringExtra2, booleanExtra)) == 0) {
                ExceptionMonitorService.m59182gg(C4996ah.getContext());
            }
            dnd();
            AppMethodBeat.m2505o(28794);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.CrashMonitorService", e, "", new Object[0]);
            AppMethodBeat.m2505o(28794);
        }
    }

    private void dnd() {
        AppMethodBeat.m2504i(28795);
        if (System.currentTimeMillis() - this.xvt <= 600000) {
            AppMethodBeat.m2505o(28795);
            return;
        }
        this.xvt = System.currentTimeMillis();
        C7305d.post(new C359752(), "RecoveryWriteLogThread");
        AppMethodBeat.m2505o(28795);
    }

    /* renamed from: Iu */
    public final IBinder mo10421Iu() {
        return null;
    }

    /* renamed from: gg */
    public static void m59182gg(Context context) {
        AppMethodBeat.m2504i(28796);
        Intent intent = new Intent(context, CrashUploadAlarmReceiver.class);
        if (PendingIntent.getBroadcast(context, 0, intent, 536870912) == null) {
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 0);
            ((AlarmManager) context.getSystemService("alarm")).set(0, C5046bo.anU() + 1800000, broadcast);
            C4990ab.m7411d("MicroMsg.CrashMonitorService", "dkcrash startAlarmMgr pendingIntent:%d %d", Integer.valueOf(broadcast.hashCode()), Long.valueOf(r2));
        }
        AppMethodBeat.m2505o(28796);
    }

    public final String getTag() {
        return "MicroMsg.CrashMonitorService";
    }
}
