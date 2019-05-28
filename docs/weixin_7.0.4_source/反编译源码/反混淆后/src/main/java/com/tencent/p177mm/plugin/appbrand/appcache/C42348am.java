package com.tencent.p177mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.am */
public final class C42348am {
    /* renamed from: a */
    public static void m74896a(FilenameFilter filenameFilter) {
        AppMethodBeat.m2504i(59481);
        String str = C1720g.m3536RP().cachePath;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        File file = new File(str + "appbrand/jscache");
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles(filenameFilter);
            if (listFiles != null && listFiles.length > 0) {
                for (File t : listFiles) {
                    C1173e.m2575t(t);
                    C4990ab.m7417i("WxaJsCacheStorage", "clear file:%s", t.getName());
                }
            }
        }
        AppMethodBeat.m2505o(59481);
    }

    public final void clear(final String str) {
        AppMethodBeat.m2504i(59482);
        C42348am.m74896a(new FilenameFilter() {
            public final boolean accept(File file, String str) {
                AppMethodBeat.m2504i(59480);
                boolean endsWith = str.endsWith("_" + str);
                AppMethodBeat.m2505o(59480);
                return endsWith;
            }
        });
        AppMethodBeat.m2505o(59482);
    }
}
