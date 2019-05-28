package kotlinx.coroutines;

import com.facebook.internal.AnalyticsEvents;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p002c.C36927c;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0019\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\u001c\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\"\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\f2\u0006\u0010\"\u001a\u00020\u0006H\u0004J\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u0006H\u0002J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&H\u0016J\n\u0010'\u001a\u0004\u0018\u00010\fH\u0001J\u0010\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u001bH\u0002J\u0017\u0010*\u001a\u00020\u001e2\b\u0010%\u001a\u0004\u0018\u00010&H\u0000¢\u0006\u0002\b+J/\u0010,\u001a\u00020\u001e2'\u0010-\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001e0.j\u0002`1J\u001f\u00102\u001a\u0002032\u0014\u00104\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u001e0.H\bJ1\u00105\u001a\u0002062'\u0010-\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001e0.j\u0002`1H\u0002J\b\u00107\u001a\u000208H\u0014J\u001a\u00109\u001a\u00020\u001e2\b\u0010:\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0004J\u001e\u0010;\u001a\u00020\u001e2\f\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000=H\u0016ø\u0001\u0000¢\u0006\u0002\u0010>J\u001d\u0010?\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u0006H\u0000¢\u0006\u0002\b@J\b\u0010A\u001a\u000208H\u0002J\n\u0010B\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010C\u001a\u000208H\u0016J\b\u0010D\u001a\u00020\u0010H\u0002J\b\u0010E\u001a\u00020\u0010H\u0002J\u001a\u0010F\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\fH\u0004J\"\u0010G\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\b\u0010:\u001a\u0004\u0018\u00010\f2\u0006\u0010\"\u001a\u00020\u0006H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0013\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\f8@X\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u0002\u0004\n\u0002\b\u0019¨\u0006H"}, dWq = {"Lkotlinx/coroutines/AbstractContinuation;", "T", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlin/coroutines/Continuation;", "delegate", "resumeMode", "", "(Lkotlin/coroutines/Continuation;I)V", "_decision", "Lkotlinx/atomicfu/AtomicInt;", "_state", "Lkotlinx/atomicfu/AtomicRef;", "", "getDelegate", "()Lkotlin/coroutines/Continuation;", "isActive", "", "()Z", "isCancelled", "isCompleted", "parentHandle", "Lkotlinx/coroutines/DisposableHandle;", "state", "getState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "cancel", "cause", "", "cancelImpl", "completeStateUpdate", "", "expect", "Lkotlinx/coroutines/NotCompleted;", "update", "mode", "dispatchResume", "getContinuationCancellationCause", "parent", "Lkotlinx/coroutines/Job;", "getResult", "handleException", "exception", "initParentJobInternal", "initParentJobInternal$kotlinx_coroutines_core", "invokeOnCancellation", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "loopOnState", "", "block", "makeHandler", "Lkotlinx/coroutines/CancelHandler;", "nameString", "", "resumeImpl", "proposedUpdate", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "resumeWithExceptionMode", "resumeWithExceptionMode$kotlinx_coroutines_core", "stateString", "takeState", "toString", "tryResume", "trySuspend", "tryUpdateStateToFinal", "updateStateToFinal", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.a */
public abstract class C46947a<T> extends C46846an<T> implements C36927c<T> {
    private static final AtomicIntegerFieldUpdater BPr = AtomicIntegerFieldUpdater.newUpdater(C46947a.class, "BPq");
    private static final AtomicReferenceFieldUpdater BPt = AtomicReferenceFieldUpdater.newUpdater(C46947a.class, Object.class, "BPs");
    private volatile int BPq = 0;
    public volatile Object BPs = C44614b.BPw;
    public volatile C41155ap BPu;
    public final C36927c<T> BPv;

    public final C36927c<T> ekR() {
        return this.BPv;
    }

    public C46947a(C36927c<? super T> c36927c) {
        C25052j.m39376p(c36927c, "delegate");
        super(1);
        this.BPv = c36927c;
    }

    /* renamed from: a */
    public static Throwable m89802a(C41157bc c41157bc) {
        C25052j.m39376p(c41157bc, "parent");
        return c41157bc.els();
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

    /* renamed from: dn */
    public final void mo45dn(Object obj) {
        mo76260l(C41162r.m71594ed(obj), this.BQd);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A:{SYNTHETIC, RETURN, ORIG_RETURN} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: UX */
    private final void m89801UX(int i) {
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
                C16448am.m25226a((C46846an) this, i);
                return;
            }
            return;
        } while (!BPr.compareAndSet(this, 0, 2));
        i2 = 1;
        if (i2 != 0) {
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final boolean mo76257a(C36629bm c36629bm, Object obj, int i) {
        if (!m89803a(c36629bm, obj)) {
            return false;
        }
        m89804b(c36629bm, obj, i);
        return true;
    }

    /* renamed from: a */
    private boolean m89803a(C36629bm c36629bm, Object obj) {
        C25052j.m39376p(c36629bm, "expect");
        if (!(!(obj instanceof C36629bm))) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!BPt.compareAndSet(this, c36629bm, obj)) {
            return false;
        } else {
            C41155ap c41155ap = this.BPu;
            if (c41155ap != null) {
                c41155ap.dispose();
                this.BPu = C41361bl.BQP;
            }
            return true;
        }
    }

    /* renamed from: b */
    private void m89804b(C36629bm c36629bm, Object obj, int i) {
        Throwable th;
        Throwable th2 = null;
        C25052j.m39376p(c36629bm, "expect");
        if (obj instanceof C31195q) {
            th = obj;
        } else {
            th = null;
        }
        C31195q c31195q = (C31195q) th;
        if ((obj instanceof C44620k) && (c36629bm instanceof C25030g)) {
            try {
                C25030g c25030g = (C25030g) c36629bm;
                if (c31195q != null) {
                    th2 = c31195q.cause;
                }
                c25030g.mo41930v(th2);
            } catch (Throwable th3) {
                m89805t(new C41164u("Exception in completion handler " + c36629bm + " for " + this, th3));
            }
        }
        m89801UX(i);
    }

    /* renamed from: t */
    private final void m89805t(Throwable th) {
        C16467z.m25274a(dWv(), th, null);
    }

    public String toString() {
        String str;
        StringBuilder append = new StringBuilder().append(ekQ()).append('{');
        Object obj = this.BPs;
        if (obj instanceof C36629bm) {
            str = "Active";
        } else if (obj instanceof C44620k) {
            str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED;
        } else if (obj instanceof C31195q) {
            str = "CompletedExceptionally";
        } else {
            str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED;
        }
        return append.append(str).append("}@").append(C36623af.m60717ee(this)).toString();
    }

    /* Access modifiers changed, original: protected */
    public String ekQ() {
        return C36623af.m60718ef(this);
    }

    public final Object ekO() {
        return this.BPs;
    }

    /* renamed from: h */
    public final void mo76259h(C17126b<? super Throwable, C37091y> c17126b) {
        Object obj = null;
        C25052j.m39376p(c17126b, "handler");
        C25030g c25030g = null;
        while (true) {
            Object obj2 = this.BPs;
            if (obj2 instanceof C44618d) {
                Object obj3;
                C25030g c25030g2;
                if (c25030g == null) {
                    if (c17126b instanceof C25030g) {
                        c25030g = (C25030g) c17126b;
                    } else {
                        c25030g = new C44613az(c17126b);
                    }
                    obj3 = c25030g;
                    c25030g2 = c25030g;
                } else {
                    C25030g obj32 = c25030g;
                    c25030g2 = c25030g;
                }
                if (!BPt.compareAndSet(this, obj2, obj32)) {
                    c25030g = c25030g2;
                } else {
                    return;
                }
            } else if (obj2 instanceof C25030g) {
                throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + c17126b + ", already has " + obj2).toString());
            } else if (obj2 instanceof C44620k) {
                Object obj4;
                if (obj2 instanceof C31195q) {
                    obj4 = obj2;
                } else {
                    obj4 = null;
                }
                C31195q c31195q = (C31195q) obj4;
                if (c31195q != null) {
                    obj = c31195q.cause;
                }
                c17126b.mo50am(obj);
                return;
            } else {
                return;
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: l */
    public final void mo76260l(Object obj, int i) {
        Object obj2;
        do {
            obj2 = this.BPs;
            if (!(obj2 instanceof C36629bm)) {
                if (!(obj2 instanceof C44620k)) {
                    throw new IllegalStateException("Already resumed, but proposed with update ".concat(String.valueOf(obj)).toString());
                } else if (obj instanceof C31195q) {
                    m89805t(((C31195q) obj).cause);
                    return;
                } else {
                    return;
                }
            }
        } while (!mo76257a((C36629bm) obj2, obj, i));
    }
}
