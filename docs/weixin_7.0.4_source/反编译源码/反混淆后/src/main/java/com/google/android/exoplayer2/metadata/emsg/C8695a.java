package com.google.android.exoplayer2.metadata.emsg;

import com.google.android.exoplayer2.metadata.C17679a;
import com.google.android.exoplayer2.metadata.C36689d;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.metadata.emsg.a */
public final class C8695a implements C17679a {
    /* renamed from: a */
    public final Metadata mo19234a(C36689d c36689d) {
        AppMethodBeat.m2504i(95273);
        ByteBuffer byteBuffer = c36689d.aEY;
        C32065l c32065l = new C32065l(byteBuffer.array(), byteBuffer.limit());
        String tL = c32065l.mo52392tL();
        String tL2 = c32065l.mo52392tL();
        long cM = c32065l.mo52366cM();
        c32065l.mo52369eM(4);
        Metadata metadata = new Metadata(new EventMessage(tL, tL2, (c32065l.mo52366cM() * 1000) / cM, c32065l.mo52366cM(), Arrays.copyOfRange(r1, c32065l.position, r0)));
        AppMethodBeat.m2505o(95273);
        return metadata;
    }
}
