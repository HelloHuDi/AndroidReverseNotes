package com.google.android.exoplayer2.p105f.p106b;

import com.google.android.exoplayer2.p105f.C17659d;
import com.google.android.exoplayer2.p105f.C8672b;
import com.google.android.exoplayer2.p105f.p106b.C41602b.C37251h;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.f.b.a */
public final class C17657a extends C8672b {
    private final C41602b bmA;

    public C17657a(List<byte[]> list) {
        super("DvbDecoder");
        AppMethodBeat.m2504i(95622);
        C32065l c32065l = new C32065l((byte[]) list.get(0));
        this.bmA = new C41602b(c32065l.readUnsignedShort(), c32065l.readUnsignedShort());
        AppMethodBeat.m2505o(95622);
    }

    /* renamed from: c */
    public final /* synthetic */ C17659d mo2574c(byte[] bArr, int i, boolean z) {
        AppMethodBeat.m2504i(95623);
        if (z) {
            C37251h c37251h = this.bmA.bmJ;
            c37251h.bmV.clear();
            c37251h.bnn.clear();
            c37251h.bno.clear();
            c37251h.bnp.clear();
            c37251h.bnq.clear();
            c37251h.bnr = null;
            c37251h.bns = null;
        }
        C41603c c41603c = new C41603c(this.bmA.mo66736g(bArr, i));
        AppMethodBeat.m2505o(95623);
        return c41603c;
    }
}
