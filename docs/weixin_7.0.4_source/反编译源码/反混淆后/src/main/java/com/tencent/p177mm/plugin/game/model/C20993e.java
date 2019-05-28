package com.tencent.p177mm.plugin.game.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.constants.Build;
import com.tencent.p177mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.p177mm.plugin.game.commlib.C45985a;
import com.tencent.p177mm.plugin.game.p1268a.C43156b;
import com.tencent.p177mm.plugin.game.p428f.C46000a.C3220a;
import com.tencent.p177mm.plugin.game.p433ui.GameRegionPreference.C3265a;
import com.tencent.p177mm.plugin.game.p731d.C12109ac;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.pluginsdk.model.app.C14875aj;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.game.model.e */
public final class C20993e {
    private static String mVK = "";

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0030 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static LinkedList<C40439f> bDQ() {
        AppMethodBeat.m2504i(111198);
        C4990ab.m7410d("MicroMsg.GameCenterLogic", "getShowInGameCenterGames");
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(((C43156b) C1720g.m3528K(C43156b.class)).bCV().mVi);
        LinkedList linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            int i;
            C40439f c40439f = (C40439f) it.next();
            if (c40439f != null) {
                C4990ab.m7417i("MicroMsg.GameCenterLogic", "appinfo:[%s], appinfo flag:[%d]", c40439f.field_appId, Integer.valueOf(c40439f.field_appInfoFlag));
                if ((c40439f.field_appInfoFlag & 4) > 0) {
                    i = 1;
                    if (i != 0) {
                        C4990ab.m7417i("MicroMsg.GameCenterLogic", "app should not show in gamecenter:[%s]", c40439f.field_appName);
                        linkedList2.add(c40439f);
                    }
                }
            }
            i = 0;
            if (i != 0) {
            }
        }
        if (linkedList2.size() > 0) {
            linkedList.removeAll(linkedList2);
        }
        AppMethodBeat.m2505o(111198);
        return linkedList;
    }

    public static LinkedList<String> bDR() {
        AppMethodBeat.m2504i(111199);
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(((C43156b) C1720g.m3528K(C43156b.class)).bCV().mVh);
        AppMethodBeat.m2505o(111199);
        return linkedList;
    }

    /* renamed from: ak */
    public static void m32265ak(Context context, final String str) {
        AppMethodBeat.m2504i(111200);
        C20993e.m32263a(context, str, null, "WX_GameCenter", new C14875aj() {
            /* renamed from: dR */
            public final void mo6036dR(boolean z) {
                AppMethodBeat.m2504i(111196);
                if (z) {
                    ((C43156b) C1720g.m3528K(C43156b.class)).bCW();
                    C28236t.m44820b(str, 0, 0, null, null);
                }
                AppMethodBeat.m2505o(111196);
            }
        });
        AppMethodBeat.m2505o(111200);
    }

    /* renamed from: a */
    public static void m32263a(Context context, String str, String str2, String str3, C14875aj c14875aj) {
        AppMethodBeat.m2504i(111201);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.GameCenterLogic", "null or nil appid");
            if (c14875aj != null) {
                c14875aj.mo6036dR(false);
            }
        }
        C20993e.m32262a(context, C46494g.m87739bT(str, true), str2, str3, c14875aj);
        AppMethodBeat.m2505o(111201);
    }

    /* renamed from: a */
    private static void m32262a(final Context context, final C40439f c40439f, String str, String str2, final C14875aj c14875aj) {
        AppMethodBeat.m2504i(111202);
        if (c40439f == null || C5046bo.isNullOrNil(c40439f.field_appId)) {
            C4990ab.m7412e("MicroMsg.GameCenterLogic", "appinfo is null or appid is null");
            if (c14875aj != null) {
                c14875aj.mo6036dR(false);
            }
            AppMethodBeat.m2505o(111202);
        } else if (C35799p.m58689b(context, c40439f)) {
            final WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXAppExtendObject());
            wXMediaMessage.sdkVer = Build.SDK_INT;
            wXMediaMessage.messageAction = str;
            wXMediaMessage.messageExt = str2;
            C4990ab.m7411d("MicroMsg.GameCenterLogic", "launch game app from wx: appid: [%s], appname:[%s], openid:[%s]", c40439f.field_appId, c40439f.field_appName, c40439f.field_openId);
            if (C5046bo.isNullOrNil(c40439f.field_openId)) {
                C4990ab.m7417i("MicroMsg.GameCenterLogic", "open id is null or nil, try to get from server:[%s]", c40439f.field_appName);
                C34832a.bYL().mo9878wy(c40439f.field_appId);
            }
            C26006a.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(111197);
                    C46494g.m87728a(context, c40439f.field_packageName, wXMediaMessage, c40439f.field_appId, c40439f.field_openId, 0, c14875aj, null);
                    AppMethodBeat.m2505o(111197);
                }
            });
            AppMethodBeat.m2505o(111202);
        } else {
            C4990ab.m7413e("MicroMsg.GameCenterLogic", "The app %s signature is incorrect.", c40439f.field_appName);
            Toast.makeText(context, context.getString(C25738R.string.c62, new Object[]{C46494g.m87733b(context, c40439f, null)}), 1).show();
            if (c14875aj != null) {
                c14875aj.mo6036dR(false);
            }
            AppMethodBeat.m2505o(111202);
        }
    }

    public static String bDS() {
        AppMethodBeat.m2504i(111203);
        String gQ = C5046bo.m7555gQ(C4996ah.getContext());
        if (C5046bo.isNullOrNil(gQ)) {
            gQ = "CN";
        }
        gQ = gQ.toUpperCase();
        AppMethodBeat.m2505o(111203);
        return gQ;
    }

    /* renamed from: dX */
    public static C3265a m32271dX(Context context) {
        AppMethodBeat.m2504i(111204);
        Object ef = C20993e.m32279ef(context);
        if (C5046bo.isNullOrNil(ef)) {
            ef = C20993e.bDS();
        }
        C3265a c3265a = (C3265a) C3220a.nnu.bFD().get(ef);
        AppMethodBeat.m2505o(111204);
        return c3265a;
    }

    /* renamed from: a */
    public static String m32261a(C3265a c3265a) {
        AppMethodBeat.m2504i(111205);
        StringBuffer stringBuffer = new StringBuffer();
        if (c3265a != null) {
            String nullAsNil = C5046bo.nullAsNil(C4988aa.dor());
            if ("zh_CN".equalsIgnoreCase(nullAsNil)) {
                stringBuffer.append(c3265a.nlQ);
            } else if ("zh_TW".equalsIgnoreCase(nullAsNil) || "zh_HK".equalsIgnoreCase(nullAsNil)) {
                stringBuffer.append(c3265a.nlR);
            } else {
                stringBuffer.append(c3265a.nlS);
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(111205);
        return stringBuffer2;
    }

    public static String bDT() {
        AppMethodBeat.m2504i(111206);
        C3265a c3265a = (C3265a) C3220a.nnu.bFD().get(C20993e.bDS());
        StringBuffer stringBuffer = new StringBuffer();
        if (c3265a != null) {
            stringBuffer.append(c3265a.nlQ);
            stringBuffer.append(C20993e.m32260NU("zh_CN"));
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(111206);
        return stringBuffer2;
    }

    public static String bDU() {
        AppMethodBeat.m2504i(111207);
        C3265a c3265a = (C3265a) C3220a.nnu.bFD().get(C20993e.bDS());
        StringBuffer stringBuffer = new StringBuffer();
        if (c3265a != null) {
            stringBuffer.append(c3265a.nlR);
            stringBuffer.append(C20993e.m32260NU("zh_TW"));
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(111207);
        return stringBuffer2;
    }

    public static String bDV() {
        AppMethodBeat.m2504i(111208);
        C3265a c3265a = (C3265a) C3220a.nnu.bFD().get(C20993e.bDS());
        StringBuffer stringBuffer = new StringBuffer();
        if (c3265a != null) {
            stringBuffer.append(c3265a.nlS);
            stringBuffer.append(C20993e.m32260NU("en"));
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(111208);
        return stringBuffer2;
    }

    /* renamed from: NU */
    private static String m32260NU(String str) {
        String str2;
        AppMethodBeat.m2504i(111209);
        InputStream inputStream = null;
        String str3 = "";
        try {
            inputStream = C4996ah.getContext().getAssets().open("game_region_default.txt");
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            str2 = new String(bArr);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    C4990ab.m7413e("MicroMsg.GameCenterLogic", "exception:%s", C5046bo.m7574l(e));
                }
            }
        } catch (IOException e2) {
            C4990ab.m7413e("MicroMsg.GameCenterLogic", "exception:%s", C5046bo.m7574l(e2));
            if (inputStream != null) {
                try {
                    inputStream.close();
                    str2 = str3;
                } catch (IOException e22) {
                    C4990ab.m7413e("MicroMsg.GameCenterLogic", "exception:%s", C5046bo.m7574l(e22));
                    str2 = str3;
                }
            } else {
                str2 = str3;
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    C4990ab.m7413e("MicroMsg.GameCenterLogic", "exception:%s", C5046bo.m7574l(e3));
                }
            }
            AppMethodBeat.m2505o(111209);
        }
        String[] split = str2.trim().split("\\|");
        if (split.length < 3) {
            C4990ab.m7413e("MicroMsg.GameCenterLogic", "this region default title has problem %s", str2);
            str2 = "";
            AppMethodBeat.m2505o(111209);
            return str2;
        } else if ("zh_CN".equalsIgnoreCase(str)) {
            str2 = split[0];
            AppMethodBeat.m2505o(111209);
            return str2;
        } else if ("zh_TW".equalsIgnoreCase(str) || "zh_HK".equalsIgnoreCase(str)) {
            str2 = split[1];
            AppMethodBeat.m2505o(111209);
            return str2;
        } else {
            str2 = split[2];
            AppMethodBeat.m2505o(111209);
            return str2;
        }
    }

    /* renamed from: dV */
    public static void m32270dV(Context context) {
        AppMethodBeat.m2504i(111210);
        context.getSharedPreferences("game_center_pref", 0).edit().putString("notified_game_for_yyb_download_key", "").commit();
        context.getSharedPreferences("game_center_pref", 0).edit().putInt("total_notify_times_for_yyb_download_key", 0).commit();
        context.getSharedPreferences("game_center_pref", 0).edit().putBoolean("delete_message_by_time_key", false).commit();
        AppMethodBeat.m2505o(111210);
    }

    public static void bDW() {
        AppMethodBeat.m2504i(111211);
        C4996ah.getContext().getSharedPreferences("game_center_pref", 0).edit().putString("game_center_pref_lang", C4988aa.dor()).commit();
        AppMethodBeat.m2505o(111211);
    }

    public static String bDX() {
        AppMethodBeat.m2504i(111212);
        String string = C4996ah.getContext().getSharedPreferences("game_center_pref", 0).getString("game_center_pref_lang", C4988aa.dor());
        AppMethodBeat.m2505o(111212);
        return string;
    }

    public static boolean bDY() {
        AppMethodBeat.m2504i(111213);
        if (System.currentTimeMillis() - ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_GAME_SEARCH_LIST_UPDATE_TIME_LONG, Long.valueOf(0))).longValue() > 86400000) {
            AppMethodBeat.m2505o(111213);
            return true;
        }
        AppMethodBeat.m2505o(111213);
        return false;
    }

    public static void bDZ() {
        AppMethodBeat.m2504i(111214);
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_GAME_SEARCH_LIST_UPDATE_TIME_LONG, Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.m2505o(111214);
    }

    /* renamed from: ar */
    public static void m32266ar(Context context, String str) {
        int i = 0;
        AppMethodBeat.m2504i(111215);
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        SharedPreferences sharedPreferences = context.getSharedPreferences("game_center_pref", 0);
        String string = sharedPreferences.getString("download_app_id_time_map", "");
        if (C5046bo.isNullOrNil(string)) {
            sharedPreferences.edit().putString("download_app_id_time_map", str + "-" + valueOf).commit();
            AppMethodBeat.m2505o(111215);
        } else if (string.contains(str)) {
            String str2 = new String();
            String[] split = string.split(",");
            while (i < split.length) {
                string = split[i];
                if (string.contains(str)) {
                    string = str + "-" + valueOf;
                }
                if (i == split.length - 1) {
                    str2 = str2 + string;
                } else {
                    str2 = str2 + string + ",";
                }
                i++;
            }
            sharedPreferences.edit().putString("download_app_id_time_map", str2).apply();
            AppMethodBeat.m2505o(111215);
        } else {
            sharedPreferences.edit().putString("download_app_id_time_map", string + "," + str + "-" + valueOf).apply();
            AppMethodBeat.m2505o(111215);
        }
    }

    /* renamed from: as */
    public static void m32267as(Context context, String str) {
        int i = 0;
        AppMethodBeat.m2504i(111216);
        SharedPreferences sharedPreferences = context.getSharedPreferences("game_center_pref", 0);
        String string = sharedPreferences.getString("download_app_id_time_map", "");
        if (C5046bo.isNullOrNil(string)) {
            AppMethodBeat.m2505o(111216);
            return;
        }
        if (string.contains(str)) {
            String str2 = new String();
            String[] split = string.split(",");
            while (i < split.length) {
                String str3 = split[i];
                if (!str3.contains(str)) {
                    if (i == split.length - 1) {
                        str2 = str2 + str3;
                    } else {
                        str2 = str2 + str3 + ",";
                    }
                }
                i++;
            }
            sharedPreferences.edit().putString("download_app_id_time_map", str2).apply();
        }
        AppMethodBeat.m2505o(111216);
    }

    /* renamed from: dY */
    public static void m32272dY(Context context) {
        AppMethodBeat.m2504i(111217);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        SharedPreferences sharedPreferences = context.getSharedPreferences("game_center_pref", 0);
        String string = sharedPreferences.getString("download_app_id_time_map", "");
        if (C5046bo.isNullOrNil(string)) {
            AppMethodBeat.m2505o(111217);
            return;
        }
        String[] split = string.split(",");
        string = new String();
        for (String str : split) {
            String[] split2 = str.split("-");
            String str2 = split2[0];
            if (!(C5046bo.isNullOrNil(str2) || C46494g.m87757u(context, str2))) {
                if (currentTimeMillis - C5046bo.getLong(split2[1], 0) < TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC) {
                    string = string + str + ",";
                } else {
                    FileDownloadTaskInfo Ir = C2896d.bij().mo7040Ir(str2);
                    C4990ab.m7417i("MicroMsg.GameCenterLogic", "checkGameDownloadTime, status = %d, id = %d", Integer.valueOf(Ir.status), Long.valueOf(Ir.f16167id));
                    if (Ir.status == 2) {
                        C2896d.bij().mo7047hl(Ir.f16167id);
                    } else if ((Ir.status == 0 || Ir.status == 4) && C5730e.m8628ct(Ir.path)) {
                        C5730e.deleteFile(Ir.path);
                    }
                }
            }
        }
        if (C5046bo.isNullOrNil(string)) {
            AppMethodBeat.m2505o(111217);
            return;
        }
        if (string.charAt(string.length() - 1) == ',') {
            string = string.substring(0, string.length() - 1);
        }
        sharedPreferences.edit().putString("download_app_id_time_map", string.toString()).apply();
        AppMethodBeat.m2505o(111217);
    }

    /* renamed from: dZ */
    public static boolean m32273dZ(Context context) {
        AppMethodBeat.m2504i(111218);
        boolean z = context.getSharedPreferences("game_center_pref", 0).getBoolean("show_open_download_authority_tips", false);
        AppMethodBeat.m2505o(111218);
        return z;
    }

    /* renamed from: ea */
    public static void m32274ea(Context context) {
        AppMethodBeat.m2504i(111219);
        context.getSharedPreferences("game_center_pref", 0).edit().putBoolean("show_open_download_authority_tips", true).commit();
        AppMethodBeat.m2505o(111219);
    }

    /* renamed from: eb */
    public static Set<String> m32275eb(Context context) {
        AppMethodBeat.m2504i(111220);
        Set stringSet = context.getSharedPreferences("game_center_pref", 0).getStringSet("show_download_gift_tips", new HashSet());
        AppMethodBeat.m2505o(111220);
        return stringSet;
    }

    /* renamed from: a */
    public static void m32264a(Context context, Set<String> set) {
        AppMethodBeat.m2504i(111221);
        context.getSharedPreferences("game_center_pref", 0).edit().putStringSet("show_download_gift_tips", set).commit();
        AppMethodBeat.m2505o(111221);
    }

    /* renamed from: dI */
    public static ShapeDrawable m32269dI(int i, int i2) {
        AppMethodBeat.m2504i(111222);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{(float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2}, null, null));
        shapeDrawable.getPaint().setColor(i);
        AppMethodBeat.m2505o(111222);
        return shapeDrawable;
    }

    /* renamed from: ec */
    public static boolean m32276ec(Context context) {
        AppMethodBeat.m2504i(111223);
        boolean z = context.getSharedPreferences("game_center_pref", 0).getBoolean("show_message_tips", true);
        AppMethodBeat.m2505o(111223);
        return z;
    }

    /* renamed from: ed */
    public static void m32277ed(Context context) {
        AppMethodBeat.m2504i(111224);
        context.getSharedPreferences("game_center_pref", 0).edit().putBoolean("show_message_tips", false).apply();
        AppMethodBeat.m2505o(111224);
    }

    /* renamed from: ee */
    public static int m32278ee(Context context) {
        AppMethodBeat.m2504i(111225);
        int i = context.getSharedPreferences("game_center_pref", 0).getInt("game_top_banner_id", 0);
        AppMethodBeat.m2505o(111225);
        return i;
    }

    /* renamed from: N */
    public static void m32259N(Context context, int i) {
        AppMethodBeat.m2504i(111226);
        context.getSharedPreferences("game_center_pref", 0).edit().putInt("game_top_banner_id", i).apply();
        AppMethodBeat.m2505o(111226);
    }

    public static String bEa() {
        AppMethodBeat.m2504i(111227);
        C12109ac bDf = C45985a.bDf();
        String str;
        if (bDf != null) {
            str = bDf.mZj;
            AppMethodBeat.m2505o(111227);
            return str;
        }
        str = "";
        AppMethodBeat.m2505o(111227);
        return str;
    }

    public static int bEb() {
        AppMethodBeat.m2504i(111228);
        C12109ac bDf = C45985a.bDf();
        if (bDf != null) {
            int i = bDf.naz;
            AppMethodBeat.m2505o(111228);
            return i;
        }
        AppMethodBeat.m2505o(111228);
        return 0;
    }

    /* renamed from: ef */
    public static String m32279ef(Context context) {
        AppMethodBeat.m2504i(111229);
        String string = context.getSharedPreferences("game_center_pref", 0).getString("game_region_code", "");
        AppMethodBeat.m2505o(111229);
        return string;
    }

    /* renamed from: at */
    public static void m32268at(Context context, String str) {
        AppMethodBeat.m2504i(111230);
        context.getSharedPreferences("game_center_pref", 0).edit().putString("game_region_code", str).commit();
        AppMethodBeat.m2505o(111230);
    }

    /* renamed from: eg */
    public static boolean m32280eg(Context context) {
        AppMethodBeat.m2504i(111231);
        if (context.getSharedPreferences("game_center_pref", 0).getInt("game_region_confirm_mark", 0) == 1) {
            AppMethodBeat.m2505o(111231);
            return false;
        }
        AppMethodBeat.m2505o(111231);
        return true;
    }

    /* renamed from: eh */
    public static void m32281eh(Context context) {
        AppMethodBeat.m2504i(111232);
        context.getSharedPreferences("game_center_pref", 0).edit().putInt("game_region_confirm_mark", 1).commit();
        AppMethodBeat.m2505o(111232);
    }

    public static void bEc() {
        AppMethodBeat.m2504i(111233);
        C4996ah.getContext().getSharedPreferences("game_center_pref", 0).edit().putLong("game_index_last_visit_time", System.currentTimeMillis()).commit();
        AppMethodBeat.m2505o(111233);
    }

    public static long bEd() {
        AppMethodBeat.m2504i(111234);
        long j = C4996ah.getContext().getSharedPreferences("game_center_pref", 0).getLong("game_index_last_visit_time", 0);
        AppMethodBeat.m2505o(111234);
        return j;
    }

    public static String bEe() {
        return mVK;
    }
}
