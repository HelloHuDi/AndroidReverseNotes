package com.google.android.exoplayer2.f.b;

import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.i.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class a extends b {
    private final b bmA;

    public a(List<byte[]> list) {
        super("DvbDecoder");
        AppMethodBeat.i(95622);
        l lVar = new l((byte[]) list.get(0));
        this.bmA = new b(lVar.readUnsignedShort(), lVar.readUnsignedShort());
        AppMethodBeat.o(95622);
    }

    public final /* synthetic */ d c(byte[] bArr, int i, boolean z) {
        AppMethodBeat.i(95623);
        if (z) {
            h hVar = this.bmA.bmJ;
            hVar.bmV.clear();
            hVar.bnn.clear();
            hVar.bno.clear();
            hVar.bnp.clear();
            hVar.bnq.clear();
            hVar.bnr = null;
            hVar.bns = null;
        }
        c cVar = new c(this.bmA.g(bArr, i));
        AppMethodBeat.o(95623);
        return cVar;
    }
}
