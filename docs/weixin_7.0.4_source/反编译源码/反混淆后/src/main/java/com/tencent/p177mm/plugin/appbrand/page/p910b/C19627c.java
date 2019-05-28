package com.tencent.p177mm.plugin.appbrand.page.p910b;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;

/* renamed from: com.tencent.mm.plugin.appbrand.page.b.c */
public interface C19627c {

    /* renamed from: com.tencent.mm.plugin.appbrand.page.b.c$a */
    public static class C19626a {
        /* renamed from: r */
        public static C19627c m30426r(C44709u c44709u) {
            AppMethodBeat.m2504i(87373);
            if (VERSION.SDK_INT >= 21) {
                C38463a c38463a = new C38463a(c44709u);
                AppMethodBeat.m2505o(87373);
                return c38463a;
            }
            C19627c c27222b = new C27222b(c44709u);
            AppMethodBeat.m2505o(87373);
            return c27222b;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.b.c$b */
    public enum C19628b {
        SHOWN,
        HIDDEN;

        static {
            AppMethodBeat.m2505o(87376);
        }
    }

    void aAS();

    void aBr();

    void aBs();

    C19628b aBt();

    void onOrientationChanged(int i);
}
