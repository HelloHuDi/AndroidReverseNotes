package kotlinx.coroutines.c;

import a.h.h;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.a.n;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u0010\u0010\u0005\u001a\u00020\u00068\u0000X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0007\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\b\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\t\u001a\u00020\u00068\u0000X\u0004¢\u0006\u0002\n\u0000\"\u0012\u0010\n\u001a\u00020\u000b8\u0000@\u0000X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, dWq = {"BLOCKING_DEFAULT_PARALLELISM", "", "CORE_POOL_SIZE", "DEFAULT_SCHEDULER_NAME", "", "IDLE_WORKER_KEEP_ALIVE_NS", "", "MAX_POOL_SIZE", "QUEUE_SIZE_OFFLOAD_THRESHOLD", "WORK_STEALING_TIME_RESOLUTION_NS", "schedulerTimeSource", "Lkotlinx/coroutines/scheduling/TimeSource;", "kotlinx-coroutines-core"})
public final class m {
    public static final long BSS = n.aU("kotlinx.coroutines.scheduler.resolution.ns", 100000);
    public static final int BST = n.e("kotlinx.coroutines.scheduler.offload.threshold", 96, 0, 128, 4);
    public static final int BSU = n.e("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12);
    public static final int BSV = n.e("kotlinx.coroutines.scheduler.max.pool.size", h.aQ(n.elQ() * 128, CORE_POOL_SIZE, 2097150), 0, 2097150, 4);
    public static final long BSW = TimeUnit.SECONDS.toNanos(n.aU("kotlinx.coroutines.scheduler.keep.alive.sec", 5));
    public static n BSX = g.BSK;
    public static final int CORE_POOL_SIZE = n.e("kotlinx.coroutines.scheduler.core.pool.size", h.im(n.elQ(), 2), 1, 0, 8);

    static {
        AppMethodBeat.i(118302);
        AppMethodBeat.o(118302);
    }
}
