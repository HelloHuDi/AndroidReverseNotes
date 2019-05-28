package com.google.android.exoplayer2.h;

import com.google.android.exoplayer2.h.r.a;
import com.google.android.exoplayer2.h.r.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ugc.TXRecordCommon;

public final class o extends a {
    private final u<? super f> bpJ;
    private final boolean bqt;
    private final int bqu;
    private final int bqv;
    private final String userAgent;

    public o(String str) {
        this(str, null);
    }

    public o(String str, u<? super f> uVar) {
        this(str, uVar, (byte) 0);
    }

    private o(String str, u<? super f> uVar, byte b) {
        this.userAgent = str;
        this.bpJ = uVar;
        this.bqu = TXRecordCommon.AUDIO_SAMPLERATE_8000;
        this.bqv = TXRecordCommon.AUDIO_SAMPLERATE_8000;
        this.bqt = false;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ r a(f fVar) {
        AppMethodBeat.i(95834);
        n nVar = new n(this.userAgent, this.bpJ, this.bqu, this.bqv, this.bqt, fVar);
        AppMethodBeat.o(95834);
        return nVar;
    }
}
