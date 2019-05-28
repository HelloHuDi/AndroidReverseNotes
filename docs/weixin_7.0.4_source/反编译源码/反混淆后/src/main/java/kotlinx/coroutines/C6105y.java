package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.ServiceLoader;
import p000a.C0220l;
import p000a.p001a.C25035t;
import p000a.p002c.C41366e;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u001a\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, dWq = {"handlers", "", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleCoroutineExceptionImpl", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.y */
public final class C6105y {
    private static final List<C31196x> xEL;

    static {
        AppMethodBeat.m2504i(118477);
        Class cls = C31196x.class;
        ServiceLoader load = ServiceLoader.load(cls, cls.getClassLoader());
        C25052j.m39375o(load, "ServiceLoader.load(servi…serviceClass.classLoader)");
        xEL = C25035t.m39352m(load);
        AppMethodBeat.m2505o(118477);
    }

    /* renamed from: a */
    public static final void m9610a(C41366e c41366e, Throwable th) {
        AppMethodBeat.m2504i(118476);
        C25052j.m39376p(c41366e, "context");
        C25052j.m39376p(th, "exception");
        for (C31196x handleException : xEL) {
            try {
                handleException.handleException(c41366e, th);
            } catch (Throwable th2) {
                Thread currentThread = Thread.currentThread();
                C25052j.m39375o(currentThread, "currentThread");
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, C16467z.m25275b(th, th2));
            }
        }
        Thread currentThread2 = Thread.currentThread();
        C25052j.m39375o(currentThread2, "currentThread");
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
        AppMethodBeat.m2505o(118476);
    }
}
