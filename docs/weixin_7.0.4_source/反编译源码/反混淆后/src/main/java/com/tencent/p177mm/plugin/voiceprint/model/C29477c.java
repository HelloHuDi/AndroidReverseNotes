package com.tencent.p177mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C32775bc.C18618a;
import com.tencent.p177mm.model.C32775bc.C6666b;
import com.tencent.p177mm.p183ai.C6297k;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38271be;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;

/* renamed from: com.tencent.mm.plugin.voiceprint.model.c */
final class C29477c extends C6297k {
    C18618a sKU = new C18618a();
    C6666b sKV = new C6666b();

    C29477c() {
        AppMethodBeat.m2504i(26077);
        AppMethodBeat.m2505o(26077);
    }

    public final int getType() {
        return C38271be.CTRL_INDEX;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/verifyvoiceprintrsa";
    }

    /* renamed from: ZS */
    public final C4835e mo5618ZS() {
        return this.sKV;
    }

    /* renamed from: ZR */
    public final C4834d mo14537ZR() {
        return this.sKU;
    }

    public final int acC() {
        return 1;
    }
}
