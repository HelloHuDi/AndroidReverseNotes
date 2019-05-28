package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.game.a.b;
import com.tencent.mm.plugin.game.ui.GameRegionPreference;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.pluginsdk.model.app.aj;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class e {
    private static String mVK = "";

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0030 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static LinkedList<f> bDQ() {
        AppMethodBeat.i(111198);
        ab.d("MicroMsg.GameCenterLogic", "getShowInGameCenterGames");
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(((b) g.K(b.class)).bCV().mVi);
        LinkedList linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            int i;
            f fVar = (f) it.next();
            if (fVar != null) {
                ab.i("MicroMsg.GameCenterLogic", "appinfo:[%s], appinfo flag:[%d]", fVar.field_appId, Integer.valueOf(fVar.field_appInfoFlag));
                if ((fVar.field_appInfoFlag & 4) > 0) {
                    i = 1;
                    if (i != 0) {
                        ab.i("MicroMsg.GameCenterLogic", "app should not show in gamecenter:[%s]", fVar.field_appName);
                        linkedList2.add(fVar);
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
        AppMethodBeat.o(111198);
        return linkedList;
    }

    public static LinkedList<String> bDR() {
        AppMethodBeat.i(111199);
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(((b) g.K(b.class)).bCV().mVh);
        AppMethodBeat.o(111199);
        return linkedList;
    }

    public static void ak(Context context, final String str) {
        AppMethodBeat.i(111200);
        a(context, str, null, "WX_GameCenter", new aj() {
            public final void dR(boolean z) {
                AppMethodBeat.i(111196);
                if (z) {
                    ((b) g.K(b.class)).bCW();
                    t.b(str, 0, 0, null, null);
                }
                AppMethodBeat.o(111196);
            }
        });
        AppMethodBeat.o(111200);
    }

    public static void a(Context context, String str, String str2, String str3, aj ajVar) {
        AppMethodBeat.i(111201);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.GameCenterLogic", "null or nil appid");
            if (ajVar != null) {
                ajVar.dR(false);
            }
        }
        a(context, com.tencent.mm.pluginsdk.model.app.g.bT(str, true), str2, str3, ajVar);
        AppMethodBeat.o(111201);
    }

    private static void a(final Context context, final f fVar, String str, String str2, final aj ajVar) {
        AppMethodBeat.i(111202);
        if (fVar == null || bo.isNullOrNil(fVar.field_appId)) {
            ab.e("MicroMsg.GameCenterLogic", "appinfo is null or appid is null");
            if (ajVar != null) {
                ajVar.dR(false);
            }
            AppMethodBeat.o(111202);
        } else if (p.b(context, fVar)) {
            final WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXAppExtendObject());
            wXMediaMessage.sdkVer = Build.SDK_INT;
            wXMediaMessage.messageAction = str;
            wXMediaMessage.messageExt = str2;
            ab.d("MicroMsg.GameCenterLogic", "launch game app from wx: appid: [%s], appname:[%s], openid:[%s]", fVar.field_appId, fVar.field_appName, fVar.field_openId);
            if (bo.isNullOrNil(fVar.field_openId)) {
                ab.i("MicroMsg.GameCenterLogic", "open id is null or nil, try to get from server:[%s]", fVar.field_appName);
                a.bYL().wy(fVar.field_appId);
            }
            com.tencent.mm.ce.a.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(111197);
                    com.tencent.mm.pluginsdk.model.app.g.a(context, fVar.field_packageName, wXMediaMessage, fVar.field_appId, fVar.field_openId, 0, ajVar, null);
                    AppMethodBeat.o(111197);
                }
            });
            AppMethodBeat.o(111202);
        } else {
            ab.e("MicroMsg.GameCenterLogic", "The app %s signature is incorrect.", fVar.field_appName);
            Toast.makeText(context, context.getString(R.string.c62, new Object[]{com.tencent.mm.pluginsdk.model.app.g.b(context, fVar, null)}), 1).show();
            if (ajVar != null) {
                ajVar.dR(false);
            }
            AppMethodBeat.o(111202);
        }
    }

    public static String bDS() {
        AppMethodBeat.i(111203);
        String gQ = bo.gQ(ah.getContext());
        if (bo.isNullOrNil(gQ)) {
            gQ = "CN";
        }
        gQ = gQ.toUpperCase();
        AppMethodBeat.o(111203);
        return gQ;
    }

    public static GameRegionPreference.a dX(Context context) {
        AppMethodBeat.i(111204);
        Object ef = ef(context);
        if (bo.isNullOrNil(ef)) {
            ef = bDS();
        }
        GameRegionPreference.a aVar = (GameRegionPreference.a) com.tencent.mm.plugin.game.f.a.a.nnu.bFD().get(ef);
        AppMethodBeat.o(111204);
        return aVar;
    }

    public static String a(GameRegionPreference.a aVar) {
        AppMethodBeat.i(111205);
        StringBuffer stringBuffer = new StringBuffer();
        if (aVar != null) {
            String nullAsNil = bo.nullAsNil(aa.dor());
            if ("zh_CN".equalsIgnoreCase(nullAsNil)) {
                stringBuffer.append(aVar.nlQ);
            } else if ("zh_TW".equalsIgnoreCase(nullAsNil) || "zh_HK".equalsIgnoreCase(nullAsNil)) {
                stringBuffer.append(aVar.nlR);
            } else {
                stringBuffer.append(aVar.nlS);
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(111205);
        return stringBuffer2;
    }

    public static String bDT() {
        AppMethodBeat.i(111206);
        GameRegionPreference.a aVar = (GameRegionPreference.a) com.tencent.mm.plugin.game.f.a.a.nnu.bFD().get(bDS());
        StringBuffer stringBuffer = new StringBuffer();
        if (aVar != null) {
            stringBuffer.append(aVar.nlQ);
            stringBuffer.append(NU("zh_CN"));
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(111206);
        return stringBuffer2;
    }

    public static String bDU() {
        AppMethodBeat.i(111207);
        GameRegionPreference.a aVar = (GameRegionPreference.a) com.tencent.mm.plugin.game.f.a.a.nnu.bFD().get(bDS());
        StringBuffer stringBuffer = new StringBuffer();
        if (aVar != null) {
            stringBuffer.append(aVar.nlR);
            stringBuffer.append(NU("zh_TW"));
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(111207);
        return stringBuffer2;
    }

    public static String bDV() {
        AppMethodBeat.i(111208);
        GameRegionPreference.a aVar = (GameRegionPreference.a) com.tencent.mm.plugin.game.f.a.a.nnu.bFD().get(bDS());
        StringBuffer stringBuffer = new StringBuffer();
        if (aVar != null) {
            stringBuffer.append(aVar.nlS);
            stringBuffer.append(NU("en"));
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(111208);
        return stringBuffer2;
    }

    private static String NU(String str) {
        String str2;
        AppMethodBeat.i(111209);
        InputStream inputStream = null;
        String str3 = "";
        try {
            inputStream = ah.getContext().getAssets().open("game_region_default.txt");
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            str2 = new String(bArr);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    ab.e("MicroMsg.GameCenterLogic", "exception:%s", bo.l(e));
                }
            }
        } catch (IOException e2) {
            ab.e("MicroMsg.GameCenterLogic", "exception:%s", bo.l(e2));
            if (inputStream != null) {
                try {
                    inputStream.close();
                    str2 = str3;
                } catch (IOException e22) {
                    ab.e("MicroMsg.GameCenterLogic", "exception:%s", bo.l(e22));
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
                    ab.e("MicroMsg.GameCenterLogic", "exception:%s", bo.l(e3));
                }
            }
            AppMethodBeat.o(111209);
        }
        String[] split = str2.trim().split("\\|");
        if (split.length < 3) {
            ab.e("MicroMsg.GameCenterLogic", "this region default title has problem %s", str2);
            str2 = "";
            AppMethodBeat.o(111209);
            return str2;
        } else if ("zh_CN".equalsIgnoreCase(str)) {
            str2 = split[0];
            AppMethodBeat.o(111209);
            return str2;
        } else if ("zh_TW".equalsIgnoreCase(str) || "zh_HK".equalsIgnoreCase(str)) {
            str2 = split[1];
            AppMethodBeat.o(111209);
            return str2;
        } else {
            str2 = split[2];
            AppMethodBeat.o(111209);
            return str2;
        }
    }

    public static void dV(Context context) {
        AppMethodBeat.i(111210);
        context.getSharedPreferences("game_center_pref", 0).edit().putString("notified_game_for_yyb_download_key", "").commit();
        context.getSharedPreferences("game_center_pref", 0).edit().putInt("total_notify_times_for_yyb_download_key", 0).commit();
        context.getSharedPreferences("game_center_pref", 0).edit().putBoolean("delete_message_by_time_key", false).commit();
        AppMethodBeat.o(111210);
    }

    public static void bDW() {
        AppMethodBeat.i(111211);
        ah.getContext().getSharedPreferences("game_center_pref", 0).edit().putString("game_center_pref_lang", aa.dor()).commit();
        AppMethodBeat.o(111211);
    }

    public static String bDX() {
        AppMethodBeat.i(111212);
        String string = ah.getContext().getSharedPreferences("game_center_pref", 0).getString("game_center_pref_lang", aa.dor());
        AppMethodBeat.o(111212);
        return string;
    }

    public static boolean bDY() {
        AppMethodBeat.i(111213);
        if (System.currentTimeMillis() - ((Long) g.RP().Ry().get(ac.a.USERINFO_GAME_SEARCH_LIST_UPDATE_TIME_LONG, Long.valueOf(0))).longValue() > 86400000) {
            AppMethodBeat.o(111213);
            return true;
        }
        AppMethodBeat.o(111213);
        return false;
    }

    public static void bDZ() {
        AppMethodBeat.i(111214);
        g.RP().Ry().set(ac.a.USERINFO_GAME_SEARCH_LIST_UPDATE_TIME_LONG, Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(111214);
    }

    public static void ar(Context context, String str) {
        int i = 0;
        AppMethodBeat.i(111215);
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        SharedPreferences sharedPreferences = context.getSharedPreferences("game_center_pref", 0);
        String string = sharedPreferences.getString("download_app_id_time_map", "");
        if (bo.isNullOrNil(string)) {
            sharedPreferences.edit().putString("download_app_id_time_map", str + "-" + valueOf).commit();
            AppMethodBeat.o(111215);
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
            AppMethodBeat.o(111215);
        } else {
            sharedPreferences.edit().putString("download_app_id_time_map", string + "," + str + "-" + valueOf).apply();
            AppMethodBeat.o(111215);
        }
    }

    public static void as(Context context, String str) {
        int i = 0;
        AppMethodBeat.i(111216);
        SharedPreferences sharedPreferences = context.getSharedPreferences("game_center_pref", 0);
        String string = sharedPreferences.getString("download_app_id_time_map", "");
        if (bo.isNullOrNil(string)) {
            AppMethodBeat.o(111216);
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
        AppMethodBeat.o(111216);
    }

    public static void dY(Context context) {
        AppMethodBeat.i(111217);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        SharedPreferences sharedPreferences = context.getSharedPreferences("game_center_pref", 0);
        String string = sharedPreferences.getString("download_app_id_time_map", "");
        if (bo.isNullOrNil(string)) {
            AppMethodBeat.o(111217);
            return;
        }
        String[] split = string.split(",");
        string = new String();
        for (String str : split) {
            String[] split2 = str.split("-");
            String str2 = split2[0];
            if (!(bo.isNullOrNil(str2) || com.tencent.mm.pluginsdk.model.app.g.u(context, str2))) {
                if (currentTimeMillis - bo.getLong(split2[1], 0) < TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC) {
                    string = string + str + ",";
                } else {
                    FileDownloadTaskInfo Ir = d.bij().Ir(str2);
                    ab.i("MicroMsg.GameCenterLogic", "checkGameDownloadTime, status = %d, id = %d", Integer.valueOf(Ir.status), Long.valueOf(Ir.id));
                    if (Ir.status == 2) {
                        d.bij().hl(Ir.id);
                    } else if ((Ir.status == 0 || Ir.status == 4) && com.tencent.mm.vfs.e.ct(Ir.path)) {
                        com.tencent.mm.vfs.e.deleteFile(Ir.path);
                    }
                }
            }
        }
        if (bo.isNullOrNil(string)) {
            AppMethodBeat.o(111217);
            return;
        }
        if (string.charAt(string.length() - 1) == ',') {
            string = string.substring(0, string.length() - 1);
        }
        sharedPreferences.edit().putString("download_app_id_time_map", string.toString()).apply();
        AppMethodBeat.o(111217);
    }

    public static boolean dZ(Context context) {
        AppMethodBeat.i(111218);
        boolean z = context.getSharedPreferences("game_center_pref", 0).getBoolean("show_open_download_authority_tips", false);
        AppMethodBeat.o(111218);
        return z;
    }

    public static void ea(Context context) {
        AppMethodBeat.i(111219);
        context.getSharedPreferences("game_center_pref", 0).edit().putBoolean("show_open_download_authority_tips", true).commit();
        AppMethodBeat.o(111219);
    }

    public static Set<String> eb(Context context) {
        AppMethodBeat.i(111220);
        Set stringSet = context.getSharedPreferences("game_center_pref", 0).getStringSet("show_download_gift_tips", new HashSet());
        AppMethodBeat.o(111220);
        return stringSet;
    }

    public static void a(Context context, Set<String> set) {
        AppMethodBeat.i(111221);
        context.getSharedPreferences("game_center_pref", 0).edit().putStringSet("show_download_gift_tips", set).commit();
        AppMethodBeat.o(111221);
    }

    public static ShapeDrawable dI(int i, int i2) {
        AppMethodBeat.i(111222);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{(float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2}, null, null));
        shapeDrawable.getPaint().setColor(i);
        AppMethodBeat.o(111222);
        return shapeDrawable;
    }

    public static boolean ec(Context context) {
        AppMethodBeat.i(111223);
        boolean z = context.getSharedPreferences("game_center_pref", 0).getBoolean("show_message_tips", true);
        AppMethodBeat.o(111223);
        return z;
    }

    public static void ed(Context context) {
        AppMethodBeat.i(111224);
        context.getSharedPreferences("game_center_pref", 0).edit().putBoolean("show_message_tips", false).apply();
        AppMethodBeat.o(111224);
    }

    public static int ee(Context context) {
        AppMethodBeat.i(111225);
        int i = context.getSharedPreferences("game_center_pref", 0).getInt("game_top_banner_id", 0);
        AppMethodBeat.o(111225);
        return i;
    }

    public static void N(Context context, int i) {
        AppMethodBeat.i(111226);
        context.getSharedPreferences("game_center_pref", 0).edit().putInt("game_top_banner_id", i).apply();
        AppMethodBeat.o(111226);
    }

    public static String bEa() {
        AppMethodBeat.i(111227);
        com.tencent.mm.plugin.game.d.ac bDf = com.tencent.mm.plugin.game.commlib.a.bDf();
        String str;
        if (bDf != null) {
            str = bDf.mZj;
            AppMethodBeat.o(111227);
            return str;
        }
        str = "";
        AppMethodBeat.o(111227);
        return str;
    }

    public static int bEb() {
        AppMethodBeat.i(111228);
        com.tencent.mm.plugin.game.d.ac bDf = com.tencent.mm.plugin.game.commlib.a.bDf();
        if (bDf != null) {
            int i = bDf.naz;
            AppMethodBeat.o(111228);
            return i;
        }
        AppMethodBeat.o(111228);
        return 0;
    }

    public static String ef(Context context) {
        AppMethodBeat.i(111229);
        String string = context.getSharedPreferences("game_center_pref", 0).getString("game_region_code", "");
        AppMethodBeat.o(111229);
        return string;
    }

    public static void at(Context context, String str) {
        AppMethodBeat.i(111230);
        context.getSharedPreferences("game_center_pref", 0).edit().putString("game_region_code", str).commit();
        AppMethodBeat.o(111230);
    }

    public static boolean eg(Context context) {
        AppMethodBeat.i(111231);
        if (context.getSharedPreferences("game_center_pref", 0).getInt("game_region_confirm_mark", 0) == 1) {
            AppMethodBeat.o(111231);
            return false;
        }
        AppMethodBeat.o(111231);
        return true;
    }

    public static void eh(Context context) {
        AppMethodBeat.i(111232);
        context.getSharedPreferences("game_center_pref", 0).edit().putInt("game_region_confirm_mark", 1).commit();
        AppMethodBeat.o(111232);
    }

    public static void bEc() {
        AppMethodBeat.i(111233);
        ah.getContext().getSharedPreferences("game_center_pref", 0).edit().putLong("game_index_last_visit_time", System.currentTimeMillis()).commit();
        AppMethodBeat.o(111233);
    }

    public static long bEd() {
        AppMethodBeat.i(111234);
        long j = ah.getContext().getSharedPreferences("game_center_pref", 0).getLong("game_index_last_visit_time", 0);
        AppMethodBeat.o(111234);
        return j;
    }

    public static String bEe() {
        return mVK;
    }
}
