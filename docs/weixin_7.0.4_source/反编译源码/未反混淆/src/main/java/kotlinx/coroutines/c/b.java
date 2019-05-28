package kotlinx.coroutines.c;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.coroutines.c.a.c;

@l(dWo = {1, 1, 13})
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] eQZ;

    static {
        AppMethodBeat.i(118355);
        int[] iArr = new int[c.values().length];
        eQZ = iArr;
        iArr[c.PARKING.ordinal()] = 1;
        eQZ[c.BLOCKING.ordinal()] = 2;
        eQZ[c.CPU_ACQUIRED.ordinal()] = 3;
        eQZ[c.RETIRING.ordinal()] = 4;
        eQZ[c.TERMINATED.ordinal()] = 5;
        AppMethodBeat.o(118355);
    }
}
