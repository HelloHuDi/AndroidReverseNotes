package kotlinx.coroutines;

import a.c.c;
import a.f.a.b;
import a.f.b.j;
import a.l;
import a.y;
import com.facebook.internal.AnalyticsEvents;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0019\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\u001c\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\"\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\f2\u0006\u0010\"\u001a\u00020\u0006H\u0004J\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u0006H\u0002J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&H\u0016J\n\u0010'\u001a\u0004\u0018\u00010\fH\u0001J\u0010\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u001bH\u0002J\u0017\u0010*\u001a\u00020\u001e2\b\u0010%\u001a\u0004\u0018\u00010&H\u0000¢\u0006\u0002\b+J/\u0010,\u001a\u00020\u001e2'\u0010-\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001e0.j\u0002`1J\u001f\u00102\u001a\u0002032\u0014\u00104\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u001e0.H\bJ1\u00105\u001a\u0002062'\u0010-\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001e0.j\u0002`1H\u0002J\b\u00107\u001a\u000208H\u0014J\u001a\u00109\u001a\u00020\u001e2\b\u0010:\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0004J\u001e\u0010;\u001a\u00020\u001e2\f\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000=H\u0016ø\u0001\u0000¢\u0006\u0002\u0010>J\u001d\u0010?\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u0006H\u0000¢\u0006\u0002\b@J\b\u0010A\u001a\u000208H\u0002J\n\u0010B\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010C\u001a\u000208H\u0016J\b\u0010D\u001a\u00020\u0010H\u0002J\b\u0010E\u001a\u00020\u0010H\u0002J\u001a\u0010F\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\fH\u0004J\"\u0010G\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\b\u0010:\u001a\u0004\u0018\u00010\f2\u0006\u0010\"\u001a\u00020\u0006H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0013\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\f8@X\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u0002\u0004\n\u0002\b\u0019¨\u0006H"}, dWq = {"Lkotlinx/coroutines/AbstractContinuation;", "T", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlin/coroutines/Continuation;", "delegate", "resumeMode", "", "(Lkotlin/coroutines/Continuation;I)V", "_decision", "Lkotlinx/atomicfu/AtomicInt;", "_state", "Lkotlinx/atomicfu/AtomicRef;", "", "getDelegate", "()Lkotlin/coroutines/Continuation;", "isActive", "", "()Z", "isCancelled", "isCompleted", "parentHandle", "Lkotlinx/coroutines/DisposableHandle;", "state", "getState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "cancel", "cause", "", "cancelImpl", "completeStateUpdate", "", "expect", "Lkotlinx/coroutines/NotCompleted;", "update", "mode", "dispatchResume", "getContinuationCancellationCause", "parent", "Lkotlinx/coroutines/Job;", "getResult", "handleException", "exception", "initParentJobInternal", "initParentJobInternal$kotlinx_coroutines_core", "invokeOnCancellation", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "loopOnState", "", "block", "makeHandler", "Lkotlinx/coroutines/CancelHandler;", "nameString", "", "resumeImpl", "proposedUpdate", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "resumeWithExceptionMode", "resumeWithExceptionMode$kotlinx_coroutines_core", "stateString", "takeState", "toString", "tryResume", "trySuspend", "tryUpdateStateToFinal", "updateStateToFinal", "kotlinx-coroutines-core"})
public abstract class a<T> extends an<T> implements c<T> {
    private static final AtomicIntegerFieldUpdater BPr = AtomicIntegerFieldUpdater.newUpdater(a.class, "BPq");
    private static final AtomicReferenceFieldUpdater BPt = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "BPs");
    private volatile int BPq = 0;
    public volatile Object BPs = b.BPw;
    public volatile ap BPu;
    public final c<T> BPv;

    public final c<T> ekR() {
        return this.BPv;
    }

    public a(c<? super T> cVar) {
        j.p(cVar, "delegate");
        super(1);
        this.BPv = cVar;
    }

    public static Throwable a(bc bcVar) {
        j.p(bcVar, "parent");
        return bcVar.els();
    }

    public final boolean ekP() {
        do {
            switch (this.BPq) {
                case 0:
                    break;
                case 2:
                    return false;
                default:
                    throw new IllegalStateException("Already suspended".toString());
            }
        } while (!BPr.compareAndSet(this, 0, 1));
        return true;
    }

    public final void dn(Object obj) {
        l(r.ed(obj), this.BQd);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A:{SYNTHETIC, RETURN, ORIG_RETURN} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void UX(int i) {
        int i2 = 0;
        do {
            switch (this.BPq) {
                case 0:
                    break;
                case 1:
                    break;
                default:
                    throw new IllegalStateException("Already resumed".toString());
            }
            if (i2 != 0) {
                am.a((an) this, i);
                return;
            }
            return;
        } while (!BPr.compareAndSet(this, 0, 2));
        i2 = 1;
        if (i2 != 0) {
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean a(bm bmVar, Object obj, int i) {
        if (!a(bmVar, obj)) {
            return false;
        }
        b(bmVar, obj, i);
        return true;
    }

    private boolean a(bm bmVar, Object obj) {
        j.p(bmVar, "expect");
        if (!(!(obj instanceof bm))) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!BPt.compareAndSet(this, bmVar, obj)) {
            return false;
        } else {
            ap apVar = this.BPu;
            if (apVar != null) {
                apVar.dispose();
                this.BPu = bl.BQP;
            }
            return true;
        }
    }

    private void b(bm bmVar, Object obj, int i) {
        Throwable th;
        Throwable th2 = null;
        j.p(bmVar, "expect");
        if (obj instanceof q) {
            th = obj;
        } else {
            th = null;
        }
        q qVar = (q) th;
        if ((obj instanceof k) && (bmVar instanceof g)) {
            try {
                g gVar = (g) bmVar;
                if (qVar != null) {
                    th2 = qVar.cause;
                }
                gVar.v(th2);
            } catch (Throwable th3) {
                t(new u("Exception in completion handler " + bmVar + " for " + this, th3));
            }
        }
        UX(i);
    }

    private final void t(Throwable th) {
        z.a(dWv(), th, null);
    }

    public String toString() {
        String str;
        StringBuilder append = new StringBuilder().append(ekQ()).append('{');
        Object obj = this.BPs;
        if (obj instanceof bm) {
            str = "Active";
        } else if (obj instanceof k) {
            str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED;
        } else if (obj instanceof q) {
            str = "CompletedExceptionally";
        } else {
            str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED;
        }
        return append.append(str).append("}@").append(af.ee(this)).toString();
    }

    /* Access modifiers changed, original: protected */
    public String ekQ() {
        return af.ef(this);
    }

    public final Object ekO() {
        return this.BPs;
    }

    public final void h(b<? super Throwable, y> bVar) {
        Object obj = null;
        j.p(bVar, "handler");
        g gVar = null;
        while (true) {
            Object obj2 = this.BPs;
            if (obj2 instanceof d) {
                Object obj3;
                g gVar2;
                if (gVar == null) {
                    if (bVar instanceof g) {
                        gVar = (g) bVar;
                    } else {
                        gVar = new az(bVar);
                    }
                    obj3 = gVar;
                    gVar2 = gVar;
                } else {
                    g obj32 = gVar;
                    gVar2 = gVar;
                }
                if (!BPt.compareAndSet(this, obj2, obj32)) {
                    gVar = gVar2;
                } else {
                    return;
                }
            } else if (obj2 instanceof g) {
                throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + bVar + ", already has " + obj2).toString());
            } else if (obj2 instanceof k) {
                Object obj4;
                if (obj2 instanceof q) {
                    obj4 = obj2;
                } else {
                    obj4 = null;
                }
                q qVar = (q) obj4;
                if (qVar != null) {
                    obj = qVar.cause;
                }
                bVar.am(obj);
                return;
            } else {
                return;
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void l(Object obj, int i) {
        Object obj2;
        do {
            obj2 = this.BPs;
            if (!(obj2 instanceof bm)) {
                if (!(obj2 instanceof k)) {
                    throw new IllegalStateException("Already resumed, but proposed with update ".concat(String.valueOf(obj)).toString());
                } else if (obj instanceof q) {
                    t(((q) obj).cause);
                    return;
                } else {
                    return;
                }
            }
        } while (!a((bm) obj2, obj, i));
    }
}
