package com.tencent.mm.plugin.offline.c;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.model.bk;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelpay.JumpToOfflinePay.Resp;
import com.tencent.mm.plugin.offline.a.s.f;
import com.tencent.mm.plugin.offline.h;
import com.tencent.mm.plugin.offline.j;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wallet_core.model.Orders.RecommendTinyAppInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.ShowInfo;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import d.a.a.c;
import d.a.a.e;
import d.a.a.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static String kaE = "";
    private static String paY = "";
    public static String paZ = "";
    public static int pba = 1;
    public static String pbb = "";
    public static String pbc = "";
    public static String pbd = "";
    public static int pbe = 1;
    public static int pbf = 0;
    public static long pbg = 0;
    public static boolean pbh = false;
    public static String pbi = "";
    public static String pbj = "";
    private static Comparator<Bankcard> pbk = new Comparator<Bankcard>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.i(43650);
            int compareToIgnoreCase = ((Bankcard) obj).field_bindSerial.compareToIgnoreCase(((Bankcard) obj2).field_bindSerial);
            AppMethodBeat.o(43650);
            return compareToIgnoreCase;
        }
    };
    private static Comparator<a> pbl = new Comparator<a>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.i(43651);
            int compareToIgnoreCase = ((a) obj).pbo.compareToIgnoreCase(((a) obj2).pbo);
            AppMethodBeat.o(43651);
            return compareToIgnoreCase;
        }
    };

    public static class b {
        public String kKZ;
        public String pbn;
    }

    public static class a {
        public int pbm;
        public String pbn;
        public String pbo;
        public String pbp;
    }

    static {
        AppMethodBeat.i(43721);
        AppMethodBeat.o(43721);
    }

    public static boolean bYd() {
        AppMethodBeat.i(43652);
        k.bXg();
        String Ax = k.Ax(196630);
        if (Ax == null || !Ax.equals("1")) {
            AppMethodBeat.o(43652);
            return false;
        }
        AppMethodBeat.o(43652);
        return true;
    }

    public static boolean bYe() {
        AppMethodBeat.i(43653);
        k.bXg();
        String Ax = k.Ax(196641);
        if (Ax == null || !Ax.equals("1")) {
            AppMethodBeat.o(43653);
            return false;
        }
        AppMethodBeat.o(43653);
        return true;
    }

    public static Bankcard bYg() {
        AppMethodBeat.i(43655);
        Bankcard bYf = bYf();
        if (bYf != null && bYf.field_support_micropay && bo.isNullOrNil(bYf.field_forbidWord)) {
            AppMethodBeat.o(43655);
            return bYf;
        }
        ArrayList nf = r.cPI().nf(true);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < nf.size()) {
                bYf = (Bankcard) nf.get(i2);
                if (bYf == null || !bYf.field_support_micropay) {
                    i = i2 + 1;
                } else {
                    AppMethodBeat.o(43655);
                    return bYf;
                }
            }
            AppMethodBeat.o(43655);
            return null;
        }
    }

    public static Bankcard bYh() {
        AppMethodBeat.i(43656);
        r.cPI();
        Bankcard cQR = ak.cQR();
        AppMethodBeat.o(43656);
        return cQR;
    }

    public static int bYi() {
        AppMethodBeat.i(43657);
        int size = r.cPI().nf(true).size();
        AppMethodBeat.o(43657);
        return size;
    }

    public static List<Bankcard> jH(boolean z) {
        AppMethodBeat.i(43658);
        ArrayList arrayList = new ArrayList();
        ArrayList ng = r.cPI().ng(true);
        int i = 0;
        while (ng != null && i < ng.size()) {
            Bankcard bankcard = (Bankcard) ng.get(i);
            if (z) {
                arrayList.add(bankcard);
            } else {
                arrayList.add(bankcard);
            }
            i++;
        }
        ab.i("MicroMsg.WalletOfflineUtil", "getBindBankCardList() list size is " + arrayList.size());
        AppMethodBeat.o(43658);
        return arrayList;
    }

    public static List<Bankcard> bYj() {
        AppMethodBeat.i(43659);
        ArrayList arrayList = new ArrayList();
        ArrayList cQE = r.cPI().cQE();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < cQE.size()) {
                arrayList.add((Bankcard) cQE.get(i2));
                i = i2 + 1;
            } else {
                ab.i("MicroMsg.WalletOfflineUtil", "getOfflineBindBankCardList() list size is " + arrayList.size());
                AppMethodBeat.o(43659);
                return arrayList;
            }
        }
    }

    public static int bYk() {
        AppMethodBeat.i(43660);
        k.bXg();
        String Ax = k.Ax(196629);
        if (TextUtils.isEmpty(Ax) || !isNumeric(Ax)) {
            AppMethodBeat.o(43660);
            return 0;
        }
        int intValue = Integer.valueOf(Ax).intValue();
        AppMethodBeat.o(43660);
        return intValue;
    }

    public static void AB(int i) {
        AppMethodBeat.i(43662);
        k.bXg();
        k.aT(196640, String.valueOf(i));
        AppMethodBeat.o(43662);
    }

    public static void AC(int i) {
        AppMethodBeat.i(43663);
        k.bXg();
        k.aT(196642, String.valueOf(i));
        AppMethodBeat.o(43663);
    }

    public static String bYm() {
        AppMethodBeat.i(43664);
        k.bXg();
        String Ax = k.Ax(196632);
        AppMethodBeat.o(43664);
        return Ax;
    }

    public static String bYn() {
        AppMethodBeat.i(43665);
        k.bXg();
        String Ax = k.Ax(196631);
        AppMethodBeat.o(43665);
        return Ax;
    }

    public static void Ud(String str) {
        AppMethodBeat.i(43666);
        k.bXg();
        k.aT(196631, str);
        AppMethodBeat.o(43666);
    }

    public static void eH(Context context) {
        AppMethodBeat.i(43667);
        String dor = aa.dor();
        if ("zh_CN".equals(dor)) {
            dor = context.getString(R.string.ezq);
        } else if ("zh_TW".equals(dor)) {
            dor = context.getString(R.string.gao);
        } else if ("zh_HK".equals(dor)) {
            dor = context.getString(R.string.gan);
        } else {
            dor = context.getResources().getString(R.string.gam);
        }
        aL(context, dor);
        AppMethodBeat.o(43667);
    }

    private static void aL(Context context, String str) {
        AppMethodBeat.i(43668);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        d.b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(43668);
    }

    public static boolean isNumeric(String str) {
        AppMethodBeat.i(43669);
        if (str == null) {
            AppMethodBeat.o(43669);
            return false;
        }
        boolean matches = Pattern.compile("[0-9]*").matcher(str).matches();
        AppMethodBeat.o(43669);
        return matches;
    }

    public static void Ue(String str) {
        AppMethodBeat.i(43670);
        r.cPI();
        ak.acF(str);
        AppMethodBeat.o(43670);
    }

    public static void bYo() {
        AppMethodBeat.i(43671);
        ab.i("MicroMsg.WalletOfflineUtil", "clear offline data");
        k.bXg();
        k.aT(196630, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        k.bXg();
        k.aT(196626, "");
        k.bXg();
        k.aT(196627, "");
        k.bXg();
        k.aT(196628, "");
        k.bXg();
        k.aT(196617, "");
        k.bXg();
        k.aT(196632, "");
        k.bXg();
        k.aT(196641, "");
        k.bXg();
        k.aT(196647, "");
        k.bXg();
        k.aT(196649, "");
        r("", "", "", "");
        k.bXg();
        k.aT(196629, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        Ud("");
        k.bXg();
        k.bXh().oYL = null;
        k.bXg();
        k.bXj();
        k.bXg();
        String Ax = k.Ax(196617);
        com.tencent.mm.wallet_core.c.b.dNJ();
        com.tencent.mm.wallet_core.c.b.clearToken(Ax);
        Ui("");
        Uf("");
        AppMethodBeat.o(43671);
    }

    public static void a(Activity activity, f fVar) {
        AppMethodBeat.i(43672);
        ab.i("MicroMsg.WalletOfflineUtil", "hy: whole pay msg coming. direct parse");
        if (fVar == null || fVar.oZa == null) {
            ab.e("MicroMsg.WalletOfflineUtil", "order == null");
            AppMethodBeat.o(43672);
        } else if (bYe()) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_orders", fVar.oZa);
            bundle.putInt("key_pay_type", 2);
            if (fVar.cRz != null) {
                RealnameGuideHelper realnameGuideHelper = new RealnameGuideHelper();
                realnameGuideHelper.a(fVar.cRz.cRb, fVar.cRz.cRc, fVar.cRz.cRd, fVar.cRz.cRe, fVar.cRz.cRf, 8);
                bundle.putParcelable("key_realname_guide_helper", realnameGuideHelper);
            }
            if (activity instanceof WalletOfflineCoinPurseUI) {
                Intent intent = activity.getIntent();
                bundle.putString("key_appid", intent.getStringExtra("key_appid"));
                bundle.putInt("key_from_scene", intent.getIntExtra("key_from_scene", 0));
            }
            com.tencent.mm.wallet_core.a.a(activity, j.class, bundle);
            AppMethodBeat.o(43672);
        } else {
            AppMethodBeat.o(43672);
        }
    }

    public static Orders T(Map<String, String> map) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        AppMethodBeat.i(43673);
        Orders orders = new Orders();
        Commodity commodity = new Commodity();
        commodity.pbX = (String) map.get(".sysmsg.paymsg.user_roll.buy_uin");
        commodity.pbY = (String) map.get(".sysmsg.paymsg.user_roll.buy_name");
        commodity.pbZ = (String) map.get(".sysmsg.paymsg.user_roll.sale_uin");
        commodity.pca = (String) map.get(".sysmsg.paymsg.user_roll.sale_name");
        commodity.cAa = (String) map.get(".sysmsg.paymsg.user_roll.trans_id");
        commodity.desc = (String) map.get(".sysmsg.paymsg.user_roll.goods_name");
        commodity.kCJ = ((double) bo.getInt((String) map.get(".sysmsg.paymsg.user_roll.pay_num"), -1)) / 100.0d;
        commodity.pce = (String) map.get(".sysmsg.paymsg.user_roll.trade_state");
        commodity.pcf = (String) map.get(".sysmsg.paymsg.user_roll.trade_state_name");
        commodity.pcj = (String) map.get(".sysmsg.paymsg.user_roll.buy_bank_name");
        commodity.pcq = (String) map.get(".sysmsg.paymsg.user_roll.discount");
        commodity.pch = bo.getInt((String) map.get(".sysmsg.paymsg.user_roll.modify_timestamp"), 0);
        commodity.pcl = (String) map.get(".sysmsg.paymsg.user_roll.fee_type");
        commodity.pcm = (String) map.get(".sysmsg.paymsg.user_roll.appusername");
        commodity.pbP = (String) map.get(".sysmsg.paymsg.user_roll.app_telephone");
        commodity.tAR = ((double) bo.getInt((String) map.get(".sysmsg.paymsg.user_roll.buy_bank_name"), -1)) / 100.0d;
        Promotions promotions = new Promotions();
        promotions.name = (String) map.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.nickname");
        promotions.pcm = (String) map.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.username");
        promotions.type = Orders.tAP;
        commodity.tAS = promotions.pcm;
        promotions.pia = (String) map.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.logo_round_url");
        promotions.url = (String) map.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.subscribe_biz_url");
        int i = bo.getInt((String) map.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.recommend_level"), 1);
        commodity.tAh = i;
        commodity.tAV = (String) map.get(".sysmsg.paymsg.user_roll.rateinfo");
        commodity.tAW = (String) map.get(".sysmsg.paymsg.user_roll.discount_rateinfo");
        commodity.tAX = (String) map.get(".sysmsg.paymsg.user_roll.original_feeinfo");
        if (!bo.isNullOrNil(promotions.name)) {
            commodity.tBb = true;
            commodity.tBa.add(promotions);
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 255) {
                break;
            }
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            String str12;
            String str13;
            String str14;
            String str15;
            String str16;
            String str17;
            String str18;
            Promotions promotions2 = new Promotions();
            if (i3 == 0) {
                str = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.icon");
                str2 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.wording");
                str3 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.url");
                str4 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.btn_text");
                str5 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.type");
                str6 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.title");
                str7 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.activity_type");
                str8 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.activity_id");
                str9 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.send_record_id");
                str10 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.award_id");
                str11 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.user_record_id");
                str12 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.small_title");
                str13 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.activity_tinyapp_username");
                str14 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.activity_tinyapp_path");
                str15 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.activity_mch_id");
                str16 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.activity_tinyapp_version");
                str17 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.get_award_params");
                str18 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.query_award_status_params");
            } else {
                str = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".icon");
                str2 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".wording");
                str3 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".url");
                str4 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".btn_text");
                str5 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".type");
                str6 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".title");
                str7 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".activity_type");
                str8 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".activity_id");
                str9 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".send_record_id");
                str10 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".award_id");
                str11 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".user_record_id");
                str12 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".small_title");
                str13 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".activity_tinyapp_username");
                str14 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".activity_tinyapp_path");
                str15 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".activity_mch_id");
                str16 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".activity_tinyapp_version");
                str17 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".get_award_params");
                str18 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".query_award_status_params");
            }
            if (bo.isNullOrNil(str2)) {
                ab.i("MicroMsg.WalletOfflineUtil", "hy: activity end. total size: %d", Integer.valueOf(i3 + 1));
                break;
            }
            promotions2.pia = str;
            promotions2.name = str2;
            promotions2.url = str3;
            promotions2.tzS = str4;
            promotions2.type = Orders.tAQ;
            promotions2.tBn = bo.getInt(str5, 0);
            promotions2.title = str6;
            promotions2.uZM = bo.getInt(str7, 0);
            promotions2.ttW = bo.getLong(str8, 0);
            promotions2.tzP = bo.getInt(str9, 0);
            promotions2.uZN = bo.getInt(str10, 0);
            promotions2.tzQ = bo.getInt(str11, 0);
            promotions2.uZO = str12;
            promotions2.uZP = str13;
            promotions2.uZQ = str14;
            promotions2.tzR = bo.getLong(str15, 0);
            promotions2.uZR = bo.getInt(str16, 0);
            promotions2.uZS = str17;
            promotions2.uZT = str18;
            c c = c((Map) map, i3);
            if (c != null) {
                promotions2.tBw = c;
            }
            commodity.tBa.add(promotions2);
            i2 = i3 + 1;
        }
        str = (String) map.get(".sysmsg.paymsg.user_roll.link_ativity_info.text");
        str2 = (String) map.get(".sysmsg.paymsg.user_roll.link_ativity_info.url");
        commodity.tBc.text = str;
        commodity.tBc.url = str2;
        str = (String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_name");
        str2 = (String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_logo");
        str3 = (String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_desc");
        str4 = (String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_username");
        str5 = (String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_path");
        if (!(bo.isNullOrNil(str) || bo.isNullOrNil(str2) || bo.isNullOrNil(str3) || bo.isNullOrNil(str4))) {
            commodity.tAY = new RecommendTinyAppInfo();
            commodity.tAY.ttf = str;
            commodity.tAY.tzU = str2;
            commodity.tAY.tzV = str3;
            commodity.tAY.tzW = str4;
            commodity.tAY.ttg = str5;
            commodity.tAY.tzX = (String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_tinyapp_btn_text");
            commodity.tAY.tBx = bo.getLong((String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_id"), 0);
            commodity.tAY.tBy = bo.getLong((String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_type"), 0);
            commodity.tAY.tBA = bo.getInt((String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.send_record_id"), 0);
            commodity.tAY.tBB = bo.getInt((String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.user_record_id"), 0);
            commodity.tAY.tBC = (long) bo.getInt((String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_mch_id"), 0);
            commodity.tAY.tBz = (long) bo.getInt((String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.award_id"), 0);
            commodity.tAY.tzY = bo.getInt((String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_version"), 0);
        }
        orders.tAq = new ArrayList();
        orders.tAq.add(commodity);
        orders.tAA = bo.getInt((String) map.get(".sysmsg.paymsg.user_roll.is_use_new_paid_succ_page"), 0);
        orders.tAB = (String) map.get(".sysmsg.paymsg.user_roll.pay_succ_btn_wording");
        orders.tAj = (String) map.get(".sysmsg.paymsg.user_roll.trade_state_name");
        orders.tAh = i;
        orders.czZ = (String) map.get(".sysmsg.req_key");
        a(orders, (Map) map);
        commodity.tAR = bo.getDouble((String) map.get(".sysmsg.paymsg.user_roll.original_total_fee"), -1.0d) / 100.0d;
        if (TextUtils.isEmpty((String) map.get(".sysmsg.paymsg.user_roll.discount_array.record.favor_desc"))) {
            ab.e("MicroMsg.WalletOfflineUtil", ".sysmsg.paymsg.user_roll.discount_array.record.favor_desc value is empty");
        } else {
            int i4 = 0;
            while (true) {
                if (i4 == 0) {
                    str = "";
                } else {
                    str = String.valueOf(i4);
                }
                str3 = ".sysmsg.paymsg.user_roll.discount_array.record" + str + ".favor_desc";
                str4 = ".sysmsg.paymsg.user_roll.discount_array.record" + str + ".payment_amount";
                if (TextUtils.isEmpty((CharSequence) map.get(str3)) || TextUtils.isEmpty((CharSequence) map.get(str4))) {
                    ab.e("MicroMsg.WalletOfflineUtil", "favor_desc_key is " + str3 + ", payment_amount_key is " + str4 + ", break");
                } else {
                    DiscountInfo discountInfo = new DiscountInfo();
                    discountInfo.pOz = (String) map.get(str3);
                    discountInfo.tBm = bo.getDouble((String) map.get(str4), 0.0d);
                    commodity.tAU.add(discountInfo);
                    i4++;
                }
            }
            ab.e("MicroMsg.WalletOfflineUtil", "favor_desc_key is " + str3 + ", payment_amount_key is " + str4 + ", break");
        }
        AppMethodBeat.o(43673);
        return orders;
    }

    private static c c(Map<String, String> map, int i) {
        String str;
        AppMethodBeat.i(43674);
        if (i == 0) {
            str = ".sysmsg.paymsg.user_roll.activity_info.record.exposure_info.";
        } else {
            str = ".sysmsg.paymsg.user_roll.activity_info.record" + i + ".exposure_info.";
        }
        if (map != null) {
            String str2;
            c cVar = new c();
            cVar.BTA = bo.getInt((String) map.get(str + "is_query_others"), 0);
            cVar.wdr = (String) map.get(str + "draw_lottery_params");
            cVar.wex = bo.getInt((String) map.get(str + "is_show_btn"), 0);
            d.a.a.a aVar = new d.a.a.a();
            String str3 = str + "btn_info.";
            aVar.BTs = (String) map.get(str3 + "btn_words");
            aVar.BTt = (String) map.get(str3 + "btn_color");
            aVar.BTu = bo.getInt((String) map.get(str3 + "btn_op_type"), 0);
            aVar.url = (String) map.get(str3 + "url");
            aVar.wqf = (String) map.get(str3 + "get_lottery_params");
            str3 = str3 + "mini_app_info.";
            aVar.BTv = new d.a.a.f();
            aVar.BTv.wMk = (String) map.get(str3 + "activity_tinyapp_username");
            aVar.BTv.wMl = (String) map.get(str3 + "activity_tinyapp_path");
            aVar.BTv.wMm = bo.getInt((String) map.get(str3 + "activity_tinyapp_version"), 0);
            if (!(bo.isNullOrNil(aVar.BTs) && bo.isNullOrNil(aVar.url) && bo.isNullOrNil(aVar.wqf) && bo.isNullOrNil(aVar.BTv.wMk) && bo.isNullOrNil(aVar.BTv.wMl))) {
                cVar.wey = aVar;
            }
            cVar.BTB = bo.getInt((String) map.get(str + "user_opertaion_type"), 0);
            cVar.BTC = bo.getInt((String) map.get(str + "is_show_layer"), 0);
            cVar.BTE = (String) map.get(str + "background_img_whole");
            cVar.wew = new LinkedList();
            for (int i2 = 0; i2 < 255; i2++) {
                if (i2 == 0) {
                    str2 = str + "single_exposure_info_list.record.";
                } else {
                    str2 = str + "single_exposure_info_list.record" + i2 + ".";
                }
                g gVar = new g();
                gVar.pia = (String) map.get(str2 + "logo");
                gVar.BTP = (String) map.get(str2 + "award_name");
                gVar.BTQ = (String) map.get(str2 + "award_description");
                gVar.BTR = (String) map.get(str2 + "background_img");
                gVar.BTS = (String) map.get(str2 + "award_name_color");
                gVar.BTT = (String) map.get(str2 + "award_description_color");
                if (!(bo.isNullOrNil(gVar.pia) && bo.isNullOrNil(gVar.BTP) && bo.isNullOrNil(gVar.BTQ) && bo.isNullOrNil(gVar.BTR) && bo.isNullOrNil(gVar.BTS) && bo.isNullOrNil(gVar.BTT))) {
                    cVar.wew.add(gVar);
                }
                if (bo.isNullOrNil(gVar.BTP) || bo.isNullOrNil(gVar.BTQ)) {
                    break;
                }
            }
            cVar.BTD = new e();
            str2 = str + "layer_info.";
            cVar.BTD.BTG = (String) map.get(str2 + "layer_title");
            cVar.BTD.BTH = (String) map.get(str2 + "layer_logo");
            cVar.BTD.BTI = (String) map.get(str2 + "layer_type");
            cVar.BTD.BTJ = (String) map.get(str2 + "layer_name");
            cVar.BTD.BTK = (String) map.get(str2 + "layer_description");
            cVar.BTD.BTL = bo.getInt((String) map.get(str2 + "is_show_layer_btn"), 0);
            cVar.BTD.BTM = new d.a.a.d();
            str3 = str2 + "layer_btn_info.";
            cVar.BTD.BTM.BTs = (String) map.get(str3 + "btn_words");
            cVar.BTD.BTM.BTt = (String) map.get(str3 + "btn_color");
            cVar.BTD.BTM.BTu = bo.getInt((String) map.get(str3 + "btn_op_type"), 0);
            cVar.BTD.BTM.wqf = (String) map.get(str3 + "get_lottery_params");
            cVar.BTD.BTM.url = (String) map.get(str3 + "url");
            str3 = str3 + "mini_app_info.";
            cVar.BTD.BTM.BTv = new d.a.a.f();
            cVar.BTD.BTM.BTv.wMk = (String) map.get(str3 + "activity_tinyapp_username");
            cVar.BTD.BTM.BTv.wMl = (String) map.get(str3 + "activity_tinyapp_path");
            cVar.BTD.BTM.BTv.wMm = bo.getInt((String) map.get(str3 + "activity_tinyapp_version"), 0);
            if (!bo.isNullOrNil((String) map.get(str2 + "voice_url"))) {
                cVar.BTD.BTN = new com.tencent.mm.bt.b(((String) map.get(str2 + "voice_url")).getBytes());
            }
            if (!bo.isNullOrNil((String) map.get(str2 + "voice_data"))) {
                cVar.BTD.BTO = new com.tencent.mm.bt.b(((String) map.get(str2 + "voice_data")).getBytes());
            }
            d.a.a.b bVar = new d.a.a.b();
            str3 = str + "draw_lottery_info.";
            bVar.url = (String) map.get(str3 + "url");
            bVar.BTw = (String) map.get(str3 + "animation_wording");
            bVar.BTx = (String) map.get(str3 + "animation_wording_color");
            bVar.xis = bo.getInt((String) map.get(str3 + "op_type"), 0);
            bVar.BTy = (String) map.get(str3 + "after_animation_wording");
            bVar.BTz = (String) map.get(str3 + "after_animation_wording_color");
            str3 = str3 + "mini_app_info.";
            bVar.BTv = new d.a.a.f();
            bVar.BTv.wMk = (String) map.get(str3 + "activity_tinyapp_username");
            bVar.BTv.wMl = (String) map.get(str3 + "activity_tinyapp_path");
            bVar.BTv.wMm = bo.getInt((String) map.get(str3 + "activity_tinyapp_version"), 0);
            if (!(bo.isNullOrNil(bVar.url) && bo.isNullOrNil(bVar.BTw) && bo.isNullOrNil(bVar.BTx) && bo.isNullOrNil(bVar.BTv.wMk) && bo.isNullOrNil(bVar.BTv.wMl))) {
                cVar.BTF = bVar;
            }
            AppMethodBeat.o(43674);
            return cVar;
        }
        AppMethodBeat.o(43674);
        return null;
    }

    private static void a(Orders orders, Map<String, String> map) {
        AppMethodBeat.i(43675);
        if (map != null) {
            orders.tAC = bo.getInt((String) map.get(".sysmsg.paymsg.user_roll.is_use_show_info"), 0);
            String str = ".sysmsg.paymsg.user_roll.show_info.record";
            orders.tAE = new ArrayList();
            for (int i = 0; i < 255; i++) {
                String str2;
                if (i == 0) {
                    str2 = str + ".";
                } else {
                    str2 = str + i + ".";
                }
                ShowInfo showInfo = new ShowInfo();
                showInfo.name = (String) map.get(str2 + "name");
                showInfo.value = (String) map.get(str2 + "value");
                showInfo.mVA = (String) map.get(str2 + "name_color");
                showInfo.tBF = (String) map.get(str2 + "value_color");
                str2 = str2 + "value_attr.";
                showInfo.tBG = bo.getInt((String) map.get(str2 + "link_type"), 0);
                showInfo.tBH = (String) map.get(str2 + "link_weapp");
                showInfo.tBI = (String) map.get(str2 + "link_addr");
                showInfo.tBJ = (String) map.get(str2 + "link_url");
                showInfo.tBK = bo.getInt((String) map.get(str2 + "text_attr"), 0);
                if (!bo.isNullOrNil(showInfo.name) || !bo.isNullOrNil(showInfo.value)) {
                    orders.tAE.add(showInfo);
                }
            }
        }
        AppMethodBeat.o(43675);
    }

    public static void a(Activity activity, String str, m mVar) {
        AppMethodBeat.i(43676);
        ab.i("MicroMsg.WalletOfflineUtil", "hy: only transid coming. do old way");
        if (TextUtils.isEmpty(str)) {
            ab.e("MicroMsg.WalletOfflineUtil", "transid == null");
            AppMethodBeat.o(43676);
        } else if (bYe()) {
            Bundle bundle = new Bundle();
            if (mVar instanceof com.tencent.mm.plugin.offline.a.e) {
                RealnameGuideHelper realnameGuideHelper = ((com.tencent.mm.plugin.offline.a.e) mVar).oYc;
                if (realnameGuideHelper != null) {
                    bundle.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                }
            }
            bundle.putString("key_trans_id", str);
            bundle.putInt("key_pay_type", 2);
            if (activity instanceof WalletOfflineCoinPurseUI) {
                Intent intent = activity.getIntent();
                bundle.putString("key_appid", intent.getStringExtra("key_appid"));
                bundle.putInt("key_from_scene", intent.getIntExtra("key_from_scene", 0));
            }
            com.tencent.mm.wallet_core.a.a(activity, j.class, bundle);
            AppMethodBeat.o(43676);
        } else {
            AppMethodBeat.o(43676);
        }
    }

    public static void e(Activity activity, int i) {
        AppMethodBeat.i(43677);
        a(activity, i, -1);
        AppMethodBeat.o(43677);
    }

    public static void a(Activity activity, int i, int i2) {
        AppMethodBeat.i(43678);
        PayInfo payInfo = new PayInfo();
        payInfo.cIg = 5;
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_pay_info", payInfo);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putInt("key_bind_scene", 5);
        bundle.putInt("key_offline_add_fee", i);
        if (i2 >= 0) {
            bundle.putInt("key_entry_scene", i2);
        }
        if (!r.cPI().cQg()) {
            if (r.cPI().cQi()) {
                bundle.putBoolean("key_is_bind_bankcard", true);
                com.tencent.mm.wallet_core.a.a(activity, com.tencent.mm.plugin.offline.d.class, bundle);
                AppMethodBeat.o(43678);
                return;
            } else if (r.cPI().cQh()) {
                bundle.putBoolean("key_is_bind_bankcard", true);
                com.tencent.mm.wallet_core.a.a(activity, com.tencent.mm.plugin.offline.d.class, bundle);
                AppMethodBeat.o(43678);
                return;
            }
        }
        com.tencent.mm.wallet_core.a.a(activity, com.tencent.mm.plugin.offline.c.class, bundle);
        AppMethodBeat.o(43678);
    }

    public static void f(Activity activity, int i) {
        AppMethodBeat.i(43679);
        a(activity, "create", activity.getString(R.string.fvm), 0, i);
        AppMethodBeat.o(43679);
    }

    private static void a(Activity activity, String str, String str2, int i, int i2) {
        AppMethodBeat.i(43680);
        Bundle bundle = new Bundle();
        bundle.putString("oper", str);
        bundle.putInt("offline_chg_fee", i);
        bundle.putString("pwd_tips", str2);
        if (i2 >= 0) {
            bundle.putInt("offline_from_scene", i2);
        }
        com.tencent.mm.wallet_core.a.a(activity, h.class, bundle);
        AppMethodBeat.o(43680);
    }

    public static void U(Activity activity) {
        AppMethodBeat.i(43681);
        a(activity, "freeze", activity.getString(R.string.fvp), 0, -1);
        AppMethodBeat.o(43681);
    }

    public static void V(Activity activity) {
        AppMethodBeat.i(43682);
        g(activity, -1);
        AppMethodBeat.o(43682);
    }

    public static void g(Activity activity, int i) {
        AppMethodBeat.i(43683);
        a(activity, "create", "", bYl(), i);
        AppMethodBeat.o(43683);
    }

    public static void c(final Activity activity, String str) {
        AppMethodBeat.i(43684);
        com.tencent.mm.ui.base.h.a((Context) activity, false, str, "", activity.getString(R.string.fw6), activity.getString(R.string.or), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(43646);
                a.bYo();
                a.V(activity);
                activity.finish();
                AppMethodBeat.o(43646);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(43647);
                activity.finish();
                AppMethodBeat.o(43647);
            }
        });
        AppMethodBeat.o(43684);
    }

    public static void bYp() {
        AppMethodBeat.i(43685);
        k.bXg();
        k.aT(196643, "1");
        AppMethodBeat.o(43685);
    }

    public static void AD(int i) {
        AppMethodBeat.i(43686);
        k.bXg();
        k.aT(196644, String.valueOf(i));
        AppMethodBeat.o(43686);
    }

    public static int bYq() {
        AppMethodBeat.i(43687);
        k.bXg();
        String Ax = k.Ax(196644);
        if (TextUtils.isEmpty(Ax) || !isNumeric(Ax)) {
            AppMethodBeat.o(43687);
            return 0;
        }
        int intValue = Integer.valueOf(Ax).intValue();
        AppMethodBeat.o(43687);
        return intValue;
    }

    public static String getToken() {
        AppMethodBeat.i(43688);
        String str;
        if (TextUtils.isEmpty(paY)) {
            bYt();
            if (TextUtils.isEmpty(paY)) {
                ab.e("MicroMsg.WalletOfflineUtil", "token is null");
            }
            str = paY;
            AppMethodBeat.o(43688);
            return str;
        }
        str = paY;
        AppMethodBeat.o(43688);
        return str;
    }

    public static void r(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(43689);
        paY = str;
        paZ = str2;
        pbb = str3;
        pbc = str4;
        Uf(pbb);
        com.tencent.mm.kernel.g.RO().eJo.a(new bk(new com.tencent.mm.model.bk.a() {
            public final void a(com.tencent.mm.network.e eVar) {
                AppMethodBeat.i(43648);
                if (eVar == null || eVar.adg() == null) {
                    AppMethodBeat.o(43648);
                    return;
                }
                if (a.paY != null) {
                    eVar.adg().o("offline_token", a.paY.getBytes());
                }
                if (a.paZ != null) {
                    eVar.adg().o("offline_token_V2", a.paZ.getBytes());
                }
                if (a.pbc != null) {
                    eVar.adg().o("offline_key_list", a.pbc.getBytes());
                }
                AppMethodBeat.o(43648);
            }
        }), 0);
        AppMethodBeat.o(43689);
    }

    public static String bYr() {
        AppMethodBeat.i(43690);
        String str;
        if (TextUtils.isEmpty(paZ)) {
            bYt();
            if (TextUtils.isEmpty(paZ)) {
                ab.e("MicroMsg.WalletOfflineUtil", "offline_token_v2 is null");
            }
            str = paZ;
            AppMethodBeat.o(43690);
            return str;
        }
        str = paZ;
        AppMethodBeat.o(43690);
        return str;
    }

    public static String bYs() {
        AppMethodBeat.i(43691);
        String str;
        if (!TextUtils.isEmpty(pbb)) {
            str = pbb;
            AppMethodBeat.o(43691);
            return str;
        } else if (TextUtils.isEmpty(pbb)) {
            k.bXg();
            str = k.Ax(196656);
            pbb = str;
            AppMethodBeat.o(43691);
            return str;
        } else {
            if (TextUtils.isEmpty(pbb)) {
                ab.e("MicroMsg.WalletOfflineUtil", "offline_card_list is null");
            }
            str = pbb;
            AppMethodBeat.o(43691);
            return str;
        }
    }

    public static void Uf(String str) {
        AppMethodBeat.i(43692);
        k.bXg();
        k.aT(196656, str);
        pbb = str;
        AppMethodBeat.o(43692);
    }

    private static void bYt() {
        AppMethodBeat.i(43693);
        com.tencent.mm.kernel.g.RO().eJo.a(new bk(new com.tencent.mm.model.bk.a() {
            public final void a(com.tencent.mm.network.e eVar) {
                AppMethodBeat.i(43649);
                if (eVar == null || eVar.adg() == null) {
                    ab.e("MicroMsg.WalletOfflineUtil", "doLocalProxyScene dispatcher == null || dispatcher.getAccInfo() == null");
                    AppMethodBeat.o(43649);
                    return;
                }
                byte[] qr = eVar.adg().qr("offline_token");
                if (qr != null) {
                    a.paY = new String(qr);
                }
                qr = eVar.adg().qr("offline_token_V2");
                if (qr != null) {
                    a.paZ = new String(qr);
                }
                qr = eVar.adg().qr("offline_key_list");
                if (qr != null) {
                    a.pbc = new String(qr);
                }
                AppMethodBeat.o(43649);
            }
        }), 0);
        AppMethodBeat.o(43693);
    }

    public static LinkedList<a> Ug(String str) {
        LinkedList<a> linkedList = null;
        AppMethodBeat.i(43694);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(43694);
        } else {
            try {
                linkedList = t(new JSONArray(str));
                AppMethodBeat.o(43694);
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.WalletOfflineUtil", e, "", new Object[0]);
                AppMethodBeat.o(43694);
            }
        }
        return linkedList;
    }

    private static LinkedList<a> t(JSONArray jSONArray) {
        AppMethodBeat.i(43695);
        if (jSONArray.length() == 0) {
            AppMethodBeat.o(43695);
            return null;
        }
        LinkedList<a> linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject != null) {
                a aVar = new a();
                aVar.pbm = jSONObject.optInt("card_id");
                aVar.pbn = jSONObject.optString("bank_type");
                aVar.pbo = jSONObject.optString("bind_serial");
                aVar.pbp = jSONObject.optString("forbid_word");
                linkedList.add(aVar);
            }
        }
        AppMethodBeat.o(43695);
        return linkedList;
    }

    public static String bYu() {
        AppMethodBeat.i(43696);
        k.bXg();
        String Ax = k.Ax(196647);
        AppMethodBeat.o(43696);
        return Ax;
    }

    private static String bYv() {
        AppMethodBeat.i(43697);
        k.bXg();
        String Ax = k.Ax(196616);
        AppMethodBeat.o(43697);
        return Ax;
    }

    public static void Uh(String str) {
        AppMethodBeat.i(43698);
        k.bXg();
        k.aT(196616, str);
        AppMethodBeat.o(43698);
    }

    public static void W(Activity activity) {
        AppMethodBeat.i(43699);
        com.tencent.mm.ui.base.h.bQ(activity, activity.getResources().getString(R.string.fvn));
        if (!TextUtils.isEmpty(bYv())) {
            aL(activity, bYv());
        }
        AppMethodBeat.o(43699);
    }

    public static boolean bYw() {
        int i = 0;
        AppMethodBeat.i(43700);
        ArrayList nf = r.cPI().nf(true);
        LinkedList Ug = Ug(bYs());
        if (Ug == null || nf.size() != Ug.size()) {
            AppMethodBeat.o(43700);
            return false;
        }
        Collections.sort(Ug, pbl);
        Collections.sort(nf, pbk);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < Ug.size(); i2++) {
            stringBuilder.append(((a) Ug.get(i2)).pbo);
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        while (i < nf.size()) {
            stringBuilder2.append(((Bankcard) nf.get(i)).field_bindSerial);
            i++;
        }
        boolean equals = ag.ck(stringBuilder.toString()).equals(ag.ck(stringBuilder2.toString()));
        AppMethodBeat.o(43700);
        return equals;
    }

    private static String bYx() {
        AppMethodBeat.i(43701);
        String Ax;
        if (TextUtils.isEmpty(pbd)) {
            k.bXg();
            Ax = k.Ax(196615);
            pbd = Ax;
            AppMethodBeat.o(43701);
            return Ax;
        }
        Ax = pbd;
        AppMethodBeat.o(43701);
        return Ax;
    }

    public static void Ui(String str) {
        AppMethodBeat.i(43702);
        k.bXg();
        k.aT(196615, str);
        pbd = str;
        AppMethodBeat.o(43702);
    }

    private static LinkedList<b> Uj(String str) {
        LinkedList<b> linkedList = null;
        AppMethodBeat.i(43703);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(43703);
        } else {
            try {
                linkedList = u(new JSONArray(str));
                AppMethodBeat.o(43703);
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.WalletOfflineUtil", e, "", new Object[0]);
                AppMethodBeat.o(43703);
            }
        }
        return linkedList;
    }

    private static LinkedList<b> u(JSONArray jSONArray) {
        AppMethodBeat.i(43704);
        if (jSONArray.length() == 0) {
            AppMethodBeat.o(43704);
            return null;
        }
        LinkedList<b> linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject != null) {
                b bVar = new b();
                bVar.pbn = jSONObject.optString("bank_type");
                bVar.kKZ = jSONObject.optString("icon_url");
                linkedList.add(bVar);
            }
        }
        AppMethodBeat.o(43704);
        return linkedList;
    }

    public static int bYy() {
        AppMethodBeat.i(43705);
        k.bXg();
        String Ax = k.Ax(196649);
        if (TextUtils.isEmpty(Ax) || !isNumeric(Ax)) {
            AppMethodBeat.o(43705);
            return 0;
        }
        int intValue = Integer.valueOf(Ax).intValue();
        AppMethodBeat.o(43705);
        return intValue;
    }

    public static boolean bYz() {
        AppMethodBeat.i(43706);
        String bYm = bYm();
        if (TextUtils.isEmpty(bYm)) {
            AppMethodBeat.o(43706);
            return false;
        }
        if ((System.currentTimeMillis() / 1000) - Long.valueOf(bYm).longValue() >= ((long) bYy())) {
            AppMethodBeat.o(43706);
            return true;
        }
        AppMethodBeat.o(43706);
        return false;
    }

    public static String Uk(String str) {
        AppMethodBeat.i(43707);
        LinkedList Uj = Uj(bYx());
        String str2;
        if (Uj == null) {
            str2 = "";
            AppMethodBeat.o(43707);
            return str2;
        }
        String str3 = "";
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= Uj.size()) {
                str2 = str3;
                break;
            }
            b bVar = (b) Uj.get(i2);
            if (bVar != null && str.equals(bVar.pbn)) {
                str2 = bVar.kKZ;
                break;
            }
            i = i2 + 1;
        }
        AppMethodBeat.o(43707);
        return str2;
    }

    public static String Ul(String str) {
        int i = 0;
        AppMethodBeat.i(43708);
        LinkedList Ug = Ug(bYs());
        LinkedList Uj = Uj(bYx());
        String str2;
        if (Ug == null || Uj == null || Ug.size() == 0 || Uj.size() == 0) {
            ab.e("MicroMsg.WalletOfflineUtil", "getBankLogoUrl() cardList == null || cardLogoList == null || cardList.size() == 0 || cardLogoList.size() == 0");
            str2 = "";
            AppMethodBeat.o(43708);
            return str2;
        }
        CharSequence charSequence;
        String str3 = "";
        for (int i2 = 0; i2 < Ug.size(); i2++) {
            a aVar = (a) Ug.get(i2);
            if (aVar != null && str.equals(aVar.pbo)) {
                charSequence = aVar.pbn;
                break;
            }
        }
        Object charSequence2 = str3;
        if (TextUtils.isEmpty(charSequence2)) {
            ab.e("MicroMsg.WalletOfflineUtil", "getBankLogoUrl() bank_type == null, can not find this bank_type");
            str2 = "";
            AppMethodBeat.o(43708);
            return str2;
        }
        str3 = "";
        while (i < Uj.size()) {
            b bVar = (b) Uj.get(i);
            if (bVar != null && charSequence2.equals(bVar.pbn)) {
                str2 = bVar.kKZ;
                break;
            }
            i++;
        }
        str2 = str3;
        AppMethodBeat.o(43708);
        return str2;
    }

    public static boolean eA(Context context) {
        AppMethodBeat.i(43709);
        List runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        if (!(runningTasks == null || runningTasks.isEmpty())) {
            ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
            ab.d("MicroMsg.WalletOfflineUtil", "topActivity:" + componentName.flattenToString());
            if (!componentName.getPackageName().equals(context.getPackageName())) {
                ab.i("MicroMsg.WalletOfflineUtil", "is in backGround.");
                AppMethodBeat.o(43709);
                return false;
            }
        }
        if (((KeyguardManager) ah.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            AppMethodBeat.o(43709);
            return false;
        }
        ab.i("MicroMsg.WalletOfflineUtil", "is in foreGround.");
        AppMethodBeat.o(43709);
        return true;
    }

    public static void Um(String str) {
        AppMethodBeat.i(43710);
        com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.BUSINESS_OFFLINE_GETMSG_ACK_KEY_STRING, (Object) str);
        AppMethodBeat.o(43710);
    }

    public static String bYA() {
        AppMethodBeat.i(43711);
        Object obj = com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.BUSINESS_OFFLINE_GETMSG_ACK_KEY_STRING, (Object) "");
        if (obj != null) {
            String str = (String) obj;
            AppMethodBeat.o(43711);
            return str;
        }
        AppMethodBeat.o(43711);
        return null;
    }

    public static void Un(String str) {
        AppMethodBeat.i(43712);
        com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.BUSINESS_OFFLINE_GETMSG_REQ_KEY_STRING, (Object) str);
        AppMethodBeat.o(43712);
    }

    public static String bYB() {
        AppMethodBeat.i(43713);
        Object obj = com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.BUSINESS_OFFLINE_GETMSG_REQ_KEY_STRING, (Object) "");
        if (obj != null) {
            String str = (String) obj;
            AppMethodBeat.o(43713);
            return str;
        }
        AppMethodBeat.o(43713);
        return null;
    }

    public static void AE(int i) {
        AppMethodBeat.i(43714);
        if (i < 0) {
            i = 0;
        }
        com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.BUSINESS_OFFLINE_GETMSG_PAYMSG_TYPE_INT, Integer.valueOf(i));
        AppMethodBeat.o(43714);
    }

    public static int bYC() {
        int intValue;
        AppMethodBeat.i(43715);
        Object obj = com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.BUSINESS_OFFLINE_GETMSG_PAYMSG_TYPE_INT, null);
        if (obj != null) {
            intValue = ((Integer) obj).intValue();
        } else {
            intValue = 0;
        }
        if (intValue < 0) {
            intValue = 0;
        }
        AppMethodBeat.o(43715);
        return intValue;
    }

    public static void Uo(String str) {
        AppMethodBeat.i(43716);
        com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.BUSINESS_OFFLINE_GETMSG_TRANS_ID_STRING, (Object) str);
        AppMethodBeat.o(43716);
    }

    public static String bYD() {
        AppMethodBeat.i(43717);
        Object obj = com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.BUSINESS_OFFLINE_GETMSG_TRANS_ID_STRING, (Object) "");
        if (obj != null) {
            String str = (String) obj;
            AppMethodBeat.o(43717);
            return str;
        }
        AppMethodBeat.o(43717);
        return null;
    }

    public static int getNetworkType(Context context) {
        int i;
        AppMethodBeat.i(43718);
        if (!at.isConnected(context)) {
            i = -1;
        } else if (at.isWifi(context)) {
            i = 1;
        } else if (at.is2G(context)) {
            i = 2;
        } else if (at.is3G(context)) {
            i = 3;
        } else if (at.is4G(context)) {
            i = 4;
        } else {
            i = 0;
        }
        AppMethodBeat.o(43718);
        return i;
    }

    public static boolean bYE() {
        Map dru;
        AppMethodBeat.i(43719);
        boolean z = false;
        com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100232");
        if (ll.isValid()) {
            dru = ll.dru();
            if (dru.containsKey("open") && "1".equals(dru.get("open"))) {
                ab.e("MicroMsg.WalletOfflineUtil", "deprecated abtest 100232 enabled.");
            }
        }
        ll = com.tencent.mm.model.c.c.abi().ll("100261");
        if (ll.isValid()) {
            dru = ll.dru();
            if (dru.containsKey("open") && "1".equals(dru.get("open"))) {
                z = true;
            }
        }
        ab.i("MicroMsg.WalletOfflineUtil", "isPosEnabled: ".concat(String.valueOf(z)));
        AppMethodBeat.o(43719);
        return z;
    }

    public static void Up(String str) {
        AppMethodBeat.i(43720);
        ab.i("MicroMsg.WalletOfflineUtil", "launch 3rd app: %s", str);
        com.tencent.mm.pluginsdk.model.app.f bT = com.tencent.mm.pluginsdk.model.app.g.bT(str, true);
        if (bT == null) {
            ab.w("MicroMsg.WalletOfflineUtil", "can not find app info");
            AppMethodBeat.o(43720);
            return;
        }
        Bundle bundle = new Bundle();
        Resp resp = new Resp();
        resp.errCode = 0;
        resp.toBundle(bundle);
        Args args = new Args();
        args.targetPkgName = bT.field_packageName;
        args.bundle = bundle;
        p.at(bundle);
        p.au(bundle);
        MMessageActV2.send(ah.getContext(), args);
        AppMethodBeat.o(43720);
    }

    @Deprecated
    public static Bankcard bYf() {
        Bankcard bankcard;
        AppMethodBeat.i(43654);
        r.cPI();
        com.tencent.mm.kernel.g.RQ();
        String str = (String) com.tencent.mm.kernel.g.RP().Ry().get(196633, null);
        ab.i("MicroMsg.WalletPayOrderMgr", "step 1 getSelectedBindBankCard %s", str);
        ArrayList nf = r.cPI().nf(true);
        int i = 0;
        while (!TextUtils.isEmpty(str) && i < nf.size()) {
            bankcard = (Bankcard) nf.get(i);
            if (bankcard != null && str.equals(bankcard.field_bindSerial)) {
                ab.i("MicroMsg.WalletPayOrderMgr", "step 2 micropay: %s, forbidword: %s", Boolean.valueOf(bankcard.field_support_micropay), bankcard.field_forbidWord);
                if (bankcard.field_support_micropay) {
                    AppMethodBeat.o(43654);
                    return bankcard;
                }
            }
            i++;
        }
        ab.i("MicroMsg.WalletPayOrderMgr", "step 3 clear default bindserial");
        r.cPI();
        ak.acF("");
        r.cPI();
        bankcard = ak.cQR();
        if (bankcard == null || !bo.isNullOrNil(bankcard.field_forbidWord)) {
            int i2 = 0;
            while (i2 < nf.size()) {
                Bankcard bankcard2 = (Bankcard) nf.get(i2);
                if (bankcard2 == null || !bankcard2.field_support_micropay || bankcard2.cPc()) {
                    i2++;
                } else {
                    ab.i("MicroMsg.WalletPayOrderMgr", "do change first card: %s", bankcard2.field_bankcardType);
                    AppMethodBeat.o(43654);
                    return bankcard2;
                }
            }
            bankcard = r.cPI().thy;
            if (bankcard == null || !bankcard.field_support_micropay) {
                bankcard = r.cPI().tCZ;
                if (bankcard != null && bankcard.field_support_micropay && bo.isNullOrNil(bankcard.field_forbidWord)) {
                    ab.i("MicroMsg.WalletPayOrderMgr", "do change balance: %s", bankcard.field_bankcardType);
                    AppMethodBeat.o(43654);
                    return bankcard;
                }
                AppMethodBeat.o(43654);
                return null;
            }
            ab.i("MicroMsg.WalletPayOrderMgr", "do change balance: %s", bankcard.field_bankcardType);
            AppMethodBeat.o(43654);
            return bankcard;
        }
        ab.i("MicroMsg.WalletPayOrderMgr", "do change main card: %s", bankcard.field_bankcardType);
        AppMethodBeat.o(43654);
        return bankcard;
    }

    private static int bYl() {
        int i;
        AppMethodBeat.i(43661);
        k.bXg();
        String Ax = k.Ax(196640);
        if (TextUtils.isEmpty(Ax) || !isNumeric(Ax)) {
            i = 0;
        } else {
            i = Integer.valueOf(Ax).intValue();
        }
        if (i > 0) {
            i *= 100;
        } else {
            i = i.sHCENCODEVIDEOTIMEOUT;
        }
        AppMethodBeat.o(43661);
        return i;
    }
}
