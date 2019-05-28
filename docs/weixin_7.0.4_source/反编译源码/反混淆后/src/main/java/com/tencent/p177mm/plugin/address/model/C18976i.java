package com.tencent.p177mm.plugin.address.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.p984j.p985a.C12328b;
import com.tencent.p177mm.protocal.protobuf.asa;
import com.tencent.p177mm.protocal.protobuf.bty;
import com.tencent.p177mm.protocal.protobuf.btz;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.address.model.i */
public final class C18976i extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    public btz gIL;

    public C18976i(C12328b c12328b) {
        AppMethodBeat.m2504i(16746);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bty();
        c1196a.fsK = new btz();
        c1196a.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/saveinfo";
        this.ehh = c1196a.acD();
        bty bty = (bty) this.ehh.fsG.fsP;
        bty.cvd = 2;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder("{\"user_uin\":");
        C9638aw.m17190ZK();
        stringBuilder.append(stringBuilder2.append(C18628c.m29064QF()).append(" ,\"user_data_list\": [").toString());
        if (c12328b.type.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            stringBuilder.append("{\"group_key\": \"invoice_info\",\"group_info\": {\"group_id\": " + c12328b.nuH + ",\"field_list\": [{\"key\": \"type\",\"value\": \"" + c12328b.type + "\"},{\"key\": \"title\",\"value\": \"" + c12328b.title + "\"},{\"key\": \"tax_number\",\"value\": \"" + c12328b.nuJ + "\"},{\"key\": \"bank_number\",\"value\": \"" + c12328b.nuK + "\"},{\"key\": \"phone\",\"value\": \"" + c12328b.nuN + "\"},{\"key\": \"company_address_detail\",\"value\": \"" + c12328b.nuP + "\"},{\"key\": \"bank_name\",\"value\": \"" + c12328b.nuL + "\"}]}}");
        } else {
            stringBuilder.append("{\"group_key\": \"invoice_info\",\"group_info\": {\"group_id\": " + c12328b.nuH + ",\"field_list\": [{\"key\": \"type\",\"value\": \"" + c12328b.type + "\"},{\"key\": \"title\",\"value\": \"" + c12328b.nuI + "\"},{\"key\": \"phone\",\"value\": \"" + c12328b.nuO + "\"},{\"key\": \"email\",\"value\": \"" + c12328b.dtV + "\"}]}}");
        }
        stringBuilder.append("]}");
        bty.wty = stringBuilder.toString();
        AppMethodBeat.m2505o(16746);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(16747);
        C4990ab.m7410d("MicroMsg.NetSceneSaveUserAutoFillInfo", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            this.gIL = (btz) ((C7472b) c1929q).fsH.fsP;
            if (!(this.gIL == null || this.gIL.wVS == null || this.gIL.wVS.size() <= 0 || this.gIL.wVS.get(0) == null)) {
                C4990ab.m7416i("MicroMsg.NetSceneSaveUserAutoFillInfo", "resp groupId is.." + ((asa) this.gIL.wVS.get(0)).wcR);
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(16747);
    }

    public final int getType() {
        return 1180;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(16748);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(16748);
        return a;
    }
}
