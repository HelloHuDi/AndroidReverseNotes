package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ot;
import com.tencent.mm.protocal.protobuf.ou;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p;
import java.net.URLDecoder;

public final class m extends p {
    private final String TAG = "MicroMsg.NetSceneF2fDynamicCode";
    public ou pPb;

    public m(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        AppMethodBeat.i(44750);
        a aVar = new a();
        aVar.fsJ = new ot();
        aVar.fsK = new ou();
        aVar.fsI = 2736;
        aVar.uri = "/cgi-bin/mmpay-bin/f2fdynamiccode";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ot otVar = (ot) this.ehh.fsG.fsP;
        otVar.nUf = i;
        otVar.kfT = str;
        otVar.pPZ = str2;
        otVar.vVT = URLDecoder.decode(str3);
        otVar.pPH = str4;
        otVar.pPI = str5;
        otVar.pQc = str6;
        otVar.nickname = str7;
        otVar.pPw = str8;
        ab.i("MicroMsg.NetSceneF2fDynamicCode", "amount: %s, username: %s, transfer_code_id: %s", Integer.valueOf(i), str, URLDecoder.decode(str3));
        AppMethodBeat.o(44750);
    }

    public final int getType() {
        return 2736;
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(44751);
        ab.i("MicroMsg.NetSceneF2fDynamicCode", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pPb = (ou) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneF2fDynamicCode", "retcode: %s, retmsg: %s", Integer.valueOf(this.pPb.kCl), this.pPb.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(44751);
    }

    public final void f(q qVar) {
        ou ouVar = (ou) ((b) qVar).fsH.fsP;
        this.AfC = ouVar.kCl;
        this.AfD = ouVar.kCm;
    }
}
