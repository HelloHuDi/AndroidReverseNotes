package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class o extends m {
    public o(int i, int i2, int i3, String str) {
        this(i, i2, i3, 0, str);
    }

    public o(int i, int i2, int i3) {
        this(i, i2, 0, i3, "");
    }

    private o(int i, int i2, int i3, int i4, String str) {
        AppMethodBeat.i(43413);
        HashMap hashMap = new HashMap();
        hashMap.put("residue_num", String.valueOf(i));
        hashMap.put("entry_scene", String.valueOf(i2));
        hashMap.put("is_snapshot", String.valueOf(i3));
        hashMap.put("user_view_digit", String.valueOf(i4));
        StringBuilder stringBuilder = new StringBuilder();
        g.RQ();
        hashMap.put("code_ver", stringBuilder.append(g.RP().Ry().get(a.USERINFO_WALLET_OFFLINE_CODE_VER_STRING, (Object) "")).toString());
        hashMap.put("card_id", com.tencent.mm.plugin.offline.c.a.kaE);
        hashMap.put("user_card_id", com.tencent.mm.plugin.offline.c.a.pbi);
        hashMap.put("card_code", com.tencent.mm.plugin.offline.c.a.pbj);
        hashMap.put("ext_business_attach", str);
        M(hashMap);
        ab.i("MicroMsg.NetSceneTenpayWxOfflineShowCode", "hy: residue_num == %d, entryscene = %d,is_snapshot = %d, user_view_digit: %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        ab.d("MicroMsg.NetSceneTenpayWxOfflineShowCode", "card_id=%s,  user_card_id=%s,  card_code:%s ", com.tencent.mm.plugin.offline.c.a.kaE, com.tencent.mm.plugin.offline.c.a.pbi, com.tencent.mm.plugin.offline.c.a.pbj);
        AppMethodBeat.o(43413);
    }

    public final int bgI() {
        return 102;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(43414);
        ab.i("MicroMsg.NetSceneTenpayWxOfflineShowCode", "onGynetEnd %s %s", Integer.valueOf(i), str);
        AppMethodBeat.o(43414);
    }

    public final int ZU() {
        return 1645;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlineshowcode";
    }
}
