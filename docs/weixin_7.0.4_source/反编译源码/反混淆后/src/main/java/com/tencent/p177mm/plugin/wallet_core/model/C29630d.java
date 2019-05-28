package com.tencent.p177mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.protocal.protobuf.C40553oq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.UnsupportedEncodingException;
import java.math.RoundingMode;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.d */
public class C29630d {
    private static C29630d txo = null;

    public static C29630d cPh() {
        AppMethodBeat.m2504i(46715);
        if (txo == null) {
            txo = new C29630d();
        }
        C29630d c29630d = txo;
        AppMethodBeat.m2505o(46715);
        return c29630d;
    }

    /* renamed from: ar */
    public Bankcard mo38120ar(JSONObject jSONObject) {
        String str;
        int i = 1;
        AppMethodBeat.m2504i(46716);
        String str2 = "MicroMsg.BankcardParser";
        String str3 = "parseJson jsonBankcard %s";
        Object[] objArr = new Object[1];
        if (jSONObject == null) {
            str = "";
        } else {
            Object str4 = jSONObject;
        }
        objArr[0] = str4;
        C4990ab.m7417i(str2, str3, objArr);
        Bankcard bankcard = new Bankcard();
        try {
            int i2;
            bankcard.field_bankName = jSONObject.getString("bank_name");
            bankcard.field_bankcardTypeName = jSONObject.optString("bankacc_type_name");
            bankcard.field_bankcardType = jSONObject.getString("bank_type");
            bankcard.field_bindSerial = jSONObject.optString("bind_serial");
            C4990ab.m7411d("MicroMsg.BankcardParser", "bind_serial: %s", bankcard.field_bindSerial);
            bankcard.twQ = jSONObject.optString("h_bind_serialno");
            if (2 == jSONObject.optInt("bankacc_type", 0)) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (i2 != 0) {
                bankcard.field_cardType |= Bankcard.twG;
            }
            if ("NORMAL".equals(jSONObject.optString("extra_bind_flag"))) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            if (i2 != 0) {
                bankcard.field_cardType |= Bankcard.twH;
            }
            if ("QMF".equals(bankcard.field_bankcardType)) {
                bankcard.field_cardType |= Bankcard.twM;
                JSONObject optJSONObject = jSONObject.optJSONObject("qmfCardInfo");
                if (optJSONObject != null) {
                    bankcard.txd = optJSONObject.optLong("total_credit_line", 0);
                    bankcard.txe = optJSONObject.optLong("use_credit_line", 0);
                    bankcard.txf = optJSONObject.optLong("unuse_credit_line", 0);
                    bankcard.txg = optJSONObject.optString("payer_username", "");
                    bankcard.txh = optJSONObject.optInt("hide_credit_line", 0);
                    bankcard.txi = optJSONObject.optInt("card_type", 0);
                    bankcard.txj = optJSONObject.optString("card_type_name", "");
                    bankcard.txk = optJSONObject.optString("icon_url", "");
                }
            }
            bankcard.field_mobile = URLDecoder.decode(jSONObject.optString("mobile").replaceAll(VideoMaterialUtil.CRAZYFACE_X, "%"), ProtocolPackage.ServerEncoding);
            if (C5046bo.isNullOrNil(bankcard.field_mobile)) {
                bankcard.field_mobile = jSONObject.optString("mobile_mask");
            }
            bankcard.field_onceQuotaKind = jSONObject.optDouble("once_quota_3") / 100.0d;
            bankcard.field_onceQuotaVirtual = jSONObject.optDouble("once_quota_1") / 100.0d;
            bankcard.field_dayQuotaKind = jSONObject.optDouble("day_quota_3") / 100.0d;
            bankcard.field_dayQuotaVirtual = jSONObject.optDouble("day_quota_1") / 100.0d;
            bankcard.field_bankcardTail = jSONObject.optString("bind_tail");
            if (C5046bo.isNullOrNil(bankcard.field_bankcardTail)) {
                bankcard.field_bankcardTail = jSONObject.optString("card_tail");
            }
            bankcard.twO = jSONObject.optString("card_mask");
            bankcard.field_forbidWord = jSONObject.optString("forbid_word");
            bankcard.field_repay_url = jSONObject.optString("repay_url");
            bankcard.field_wxcreditState = 2;
            if (!C5046bo.isNullOrNil(bankcard.field_forbidWord)) {
                bankcard.field_bankcardState = 8;
            } else if (1 == jSONObject.optInt("expired_flag", 0)) {
                bankcard.field_bankcardState = 1;
            } else if (jSONObject.optInt("bank_flag", 1) == 0) {
                bankcard.field_bankcardState = 2;
            } else {
                bankcard.field_bankcardState = 0;
            }
            bankcard.field_bankPhone = jSONObject.optString("bank_phone");
            bankcard.field_fetchArriveTime = jSONObject.optLong("fetch_pre_arrive_time") * 1000;
            bankcard.field_fetchArriveTimeWording = jSONObject.optString("fetch_pre_arrive_time_wording");
            bankcard.field_bankcardTag = jSONObject.optInt("bank_card_tag", 1);
            if (bankcard.field_bankcardTag != 2) {
                i = 0;
            }
            if (i != 0) {
                bankcard.field_cardType |= Bankcard.twF;
            }
            String optString = jSONObject.optString("support_micropay");
            if (TextUtils.isEmpty(optString)) {
                bankcard.field_support_micropay = true;
            }
            if ("1".equals(optString)) {
                bankcard.field_support_micropay = true;
            } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(optString)) {
                bankcard.field_support_micropay = false;
            }
            bankcard.field_arrive_type = jSONObject.optString("arrive_type");
            bankcard.field_avail_save_wording = jSONObject.optString("avail_save_wording");
            C4990ab.m7416i("MicroMsg.BankcardParser", "getBalance() support_micropay:" + jSONObject.optString("support_micropay"));
            i = jSONObject.optInt("fetch_charge_rate", 0);
            C4990ab.m7416i("MicroMsg.BankcardParser", "fetch_charge_rate:".concat(String.valueOf(i)));
            bankcard.field_fetch_charge_rate = ((double) i) / 10000.0d;
            C4990ab.m7416i("MicroMsg.BankcardParser", "field_fetch_charge_rate:" + bankcard.field_fetch_charge_rate);
            i = jSONObject.optInt("full_fetch_charge_fee", 0);
            C4990ab.m7416i("MicroMsg.BankcardParser", "full_fetch_charge_fee:" + bankcard.field_full_fetch_charge_fee);
            bankcard.field_full_fetch_charge_fee = ((double) i) / 100.0d;
            bankcard.field_fetch_charge_info = jSONObject.optString("fetch_charge_info");
            bankcard.field_tips = jSONObject.optString("tips");
            bankcard.field_forbid_title = jSONObject.optString("forbid_title");
            bankcard.field_forbid_url = jSONObject.optString("forbid_url");
            bankcard.field_no_micro_word = jSONObject.optString("no_micro_word");
            bankcard.field_card_bottom_wording = jSONObject.optString("card_bottom_wording");
            bankcard.field_support_lqt_turn_in = jSONObject.optInt("support_lqt_turn_in", 0);
            bankcard.field_support_lqt_turn_out = jSONObject.optInt("support_lqt_turn_out", 0);
            bankcard.field_is_hightlight_pre_arrive_time_wording = jSONObject.optInt("is_hightlight_pre_arrive_time_wording", 0);
            bankcard.txl = jSONObject.optInt("support_foreign_mobile", 0);
            bankcard.field_card_state_name = jSONObject.optString("card_state_name");
            bankcard.txm = jSONObject.optString("card_fetch_wording");
            bankcard.txn = jSONObject.optLong("card_min_charge_fee");
            C29630d.m46997e(bankcard);
            AppMethodBeat.m2505o(46716);
            return bankcard;
        } catch (JSONException e) {
            C4990ab.m7416i("MicroMsg.BankcardParser", "parseJson() JSONException:" + e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.BankcardParser", e, "", new Object[0]);
            AppMethodBeat.m2505o(46716);
            return null;
        } catch (UnsupportedEncodingException e2) {
            C4990ab.m7416i("MicroMsg.BankcardParser", "parseJson() UnsupportedEncodingException :" + e2.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.BankcardParser", e2, "", new Object[0]);
            AppMethodBeat.m2505o(46716);
            return null;
        } catch (Exception e3) {
            C4990ab.m7416i("MicroMsg.BankcardParser", "parseJson() Exception:" + e3.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.BankcardParser", e3, "", new Object[0]);
            AppMethodBeat.m2505o(46716);
            return null;
        }
    }

    /* renamed from: dQ */
    public static List<Bankcard> m46996dQ(List<C40553oq> list) {
        AppMethodBeat.m2504i(46717);
        ArrayList arrayList = new ArrayList();
        if (!(list == null || list.isEmpty())) {
            C4990ab.m7417i("MicroMsg.BankcardParser", "record size: %s", Integer.valueOf(list.size()));
            for (C40553oq a : list) {
                arrayList.add(C29630d.m46995a(a));
            }
        }
        AppMethodBeat.m2505o(46717);
        return arrayList;
    }

    /* renamed from: a */
    public static Bankcard m46995a(C40553oq c40553oq) {
        boolean z = true;
        AppMethodBeat.m2504i(46718);
        C4990ab.m7417i("MicroMsg.BankcardParser", "parseFromBindQueryRecord %s", c40553oq);
        Bankcard bankcard = new Bankcard();
        try {
            boolean z2;
            bankcard.field_bankName = c40553oq.nuL;
            bankcard.field_bankcardTypeName = c40553oq.vJE;
            bankcard.field_bankcardType = c40553oq.pbn;
            bankcard.field_bindSerial = c40553oq.pbo;
            C4990ab.m7411d("MicroMsg.BankcardParser", "bind_serial: %s", bankcard.field_bindSerial);
            if (2 == C5046bo.getInt(c40553oq.vJC, 2)) {
                bankcard.field_cardType |= Bankcard.twG;
            }
            if ("NORMAL".equals(c40553oq.vVn)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                bankcard.field_cardType |= Bankcard.twH;
            }
            if (!C5046bo.isNullOrNil(c40553oq.cFl)) {
                bankcard.field_mobile = URLDecoder.decode(c40553oq.cFl.replaceAll(VideoMaterialUtil.CRAZYFACE_X, "%"), ProtocolPackage.ServerEncoding);
            }
            bankcard.field_onceQuotaKind = C36391e.m59996b(c40553oq.vVj, "100", RoundingMode.HALF_UP);
            bankcard.field_onceQuotaVirtual = C36391e.m59996b(c40553oq.vVh, "100", RoundingMode.HALF_UP);
            bankcard.field_dayQuotaKind = C36391e.m59996b(c40553oq.vVf, "100", RoundingMode.HALF_UP);
            bankcard.field_dayQuotaVirtual = C36391e.m59996b(c40553oq.vVd, "100", RoundingMode.HALF_UP);
            bankcard.field_bankcardTail = c40553oq.vJD;
            bankcard.field_forbidWord = c40553oq.pbp;
            bankcard.field_repay_url = c40553oq.uYI;
            bankcard.field_wxcreditState = 2;
            if (!C5046bo.isNullOrNil(bankcard.field_forbidWord)) {
                bankcard.field_bankcardState = 8;
            } else if (1 == C5046bo.getInt(c40553oq.vVg, 0)) {
                bankcard.field_bankcardState = 1;
            } else if (C5046bo.getInt(c40553oq.tyG, 1) == 0) {
                bankcard.field_bankcardState = 2;
            } else {
                bankcard.field_bankcardState = 0;
            }
            bankcard.field_bankPhone = c40553oq.tyH;
            bankcard.field_fetchArriveTime = C5046bo.getLong(c40553oq.vVs, 0) * 1000;
            bankcard.field_fetchArriveTimeWording = c40553oq.vVE;
            bankcard.field_bankcardTag = C5046bo.getInt(c40553oq.vVk, 1);
            if (bankcard.field_bankcardTag == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                bankcard.field_cardType |= Bankcard.twF;
            }
            if (c40553oq.vVp != 1) {
                z = false;
            }
            bankcard.field_support_micropay = z;
            C4990ab.m7416i("MicroMsg.BankcardParser", "getBalance() support_micropay:" + c40553oq.vVp);
            bankcard.field_arrive_type = c40553oq.vVy;
            bankcard.field_avail_save_wording = c40553oq.vVA;
            int i = c40553oq.vVF;
            C4990ab.m7416i("MicroMsg.BankcardParser", "fetch_charge_rate:".concat(String.valueOf(i)));
            bankcard.field_fetch_charge_rate = ((double) i) / 10000.0d;
            C4990ab.m7416i("MicroMsg.BankcardParser", "field_fetch_charge_rate:" + bankcard.field_fetch_charge_rate);
            i = c40553oq.vVG;
            C4990ab.m7416i("MicroMsg.BankcardParser", "full_fetch_charge_fee:" + bankcard.field_full_fetch_charge_fee);
            bankcard.field_full_fetch_charge_fee = ((double) i) / 100.0d;
            bankcard.field_fetch_charge_info = c40553oq.vVH;
            bankcard.field_tips = c40553oq.kfM;
            bankcard.field_forbid_title = c40553oq.vJv;
            bankcard.field_forbid_url = c40553oq.vJw;
            bankcard.field_no_micro_word = c40553oq.vVz;
            bankcard.field_card_bottom_wording = c40553oq.vVN;
            bankcard.field_support_lqt_turn_in = c40553oq.vVQ;
            bankcard.field_support_lqt_turn_out = c40553oq.vVR;
            bankcard.field_is_hightlight_pre_arrive_time_wording = c40553oq.vVP;
            C29630d.m46997e(bankcard);
            AppMethodBeat.m2505o(46718);
            return bankcard;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BankcardParser", e, "parseFromBindQueryRecord() error:" + e.getMessage(), new Object[0]);
            AppMethodBeat.m2505o(46718);
            return null;
        }
    }

    /* renamed from: e */
    public static void m46997e(Bankcard bankcard) {
        AppMethodBeat.m2504i(46719);
        if (bankcard == null) {
            AppMethodBeat.m2505o(46719);
        } else if (bankcard.cPc()) {
            bankcard.field_desc = bankcard.field_bankName;
            AppMethodBeat.m2505o(46719);
        } else if (bankcard.cPg()) {
            bankcard.field_desc = C4996ah.getContext().getString(C25738R.string.ffo, new Object[]{bankcard.txj, C36391e.m60008eL(bankcard.txg, 8)});
            AppMethodBeat.m2505o(46719);
        } else if (bankcard.cPe()) {
            bankcard.field_desc = C4996ah.getContext().getString(C25738R.string.fdv, new Object[]{bankcard.field_bankName, bankcard.field_bankcardTail});
            AppMethodBeat.m2505o(46719);
        } else if (bankcard.cPb()) {
            bankcard.field_desc = C4996ah.getContext().getString(C25738R.string.fwm, new Object[]{bankcard.field_bankName, bankcard.field_bankcardTail});
            AppMethodBeat.m2505o(46719);
        } else {
            bankcard.field_desc = C4996ah.getContext().getString(C25738R.string.fee, new Object[]{bankcard.field_bankName, bankcard.field_bankcardTail});
            AppMethodBeat.m2505o(46719);
        }
    }
}
