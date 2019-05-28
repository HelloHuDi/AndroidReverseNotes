package a.i.b.a.c.l.a;

import a.i.b.a.c.l.a.o.a;
import a.i.b.a.c.l.a.o.b;
import a.i.b.a.c.l.ba;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final /* synthetic */ class i {
    public static final /* synthetic */ int[] eQZ;
    public static final /* synthetic */ int[] pCY;
    public static final /* synthetic */ int[] pEv;

    static {
        AppMethodBeat.i(122733);
        int[] iArr = new int[a.values().length];
        eQZ = iArr;
        iArr[a.CHECK_ONLY_LOWER.ordinal()] = 1;
        eQZ[a.CHECK_SUBTYPE_AND_LOWER.ordinal()] = 2;
        eQZ[a.SKIP_LOWER.ordinal()] = 3;
        iArr = new int[b.values().length];
        pCY = iArr;
        iArr[b.FORCE_NOT_SUBTYPE.ordinal()] = 1;
        pCY[b.TAKE_FIRST_FOR_SUBTYPING.ordinal()] = 2;
        pCY[b.CHECK_ANY_OF_THEM.ordinal()] = 3;
        pCY[b.INTERSECT_ARGUMENTS_AND_CHECK_AGAIN.ordinal()] = 4;
        iArr = new int[ba.values().length];
        pEv = iArr;
        iArr[ba.INVARIANT.ordinal()] = 1;
        pEv[ba.OUT_VARIANCE.ordinal()] = 2;
        pEv[ba.IN_VARIANCE.ordinal()] = 3;
        AppMethodBeat.o(122733);
    }
}
