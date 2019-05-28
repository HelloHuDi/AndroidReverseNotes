package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.coroutines.p700a.C44608o;
import p000a.C0220l;
import p000a.C25278q;
import p000a.C37088p;
import p000a.C37088p.C37087a;
import p000a.C37091y;
import p000a.p002c.C36927c;
import p000a.p002c.C41366e;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0002\u001a-\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\u00132\u0006\u0010\u0014\u001a\u0002H\u00122\u0006\u0010\u0015\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0016\u001a-\u0010\u0017\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\u00132\u0006\u0010\u0014\u001a\u0002H\u00122\u0006\u0010\u0015\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0016\u001a(\u0010\u0018\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0001H\u0000\u001a(\u0010\u001b\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0001H\u0000\"\u0016\u0010\u0000\u001a\u00020\u00018\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\"\u0016\u0010\u0006\u001a\u00020\u00018\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003\"\u0016\u0010\b\u001a\u00020\u00018\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0003\"\u0016\u0010\n\u001a\u00020\u00018\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0003\"\u0018\u0010\f\u001a\u00020\r*\u00020\u00018@X\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000e\"\u0018\u0010\u000f\u001a\u00020\r*\u00020\u00018@X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001c"}, dWq = {"MODE_ATOMIC_DEFAULT", "", "MODE_ATOMIC_DEFAULT$annotations", "()V", "MODE_CANCELLABLE", "MODE_CANCELLABLE$annotations", "MODE_DIRECT", "MODE_DIRECT$annotations", "MODE_IGNORE", "MODE_IGNORE$annotations", "MODE_UNDISPATCHED", "MODE_UNDISPATCHED$annotations", "isCancellableMode", "", "(I)Z", "isDispatchedMode", "resumeMode", "", "T", "Lkotlin/coroutines/Continuation;", "value", "mode", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;I)V", "resumeUninterceptedMode", "resumeUninterceptedWithExceptionMode", "exception", "", "resumeWithExceptionMode", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.bo */
public final class C6102bo {
    /* renamed from: UY */
    public static final boolean m9607UY(int i) {
        return i == 1;
    }

    /* renamed from: a */
    public static final <T> void m9608a(C36927c<? super T> c36927c, T t, int i) {
        AppMethodBeat.m2504i(118527);
        C25052j.m39376p(c36927c, "receiver$0");
        switch (i) {
            case 0:
                C37087a c37087a = C37088p.AUp;
                c36927c.mo45dn(C37088p.m62044dl(t));
                AppMethodBeat.m2505o(118527);
                return;
            case 1:
                C16448am.m25224a((C36927c) c36927c, (Object) t);
                AppMethodBeat.m2505o(118527);
                return;
            case 2:
                C16448am.m25228b((C36927c) c36927c, (Object) t);
                AppMethodBeat.m2505o(118527);
                return;
            case 3:
                C31187al c31187al = (C31187al) c36927c;
                C41366e dWv = c31187al.dWv();
                Object b = C44608o.m81028b(dWv, c31187al.BPZ);
                try {
                    C36927c c36927c2 = c31187al.BQb;
                    C37087a c37087a2 = C37088p.AUp;
                    c36927c2.mo45dn(C37088p.m62044dl(t));
                    C37091y c37091y = C37091y.AUy;
                    return;
                } finally {
                    C44608o.m81027a(dWv, b);
                    AppMethodBeat.m2505o(118527);
                }
            case 4:
                AppMethodBeat.m2505o(118527);
                return;
            default:
                Throwable illegalStateException = new IllegalStateException("Invalid mode ".concat(String.valueOf(i)).toString());
                AppMethodBeat.m2505o(118527);
                throw illegalStateException;
        }
    }

    /* renamed from: a */
    public static final <T> void m9609a(C36927c<? super T> c36927c, Throwable th, int i) {
        AppMethodBeat.m2504i(118528);
        C25052j.m39376p(c36927c, "receiver$0");
        C25052j.m39376p(th, "exception");
        switch (i) {
            case 0:
                C37087a c37087a = C37088p.AUp;
                c36927c.mo45dn(C37088p.m62044dl(C25278q.m39843n(th)));
                AppMethodBeat.m2505o(118528);
                return;
            case 1:
                C16448am.m25225a((C36927c) c36927c, th);
                AppMethodBeat.m2505o(118528);
                return;
            case 2:
                C16448am.m25229b((C36927c) c36927c, th);
                AppMethodBeat.m2505o(118528);
                return;
            case 3:
                C31187al c31187al = (C31187al) c36927c;
                C41366e dWv = c31187al.dWv();
                Object b = C44608o.m81028b(dWv, c31187al.BPZ);
                try {
                    C36927c c36927c2 = c31187al.BQb;
                    C37087a c37087a2 = C37088p.AUp;
                    c36927c2.mo45dn(C37088p.m62044dl(C25278q.m39843n(th)));
                    C37091y c37091y = C37091y.AUy;
                    return;
                } finally {
                    C44608o.m81027a(dWv, b);
                    AppMethodBeat.m2505o(118528);
                }
            case 4:
                AppMethodBeat.m2505o(118528);
                return;
            default:
                Throwable illegalStateException = new IllegalStateException("Invalid mode ".concat(String.valueOf(i)).toString());
                AppMethodBeat.m2505o(118528);
                throw illegalStateException;
        }
    }
}
