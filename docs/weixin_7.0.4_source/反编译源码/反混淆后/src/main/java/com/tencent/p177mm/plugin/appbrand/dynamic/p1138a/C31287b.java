package com.tencent.p177mm.plugin.appbrand.dynamic.p1138a;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C32710b;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.C45412g;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.modelappbrand.C26435d;
import com.tencent.p177mm.modelappbrand.C9686c;
import com.tencent.p177mm.plugin.appbrand.dynamic.C45539b;
import com.tencent.p177mm.plugin.appbrand.dynamic.p288h.C45547b;
import com.tencent.p177mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.a.b */
final class C31287b implements C26435d {
    C9686c hmc;
    Runnable hmd = new C191691();
    Runnable hme = new C312912();
    Runnable hmf = new C312883();

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.a.b$1 */
    class C191691 implements Runnable {
        C191691() {
        }

        public final void run() {
            AppMethodBeat.m2504i(10731);
            C45412g.m83632lh("com.tencent.mm:support");
            AppMethodBeat.m2505o(10731);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.a.b$3 */
    class C312883 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.a.b$3$1 */
        class C312891 implements C18507c<Bundle> {
            C312891() {
            }

            /* renamed from: ao */
            public final /* synthetic */ void mo5960ao(Object obj) {
                AppMethodBeat.m2504i(10734);
                C4990ab.m7416i("MicroMsg.DynamicPagePerformance", "killProcessTask onCallback");
                C45412g.m83633li("com.tencent.mm:support");
                AppMethodBeat.m2505o(10734);
            }
        }

        C312883() {
        }

        public final void run() {
            AppMethodBeat.m2504i(10735);
            if (C32710b.m53380PL().mo53222le("com.tencent.mm:support")) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("forceKillProcess", true);
                C9549f.m17012a("com.tencent.mm:support", bundle, C31290a.class, new C312891());
                AppMethodBeat.m2505o(10735);
                return;
            }
            AppMethodBeat.m2505o(10735);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.a.b$a */
    static class C31290a implements C37866a<Bundle, Bundle> {
        private C31290a() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            boolean z = false;
            AppMethodBeat.m2504i(10736);
            Bundle bundle = (Bundle) obj;
            if (bundle != null && bundle.getBoolean("forceKillProcess", false)) {
                z = true;
            }
            if (z) {
                C45547b.aAd();
            } else {
                C45547b.aAc();
            }
            c18507c.mo5960ao(null);
            AppMethodBeat.m2505o(10736);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.a.b$2 */
    class C312912 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.a.b$2$1 */
        class C268571 implements C18507c<Bundle> {
            C268571() {
            }

            /* renamed from: ao */
            public final /* synthetic */ void mo5960ao(Object obj) {
                AppMethodBeat.m2504i(10732);
                C4990ab.m7416i("MicroMsg.DynamicPagePerformance", "exitTask onCallback");
                C45412g.m83633li("com.tencent.mm:support");
                AppMethodBeat.m2505o(10732);
            }
        }

        C312912() {
        }

        public final void run() {
            AppMethodBeat.m2504i(10733);
            if (C32710b.m53380PL().mo53222le("com.tencent.mm:support")) {
                C9549f.m17012a("com.tencent.mm:support", null, C31290a.class, new C268571());
                AppMethodBeat.m2505o(10733);
                return;
            }
            AppMethodBeat.m2505o(10733);
        }
    }

    C31287b(C9686c c9686c) {
        AppMethodBeat.m2504i(10737);
        this.hmc = c9686c;
        AppMethodBeat.m2505o(10737);
    }

    public final void exit() {
        AppMethodBeat.m2504i(10738);
        C45539b.m83987D(this.hme);
        AppMethodBeat.m2505o(10738);
    }

    public final void restart() {
        AppMethodBeat.m2504i(10739);
        C45539b.m83987D(this.hmf);
        C45539b.m83989j(this.hmd, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        AppMethodBeat.m2505o(10739);
    }

    /* renamed from: pk */
    public final void mo44199pk(String str) {
        AppMethodBeat.m2504i(10740);
        Set<View> bd = this.hmc.mo21010bd(str);
        if (bd == null || bd.isEmpty()) {
            AppMethodBeat.m2505o(10740);
            return;
        }
        for (View view : bd) {
            if (view != null && (view instanceof IPCDynamicPageView)) {
                C4990ab.m7419v("MicroMsg.DynamicPagePerformance", "pauseAllView, do pause view(%s)", Integer.valueOf(view.hashCode()));
                ((IPCDynamicPageView) view).onPause();
            }
        }
        AppMethodBeat.m2505o(10740);
    }

    /* renamed from: pl */
    public final void mo44200pl(String str) {
        AppMethodBeat.m2504i(10741);
        Set<View> bd = this.hmc.mo21010bd(str);
        if (bd == null || bd.isEmpty()) {
            AppMethodBeat.m2505o(10741);
            return;
        }
        for (View view : bd) {
            if (view != null && (view instanceof IPCDynamicPageView)) {
                C4990ab.m7419v("MicroMsg.DynamicPagePerformance", "pauseAllView, do resume view(%s)", Integer.valueOf(view.hashCode()));
                ((IPCDynamicPageView) view).onResume();
            }
        }
        AppMethodBeat.m2505o(10741);
    }
}
