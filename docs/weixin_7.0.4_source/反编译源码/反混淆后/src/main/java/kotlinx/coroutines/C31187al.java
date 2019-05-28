package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.coroutines.C41159bu.C24590a;
import kotlinx.coroutines.p700a.C44608o;
import kotlinx.coroutines.p700a.C46845m;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p002c.C36927c;
import p000a.p002c.C41366e;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0002\u0010\u0007J\u0017\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00028\u0000H\b¢\u0006\u0002\u0010\u0018J\u0011\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\bJ\t\u0010\u001d\u001a\u00020\u001eH\bJ\u0016\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00028\u0000H\b¢\u0006\u0002\u0010\u0018J\u0011\u0010 \u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\bJ\u001e\u0010!\u001a\u00020\u00152\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\n\u0010$\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010%\u001a\u00020&H\u0016R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0000@\u0000X\u000e¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\t8\u0000X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, dWq = {"Lkotlinx/coroutines/DispatchedContinuation;", "T", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlin/coroutines/Continuation;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "continuation", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)V", "_state", "", "_state$annotations", "()V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "countOrElement", "delegate", "getDelegate", "()Lkotlin/coroutines/Continuation;", "dispatchYield", "", "value", "dispatchYield$kotlinx_coroutines_core", "(Ljava/lang/Object;)V", "resumeCancellable", "resumeCancellableWithException", "exception", "", "resumeCancelled", "", "resumeUndispatched", "resumeUndispatchedWithException", "resumeWith", "result", "Lkotlin/Result;", "takeState", "toString", "", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.al */
public final class C31187al<T> extends C46846an<T> implements C36927c<T> {
    public final Object BPZ = C44608o.m81029d(dWv());
    public Object BPs = C16448am.BQc;
    public final C24596w BQa;
    public final C36927c<T> BQb;

    public final C41366e dWv() {
        AppMethodBeat.m2504i(118517);
        C41366e dWv = this.BQb.dWv();
        AppMethodBeat.m2505o(118517);
        return dWv;
    }

    public C31187al(C24596w c24596w, C36927c<? super T> c36927c) {
        C25052j.m39376p(c24596w, "dispatcher");
        C25052j.m39376p(c36927c, "continuation");
        super(0);
        AppMethodBeat.m2504i(118516);
        this.BQa = c24596w;
        this.BQb = c36927c;
        AppMethodBeat.m2505o(118516);
    }

    public final Object ekO() {
        AppMethodBeat.m2504i(118513);
        C46845m c46845m = this.BPs;
        if ((c46845m != C16448am.BQc ? 1 : null) == null) {
            Throwable illegalStateException = new IllegalStateException("Check failed.".toString());
            AppMethodBeat.m2505o(118513);
            throw illegalStateException;
        }
        this.BPs = C16448am.BQc;
        AppMethodBeat.m2505o(118513);
        return c46845m;
    }

    public final C36927c<T> ekR() {
        return this;
    }

    /* renamed from: dn */
    public final void mo45dn(Object obj) {
        AppMethodBeat.m2504i(118514);
        C41366e dWv = this.BQb.dWv();
        Object ed = C41162r.m71594ed(obj);
        if (this.BQa.mo41387b(dWv)) {
            this.BPs = ed;
            this.BQd = 0;
            this.BQa.mo30313a(dWv, this);
            AppMethodBeat.m2505o(118514);
            return;
        }
        C41159bu c41159bu = C41159bu.BQT;
        C24590a c24590a = (C24590a) C41159bu.BQS.get();
        if (c24590a.csi) {
            this.BPs = ed;
            this.BQd = 0;
            c24590a.BQU.addLast(this);
            AppMethodBeat.m2505o(118514);
            return;
        }
        C25052j.m39375o(c24590a, "eventLoop");
        C41366e dWv2;
        Object b;
        try {
            c24590a.csi = true;
            dWv2 = dWv();
            b = C44608o.m81028b(dWv2, this.BPZ);
            this.BQb.mo45dn(obj);
            C37091y c37091y = C37091y.AUy;
            C44608o.m81027a(dWv2, b);
            while (true) {
                Runnable runnable = (Runnable) c24590a.BQU.elE();
                if (runnable == null) {
                    c24590a.csi = false;
                    AppMethodBeat.m2505o(118514);
                    return;
                }
                runnable.run();
            }
        } catch (Throwable th) {
            Throwable th2;
            Throwable th3 = th2;
            try {
                c24590a.BQU.clear();
                th2 = new C24585ak("Unexpected exception in undispatched event loop, clearing pending tasks", th3);
                AppMethodBeat.m2505o(118514);
            } catch (Throwable th4) {
                c24590a.csi = false;
                AppMethodBeat.m2505o(118514);
            }
        }
    }

    public final String toString() {
        AppMethodBeat.m2504i(118515);
        String str = "DispatchedContinuation[" + this.BQa + ", " + C36623af.m60716d(this.BQb) + ']';
        AppMethodBeat.m2505o(118515);
        return str;
    }
}
