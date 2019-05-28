package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bvg;
import com.tencent.mm.protocal.protobuf.bvh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.FilterEnum4Shaka;

public final class i extends m implements k {
    private String ctj;
    private f ehi;
    private b jKA;
    private long jKC;
    public bvh jKD;
    private int scene;

    public i(String str, long j, int i) {
        AppMethodBeat.i(13849);
        this.ctj = str;
        this.jKC = j;
        this.scene = i;
        ab.i("MicroMsg.NetSceneSearchHomePageNew", "Constructors: keyword (%s) , businessType (%d), scene (%d)", str, Long.valueOf(j), Integer.valueOf(i));
        AppMethodBeat.o(13849);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(13850);
        ab.i("MicroMsg.NetSceneSearchHomePageNew", "netId (%d) , errType (%d) , errCode (%d) , errMsg (%s)", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0 && this.jKA != null) {
            this.jKD = (bvh) this.jKA.fsH.fsP;
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(13850);
    }

    public final int getType() {
        return FilterEnum4Shaka.MIC_WEISHI_XINXUE;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(13851);
        ab.i("MicroMsg.NetSceneSearchHomePageNew", "doScene");
        this.ehi = fVar;
        if (bo.isNullOrNil(this.ctj)) {
            ab.e("MicroMsg.NetSceneSearchHomePageNew", "keyword is unavailable");
            AppMethodBeat.o(13851);
            return -1;
        }
        a aVar = new a();
        aVar.fsI = FilterEnum4Shaka.MIC_WEISHI_XINXUE;
        aVar.uri = "/cgi-bin/mmbiz-bin/bizsearch/homepage";
        aVar.fsJ = new bvg();
        aVar.fsK = new bvh();
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.jKA = aVar.acD();
        bvg bvg = (bvg) this.jKA.fsG.fsP;
        bvg.wol = this.ctj;
        bvg.wDI = b.abJ();
        bvg.vQd = this.jKC;
        bvg.wWo = this.scene;
        ab.i("MicroMsg.NetSceneSearchHomePageNew", "businessTypeList is %d", Long.valueOf(this.jKC));
        int a = a(eVar, this.jKA, this);
        AppMethodBeat.o(13851);
        return a;
    }
}
