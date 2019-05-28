package p000a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, dWq = {"Lkotlin/UnsafeLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "_value", "", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "kotlin-stdlib"})
/* renamed from: a.z */
public final class C25280z<T> implements C44856f<T>, Serializable {
    private C31214a<? extends T> AUr;
    private Object AUs = C37090w.AUx;

    public C25280z(C31214a<? extends T> c31214a) {
        C25052j.m39376p(c31214a, "initializer");
        AppMethodBeat.m2504i(56411);
        this.AUr = c31214a;
        AppMethodBeat.m2505o(56411);
    }

    public final T getValue() {
        AppMethodBeat.m2504i(56408);
        if (this.AUs == C37090w.AUx) {
            C31214a c31214a = this.AUr;
            if (c31214a == null) {
                C25052j.dWJ();
            }
            this.AUs = c31214a.invoke();
            this.AUr = null;
        }
        Object obj = this.AUs;
        AppMethodBeat.m2505o(56408);
        return obj;
    }

    private final Object writeReplace() {
        AppMethodBeat.m2504i(56410);
        C36929d c36929d = new C36929d(getValue());
        AppMethodBeat.m2505o(56410);
        return c36929d;
    }

    public final String toString() {
        Object obj;
        AppMethodBeat.m2504i(56409);
        if (this.AUs != C37090w.AUx) {
            obj = 1;
        } else {
            obj = null;
        }
        String valueOf;
        if (obj != null) {
            valueOf = String.valueOf(getValue());
            AppMethodBeat.m2505o(56409);
            return valueOf;
        }
        valueOf = "Lazy value not initialized yet.";
        AppMethodBeat.m2505o(56409);
        return valueOf;
    }
}
