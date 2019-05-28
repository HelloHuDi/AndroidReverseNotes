package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.buw;
import com.tencent.mm.protocal.protobuf.bux;
import com.tencent.mm.protocal.protobuf.mh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.FilterEnum4Shaka;

public final class h extends m implements k {
    private String ctj;
    private f ehi;
    private String hlm;
    private b jKA;
    private bux jKB;
    private long jKC;
    private int offset;
    private int scene;

    public h(String str, long j, int i, int i2, String str2) {
        AppMethodBeat.i(13846);
        this.ctj = str;
        this.jKC = j;
        this.offset = i;
        this.scene = i2;
        this.hlm = str2;
        ab.i("MicroMsg.NetSceneSearchDetailPageNew", "Constructors: keyword = (%s) , LSB exist () , businessType is (%d) , offset is (%d) , scene is (%d), searchId(%s).", str, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str2);
        AppMethodBeat.o(13846);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(13847);
        ab.i("MicroMsg.NetSceneSearchDetailPageNew", "netId (%d) , errType (%d) , errCode (%d) , errMsg (%s)", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0 && this.jKA != null) {
            this.jKB = (bux) this.jKA.fsH.fsP;
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(13847);
    }

    public final int getType() {
        return FilterEnum4Shaka.MIC_WEISHI_LIULI;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(13848);
        this.ehi = fVar;
        if (bo.isNullOrNil(this.ctj)) {
            ab.e("MicroMsg.NetSceneSearchDetailPageNew", "keyword is unavailable.");
            AppMethodBeat.o(13848);
            return -1;
        }
        a aVar = new a();
        aVar.fsI = FilterEnum4Shaka.MIC_WEISHI_LIULI;
        aVar.uri = "/cgi-bin/mmbiz-bin/bizsearch/detailpage";
        aVar.fsJ = new buw();
        aVar.fsK = new bux();
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.jKA = aVar.acD();
        buw buw = (buw) this.jKA.fsG.fsP;
        buw.wDI = b.abJ();
        buw.wol = this.ctj;
        buw.vQd = this.jKC;
        buw.vOq = this.offset;
        buw.wWo = this.scene;
        buw.vQg = this.hlm;
        int a = a(eVar, this.jKA, this);
        AppMethodBeat.o(13848);
        return a;
    }

    public final mh aVX() {
        return this.jKB == null ? null : this.jKB.wWq;
    }
}
