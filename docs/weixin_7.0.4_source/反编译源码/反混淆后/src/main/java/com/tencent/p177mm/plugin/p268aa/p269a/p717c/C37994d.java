package com.tencent.p177mm.plugin.p268aa.p269a.p717c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.plugin.p268aa.p269a.C32895e;
import com.tencent.p177mm.plugin.p268aa.p269a.C38004l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vending.app.C16025a;

/* renamed from: com.tencent.mm.plugin.aa.a.c.d */
public final class C37994d extends C16025a {
    C38004l gmG = new C38004l();
    C32895e gmH = new C32895e();

    public C37994d() {
        AppMethodBeat.m2504i(40684);
        AppMethodBeat.m2505o(40684);
    }

    public final void onCreate() {
        AppMethodBeat.m2504i(40685);
        super.onCreate();
        C4990ab.m7416i("MicroMsg.LaunchAAInteractor", "LaunchAAInteractor, onCreate");
        C1202f aop = this.gmG.aop();
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(1624, aop);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(1655, aop);
        aop = this.gmH.aok();
        C4990ab.m7416i("MicroMsg.AAOperationData", "init");
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(1698, aop);
        AppMethodBeat.m2505o(40685);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(40686);
        super.onDestroy();
        C4990ab.m7416i("MicroMsg.LaunchAAInteractor", "LaunchAAInteractor, onDestroy");
        C1202f aop = this.gmG.aop();
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(1624, aop);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(1655, aop);
        aop = this.gmH.aok();
        C4990ab.m7416i("MicroMsg.AAOperationData", "uninit");
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(1698, aop);
        AppMethodBeat.m2505o(40686);
    }
}
