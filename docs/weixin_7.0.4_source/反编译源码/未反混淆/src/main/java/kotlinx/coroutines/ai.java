package kotlinx.coroutines;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.LockSupport;

@l(dWo = {1, 1, 13}, dWp = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\u0018\u0010\u0012\u001a\u00060\u0013j\u0002`\u00142\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u0014H\u0016¨\u0006\u0016"}, dWq = {"Lkotlinx/coroutines/DefaultTimeSource;", "Lkotlinx/coroutines/TimeSource;", "()V", "currentTimeMillis", "", "nanoTime", "parkNanos", "", "blocker", "", "nanos", "registerTimeLoopThread", "trackTask", "unTrackTask", "unpark", "thread", "Ljava/lang/Thread;", "unregisterTimeLoopThread", "wrapTask", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "kotlinx-coroutines-core"})
public final class ai implements br {
    public static final ai BPY = new ai();

    static {
        AppMethodBeat.i(118522);
        AppMethodBeat.o(118522);
    }

    private ai() {
    }

    public final long nanoTime() {
        AppMethodBeat.i(118518);
        long nanoTime = System.nanoTime();
        AppMethodBeat.o(118518);
        return nanoTime;
    }

    public final Runnable aD(Runnable runnable) {
        AppMethodBeat.i(118519);
        j.p(runnable, "block");
        AppMethodBeat.o(118519);
        return runnable;
    }

    public final void parkNanos(Object obj, long j) {
        AppMethodBeat.i(118520);
        j.p(obj, "blocker");
        LockSupport.parkNanos(obj, j);
        AppMethodBeat.o(118520);
    }

    public final void unpark(Thread thread) {
        AppMethodBeat.i(118521);
        j.p(thread, "thread");
        LockSupport.unpark(thread);
        AppMethodBeat.o(118521);
    }
}
