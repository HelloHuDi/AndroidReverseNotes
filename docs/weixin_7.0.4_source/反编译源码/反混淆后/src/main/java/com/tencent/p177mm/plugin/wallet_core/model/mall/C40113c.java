package com.tencent.p177mm.plugin.wallet_core.model.mall;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.mall.c */
public final class C40113c {
    private static C40113c tDD = null;
    public Map<String, MallNews> tDE = new HashMap();

    public static C40113c cQT() {
        AppMethodBeat.m2504i(47021);
        if (tDD == null) {
            tDD = new C40113c();
        }
        C40113c c40113c = tDD;
        AppMethodBeat.m2505o(47021);
        return c40113c;
    }

    private C40113c() {
        AppMethodBeat.m2504i(47022);
        mo63442Kh();
        AppMethodBeat.m2505o(47022);
    }

    /* renamed from: Kh */
    public final void mo63442Kh() {
        AppMethodBeat.m2504i(47023);
        this.tDE.clear();
        C1720g.m3537RQ();
        String str = (String) C1720g.m3536RP().mo5239Ry().get(270339, (Object) "");
        C4990ab.m7410d("MicroMsg.MallNewsManager", "data : ".concat(String.valueOf(str)));
        for (String str2 : C5046bo.m7508P(str2.split(";"))) {
            MallNews acJ = C40113c.acJ(str2);
            if (acJ != null) {
                this.tDE.put(acJ.fsT, acJ);
            }
        }
        AppMethodBeat.m2505o(47023);
    }

    public final List<String> cQU() {
        AppMethodBeat.m2504i(47024);
        ArrayList arrayList = new ArrayList();
        for (MallNews mallNews : this.tDE.values()) {
            if (!C5046bo.isNullOrNil(mallNews.cxb)) {
                arrayList.add(mallNews.cxb);
            }
        }
        C4990ab.m7410d("MicroMsg.MallNewsManager", "tickets.size : " + arrayList.size());
        AppMethodBeat.m2505o(47024);
        return arrayList;
    }

    /* renamed from: a */
    public static boolean m68764a(MallNews mallNews) {
        AppMethodBeat.m2504i(47025);
        C1720g.m3537RQ();
        ArrayList P = C5046bo.m7508P(((String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_MALL_NEWS_MARKED_STRING_SYNC, (Object) "")).split(","));
        C4990ab.m7417i("MicroMsg.MallNewsManager", "tryCheckOutOfDateRedDot markedString %s", r0);
        if (mallNews == null) {
            AppMethodBeat.m2505o(47025);
            return false;
        } else if (C5046bo.isNullOrNil(mallNews.ssr)) {
            AppMethodBeat.m2505o(47025);
            return false;
        } else if (P.contains(mallNews.ssr)) {
            AppMethodBeat.m2505o(47025);
            return true;
        } else {
            AppMethodBeat.m2505o(47025);
            return false;
        }
    }

    /* renamed from: e */
    public static void m68765e(MallFunction mallFunction) {
        AppMethodBeat.m2504i(47026);
        try {
            if (!C5046bo.isNullOrNil(mallFunction.tDn.ssr)) {
                C1720g.m3537RQ();
                List P = C5046bo.m7508P(((String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_MALL_NEWS_MARKED_STRING_SYNC, (Object) "")).split(","));
                while (P.size() > 20) {
                    P.remove(0);
                }
                if (P.contains(mallFunction.tDn.ssr)) {
                    AppMethodBeat.m2505o(47026);
                    return;
                }
                P.add(mallFunction.tDn.ssr);
                C4990ab.m7417i("MicroMsg.MallNewsManager", "doSelectFunction %s, markedString %s", mallFunction.tDn.ssr, C5046bo.m7536c(P, ","));
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_MALL_NEWS_MARKED_STRING_SYNC, r0);
            }
            AppMethodBeat.m2505o(47026);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MallNewsManager", e, "error in markedFunction", new Object[0]);
            AppMethodBeat.m2505o(47026);
        }
    }

    public static void acG(String str) {
        AppMethodBeat.m2504i(47027);
        if (!C5046bo.isNullOrNil(str)) {
            Map z = C5049br.m7595z(str, "sysmsg");
            if (z != null) {
                int i = C5046bo.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), -1);
                Object obj;
                int i2;
                String str2;
                String str3;
                String str4;
                if (i == 31) {
                    obj = (String) z.get(".sysmsg.paymsg.WalletRedDotWording");
                    i2 = C5046bo.getInt((String) z.get(".sysmsg.paymsg.WalletRedDot"), -1);
                    C4990ab.m7417i("MicroMsg.MallNewsManager", "walletEntryWording: %s, balanceRedDot: %s, lqtRedDot: %s", obj, Integer.valueOf(C5046bo.getInt((String) z.get(".sysmsg.paymsg.BalanceRedDot"), -1)), Integer.valueOf(C5046bo.getInt((String) z.get(".sysmsg.paymsg.LQTRedDot"), -1)));
                    C1720g.m3537RQ();
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_LQT_WALLET_RED_DOT_WORDING_STRING, obj);
                    C1720g.m3537RQ();
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_LQT_WALLET_RED_DOT_INT, Integer.valueOf(i2));
                    C1720g.m3537RQ();
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_LQT_BALANCE_RED_DOT_INT, Integer.valueOf(r3));
                    C1720g.m3537RQ();
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_LQT_LINK_RED_DOT_INT, Integer.valueOf(r1));
                    C40113c.cQW();
                    AppMethodBeat.m2505o(47027);
                    return;
                } else if (i == 34) {
                    Set<String> keySet = z.keySet();
                    C4990ab.m7417i("MicroMsg.MallNewsManager", "receive menu ui reddot msg: %s, keys: %s", str, keySet.toString());
                    if (keySet.size() > 0) {
                        JSONObject jSONObject = new JSONObject();
                        for (String str22 : keySet) {
                            if (str22.startsWith(".sysmsg.paymsg.reddot.item")) {
                                str3 = (String) z.get(str22);
                                str4 = str22 + ".$wording";
                                String str5 = str22 + ".$expire_time";
                                obj = (String) z.get(str4);
                                long j = C5046bo.getLong((String) z.get(str5), 0) * 1000;
                                if (!C5046bo.isNullOrNil(str3)) {
                                    C4990ab.m7417i("MicroMsg.MallNewsManager", "mall menu ui, %s has reddot, wording: %s, expireTime: %s", str3, obj, Long.valueOf(j));
                                    if ("mainentry_me".equals(str3)) {
                                        C1720g.m3537RQ();
                                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_MY_ENTRY_TAB_REDDOT_BOOLEAN_SYNC, Boolean.TRUE);
                                        if (j > 0) {
                                            C1720g.m3537RQ();
                                            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_MY_ENTRY_TAB_REDDOT_EXPIRETIME_LONG_SYNC, Long.valueOf(j));
                                        }
                                    } else if ("entry_wxpay_wallet".equals(str3)) {
                                        C1720g.m3537RQ();
                                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_MY_ENTRY_REDDOT_BOOLEAN_SYNC, Boolean.TRUE);
                                        if (C5046bo.isNullOrNil(obj)) {
                                            C1720g.m3537RQ();
                                            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_ENTRY_WORDING_STRING_SYNC, (Object) "");
                                        } else {
                                            C1720g.m3537RQ();
                                            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_ENTRY_WORDING_STRING_SYNC, obj);
                                        }
                                        if (j > 0) {
                                            C1720g.m3537RQ();
                                            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_MY_ENTRY_REDDOT_EXPIRETIME_LONG_SYNC, Long.valueOf(j));
                                        }
                                    } else if ("entry_wxpay_paycenter".equals(str3)) {
                                        C1720g.m3537RQ();
                                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_MALL_MENU_UI_REDDOT_CONFIG_BOOLEAN_SYNC, Boolean.TRUE);
                                        if (j > 0) {
                                            C1720g.m3537RQ();
                                            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_MALL_MENU_UI_REDDOT_CONFIG_EXPIRETIME_LONG_SYNC, Long.valueOf(j));
                                        }
                                    } else {
                                        try {
                                            jSONObject.put(str3, 1);
                                            if (j > 0) {
                                                jSONObject.put(String.format("%s_expiretime", new Object[]{str3}), j);
                                            }
                                        } catch (Exception e) {
                                            C4990ab.printErrStackTrace("MicroMsg.MallNewsManager", e, "put redDotConfig json failed: %s", e.getMessage());
                                        }
                                    }
                                }
                            }
                        }
                        C4990ab.m7417i("MicroMsg.MallNewsManager", "redDotConfig: %s", jSONObject.toString());
                        if (jSONObject.length() > 0) {
                            C1720g.m3537RQ();
                            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_MENU_UI_REDDOT_CONFIG_STRING_SYNC, jSONObject.toString());
                            C1720g.m3537RQ();
                            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_MALL_MENU_UI_REDDOT_CONFIG_BOOLEAN_SYNC, Boolean.TRUE);
                        }
                    }
                    AppMethodBeat.m2505o(47027);
                    return;
                } else if (i == 36) {
                    C4990ab.m7417i("MicroMsg.MallNewsManager", "walletEntryWording: %s, walletRedDot: %s, lqbRedDot: %s", (String) z.get(".sysmsg.paymsg.WalletRedDotWording"), Integer.valueOf(C5046bo.getInt((String) z.get(".sysmsg.paymsg.WalletRedDot"), -1)), Integer.valueOf(C5046bo.getInt((String) z.get(".sysmsg.paymsg.LQBRedDot"), -1)));
                    C1720g.m3537RQ();
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_LQT_WALLET_RED_DOT_WORDING_STRING, obj);
                    C1720g.m3537RQ();
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_LQT_WALLET_RED_DOT_INT, Integer.valueOf(i2));
                    C1720g.m3537RQ();
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_LQB_MALL_ENTRY_RED_DOT_INT, Integer.valueOf(r1));
                    C40113c.cQW();
                    AppMethodBeat.m2505o(47027);
                    return;
                } else if (i == 38) {
                    Set<String> keySet2 = z.keySet();
                    C4990ab.m7417i("MicroMsg.MallNewsManager", "receive menu ui reddot msg: %s, keys: %s", str, keySet2.toString());
                    if (keySet2.size() > 0) {
                        JSONObject jSONObject2 = new JSONObject();
                        Object obj2 = null;
                        Object obj3 = null;
                        for (String str222 : keySet2) {
                            if (str222.startsWith(".sysmsg.paymsg.reddot.item")) {
                                str4 = (String) z.get(str222);
                                str3 = str222 + ".$wording";
                                String str6 = str222 + ".$expire_time";
                                obj = (String) z.get(str3);
                                long j2 = C5046bo.getLong((String) z.get(str6), 0) * 1000;
                                if (!C5046bo.isNullOrNil(str4)) {
                                    C4990ab.m7417i("MicroMsg.MallNewsManager", "mall menu ui, %s has reddot, wording: %s, expireTime: %s", str4, obj, Long.valueOf(j2));
                                    if ("mainentry_me".equals(str4)) {
                                        C16112c.m24429PK().mo28548b(C5127a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_STRING_SYNC, true);
                                        C1720g.m3537RQ();
                                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_EXPIRETIME_LONG_SYNC, Long.valueOf(j2));
                                        obj3 = 1;
                                    } else if ("entry_wxpay_pay".equals(str4)) {
                                        C16112c.m24429PK().mo28548b(C5127a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_STRING_SYNC, true);
                                        if (C5046bo.isNullOrNil(obj)) {
                                            C1720g.m3537RQ();
                                            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_New_MY_ENTRY_WORDING_STRING_SYNC, (Object) "");
                                        } else {
                                            C1720g.m3537RQ();
                                            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_New_MY_ENTRY_WORDING_STRING_SYNC, obj);
                                        }
                                        C1720g.m3537RQ();
                                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_New_MY_ENTRY_REDDOT_EXPIRETIME_LONG_SYNC, Long.valueOf(j2));
                                        obj2 = 1;
                                    } else if ("entry_wxpay_pay_wallet".equals(str4)) {
                                        C1720g.m3537RQ();
                                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_New_MALL_UI_REDDOT_CONFIG_BOOLEAN_SYNC, Boolean.TRUE);
                                        C1720g.m3537RQ();
                                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_New_MALL_UI_REDDOT_CONFIG_EXPIRETIME_LONG_SYNC, Long.valueOf(j2));
                                    } else if (str4.startsWith("bind_serial_")) {
                                        str4 = str4.substring(12);
                                        C1720g.m3537RQ();
                                        str222 = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_BANKCARD_SERIAL_STRING_SYNC, (Object) "");
                                        C4990ab.m7411d("MicroMsg.MallNewsManager", "bind serial: %s", str4);
                                        if (C5046bo.isNullOrNil(str222)) {
                                            str222 = str4;
                                        } else {
                                            obj = str222 + "," + str4;
                                        }
                                        C1720g.m3537RQ();
                                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_BANKCARD_SERIAL_STRING_SYNC, obj);
                                    } else {
                                        try {
                                            jSONObject2.put(str4, 1);
                                            jSONObject2.put(String.format("%s_expiretime", new Object[]{str4}), j2);
                                        } catch (Exception e2) {
                                            C4990ab.printErrStackTrace("MicroMsg.MallNewsManager", e2, "put redDotConfig json failed: %s", e2.getMessage());
                                        }
                                    }
                                }
                            }
                        }
                        if (obj3 == null) {
                            C16112c.m24429PK().mo28554c(C5127a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_STRING_SYNC, C5127a.USERINFO_NEW_BANDAGE_WATCHER_ME_TAB_STRING_SYNC);
                        }
                        if (obj2 == null) {
                            C16112c.m24429PK().mo28554c(C5127a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_STRING_SYNC, C5127a.USERINFO_NEW_BANDAGE_WATCHER_PAY_ENTRANCE_STRING_SYNC);
                        }
                        C4990ab.m7417i("MicroMsg.MallNewsManager", "redDotConfig: %s", jSONObject2.toString());
                        if (jSONObject2.length() > 0) {
                            C1720g.m3537RQ();
                            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_New_MALL_UI_ITEM_REDDOT_CONFIG_STRING_SYNC, jSONObject2.toString());
                            C1720g.m3537RQ();
                            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_New_MALL_UI_REDDOT_CONFIG_BOOLEAN_SYNC, Boolean.TRUE);
                        }
                    }
                }
            }
        }
        AppMethodBeat.m2505o(47027);
    }

    public static void cQV() {
        AppMethodBeat.m2504i(47028);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_LQT_WALLET_RED_DOT_WORDING_STRING, (Object) "");
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_LQT_WALLET_RED_DOT_INT, Integer.valueOf(-1));
        AppMethodBeat.m2505o(47028);
    }

    public static void cQW() {
        AppMethodBeat.m2504i(47029);
        C4990ab.m7410d("MicroMsg.MallNewsManager", "clearMallNew ");
        C16112c.m24429PK().mo28553bZ(262156, 266248);
        AppMethodBeat.m2505o(47029);
    }

    public final boolean bZX() {
        AppMethodBeat.m2504i(47030);
        C4990ab.m7410d("MicroMsg.MallNewsManager", "notifyNewsMap.size : " + this.tDE.size());
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : this.tDE.keySet()) {
            if (!C5046bo.isNullOrNil(str)) {
                MallNews mallNews = (MallNews) this.tDE.get(str);
                stringBuffer.append(mallNews.tDB.replace("</mallactivity></sysmsg>", "").replaceAll("<showflag>([^<]*)</showflag>", "").replaceAll("<newsTipFlag>([^<]*)</newsTipFlag>", "") + "<showflag>" + mallNews.tDt + "</showflag><newsTipFlag>" + mallNews.tDu + "</newsTipFlag></mallactivity></sysmsg>;");
            }
        }
        C4990ab.m7410d("MicroMsg.MallNewsManager", "save data  : " + stringBuffer.toString());
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(270339, stringBuffer.toString());
        AppMethodBeat.m2505o(47030);
        return true;
    }

    public final String acH(String str) {
        AppMethodBeat.m2504i(47031);
        MallNews mallNews = (MallNews) this.tDE.get(str);
        if (mallNews == null || C5046bo.isNullOrNil(mallNews.cxb)) {
            AppMethodBeat.m2505o(47031);
            return null;
        }
        String str2 = mallNews.cxb;
        AppMethodBeat.m2505o(47031);
        return str2;
    }

    public final MallNews acI(String str) {
        AppMethodBeat.m2504i(47032);
        C4990ab.m7410d("MicroMsg.MallNewsManager", "removeNewsInIndexUI : ".concat(String.valueOf(str)));
        if (C5046bo.isNullOrNil(str) || !this.tDE.containsKey(str)) {
            AppMethodBeat.m2505o(47032);
            return null;
        }
        MallNews mallNews = (MallNews) this.tDE.get(str);
        if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(mallNews.tDt)) {
            mallNews.tDt = "1";
            bZX();
        }
        AppMethodBeat.m2505o(47032);
        return mallNews;
    }

    public static MallNews acJ(String str) {
        AppMethodBeat.m2504i(47033);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(47033);
            return null;
        }
        Map z = C5049br.m7595z(str, "sysmsg");
        if (z == null) {
            AppMethodBeat.m2505o(47033);
            return null;
        }
        try {
            MallNews mallNews = new MallNews((String) z.get(".sysmsg.mallactivity.functionid"));
            mallNews.ssr = (String) z.get(".sysmsg.mallactivity.activityid");
            mallNews.cxb = (String) z.get(".sysmsg.mallactivity.ticket");
            mallNews.type = (String) z.get(".sysmsg.mallactivity.type");
            mallNews.showType = C5046bo.getInt((String) z.get(".sysmsg.mallactivity.showtype"), 0);
            if (z.containsKey(".sysmsg.mallactivity.showflag")) {
                mallNews.tDt = (String) z.get(".sysmsg.mallactivity.showflag");
            } else {
                mallNews.tDt = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            if (z.containsKey(".sysmsg.mallactivity.newsTipFlag")) {
                mallNews.tDu = (String) z.get(".sysmsg.mallactivity.newsTipFlag");
            } else {
                mallNews.tDu = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            mallNews.tDB = str;
            if (C5046bo.isNullOrNil(mallNews.fsT)) {
                AppMethodBeat.m2505o(47033);
                return null;
            }
            AppMethodBeat.m2505o(47033);
            return mallNews;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.MallNewsManager", "cmdid error");
            AppMethodBeat.m2505o(47033);
            return null;
        }
    }

    /* renamed from: X */
    public final void mo63443X(ArrayList<MallFunction> arrayList) {
        AppMethodBeat.m2504i(47034);
        if (arrayList != null) {
            HashSet<String> hashSet = new HashSet(this.tDE.keySet());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                hashSet.remove(((MallFunction) it.next()).pFP);
            }
            for (String remove : hashSet) {
                this.tDE.remove(remove);
            }
            bZX();
        }
        AppMethodBeat.m2505o(47034);
    }
}
