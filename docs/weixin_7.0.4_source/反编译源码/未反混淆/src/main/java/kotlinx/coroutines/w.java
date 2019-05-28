package kotlinx.coroutines;

import a.c.a;
import a.c.c;
import a.c.d;
import a.c.e;
import a.c.e.b;
import a.c.f;
import a.f.b.j;
import a.l;

@l(dWo = {1, 1, 13}, dWp = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\nH&J\u001c\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\nH\u0017J \u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\u0004\b\u0000\u0010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\rJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J\u0011\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0000H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016¨\u0006\u0016"}, dWq = {"Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/ContinuationInterceptor;", "()V", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatchYield", "interceptContinuation", "Lkotlin/coroutines/Continuation;", "T", "continuation", "isDispatchNeeded", "", "plus", "other", "toString", "", "kotlinx-coroutines-core"})
public abstract class w extends a implements d {
    public abstract void a(e eVar, Runnable runnable);

    public final void b(c<?> cVar) {
        j.p(cVar, "continuation");
        j.p(cVar, "continuation");
    }

    public <E extends b> E get(e.c<E> cVar) {
        j.p(cVar, "key");
        j.p(cVar, "key");
        return cVar == d.AVd ? this : null;
    }

    public e minusKey(e.c<?> cVar) {
        j.p(cVar, "key");
        j.p(cVar, "key");
        return cVar == d.AVd ? f.AVg : this;
    }

    public w() {
        super(d.AVd);
    }

    public boolean b(e eVar) {
        j.p(eVar, "context");
        return true;
    }

    public final <T> c<T> a(c<? super T> cVar) {
        j.p(cVar, "continuation");
        return new al(this, cVar);
    }

    public String toString() {
        return af.ef(this) + '@' + af.ee(this);
    }
}
