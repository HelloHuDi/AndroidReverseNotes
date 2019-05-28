package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p002c.C41366e;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0000\b\u0012\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0014R\u0014\u0010\b\u001a\u00020\u00068TX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, dWq = {"Lkotlinx/coroutines/StandaloneCoroutine;", "Lkotlinx/coroutines/AbstractCoroutine;", "", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "active", "", "(Lkotlin/coroutines/CoroutineContext;Z)V", "cancelsParent", "getCancelsParent", "()Z", "handleJobException", "exception", "", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.bp */
class C16461bp extends C44617c<C37091y> {
    public C16461bp(C41366e c41366e, boolean z) {
        C25052j.m39376p(c41366e, "parentContext");
        super(c41366e, z);
        AppMethodBeat.m2504i(118463);
        AppMethodBeat.m2505o(118463);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean elw() {
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: z */
    public final void mo30345z(Throwable th) {
        AppMethodBeat.m2504i(118462);
        C25052j.m39376p(th, "exception");
        C16467z.m25276b(this.BPy, th);
        AppMethodBeat.m2505o(118462);
    }
}
