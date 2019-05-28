package kotlinx.coroutines;

import p000a.C0220l;
import p000a.p002c.C25044a;
import p000a.p002c.C36927c;
import p000a.p002c.C41366e;
import p000a.p002c.C41366e.C36928c;
import p000a.p002c.C41366e.C41367b;
import p000a.p002c.C44850f;
import p000a.p002c.C46863d;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\nH&J\u001c\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\nH\u0017J \u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\u0004\b\u0000\u0010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\rJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J\u0011\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0000H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016¨\u0006\u0016"}, dWq = {"Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/ContinuationInterceptor;", "()V", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatchYield", "interceptContinuation", "Lkotlin/coroutines/Continuation;", "T", "continuation", "isDispatchNeeded", "", "plus", "other", "toString", "", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.w */
public abstract class C24596w extends C25044a implements C46863d {
    /* renamed from: a */
    public abstract void mo30313a(C41366e c41366e, Runnable runnable);

    /* renamed from: b */
    public final void mo41386b(C36927c<?> c36927c) {
        C25052j.m39376p(c36927c, "continuation");
        C25052j.m39376p(c36927c, "continuation");
    }

    public <E extends C41367b> E get(C36928c<E> c36928c) {
        C25052j.m39376p(c36928c, "key");
        C25052j.m39376p(c36928c, "key");
        return c36928c == C46863d.AVd ? this : null;
    }

    public C41366e minusKey(C36928c<?> c36928c) {
        C25052j.m39376p(c36928c, "key");
        C25052j.m39376p(c36928c, "key");
        return c36928c == C46863d.AVd ? C44850f.AVg : this;
    }

    public C24596w() {
        super(C46863d.AVd);
    }

    /* renamed from: b */
    public boolean mo41387b(C41366e c41366e) {
        C25052j.m39376p(c41366e, "context");
        return true;
    }

    /* renamed from: a */
    public final <T> C36927c<T> mo41385a(C36927c<? super T> c36927c) {
        C25052j.m39376p(c36927c, "continuation");
        return new C31187al(this, c36927c);
    }

    public String toString() {
        return C36623af.m60718ef(this) + '@' + C36623af.m60717ee(this);
    }
}
