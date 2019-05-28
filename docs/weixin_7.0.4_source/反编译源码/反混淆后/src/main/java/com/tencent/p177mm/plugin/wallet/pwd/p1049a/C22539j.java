package com.tencent.p177mm.plugin.wallet.pwd.p1049a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C43799ad;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet.pwd.a.j */
public final class C22539j extends C5749m {
    public int tqB;
    public String tqC;
    public int tqD;
    public String tqE;
    public String tqF;
    public String tqG;

    public C22539j() {
        AppMethodBeat.m2504i(46184);
        HashMap hashMap = new HashMap();
        hashMap.put("deviceid", C1427q.getDeviceID(C4996ah.getContext()));
        mo70323M(hashMap);
        AppMethodBeat.m2505o(46184);
    }

    public final int bgI() {
        return 0;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(46185);
        C4990ab.m7416i("MicroMsg.NetSceneTenpayPayManager", "errCode:" + i + ";errMsg:" + str);
        C4990ab.m7411d("MicroMsg.NetSceneTenpayPayManager", "json: %s", jSONObject.toString());
        if (i == 0) {
            String optString = jSONObject.optString("is_show_deduct", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            if (!C22539j.isNumeric(optString)) {
                optString = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            this.tqB = Integer.valueOf(optString).intValue();
            this.tqC = jSONObject.optString("deduct_show_url", "");
            optString = jSONObject.optString("deduct_cache_time", "");
            if (!C22539j.isNumeric(optString)) {
                optString = "84600";
            }
            this.tqD = Integer.valueOf(optString).intValue();
            this.tqE = jSONObject.optString("deduct_title", "");
            this.tqF = jSONObject.optString("realname_url", "");
            this.tqG = jSONObject.optString("forget_pwd_url", "");
            Object optString2 = jSONObject.optString("payway_select_wording", "");
            Object optString3 = jSONObject.optString("payway_change_wording", "");
            C43799ad c43799ad = new C43799ad();
            c43799ad.field_is_show = this.tqB;
            c43799ad.field_pref_key = "wallet_open_auto_pay";
            c43799ad.field_pref_title = this.tqE;
            c43799ad.field_pref_url = this.tqC;
            C14241r.cPH().acP("wallet_open_auto_pay");
            C4990ab.m7417i("MicroMsg.NetSceneTenpayPayManager", "deductCacheTime %s forget_pwd_url %s", Integer.valueOf(this.tqD), this.tqG);
            C14241r.cPH().mo10101b((C4925c) c43799ad);
            JSONObject optJSONObject = jSONObject.optJSONObject("switch_wallet");
            if (optJSONObject != null) {
                c43799ad = C22539j.m34233k(optJSONObject, "wallet_switch_currency");
                C14241r.cPH().acP("wallet_switch_currency");
                C14241r.cPH().mo10101b((C4925c) c43799ad);
            }
            optJSONObject = jSONObject.optJSONObject("im_mch");
            if (optJSONObject != null) {
                c43799ad = C22539j.m34233k(optJSONObject, "wallet_im_mch");
                C14241r.cPH().acP("wallet_im_mch");
                C14241r.cPH().mo10101b((C4925c) c43799ad);
            }
            optJSONObject = jSONObject.optJSONObject("unreg_info");
            if (optJSONObject != null) {
                Object optString4 = optJSONObject.optString("unreg_title", "");
                Object optString5 = optJSONObject.optString("unreg_url", "");
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_USERINFO_UNREGTITLE_TYPE_STRING_SYNC, optString4);
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_USERINFO_UNREGURL_TYPE_STRING_SYNC, optString5);
            } else {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_USERINFO_UNREGTITLE_TYPE_STRING_SYNC, (Object) "");
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_USERINFO_UNREGURL_TYPE_STRING_SYNC, (Object) "");
            }
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_PREF_INFO_CACHE_TIME_LONG_SYNC, Long.valueOf(new Date().getTime() / 1000));
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_PREF_INFO_EXPIRES_INT_SYNC, Integer.valueOf(this.tqD));
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_REALNAME_URL_STRING_SYNC, this.tqF);
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_DEDUCT_FORGET_URL_STRING, this.tqG);
            if (!C5046bo.isNullOrNil(optString2)) {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_DEDUCT_SELECT_WORDING_STRING, optString2);
            }
            if (!C5046bo.isNullOrNil(optString3)) {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_DEDUCT_CHANGE_WORDING_STRING, optString3);
            }
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().dsb();
        }
        AppMethodBeat.m2505o(46185);
    }

    /* renamed from: k */
    private static C43799ad m34233k(JSONObject jSONObject, String str) {
        AppMethodBeat.m2504i(46186);
        C43799ad c43799ad = new C43799ad();
        c43799ad.field_is_show = jSONObject.optInt("show_label", 0);
        c43799ad.field_pref_key = str;
        c43799ad.field_pref_title = jSONObject.optString("title");
        c43799ad.field_pref_desc = jSONObject.optString("desc");
        c43799ad.field_logo_url = jSONObject.optString("logo_url");
        c43799ad.field_jump_type = jSONObject.optInt("jump_type");
        c43799ad.field_pref_url = jSONObject.optString("jump_h5_url");
        c43799ad.field_tinyapp_username = jSONObject.optString("tinyapp_username");
        c43799ad.field_tinyapp_path = jSONObject.optString("tinyapp_path");
        AppMethodBeat.m2505o(46186);
        return c43799ad;
    }

    public static boolean bxX() {
        AppMethodBeat.m2504i(46187);
        C1720g.m3537RQ();
        long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_PREF_INFO_CACHE_TIME_LONG_SYNC, Long.valueOf(0))).longValue();
        C1720g.m3537RQ();
        C4990ab.m7417i("MicroMsg.NetSceneTenpayPayManager", "check isExpire %s %s %s", Long.valueOf(longValue), Integer.valueOf(r0), Long.valueOf(((long) ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_PREF_INFO_EXPIRES_INT_SYNC, Integer.valueOf(0))).intValue()) + longValue));
        if (longValue <= 0) {
            AppMethodBeat.m2505o(46187);
            return true;
        } else if (new Date().getTime() / 1000 > longValue + ((long) r0)) {
            AppMethodBeat.m2505o(46187);
            return true;
        } else {
            AppMethodBeat.m2505o(46187);
            return false;
        }
    }

    private static boolean isNumeric(String str) {
        AppMethodBeat.m2504i(46188);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(46188);
            return false;
        }
        int length = str.length();
        char charAt;
        do {
            length--;
            if (length >= 0) {
                charAt = str.charAt(length);
                if (charAt < '0') {
                    break;
                }
            } else {
                AppMethodBeat.m2505o(46188);
                return true;
            }
        } while (charAt <= '9');
        AppMethodBeat.m2505o(46188);
        return false;
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1654;
    }

    public final int cOo() {
        return 100000;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/paymanage";
    }
}
