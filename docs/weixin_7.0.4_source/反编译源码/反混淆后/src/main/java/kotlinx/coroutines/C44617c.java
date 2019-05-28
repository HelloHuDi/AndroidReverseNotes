package kotlinx.coroutines;

import kotlinx.coroutines.p1127b.C16453a;
import kotlinx.coroutines.p700a.C44608o;
import p000a.C0220l;
import p000a.C25278q;
import p000a.C31824m;
import p000a.C37088p;
import p000a.C37088p.C37087a;
import p000a.C37091y;
import p000a.p002c.C36927c;
import p000a.p002c.C41366e;
import p000a.p002c.p773a.C25040a;
import p000a.p002c.p773a.C25042c;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C0014z;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0005B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0015\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0000¢\u0006\u0002\b\u001cJ\r\u0010\u001d\u001a\u00020\u0019H\u0000¢\u0006\u0002\b\u001eJ\r\u0010\u001f\u001a\u00020 H\u0010¢\u0006\u0002\b!J\u0012\u0010\"\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010\u001bH\u0014J\u0015\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J'\u0010(\u001a\u00020\u00192\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\tH\u0010¢\u0006\u0002\b-J\b\u0010.\u001a\u00020\u0019H\u0014J\r\u0010/\u001a\u00020\u0019H\u0000¢\u0006\u0002\b0J\u001c\u00101\u001a\u00020\u00192\f\u00102\u001a\b\u0012\u0004\u0012\u00028\u000003ø\u0001\u0000¢\u0006\u0002\u0010&JM\u00104\u001a\u00020\u0019\"\u0004\b\u0001\u001052\u0006\u00104\u001a\u0002062\u0006\u00107\u001a\u0002H52'\u00108\u001a#\b\u0001\u0012\u0004\u0012\u0002H5\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010*09¢\u0006\u0002\b:ø\u0001\u0000¢\u0006\u0002\u0010;J4\u00104\u001a\u00020\u00192\u0006\u00104\u001a\u0002062\u001c\u00108\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010*0<ø\u0001\u0000¢\u0006\u0002\u0010=R\u0017\u0010\u000b\u001a\u00020\u0007¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00138PX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0006\u001a\u00020\u00078\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006>"}, dWq = {"Lkotlinx/coroutines/AbstractCoroutine;", "T", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/CoroutineScope;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "active", "", "(Lkotlin/coroutines/CoroutineContext;Z)V", "context", "context$annotations", "()V", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "getCoroutineContext", "defaultResumeMode", "", "getDefaultResumeMode$kotlinx_coroutines_core", "()I", "isActive", "()Z", "handleOnCompletionException", "", "exception", "", "handleOnCompletionException$kotlinx_coroutines_core", "initParentJob", "initParentJob$kotlinx_coroutines_core", "nameString", "", "nameString$kotlinx_coroutines_core", "onCancellation", "cause", "onCompleted", "value", "(Ljava/lang/Object;)V", "onCompletedExceptionally", "onCompletionInternal", "state", "", "mode", "suppressed", "onCompletionInternal$kotlinx_coroutines_core", "onStart", "onStartInternal", "onStartInternal$kotlinx_coroutines_core", "resumeWith", "result", "Lkotlin/Result;", "start", "R", "Lkotlinx/coroutines/CoroutineStart;", "receiver", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineStart;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/Function1;", "(Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.c */
public abstract class C44617c<T> extends C16456bg implements C36927c<T>, C36622ac, C41157bc {
    private final C41366e BPx = this.BPy.plus(this);
    protected final C41366e BPy;

    public C44617c(C41366e c41366e, boolean z) {
        C25052j.m39376p(c41366e, "parentContext");
        super(z);
        this.BPy = c41366e;
    }

    public final C41366e dWv() {
        return this.BPx;
    }

    public final C41366e ekT() {
        return this.BPx;
    }

    public final boolean isActive() {
        return super.isActive();
    }

    /* Access modifiers changed, original: protected */
    public void onStart() {
    }

    public final void ekU() {
        onStart();
    }

    /* renamed from: eb */
    public final void mo30332eb(Object obj) {
        if (obj instanceof C31195q) {
            C25052j.m39376p(((C31195q) obj).cause, "exception");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:1:0x0005 A:{LOOP_START} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: dn */
    public final void mo45dn(Object obj) {
        Throwable th = null;
        Object ed = C41162r.m71594ed(obj);
        while (true) {
            switch (super.mo30328L(elt(), ed)) {
                case 0:
                    String str = "Job " + this + " is already complete or completing, but is being completed with " + ed;
                    if (!(ed instanceof C31195q)) {
                        ed = null;
                    }
                    C31195q c31195q = (C31195q) ed;
                    if (c31195q != null) {
                        th = c31195q.cause;
                    }
                    throw new IllegalStateException(str, th);
                case 1:
                case 2:
                    return;
                case 3:
                    break;
                default:
                    throw new IllegalStateException("unexpected result".toString());
            }
        }
    }

    /* renamed from: u */
    public final void mo30343u(Throwable th) {
        C25052j.m39376p(th, "exception");
        C16467z.m25274a(this.BPy, th, this);
    }

    public final String ekV() {
        String a = C46852v.m89093a(this.BPx);
        if (a == null) {
            return super.ekV();
        }
        return "\"" + a + "\":" + super.ekV();
    }

    /* renamed from: a */
    public final <R> void mo71481a(C6098ad c6098ad, R r, C31591m<? super R, ? super C36927c<? super T>, ? extends Object> c31591m) {
        C25052j.m39376p(c6098ad, "start");
        C25052j.m39376p(c31591m, "block");
        C41157bc c41157bc = (C41157bc) this.BPy.get(C41157bc.BQx);
        if ((this.BQA == null ? 1 : null) == null) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (c41157bc == null) {
            this.BQA = C41361bl.BQP;
        } else {
            Object obj;
            c41157bc.start();
            C44622m a = c41157bc.mo30330a(this);
            this.BQA = a;
            if (elt() instanceof C44612ay) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                a.dispose();
                this.BQA = C41361bl.BQP;
            }
        }
        C36927c c36927c = this;
        C25052j.m39376p(c31591m, "block");
        C25052j.m39376p(c36927c, "completion");
        switch (C6099ae.pCY[c6098ad.ordinal()]) {
            case 1:
                C16453a.m25236b(c31591m, r, c36927c);
                return;
            case 2:
                C25052j.m39376p(c31591m, "receiver$0");
                C25052j.m39376p(c36927c, "completion");
                C36927c c = C25042c.m39365c(C25042c.m39364a(c31591m, r, c36927c));
                C37091y c37091y = C37091y.AUy;
                C37087a c37087a = C37088p.AUp;
                c.mo45dn(C37088p.m62044dl(c37091y));
                return;
            case 3:
                C25052j.m39376p(c31591m, "receiver$0");
                C25052j.m39376p(c36927c, "completion");
                C41366e dWv;
                Object b;
                C37087a c37087a2;
                try {
                    dWv = c36927c.dWv();
                    b = C44608o.m81028b(dWv, null);
                    C25040a m = ((C31591m) C0014z.m8dt(c31591m)).mo212m(r, c36927c);
                    C44608o.m81027a(dWv, b);
                    if (m != C25040a.COROUTINE_SUSPENDED) {
                        c37087a2 = C37088p.AUp;
                        c36927c.mo45dn(C37088p.m62044dl(m));
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    c37087a2 = C37088p.AUp;
                    c36927c.mo45dn(C37088p.m62044dl(C25278q.m39843n(th)));
                    return;
                }
            case 4:
                return;
            default:
                throw new C31824m();
        }
    }
}
