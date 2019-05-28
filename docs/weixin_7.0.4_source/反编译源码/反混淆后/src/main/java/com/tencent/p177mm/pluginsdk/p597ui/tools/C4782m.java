package com.tencent.p177mm.pluginsdk.p597ui.tools;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.xweb.WebView;

/* renamed from: com.tencent.mm.pluginsdk.ui.tools.m */
public final class C4782m {
    private static String vvl = null;
    private static final String[] vvm = new String[]{"", "dynamic_config_recv", "trigger_download", "start_download", "stop_download", "download_finish", "install_finish", "use"};

    /* renamed from: kT */
    public static void m7141kT(int i) {
        AppMethodBeat.m2504i(114676);
        C4782m.m7140gu(i, 0);
        AppMethodBeat.m2505o(114676);
    }

    /* renamed from: gu */
    public static void m7140gu(int i, int i2) {
        AppMethodBeat.m2504i(114677);
        if (i <= 0 || i > 7) {
            C4990ab.m7413e("MicroMsg.TBSReporter", "report invalid scene = %d", Integer.valueOf(i));
            AppMethodBeat.m2505o(114677);
            return;
        }
        C4782m.m7139gQ(i, i2);
        Context context = C4996ah.getContext();
        int installedTbsCoreVersion = WebView.getInstalledTbsCoreVersion(context);
        int tbsSDKVersion = WebView.getTbsSDKVersion(context);
        String fS = C4782m.m7138fS(context);
        C7060h.pYm.mo8377a(11633, false, true, Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() / 1000), Integer.valueOf(installedTbsCoreVersion), Integer.valueOf(tbsSDKVersion), fS, Integer.valueOf(i2));
        AppMethodBeat.m2505o(114677);
    }

    /* renamed from: fS */
    private static String m7138fS(Context context) {
        AppMethodBeat.m2504i(114678);
        String str;
        if (vvl != null) {
            str = vvl;
            AppMethodBeat.m2505o(114678);
            return str;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(C4996ah.getPackageName(), 128);
            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                str = applicationInfo.metaData.getString("com.tencent.mtt.TBS_CODE");
                if (!C5046bo.isNullOrNil(str)) {
                    vvl = str;
                    AppMethodBeat.m2505o(114678);
                    return str;
                }
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.TBSReporter", "getMetaTbsCode, ex = %s", e.getMessage());
        }
        AppMethodBeat.m2505o(114678);
        return null;
    }

    /* renamed from: gQ */
    private static void m7139gQ(int i, int i2) {
        AppMethodBeat.m2504i(114679);
        C4990ab.m7417i("MicroMsg.TBSReporter", "logSceneDetail, scene = %d_%s, errcode = %d", Integer.valueOf(i), vvm[i], Integer.valueOf(i2));
        AppMethodBeat.m2505o(114679);
    }
}
