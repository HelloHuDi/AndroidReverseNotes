package kotlinx.coroutines;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0010\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, dWq = {"Lkotlinx/coroutines/CompletedExceptionally;", "", "cause", "", "(Ljava/lang/Throwable;)V", "toString", "", "kotlinx-coroutines-core"})
public class q {
    public final Throwable cause;

    public q(Throwable th) {
        j.p(th, "cause");
        AppMethodBeat.i(118475);
        this.cause = th;
        AppMethodBeat.o(118475);
    }

    public String toString() {
        AppMethodBeat.i(118474);
        String str = af.ef(this) + '[' + this.cause + ']';
        AppMethodBeat.o(118474);
        return str;
    }
}
