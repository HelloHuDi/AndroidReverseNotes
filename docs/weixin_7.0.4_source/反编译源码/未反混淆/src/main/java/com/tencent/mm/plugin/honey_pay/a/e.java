package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.ajr;
import com.tencent.mm.protocal.protobuf.ajs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p;

public final class e extends p {
    private final String TAG = "MicroMsg.NetSceneGetHoneyPayCard";
    public ajs nqB;

    public e(String str) {
        AppMethodBeat.i(41725);
        a aVar = new a();
        aVar.fsJ = new ajr();
        aVar.fsK = new ajs();
        aVar.fsI = Exif.PARSE_EXIF_ERROR_NO_EXIF;
        aVar.uri = "/cgi-bin/mmpay-bin/gethpcard";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ajr ajr = (ajr) this.ehh.fsG.fsP;
        ajr.wpp = str;
        ajr.woh = k.bQO();
        ab.i("MicroMsg.NetSceneGetHoneyPayCard", "card no: %s", str);
        AppMethodBeat.o(41725);
    }

    public final int getType() {
        return Exif.PARSE_EXIF_ERROR_NO_EXIF;
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(41726);
        ab.i("MicroMsg.NetSceneGetHoneyPayCard", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.nqB = (ajs) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneGetHoneyPayCard", "retcode: %s, retmsg: %s", Integer.valueOf(this.nqB.kdT), this.nqB.kdU);
        if (this.nqB.wpq != null) {
            c.U(this.nqB.wpq.cJF, this.nqB.wpq.vQO, this.nqB.wpq.ubv);
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(41726);
    }

    public final void f(q qVar) {
        ajs ajs = (ajs) ((b) qVar).fsH.fsP;
        this.AfC = ajs.kdT;
        this.AfD = ajs.kdU;
    }
}
