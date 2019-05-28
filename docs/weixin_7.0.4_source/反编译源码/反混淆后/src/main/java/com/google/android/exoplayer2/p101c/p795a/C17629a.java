package com.google.android.exoplayer2.p101c.p795a;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p101c.C32041m;
import com.google.android.exoplayer2.p101c.p795a.C41592d.C8644a;
import com.google.android.exoplayer2.p111i.C32062c;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ugc.TXRecordCommon;
import java.util.Collections;

/* renamed from: com.google.android.exoplayer2.c.a.a */
final class C17629a extends C41592d {
    private static final int[] aTd = new int[]{5512, 11025, 22050, TXRecordCommon.AUDIO_SAMPLERATE_44100};
    private boolean aTe;
    private boolean aTf;
    private int aTg;

    public C17629a(C32041m c32041m) {
        super(c32041m);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final boolean mo32314a(C32065l c32065l) {
        int i = 2;
        AppMethodBeat.m2504i(94861);
        if (this.aTe) {
            c32065l.mo52369eM(1);
        } else {
            int readUnsignedByte = c32065l.readUnsignedByte();
            this.aTg = (readUnsignedByte >> 4) & 15;
            if (this.aTg == 2) {
                this.aTw.mo42836f(Format.m15271a(null, "audio/mpeg", -1, -1, 1, aTd[(readUnsignedByte >> 2) & 3], null, null, null));
                this.aTf = true;
            } else if (this.aTg == 7 || this.aTg == 8) {
                String str = this.aTg == 7 ? "audio/g711-alaw" : "audio/g711-mlaw";
                if ((readUnsignedByte & 1) != 1) {
                    i = 3;
                }
                this.aTw.mo42836f(Format.m15270a(null, str, -1, -1, 1, TXRecordCommon.AUDIO_SAMPLERATE_8000, i, null, null, 0, null));
                this.aTf = true;
            } else if (this.aTg != 10) {
                C8644a c8644a = new C8644a("Audio format not supported: " + this.aTg);
                AppMethodBeat.m2505o(94861);
                throw c8644a;
            }
            this.aTe = true;
        }
        AppMethodBeat.m2505o(94861);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo32313a(C32065l c32065l, long j) {
        AppMethodBeat.m2504i(94862);
        int tB;
        if (this.aTg == 2) {
            tB = c32065l.mo52382tB();
            this.aTw.mo42835a(c32065l, tB);
            this.aTw.mo42834a(j, 1, tB, 0, null);
            AppMethodBeat.m2505o(94862);
            return;
        }
        int readUnsignedByte = c32065l.readUnsignedByte();
        if (readUnsignedByte != 0 || this.aTf) {
            if (this.aTg != 10 || readUnsignedByte == 1) {
                tB = c32065l.mo52382tB();
                this.aTw.mo42835a(c32065l, tB);
                this.aTw.mo42834a(j, 1, tB, 0, null);
            }
            AppMethodBeat.m2505o(94862);
            return;
        }
        byte[] bArr = new byte[c32065l.mo52382tB()];
        c32065l.readBytes(bArr, 0, bArr.length);
        Pair q = C32062c.m52121q(bArr);
        this.aTw.mo42836f(Format.m15271a(null, "audio/mp4a-latm", -1, -1, ((Integer) q.second).intValue(), ((Integer) q.first).intValue(), Collections.singletonList(bArr), null, null));
        this.aTf = true;
        AppMethodBeat.m2505o(94862);
    }
}
