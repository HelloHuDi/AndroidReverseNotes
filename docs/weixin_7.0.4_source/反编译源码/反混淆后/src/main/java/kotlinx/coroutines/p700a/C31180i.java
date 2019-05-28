package kotlinx.coroutines.p700a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.p700a.C31181j.C31182a;
import kotlinx.coroutines.p700a.C31181j.C31183b;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J&\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0016\"\u0004\b\u0001\u0010\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00170\u0019J\r\u0010\u001a\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u001bJ$\u0010\u001c\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0019H\b¢\u0006\u0002\u0010\u001eR$\u0010\u0006\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u00000\bj\b\u0012\u0004\u0012\u00028\u0000`\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, dWq = {"Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "E", "", "singleConsumer", "", "(Z)V", "_cur", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "Lkotlinx/coroutines/internal/Core;", "isEmpty", "()Z", "size", "", "getSize", "()I", "addLast", "element", "(Ljava/lang/Object;)Z", "close", "", "map", "", "R", "transform", "Lkotlin/Function1;", "removeFirstOrNull", "()Ljava/lang/Object;", "removeFirstOrNullIf", "predicate", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.a.i */
public class C31180i<E> {
    public static final /* synthetic */ AtomicReferenceFieldUpdater BRy = AtomicReferenceFieldUpdater.newUpdater(C31180i.class, Object.class, "BRx");
    public volatile /* synthetic */ Object BRx = new C31181j(8, false);

    static {
        AppMethodBeat.m2504i(118450);
        AppMethodBeat.m2505o(118450);
    }

    public C31180i() {
        AppMethodBeat.m2504i(118449);
        AppMethodBeat.m2505o(118449);
    }

    public final void close() {
        AppMethodBeat.m2504i(118446);
        while (true) {
            Object obj;
            C31181j c31181j = (C31181j) this.BRx;
            long j;
            do {
                j = c31181j.BRz;
                if ((j & 2305843009213693952L) != 0) {
                    break;
                } else if ((1152921504606846976L & j) != 0) {
                    obj = null;
                    break;
                }
            } while (!C31181j.BRA.compareAndSet(c31181j, j, j | 2305843009213693952L));
            obj = 1;
            if (obj != null) {
                AppMethodBeat.m2505o(118446);
                return;
            }
            BRy.compareAndSet(this, c31181j, c31181j.elO());
        }
    }

    /* renamed from: en */
    public final boolean mo50945en(E e) {
        AppMethodBeat.m2504i(118447);
        C25052j.m39376p(e, "element");
        while (true) {
            C31181j c31181j = (C31181j) this.BRx;
            switch (c31181j.mo50947eo(e)) {
                case 0:
                    AppMethodBeat.m2505o(118447);
                    return true;
                case 1:
                    BRy.compareAndSet(this, c31181j, c31181j.elO());
                    break;
                case 2:
                    AppMethodBeat.m2505o(118447);
                    return false;
                default:
                    break;
            }
        }
    }

    public final E elE() {
        AppMethodBeat.m2504i(118448);
        while (true) {
            E e;
            C31181j c31181j = (C31181j) this.BRx;
            while (true) {
                long j = c31181j.BRz;
                if ((1152921504606846976L & j) != 0) {
                    e = C31181j.BRD;
                    break;
                }
                C31182a c31182a = C31181j.BRE;
                int i = (int) ((1073741823 & j) >> null);
                if ((((int) ((1152921503533105152L & j) >> 30)) & c31181j.mask) == (c31181j.mask & i)) {
                    e = null;
                    break;
                }
                E e2 = c31181j.BRB.get(c31181j.mask & i);
                if (e2 == null) {
                    if (c31181j.BRC) {
                        e = null;
                        break;
                    }
                } else if (e2 instanceof C31183b) {
                    e = null;
                    break;
                } else {
                    int i2 = (i + 1) & 1073741823;
                    AtomicLongFieldUpdater atomicLongFieldUpdater = C31181j.BRA;
                    C31182a c31182a2 = C31181j.BRE;
                    if (atomicLongFieldUpdater.compareAndSet(c31181j, j, C31182a.m50270K(j, i2))) {
                        c31181j.BRB.set(c31181j.mask & i, null);
                        e = e2;
                        break;
                    } else if (c31181j.BRC) {
                        C31181j c31181j2 = c31181j;
                        do {
                            c31181j2 = C31181j.m50263a(c31181j2, i, i2);
                        } while (c31181j2 != null);
                        e = e2;
                        break;
                    }
                }
            }
            if (e != C31181j.BRD) {
                AppMethodBeat.m2505o(118448);
                return e;
            }
            BRy.compareAndSet(this, c31181j, c31181j.elO());
        }
    }
}
