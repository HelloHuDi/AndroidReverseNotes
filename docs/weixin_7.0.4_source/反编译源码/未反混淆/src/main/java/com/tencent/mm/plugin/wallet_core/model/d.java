package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.protocal.protobuf.oq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.UnsupportedEncodingException;
import java.math.RoundingMode;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class d {
    private static d txo = null;

    public static d cPh() {
        AppMethodBeat.i(46715);
        if (txo == null) {
            txo = new d();
        }
        d dVar = txo;
        AppMethodBeat.o(46715);
        return dVar;
    }

    public Bankcard ar(JSONObject jSONObject) {
        String str;
        int i = 1;
        AppMethodBeat.i(46716);
        String str2 = "MicroMsg.BankcardParser";
        String str3 = "parseJson jsonBankcard %s";
        Object[] objArr = new Object[1];
        if (jSONObject == null) {
            str = "";
        } else {
            Object str4 = jSONObject;
        }
        objArr[0] = str4;
        ab.i(str2, str3, objArr);
        Bankcard bankcard = new Bankcard();
        try {
            int i2;
            bankcard.field_bankName = jSONObject.getString("bank_name");
            bankcard.field_bankcardTypeName = jSONObject.optString("bankacc_type_name");
            bankcard.field_bankcardType = jSONObject.getString("bank_type");
            bankcard.field_bindSerial = jSONObject.optString("bind_serial");
            ab.d("MicroMsg.BankcardParser", "bind_serial: %s", bankcard.field_bindSerial);
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
            if (bo.isNullOrNil(bankcard.field_mobile)) {
                bankcard.field_mobile = jSONObject.optString("mobile_mask");
            }
            bankcard.field_onceQuotaKind = jSONObject.optDouble("once_quota_3") / 100.0d;
            bankcard.field_onceQuotaVirtual = jSONObject.optDouble("once_quota_1") / 100.0d;
            bankcard.field_dayQuotaKind = jSONObject.optDouble("day_quota_3") / 100.0d;
            bankcard.field_dayQuotaVirtual = jSONObject.optDouble("day_quota_1") / 100.0d;
            bankcard.field_bankcardTail = jSONObject.optString("bind_tail");
            if (bo.isNullOrNil(bankcard.field_bankcardTail)) {
                bankcard.field_bankcardTail = jSONObject.optString("card_tail");
            }
            bankcard.twO = jSONObject.optString("card_mask");
            bankcard.field_forbidWord = jSONObject.optString("forbid_word");
            bankcard.field_repay_url = jSONObject.optString("repay_url");
            bankcard.field_wxcreditState = 2;
            if (!bo.isNullOrNil(bankcard.field_forbidWord)) {
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
            ab.i("MicroMsg.BankcardParser", "getBalance() support_micropay:" + jSONObject.optString("support_micropay"));
            i = jSONObject.optInt("fetch_charge_rate", 0);
            ab.i("MicroMsg.BankcardParser", "fetch_charge_rate:".concat(String.valueOf(i)));
            bankcard.field_fetch_charge_rate = ((double) i) / 10000.0d;
            ab.i("MicroMsg.BankcardParser", "field_fetch_charge_rate:" + bankcard.field_fetch_charge_rate);
            i = jSONObject.optInt("full_fetch_charge_fee", 0);
            ab.i("MicroMsg.BankcardParser", "full_fetch_charge_fee:" + bankcard.field_full_fetch_charge_fee);
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
            e(bankcard);
            AppMethodBeat.o(46716);
            return bankcard;
        } catch (JSONException e) {
            ab.i("MicroMsg.BankcardParser", "parseJson() JSONException:" + e.getMessage());
            ab.printErrStackTrace("MicroMsg.BankcardParser", e, "", new Object[0]);
            AppMethodBeat.o(46716);
            return null;
        } catch (UnsupportedEncodingException e2) {
            ab.i("MicroMsg.BankcardParser", "parseJson() UnsupportedEncodingException :" + e2.getMessage());
            ab.printErrStackTrace("MicroMsg.BankcardParser", e2, "", new Object[0]);
            AppMethodBeat.o(46716);
            return null;
        } catch (Exception e3) {
            ab.i("MicroMsg.BankcardParser", "parseJson() Exception:" + e3.getMessage());
            ab.printErrStackTrace("MicroMsg.BankcardParser", e3, "", new Object[0]);
            AppMethodBeat.o(46716);
            return null;
        }
    }

    public static List<Bankcard> dQ(List<oq> list) {
        AppMethodBeat.i(46717);
        ArrayList arrayList = new ArrayList();
        if (!(list == null || list.isEmpty())) {
            ab.i("MicroMsg.BankcardParser", "record size: %s", Integer.valueOf(list.size()));
            for (oq a : list) {
                arrayList.add(a(a));
            }
        }
        AppMethodBeat.o(46717);
        return arrayList;
    }

    public static Bankcard a(oq oqVar) {
        boolean z = true;
        AppMethodBeat.i(46718);
        ab.i("MicroMsg.BankcardParser", "parseFromBindQueryRecord %s", oqVar);
        Bankcard bankcard = new Bankcard();
        try {
            boolean z2;
            bankcard.field_bankName = oqVar.nuL;
            bankcard.field_bankcardTypeName = oqVar.vJE;
            bankcard.field_bankcardType = oqVar.pbn;
            bankcard.field_bindSerial = oqVar.pbo;
            ab.d("MicroMsg.BankcardParser", "bind_serial: %s", bankcard.field_bindSerial);
            if (2 == bo.getInt(oqVar.vJC, 2)) {
                bankcard.field_cardType |= Bankcard.twG;
            }
            if ("NORMAL".equals(oqVar.vVn)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                bankcard.field_cardType |= Bankcard.twH;
            }
            if (!bo.isNullOrNil(oqVar.cFl)) {
                bankcard.field_mobile = URLDecoder.decode(oqVar.cFl.replaceAll(VideoMaterialUtil.CRAZYFACE_X, "%"), ProtocolPackage.ServerEncoding);
            }
            bankcard.field_onceQuotaKind = e.b(oqVar.vVj, "100", RoundingMode.HALF_UP);
            bankcard.field_onceQuotaVirtual = e.b(oqVar.vVh, "100", RoundingMode.HALF_UP);
            bankcard.field_dayQuotaKind = e.b(oqVar.vVf, "100", RoundingMode.HALF_UP);
            bankcard.field_dayQuotaVirtual = e.b(oqVar.vVd, "100", RoundingMode.HALF_UP);
            bankcard.field_bankcardTail = oqVar.vJD;
            bankcard.field_forbidWord = oqVar.pbp;
            bankcard.field_repay_url = oqVar.uYI;
            bankcard.field_wxcreditState = 2;
            if (!bo.isNullOrNil(bankcard.field_forbidWord)) {
                bankcard.field_bankcardState = 8;
            } else if (1 == bo.getInt(oqVar.vVg, 0)) {
                bankcard.field_bankcardState = 1;
            } else if (bo.getInt(oqVar.tyG, 1) == 0) {
                bankcard.field_bankcardState = 2;
            } else {
                bankcard.field_bankcardState = 0;
            }
            bankcard.field_bankPhone = oqVar.tyH;
            bankcard.field_fetchArriveTime = bo.getLong(oqVar.vVs, 0) * 1000;
            bankcard.field_fetchArriveTimeWording = oqVar.vVE;
            bankcard.field_bankcardTag = bo.getInt(oqVar.vVk, 1);
            if (bankcard.field_bankcardTag == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                bankcard.field_cardType |= Bankcard.twF;
            }
            if (oqVar.vVp != 1) {
                z = false;
            }
            bankcard.field_support_micropay = z;
            ab.i("MicroMsg.BankcardParser", "getBalance() support_micropay:" + oqVar.vVp);
            bankcard.field_arrive_type = oqVar.vVy;
            bankcard.field_avail_save_wording = oqVar.vVA;
            int i = oqVar.vVF;
            ab.i("MicroMsg.BankcardParser", "fetch_charge_rate:".concat(String.valueOf(i)));
            bankcard.field_fetch_charge_rate = ((double) i) / 10000.0d;
            ab.i("MicroMsg.BankcardParser", "field_fetch_charge_rate:" + bankcard.field_fetch_charge_rate);
            i = oqVar.vVG;
            ab.i("MicroMsg.BankcardParser", "full_fetch_charge_fee:" + bankcard.field_full_fetch_charge_fee);
            bankcard.field_full_fetch_charge_fee = ((double) i) / 100.0d;
            bankcard.field_fetch_charge_info = oqVar.vVH;
            bankcard.field_tips = oqVar.kfM;
            bankcard.field_forbid_title = oqVar.vJv;
            bankcard.field_forbid_url = oqVar.vJw;
            bankcard.field_no_micro_word = oqVar.vVz;
            bankcard.field_card_bottom_wording = oqVar.vVN;
            bankcard.field_support_lqt_turn_in = oqVar.vVQ;
            bankcard.field_support_lqt_turn_out = oqVar.vVR;
            bankcard.field_is_hightlight_pre_arrive_time_wording = oqVar.vVP;
            e(bankcard);
            AppMethodBeat.o(46718);
            return bankcard;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BankcardParser", e, "parseFromBindQueryRecord() error:" + e.getMessage(), new Object[0]);
            AppMethodBeat.o(46718);
            return null;
        }
    }

    public static void e(Bankcard bankcard) {
        AppMethodBeat.i(46719);
        if (bankcard == null) {
            AppMethodBeat.o(46719);
        } else if (bankcard.cPc()) {
            bankcard.field_desc = bankcard.field_bankName;
            AppMethodBeat.o(46719);
        } else if (bankcard.cPg()) {
            bankcard.field_desc = ah.getContext().getString(R.string.ffo, new Object[]{bankcard.txj, e.eL(bankcard.txg, 8)});
            AppMethodBeat.o(46719);
        } else if (bankcard.cPe()) {
            bankcard.field_desc = ah.getContext().getString(R.string.fdv, new Object[]{bankcard.field_bankName, bankcard.field_bankcardTail});
            AppMethodBeat.o(46719);
        } else if (bankcard.cPb()) {
            bankcard.field_desc = ah.getContext().getString(R.string.fwm, new Object[]{bankcard.field_bankName, bankcard.field_bankcardTail});
            AppMethodBeat.o(46719);
        } else {
            bankcard.field_desc = ah.getContext().getString(R.string.fee, new Object[]{bankcard.field_bankName, bankcard.field_bankcardTail});
            AppMethodBeat.o(46719);
        }
    }
}
