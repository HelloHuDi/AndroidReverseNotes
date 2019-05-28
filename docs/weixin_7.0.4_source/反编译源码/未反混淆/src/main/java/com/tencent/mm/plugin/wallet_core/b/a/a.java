package com.tencent.mm.plugin.wallet_core.b.a;

import com.facebook.appevents.UserDataStore;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.x;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends m {
    private Map<String, String> oYG = new HashMap();
    private Map<String, String> toe = new HashMap();
    public String token = null;
    public String tos = null;

    public a(Authen authen) {
        AppMethodBeat.i(46483);
        a(authen.pGr, this.oYG, this.toe);
        this.oYG.put("flag", authen.bJt);
        this.oYG.put("bank_type", authen.pbn);
        this.oYG.put("mobile_area", authen.twt);
        if (!bo.isNullOrNil(authen.twc)) {
            this.oYG.put("passwd", authen.twc);
        }
        if (!bo.isNullOrNil(authen.token)) {
            this.oYG.put("token", authen.token);
        }
        if (!bo.isNullOrNil(authen.tlk)) {
            g.RQ();
            p pVar = new p(bo.a((Integer) g.RP().Ry().get(9, null), 0));
            this.oYG.put("import_code", authen.tlk);
            this.oYG.put("qqid", pVar.toString());
            if (authen.twf > 0) {
                this.oYG.put("cre_type", authen.twf);
            }
            this.oYG.put("bind_serailno", authen.pbo);
        }
        if (!bo.isNullOrNil(authen.twl)) {
            this.oYG.put("first_name", authen.twl);
            this.oYG.put("last_name", authen.twm);
            this.oYG.put(UserDataStore.COUNTRY, authen.country);
            this.oYG.put("area", authen.duc);
            this.oYG.put("city", authen.dud);
            this.oYG.put("address", authen.fBg);
            this.oYG.put("phone_number", authen.nuN);
            this.oYG.put("zip_code", authen.gIO);
            this.oYG.put(Scopes.EMAIL, authen.dtV);
            this.oYG.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, aa.dor());
        }
        if (!bo.isNullOrNil(authen.twd)) {
            this.oYG.put("true_name", authen.twd);
        }
        if (!bo.isNullOrNil(authen.twe)) {
            this.oYG.put("identify_card", authen.twe);
        }
        if (authen.twf > 0) {
            this.oYG.put("cre_type", authen.twf);
        }
        if (!bo.isNullOrNil(authen.tuk)) {
            this.oYG.put("mobile_no", authen.tuk);
        }
        this.oYG.put("bank_card_id", authen.twg);
        if (!bo.isNullOrNil(authen.twh)) {
            this.oYG.put("cvv2", authen.twh);
        }
        if (!bo.isNullOrNil(authen.twi)) {
            this.oYG.put("valid_thru", authen.twi);
        }
        if (authen.bJt == 1 || authen.bJt == 2) {
            this.oYG.put("creid_renewal", String.valueOf(authen.twu));
            this.oYG.put("birth_date", authen.twv);
            this.oYG.put("cre_expire_date", authen.tww);
        }
        if (x.dNS()) {
            this.toe.put("uuid_for_bindcard", x.dNU());
            this.toe.put("bindcard_scene", x.dNT());
        }
        M(this.oYG);
        ba(this.toe);
        AppMethodBeat.o(46483);
    }

    public final boolean bXl() {
        AppMethodBeat.i(46484);
        super.bXl();
        this.oYG.put("is_repeat_send", "1");
        M(this.oYG);
        AppMethodBeat.o(46484);
        return true;
    }

    public final int bgI() {
        return 12;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(46485);
        if (jSONObject != null) {
            this.tos = jSONObject.optString("req_key");
            this.token = jSONObject.optString("token");
        }
        AppMethodBeat.o(46485);
    }

    public final String getToken() {
        return this.token;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/bindauthen";
    }

    public final int ZU() {
        return 471;
    }
}
