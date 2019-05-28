package kotlinx.coroutines;

import a.c.c;
import a.c.e;
import a.f.b.j;
import a.l;
import a.p;
import a.q;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.coroutines.a.m;
import kotlinx.coroutines.a.o;
import kotlinx.coroutines.bu.a;

@l(dWo = {1, 1, 13}, dWp = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0004\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0000\u001a.\u0010\n\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00060\f2\u0006\u0010\r\u001a\u00020\tH\u0000\u001a%\u0010\u000e\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\f2\u0006\u0010\u000f\u001a\u0002H\u0006H\u0000¢\u0006\u0002\u0010\u0010\u001a \u0010\u0011\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u001a%\u0010\u0014\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\f2\u0006\u0010\u000f\u001a\u0002H\u0006H\u0000¢\u0006\u0002\u0010\u0010\u001a \u0010\u0015\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u001a\u0012\u0010\u0016\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020\u00050\u0018H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003¨\u0006\u0019"}, dWq = {"UNDEFINED", "Lkotlinx/coroutines/internal/Symbol;", "UNDEFINED$annotations", "()V", "dispatch", "", "T", "Lkotlinx/coroutines/DispatchedTask;", "mode", "", "resume", "delegate", "Lkotlin/coroutines/Continuation;", "useMode", "resumeCancellable", "value", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "resumeCancellableWithException", "exception", "", "resumeDirect", "resumeDirectWithException", "yieldUndispatched", "", "Lkotlinx/coroutines/DispatchedContinuation;", "kotlinx-coroutines-core"})
public final class am {
    private static final m BQc = new m("UNDEFINED");

    static {
        AppMethodBeat.i(118583);
        AppMethodBeat.o(118583);
    }

    public static final <T> void a(c<? super T> cVar, T t) {
        AppMethodBeat.i(118577);
        j.p(cVar, "receiver$0");
        if (cVar instanceof al) {
            al alVar = (al) cVar;
            if (alVar.BQa.b(alVar.dWv())) {
                alVar.BPs = t;
                alVar.BQd = 1;
                alVar.BQa.a(alVar.dWv(), alVar);
                AppMethodBeat.o(118577);
                return;
            }
            bu buVar = bu.BQT;
            a aVar = (a) bu.BQS.get();
            if (aVar.csi) {
                alVar.BPs = t;
                alVar.BQd = 1;
                aVar.BQU.addLast(alVar);
                AppMethodBeat.o(118577);
                return;
            }
            j.o(aVar, "eventLoop");
            Throwable els;
            e dWv;
            Object b;
            try {
                int i;
                aVar.csi = true;
                bc bcVar = (bc) alVar.dWv().get(bc.BQx);
                if (bcVar == null || bcVar.isActive()) {
                    boolean i2 = false;
                } else {
                    els = bcVar.els();
                    p.a aVar2 = p.AUp;
                    alVar.dn(p.dl(q.n(els)));
                    i2 = 1;
                }
                if (i2 == 0) {
                    dWv = alVar.dWv();
                    b = o.b(dWv, alVar.BPZ);
                    c cVar2 = alVar.BQb;
                    p.a aVar3 = p.AUp;
                    cVar2.dn(p.dl(t));
                    y yVar = y.AUy;
                    o.a(dWv, b);
                }
                while (true) {
                    Runnable runnable = (Runnable) aVar.BQU.elE();
                    if (runnable == null) {
                        aVar.csi = false;
                        AppMethodBeat.o(118577);
                        return;
                    }
                    runnable.run();
                }
            } catch (Throwable els2) {
                Throwable th = els2;
                try {
                    aVar.BQU.clear();
                    els2 = new ak("Unexpected exception in undispatched event loop, clearing pending tasks", th);
                    AppMethodBeat.o(118577);
                } catch (Throwable th2) {
                    aVar.csi = false;
                    AppMethodBeat.o(118577);
                }
            }
        } else {
            p.a aVar4 = p.AUp;
            cVar.dn(p.dl(t));
            AppMethodBeat.o(118577);
        }
    }

    public static final <T> void a(c<? super T> cVar, Throwable th) {
        AppMethodBeat.i(118578);
        j.p(cVar, "receiver$0");
        j.p(th, "exception");
        if (cVar instanceof al) {
            al alVar = (al) cVar;
            e dWv = alVar.BQb.dWv();
            q qVar = new q(th);
            if (alVar.BQa.b(dWv)) {
                alVar.BPs = new q(th);
                alVar.BQd = 1;
                alVar.BQa.a(dWv, alVar);
                AppMethodBeat.o(118578);
                return;
            }
            bu buVar = bu.BQT;
            a aVar = (a) bu.BQS.get();
            if (aVar.csi) {
                alVar.BPs = qVar;
                alVar.BQd = 1;
                aVar.BQU.addLast(alVar);
                AppMethodBeat.o(118578);
                return;
            }
            j.o(aVar, "eventLoop");
            Throwable els;
            e dWv2;
            Object b;
            try {
                int i;
                aVar.csi = true;
                bc bcVar = (bc) alVar.dWv().get(bc.BQx);
                if (bcVar == null || bcVar.isActive()) {
                    boolean i2 = false;
                } else {
                    els = bcVar.els();
                    p.a aVar2 = p.AUp;
                    alVar.dn(p.dl(q.n(els)));
                    i2 = 1;
                }
                if (i2 == 0) {
                    dWv2 = alVar.dWv();
                    b = o.b(dWv2, alVar.BPZ);
                    c cVar2 = alVar.BQb;
                    p.a aVar3 = p.AUp;
                    cVar2.dn(p.dl(q.n(th)));
                    y yVar = y.AUy;
                    o.a(dWv2, b);
                }
                while (true) {
                    Runnable runnable = (Runnable) aVar.BQU.elE();
                    if (runnable == null) {
                        aVar.csi = false;
                        AppMethodBeat.o(118578);
                        return;
                    }
                    runnable.run();
                }
            } catch (Throwable els2) {
                Throwable th2 = els2;
                try {
                    aVar.BQU.clear();
                    els2 = new ak("Unexpected exception in undispatched event loop, clearing pending tasks", th2);
                    AppMethodBeat.o(118578);
                } catch (Throwable th3) {
                    aVar.csi = false;
                    AppMethodBeat.o(118578);
                }
            }
        } else {
            p.a aVar4 = p.AUp;
            cVar.dn(p.dl(q.n(th)));
            AppMethodBeat.o(118578);
        }
    }

    public static final <T> void b(c<? super T> cVar, T t) {
        AppMethodBeat.i(118579);
        j.p(cVar, "receiver$0");
        if (cVar instanceof al) {
            c cVar2 = ((al) cVar).BQb;
            p.a aVar = p.AUp;
            cVar2.dn(p.dl(t));
            AppMethodBeat.o(118579);
            return;
        }
        p.a aVar2 = p.AUp;
        cVar.dn(p.dl(t));
        AppMethodBeat.o(118579);
    }

    public static final <T> void b(c<? super T> cVar, Throwable th) {
        AppMethodBeat.i(118580);
        j.p(cVar, "receiver$0");
        j.p(th, "exception");
        if (cVar instanceof al) {
            c cVar2 = ((al) cVar).BQb;
            p.a aVar = p.AUp;
            cVar2.dn(p.dl(q.n(th)));
            AppMethodBeat.o(118580);
            return;
        }
        p.a aVar2 = p.AUp;
        cVar.dn(p.dl(q.n(th)));
        AppMethodBeat.o(118580);
    }

    public static final <T> void a(an<? super T> anVar, int i) {
        Object obj = 1;
        AppMethodBeat.i(118581);
        j.p(anVar, "receiver$0");
        c ekR = anVar.ekR();
        if (!(i == 0 || i == 1)) {
            obj = null;
        }
        if (obj != null && (ekR instanceof al) && bo.UY(i) == bo.UY(anVar.BQd)) {
            w wVar = ((al) ekR).BQa;
            e dWv = ekR.dWv();
            if (wVar.b(dWv)) {
                wVar.a(dWv, anVar);
                AppMethodBeat.o(118581);
                return;
            }
            bu buVar = bu.BQT;
            bu.a(anVar);
            AppMethodBeat.o(118581);
            return;
        }
        a(anVar, ekR, i);
        AppMethodBeat.o(118581);
    }

    public static final <T> void a(an<? super T> anVar, c<? super T> cVar, int i) {
        AppMethodBeat.i(118582);
        j.p(anVar, "receiver$0");
        j.p(cVar, "delegate");
        Object ekO = anVar.ekO();
        Throwable eg = an.eg(ekO);
        if (eg != null) {
            bo.a((c) cVar, eg, i);
            AppMethodBeat.o(118582);
            return;
        }
        bo.a((c) cVar, anVar.ec(ekO), i);
        AppMethodBeat.o(118582);
    }
}
