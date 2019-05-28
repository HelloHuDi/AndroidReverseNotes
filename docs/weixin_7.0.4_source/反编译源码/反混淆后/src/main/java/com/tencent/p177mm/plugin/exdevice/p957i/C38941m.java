package com.tencent.p177mm.plugin.exdevice.p957i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.exdevice.p952b.C27828c;
import com.tencent.p177mm.plugin.exdevice.service.C11661p.C11662a;
import com.tencent.p177mm.plugin.exdevice.service.C27863l;
import com.tencent.p177mm.plugin.exdevice.service.C27866o;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.exdevice.i.m */
public final class C38941m extends C11662a {
    private C34032n lxQ = null;
    C45887l lxR = null;

    public C38941m(C27828c c27828c, C45884c c45884c) {
        AppMethodBeat.m2504i(19751);
        Assert.assertNotNull(c27828c);
        Assert.assertNotNull(c45884c);
        this.lxQ = new C34032n(c27828c);
        this.lxR = new C45887l(c45884c);
        AppMethodBeat.m2505o(19751);
    }

    public final C27866o bpu() {
        AppMethodBeat.m2504i(19752);
        Assert.assertNotNull(this.lxQ);
        C34032n c34032n = this.lxQ;
        AppMethodBeat.m2505o(19752);
        return c34032n;
    }

    public final C27863l bpv() {
        AppMethodBeat.m2504i(19753);
        Assert.assertNotNull(this.lxR);
        C45887l c45887l = this.lxR;
        AppMethodBeat.m2505o(19753);
        return c45887l;
    }
}
