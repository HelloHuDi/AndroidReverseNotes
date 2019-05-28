package com.tencent.p177mm.plugin.appbrand.p322m.p1229b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p322m.C45651d;
import com.tencent.p177mm.plugin.appbrand.p328r.C45672d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.m.b.a */
public class C19598a {
    public C45651d iqc;

    public final String aIW() {
        AppMethodBeat.m2504i(102189);
        C4990ab.m7416i("MicroMsg.AppBrandNodeJSInstallHelper", "getNodeInjectJs");
        if (this.iqc == null) {
            IllegalStateException illegalStateException = new IllegalStateException("You had not called whenCreateJsRuntime!");
            AppMethodBeat.m2505o(102189);
            throw illegalStateException;
        }
        String Eb = C45672d.m84370Eb("wxa_library/node_jsapi.js");
        AppMethodBeat.m2505o(102189);
        return Eb;
    }
}
