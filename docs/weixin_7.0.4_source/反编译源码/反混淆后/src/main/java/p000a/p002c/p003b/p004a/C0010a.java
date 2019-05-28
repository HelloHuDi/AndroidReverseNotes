package p000a.p002c.p003b.p004a;

import java.io.Serializable;
import p000a.C0220l;
import p000a.C25278q;
import p000a.C37088p;
import p000a.C37088p.C37087a;
import p000a.C37091y;
import p000a.p002c.C36927c;
import p000a.p002c.p773a.C25040a;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b!\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u00032\u00020\u0004B\u0017\u0012\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001¢\u0006\u0002\u0010\u0006J$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016J\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\"\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0013H$ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\rH\u0014J\u001e\u0010\u0016\u001a\u00020\r2\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0013ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001b\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, dWq = {"Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Ljava/io/Serializable;", "completion", "(Lkotlin/coroutines/Continuation;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCompletion", "()Lkotlin/coroutines/Continuation;", "create", "", "value", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "invokeSuspend", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "resumeWith", "(Ljava/lang/Object;)V", "toString", "", "kotlin-stdlib"})
/* renamed from: a.c.b.a.a */
public abstract class C0010a implements C36927c<Object>, Serializable {
    final C36927c<Object> AVp;

    /* renamed from: bO */
    public abstract Object mo43bO(Object obj);

    public C0010a(C36927c<Object> c36927c) {
        this.AVp = c36927c;
    }

    /* renamed from: dn */
    public final void mo45dn(Object obj) {
        C25052j.m39376p(this, "frame");
        this = this;
        while (true) {
            C36927c c36927c = this.AVp;
            if (c36927c == null) {
                C25052j.dWJ();
            }
            C37087a c37087a;
            try {
                C25040a bO = this.mo43bO(obj);
                if (bO != C25040a.COROUTINE_SUSPENDED) {
                    c37087a = C37088p.AUp;
                    obj = C37088p.m62044dl(bO);
                    this.dWw();
                    if (c36927c instanceof C0010a) {
                        this = (C0010a) c36927c;
                    } else {
                        c36927c.mo45dn(obj);
                        return;
                    }
                }
                return;
            } catch (Throwable th) {
                c37087a = C37088p.AUp;
                obj = C37088p.m62044dl(C25278q.m39843n(th));
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void dWw() {
    }

    /* renamed from: a */
    public C36927c<C37091y> mo42a(Object obj, C36927c<?> c36927c) {
        C25052j.m39376p(c36927c, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public String toString() {
        StackTraceElement stackTraceElement;
        Object obj;
        StringBuilder stringBuilder = new StringBuilder("Continuation at ");
        C25052j.m39376p(this, "receiver$0");
        C31589d c31589d = (C31589d) getClass().getAnnotation(C31589d.class);
        if (c31589d == null) {
            stackTraceElement = null;
        } else {
            int v = c31589d.mo51589v();
            if (v > 1) {
                throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + v + ". Please update the Kotlin standard library.").toString());
            }
            v = C44849e.m82047a(this);
            if (v < 0) {
                v = -1;
            } else {
                v = c31589d.dWy()[v];
            }
            stackTraceElement = new StackTraceElement(c31589d.mo51585c(), c31589d.mo51588m(), c31589d.mo51587f(), v);
        }
        if (stackTraceElement != null) {
            obj = stackTraceElement;
        } else {
            Serializable obj2 = getClass().getName();
        }
        return stringBuilder.append(obj2).toString();
    }
}
