package com.tencent.p177mm.plugin.location.p446ui.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelgeo.Addr;
import com.tencent.p177mm.protocal.protobuf.bhu;

/* renamed from: com.tencent.mm.plugin.location.ui.impl.f */
public final class C43245f {
    public double bDG;
    public double bDH;
    public String mName;
    public String nQA;
    public String nQB;
    public int nQC = -1;
    public String nQp;
    public String nQq;
    public String nQr;
    public String nQs;
    public String nQt;
    public String nQu;
    public String nQv;
    public String nQw;
    public String nQx;
    public String nQy;
    public Addr nQz;
    public int type;

    public C43245f(bhu bhu, String str) {
        AppMethodBeat.m2504i(113667);
        this.mName = bhu.Name;
        this.nQp = bhu.wKW;
        this.bDH = bhu.vNH;
        this.bDG = bhu.vNI;
        this.nQq = bhu.wKX;
        this.nQr = bhu.oRb;
        this.nQs = bhu.wKY;
        this.nQt = bhu.guO;
        this.nQu = bhu.guP;
        this.nQv = bhu.wcl;
        this.nQw = bhu.wcm;
        this.nQx = bhu.wKZ;
        this.nQA = str;
        this.nQz = new Addr();
        this.nQz.fBg = this.nQp;
        this.nQz.fBi = this.nQu;
        this.nQz.fBj = this.nQu;
        this.nQz.fBk = this.nQv;
        this.nQz.fBm = this.nQx;
        this.nQz.fBp = this.mName;
        this.nQz.fBh = this.nQt;
        this.nQz.fBs = (float) bhu.vNH;
        this.nQz.fBr = (float) bhu.vNI;
        this.type = 0;
        AppMethodBeat.m2505o(113667);
    }
}
