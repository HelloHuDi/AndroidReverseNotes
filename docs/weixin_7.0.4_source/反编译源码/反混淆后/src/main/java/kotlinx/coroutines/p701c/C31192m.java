package kotlinx.coroutines.p701c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.p700a.C41151n;
import p000a.C0220l;
import p000a.p009h.C0016h;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u0010\u0010\u0005\u001a\u00020\u00068\u0000X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0007\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\b\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\t\u001a\u00020\u00068\u0000X\u0004¢\u0006\u0002\n\u0000\"\u0012\u0010\n\u001a\u00020\u000b8\u0000@\u0000X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, dWq = {"BLOCKING_DEFAULT_PARALLELISM", "", "CORE_POOL_SIZE", "DEFAULT_SCHEDULER_NAME", "", "IDLE_WORKER_KEEP_ALIVE_NS", "", "MAX_POOL_SIZE", "QUEUE_SIZE_OFFLOAD_THRESHOLD", "WORK_STEALING_TIME_RESOLUTION_NS", "schedulerTimeSource", "Lkotlinx/coroutines/scheduling/TimeSource;", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.c.m */
public final class C31192m {
    public static final long BSS = C41151n.m71585aU("kotlinx.coroutines.scheduler.resolution.ns", 100000);
    public static final int BST = C41151n.m71587e("kotlinx.coroutines.scheduler.offload.threshold", 96, 0, 128, 4);
    public static final int BSU = C41151n.m71587e("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12);
    public static final int BSV = C41151n.m71587e("kotlinx.coroutines.scheduler.max.pool.size", C0016h.m14aQ(C41151n.elQ() * 128, CORE_POOL_SIZE, 2097150), 0, 2097150, 4);
    public static final long BSW = TimeUnit.SECONDS.toNanos(C41151n.m71585aU("kotlinx.coroutines.scheduler.keep.alive.sec", 5));
    public static C16463n BSX = C6103g.BSK;
    public static final int CORE_POOL_SIZE = C41151n.m71587e("kotlinx.coroutines.scheduler.core.pool.size", C0016h.m19im(C41151n.elQ(), 2), 1, 0, 8);

    static {
        AppMethodBeat.m2504i(118302);
        AppMethodBeat.m2505o(118302);
    }
}
