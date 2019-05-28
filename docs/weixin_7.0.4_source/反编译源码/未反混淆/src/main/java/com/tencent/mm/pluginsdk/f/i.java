package com.tencent.mm.pluginsdk.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.c.a;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.protocal.o;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.List;

public final class i {
    private static String nus = "tinker-boots-install-info";
    private static String nut = "tinker-boots-last-show";
    private static String nuu = "tinker-boots-show-time";
    private static String nuv = "";
    private static final long[] vdB = new long[]{0, 259200000, 604800000};

    public static String dhU() {
        AppMethodBeat.i(27437);
        String string = ah.getContext().getSharedPreferences("update_config_prefs", h.Mu()).getString("update_downloaded_pack_md5_key", null);
        AppMethodBeat.o(27437);
        return string;
    }

    public static int dhV() {
        AppMethodBeat.i(27438);
        int i = ah.getContext().getSharedPreferences("update_config_prefs", h.Mu()).getInt("update_downloaded_pack_update_type", 3);
        AppMethodBeat.o(27438);
        return i;
    }

    public static boolean dhW() {
        AppMethodBeat.i(27439);
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("update_config_prefs", h.Mu());
        long j = sharedPreferences.getLong("update_downloaded_cancel_ts", 0);
        int i = sharedPreferences.getInt("update_downloaded_cancel_times", 0);
        ab.i("MicroMsg.UpdateUtil", "checkIgnoreDownloadedPack last: %s times: %s", Long.valueOf(j), Integer.valueOf(i));
        if (i > vdB.length - 1) {
            AppMethodBeat.o(27439);
            return true;
        }
        if (System.currentTimeMillis() - j > vdB[i]) {
            AppMethodBeat.o(27439);
            return false;
        } else if (System.currentTimeMillis() - j < 0) {
            ab.e("MicroMsg.UpdateUtil", "user modify mobile time. we just remove the config.");
            ah.getContext().getSharedPreferences("update_config_prefs", h.Mu()).edit().clear().commit();
            ab.i("MicroMsg.UpdateUtil", "clearUpdateConfigPrefs");
            AppMethodBeat.o(27439);
            return true;
        } else {
            AppMethodBeat.o(27439);
            return true;
        }
    }

    public static boolean dhX() {
        AppMethodBeat.i(27440);
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("update_config_prefs", h.Mu());
        long j = sharedPreferences.getLong("update_downloading_in_silence", 0);
        boolean z = sharedPreferences.getBoolean("update_download_start_one_immediate", false);
        ab.i("MicroMsg.UpdateUtil", "hasUnfinishDownloadingInSilence unfinish %s", Long.valueOf(j));
        if (z || (j != 0 && System.currentTimeMillis() - j > 3600000)) {
            AppMethodBeat.o(27440);
            return true;
        }
        AppMethodBeat.o(27440);
        return false;
    }

    public static String fN(Context context) {
        AppMethodBeat.i(27441);
        String en = en(context);
        if (en == null || !new File(en).exists()) {
            AppMethodBeat.o(27441);
            return null;
        }
        a cL = a.cL(en);
        if (cL == null || cL.cdc == null) {
            en = g.cz(en);
            AppMethodBeat.o(27441);
            return en;
        }
        en = cL.cdc.apkMd5;
        AppMethodBeat.o(27441);
        return en;
    }

    public static String en(Context context) {
        AppMethodBeat.i(27442);
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir;
            AppMethodBeat.o(27442);
            return str;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.UpdateUtil", e, "", new Object[0]);
            AppMethodBeat.o(27442);
            return null;
        }
    }

    public static void aC(Context context, String str) {
        AppMethodBeat.i(27443);
        q.a(context, new File(str), null, false);
        AppMethodBeat.o(27443);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static che dhY() {
        che che;
        Throwable e;
        AppMethodBeat.i(27444);
        String string = ah.getContext().getSharedPreferences("tinker_patch_share_config", h.Mu()).getString(nus, "");
        if (bo.isNullOrNil(string)) {
            che = null;
        } else {
            che che2;
            try {
                che2 = new che();
                try {
                    che = (che) che2.parseFrom(Base64.decode(string, 0));
                } catch (Exception e2) {
                    e = e2;
                    ab.printErrStackTrace("MicroMsg.UpdateUtil", e, "parse tinker install failed.", new Object[0]);
                    che = che2;
                    if (che != null) {
                    }
                }
            } catch (Exception e3) {
                e = e3;
                che2 = null;
                ab.printErrStackTrace("MicroMsg.UpdateUtil", e, "parse tinker install failed.", new Object[0]);
                che = che2;
                if (che != null) {
                }
            }
        }
        if (che != null) {
            AppMethodBeat.o(27444);
            return che;
        }
        ab.i("MicroMsg.UpdateUtil", "update info is null.");
        AppMethodBeat.o(27444);
        return null;
    }

    public static boolean dhZ() {
        AppMethodBeat.i(27445);
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("tinker_patch_share_config", h.Mu());
        long j = sharedPreferences.getLong(nut, 0);
        int i = sharedPreferences.getInt(nuu, 0);
        ab.d("MicroMsg.UpdateUtil", "isNeedShowTinkerDialog now:%d last:%d time:%d", Long.valueOf(System.currentTimeMillis()), Long.valueOf(j), Integer.valueOf(i));
        if (System.currentTimeMillis() - j <= 21600000 || i >= 3) {
            AppMethodBeat.o(27445);
            return false;
        }
        AppMethodBeat.o(27445);
        return true;
    }

    public static void dia() {
        AppMethodBeat.i(27446);
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("tinker_patch_share_config", h.Mu());
        sharedPreferences.edit().putLong(nut, System.currentTimeMillis()).apply();
        sharedPreferences.edit().putInt(nuu, sharedPreferences.getInt(nuu, 0) + 1).apply();
        AppMethodBeat.o(27446);
    }

    public static String[] getShortIps() {
        int i = 0;
        AppMethodBeat.i(27447);
        if (ae.gii == null || ae.gii.length() <= 0) {
            String string = ah.getContext().getSharedPreferences("system_config_prefs", 0).getString("builtin_short_ips", "");
            if (string == null || string.length() <= 0) {
                string = "0,112.64.200.240,80|0,180.153.82.27,80|0,117.135.130.177,80";
            }
            List akF = o.akF(string);
            String[] strArr = new String[akF.size()];
            while (i < akF.size()) {
                strArr[i] = ((o) akF.get(i)).nJq;
                i++;
            }
            AppMethodBeat.o(27447);
            return strArr;
        }
        String[] strArr2 = new String[]{ae.gii};
        AppMethodBeat.o(27447);
        return strArr2;
    }
}
