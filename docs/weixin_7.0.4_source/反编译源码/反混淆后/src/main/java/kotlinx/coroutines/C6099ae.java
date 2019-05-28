package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13})
/* renamed from: kotlinx.coroutines.ae */
public final /* synthetic */ class C6099ae {
    public static final /* synthetic */ int[] eQZ;
    public static final /* synthetic */ int[] pCY;

    static {
        AppMethodBeat.m2504i(118549);
        int[] iArr = new int[C6098ad.values().length];
        eQZ = iArr;
        iArr[C6098ad.DEFAULT.ordinal()] = 1;
        eQZ[C6098ad.ATOMIC.ordinal()] = 2;
        eQZ[C6098ad.UNDISPATCHED.ordinal()] = 3;
        eQZ[C6098ad.LAZY.ordinal()] = 4;
        iArr = new int[C6098ad.values().length];
        pCY = iArr;
        iArr[C6098ad.DEFAULT.ordinal()] = 1;
        pCY[C6098ad.ATOMIC.ordinal()] = 2;
        pCY[C6098ad.UNDISPATCHED.ordinal()] = 3;
        pCY[C6098ad.LAZY.ordinal()] = 4;
        AppMethodBeat.m2505o(118549);
    }
}
