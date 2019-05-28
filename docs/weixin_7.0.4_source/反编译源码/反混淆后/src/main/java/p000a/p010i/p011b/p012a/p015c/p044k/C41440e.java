package p000a.p010i.p011b.p012a.p015c.p044k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* renamed from: a.i.b.a.c.k.e */
final class C41440e implements Lock {
    public static final Lock BIZ = new C41440e();

    static {
        AppMethodBeat.m2504i(122478);
        AppMethodBeat.m2505o(122478);
    }

    private C41440e() {
    }

    public final void lock() {
    }

    public final void unlock() {
    }

    public final void lockInterruptibly() {
        AppMethodBeat.m2504i(122474);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Should not be called");
        AppMethodBeat.m2505o(122474);
        throw unsupportedOperationException;
    }

    public final boolean tryLock() {
        AppMethodBeat.m2504i(122475);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Should not be called");
        AppMethodBeat.m2505o(122475);
        throw unsupportedOperationException;
    }

    public final boolean tryLock(long j, TimeUnit timeUnit) {
        AppMethodBeat.m2504i(122476);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Should not be called");
        AppMethodBeat.m2505o(122476);
        throw unsupportedOperationException;
    }

    public final Condition newCondition() {
        AppMethodBeat.m2504i(122477);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Should not be called");
        AppMethodBeat.m2505o(122477);
        throw unsupportedOperationException;
    }
}
