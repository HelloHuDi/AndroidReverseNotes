package a.i.b.a.c.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

final class e implements Lock {
    public static final Lock BIZ = new e();

    static {
        AppMethodBeat.i(122478);
        AppMethodBeat.o(122478);
    }

    private e() {
    }

    public final void lock() {
    }

    public final void unlock() {
    }

    public final void lockInterruptibly() {
        AppMethodBeat.i(122474);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Should not be called");
        AppMethodBeat.o(122474);
        throw unsupportedOperationException;
    }

    public final boolean tryLock() {
        AppMethodBeat.i(122475);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Should not be called");
        AppMethodBeat.o(122475);
        throw unsupportedOperationException;
    }

    public final boolean tryLock(long j, TimeUnit timeUnit) {
        AppMethodBeat.i(122476);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Should not be called");
        AppMethodBeat.o(122476);
        throw unsupportedOperationException;
    }

    public final Condition newCondition() {
        AppMethodBeat.i(122477);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Should not be called");
        AppMethodBeat.o(122477);
        throw unsupportedOperationException;
    }
}
