package com.tencent.mm.plugin.wallet_index.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_index.c.l;
import com.tencent.mm.protocal.protobuf.auh;
import com.tencent.mm.protocal.protobuf.aui;
import com.tencent.mm.wallet_core.c.t;
import java.util.ArrayList;
import java.util.List;

public final class c {
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

    public c() {
        AppMethodBeat.i(48227);
        AppMethodBeat.o(48227);
    }

    public final boolean cSX() {
        return this.peo == 2;
    }

    public final m a(com.tencent.mm.plugin.wallet_index.b.a.c cVar, boolean z) {
        AppMethodBeat.i(48228);
        int i = z ? 2 : 1;
        if (this.tRE) {
            if (!cSX()) {
                this.tRe.wyp = cVar.mSignature;
                this.tRe.wym = cVar.tQV;
                this.tRe.pdz = cVar.tQY;
                this.tRe.wma = cVar.tQX;
                this.tRe.pho = cVar.kWz;
                this.tRe.wyo = cVar.tQW;
            }
            l lVar = new l(this.peo, i, cVar.kWz, this.tRf, this.tRe);
            AppMethodBeat.o(48228);
            return lVar;
        }
        m tVar = new t(cVar.kWz, i, this.peo, this.mCount, cVar.tQV, cVar.tQW, cVar.mSignature, cVar.tQX, cVar.tQY);
        AppMethodBeat.o(48228);
        return tVar;
    }
}
