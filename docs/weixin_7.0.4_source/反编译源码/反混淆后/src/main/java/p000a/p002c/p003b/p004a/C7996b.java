package p000a.p002c.p003b.p004a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.p002c.C36927c;
import p000a.p002c.C41366e;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, dWq = {"Lkotlin/coroutines/jvm/internal/CompletedContinuation;", "Lkotlin/coroutines/Continuation;", "", "()V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "kotlin-stdlib"})
/* renamed from: a.c.b.a.b */
public final class C7996b implements C36927c<Object> {
    public static final C7996b AVq = new C7996b();

    static {
        AppMethodBeat.m2504i(56383);
        AppMethodBeat.m2505o(56383);
    }

    private C7996b() {
    }

    public final C41366e dWv() {
        AppMethodBeat.m2504i(56381);
        Throwable illegalStateException = new IllegalStateException("This continuation is already complete".toString());
        AppMethodBeat.m2505o(56381);
        throw illegalStateException;
    }

    /* renamed from: dn */
    public final void mo45dn(Object obj) {
        AppMethodBeat.m2504i(56382);
        Throwable illegalStateException = new IllegalStateException("This continuation is already complete".toString());
        AppMethodBeat.m2505o(56382);
        throw illegalStateException;
    }

    public final String toString() {
        return "This continuation is already complete";
    }
}
