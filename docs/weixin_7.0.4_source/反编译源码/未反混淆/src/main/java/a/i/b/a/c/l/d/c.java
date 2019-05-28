package a.i.b.a.c.l.d;

import a.i.b.a.c.l.ba;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final /* synthetic */ class c {
    public static final /* synthetic */ int[] eQZ;
    public static final /* synthetic */ int[] pCY;

    static {
        AppMethodBeat.i(122830);
        int[] iArr = new int[ba.values().length];
        eQZ = iArr;
        iArr[ba.INVARIANT.ordinal()] = 1;
        eQZ[ba.IN_VARIANCE.ordinal()] = 2;
        eQZ[ba.OUT_VARIANCE.ordinal()] = 3;
        iArr = new int[ba.values().length];
        pCY = iArr;
        iArr[ba.IN_VARIANCE.ordinal()] = 1;
        pCY[ba.OUT_VARIANCE.ordinal()] = 2;
        AppMethodBeat.o(122830);
    }
}
