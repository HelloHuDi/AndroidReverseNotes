package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.xweb.WebView;

public final class m {
    private static String vvl = null;
    private static final String[] vvm = new String[]{"", "dynamic_config_recv", "trigger_download", "start_download", "stop_download", "download_finish", "install_finish", "use"};

    public static void kT(int i) {
        AppMethodBeat.i(114676);
        gu(i, 0);
        AppMethodBeat.o(114676);
    }

    public static void gu(int i, int i2) {
        AppMethodBeat.i(114677);
        if (i <= 0 || i > 7) {
            ab.e("MicroMsg.TBSReporter", "report invalid scene = %d", Integer.valueOf(i));
            AppMethodBeat.o(114677);
            return;
        }
        gQ(i, i2);
        Context context = ah.getContext();
        int installedTbsCoreVersion = WebView.getInstalledTbsCoreVersion(context);
        int tbsSDKVersion = WebView.getTbsSDKVersion(context);
        String fS = fS(context);
        h.pYm.a(11633, false, true, Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() / 1000), Integer.valueOf(installedTbsCoreVersion), Integer.valueOf(tbsSDKVersion), fS, Integer.valueOf(i2));
        AppMethodBeat.o(114677);
    }

    private static String fS(Context context) {
        AppMethodBeat.i(114678);
        String str;
        if (vvl != null) {
            str = vvl;
            AppMethodBeat.o(114678);
            return str;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(ah.getPackageName(), 128);
            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                str = applicationInfo.metaData.getString("com.tencent.mtt.TBS_CODE");
                if (!bo.isNullOrNil(str)) {
                    vvl = str;
                    AppMethodBeat.o(114678);
                    return str;
                }
            }
        } catch (Exception e) {
            ab.e("MicroMsg.TBSReporter", "getMetaTbsCode, ex = %s", e.getMessage());
        }
        AppMethodBeat.o(114678);
        return null;
    }

    private static void gQ(int i, int i2) {
        AppMethodBeat.i(114679);
        ab.i("MicroMsg.TBSReporter", "logSceneDetail, scene = %d_%s, errcode = %d", Integer.valueOf(i), vvm[i], Integer.valueOf(i2));
        AppMethodBeat.o(114679);
    }
}
