package com.tencent.p177mm.plugin.offline.p478a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.offline.p1006c.C28630a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.offline.a.o */
public final class C43354o extends C5749m {
    public C43354o(int i, int i2, int i3, String str) {
        this(i, i2, i3, 0, str);
    }

    public C43354o(int i, int i2, int i3) {
        this(i, i2, 0, i3, "");
    }

    private C43354o(int i, int i2, int i3, int i4, String str) {
        AppMethodBeat.m2504i(43413);
        HashMap hashMap = new HashMap();
        hashMap.put("residue_num", String.valueOf(i));
        hashMap.put("entry_scene", String.valueOf(i2));
        hashMap.put("is_snapshot", String.valueOf(i3));
        hashMap.put("user_view_digit", String.valueOf(i4));
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3537RQ();
        hashMap.put("code_ver", stringBuilder.append(C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_OFFLINE_CODE_VER_STRING, (Object) "")).toString());
        hashMap.put("card_id", C28630a.kaE);
        hashMap.put("user_card_id", C28630a.pbi);
        hashMap.put("card_code", C28630a.pbj);
        hashMap.put("ext_business_attach", str);
        mo70323M(hashMap);
        C4990ab.m7417i("MicroMsg.NetSceneTenpayWxOfflineShowCode", "hy: residue_num == %d, entryscene = %d,is_snapshot = %d, user_view_digit: %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        C4990ab.m7411d("MicroMsg.NetSceneTenpayWxOfflineShowCode", "card_id=%s,  user_card_id=%s,  card_code:%s ", C28630a.kaE, C28630a.pbi, C28630a.pbj);
        AppMethodBeat.m2505o(43413);
    }

    public final int bgI() {
        return 102;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(43414);
        C4990ab.m7417i("MicroMsg.NetSceneTenpayWxOfflineShowCode", "onGynetEnd %s %s", Integer.valueOf(i), str);
        AppMethodBeat.m2505o(43414);
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1645;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlineshowcode";
    }
}
