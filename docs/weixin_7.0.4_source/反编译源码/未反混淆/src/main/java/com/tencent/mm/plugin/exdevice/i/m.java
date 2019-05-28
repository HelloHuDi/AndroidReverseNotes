package com.tencent.mm.plugin.exdevice.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.service.l;
import com.tencent.mm.plugin.exdevice.service.o;
import com.tencent.mm.plugin.exdevice.service.p.a;
import junit.framework.Assert;

public final class m extends a {
    private n lxQ = null;
    l lxR = null;

    public m(c cVar, c cVar2) {
        AppMethodBeat.i(19751);
        Assert.assertNotNull(cVar);
        Assert.assertNotNull(cVar2);
        this.lxQ = new n(cVar);
        this.lxR = new l(cVar2);
        AppMethodBeat.o(19751);
    }

    public final o bpu() {
        AppMethodBeat.i(19752);
        Assert.assertNotNull(this.lxQ);
        n nVar = this.lxQ;
        AppMethodBeat.o(19752);
        return nVar;
    }

    public final l bpv() {
        AppMethodBeat.i(19753);
        Assert.assertNotNull(this.lxR);
        l lVar = this.lxR;
        AppMethodBeat.o(19753);
        return lVar;
    }
}
