package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import java.io.File;

public final class ba {
    public static void clear(String str) {
        AppMethodBeat.i(59545);
        String str2 = g.RP().cachePath;
        if (!str2.endsWith("/")) {
            str2 = str2 + "/";
        }
        File file = new File(str2 + "appbrand/loadingurl" + File.separator + str);
        if (file.exists() && file.isDirectory()) {
            e.t(file);
        }
        str2 = Environment.getExternalStorageDirectory().getAbsolutePath();
        if (!str2.endsWith("/")) {
            str2 = str2 + "/";
        }
        file = new File(str2 + "Tencent/MicroMsg/appbrand/loadingurl");
        if (file.exists() && file.isDirectory()) {
            e.t(file);
        }
        AppMethodBeat.o(59545);
    }
}
