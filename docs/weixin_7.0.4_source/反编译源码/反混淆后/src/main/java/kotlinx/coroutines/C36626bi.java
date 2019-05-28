package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.coroutines.p1127b.C16453a;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p002c.C36927c;
import p000a.p002c.C41366e;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012'\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\u0002\b\nø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\b\u0010\r\u001a\u00020\bH\u0014R4\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\u0002\b\nX\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, dWq = {"Lkotlinx/coroutines/LazyStandaloneCoroutine;", "Lkotlinx/coroutines/StandaloneCoroutine;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "onStart", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.bi */
final class C36626bi extends C16461bp {
    private final C31591m<C36622ac, C36927c<? super C37091y>, Object> BQO;

    public C36626bi(C41366e c41366e, C31591m<? super C36622ac, ? super C36927c<? super C37091y>, ? extends Object> c31591m) {
        C25052j.m39376p(c41366e, "parentContext");
        C25052j.m39376p(c31591m, "block");
        super(c41366e, false);
        AppMethodBeat.m2504i(118470);
        this.BQO = c31591m;
        AppMethodBeat.m2505o(118470);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onStart() {
        AppMethodBeat.m2504i(118469);
        C16453a.m25236b(this.BQO, this, this);
        AppMethodBeat.m2505o(118469);
    }
}
