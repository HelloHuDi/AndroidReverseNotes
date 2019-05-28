package com.tencent.p177mm.plugin.wxcredit.p1334a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wxcredit.a.c */
public final class C46477c extends C5749m {
    public double uYv = 0.0d;

    public C46477c(List<C44027l> list, String str) {
        AppMethodBeat.m2504i(48657);
        HashMap hashMap = new HashMap();
        hashMap.put("session_key", str);
        int i = 0;
        Iterator it = list.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                C44027l c44027l = (C44027l) it.next();
                hashMap.put("qt_id_".concat(String.valueOf(i2)), c44027l.f17236id);
                hashMap.put("ans_cont_".concat(String.valueOf(i2)), c44027l.nYb);
                hashMap.put("level_".concat(String.valueOf(i2)), c44027l.level);
                hashMap.put("parent_id_".concat(String.valueOf(i2)), c44027l.uYQ);
                i2++;
                if (c44027l.uYS == null || !"Y".equals(c44027l.nYb)) {
                    i = i2;
                } else {
                    hashMap.put("qt_id_".concat(String.valueOf(i2)), c44027l.uYS.f17236id);
                    hashMap.put("ans_cont_".concat(String.valueOf(i2)), c44027l.uYS.nYb);
                    hashMap.put("level_".concat(String.valueOf(i2)), c44027l.uYS.level);
                    hashMap.put("parent_id_".concat(String.valueOf(i2)), c44027l.uYS.uYQ);
                    i = i2 + 1;
                }
            } else {
                hashMap.put("total_num", String.valueOf(i2));
                mo70323M(hashMap);
                AppMethodBeat.m2505o(48657);
                return;
            }
        }
    }

    public final int bgI() {
        return 60;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(48658);
        C4990ab.m7410d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            AppMethodBeat.m2505o(48658);
            return;
        }
        try {
            this.uYv = ((double) jSONObject.getInt("credit_amount")) / 100.0d;
            AppMethodBeat.m2505o(48658);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", e, "", new Object[0]);
            AppMethodBeat.m2505o(48658);
        }
    }
}
