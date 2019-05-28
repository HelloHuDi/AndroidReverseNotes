package kotlinx.coroutines;

import kotlinx.coroutines.p700a.C44608o;
import kotlinx.coroutines.p701c.C36635i;
import kotlinx.coroutines.p701c.C36636j;
import p000a.C0220l;
import p000a.C25278q;
import p000a.C37088p;
import p000a.C37088p.C37087a;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p002c.C36927c;
import p000a.p002c.C41366e;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00060\u0002j\u0002`\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u001d\u0010\u000f\u001a\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\n\u0010\u0013\u001a\u0004\u0018\u00010\u000eH&R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, dWq = {"Lkotlinx/coroutines/DispatchedTask;", "T", "Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/SchedulerTask;", "resumeMode", "", "(I)V", "delegate", "Lkotlin/coroutines/Continuation;", "getDelegate", "()Lkotlin/coroutines/Continuation;", "getExceptionalResult", "", "state", "", "getSuccessfulResult", "(Ljava/lang/Object;)Ljava/lang/Object;", "run", "", "takeState", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.an */
public abstract class C46846an<T> extends C36635i {
    public int BQd;

    public abstract Object ekO();

    public abstract C36927c<T> ekR();

    public C46846an(int i) {
        this.BQd = i;
    }

    /* renamed from: ec */
    public <T> T mo71482ec(Object obj) {
        return obj;
    }

    /* renamed from: eg */
    public static Throwable m89081eg(Object obj) {
        C31195q c31195q = (C31195q) (!(obj instanceof C31195q) ? null : obj);
        return c31195q != null ? c31195q.cause : null;
    }

    public final void run() {
        C36636j c36636j = this.BSN;
        C41366e dWv;
        Object b;
        Throwable els;
        try {
            C36927c ekR = ekR();
            if (ekR == null) {
                throw new C44941v("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<T>");
            }
            C37087a c37087a;
            C37091y c37091y;
            C31187al c31187al = (C31187al) ekR;
            C36927c c36927c = c31187al.BQb;
            dWv = c36927c.dWv();
            C41157bc c41157bc = C6102bo.m9607UY(this.BQd) ? (C41157bc) dWv.get(C41157bc.BQx) : null;
            Object ekO = ekO();
            b = C44608o.m81028b(dWv, c31187al.BPZ);
            if (c41157bc != null) {
                if (!c41157bc.isActive()) {
                    els = c41157bc.els();
                    c37087a = C37088p.AUp;
                    c36927c.mo45dn(C37088p.m62044dl(C25278q.m39843n(els)));
                    c37091y = C37091y.AUy;
                    C44608o.m81027a(dWv, b);
                    c36636j.emj();
                }
            }
            els = C46846an.m89081eg(ekO);
            if (els != null) {
                c37087a = C37088p.AUp;
                c36927c.mo45dn(C37088p.m62044dl(C25278q.m39843n(els)));
            } else {
                Object ec = mo71482ec(ekO);
                c37087a = C37088p.AUp;
                c36927c.mo45dn(C37088p.m62044dl(ec));
            }
            c37091y = C37091y.AUy;
            C44608o.m81027a(dWv, b);
            c36636j.emj();
        } catch (Throwable th) {
            c36636j.emj();
        }
    }
}
