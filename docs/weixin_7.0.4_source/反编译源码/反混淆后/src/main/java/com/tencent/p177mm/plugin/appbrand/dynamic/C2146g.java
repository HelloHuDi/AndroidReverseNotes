package com.tencent.p177mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1923n.C1924a;
import com.tencent.p177mm.plugin.appbrand.dynamic.p1220f.C42424d;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.Collection;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.g */
public final class C2146g {
    private static C1924a hlG = new C21471();

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.g$1 */
    static class C21471 extends C1924a {
        C21471() {
        }

        /* renamed from: gl */
        public final void mo5192gl(int i) {
            AppMethodBeat.m2504i(10692);
            Bundle bundle = new Bundle();
            bundle.putInt("status", i);
            for (String a : C33164i.azC().azD()) {
                C9549f.m17012a(a, bundle, C2148a.class, null);
            }
            AppMethodBeat.m2505o(10692);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.g$a */
    static final class C2148a implements C37866a<Bundle, Bundle> {
        private C2148a() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(10693);
            Collection<C38195c> values = C33159d.azy().hlx.values();
            if (values == null || values.isEmpty()) {
                AppMethodBeat.m2505o(10693);
                return;
            }
            C42424d c42424d = new C42424d();
            String str = c42424d.name;
            String jSONObject = c42424d.toJSONObject().toString();
            for (C38195c c38195c : values) {
                if (c38195c != null) {
                    c38195c.mo60930bJ(str, jSONObject);
                }
            }
            AppMethodBeat.m2505o(10693);
        }
    }

    static {
        AppMethodBeat.m2504i(10696);
        AppMethodBeat.m2505o(10696);
    }

    public static void initialize() {
        AppMethodBeat.m2504i(10694);
        if (C4996ah.bqo()) {
            C1720g.m3537RQ();
            C1720g.m3535RO().mo5187a(hlG);
            AppMethodBeat.m2505o(10694);
            return;
        }
        AppMethodBeat.m2505o(10694);
    }

    public static void release() {
        AppMethodBeat.m2504i(10695);
        C1720g.m3537RQ();
        C1720g.m3535RO().mo5188b(hlG);
        AppMethodBeat.m2505o(10695);
    }
}
