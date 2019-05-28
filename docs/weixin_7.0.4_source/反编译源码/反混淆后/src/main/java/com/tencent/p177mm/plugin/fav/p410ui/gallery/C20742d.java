package com.tencent.p177mm.plugin.fav.p410ui.gallery;

import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.protocal.protobuf.aar;

/* renamed from: com.tencent.mm.plugin.fav.ui.gallery.d */
public final class C20742d {
    public aar cAJ;
    public C27966g mnW;

    public C20742d(C27966g c27966g, aar aar) {
        this.mnW = c27966g;
        this.cAJ = aar;
    }

    public final boolean bws() {
        return this.cAJ.dataType == 4;
    }

    public final boolean bwt() {
        return this.cAJ.dataType == 15;
    }
}
