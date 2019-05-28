package com.tencent.p177mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C6297k;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.protocal.C4842v.C4843a;
import com.tencent.p177mm.protocal.C4842v.C4844b;

/* renamed from: com.tencent.mm.model.az */
public final class C42186az extends C6297k {
    private final C4843a flU = new C4843a();
    private final C4844b flV = new C4844b();

    public C42186az() {
        AppMethodBeat.m2504i(58106);
        AppMethodBeat.m2505o(58106);
    }

    /* renamed from: ZR */
    public final C4834d mo14537ZR() {
        return this.flU;
    }

    /* renamed from: ZS */
    public final C4835e mo5618ZS() {
        return this.flV;
    }

    public final int getType() {
        return 126;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/newreg";
    }
}
