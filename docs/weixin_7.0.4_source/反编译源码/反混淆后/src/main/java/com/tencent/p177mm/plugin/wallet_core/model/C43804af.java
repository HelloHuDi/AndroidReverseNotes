package com.tencent.p177mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.wallet_core.model.C22590b.C4393b;
import com.tencent.p177mm.protocal.protobuf.C40523gx;
import com.tencent.p177mm.protocal.protobuf.C44124gw;
import com.tencent.p177mm.protocal.protobuf.C46546gy;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.p649c.C30862w;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.C36391e.C30881a;
import com.tencent.p177mm.wallet_core.p650ui.C36391e.C30882c;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.af */
public final class C43804af {
    /* renamed from: a */
    public static void m78521a(JSONObject jSONObject, int i, boolean z) {
        AppMethodBeat.m2504i(46927);
        C4990ab.m7417i("MicroMsg.WalletQueryBankcardParser", "parseQueryBankcard(): %s, %s", Integer.valueOf(i), Boolean.valueOf(z));
        try {
            JSONObject optJSONObject;
            long optLong = jSONObject.optLong("time_stamp");
            if (optLong > 0) {
                C30862w.setTimeStamp(String.valueOf(optLong));
            } else {
                C4990ab.m7420w("MicroMsg.WalletQueryBankcardParser", "no time_stamp at WalletQueryBankcardParser.");
            }
            C22586aj a = C43804af.m78518a(jSONObject.getJSONObject("user_info"), i);
            if (z) {
                a.field_switchConfig = jSONObject.getJSONObject("switch_info").getInt("switch_bit");
            } else {
                a.field_switchConfig = C14241r.cPE().cRh().field_switchConfig;
            }
            a.field_paymenu_use_new = jSONObject.optInt("paymenu_use_new");
            C4990ab.m7417i("MicroMsg.WalletQueryBankcardParser", "parseQueryBankcard, paymenu_use_new: %s", Integer.valueOf(a.field_paymenu_use_new));
            String optString = jSONObject.optString("support_bank_word");
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_SUPPORT_BANK_WORD_STRING, C5046bo.nullAsNil(optString));
            ArrayList z2 = C43804af.m78528z(jSONObject.optJSONArray("Array"));
            ArrayList A = C43804af.m78514A(jSONObject.optJSONArray("virtual_card_array"));
            Bankcard aG = C43804af.m78525aG(jSONObject.optJSONObject("balance_info"));
            if (aG != null && i == 10) {
                C4990ab.m7417i("MicroMsg.WalletQueryBankcardParser", "carson: entry_url: %s、entry_word：%s", aG.twW, aG.twX);
                optJSONObject = jSONObject.optJSONObject("bill_entry");
                if (optJSONObject != null) {
                    aG.twW = optJSONObject.optString("entry_url");
                    aG.twX = optJSONObject.optString("entry_word");
                }
            }
            C4990ab.m7417i("MicroMsg.WalletQueryBankcardParser", "hy: cache time: %d", Integer.valueOf(jSONObject.optInt("query_cache_time")));
            optJSONObject = jSONObject.optJSONObject("complex_switch_info");
            if (optJSONObject != null) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("bind_newcard_switch");
                optJSONObject2.optInt("forbid_bind_card");
                optJSONObject2.optString("forbid_word");
            }
            C43809g.cPl().mo69492at(optJSONObject);
            Bankcard B = C43804af.m78515B(jSONObject.optJSONArray("history_card_array"));
            C43804af.m78524aF(jSONObject);
            optJSONObject = jSONObject.optJSONObject("bank_priority");
            if (optJSONObject != null) {
                a.field_bank_priority = optJSONObject.toString();
            }
            List aE = C43804af.m78523aE(optJSONObject);
            a.field_unipay_order_state = jSONObject.optInt("unipayorderstate", 0);
            C43804af.m78522a(jSONObject, a, z);
            jSONObject.optString("query_order_time");
            C40114n aH = C43804af.m78526aH(jSONObject.optJSONObject("loan_entry_info"));
            optJSONObject = jSONObject.optJSONObject("fetch_info");
            C22590b c22590b = C14241r.cPI().tCX;
            C4990ab.m7411d("MicroMsg.WalletQueryBankcardParser", "fetchInfo: %s", c22590b);
            if (optJSONObject != null) {
                c22590b = C43804af.m78519a(optJSONObject, true);
            } else {
                C4990ab.m7412e("MicroMsg.WalletQueryBankcardParser", "parseQueryBankcard() fetch_info is null");
            }
            Bankcard aI = C43804af.m78527aI(jSONObject.optJSONObject("lqt_info"));
            if (i == 4) {
                C4990ab.m7410d("MicroMsg.WalletQueryBankcardParser", "update fetch scene data");
                C14241r.cPI().tgW = jSONObject.optInt("is_use_dynamic_free_fee");
                C14241r.cPI().tgX = jSONObject.optInt("dynamic_free_fee_hold_time");
            }
            C14241r.cPI().mo38133a(a, z2, A, aG, B, aH, c22590b, aI, r11, i, aE);
            AppMethodBeat.m2505o(46927);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.WalletQueryBankcardParser", "parseQueryBankcard Exception :" + e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.WalletQueryBankcardParser", e, "", new Object[0]);
            AppMethodBeat.m2505o(46927);
        }
    }

    /* renamed from: aE */
    public static List<C22591c> m78523aE(JSONObject jSONObject) {
        AppMethodBeat.m2504i(46928);
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("bankinfo_array");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        C22591c c22591c = new C22591c();
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        c22591c.pbo = jSONObject2.optString("bind_serial");
                        c22591c.twE = jSONObject2.optString("polling_forbid_word");
                        arrayList.add(c22591c);
                    }
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.WalletQueryBankcardParser", e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(46928);
        return arrayList;
    }

    /* renamed from: a */
    private static void m78522a(JSONObject jSONObject, C22586aj c22586aj, boolean z) {
        AppMethodBeat.m2504i(46929);
        if (z) {
            JSONObject optJSONObject = jSONObject.optJSONObject("wallet_info");
            if (optJSONObject != null) {
                c22586aj.field_wallet_balance = optJSONObject.optLong("wallet_balance", -1);
                c22586aj.field_wallet_entrance_balance_switch_state = optJSONObject.optInt("wallet_entrance_balance_switch_state", -1);
            }
            AppMethodBeat.m2505o(46929);
            return;
        }
        c22586aj.field_wallet_balance = C14241r.cPE().cRh().field_wallet_balance;
        c22586aj.field_wallet_entrance_balance_switch_state = C14241r.cPE().cRh().field_wallet_entrance_balance_switch_state;
        AppMethodBeat.m2505o(46929);
    }

    /* renamed from: Hr */
    public static boolean m78516Hr(int i) {
        if (i == 9 || i == 10 || i == 11 || i == 12 || i == 13 || i == 14 || i == 15 || i == 16 || i == 17 || i == 18 || i == 19 || i == 20 || i == 21 || i == 22 || i == 23) {
            return true;
        }
        return false;
    }

    /* renamed from: aF */
    private static void m78524aF(JSONObject jSONObject) {
        Object bc;
        Object bc2;
        AppMethodBeat.m2504i(46930);
        JSONArray optJSONArray = jSONObject.optJSONArray("balance_notice");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("fetch_notice");
        if (optJSONArray != null) {
            bc = C5046bo.m7532bc(optJSONArray.toString(), "");
        } else {
            String bc3 = "";
        }
        if (optJSONArray2 != null) {
            bc2 = C5046bo.m7532bc(optJSONArray2.toString(), "");
        } else {
            bc2 = "";
        }
        C4990ab.m7417i("MicroMsg.WalletQueryBankcardParser", "hy: balance notice: %s, fetchNotice: %s", bc3, bc2);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_BALANCE_NOTICE_STRING, bc3);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_FETCH_NOTICE_STRING, bc2);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().dsb();
        AppMethodBeat.m2505o(46930);
    }

    /* renamed from: a */
    private static C22586aj m78518a(JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(46931);
        C4990ab.m7416i("MicroMsg.WalletQueryBankcardParser", "getUserInfo()");
        C22586aj c22586aj = new C22586aj();
        if (jSONObject == null || jSONObject.length() <= 0) {
            C4990ab.m7412e("MicroMsg.WalletQueryBankcardParser", "getUserInfo() json == null or json.length() == 0");
            AppMethodBeat.m2505o(46931);
            return null;
        }
        c22586aj.field_is_reg = jSONObject.getInt("is_reg");
        c22586aj.field_true_name = jSONObject.optString("true_name");
        c22586aj.field_cre_type = jSONObject.optInt("cre_type", -1);
        c22586aj.field_main_card_bind_serialno = jSONObject.optString("last_card_bind_serialno");
        c22586aj.field_cre_name = jSONObject.optString("cre_name");
        c22586aj.field_ftf_pay_url = jSONObject.optString("transfer_url");
        c22586aj.field_reset_passwd_flag = jSONObject.optString("reset_passwd_flag");
        c22586aj.field_find_passwd_url = jSONObject.optString("reset_passwd_url");
        c22586aj.field_forget_passwd_url = jSONObject.optString("forget_passwd_url");
        C14241r.cPI();
        C22587ak.acD(c22586aj.field_main_card_bind_serialno);
        c22586aj.field_isDomesticUser = "2".equals(jSONObject.optString("icard_user_flag", "2"));
        JSONObject optJSONObject = jSONObject.optJSONObject("touch_info");
        if (optJSONObject != null) {
            c22586aj.field_is_open_touch = optJSONObject.optInt("is_open_touch", 0);
            c22586aj.field_soter_pay_open_type = optJSONObject.optInt("soter_pay_open_type", 0);
            C4990ab.m7411d("MicroMsg.WalletQueryBankcardParser", "getUserInfo field_is_open_touch() is %s, %s", Integer.valueOf(c22586aj.field_is_open_touch), Integer.valueOf(c22586aj.field_soter_pay_open_type));
        } else {
            int i2;
            C4990ab.m7412e("MicroMsg.WalletQueryBankcardParser", "touch_info is null ");
            if (C14241r.cPI().cQk()) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            c22586aj.field_is_open_touch = i2;
            c22586aj.field_soter_pay_open_type = C14241r.cPI().cQm();
            C4990ab.m7412e("MicroMsg.WalletQueryBankcardParser", "old field_is_open_touch is " + c22586aj.field_is_open_touch);
        }
        c22586aj.field_lct_wording = jSONObject.optString("lct_wording");
        c22586aj.field_lct_url = jSONObject.optString("lct_url");
        C4990ab.m7416i("MicroMsg.WalletQueryBankcardParser", "field_lct_wording: " + c22586aj.field_lct_wording + ", field_lct_url:" + c22586aj.field_lct_url);
        c22586aj.field_lqt_state = jSONObject.optInt("lqt_state", -1);
        optJSONObject = jSONObject.optJSONObject("lqb_show_info");
        C4990ab.m7417i("MicroMsg.WalletQueryBankcardParser", "field_lqt_state: %s, lqb_show_info: %s", Integer.valueOf(c22586aj.field_lqt_state), optJSONObject);
        if (optJSONObject != null) {
            c22586aj.field_is_show_lqb = optJSONObject.optInt("is_show_lqb");
            c22586aj.field_is_open_lqb = optJSONObject.optInt("is_open_lqb");
            c22586aj.field_lqb_open_url = optJSONObject.optString("lqb_open_url");
        }
        optJSONObject = jSONObject.optJSONObject("lqt_cell_info");
        C4990ab.m7417i("MicroMsg.WalletQueryBankcardParser", "lqt_cell_info: %s", optJSONObject);
        if (optJSONObject != null) {
            c22586aj.field_lqt_cell_is_show = optJSONObject.optInt("is_show_cell");
            c22586aj.field_lqt_cell_icon = optJSONObject.optString("cell_icon");
            c22586aj.field_lqt_cell_is_open_lqt = optJSONObject.optInt("is_open_lqt");
            c22586aj.field_lqt_cell_lqt_open_url = optJSONObject.optString("lqt_open_url");
            c22586aj.field_lqt_cell_lqt_title = optJSONObject.optString("lqt_title");
            c22586aj.field_lqt_cell_lqt_wording = optJSONObject.optString("lqt_wording");
        }
        if (C43804af.m78516Hr(i) || i == 3 || i == 4) {
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_LQT_OPEN_FLAG_INT_SYNC, Integer.valueOf(c22586aj.field_lqt_state));
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_LQT_ENTRY_WORDING_STRING_SYNC, c22586aj.field_lct_wording);
        }
        AppMethodBeat.m2505o(46931);
        return c22586aj;
    }

    /* renamed from: aG */
    private static Bankcard m78525aG(JSONObject jSONObject) {
        String str;
        Object str2;
        AppMethodBeat.m2504i(46932);
        String str3 = "MicroMsg.WalletQueryBankcardParser";
        String str4 = "Bankcard getBalance %s";
        Object[] objArr = new Object[1];
        if (jSONObject == null) {
            str2 = "";
        } else {
            str2 = jSONObject;
        }
        objArr[0] = str2;
        C4990ab.m7417i(str3, str4, objArr);
        if (jSONObject == null || jSONObject.length() <= 0) {
            C4990ab.m7416i("MicroMsg.WalletQueryBankcardParser", "getBalance() json == null or json.length() == 0");
            AppMethodBeat.m2505o(46932);
            return null;
        }
        boolean z;
        Bankcard bankcard = new Bankcard((byte) 0);
        C43804af.m78520a(bankcard, jSONObject.optLong("balance_version", -1), jSONObject.optLong("time_out", 7200), jSONObject.optInt("avail_balance"));
        bankcard.twS = C36391e.m59996b(jSONObject.optString("avail_balance", AppEventsConstants.EVENT_PARAM_VALUE_NO), "100", RoundingMode.HALF_UP);
        bankcard.twT = jSONObject.optString("balance_show_wording");
        bankcard.twY = jSONObject.optString("max_fetch_wording");
        bankcard.twZ = jSONObject.optString("avail_fetch_wording");
        bankcard.twU = C36391e.m59996b(jSONObject.optString("fetch_balance", AppEventsConstants.EVENT_PARAM_VALUE_NO), "100", RoundingMode.HALF_UP);
        bankcard.field_cardType |= Bankcard.twI;
        bankcard.field_bankcardType = jSONObject.optString("balance_bank_type");
        bankcard.field_bindSerial = jSONObject.optString("balance_bind_serial");
        bankcard.field_forbidWord = jSONObject.optString("balance_forbid_word");
        if (C5046bo.isNullOrNil(bankcard.field_forbidWord)) {
            bankcard.field_bankcardState = 0;
        } else {
            bankcard.field_bankcardState = 8;
        }
        bankcard.field_fetchArriveTime = jSONObject.optLong("fetch_arrive_time");
        bankcard.field_mobile = jSONObject.optString("mobile");
        if (jSONObject.optInt("support_micropay", 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        bankcard.field_support_micropay = z;
        C4990ab.m7416i("MicroMsg.WalletQueryBankcardParser", "getBalance() support_micropay:" + jSONObject.optInt("support_micropay", 0));
        bankcard.twV = jSONObject.optString("balance_list_url");
        C4990ab.m7417i("MicroMsg.WalletQueryBankcardParser", "carson balance_list_url: %s", bankcard.twV);
        str2 = C4996ah.getContext().getString(C25738R.string.f8d);
        bankcard.field_desc = str2;
        bankcard.field_bankName = str2;
        bankcard.field_bankcardTail = "10000";
        bankcard.field_forbid_title = jSONObject.optString("forbid_title");
        bankcard.field_forbid_url = jSONObject.optString("forbid_url");
        JSONObject optJSONObject = jSONObject.optJSONObject("balance_menu_info");
        if (optJSONObject != null) {
            C4990ab.m7411d("MicroMsg.WalletQueryBankcardParser", "balance menu info: %s", optJSONObject.toString());
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_BALANCE_MENU_INFO_STRING_SYNC, str2);
        } else {
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_BALANCE_MENU_INFO_STRING_SYNC, (Object) "");
        }
        AppMethodBeat.m2505o(46932);
        return bankcard;
    }

    /* renamed from: a */
    public static Bankcard m78517a(C44124gw c44124gw) {
        AppMethodBeat.m2504i(46933);
        C4990ab.m7417i("MicroMsg.WalletQueryBankcardParser", "Bankcard getBalance from balance info %s", c44124gw);
        Bankcard bankcard = null;
        if (c44124gw != null) {
            boolean z;
            bankcard = new Bankcard((byte) 0);
            C43804af.m78520a(bankcard, c44124gw.vJs, (long) c44124gw.vJt, C5046bo.getInt(c44124gw.vJo, 0));
            bankcard.twS = C36391e.m59996b(c44124gw.vJo, "100", RoundingMode.HALF_UP);
            bankcard.twT = c44124gw.twT;
            bankcard.twY = c44124gw.twY;
            bankcard.twZ = c44124gw.twZ;
            bankcard.twU = C36391e.m59996b(c44124gw.vJq, "100", RoundingMode.HALF_UP);
            bankcard.field_cardType |= Bankcard.twI;
            bankcard.field_bankcardType = c44124gw.vJk;
            bankcard.field_bindSerial = c44124gw.vJl;
            bankcard.field_forbidWord = c44124gw.vJm;
            if (C5046bo.isNullOrNil(bankcard.field_forbidWord)) {
                bankcard.field_bankcardState = 0;
            } else {
                bankcard.field_bankcardState = 8;
            }
            bankcard.field_mobile = c44124gw.cFl;
            if (C5046bo.getInt(c44124gw.vJr, 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            bankcard.field_support_micropay = z;
            C4990ab.m7416i("MicroMsg.WalletQueryBankcardParser", "getBalance() support_micropay:" + c44124gw.vJr);
            bankcard.twV = c44124gw.twV;
            String string = C4996ah.getContext().getString(C25738R.string.f8d);
            bankcard.field_desc = string;
            bankcard.field_bankName = string;
            bankcard.field_bankcardTail = "10000";
            bankcard.field_forbid_title = c44124gw.vJv;
            bankcard.field_forbid_url = c44124gw.vJw;
            C40523gx c40523gx = c44124gw.vJy;
            if (c40523gx != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("is_show_menu", c40523gx.vJz);
                    LinkedList<C46546gy> linkedList = c40523gx.vJA;
                    JSONArray jSONArray = new JSONArray();
                    for (C46546gy c46546gy : linkedList) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("title", c46546gy.title);
                        jSONObject2.put("jump_type", c46546gy.ttd);
                        jSONObject2.put("jump_h5_url", c46546gy.tte);
                        jSONObject2.put("tinyapp_username", c46546gy.tzW);
                        jSONObject2.put("tinyapp_path", c46546gy.ttg);
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put("balance_menu_item", jSONArray);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.WalletQueryBankcardParser", e, "Bankcard getBalance from balance, assemble menuInfoJson error: %s", e.getMessage());
                }
                C4990ab.m7411d("MicroMsg.WalletQueryBankcardParser", "balance menu info: %s", jSONObject.toString());
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_BALANCE_MENU_INFO_STRING_SYNC, jSONObject.toString());
            } else {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_BALANCE_MENU_INFO_STRING_SYNC, (Object) "");
            }
        }
        AppMethodBeat.m2505o(46933);
        return bankcard;
    }

    /* renamed from: a */
    public static C22590b m78519a(JSONObject jSONObject, boolean z) {
        int i = 0;
        AppMethodBeat.m2504i(46934);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.WalletQueryBankcardParser", "getBalanceFetchInfo(), json is null");
            AppMethodBeat.m2505o(46934);
            return null;
        }
        C4990ab.m7412e("MicroMsg.WalletQueryBankcardParser", "getBalanceFetchInfo(), json is valid");
        C22590b c22590b = new C22590b();
        c22590b.twx = jSONObject.optString("fetch_charge_title");
        C4990ab.m7416i("MicroMsg.WalletQueryBankcardParser", "fetch_charge_title:" + c22590b.twx);
        if (z) {
            C4990ab.m7416i("MicroMsg.WalletQueryBankcardParser", "isBindQuery true");
            c22590b.tgP = jSONObject.optInt("is_cal_charge", 0);
            c22590b.tgO = jSONObject.optInt("is_show_charge", 0);
            c22590b.tgQ = jSONObject.optInt("is_full_fetch_direct", 0);
            c22590b.tgR = C36391e.m59996b(jSONObject.optString("min_charge_fee", AppEventsConstants.EVENT_PARAM_VALUE_NO), "100", RoundingMode.HALF_UP);
            c22590b.pPt = C36391e.m59996b(jSONObject.optString("remain_fee", AppEventsConstants.EVENT_PARAM_VALUE_NO), "100", RoundingMode.HALF_UP);
            c22590b.twz = jSONObject.optString("card_list_wording_title", "");
            c22590b.twA = jSONObject.optString("card_list_wording_content", "");
            if (jSONObject.has("withdraw_sector")) {
                c22590b.twB = C22590b.m34291aq(jSONObject.optJSONObject("withdraw_sector"));
            }
            C4990ab.m7416i("MicroMsg.WalletQueryBankcardParser", " is_cal_charge:" + c22590b.tgP + " is_show_charge:" + c22590b.tgO + " min_charge_fee:" + c22590b.tgR + " remain_fee:" + c22590b.pPt + " is_full_fetch_direct:" + c22590b.tgQ);
        } else {
            C4990ab.m7416i("MicroMsg.WalletQueryBankcardParser", "isBindQuery false");
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("item");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            C4990ab.m7412e("MicroMsg.WalletQueryBankcardParser", "getBalanceFetchInfo(), itemJsonArray is null");
        } else {
            c22590b.twy = new LinkedList();
            while (i < optJSONArray.length()) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    C4393b c4393b = new C4393b();
                    c4393b.key = optJSONObject.optString("key");
                    c4393b.value = optJSONObject.optString("value");
                    C4990ab.m7416i("MicroMsg.WalletQueryBankcardParser", "feeItem.key is " + c4393b.key + " , feeItem.value is " + c4393b.value);
                    if (!(TextUtils.isEmpty(c4393b.key) || TextUtils.isEmpty(c4393b.value))) {
                        c22590b.twy.add(c4393b);
                    }
                } else {
                    C4990ab.m7412e("MicroMsg.WalletQueryBankcardParser", "item index " + i + " is empty");
                }
                i++;
            }
            C4990ab.m7416i("MicroMsg.WalletQueryBankcardParser", "itemsList size is " + c22590b.twy.size());
        }
        AppMethodBeat.m2505o(46934);
        return c22590b;
    }

    /* renamed from: a */
    private static void m78520a(Bankcard bankcard, long j, long j2, int i) {
        AppMethodBeat.m2504i(46935);
        final long j3 = j2;
        final long j4 = j;
        final int i2 = i;
        final Bankcard bankcard2 = bankcard;
        C36391e.m59988a(new String[]{"wallet_balance_version", "wallet_balance_last_update_time", "wallet_balance"}, new C30881a() {
            /* renamed from: ak */
            public final void mo49394ak(Map<String, Object> map) {
                AppMethodBeat.m2504i(46926);
                if (map != null) {
                    long a = C5046bo.m7514a((Long) map.get("wallet_balance_version"), -1);
                    long a2 = C5046bo.m7514a((Long) map.get("wallet_balance_last_update_time"), -1);
                    if (a2 < 0 || a < 0 || a2 + j3 > C5046bo.m7588yz() || j4 >= a) {
                        C36391e.m59987a(new C30882c("wallet_balance_version", Long.valueOf(j4)), new C30882c("wallet_balance_last_update_time", Long.valueOf(C5046bo.m7588yz())), new C30882c("wallet_balance", Double.valueOf(((double) i2) / 100.0d)));
                        bankcard2.twS = ((double) i2) / 100.0d;
                        AppMethodBeat.m2505o(46926);
                        return;
                    }
                    C4990ab.m7420w("MicroMsg.WalletQueryBankcardParser", "hy: new balance comes but last msg is not timeout and balance version is smaller than before");
                }
                AppMethodBeat.m2505o(46926);
            }
        });
        AppMethodBeat.m2505o(46935);
    }

    /* renamed from: z */
    private static ArrayList<Bankcard> m78528z(JSONArray jSONArray) {
        AppMethodBeat.m2504i(46936);
        C4990ab.m7416i("MicroMsg.WalletQueryBankcardParser", "getBankcards()");
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                Bankcard ar = C29630d.cPh().mo38120ar(jSONArray.getJSONObject(i));
                if (ar != null) {
                    C29630d.m46997e(ar);
                    arrayList.add(ar);
                }
            }
        }
        AppMethodBeat.m2505o(46936);
        return arrayList;
    }

    /* renamed from: A */
    private static ArrayList<Bankcard> m78514A(JSONArray jSONArray) {
        AppMethodBeat.m2504i(46937);
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                Bankcard bankcard = new Bankcard();
                bankcard.field_cardType |= Bankcard.twH;
                bankcard.field_bankName = jSONObject.getString("bank_name");
                bankcard.field_bankcardType = jSONObject.getString("bank_type");
                bankcard.field_bankcardTypeName = jSONObject.optString("bankacc_type_name");
                bankcard.twO = jSONObject.getString("card_id");
                bankcard.field_bizUsername = jSONObject.getString("app_username");
                bankcard.field_wxcreditState = jSONObject.getInt("card_status");
                if (bankcard.field_wxcreditState != 2) {
                    bankcard.field_bankcardState = 9;
                } else {
                    bankcard.field_bankcardState = 0;
                }
                bankcard.field_desc = C4996ah.getContext().getString(C25738R.string.fwm, new Object[]{bankcard.field_bankName, bankcard.field_bankcardTail});
                bankcard.txc = new C43807e();
                bankcard.txc.oRi = jSONObject.getString("logo_url");
                bankcard.txc.txp = jSONObject.getString("background_logo_url");
                bankcard.txc.txq = jSONObject.getString("big_logo_url");
                arrayList.add(bankcard);
            }
        }
        AppMethodBeat.m2505o(46937);
        return arrayList;
    }

    /* renamed from: B */
    private static Bankcard m78515B(JSONArray jSONArray) {
        AppMethodBeat.m2504i(46938);
        if (jSONArray == null || jSONArray.length() <= 0) {
            C4990ab.m7412e("MicroMsg.WalletQueryBankcardParser", "getHistroyBankcard() json == null or json.length() == 0");
            AppMethodBeat.m2505o(46938);
            return null;
        }
        Bankcard ar = C29630d.cPh().mo38120ar(jSONArray.getJSONObject(0));
        ar.field_cardType |= Bankcard.twJ;
        AppMethodBeat.m2505o(46938);
        return ar;
    }

    /* renamed from: aH */
    private static C40114n m78526aH(JSONObject jSONObject) {
        AppMethodBeat.m2504i(46939);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.WalletQueryBankcardParser", "getLoanEntryInfo json is null");
            AppMethodBeat.m2505o(46939);
            return null;
        }
        C4990ab.m7416i("MicroMsg.WalletQueryBankcardParser", "getLoanEntryInfo()");
        C40114n c40114n = new C40114n();
        c40114n.field_title = jSONObject.optString("title");
        c40114n.field_loan_jump_url = jSONObject.optString("loan_jump_url");
        C4990ab.m7416i("MicroMsg.WalletQueryBankcardParser", "getLoanEntryInfo() field_loan_jump_url:" + c40114n.field_loan_jump_url);
        c40114n.field_is_show_entry = jSONObject.optInt("is_show_entry", 0);
        c40114n.field_tips = jSONObject.optString("tips");
        c40114n.field_is_overdue = jSONObject.optInt("is_overdue", 0);
        if (jSONObject.has("available_otb")) {
            c40114n.field_available_otb = C36391e.m60006e(jSONObject.optDouble("available_otb") / 100.0d, "CNY");
        }
        if (jSONObject.has(C8741b.INDEX)) {
            c40114n.field_red_dot_index = jSONObject.optInt(C8741b.INDEX);
        }
        C4990ab.m7416i("MicroMsg.WalletQueryBankcardParser", "getLoanEntryInfo() field_index:" + c40114n.field_red_dot_index + "  field_is_overdue:" + c40114n.field_is_overdue + "  field_is_show_entry:" + c40114n.field_is_show_entry);
        AppMethodBeat.m2505o(46939);
        return c40114n;
    }

    /* renamed from: aI */
    private static Bankcard m78527aI(JSONObject jSONObject) {
        boolean z = true;
        AppMethodBeat.m2504i(46940);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.WalletQueryBankcardParser", "getLqtInfo, json object is null!");
            AppMethodBeat.m2505o(46940);
            return null;
        }
        C4990ab.m7417i("MicroMsg.WalletQueryBankcardParser", "now get getLqtInfo: %s", jSONObject.toString());
        Bankcard bankcard = new Bankcard((byte) 0);
        bankcard.field_bankcardType = jSONObject.optString("lqt_bank_type");
        bankcard.field_bindSerial = jSONObject.optString("lqt_bind_serial");
        bankcard.field_bankName = jSONObject.optString("lqt_bank_name");
        bankcard.twS = ((double) jSONObject.optLong("total_balance")) / 100.0d;
        bankcard.twU = ((double) jSONObject.optLong("avail_balance")) / 100.0d;
        bankcard.txc = new C43807e();
        bankcard.txc.oRi = jSONObject.optString("lqt_logo_url");
        bankcard.field_forbidWord = jSONObject.optString("lqt_forbid_word");
        bankcard.field_forbid_title = jSONObject.optString("forbid_title");
        bankcard.field_forbid_url = jSONObject.optString("forbid_url");
        bankcard.twT = jSONObject.optString("lqt_show_wording");
        bankcard.field_mobile = jSONObject.optString("mobile");
        if (jSONObject.optInt("support_micropay", 0) != 1) {
            z = false;
        }
        bankcard.field_support_micropay = z;
        bankcard.field_cardType |= Bankcard.twL;
        if (C5046bo.isNullOrNil(bankcard.field_bankName)) {
            bankcard.field_bankName = C4996ah.getContext().getString(C25738R.string.fk0);
        }
        bankcard.field_desc = bankcard.field_bankName;
        if (C5046bo.isNullOrNil(bankcard.field_forbidWord)) {
            bankcard.field_bankcardState = 0;
        } else {
            bankcard.field_bankcardState = 8;
        }
        AppMethodBeat.m2505o(46940);
        return bankcard;
    }
}
