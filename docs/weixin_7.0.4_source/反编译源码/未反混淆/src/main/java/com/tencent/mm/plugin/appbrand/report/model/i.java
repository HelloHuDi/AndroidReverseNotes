package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aq;
import com.tencent.mm.plugin.appbrand.page.w;

public interface i extends h {
    public static final i iBj = new i() {
        public final a aLo() {
            return null;
        }

        public final boolean DC(String str) {
            return false;
        }

        public final a k(w wVar) {
            return null;
        }

        public final void a(w wVar, w wVar2, aq aqVar) {
        }

        public final void b(w wVar) {
        }

        public final void c(w wVar) {
        }
    };

    public static class a {
        int iBk;
        public c iBl;
        public b iBm;
        public String path;

        a(w wVar) {
            AppMethodBeat.i(132614);
            this.iBk = wVar.hashCode();
            this.path = wVar.aBm();
            AppMethodBeat.o(132614);
        }
    }

    public static class b {
        public String path;

        b(String str) {
            this.path = str;
        }
    }

    public static class c {
        public String path;
        public int type;

        c(int i, String str) {
            this.type = i;
            this.path = str;
        }
    }

    boolean DC(String str);

    a aLo();

    a k(w wVar);
}
