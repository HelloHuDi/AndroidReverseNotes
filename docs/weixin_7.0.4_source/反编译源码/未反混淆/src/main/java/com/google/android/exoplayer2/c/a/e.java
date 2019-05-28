package com.google.android.exoplayer2.c.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.a.d.a;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e extends d {
    private boolean aTf;
    private final l aTx = new l(j.bqY);
    private final l aTy = new l(4);
    private int aTz;
    private int frameType;

    public e(m mVar) {
        super(mVar);
        AppMethodBeat.i(94878);
        AppMethodBeat.o(94878);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean a(l lVar) {
        AppMethodBeat.i(94879);
        int readUnsignedByte = lVar.readUnsignedByte();
        int i = (readUnsignedByte >> 4) & 15;
        readUnsignedByte &= 15;
        if (readUnsignedByte != 7) {
            a aVar = new a("Video format not supported: ".concat(String.valueOf(readUnsignedByte)));
            AppMethodBeat.o(94879);
            throw aVar;
        }
        this.frameType = i;
        if (i != 5) {
            AppMethodBeat.o(94879);
            return true;
        }
        AppMethodBeat.o(94879);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(l lVar, long j) {
        AppMethodBeat.i(94880);
        int readUnsignedByte = lVar.readUnsignedByte();
        long tD = (((long) lVar.tD()) * 1000) + j;
        if (readUnsignedByte != 0 || this.aTf) {
            if (readUnsignedByte == 1 && this.aTf) {
                int tI;
                byte[] bArr = this.aTy.data;
                bArr[0] = (byte) 0;
                bArr[1] = (byte) 0;
                bArr[2] = (byte) 0;
                readUnsignedByte = 4 - this.aTz;
                int i = 0;
                while (lVar.tB() > 0) {
                    lVar.readBytes(this.aTy.data, readUnsignedByte, this.aTz);
                    this.aTy.setPosition(0);
                    tI = this.aTy.tI();
                    this.aTx.setPosition(0);
                    this.aTw.a(this.aTx, 4);
                    i += 4;
                    this.aTw.a(lVar, tI);
                    i += tI;
                }
                m mVar = this.aTw;
                if (this.frameType == 1) {
                    tI = 1;
                } else {
                    tI = 0;
                }
                mVar.a(tD, tI, i, 0, null);
            }
            AppMethodBeat.o(94880);
            return;
        }
        l lVar2 = new l(new byte[lVar.tB()]);
        lVar.readBytes(lVar2.data, 0, lVar.tB());
        com.google.android.exoplayer2.video.a K = com.google.android.exoplayer2.video.a.K(lVar2);
        this.aTz = K.aTz;
        this.aTw.f(Format.a(null, "video/avc", K.width, K.height, K.aOf, K.brq));
        this.aTf = true;
        AppMethodBeat.o(94880);
    }
}
