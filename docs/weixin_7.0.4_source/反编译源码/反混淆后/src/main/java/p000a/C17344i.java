package p000a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004¨\u0006\t"}, dWq = {"lazy", "Lkotlin/Lazy;", "T", "initializer", "Lkotlin/Function0;", "lock", "", "mode", "Lkotlin/LazyThreadSafetyMode;", "kotlin-stdlib"}, dWr = 1)
/* renamed from: a.i */
public class C17344i {
    /* renamed from: g */
    public static final <T> C44856f<T> m26854g(C31214a<? extends T> c31214a) {
        AppMethodBeat.m2504i(56365);
        C25052j.m39376p(c31214a, "initializer");
        C44856f c25279s = new C25279s(c31214a, (byte) 0);
        AppMethodBeat.m2505o(56365);
        return c25279s;
    }

    /* renamed from: a */
    public static final <T> C44856f<T> m26853a(C0219k c0219k, C31214a<? extends T> c31214a) {
        AppMethodBeat.m2504i(56366);
        C25052j.m39376p(c0219k, "mode");
        C25052j.m39376p(c31214a, "initializer");
        C44856f<T> c17358r;
        switch (C44857h.eQZ[c0219k.ordinal()]) {
            case 1:
                C44856f c25279s = new C25279s(c31214a, (byte) 0);
                AppMethodBeat.m2505o(56366);
                return c25279s;
            case 2:
                c17358r = new C17358r(c31214a);
                AppMethodBeat.m2505o(56366);
                return c17358r;
            case 3:
                c17358r = new C25280z(c31214a);
                AppMethodBeat.m2505o(56366);
                return c17358r;
            default:
                C31824m c31824m = new C31824m();
                AppMethodBeat.m2505o(56366);
                throw c31824m;
        }
    }
}
