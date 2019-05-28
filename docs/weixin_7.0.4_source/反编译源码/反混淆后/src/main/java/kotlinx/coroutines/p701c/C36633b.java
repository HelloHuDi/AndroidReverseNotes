package kotlinx.coroutines.p701c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.coroutines.p701c.C36631a.C36632c;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13})
/* renamed from: kotlinx.coroutines.c.b */
public final /* synthetic */ class C36633b {
    public static final /* synthetic */ int[] eQZ;

    static {
        AppMethodBeat.m2504i(118355);
        int[] iArr = new int[C36632c.values().length];
        eQZ = iArr;
        iArr[C36632c.PARKING.ordinal()] = 1;
        eQZ[C36632c.BLOCKING.ordinal()] = 2;
        eQZ[C36632c.CPU_ACQUIRED.ordinal()] = 3;
        eQZ[C36632c.RETIRING.ordinal()] = 4;
        eQZ[C36632c.TERMINATED.ordinal()] = 5;
        AppMethodBeat.m2505o(118355);
    }
}
