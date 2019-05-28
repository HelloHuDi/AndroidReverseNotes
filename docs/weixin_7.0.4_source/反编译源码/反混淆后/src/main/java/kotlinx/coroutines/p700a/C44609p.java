package kotlinx.coroutines.p700a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\u0006\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, dWq = {"Lkotlinx/coroutines/internal/ThreadLocalWithInitialValue;", "T", "Ljava/lang/ThreadLocal;", "supplier", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "initialValue", "()Ljava/lang/Object;", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.a.p */
public final class C44609p<T> extends ThreadLocal<T> {
    private final C31214a<T> BRR;

    public C44609p(C31214a<? extends T> c31214a) {
        C25052j.m39376p(c31214a, "supplier");
        AppMethodBeat.m2504i(118383);
        this.BRR = c31214a;
        AppMethodBeat.m2505o(118383);
    }

    /* Access modifiers changed, original: protected|final */
    public final T initialValue() {
        AppMethodBeat.m2504i(118382);
        Object invoke = this.BRR.invoke();
        AppMethodBeat.m2505o(118382);
        return invoke;
    }
}
