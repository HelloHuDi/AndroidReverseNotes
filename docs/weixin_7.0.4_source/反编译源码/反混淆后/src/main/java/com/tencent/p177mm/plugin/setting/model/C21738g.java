package com.tencent.p177mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.apm;
import com.tencent.p177mm.protocal.protobuf.apn;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.setting.model.g */
public final class C21738g extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;

    public C21738g() {
        AppMethodBeat.m2504i(126851);
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
        AppMethodBeat.m2505o(126851);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(126852);
        C4990ab.m7410d("MicroMsg.NetSceneGetUserAutoFillInfo", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            C4990ab.m7416i("MicroMsg.NetSceneGetUserAutoFillInfo", "return is 0.now we parse the json and resetList..");
            apn apn = (apn) ((C7472b) c1929q).fsH.fsP;
            if (apn.wty != null) {
                try {
                    boolean z = new JSONObject(apn.wty).getBoolean("has_invoice_info");
                    C4990ab.m7416i("MicroMsg.NetSceneGetUserAutoFillInfo", "has_invoice_info is ..".concat(String.valueOf(z)));
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_ABOUT_INVOICE_ENTRANCE_BOOLEAN, Boolean.valueOf(z));
                } catch (JSONException e) {
                    C4990ab.m7412e("MicroMsg.NetSceneGetUserAutoFillInfo", "error parse this json");
                }
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(126852);
    }

    public final int getType() {
        return 1191;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(126853);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(126853);
        return a;
    }
}
