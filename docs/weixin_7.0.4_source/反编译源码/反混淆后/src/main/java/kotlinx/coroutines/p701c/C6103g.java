package kotlinx.coroutines.p701c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, dWq = {"Lkotlinx/coroutines/scheduling/NanoTimeSource;", "Lkotlinx/coroutines/scheduling/TimeSource;", "()V", "nanoTime", "", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.c.g */
public final class C6103g extends C16463n {
    public static final C6103g BSK = new C6103g();

    static {
        AppMethodBeat.m2504i(118354);
        AppMethodBeat.m2505o(118354);
    }

    private C6103g() {
    }

    public final long nanoTime() {
        AppMethodBeat.m2504i(118353);
        long nanoTime = System.nanoTime();
        AppMethodBeat.m2505o(118353);
        return nanoTime;
    }
}
