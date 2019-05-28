package kotlinx.coroutines.c;

import a.h.h;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.coroutines.a.n;
import kotlinx.coroutines.w;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, dWq = {"Lkotlinx/coroutines/scheduling/DefaultScheduler;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "()V", "IO", "Lkotlinx/coroutines/CoroutineDispatcher;", "getIO", "()Lkotlinx/coroutines/CoroutineDispatcher;", "close", "", "toDebugString", "", "toString", "kotlinx-coroutines-core"})
public final class c extends d {
    private static final w BQg;
    public static final c BSC;

    static {
        int i = 0;
        AppMethodBeat.i(118301);
        c cVar = new c();
        BSC = cVar;
        int e = n.e("kotlinx.coroutines.io.parallelism", h.im(64, n.elQ()), 0, 0, 12);
        if (e > 0) {
            i = 1;
        }
        if (i == 0) {
            Throwable illegalArgumentException = new IllegalArgumentException("Expected positive parallelism level, but have ".concat(String.valueOf(e)).toString());
            AppMethodBeat.o(118301);
            throw illegalArgumentException;
        }
        BQg = new f(cVar, e, l.PROBABLY_BLOCKING);
        AppMethodBeat.o(118301);
    }

    private c() {
    }

    public static w elk() {
        return BQg;
    }

    public final void close() {
        AppMethodBeat.i(118300);
        Throwable unsupportedOperationException = new UnsupportedOperationException("DefaultDispatcher cannot be closed");
        AppMethodBeat.o(118300);
        throw unsupportedOperationException;
    }

    public final String toString() {
        return "DefaultDispatcher";
    }
}
