package com.tencent.mm.plugin.scanner.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.lc;
import com.tencent.mm.protocal.protobuf.ld;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.FilterEnum4Shaka;

public final class i extends m implements k {
    private b ehh;
    private f ehi;

    public i(String str, String str2, int i, String str3, int i2, int i3) {
        AppMethodBeat.i(80850);
        a aVar = new a();
        aVar.fsJ = new lc();
        aVar.fsK = new ld();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanproductreport";
        aVar.fsI = FilterEnum4Shaka.MIC_WEISHI_BAIHUA;
        this.ehh = aVar.acD();
        lc lcVar = (lc) this.ehh.fsG.fsP;
        lcVar.vOz = d.vxj;
        lcVar.vOA = d.vxi;
        lcVar.vOB = d.vxl;
        lcVar.vOC = d.vxm;
        lcVar.vOD = aa.dor();
        lcVar.pXL = 11294;
        lcVar.vOE = null;
        lcVar.pZp = str;
        lcVar.pZo = str2;
        lcVar.type = i;
        lcVar.value = str3;
        lcVar.count = i2;
        lcVar.oZe = i3;
        ab.v("MircoMsg.NetSceneScanProductReport", "statid:".concat(String.valueOf(str2)));
        AppMethodBeat.o(80850);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(80851);
        ab.d("MircoMsg.NetSceneScanProductReport", "errType = " + i2 + ", errCode = " + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(80851);
    }

    public final int getType() {
        return FilterEnum4Shaka.MIC_WEISHI_BAIHUA;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(80852);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(80852);
        return a;
    }
}
