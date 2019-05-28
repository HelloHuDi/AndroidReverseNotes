package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;
import p000a.C0220l;
import p000a.p002c.C36927c;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, dWq = {"Lkotlinx/coroutines/CancelledContinuation;", "Lkotlinx/coroutines/CompletedExceptionally;", "continuation", "Lkotlin/coroutines/Continuation;", "cause", "", "(Lkotlin/coroutines/Continuation;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.k */
public final class C44620k extends C31195q {
    public C44620k(C36927c<?> c36927c, Throwable th) {
        C25052j.m39376p(c36927c, "continuation");
        super(th == null ? new CancellationException("Continuation " + c36927c + " was cancelled normally") : th);
        AppMethodBeat.m2504i(118365);
        AppMethodBeat.m2505o(118365);
    }
}
