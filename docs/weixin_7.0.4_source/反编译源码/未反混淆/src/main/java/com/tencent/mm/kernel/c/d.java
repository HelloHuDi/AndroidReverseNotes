package com.tencent.mm.kernel.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Modifier;
import java.util.concurrent.ConcurrentHashMap;

public final class d {
    private static final d eMG = new d();
    private ConcurrentHashMap<Class<? extends a>, c> eME = new ConcurrentHashMap();
    public a eMF = null;

    public interface a {
        void a(a aVar);

        void a(c cVar);

        void b(c cVar);
    }

    public d() {
        AppMethodBeat.i(51931);
        AppMethodBeat.o(51931);
    }

    static {
        AppMethodBeat.i(51936);
        AppMethodBeat.o(51936);
    }

    public final <T extends a> T U(Class<T> cls) {
        int i;
        a SJ;
        AppMethodBeat.i(51932);
        c cVar = (c) this.eME.get(cls);
        if (cls.isInterface() || !Modifier.isAbstract(cls.getModifiers())) {
            i = 0;
        } else {
            ab.w("MicroMsg.ServiceHub", "Did you call service by using the service implementation class ?? Use interface class instead!! Carl is warning u!");
            i = 1;
        }
        if (cVar != null) {
            SJ = cVar.SJ();
        } else {
            ab.e("MicroMsg.ServiceHub", "Service(%s) not found!!! ", cls);
            if (i != 0) {
                ab.e("MicroMsg.ServiceHub", "This error must cause by using implementation class to call service! Use interface instead! Understand?");
            }
            SJ = null;
        }
        if (this.eMF != null) {
            this.eMF.a(SJ);
        }
        AppMethodBeat.o(51932);
        return SJ;
    }

    public final <T extends a, N extends T> void a(Class<T> cls, N n) {
        AppMethodBeat.i(51933);
        b(cls, new e(n));
        AppMethodBeat.o(51933);
    }

    public final <T extends a, N extends T> void b(Class<T> cls, c<N> cVar) {
        AppMethodBeat.i(51934);
        this.eME.put(cls, cVar);
        if (cVar instanceof b) {
            ((b) cVar).SH();
        }
        if (this.eMF != null) {
            this.eMF.a((c) cVar);
        }
        ab.i("MicroMsg.ServiceHub", "register service %s %s", cls, cVar);
        AppMethodBeat.o(51934);
    }

    public final void L(Class<? extends a> cls) {
        AppMethodBeat.i(51935);
        c cVar = (c) this.eME.remove(cls);
        if (cVar instanceof b) {
            ((b) cVar).SI();
        }
        if (this.eMF != null) {
            this.eMF.b(cVar);
        }
        AppMethodBeat.o(51935);
    }
}
