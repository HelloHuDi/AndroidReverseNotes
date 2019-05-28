package com.tencent.p177mm.wallet_core.tenpay.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.wallet_core.tenpay.model.g */
public class C36384g extends C46723p {
    public boolean AgA = false;
    protected JSONObject Agx;
    public boolean Agy = false;
    public int Agz = 0;

    public C36384g(Map<String, String> map) {
        AppMethodBeat.m2504i(49173);
        C4990ab.m7416i("MicroMsg.NetSceneDelayQueryOrder", "NetSceneDelayQueryOrder call");
        mo70323M(map);
        AppMethodBeat.m2505o(49173);
    }

    /* renamed from: K */
    public final void mo57302K(boolean z, int i) {
        AppMethodBeat.m2504i(49174);
        HashMap hashMap = new HashMap();
        hashMap.put("is_last_query", (z ? 1 : 0));
        hashMap.put("curr_query_count", String.valueOf(i));
        mo70326aZ(hashMap);
        AppMethodBeat.m2505o(49174);
    }

    public final int bgI() {
        return 1525;
    }

    public String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/payorderquery";
    }

    /* renamed from: ZU */
    public int mo9382ZU() {
        return 1525;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(49175);
        super.mo9383a(i, str, jSONObject);
        if (C1947ae.gju) {
            try {
                jSONObject = new JSONObject("{\"retcode\":268447844,\"retmsg\":\"系统麻烦请稍后再试\",\"can_pay_retry\":1,\"show_retmsg_type\":1}");
            } catch (Exception e) {
            }
        }
        C4990ab.m7416i("MicroMsg.NetSceneDelayQueryOrder", "errCode = " + i + "errMsg=" + str);
        this.Agx = jSONObject;
        if (jSONObject != null) {
            boolean z;
            C4990ab.m7411d("MicroMsg.NetSceneDelayQueryOrder", "ret json: %s", jSONObject.toString());
            if (jSONObject.optInt("can_pay_retry") == 1) {
                z = true;
            } else {
                z = false;
            }
            this.Agy = z;
            this.Agz = jSONObject.optInt("show_retmsg_type");
        }
        AppMethodBeat.m2505o(49175);
    }

    public final JSONObject dOp() {
        return this.Agx;
    }
}
