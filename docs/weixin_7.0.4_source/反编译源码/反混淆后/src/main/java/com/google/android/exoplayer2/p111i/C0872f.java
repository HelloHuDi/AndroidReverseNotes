package com.google.android.exoplayer2.p111i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19395n;

/* renamed from: com.google.android.exoplayer2.i.f */
public final class C0872f {
    public final int bdU;
    public final int brf;
    public final int brg;
    public final int brh;
    public final int bri;
    public final long brj;
    public final int channels;
    public final int sampleRate;

    public C0872f(byte[] bArr) {
        AppMethodBeat.m2504i(95875);
        C32064k c32064k = new C32064k(bArr);
        c32064k.setPosition(C19395n.CTRL_INDEX);
        this.brf = c32064k.mo52354ed(16);
        this.brg = c32064k.mo52354ed(16);
        this.brh = c32064k.mo52354ed(24);
        this.bri = c32064k.mo52354ed(24);
        this.sampleRate = c32064k.mo52354ed(20);
        this.channels = c32064k.mo52354ed(3) + 1;
        this.bdU = c32064k.mo52354ed(5) + 1;
        this.brj = (((long) c32064k.mo52354ed(32)) & 4294967295L) | ((((long) c32064k.mo52354ed(4)) & 15) << 32);
        AppMethodBeat.m2505o(95875);
    }
}
