package kotlinx.coroutines;

import a.c.c;
import a.c.e;
import a.f.b.j;
import a.l;
import a.p;
import a.p.a;
import a.q;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.coroutines.a.o;

@l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0002\u001a-\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\u00132\u0006\u0010\u0014\u001a\u0002H\u00122\u0006\u0010\u0015\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0016\u001a-\u0010\u0017\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\u00132\u0006\u0010\u0014\u001a\u0002H\u00122\u0006\u0010\u0015\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0016\u001a(\u0010\u0018\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0001H\u0000\u001a(\u0010\u001b\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0001H\u0000\"\u0016\u0010\u0000\u001a\u00020\u00018\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\"\u0016\u0010\u0006\u001a\u00020\u00018\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003\"\u0016\u0010\b\u001a\u00020\u00018\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0003\"\u0016\u0010\n\u001a\u00020\u00018\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0003\"\u0018\u0010\f\u001a\u00020\r*\u00020\u00018@X\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000e\"\u0018\u0010\u000f\u001a\u00020\r*\u00020\u00018@X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001c"}, dWq = {"MODE_ATOMIC_DEFAULT", "", "MODE_ATOMIC_DEFAULT$annotations", "()V", "MODE_CANCELLABLE", "MODE_CANCELLABLE$annotations", "MODE_DIRECT", "MODE_DIRECT$annotations", "MODE_IGNORE", "MODE_IGNORE$annotations", "MODE_UNDISPATCHED", "MODE_UNDISPATCHED$annotations", "isCancellableMode", "", "(I)Z", "isDispatchedMode", "resumeMode", "", "T", "Lkotlin/coroutines/Continuation;", "value", "mode", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;I)V", "resumeUninterceptedMode", "resumeUninterceptedWithExceptionMode", "exception", "", "resumeWithExceptionMode", "kotlinx-coroutines-core"})
public final class bo {
    public static final boolean UY(int i) {
        return i == 1;
    }

    public static final <T> void a(c<? super T> cVar, T t, int i) {
        AppMethodBeat.i(118527);
        j.p(cVar, "receiver$0");
        switch (i) {
            case 0:
                a aVar = p.AUp;
                cVar.dn(p.dl(t));
                AppMethodBeat.o(118527);
                return;
            case 1:
                am.a((c) cVar, (Object) t);
                AppMethodBeat.o(118527);
                return;
            case 2:
                am.b((c) cVar, (Object) t);
                AppMethodBeat.o(118527);
                return;
            case 3:
                al alVar = (al) cVar;
                e dWv = alVar.dWv();
                Object b = o.b(dWv, alVar.BPZ);
                try {
                    c cVar2 = alVar.BQb;
                    a aVar2 = p.AUp;
                    cVar2.dn(p.dl(t));
                    y yVar = y.AUy;
                    return;
                } finally {
                    o.a(dWv, b);
                    AppMethodBeat.o(118527);
                }
            case 4:
                AppMethodBeat.o(118527);
                return;
            default:
                Throwable illegalStateException = new IllegalStateException("Invalid mode ".concat(String.valueOf(i)).toString());
                AppMethodBeat.o(118527);
                throw illegalStateException;
        }
    }

    public static final <T> void a(c<? super T> cVar, Throwable th, int i) {
        AppMethodBeat.i(118528);
        j.p(cVar, "receiver$0");
        j.p(th, "exception");
        switch (i) {
            case 0:
                a aVar = p.AUp;
                cVar.dn(p.dl(q.n(th)));
                AppMethodBeat.o(118528);
                return;
            case 1:
                am.a((c) cVar, th);
                AppMethodBeat.o(118528);
                return;
            case 2:
                am.b((c) cVar, th);
                AppMethodBeat.o(118528);
                return;
            case 3:
                al alVar = (al) cVar;
                e dWv = alVar.dWv();
                Object b = o.b(dWv, alVar.BPZ);
                try {
                    c cVar2 = alVar.BQb;
                    a aVar2 = p.AUp;
                    cVar2.dn(p.dl(q.n(th)));
                    y yVar = y.AUy;
                    return;
                } finally {
                    o.a(dWv, b);
                    AppMethodBeat.o(118528);
                }
            case 4:
                AppMethodBeat.o(118528);
                return;
            default:
                Throwable illegalStateException = new IllegalStateException("Invalid mode ".concat(String.valueOf(i)).toString());
                AppMethodBeat.o(118528);
                throw illegalStateException;
        }
    }
}
