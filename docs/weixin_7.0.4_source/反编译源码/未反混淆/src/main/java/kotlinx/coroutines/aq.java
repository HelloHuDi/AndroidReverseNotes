package kotlinx.coroutines;

import a.f.b.j;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lkotlinx/coroutines/DisposeOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "handle", "Lkotlinx/coroutines/DisposableHandle;", "(Lkotlinx/coroutines/DisposableHandle;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
final class aq extends g {
    private final ap BQi;

    public aq(ap apVar) {
        j.p(apVar, "handle");
        AppMethodBeat.i(118370);
        this.BQi = apVar;
        AppMethodBeat.o(118370);
    }

    public final /* synthetic */ Object am(Object obj) {
        AppMethodBeat.i(118368);
        v((Throwable) obj);
        y yVar = y.AUy;
        AppMethodBeat.o(118368);
        return yVar;
    }

    public final void v(Throwable th) {
        AppMethodBeat.i(118367);
        this.BQi.dispose();
        AppMethodBeat.o(118367);
    }

    public final String toString() {
        AppMethodBeat.i(118369);
        String str = "DisposeOnCancel[" + this.BQi + ']';
        AppMethodBeat.o(118369);
        return str;
    }
}
