package com.tencent.mm.plugin.address.model;

import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.apm;
import com.tencent.mm.protocal.protobuf.apn;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends m implements k {
    private com.tencent.mm.ai.b ehh;
    private f ehi;

    public b() {
        AppMethodBeat.i(16725);
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
        AppMethodBeat.o(16725);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(16726);
        ab.d("MicroMsg.NetSceneGetUserAutoFillInfo", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            com.tencent.mm.plugin.address.a.a.arR().gIF = new com.tencent.mm.plugin.j.a.a();
            ab.i("MicroMsg.NetSceneGetUserAutoFillInfo", "return is 0.now we resetList and parse the json ..");
            apn apn = (apn) ((com.tencent.mm.ai.b) qVar).fsH.fsP;
            ab.i("MicroMsg.NetSceneGetUserAutoFillInfo", "resp json is.." + apn.wty);
            if (apn.wty != null) {
                try {
                    JSONArray jSONArray = new JSONObject(apn.wty).getJSONArray("user_data_list").getJSONObject(0).getJSONArray("group_info_list");
                    if (jSONArray != null && jSONArray.length() > 0) {
                        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                            try {
                                JSONObject jSONObject = jSONArray.getJSONObject(i4);
                                com.tencent.mm.plugin.j.a.b bVar = new com.tencent.mm.plugin.j.a.b();
                                bVar.nuH = jSONObject.getInt(com.google.firebase.analytics.FirebaseAnalytics.b.GROUP_ID);
                                bVar.nuQ = jSONObject.getString("invoice_url");
                                ab.i("MicroMsg.NetSceneGetUserAutoFillInfo", "get groupid:" + jSONObject.getInt(com.google.firebase.analytics.FirebaseAnalytics.b.GROUP_ID) + "get invoiceUrl:" + jSONObject.getString("invoice_url"));
                                JSONArray jSONArray2 = jSONObject.getJSONArray("field_list");
                                if (jSONArray2 != null && jSONArray2.length() > 0) {
                                    for (int i5 = 0; i5 < jSONArray2.length(); i5++) {
                                        JSONObject jSONObject2 = jSONArray2.getJSONObject(i5);
                                        String string = jSONObject2.getString("key");
                                        Object obj = -1;
                                        switch (string.hashCode()) {
                                            case -1787383122:
                                                if (string.equals("bank_name")) {
                                                    obj = 2;
                                                    break;
                                                }
                                                break;
                                            case -192204195:
                                                if (string.equals("tax_number")) {
                                                    obj = 1;
                                                    break;
                                                }
                                                break;
                                            case 3575610:
                                                if (string.equals("type")) {
                                                    obj = 4;
                                                    break;
                                                }
                                                break;
                                            case 96619420:
                                                if (string.equals(Scopes.EMAIL)) {
                                                    obj = 5;
                                                    break;
                                                }
                                                break;
                                            case 106642798:
                                                if (string.equals("phone")) {
                                                    obj = 6;
                                                    break;
                                                }
                                                break;
                                            case 110371416:
                                                if (string.equals("title")) {
                                                    obj = null;
                                                    break;
                                                }
                                                break;
                                            case 330208940:
                                                if (string.equals("bank_number")) {
                                                    obj = 3;
                                                    break;
                                                }
                                                break;
                                            case 944498430:
                                                if (string.equals("company_address_detail")) {
                                                    obj = 7;
                                                    break;
                                                }
                                                break;
                                        }
                                        switch (obj) {
                                            case null:
                                                bVar.title = jSONObject2.getString("value");
                                                break;
                                            case 1:
                                                bVar.nuJ = jSONObject2.getString("value");
                                                break;
                                            case 2:
                                                bVar.nuL = jSONObject2.getString("value");
                                                break;
                                            case 3:
                                                bVar.nuK = jSONObject2.getString("value");
                                                break;
                                            case 4:
                                                bVar.type = jSONObject2.getString("value");
                                                break;
                                            case 5:
                                                bVar.dtV = jSONObject2.getString("value");
                                                break;
                                            case 6:
                                                bVar.nuN = jSONObject2.getString("value");
                                                bVar.nuO = jSONObject2.getString("value");
                                                break;
                                            case 7:
                                                bVar.nuP = jSONObject2.getString("value");
                                                break;
                                            default:
                                                break;
                                        }
                                    }
                                }
                                com.tencent.mm.plugin.address.b.a.a arR = com.tencent.mm.plugin.address.a.a.arR();
                                if (bVar.type != null && bVar.type.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                    bVar.nuI = "";
                                    bVar.nuO = "";
                                    bVar.dtV = "";
                                    arR.gIF.nuG.add(bVar);
                                } else if (bVar.type != null && bVar.type.equals("1")) {
                                    bVar.nuI = bVar.title;
                                    bVar.title = "";
                                    bVar.nuN = "";
                                    bVar.nuJ = "";
                                    bVar.nuK = "";
                                    bVar.nuL = "";
                                    bVar.nuP = "";
                                    arR.gIF.nuG.add(bVar);
                                }
                                ab.i("MicroMsg.InvoiceMgr", "type is error..");
                            } catch (JSONException e) {
                                ab.e("MicroMsg.NetSceneGetUserAutoFillInfo", "parse error for no.".concat(String.valueOf(i4)));
                            }
                        }
                    }
                } catch (JSONException e2) {
                    ab.e("MicroMsg.NetSceneGetUserAutoFillInfo", "error parse this json");
                }
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(16726);
    }

    public final int getType() {
        return 1191;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(16727);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(16727);
        return a;
    }
}
