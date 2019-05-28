package kotlinx.coroutines;

import a.f.a.b;
import a.f.b.j;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B.\u0012'\u0010\u0002\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003j\u0002`\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\f\u001a\u00020\rH\u0016R/\u0010\u0002\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003j\u0002`\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, dWq = {"Lkotlinx/coroutines/InvokeOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "handler", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "(Lkotlin/jvm/functions/Function1;)V", "invoke", "toString", "", "kotlinx-coroutines-core"})
final class az extends g {
    private final b<Throwable, y> BQu;

    public final /* synthetic */ Object am(Object obj) {
        AppMethodBeat.i(118479);
        v((Throwable) obj);
        y yVar = y.AUy;
        AppMethodBeat.o(118479);
        return yVar;
    }

    public az(b<? super Throwable, y> bVar) {
        j.p(bVar, "handler");
        AppMethodBeat.i(118481);
        this.BQu = bVar;
        AppMethodBeat.o(118481);
    }

    public final void v(Throwable th) {
        AppMethodBeat.i(118478);
        this.BQu.am(th);
        AppMethodBeat.o(118478);
    }

    public final String toString() {
        AppMethodBeat.i(118480);
        String str = "InvokeOnCancel[" + af.ef(this.BQu) + '@' + af.ee(this) + ']';
        AppMethodBeat.o(118480);
        return str;
    }
}
