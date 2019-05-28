package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g.n;

public final class f {
    public final int bdU;
    public final int brf;
    public final int brg;
    public final int brh;
    public final int bri;
    public final long brj;
    public final int channels;
    public final int sampleRate;

    public f(byte[] bArr) {
        AppMethodBeat.i(95875);
        k kVar = new k(bArr);
        kVar.setPosition(n.CTRL_INDEX);
        this.brf = kVar.ed(16);
        this.brg = kVar.ed(16);
        this.brh = kVar.ed(24);
        this.bri = kVar.ed(24);
        this.sampleRate = kVar.ed(20);
        this.channels = kVar.ed(3) + 1;
        this.bdU = kVar.ed(5) + 1;
        this.brj = (((long) kVar.ed(32)) & 4294967295L) | ((((long) kVar.ed(4)) & 15) << 32);
        AppMethodBeat.o(95875);
    }
}
