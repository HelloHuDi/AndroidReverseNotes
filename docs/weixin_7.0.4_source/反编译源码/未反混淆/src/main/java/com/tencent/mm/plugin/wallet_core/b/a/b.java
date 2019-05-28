package com.tencent.mm.plugin.wallet_core.b.a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTask;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.c.x;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends m implements i {
    public BindCardOrder ttK;

    public b(s sVar) {
        this(sVar, -1);
    }

    public b(s sVar, int i) {
        AppMethodBeat.i(46486);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap.put("flag", sVar.flag);
        hashMap.put("passwd", sVar.guu);
        hashMap.put("verify_code", sVar.tCi);
        hashMap.put("token", sVar.token);
        hashMap.put("bind_flag", sVar.tCj ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        if (i > 0) {
            hashMap.put("realname_scene", String.valueOf(i));
            ab.i("MicroMsg.NetSenceTenPayBase", "realname_scene=%d", Integer.valueOf(i));
        }
        if (!bo.isNullOrNil(sVar.pbn)) {
            hashMap.put("bank_type", sVar.pbn);
        }
        if (x.dNS()) {
            hashMap2.put("uuid_for_bindcard", x.dNU());
            hashMap2.put("bindcard_scene", x.dNT());
        }
        a(sVar.pGr, (Map) hashMap, (Map) hashMap2);
        M(hashMap);
        ba(hashMap2);
        AppMethodBeat.o(46486);
    }

    public final int bgI() {
        return 17;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(46487);
        this.ttK = new BindCardOrder();
        this.ttK.as(jSONObject);
        AppMethodBeat.o(46487);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/bindverifyreg";
    }

    public final int ZU() {
        return JsApiCancelDownloadTask.CTRL_INDEX;
    }
}
