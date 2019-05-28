package kotlinx.coroutines;

import a.f.a.b;
import a.f.b.j;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B6\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012'\u0010\u0004\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005j\u0002`\u000b¢\u0006\u0002\u0010\fJ\u0013\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R/\u0010\u0004\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005j\u0002`\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, dWq = {"Lkotlinx/coroutines/InvokeOnCompletion;", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/Job;", "job", "handler", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "(Lkotlinx/coroutines/Job;Lkotlin/jvm/functions/Function1;)V", "invoke", "toString", "", "kotlinx-coroutines-core"})
final class bb extends bf<bc> {
    private final b<Throwable, y> BQu;

    public final /* synthetic */ Object am(Object obj) {
        AppMethodBeat.i(118379);
        v((Throwable) obj);
        y yVar = y.AUy;
        AppMethodBeat.o(118379);
        return yVar;
    }

    public bb(bc bcVar, b<? super Throwable, y> bVar) {
        j.p(bcVar, "job");
        j.p(bVar, "handler");
        super(bcVar);
        AppMethodBeat.i(118381);
        this.BQu = bVar;
        AppMethodBeat.o(118381);
    }

    public final void v(Throwable th) {
        AppMethodBeat.i(118378);
        this.BQu.am(th);
        AppMethodBeat.o(118378);
    }

    public final String toString() {
        AppMethodBeat.i(118380);
        String str = "InvokeOnCompletion[" + af.ef(this) + '@' + af.ee(this) + ']';
        AppMethodBeat.o(118380);
        return str;
    }
}
