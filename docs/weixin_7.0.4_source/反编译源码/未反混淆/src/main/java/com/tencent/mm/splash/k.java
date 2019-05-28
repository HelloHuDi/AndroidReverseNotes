package com.tencent.mm.splash;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

final class k extends Instrumentation {
    public Instrumentation xHs;

    public k(Instrumentation instrumentation) {
        AppMethodBeat.i(114885);
        this.xHs = instrumentation;
        drp();
        AppMethodBeat.o(114885);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final Activity newActivity(ClassLoader classLoader, String str, Intent intent) {
        AppMethodBeat.i(114886);
        if (h.xGI != null) {
            h.xGI.cZ(str);
        }
        if (!h.dra() || h.drg().getCanonicalName().equals(str)) {
            Activity m;
            Activity newActivity = super.newActivity(classLoader, str, intent);
            d dVar = h.ceX;
            if (dVar != null) {
                m = dVar.m(newActivity);
                if (m != newActivity) {
                    h.g("WxSplash.SplashHackInstrumentation", "Activity %s is intercepted by %s.", str, m);
                    if (j.dro()) {
                        h.g("WxSplash.SplashHackInstrumentation", "processing relaunch activity.", new Object[0]);
                        intent.putExtra("splash-hack-activity-recreate", true);
                    }
                    AppMethodBeat.o(114886);
                    return m;
                }
            }
            m = newActivity;
            if (j.dro()) {
            }
            AppMethodBeat.o(114886);
            return m;
        }
        i iVar = new i();
        iVar.xHe = str;
        h.g("WxSplash.SplashHackInstrumentation", "new splash hack activity. replace activity %s", str);
        h.xGC.add(iVar);
        AppMethodBeat.o(114886);
        return iVar;
    }

    private void drp() {
        AppMethodBeat.i(114887);
        Field[] declaredFields = Instrumentation.class.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            declaredFields[i].setAccessible(true);
            declaredFields[i].set(this, declaredFields[i].get(this.xHs));
        }
        AppMethodBeat.o(114887);
    }
}
