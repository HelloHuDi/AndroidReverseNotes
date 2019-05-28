package com.tencent.mm.plugin.exdevice.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.service.o.a;
import com.tencent.mm.sdk.platformtools.ab;
import junit.framework.Assert;

public final class n extends a {
    private c lxu = null;

    public n(c cVar) {
        AppMethodBeat.i(19754);
        Assert.assertNotNull(cVar);
        this.lxu = cVar;
        AppMethodBeat.o(19754);
    }

    public final long bpp() {
        AppMethodBeat.i(19755);
        ab.i("MicroMsg.exdevice.RemoteExDeviceTaskRequest", "getDeviceId : " + this.lxu.jJa);
        long j = this.lxu.jJa;
        AppMethodBeat.o(19755);
        return j;
    }

    public final byte[] bpq() {
        AppMethodBeat.i(19756);
        byte[] bot = this.lxu.bot();
        AppMethodBeat.o(19756);
        return bot;
    }

    public final int bpr() {
        AppMethodBeat.i(19757);
        short bor = this.lxu.bor();
        AppMethodBeat.o(19757);
        return bor;
    }

    public final int bps() {
        return this.lxu.lqB;
    }

    public final int bpt() {
        AppMethodBeat.i(19758);
        short bos = this.lxu.bos();
        AppMethodBeat.o(19758);
        return bos;
    }
}
