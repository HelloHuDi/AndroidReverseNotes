package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.bbx;
import com.tencent.mm.protocal.protobuf.xe;
import com.tencent.mm.protocal.protobuf.xf;

public final class k extends b {
    private bbx qjJ;

    public k(boolean z, int i, int i2) {
        int i3 = 1;
        super(31);
        AppMethodBeat.i(126861);
        this.qjJ = new bbx();
        xe xeVar = new xe();
        xeVar.wcX = z ? 1 : 0;
        if (z) {
            i3 = 0;
        }
        xeVar.wcZ = i3;
        xf xfVar = new xf();
        xfVar.wdb = i;
        xfVar.wdc = i2;
        xeVar.wcY = xfVar;
        xfVar.wdb = 0;
        xfVar.wdc = 0;
        xeVar.wda = xfVar;
        this.qjJ.wGB = xeVar;
        this.oqT = this.qjJ;
        AppMethodBeat.o(126861);
    }

    public k() {
        this(false, 22, 8);
    }
}
