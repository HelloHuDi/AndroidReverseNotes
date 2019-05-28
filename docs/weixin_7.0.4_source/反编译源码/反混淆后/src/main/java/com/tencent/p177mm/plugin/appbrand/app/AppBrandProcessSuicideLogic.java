package com.tencent.p177mm.plugin.appbrand.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.modelappbrand.C45445b;
import com.tencent.p177mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.p328r.C27276a;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandEmbedUI;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandInToolsUI;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandUI;
import com.tencent.p177mm.plugin.appbrand.report.C19690c;
import com.tencent.p177mm.plugin.appbrand.task.C45694h;
import com.tencent.p177mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic */
public final class AppBrandProcessSuicideLogic extends C27276a {
    private static final AppBrandProcessSuicideLogic gQS = new AppBrandProcessSuicideLogic();
    private final AtomicInteger gQT = new AtomicInteger(0);
    private final AtomicBoolean gQU = new AtomicBoolean();

    /* renamed from: com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic$ProcessRestartTask */
    public static class ProcessRestartTask extends MainProcessTask {
        public static final Creator<ProcessRestartTask> CREATOR = new C20461();
        public String eHT;
        public String gQX;

        /* renamed from: com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic$ProcessRestartTask$1 */
        static class C20461 implements Creator<ProcessRestartTask> {
            C20461() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ProcessRestartTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(129197);
                ProcessRestartTask processRestartTask = new ProcessRestartTask();
                processRestartTask.mo6032g(parcel);
                AppMethodBeat.m2505o(129197);
                return processRestartTask;
            }
        }

        public final void asP() {
            AppMethodBeat.m2504i(129198);
            C45445b.m83711pj(this.eHT);
            C45694h.m84412DO(this.gQX);
            AppMethodBeat.m2505o(129198);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(129199);
            parcel.writeString(this.eHT);
            parcel.writeString(this.gQX);
            AppMethodBeat.m2505o(129199);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(129200);
            this.eHT = parcel.readString();
            this.gQX = parcel.readString();
            AppMethodBeat.m2505o(129200);
        }

        static {
            AppMethodBeat.m2504i(129201);
            AppMethodBeat.m2505o(129201);
        }
    }

    /* renamed from: e */
    public static void m29572e(Application application) {
        AppMethodBeat.m2504i(129202);
        application.registerActivityLifecycleCallbacks(gQS);
        AppMethodBeat.m2505o(129202);
    }

    static {
        AppMethodBeat.m2504i(129207);
        AppMethodBeat.m2505o(129207);
    }

    private AppBrandProcessSuicideLogic() {
        AppMethodBeat.m2504i(129203);
        AppMethodBeat.m2505o(129203);
    }

    public static void auG() {
        AppMethodBeat.m2504i(138692);
        gQS.gQU.set(true);
        AppMethodBeat.m2505o(138692);
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(129204);
        this.gQU.set(false);
        this.gQT.incrementAndGet();
        AppMethodBeat.m2505o(129204);
    }

    public final void onActivityDestroyed(Activity activity) {
        AppMethodBeat.m2504i(129205);
        if (this.gQT.decrementAndGet() == 0) {
            final Class cls = activity.getClass();
            C7305d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(129196);
                    AppBrandProcessSuicideLogic.m29571a(AppBrandProcessSuicideLogic.this, cls);
                    AppMethodBeat.m2505o(129196);
                }
            }, "CleanupWhenNoActivitiesAliveInAppBrandProcess");
        }
        AppMethodBeat.m2505o(129205);
    }

    /* renamed from: a */
    static /* synthetic */ void m29571a(AppBrandProcessSuicideLogic appBrandProcessSuicideLogic, Class cls) {
        AppMethodBeat.m2504i(129206);
        C19690c.aLb();
        try {
            KVCommCrossProcessReceiver.cgo();
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandProcessSuicideLogic", e, "sendKV", new Object[0]);
        }
        if (!DebuggerShell.ayT()) {
            C4990ab.m7417i("MicroMsg.AppBrandProcessSuicideLogic", "before suicide, dump DataCenter %s", C37922v.m64076Zp().toString());
            C4990ab.m7417i("MicroMsg.AppBrandProcessSuicideLogic", "before suicide, last activity is %s", cls.getName());
            C4990ab.m7417i("MicroMsg.AppBrandProcessSuicideLogic", "before suicide, mActivityRecreatingByConfigurationChanged %B", Boolean.valueOf(appBrandProcessSuicideLogic.gQU.get()));
            C4990ab.dou();
            if (!appBrandProcessSuicideLogic.gQU.get() && appBrandProcessSuicideLogic.gQT.get() <= 0) {
                if (AppBrandUI.class.isAssignableFrom(cls)) {
                    if (!AppBrandInToolsUI.class.isAssignableFrom(cls)) {
                        MainProcessTask processRestartTask = new ProcessRestartTask();
                        processRestartTask.eHT = C4996ah.getProcessName();
                        if (AppBrandEmbedUI.class.isAssignableFrom(cls)) {
                            processRestartTask.gQX = AppBrandUI.class.getName();
                        } else {
                            processRestartTask.gQX = cls.getName();
                        }
                        AppBrandMainProcessService.m54355b(processRestartTask);
                    }
                }
                System.exit(0);
            }
        }
        AppMethodBeat.m2505o(129206);
    }
}
