package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class g extends p {
    public boolean AgA = false;
    protected JSONObject Agx;
    public boolean Agy = false;
    public int Agz = 0;

    public g(Map<String, String> map) {
        AppMethodBeat.i(49173);
        ab.i("MicroMsg.NetSceneDelayQueryOrder", "NetSceneDelayQueryOrder call");
        M(map);
        AppMethodBeat.o(49173);
    }

    public final void K(boolean z, int i) {
        AppMethodBeat.i(49174);
        HashMap hashMap = new HashMap();
        hashMap.put("is_last_query", (z ? 1 : 0));
        hashMap.put("curr_query_count", String.valueOf(i));
        aZ(hashMap);
        AppMethodBeat.o(49174);
    }

    public final int bgI() {
        return 1525;
    }

    public String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/payorderquery";
    }

    public int ZU() {
        return 1525;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(49175);
        super.a(i, str, jSONObject);
        if (ae.gju) {
            try {
                jSONObject = new JSONObject("{\"retcode\":268447844,\"retmsg\":\"系统麻烦请稍后再试\",\"can_pay_retry\":1,\"show_retmsg_type\":1}");
            } catch (Exception e) {
            }
        }
        ab.i("MicroMsg.NetSceneDelayQueryOrder", "errCode = " + i + "errMsg=" + str);
        this.Agx = jSONObject;
        if (jSONObject != null) {
            boolean z;
            ab.d("MicroMsg.NetSceneDelayQueryOrder", "ret json: %s", jSONObject.toString());
            if (jSONObject.optInt("can_pay_retry") == 1) {
                z = true;
            } else {
                z = false;
            }
            this.Agy = z;
            this.Agz = jSONObject.optInt("show_retmsg_type");
        }
        AppMethodBeat.o(49175);
    }

    public final JSONObject dOp() {
        return this.Agx;
    }
}
