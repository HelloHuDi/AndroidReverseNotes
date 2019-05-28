package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.C37088p;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\u0005"}, dWq = {"toState", "", "T", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.r */
public final class C41162r {
    /* renamed from: ed */
    public static final <T> Object m71594ed(Object obj) {
        AppMethodBeat.m2504i(118471);
        if (C37088p.m62042dj(obj)) {
            AppMethodBeat.m2505o(118471);
            return obj;
        }
        Throwable dk = C37088p.m62043dk(obj);
        if (dk == null) {
            C25052j.dWJ();
        }
        C31195q c31195q = new C31195q(dk);
        AppMethodBeat.m2505o(118471);
        return c31195q;
    }
}
