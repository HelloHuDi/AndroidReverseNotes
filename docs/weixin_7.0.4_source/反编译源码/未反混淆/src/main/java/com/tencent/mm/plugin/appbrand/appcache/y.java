package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.sdk.platformtools.bo;

public final class y {
    private static String[] gTA = new String[]{"__APP__", "__WITHOUT_CODELIB__", "__CODELIB__"};
    private String appId;
    private String gTy;
    private volatile String gTz;

    public y(String str, String str2) {
        AppMethodBeat.i(101719);
        this.appId = str;
        this.gTy = xs(str2);
        AppMethodBeat.o(101719);
    }

    private static String xs(String str) {
        AppMethodBeat.i(101720);
        if (bo.isNullOrNil(str) || a.contains(gTA, (Object) str)) {
            AppMethodBeat.o(101720);
            return str;
        }
        str = l.yk(str);
        AppMethodBeat.o(101720);
        return str;
    }

    public y(String str, String str2, int i) {
        String str3;
        AppMethodBeat.i(101721);
        if (i == 13) {
            str3 = xs(str2) + '$' + "__WITHOUT_CODELIB__";
        } else {
            str3 = xs(str2);
        }
        this.gTy = str3;
        this.appId = str;
        AppMethodBeat.o(101721);
    }

    public y(String str) {
        this.appId = str;
        this.gTy = null;
    }

    public final String toString() {
        AppMethodBeat.i(101722);
        if (bo.isNullOrNil(this.gTz)) {
            this.gTz = this.appId + (bo.isNullOrNil(this.gTy) ? "" : "$" + this.gTy);
        }
        String str = this.gTz;
        AppMethodBeat.o(101722);
        return str;
    }
}
