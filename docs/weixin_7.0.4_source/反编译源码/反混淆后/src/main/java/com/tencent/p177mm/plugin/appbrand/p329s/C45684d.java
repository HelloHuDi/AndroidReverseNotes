package com.tencent.p177mm.plugin.appbrand.p329s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19475s;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.sdk.platformtools.C30292bc.C23502a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.s.d */
public final class C45684d {
    public C2241c hvw;
    public C23502a iRh = new C335251();

    /* renamed from: com.tencent.mm.plugin.appbrand.s.d$1 */
    class C335251 implements C23502a {
        C335251() {
        }

        public final void aNW() {
            AppMethodBeat.m2504i(87407);
            C4990ab.m7416i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onScreenShot callback");
            C19475s.m30162k(C45684d.this.hvw);
            AppMethodBeat.m2505o(87407);
        }
    }

    public C45684d() {
        AppMethodBeat.m2504i(87408);
        AppMethodBeat.m2505o(87408);
    }
}
