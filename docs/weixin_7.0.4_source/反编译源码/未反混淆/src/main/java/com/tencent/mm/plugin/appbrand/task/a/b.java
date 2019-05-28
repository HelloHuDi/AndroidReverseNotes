package com.tencent.mm.plugin.appbrand.task.a;

import a.f.b.j;
import a.l;
import android.annotation.SuppressLint;
import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.g;

@l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadMemoryStressReceiver;", "Lcom/tencent/mm/plugin/appbrand/utils/ApplicationTrimMemoryListener;", "()V", "onTrimMemory", "", "level", "", "setup", "app", "Landroid/app/Application;", "plugin-appbrand-integration_release"})
public final class b extends g {
    public static final b iFy = new b();

    static {
        AppMethodBeat.i(134973);
        AppMethodBeat.o(134973);
    }

    private b() {
    }

    public static final void e(Application application) {
        AppMethodBeat.i(134971);
        j.p(application, "app");
        application.registerComponentCallbacks(iFy);
        AppMethodBeat.o(134971);
    }

    @SuppressLint({"SwitchIntDef"})
    public final void onTrimMemory(int i) {
        AppMethodBeat.i(134972);
        switch (i) {
            case 5:
            case 10:
            case 15:
                a.onTrimMemory(i);
                break;
        }
        AppMethodBeat.o(134972);
    }
}
