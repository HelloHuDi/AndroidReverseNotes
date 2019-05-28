package kotlinx.coroutines;

import a.f.b.j;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;

@a.l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00058\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, dWq = {"Lkotlinx/coroutines/ChildContinuation;", "Lkotlinx/coroutines/JobCancellingNode;", "Lkotlinx/coroutines/Job;", "parent", "child", "Lkotlinx/coroutines/AbstractContinuation;", "(Lkotlinx/coroutines/Job;Lkotlinx/coroutines/AbstractContinuation;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
public final class l extends be<bc> {
    public final a<?> BPz;

    public final /* synthetic */ Object am(Object obj) {
        AppMethodBeat.i(118540);
        v((Throwable) obj);
        y yVar = y.AUy;
        AppMethodBeat.o(118540);
        return yVar;
    }

    public l(bc bcVar, a<?> aVar) {
        j.p(bcVar, "parent");
        j.p(aVar, "child");
        super(bcVar);
        AppMethodBeat.i(118542);
        this.BPz = aVar;
        AppMethodBeat.o(118542);
    }

    public final void v(Throwable th) {
        AppMethodBeat.i(118539);
        a aVar = this.BPz;
        Throwable a = a.a(this.BQz);
        Object obj;
        do {
            obj = aVar.BPs;
            if (!(obj instanceof bm)) {
                break;
            }
        } while (!aVar.a((bm) obj, new k(aVar, a), 0));
        AppMethodBeat.o(118539);
    }

    public final String toString() {
        AppMethodBeat.i(118541);
        String str = "ChildContinuation[" + this.BPz + ']';
        AppMethodBeat.o(118541);
        return str;
    }
}
