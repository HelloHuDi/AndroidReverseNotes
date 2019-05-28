package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;
import java.io.FilenameFilter;

public final class am {
    public static void a(FilenameFilter filenameFilter) {
        AppMethodBeat.i(59481);
        String str = g.RP().cachePath;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        File file = new File(str + "appbrand/jscache");
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles(filenameFilter);
            if (listFiles != null && listFiles.length > 0) {
                for (File t : listFiles) {
                    e.t(t);
                    ab.i("WxaJsCacheStorage", "clear file:%s", t.getName());
                }
            }
        }
        AppMethodBeat.o(59481);
    }

    public final void clear(final String str) {
        AppMethodBeat.i(59482);
        a(new FilenameFilter() {
            public final boolean accept(File file, String str) {
                AppMethodBeat.i(59480);
                boolean endsWith = str.endsWith("_" + str);
                AppMethodBeat.o(59480);
                return endsWith;
            }
        });
        AppMethodBeat.o(59482);
    }
}
