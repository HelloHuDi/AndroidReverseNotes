package com.tencent.p177mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C35941nx;
import com.tencent.p177mm.protocal.protobuf.agn;
import com.tencent.p177mm.protocal.protobuf.ago;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.card.model.ab */
public final class C27585ab extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    public String kdS;
    public int kee;
    public String kef;
    public int keg;
    public String keh;

    public C27585ab(LinkedList<C35941nx> linkedList, int i, String str, String str2, String str3, String str4, String str5, int i2) {
        AppMethodBeat.m2504i(87898);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new agn();
        c1196a.fsK = new ago();
        c1196a.uri = "/cgi-bin/micromsg-bin/getcardlistfromapp";
        this.ehh = c1196a.acD();
        agn agn = (agn) this.ehh.fsG.fsP;
        agn.vBz = linkedList;
        agn.cME = i;
        agn.kKO = str;
        agn.sign = str2;
        agn.vBv = str3;
        agn.vBu = str4;
        agn.wni = str5;
        agn.vBw = i2;
        AppMethodBeat.m2505o(87898);
    }

    public final int getType() {
        return 690;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(87899);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(87899);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(87900);
        C4990ab.m7416i("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, errType = " + i2 + " errCode = " + i3 + " netType = 690");
        if (i2 == 0 && i3 == 0) {
            this.kdS = ((ago) this.ehh.fsH.fsP).kdS;
            if (TextUtils.isEmpty(this.kdS)) {
                C4990ab.m7412e("MicroMsg.NetSceneGetCardListFromApp", "parseRespData json_ret is empty!");
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(this.kdS);
                    this.kee = jSONObject.optInt("accept_button_status", 0);
                    this.kef = jSONObject.optString("accept_button_wording");
                    this.keg = jSONObject.optInt("private_status", 0);
                    this.keh = jSONObject.optString("private_wording");
                } catch (JSONException e) {
                    C4990ab.printErrStackTrace("MicroMsg.NetSceneGetCardListFromApp", e, "", new Object[0]);
                    C4990ab.m7412e("MicroMsg.NetSceneGetCardListFromApp", "parseRespData:" + e.getMessage());
                }
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(87900);
    }
}
