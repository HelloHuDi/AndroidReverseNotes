package p000a.p002c.p003b.p004a;

import p000a.C0220l;
import p000a.p002c.C36927c;
import p000a.p002c.C41366e;
import p000a.p002c.C41366e.C41367b;
import p000a.p002c.C46863d;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b!\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005B!\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003J\b\u0010\r\u001a\u00020\u000eH\u0014R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, dWq = {"Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "completion", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/coroutines/Continuation;)V", "_context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/Continuation;Lkotlin/coroutines/CoroutineContext;)V", "context", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "intercepted", "releaseIntercepted", "", "kotlin-stdlib"})
/* renamed from: a.c.b.a.c */
public abstract class C31588c extends C0010a {
    private transient C36927c<Object> AVr;
    private final C41366e AVs;

    public C31588c(C36927c<Object> c36927c, C41366e c41366e) {
        super(c36927c);
        this.AVs = c41366e;
    }

    public C31588c(C36927c<Object> c36927c) {
        this(c36927c, c36927c != null ? c36927c.dWv() : null);
    }

    public final C41366e dWv() {
        C41366e c41366e = this.AVs;
        if (c41366e == null) {
            C25052j.dWJ();
        }
        return c41366e;
    }

    public final C36927c<Object> dWx() {
        C36927c<Object> c36927c = this.AVr;
        if (c36927c == null) {
            C46863d c46863d = (C46863d) dWv().get(C46863d.AVd);
            c36927c = c46863d != null ? c46863d.mo41385a(this) : this;
            this.AVr = c36927c;
        }
        return c36927c;
    }

    /* Access modifiers changed, original: protected|final */
    public final void dWw() {
        C36927c c36927c = this.AVr;
        if (!(c36927c == null || c36927c == this)) {
            C41367b c41367b = dWv().get(C46863d.AVd);
            if (c41367b == null) {
                C25052j.dWJ();
            }
            ((C46863d) c41367b).mo41386b(c36927c);
        }
        this.AVr = C7996b.AVq;
    }
}
