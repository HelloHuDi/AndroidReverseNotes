package com.google.android.exoplayer2.c.a;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.i.c;
import com.google.android.exoplayer2.i.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ugc.TXRecordCommon;
import java.util.Collections;

final class a extends d {
    private static final int[] aTd = new int[]{5512, 11025, 22050, TXRecordCommon.AUDIO_SAMPLERATE_44100};
    private boolean aTe;
    private boolean aTf;
    private int aTg;

    public a(m mVar) {
        super(mVar);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean a(l lVar) {
        int i = 2;
        AppMethodBeat.i(94861);
        if (this.aTe) {
            lVar.eM(1);
        } else {
            int readUnsignedByte = lVar.readUnsignedByte();
            this.aTg = (readUnsignedByte >> 4) & 15;
            if (this.aTg == 2) {
                this.aTw.f(Format.a(null, "audio/mpeg", -1, -1, 1, aTd[(readUnsignedByte >> 2) & 3], null, null, null));
                this.aTf = true;
            } else if (this.aTg == 7 || this.aTg == 8) {
                String str = this.aTg == 7 ? "audio/g711-alaw" : "audio/g711-mlaw";
                if ((readUnsignedByte & 1) != 1) {
                    i = 3;
                }
                this.aTw.f(Format.a(null, str, -1, -1, 1, TXRecordCommon.AUDIO_SAMPLERATE_8000, i, null, null, 0, null));
                this.aTf = true;
            } else if (this.aTg != 10) {
                com.google.android.exoplayer2.c.a.d.a aVar = new com.google.android.exoplayer2.c.a.d.a("Audio format not supported: " + this.aTg);
                AppMethodBeat.o(94861);
                throw aVar;
            }
            this.aTe = true;
        }
        AppMethodBeat.o(94861);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(l lVar, long j) {
        AppMethodBeat.i(94862);
        int tB;
        if (this.aTg == 2) {
            tB = lVar.tB();
            this.aTw.a(lVar, tB);
            this.aTw.a(j, 1, tB, 0, null);
            AppMethodBeat.o(94862);
            return;
        }
        int readUnsignedByte = lVar.readUnsignedByte();
        if (readUnsignedByte != 0 || this.aTf) {
            if (this.aTg != 10 || readUnsignedByte == 1) {
                tB = lVar.tB();
                this.aTw.a(lVar, tB);
                this.aTw.a(j, 1, tB, 0, null);
            }
            AppMethodBeat.o(94862);
            return;
        }
        byte[] bArr = new byte[lVar.tB()];
        lVar.readBytes(bArr, 0, bArr.length);
        Pair q = c.q(bArr);
        this.aTw.f(Format.a(null, "audio/mp4a-latm", -1, -1, ((Integer) q.second).intValue(), ((Integer) q.first).intValue(), Collections.singletonList(bArr), null, null));
        this.aTf = true;
        AppMethodBeat.o(94862);
    }
}
