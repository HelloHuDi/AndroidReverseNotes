package kotlinx.coroutines.c;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlinx.coroutines.a.i;
import kotlinx.coroutines.a.j;
import kotlinx.coroutines.a.j.a;
import kotlinx.coroutines.a.j.b;
import kotlinx.coroutines.a.m;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0005"}, dWq = {"Lkotlinx/coroutines/scheduling/GlobalQueue;", "Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "Lkotlinx/coroutines/scheduling/Task;", "()V", "removeFirstBlockingModeOrNull", "kotlinx-coroutines-core"})
public final class e extends i<i> {
    public final i emi() {
        AppMethodBeat.i(118356);
        while (true) {
            m mVar;
            j jVar = (j) this.BRx;
            while (true) {
                long j = jVar.BRz;
                if ((1152921504606846976L & j) != 0) {
                    mVar = j.BRD;
                    break;
                }
                a aVar = j.BRE;
                int i = (int) ((1073741823 & j) >> 0);
                if ((((int) ((1152921503533105152L & j) >> 30)) & jVar.mask) == (jVar.mask & i)) {
                    mVar = null;
                    break;
                }
                m mVar2 = jVar.BRB.get(jVar.mask & i);
                if (mVar2 == null) {
                    if (jVar.BRC) {
                        mVar = null;
                        break;
                    }
                } else if (mVar2 instanceof b) {
                    mVar = null;
                    break;
                } else {
                    if ((((i) mVar2).eml() == l.PROBABLY_BLOCKING ? 1 : null) == null) {
                        mVar = null;
                        break;
                    }
                    int i2 = (i + 1) & 1073741823;
                    AtomicLongFieldUpdater atomicLongFieldUpdater = j.BRA;
                    a aVar2 = j.BRE;
                    if (atomicLongFieldUpdater.compareAndSet(jVar, j, a.K(j, i2))) {
                        jVar.BRB.set(jVar.mask & i, null);
                        mVar = mVar2;
                        break;
                    } else if (jVar.BRC) {
                        j jVar2 = jVar;
                        do {
                            jVar2 = j.a(jVar2, i, i2);
                        } while (jVar2 != null);
                        mVar = mVar2;
                        break;
                    }
                }
            }
            if (mVar != j.BRD) {
                i iVar = (i) mVar;
                AppMethodBeat.o(118356);
                return iVar;
            }
            i.BRy.compareAndSet(this, jVar, jVar.elO());
        }
    }
}
