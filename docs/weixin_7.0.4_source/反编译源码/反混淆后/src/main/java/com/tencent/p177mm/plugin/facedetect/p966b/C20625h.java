package com.tencent.p177mm.plugin.facedetect.p966b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C6297k;
import com.tencent.p177mm.plugin.facedetect.p966b.C43025i.C20626a;
import com.tencent.p177mm.plugin.facedetect.p966b.C43025i.C43024b;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;

/* renamed from: com.tencent.mm.plugin.facedetect.b.h */
final class C20625h extends C6297k {
    C20626a lSx = new C20626a();
    C43024b lSy = new C43024b();

    C20625h() {
        AppMethodBeat.m2504i(65);
        AppMethodBeat.m2505o(65);
    }

    public final int getType() {
        return 733;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/getbioconfigrsa";
    }

    /* renamed from: ZS */
    public final C4835e mo5618ZS() {
        return this.lSy;
    }

    /* renamed from: ZR */
    public final C4834d mo14537ZR() {
        return this.lSx;
    }

    public final int acC() {
        return 1;
    }
}
