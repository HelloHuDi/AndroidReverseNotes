package com.tencent.p177mm.plugin.appbrand.appcache;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1173e;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.ba */
public final class C38115ba {
    public static void clear(String str) {
        AppMethodBeat.m2504i(59545);
        String str2 = C1720g.m3536RP().cachePath;
        if (!str2.endsWith("/")) {
            str2 = str2 + "/";
        }
        File file = new File(str2 + "appbrand/loadingurl" + File.separator + str);
        if (file.exists() && file.isDirectory()) {
            C1173e.m2575t(file);
        }
        str2 = Environment.getExternalStorageDirectory().getAbsolutePath();
        if (!str2.endsWith("/")) {
            str2 = str2 + "/";
        }
        file = new File(str2 + "Tencent/MicroMsg/appbrand/loadingurl");
        if (file.exists() && file.isDirectory()) {
            C1173e.m2575t(file);
        }
        AppMethodBeat.m2505o(59545);
    }
}
