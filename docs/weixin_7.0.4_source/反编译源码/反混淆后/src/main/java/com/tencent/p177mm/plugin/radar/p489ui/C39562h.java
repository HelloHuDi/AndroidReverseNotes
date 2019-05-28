package com.tencent.p177mm.plugin.radar.p489ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.radar.p488b.C39550e.C39549e;
import com.tencent.p177mm.plugin.radar.p488b.C43413c.C21556e;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13})
/* renamed from: com.tencent.mm.plugin.radar.ui.h */
public final /* synthetic */ class C39562h {
    public static final /* synthetic */ int[] eQZ;
    public static final /* synthetic */ int[] pCY;
    public static final /* synthetic */ int[] pEv;

    static {
        AppMethodBeat.m2504i(103094);
        int[] iArr = new int[C21556e.values().length];
        eQZ = iArr;
        iArr[C21556e.Stranger.ordinal()] = 1;
        eQZ[C21556e.NeedVerify.ordinal()] = 2;
        iArr = new int[C39549e.values().length];
        pCY = iArr;
        iArr[C39549e.SEARCHING.ordinal()] = 1;
        pCY[C39549e.SEARCH_RETRUN.ordinal()] = 2;
        pCY[C39549e.RALATIONCHAIN_RETRUN.ordinal()] = 3;
        iArr = new int[C39549e.values().length];
        pEv = iArr;
        iArr[C39549e.SEARCHING.ordinal()] = 1;
        pEv[C39549e.SEARCH_RETRUN.ordinal()] = 2;
        pEv[C39549e.RALATIONCHAIN.ordinal()] = 3;
        pEv[C39549e.RALATIONCHAIN_RETRUN.ordinal()] = 4;
        pEv[C39549e.CREATING_CHAT.ordinal()] = 5;
        AppMethodBeat.m2505o(103094);
    }
}
