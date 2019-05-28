package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cjv;
import com.tencent.mm.protocal.protobuf.cjw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.FilterEnum4Shaka;

public final class n extends m implements k {
    private b ehh = null;
    private f ehi = null;
    public int lwc;
    public int lwd;
    public int opType;

    public n(int i, int i2) {
        AppMethodBeat.i(19472);
        this.opType = i;
        this.lwc = i2;
        a aVar = new a();
        aVar.fsJ = new cjv();
        aVar.fsK = new cjw();
        aVar.uri = "/cgi-bin/mmbiz-bin/rank/updateranksetting";
        aVar.fsI = FilterEnum4Shaka.MIC_SHAKA_ADD2_9;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        cjv cjv = (cjv) this.ehh.fsG.fsP;
        cjv.cKJ = this.opType;
        cjv.bJt = this.lwc;
        AppMethodBeat.o(19472);
    }

    public final int getType() {
        return FilterEnum4Shaka.MIC_SHAKA_ADD2_9;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(19473);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(19473);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(19474);
        ab.d("MicroMsg.NetSceneUpdateRankSetting", "hy: scene end. errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.lwd = ((cjw) this.ehh.fsH.fsP).bJt;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(19474);
    }
}
