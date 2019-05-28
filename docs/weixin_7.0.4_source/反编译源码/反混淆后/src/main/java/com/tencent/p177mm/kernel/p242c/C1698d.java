package com.tencent.p177mm.kernel.p242c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.reflect.Modifier;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.kernel.c.d */
public final class C1698d {
    private static final C1698d eMG = new C1698d();
    private ConcurrentHashMap<Class<? extends C1694a>, C1696c> eME = new ConcurrentHashMap();
    public C1697a eMF = null;

    /* renamed from: com.tencent.mm.kernel.c.d$a */
    public interface C1697a {
        /* renamed from: a */
        void mo5205a(C1694a c1694a);

        /* renamed from: a */
        void mo5206a(C1696c c1696c);

        /* renamed from: b */
        void mo5207b(C1696c c1696c);
    }

    public C1698d() {
        AppMethodBeat.m2504i(51931);
        AppMethodBeat.m2505o(51931);
    }

    static {
        AppMethodBeat.m2504i(51936);
        AppMethodBeat.m2505o(51936);
    }

    /* renamed from: U */
    public final <T extends C1694a> T mo5209U(Class<T> cls) {
        int i;
        C1694a SJ;
        AppMethodBeat.m2504i(51932);
        C1696c c1696c = (C1696c) this.eME.get(cls);
        if (cls.isInterface() || !Modifier.isAbstract(cls.getModifiers())) {
            i = 0;
        } else {
            C4990ab.m7420w("MicroMsg.ServiceHub", "Did you call service by using the service implementation class ?? Use interface class instead!! Carl is warning u!");
            i = 1;
        }
        if (c1696c != null) {
            SJ = c1696c.mo5204SJ();
        } else {
            C4990ab.m7413e("MicroMsg.ServiceHub", "Service(%s) not found!!! ", cls);
            if (i != 0) {
                C4990ab.m7412e("MicroMsg.ServiceHub", "This error must cause by using implementation class to call service! Use interface instead! Understand?");
            }
            SJ = null;
        }
        if (this.eMF != null) {
            this.eMF.mo5205a(SJ);
        }
        AppMethodBeat.m2505o(51932);
        return SJ;
    }

    /* renamed from: a */
    public final <T extends C1694a, N extends T> void mo5210a(Class<T> cls, N n) {
        AppMethodBeat.m2504i(51933);
        mo5211b(cls, new C6625e(n));
        AppMethodBeat.m2505o(51933);
    }

    /* renamed from: b */
    public final <T extends C1694a, N extends T> void mo5211b(Class<T> cls, C1696c<N> c1696c) {
        AppMethodBeat.m2504i(51934);
        this.eME.put(cls, c1696c);
        if (c1696c instanceof C1695b) {
            ((C1695b) c1696c).mo5202SH();
        }
        if (this.eMF != null) {
            this.eMF.mo5206a((C1696c) c1696c);
        }
        C4990ab.m7417i("MicroMsg.ServiceHub", "register service %s %s", cls, c1696c);
        AppMethodBeat.m2505o(51934);
    }

    /* renamed from: L */
    public final void mo5208L(Class<? extends C1694a> cls) {
        AppMethodBeat.m2504i(51935);
        C1696c c1696c = (C1696c) this.eME.remove(cls);
        if (c1696c instanceof C1695b) {
            ((C1695b) c1696c).mo5203SI();
        }
        if (this.eMF != null) {
            this.eMF.mo5207b(c1696c);
        }
        AppMethodBeat.m2505o(51935);
    }
}
