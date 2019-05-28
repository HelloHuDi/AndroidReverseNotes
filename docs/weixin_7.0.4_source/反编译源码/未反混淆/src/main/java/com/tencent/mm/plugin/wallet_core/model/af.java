package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.b.b;
import com.tencent.mm.protocal.protobuf.gw;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.protocal.protobuf.gy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.e.c;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class af {
    public static void a(JSONObject jSONObject, int i, boolean z) {
        AppMethodBeat.i(46927);
        ab.i("MicroMsg.WalletQueryBankcardParser", "parseQueryBankcard(): %s, %s", Integer.valueOf(i), Boolean.valueOf(z));
        try {
            JSONObject optJSONObject;
            long optLong = jSONObject.optLong("time_stamp");
            if (optLong > 0) {
                w.setTimeStamp(String.valueOf(optLong));
            } else {
                ab.w("MicroMsg.WalletQueryBankcardParser", "no time_stamp at WalletQueryBankcardParser.");
            }
            aj a = a(jSONObject.getJSONObject("user_info"), i);
            if (z) {
                a.field_switchConfig = jSONObject.getJSONObject("switch_info").getInt("switch_bit");
            } else {
                a.field_switchConfig = r.cPE().cRh().field_switchConfig;
            }
            a.field_paymenu_use_new = jSONObject.optInt("paymenu_use_new");
            ab.i("MicroMsg.WalletQueryBankcardParser", "parseQueryBankcard, paymenu_use_new: %s", Integer.valueOf(a.field_paymenu_use_new));
            String optString = jSONObject.optString("support_bank_word");
            g.RQ();
            g.RP().Ry().set(a.USERINFO_WALLET_SUPPORT_BANK_WORD_STRING, bo.nullAsNil(optString));
            ArrayList z2 = z(jSONObject.optJSONArray("Array"));
            ArrayList A = A(jSONObject.optJSONArray("virtual_card_array"));
            Bankcard aG = aG(jSONObject.optJSONObject("balance_info"));
            if (aG != null && i == 10) {
                ab.i("MicroMsg.WalletQueryBankcardParser", "carson: entry_url: %s、entry_word：%s", aG.twW, aG.twX);
                optJSONObject = jSONObject.optJSONObject("bill_entry");
                if (optJSONObject != null) {
                    aG.twW = optJSONObject.optString("entry_url");
                    aG.twX = optJSONObject.optString("entry_word");
                }
            }
            ab.i("MicroMsg.WalletQueryBankcardParser", "hy: cache time: %d", Integer.valueOf(jSONObject.optInt("query_cache_time")));
            optJSONObject = jSONObject.optJSONObject("complex_switch_info");
            if (optJSONObject != null) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("bind_newcard_switch");
                optJSONObject2.optInt("forbid_bind_card");
                optJSONObject2.optString("forbid_word");
            }
            g.cPl().at(optJSONObject);
            Bankcard B = B(jSONObject.optJSONArray("history_card_array"));
            aF(jSONObject);
            optJSONObject = jSONObject.optJSONObject("bank_priority");
            if (optJSONObject != null) {
                a.field_bank_priority = optJSONObject.toString();
            }
            List aE = aE(optJSONObject);
            a.field_unipay_order_state = jSONObject.optInt("unipayorderstate", 0);
            a(jSONObject, a, z);
            jSONObject.optString("query_order_time");
            n aH = aH(jSONObject.optJSONObject("loan_entry_info"));
            optJSONObject = jSONObject.optJSONObject("fetch_info");
            b bVar = r.cPI().tCX;
            ab.d("MicroMsg.WalletQueryBankcardParser", "fetchInfo: %s", bVar);
            if (optJSONObject != null) {
                bVar = a(optJSONObject, true);
            } else {
                ab.e("MicroMsg.WalletQueryBankcardParser", "parseQueryBankcard() fetch_info is null");
            }
            Bankcard aI = aI(jSONObject.optJSONObject("lqt_info"));
            if (i == 4) {
                ab.d("MicroMsg.WalletQueryBankcardParser", "update fetch scene data");
                r.cPI().tgW = jSONObject.optInt("is_use_dynamic_free_fee");
                r.cPI().tgX = jSONObject.optInt("dynamic_free_fee_hold_time");
            }
            r.cPI().a(a, z2, A, aG, B, aH, bVar, aI, r11, i, aE);
            AppMethodBeat.o(46927);
        } catch (Exception e) {
            ab.e("MicroMsg.WalletQueryBankcardParser", "parseQueryBankcard Exception :" + e.getMessage());
            ab.printErrStackTrace("MicroMsg.WalletQueryBankcardParser", e, "", new Object[0]);
            AppMethodBeat.o(46927);
        }
    }

    public static List<c> aE(JSONObject jSONObject) {
        AppMethodBeat.i(46928);
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("bankinfo_array");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        c cVar = new c();
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        cVar.pbo = jSONObject2.optString("bind_serial");
                        cVar.twE = jSONObject2.optString("polling_forbid_word");
                        arrayList.add(cVar);
                    }
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.WalletQueryBankcardParser", e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(46928);
        return arrayList;
    }

    private static void a(JSONObject jSONObject, aj ajVar, boolean z) {
        AppMethodBeat.i(46929);
        if (z) {
            JSONObject optJSONObject = jSONObject.optJSONObject("wallet_info");
            if (optJSONObject != null) {
                ajVar.field_wallet_balance = optJSONObject.optLong("wallet_balance", -1);
                ajVar.field_wallet_entrance_balance_switch_state = optJSONObject.optInt("wallet_entrance_balance_switch_state", -1);
            }
            AppMethodBeat.o(46929);
            return;
        }
        ajVar.field_wallet_balance = r.cPE().cRh().field_wallet_balance;
        ajVar.field_wallet_entrance_balance_switch_state = r.cPE().cRh().field_wallet_entrance_balance_switch_state;
        AppMethodBeat.o(46929);
    }

    public static boolean Hr(int i) {
        if (i == 9 || i == 10 || i == 11 || i == 12 || i == 13 || i == 14 || i == 15 || i == 16 || i == 17 || i == 18 || i == 19 || i == 20 || i == 21 || i == 22 || i == 23) {
            return true;
        }
        return false;
    }

    private static void aF(JSONObject jSONObject) {
        Object bc;
        Object bc2;
        AppMethodBeat.i(46930);
        JSONArray optJSONArray = jSONObject.optJSONArray("balance_notice");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("fetch_notice");
        if (optJSONArray != null) {
            bc = bo.bc(optJSONArray.toString(), "");
        } else {
            String bc3 = "";
        }
        if (optJSONArray2 != null) {
            bc2 = bo.bc(optJSONArray2.toString(), "");
        } else {
            bc2 = "";
        }
        ab.i("MicroMsg.WalletQueryBankcardParser", "hy: balance notice: %s, fetchNotice: %s", bc3, bc2);
        g.RQ();
        g.RP().Ry().set(a.USERINFO_WALLET_BALANCE_NOTICE_STRING, bc3);
        g.RQ();
        g.RP().Ry().set(a.USERINFO_WALLET_FETCH_NOTICE_STRING, bc2);
        g.RQ();
        g.RP().Ry().dsb();
        AppMethodBeat.o(46930);
    }

    private static aj a(JSONObject jSONObject, int i) {
        AppMethodBeat.i(46931);
        ab.i("MicroMsg.WalletQueryBankcardParser", "getUserInfo()");
        aj ajVar = new aj();
        if (jSONObject == null || jSONObject.length() <= 0) {
            ab.e("MicroMsg.WalletQueryBankcardParser", "getUserInfo() json == null or json.length() == 0");
            AppMethodBeat.o(46931);
            return null;
        }
        ajVar.field_is_reg = jSONObject.getInt("is_reg");
        ajVar.field_true_name = jSONObject.optString("true_name");
        ajVar.field_cre_type = jSONObject.optInt("cre_type", -1);
        ajVar.field_main_card_bind_serialno = jSONObject.optString("last_card_bind_serialno");
        ajVar.field_cre_name = jSONObject.optString("cre_name");
        ajVar.field_ftf_pay_url = jSONObject.optString("transfer_url");
        ajVar.field_reset_passwd_flag = jSONObject.optString("reset_passwd_flag");
        ajVar.field_find_passwd_url = jSONObject.optString("reset_passwd_url");
        ajVar.field_forget_passwd_url = jSONObject.optString("forget_passwd_url");
        r.cPI();
        ak.acD(ajVar.field_main_card_bind_serialno);
        ajVar.field_isDomesticUser = "2".equals(jSONObject.optString("icard_user_flag", "2"));
        JSONObject optJSONObject = jSONObject.optJSONObject("touch_info");
        if (optJSONObject != null) {
            ajVar.field_is_open_touch = optJSONObject.optInt("is_open_touch", 0);
            ajVar.field_soter_pay_open_type = optJSONObject.optInt("soter_pay_open_type", 0);
            ab.d("MicroMsg.WalletQueryBankcardParser", "getUserInfo field_is_open_touch() is %s, %s", Integer.valueOf(ajVar.field_is_open_touch), Integer.valueOf(ajVar.field_soter_pay_open_type));
        } else {
            int i2;
            ab.e("MicroMsg.WalletQueryBankcardParser", "touch_info is null ");
            if (r.cPI().cQk()) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            ajVar.field_is_open_touch = i2;
            ajVar.field_soter_pay_open_type = r.cPI().cQm();
            ab.e("MicroMsg.WalletQueryBankcardParser", "old field_is_open_touch is " + ajVar.field_is_open_touch);
        }
        ajVar.field_lct_wording = jSONObject.optString("lct_wording");
        ajVar.field_lct_url = jSONObject.optString("lct_url");
        ab.i("MicroMsg.WalletQueryBankcardParser", "field_lct_wording: " + ajVar.field_lct_wording + ", field_lct_url:" + ajVar.field_lct_url);
        ajVar.field_lqt_state = jSONObject.optInt("lqt_state", -1);
        optJSONObject = jSONObject.optJSONObject("lqb_show_info");
        ab.i("MicroMsg.WalletQueryBankcardParser", "field_lqt_state: %s, lqb_show_info: %s", Integer.valueOf(ajVar.field_lqt_state), optJSONObject);
        if (optJSONObject != null) {
            ajVar.field_is_show_lqb = optJSONObject.optInt("is_show_lqb");
            ajVar.field_is_open_lqb = optJSONObject.optInt("is_open_lqb");
            ajVar.field_lqb_open_url = optJSONObject.optString("lqb_open_url");
        }
        optJSONObject = jSONObject.optJSONObject("lqt_cell_info");
        ab.i("MicroMsg.WalletQueryBankcardParser", "lqt_cell_info: %s", optJSONObject);
        if (optJSONObject != null) {
            ajVar.field_lqt_cell_is_show = optJSONObject.optInt("is_show_cell");
            ajVar.field_lqt_cell_icon = optJSONObject.optString("cell_icon");
            ajVar.field_lqt_cell_is_open_lqt = optJSONObject.optInt("is_open_lqt");
            ajVar.field_lqt_cell_lqt_open_url = optJSONObject.optString("lqt_open_url");
            ajVar.field_lqt_cell_lqt_title = optJSONObject.optString("lqt_title");
            ajVar.field_lqt_cell_lqt_wording = optJSONObject.optString("lqt_wording");
        }
        if (Hr(i) || i == 3 || i == 4) {
            g.RQ();
            g.RP().Ry().set(a.USERINFO_WALLET_LQT_OPEN_FLAG_INT_SYNC, Integer.valueOf(ajVar.field_lqt_state));
            g.RQ();
            g.RP().Ry().set(a.USERINFO_WALLET_LQT_ENTRY_WORDING_STRING_SYNC, ajVar.field_lct_wording);
        }
        AppMethodBeat.o(46931);
        return ajVar;
    }

    private static Bankcard aG(JSONObject jSONObject) {
        String str;
        Object str2;
        AppMethodBeat.i(46932);
        String str3 = "MicroMsg.WalletQueryBankcardParser";
        String str4 = "Bankcard getBalance %s";
        Object[] objArr = new Object[1];
        if (jSONObject == null) {
            str2 = "";
        } else {
            str2 = jSONObject;
        }
        objArr[0] = str2;
        ab.i(str3, str4, objArr);
        if (jSONObject == null || jSONObject.length() <= 0) {
            ab.i("MicroMsg.WalletQueryBankcardParser", "getBalance() json == null or json.length() == 0");
            AppMethodBeat.o(46932);
            return null;
        }
        boolean z;
        Bankcard bankcard = new Bankcard((byte) 0);
        a(bankcard, jSONObject.optLong("balance_version", -1), jSONObject.optLong("time_out", 7200), jSONObject.optInt("avail_balance"));
        bankcard.twS = e.b(jSONObject.optString("avail_balance", AppEventsConstants.EVENT_PARAM_VALUE_NO), "100", RoundingMode.HALF_UP);
        bankcard.twT = jSONObject.optString("balance_show_wording");
        bankcard.twY = jSONObject.optString("max_fetch_wording");
        bankcard.twZ = jSONObject.optString("avail_fetch_wording");
        bankcard.twU = e.b(jSONObject.optString("fetch_balance", AppEventsConstants.EVENT_PARAM_VALUE_NO), "100", RoundingMode.HALF_UP);
        bankcard.field_cardType |= Bankcard.twI;
        bankcard.field_bankcardType = jSONObject.optString("balance_bank_type");
        bankcard.field_bindSerial = jSONObject.optString("balance_bind_serial");
        bankcard.field_forbidWord = jSONObject.optString("balance_forbid_word");
        if (bo.isNullOrNil(bankcard.field_forbidWord)) {
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
        ab.i("MicroMsg.WalletQueryBankcardParser", "getBalance() support_micropay:" + jSONObject.optInt("support_micropay", 0));
        bankcard.twV = jSONObject.optString("balance_list_url");
        ab.i("MicroMsg.WalletQueryBankcardParser", "carson balance_list_url: %s", bankcard.twV);
        str2 = ah.getContext().getString(R.string.f8d);
        bankcard.field_desc = str2;
        bankcard.field_bankName = str2;
        bankcard.field_bankcardTail = "10000";
        bankcard.field_forbid_title = jSONObject.optString("forbid_title");
        bankcard.field_forbid_url = jSONObject.optString("forbid_url");
        JSONObject optJSONObject = jSONObject.optJSONObject("balance_menu_info");
        if (optJSONObject != null) {
            ab.d("MicroMsg.WalletQueryBankcardParser", "balance menu info: %s", optJSONObject.toString());
            g.RP().Ry().set(a.USERINFO_WALLET_BALANCE_MENU_INFO_STRING_SYNC, str2);
        } else {
            g.RP().Ry().set(a.USERINFO_WALLET_BALANCE_MENU_INFO_STRING_SYNC, (Object) "");
        }
        AppMethodBeat.o(46932);
        return bankcard;
    }

    public static Bankcard a(gw gwVar) {
        AppMethodBeat.i(46933);
        ab.i("MicroMsg.WalletQueryBankcardParser", "Bankcard getBalance from balance info %s", gwVar);
        Bankcard bankcard = null;
        if (gwVar != null) {
            boolean z;
            bankcard = new Bankcard((byte) 0);
            a(bankcard, gwVar.vJs, (long) gwVar.vJt, bo.getInt(gwVar.vJo, 0));
            bankcard.twS = e.b(gwVar.vJo, "100", RoundingMode.HALF_UP);
            bankcard.twT = gwVar.twT;
            bankcard.twY = gwVar.twY;
            bankcard.twZ = gwVar.twZ;
            bankcard.twU = e.b(gwVar.vJq, "100", RoundingMode.HALF_UP);
            bankcard.field_cardType |= Bankcard.twI;
            bankcard.field_bankcardType = gwVar.vJk;
            bankcard.field_bindSerial = gwVar.vJl;
            bankcard.field_forbidWord = gwVar.vJm;
            if (bo.isNullOrNil(bankcard.field_forbidWord)) {
                bankcard.field_bankcardState = 0;
            } else {
                bankcard.field_bankcardState = 8;
            }
            bankcard.field_mobile = gwVar.cFl;
            if (bo.getInt(gwVar.vJr, 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            bankcard.field_support_micropay = z;
            ab.i("MicroMsg.WalletQueryBankcardParser", "getBalance() support_micropay:" + gwVar.vJr);
            bankcard.twV = gwVar.twV;
            String string = ah.getContext().getString(R.string.f8d);
            bankcard.field_desc = string;
            bankcard.field_bankName = string;
            bankcard.field_bankcardTail = "10000";
            bankcard.field_forbid_title = gwVar.vJv;
            bankcard.field_forbid_url = gwVar.vJw;
            gx gxVar = gwVar.vJy;
            if (gxVar != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("is_show_menu", gxVar.vJz);
                    LinkedList<gy> linkedList = gxVar.vJA;
                    JSONArray jSONArray = new JSONArray();
                    for (gy gyVar : linkedList) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("title", gyVar.title);
                        jSONObject2.put("jump_type", gyVar.ttd);
                        jSONObject2.put("jump_h5_url", gyVar.tte);
                        jSONObject2.put("tinyapp_username", gyVar.tzW);
                        jSONObject2.put("tinyapp_path", gyVar.ttg);
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put("balance_menu_item", jSONArray);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.WalletQueryBankcardParser", e, "Bankcard getBalance from balance, assemble menuInfoJson error: %s", e.getMessage());
                }
                ab.d("MicroMsg.WalletQueryBankcardParser", "balance menu info: %s", jSONObject.toString());
                g.RP().Ry().set(a.USERINFO_WALLET_BALANCE_MENU_INFO_STRING_SYNC, jSONObject.toString());
            } else {
                g.RP().Ry().set(a.USERINFO_WALLET_BALANCE_MENU_INFO_STRING_SYNC, (Object) "");
            }
        }
        AppMethodBeat.o(46933);
        return bankcard;
    }

    public static b a(JSONObject jSONObject, boolean z) {
        int i = 0;
        AppMethodBeat.i(46934);
        if (jSONObject == null) {
            ab.e("MicroMsg.WalletQueryBankcardParser", "getBalanceFetchInfo(), json is null");
            AppMethodBeat.o(46934);
            return null;
        }
        ab.e("MicroMsg.WalletQueryBankcardParser", "getBalanceFetchInfo(), json is valid");
        b bVar = new b();
        bVar.twx = jSONObject.optString("fetch_charge_title");
        ab.i("MicroMsg.WalletQueryBankcardParser", "fetch_charge_title:" + bVar.twx);
        if (z) {
            ab.i("MicroMsg.WalletQueryBankcardParser", "isBindQuery true");
            bVar.tgP = jSONObject.optInt("is_cal_charge", 0);
            bVar.tgO = jSONObject.optInt("is_show_charge", 0);
            bVar.tgQ = jSONObject.optInt("is_full_fetch_direct", 0);
            bVar.tgR = e.b(jSONObject.optString("min_charge_fee", AppEventsConstants.EVENT_PARAM_VALUE_NO), "100", RoundingMode.HALF_UP);
            bVar.pPt = e.b(jSONObject.optString("remain_fee", AppEventsConstants.EVENT_PARAM_VALUE_NO), "100", RoundingMode.HALF_UP);
            bVar.twz = jSONObject.optString("card_list_wording_title", "");
            bVar.twA = jSONObject.optString("card_list_wording_content", "");
            if (jSONObject.has("withdraw_sector")) {
                bVar.twB = b.aq(jSONObject.optJSONObject("withdraw_sector"));
            }
            ab.i("MicroMsg.WalletQueryBankcardParser", " is_cal_charge:" + bVar.tgP + " is_show_charge:" + bVar.tgO + " min_charge_fee:" + bVar.tgR + " remain_fee:" + bVar.pPt + " is_full_fetch_direct:" + bVar.tgQ);
        } else {
            ab.i("MicroMsg.WalletQueryBankcardParser", "isBindQuery false");
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("item");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            ab.e("MicroMsg.WalletQueryBankcardParser", "getBalanceFetchInfo(), itemJsonArray is null");
        } else {
            bVar.twy = new LinkedList();
            while (i < optJSONArray.length()) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    b bVar2 = new b();
                    bVar2.key = optJSONObject.optString("key");
                    bVar2.value = optJSONObject.optString("value");
                    ab.i("MicroMsg.WalletQueryBankcardParser", "feeItem.key is " + bVar2.key + " , feeItem.value is " + bVar2.value);
                    if (!(TextUtils.isEmpty(bVar2.key) || TextUtils.isEmpty(bVar2.value))) {
                        bVar.twy.add(bVar2);
                    }
                } else {
                    ab.e("MicroMsg.WalletQueryBankcardParser", "item index " + i + " is empty");
                }
                i++;
            }
            ab.i("MicroMsg.WalletQueryBankcardParser", "itemsList size is " + bVar.twy.size());
        }
        AppMethodBeat.o(46934);
        return bVar;
    }

    private static void a(Bankcard bankcard, long j, long j2, int i) {
        AppMethodBeat.i(46935);
        final long j3 = j2;
        final long j4 = j;
        final int i2 = i;
        final Bankcard bankcard2 = bankcard;
        e.a(new String[]{"wallet_balance_version", "wallet_balance_last_update_time", "wallet_balance"}, new e.a() {
            public final void ak(Map<String, Object> map) {
                AppMethodBeat.i(46926);
                if (map != null) {
                    long a = bo.a((Long) map.get("wallet_balance_version"), -1);
                    long a2 = bo.a((Long) map.get("wallet_balance_last_update_time"), -1);
                    if (a2 < 0 || a < 0 || a2 + j3 > bo.yz() || j4 >= a) {
                        e.a(new c("wallet_balance_version", Long.valueOf(j4)), new c("wallet_balance_last_update_time", Long.valueOf(bo.yz())), new c("wallet_balance", Double.valueOf(((double) i2) / 100.0d)));
                        bankcard2.twS = ((double) i2) / 100.0d;
                        AppMethodBeat.o(46926);
                        return;
                    }
                    ab.w("MicroMsg.WalletQueryBankcardParser", "hy: new balance comes but last msg is not timeout and balance version is smaller than before");
                }
                AppMethodBeat.o(46926);
            }
        });
        AppMethodBeat.o(46935);
    }

    private static ArrayList<Bankcard> z(JSONArray jSONArray) {
        AppMethodBeat.i(46936);
        ab.i("MicroMsg.WalletQueryBankcardParser", "getBankcards()");
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                Bankcard ar = d.cPh().ar(jSONArray.getJSONObject(i));
                if (ar != null) {
                    d.e(ar);
                    arrayList.add(ar);
                }
            }
        }
        AppMethodBeat.o(46936);
        return arrayList;
    }

    private static ArrayList<Bankcard> A(JSONArray jSONArray) {
        AppMethodBeat.i(46937);
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
                bankcard.field_desc = ah.getContext().getString(R.string.fwm, new Object[]{bankcard.field_bankName, bankcard.field_bankcardTail});
                bankcard.txc = new e();
                bankcard.txc.oRi = jSONObject.getString("logo_url");
                bankcard.txc.txp = jSONObject.getString("background_logo_url");
                bankcard.txc.txq = jSONObject.getString("big_logo_url");
                arrayList.add(bankcard);
            }
        }
        AppMethodBeat.o(46937);
        return arrayList;
    }

    private static Bankcard B(JSONArray jSONArray) {
        AppMethodBeat.i(46938);
        if (jSONArray == null || jSONArray.length() <= 0) {
            ab.e("MicroMsg.WalletQueryBankcardParser", "getHistroyBankcard() json == null or json.length() == 0");
            AppMethodBeat.o(46938);
            return null;
        }
        Bankcard ar = d.cPh().ar(jSONArray.getJSONObject(0));
        ar.field_cardType |= Bankcard.twJ;
        AppMethodBeat.o(46938);
        return ar;
    }

    private static n aH(JSONObject jSONObject) {
        AppMethodBeat.i(46939);
        if (jSONObject == null) {
            ab.e("MicroMsg.WalletQueryBankcardParser", "getLoanEntryInfo json is null");
            AppMethodBeat.o(46939);
            return null;
        }
        ab.i("MicroMsg.WalletQueryBankcardParser", "getLoanEntryInfo()");
        n nVar = new n();
        nVar.field_title = jSONObject.optString("title");
        nVar.field_loan_jump_url = jSONObject.optString("loan_jump_url");
        ab.i("MicroMsg.WalletQueryBankcardParser", "getLoanEntryInfo() field_loan_jump_url:" + nVar.field_loan_jump_url);
        nVar.field_is_show_entry = jSONObject.optInt("is_show_entry", 0);
        nVar.field_tips = jSONObject.optString("tips");
        nVar.field_is_overdue = jSONObject.optInt("is_overdue", 0);
        if (jSONObject.has("available_otb")) {
            nVar.field_available_otb = e.e(jSONObject.optDouble("available_otb") / 100.0d, "CNY");
        }
        if (jSONObject.has(FirebaseAnalytics.b.INDEX)) {
            nVar.field_red_dot_index = jSONObject.optInt(FirebaseAnalytics.b.INDEX);
        }
        ab.i("MicroMsg.WalletQueryBankcardParser", "getLoanEntryInfo() field_index:" + nVar.field_red_dot_index + "  field_is_overdue:" + nVar.field_is_overdue + "  field_is_show_entry:" + nVar.field_is_show_entry);
        AppMethodBeat.o(46939);
        return nVar;
    }

    private static Bankcard aI(JSONObject jSONObject) {
        boolean z = true;
        AppMethodBeat.i(46940);
        if (jSONObject == null) {
            ab.e("MicroMsg.WalletQueryBankcardParser", "getLqtInfo, json object is null!");
            AppMethodBeat.o(46940);
            return null;
        }
        ab.i("MicroMsg.WalletQueryBankcardParser", "now get getLqtInfo: %s", jSONObject.toString());
        Bankcard bankcard = new Bankcard((byte) 0);
        bankcard.field_bankcardType = jSONObject.optString("lqt_bank_type");
        bankcard.field_bindSerial = jSONObject.optString("lqt_bind_serial");
        bankcard.field_bankName = jSONObject.optString("lqt_bank_name");
        bankcard.twS = ((double) jSONObject.optLong("total_balance")) / 100.0d;
        bankcard.twU = ((double) jSONObject.optLong("avail_balance")) / 100.0d;
        bankcard.txc = new e();
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
        if (bo.isNullOrNil(bankcard.field_bankName)) {
            bankcard.field_bankName = ah.getContext().getString(R.string.fk0);
        }
        bankcard.field_desc = bankcard.field_bankName;
        if (bo.isNullOrNil(bankcard.field_forbidWord)) {
            bankcard.field_bankcardState = 0;
        } else {
            bankcard.field_bankcardState = 8;
        }
        AppMethodBeat.o(46940);
        return bankcard;
    }
}
