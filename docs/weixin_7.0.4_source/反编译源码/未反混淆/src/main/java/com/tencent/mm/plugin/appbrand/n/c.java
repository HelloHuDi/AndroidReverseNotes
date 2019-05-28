package com.tencent.mm.plugin.appbrand.n;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public enum c {
    ;
    
    private Map<a, Long> izl;
    private Map<a, Long> izm;

    public enum a {
        public static final a izA = null;
        private static final /* synthetic */ a[] izB = null;
        public static final a izo = null;
        public static final a izp = null;
        public static final a izq = null;
        public static final a izr = null;
        public static final a izs = null;
        public static final a izt = null;
        public static final a izu = null;
        public static final a izv = null;
        public static final a izw = null;
        public static final a izx = null;
        public static final a izy = null;
        public static final a izz = null;
        private String name;

        public static a valueOf(String str) {
            AppMethodBeat.i(91129);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(91129);
            return aVar;
        }

        public static a[] values() {
            AppMethodBeat.i(91128);
            a[] aVarArr = (a[]) izB.clone();
            AppMethodBeat.o(91128);
            return aVarArr;
        }

        static {
            AppMethodBeat.i(91130);
            izo = new a("AppStart", 0, "AppStart");
            izp = new a("LoadPageFrame", 1, "LoadPageFrame");
            izq = new a("PrepareJsRuntime", 2, "PrepareJsRuntime");
            izr = new a("GetDom", 3, "GetDom");
            izs = new a("ParseDom", 4, "ParseDom");
            izt = new a("DiffDom", 5, "DiffDom");
            izu = new a("GetGlobalCss", 6, "GetGlobalCss");
            izv = new a("GetCss", 7, "GetCss");
            izw = new a("ParseCss", 8, "ParseCss");
            izx = new a("GetData", 9, "GetData");
            izy = new a("Layout", 10, "Layout");
            izz = new a("JSEvent", 11, "JSEvent");
            izA = new a("StartUp", 12, "StartUp");
            izB = new a[]{izo, izp, izq, izr, izs, izt, izu, izv, izw, izx, izy, izz, izA};
            AppMethodBeat.o(91130);
        }

        private a(String str, int i, String str2) {
            this.name = str2;
        }

        public final String toString() {
            return this.name;
        }
    }

    private c(String str) {
        AppMethodBeat.i(91133);
        this.izl = new HashMap();
        this.izm = new HashMap();
        AppMethodBeat.o(91133);
    }

    static {
        AppMethodBeat.o(91135);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(91134);
        this.izl.put(aVar, Long.valueOf(SystemClock.elapsedRealtime()));
        AppMethodBeat.o(91134);
    }

    public final String toString() {
        return "";
    }
}
