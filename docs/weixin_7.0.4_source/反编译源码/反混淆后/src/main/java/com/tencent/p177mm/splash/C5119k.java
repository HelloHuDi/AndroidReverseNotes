package com.tencent.p177mm.splash;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.splash.k */
final class C5119k extends Instrumentation {
    public Instrumentation xHs;

    public C5119k(Instrumentation instrumentation) {
        AppMethodBeat.m2504i(114885);
        this.xHs = instrumentation;
        drp();
        AppMethodBeat.m2505o(114885);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final Activity newActivity(ClassLoader classLoader, String str, Intent intent) {
        AppMethodBeat.m2504i(114886);
        if (C5115h.xGI != null) {
            C5115h.xGI.mo4573cZ(str);
        }
        if (!C5115h.dra() || C5115h.drg().getCanonicalName().equals(str)) {
            Activity m;
            Activity newActivity = super.newActivity(classLoader, str, intent);
            C5105d c5105d = C5115h.ceX;
            if (c5105d != null) {
                m = c5105d.mo10478m(newActivity);
                if (m != newActivity) {
                    C5115h.m7780g("WxSplash.SplashHackInstrumentation", "Activity %s is intercepted by %s.", str, m);
                    if (C5118j.dro()) {
                        C5115h.m7780g("WxSplash.SplashHackInstrumentation", "processing relaunch activity.", new Object[0]);
                        intent.putExtra("splash-hack-activity-recreate", true);
                    }
                    AppMethodBeat.m2505o(114886);
                    return m;
                }
            }
            m = newActivity;
            if (C5118j.dro()) {
            }
            AppMethodBeat.m2505o(114886);
            return m;
        }
        C5117i c5117i = new C5117i();
        c5117i.xHe = str;
        C5115h.m7780g("WxSplash.SplashHackInstrumentation", "new splash hack activity. replace activity %s", str);
        C5115h.xGC.add(c5117i);
        AppMethodBeat.m2505o(114886);
        return c5117i;
    }

    private void drp() {
        AppMethodBeat.m2504i(114887);
        Field[] declaredFields = Instrumentation.class.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            declaredFields[i].setAccessible(true);
            declaredFields[i].set(this, declaredFields[i].get(this.xHs));
        }
        AppMethodBeat.m2505o(114887);
    }
}
