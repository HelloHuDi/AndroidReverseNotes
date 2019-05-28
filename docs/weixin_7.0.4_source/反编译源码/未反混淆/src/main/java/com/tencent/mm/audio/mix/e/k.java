package com.tencent.mm.audio.mix.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ugc.TXRecordCommon;

public final class k extends f {
    private float A = ((float) (this.cnm / this.cnn));
    private float B = 1.0f;
    private float cnj = 128.0f;
    private float cnk = 128.0f;
    private float cnl = 128.0f;
    private int cnm = TXRecordCommon.AUDIO_SAMPLERATE_44100;
    private int cnn = ((int) ((((0.02f * ((float) this.cnm)) * 2.0f) * 16.0f) / 8.0f));

    public k() {
        AppMethodBeat.i(137129);
        AppMethodBeat.o(137129);
    }

    /* Access modifiers changed, original: protected|final */
    public final byte[] D(int i, int i2, int i3) {
        AppMethodBeat.i(137130);
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = 0;
            for (int i6 = 0; i6 < i; i6++) {
                i5 += this.cmZ[i6][i4];
                if (i5 > this.MAX_VALUE) {
                    this.cnj *= 32768.0f / ((float) i5);
                } else if (i5 < this.MIN_VALUE) {
                    this.cnj *= 32768.0f / ((float) i5);
                }
            }
            if (this.cnj >= this.cnk) {
                this.cnj = ((this.A * (this.cnk + 1.0f)) + (this.B * this.cnj)) / (this.A + this.B);
            } else {
                this.cnj = (this.cnk + this.cnj) / 2.0f;
            }
            this.cnk = this.cnj;
            if ((((int) (this.cnj * 128.0f)) >> 7) != 128) {
                i5 = ((int) (((double) ((this.cnl * this.cnj) / 128.0f)) * ((double) i5))) / 128;
            }
            this.cnc[i4] = gz(i5);
        }
        byte[] bM = bM(i3, i2);
        AppMethodBeat.o(137130);
        return bM;
    }
}
