package com.tencent.mm.plugin.card.sharecard.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ban;
import com.tencent.mm.protocal.protobuf.bao;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

public final class f extends m implements k {
    private final b ehh;
    private com.tencent.mm.ai.f ehi;
    public String kbH;
    public int kbI = 0;
    public String kbJ;
    public int kbK;
    public String kbL;
    public String kfB;

    public f(String str, int i, int i2, int i3) {
        AppMethodBeat.i(88030);
        a aVar = new a();
        aVar.fsJ = new ban();
        aVar.fsK = new bao();
        aVar.uri = "/cgi-bin/micromsg-bin/marksharecard";
        aVar.fsI = 907;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ban ban = (ban) this.ehh.fsG.fsP;
        ban.cMC = str;
        ban.wEk = i2;
        ban.wEj = i;
        ban.scene = i3;
        this.kfB = str;
        AppMethodBeat.o(88030);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(88031);
        ab.i("MicroMsg.NetSceneMarkShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", Integer.valueOf(907), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            bao bao = (bao) this.ehh.fsH.fsP;
            ab.i("MicroMsg.NetSceneMarkShareCard", "json_ret:" + bao.kdS);
            String str2 = bao.kdS;
            if (TextUtils.isEmpty(str2)) {
                ab.e("MicroMsg.NetSceneMarkShareCard", "parseJson json_ret is empty!");
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    this.kbH = jSONObject.optString("mark_user");
                    this.kbI = jSONObject.optInt("mark_succ", 0);
                    this.kbJ = jSONObject.optString("mark_card_id");
                    this.kbK = jSONObject.optInt("expire_time", 0);
                    this.kbL = jSONObject.optString("pay_qrcode_wording");
                } catch (JSONException e) {
                    ab.printErrStackTrace("MicroMsg.NetSceneMarkShareCard", e, "", new Object[0]);
                }
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(88031);
    }

    public final int getType() {
        return 907;
    }

    public final int a(e eVar, com.tencent.mm.ai.f fVar) {
        AppMethodBeat.i(88032);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(88032);
        return a;
    }
}
