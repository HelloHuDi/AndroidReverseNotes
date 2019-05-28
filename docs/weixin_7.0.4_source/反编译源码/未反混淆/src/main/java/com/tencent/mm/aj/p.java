package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ka;
import com.tencent.mm.protocal.protobuf.kb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.FilterEnum4Shaka;

public final class p extends m implements k {
    private String edV;
    b ehh;
    private f ehi;
    private a<p> fwN;

    public interface a<T extends m> {
        void a(int i, int i2, String str, T t);
    }

    public p(String str, String str2, a<p> aVar) {
        this(str, str2);
        this.fwN = aVar;
    }

    private p(String str, String str2) {
        AppMethodBeat.i(11432);
        this.edV = str;
        ab.i("MicroMsg.NetSceneBizAttrSync", "[BizAttr] NetSceneBizAttrSync (%s)", str);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsI = FilterEnum4Shaka.MIC_WEISHI_LIUJIN;
        aVar.uri = "/cgi-bin/mmbiz-bin/bizattr/bizattrsync";
        aVar.fsJ = new ka();
        aVar.fsK = new kb();
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ka kaVar = (ka) this.ehh.fsG.fsP;
        kaVar.vMR = this.edV;
        kaVar.vMS = new com.tencent.mm.bt.b(bo.anf(bo.nullAsNil(str2)));
        AppMethodBeat.o(11432);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(11433);
        ab.i("MicroMsg.NetSceneBizAttrSync", "[BizAttr] onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        if (this.fwN != null) {
            this.fwN.a(i2, i3, str, this);
        }
        AppMethodBeat.o(11433);
    }

    public final int getType() {
        return FilterEnum4Shaka.MIC_WEISHI_LIUJIN;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(11434);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(11434);
        return a;
    }
}
