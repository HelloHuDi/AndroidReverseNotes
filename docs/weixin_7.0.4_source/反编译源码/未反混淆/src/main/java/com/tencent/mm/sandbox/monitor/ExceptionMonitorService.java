package com.tencent.mm.sandbox.monitor;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelrecovery.a;
import com.tencent.mm.sandbox.c;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.service.MMService;

public class ExceptionMonitorService extends MMService {
    public static long eRt = 0;
    public static int xvo = 0;
    private static ExceptionMonitorService xvs = null;
    private long xvp = 300000;
    private ak xvq = new ak();
    private Runnable xvr = new Runnable() {
        public final void run() {
            AppMethodBeat.i(28787);
            ab.d("MicroMsg.CrashMonitorService", "stopSelf");
            ExceptionMonitorService.this.stopSelf();
            AppMethodBeat.o(28787);
        }
    };
    private long xvt;

    public ExceptionMonitorService() {
        AppMethodBeat.i(28789);
        AppMethodBeat.o(28789);
    }

    public final void onCreate() {
        AppMethodBeat.i(28790);
        super.onCreate();
        xvs = this;
        c.l(hashCode(), this);
        this.xvq.postDelayed(this.xvr, this.xvp);
        AppMethodBeat.o(28790);
    }

    public final void onStart(Intent intent, int i) {
        AppMethodBeat.i(28791);
        super.onStart(intent, i);
        o(intent);
        AppMethodBeat.o(28791);
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        AppMethodBeat.i(28792);
        o(intent);
        AppMethodBeat.o(28792);
        return 1;
    }

    public final void onDestroy() {
        AppMethodBeat.i(28793);
        super.onDestroy();
        xvs = null;
        c.m(hashCode(), this);
        this.xvq.removeCallbacks(this.xvr);
        AppMethodBeat.o(28793);
    }

    private void o(Intent intent) {
        AppMethodBeat.i(28794);
        if (intent == null) {
            AppMethodBeat.o(28794);
            return;
        }
        this.xvq.removeCallbacks(this.xvr);
        this.xvq.postDelayed(this.xvr, this.xvp);
        String action = intent.getAction();
        ab.d("MicroMsg.CrashMonitorService", "dkcrash handleCommand action:".concat(String.valueOf(action)));
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
            ab.d("MicroMsg.CrashMonitorService", "dkcrash handleCommand. action=" + action + " pid:" + intExtra + " tag=" + stringExtra + ", userName=" + stringExtra3 + ", message" + stringExtra2);
            if (bo.isNullOrNil(stringExtra2)) {
                AppMethodBeat.o(28794);
                return;
            }
            if (a.a(stringExtra3, stringExtra, new a(stringExtra3, stringExtra, bo.anT(), stringExtra2, booleanExtra)) == 0) {
                gg(ah.getContext());
            }
            dnd();
            AppMethodBeat.o(28794);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.CrashMonitorService", e, "", new Object[0]);
            AppMethodBeat.o(28794);
        }
    }

    private void dnd() {
        AppMethodBeat.i(28795);
        if (System.currentTimeMillis() - this.xvt <= 600000) {
            AppMethodBeat.o(28795);
            return;
        }
        this.xvt = System.currentTimeMillis();
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(28788);
                a.aiz();
                AppMethodBeat.o(28788);
            }
        }, "RecoveryWriteLogThread");
        AppMethodBeat.o(28795);
    }

    public final IBinder Iu() {
        return null;
    }

    public static void gg(Context context) {
        AppMethodBeat.i(28796);
        Intent intent = new Intent(context, CrashUploadAlarmReceiver.class);
        if (PendingIntent.getBroadcast(context, 0, intent, 536870912) == null) {
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 0);
            ((AlarmManager) context.getSystemService("alarm")).set(0, bo.anU() + 1800000, broadcast);
            ab.d("MicroMsg.CrashMonitorService", "dkcrash startAlarmMgr pendingIntent:%d %d", Integer.valueOf(broadcast.hashCode()), Long.valueOf(r2));
        }
        AppMethodBeat.o(28796);
    }

    public final String getTag() {
        return "MicroMsg.CrashMonitorService";
    }
}
