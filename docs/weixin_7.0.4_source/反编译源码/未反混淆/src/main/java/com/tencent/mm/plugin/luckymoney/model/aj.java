package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import org.json.JSONObject;

public final class aj extends ak {
    public aj(String str, String str2, int i, int i2, String str3) {
        AppMethodBeat.i(42407);
        HashMap hashMap = new HashMap();
        hashMap.put("sendId", String.valueOf(str));
        hashMap.put("offset", String.valueOf(i2));
        hashMap.put("type", String.valueOf(i));
        hashMap.put("receiveId", str2);
        hashMap.put("ver", str3);
        M(hashMap);
        AppMethodBeat.o(42407);
    }

    public final int getType() {
        return 1612;
    }

    public final String bgF() {
        return "/cgi-bin/mmpay-bin/deletelistwxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(42408);
        ab.i("NetSceneLuckyMoneyMyRecordDelete", "onGYNetEnd");
        AppMethodBeat.o(42408);
    }
}
