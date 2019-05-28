package com.tencent.mm.plugin.appbrand.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.r.a;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.plugin.appbrand.ui.AppBrandEmbedUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandInToolsUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class AppBrandProcessSuicideLogic extends a {
    private static final AppBrandProcessSuicideLogic gQS = new AppBrandProcessSuicideLogic();
    private final AtomicInteger gQT = new AtomicInteger(0);
    private final AtomicBoolean gQU = new AtomicBoolean();

    public static class ProcessRestartTask extends MainProcessTask {
        public static final Creator<ProcessRestartTask> CREATOR = new Creator<ProcessRestartTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ProcessRestartTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(129197);
                ProcessRestartTask processRestartTask = new ProcessRestartTask();
                processRestartTask.g(parcel);
                AppMethodBeat.o(129197);
                return processRestartTask;
            }
        };
        public String eHT;
        public String gQX;

        public final void asP() {
            AppMethodBeat.i(129198);
            b.pj(this.eHT);
            h.DO(this.gQX);
            AppMethodBeat.o(129198);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(129199);
            parcel.writeString(this.eHT);
            parcel.writeString(this.gQX);
            AppMethodBeat.o(129199);
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(129200);
            this.eHT = parcel.readString();
            this.gQX = parcel.readString();
            AppMethodBeat.o(129200);
        }

        static {
            AppMethodBeat.i(129201);
            AppMethodBeat.o(129201);
        }
    }

    public static void e(Application application) {
        AppMethodBeat.i(129202);
        application.registerActivityLifecycleCallbacks(gQS);
        AppMethodBeat.o(129202);
    }

    static {
        AppMethodBeat.i(129207);
        AppMethodBeat.o(129207);
    }

    private AppBrandProcessSuicideLogic() {
        AppMethodBeat.i(129203);
        AppMethodBeat.o(129203);
    }

    public static void auG() {
        AppMethodBeat.i(138692);
        gQS.gQU.set(true);
        AppMethodBeat.o(138692);
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        AppMethodBeat.i(129204);
        this.gQU.set(false);
        this.gQT.incrementAndGet();
        AppMethodBeat.o(129204);
    }

    public final void onActivityDestroyed(Activity activity) {
        AppMethodBeat.i(129205);
        if (this.gQT.decrementAndGet() == 0) {
            final Class cls = activity.getClass();
            d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(129196);
                    AppBrandProcessSuicideLogic.a(AppBrandProcessSuicideLogic.this, cls);
                    AppMethodBeat.o(129196);
                }
            }, "CleanupWhenNoActivitiesAliveInAppBrandProcess");
        }
        AppMethodBeat.o(129205);
    }

    static /* synthetic */ void a(AppBrandProcessSuicideLogic appBrandProcessSuicideLogic, Class cls) {
        AppMethodBeat.i(129206);
        c.aLb();
        try {
            KVCommCrossProcessReceiver.cgo();
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.AppBrandProcessSuicideLogic", e, "sendKV", new Object[0]);
        }
        if (!DebuggerShell.ayT()) {
            ab.i("MicroMsg.AppBrandProcessSuicideLogic", "before suicide, dump DataCenter %s", v.Zp().toString());
            ab.i("MicroMsg.AppBrandProcessSuicideLogic", "before suicide, last activity is %s", cls.getName());
            ab.i("MicroMsg.AppBrandProcessSuicideLogic", "before suicide, mActivityRecreatingByConfigurationChanged %B", Boolean.valueOf(appBrandProcessSuicideLogic.gQU.get()));
            ab.dou();
            if (!appBrandProcessSuicideLogic.gQU.get() && appBrandProcessSuicideLogic.gQT.get() <= 0) {
                if (AppBrandUI.class.isAssignableFrom(cls)) {
                    if (!AppBrandInToolsUI.class.isAssignableFrom(cls)) {
                        MainProcessTask processRestartTask = new ProcessRestartTask();
                        processRestartTask.eHT = ah.getProcessName();
                        if (AppBrandEmbedUI.class.isAssignableFrom(cls)) {
                            processRestartTask.gQX = AppBrandUI.class.getName();
                        } else {
                            processRestartTask.gQX = cls.getName();
                        }
                        AppBrandMainProcessService.b(processRestartTask);
                    }
                }
                System.exit(0);
            }
        }
        AppMethodBeat.o(129206);
    }
}
