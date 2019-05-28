package com.tencent.p177mm.plugin.report.p499b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C6665av;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C8900q;
import com.tencent.p177mm.platformtools.C9784ad;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.tencent.mm.plugin.report.b.f */
public final class C3733f {
    /* renamed from: VZ */
    public static boolean m6039VZ(String str) {
        AppMethodBeat.m2504i(72678);
        File file = new File("/sdcard/cov.txt");
        if (file.exists()) {
            String T = C6665av.fly.mo5292T("login_user_name", "never_login_crash");
            C3733f.m6040a(T, file, str);
            String b = C8900q.m16038b(file, false, "/sdcard/cov/cov_" + new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date()) + ".zip");
            if (b == null) {
                C4990ab.m7412e("MicroMsg.NetSceneCodeCoverageReport", "zip file failed");
                AppMethodBeat.m2505o(72678);
                return false;
            }
            file.delete();
            C4990ab.m7416i("MicroMsg.NetSceneCodeCoverageReport", "code coverage try upload :".concat(String.valueOf(T)));
            C9784ad.m17422a(b, T, false, false, 20004);
            AppMethodBeat.m2505o(72678);
            return true;
        }
        C4990ab.m7420w("MicroMsg.NetSceneCodeCoverageReport", "codecoverage checkUpload dir never create ?");
        AppMethodBeat.m2505o(72678);
        return false;
    }

    /* renamed from: a */
    private static void m6040a(String str, File file, String str2) {
        AppMethodBeat.m2504i(72679);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("#username=".concat(String.valueOf(str)));
        stringBuffer.append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuffer.append("#rev=" + C5058f.REV);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuffer.append("#path=" + C5058f.SVNPATH);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_UNIX);
        if (str2.length() > 0) {
            stringBuffer.append("#startrev=".concat(String.valueOf(str2)));
            stringBuffer.append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        C1173e.m2568e(file.getAbsolutePath(), stringBuffer.toString().getBytes());
        AppMethodBeat.m2505o(72679);
    }
}
