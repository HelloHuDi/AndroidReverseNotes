package com.tencent.p177mm.plugin.offline.p478a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C24144d;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.offline.a.f */
public final class C46116f extends C5749m {
    private boolean cNi = true;

    public C46116f(String str, String str2) {
        AppMethodBeat.m2504i(43393);
        HashMap hashMap = new HashMap();
        hashMap.put("code_ver", str);
        hashMap.put("cn", str2);
        C4990ab.m7417i("MicroMsg.NetSceneOfflineVerifyToken", "reqtoken ver %s cn: %s", str, str2);
        mo70323M(hashMap);
        AppMethodBeat.m2505o(43393);
    }

    public final int bgI() {
        return 1686;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlineverifytoken";
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1686;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(43394);
        C4990ab.m7417i("MicroMsg.NetSceneOfflineVerifyToken", "respone %d errMsg: %s", Integer.valueOf(i), str);
        if (i == 0) {
            C4990ab.m7416i("MicroMsg.NetSceneOfflineVerifyToken", "NetSceneOfflineVerifyToken succ");
            C7060h.pYm.mo8378a(135, 22, 1, true);
            AppMethodBeat.m2505o(43394);
            return;
        }
        C4990ab.m7417i("MicroMsg.NetSceneOfflineVerifyToken", "NetSceneOfflineVerifyToken fail.errCode = %d ;errMsg = ", Integer.valueOf(i), str);
        C7060h.pYm.mo8378a(135, 23, 1, true);
        AppMethodBeat.m2505o(43394);
    }

    /* renamed from: a */
    public final void mo26460a(C24144d c24144d, JSONObject jSONObject) {
        AppMethodBeat.m2504i(43395);
        if (c24144d.Afo != 0 || c24144d.errType == 0) {
            this.cNi = true;
        } else {
            this.cNi = false;
        }
        C4990ab.m7417i("MicroMsg.NetSceneOfflineVerifyToken", "onGYNetEnd2 isBlock %s", Boolean.valueOf(this.cNi));
        AppMethodBeat.m2505o(43395);
    }

    public final boolean bXm() {
        return this.cNi;
    }
}
