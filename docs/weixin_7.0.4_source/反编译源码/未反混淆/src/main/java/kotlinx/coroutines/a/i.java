package kotlinx.coroutines.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.a.j.a;
import kotlinx.coroutines.a.j.b;

@l(dWo = {1, 1, 13}, dWp = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J&\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0016\"\u0004\b\u0001\u0010\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00170\u0019J\r\u0010\u001a\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u001bJ$\u0010\u001c\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0019H\b¢\u0006\u0002\u0010\u001eR$\u0010\u0006\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u00000\bj\b\u0012\u0004\u0012\u00028\u0000`\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, dWq = {"Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "E", "", "singleConsumer", "", "(Z)V", "_cur", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "Lkotlinx/coroutines/internal/Core;", "isEmpty", "()Z", "size", "", "getSize", "()I", "addLast", "element", "(Ljava/lang/Object;)Z", "close", "", "map", "", "R", "transform", "Lkotlin/Function1;", "removeFirstOrNull", "()Ljava/lang/Object;", "removeFirstOrNullIf", "predicate", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
public class i<E> {
    public static final /* synthetic */ AtomicReferenceFieldUpdater BRy = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "BRx");
    public volatile /* synthetic */ Object BRx = new j(8, false);

    static {
        AppMethodBeat.i(118450);
        AppMethodBeat.o(118450);
    }

    public i() {
        AppMethodBeat.i(118449);
        AppMethodBeat.o(118449);
    }

    public final void close() {
        AppMethodBeat.i(118446);
        while (true) {
            Object obj;
            j jVar = (j) this.BRx;
            long j;
            do {
                j = jVar.BRz;
                if ((j & 2305843009213693952L) != 0) {
                    break;
                } else if ((1152921504606846976L & j) != 0) {
                    obj = null;
                    break;
                }
            } while (!j.BRA.compareAndSet(jVar, j, j | 2305843009213693952L));
            obj = 1;
            if (obj != null) {
                AppMethodBeat.o(118446);
                return;
            }
            BRy.compareAndSet(this, jVar, jVar.elO());
        }
    }

    public final boolean en(E e) {
        AppMethodBeat.i(118447);
        j.p(e, "element");
        while (true) {
            j jVar = (j) this.BRx;
            switch (jVar.eo(e)) {
                case 0:
                    AppMethodBeat.o(118447);
                    return true;
                case 1:
                    BRy.compareAndSet(this, jVar, jVar.elO());
                    break;
                case 2:
                    AppMethodBeat.o(118447);
                    return false;
                default:
                    break;
            }
        }
    }

    public final E elE() {
        AppMethodBeat.i(118448);
        while (true) {
            E e;
            j jVar = (j) this.BRx;
            while (true) {
                long j = jVar.BRz;
                if ((1152921504606846976L & j) != 0) {
                    e = j.BRD;
                    break;
                }
                a aVar = j.BRE;
                int i = (int) ((1073741823 & j) >> null);
                if ((((int) ((1152921503533105152L & j) >> 30)) & jVar.mask) == (jVar.mask & i)) {
                    e = null;
                    break;
                }
                E e2 = jVar.BRB.get(jVar.mask & i);
                if (e2 == null) {
                    if (jVar.BRC) {
                        e = null;
                        break;
                    }
                } else if (e2 instanceof b) {
                    e = null;
                    break;
                } else {
                    int i2 = (i + 1) & 1073741823;
                    AtomicLongFieldUpdater atomicLongFieldUpdater = j.BRA;
                    a aVar2 = j.BRE;
                    if (atomicLongFieldUpdater.compareAndSet(jVar, j, a.K(j, i2))) {
                        jVar.BRB.set(jVar.mask & i, null);
                        e = e2;
                        break;
                    } else if (jVar.BRC) {
                        j jVar2 = jVar;
                        do {
                            jVar2 = j.a(jVar2, i, i2);
                        } while (jVar2 != null);
                        e = e2;
                        break;
                    }
                }
            }
            if (e != j.BRD) {
                AppMethodBeat.o(118448);
                return e;
            }
            BRy.compareAndSet(this, jVar, jVar.elO());
        }
    }
}
