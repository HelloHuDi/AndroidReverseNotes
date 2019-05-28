package com.tencent.p177mm.plugin.wallet_index.p566ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.wallet_index.p1052b.p1053a.C22688c;
import com.tencent.p177mm.plugin.wallet_index.p564c.C29692l;
import com.tencent.p177mm.protocal.protobuf.auh;
import com.tencent.p177mm.protocal.protobuf.aui;
import com.tencent.p177mm.wallet_core.p649c.C16079t;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wallet_index.ui.c */
public final class C14357c {
    String kWz = null;
    public int mCount = 1;
    int peo;
    public String tQX = null;
    public String tQY = null;
    public ArrayList<String> tRA = new ArrayList();
    public String tRB = null;
    public int tRC = 0;
    List<String> tRD = new ArrayList();
    boolean tRE = false;
    public String tRF;
    public String tRG;
    public auh tRe;
    public aui tRf;
    public String tRw = null;
    public ArrayList<String> tRz = new ArrayList();

    public C14357c() {
        AppMethodBeat.m2504i(48227);
        AppMethodBeat.m2505o(48227);
    }

    public final boolean cSX() {
        return this.peo == 2;
    }

    /* renamed from: a */
    public final C1207m mo26627a(C22688c c22688c, boolean z) {
        AppMethodBeat.m2504i(48228);
        int i = z ? 2 : 1;
        if (this.tRE) {
            if (!cSX()) {
                this.tRe.wyp = c22688c.mSignature;
                this.tRe.wym = c22688c.tQV;
                this.tRe.pdz = c22688c.tQY;
                this.tRe.wma = c22688c.tQX;
                this.tRe.pho = c22688c.kWz;
                this.tRe.wyo = c22688c.tQW;
            }
            C29692l c29692l = new C29692l(this.peo, i, c22688c.kWz, this.tRf, this.tRe);
            AppMethodBeat.m2505o(48228);
            return c29692l;
        }
        C1207m c16079t = new C16079t(c22688c.kWz, i, this.peo, this.mCount, c22688c.tQV, c22688c.tQW, c22688c.mSignature, c22688c.tQX, c22688c.tQY);
        AppMethodBeat.m2505o(48228);
        return c16079t;
    }
}
