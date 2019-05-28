package kotlinx.coroutines;

import a.c.e;
import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, dWq = {"Lkotlinx/coroutines/Unconfined;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "isDispatchNeeded", "", "toString", "", "kotlinx-coroutines-core"})
public final class bt extends w {
    public static final bt BQR = new bt();

    static {
        AppMethodBeat.i(118489);
        AppMethodBeat.o(118489);
    }

    private bt() {
    }

    public final boolean b(e eVar) {
        AppMethodBeat.i(118487);
        j.p(eVar, "context");
        AppMethodBeat.o(118487);
        return false;
    }

    public final void a(e eVar, Runnable runnable) {
        AppMethodBeat.i(118488);
        j.p(eVar, "context");
        j.p(runnable, "block");
        Throwable unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(118488);
        throw unsupportedOperationException;
    }

    public final String toString() {
        return "Unconfined";
    }
}
