package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.coroutines.C41159bu.C24590a;
import kotlinx.coroutines.p700a.C44608o;
import kotlinx.coroutines.p700a.C46845m;
import p000a.C0220l;
import p000a.C25278q;
import p000a.C37088p;
import p000a.C37088p.C37087a;
import p000a.C37091y;
import p000a.p002c.C36927c;
import p000a.p002c.C41366e;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0004\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0000\u001a.\u0010\n\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00060\f2\u0006\u0010\r\u001a\u00020\tH\u0000\u001a%\u0010\u000e\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\f2\u0006\u0010\u000f\u001a\u0002H\u0006H\u0000¢\u0006\u0002\u0010\u0010\u001a \u0010\u0011\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u001a%\u0010\u0014\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\f2\u0006\u0010\u000f\u001a\u0002H\u0006H\u0000¢\u0006\u0002\u0010\u0010\u001a \u0010\u0015\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u001a\u0012\u0010\u0016\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020\u00050\u0018H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003¨\u0006\u0019"}, dWq = {"UNDEFINED", "Lkotlinx/coroutines/internal/Symbol;", "UNDEFINED$annotations", "()V", "dispatch", "", "T", "Lkotlinx/coroutines/DispatchedTask;", "mode", "", "resume", "delegate", "Lkotlin/coroutines/Continuation;", "useMode", "resumeCancellable", "value", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "resumeCancellableWithException", "exception", "", "resumeDirect", "resumeDirectWithException", "yieldUndispatched", "", "Lkotlinx/coroutines/DispatchedContinuation;", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.am */
public final class C16448am {
    private static final C46845m BQc = new C46845m("UNDEFINED");

    static {
        AppMethodBeat.m2504i(118583);
        AppMethodBeat.m2505o(118583);
    }

    /* renamed from: a */
    public static final <T> void m25224a(C36927c<? super T> c36927c, T t) {
        AppMethodBeat.m2504i(118577);
        C25052j.m39376p(c36927c, "receiver$0");
        if (c36927c instanceof C31187al) {
            C31187al c31187al = (C31187al) c36927c;
            if (c31187al.BQa.mo41387b(c31187al.dWv())) {
                c31187al.BPs = t;
                c31187al.BQd = 1;
                c31187al.BQa.mo30313a(c31187al.dWv(), c31187al);
                AppMethodBeat.m2505o(118577);
                return;
            }
            C41159bu c41159bu = C41159bu.BQT;
            C24590a c24590a = (C24590a) C41159bu.BQS.get();
            if (c24590a.csi) {
                c31187al.BPs = t;
                c31187al.BQd = 1;
                c24590a.BQU.addLast(c31187al);
                AppMethodBeat.m2505o(118577);
                return;
            }
            C25052j.m39375o(c24590a, "eventLoop");
            Throwable els;
            C41366e dWv;
            Object b;
            try {
                int i;
                c24590a.csi = true;
                C41157bc c41157bc = (C41157bc) c31187al.dWv().get(C41157bc.BQx);
                if (c41157bc == null || c41157bc.isActive()) {
                    boolean i2 = false;
                } else {
                    els = c41157bc.els();
                    C37087a c37087a = C37088p.AUp;
                    c31187al.mo45dn(C37088p.m62044dl(C25278q.m39843n(els)));
                    i2 = 1;
                }
                if (i2 == 0) {
                    dWv = c31187al.dWv();
                    b = C44608o.m81028b(dWv, c31187al.BPZ);
                    C36927c c36927c2 = c31187al.BQb;
                    C37087a c37087a2 = C37088p.AUp;
                    c36927c2.mo45dn(C37088p.m62044dl(t));
                    C37091y c37091y = C37091y.AUy;
                    C44608o.m81027a(dWv, b);
                }
                while (true) {
                    Runnable runnable = (Runnable) c24590a.BQU.elE();
                    if (runnable == null) {
                        c24590a.csi = false;
                        AppMethodBeat.m2505o(118577);
                        return;
                    }
                    runnable.run();
                }
            } catch (Throwable els2) {
                Throwable th = els2;
                try {
                    c24590a.BQU.clear();
                    els2 = new C24585ak("Unexpected exception in undispatched event loop, clearing pending tasks", th);
                    AppMethodBeat.m2505o(118577);
                } catch (Throwable th2) {
                    c24590a.csi = false;
                    AppMethodBeat.m2505o(118577);
                }
            }
        } else {
            C37087a c37087a3 = C37088p.AUp;
            c36927c.mo45dn(C37088p.m62044dl(t));
            AppMethodBeat.m2505o(118577);
        }
    }

    /* renamed from: a */
    public static final <T> void m25225a(C36927c<? super T> c36927c, Throwable th) {
        AppMethodBeat.m2504i(118578);
        C25052j.m39376p(c36927c, "receiver$0");
        C25052j.m39376p(th, "exception");
        if (c36927c instanceof C31187al) {
            C31187al c31187al = (C31187al) c36927c;
            C41366e dWv = c31187al.BQb.dWv();
            C31195q c31195q = new C31195q(th);
            if (c31187al.BQa.mo41387b(dWv)) {
                c31187al.BPs = new C31195q(th);
                c31187al.BQd = 1;
                c31187al.BQa.mo30313a(dWv, c31187al);
                AppMethodBeat.m2505o(118578);
                return;
            }
            C41159bu c41159bu = C41159bu.BQT;
            C24590a c24590a = (C24590a) C41159bu.BQS.get();
            if (c24590a.csi) {
                c31187al.BPs = c31195q;
                c31187al.BQd = 1;
                c24590a.BQU.addLast(c31187al);
                AppMethodBeat.m2505o(118578);
                return;
            }
            C25052j.m39375o(c24590a, "eventLoop");
            Throwable els;
            C41366e dWv2;
            Object b;
            try {
                int i;
                c24590a.csi = true;
                C41157bc c41157bc = (C41157bc) c31187al.dWv().get(C41157bc.BQx);
                if (c41157bc == null || c41157bc.isActive()) {
                    boolean i2 = false;
                } else {
                    els = c41157bc.els();
                    C37087a c37087a = C37088p.AUp;
                    c31187al.mo45dn(C37088p.m62044dl(C25278q.m39843n(els)));
                    i2 = 1;
                }
                if (i2 == 0) {
                    dWv2 = c31187al.dWv();
                    b = C44608o.m81028b(dWv2, c31187al.BPZ);
                    C36927c c36927c2 = c31187al.BQb;
                    C37087a c37087a2 = C37088p.AUp;
                    c36927c2.mo45dn(C37088p.m62044dl(C25278q.m39843n(th)));
                    C37091y c37091y = C37091y.AUy;
                    C44608o.m81027a(dWv2, b);
                }
                while (true) {
                    Runnable runnable = (Runnable) c24590a.BQU.elE();
                    if (runnable == null) {
                        c24590a.csi = false;
                        AppMethodBeat.m2505o(118578);
                        return;
                    }
                    runnable.run();
                }
            } catch (Throwable els2) {
                Throwable th2 = els2;
                try {
                    c24590a.BQU.clear();
                    els2 = new C24585ak("Unexpected exception in undispatched event loop, clearing pending tasks", th2);
                    AppMethodBeat.m2505o(118578);
                } catch (Throwable th3) {
                    c24590a.csi = false;
                    AppMethodBeat.m2505o(118578);
                }
            }
        } else {
            C37087a c37087a3 = C37088p.AUp;
            c36927c.mo45dn(C37088p.m62044dl(C25278q.m39843n(th)));
            AppMethodBeat.m2505o(118578);
        }
    }

    /* renamed from: b */
    public static final <T> void m25228b(C36927c<? super T> c36927c, T t) {
        AppMethodBeat.m2504i(118579);
        C25052j.m39376p(c36927c, "receiver$0");
        if (c36927c instanceof C31187al) {
            C36927c c36927c2 = ((C31187al) c36927c).BQb;
            C37087a c37087a = C37088p.AUp;
            c36927c2.mo45dn(C37088p.m62044dl(t));
            AppMethodBeat.m2505o(118579);
            return;
        }
        C37087a c37087a2 = C37088p.AUp;
        c36927c.mo45dn(C37088p.m62044dl(t));
        AppMethodBeat.m2505o(118579);
    }

    /* renamed from: b */
    public static final <T> void m25229b(C36927c<? super T> c36927c, Throwable th) {
        AppMethodBeat.m2504i(118580);
        C25052j.m39376p(c36927c, "receiver$0");
        C25052j.m39376p(th, "exception");
        if (c36927c instanceof C31187al) {
            C36927c c36927c2 = ((C31187al) c36927c).BQb;
            C37087a c37087a = C37088p.AUp;
            c36927c2.mo45dn(C37088p.m62044dl(C25278q.m39843n(th)));
            AppMethodBeat.m2505o(118580);
            return;
        }
        C37087a c37087a2 = C37088p.AUp;
        c36927c.mo45dn(C37088p.m62044dl(C25278q.m39843n(th)));
        AppMethodBeat.m2505o(118580);
    }

    /* renamed from: a */
    public static final <T> void m25226a(C46846an<? super T> c46846an, int i) {
        Object obj = 1;
        AppMethodBeat.m2504i(118581);
        C25052j.m39376p(c46846an, "receiver$0");
        C36927c ekR = c46846an.ekR();
        if (!(i == 0 || i == 1)) {
            obj = null;
        }
        if (obj != null && (ekR instanceof C31187al) && C6102bo.m9607UY(i) == C6102bo.m9607UY(c46846an.BQd)) {
            C24596w c24596w = ((C31187al) ekR).BQa;
            C41366e dWv = ekR.dWv();
            if (c24596w.mo41387b(dWv)) {
                c24596w.mo30313a(dWv, c46846an);
                AppMethodBeat.m2505o(118581);
                return;
            }
            C41159bu c41159bu = C41159bu.BQT;
            C41159bu.m71592a(c46846an);
            AppMethodBeat.m2505o(118581);
            return;
        }
        C16448am.m25227a(c46846an, ekR, i);
        AppMethodBeat.m2505o(118581);
    }

    /* renamed from: a */
    public static final <T> void m25227a(C46846an<? super T> c46846an, C36927c<? super T> c36927c, int i) {
        AppMethodBeat.m2504i(118582);
        C25052j.m39376p(c46846an, "receiver$0");
        C25052j.m39376p(c36927c, "delegate");
        Object ekO = c46846an.ekO();
        Throwable eg = C46846an.m89081eg(ekO);
        if (eg != null) {
            C6102bo.m9609a((C36927c) c36927c, eg, i);
            AppMethodBeat.m2505o(118582);
            return;
        }
        C6102bo.m9608a((C36927c) c36927c, c46846an.mo71482ec(ekO), i);
        AppMethodBeat.m2505o(118582);
    }
}
