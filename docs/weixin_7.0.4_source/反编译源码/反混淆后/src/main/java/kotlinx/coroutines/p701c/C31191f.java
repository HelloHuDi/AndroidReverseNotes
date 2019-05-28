package kotlinx.coroutines.p701c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlinx.coroutines.C25023av;
import p000a.C0220l;
import p000a.p002c.C41366e;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u001c\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\n\u0010 \u001a\u00060\u0016j\u0002`\u0017H\u0016J\u001c\u0010\u001d\u001a\u00020\u001b2\n\u0010 \u001a\u00060\u0016j\u0002`\u00172\u0006\u0010!\u001a\u00020\"H\u0002J\u0014\u0010#\u001a\u00020\u001b2\n\u0010$\u001a\u00060\u0016j\u0002`\u0017H\u0016J\b\u0010%\u001a\u00020&H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\f\u0012\b\u0012\u00060\u0016j\u0002`\u00170\u0015X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006'"}, dWq = {"Lkotlinx/coroutines/scheduling/LimitingDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/scheduling/TaskContext;", "Ljava/util/concurrent/Executor;", "dispatcher", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "parallelism", "", "taskMode", "Lkotlinx/coroutines/scheduling/TaskMode;", "(Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;ILkotlinx/coroutines/scheduling/TaskMode;)V", "getDispatcher", "()Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "executor", "getExecutor", "()Ljava/util/concurrent/Executor;", "inFlightTasks", "Lkotlinx/atomicfu/AtomicInt;", "getParallelism", "()I", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "getTaskMode", "()Lkotlinx/coroutines/scheduling/TaskMode;", "afterTask", "", "close", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "fair", "", "execute", "command", "toString", "", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.c.f */
final class C31191f extends C25023av implements Executor, C36636j {
    private static final AtomicIntegerFieldUpdater BSG = AtomicIntegerFieldUpdater.newUpdater(C31191f.class, "BSF");
    private final ConcurrentLinkedQueue<Runnable> BSE = new ConcurrentLinkedQueue();
    private volatile int BSF = 0;
    private final C46850d BSH;
    private final int BSI;
    private final C41160l BSJ;

    static {
        AppMethodBeat.m2504i(118364);
        AppMethodBeat.m2505o(118364);
    }

    public final C41160l emk() {
        return this.BSJ;
    }

    public C31191f(C46850d c46850d, int i, C41160l c41160l) {
        C25052j.m39376p(c46850d, "dispatcher");
        C25052j.m39376p(c41160l, "taskMode");
        AppMethodBeat.m2504i(118363);
        this.BSH = c46850d;
        this.BSI = i;
        this.BSJ = c41160l;
        AppMethodBeat.m2505o(118363);
    }

    public final void execute(Runnable runnable) {
        AppMethodBeat.m2504i(118357);
        C25052j.m39376p(runnable, "command");
        m50281b(runnable, false);
        AppMethodBeat.m2505o(118357);
    }

    public final void close() {
        AppMethodBeat.m2504i(118358);
        Throwable illegalStateException = new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
        AppMethodBeat.m2505o(118358);
        throw illegalStateException;
    }

    /* renamed from: a */
    public final void mo30313a(C41366e c41366e, Runnable runnable) {
        AppMethodBeat.m2504i(118359);
        C25052j.m39376p(c41366e, "context");
        C25052j.m39376p(runnable, "block");
        m50281b(runnable, false);
        AppMethodBeat.m2505o(118359);
    }

    /* renamed from: b */
    private final void m50281b(Runnable runnable, boolean z) {
        AppMethodBeat.m2504i(118360);
        while (BSG.incrementAndGet(this) > this.BSI) {
            this.BSE.add(runnable);
            if (BSG.decrementAndGet(this) >= this.BSI) {
                AppMethodBeat.m2505o(118360);
                return;
            }
            Runnable runnable2 = (Runnable) this.BSE.poll();
            if (runnable2 == null) {
                AppMethodBeat.m2505o(118360);
                return;
            }
            runnable = runnable2;
        }
        this.BSH.mo75989b(runnable, this, z);
        AppMethodBeat.m2505o(118360);
    }

    public final String toString() {
        AppMethodBeat.m2504i(118361);
        String str = super.toString() + "[dispatcher = " + this.BSH + ']';
        AppMethodBeat.m2505o(118361);
        return str;
    }

    public final void emj() {
        AppMethodBeat.m2504i(118362);
        Runnable runnable = (Runnable) this.BSE.poll();
        if (runnable != null) {
            this.BSH.mo75989b(runnable, this, true);
            AppMethodBeat.m2505o(118362);
            return;
        }
        BSG.decrementAndGet(this);
        runnable = (Runnable) this.BSE.poll();
        if (runnable == null) {
            AppMethodBeat.m2505o(118362);
            return;
        }
        m50281b(runnable, true);
        AppMethodBeat.m2505o(118362);
    }
}
