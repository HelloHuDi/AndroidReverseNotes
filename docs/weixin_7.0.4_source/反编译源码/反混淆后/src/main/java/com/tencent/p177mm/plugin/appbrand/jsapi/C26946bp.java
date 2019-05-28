package com.tencent.p177mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.jsapi.p308i.C45604f;
import com.tencent.p177mm.plugin.appbrand.p281b.C10136c.C10137a;
import com.tencent.p177mm.plugin.appbrand.p281b.C45524b;
import com.tencent.p177mm.plugin.appbrand.p321l.C19541k.C19545a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bp */
public final class C26946bp {
    static final Map<String, C10137a> hzA = new HashMap();

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bp$1 */
    static class C269471 implements C19545a {
        C269471() {
        }

        /* renamed from: d */
        public final void mo34740d(final C2241c c2241c, final String str) {
            AppMethodBeat.m2504i(86967);
            C269481 c269481 = new C10137a() {
                /* renamed from: a */
                public final void mo6006a(String str, C45524b c45524b) {
                    AppMethodBeat.m2504i(86966);
                    C45604f.m84165a(c2241c, str, c45524b, str);
                    AppMethodBeat.m2505o(86966);
                }
            };
            C26946bp.hzA.put(str, c269481);
            ((C33327h) c2241c).getRuntime().gNN.mo21486a(c269481);
            AppMethodBeat.m2505o(86967);
        }

        /* renamed from: e */
        public final void mo34741e(C2241c c2241c, String str) {
            AppMethodBeat.m2504i(86968);
            C10137a c10137a = (C10137a) C26946bp.hzA.get(str);
            if (c10137a != null) {
                C6750i runtime = ((C33327h) c2241c).getRuntime();
                if (runtime != null) {
                    runtime.gNN.mo21488b(c10137a);
                }
            }
            AppMethodBeat.m2505o(86968);
        }
    }

    static {
        AppMethodBeat.m2504i(86970);
        AppMethodBeat.m2505o(86970);
    }

    public static void aCp() {
        AppMethodBeat.m2504i(86969);
        C45604f.m84167a(new C269471());
        AppMethodBeat.m2505o(86969);
    }
}
