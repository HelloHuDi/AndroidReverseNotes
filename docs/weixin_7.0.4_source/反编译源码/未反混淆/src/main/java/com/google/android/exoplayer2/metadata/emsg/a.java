package com.google.android.exoplayer2.metadata.emsg;

import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class a implements com.google.android.exoplayer2.metadata.a {
    public final Metadata a(d dVar) {
        AppMethodBeat.i(95273);
        ByteBuffer byteBuffer = dVar.aEY;
        l lVar = new l(byteBuffer.array(), byteBuffer.limit());
        String tL = lVar.tL();
        String tL2 = lVar.tL();
        long cM = lVar.cM();
        lVar.eM(4);
        Metadata metadata = new Metadata(new EventMessage(tL, tL2, (lVar.cM() * 1000) / cM, lVar.cM(), Arrays.copyOfRange(r1, lVar.position, r0)));
        AppMethodBeat.o(95273);
        return metadata;
    }
}
