package com.tencent.p177mm.plugin.appbrand.task.p1139a;

import android.annotation.SuppressLint;
import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p329s.C10729g;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadMemoryStressReceiver;", "Lcom/tencent/mm/plugin/appbrand/utils/ApplicationTrimMemoryListener;", "()V", "onTrimMemory", "", "level", "", "setup", "app", "Landroid/app/Application;", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.task.a.b */
public final class C16697b extends C10729g {
    public static final C16697b iFy = new C16697b();

    static {
        AppMethodBeat.m2504i(134973);
        AppMethodBeat.m2505o(134973);
    }

    private C16697b() {
    }

    /* renamed from: e */
    public static final void m25702e(Application application) {
        AppMethodBeat.m2504i(134971);
        C25052j.m39376p(application, "app");
        application.registerComponentCallbacks(iFy);
        AppMethodBeat.m2505o(134971);
    }

    @SuppressLint({"SwitchIntDef"})
    public final void onTrimMemory(int i) {
        AppMethodBeat.m2504i(134972);
        switch (i) {
            case 5:
            case 10:
            case 15:
                C27308a.onTrimMemory(i);
                break;
        }
        AppMethodBeat.m2505o(134972);
    }
}
