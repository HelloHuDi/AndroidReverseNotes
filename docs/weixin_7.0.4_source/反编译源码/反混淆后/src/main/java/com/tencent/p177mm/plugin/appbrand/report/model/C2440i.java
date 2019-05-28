package com.tencent.p177mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.page.C2412aq;
import com.tencent.p177mm.plugin.appbrand.page.C27242w;

/* renamed from: com.tencent.mm.plugin.appbrand.report.model.i */
public interface C2440i extends C27284h {
    public static final C2440i iBj = new C24431();

    /* renamed from: com.tencent.mm.plugin.appbrand.report.model.i$a */
    public static class C2441a {
        int iBk;
        public C2444c iBl;
        public C2442b iBm;
        public String path;

        C2441a(C27242w c27242w) {
            AppMethodBeat.m2504i(132614);
            this.iBk = c27242w.hashCode();
            this.path = c27242w.aBm();
            AppMethodBeat.m2505o(132614);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.report.model.i$b */
    public static class C2442b {
        public String path;

        C2442b(String str) {
            this.path = str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.report.model.i$1 */
    static class C24431 implements C2440i {
        C24431() {
        }

        public final C2441a aLo() {
            return null;
        }

        /* renamed from: DC */
        public final boolean mo6355DC(String str) {
            return false;
        }

        /* renamed from: k */
        public final C2441a mo6357k(C27242w c27242w) {
            return null;
        }

        /* renamed from: a */
        public final void mo6358a(C27242w c27242w, C27242w c27242w2, C2412aq c2412aq) {
        }

        /* renamed from: b */
        public final void mo6359b(C27242w c27242w) {
        }

        /* renamed from: c */
        public final void mo6360c(C27242w c27242w) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.report.model.i$c */
    public static class C2444c {
        public String path;
        public int type;

        C2444c(int i, String str) {
            this.type = i;
            this.path = str;
        }
    }

    /* renamed from: DC */
    boolean mo6355DC(String str);

    C2441a aLo();

    /* renamed from: k */
    C2441a mo6357k(C27242w c27242w);
}
