package com.tencent.p177mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18615ba.C18616a;
import com.tencent.p177mm.model.C18615ba.C18617b;
import com.tencent.p177mm.p183ai.C6297k;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45580bd;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;

/* renamed from: com.tencent.mm.plugin.voiceprint.model.a */
final class C35341a extends C6297k {
    C18616a sKQ = new C18616a();
    C18617b sKR = new C18617b();

    C35341a() {
        AppMethodBeat.m2504i(26075);
        AppMethodBeat.m2505o(26075);
    }

    public final int getType() {
        return C45580bd.CTRL_INDEX;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/getvoiceprintresourcersa";
    }

    /* renamed from: ZS */
    public final C4835e mo5618ZS() {
        return this.sKR;
    }

    /* renamed from: ZR */
    public final C4834d mo14537ZR() {
        return this.sKQ;
    }

    public final int acC() {
        return 1;
    }
}
