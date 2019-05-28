package com.tencent.p177mm.plugin.appbrand.p326n;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.n.c */
public enum C33459c {
    ;
    
    private Map<C33460a, Long> izl;
    private Map<C33460a, Long> izm;

    /* renamed from: com.tencent.mm.plugin.appbrand.n.c$a */
    public enum C33460a {
        public static final C33460a izA = null;
        private static final /* synthetic */ C33460a[] izB = null;
        public static final C33460a izo = null;
        public static final C33460a izp = null;
        public static final C33460a izq = null;
        public static final C33460a izr = null;
        public static final C33460a izs = null;
        public static final C33460a izt = null;
        public static final C33460a izu = null;
        public static final C33460a izv = null;
        public static final C33460a izw = null;
        public static final C33460a izx = null;
        public static final C33460a izy = null;
        public static final C33460a izz = null;
        private String name;

        public static C33460a valueOf(String str) {
            AppMethodBeat.m2504i(91129);
            C33460a c33460a = (C33460a) Enum.valueOf(C33460a.class, str);
            AppMethodBeat.m2505o(91129);
            return c33460a;
        }

        public static C33460a[] values() {
            AppMethodBeat.m2504i(91128);
            C33460a[] c33460aArr = (C33460a[]) izB.clone();
            AppMethodBeat.m2505o(91128);
            return c33460aArr;
        }

        static {
            AppMethodBeat.m2504i(91130);
            izo = new C33460a("AppStart", 0, "AppStart");
            izp = new C33460a("LoadPageFrame", 1, "LoadPageFrame");
            izq = new C33460a("PrepareJsRuntime", 2, "PrepareJsRuntime");
            izr = new C33460a("GetDom", 3, "GetDom");
            izs = new C33460a("ParseDom", 4, "ParseDom");
            izt = new C33460a("DiffDom", 5, "DiffDom");
            izu = new C33460a("GetGlobalCss", 6, "GetGlobalCss");
            izv = new C33460a("GetCss", 7, "GetCss");
            izw = new C33460a("ParseCss", 8, "ParseCss");
            izx = new C33460a("GetData", 9, "GetData");
            izy = new C33460a("Layout", 10, "Layout");
            izz = new C33460a("JSEvent", 11, "JSEvent");
            izA = new C33460a("StartUp", 12, "StartUp");
            izB = new C33460a[]{izo, izp, izq, izr, izs, izt, izu, izv, izw, izx, izy, izz, izA};
            AppMethodBeat.m2505o(91130);
        }

        private C33460a(String str, int i, String str2) {
            this.name = str2;
        }

        public final String toString() {
            return this.name;
        }
    }

    private C33459c(String str) {
        AppMethodBeat.m2504i(91133);
        this.izl = new HashMap();
        this.izm = new HashMap();
        AppMethodBeat.m2505o(91133);
    }

    static {
        AppMethodBeat.m2505o(91135);
    }

    /* renamed from: a */
    public final void mo53945a(C33460a c33460a) {
        AppMethodBeat.m2504i(91134);
        this.izl.put(c33460a, Long.valueOf(SystemClock.elapsedRealtime()));
        AppMethodBeat.m2505o(91134);
    }

    public final String toString() {
        return "";
    }
}
