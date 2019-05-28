package com.tencent.p177mm.plugin.offline.p1006c;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C6668bk;
import com.tencent.p177mm.model.C6668bk.C1835a;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.opensdk.channel.MMessageActV2;
import com.tencent.p177mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.p177mm.opensdk.modelpay.JumpToOfflinePay.Resp;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.offline.C12739c;
import com.tencent.p177mm.plugin.offline.C31377d;
import com.tencent.p177mm.plugin.offline.C34646h;
import com.tencent.p177mm.plugin.offline.C34650j;
import com.tencent.p177mm.plugin.offline.C7007k;
import com.tencent.p177mm.plugin.offline.p478a.C12736e;
import com.tencent.p177mm.plugin.offline.p478a.C21405s.C21411f;
import com.tencent.p177mm.plugin.offline.p479ui.WalletOfflineCoinPurseUI;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C22587ak;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.RecommendTinyAppInfo;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.ShowInfo;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.p649c.C40928b;
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
import p1121d.p1122a.p1123a.C16442f;
import p1121d.p1122a.p1123a.C24578d;
import p1121d.p1122a.p1123a.C31176c;
import p1121d.p1122a.p1123a.C31177e;
import p1121d.p1122a.p1123a.C41148b;
import p1121d.p1122a.p1123a.C44604a;
import p1121d.p1122a.p1123a.C44605g;

/* renamed from: com.tencent.mm.plugin.offline.c.a */
public final class C28630a {
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
    private static Comparator<Bankcard> pbk = new C286345();
    private static Comparator<C28635a> pbl = new C127386();

    /* renamed from: com.tencent.mm.plugin.offline.c.a$6 */
    static class C127386 implements Comparator<C28635a> {
        C127386() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.m2504i(43651);
            int compareToIgnoreCase = ((C28635a) obj).pbo.compareToIgnoreCase(((C28635a) obj2).pbo);
            AppMethodBeat.m2505o(43651);
            return compareToIgnoreCase;
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.c.a$b */
    public static class C21412b {
        public String kKZ;
        public String pbn;
    }

    /* renamed from: com.tencent.mm.plugin.offline.c.a$4 */
    static class C286324 implements C1835a {
        C286324() {
        }

        /* renamed from: a */
        public final void mo4918a(C1902e c1902e) {
            AppMethodBeat.m2504i(43649);
            if (c1902e == null || c1902e.adg() == null) {
                C4990ab.m7412e("MicroMsg.WalletOfflineUtil", "doLocalProxyScene dispatcher == null || dispatcher.getAccInfo() == null");
                AppMethodBeat.m2505o(43649);
                return;
            }
            byte[] qr = c1902e.adg().mo5492qr("offline_token");
            if (qr != null) {
                C28630a.paY = new String(qr);
            }
            qr = c1902e.adg().mo5492qr("offline_token_V2");
            if (qr != null) {
                C28630a.paZ = new String(qr);
            }
            qr = c1902e.adg().mo5492qr("offline_key_list");
            if (qr != null) {
                C28630a.pbc = new String(qr);
            }
            AppMethodBeat.m2505o(43649);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.c.a$3 */
    static class C286333 implements C1835a {
        C286333() {
        }

        /* renamed from: a */
        public final void mo4918a(C1902e c1902e) {
            AppMethodBeat.m2504i(43648);
            if (c1902e == null || c1902e.adg() == null) {
                AppMethodBeat.m2505o(43648);
                return;
            }
            if (C28630a.paY != null) {
                c1902e.adg().mo5491o("offline_token", C28630a.paY.getBytes());
            }
            if (C28630a.paZ != null) {
                c1902e.adg().mo5491o("offline_token_V2", C28630a.paZ.getBytes());
            }
            if (C28630a.pbc != null) {
                c1902e.adg().mo5491o("offline_key_list", C28630a.pbc.getBytes());
            }
            AppMethodBeat.m2505o(43648);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.c.a$5 */
    static class C286345 implements Comparator<Bankcard> {
        C286345() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.m2504i(43650);
            int compareToIgnoreCase = ((Bankcard) obj).field_bindSerial.compareToIgnoreCase(((Bankcard) obj2).field_bindSerial);
            AppMethodBeat.m2505o(43650);
            return compareToIgnoreCase;
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.c.a$a */
    public static class C28635a {
        public int pbm;
        public String pbn;
        public String pbo;
        public String pbp;
    }

    static {
        AppMethodBeat.m2504i(43721);
        AppMethodBeat.m2505o(43721);
    }

    public static boolean bYd() {
        AppMethodBeat.m2504i(43652);
        C7007k.bXg();
        String Ax = C7007k.m11709Ax(196630);
        if (Ax == null || !Ax.equals("1")) {
            AppMethodBeat.m2505o(43652);
            return false;
        }
        AppMethodBeat.m2505o(43652);
        return true;
    }

    public static boolean bYe() {
        AppMethodBeat.m2504i(43653);
        C7007k.bXg();
        String Ax = C7007k.m11709Ax(196641);
        if (Ax == null || !Ax.equals("1")) {
            AppMethodBeat.m2505o(43653);
            return false;
        }
        AppMethodBeat.m2505o(43653);
        return true;
    }

    public static Bankcard bYg() {
        AppMethodBeat.m2504i(43655);
        Bankcard bYf = C28630a.bYf();
        if (bYf != null && bYf.field_support_micropay && C5046bo.isNullOrNil(bYf.field_forbidWord)) {
            AppMethodBeat.m2505o(43655);
            return bYf;
        }
        ArrayList nf = C14241r.cPI().mo38171nf(true);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < nf.size()) {
                bYf = (Bankcard) nf.get(i2);
                if (bYf == null || !bYf.field_support_micropay) {
                    i = i2 + 1;
                } else {
                    AppMethodBeat.m2505o(43655);
                    return bYf;
                }
            }
            AppMethodBeat.m2505o(43655);
            return null;
        }
    }

    public static Bankcard bYh() {
        AppMethodBeat.m2504i(43656);
        C14241r.cPI();
        Bankcard cQR = C22587ak.cQR();
        AppMethodBeat.m2505o(43656);
        return cQR;
    }

    public static int bYi() {
        AppMethodBeat.m2504i(43657);
        int size = C14241r.cPI().mo38171nf(true).size();
        AppMethodBeat.m2505o(43657);
        return size;
    }

    /* renamed from: jH */
    public static List<Bankcard> m45524jH(boolean z) {
        AppMethodBeat.m2504i(43658);
        ArrayList arrayList = new ArrayList();
        ArrayList ng = C14241r.cPI().mo38172ng(true);
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
        C4990ab.m7416i("MicroMsg.WalletOfflineUtil", "getBindBankCardList() list size is " + arrayList.size());
        AppMethodBeat.m2505o(43658);
        return arrayList;
    }

    public static List<Bankcard> bYj() {
        AppMethodBeat.m2504i(43659);
        ArrayList arrayList = new ArrayList();
        ArrayList cQE = C14241r.cPI().cQE();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < cQE.size()) {
                arrayList.add((Bankcard) cQE.get(i2));
                i = i2 + 1;
            } else {
                C4990ab.m7416i("MicroMsg.WalletOfflineUtil", "getOfflineBindBankCardList() list size is " + arrayList.size());
                AppMethodBeat.m2505o(43659);
                return arrayList;
            }
        }
    }

    public static int bYk() {
        AppMethodBeat.m2504i(43660);
        C7007k.bXg();
        String Ax = C7007k.m11709Ax(196629);
        if (TextUtils.isEmpty(Ax) || !C28630a.isNumeric(Ax)) {
            AppMethodBeat.m2505o(43660);
            return 0;
        }
        int intValue = Integer.valueOf(Ax).intValue();
        AppMethodBeat.m2505o(43660);
        return intValue;
    }

    /* renamed from: AB */
    public static void m45490AB(int i) {
        AppMethodBeat.m2504i(43662);
        C7007k.bXg();
        C7007k.m11711aT(196640, String.valueOf(i));
        AppMethodBeat.m2505o(43662);
    }

    /* renamed from: AC */
    public static void m45491AC(int i) {
        AppMethodBeat.m2504i(43663);
        C7007k.bXg();
        C7007k.m11711aT(196642, String.valueOf(i));
        AppMethodBeat.m2505o(43663);
    }

    public static String bYm() {
        AppMethodBeat.m2504i(43664);
        C7007k.bXg();
        String Ax = C7007k.m11709Ax(196632);
        AppMethodBeat.m2505o(43664);
        return Ax;
    }

    public static String bYn() {
        AppMethodBeat.m2504i(43665);
        C7007k.bXg();
        String Ax = C7007k.m11709Ax(196631);
        AppMethodBeat.m2505o(43665);
        return Ax;
    }

    /* renamed from: Ud */
    public static void m45496Ud(String str) {
        AppMethodBeat.m2504i(43666);
        C7007k.bXg();
        C7007k.m11711aT(196631, str);
        AppMethodBeat.m2505o(43666);
    }

    /* renamed from: eH */
    public static void m45521eH(Context context) {
        AppMethodBeat.m2504i(43667);
        String dor = C4988aa.dor();
        if ("zh_CN".equals(dor)) {
            dor = context.getString(C25738R.string.ezq);
        } else if ("zh_TW".equals(dor)) {
            dor = context.getString(C25738R.string.gao);
        } else if ("zh_HK".equals(dor)) {
            dor = context.getString(C25738R.string.gan);
        } else {
            dor = context.getResources().getString(C25738R.string.gam);
        }
        C28630a.m45516aL(context, dor);
        AppMethodBeat.m2505o(43667);
    }

    /* renamed from: aL */
    private static void m45516aL(Context context, String str) {
        AppMethodBeat.m2504i(43668);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        C25985d.m41467b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(43668);
    }

    public static boolean isNumeric(String str) {
        AppMethodBeat.m2504i(43669);
        if (str == null) {
            AppMethodBeat.m2505o(43669);
            return false;
        }
        boolean matches = Pattern.compile("[0-9]*").matcher(str).matches();
        AppMethodBeat.m2505o(43669);
        return matches;
    }

    /* renamed from: Ue */
    public static void m45497Ue(String str) {
        AppMethodBeat.m2504i(43670);
        C14241r.cPI();
        C22587ak.acF(str);
        AppMethodBeat.m2505o(43670);
    }

    public static void bYo() {
        AppMethodBeat.m2504i(43671);
        C4990ab.m7416i("MicroMsg.WalletOfflineUtil", "clear offline data");
        C7007k.bXg();
        C7007k.m11711aT(196630, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        C7007k.bXg();
        C7007k.m11711aT(196626, "");
        C7007k.bXg();
        C7007k.m11711aT(196627, "");
        C7007k.bXg();
        C7007k.m11711aT(196628, "");
        C7007k.bXg();
        C7007k.m11711aT(196617, "");
        C7007k.bXg();
        C7007k.m11711aT(196632, "");
        C7007k.bXg();
        C7007k.m11711aT(196641, "");
        C7007k.bXg();
        C7007k.m11711aT(196647, "");
        C7007k.bXg();
        C7007k.m11711aT(196649, "");
        C28630a.m45525r("", "", "", "");
        C7007k.bXg();
        C7007k.m11711aT(196629, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        C28630a.m45496Ud("");
        C7007k.bXg();
        C7007k.bXh().oYL = null;
        C7007k.bXg();
        C7007k.bXj();
        C7007k.bXg();
        String Ax = C7007k.m11709Ax(196617);
        C40928b.dNJ();
        C40928b.clearToken(Ax);
        C28630a.m45501Ui("");
        C28630a.m45498Uf("");
        AppMethodBeat.m2505o(43671);
    }

    /* renamed from: a */
    public static void m45512a(Activity activity, C21411f c21411f) {
        AppMethodBeat.m2504i(43672);
        C4990ab.m7416i("MicroMsg.WalletOfflineUtil", "hy: whole pay msg coming. direct parse");
        if (c21411f == null || c21411f.oZa == null) {
            C4990ab.m7412e("MicroMsg.WalletOfflineUtil", "order == null");
            AppMethodBeat.m2505o(43672);
        } else if (C28630a.bYe()) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_orders", c21411f.oZa);
            bundle.putInt("key_pay_type", 2);
            if (c21411f.cRz != null) {
                RealnameGuideHelper realnameGuideHelper = new RealnameGuideHelper();
                realnameGuideHelper.mo74571a(c21411f.cRz.cRb, c21411f.cRz.cRc, c21411f.cRz.cRd, c21411f.cRz.cRe, c21411f.cRz.cRf, 8);
                bundle.putParcelable("key_realname_guide_helper", realnameGuideHelper);
            }
            if (activity instanceof WalletOfflineCoinPurseUI) {
                Intent intent = activity.getIntent();
                bundle.putString("key_appid", intent.getStringExtra("key_appid"));
                bundle.putInt("key_from_scene", intent.getIntExtra("key_from_scene", 0));
            }
            C24143a.m37105a(activity, C34650j.class, bundle);
            AppMethodBeat.m2505o(43672);
        } else {
            AppMethodBeat.m2505o(43672);
        }
    }

    /* renamed from: T */
    public static Orders m45494T(Map<String, String> map) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        AppMethodBeat.m2504i(43673);
        Orders orders = new Orders();
        Commodity commodity = new Commodity();
        commodity.pbX = (String) map.get(".sysmsg.paymsg.user_roll.buy_uin");
        commodity.pbY = (String) map.get(".sysmsg.paymsg.user_roll.buy_name");
        commodity.pbZ = (String) map.get(".sysmsg.paymsg.user_roll.sale_uin");
        commodity.pca = (String) map.get(".sysmsg.paymsg.user_roll.sale_name");
        commodity.cAa = (String) map.get(".sysmsg.paymsg.user_roll.trans_id");
        commodity.desc = (String) map.get(".sysmsg.paymsg.user_roll.goods_name");
        commodity.kCJ = ((double) C5046bo.getInt((String) map.get(".sysmsg.paymsg.user_roll.pay_num"), -1)) / 100.0d;
        commodity.pce = (String) map.get(".sysmsg.paymsg.user_roll.trade_state");
        commodity.pcf = (String) map.get(".sysmsg.paymsg.user_roll.trade_state_name");
        commodity.pcj = (String) map.get(".sysmsg.paymsg.user_roll.buy_bank_name");
        commodity.pcq = (String) map.get(".sysmsg.paymsg.user_roll.discount");
        commodity.pch = C5046bo.getInt((String) map.get(".sysmsg.paymsg.user_roll.modify_timestamp"), 0);
        commodity.pcl = (String) map.get(".sysmsg.paymsg.user_roll.fee_type");
        commodity.pcm = (String) map.get(".sysmsg.paymsg.user_roll.appusername");
        commodity.pbP = (String) map.get(".sysmsg.paymsg.user_roll.app_telephone");
        commodity.tAR = ((double) C5046bo.getInt((String) map.get(".sysmsg.paymsg.user_roll.buy_bank_name"), -1)) / 100.0d;
        Promotions promotions = new Promotions();
        promotions.name = (String) map.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.nickname");
        promotions.pcm = (String) map.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.username");
        promotions.type = Orders.tAP;
        commodity.tAS = promotions.pcm;
        promotions.pia = (String) map.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.logo_round_url");
        promotions.url = (String) map.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.subscribe_biz_url");
        int i = C5046bo.getInt((String) map.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.recommend_level"), 1);
        commodity.tAh = i;
        commodity.tAV = (String) map.get(".sysmsg.paymsg.user_roll.rateinfo");
        commodity.tAW = (String) map.get(".sysmsg.paymsg.user_roll.discount_rateinfo");
        commodity.tAX = (String) map.get(".sysmsg.paymsg.user_roll.original_feeinfo");
        if (!C5046bo.isNullOrNil(promotions.name)) {
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
            if (C5046bo.isNullOrNil(str2)) {
                C4990ab.m7417i("MicroMsg.WalletOfflineUtil", "hy: activity end. total size: %d", Integer.valueOf(i3 + 1));
                break;
            }
            promotions2.pia = str;
            promotions2.name = str2;
            promotions2.url = str3;
            promotions2.tzS = str4;
            promotions2.type = Orders.tAQ;
            promotions2.tBn = C5046bo.getInt(str5, 0);
            promotions2.title = str6;
            promotions2.uZM = C5046bo.getInt(str7, 0);
            promotions2.ttW = C5046bo.getLong(str8, 0);
            promotions2.tzP = C5046bo.getInt(str9, 0);
            promotions2.uZN = C5046bo.getInt(str10, 0);
            promotions2.tzQ = C5046bo.getInt(str11, 0);
            promotions2.uZO = str12;
            promotions2.uZP = str13;
            promotions2.uZQ = str14;
            promotions2.tzR = C5046bo.getLong(str15, 0);
            promotions2.uZR = C5046bo.getInt(str16, 0);
            promotions2.uZS = str17;
            promotions2.uZT = str18;
            C31176c c = C28630a.m45517c((Map) map, i3);
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
        if (!(C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str3) || C5046bo.isNullOrNil(str4))) {
            commodity.tAY = new RecommendTinyAppInfo();
            commodity.tAY.ttf = str;
            commodity.tAY.tzU = str2;
            commodity.tAY.tzV = str3;
            commodity.tAY.tzW = str4;
            commodity.tAY.ttg = str5;
            commodity.tAY.tzX = (String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_tinyapp_btn_text");
            commodity.tAY.tBx = C5046bo.getLong((String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_id"), 0);
            commodity.tAY.tBy = C5046bo.getLong((String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_type"), 0);
            commodity.tAY.tBA = C5046bo.getInt((String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.send_record_id"), 0);
            commodity.tAY.tBB = C5046bo.getInt((String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.user_record_id"), 0);
            commodity.tAY.tBC = (long) C5046bo.getInt((String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_mch_id"), 0);
            commodity.tAY.tBz = (long) C5046bo.getInt((String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.award_id"), 0);
            commodity.tAY.tzY = C5046bo.getInt((String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_version"), 0);
        }
        orders.tAq = new ArrayList();
        orders.tAq.add(commodity);
        orders.tAA = C5046bo.getInt((String) map.get(".sysmsg.paymsg.user_roll.is_use_new_paid_succ_page"), 0);
        orders.tAB = (String) map.get(".sysmsg.paymsg.user_roll.pay_succ_btn_wording");
        orders.tAj = (String) map.get(".sysmsg.paymsg.user_roll.trade_state_name");
        orders.tAh = i;
        orders.czZ = (String) map.get(".sysmsg.req_key");
        C28630a.m45515a(orders, (Map) map);
        commodity.tAR = C5046bo.getDouble((String) map.get(".sysmsg.paymsg.user_roll.original_total_fee"), -1.0d) / 100.0d;
        if (TextUtils.isEmpty((String) map.get(".sysmsg.paymsg.user_roll.discount_array.record.favor_desc"))) {
            C4990ab.m7412e("MicroMsg.WalletOfflineUtil", ".sysmsg.paymsg.user_roll.discount_array.record.favor_desc value is empty");
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
                    C4990ab.m7412e("MicroMsg.WalletOfflineUtil", "favor_desc_key is " + str3 + ", payment_amount_key is " + str4 + ", break");
                } else {
                    DiscountInfo discountInfo = new DiscountInfo();
                    discountInfo.pOz = (String) map.get(str3);
                    discountInfo.tBm = C5046bo.getDouble((String) map.get(str4), 0.0d);
                    commodity.tAU.add(discountInfo);
                    i4++;
                }
            }
            C4990ab.m7412e("MicroMsg.WalletOfflineUtil", "favor_desc_key is " + str3 + ", payment_amount_key is " + str4 + ", break");
        }
        AppMethodBeat.m2505o(43673);
        return orders;
    }

    /* renamed from: c */
    private static C31176c m45517c(Map<String, String> map, int i) {
        String str;
        AppMethodBeat.m2504i(43674);
        if (i == 0) {
            str = ".sysmsg.paymsg.user_roll.activity_info.record.exposure_info.";
        } else {
            str = ".sysmsg.paymsg.user_roll.activity_info.record" + i + ".exposure_info.";
        }
        if (map != null) {
            String str2;
            C31176c c31176c = new C31176c();
            c31176c.BTA = C5046bo.getInt((String) map.get(str + "is_query_others"), 0);
            c31176c.wdr = (String) map.get(str + "draw_lottery_params");
            c31176c.wex = C5046bo.getInt((String) map.get(str + "is_show_btn"), 0);
            C44604a c44604a = new C44604a();
            String str3 = str + "btn_info.";
            c44604a.BTs = (String) map.get(str3 + "btn_words");
            c44604a.BTt = (String) map.get(str3 + "btn_color");
            c44604a.BTu = C5046bo.getInt((String) map.get(str3 + "btn_op_type"), 0);
            c44604a.url = (String) map.get(str3 + "url");
            c44604a.wqf = (String) map.get(str3 + "get_lottery_params");
            str3 = str3 + "mini_app_info.";
            c44604a.BTv = new C16442f();
            c44604a.BTv.wMk = (String) map.get(str3 + "activity_tinyapp_username");
            c44604a.BTv.wMl = (String) map.get(str3 + "activity_tinyapp_path");
            c44604a.BTv.wMm = C5046bo.getInt((String) map.get(str3 + "activity_tinyapp_version"), 0);
            if (!(C5046bo.isNullOrNil(c44604a.BTs) && C5046bo.isNullOrNil(c44604a.url) && C5046bo.isNullOrNil(c44604a.wqf) && C5046bo.isNullOrNil(c44604a.BTv.wMk) && C5046bo.isNullOrNil(c44604a.BTv.wMl))) {
                c31176c.wey = c44604a;
            }
            c31176c.BTB = C5046bo.getInt((String) map.get(str + "user_opertaion_type"), 0);
            c31176c.BTC = C5046bo.getInt((String) map.get(str + "is_show_layer"), 0);
            c31176c.BTE = (String) map.get(str + "background_img_whole");
            c31176c.wew = new LinkedList();
            for (int i2 = 0; i2 < 255; i2++) {
                if (i2 == 0) {
                    str2 = str + "single_exposure_info_list.record.";
                } else {
                    str2 = str + "single_exposure_info_list.record" + i2 + ".";
                }
                C44605g c44605g = new C44605g();
                c44605g.pia = (String) map.get(str2 + "logo");
                c44605g.BTP = (String) map.get(str2 + "award_name");
                c44605g.BTQ = (String) map.get(str2 + "award_description");
                c44605g.BTR = (String) map.get(str2 + "background_img");
                c44605g.BTS = (String) map.get(str2 + "award_name_color");
                c44605g.BTT = (String) map.get(str2 + "award_description_color");
                if (!(C5046bo.isNullOrNil(c44605g.pia) && C5046bo.isNullOrNil(c44605g.BTP) && C5046bo.isNullOrNil(c44605g.BTQ) && C5046bo.isNullOrNil(c44605g.BTR) && C5046bo.isNullOrNil(c44605g.BTS) && C5046bo.isNullOrNil(c44605g.BTT))) {
                    c31176c.wew.add(c44605g);
                }
                if (C5046bo.isNullOrNil(c44605g.BTP) || C5046bo.isNullOrNil(c44605g.BTQ)) {
                    break;
                }
            }
            c31176c.BTD = new C31177e();
            str2 = str + "layer_info.";
            c31176c.BTD.BTG = (String) map.get(str2 + "layer_title");
            c31176c.BTD.BTH = (String) map.get(str2 + "layer_logo");
            c31176c.BTD.BTI = (String) map.get(str2 + "layer_type");
            c31176c.BTD.BTJ = (String) map.get(str2 + "layer_name");
            c31176c.BTD.BTK = (String) map.get(str2 + "layer_description");
            c31176c.BTD.BTL = C5046bo.getInt((String) map.get(str2 + "is_show_layer_btn"), 0);
            c31176c.BTD.BTM = new C24578d();
            str3 = str2 + "layer_btn_info.";
            c31176c.BTD.BTM.BTs = (String) map.get(str3 + "btn_words");
            c31176c.BTD.BTM.BTt = (String) map.get(str3 + "btn_color");
            c31176c.BTD.BTM.BTu = C5046bo.getInt((String) map.get(str3 + "btn_op_type"), 0);
            c31176c.BTD.BTM.wqf = (String) map.get(str3 + "get_lottery_params");
            c31176c.BTD.BTM.url = (String) map.get(str3 + "url");
            str3 = str3 + "mini_app_info.";
            c31176c.BTD.BTM.BTv = new C16442f();
            c31176c.BTD.BTM.BTv.wMk = (String) map.get(str3 + "activity_tinyapp_username");
            c31176c.BTD.BTM.BTv.wMl = (String) map.get(str3 + "activity_tinyapp_path");
            c31176c.BTD.BTM.BTv.wMm = C5046bo.getInt((String) map.get(str3 + "activity_tinyapp_version"), 0);
            if (!C5046bo.isNullOrNil((String) map.get(str2 + "voice_url"))) {
                c31176c.BTD.BTN = new C1332b(((String) map.get(str2 + "voice_url")).getBytes());
            }
            if (!C5046bo.isNullOrNil((String) map.get(str2 + "voice_data"))) {
                c31176c.BTD.BTO = new C1332b(((String) map.get(str2 + "voice_data")).getBytes());
            }
            C41148b c41148b = new C41148b();
            str3 = str + "draw_lottery_info.";
            c41148b.url = (String) map.get(str3 + "url");
            c41148b.BTw = (String) map.get(str3 + "animation_wording");
            c41148b.BTx = (String) map.get(str3 + "animation_wording_color");
            c41148b.xis = C5046bo.getInt((String) map.get(str3 + "op_type"), 0);
            c41148b.BTy = (String) map.get(str3 + "after_animation_wording");
            c41148b.BTz = (String) map.get(str3 + "after_animation_wording_color");
            str3 = str3 + "mini_app_info.";
            c41148b.BTv = new C16442f();
            c41148b.BTv.wMk = (String) map.get(str3 + "activity_tinyapp_username");
            c41148b.BTv.wMl = (String) map.get(str3 + "activity_tinyapp_path");
            c41148b.BTv.wMm = C5046bo.getInt((String) map.get(str3 + "activity_tinyapp_version"), 0);
            if (!(C5046bo.isNullOrNil(c41148b.url) && C5046bo.isNullOrNil(c41148b.BTw) && C5046bo.isNullOrNil(c41148b.BTx) && C5046bo.isNullOrNil(c41148b.BTv.wMk) && C5046bo.isNullOrNil(c41148b.BTv.wMl))) {
                c31176c.BTF = c41148b;
            }
            AppMethodBeat.m2505o(43674);
            return c31176c;
        }
        AppMethodBeat.m2505o(43674);
        return null;
    }

    /* renamed from: a */
    private static void m45515a(Orders orders, Map<String, String> map) {
        AppMethodBeat.m2504i(43675);
        if (map != null) {
            orders.tAC = C5046bo.getInt((String) map.get(".sysmsg.paymsg.user_roll.is_use_show_info"), 0);
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
                showInfo.tBG = C5046bo.getInt((String) map.get(str2 + "link_type"), 0);
                showInfo.tBH = (String) map.get(str2 + "link_weapp");
                showInfo.tBI = (String) map.get(str2 + "link_addr");
                showInfo.tBJ = (String) map.get(str2 + "link_url");
                showInfo.tBK = C5046bo.getInt((String) map.get(str2 + "text_attr"), 0);
                if (!C5046bo.isNullOrNil(showInfo.name) || !C5046bo.isNullOrNil(showInfo.value)) {
                    orders.tAE.add(showInfo);
                }
            }
        }
        AppMethodBeat.m2505o(43675);
    }

    /* renamed from: a */
    public static void m45513a(Activity activity, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(43676);
        C4990ab.m7416i("MicroMsg.WalletOfflineUtil", "hy: only transid coming. do old way");
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7412e("MicroMsg.WalletOfflineUtil", "transid == null");
            AppMethodBeat.m2505o(43676);
        } else if (C28630a.bYe()) {
            Bundle bundle = new Bundle();
            if (c1207m instanceof C12736e) {
                RealnameGuideHelper realnameGuideHelper = ((C12736e) c1207m).oYc;
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
            C24143a.m37105a(activity, C34650j.class, bundle);
            AppMethodBeat.m2505o(43676);
        } else {
            AppMethodBeat.m2505o(43676);
        }
    }

    /* renamed from: e */
    public static void m45519e(Activity activity, int i) {
        AppMethodBeat.m2504i(43677);
        C28630a.m45511a(activity, i, -1);
        AppMethodBeat.m2505o(43677);
    }

    /* renamed from: a */
    public static void m45511a(Activity activity, int i, int i2) {
        AppMethodBeat.m2504i(43678);
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
        if (!C14241r.cPI().cQg()) {
            if (C14241r.cPI().cQi()) {
                bundle.putBoolean("key_is_bind_bankcard", true);
                C24143a.m37105a(activity, C31377d.class, bundle);
                AppMethodBeat.m2505o(43678);
                return;
            } else if (C14241r.cPI().cQh()) {
                bundle.putBoolean("key_is_bind_bankcard", true);
                C24143a.m37105a(activity, C31377d.class, bundle);
                AppMethodBeat.m2505o(43678);
                return;
            }
        }
        C24143a.m37105a(activity, C12739c.class, bundle);
        AppMethodBeat.m2505o(43678);
    }

    /* renamed from: f */
    public static void m45522f(Activity activity, int i) {
        AppMethodBeat.m2504i(43679);
        C28630a.m45514a(activity, "create", activity.getString(C25738R.string.fvm), 0, i);
        AppMethodBeat.m2505o(43679);
    }

    /* renamed from: a */
    private static void m45514a(Activity activity, String str, String str2, int i, int i2) {
        AppMethodBeat.m2504i(43680);
        Bundle bundle = new Bundle();
        bundle.putString("oper", str);
        bundle.putInt("offline_chg_fee", i);
        bundle.putString("pwd_tips", str2);
        if (i2 >= 0) {
            bundle.putInt("offline_from_scene", i2);
        }
        C24143a.m37105a(activity, C34646h.class, bundle);
        AppMethodBeat.m2505o(43680);
    }

    /* renamed from: U */
    public static void m45495U(Activity activity) {
        AppMethodBeat.m2504i(43681);
        C28630a.m45514a(activity, "freeze", activity.getString(C25738R.string.fvp), 0, -1);
        AppMethodBeat.m2505o(43681);
    }

    /* renamed from: V */
    public static void m45509V(Activity activity) {
        AppMethodBeat.m2504i(43682);
        C28630a.m45523g(activity, -1);
        AppMethodBeat.m2505o(43682);
    }

    /* renamed from: g */
    public static void m45523g(Activity activity, int i) {
        AppMethodBeat.m2504i(43683);
        C28630a.m45514a(activity, "create", "", C28630a.bYl(), i);
        AppMethodBeat.m2505o(43683);
    }

    /* renamed from: c */
    public static void m45518c(final Activity activity, String str) {
        AppMethodBeat.m2504i(43684);
        C30379h.m48453a((Context) activity, false, str, "", activity.getString(C25738R.string.fw6), activity.getString(C25738R.string.f9076or), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(43646);
                C28630a.bYo();
                C28630a.m45509V(activity);
                activity.finish();
                AppMethodBeat.m2505o(43646);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(43647);
                activity.finish();
                AppMethodBeat.m2505o(43647);
            }
        });
        AppMethodBeat.m2505o(43684);
    }

    public static void bYp() {
        AppMethodBeat.m2504i(43685);
        C7007k.bXg();
        C7007k.m11711aT(196643, "1");
        AppMethodBeat.m2505o(43685);
    }

    /* renamed from: AD */
    public static void m45492AD(int i) {
        AppMethodBeat.m2504i(43686);
        C7007k.bXg();
        C7007k.m11711aT(196644, String.valueOf(i));
        AppMethodBeat.m2505o(43686);
    }

    public static int bYq() {
        AppMethodBeat.m2504i(43687);
        C7007k.bXg();
        String Ax = C7007k.m11709Ax(196644);
        if (TextUtils.isEmpty(Ax) || !C28630a.isNumeric(Ax)) {
            AppMethodBeat.m2505o(43687);
            return 0;
        }
        int intValue = Integer.valueOf(Ax).intValue();
        AppMethodBeat.m2505o(43687);
        return intValue;
    }

    public static String getToken() {
        AppMethodBeat.m2504i(43688);
        String str;
        if (TextUtils.isEmpty(paY)) {
            C28630a.bYt();
            if (TextUtils.isEmpty(paY)) {
                C4990ab.m7412e("MicroMsg.WalletOfflineUtil", "token is null");
            }
            str = paY;
            AppMethodBeat.m2505o(43688);
            return str;
        }
        str = paY;
        AppMethodBeat.m2505o(43688);
        return str;
    }

    /* renamed from: r */
    public static void m45525r(String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(43689);
        paY = str;
        paZ = str2;
        pbb = str3;
        pbc = str4;
        C28630a.m45498Uf(pbb);
        C1720g.m3535RO().eJo.mo14541a(new C6668bk(new C286333()), 0);
        AppMethodBeat.m2505o(43689);
    }

    public static String bYr() {
        AppMethodBeat.m2504i(43690);
        String str;
        if (TextUtils.isEmpty(paZ)) {
            C28630a.bYt();
            if (TextUtils.isEmpty(paZ)) {
                C4990ab.m7412e("MicroMsg.WalletOfflineUtil", "offline_token_v2 is null");
            }
            str = paZ;
            AppMethodBeat.m2505o(43690);
            return str;
        }
        str = paZ;
        AppMethodBeat.m2505o(43690);
        return str;
    }

    public static String bYs() {
        AppMethodBeat.m2504i(43691);
        String str;
        if (!TextUtils.isEmpty(pbb)) {
            str = pbb;
            AppMethodBeat.m2505o(43691);
            return str;
        } else if (TextUtils.isEmpty(pbb)) {
            C7007k.bXg();
            str = C7007k.m11709Ax(196656);
            pbb = str;
            AppMethodBeat.m2505o(43691);
            return str;
        } else {
            if (TextUtils.isEmpty(pbb)) {
                C4990ab.m7412e("MicroMsg.WalletOfflineUtil", "offline_card_list is null");
            }
            str = pbb;
            AppMethodBeat.m2505o(43691);
            return str;
        }
    }

    /* renamed from: Uf */
    public static void m45498Uf(String str) {
        AppMethodBeat.m2504i(43692);
        C7007k.bXg();
        C7007k.m11711aT(196656, str);
        pbb = str;
        AppMethodBeat.m2505o(43692);
    }

    private static void bYt() {
        AppMethodBeat.m2504i(43693);
        C1720g.m3535RO().eJo.mo14541a(new C6668bk(new C286324()), 0);
        AppMethodBeat.m2505o(43693);
    }

    /* renamed from: Ug */
    public static LinkedList<C28635a> m45499Ug(String str) {
        LinkedList<C28635a> linkedList = null;
        AppMethodBeat.m2504i(43694);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(43694);
        } else {
            try {
                linkedList = C28630a.m45526t(new JSONArray(str));
                AppMethodBeat.m2505o(43694);
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.WalletOfflineUtil", e, "", new Object[0]);
                AppMethodBeat.m2505o(43694);
            }
        }
        return linkedList;
    }

    /* renamed from: t */
    private static LinkedList<C28635a> m45526t(JSONArray jSONArray) {
        AppMethodBeat.m2504i(43695);
        if (jSONArray.length() == 0) {
            AppMethodBeat.m2505o(43695);
            return null;
        }
        LinkedList<C28635a> linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject != null) {
                C28635a c28635a = new C28635a();
                c28635a.pbm = jSONObject.optInt("card_id");
                c28635a.pbn = jSONObject.optString("bank_type");
                c28635a.pbo = jSONObject.optString("bind_serial");
                c28635a.pbp = jSONObject.optString("forbid_word");
                linkedList.add(c28635a);
            }
        }
        AppMethodBeat.m2505o(43695);
        return linkedList;
    }

    public static String bYu() {
        AppMethodBeat.m2504i(43696);
        C7007k.bXg();
        String Ax = C7007k.m11709Ax(196647);
        AppMethodBeat.m2505o(43696);
        return Ax;
    }

    private static String bYv() {
        AppMethodBeat.m2504i(43697);
        C7007k.bXg();
        String Ax = C7007k.m11709Ax(196616);
        AppMethodBeat.m2505o(43697);
        return Ax;
    }

    /* renamed from: Uh */
    public static void m45500Uh(String str) {
        AppMethodBeat.m2504i(43698);
        C7007k.bXg();
        C7007k.m11711aT(196616, str);
        AppMethodBeat.m2505o(43698);
    }

    /* renamed from: W */
    public static void m45510W(Activity activity) {
        AppMethodBeat.m2504i(43699);
        C30379h.m48465bQ(activity, activity.getResources().getString(C25738R.string.fvn));
        if (!TextUtils.isEmpty(C28630a.bYv())) {
            C28630a.m45516aL(activity, C28630a.bYv());
        }
        AppMethodBeat.m2505o(43699);
    }

    public static boolean bYw() {
        int i = 0;
        AppMethodBeat.m2504i(43700);
        ArrayList nf = C14241r.cPI().mo38171nf(true);
        LinkedList Ug = C28630a.m45499Ug(C28630a.bYs());
        if (Ug == null || nf.size() != Ug.size()) {
            AppMethodBeat.m2505o(43700);
            return false;
        }
        Collections.sort(Ug, pbl);
        Collections.sort(nf, pbk);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < Ug.size(); i2++) {
            stringBuilder.append(((C28635a) Ug.get(i2)).pbo);
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        while (i < nf.size()) {
            stringBuilder2.append(((Bankcard) nf.get(i)).field_bindSerial);
            i++;
        }
        boolean equals = C4995ag.m7428ck(stringBuilder.toString()).equals(C4995ag.m7428ck(stringBuilder2.toString()));
        AppMethodBeat.m2505o(43700);
        return equals;
    }

    private static String bYx() {
        AppMethodBeat.m2504i(43701);
        String Ax;
        if (TextUtils.isEmpty(pbd)) {
            C7007k.bXg();
            Ax = C7007k.m11709Ax(196615);
            pbd = Ax;
            AppMethodBeat.m2505o(43701);
            return Ax;
        }
        Ax = pbd;
        AppMethodBeat.m2505o(43701);
        return Ax;
    }

    /* renamed from: Ui */
    public static void m45501Ui(String str) {
        AppMethodBeat.m2504i(43702);
        C7007k.bXg();
        C7007k.m11711aT(196615, str);
        pbd = str;
        AppMethodBeat.m2505o(43702);
    }

    /* renamed from: Uj */
    private static LinkedList<C21412b> m45502Uj(String str) {
        LinkedList<C21412b> linkedList = null;
        AppMethodBeat.m2504i(43703);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(43703);
        } else {
            try {
                linkedList = C28630a.m45527u(new JSONArray(str));
                AppMethodBeat.m2505o(43703);
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.WalletOfflineUtil", e, "", new Object[0]);
                AppMethodBeat.m2505o(43703);
            }
        }
        return linkedList;
    }

    /* renamed from: u */
    private static LinkedList<C21412b> m45527u(JSONArray jSONArray) {
        AppMethodBeat.m2504i(43704);
        if (jSONArray.length() == 0) {
            AppMethodBeat.m2505o(43704);
            return null;
        }
        LinkedList<C21412b> linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject != null) {
                C21412b c21412b = new C21412b();
                c21412b.pbn = jSONObject.optString("bank_type");
                c21412b.kKZ = jSONObject.optString("icon_url");
                linkedList.add(c21412b);
            }
        }
        AppMethodBeat.m2505o(43704);
        return linkedList;
    }

    public static int bYy() {
        AppMethodBeat.m2504i(43705);
        C7007k.bXg();
        String Ax = C7007k.m11709Ax(196649);
        if (TextUtils.isEmpty(Ax) || !C28630a.isNumeric(Ax)) {
            AppMethodBeat.m2505o(43705);
            return 0;
        }
        int intValue = Integer.valueOf(Ax).intValue();
        AppMethodBeat.m2505o(43705);
        return intValue;
    }

    public static boolean bYz() {
        AppMethodBeat.m2504i(43706);
        String bYm = C28630a.bYm();
        if (TextUtils.isEmpty(bYm)) {
            AppMethodBeat.m2505o(43706);
            return false;
        }
        if ((System.currentTimeMillis() / 1000) - Long.valueOf(bYm).longValue() >= ((long) C28630a.bYy())) {
            AppMethodBeat.m2505o(43706);
            return true;
        }
        AppMethodBeat.m2505o(43706);
        return false;
    }

    /* renamed from: Uk */
    public static String m45503Uk(String str) {
        AppMethodBeat.m2504i(43707);
        LinkedList Uj = C28630a.m45502Uj(C28630a.bYx());
        String str2;
        if (Uj == null) {
            str2 = "";
            AppMethodBeat.m2505o(43707);
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
            C21412b c21412b = (C21412b) Uj.get(i2);
            if (c21412b != null && str.equals(c21412b.pbn)) {
                str2 = c21412b.kKZ;
                break;
            }
            i = i2 + 1;
        }
        AppMethodBeat.m2505o(43707);
        return str2;
    }

    /* renamed from: Ul */
    public static String m45504Ul(String str) {
        int i = 0;
        AppMethodBeat.m2504i(43708);
        LinkedList Ug = C28630a.m45499Ug(C28630a.bYs());
        LinkedList Uj = C28630a.m45502Uj(C28630a.bYx());
        String str2;
        if (Ug == null || Uj == null || Ug.size() == 0 || Uj.size() == 0) {
            C4990ab.m7412e("MicroMsg.WalletOfflineUtil", "getBankLogoUrl() cardList == null || cardLogoList == null || cardList.size() == 0 || cardLogoList.size() == 0");
            str2 = "";
            AppMethodBeat.m2505o(43708);
            return str2;
        }
        CharSequence charSequence;
        String str3 = "";
        for (int i2 = 0; i2 < Ug.size(); i2++) {
            C28635a c28635a = (C28635a) Ug.get(i2);
            if (c28635a != null && str.equals(c28635a.pbo)) {
                charSequence = c28635a.pbn;
                break;
            }
        }
        Object charSequence2 = str3;
        if (TextUtils.isEmpty(charSequence2)) {
            C4990ab.m7412e("MicroMsg.WalletOfflineUtil", "getBankLogoUrl() bank_type == null, can not find this bank_type");
            str2 = "";
            AppMethodBeat.m2505o(43708);
            return str2;
        }
        str3 = "";
        while (i < Uj.size()) {
            C21412b c21412b = (C21412b) Uj.get(i);
            if (c21412b != null && charSequence2.equals(c21412b.pbn)) {
                str2 = c21412b.kKZ;
                break;
            }
            i++;
        }
        str2 = str3;
        AppMethodBeat.m2505o(43708);
        return str2;
    }

    /* renamed from: eA */
    public static boolean m45520eA(Context context) {
        AppMethodBeat.m2504i(43709);
        List runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        if (!(runningTasks == null || runningTasks.isEmpty())) {
            ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
            C4990ab.m7410d("MicroMsg.WalletOfflineUtil", "topActivity:" + componentName.flattenToString());
            if (!componentName.getPackageName().equals(context.getPackageName())) {
                C4990ab.m7416i("MicroMsg.WalletOfflineUtil", "is in backGround.");
                AppMethodBeat.m2505o(43709);
                return false;
            }
        }
        if (((KeyguardManager) C4996ah.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            AppMethodBeat.m2505o(43709);
            return false;
        }
        C4990ab.m7416i("MicroMsg.WalletOfflineUtil", "is in foreGround.");
        AppMethodBeat.m2505o(43709);
        return true;
    }

    /* renamed from: Um */
    public static void m45505Um(String str) {
        AppMethodBeat.m2504i(43710);
        C1720g.m3536RP().mo5239Ry().set(C5127a.BUSINESS_OFFLINE_GETMSG_ACK_KEY_STRING, (Object) str);
        AppMethodBeat.m2505o(43710);
    }

    public static String bYA() {
        AppMethodBeat.m2504i(43711);
        Object obj = C1720g.m3536RP().mo5239Ry().get(C5127a.BUSINESS_OFFLINE_GETMSG_ACK_KEY_STRING, (Object) "");
        if (obj != null) {
            String str = (String) obj;
            AppMethodBeat.m2505o(43711);
            return str;
        }
        AppMethodBeat.m2505o(43711);
        return null;
    }

    /* renamed from: Un */
    public static void m45506Un(String str) {
        AppMethodBeat.m2504i(43712);
        C1720g.m3536RP().mo5239Ry().set(C5127a.BUSINESS_OFFLINE_GETMSG_REQ_KEY_STRING, (Object) str);
        AppMethodBeat.m2505o(43712);
    }

    public static String bYB() {
        AppMethodBeat.m2504i(43713);
        Object obj = C1720g.m3536RP().mo5239Ry().get(C5127a.BUSINESS_OFFLINE_GETMSG_REQ_KEY_STRING, (Object) "");
        if (obj != null) {
            String str = (String) obj;
            AppMethodBeat.m2505o(43713);
            return str;
        }
        AppMethodBeat.m2505o(43713);
        return null;
    }

    /* renamed from: AE */
    public static void m45493AE(int i) {
        AppMethodBeat.m2504i(43714);
        if (i < 0) {
            i = 0;
        }
        C1720g.m3536RP().mo5239Ry().set(C5127a.BUSINESS_OFFLINE_GETMSG_PAYMSG_TYPE_INT, Integer.valueOf(i));
        AppMethodBeat.m2505o(43714);
    }

    public static int bYC() {
        int intValue;
        AppMethodBeat.m2504i(43715);
        Object obj = C1720g.m3536RP().mo5239Ry().get(C5127a.BUSINESS_OFFLINE_GETMSG_PAYMSG_TYPE_INT, null);
        if (obj != null) {
            intValue = ((Integer) obj).intValue();
        } else {
            intValue = 0;
        }
        if (intValue < 0) {
            intValue = 0;
        }
        AppMethodBeat.m2505o(43715);
        return intValue;
    }

    /* renamed from: Uo */
    public static void m45507Uo(String str) {
        AppMethodBeat.m2504i(43716);
        C1720g.m3536RP().mo5239Ry().set(C5127a.BUSINESS_OFFLINE_GETMSG_TRANS_ID_STRING, (Object) str);
        AppMethodBeat.m2505o(43716);
    }

    public static String bYD() {
        AppMethodBeat.m2504i(43717);
        Object obj = C1720g.m3536RP().mo5239Ry().get(C5127a.BUSINESS_OFFLINE_GETMSG_TRANS_ID_STRING, (Object) "");
        if (obj != null) {
            String str = (String) obj;
            AppMethodBeat.m2505o(43717);
            return str;
        }
        AppMethodBeat.m2505o(43717);
        return null;
    }

    public static int getNetworkType(Context context) {
        int i;
        AppMethodBeat.m2504i(43718);
        if (!C5023at.isConnected(context)) {
            i = -1;
        } else if (C5023at.isWifi(context)) {
            i = 1;
        } else if (C5023at.is2G(context)) {
            i = 2;
        } else if (C5023at.is3G(context)) {
            i = 3;
        } else if (C5023at.is4G(context)) {
            i = 4;
        } else {
            i = 0;
        }
        AppMethodBeat.m2505o(43718);
        return i;
    }

    public static boolean bYE() {
        Map dru;
        AppMethodBeat.m2504i(43719);
        boolean z = false;
        C5141c ll = C18624c.abi().mo17131ll("100232");
        if (ll.isValid()) {
            dru = ll.dru();
            if (dru.containsKey("open") && "1".equals(dru.get("open"))) {
                C4990ab.m7412e("MicroMsg.WalletOfflineUtil", "deprecated abtest 100232 enabled.");
            }
        }
        ll = C18624c.abi().mo17131ll("100261");
        if (ll.isValid()) {
            dru = ll.dru();
            if (dru.containsKey("open") && "1".equals(dru.get("open"))) {
                z = true;
            }
        }
        C4990ab.m7416i("MicroMsg.WalletOfflineUtil", "isPosEnabled: ".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(43719);
        return z;
    }

    /* renamed from: Up */
    public static void m45508Up(String str) {
        AppMethodBeat.m2504i(43720);
        C4990ab.m7417i("MicroMsg.WalletOfflineUtil", "launch 3rd app: %s", str);
        C40439f bT = C46494g.m87739bT(str, true);
        if (bT == null) {
            C4990ab.m7420w("MicroMsg.WalletOfflineUtil", "can not find app info");
            AppMethodBeat.m2505o(43720);
            return;
        }
        Bundle bundle = new Bundle();
        Resp resp = new Resp();
        resp.errCode = 0;
        resp.toBundle(bundle);
        Args args = new Args();
        args.targetPkgName = bT.field_packageName;
        args.bundle = bundle;
        C35799p.m58687at(bundle);
        C35799p.m58688au(bundle);
        MMessageActV2.send(C4996ah.getContext(), args);
        AppMethodBeat.m2505o(43720);
    }

    @Deprecated
    public static Bankcard bYf() {
        Bankcard bankcard;
        AppMethodBeat.m2504i(43654);
        C14241r.cPI();
        C1720g.m3537RQ();
        String str = (String) C1720g.m3536RP().mo5239Ry().get(196633, null);
        C4990ab.m7417i("MicroMsg.WalletPayOrderMgr", "step 1 getSelectedBindBankCard %s", str);
        ArrayList nf = C14241r.cPI().mo38171nf(true);
        int i = 0;
        while (!TextUtils.isEmpty(str) && i < nf.size()) {
            bankcard = (Bankcard) nf.get(i);
            if (bankcard != null && str.equals(bankcard.field_bindSerial)) {
                C4990ab.m7417i("MicroMsg.WalletPayOrderMgr", "step 2 micropay: %s, forbidword: %s", Boolean.valueOf(bankcard.field_support_micropay), bankcard.field_forbidWord);
                if (bankcard.field_support_micropay) {
                    AppMethodBeat.m2505o(43654);
                    return bankcard;
                }
            }
            i++;
        }
        C4990ab.m7416i("MicroMsg.WalletPayOrderMgr", "step 3 clear default bindserial");
        C14241r.cPI();
        C22587ak.acF("");
        C14241r.cPI();
        bankcard = C22587ak.cQR();
        if (bankcard == null || !C5046bo.isNullOrNil(bankcard.field_forbidWord)) {
            int i2 = 0;
            while (i2 < nf.size()) {
                Bankcard bankcard2 = (Bankcard) nf.get(i2);
                if (bankcard2 == null || !bankcard2.field_support_micropay || bankcard2.cPc()) {
                    i2++;
                } else {
                    C4990ab.m7417i("MicroMsg.WalletPayOrderMgr", "do change first card: %s", bankcard2.field_bankcardType);
                    AppMethodBeat.m2505o(43654);
                    return bankcard2;
                }
            }
            bankcard = C14241r.cPI().thy;
            if (bankcard == null || !bankcard.field_support_micropay) {
                bankcard = C14241r.cPI().tCZ;
                if (bankcard != null && bankcard.field_support_micropay && C5046bo.isNullOrNil(bankcard.field_forbidWord)) {
                    C4990ab.m7417i("MicroMsg.WalletPayOrderMgr", "do change balance: %s", bankcard.field_bankcardType);
                    AppMethodBeat.m2505o(43654);
                    return bankcard;
                }
                AppMethodBeat.m2505o(43654);
                return null;
            }
            C4990ab.m7417i("MicroMsg.WalletPayOrderMgr", "do change balance: %s", bankcard.field_bankcardType);
            AppMethodBeat.m2505o(43654);
            return bankcard;
        }
        C4990ab.m7417i("MicroMsg.WalletPayOrderMgr", "do change main card: %s", bankcard.field_bankcardType);
        AppMethodBeat.m2505o(43654);
        return bankcard;
    }

    private static int bYl() {
        int i;
        AppMethodBeat.m2504i(43661);
        C7007k.bXg();
        String Ax = C7007k.m11709Ax(196640);
        if (TextUtils.isEmpty(Ax) || !C28630a.isNumeric(Ax)) {
            i = 0;
        } else {
            i = Integer.valueOf(Ax).intValue();
        }
        if (i > 0) {
            i *= 100;
        } else {
            i = C1625i.sHCENCODEVIDEOTIMEOUT;
        }
        AppMethodBeat.m2505o(43661);
        return i;
    }
}
