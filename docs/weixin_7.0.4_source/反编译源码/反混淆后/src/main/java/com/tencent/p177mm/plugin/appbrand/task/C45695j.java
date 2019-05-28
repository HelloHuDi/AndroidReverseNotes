package com.tencent.p177mm.plugin.appbrand.task;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.LinkedHashMap;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.task.j */
class C45695j {
    final String iFq;
    final Class<? extends Activity> iFr;
    private final Class iFs;
    final LinkedHashMap<String, Integer> iFt = new LinkedHashMap();
    final LinkedHashMap<String, AppBrandRemoteTaskController> iFu = new LinkedHashMap();
    C38519g iFv = C38519g.NIL;
    final Class ifs;

    C45695j(Class<? extends Activity> cls, Class cls2, Class cls3) {
        AppMethodBeat.m2504i(132874);
        this.iFq = cls.getName();
        this.iFr = cls;
        this.iFs = cls2;
        this.ifs = cls3;
        AppMethodBeat.m2505o(132874);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: f */
    public final void mo73491f(C38519g c38519g) {
        AppMethodBeat.m2504i(132875);
        if (mo6386a(c38519g)) {
            this.iFv = c38519g;
            AppMethodBeat.m2505o(132875);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("AppBrandUITask not support this type. [" + c38519g.name() + "]");
        AppMethodBeat.m2505o(132875);
        throw illegalStateException;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public boolean mo6386a(C38519g c38519g) {
        return true;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: Dw */
    public final void mo73489Dw() {
        AppMethodBeat.m2504i(132876);
        if (this.iFs == null) {
            AppMethodBeat.m2505o(132876);
            return;
        }
        try {
            Intent intent = new Intent();
            AppBrandPreloadProfiler appBrandPreloadProfiler = new AppBrandPreloadProfiler();
            appBrandPreloadProfiler.aLK();
            intent.putExtra("preloadProfiler", appBrandPreloadProfiler);
            intent.setClass(C4996ah.getContext(), this.iFs);
            this.iFv.mo61248G(intent);
            C4996ah.getContext().sendBroadcast(intent);
            AppMethodBeat.m2505o(132876);
        } catch (Exception e) {
            AppMethodBeat.m2505o(132876);
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo73490a(String str, int i, AppBrandRemoteTaskController appBrandRemoteTaskController) {
        AppMethodBeat.m2504i(132877);
        this.iFt.put(str, Integer.valueOf(i));
        this.iFu.put(str, appBrandRemoteTaskController);
        AppMethodBeat.m2505o(132877);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: DI */
    public void mo73486DI(String str) {
        AppMethodBeat.m2504i(132878);
        this.iFt.remove(str);
        this.iFu.remove(str);
        if (this.iFt.isEmpty()) {
            this.iFv = C38519g.NIL;
        }
        AppMethodBeat.m2505o(132878);
    }

    /* Access modifiers changed, original: 0000 */
    public void aLJ() {
        AppMethodBeat.m2504i(132879);
        if (this.iFt.isEmpty()) {
            ActivityManager activityManager = (ActivityManager) C4996ah.getContext().getSystemService("activity");
            PackageManager packageManager = C4996ah.getContext().getPackageManager();
            if (activityManager == null || packageManager == null) {
                AppMethodBeat.m2505o(132879);
                return;
            }
            try {
                String str = packageManager.getActivityInfo(new ComponentName(C4996ah.getContext(), this.iFr), 128).processName;
                List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses == null) {
                    AppMethodBeat.m2505o(132879);
                    return;
                }
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.processName.equals(str)) {
                        try {
                            Process.killProcess(runningAppProcessInfo.pid);
                            AppMethodBeat.m2505o(132879);
                            return;
                        } catch (Exception e) {
                            AppMethodBeat.m2505o(132879);
                            return;
                        }
                    }
                }
                AppMethodBeat.m2505o(132879);
                return;
            } catch (Exception e2) {
                AppMethodBeat.m2505o(132879);
                return;
            }
        }
        AppMethodBeat.m2505o(132879);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: DT */
    public final Integer mo73487DT(String str) {
        AppMethodBeat.m2504i(132880);
        Integer num = (Integer) this.iFt.get(str);
        AppMethodBeat.m2505o(132880);
        return num;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: DU */
    public final AppBrandRemoteTaskController mo73488DU(String str) {
        AppMethodBeat.m2504i(132881);
        AppBrandRemoteTaskController appBrandRemoteTaskController = (AppBrandRemoteTaskController) this.iFu.get(str);
        AppMethodBeat.m2505o(132881);
        return appBrandRemoteTaskController;
    }
}
