package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class am extends ak {
    public String nSd;
    public String nWX;

    public am(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(42412);
        this.nWX = str3;
        this.nSd = str2;
        HashMap hashMap = new HashMap();
        hashMap.put("sendId", str);
        hashMap.put("receiveId", str3);
        hashMap.put("wishing", URLEncoder.encode(bo.nullAsNil(str2)));
        hashMap.put("ver", str4);
        M(hashMap);
        AppMethodBeat.o(42412);
    }

    public final int getType() {
        return 1682;
    }

    public final String bgF() {
        return "/cgi-bin/mmpay-bin/wishwxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }
}
