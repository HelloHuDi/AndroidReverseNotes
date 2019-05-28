package com.tencent.p177mm.audio.mix.p1181b.p1182a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.p831d.C41777h;
import com.tencent.p177mm.audio.mix.p831d.C41778i;

/* renamed from: com.tencent.mm.audio.mix.b.a.e */
public final class C17953e extends C41778i {
    private C25837f ckS;

    public C17953e(C25837f c25837f, String str) {
        super(str);
        this.ckS = c25837f;
    }

    public final void run() {
        AppMethodBeat.m2504i(137007);
        if (this.ckS != null) {
            this.ckS.mo43825Dp();
            this.ckS.end();
        }
        this.ckS = null;
        C41777h.m73747b(this);
        AppMethodBeat.m2505o(137007);
    }
}
