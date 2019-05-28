package kotlinx.coroutines;

import a.c.e;
import a.f.a.m;
import a.f.b.j;
import a.f.b.z;
import a.l;
import a.p;
import a.q;
import a.y;
import kotlinx.coroutines.a.o;
import kotlinx.coroutines.b.a;

@l(dWo = {1, 1, 13}, dWp = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0005B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0015\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0000¢\u0006\u0002\b\u001cJ\r\u0010\u001d\u001a\u00020\u0019H\u0000¢\u0006\u0002\b\u001eJ\r\u0010\u001f\u001a\u00020 H\u0010¢\u0006\u0002\b!J\u0012\u0010\"\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010\u001bH\u0014J\u0015\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J'\u0010(\u001a\u00020\u00192\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\tH\u0010¢\u0006\u0002\b-J\b\u0010.\u001a\u00020\u0019H\u0014J\r\u0010/\u001a\u00020\u0019H\u0000¢\u0006\u0002\b0J\u001c\u00101\u001a\u00020\u00192\f\u00102\u001a\b\u0012\u0004\u0012\u00028\u000003ø\u0001\u0000¢\u0006\u0002\u0010&JM\u00104\u001a\u00020\u0019\"\u0004\b\u0001\u001052\u0006\u00104\u001a\u0002062\u0006\u00107\u001a\u0002H52'\u00108\u001a#\b\u0001\u0012\u0004\u0012\u0002H5\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010*09¢\u0006\u0002\b:ø\u0001\u0000¢\u0006\u0002\u0010;J4\u00104\u001a\u00020\u00192\u0006\u00104\u001a\u0002062\u001c\u00108\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010*0<ø\u0001\u0000¢\u0006\u0002\u0010=R\u0017\u0010\u000b\u001a\u00020\u0007¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00138PX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0006\u001a\u00020\u00078\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006>"}, dWq = {"Lkotlinx/coroutines/AbstractCoroutine;", "T", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/CoroutineScope;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "active", "", "(Lkotlin/coroutines/CoroutineContext;Z)V", "context", "context$annotations", "()V", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "getCoroutineContext", "defaultResumeMode", "", "getDefaultResumeMode$kotlinx_coroutines_core", "()I", "isActive", "()Z", "handleOnCompletionException", "", "exception", "", "handleOnCompletionException$kotlinx_coroutines_core", "initParentJob", "initParentJob$kotlinx_coroutines_core", "nameString", "", "nameString$kotlinx_coroutines_core", "onCancellation", "cause", "onCompleted", "value", "(Ljava/lang/Object;)V", "onCompletedExceptionally", "onCompletionInternal", "state", "", "mode", "suppressed", "onCompletionInternal$kotlinx_coroutines_core", "onStart", "onStartInternal", "onStartInternal$kotlinx_coroutines_core", "resumeWith", "result", "Lkotlin/Result;", "start", "R", "Lkotlinx/coroutines/CoroutineStart;", "receiver", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineStart;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/Function1;", "(Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"})
public abstract class c<T> extends bg implements a.c.c<T>, ac, bc {
    private final e BPx = this.BPy.plus(this);
    protected final e BPy;

    public c(e eVar, boolean z) {
        j.p(eVar, "parentContext");
        super(z);
        this.BPy = eVar;
    }

    public final e dWv() {
        return this.BPx;
    }

    public final e ekT() {
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

    public final void eb(Object obj) {
        if (obj instanceof q) {
            j.p(((q) obj).cause, "exception");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:1:0x0005 A:{LOOP_START} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dn(Object obj) {
        Throwable th = null;
        Object ed = r.ed(obj);
        while (true) {
            switch (super.L(elt(), ed)) {
                case 0:
                    String str = "Job " + this + " is already complete or completing, but is being completed with " + ed;
                    if (!(ed instanceof q)) {
                        ed = null;
                    }
                    q qVar = (q) ed;
                    if (qVar != null) {
                        th = qVar.cause;
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

    public final void u(Throwable th) {
        j.p(th, "exception");
        z.a(this.BPy, th, this);
    }

    public final String ekV() {
        String a = v.a(this.BPx);
        if (a == null) {
            return super.ekV();
        }
        return "\"" + a + "\":" + super.ekV();
    }

    public final <R> void a(ad adVar, R r, m<? super R, ? super a.c.c<? super T>, ? extends Object> mVar) {
        j.p(adVar, "start");
        j.p(mVar, "block");
        bc bcVar = (bc) this.BPy.get(bc.BQx);
        if ((this.BQA == null ? 1 : null) == null) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (bcVar == null) {
            this.BQA = bl.BQP;
        } else {
            Object obj;
            bcVar.start();
            m a = bcVar.a(this);
            this.BQA = a;
            if (elt() instanceof ay) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                a.dispose();
                this.BQA = bl.BQP;
            }
        }
        a.c.c cVar = this;
        j.p(mVar, "block");
        j.p(cVar, "completion");
        switch (ae.pCY[adVar.ordinal()]) {
            case 1:
                a.b(mVar, r, cVar);
                return;
            case 2:
                j.p(mVar, "receiver$0");
                j.p(cVar, "completion");
                a.c.c c = a.c.a.c.c(a.c.a.c.a(mVar, r, cVar));
                y yVar = y.AUy;
                p.a aVar = p.AUp;
                c.dn(p.dl(yVar));
                return;
            case 3:
                j.p(mVar, "receiver$0");
                j.p(cVar, "completion");
                e dWv;
                Object b;
                p.a aVar2;
                try {
                    dWv = cVar.dWv();
                    b = o.b(dWv, null);
                    a.c.a.a m = ((m) z.dt(mVar)).m(r, cVar);
                    o.a(dWv, b);
                    if (m != a.c.a.a.COROUTINE_SUSPENDED) {
                        aVar2 = p.AUp;
                        cVar.dn(p.dl(m));
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    aVar2 = p.AUp;
                    cVar.dn(p.dl(q.n(th)));
                    return;
                }
            case 4:
                return;
            default:
                throw new a.m();
        }
    }
}
