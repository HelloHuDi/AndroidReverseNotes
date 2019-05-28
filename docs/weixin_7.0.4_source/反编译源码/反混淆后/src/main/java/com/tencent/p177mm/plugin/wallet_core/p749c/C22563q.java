package com.tencent.p177mm.plugin.wallet_core.p749c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.p313p.C10503e;
import com.tencent.p177mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.p177mm.plugin.wallet_core.model.C14264s;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C36379x;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.c.q */
public final class C22563q extends C5749m {
    public BindCardOrder ttK;

    public C22563q(C14264s c14264s) {
        this(c14264s, -1);
    }

    public C22563q(C14264s c14264s, int i) {
        AppMethodBeat.m2504i(46530);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        mo70324a(c14264s.pGr, (Map) hashMap, (Map) hashMap2);
        hashMap.put("flag", c14264s.flag);
        if ("2".equals(c14264s.flag)) {
            hashMap.put("passwd", c14264s.guu);
        }
        hashMap.put("verify_code", c14264s.tCi);
        hashMap.put("token", c14264s.token);
        if (!(c14264s.pGr == null || C5046bo.isNullOrNil(c14264s.pGr.czZ))) {
            hashMap.put("req_key", c14264s.pGr.czZ);
        }
        if (i >= 0) {
            hashMap.put("realname_scene", String.valueOf(i));
            C4990ab.m7417i("MicroMsg.NetSenceTenPayBase", "realname_scene=%d", Integer.valueOf(i));
        }
        if (!C5046bo.isNullOrNil(c14264s.pbn)) {
            hashMap.put("bank_type", c14264s.pbn);
        }
        if (C36379x.dNS()) {
            hashMap2.put("uuid_for_bindcard", C36379x.dNU());
            hashMap2.put("bindcard_scene", C36379x.dNT());
        }
        mo70323M(hashMap);
        mo70328ba(hashMap2);
        AppMethodBeat.m2505o(46530);
    }

    public final int bgI() {
        return 13;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(46531);
        C4990ab.m7416i("test", "test");
        this.ttK = new BindCardOrder();
        this.ttK.mo63421as(jSONObject);
        AppMethodBeat.m2505o(46531);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/bindverify";
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return C10503e.CTRL_INDEX;
    }
}
