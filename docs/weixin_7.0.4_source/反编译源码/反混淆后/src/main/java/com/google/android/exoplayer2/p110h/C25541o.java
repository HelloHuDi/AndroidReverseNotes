package com.google.android.exoplayer2.p110h;

import com.google.android.exoplayer2.p110h.C17668r.C17672f;
import com.google.android.exoplayer2.p110h.C17668r.C8681a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ugc.TXRecordCommon;

/* renamed from: com.google.android.exoplayer2.h.o */
public final class C25541o extends C8681a {
    private final C41615u<? super C0867f> bpJ;
    private final boolean bqt;
    private final int bqu;
    private final int bqv;
    private final String userAgent;

    public C25541o(String str) {
        this(str, null);
    }

    public C25541o(String str, C41615u<? super C0867f> c41615u) {
        this(str, c41615u, (byte) 0);
    }

    private C25541o(String str, C41615u<? super C0867f> c41615u, byte b) {
        this.userAgent = str;
        this.bpJ = c41615u;
        this.bqu = TXRecordCommon.AUDIO_SAMPLERATE_8000;
        this.bqv = TXRecordCommon.AUDIO_SAMPLERATE_8000;
        this.bqt = false;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ C17668r mo19211a(C17672f c17672f) {
        AppMethodBeat.m2504i(95834);
        C24652n c24652n = new C24652n(this.userAgent, this.bpJ, this.bqu, this.bqv, this.bqt, c17672f);
        AppMethodBeat.m2505o(95834);
        return c24652n;
    }
}
