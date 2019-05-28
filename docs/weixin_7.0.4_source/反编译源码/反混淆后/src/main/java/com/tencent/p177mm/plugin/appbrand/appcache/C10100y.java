package com.tencent.p177mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.loader.C32473a;
import com.tencent.p177mm.plugin.appbrand.appstorage.C42367l;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.y */
public final class C10100y {
    private static String[] gTA = new String[]{"__APP__", "__WITHOUT_CODELIB__", "__CODELIB__"};
    private String appId;
    private String gTy;
    private volatile String gTz;

    public C10100y(String str, String str2) {
        AppMethodBeat.m2504i(101719);
        this.appId = str;
        this.gTy = C10100y.m17694xs(str2);
        AppMethodBeat.m2505o(101719);
    }

    /* renamed from: xs */
    private static String m17694xs(String str) {
        AppMethodBeat.m2504i(101720);
        if (C5046bo.isNullOrNil(str) || C32473a.contains(gTA, (Object) str)) {
            AppMethodBeat.m2505o(101720);
            return str;
        }
        str = C42367l.m74946yk(str);
        AppMethodBeat.m2505o(101720);
        return str;
    }

    public C10100y(String str, String str2, int i) {
        String str3;
        AppMethodBeat.m2504i(101721);
        if (i == 13) {
            str3 = C10100y.m17694xs(str2) + '$' + "__WITHOUT_CODELIB__";
        } else {
            str3 = C10100y.m17694xs(str2);
        }
        this.gTy = str3;
        this.appId = str;
        AppMethodBeat.m2505o(101721);
    }

    public C10100y(String str) {
        this.appId = str;
        this.gTy = null;
    }

    public final String toString() {
        AppMethodBeat.m2504i(101722);
        if (C5046bo.isNullOrNil(this.gTz)) {
            this.gTz = this.appId + (C5046bo.isNullOrNil(this.gTy) ? "" : "$" + this.gTy);
        }
        String str = this.gTz;
        AppMethodBeat.m2505o(101722);
        return str;
    }
}
