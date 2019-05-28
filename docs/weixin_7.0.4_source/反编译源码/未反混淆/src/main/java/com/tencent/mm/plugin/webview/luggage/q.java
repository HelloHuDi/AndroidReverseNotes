package com.tencent.mm.plugin.webview.luggage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.d;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public final class q {
    public d uiI;
    public final HashMap<String, String> ujw = new HashMap();
    public final HashMap<String, d> ujx = new HashMap();

    public q(d dVar) {
        AppMethodBeat.i(6230);
        this.uiI = dVar;
        AppMethodBeat.o(6230);
    }

    public final String getAppId() {
        AppMethodBeat.i(6231);
        String url = this.uiI.getUrl();
        if (bo.isNullOrNil(url)) {
            AppMethodBeat.o(6231);
            return null;
        }
        url = (String) this.ujw.get(aef(url));
        AppMethodBeat.o(6231);
        return url;
    }

    public static String aef(String str) {
        AppMethodBeat.i(6232);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(6232);
            return str;
        }
        int indexOf = str.indexOf("#");
        if (indexOf < 0) {
            AppMethodBeat.o(6232);
            return str;
        }
        str = str.substring(0, indexOf);
        AppMethodBeat.o(6232);
        return str;
    }
}
