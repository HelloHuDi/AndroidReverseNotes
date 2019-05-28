package kotlinx.coroutines.p701c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlinx.coroutines.p700a.C31180i;
import kotlinx.coroutines.p700a.C31181j;
import kotlinx.coroutines.p700a.C31181j.C31182a;
import kotlinx.coroutines.p700a.C31181j.C31183b;
import kotlinx.coroutines.p700a.C46845m;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0005"}, dWq = {"Lkotlinx/coroutines/scheduling/GlobalQueue;", "Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "Lkotlinx/coroutines/scheduling/Task;", "()V", "removeFirstBlockingModeOrNull", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.c.e */
public final class C24593e extends C31180i<C36635i> {
    public final C36635i emi() {
        AppMethodBeat.m2504i(118356);
        while (true) {
            C46845m c46845m;
            C31181j c31181j = (C31181j) this.BRx;
            while (true) {
                long j = c31181j.BRz;
                if ((1152921504606846976L & j) != 0) {
                    c46845m = C31181j.BRD;
                    break;
                }
                C31182a c31182a = C31181j.BRE;
                int i = (int) ((1073741823 & j) >> 0);
                if ((((int) ((1152921503533105152L & j) >> 30)) & c31181j.mask) == (c31181j.mask & i)) {
                    c46845m = null;
                    break;
                }
                C46845m c46845m2 = c31181j.BRB.get(c31181j.mask & i);
                if (c46845m2 == null) {
                    if (c31181j.BRC) {
                        c46845m = null;
                        break;
                    }
                } else if (c46845m2 instanceof C31183b) {
                    c46845m = null;
                    break;
                } else {
                    if ((((C36635i) c46845m2).eml() == C41160l.PROBABLY_BLOCKING ? 1 : null) == null) {
                        c46845m = null;
                        break;
                    }
                    int i2 = (i + 1) & 1073741823;
                    AtomicLongFieldUpdater atomicLongFieldUpdater = C31181j.BRA;
                    C31182a c31182a2 = C31181j.BRE;
                    if (atomicLongFieldUpdater.compareAndSet(c31181j, j, C31182a.m50270K(j, i2))) {
                        c31181j.BRB.set(c31181j.mask & i, null);
                        c46845m = c46845m2;
                        break;
                    } else if (c31181j.BRC) {
                        C31181j c31181j2 = c31181j;
                        do {
                            c31181j2 = C31181j.m50263a(c31181j2, i, i2);
                        } while (c31181j2 != null);
                        c46845m = c46845m2;
                        break;
                    }
                }
            }
            if (c46845m != C31181j.BRD) {
                C36635i c36635i = (C36635i) c46845m;
                AppMethodBeat.m2505o(118356);
                return c36635i;
            }
            C31180i.BRy.compareAndSet(this, c31181j, c31181j.elO());
        }
    }
}
