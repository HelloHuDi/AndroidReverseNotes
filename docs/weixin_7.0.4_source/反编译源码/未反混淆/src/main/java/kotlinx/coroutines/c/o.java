package kotlinx.coroutines.c;

import a.f.b.j;
import a.h.h;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.d;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@l(dWo = {1, 1, 13}, dWp = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u0015\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0018J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005J!\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u001dH\bJ\r\u0010\u001e\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u001fJ\u0010\u0010 \u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u0016\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013J \u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078@X\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, dWq = {"Lkotlinx/coroutines/scheduling/WorkQueue;", "", "()V", "buffer", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Lkotlinx/coroutines/scheduling/Task;", "bufferSize", "", "getBufferSize$kotlinx_coroutines_core", "()I", "consumerIndex", "Lkotlinx/atomicfu/AtomicInt;", "lastScheduledTask", "Lkotlinx/atomicfu/AtomicRef;", "producerIndex", "add", "", "task", "globalQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "addLast", "addToGlobalQueue", "", "offloadAllWork", "offloadAllWork$kotlinx_coroutines_core", "offloadWork", "poll", "pollExternal", "predicate", "Lkotlin/Function1;", "size", "size$kotlinx_coroutines_core", "tryAddLast", "trySteal", "victim", "tryStealLastScheduled", "time", "", "kotlinx-coroutines-core"})
public final class o {
    private static final AtomicReferenceFieldUpdater BTa = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "BSZ");
    static final AtomicIntegerFieldUpdater BTc = AtomicIntegerFieldUpdater.newUpdater(o.class, "BTb");
    static final AtomicIntegerFieldUpdater BTe = AtomicIntegerFieldUpdater.newUpdater(o.class, "BTd");
    private final AtomicReferenceArray<i> BSY = new AtomicReferenceArray(128);
    volatile Object BSZ = null;
    volatile int BTb = 0;
    volatile int BTd = 0;

    static {
        AppMethodBeat.i(118313);
        AppMethodBeat.o(118313);
    }

    public o() {
        AppMethodBeat.i(118312);
        AppMethodBeat.o(118312);
    }

    public final int emm() {
        return this.BTb - this.BTd;
    }

    public final i emn() {
        AppMethodBeat.i(118303);
        i iVar = (i) BTa.getAndSet(this, null);
        if (iVar == null) {
            while (true) {
                int i = this.BTd;
                if (i - this.BTb == 0) {
                    AppMethodBeat.o(118303);
                    return null;
                }
                int i2 = i & d.MIC_SketchMark;
                if (((i) this.BSY.get(i2)) != null && BTe.compareAndSet(this, i, i + 1)) {
                    iVar = (i) this.BSY.getAndSet(i2, null);
                    AppMethodBeat.o(118303);
                    return iVar;
                }
            }
        } else {
            AppMethodBeat.o(118303);
            return iVar;
        }
    }

    public final boolean a(i iVar, e eVar) {
        AppMethodBeat.i(118304);
        j.p(iVar, "task");
        j.p(eVar, "globalQueue");
        i iVar2 = (i) BTa.getAndSet(this, iVar);
        if (iVar2 == null) {
            AppMethodBeat.o(118304);
            return true;
        }
        boolean b = b(iVar2, eVar);
        AppMethodBeat.o(118304);
        return b;
    }

    public final boolean b(i iVar, e eVar) {
        AppMethodBeat.i(118305);
        j.p(iVar, "task");
        j.p(eVar, "globalQueue");
        boolean z = true;
        while (!c(iVar)) {
            a(eVar);
            z = false;
        }
        AppMethodBeat.o(118305);
        return z;
    }

    public final boolean a(o oVar, e eVar) {
        AppMethodBeat.i(118306);
        j.p(oVar, "victim");
        j.p(eVar, "globalQueue");
        long nanoTime = m.BSX.nanoTime();
        int emm = oVar.emm();
        if (emm == 0) {
            boolean a = a(nanoTime, oVar, eVar);
            AppMethodBeat.o(118306);
            return a;
        }
        boolean z = false;
        int im = h.im(emm / 2, 1);
        for (int i = 0; i < im; i++) {
            i iVar;
            while (true) {
                int i2 = oVar.BTd;
                if (i2 - oVar.BTb == 0) {
                    iVar = null;
                    break;
                }
                int i3 = i2 & d.MIC_SketchMark;
                iVar = (i) oVar.BSY.get(i3);
                if (iVar != null) {
                    Object obj;
                    if (nanoTime - iVar.BSM >= m.BSS || oVar.emm() > m.BST) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj == null) {
                        iVar = null;
                        break;
                    } else if (BTe.compareAndSet(oVar, i2, i2 + 1)) {
                        iVar = (i) oVar.BSY.getAndSet(i3, null);
                        break;
                    }
                }
            }
            if (iVar == null) {
                AppMethodBeat.o(118306);
                return z;
            }
            z = true;
            a(iVar, eVar);
        }
        AppMethodBeat.o(118306);
        return z;
    }

    private final boolean a(long j, o oVar, e eVar) {
        AppMethodBeat.i(118307);
        i iVar = (i) oVar.BSZ;
        if (iVar == null) {
            AppMethodBeat.o(118307);
            return false;
        } else if (j - iVar.BSM < m.BSS) {
            AppMethodBeat.o(118307);
            return false;
        } else if (BTa.compareAndSet(oVar, iVar, null)) {
            a(iVar, eVar);
            AppMethodBeat.o(118307);
            return true;
        } else {
            AppMethodBeat.o(118307);
            return false;
        }
    }

    private final void a(e eVar) {
        AppMethodBeat.i(118308);
        int im = h.im(emm() / 2, 1);
        int i = 0;
        while (i < im) {
            i iVar;
            while (true) {
                int i2 = this.BTd;
                if (i2 - this.BTb != 0) {
                    int i3 = i2 & d.MIC_SketchMark;
                    if (((i) this.BSY.get(i3)) != null && BTe.compareAndSet(this, i2, i2 + 1)) {
                        iVar = (i) this.BSY.getAndSet(i3, null);
                        break;
                    }
                } else {
                    iVar = null;
                    break;
                }
            }
            if (iVar == null) {
                AppMethodBeat.o(118308);
                return;
            } else {
                a(eVar, iVar);
                i++;
            }
        }
        AppMethodBeat.o(118308);
    }

    private static void a(e eVar, i iVar) {
        AppMethodBeat.i(118309);
        if (eVar.en(iVar)) {
            AppMethodBeat.o(118309);
            return;
        }
        Throwable illegalStateException = new IllegalStateException("GlobalQueue could not be closed yet".toString());
        AppMethodBeat.o(118309);
        throw illegalStateException;
    }

    public final void b(e eVar) {
        AppMethodBeat.i(118310);
        j.p(eVar, "globalQueue");
        i iVar = (i) BTa.getAndSet(this, null);
        if (iVar != null) {
            a(eVar, iVar);
        }
        while (true) {
            int i = this.BTd;
            if (i - this.BTb == 0) {
                iVar = null;
            } else {
                int i2 = i & d.MIC_SketchMark;
                if (((i) this.BSY.get(i2)) != null && BTe.compareAndSet(this, i, i + 1)) {
                    iVar = (i) this.BSY.getAndSet(i2, null);
                }
            }
            if (iVar == null) {
                AppMethodBeat.o(118310);
                return;
            }
            a(eVar, iVar);
        }
    }

    private final boolean c(i iVar) {
        AppMethodBeat.i(118311);
        if (emm() == d.MIC_SketchMark) {
            AppMethodBeat.o(118311);
            return false;
        }
        int i = this.BTb & d.MIC_SketchMark;
        if (this.BSY.get(i) != null) {
            AppMethodBeat.o(118311);
            return false;
        }
        this.BSY.lazySet(i, iVar);
        BTc.incrementAndGet(this);
        AppMethodBeat.o(118311);
        return true;
    }
}
