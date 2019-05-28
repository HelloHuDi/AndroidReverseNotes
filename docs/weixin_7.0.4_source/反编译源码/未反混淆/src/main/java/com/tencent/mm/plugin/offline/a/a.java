package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.alb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.wallet_core.c.u;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends u {
    private final b ehh;
    private f ehi;
    private ArrayList<String> hUW;
    private String oXT;
    private String oXU;

    public final int getType() {
        return 606;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(43381);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(43381);
        return a;
    }

    public final void e(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(43382);
        if (i != 0) {
            ab.e("MicroMsg.NetSceneGetOffLineInfo", "Cmd : 606, errType = " + i + ", errCode = " + i2 + ", errMsg = " + str);
        }
        alb alb = (alb) ((b) qVar).fsH.fsP;
        if (i == 0 && i2 == 0) {
            try {
                if (!TextUtils.isEmpty(alb.wqA)) {
                    JSONObject jSONObject = new JSONObject(alb.wqA);
                    int optInt = jSONObject.optInt("InitValue");
                    int optInt2 = jSONObject.optInt("FastChangedLimit");
                    this.oXU = jSONObject.optString("guide_tips");
                    com.tencent.mm.plugin.offline.c.a.AB(optInt);
                    com.tencent.mm.plugin.offline.c.a.AC(optInt2);
                    ab.v("MicroMsg.NetSceneGetOffLineInfo", "initValue:" + optInt + " fastChangeValue:" + optInt2);
                }
                if (!TextUtils.isEmpty(alb.wqB)) {
                    aa(new JSONObject(alb.wqB));
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.NetSceneGetOffLineInfo", e, "", new Object[0]);
                i = 1000;
                i2 = 2;
                str = ah.getContext().getString(R.string.fdx);
            }
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(43382);
    }

    private void aa(JSONObject jSONObject) {
        AppMethodBeat.i(43383);
        this.oXT = jSONObject.optString("micropay_tips");
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("head_url_list");
            if (jSONArray == null || jSONArray.length() == 0) {
                AppMethodBeat.o(43383);
                return;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                this.hUW.add((String) jSONArray.get(i));
            }
            AppMethodBeat.o(43383);
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.NetSceneGetOffLineInfo", e, "", new Object[0]);
            AppMethodBeat.o(43383);
        }
    }
}
