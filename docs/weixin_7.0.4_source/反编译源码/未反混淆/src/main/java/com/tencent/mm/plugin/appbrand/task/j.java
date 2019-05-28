package com.tencent.mm.plugin.appbrand.task;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.LinkedHashMap;
import java.util.List;

class j {
    final String iFq;
    final Class<? extends Activity> iFr;
    private final Class iFs;
    final LinkedHashMap<String, Integer> iFt = new LinkedHashMap();
    final LinkedHashMap<String, AppBrandRemoteTaskController> iFu = new LinkedHashMap();
    g iFv = g.NIL;
    final Class ifs;

    j(Class<? extends Activity> cls, Class cls2, Class cls3) {
        AppMethodBeat.i(132874);
        this.iFq = cls.getName();
        this.iFr = cls;
        this.iFs = cls2;
        this.ifs = cls3;
        AppMethodBeat.o(132874);
    }

    /* Access modifiers changed, original: final */
    public final void f(g gVar) {
        AppMethodBeat.i(132875);
        if (a(gVar)) {
            this.iFv = gVar;
            AppMethodBeat.o(132875);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("AppBrandUITask not support this type. [" + gVar.name() + "]");
        AppMethodBeat.o(132875);
        throw illegalStateException;
    }

    /* Access modifiers changed, original: protected */
    public boolean a(g gVar) {
        return true;
    }

    /* Access modifiers changed, original: final */
    public final void Dw() {
        AppMethodBeat.i(132876);
        if (this.iFs == null) {
            AppMethodBeat.o(132876);
            return;
        }
        try {
            Intent intent = new Intent();
            AppBrandPreloadProfiler appBrandPreloadProfiler = new AppBrandPreloadProfiler();
            appBrandPreloadProfiler.aLK();
            intent.putExtra("preloadProfiler", appBrandPreloadProfiler);
            intent.setClass(ah.getContext(), this.iFs);
            this.iFv.G(intent);
            ah.getContext().sendBroadcast(intent);
            AppMethodBeat.o(132876);
        } catch (Exception e) {
            AppMethodBeat.o(132876);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void a(String str, int i, AppBrandRemoteTaskController appBrandRemoteTaskController) {
        AppMethodBeat.i(132877);
        this.iFt.put(str, Integer.valueOf(i));
        this.iFu.put(str, appBrandRemoteTaskController);
        AppMethodBeat.o(132877);
    }

    /* Access modifiers changed, original: 0000 */
    public void DI(String str) {
        AppMethodBeat.i(132878);
        this.iFt.remove(str);
        this.iFu.remove(str);
        if (this.iFt.isEmpty()) {
            this.iFv = g.NIL;
        }
        AppMethodBeat.o(132878);
    }

    /* Access modifiers changed, original: 0000 */
    public void aLJ() {
        AppMethodBeat.i(132879);
        if (this.iFt.isEmpty()) {
            ActivityManager activityManager = (ActivityManager) ah.getContext().getSystemService("activity");
            PackageManager packageManager = ah.getContext().getPackageManager();
            if (activityManager == null || packageManager == null) {
                AppMethodBeat.o(132879);
                return;
            }
            try {
                String str = packageManager.getActivityInfo(new ComponentName(ah.getContext(), this.iFr), 128).processName;
                List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses == null) {
                    AppMethodBeat.o(132879);
                    return;
                }
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.processName.equals(str)) {
                        try {
                            Process.killProcess(runningAppProcessInfo.pid);
                            AppMethodBeat.o(132879);
                            return;
                        } catch (Exception e) {
                            AppMethodBeat.o(132879);
                            return;
                        }
                    }
                }
                AppMethodBeat.o(132879);
                return;
            } catch (Exception e2) {
                AppMethodBeat.o(132879);
                return;
            }
        }
        AppMethodBeat.o(132879);
    }

    /* Access modifiers changed, original: final */
    public final Integer DT(String str) {
        AppMethodBeat.i(132880);
        Integer num = (Integer) this.iFt.get(str);
        AppMethodBeat.o(132880);
        return num;
    }

    /* Access modifiers changed, original: final */
    public final AppBrandRemoteTaskController DU(String str) {
        AppMethodBeat.i(132881);
        AppBrandRemoteTaskController appBrandRemoteTaskController = (AppBrandRemoteTaskController) this.iFu.get(str);
        AppMethodBeat.o(132881);
        return appBrandRemoteTaskController;
    }
}
