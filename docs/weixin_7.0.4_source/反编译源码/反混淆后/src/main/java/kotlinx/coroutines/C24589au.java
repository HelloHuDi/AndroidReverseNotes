package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.coroutines.p700a.C46845m;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0000\u001a\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\tXT¢\u0006\u0002\n\u0000*\u001e\b\u0002\u0010\u0010\u001a\u0004\b\u0000\u0010\u0011\"\b\u0012\u0004\u0012\u0002H\u00110\u00122\b\u0012\u0004\u0012\u0002H\u00110\u0012¨\u0006\u0013"}, dWq = {"CLOSED_EMPTY", "Lkotlinx/coroutines/internal/Symbol;", "CLOSED_EMPTY$annotations", "()V", "DISPOSED_TASK", "MAX_MS", "", "MS_TO_NS", "SCHEDULE_COMPLETED", "", "SCHEDULE_DISPOSED", "SCHEDULE_OK", "delayNanosToMillis", "timeNanos", "delayToNanos", "timeMillis", "Queue", "T", "Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.au */
public final class C24589au {
    private static final C46845m BQq = new C46845m("REMOVED_TASK");
    private static final C46845m BQr = new C46845m("CLOSED_EMPTY");

    static {
        AppMethodBeat.m2504i(118373);
        AppMethodBeat.m2505o(118373);
    }

    /* renamed from: nY */
    public static final long m38233nY(long j) {
        if (1000 <= 0) {
            return 0;
        }
        if (1000 >= 9223372036854L) {
            return Long.MAX_VALUE;
        }
        return 1000000000;
    }
}
