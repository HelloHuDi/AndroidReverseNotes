package com.tencent.mm.plugin.wallet.pwd.a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONObject;

public final class j extends m {
    public int tqB;
    public String tqC;
    public int tqD;
    public String tqE;
    public String tqF;
    public String tqG;

    public j() {
        AppMethodBeat.i(46184);
        HashMap hashMap = new HashMap();
        hashMap.put("deviceid", q.getDeviceID(ah.getContext()));
        M(hashMap);
        AppMethodBeat.o(46184);
    }

    public final int bgI() {
        return 0;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(46185);
        ab.i("MicroMsg.NetSceneTenpayPayManager", "errCode:" + i + ";errMsg:" + str);
        ab.d("MicroMsg.NetSceneTenpayPayManager", "json: %s", jSONObject.toString());
        if (i == 0) {
            String optString = jSONObject.optString("is_show_deduct", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            if (!isNumeric(optString)) {
                optString = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            this.tqB = Integer.valueOf(optString).intValue();
            this.tqC = jSONObject.optString("deduct_show_url", "");
            optString = jSONObject.optString("deduct_cache_time", "");
            if (!isNumeric(optString)) {
                optString = "84600";
            }
            this.tqD = Integer.valueOf(optString).intValue();
            this.tqE = jSONObject.optString("deduct_title", "");
            this.tqF = jSONObject.optString("realname_url", "");
            this.tqG = jSONObject.optString("forget_pwd_url", "");
            Object optString2 = jSONObject.optString("payway_select_wording", "");
            Object optString3 = jSONObject.optString("payway_change_wording", "");
            ad adVar = new ad();
            adVar.field_is_show = this.tqB;
            adVar.field_pref_key = "wallet_open_auto_pay";
            adVar.field_pref_title = this.tqE;
            adVar.field_pref_url = this.tqC;
            r.cPH().acP("wallet_open_auto_pay");
            ab.i("MicroMsg.NetSceneTenpayPayManager", "deductCacheTime %s forget_pwd_url %s", Integer.valueOf(this.tqD), this.tqG);
            r.cPH().b((c) adVar);
            JSONObject optJSONObject = jSONObject.optJSONObject("switch_wallet");
            if (optJSONObject != null) {
                adVar = k(optJSONObject, "wallet_switch_currency");
                r.cPH().acP("wallet_switch_currency");
                r.cPH().b((c) adVar);
            }
            optJSONObject = jSONObject.optJSONObject("im_mch");
            if (optJSONObject != null) {
                adVar = k(optJSONObject, "wallet_im_mch");
                r.cPH().acP("wallet_im_mch");
                r.cPH().b((c) adVar);
            }
            optJSONObject = jSONObject.optJSONObject("unreg_info");
            if (optJSONObject != null) {
                Object optString4 = optJSONObject.optString("unreg_title", "");
                Object optString5 = optJSONObject.optString("unreg_url", "");
                g.RQ();
                g.RP().Ry().set(a.USERINFO_WALLET_USERINFO_UNREGTITLE_TYPE_STRING_SYNC, optString4);
                g.RQ();
                g.RP().Ry().set(a.USERINFO_WALLET_USERINFO_UNREGURL_TYPE_STRING_SYNC, optString5);
            } else {
                g.RQ();
                g.RP().Ry().set(a.USERINFO_WALLET_USERINFO_UNREGTITLE_TYPE_STRING_SYNC, (Object) "");
                g.RQ();
                g.RP().Ry().set(a.USERINFO_WALLET_USERINFO_UNREGURL_TYPE_STRING_SYNC, (Object) "");
            }
            g.RQ();
            g.RP().Ry().set(a.USERINFO_WALLET_PREF_INFO_CACHE_TIME_LONG_SYNC, Long.valueOf(new Date().getTime() / 1000));
            g.RQ();
            g.RP().Ry().set(a.USERINFO_WALLET_PREF_INFO_EXPIRES_INT_SYNC, Integer.valueOf(this.tqD));
            g.RQ();
            g.RP().Ry().set(a.USERINFO_WALLET_REALNAME_URL_STRING_SYNC, this.tqF);
            g.RQ();
            g.RP().Ry().set(a.USERINFO_WALLET_DEDUCT_FORGET_URL_STRING, this.tqG);
            if (!bo.isNullOrNil(optString2)) {
                g.RQ();
                g.RP().Ry().set(a.USERINFO_WALLET_DEDUCT_SELECT_WORDING_STRING, optString2);
            }
            if (!bo.isNullOrNil(optString3)) {
                g.RQ();
                g.RP().Ry().set(a.USERINFO_WALLET_DEDUCT_CHANGE_WORDING_STRING, optString3);
            }
            g.RQ();
            g.RP().Ry().dsb();
        }
        AppMethodBeat.o(46185);
    }

    private static ad k(JSONObject jSONObject, String str) {
        AppMethodBeat.i(46186);
        ad adVar = new ad();
        adVar.field_is_show = jSONObject.optInt("show_label", 0);
        adVar.field_pref_key = str;
        adVar.field_pref_title = jSONObject.optString("title");
        adVar.field_pref_desc = jSONObject.optString("desc");
        adVar.field_logo_url = jSONObject.optString("logo_url");
        adVar.field_jump_type = jSONObject.optInt("jump_type");
        adVar.field_pref_url = jSONObject.optString("jump_h5_url");
        adVar.field_tinyapp_username = jSONObject.optString("tinyapp_username");
        adVar.field_tinyapp_path = jSONObject.optString("tinyapp_path");
        AppMethodBeat.o(46186);
        return adVar;
    }

    public static boolean bxX() {
        AppMethodBeat.i(46187);
        g.RQ();
        long longValue = ((Long) g.RP().Ry().get(a.USERINFO_WALLET_PREF_INFO_CACHE_TIME_LONG_SYNC, Long.valueOf(0))).longValue();
        g.RQ();
        ab.i("MicroMsg.NetSceneTenpayPayManager", "check isExpire %s %s %s", Long.valueOf(longValue), Integer.valueOf(r0), Long.valueOf(((long) ((Integer) g.RP().Ry().get(a.USERINFO_WALLET_PREF_INFO_EXPIRES_INT_SYNC, Integer.valueOf(0))).intValue()) + longValue));
        if (longValue <= 0) {
            AppMethodBeat.o(46187);
            return true;
        } else if (new Date().getTime() / 1000 > longValue + ((long) r0)) {
            AppMethodBeat.o(46187);
            return true;
        } else {
            AppMethodBeat.o(46187);
            return false;
        }
    }

    private static boolean isNumeric(String str) {
        AppMethodBeat.i(46188);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(46188);
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
                AppMethodBeat.o(46188);
                return true;
            }
        } while (charAt <= '9');
        AppMethodBeat.o(46188);
        return false;
    }

    public final int ZU() {
        return 1654;
    }

    public final int cOo() {
        return 100000;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/paymanage";
    }
}
