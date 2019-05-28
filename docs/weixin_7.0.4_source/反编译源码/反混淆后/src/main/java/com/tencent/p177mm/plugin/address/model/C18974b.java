package com.tencent.p177mm.plugin.address.model;

import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.Scopes;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.address.p1467a.C33045a;
import com.tencent.p177mm.plugin.address.p718b.p1387a.C26684a;
import com.tencent.p177mm.plugin.p984j.p985a.C12328b;
import com.tencent.p177mm.plugin.p984j.p985a.C43233a;
import com.tencent.p177mm.protocal.protobuf.apm;
import com.tencent.p177mm.protocal.protobuf.apn;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.address.model.b */
public final class C18974b extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;

    public C18974b() {
        AppMethodBeat.m2504i(16725);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new apm();
        c1196a.fsK = new apn();
        c1196a.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo";
        this.ehh = c1196a.acD();
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
        AppMethodBeat.m2505o(16725);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(16726);
        C4990ab.m7410d("MicroMsg.NetSceneGetUserAutoFillInfo", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            C33045a.arR().gIF = new C43233a();
            C4990ab.m7416i("MicroMsg.NetSceneGetUserAutoFillInfo", "return is 0.now we resetList and parse the json ..");
            apn apn = (apn) ((C7472b) c1929q).fsH.fsP;
            C4990ab.m7416i("MicroMsg.NetSceneGetUserAutoFillInfo", "resp json is.." + apn.wty);
            if (apn.wty != null) {
                try {
                    JSONArray jSONArray = new JSONObject(apn.wty).getJSONArray("user_data_list").getJSONObject(0).getJSONArray("group_info_list");
                    if (jSONArray != null && jSONArray.length() > 0) {
                        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                            try {
                                JSONObject jSONObject = jSONArray.getJSONObject(i4);
                                C12328b c12328b = new C12328b();
                                c12328b.nuH = jSONObject.getInt(C8741b.GROUP_ID);
                                c12328b.nuQ = jSONObject.getString("invoice_url");
                                C4990ab.m7416i("MicroMsg.NetSceneGetUserAutoFillInfo", "get groupid:" + jSONObject.getInt(C8741b.GROUP_ID) + "get invoiceUrl:" + jSONObject.getString("invoice_url"));
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
                                                c12328b.title = jSONObject2.getString("value");
                                                break;
                                            case 1:
                                                c12328b.nuJ = jSONObject2.getString("value");
                                                break;
                                            case 2:
                                                c12328b.nuL = jSONObject2.getString("value");
                                                break;
                                            case 3:
                                                c12328b.nuK = jSONObject2.getString("value");
                                                break;
                                            case 4:
                                                c12328b.type = jSONObject2.getString("value");
                                                break;
                                            case 5:
                                                c12328b.dtV = jSONObject2.getString("value");
                                                break;
                                            case 6:
                                                c12328b.nuN = jSONObject2.getString("value");
                                                c12328b.nuO = jSONObject2.getString("value");
                                                break;
                                            case 7:
                                                c12328b.nuP = jSONObject2.getString("value");
                                                break;
                                            default:
                                                break;
                                        }
                                    }
                                }
                                C26684a arR = C33045a.arR();
                                if (c12328b.type != null && c12328b.type.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                    c12328b.nuI = "";
                                    c12328b.nuO = "";
                                    c12328b.dtV = "";
                                    arR.gIF.nuG.add(c12328b);
                                } else if (c12328b.type != null && c12328b.type.equals("1")) {
                                    c12328b.nuI = c12328b.title;
                                    c12328b.title = "";
                                    c12328b.nuN = "";
                                    c12328b.nuJ = "";
                                    c12328b.nuK = "";
                                    c12328b.nuL = "";
                                    c12328b.nuP = "";
                                    arR.gIF.nuG.add(c12328b);
                                }
                                C4990ab.m7416i("MicroMsg.InvoiceMgr", "type is error..");
                            } catch (JSONException e) {
                                C4990ab.m7412e("MicroMsg.NetSceneGetUserAutoFillInfo", "parse error for no.".concat(String.valueOf(i4)));
                            }
                        }
                    }
                } catch (JSONException e2) {
                    C4990ab.m7412e("MicroMsg.NetSceneGetUserAutoFillInfo", "error parse this json");
                }
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(16726);
    }

    public final int getType() {
        return 1191;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(16727);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(16727);
        return a;
    }
}
