package kotlinx.coroutines.p701c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.coroutines.C24596w;
import kotlinx.coroutines.p700a.C41151n;
import p000a.C0220l;
import p000a.p009h.C0016h;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, dWq = {"Lkotlinx/coroutines/scheduling/DefaultScheduler;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "()V", "IO", "Lkotlinx/coroutines/CoroutineDispatcher;", "getIO", "()Lkotlinx/coroutines/CoroutineDispatcher;", "close", "", "toDebugString", "", "toString", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.c.c */
public final class C36634c extends C46850d {
    private static final C24596w BQg;
    public static final C36634c BSC;

    static {
        int i = 0;
        AppMethodBeat.m2504i(118301);
        C36634c c36634c = new C36634c();
        BSC = c36634c;
        int e = C41151n.m71587e("kotlinx.coroutines.io.parallelism", C0016h.m19im(64, C41151n.elQ()), 0, 0, 12);
        if (e > 0) {
            i = 1;
        }
        if (i == 0) {
            Throwable illegalArgumentException = new IllegalArgumentException("Expected positive parallelism level, but have ".concat(String.valueOf(e)).toString());
            AppMethodBeat.m2505o(118301);
            throw illegalArgumentException;
        }
        BQg = new C31191f(c36634c, e, C41160l.PROBABLY_BLOCKING);
        AppMethodBeat.m2505o(118301);
    }

    private C36634c() {
    }

    public static C24596w elk() {
        return BQg;
    }

    public final void close() {
        AppMethodBeat.m2504i(118300);
        Throwable unsupportedOperationException = new UnsupportedOperationException("DefaultDispatcher cannot be closed");
        AppMethodBeat.m2505o(118300);
        throw unsupportedOperationException;
    }

    public final String toString() {
        return "DefaultDispatcher";
    }
}
