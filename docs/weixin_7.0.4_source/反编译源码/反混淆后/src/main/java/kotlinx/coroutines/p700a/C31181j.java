package kotlinx.coroutines.p700a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 -*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0002-.B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00028\u0000¢\u0006\u0002\u0010\u0017J \u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J \u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0006\u0010\u001c\u001a\u00020\u0006J1\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\n2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001fJ&\u0010 \u001a\b\u0012\u0004\u0012\u0002H\"0!\"\u0004\b\u0001\u0010\"2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\"0$J\b\u0010%\u001a\u00020\u001aH\u0002J\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\b\u0010'\u001a\u0004\u0018\u00010\u0002J\u001f\u0010(\u001a\u0004\u0018\u00010\u00022\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060$H\bJ,\u0010*\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\n2\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0004H\u0002R(\u0010\b\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006/"}, dWq = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "E", "", "capacity", "", "singleConsumer", "", "(IZ)V", "_next", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/internal/Core;", "_state", "Lkotlinx/atomicfu/AtomicLong;", "array", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "isEmpty", "()Z", "mask", "size", "getSize", "()I", "addLast", "element", "(Ljava/lang/Object;)I", "allocateNextCopy", "state", "", "allocateOrGetNextCopy", "close", "fillPlaceholder", "index", "(ILjava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "map", "", "R", "transform", "Lkotlin/Function1;", "markFrozen", "next", "removeFirstOrNull", "removeFirstOrNullIf", "predicate", "removeSlowPath", "oldHead", "newHead", "Companion", "Placeholder", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.a.j */
public final class C31181j<E> {
    public static final /* synthetic */ AtomicLongFieldUpdater BRA = AtomicLongFieldUpdater.newUpdater(C31181j.class, "BRz");
    public static final C46845m BRD = new C46845m("REMOVE_FROZEN");
    public static final C31182a BRE = new C31182a();
    private static final AtomicReferenceFieldUpdater BRq = AtomicReferenceFieldUpdater.newUpdater(C31181j.class, Object.class, "BRp");
    private final AtomicReferenceArray<Object> BRB = new AtomicReferenceArray(this.capacity);
    private final boolean BRC;
    private volatile Object BRp = null;
    public volatile /* synthetic */ long BRz = 0;
    private final int capacity;
    private final int mask = (this.capacity - 1);

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0016\u001a\u00020\u0004*\u00020\tJ\u0012\u0010\u0017\u001a\u00020\t*\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0004J\u0012\u0010\u0019\u001a\u00020\t*\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0004JP\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0001\u0010\u001c*\u00020\t26\u0010\u001d\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H\u001c0\u001eH\b¢\u0006\u0002\u0010#J\u0015\u0010$\u001a\u00020\t*\u00020\t2\u0006\u0010%\u001a\u00020\tH\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00138\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006&"}, dWq = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion;", "", "()V", "ADD_CLOSED", "", "ADD_FROZEN", "ADD_SUCCESS", "CAPACITY_BITS", "CLOSED_MASK", "", "CLOSED_SHIFT", "FROZEN_MASK", "FROZEN_SHIFT", "HEAD_MASK", "HEAD_SHIFT", "INITIAL_CAPACITY", "MAX_CAPACITY_MASK", "MIN_ADD_SPIN_CAPACITY", "REMOVE_FROZEN", "Lkotlinx/coroutines/internal/Symbol;", "TAIL_MASK", "TAIL_SHIFT", "addFailReason", "updateHead", "newHead", "updateTail", "newTail", "withState", "T", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "head", "tail", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "wo", "other", "kotlinx-coroutines-core"})
    /* renamed from: kotlinx.coroutines.a.j$a */
    public static final class C31182a {
        private C31182a() {
        }

        public /* synthetic */ C31182a(byte b) {
            this();
        }

        /* renamed from: ob */
        public static int m50272ob(long j) {
            return (2305843009213693952L & j) != 0 ? 2 : 1;
        }

        /* renamed from: K */
        public static long m50270K(long j, int i) {
            return (-1073741824 & j) | (((long) i) << null);
        }

        /* renamed from: L */
        public static long m50271L(long j, int i) {
            return (-1152921503533105153L & j) | (((long) i) << 30);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Placeholder;", "", "index", "", "(I)V", "kotlinx-coroutines-core"})
    /* renamed from: kotlinx.coroutines.a.j$b */
    public static final class C31183b {
        public final int index;

        public C31183b(int i) {
            this.index = i;
        }
    }

    public C31181j(int i, boolean z) {
        Object obj = 1;
        AppMethodBeat.m2504i(118406);
        this.capacity = i;
        this.BRC = z;
        Throwable illegalStateException;
        if ((this.mask <= 1073741823 ? 1 : null) == null) {
            illegalStateException = new IllegalStateException("Check failed.".toString());
            AppMethodBeat.m2505o(118406);
            throw illegalStateException;
        }
        if ((this.capacity & this.mask) != 0) {
            obj = null;
        }
        if (obj == null) {
            illegalStateException = new IllegalStateException("Check failed.".toString());
            AppMethodBeat.m2505o(118406);
            throw illegalStateException;
        }
        AppMethodBeat.m2505o(118406);
    }

    public final boolean isEmpty() {
        long j = this.BRz;
        return ((int) ((1073741823 & j) >> 0)) == ((int) ((j & 1152921503533105152L) >> 30));
    }

    /* renamed from: u */
    private final C31181j<E> m50268u(int i, E e) {
        AppMethodBeat.m2504i(118401);
        Object obj = this.BRB.get(this.mask & i);
        if ((obj instanceof C31183b) && ((C31183b) obj).index == i) {
            this.BRB.set(this.mask & i, e);
            AppMethodBeat.m2505o(118401);
            return this;
        }
        AppMethodBeat.m2505o(118401);
        return null;
    }

    public final C31181j<E> elO() {
        AppMethodBeat.m2504i(118402);
        C31181j nZ = m50266nZ(elP());
        AppMethodBeat.m2505o(118402);
        return nZ;
    }

    /* renamed from: oa */
    private final C31181j<E> m50267oa(long j) {
        AppMethodBeat.m2504i(118405);
        C31181j c31181j = new C31181j(this.capacity * 2, this.BRC);
        int i = (int) ((1152921503533105152L & j) >> 30);
        for (int i2 = (int) ((1073741823 & j) >> null); (this.mask & i2) != (this.mask & i); i2++) {
            AtomicReferenceArray atomicReferenceArray = c31181j.BRB;
            int i3 = i2 & c31181j.mask;
            Object obj = this.BRB.get(this.mask & i2);
            if (obj == null) {
                obj = new C31183b(i2);
            }
            atomicReferenceArray.set(i3, obj);
        }
        c31181j.BRz = -1152921504606846977L & j;
        AppMethodBeat.m2505o(118405);
        return c31181j;
    }

    static {
        AppMethodBeat.m2504i(118408);
        AppMethodBeat.m2505o(118408);
    }

    /* renamed from: eo */
    public final int mo50947eo(E e) {
        AppMethodBeat.m2504i(118400);
        C25052j.m39376p(e, "element");
        while (true) {
            long j = this.BRz;
            int ob;
            if ((3458764513820540928L & j) != 0) {
                ob = C31182a.m50272ob(j);
                AppMethodBeat.m2505o(118400);
                return ob;
            }
            ob = (int) ((1073741823 & j) >> 0);
            int i = (int) ((1152921503533105152L & j) >> 30);
            int i2 = this.mask;
            if (((i + 2) & i2) == (ob & i2)) {
                AppMethodBeat.m2505o(118400);
                return 1;
            } else if (this.BRC || this.BRB.get(i & i2) == null) {
                int i3 = (i + 1) & 1073741823;
                if (BRA.compareAndSet(this, j, C31182a.m50271L(j, i3))) {
                    this.BRB.set(i & i2, e);
                    this = this;
                    while ((this.BRz & 1152921504606846976L) != 0) {
                        this = this.elO().m50268u(i, e);
                        if (this == null) {
                            break;
                        }
                    }
                    AppMethodBeat.m2505o(118400);
                    return 0;
                }
            } else if (this.capacity < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT || ((i - ob) & 1073741823) > (this.capacity >> 1)) {
                AppMethodBeat.m2505o(118400);
            }
        }
        AppMethodBeat.m2505o(118400);
        return 1;
    }

    private final long elP() {
        long j;
        AppMethodBeat.m2504i(118403);
        long j2;
        do {
            j2 = this.BRz;
            if ((j2 & 1152921504606846976L) != 0) {
                AppMethodBeat.m2505o(118403);
                return j2;
            }
            j = j2 | 1152921504606846976L;
        } while (!BRA.compareAndSet(this, j2, j));
        AppMethodBeat.m2505o(118403);
        return j;
    }

    /* renamed from: nZ */
    private final C31181j<E> m50266nZ(long j) {
        AppMethodBeat.m2504i(118404);
        while (true) {
            C31181j c31181j = (C31181j) this.BRp;
            if (c31181j != null) {
                AppMethodBeat.m2505o(118404);
                return c31181j;
            }
            BRq.compareAndSet(this, null, m50267oa(j));
        }
    }

    /* renamed from: a */
    public static final /* synthetic */ C31181j m50263a(C31181j c31181j, int i, int i2) {
        int i3;
        AppMethodBeat.m2504i(118407);
        long j;
        do {
            j = c31181j.BRz;
            i3 = (int) ((1073741823 & j) >> 0);
            if ((i3 == i ? 1 : null) == null) {
                Throwable illegalStateException = new IllegalStateException("This queue can have only one consumer".toString());
                AppMethodBeat.m2505o(118407);
                throw illegalStateException;
            } else if ((1152921504606846976L & j) != 0) {
                C31181j elO = c31181j.elO();
                AppMethodBeat.m2505o(118407);
                return elO;
            }
        } while (!BRA.compareAndSet(c31181j, j, C31182a.m50270K(j, i2)));
        c31181j.BRB.set(c31181j.mask & i3, null);
        AppMethodBeat.m2505o(118407);
        return null;
    }
}
