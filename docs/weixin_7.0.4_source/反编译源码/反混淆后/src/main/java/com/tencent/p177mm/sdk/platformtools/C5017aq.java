package com.tencent.p177mm.sdk.platformtools;

import android.os.Debug;
import android.os.Handler;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.tencent.mm.sdk.platformtools.aq */
public final class C5017aq implements Runnable {
    private static final String xzM;
    private static final String xzN;
    long cmn;
    final String eOn;
    long endTime;
    long fpi;
    final Handler handler;
    int priority;
    boolean started = false;
    final Thread thread;
    String threadName;
    long waitTime;
    final Object xxu;
    public final Runnable xzE;
    long xzF;
    final C5016a xzG;
    long xzH;
    long xzI;
    long xzJ;
    long xzK;
    float xzL = -1.0f;

    /* renamed from: com.tencent.mm.sdk.platformtools.aq$a */
    public interface C5016a {
        /* renamed from: a */
        void mo10318a(Runnable runnable, C5017aq c5017aq);

        /* renamed from: a */
        void mo10319a(Runnable runnable, Thread thread, long j, long j2, long j3, float f);
    }

    C5017aq(Thread thread, Handler handler, Runnable runnable, Object obj, C5016a c5016a) {
        AppMethodBeat.m2504i(52166);
        this.thread = thread;
        if (thread != null) {
            this.threadName = thread.getName();
            this.xzF = thread.getId();
            this.priority = thread.getPriority();
        }
        this.handler = handler;
        this.xzE = runnable;
        String name = runnable.getClass().getName();
        String obj2 = runnable.toString();
        if (!C5046bo.isNullOrNil(obj2)) {
            int indexOf = obj2.indexOf(124);
            if (indexOf > 0) {
                name = name + "_" + obj2.substring(indexOf + 1);
            }
        }
        this.eOn = name;
        this.xxu = obj;
        this.xzG = c5016a;
        this.cmn = System.currentTimeMillis();
        AppMethodBeat.m2505o(52166);
    }

    public final void run() {
        AppMethodBeat.m2504i(52167);
        new StringBuilder("/proc/self/task/").append(Process.myTid()).append("/stat");
        this.fpi = System.currentTimeMillis();
        this.xzI = Debug.threadCpuTimeNanos();
        this.waitTime = (this.fpi - this.cmn) - this.xzH;
        this.xzJ = -1;
        this.xzK = -1;
        this.started = true;
        this.xzE.run();
        this.xzJ = -1 - this.xzJ;
        this.xzK = -1 - this.xzK;
        this.endTime = System.currentTimeMillis();
        this.fpi = this.endTime - this.fpi;
        this.xzI = (Debug.threadCpuTimeNanos() - this.xzI) / 1000000;
        if (this.xzK != 0) {
            this.xzL = ((float) (100 * this.xzJ)) / ((float) this.xzK);
        }
        if (this.xzG != null) {
            this.xzG.mo10318a(this.xzE, this);
            this.xzG.mo10319a(this, this.thread, this.fpi, this.xzI, this.waitTime, this.xzL);
        }
        AppMethodBeat.m2505o(52167);
    }

    static {
        AppMethodBeat.m2504i(52169);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("taskName = %s");
        stringBuilder.append("|token = %s");
        stringBuilder.append("|handler = %s");
        stringBuilder.append("|threadName = %s");
        stringBuilder.append("|threadId = %d");
        stringBuilder.append("|priority = %d");
        stringBuilder.append("|addTime = %d");
        stringBuilder.append("|delayTime = %d");
        stringBuilder.append("|usedTime = %d");
        stringBuilder.append("|cpuTime = %d");
        stringBuilder.append("|started = %b");
        xzM = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("taskName = %s");
        stringBuilder.append(" | addTime = %s");
        stringBuilder.append(" | endTime = %s");
        stringBuilder.append(" | usedTime = %d");
        stringBuilder.append(" | cpuTime = %d");
        stringBuilder.append(" | threadCpuTime = %d");
        stringBuilder.append(" | totalCpuTime = %d");
        stringBuilder.append(" | threadCpuRate = %.1f");
        xzN = stringBuilder.toString();
        AppMethodBeat.m2505o(52169);
    }

    public final String dump(boolean z) {
        AppMethodBeat.m2504i(52168);
        String format;
        if (z) {
            format = String.format(xzM, new Object[]{this.eOn, this.xxu, this.handler, this.threadName, Long.valueOf(this.xzF), Integer.valueOf(this.priority), Long.valueOf(this.cmn), Long.valueOf(this.xzH), Long.valueOf(this.fpi), Long.valueOf(this.xzI), Boolean.valueOf(this.started)});
            AppMethodBeat.m2505o(52168);
            return format;
        }
        format = String.format(xzN, new Object[]{this.eOn, new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.cmn)), new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.endTime)), Long.valueOf(this.fpi), Long.valueOf(this.xzI), Long.valueOf(this.xzJ), Long.valueOf(this.xzK), Float.valueOf(this.xzL)});
        AppMethodBeat.m2505o(52168);
        return format;
    }
}
