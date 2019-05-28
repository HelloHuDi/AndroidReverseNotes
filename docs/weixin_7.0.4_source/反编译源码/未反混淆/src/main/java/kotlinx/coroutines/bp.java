package kotlinx.coroutines;

import a.c.e;
import a.f.b.j;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0000\b\u0012\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0014R\u0014\u0010\b\u001a\u00020\u00068TX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, dWq = {"Lkotlinx/coroutines/StandaloneCoroutine;", "Lkotlinx/coroutines/AbstractCoroutine;", "", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "active", "", "(Lkotlin/coroutines/CoroutineContext;Z)V", "cancelsParent", "getCancelsParent", "()Z", "handleJobException", "exception", "", "kotlinx-coroutines-core"})
class bp extends c<y> {
    public bp(e eVar, boolean z) {
        j.p(eVar, "parentContext");
        super(eVar, z);
        AppMethodBeat.i(118463);
        AppMethodBeat.o(118463);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean elw() {
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final void z(Throwable th) {
        AppMethodBeat.i(118462);
        j.p(th, "exception");
        z.b(this.BPy, th);
        AppMethodBeat.o(118462);
    }
}
