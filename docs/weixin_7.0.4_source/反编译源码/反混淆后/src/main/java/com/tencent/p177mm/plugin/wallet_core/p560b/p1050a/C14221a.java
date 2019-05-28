package com.tencent.p177mm.plugin.wallet_core.p560b.p1050a;

import com.facebook.appevents.UserDataStore;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.plugin.wallet_core.model.Authen;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C36379x;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.b.a.a */
public final class C14221a extends C5749m {
    private Map<String, String> oYG = new HashMap();
    private Map<String, String> toe = new HashMap();
    public String token = null;
    public String tos = null;

    public C14221a(Authen authen) {
        AppMethodBeat.m2504i(46483);
        mo70324a(authen.pGr, this.oYG, this.toe);
        this.oYG.put("flag", authen.bJt);
        this.oYG.put("bank_type", authen.pbn);
        this.oYG.put("mobile_area", authen.twt);
        if (!C5046bo.isNullOrNil(authen.twc)) {
            this.oYG.put("passwd", authen.twc);
        }
        if (!C5046bo.isNullOrNil(authen.token)) {
            this.oYG.put("token", authen.token);
        }
        if (!C5046bo.isNullOrNil(authen.tlk)) {
            C1720g.m3537RQ();
            C1183p c1183p = new C1183p(C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(9, null), 0));
            this.oYG.put("import_code", authen.tlk);
            this.oYG.put("qqid", c1183p.toString());
            if (authen.twf > 0) {
                this.oYG.put("cre_type", authen.twf);
            }
            this.oYG.put("bind_serailno", authen.pbo);
        }
        if (!C5046bo.isNullOrNil(authen.twl)) {
            this.oYG.put("first_name", authen.twl);
            this.oYG.put("last_name", authen.twm);
            this.oYG.put(UserDataStore.COUNTRY, authen.country);
            this.oYG.put("area", authen.duc);
            this.oYG.put("city", authen.dud);
            this.oYG.put("address", authen.fBg);
            this.oYG.put("phone_number", authen.nuN);
            this.oYG.put("zip_code", authen.gIO);
            this.oYG.put(Scopes.EMAIL, authen.dtV);
            this.oYG.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, C4988aa.dor());
        }
        if (!C5046bo.isNullOrNil(authen.twd)) {
            this.oYG.put("true_name", authen.twd);
        }
        if (!C5046bo.isNullOrNil(authen.twe)) {
            this.oYG.put("identify_card", authen.twe);
        }
        if (authen.twf > 0) {
            this.oYG.put("cre_type", authen.twf);
        }
        if (!C5046bo.isNullOrNil(authen.tuk)) {
            this.oYG.put("mobile_no", authen.tuk);
        }
        this.oYG.put("bank_card_id", authen.twg);
        if (!C5046bo.isNullOrNil(authen.twh)) {
            this.oYG.put("cvv2", authen.twh);
        }
        if (!C5046bo.isNullOrNil(authen.twi)) {
            this.oYG.put("valid_thru", authen.twi);
        }
        if (authen.bJt == 1 || authen.bJt == 2) {
            this.oYG.put("creid_renewal", String.valueOf(authen.twu));
            this.oYG.put("birth_date", authen.twv);
            this.oYG.put("cre_expire_date", authen.tww);
        }
        if (C36379x.dNS()) {
            this.toe.put("uuid_for_bindcard", C36379x.dNU());
            this.toe.put("bindcard_scene", C36379x.dNT());
        }
        mo70323M(this.oYG);
        mo70328ba(this.toe);
        AppMethodBeat.m2505o(46483);
    }

    public final boolean bXl() {
        AppMethodBeat.m2504i(46484);
        super.bXl();
        this.oYG.put("is_repeat_send", "1");
        mo70323M(this.oYG);
        AppMethodBeat.m2505o(46484);
        return true;
    }

    public final int bgI() {
        return 12;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(46485);
        if (jSONObject != null) {
            this.tos = jSONObject.optString("req_key");
            this.token = jSONObject.optString("token");
        }
        AppMethodBeat.m2505o(46485);
    }

    public final String getToken() {
        return this.token;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/bindauthen";
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 471;
    }
}
