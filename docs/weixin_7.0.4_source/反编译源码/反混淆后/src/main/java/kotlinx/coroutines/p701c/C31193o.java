package kotlinx.coroutines.p701c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C31128d;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p009h.C0016h;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u0015\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0018J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005J!\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u001dH\bJ\r\u0010\u001e\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u001fJ\u0010\u0010 \u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u0016\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013J \u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078@X\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, dWq = {"Lkotlinx/coroutines/scheduling/WorkQueue;", "", "()V", "buffer", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Lkotlinx/coroutines/scheduling/Task;", "bufferSize", "", "getBufferSize$kotlinx_coroutines_core", "()I", "consumerIndex", "Lkotlinx/atomicfu/AtomicInt;", "lastScheduledTask", "Lkotlinx/atomicfu/AtomicRef;", "producerIndex", "add", "", "task", "globalQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "addLast", "addToGlobalQueue", "", "offloadAllWork", "offloadAllWork$kotlinx_coroutines_core", "offloadWork", "poll", "pollExternal", "predicate", "Lkotlin/Function1;", "size", "size$kotlinx_coroutines_core", "tryAddLast", "trySteal", "victim", "tryStealLastScheduled", "time", "", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.c.o */
public final class C31193o {
    private static final AtomicReferenceFieldUpdater BTa = AtomicReferenceFieldUpdater.newUpdater(C31193o.class, Object.class, "BSZ");
    static final AtomicIntegerFieldUpdater BTc = AtomicIntegerFieldUpdater.newUpdater(C31193o.class, "BTb");
    static final AtomicIntegerFieldUpdater BTe = AtomicIntegerFieldUpdater.newUpdater(C31193o.class, "BTd");
    private final AtomicReferenceArray<C36635i> BSY = new AtomicReferenceArray(128);
    volatile Object BSZ = null;
    volatile int BTb = 0;
    volatile int BTd = 0;

    static {
        AppMethodBeat.m2504i(118313);
        AppMethodBeat.m2505o(118313);
    }

    public C31193o() {
        AppMethodBeat.m2504i(118312);
        AppMethodBeat.m2505o(118312);
    }

    public final int emm() {
        return this.BTb - this.BTd;
    }

    public final C36635i emn() {
        AppMethodBeat.m2504i(118303);
        C36635i c36635i = (C36635i) BTa.getAndSet(this, null);
        if (c36635i == null) {
            while (true) {
                int i = this.BTd;
                if (i - this.BTb == 0) {
                    AppMethodBeat.m2505o(118303);
                    return null;
                }
                int i2 = i & C31128d.MIC_SketchMark;
                if (((C36635i) this.BSY.get(i2)) != null && BTe.compareAndSet(this, i, i + 1)) {
                    c36635i = (C36635i) this.BSY.getAndSet(i2, null);
                    AppMethodBeat.m2505o(118303);
                    return c36635i;
                }
            }
        } else {
            AppMethodBeat.m2505o(118303);
            return c36635i;
        }
    }

    /* renamed from: a */
    public final boolean mo50961a(C36635i c36635i, C24593e c24593e) {
        AppMethodBeat.m2504i(118304);
        C25052j.m39376p(c36635i, "task");
        C25052j.m39376p(c24593e, "globalQueue");
        C36635i c36635i2 = (C36635i) BTa.getAndSet(this, c36635i);
        if (c36635i2 == null) {
            AppMethodBeat.m2505o(118304);
            return true;
        }
        boolean b = mo50964b(c36635i2, c24593e);
        AppMethodBeat.m2505o(118304);
        return b;
    }

    /* renamed from: b */
    public final boolean mo50964b(C36635i c36635i, C24593e c24593e) {
        AppMethodBeat.m2504i(118305);
        C25052j.m39376p(c36635i, "task");
        C25052j.m39376p(c24593e, "globalQueue");
        boolean z = true;
        while (!m50286c(c36635i)) {
            m50283a(c24593e);
            z = false;
        }
        AppMethodBeat.m2505o(118305);
        return z;
    }

    /* renamed from: a */
    public final boolean mo50962a(C31193o c31193o, C24593e c24593e) {
        AppMethodBeat.m2504i(118306);
        C25052j.m39376p(c31193o, "victim");
        C25052j.m39376p(c24593e, "globalQueue");
        long nanoTime = C31192m.BSX.nanoTime();
        int emm = c31193o.emm();
        if (emm == 0) {
            boolean a = m50285a(nanoTime, c31193o, c24593e);
            AppMethodBeat.m2505o(118306);
            return a;
        }
        boolean z = false;
        int im = C0016h.m19im(emm / 2, 1);
        for (int i = 0; i < im; i++) {
            C36635i c36635i;
            while (true) {
                int i2 = c31193o.BTd;
                if (i2 - c31193o.BTb == 0) {
                    c36635i = null;
                    break;
                }
                int i3 = i2 & C31128d.MIC_SketchMark;
                c36635i = (C36635i) c31193o.BSY.get(i3);
                if (c36635i != null) {
                    Object obj;
                    if (nanoTime - c36635i.BSM >= C31192m.BSS || c31193o.emm() > C31192m.BST) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj == null) {
                        c36635i = null;
                        break;
                    } else if (BTe.compareAndSet(c31193o, i2, i2 + 1)) {
                        c36635i = (C36635i) c31193o.BSY.getAndSet(i3, null);
                        break;
                    }
                }
            }
            if (c36635i == null) {
                AppMethodBeat.m2505o(118306);
                return z;
            }
            z = true;
            mo50961a(c36635i, c24593e);
        }
        AppMethodBeat.m2505o(118306);
        return z;
    }

    /* renamed from: a */
    private final boolean m50285a(long j, C31193o c31193o, C24593e c24593e) {
        AppMethodBeat.m2504i(118307);
        C36635i c36635i = (C36635i) c31193o.BSZ;
        if (c36635i == null) {
            AppMethodBeat.m2505o(118307);
            return false;
        } else if (j - c36635i.BSM < C31192m.BSS) {
            AppMethodBeat.m2505o(118307);
            return false;
        } else if (BTa.compareAndSet(c31193o, c36635i, null)) {
            mo50961a(c36635i, c24593e);
            AppMethodBeat.m2505o(118307);
            return true;
        } else {
            AppMethodBeat.m2505o(118307);
            return false;
        }
    }

    /* renamed from: a */
    private final void m50283a(C24593e c24593e) {
        AppMethodBeat.m2504i(118308);
        int im = C0016h.m19im(emm() / 2, 1);
        int i = 0;
        while (i < im) {
            C36635i c36635i;
            while (true) {
                int i2 = this.BTd;
                if (i2 - this.BTb != 0) {
                    int i3 = i2 & C31128d.MIC_SketchMark;
                    if (((C36635i) this.BSY.get(i3)) != null && BTe.compareAndSet(this, i2, i2 + 1)) {
                        c36635i = (C36635i) this.BSY.getAndSet(i3, null);
                        break;
                    }
                } else {
                    c36635i = null;
                    break;
                }
            }
            if (c36635i == null) {
                AppMethodBeat.m2505o(118308);
                return;
            } else {
                C31193o.m50284a(c24593e, c36635i);
                i++;
            }
        }
        AppMethodBeat.m2505o(118308);
    }

    /* renamed from: a */
    private static void m50284a(C24593e c24593e, C36635i c36635i) {
        AppMethodBeat.m2504i(118309);
        if (c24593e.mo50945en(c36635i)) {
            AppMethodBeat.m2505o(118309);
            return;
        }
        Throwable illegalStateException = new IllegalStateException("GlobalQueue could not be closed yet".toString());
        AppMethodBeat.m2505o(118309);
        throw illegalStateException;
    }

    /* renamed from: b */
    public final void mo50963b(C24593e c24593e) {
        AppMethodBeat.m2504i(118310);
        C25052j.m39376p(c24593e, "globalQueue");
        C36635i c36635i = (C36635i) BTa.getAndSet(this, null);
        if (c36635i != null) {
            C31193o.m50284a(c24593e, c36635i);
        }
        while (true) {
            int i = this.BTd;
            if (i - this.BTb == 0) {
                c36635i = null;
            } else {
                int i2 = i & C31128d.MIC_SketchMark;
                if (((C36635i) this.BSY.get(i2)) != null && BTe.compareAndSet(this, i, i + 1)) {
                    c36635i = (C36635i) this.BSY.getAndSet(i2, null);
                }
            }
            if (c36635i == null) {
                AppMethodBeat.m2505o(118310);
                return;
            }
            C31193o.m50284a(c24593e, c36635i);
        }
    }

    /* renamed from: c */
    private final boolean m50286c(C36635i c36635i) {
        AppMethodBeat.m2504i(118311);
        if (emm() == C31128d.MIC_SketchMark) {
            AppMethodBeat.m2505o(118311);
            return false;
        }
        int i = this.BTb & C31128d.MIC_SketchMark;
        if (this.BSY.get(i) != null) {
            AppMethodBeat.m2505o(118311);
            return false;
        }
        this.BSY.lazySet(i, c36635i);
        BTc.incrementAndGet(this);
        AppMethodBeat.m2505o(118311);
        return true;
    }
}
