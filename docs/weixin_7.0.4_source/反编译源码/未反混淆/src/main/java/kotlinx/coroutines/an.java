package kotlinx.coroutines;

import a.c.c;
import a.c.e;
import a.l;
import a.p;
import a.p.a;
import a.q;
import a.v;
import a.y;
import kotlinx.coroutines.a.o;
import kotlinx.coroutines.c.i;
import kotlinx.coroutines.c.j;

@l(dWo = {1, 1, 13}, dWp = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00060\u0002j\u0002`\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u001d\u0010\u000f\u001a\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\n\u0010\u0013\u001a\u0004\u0018\u00010\u000eH&R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, dWq = {"Lkotlinx/coroutines/DispatchedTask;", "T", "Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/SchedulerTask;", "resumeMode", "", "(I)V", "delegate", "Lkotlin/coroutines/Continuation;", "getDelegate", "()Lkotlin/coroutines/Continuation;", "getExceptionalResult", "", "state", "", "getSuccessfulResult", "(Ljava/lang/Object;)Ljava/lang/Object;", "run", "", "takeState", "kotlinx-coroutines-core"})
public abstract class an<T> extends i {
    public int BQd;

    public abstract Object ekO();

    public abstract c<T> ekR();

    public an(int i) {
        this.BQd = i;
    }

    public <T> T ec(Object obj) {
        return obj;
    }

    public static Throwable eg(Object obj) {
        q qVar = (q) (!(obj instanceof q) ? null : obj);
        return qVar != null ? qVar.cause : null;
    }

    public final void run() {
        j jVar = this.BSN;
        e dWv;
        Object b;
        Throwable els;
        try {
            c ekR = ekR();
            if (ekR == null) {
                throw new v("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<T>");
            }
            a aVar;
            y yVar;
            al alVar = (al) ekR;
            c cVar = alVar.BQb;
            dWv = cVar.dWv();
            bc bcVar = bo.UY(this.BQd) ? (bc) dWv.get(bc.BQx) : null;
            Object ekO = ekO();
            b = o.b(dWv, alVar.BPZ);
            if (bcVar != null) {
                if (!bcVar.isActive()) {
                    els = bcVar.els();
                    aVar = p.AUp;
                    cVar.dn(p.dl(q.n(els)));
                    yVar = y.AUy;
                    o.a(dWv, b);
                    jVar.emj();
                }
            }
            els = eg(ekO);
            if (els != null) {
                aVar = p.AUp;
                cVar.dn(p.dl(q.n(els)));
            } else {
                Object ec = ec(ekO);
                aVar = p.AUp;
                cVar.dn(p.dl(ec));
            }
            yVar = y.AUy;
            o.a(dWv, b);
            jVar.emj();
        } catch (Throwable th) {
            jVar.emj();
        }
    }
}
