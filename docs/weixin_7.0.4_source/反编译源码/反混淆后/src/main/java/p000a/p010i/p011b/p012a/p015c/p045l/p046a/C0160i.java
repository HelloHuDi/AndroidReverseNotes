package p000a.p010i.p011b.p012a.p015c.p045l.p046a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p010i.p011b.p012a.p015c.p045l.C0163ba;
import p000a.p010i.p011b.p012a.p015c.p045l.p046a.C44919o.C37045a;
import p000a.p010i.p011b.p012a.p015c.p045l.p046a.C44919o.C44918b;

/* renamed from: a.i.b.a.c.l.a.i */
public final /* synthetic */ class C0160i {
    public static final /* synthetic */ int[] eQZ;
    public static final /* synthetic */ int[] pCY;
    public static final /* synthetic */ int[] pEv;

    static {
        AppMethodBeat.m2504i(122733);
        int[] iArr = new int[C37045a.values().length];
        eQZ = iArr;
        iArr[C37045a.CHECK_ONLY_LOWER.ordinal()] = 1;
        eQZ[C37045a.CHECK_SUBTYPE_AND_LOWER.ordinal()] = 2;
        eQZ[C37045a.SKIP_LOWER.ordinal()] = 3;
        iArr = new int[C44918b.values().length];
        pCY = iArr;
        iArr[C44918b.FORCE_NOT_SUBTYPE.ordinal()] = 1;
        pCY[C44918b.TAKE_FIRST_FOR_SUBTYPING.ordinal()] = 2;
        pCY[C44918b.CHECK_ANY_OF_THEM.ordinal()] = 3;
        pCY[C44918b.INTERSECT_ARGUMENTS_AND_CHECK_AGAIN.ordinal()] = 4;
        iArr = new int[C0163ba.values().length];
        pEv = iArr;
        iArr[C0163ba.INVARIANT.ordinal()] = 1;
        pEv[C0163ba.OUT_VARIANCE.ordinal()] = 2;
        pEv[C0163ba.IN_VARIANCE.ordinal()] = 3;
        AppMethodBeat.m2505o(122733);
    }
}
