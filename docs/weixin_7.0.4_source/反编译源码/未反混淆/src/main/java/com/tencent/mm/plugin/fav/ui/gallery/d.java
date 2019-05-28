package com.tencent.mm.plugin.fav.ui.gallery;

import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.aar;

public final class d {
    public aar cAJ;
    public g mnW;

    public d(g gVar, aar aar) {
        this.mnW = gVar;
        this.cAJ = aar;
    }

    public final boolean bws() {
        return this.cAJ.dataType == 4;
    }

    public final boolean bwt() {
        return this.cAJ.dataType == 15;
    }
}
