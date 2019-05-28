package com.tencent.mm.plugin.radar.ui;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.radar.b.c.e;

@l(dWo = {1, 1, 13})
public final /* synthetic */ class h {
    public static final /* synthetic */ int[] eQZ;
    public static final /* synthetic */ int[] pCY;
    public static final /* synthetic */ int[] pEv;

    static {
        AppMethodBeat.i(103094);
        int[] iArr = new int[e.values().length];
        eQZ = iArr;
        iArr[e.Stranger.ordinal()] = 1;
        eQZ[e.NeedVerify.ordinal()] = 2;
        iArr = new int[com.tencent.mm.plugin.radar.b.e.e.values().length];
        pCY = iArr;
        iArr[com.tencent.mm.plugin.radar.b.e.e.SEARCHING.ordinal()] = 1;
        pCY[com.tencent.mm.plugin.radar.b.e.e.SEARCH_RETRUN.ordinal()] = 2;
        pCY[com.tencent.mm.plugin.radar.b.e.e.RALATIONCHAIN_RETRUN.ordinal()] = 3;
        iArr = new int[com.tencent.mm.plugin.radar.b.e.e.values().length];
        pEv = iArr;
        iArr[com.tencent.mm.plugin.radar.b.e.e.SEARCHING.ordinal()] = 1;
        pEv[com.tencent.mm.plugin.radar.b.e.e.SEARCH_RETRUN.ordinal()] = 2;
        pEv[com.tencent.mm.plugin.radar.b.e.e.RALATIONCHAIN.ordinal()] = 3;
        pEv[com.tencent.mm.plugin.radar.b.e.e.RALATIONCHAIN_RETRUN.ordinal()] = 4;
        pEv[com.tencent.mm.plugin.radar.b.e.e.CREATING_CHAT.ordinal()] = 5;
        AppMethodBeat.o(103094);
    }
}
