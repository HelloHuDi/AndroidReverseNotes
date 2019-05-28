package kotlinx.coroutines;

import a.b;
import a.c.e;
import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;

@l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a%\u0010\u0000\u001a\u00020\u00012\u001a\b\u0004\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003H\b\u001a$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007\u001a\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0005H\u0007\u001a\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0000¨\u0006\u0010"}, dWq = {"CoroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handler", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext;", "", "", "handleCoroutineException", "context", "exception", "caller", "Lkotlinx/coroutines/Job;", "handleExceptionViaHandler", "handlerException", "originalException", "thrownException", "kotlinx-coroutines-core"})
public final class z {
    public static final void a(e eVar, Throwable th, bc bcVar) {
        AppMethodBeat.i(118374);
        j.p(eVar, "context");
        j.p(th, "exception");
        if (th instanceof CancellationException) {
            AppMethodBeat.o(118374);
            return;
        }
        bc bcVar2 = (bc) eVar.get(bc.BQx);
        if (bcVar2 == null || bcVar2 == bcVar || !bcVar2.y(th)) {
            b(eVar, th);
            AppMethodBeat.o(118374);
            return;
        }
        AppMethodBeat.o(118374);
    }

    public static final void b(e eVar, Throwable th) {
        AppMethodBeat.i(118375);
        j.p(eVar, "context");
        j.p(th, "exception");
        try {
            x xVar = (x) eVar.get(x.BPJ);
            if (xVar != null) {
                xVar.handleException(eVar, th);
                AppMethodBeat.o(118375);
                return;
            }
            y.a(eVar, th);
            AppMethodBeat.o(118375);
        } catch (Throwable th2) {
            y.a(eVar, b(th, th2));
            AppMethodBeat.o(118375);
        }
    }

    public static final Throwable b(Throwable th, Throwable th2) {
        AppMethodBeat.i(118376);
        j.p(th, "originalException");
        j.p(th2, "thrownException");
        if (th == th2) {
            AppMethodBeat.o(118376);
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        b.a(runtimeException, th);
        Throwable th3 = runtimeException;
        AppMethodBeat.o(118376);
        return th3;
    }
}
