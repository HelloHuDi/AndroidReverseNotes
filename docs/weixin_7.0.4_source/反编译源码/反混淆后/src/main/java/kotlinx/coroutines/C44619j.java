package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.p002c.C36927c;
import p000a.p002c.C41366e;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00060\u0004j\u0002`\u0005B\u001b\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001d\u0010\u0013\u001a\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0014J!\u0010\u0019\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001a\u001a\u00028\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0019\u0010 \u001a\u00020\u0010*\u00020!2\u0006\u0010\u001a\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\"J\u0014\u0010#\u001a\u00020\u0010*\u00020!2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006$"}, dWq = {"Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "Lkotlinx/coroutines/AbstractContinuation;", "Lkotlinx/coroutines/CancellableContinuation;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "delegate", "Lkotlin/coroutines/Continuation;", "resumeMode", "", "(Lkotlin/coroutines/Continuation;I)V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "completeResume", "", "token", "", "getSuccessfulResult", "state", "(Ljava/lang/Object;)Ljava/lang/Object;", "initCancellability", "nameString", "", "tryResume", "value", "idempotent", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "tryResumeWithException", "exception", "", "resumeUndispatched", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.j */
public final class C44619j<T> extends C46947a<T> implements Runnable, C24594i<T> {
    private final C41366e BPx;

    public C44619j(C36927c<? super T> c36927c) {
        C25052j.m39376p(c36927c, "delegate");
        super(c36927c);
        AppMethodBeat.m2504i(118526);
        this.BPx = c36927c.dWv();
        AppMethodBeat.m2505o(118526);
    }

    public final C41366e dWv() {
        return this.BPx;
    }

    /* renamed from: ec */
    public final <T> T mo71482ec(Object obj) {
        return obj instanceof C41163s ? ((C41163s) obj).result : obj;
    }

    /* Access modifiers changed, original: protected|final */
    public final String ekQ() {
        AppMethodBeat.m2504i(118525);
        String str = "CancellableContinuation(" + C36623af.m60716d(this.BPv) + ')';
        AppMethodBeat.m2505o(118525);
        return str;
    }

    /* renamed from: a */
    public final void mo41382a(C24596w c24596w, T t) {
        C24596w c24596w2 = null;
        AppMethodBeat.m2504i(118524);
        C25052j.m39376p(c24596w, "receiver$0");
        C36927c c36927c = this.BPv;
        if (!(c36927c instanceof C31187al)) {
            c36927c = null;
        }
        C31187al c31187al = (C31187al) c36927c;
        if (c31187al != null) {
            c24596w2 = c31187al.BQa;
        }
        mo76260l(t, c24596w2 == c24596w ? 3 : this.BQd);
        AppMethodBeat.m2505o(118524);
    }
}
