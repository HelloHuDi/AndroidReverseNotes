package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.modelappbrand.c;
import com.tencent.mm.modelappbrand.d;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.Set;

final class b implements d {
    c hmc;
    Runnable hmd = new Runnable() {
        public final void run() {
            AppMethodBeat.i(10731);
            g.lh("com.tencent.mm:support");
            AppMethodBeat.o(10731);
        }
    };
    Runnable hme = new Runnable() {
        public final void run() {
            AppMethodBeat.i(10733);
            if (com.tencent.mm.ipcinvoker.b.PL().le("com.tencent.mm:support")) {
                f.a("com.tencent.mm:support", null, a.class, new com.tencent.mm.ipcinvoker.c<Bundle>() {
                    public final /* synthetic */ void ao(Object obj) {
                        AppMethodBeat.i(10732);
                        ab.i("MicroMsg.DynamicPagePerformance", "exitTask onCallback");
                        g.li("com.tencent.mm:support");
                        AppMethodBeat.o(10732);
                    }
                });
                AppMethodBeat.o(10733);
                return;
            }
            AppMethodBeat.o(10733);
        }
    };
    Runnable hmf = new Runnable() {
        public final void run() {
            AppMethodBeat.i(10735);
            if (com.tencent.mm.ipcinvoker.b.PL().le("com.tencent.mm:support")) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("forceKillProcess", true);
                f.a("com.tencent.mm:support", bundle, a.class, new com.tencent.mm.ipcinvoker.c<Bundle>() {
                    public final /* synthetic */ void ao(Object obj) {
                        AppMethodBeat.i(10734);
                        ab.i("MicroMsg.DynamicPagePerformance", "killProcessTask onCallback");
                        g.li("com.tencent.mm:support");
                        AppMethodBeat.o(10734);
                    }
                });
                AppMethodBeat.o(10735);
                return;
            }
            AppMethodBeat.o(10735);
        }
    };

    static class a implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            boolean z = false;
            AppMethodBeat.i(10736);
            Bundle bundle = (Bundle) obj;
            if (bundle != null && bundle.getBoolean("forceKillProcess", false)) {
                z = true;
            }
            if (z) {
                com.tencent.mm.plugin.appbrand.dynamic.h.b.aAd();
            } else {
                com.tencent.mm.plugin.appbrand.dynamic.h.b.aAc();
            }
            cVar.ao(null);
            AppMethodBeat.o(10736);
        }
    }

    b(c cVar) {
        AppMethodBeat.i(10737);
        this.hmc = cVar;
        AppMethodBeat.o(10737);
    }

    public final void exit() {
        AppMethodBeat.i(10738);
        com.tencent.mm.plugin.appbrand.dynamic.b.D(this.hme);
        AppMethodBeat.o(10738);
    }

    public final void restart() {
        AppMethodBeat.i(10739);
        com.tencent.mm.plugin.appbrand.dynamic.b.D(this.hmf);
        com.tencent.mm.plugin.appbrand.dynamic.b.j(this.hmd, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        AppMethodBeat.o(10739);
    }

    public final void pk(String str) {
        AppMethodBeat.i(10740);
        Set<View> bd = this.hmc.bd(str);
        if (bd == null || bd.isEmpty()) {
            AppMethodBeat.o(10740);
            return;
        }
        for (View view : bd) {
            if (view != null && (view instanceof IPCDynamicPageView)) {
                ab.v("MicroMsg.DynamicPagePerformance", "pauseAllView, do pause view(%s)", Integer.valueOf(view.hashCode()));
                ((IPCDynamicPageView) view).onPause();
            }
        }
        AppMethodBeat.o(10740);
    }

    public final void pl(String str) {
        AppMethodBeat.i(10741);
        Set<View> bd = this.hmc.bd(str);
        if (bd == null || bd.isEmpty()) {
            AppMethodBeat.o(10741);
            return;
        }
        for (View view : bd) {
            if (view != null && (view instanceof IPCDynamicPageView)) {
                ab.v("MicroMsg.DynamicPagePerformance", "pauseAllView, do resume view(%s)", Integer.valueOf(view.hashCode()));
                ((IPCDynamicPageView) view).onResume();
            }
        }
        AppMethodBeat.o(10741);
    }
}
