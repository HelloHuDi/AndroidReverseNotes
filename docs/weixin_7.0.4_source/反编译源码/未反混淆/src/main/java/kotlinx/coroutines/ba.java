package kotlinx.coroutines;

import a.f.a.b;
import a.f.b.j;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@l(dWo = {1, 1, 13}, dWp = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B6\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012'\u0010\u0004\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005j\u0002`\u000b¢\u0006\u0002\u0010\fJ\u0013\u0010\u000f\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R/\u0010\u0004\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005j\u0002`\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, dWq = {"Lkotlinx/coroutines/InvokeOnCancelling;", "Lkotlinx/coroutines/JobCancellingNode;", "Lkotlinx/coroutines/Job;", "job", "handler", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "(Lkotlinx/coroutines/Job;Lkotlin/jvm/functions/Function1;)V", "_invoked", "Lkotlinx/atomicfu/AtomicInt;", "invoke", "toString", "", "kotlinx-coroutines-core"})
final class ba extends be<bc> {
    private static final AtomicIntegerFieldUpdater BQw = AtomicIntegerFieldUpdater.newUpdater(ba.class, "BQv");
    private final b<Throwable, y> BQu;
    private volatile int BQv = 0;

    static {
        AppMethodBeat.i(118533);
        AppMethodBeat.o(118533);
    }

    public final /* synthetic */ Object am(Object obj) {
        AppMethodBeat.i(118530);
        v((Throwable) obj);
        y yVar = y.AUy;
        AppMethodBeat.o(118530);
        return yVar;
    }

    public ba(bc bcVar, b<? super Throwable, y> bVar) {
        j.p(bcVar, "job");
        j.p(bVar, "handler");
        super(bcVar);
        AppMethodBeat.i(118532);
        this.BQu = bVar;
        AppMethodBeat.o(118532);
    }

    public final void v(Throwable th) {
        AppMethodBeat.i(118529);
        if (BQw.compareAndSet(this, 0, 1)) {
            this.BQu.am(th);
        }
        AppMethodBeat.o(118529);
    }

    public final String toString() {
        AppMethodBeat.i(118531);
        String str = "InvokeOnCancelling[" + af.ef(this) + '@' + af.ee(this) + ']';
        AppMethodBeat.o(118531);
        return str;
    }
}
