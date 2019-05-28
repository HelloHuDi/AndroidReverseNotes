package kotlinx.coroutines.p701c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.RejectedExecutionException;
import kotlinx.coroutines.C25023av;
import kotlinx.coroutines.C41153ag;
import p000a.C0220l;
import p000a.p002c.C41366e;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0017\u0018\u00002\u00020\u0001B%\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001b\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\bB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\rH\u0002J\u001c\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\n\u0010\u001b\u001a\u00060\u001cj\u0002`\u001dH\u0016J)\u0010\u001e\u001a\u00020\u00162\n\u0010\u001b\u001a\u00060\u001cj\u0002`\u001d2\u0006\u0010\u0019\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0000¢\u0006\u0002\b\"J\u001c\u0010#\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\n\u0010\u001b\u001a\u00060\u001cj\u0002`\u001dH\u0016J\u000e\u0010$\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003J\r\u0010%\u001a\u00020\u0016H\u0000¢\u0006\u0002\b&J\u0015\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\nH\u0000¢\u0006\u0002\b)J\b\u0010*\u001a\u00020\u0006H\u0016J\r\u0010+\u001a\u00020\u0016H\u0000¢\u0006\u0002\b,R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, dWq = {"Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "corePoolSize", "", "maxPoolSize", "schedulerName", "", "(IILjava/lang/String;)V", "(II)V", "idleWorkerKeepAliveNs", "", "(IIJLjava/lang/String;)V", "coroutineScheduler", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "blocking", "Lkotlinx/coroutines/CoroutineDispatcher;", "parallelism", "close", "", "createScheduler", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatchWithContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "fair", "", "dispatchWithContext$kotlinx_coroutines_core", "dispatchYield", "limited", "restore", "restore$kotlinx_coroutines_core", "shutdown", "timeout", "shutdown$kotlinx_coroutines_core", "toString", "usePrivateScheduler", "usePrivateScheduler$kotlinx_coroutines_core", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.c.d */
public class C46850d extends C25023av {
    private C36631a BSD;
    private final int BSc;
    private final long BSd;
    private final String BSe;
    private final int cml;

    private C46850d(int i, int i2, long j, String str) {
        C25052j.m39376p(str, "schedulerName");
        AppMethodBeat.m2504i(118294);
        this.cml = i;
        this.BSc = i2;
        this.BSd = j;
        this.BSe = str;
        this.BSD = new C36631a(this.cml, this.BSc, this.BSd, this.BSe);
        AppMethodBeat.m2505o(118294);
    }

    public /* synthetic */ C46850d() {
        this(C31192m.CORE_POOL_SIZE, C31192m.BSV, "DefaultDispatcher");
        AppMethodBeat.m2504i(118296);
        AppMethodBeat.m2505o(118296);
    }

    private C46850d(int i, int i2, String str) {
        C25052j.m39376p(str, "schedulerName");
        this(i, i2, C31192m.BSW, str);
        AppMethodBeat.m2504i(118295);
        AppMethodBeat.m2505o(118295);
    }

    /* renamed from: a */
    public final void mo30313a(C41366e c41366e, Runnable runnable) {
        AppMethodBeat.m2504i(118290);
        C25052j.m39376p(c41366e, "context");
        C25052j.m39376p(runnable, "block");
        try {
            C36631a.m60723a(this.BSD, runnable);
            AppMethodBeat.m2505o(118290);
        } catch (RejectedExecutionException e) {
            C41153ag.BPW.mo30313a(c41366e, runnable);
            AppMethodBeat.m2505o(118290);
        }
    }

    public void close() {
        AppMethodBeat.m2504i(118291);
        this.BSD.close();
        AppMethodBeat.m2505o(118291);
    }

    public String toString() {
        AppMethodBeat.m2504i(118292);
        String str = super.toString() + "[scheduler = " + this.BSD + ']';
        AppMethodBeat.m2505o(118292);
        return str;
    }

    /* renamed from: b */
    public final void mo75989b(Runnable runnable, C36636j c36636j, boolean z) {
        AppMethodBeat.m2504i(118293);
        C25052j.m39376p(runnable, "block");
        C25052j.m39376p(c36636j, "context");
        try {
            this.BSD.mo58444a(runnable, c36636j, z);
            AppMethodBeat.m2505o(118293);
        } catch (RejectedExecutionException e) {
            C41153ag.BPW.mo30315aE(C36631a.m60722a(runnable, c36636j));
            AppMethodBeat.m2505o(118293);
        }
    }
}
