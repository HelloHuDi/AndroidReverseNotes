package com.tencent.p177mm.plugin.wallet_core.p560b.p1050a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTask;
import com.tencent.p177mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.p177mm.plugin.wallet_core.model.C14264s;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C36379x;
import com.tencent.p177mm.wallet_core.p649c.C44426i;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.b.a.b */
public final class C29614b extends C5749m implements C44426i {
    public BindCardOrder ttK;

    public C29614b(C14264s c14264s) {
        this(c14264s, -1);
    }

    public C29614b(C14264s c14264s, int i) {
        AppMethodBeat.m2504i(46486);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap.put("flag", c14264s.flag);
        hashMap.put("passwd", c14264s.guu);
        hashMap.put("verify_code", c14264s.tCi);
        hashMap.put("token", c14264s.token);
        hashMap.put("bind_flag", c14264s.tCj ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        if (i > 0) {
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
        mo70324a(c14264s.pGr, (Map) hashMap, (Map) hashMap2);
        mo70323M(hashMap);
        mo70328ba(hashMap2);
        AppMethodBeat.m2505o(46486);
    }

    public final int bgI() {
        return 17;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(46487);
        this.ttK = new BindCardOrder();
        this.ttK.mo63421as(jSONObject);
        AppMethodBeat.m2505o(46487);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/bindverifyreg";
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return JsApiCancelDownloadTask.CTRL_INDEX;
    }
}
