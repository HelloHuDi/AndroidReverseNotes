package com.tencent.p177mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9647bb.C9648a;
import com.tencent.p177mm.model.C9647bb.C9649b;
import com.tencent.p177mm.p183ai.C6297k;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45579bb;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;

/* renamed from: com.tencent.mm.plugin.voiceprint.model.b */
final class C40015b extends C6297k {
    C9648a sKS = new C9648a();
    C9649b sKT = new C9649b();

    C40015b() {
        AppMethodBeat.m2504i(26076);
        AppMethodBeat.m2505o(26076);
    }

    public final int getType() {
        return C45579bb.CTRL_INDEX;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/getvoiceprintticketrsa";
    }

    /* renamed from: ZS */
    public final C4835e mo5618ZS() {
        return this.sKT;
    }

    /* renamed from: ZR */
    public final C4834d mo14537ZR() {
        return this.sKS;
    }

    public final int acC() {
        return 1;
    }
}
