package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.LockSupport;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\u0018\u0010\u0012\u001a\u00060\u0013j\u0002`\u00142\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u0014H\u0016¨\u0006\u0016"}, dWq = {"Lkotlinx/coroutines/DefaultTimeSource;", "Lkotlinx/coroutines/TimeSource;", "()V", "currentTimeMillis", "", "nanoTime", "parkNanos", "", "blocker", "", "nanos", "registerTimeLoopThread", "trackTask", "unTrackTask", "unpark", "thread", "Ljava/lang/Thread;", "unregisterTimeLoopThread", "wrapTask", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.ai */
public final class C36910ai implements C36630br {
    public static final C36910ai BPY = new C36910ai();

    static {
        AppMethodBeat.m2504i(118522);
        AppMethodBeat.m2505o(118522);
    }

    private C36910ai() {
    }

    public final long nanoTime() {
        AppMethodBeat.m2504i(118518);
        long nanoTime = System.nanoTime();
        AppMethodBeat.m2505o(118518);
        return nanoTime;
    }

    /* renamed from: aD */
    public final Runnable mo58440aD(Runnable runnable) {
        AppMethodBeat.m2504i(118519);
        C25052j.m39376p(runnable, "block");
        AppMethodBeat.m2505o(118519);
        return runnable;
    }

    public final void parkNanos(Object obj, long j) {
        AppMethodBeat.m2504i(118520);
        C25052j.m39376p(obj, "blocker");
        LockSupport.parkNanos(obj, j);
        AppMethodBeat.m2505o(118520);
    }

    public final void unpark(Thread thread) {
        AppMethodBeat.m2504i(118521);
        C25052j.m39376p(thread, "thread");
        LockSupport.unpark(thread);
        AppMethodBeat.m2505o(118521);
    }
}
