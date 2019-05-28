package com.tencent.p177mm.plugin.soter.p527b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C6297k;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42466ag;
import com.tencent.p177mm.plugin.soter.p527b.C4101c.C4102a;
import com.tencent.p177mm.plugin.soter.p527b.C4101c.C4103b;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;

/* renamed from: com.tencent.mm.plugin.soter.b.b */
final class C22153b extends C6297k {
    C4102a rNC = new C4102a();
    C4103b rND = new C4103b();

    C22153b() {
        AppMethodBeat.m2504i(59297);
        AppMethodBeat.m2505o(59297);
    }

    public final int getType() {
        return C42466ag.CTRL_INDEX;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/updatesoteraskrsa";
    }

    /* renamed from: ZS */
    public final C4835e mo5618ZS() {
        return this.rND;
    }

    /* renamed from: ZR */
    public final C4834d mo14537ZR() {
        return this.rNC;
    }

    public final int acC() {
        return 1;
    }
}
