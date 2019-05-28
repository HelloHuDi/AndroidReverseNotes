package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.lq;
import com.tencent.mm.protocal.protobuf.lr;
import com.tencent.mm.sdk.platformtools.ab;

public final class g extends m implements k {
    private f ehi;
    private b gme;
    lq pOK;
    public lr pOL;
    public c pOM;
    public d pON;
    public boolean pOO = false;
    public String pOP = "";
    public boolean pOQ = false;
    public int pOR = 0;

    public g(int i, int i2, int i3, String str, String str2, String str3, String str4, String str5, String str6, int i4, c cVar, d dVar) {
        AppMethodBeat.i(44732);
        this.pOP = System.currentTimeMillis() + i;
        a aVar = new a();
        this.pOR = i;
        aVar.fsJ = new lq();
        aVar.fsK = new lr();
        aVar.fsI = 2677;
        aVar.uri = "/cgi-bin/mmpay-bin/busif2fgetfavor";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.gme = aVar.acD();
        this.pOK = (lq) this.gme.fsG.fsP;
        this.pOK.nUf = i;
        this.pOK.cIb = i2;
        this.pOK.pOA = i3;
        this.pOK.vPl = str;
        this.pOK.pPW = str2;
        this.pOK.pOB = str3;
        this.pOK.pPZ = str4;
        this.pOK.vFf = str5;
        this.pOK.pOC = str6;
        this.pOK.vPm = i4;
        this.pOM = cVar;
        this.pON = dVar;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("request.amount %s", new Object[]{Integer.valueOf(this.pOK.nUf)}));
        stringBuffer.append(String.format("request.channel %s", new Object[]{Integer.valueOf(this.pOK.cIb)}));
        stringBuffer.append(String.format("request.scan_scene %s", new Object[]{Integer.valueOf(this.pOK.pOA)}));
        stringBuffer.append(String.format("request.receiver_desc %s", new Object[]{this.pOK.vPl}));
        stringBuffer.append(String.format("request.mch_name %s", new Object[]{this.pOK.pPW}));
        stringBuffer.append(String.format("request.favor_req_sign %s", new Object[]{this.pOK.pOB}));
        stringBuffer.append(String.format("request.receiver_openid %s", new Object[]{this.pOK.pPZ}));
        stringBuffer.append(String.format("request.receiver_username %s", new Object[]{this.pOK.vFf}));
        stringBuffer.append(String.format("request.favor_req_extend %s", new Object[]{this.pOK.pOC}));
        stringBuffer.append(String.format("request.fail_click_cell %s", new Object[]{Integer.valueOf(this.pOK.vPm)}));
        ab.i("MicroMsg.NetSceneBusiF2fGetFavor", "NetSceneBusiF2fGetFavor req %s", stringBuffer.toString());
        AppMethodBeat.o(44732);
    }

    public final int getType() {
        return 2677;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(44733);
        this.ehi = fVar;
        int a = a(eVar, this.gme, this);
        AppMethodBeat.o(44733);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(44734);
        ab.i("MicroMsg.NetSceneBusiF2fGetFavor", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.pOL = (lr) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneBusiF2fGetFavor", "ret_code: %s, ret_msg: %s favor_comm_resp : %s", Integer.valueOf(this.pOL.kdT), this.pOL.kdU, a.a(this.pOL.pOE));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(44734);
    }
}
