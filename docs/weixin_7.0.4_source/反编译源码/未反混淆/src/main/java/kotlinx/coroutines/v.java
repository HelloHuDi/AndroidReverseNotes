package kotlinx.coroutines;

import a.c.d;
import a.c.e;
import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.coroutines.a.n;
import kotlinx.coroutines.c.c;

@l(dWo = {1, 1, 13}, dWp = {"\u0000B\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\r\u001a\u00020\u000eH\u0000\u001a\b\u0010\u000f\u001a\u00020\u0010H\u0000\u001a4\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u00122\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0017H\b¢\u0006\u0002\u0010\u0018\u001a\u0014\u0010\u0019\u001a\u00020\n*\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\nH\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u001a\u0010\t\u001a\u0004\u0018\u00010\u0001*\u00020\n8@X\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, dWq = {"COROUTINES_SCHEDULER_PROPERTY_NAME", "", "COROUTINE_ID", "Ljava/util/concurrent/atomic/AtomicLong;", "DEBUG_THREAD_NAME_SEPARATOR", "useCoroutinesScheduler", "", "getUseCoroutinesScheduler", "()Z", "coroutineName", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineName", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "createDefaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "resetCoroutineId", "", "withCoroutineContext", "T", "context", "countOrElement", "", "block", "Lkotlin/Function0;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "newCoroutineContext", "Lkotlinx/coroutines/CoroutineScope;", "kotlinx-coroutines-core"})
public final class v {
    private static final AtomicLong BPH = new AtomicLong();
    private static final boolean BPI;

    /* JADX WARNING: Missing block: B:7:0x0024, code skipped:
            r0 = new java.lang.IllegalStateException(("System property 'kotlinx.coroutines.scheduler' has unrecognized value '" + r0 + '\'').toString());
            com.tencent.matrix.trace.core.AppMethodBeat.o(118503);
     */
    /* JADX WARNING: Missing block: B:8:0x0048, code skipped:
            throw r0;
     */
    /* JADX WARNING: Missing block: B:10:0x0050, code skipped:
            if (r0.equals("") != false) goto L_0x0016;
     */
    /* JADX WARNING: Missing block: B:15:0x0065, code skipped:
            if (r0.equals("on") != false) goto L_0x0016;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        boolean z;
        AppMethodBeat.i(118503);
        String awA = n.awA("kotlinx.coroutines.scheduler");
        if (awA != null) {
            switch (awA.hashCode()) {
                case 0:
                    break;
                case 3551:
                    break;
                case 109935:
                    if (awA.equals("off")) {
                        z = false;
                        break;
                    }
                    break;
            }
        }
        z = true;
        BPI = z;
        AppMethodBeat.o(118503);
    }

    public static final w ekZ() {
        return BPI ? c.BSC : p.BPE;
    }

    public static final e a(ac acVar, e eVar) {
        e plus;
        AppMethodBeat.i(118501);
        j.p(acVar, "receiver$0");
        j.p(eVar, "context");
        e plus2 = acVar.ekT().plus(eVar);
        if (af.ela()) {
            plus = plus2.plus(new aa(BPH.incrementAndGet()));
        } else {
            plus = plus2;
        }
        if (plus2 == ao.elj() || plus2.get(d.AVd) != null) {
            AppMethodBeat.o(118501);
            return plus;
        }
        plus = plus.plus(ao.elj());
        AppMethodBeat.o(118501);
        return plus;
    }

    /* JADX WARNING: Missing block: B:9:0x0037, code skipped:
            if (r1 == null) goto L_0x0039;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final String a(e eVar) {
        AppMethodBeat.i(118502);
        j.p(eVar, "receiver$0");
        if (af.ela()) {
            aa aaVar = (aa) eVar.get(aa.BPL);
            if (aaVar == null) {
                AppMethodBeat.o(118502);
                return null;
            }
            String str;
            ab abVar = (ab) eVar.get(ab.BPM);
            if (abVar != null) {
                str = abVar.name;
            }
            str = "coroutine";
            String str2 = str + '#' + aaVar.id;
            AppMethodBeat.o(118502);
            return str2;
        }
        AppMethodBeat.o(118502);
        return null;
    }
}
