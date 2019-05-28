package com.tencent.mm.plugin.report.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.a.q;
import com.tencent.mm.model.av;
import com.tencent.mm.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class f {
    public static boolean VZ(String str) {
        AppMethodBeat.i(72678);
        File file = new File("/sdcard/cov.txt");
        if (file.exists()) {
            String T = av.fly.T("login_user_name", "never_login_crash");
            a(T, file, str);
            String b = q.b(file, false, "/sdcard/cov/cov_" + new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date()) + ".zip");
            if (b == null) {
                ab.e("MicroMsg.NetSceneCodeCoverageReport", "zip file failed");
                AppMethodBeat.o(72678);
                return false;
            }
            file.delete();
            ab.i("MicroMsg.NetSceneCodeCoverageReport", "code coverage try upload :".concat(String.valueOf(T)));
            ad.a(b, T, false, false, 20004);
            AppMethodBeat.o(72678);
            return true;
        }
        ab.w("MicroMsg.NetSceneCodeCoverageReport", "codecoverage checkUpload dir never create ?");
        AppMethodBeat.o(72678);
        return false;
    }

    private static void a(String str, File file, String str2) {
        AppMethodBeat.i(72679);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("#username=".concat(String.valueOf(str)));
        stringBuffer.append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuffer.append("#rev=" + com.tencent.mm.sdk.platformtools.f.REV);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuffer.append("#path=" + com.tencent.mm.sdk.platformtools.f.SVNPATH);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_UNIX);
        if (str2.length() > 0) {
            stringBuffer.append("#startrev=".concat(String.valueOf(str2)));
            stringBuffer.append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        e.e(file.getAbsolutePath(), stringBuffer.toString().getBytes());
        AppMethodBeat.o(72679);
    }
}
