package kotlinx.coroutines;

import a.f.b.j;
import a.l;
import a.p;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\u0005"}, dWq = {"toState", "", "T", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
public final class r {
    public static final <T> Object ed(Object obj) {
        AppMethodBeat.i(118471);
        if (p.dj(obj)) {
            AppMethodBeat.o(118471);
            return obj;
        }
        Throwable dk = p.dk(obj);
        if (dk == null) {
            j.dWJ();
        }
        q qVar = new q(dk);
        AppMethodBeat.o(118471);
        return qVar;
    }
}
