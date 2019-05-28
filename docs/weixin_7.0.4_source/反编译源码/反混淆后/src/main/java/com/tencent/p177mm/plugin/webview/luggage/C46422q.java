package com.tencent.p177mm.plugin.webview.luggage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C43970c.C22988d;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.webview.luggage.q */
public final class C46422q {
    public C24905d uiI;
    public final HashMap<String, String> ujw = new HashMap();
    public final HashMap<String, C22988d> ujx = new HashMap();

    public C46422q(C24905d c24905d) {
        AppMethodBeat.m2504i(6230);
        this.uiI = c24905d;
        AppMethodBeat.m2505o(6230);
    }

    public final String getAppId() {
        AppMethodBeat.m2504i(6231);
        String url = this.uiI.getUrl();
        if (C5046bo.isNullOrNil(url)) {
            AppMethodBeat.m2505o(6231);
            return null;
        }
        url = (String) this.ujw.get(C46422q.aef(url));
        AppMethodBeat.m2505o(6231);
        return url;
    }

    public static String aef(String str) {
        AppMethodBeat.m2504i(6232);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(6232);
            return str;
        }
        int indexOf = str.indexOf("#");
        if (indexOf < 0) {
            AppMethodBeat.m2505o(6232);
            return str;
        }
        str = str.substring(0, indexOf);
        AppMethodBeat.m2505o(6232);
        return str;
    }
}
