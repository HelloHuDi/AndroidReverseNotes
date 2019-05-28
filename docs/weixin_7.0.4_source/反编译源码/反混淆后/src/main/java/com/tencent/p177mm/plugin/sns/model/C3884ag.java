package com.tencent.p177mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.p517i.C43548b;

/* renamed from: com.tencent.mm.plugin.sns.model.ag */
public final class C3884ag implements C29045ae {
    private C43548b qMn;
    private int scene;

    public C3884ag() {
        this.scene = 0;
        this.scene = 2;
    }

    public final int bFf() {
        return this.scene;
    }

    public final C43548b cnj() {
        AppMethodBeat.m2504i(36525);
        if (this.qMn == null) {
            this.qMn = new C43548b();
        }
        C43548b c43548b = this.qMn;
        AppMethodBeat.m2505o(36525);
        return c43548b;
    }
}
