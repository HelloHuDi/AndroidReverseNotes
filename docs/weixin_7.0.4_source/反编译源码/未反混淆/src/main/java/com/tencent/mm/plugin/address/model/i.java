package com.tencent.mm.plugin.address.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.asa;
import com.tencent.mm.protocal.protobuf.bty;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.sdk.platformtools.ab;

public final class i extends m implements k {
    private b ehh;
    private f ehi;
    public btz gIL;

    public i(com.tencent.mm.plugin.j.a.b bVar) {
        AppMethodBeat.i(16746);
        a aVar = new a();
        aVar.fsJ = new bty();
        aVar.fsK = new btz();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/saveinfo";
        this.ehh = aVar.acD();
        bty bty = (bty) this.ehh.fsG.fsP;
        bty.cvd = 2;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder("{\"user_uin\":");
        aw.ZK();
        stringBuilder.append(stringBuilder2.append(c.QF()).append(" ,\"user_data_list\": [").toString());
        if (bVar.type.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            stringBuilder.append("{\"group_key\": \"invoice_info\",\"group_info\": {\"group_id\": " + bVar.nuH + ",\"field_list\": [{\"key\": \"type\",\"value\": \"" + bVar.type + "\"},{\"key\": \"title\",\"value\": \"" + bVar.title + "\"},{\"key\": \"tax_number\",\"value\": \"" + bVar.nuJ + "\"},{\"key\": \"bank_number\",\"value\": \"" + bVar.nuK + "\"},{\"key\": \"phone\",\"value\": \"" + bVar.nuN + "\"},{\"key\": \"company_address_detail\",\"value\": \"" + bVar.nuP + "\"},{\"key\": \"bank_name\",\"value\": \"" + bVar.nuL + "\"}]}}");
        } else {
            stringBuilder.append("{\"group_key\": \"invoice_info\",\"group_info\": {\"group_id\": " + bVar.nuH + ",\"field_list\": [{\"key\": \"type\",\"value\": \"" + bVar.type + "\"},{\"key\": \"title\",\"value\": \"" + bVar.nuI + "\"},{\"key\": \"phone\",\"value\": \"" + bVar.nuO + "\"},{\"key\": \"email\",\"value\": \"" + bVar.dtV + "\"}]}}");
        }
        stringBuilder.append("]}");
        bty.wty = stringBuilder.toString();
        AppMethodBeat.o(16746);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(16747);
        ab.d("MicroMsg.NetSceneSaveUserAutoFillInfo", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            this.gIL = (btz) ((b) qVar).fsH.fsP;
            if (!(this.gIL == null || this.gIL.wVS == null || this.gIL.wVS.size() <= 0 || this.gIL.wVS.get(0) == null)) {
                ab.i("MicroMsg.NetSceneSaveUserAutoFillInfo", "resp groupId is.." + ((asa) this.gIL.wVS.get(0)).wcR);
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(16747);
    }

    public final int getType() {
        return 1180;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(16748);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(16748);
        return a;
    }
}
