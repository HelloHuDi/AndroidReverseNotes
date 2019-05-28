package kotlinx.coroutines;

import a.c.c;
import a.c.e;
import a.f.b.j;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.coroutines.a.m;
import kotlinx.coroutines.a.o;
import kotlinx.coroutines.bu.a;

@l(dWo = {1, 1, 13}, dWp = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0002\u0010\u0007J\u0017\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00028\u0000H\b¢\u0006\u0002\u0010\u0018J\u0011\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\bJ\t\u0010\u001d\u001a\u00020\u001eH\bJ\u0016\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00028\u0000H\b¢\u0006\u0002\u0010\u0018J\u0011\u0010 \u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\bJ\u001e\u0010!\u001a\u00020\u00152\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\n\u0010$\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010%\u001a\u00020&H\u0016R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0000@\u0000X\u000e¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\t8\u0000X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, dWq = {"Lkotlinx/coroutines/DispatchedContinuation;", "T", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlin/coroutines/Continuation;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "continuation", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)V", "_state", "", "_state$annotations", "()V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "countOrElement", "delegate", "getDelegate", "()Lkotlin/coroutines/Continuation;", "dispatchYield", "", "value", "dispatchYield$kotlinx_coroutines_core", "(Ljava/lang/Object;)V", "resumeCancellable", "resumeCancellableWithException", "exception", "", "resumeCancelled", "", "resumeUndispatched", "resumeUndispatchedWithException", "resumeWith", "result", "Lkotlin/Result;", "takeState", "toString", "", "kotlinx-coroutines-core"})
public final class al<T> extends an<T> implements c<T> {
    public final Object BPZ = o.d(dWv());
    public Object BPs = am.BQc;
    public final w BQa;
    public final c<T> BQb;

    public final e dWv() {
        AppMethodBeat.i(118517);
        e dWv = this.BQb.dWv();
        AppMethodBeat.o(118517);
        return dWv;
    }

    public al(w wVar, c<? super T> cVar) {
        j.p(wVar, "dispatcher");
        j.p(cVar, "continuation");
        super(0);
        AppMethodBeat.i(118516);
        this.BQa = wVar;
        this.BQb = cVar;
        AppMethodBeat.o(118516);
    }

    public final Object ekO() {
        AppMethodBeat.i(118513);
        m mVar = this.BPs;
        if ((mVar != am.BQc ? 1 : null) == null) {
            Throwable illegalStateException = new IllegalStateException("Check failed.".toString());
            AppMethodBeat.o(118513);
            throw illegalStateException;
        }
        this.BPs = am.BQc;
        AppMethodBeat.o(118513);
        return mVar;
    }

    public final c<T> ekR() {
        return this;
    }

    public final void dn(Object obj) {
        AppMethodBeat.i(118514);
        e dWv = this.BQb.dWv();
        Object ed = r.ed(obj);
        if (this.BQa.b(dWv)) {
            this.BPs = ed;
            this.BQd = 0;
            this.BQa.a(dWv, this);
            AppMethodBeat.o(118514);
            return;
        }
        bu buVar = bu.BQT;
        a aVar = (a) bu.BQS.get();
        if (aVar.csi) {
            this.BPs = ed;
            this.BQd = 0;
            aVar.BQU.addLast(this);
            AppMethodBeat.o(118514);
            return;
        }
        j.o(aVar, "eventLoop");
        e dWv2;
        Object b;
        try {
            aVar.csi = true;
            dWv2 = dWv();
            b = o.b(dWv2, this.BPZ);
            this.BQb.dn(obj);
            y yVar = y.AUy;
            o.a(dWv2, b);
            while (true) {
                Runnable runnable = (Runnable) aVar.BQU.elE();
                if (runnable == null) {
                    aVar.csi = false;
                    AppMethodBeat.o(118514);
                    return;
                }
                runnable.run();
            }
        } catch (Throwable th) {
            Throwable th2;
            Throwable th3 = th2;
            try {
                aVar.BQU.clear();
                th2 = new ak("Unexpected exception in undispatched event loop, clearing pending tasks", th3);
                AppMethodBeat.o(118514);
            } catch (Throwable th4) {
                aVar.csi = false;
                AppMethodBeat.o(118514);
            }
        }
    }

    public final String toString() {
        AppMethodBeat.i(118515);
        String str = "DispatchedContinuation[" + this.BQa + ", " + af.d(this.BQb) + ']';
        AppMethodBeat.o(118515);
        return str;
    }
}
