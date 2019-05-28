package com.tencent.p177mm.plugin.card.sharecard.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.ban;
import com.tencent.p177mm.protocal.protobuf.bao;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.card.sharecard.model.f */
public final class C42857f extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    public String kbH;
    public int kbI = 0;
    public String kbJ;
    public int kbK;
    public String kbL;
    public String kfB;

    public C42857f(String str, int i, int i2, int i3) {
        AppMethodBeat.m2504i(88030);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ban();
        c1196a.fsK = new bao();
        c1196a.uri = "/cgi-bin/micromsg-bin/marksharecard";
        c1196a.fsI = 907;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        ban ban = (ban) this.ehh.fsG.fsP;
        ban.cMC = str;
        ban.wEk = i2;
        ban.wEj = i;
        ban.scene = i3;
        this.kfB = str;
        AppMethodBeat.m2505o(88030);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(88031);
        C4990ab.m7417i("MicroMsg.NetSceneMarkShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", Integer.valueOf(907), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            bao bao = (bao) this.ehh.fsH.fsP;
            C4990ab.m7416i("MicroMsg.NetSceneMarkShareCard", "json_ret:" + bao.kdS);
            String str2 = bao.kdS;
            if (TextUtils.isEmpty(str2)) {
                C4990ab.m7412e("MicroMsg.NetSceneMarkShareCard", "parseJson json_ret is empty!");
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    this.kbH = jSONObject.optString("mark_user");
                    this.kbI = jSONObject.optInt("mark_succ", 0);
                    this.kbJ = jSONObject.optString("mark_card_id");
                    this.kbK = jSONObject.optInt("expire_time", 0);
                    this.kbL = jSONObject.optString("pay_qrcode_wording");
                } catch (JSONException e) {
                    C4990ab.printErrStackTrace("MicroMsg.NetSceneMarkShareCard", e, "", new Object[0]);
                }
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(88031);
    }

    public final int getType() {
        return 907;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(88032);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(88032);
        return a;
    }
}
