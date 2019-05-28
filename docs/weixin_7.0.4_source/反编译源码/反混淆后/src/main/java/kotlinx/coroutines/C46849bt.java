package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.p002c.C41366e;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, dWq = {"Lkotlinx/coroutines/Unconfined;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "isDispatchNeeded", "", "toString", "", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.bt */
public final class C46849bt extends C24596w {
    public static final C46849bt BQR = new C46849bt();

    static {
        AppMethodBeat.m2504i(118489);
        AppMethodBeat.m2505o(118489);
    }

    private C46849bt() {
    }

    /* renamed from: b */
    public final boolean mo41387b(C41366e c41366e) {
        AppMethodBeat.m2504i(118487);
        C25052j.m39376p(c41366e, "context");
        AppMethodBeat.m2505o(118487);
        return false;
    }

    /* renamed from: a */
    public final void mo30313a(C41366e c41366e, Runnable runnable) {
        AppMethodBeat.m2504i(118488);
        C25052j.m39376p(c41366e, "context");
        C25052j.m39376p(runnable, "block");
        Throwable unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.m2505o(118488);
        throw unsupportedOperationException;
    }

    public final String toString() {
        return "Unconfined";
    }
}
