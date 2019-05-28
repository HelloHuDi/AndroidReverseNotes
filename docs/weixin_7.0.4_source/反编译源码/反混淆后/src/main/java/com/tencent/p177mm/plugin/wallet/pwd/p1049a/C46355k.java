package com.tencent.p177mm.plugin.wallet.pwd.p1049a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C46720ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet.pwd.a.k */
public final class C46355k extends C5749m implements C1918k {
    public JSONObject tqH;

    public C46355k(boolean z, String str, String str2) {
        AppMethodBeat.m2504i(46189);
        HashMap hashMap = new HashMap();
        C4990ab.m7411d("MicroMsg.NetSceneTenpayQueryBasicSecurityInfo", "cpuId: %s, uid: %s", str, str2);
        hashMap.put("is_root", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put("is_device_open_touch", z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put("cpu_id", str);
        hashMap.put("app_uid", str2);
        mo70323M(hashMap);
        AppMethodBeat.m2505o(46189);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(46190);
        this.ehi = c1202f;
        int a = super.mo4456a(c1902e, c1202f);
        AppMethodBeat.m2505o(46190);
        return a;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/paysecurity";
    }

    public final int bgI() {
        return 0;
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1669;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(46191);
        C4990ab.m7417i("MicroMsg.NetSceneTenpayQueryBasicSecurityInfo", "alvinluo errCode: %d, errMsg: %s", Integer.valueOf(i), str);
        if (i == 0 && jSONObject != null) {
            C4990ab.m7419v("MicroMsg.NetSceneTenpayQueryBasicSecurityInfo", "alvinluo json: %s", jSONObject.toString());
            this.tqH = jSONObject;
            C46720ab.dNZ().mo75126aT(this.tqH);
        }
        AppMethodBeat.m2505o(46191);
    }
}
