package com.tencent.mm.plugin.scanner.a;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ky;
import com.tencent.mm.protocal.protobuf.kz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.FilterEnum4Shaka;

public final class h extends m implements k {
    private int ctE;
    private int eCW = 1;
    public b ehh;
    private f ehi;
    private int frO;
    private int offset;
    private byte[] pZD;

    public h(byte[] bArr, int i, int i2) {
        this.pZD = bArr;
        this.eCW = 1;
        this.frO = i;
        this.offset = 0;
        this.ctE = i2;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(80847);
        this.ehi = fVar;
        a aVar = new a();
        aVar.fsJ = new ky();
        aVar.fsK = new kz();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanimg";
        aVar.fsI = FilterEnum4Shaka.MIC_WEISHI_HUAYE;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ky kyVar = (ky) this.ehh.fsG.fsP;
        kyVar.vOn = ((int) bo.anU()) & BaseClientBuilder.API_PRIORITY_OTHER;
        kyVar.vOo = new SKBuiltinBuffer_t().setBuffer(this.pZD);
        kyVar.vOp = this.frO;
        kyVar.vOq = this.offset;
        if (this.offset + this.pZD.length < this.frO) {
            kyVar.fJT = 0;
        } else {
            kyVar.fJT = 1;
        }
        kyVar.vOr = this.eCW;
        kyVar.vOs = this.ctE;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(80847);
        return a;
    }

    public final m.b b(q qVar) {
        AppMethodBeat.i(80848);
        ky kyVar = (ky) ((b) qVar).fsG.fsP;
        m.b bVar;
        if (kyVar.vOn <= 0 || kyVar.vOr < 0 || kyVar.vOo == null || kyVar.vOo.getILen() <= 0 || kyVar.vOp <= 0 || kyVar.vOq < 0 || kyVar.vOq + kyVar.vOo.getILen() > kyVar.vOp) {
            ab.e("MicroMsg.scanner.NetSceneScanImage", "ERR: Security Check Failed, imageType = %s, totalLen = %s, offset = %s", Integer.valueOf(kyVar.vOr), Integer.valueOf(kyVar.vOp), Integer.valueOf(kyVar.vOq));
            if (kyVar.vOo != null) {
                ab.e("MicroMsg.scanner.NetSceneScanImage", "buffer length = %s", Integer.valueOf(kyVar.vOo.getILen()));
            }
            bVar = m.b.EFailed;
            AppMethodBeat.o(80848);
            return bVar;
        }
        bVar = m.b.EOk;
        AppMethodBeat.o(80848);
        return bVar;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(80849);
        ab.d("MicroMsg.scanner.NetSceneScanImage", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(80849);
    }

    public final int getType() {
        return FilterEnum4Shaka.MIC_WEISHI_HUAYE;
    }
}
