package kotlinx.coroutines.a;

import a.f.b.j;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@l(dWo = {1, 1, 13}, dWp = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001:\u0004BCDEB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u00060\u0000j\u0002`\u000fJ%\u0010\u0019\u001a\u00020\t2\n\u0010\u0018\u001a\u00060\u0000j\u0002`\u000f2\u000e\b\u0004\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u001bH\bJ-\u0010\u001c\u001a\u00020\t2\n\u0010\u0018\u001a\u00060\u0000j\u0002`\u000f2\u0016\u0010\u001d\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u000f\u0012\u0004\u0012\u00020\t0\u001eH\bJ=\u0010\u001f\u001a\u00020\t2\n\u0010\u0018\u001a\u00060\u0000j\u0002`\u000f2\u0016\u0010\u001d\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u000f\u0012\u0004\u0012\u00020\t0\u001e2\u000e\b\u0004\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u001bH\bJ \u0010 \u001a\u00020\t2\n\u0010\u0018\u001a\u00060\u0000j\u0002`\u000f2\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u000fH\u0001J\u0012\u0010!\u001a\u00020\t2\n\u0010\u0018\u001a\u00060\u0000j\u0002`\u000fJ&\u0010\"\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u000f2\n\u0010\u0005\u001a\u00060\u0000j\u0002`\u000f2\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J'\u0010%\u001a\b\u0012\u0004\u0012\u0002H'0&\"\f\b\u0000\u0010'*\u00060\u0000j\u0002`\u000f2\u0006\u0010\u0018\u001a\u0002H'¢\u0006\u0002\u0010(J\n\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010+\u001a\f\u0012\b\u0012\u00060\u0000j\u0002`\u000f0,J\f\u0010-\u001a\u00060\u0000j\u0002`\u000fH\u0002J\u0014\u0010.\u001a\u00020\u00172\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u000fH\u0002J\u0014\u0010/\u001a\u00020\u00172\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u000fH\u0002J\b\u00100\u001a\u00020\u0017H\u0001J\u0006\u00101\u001a\u00020\u0017J%\u00102\u001a\u0002032\n\u0010\u0018\u001a\u00060\u0000j\u0002`\u000f2\u000e\b\u0004\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u001bH\bJ\f\u00104\u001a\u00060\u0000j\u0002`\u000fH\u0002J\b\u00105\u001a\u00020\tH\u0016J\u0018\u00106\u001a\u0004\u0018\u0001H'\"\u0006\b\u0000\u0010'\u0018\u0001H\b¢\u0006\u0002\u0010\rJ,\u00107\u001a\u0004\u0018\u0001H'\"\u0006\b\u0000\u0010'\u0018\u00012\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\t0\u001eH\b¢\u0006\u0002\u00108J\u000e\u00109\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u000fJ\b\u0010:\u001a\u00020\u0007H\u0002J\b\u0010;\u001a\u00020<H\u0016J(\u0010=\u001a\u00020>2\n\u0010\u0018\u001a\u00060\u0000j\u0002`\u000f2\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u000f2\u0006\u0010?\u001a\u000203H\u0001J%\u0010@\u001a\u00020\u00172\n\u0010\u0012\u001a\u00060\u0000j\u0002`\u000f2\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u000fH\u0000¢\u0006\u0002\bAR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0015\u0010\u000e\u001a\u00060\u0000j\u0002`\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0015\u0010\u0014\u001a\u00060\u0000j\u0002`\u000f8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011¨\u0006F"}, dWq = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "", "()V", "_next", "Lkotlinx/atomicfu/AtomicRef;", "_prev", "_removedRef", "Lkotlinx/coroutines/internal/Removed;", "isRemoved", "", "()Z", "next", "getNext", "()Ljava/lang/Object;", "nextNode", "Lkotlinx/coroutines/internal/Node;", "getNextNode", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "prev", "getPrev", "prevNode", "getPrevNode", "addLast", "", "node", "addLastIf", "condition", "Lkotlin/Function0;", "addLastIfPrev", "predicate", "Lkotlin/Function1;", "addLastIfPrevAndIf", "addNext", "addOneIfEmpty", "correctPrev", "op", "Lkotlinx/coroutines/internal/OpDescriptor;", "describeAddLast", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "T", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "describeRemove", "Lkotlinx/coroutines/internal/AtomicDesc;", "describeRemoveFirst", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "findHead", "finishAdd", "finishRemove", "helpDelete", "helpRemove", "makeCondAddOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "markPrev", "remove", "removeFirstIfIsInstanceOf", "removeFirstIfIsInstanceOfOrPeekIf", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "removeFirstOrNull", "removed", "toString", "", "tryCondAddNext", "", "condAdd", "validateNode", "validateNode$kotlinx_coroutines_core", "AbstractAtomicDesc", "AddLastDesc", "CondAddOp", "RemoveFirstDesc", "kotlinx-coroutines-core"})
public class h {
    static final AtomicReferenceFieldUpdater BRq = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "BRp");
    static final AtomicReferenceFieldUpdater BRs = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "BRr");
    private static final AtomicReferenceFieldUpdater BRu = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "BRt");
    volatile Object BRp = this;
    volatile Object BRr = this;
    private volatile Object BRt = null;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b!\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0011\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\u0002j\u0002`\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, dWq = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "newNode", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "oldNext", "complete", "", "affected", "failure", "", "kotlinx-coroutines-core"})
    public static abstract class a extends d<h> {
        public h BRv;
        public final h BRw;

        public final /* synthetic */ void M(Object obj, Object obj2) {
            h hVar = (h) obj;
            j.p(hVar, "affected");
            Object obj3 = obj2 == null ? 1 : null;
            Object obj4 = obj3 != null ? this.BRw : this.BRv;
            if (obj4 != null && h.BRq.compareAndSet(hVar, this, obj4) && obj3 != null) {
                h hVar2 = this.BRw;
                h hVar3 = this.BRv;
                if (hVar3 == null) {
                    j.dWJ();
                }
                h.a(hVar2, hVar3);
            }
        }

        public a(h hVar) {
            j.p(hVar, "newNode");
            this.BRw = hVar;
        }
    }

    static {
        AppMethodBeat.i(118424);
        AppMethodBeat.o(118424);
    }

    public h() {
        AppMethodBeat.i(118422);
        AppMethodBeat.o(118422);
    }

    public static final /* synthetic */ void a(h hVar, h hVar2) {
        AppMethodBeat.i(118423);
        hVar.c(hVar2);
        AppMethodBeat.o(118423);
    }

    private final l elI() {
        AppMethodBeat.i(118410);
        l lVar = (l) this.BRt;
        if (lVar == null) {
            lVar = new l(this);
            BRu.lazySet(this, lVar);
        }
        AppMethodBeat.o(118410);
        return lVar;
    }

    public final h elK() {
        AppMethodBeat.i(139014);
        h em = g.em(elJ());
        AppMethodBeat.o(139014);
        return em;
    }

    public final boolean b(h hVar) {
        AppMethodBeat.i(118414);
        j.p(hVar, "node");
        BRs.lazySet(hVar, this);
        BRq.lazySet(hVar, this);
        while (elJ() == this) {
            if (BRq.compareAndSet(this, this, hVar)) {
                hVar.c(this);
                AppMethodBeat.o(118414);
                return true;
            }
        }
        AppMethodBeat.o(118414);
        return false;
    }

    public final int a(h hVar, h hVar2, a aVar) {
        AppMethodBeat.i(118415);
        j.p(hVar, "node");
        j.p(hVar2, "next");
        j.p(aVar, "condAdd");
        BRs.lazySet(hVar, this);
        BRq.lazySet(hVar, hVar2);
        aVar.BRv = hVar2;
        if (!BRq.compareAndSet(this, hVar2, aVar)) {
            AppMethodBeat.o(118415);
            return 0;
        } else if (aVar.el(this) == null) {
            AppMethodBeat.o(118415);
            return 1;
        } else {
            AppMethodBeat.o(118415);
            return 2;
        }
    }

    public boolean aQp() {
        h elJ;
        v vVar;
        AppMethodBeat.i(118416);
        do {
            elJ = elJ();
            if (elJ instanceof l) {
                AppMethodBeat.o(118416);
                return false;
            } else if (elJ == this) {
                AppMethodBeat.o(118416);
                return false;
            } else if (elJ == null) {
                vVar = new v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                AppMethodBeat.o(118416);
                throw vVar;
            }
        } while (!BRq.compareAndSet(this, elJ, elJ.elI()));
        elJ = elJ;
        h elM = elM();
        Object obj = this.BRp;
        if (obj == null) {
            vVar = new v("null cannot be cast to non-null type kotlinx.coroutines.internal.Removed");
            AppMethodBeat.o(118416);
            throw vVar;
        }
        Object obj2 = null;
        loop1:
        while (true) {
            h hVar = ((l) obj).BRF;
            h hVar2 = elM;
            while (true) {
                obj = hVar.elJ();
                if (obj instanceof l) {
                    break;
                }
                h elJ2 = hVar2.elJ();
                if (elJ2 instanceof l) {
                    if (obj2 != null) {
                        hVar2.elM();
                        BRq.compareAndSet(obj2, hVar2, ((l) elJ2).BRF);
                        hVar2 = obj2;
                        obj2 = null;
                    } else {
                        hVar2 = g.em(hVar2.BRr);
                    }
                } else if (elJ2 != this) {
                    if (elJ2 != null) {
                        elJ2 = elJ2;
                        if (elJ2 == hVar) {
                            break loop1;
                        }
                        obj2 = hVar2;
                        hVar2 = elJ2;
                    } else {
                        vVar = new v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                        AppMethodBeat.o(118416);
                        throw vVar;
                    }
                } else if (BRq.compareAndSet(hVar2, this, hVar)) {
                    break loop1;
                }
            }
            hVar.elM();
            elM = hVar2;
        }
        elJ.d(g.em(this.BRr));
        AppMethodBeat.o(118416);
        return true;
    }

    private final h elN() {
        AppMethodBeat.i(118419);
        h hVar = this;
        while (!(hVar instanceof f)) {
            h em = g.em(hVar.elJ());
            if ((em != ((h) this) ? 1 : null) == null) {
                Throwable illegalStateException = new IllegalStateException("Cannot loop to this while looking for list head".toString());
                AppMethodBeat.o(118419);
                throw illegalStateException;
            }
            hVar = em;
        }
        AppMethodBeat.o(118419);
        return hVar;
    }

    private final h d(h hVar) {
        AppMethodBeat.i(118420);
        Object obj = null;
        h hVar2 = hVar;
        while (true) {
            h hVar3 = hVar2.BRp;
            if (hVar3 == null) {
                AppMethodBeat.o(118420);
                return hVar2;
            } else if (hVar3 instanceof k) {
                ((k) hVar3).el(hVar2);
            } else if (!(hVar3 instanceof l)) {
                h hVar4 = this.BRr;
                if (hVar4 instanceof l) {
                    AppMethodBeat.o(118420);
                    return null;
                } else if (hVar3 != this) {
                    if (hVar3 == null) {
                        v vVar = new v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                        AppMethodBeat.o(118420);
                        throw vVar;
                    }
                    obj = hVar2;
                    hVar2 = hVar3;
                } else if (hVar4 == hVar2) {
                    AppMethodBeat.o(118420);
                    return null;
                } else if (BRs.compareAndSet(this, hVar4, hVar2) && !(hVar2.BRr instanceof l)) {
                    AppMethodBeat.o(118420);
                    return null;
                }
            } else if (obj != null) {
                hVar2.elM();
                BRq.compareAndSet(obj, hVar2, ((l) hVar3).BRF);
                hVar2 = obj;
                obj = null;
            } else {
                hVar2 = g.em(hVar2.BRr);
            }
        }
    }

    public String toString() {
        AppMethodBeat.i(118421);
        String str = getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
        AppMethodBeat.o(118421);
        return str;
    }

    public final Object elJ() {
        AppMethodBeat.i(118411);
        while (true) {
            Object obj = this.BRp;
            if (obj instanceof k) {
                ((k) obj).el(this);
            } else {
                AppMethodBeat.o(118411);
                return obj;
            }
        }
    }

    public final Object elL() {
        Object obj;
        AppMethodBeat.i(118413);
        while (true) {
            obj = this.BRr;
            if (obj instanceof l) {
                AppMethodBeat.o(118413);
                break;
            } else if (obj == null) {
                v vVar = new v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                AppMethodBeat.o(118413);
                throw vVar;
            } else if (((h) obj).elJ() == this) {
                AppMethodBeat.o(118413);
                break;
            } else {
                d((h) obj);
            }
        }
        return obj;
    }

    private final void c(h hVar) {
        Object obj;
        AppMethodBeat.i(118417);
        do {
            obj = hVar.BRr;
            if ((obj instanceof l) || elJ() != hVar) {
                AppMethodBeat.o(118417);
                return;
            }
        } while (!BRs.compareAndSet(hVar, obj, this));
        if (elJ() instanceof l) {
            if (obj == null) {
                v vVar = new v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                AppMethodBeat.o(118417);
                throw vVar;
            }
            hVar.d((h) obj);
        }
        AppMethodBeat.o(118417);
    }

    private final h elM() {
        h hVar;
        AppMethodBeat.i(118418);
        h elN;
        do {
            hVar = this.BRr;
            if (hVar instanceof l) {
                hVar = ((l) hVar).BRF;
                AppMethodBeat.o(118418);
                return hVar;
            }
            if (hVar == this) {
                elN = elN();
            } else if (hVar == null) {
                v vVar = new v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                AppMethodBeat.o(118418);
                throw vVar;
            } else {
                elN = hVar;
            }
        } while (!BRs.compareAndSet(this, hVar, elN.elI()));
        hVar = hVar;
        AppMethodBeat.o(118418);
        return hVar;
    }
}
