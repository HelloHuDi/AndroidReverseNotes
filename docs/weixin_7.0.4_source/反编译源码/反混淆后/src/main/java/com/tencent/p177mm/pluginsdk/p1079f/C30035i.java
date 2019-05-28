package com.tencent.p177mm.pluginsdk.p1079f;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p209c.C32429a;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.pluginsdk.model.app.C35800q;
import com.tencent.p177mm.protocal.C4838o;
import com.tencent.p177mm.protocal.protobuf.che;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;
import java.util.List;

/* renamed from: com.tencent.mm.pluginsdk.f.i */
public final class C30035i {
    private static String nus = "tinker-boots-install-info";
    private static String nut = "tinker-boots-last-show";
    private static String nuu = "tinker-boots-show-time";
    private static String nuv = "";
    private static final long[] vdB = new long[]{0, 259200000, 604800000};

    public static String dhU() {
        AppMethodBeat.m2504i(27437);
        String string = C4996ah.getContext().getSharedPreferences("update_config_prefs", C1448h.m3078Mu()).getString("update_downloaded_pack_md5_key", null);
        AppMethodBeat.m2505o(27437);
        return string;
    }

    public static int dhV() {
        AppMethodBeat.m2504i(27438);
        int i = C4996ah.getContext().getSharedPreferences("update_config_prefs", C1448h.m3078Mu()).getInt("update_downloaded_pack_update_type", 3);
        AppMethodBeat.m2505o(27438);
        return i;
    }

    public static boolean dhW() {
        AppMethodBeat.m2504i(27439);
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("update_config_prefs", C1448h.m3078Mu());
        long j = sharedPreferences.getLong("update_downloaded_cancel_ts", 0);
        int i = sharedPreferences.getInt("update_downloaded_cancel_times", 0);
        C4990ab.m7417i("MicroMsg.UpdateUtil", "checkIgnoreDownloadedPack last: %s times: %s", Long.valueOf(j), Integer.valueOf(i));
        if (i > vdB.length - 1) {
            AppMethodBeat.m2505o(27439);
            return true;
        }
        if (System.currentTimeMillis() - j > vdB[i]) {
            AppMethodBeat.m2505o(27439);
            return false;
        } else if (System.currentTimeMillis() - j < 0) {
            C4990ab.m7412e("MicroMsg.UpdateUtil", "user modify mobile time. we just remove the config.");
            C4996ah.getContext().getSharedPreferences("update_config_prefs", C1448h.m3078Mu()).edit().clear().commit();
            C4990ab.m7416i("MicroMsg.UpdateUtil", "clearUpdateConfigPrefs");
            AppMethodBeat.m2505o(27439);
            return true;
        } else {
            AppMethodBeat.m2505o(27439);
            return true;
        }
    }

    public static boolean dhX() {
        AppMethodBeat.m2504i(27440);
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("update_config_prefs", C1448h.m3078Mu());
        long j = sharedPreferences.getLong("update_downloading_in_silence", 0);
        boolean z = sharedPreferences.getBoolean("update_download_start_one_immediate", false);
        C4990ab.m7417i("MicroMsg.UpdateUtil", "hasUnfinishDownloadingInSilence unfinish %s", Long.valueOf(j));
        if (z || (j != 0 && System.currentTimeMillis() - j > 3600000)) {
            AppMethodBeat.m2505o(27440);
            return true;
        }
        AppMethodBeat.m2505o(27440);
        return false;
    }

    /* renamed from: fN */
    public static String m47538fN(Context context) {
        AppMethodBeat.m2504i(27441);
        String en = C30035i.m47537en(context);
        if (en == null || !new File(en).exists()) {
            AppMethodBeat.m2505o(27441);
            return null;
        }
        C32429a cL = C32429a.m53086cL(en);
        if (cL == null || cL.cdc == null) {
            en = C1178g.m2587cz(en);
            AppMethodBeat.m2505o(27441);
            return en;
        }
        en = cL.cdc.apkMd5;
        AppMethodBeat.m2505o(27441);
        return en;
    }

    /* renamed from: en */
    public static String m47537en(Context context) {
        AppMethodBeat.m2504i(27442);
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir;
            AppMethodBeat.m2505o(27442);
            return str;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.UpdateUtil", e, "", new Object[0]);
            AppMethodBeat.m2505o(27442);
            return null;
        }
    }

    /* renamed from: aC */
    public static void m47536aC(Context context, String str) {
        AppMethodBeat.m2504i(27443);
        C35800q.m58698a(context, new File(str), null, false);
        AppMethodBeat.m2505o(27443);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static che dhY() {
        che che;
        Throwable e;
        AppMethodBeat.m2504i(27444);
        String string = C4996ah.getContext().getSharedPreferences("tinker_patch_share_config", C1448h.m3078Mu()).getString(nus, "");
        if (C5046bo.isNullOrNil(string)) {
            che = null;
        } else {
            che che2;
            try {
                che2 = new che();
                try {
                    che = (che) che2.parseFrom(Base64.decode(string, 0));
                } catch (Exception e2) {
                    e = e2;
                    C4990ab.printErrStackTrace("MicroMsg.UpdateUtil", e, "parse tinker install failed.", new Object[0]);
                    che = che2;
                    if (che != null) {
                    }
                }
            } catch (Exception e3) {
                e = e3;
                che2 = null;
                C4990ab.printErrStackTrace("MicroMsg.UpdateUtil", e, "parse tinker install failed.", new Object[0]);
                che = che2;
                if (che != null) {
                }
            }
        }
        if (che != null) {
            AppMethodBeat.m2505o(27444);
            return che;
        }
        C4990ab.m7416i("MicroMsg.UpdateUtil", "update info is null.");
        AppMethodBeat.m2505o(27444);
        return null;
    }

    public static boolean dhZ() {
        AppMethodBeat.m2504i(27445);
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("tinker_patch_share_config", C1448h.m3078Mu());
        long j = sharedPreferences.getLong(nut, 0);
        int i = sharedPreferences.getInt(nuu, 0);
        C4990ab.m7411d("MicroMsg.UpdateUtil", "isNeedShowTinkerDialog now:%d last:%d time:%d", Long.valueOf(System.currentTimeMillis()), Long.valueOf(j), Integer.valueOf(i));
        if (System.currentTimeMillis() - j <= 21600000 || i >= 3) {
            AppMethodBeat.m2505o(27445);
            return false;
        }
        AppMethodBeat.m2505o(27445);
        return true;
    }

    public static void dia() {
        AppMethodBeat.m2504i(27446);
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("tinker_patch_share_config", C1448h.m3078Mu());
        sharedPreferences.edit().putLong(nut, System.currentTimeMillis()).apply();
        sharedPreferences.edit().putInt(nuu, sharedPreferences.getInt(nuu, 0) + 1).apply();
        AppMethodBeat.m2505o(27446);
    }

    public static String[] getShortIps() {
        int i = 0;
        AppMethodBeat.m2504i(27447);
        if (C1947ae.gii == null || C1947ae.gii.length() <= 0) {
            String string = C4996ah.getContext().getSharedPreferences("system_config_prefs", 0).getString("builtin_short_ips", "");
            if (string == null || string.length() <= 0) {
                string = "0,112.64.200.240,80|0,180.153.82.27,80|0,117.135.130.177,80";
            }
            List akF = C4838o.akF(string);
            String[] strArr = new String[akF.size()];
            while (i < akF.size()) {
                strArr[i] = ((C4838o) akF.get(i)).nJq;
                i++;
            }
            AppMethodBeat.m2505o(27447);
            return strArr;
        }
        String[] strArr2 = new String[]{C1947ae.gii};
        AppMethodBeat.m2505o(27447);
        return strArr2;
    }
}
