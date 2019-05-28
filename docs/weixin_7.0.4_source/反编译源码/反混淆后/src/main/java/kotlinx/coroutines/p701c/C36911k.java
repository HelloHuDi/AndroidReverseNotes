package kotlinx.coroutines.p701c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.coroutines.C36623af;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B!\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0002\u001a\u00060\u0003j\u0002`\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, dWq = {"Lkotlinx/coroutines/scheduling/TaskImpl;", "Lkotlinx/coroutines/scheduling/Task;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "submissionTime", "", "taskContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "(Ljava/lang/Runnable;JLkotlinx/coroutines/scheduling/TaskContext;)V", "run", "", "toString", "", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.c.k */
public final class C36911k extends C36635i {
    public final Runnable BSO;

    public C36911k(Runnable runnable, long j, C36636j c36636j) {
        C25052j.m39376p(runnable, "block");
        C25052j.m39376p(c36636j, "taskContext");
        super(j, c36636j);
        AppMethodBeat.m2504i(118316);
        this.BSO = runnable;
        AppMethodBeat.m2505o(118316);
    }

    public final void run() {
        AppMethodBeat.m2504i(118314);
        try {
            this.BSO.run();
        } finally {
            this.BSN.emj();
            AppMethodBeat.m2505o(118314);
        }
    }

    public final String toString() {
        AppMethodBeat.m2504i(118315);
        String str = "Task[" + C36623af.m60718ef(this.BSO) + '@' + C36623af.m60717ee(this.BSO) + ", " + this.BSM + ", " + this.BSN + ']';
        AppMethodBeat.m2505o(118315);
        return str;
    }
}
