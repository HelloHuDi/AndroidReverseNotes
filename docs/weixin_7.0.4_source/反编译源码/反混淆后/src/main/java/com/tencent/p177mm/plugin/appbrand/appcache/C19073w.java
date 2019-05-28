package com.tencent.p177mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.w */
public final class C19073w {
    /* renamed from: a */
    public static String m29638a(C45512ao c45512ao, String str) {
        String str2 = null;
        AppMethodBeat.m2504i(86801);
        if (c45512ao == null || C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(86801);
        } else {
            c45512ao.avW();
            InputStream xy = c45512ao.mo73324xy(str);
            if (xy == null) {
                AppMethodBeat.m2505o(86801);
            } else {
                try {
                    xy.mark(xy.available());
                    String b = C1178g.m2585b(xy, 4096);
                    xy.reset();
                    File file = new File(c45512ao.gUc.getAbsolutePath() + "_xdir/" + str);
                    File parentFile = file.getParentFile();
                    if (parentFile.exists() && parentFile.isFile()) {
                        parentFile.delete();
                    }
                    parentFile.mkdirs();
                    if (!b.equals(C1178g.m2589v(file))) {
                        if (file.isDirectory()) {
                            Runtime.getRuntime().exec("rm -r " + file.getAbsolutePath());
                        } else {
                            file.delete();
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        C1173e.copyStream(xy, fileOutputStream);
                        C5046bo.m7527b(fileOutputStream);
                    }
                    str2 = file.getAbsolutePath();
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.AppBrand.PkgPartialCopy", e, "copy failed", new Object[0]);
                } finally {
                    C5046bo.m7527b(xy);
                    AppMethodBeat.m2505o(86801);
                }
            }
        }
        return str2;
    }
}
