package com.tencent.p177mm.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C17865a.C17866a;
import com.tencent.p177mm.api.C25784s;
import com.tencent.p177mm.api.C45153o;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1671c;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p843bx.C41911a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.MMPhotoEditPlugin */
public class MMPhotoEditPlugin extends C7597f implements C1671c {
    public void installed() {
    }

    public void configure(C1681g c1681g) {
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(116300);
        C25784s.ccQ = new C17866a();
        AppMethodBeat.m2505o(116300);
    }

    public void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(116301);
        C1202f c1202f = C41911a.xuc;
        C4990ab.m7416i("MicroMsg.MediaSecurityReport", "init");
        C1720g.m3540Rg().mo14539a(110, c1202f);
        C1720g.m3540Rg().mo14539a(149, c1202f);
        C1720g.m3542a(C45153o.class, C41911a.xuc);
        AppMethodBeat.m2505o(116301);
    }

    public void onAccountRelease() {
        AppMethodBeat.m2504i(116302);
        C1720g.m3529L(C45153o.class);
        C1202f c1202f = C41911a.xuc;
        C4990ab.m7416i("MicroMsg.MediaSecurityReport", "release");
        C1720g.m3540Rg().mo14546b(110, c1202f);
        C1720g.m3540Rg().mo14546b(149, c1202f);
        c1202f.xud.clear();
        AppMethodBeat.m2505o(116302);
    }
}
