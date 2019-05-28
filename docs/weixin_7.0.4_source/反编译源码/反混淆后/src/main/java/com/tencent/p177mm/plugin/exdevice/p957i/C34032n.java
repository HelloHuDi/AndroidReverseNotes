package com.tencent.p177mm.plugin.exdevice.p957i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.exdevice.p952b.C27828c;
import com.tencent.p177mm.plugin.exdevice.service.C27866o.C27867a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.exdevice.i.n */
public final class C34032n extends C27867a {
    private C27828c lxu = null;

    public C34032n(C27828c c27828c) {
        AppMethodBeat.m2504i(19754);
        Assert.assertNotNull(c27828c);
        this.lxu = c27828c;
        AppMethodBeat.m2505o(19754);
    }

    public final long bpp() {
        AppMethodBeat.m2504i(19755);
        C4990ab.m7416i("MicroMsg.exdevice.RemoteExDeviceTaskRequest", "getDeviceId : " + this.lxu.jJa);
        long j = this.lxu.jJa;
        AppMethodBeat.m2505o(19755);
        return j;
    }

    public final byte[] bpq() {
        AppMethodBeat.m2504i(19756);
        byte[] bot = this.lxu.bot();
        AppMethodBeat.m2505o(19756);
        return bot;
    }

    public final int bpr() {
        AppMethodBeat.m2504i(19757);
        short bor = this.lxu.bor();
        AppMethodBeat.m2505o(19757);
        return bor;
    }

    public final int bps() {
        return this.lxu.lqB;
    }

    public final int bpt() {
        AppMethodBeat.m2504i(19758);
        short bos = this.lxu.bos();
        AppMethodBeat.m2505o(19758);
        return bos;
    }
}
