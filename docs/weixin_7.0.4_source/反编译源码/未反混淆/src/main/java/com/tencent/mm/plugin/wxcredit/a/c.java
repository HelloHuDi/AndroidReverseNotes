package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class c extends m {
    public double uYv = 0.0d;

    public c(List<l> list, String str) {
        AppMethodBeat.i(48657);
        HashMap hashMap = new HashMap();
        hashMap.put("session_key", str);
        int i = 0;
        Iterator it = list.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                l lVar = (l) it.next();
                hashMap.put("qt_id_".concat(String.valueOf(i2)), lVar.id);
                hashMap.put("ans_cont_".concat(String.valueOf(i2)), lVar.nYb);
                hashMap.put("level_".concat(String.valueOf(i2)), lVar.level);
                hashMap.put("parent_id_".concat(String.valueOf(i2)), lVar.uYQ);
                i2++;
                if (lVar.uYS == null || !"Y".equals(lVar.nYb)) {
                    i = i2;
                } else {
                    hashMap.put("qt_id_".concat(String.valueOf(i2)), lVar.uYS.id);
                    hashMap.put("ans_cont_".concat(String.valueOf(i2)), lVar.uYS.nYb);
                    hashMap.put("level_".concat(String.valueOf(i2)), lVar.uYS.level);
                    hashMap.put("parent_id_".concat(String.valueOf(i2)), lVar.uYS.uYQ);
                    i = i2 + 1;
                }
            } else {
                hashMap.put("total_num", String.valueOf(i2));
                M(hashMap);
                AppMethodBeat.o(48657);
                return;
            }
        }
    }

    public final int bgI() {
        return 60;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(48658);
        ab.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            AppMethodBeat.o(48658);
            return;
        }
        try {
            this.uYv = ((double) jSONObject.getInt("credit_amount")) / 100.0d;
            AppMethodBeat.o(48658);
        } catch (Exception e) {
            ab.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", e, "", new Object[0]);
            AppMethodBeat.o(48658);
        }
    }
}
