package com.tencent.mm.plugin.wallet_core.model.mall;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class c {
    private static c tDD = null;
    public Map<String, MallNews> tDE = new HashMap();

    public static c cQT() {
        AppMethodBeat.i(47021);
        if (tDD == null) {
            tDD = new c();
        }
        c cVar = tDD;
        AppMethodBeat.o(47021);
        return cVar;
    }

    private c() {
        AppMethodBeat.i(47022);
        Kh();
        AppMethodBeat.o(47022);
    }

    public final void Kh() {
        AppMethodBeat.i(47023);
        this.tDE.clear();
        g.RQ();
        String str = (String) g.RP().Ry().get(270339, (Object) "");
        ab.d("MicroMsg.MallNewsManager", "data : ".concat(String.valueOf(str)));
        for (String str2 : bo.P(str2.split(";"))) {
            MallNews acJ = acJ(str2);
            if (acJ != null) {
                this.tDE.put(acJ.fsT, acJ);
            }
        }
        AppMethodBeat.o(47023);
    }

    public final List<String> cQU() {
        AppMethodBeat.i(47024);
        ArrayList arrayList = new ArrayList();
        for (MallNews mallNews : this.tDE.values()) {
            if (!bo.isNullOrNil(mallNews.cxb)) {
                arrayList.add(mallNews.cxb);
            }
        }
        ab.d("MicroMsg.MallNewsManager", "tickets.size : " + arrayList.size());
        AppMethodBeat.o(47024);
        return arrayList;
    }

    public static boolean a(MallNews mallNews) {
        AppMethodBeat.i(47025);
        g.RQ();
        ArrayList P = bo.P(((String) g.RP().Ry().get(a.USERINFO_MALL_NEWS_MARKED_STRING_SYNC, (Object) "")).split(","));
        ab.i("MicroMsg.MallNewsManager", "tryCheckOutOfDateRedDot markedString %s", r0);
        if (mallNews == null) {
            AppMethodBeat.o(47025);
            return false;
        } else if (bo.isNullOrNil(mallNews.ssr)) {
            AppMethodBeat.o(47025);
            return false;
        } else if (P.contains(mallNews.ssr)) {
            AppMethodBeat.o(47025);
            return true;
        } else {
            AppMethodBeat.o(47025);
            return false;
        }
    }

    public static void e(MallFunction mallFunction) {
        AppMethodBeat.i(47026);
        try {
            if (!bo.isNullOrNil(mallFunction.tDn.ssr)) {
                g.RQ();
                List P = bo.P(((String) g.RP().Ry().get(a.USERINFO_MALL_NEWS_MARKED_STRING_SYNC, (Object) "")).split(","));
                while (P.size() > 20) {
                    P.remove(0);
                }
                if (P.contains(mallFunction.tDn.ssr)) {
                    AppMethodBeat.o(47026);
                    return;
                }
                P.add(mallFunction.tDn.ssr);
                ab.i("MicroMsg.MallNewsManager", "doSelectFunction %s, markedString %s", mallFunction.tDn.ssr, bo.c(P, ","));
                g.RQ();
                g.RP().Ry().set(a.USERINFO_MALL_NEWS_MARKED_STRING_SYNC, r0);
            }
            AppMethodBeat.o(47026);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MallNewsManager", e, "error in markedFunction", new Object[0]);
            AppMethodBeat.o(47026);
        }
    }

    public static void acG(String str) {
        AppMethodBeat.i(47027);
        if (!bo.isNullOrNil(str)) {
            Map z = br.z(str, "sysmsg");
            if (z != null) {
                int i = bo.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), -1);
                Object obj;
                int i2;
                String str2;
                String str3;
                String str4;
                if (i == 31) {
                    obj = (String) z.get(".sysmsg.paymsg.WalletRedDotWording");
                    i2 = bo.getInt((String) z.get(".sysmsg.paymsg.WalletRedDot"), -1);
                    ab.i("MicroMsg.MallNewsManager", "walletEntryWording: %s, balanceRedDot: %s, lqtRedDot: %s", obj, Integer.valueOf(bo.getInt((String) z.get(".sysmsg.paymsg.BalanceRedDot"), -1)), Integer.valueOf(bo.getInt((String) z.get(".sysmsg.paymsg.LQTRedDot"), -1)));
                    g.RQ();
                    g.RP().Ry().set(a.USERINFO_LQT_WALLET_RED_DOT_WORDING_STRING, obj);
                    g.RQ();
                    g.RP().Ry().set(a.USERINFO_LQT_WALLET_RED_DOT_INT, Integer.valueOf(i2));
                    g.RQ();
                    g.RP().Ry().set(a.USERINFO_LQT_BALANCE_RED_DOT_INT, Integer.valueOf(r3));
                    g.RQ();
                    g.RP().Ry().set(a.USERINFO_LQT_LINK_RED_DOT_INT, Integer.valueOf(r1));
                    cQW();
                    AppMethodBeat.o(47027);
                    return;
                } else if (i == 34) {
                    Set<String> keySet = z.keySet();
                    ab.i("MicroMsg.MallNewsManager", "receive menu ui reddot msg: %s, keys: %s", str, keySet.toString());
                    if (keySet.size() > 0) {
                        JSONObject jSONObject = new JSONObject();
                        for (String str22 : keySet) {
                            if (str22.startsWith(".sysmsg.paymsg.reddot.item")) {
                                str3 = (String) z.get(str22);
                                str4 = str22 + ".$wording";
                                String str5 = str22 + ".$expire_time";
                                obj = (String) z.get(str4);
                                long j = bo.getLong((String) z.get(str5), 0) * 1000;
                                if (!bo.isNullOrNil(str3)) {
                                    ab.i("MicroMsg.MallNewsManager", "mall menu ui, %s has reddot, wording: %s, expireTime: %s", str3, obj, Long.valueOf(j));
                                    if ("mainentry_me".equals(str3)) {
                                        g.RQ();
                                        g.RP().Ry().set(a.USERINFO_WALLET_MY_ENTRY_TAB_REDDOT_BOOLEAN_SYNC, Boolean.TRUE);
                                        if (j > 0) {
                                            g.RQ();
                                            g.RP().Ry().set(a.USERINFO_WALLET_MY_ENTRY_TAB_REDDOT_EXPIRETIME_LONG_SYNC, Long.valueOf(j));
                                        }
                                    } else if ("entry_wxpay_wallet".equals(str3)) {
                                        g.RQ();
                                        g.RP().Ry().set(a.USERINFO_WALLET_MY_ENTRY_REDDOT_BOOLEAN_SYNC, Boolean.TRUE);
                                        if (bo.isNullOrNil(obj)) {
                                            g.RQ();
                                            g.RP().Ry().set(a.USERINFO_WALLET_ENTRY_WORDING_STRING_SYNC, (Object) "");
                                        } else {
                                            g.RQ();
                                            g.RP().Ry().set(a.USERINFO_WALLET_ENTRY_WORDING_STRING_SYNC, obj);
                                        }
                                        if (j > 0) {
                                            g.RQ();
                                            g.RP().Ry().set(a.USERINFO_WALLET_MY_ENTRY_REDDOT_EXPIRETIME_LONG_SYNC, Long.valueOf(j));
                                        }
                                    } else if ("entry_wxpay_paycenter".equals(str3)) {
                                        g.RQ();
                                        g.RP().Ry().set(a.USERINFO_WALLET_MALL_MENU_UI_REDDOT_CONFIG_BOOLEAN_SYNC, Boolean.TRUE);
                                        if (j > 0) {
                                            g.RQ();
                                            g.RP().Ry().set(a.USERINFO_WALLET_MALL_MENU_UI_REDDOT_CONFIG_EXPIRETIME_LONG_SYNC, Long.valueOf(j));
                                        }
                                    } else {
                                        try {
                                            jSONObject.put(str3, 1);
                                            if (j > 0) {
                                                jSONObject.put(String.format("%s_expiretime", new Object[]{str3}), j);
                                            }
                                        } catch (Exception e) {
                                            ab.printErrStackTrace("MicroMsg.MallNewsManager", e, "put redDotConfig json failed: %s", e.getMessage());
                                        }
                                    }
                                }
                            }
                        }
                        ab.i("MicroMsg.MallNewsManager", "redDotConfig: %s", jSONObject.toString());
                        if (jSONObject.length() > 0) {
                            g.RQ();
                            g.RP().Ry().set(a.USERINFO_WALLET_MENU_UI_REDDOT_CONFIG_STRING_SYNC, jSONObject.toString());
                            g.RQ();
                            g.RP().Ry().set(a.USERINFO_WALLET_MALL_MENU_UI_REDDOT_CONFIG_BOOLEAN_SYNC, Boolean.TRUE);
                        }
                    }
                    AppMethodBeat.o(47027);
                    return;
                } else if (i == 36) {
                    ab.i("MicroMsg.MallNewsManager", "walletEntryWording: %s, walletRedDot: %s, lqbRedDot: %s", (String) z.get(".sysmsg.paymsg.WalletRedDotWording"), Integer.valueOf(bo.getInt((String) z.get(".sysmsg.paymsg.WalletRedDot"), -1)), Integer.valueOf(bo.getInt((String) z.get(".sysmsg.paymsg.LQBRedDot"), -1)));
                    g.RQ();
                    g.RP().Ry().set(a.USERINFO_LQT_WALLET_RED_DOT_WORDING_STRING, obj);
                    g.RQ();
                    g.RP().Ry().set(a.USERINFO_LQT_WALLET_RED_DOT_INT, Integer.valueOf(i2));
                    g.RQ();
                    g.RP().Ry().set(a.USERINFO_LQB_MALL_ENTRY_RED_DOT_INT, Integer.valueOf(r1));
                    cQW();
                    AppMethodBeat.o(47027);
                    return;
                } else if (i == 38) {
                    Set<String> keySet2 = z.keySet();
                    ab.i("MicroMsg.MallNewsManager", "receive menu ui reddot msg: %s, keys: %s", str, keySet2.toString());
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
                                long j2 = bo.getLong((String) z.get(str6), 0) * 1000;
                                if (!bo.isNullOrNil(str4)) {
                                    ab.i("MicroMsg.MallNewsManager", "mall menu ui, %s has reddot, wording: %s, expireTime: %s", str4, obj, Long.valueOf(j2));
                                    if ("mainentry_me".equals(str4)) {
                                        com.tencent.mm.x.c.PK().b(a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_STRING_SYNC, true);
                                        g.RQ();
                                        g.RP().Ry().set(a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_EXPIRETIME_LONG_SYNC, Long.valueOf(j2));
                                        obj3 = 1;
                                    } else if ("entry_wxpay_pay".equals(str4)) {
                                        com.tencent.mm.x.c.PK().b(a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_STRING_SYNC, true);
                                        if (bo.isNullOrNil(obj)) {
                                            g.RQ();
                                            g.RP().Ry().set(a.USERINFO_WALLET_New_MY_ENTRY_WORDING_STRING_SYNC, (Object) "");
                                        } else {
                                            g.RQ();
                                            g.RP().Ry().set(a.USERINFO_WALLET_New_MY_ENTRY_WORDING_STRING_SYNC, obj);
                                        }
                                        g.RQ();
                                        g.RP().Ry().set(a.USERINFO_WALLET_New_MY_ENTRY_REDDOT_EXPIRETIME_LONG_SYNC, Long.valueOf(j2));
                                        obj2 = 1;
                                    } else if ("entry_wxpay_pay_wallet".equals(str4)) {
                                        g.RQ();
                                        g.RP().Ry().set(a.USERINFO_WALLET_New_MALL_UI_REDDOT_CONFIG_BOOLEAN_SYNC, Boolean.TRUE);
                                        g.RQ();
                                        g.RP().Ry().set(a.USERINFO_WALLET_New_MALL_UI_REDDOT_CONFIG_EXPIRETIME_LONG_SYNC, Long.valueOf(j2));
                                    } else if (str4.startsWith("bind_serial_")) {
                                        str4 = str4.substring(12);
                                        g.RQ();
                                        str222 = (String) g.RP().Ry().get(a.USERINFO_WALLET_BANKCARD_SERIAL_STRING_SYNC, (Object) "");
                                        ab.d("MicroMsg.MallNewsManager", "bind serial: %s", str4);
                                        if (bo.isNullOrNil(str222)) {
                                            str222 = str4;
                                        } else {
                                            obj = str222 + "," + str4;
                                        }
                                        g.RQ();
                                        g.RP().Ry().set(a.USERINFO_WALLET_BANKCARD_SERIAL_STRING_SYNC, obj);
                                    } else {
                                        try {
                                            jSONObject2.put(str4, 1);
                                            jSONObject2.put(String.format("%s_expiretime", new Object[]{str4}), j2);
                                        } catch (Exception e2) {
                                            ab.printErrStackTrace("MicroMsg.MallNewsManager", e2, "put redDotConfig json failed: %s", e2.getMessage());
                                        }
                                    }
                                }
                            }
                        }
                        if (obj3 == null) {
                            com.tencent.mm.x.c.PK().c(a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_STRING_SYNC, a.USERINFO_NEW_BANDAGE_WATCHER_ME_TAB_STRING_SYNC);
                        }
                        if (obj2 == null) {
                            com.tencent.mm.x.c.PK().c(a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_STRING_SYNC, a.USERINFO_NEW_BANDAGE_WATCHER_PAY_ENTRANCE_STRING_SYNC);
                        }
                        ab.i("MicroMsg.MallNewsManager", "redDotConfig: %s", jSONObject2.toString());
                        if (jSONObject2.length() > 0) {
                            g.RQ();
                            g.RP().Ry().set(a.USERINFO_WALLET_New_MALL_UI_ITEM_REDDOT_CONFIG_STRING_SYNC, jSONObject2.toString());
                            g.RQ();
                            g.RP().Ry().set(a.USERINFO_WALLET_New_MALL_UI_REDDOT_CONFIG_BOOLEAN_SYNC, Boolean.TRUE);
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(47027);
    }

    public static void cQV() {
        AppMethodBeat.i(47028);
        g.RQ();
        g.RP().Ry().set(a.USERINFO_LQT_WALLET_RED_DOT_WORDING_STRING, (Object) "");
        g.RQ();
        g.RP().Ry().set(a.USERINFO_LQT_WALLET_RED_DOT_INT, Integer.valueOf(-1));
        AppMethodBeat.o(47028);
    }

    public static void cQW() {
        AppMethodBeat.i(47029);
        ab.d("MicroMsg.MallNewsManager", "clearMallNew ");
        com.tencent.mm.x.c.PK().bZ(262156, 266248);
        AppMethodBeat.o(47029);
    }

    public final boolean bZX() {
        AppMethodBeat.i(47030);
        ab.d("MicroMsg.MallNewsManager", "notifyNewsMap.size : " + this.tDE.size());
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : this.tDE.keySet()) {
            if (!bo.isNullOrNil(str)) {
                MallNews mallNews = (MallNews) this.tDE.get(str);
                stringBuffer.append(mallNews.tDB.replace("</mallactivity></sysmsg>", "").replaceAll("<showflag>([^<]*)</showflag>", "").replaceAll("<newsTipFlag>([^<]*)</newsTipFlag>", "") + "<showflag>" + mallNews.tDt + "</showflag><newsTipFlag>" + mallNews.tDu + "</newsTipFlag></mallactivity></sysmsg>;");
            }
        }
        ab.d("MicroMsg.MallNewsManager", "save data  : " + stringBuffer.toString());
        g.RQ();
        g.RP().Ry().set(270339, stringBuffer.toString());
        AppMethodBeat.o(47030);
        return true;
    }

    public final String acH(String str) {
        AppMethodBeat.i(47031);
        MallNews mallNews = (MallNews) this.tDE.get(str);
        if (mallNews == null || bo.isNullOrNil(mallNews.cxb)) {
            AppMethodBeat.o(47031);
            return null;
        }
        String str2 = mallNews.cxb;
        AppMethodBeat.o(47031);
        return str2;
    }

    public final MallNews acI(String str) {
        AppMethodBeat.i(47032);
        ab.d("MicroMsg.MallNewsManager", "removeNewsInIndexUI : ".concat(String.valueOf(str)));
        if (bo.isNullOrNil(str) || !this.tDE.containsKey(str)) {
            AppMethodBeat.o(47032);
            return null;
        }
        MallNews mallNews = (MallNews) this.tDE.get(str);
        if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(mallNews.tDt)) {
            mallNews.tDt = "1";
            bZX();
        }
        AppMethodBeat.o(47032);
        return mallNews;
    }

    public static MallNews acJ(String str) {
        AppMethodBeat.i(47033);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(47033);
            return null;
        }
        Map z = br.z(str, "sysmsg");
        if (z == null) {
            AppMethodBeat.o(47033);
            return null;
        }
        try {
            MallNews mallNews = new MallNews((String) z.get(".sysmsg.mallactivity.functionid"));
            mallNews.ssr = (String) z.get(".sysmsg.mallactivity.activityid");
            mallNews.cxb = (String) z.get(".sysmsg.mallactivity.ticket");
            mallNews.type = (String) z.get(".sysmsg.mallactivity.type");
            mallNews.showType = bo.getInt((String) z.get(".sysmsg.mallactivity.showtype"), 0);
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
            if (bo.isNullOrNil(mallNews.fsT)) {
                AppMethodBeat.o(47033);
                return null;
            }
            AppMethodBeat.o(47033);
            return mallNews;
        } catch (Exception e) {
            ab.e("MicroMsg.MallNewsManager", "cmdid error");
            AppMethodBeat.o(47033);
            return null;
        }
    }

    public final void X(ArrayList<MallFunction> arrayList) {
        AppMethodBeat.i(47034);
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
        AppMethodBeat.o(47034);
    }
}
