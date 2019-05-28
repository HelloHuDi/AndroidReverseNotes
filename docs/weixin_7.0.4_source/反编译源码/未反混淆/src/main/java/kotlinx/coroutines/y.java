package kotlinx.coroutines;

import a.a.t;
import a.c.e;
import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.ServiceLoader;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u001a\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, dWq = {"handlers", "", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleCoroutineExceptionImpl", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"})
public final class y {
    private static final List<x> xEL;

    static {
        AppMethodBeat.i(118477);
        Class cls = x.class;
        ServiceLoader load = ServiceLoader.load(cls, cls.getClassLoader());
        j.o(load, "ServiceLoader.load(servi…serviceClass.classLoader)");
        xEL = t.m(load);
        AppMethodBeat.o(118477);
    }

    public static final void a(e eVar, Throwable th) {
        AppMethodBeat.i(118476);
        j.p(eVar, "context");
        j.p(th, "exception");
        for (x handleException : xEL) {
            try {
                handleException.handleException(eVar, th);
            } catch (Throwable th2) {
                Thread currentThread = Thread.currentThread();
                j.o(currentThread, "currentThread");
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, z.b(th, th2));
            }
        }
        Thread currentThread2 = Thread.currentThread();
        j.o(currentThread2, "currentThread");
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
        AppMethodBeat.o(118476);
    }
}
