package a.c.b.a;

import a.c.d;
import a.c.e;
import a.c.e.b;
import a.f.b.j;
import a.l;

@l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b!\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005B!\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003J\b\u0010\r\u001a\u00020\u000eH\u0014R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, dWq = {"Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "completion", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/coroutines/Continuation;)V", "_context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/Continuation;Lkotlin/coroutines/CoroutineContext;)V", "context", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "intercepted", "releaseIntercepted", "", "kotlin-stdlib"})
public abstract class c extends a {
    private transient a.c.c<Object> AVr;
    private final e AVs;

    public c(a.c.c<Object> cVar, e eVar) {
        super(cVar);
        this.AVs = eVar;
    }

    public c(a.c.c<Object> cVar) {
        this(cVar, cVar != null ? cVar.dWv() : null);
    }

    public final e dWv() {
        e eVar = this.AVs;
        if (eVar == null) {
            j.dWJ();
        }
        return eVar;
    }

    public final a.c.c<Object> dWx() {
        a.c.c<Object> cVar = this.AVr;
        if (cVar == null) {
            d dVar = (d) dWv().get(d.AVd);
            cVar = dVar != null ? dVar.a(this) : this;
            this.AVr = cVar;
        }
        return cVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void dWw() {
        a.c.c cVar = this.AVr;
        if (!(cVar == null || cVar == this)) {
            b bVar = dWv().get(d.AVd);
            if (bVar == null) {
                j.dWJ();
            }
            ((d) bVar).b(cVar);
        }
        this.AVr = b.AVq;
    }
}
