package kotlinx.coroutines.p700a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001:\u0004BCDEB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u00060\u0000j\u0002`\u000fJ%\u0010\u0019\u001a\u00020\t2\n\u0010\u0018\u001a\u00060\u0000j\u0002`\u000f2\u000e\b\u0004\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u001bH\bJ-\u0010\u001c\u001a\u00020\t2\n\u0010\u0018\u001a\u00060\u0000j\u0002`\u000f2\u0016\u0010\u001d\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u000f\u0012\u0004\u0012\u00020\t0\u001eH\bJ=\u0010\u001f\u001a\u00020\t2\n\u0010\u0018\u001a\u00060\u0000j\u0002`\u000f2\u0016\u0010\u001d\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u000f\u0012\u0004\u0012\u00020\t0\u001e2\u000e\b\u0004\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u001bH\bJ \u0010 \u001a\u00020\t2\n\u0010\u0018\u001a\u00060\u0000j\u0002`\u000f2\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u000fH\u0001J\u0012\u0010!\u001a\u00020\t2\n\u0010\u0018\u001a\u00060\u0000j\u0002`\u000fJ&\u0010\"\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u000f2\n\u0010\u0005\u001a\u00060\u0000j\u0002`\u000f2\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J'\u0010%\u001a\b\u0012\u0004\u0012\u0002H'0&\"\f\b\u0000\u0010'*\u00060\u0000j\u0002`\u000f2\u0006\u0010\u0018\u001a\u0002H'¢\u0006\u0002\u0010(J\n\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010+\u001a\f\u0012\b\u0012\u00060\u0000j\u0002`\u000f0,J\f\u0010-\u001a\u00060\u0000j\u0002`\u000fH\u0002J\u0014\u0010.\u001a\u00020\u00172\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u000fH\u0002J\u0014\u0010/\u001a\u00020\u00172\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u000fH\u0002J\b\u00100\u001a\u00020\u0017H\u0001J\u0006\u00101\u001a\u00020\u0017J%\u00102\u001a\u0002032\n\u0010\u0018\u001a\u00060\u0000j\u0002`\u000f2\u000e\b\u0004\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u001bH\bJ\f\u00104\u001a\u00060\u0000j\u0002`\u000fH\u0002J\b\u00105\u001a\u00020\tH\u0016J\u0018\u00106\u001a\u0004\u0018\u0001H'\"\u0006\b\u0000\u0010'\u0018\u0001H\b¢\u0006\u0002\u0010\rJ,\u00107\u001a\u0004\u0018\u0001H'\"\u0006\b\u0000\u0010'\u0018\u00012\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\t0\u001eH\b¢\u0006\u0002\u00108J\u000e\u00109\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u000fJ\b\u0010:\u001a\u00020\u0007H\u0002J\b\u0010;\u001a\u00020<H\u0016J(\u0010=\u001a\u00020>2\n\u0010\u0018\u001a\u00060\u0000j\u0002`\u000f2\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u000f2\u0006\u0010?\u001a\u000203H\u0001J%\u0010@\u001a\u00020\u00172\n\u0010\u0012\u001a\u00060\u0000j\u0002`\u000f2\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u000fH\u0000¢\u0006\u0002\bAR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0015\u0010\u000e\u001a\u00060\u0000j\u0002`\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0015\u0010\u0014\u001a\u00060\u0000j\u0002`\u000f8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011¨\u0006F"}, dWq = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "", "()V", "_next", "Lkotlinx/atomicfu/AtomicRef;", "_prev", "_removedRef", "Lkotlinx/coroutines/internal/Removed;", "isRemoved", "", "()Z", "next", "getNext", "()Ljava/lang/Object;", "nextNode", "Lkotlinx/coroutines/internal/Node;", "getNextNode", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "prev", "getPrev", "prevNode", "getPrevNode", "addLast", "", "node", "addLastIf", "condition", "Lkotlin/Function0;", "addLastIfPrev", "predicate", "Lkotlin/Function1;", "addLastIfPrevAndIf", "addNext", "addOneIfEmpty", "correctPrev", "op", "Lkotlinx/coroutines/internal/OpDescriptor;", "describeAddLast", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "T", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "describeRemove", "Lkotlinx/coroutines/internal/AtomicDesc;", "describeRemoveFirst", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "findHead", "finishAdd", "finishRemove", "helpDelete", "helpRemove", "makeCondAddOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "markPrev", "remove", "removeFirstIfIsInstanceOf", "removeFirstIfIsInstanceOfOrPeekIf", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "removeFirstOrNull", "removed", "toString", "", "tryCondAddNext", "", "condAdd", "validateNode", "validateNode$kotlinx_coroutines_core", "AbstractAtomicDesc", "AddLastDesc", "CondAddOp", "RemoveFirstDesc", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.a.h */
public class C31179h {
    static final AtomicReferenceFieldUpdater BRq = AtomicReferenceFieldUpdater.newUpdater(C31179h.class, Object.class, "BRp");
    static final AtomicReferenceFieldUpdater BRs = AtomicReferenceFieldUpdater.newUpdater(C31179h.class, Object.class, "BRr");
    private static final AtomicReferenceFieldUpdater BRu = AtomicReferenceFieldUpdater.newUpdater(C31179h.class, Object.class, "BRt");
    volatile Object BRp = this;
    volatile Object BRr = this;
    private volatile Object BRt = null;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b!\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0011\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\u0002j\u0002`\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, dWq = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "newNode", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "oldNext", "complete", "", "affected", "failure", "", "kotlinx-coroutines-core"})
    /* renamed from: kotlinx.coroutines.a.h$a */
    public static abstract class C6095a extends C46843d<C31179h> {
        public C31179h BRv;
        public final C31179h BRw;

        /* renamed from: M */
        public final /* synthetic */ void mo13485M(Object obj, Object obj2) {
            C31179h c31179h = (C31179h) obj;
            C25052j.m39376p(c31179h, "affected");
            Object obj3 = obj2 == null ? 1 : null;
            Object obj4 = obj3 != null ? this.BRw : this.BRv;
            if (obj4 != null && C31179h.BRq.compareAndSet(c31179h, this, obj4) && obj3 != null) {
                C31179h c31179h2 = this.BRw;
                C31179h c31179h3 = this.BRv;
                if (c31179h3 == null) {
                    C25052j.dWJ();
                }
                C31179h.m50256a(c31179h2, c31179h3);
            }
        }

        public C6095a(C31179h c31179h) {
            C25052j.m39376p(c31179h, "newNode");
            this.BRw = c31179h;
        }
    }

    static {
        AppMethodBeat.m2504i(118424);
        AppMethodBeat.m2505o(118424);
    }

    public C31179h() {
        AppMethodBeat.m2504i(118422);
        AppMethodBeat.m2505o(118422);
    }

    /* renamed from: a */
    public static final /* synthetic */ void m50256a(C31179h c31179h, C31179h c31179h2) {
        AppMethodBeat.m2504i(118423);
        c31179h.m50257c(c31179h2);
        AppMethodBeat.m2505o(118423);
    }

    private final C24580l elI() {
        AppMethodBeat.m2504i(118410);
        C24580l c24580l = (C24580l) this.BRt;
        if (c24580l == null) {
            c24580l = new C24580l(this);
            BRu.lazySet(this, c24580l);
        }
        AppMethodBeat.m2505o(118410);
        return c24580l;
    }

    public final C31179h elK() {
        AppMethodBeat.m2504i(139014);
        C31179h em = C41150g.m71584em(elJ());
        AppMethodBeat.m2505o(139014);
        return em;
    }

    /* renamed from: b */
    public final boolean mo50939b(C31179h c31179h) {
        AppMethodBeat.m2504i(118414);
        C25052j.m39376p(c31179h, "node");
        BRs.lazySet(c31179h, this);
        BRq.lazySet(c31179h, this);
        while (elJ() == this) {
            if (BRq.compareAndSet(this, this, c31179h)) {
                c31179h.m50257c(this);
                AppMethodBeat.m2505o(118414);
                return true;
            }
        }
        AppMethodBeat.m2505o(118414);
        return false;
    }

    /* renamed from: a */
    public final int mo50937a(C31179h c31179h, C31179h c31179h2, C6095a c6095a) {
        AppMethodBeat.m2504i(118415);
        C25052j.m39376p(c31179h, "node");
        C25052j.m39376p(c31179h2, "next");
        C25052j.m39376p(c6095a, "condAdd");
        BRs.lazySet(c31179h, this);
        BRq.lazySet(c31179h, c31179h2);
        c6095a.BRv = c31179h2;
        if (!BRq.compareAndSet(this, c31179h2, c6095a)) {
            AppMethodBeat.m2505o(118415);
            return 0;
        } else if (c6095a.mo50949el(this) == null) {
            AppMethodBeat.m2505o(118415);
            return 1;
        } else {
            AppMethodBeat.m2505o(118415);
            return 2;
        }
    }

    public boolean aQp() {
        C31179h elJ;
        C44941v c44941v;
        AppMethodBeat.m2504i(118416);
        do {
            elJ = elJ();
            if (elJ instanceof C24580l) {
                AppMethodBeat.m2505o(118416);
                return false;
            } else if (elJ == this) {
                AppMethodBeat.m2505o(118416);
                return false;
            } else if (elJ == null) {
                c44941v = new C44941v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                AppMethodBeat.m2505o(118416);
                throw c44941v;
            }
        } while (!BRq.compareAndSet(this, elJ, elJ.elI()));
        elJ = elJ;
        C31179h elM = elM();
        Object obj = this.BRp;
        if (obj == null) {
            c44941v = new C44941v("null cannot be cast to non-null type kotlinx.coroutines.internal.Removed");
            AppMethodBeat.m2505o(118416);
            throw c44941v;
        }
        Object obj2 = null;
        loop1:
        while (true) {
            C31179h c31179h = ((C24580l) obj).BRF;
            C31179h c31179h2 = elM;
            while (true) {
                obj = c31179h.elJ();
                if (obj instanceof C24580l) {
                    break;
                }
                C31179h elJ2 = c31179h2.elJ();
                if (elJ2 instanceof C24580l) {
                    if (obj2 != null) {
                        c31179h2.elM();
                        BRq.compareAndSet(obj2, c31179h2, ((C24580l) elJ2).BRF);
                        c31179h2 = obj2;
                        obj2 = null;
                    } else {
                        c31179h2 = C41150g.m71584em(c31179h2.BRr);
                    }
                } else if (elJ2 != this) {
                    if (elJ2 != null) {
                        elJ2 = elJ2;
                        if (elJ2 == c31179h) {
                            break loop1;
                        }
                        obj2 = c31179h2;
                        c31179h2 = elJ2;
                    } else {
                        c44941v = new C44941v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                        AppMethodBeat.m2505o(118416);
                        throw c44941v;
                    }
                } else if (BRq.compareAndSet(c31179h2, this, c31179h)) {
                    break loop1;
                }
            }
            c31179h.elM();
            elM = c31179h2;
        }
        elJ.m50258d(C41150g.m71584em(this.BRr));
        AppMethodBeat.m2505o(118416);
        return true;
    }

    private final C31179h elN() {
        AppMethodBeat.m2504i(118419);
        C31179h c31179h = this;
        while (!(c31179h instanceof C46844f)) {
            C31179h em = C41150g.m71584em(c31179h.elJ());
            if ((em != ((C31179h) this) ? 1 : null) == null) {
                Throwable illegalStateException = new IllegalStateException("Cannot loop to this while looking for list head".toString());
                AppMethodBeat.m2505o(118419);
                throw illegalStateException;
            }
            c31179h = em;
        }
        AppMethodBeat.m2505o(118419);
        return c31179h;
    }

    /* renamed from: d */
    private final C31179h m50258d(C31179h c31179h) {
        AppMethodBeat.m2504i(118420);
        Object obj = null;
        C31179h c31179h2 = c31179h;
        while (true) {
            C31179h c31179h3 = c31179h2.BRp;
            if (c31179h3 == null) {
                AppMethodBeat.m2505o(118420);
                return c31179h2;
            } else if (c31179h3 instanceof C31184k) {
                ((C31184k) c31179h3).mo50949el(c31179h2);
            } else if (!(c31179h3 instanceof C24580l)) {
                C31179h c31179h4 = this.BRr;
                if (c31179h4 instanceof C24580l) {
                    AppMethodBeat.m2505o(118420);
                    return null;
                } else if (c31179h3 != this) {
                    if (c31179h3 == null) {
                        C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                        AppMethodBeat.m2505o(118420);
                        throw c44941v;
                    }
                    obj = c31179h2;
                    c31179h2 = c31179h3;
                } else if (c31179h4 == c31179h2) {
                    AppMethodBeat.m2505o(118420);
                    return null;
                } else if (BRs.compareAndSet(this, c31179h4, c31179h2) && !(c31179h2.BRr instanceof C24580l)) {
                    AppMethodBeat.m2505o(118420);
                    return null;
                }
            } else if (obj != null) {
                c31179h2.elM();
                BRq.compareAndSet(obj, c31179h2, ((C24580l) c31179h3).BRF);
                c31179h2 = obj;
                obj = null;
            } else {
                c31179h2 = C41150g.m71584em(c31179h2.BRr);
            }
        }
    }

    public String toString() {
        AppMethodBeat.m2504i(118421);
        String str = getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
        AppMethodBeat.m2505o(118421);
        return str;
    }

    public final Object elJ() {
        AppMethodBeat.m2504i(118411);
        while (true) {
            Object obj = this.BRp;
            if (obj instanceof C31184k) {
                ((C31184k) obj).mo50949el(this);
            } else {
                AppMethodBeat.m2505o(118411);
                return obj;
            }
        }
    }

    public final Object elL() {
        Object obj;
        AppMethodBeat.m2504i(118413);
        while (true) {
            obj = this.BRr;
            if (obj instanceof C24580l) {
                AppMethodBeat.m2505o(118413);
                break;
            } else if (obj == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                AppMethodBeat.m2505o(118413);
                throw c44941v;
            } else if (((C31179h) obj).elJ() == this) {
                AppMethodBeat.m2505o(118413);
                break;
            } else {
                m50258d((C31179h) obj);
            }
        }
        return obj;
    }

    /* renamed from: c */
    private final void m50257c(C31179h c31179h) {
        Object obj;
        AppMethodBeat.m2504i(118417);
        do {
            obj = c31179h.BRr;
            if ((obj instanceof C24580l) || elJ() != c31179h) {
                AppMethodBeat.m2505o(118417);
                return;
            }
        } while (!BRs.compareAndSet(c31179h, obj, this));
        if (elJ() instanceof C24580l) {
            if (obj == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                AppMethodBeat.m2505o(118417);
                throw c44941v;
            }
            c31179h.m50258d((C31179h) obj);
        }
        AppMethodBeat.m2505o(118417);
    }

    private final C31179h elM() {
        C31179h c31179h;
        AppMethodBeat.m2504i(118418);
        C31179h elN;
        do {
            c31179h = this.BRr;
            if (c31179h instanceof C24580l) {
                c31179h = ((C24580l) c31179h).BRF;
                AppMethodBeat.m2505o(118418);
                return c31179h;
            }
            if (c31179h == this) {
                elN = elN();
            } else if (c31179h == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                AppMethodBeat.m2505o(118418);
                throw c44941v;
            } else {
                elN = c31179h;
            }
        } while (!BRs.compareAndSet(this, c31179h, elN.elI()));
        c31179h = c31179h;
        AppMethodBeat.m2505o(118418);
        return c31179h;
    }
}
