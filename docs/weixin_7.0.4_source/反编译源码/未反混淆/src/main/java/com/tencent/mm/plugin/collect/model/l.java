package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bbc;
import com.tencent.mm.protocal.protobuf.ox;
import com.tencent.mm.protocal.protobuf.oy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class l extends m implements k {
    private final String TAG = "MicroMsg.NetSceneF2fQrcode";
    private b ehh;
    private f ehi;
    public oy kCk;

    public l() {
        AppMethodBeat.i(40975);
        a aVar = new a();
        aVar.fsJ = new ox();
        aVar.fsK = new oy();
        aVar.fsI = 1588;
        aVar.uri = "/cgi-bin/mmpay-bin/f2fqrcode";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        AppMethodBeat.o(40975);
    }

    public final int getType() {
        return 1588;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(40976);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(40976);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(40977);
        this.kCk = (oy) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneF2fQrcode", "errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        ab.d("MicroMsg.NetSceneF2fQrcode", "payurl: %s, true_name: %s, bottom_icon_url: %s", this.kCk.url, this.kCk.twd, this.kCk.vWa);
        if (!bo.isNullOrNil(this.kCk.url)) {
            g.RQ();
            g.RP().Ry().set(ac.a.USERINFO_WALLET_F2F_COLLECT_PAY_URL_STRING_SYNC, this.kCk.url);
        }
        if (!bo.isNullOrNil(this.kCk.twd)) {
            g.RQ();
            g.RP().Ry().set(ac.a.USERINFO_WALLET_F2F_COLLECT_TRUE_NAME_STRING_SYNC, this.kCk.twd);
        }
        g.RQ();
        g.RP().Ry().set(ac.a.USERINFO_WALLET_F2F_COLLECT_BOTTOM_LEFT_ICON_URL_STRING_SYNC, this.kCk.vWa);
        JSONObject a = a(this.kCk.vVZ);
        JSONArray bo = bo(this.kCk.vVY);
        if (a != null) {
            ab.d("MicroMsg.NetSceneF2fQrcode", "bottom: %s", a.toString());
            g.RQ();
            g.RP().Ry().set(ac.a.USERINFO_WALLET_F2F_COLLECT_BOTTOM_MENU_STRING_SYNC, a.toString());
        }
        if (bo != null) {
            ab.d("MicroMsg.NetSceneF2fQrcode", "upright: %s", bo.toString());
            g.RQ();
            g.RP().Ry().set(ac.a.USERINFO_WALLET_F2F_COLLECT_UPRIGHT_MENU_STRING_SYNC, bo.toString());
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(40977);
    }

    private static JSONArray bo(List<bbc> list) {
        AppMethodBeat.i(40978);
        JSONArray jSONArray = new JSONArray();
        if (list == null || list.size() == 0) {
            ab.w("MicroMsg.NetSceneF2fQrcode", "empty menu items");
            AppMethodBeat.o(40978);
            return null;
        }
        int i = 0;
        while (i < list.size()) {
            try {
                JSONObject a = a((bbc) list.get(i));
                if (a != null) {
                    jSONArray.put(i, a);
                }
                i++;
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.NetSceneF2fQrcode", e, "", new Object[0]);
                AppMethodBeat.o(40978);
                return null;
            }
        }
        AppMethodBeat.o(40978);
        return jSONArray;
    }

    private static JSONObject a(bbc bbc) {
        int i;
        AppMethodBeat.i(40979);
        if (bbc == null || bo.isNullOrNil(bbc.cEh)) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            ab.w("MicroMsg.NetSceneF2fQrcode", "empty menu item");
            AppMethodBeat.o(40979);
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", bbc.type);
            jSONObject.put("wording", bbc.cEh);
            jSONObject.put("url", bbc.url);
            jSONObject.put("waapp_username", bbc.wFS);
            jSONObject.put("waapp_path", bbc.wFT);
            AppMethodBeat.o(40979);
            return jSONObject;
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.NetSceneF2fQrcode", e, "", new Object[0]);
            AppMethodBeat.o(40979);
            return null;
        }
    }
}
