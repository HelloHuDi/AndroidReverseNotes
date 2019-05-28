package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;
import p000a.C0220l;
import p000a.C7993b;
import p000a.p002c.C41366e;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a%\u0010\u0000\u001a\u00020\u00012\u001a\b\u0004\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003H\b\u001a$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007\u001a\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0005H\u0007\u001a\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0000¨\u0006\u0010"}, dWq = {"CoroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handler", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext;", "", "", "handleCoroutineException", "context", "exception", "caller", "Lkotlinx/coroutines/Job;", "handleExceptionViaHandler", "handlerException", "originalException", "thrownException", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.z */
public final class C16467z {
    /* renamed from: a */
    public static final void m25274a(C41366e c41366e, Throwable th, C41157bc c41157bc) {
        AppMethodBeat.m2504i(118374);
        C25052j.m39376p(c41366e, "context");
        C25052j.m39376p(th, "exception");
        if (th instanceof CancellationException) {
            AppMethodBeat.m2505o(118374);
            return;
        }
        C41157bc c41157bc2 = (C41157bc) c41366e.get(C41157bc.BQx);
        if (c41157bc2 == null || c41157bc2 == c41157bc || !c41157bc2.mo30344y(th)) {
            C16467z.m25276b(c41366e, th);
            AppMethodBeat.m2505o(118374);
            return;
        }
        AppMethodBeat.m2505o(118374);
    }

    /* renamed from: b */
    public static final void m25276b(C41366e c41366e, Throwable th) {
        AppMethodBeat.m2504i(118375);
        C25052j.m39376p(c41366e, "context");
        C25052j.m39376p(th, "exception");
        try {
            C31196x c31196x = (C31196x) c41366e.get(C31196x.BPJ);
            if (c31196x != null) {
                c31196x.handleException(c41366e, th);
                AppMethodBeat.m2505o(118375);
                return;
            }
            C6105y.m9610a(c41366e, th);
            AppMethodBeat.m2505o(118375);
        } catch (Throwable th2) {
            C6105y.m9610a(c41366e, C16467z.m25275b(th, th2));
            AppMethodBeat.m2505o(118375);
        }
    }

    /* renamed from: b */
    public static final Throwable m25275b(Throwable th, Throwable th2) {
        AppMethodBeat.m2504i(118376);
        C25052j.m39376p(th, "originalException");
        C25052j.m39376p(th2, "thrownException");
        if (th == th2) {
            AppMethodBeat.m2505o(118376);
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        C7993b.m14177a(runtimeException, th);
        Throwable th3 = runtimeException;
        AppMethodBeat.m2505o(118376);
        return th3;
    }
}
