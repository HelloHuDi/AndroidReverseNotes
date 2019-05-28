package kotlinx.coroutines.c;

import a.c.e;
import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlinx.coroutines.av;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u001c\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\n\u0010 \u001a\u00060\u0016j\u0002`\u0017H\u0016J\u001c\u0010\u001d\u001a\u00020\u001b2\n\u0010 \u001a\u00060\u0016j\u0002`\u00172\u0006\u0010!\u001a\u00020\"H\u0002J\u0014\u0010#\u001a\u00020\u001b2\n\u0010$\u001a\u00060\u0016j\u0002`\u0017H\u0016J\b\u0010%\u001a\u00020&H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\f\u0012\b\u0012\u00060\u0016j\u0002`\u00170\u0015X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006'"}, dWq = {"Lkotlinx/coroutines/scheduling/LimitingDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/scheduling/TaskContext;", "Ljava/util/concurrent/Executor;", "dispatcher", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "parallelism", "", "taskMode", "Lkotlinx/coroutines/scheduling/TaskMode;", "(Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;ILkotlinx/coroutines/scheduling/TaskMode;)V", "getDispatcher", "()Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "executor", "getExecutor", "()Ljava/util/concurrent/Executor;", "inFlightTasks", "Lkotlinx/atomicfu/AtomicInt;", "getParallelism", "()I", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "getTaskMode", "()Lkotlinx/coroutines/scheduling/TaskMode;", "afterTask", "", "close", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "fair", "", "execute", "command", "toString", "", "kotlinx-coroutines-core"})
final class f extends av implements Executor, j {
    private static final AtomicIntegerFieldUpdater BSG = AtomicIntegerFieldUpdater.newUpdater(f.class, "BSF");
    private final ConcurrentLinkedQueue<Runnable> BSE = new ConcurrentLinkedQueue();
    private volatile int BSF = 0;
    private final d BSH;
    private final int BSI;
    private final l BSJ;

    static {
        AppMethodBeat.i(118364);
        AppMethodBeat.o(118364);
    }

    public final l emk() {
        return this.BSJ;
    }

    public f(d dVar, int i, l lVar) {
        j.p(dVar, "dispatcher");
        j.p(lVar, "taskMode");
        AppMethodBeat.i(118363);
        this.BSH = dVar;
        this.BSI = i;
        this.BSJ = lVar;
        AppMethodBeat.o(118363);
    }

    public final void execute(Runnable runnable) {
        AppMethodBeat.i(118357);
        j.p(runnable, "command");
        b(runnable, false);
        AppMethodBeat.o(118357);
    }

    public final void close() {
        AppMethodBeat.i(118358);
        Throwable illegalStateException = new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
        AppMethodBeat.o(118358);
        throw illegalStateException;
    }

    public final void a(e eVar, Runnable runnable) {
        AppMethodBeat.i(118359);
        j.p(eVar, "context");
        j.p(runnable, "block");
        b(runnable, false);
        AppMethodBeat.o(118359);
    }

    private final void b(Runnable runnable, boolean z) {
        AppMethodBeat.i(118360);
        while (BSG.incrementAndGet(this) > this.BSI) {
            this.BSE.add(runnable);
            if (BSG.decrementAndGet(this) >= this.BSI) {
                AppMethodBeat.o(118360);
                return;
            }
            Runnable runnable2 = (Runnable) this.BSE.poll();
            if (runnable2 == null) {
                AppMethodBeat.o(118360);
                return;
            }
            runnable = runnable2;
        }
        this.BSH.b(runnable, this, z);
        AppMethodBeat.o(118360);
    }

    public final String toString() {
        AppMethodBeat.i(118361);
        String str = super.toString() + "[dispatcher = " + this.BSH + ']';
        AppMethodBeat.o(118361);
        return str;
    }

    public final void emj() {
        AppMethodBeat.i(118362);
        Runnable runnable = (Runnable) this.BSE.poll();
        if (runnable != null) {
            this.BSH.b(runnable, this, true);
            AppMethodBeat.o(118362);
            return;
        }
        BSG.decrementAndGet(this);
        runnable = (Runnable) this.BSE.poll();
        if (runnable == null) {
            AppMethodBeat.o(118362);
            return;
        }
        b(runnable, true);
        AppMethodBeat.o(118362);
    }
}
