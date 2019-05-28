package com.tencent.p177mm.plugin.appbrand.compat;

import android.support.annotation.Keep;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1671c;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.kernel.p242c.C6625e;
import com.tencent.p177mm.plugin.appbrand.compat.p887a.C38157b;
import com.tencent.p177mm.plugin.appbrand.compat.p887a.C42401a;
import com.tencent.p177mm.plugin.appbrand.compat.p887a.C45534c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p316t.C42583c.C19489a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p316t.C42584d;

@Keep
@Deprecated
/* renamed from: com.tencent.mm.plugin.appbrand.compat.PluginAppBrandCompat */
public final class PluginAppBrandCompat extends C7597f implements C1671c, C45534c {
    public final void installed() {
        AppMethodBeat.m2504i(17021);
        super.installed();
        alias(C45534c.class);
        AppMethodBeat.m2505o(17021);
    }

    public final void configure(C1681g c1681g) {
    }

    public final void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(17022);
        if (c1681g.mo5181SG()) {
            C1720g.m3543a(C38157b.class, new C6625e(new C26827b()));
        } else {
            C37384e.m62987a(C19489a.class, new C42584d());
        }
        C1720g.m3543a(C42401a.class, new C6625e(new C10168a()));
        AppMethodBeat.m2505o(17022);
    }

    public final void onAccountInitialized(C1705c c1705c) {
    }

    public final void onAccountRelease() {
    }
}
