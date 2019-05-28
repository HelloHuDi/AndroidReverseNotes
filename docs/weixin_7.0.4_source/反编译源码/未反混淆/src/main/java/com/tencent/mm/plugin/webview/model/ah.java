package com.tencent.mm.plugin.webview.model;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.n;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class ah {
    private static final Set<String> ums;

    static {
        String str;
        AppMethodBeat.i(6696);
        HashSet hashSet = new HashSet();
        ums = hashSet;
        hashSet.add("file:///android_asset/");
        String str2 = e.eSk;
        if (bo.isNullOrNil(str2)) {
            str = str2;
        } else {
            str = e.eSk.replace("/data/user/0", "/data/data");
        }
        ums.add("file://" + new File(aa.Ia(0)).getAbsolutePath());
        ums.add("file://" + ((n) g.K(n.class)).cUN());
        ums.add("file://" + new File(e.eSn, aa.HY(0)).getAbsolutePath());
        ums.add("file://" + new File(str, "wenote/res").getAbsolutePath());
        ums.add("file://" + new File(e.eSn, "wenote/res").getAbsolutePath());
        ab.i("MicroMsg.URLFilter", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", r2.getAbsolutePath(), r0.getAbsolutePath());
        ums.add("file://" + new File(str, "emoji/res").getAbsolutePath());
        ums.add("file://" + new File(e.eSn, "emoji/res").getAbsolutePath());
        ab.i("MicroMsg.URLFilter", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", r0.getAbsolutePath(), r1.getAbsolutePath());
        Iterator it = ums.iterator();
        while (it.hasNext()) {
            ab.i("MicroMsg.URLFilter", "WebViewUI white list path : %s", (String) it.next());
        }
        AppMethodBeat.o(6696);
    }

    public static boolean aes(String str) {
        AppMethodBeat.i(6695);
        if (ae.giw) {
            ab.w("MicroMsg.URLFilter", "skipLoadUrlCheck");
            AppMethodBeat.o(6695);
            return true;
        } else if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(6695);
            return true;
        } else {
            String toLowerCase = str.toLowerCase();
            if (toLowerCase.startsWith("about:blank")) {
                AppMethodBeat.o(6695);
                return false;
            } else if (toLowerCase.startsWith("file://")) {
                for (String startsWith : ums) {
                    if (toLowerCase.startsWith(startsWith)) {
                        AppMethodBeat.o(6695);
                        return true;
                    }
                }
                AppMethodBeat.o(6695);
                return false;
            } else {
                Uri parse = Uri.parse(toLowerCase);
                if (bo.isNullOrNil(parse.getHost())) {
                    AppMethodBeat.o(6695);
                    return true;
                } else if (parse.getHost().contains(u.bOO())) {
                    AppMethodBeat.o(6695);
                    return false;
                } else {
                    AppMethodBeat.o(6695);
                    return true;
                }
            }
        }
    }
}
