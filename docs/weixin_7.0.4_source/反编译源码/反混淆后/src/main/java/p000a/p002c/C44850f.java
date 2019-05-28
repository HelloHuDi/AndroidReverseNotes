package p000a.p002c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import p000a.C0220l;
import p000a.p002c.C41366e.C36928c;
import p000a.p002c.C41366e.C41367b;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J5\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u0002H\b2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H\b0\u000bH\u0016¢\u0006\u0002\u0010\rJ(\u0010\u000e\u001a\u0004\u0018\u0001H\u000f\"\b\b\u0000\u0010\u000f*\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0011H\u0002¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0014\u0010\u0015\u001a\u00020\u00012\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0016J\u0011\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u001c"}, dWq = {"Lkotlin/coroutines/EmptyCoroutineContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "serialVersionUID", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "hashCode", "", "minusKey", "plus", "context", "readResolve", "", "toString", "", "kotlin-stdlib"})
/* renamed from: a.c.f */
public final class C44850f implements C41366e, Serializable {
    public static final C44850f AVg = new C44850f();

    static {
        AppMethodBeat.m2504i(56407);
        AppMethodBeat.m2505o(56407);
    }

    private C44850f() {
    }

    private final Object readResolve() {
        return AVg;
    }

    public final <E extends C41367b> E get(C36928c<E> c36928c) {
        AppMethodBeat.m2504i(56403);
        C25052j.m39376p(c36928c, "key");
        AppMethodBeat.m2505o(56403);
        return null;
    }

    public final <R> R fold(R r, C31591m<? super R, ? super C41367b, ? extends R> c31591m) {
        AppMethodBeat.m2504i(56404);
        C25052j.m39376p(c31591m, "operation");
        AppMethodBeat.m2505o(56404);
        return r;
    }

    public final C41366e plus(C41366e c41366e) {
        AppMethodBeat.m2504i(56405);
        C25052j.m39376p(c41366e, "context");
        AppMethodBeat.m2505o(56405);
        return c41366e;
    }

    public final C41366e minusKey(C36928c<?> c36928c) {
        AppMethodBeat.m2504i(56406);
        C25052j.m39376p(c36928c, "key");
        C41366e c41366e = this;
        AppMethodBeat.m2505o(56406);
        return c41366e;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "EmptyCoroutineContext";
    }
}
