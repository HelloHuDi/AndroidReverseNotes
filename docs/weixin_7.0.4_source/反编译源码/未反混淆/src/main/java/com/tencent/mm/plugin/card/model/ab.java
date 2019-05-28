package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.agn;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.nx;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class ab extends m implements k {
    private final b ehh;
    private f ehi;
    public String kdS;
    public int kee;
    public String kef;
    public int keg;
    public String keh;

    public ab(LinkedList<nx> linkedList, int i, String str, String str2, String str3, String str4, String str5, int i2) {
        AppMethodBeat.i(87898);
        a aVar = new a();
        aVar.fsJ = new agn();
        aVar.fsK = new ago();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardlistfromapp";
        this.ehh = aVar.acD();
        agn agn = (agn) this.ehh.fsG.fsP;
        agn.vBz = linkedList;
        agn.cME = i;
        agn.kKO = str;
        agn.sign = str2;
        agn.vBv = str3;
        agn.vBu = str4;
        agn.wni = str5;
        agn.vBw = i2;
        AppMethodBeat.o(87898);
    }

    public final int getType() {
        return 690;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(87899);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(87899);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(87900);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, errType = " + i2 + " errCode = " + i3 + " netType = 690");
        if (i2 == 0 && i3 == 0) {
            this.kdS = ((ago) this.ehh.fsH.fsP).kdS;
            if (TextUtils.isEmpty(this.kdS)) {
                com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetSceneGetCardListFromApp", "parseRespData json_ret is empty!");
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(this.kdS);
                    this.kee = jSONObject.optInt("accept_button_status", 0);
                    this.kef = jSONObject.optString("accept_button_wording");
                    this.keg = jSONObject.optInt("private_status", 0);
                    this.keh = jSONObject.optString("private_wording");
                } catch (JSONException e) {
                    com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.NetSceneGetCardListFromApp", e, "", new Object[0]);
                    com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetSceneGetCardListFromApp", "parseRespData:" + e.getMessage());
                }
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(87900);
    }
}
