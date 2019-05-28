package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.apm;
import com.tencent.mm.protocal.protobuf.apn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class g extends m implements k {
    private b ehh;
    private f ehi;

    public g() {
        AppMethodBeat.i(126851);
        a aVar = new a();
        aVar.fsJ = new apm();
        aVar.fsK = new apn();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo";
        this.ehh = aVar.acD();
        apm apm = (apm) this.ehh.fsG.fsP;
        apm.cvd = 2;
        LinkedList linkedList = new LinkedList();
        linkedList.add("invoice_info.title");
        linkedList.add("invoice_info.tax_number");
        linkedList.add("invoice_info.bank_number");
        linkedList.add("invoice_info.bank_name");
        linkedList.add("invoice_info.type");
        linkedList.add("invoice_info.email");
        linkedList.add("invoice_info.company_address");
        linkedList.add("invoice_info.company_address_detail");
        linkedList.add("invoice_info.company_address_postcode");
        linkedList.add("invoice_info.phone");
        apm.wtx = linkedList;
        apm.wtw = false;
        AppMethodBeat.o(126851);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(126852);
        ab.d("MicroMsg.NetSceneGetUserAutoFillInfo", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            ab.i("MicroMsg.NetSceneGetUserAutoFillInfo", "return is 0.now we parse the json and resetList..");
            apn apn = (apn) ((b) qVar).fsH.fsP;
            if (apn.wty != null) {
                try {
                    boolean z = new JSONObject(apn.wty).getBoolean("has_invoice_info");
                    ab.i("MicroMsg.NetSceneGetUserAutoFillInfo", "has_invoice_info is ..".concat(String.valueOf(z)));
                    com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_ABOUT_INVOICE_ENTRANCE_BOOLEAN, Boolean.valueOf(z));
                } catch (JSONException e) {
                    ab.e("MicroMsg.NetSceneGetUserAutoFillInfo", "error parse this json");
                }
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(126852);
    }

    public final int getType() {
        return 1191;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(126853);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(126853);
        return a;
    }
}
