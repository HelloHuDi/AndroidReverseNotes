package kotlinx.coroutines.c;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.coroutines.af;

@l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B!\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0002\u001a\u00060\u0003j\u0002`\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, dWq = {"Lkotlinx/coroutines/scheduling/TaskImpl;", "Lkotlinx/coroutines/scheduling/Task;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "submissionTime", "", "taskContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "(Ljava/lang/Runnable;JLkotlinx/coroutines/scheduling/TaskContext;)V", "run", "", "toString", "", "kotlinx-coroutines-core"})
public final class k extends i {
    public final Runnable BSO;

    public k(Runnable runnable, long j, j jVar) {
        j.p(runnable, "block");
        j.p(jVar, "taskContext");
        super(j, jVar);
        AppMethodBeat.i(118316);
        this.BSO = runnable;
        AppMethodBeat.o(118316);
    }

    public final void run() {
        AppMethodBeat.i(118314);
        try {
            this.BSO.run();
        } finally {
            this.BSN.emj();
            AppMethodBeat.o(118314);
        }
    }

    public final String toString() {
        AppMethodBeat.i(118315);
        String str = "Task[" + af.ef(this.BSO) + '@' + af.ee(this.BSO) + ", " + this.BSM + ", " + this.BSN + ']';
        AppMethodBeat.o(118315);
        return str;
    }
}
