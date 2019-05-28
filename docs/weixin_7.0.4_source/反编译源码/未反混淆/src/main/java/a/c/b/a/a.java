package a.c.b.a;

import a.c.c;
import a.f.b.j;
import a.l;
import a.p;
import a.q;
import a.y;
import java.io.Serializable;

@l(dWo = {1, 1, 13}, dWp = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b!\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u00032\u00020\u0004B\u0017\u0012\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001¢\u0006\u0002\u0010\u0006J$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016J\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\"\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0013H$ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\rH\u0014J\u001e\u0010\u0016\u001a\u00020\r2\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0013ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001b\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, dWq = {"Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Ljava/io/Serializable;", "completion", "(Lkotlin/coroutines/Continuation;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCompletion", "()Lkotlin/coroutines/Continuation;", "create", "", "value", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "invokeSuspend", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "resumeWith", "(Ljava/lang/Object;)V", "toString", "", "kotlin-stdlib"})
public abstract class a implements c<Object>, Serializable {
    final c<Object> AVp;

    public abstract Object bO(Object obj);

    public a(c<Object> cVar) {
        this.AVp = cVar;
    }

    public final void dn(Object obj) {
        j.p(this, "frame");
        this = this;
        while (true) {
            c cVar = this.AVp;
            if (cVar == null) {
                j.dWJ();
            }
            a.p.a aVar;
            try {
                a.c.a.a bO = this.bO(obj);
                if (bO != a.c.a.a.COROUTINE_SUSPENDED) {
                    aVar = p.AUp;
                    obj = p.dl(bO);
                    this.dWw();
                    if (cVar instanceof a) {
                        this = (a) cVar;
                    } else {
                        cVar.dn(obj);
                        return;
                    }
                }
                return;
            } catch (Throwable th) {
                aVar = p.AUp;
                obj = p.dl(q.n(th));
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void dWw() {
    }

    public c<y> a(Object obj, c<?> cVar) {
        j.p(cVar, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public String toString() {
        StackTraceElement stackTraceElement;
        Object obj;
        StringBuilder stringBuilder = new StringBuilder("Continuation at ");
        j.p(this, "receiver$0");
        d dVar = (d) getClass().getAnnotation(d.class);
        if (dVar == null) {
            stackTraceElement = null;
        } else {
            int v = dVar.v();
            if (v > 1) {
                throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + v + ". Please update the Kotlin standard library.").toString());
            }
            v = e.a(this);
            if (v < 0) {
                v = -1;
            } else {
                v = dVar.dWy()[v];
            }
            stackTraceElement = new StackTraceElement(dVar.c(), dVar.m(), dVar.f(), v);
        }
        if (stackTraceElement != null) {
            obj = stackTraceElement;
        } else {
            Serializable obj2 = getClass().getName();
        }
        return stringBuilder.append(obj2).toString();
    }
}
