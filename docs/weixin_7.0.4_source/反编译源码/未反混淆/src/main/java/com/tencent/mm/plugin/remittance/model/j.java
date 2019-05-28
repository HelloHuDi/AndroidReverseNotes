package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cz;
import com.tencent.mm.protocal.protobuf.lw;
import com.tencent.mm.protocal.protobuf.lx;
import com.tencent.mm.sdk.platformtools.ab;

public final class j extends m implements k {
    private f ehi;
    private b gme;
    public lx pOW;

    public j(cz czVar, String str) {
        AppMethodBeat.i(44741);
        a aVar = new a();
        aVar.fsJ = new lw();
        aVar.fsK = new lx();
        aVar.uri = "/cgi-bin/mmpay-bin/busif2fsucpage";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.gme = aVar.acD();
        lw lwVar = (lw) this.gme.fsG.fsP;
        lwVar.vPn = czVar;
        lwVar.vPC = str;
        ab.i("MicroMsg.NetSceneBusiF2fSucpage", "NetSceneBusiF2fSucpage suc_page_extend %s req %s", str, a.a(czVar));
        AppMethodBeat.o(44741);
    }

    public final int getType() {
        return 2504;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(44742);
        this.ehi = fVar;
        int a = a(eVar, this.gme, this);
        AppMethodBeat.o(44742);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(44743);
        ab.i("MicroMsg.NetSceneBusiF2fSucpage", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.pOW = (lx) ((b) qVar).fsH.fsP;
        StringBuffer stringBuffer = new StringBuffer();
        if (this.pOW.tBw != null) {
            stringBuffer.append("response: " + this.pOW.vPQ);
            stringBuffer.append("is_show_btn: " + this.pOW.tBw.wex);
            if (this.pOW.tBw.wew != null) {
                stringBuffer.append("single_exposure_info_list " + this.pOW.tBw.wew.size());
            }
        }
        ab.i("MicroMsg.NetSceneBusiF2fSucpage", "ret_code: %s, ret_msg: %s %s", Integer.valueOf(this.pOW.kdT), this.pOW.kdU, stringBuffer.toString());
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(44743);
    }
}
