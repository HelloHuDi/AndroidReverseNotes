package com.tencent.p177mm.plugin.radar.p489ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.radar.p488b.C39550e.C21557a;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13})
/* renamed from: com.tencent.mm.plugin.radar.ui.e */
public final /* synthetic */ class C12944e {
    public static final /* synthetic */ int[] eQZ;
    public static final /* synthetic */ int[] pCY;

    static {
        AppMethodBeat.m2504i(103016);
        int[] iArr = new int[C21557a.values().length];
        eQZ = iArr;
        iArr[C21557a.UnSelected.ordinal()] = 1;
        eQZ[C21557a.Selected.ordinal()] = 2;
        iArr = new int[C21557a.values().length];
        pCY = iArr;
        iArr[C21557a.Selected.ordinal()] = 1;
        pCY[C21557a.UnSelected.ordinal()] = 2;
        AppMethodBeat.m2505o(103016);
    }
}
