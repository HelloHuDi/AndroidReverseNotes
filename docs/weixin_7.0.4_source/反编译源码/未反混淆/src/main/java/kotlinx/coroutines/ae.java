package kotlinx.coroutines;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13})
public final /* synthetic */ class ae {
    public static final /* synthetic */ int[] eQZ;
    public static final /* synthetic */ int[] pCY;

    static {
        AppMethodBeat.i(118549);
        int[] iArr = new int[ad.values().length];
        eQZ = iArr;
        iArr[ad.DEFAULT.ordinal()] = 1;
        eQZ[ad.ATOMIC.ordinal()] = 2;
        eQZ[ad.UNDISPATCHED.ordinal()] = 3;
        eQZ[ad.LAZY.ordinal()] = 4;
        iArr = new int[ad.values().length];
        pCY = iArr;
        iArr[ad.DEFAULT.ordinal()] = 1;
        pCY[ad.ATOMIC.ordinal()] = 2;
        pCY[ad.UNDISPATCHED.ordinal()] = 3;
        pCY[ad.LAZY.ordinal()] = 4;
        AppMethodBeat.o(118549);
    }
}
