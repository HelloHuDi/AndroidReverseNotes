package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bnt;
import com.tencent.mm.protocal.protobuf.bnu;
import com.tencent.mm.sdk.platformtools.ab;

public final class k extends m implements com.tencent.mm.network.k {
    private f ehi;
    private b gme;
    public String ssr;
    private bnt tub;
    public bnu tuc;

    public k(String str, String str2) {
        AppMethodBeat.i(46518);
        a aVar = new a();
        aVar.fsJ = new bnt();
        aVar.fsK = new bnu();
        aVar.uri = "/cgi-bin/mmpay-bin/mktqueryawardstatus";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.gme = aVar.acD();
        this.tub = (bnt) this.gme.fsG.fsP;
        this.tub.tIJ = str;
        this.ssr = str2;
        ab.i("MicroMsg.NetSceneMtkQueryAwardStatus", "NetSceneMtkQueryAwardStatus, query_award_status_params: %s, activityId: %s", str, str2);
        AppMethodBeat.o(46518);
    }

    public final int getType() {
        return 2710;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(46519);
        this.ehi = fVar;
        int a = a(eVar, this.gme, this);
        AppMethodBeat.o(46519);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(46520);
        ab.i("MicroMsg.NetSceneMtkQueryAwardStatus", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.tuc = (bnu) ((b) qVar).fsH.fsP;
        if (i2 == 0 || i3 == 0) {
            ab.i("MicroMsg.NetSceneMtkQueryAwardStatus", "ret_code: %s, ret_msg: %s", Integer.valueOf(this.tuc.kdT), this.tuc.kdU);
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(46520);
    }
}
