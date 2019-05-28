package com.tencent.p177mm.plugin.webview.model;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.websearch.api.C43852n;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C30152u;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.webview.model.ah */
public final class C43911ah {
    private static final Set<String> ums;

    static {
        String str;
        AppMethodBeat.m2504i(6696);
        HashSet hashSet = new HashSet();
        ums = hashSet;
        hashSet.add("file:///android_asset/");
        String str2 = C6457e.eSk;
        if (C5046bo.isNullOrNil(str2)) {
            str = str2;
        } else {
            str = C6457e.eSk.replace("/data/user/0", "/data/data");
        }
        ums.add("file://" + new File(C46400aa.m87310Ia(0)).getAbsolutePath());
        ums.add("file://" + ((C43852n) C1720g.m3528K(C43852n.class)).cUN());
        ums.add("file://" + new File(C6457e.eSn, C46400aa.m87308HY(0)).getAbsolutePath());
        ums.add("file://" + new File(str, "wenote/res").getAbsolutePath());
        ums.add("file://" + new File(C6457e.eSn, "wenote/res").getAbsolutePath());
        C4990ab.m7417i("MicroMsg.URLFilter", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", r2.getAbsolutePath(), r0.getAbsolutePath());
        ums.add("file://" + new File(str, "emoji/res").getAbsolutePath());
        ums.add("file://" + new File(C6457e.eSn, "emoji/res").getAbsolutePath());
        C4990ab.m7417i("MicroMsg.URLFilter", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", r0.getAbsolutePath(), r1.getAbsolutePath());
        Iterator it = ums.iterator();
        while (it.hasNext()) {
            C4990ab.m7417i("MicroMsg.URLFilter", "WebViewUI white list path : %s", (String) it.next());
        }
        AppMethodBeat.m2505o(6696);
    }

    public static boolean aes(String str) {
        AppMethodBeat.m2504i(6695);
        if (C1947ae.giw) {
            C4990ab.m7420w("MicroMsg.URLFilter", "skipLoadUrlCheck");
            AppMethodBeat.m2505o(6695);
            return true;
        } else if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(6695);
            return true;
        } else {
            String toLowerCase = str.toLowerCase();
            if (toLowerCase.startsWith("about:blank")) {
                AppMethodBeat.m2505o(6695);
                return false;
            } else if (toLowerCase.startsWith("file://")) {
                for (String startsWith : ums) {
                    if (toLowerCase.startsWith(startsWith)) {
                        AppMethodBeat.m2505o(6695);
                        return true;
                    }
                }
                AppMethodBeat.m2505o(6695);
                return false;
            } else {
                Uri parse = Uri.parse(toLowerCase);
                if (C5046bo.isNullOrNil(parse.getHost())) {
                    AppMethodBeat.m2505o(6695);
                    return true;
                } else if (parse.getHost().contains(C30152u.bOO())) {
                    AppMethodBeat.m2505o(6695);
                    return false;
                } else {
                    AppMethodBeat.m2505o(6695);
                    return true;
                }
            }
        }
    }
}
