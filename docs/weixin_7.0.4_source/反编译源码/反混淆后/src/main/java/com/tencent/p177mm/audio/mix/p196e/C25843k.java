package com.tencent.p177mm.audio.mix.p196e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ugc.TXRecordCommon;

/* renamed from: com.tencent.mm.audio.mix.e.k */
public final class C25843k extends C45169f {
    /* renamed from: A */
    private float f13657A = ((float) (this.cnm / this.cnn));
    /* renamed from: B */
    private float f13658B = 1.0f;
    private float cnj = 128.0f;
    private float cnk = 128.0f;
    private float cnl = 128.0f;
    private int cnm = TXRecordCommon.AUDIO_SAMPLERATE_44100;
    private int cnn = ((int) ((((0.02f * ((float) this.cnm)) * 2.0f) * 16.0f) / 8.0f));

    public C25843k() {
        AppMethodBeat.m2504i(137129);
        AppMethodBeat.m2505o(137129);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: D */
    public final byte[] mo4603D(int i, int i2, int i3) {
        AppMethodBeat.m2504i(137130);
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
                this.cnj = ((this.f13657A * (this.cnk + 1.0f)) + (this.f13658B * this.cnj)) / (this.f13657A + this.f13658B);
            } else {
                this.cnj = (this.cnk + this.cnj) / 2.0f;
            }
            this.cnk = this.cnj;
            if ((((int) (this.cnj * 128.0f)) >> 7) != 128) {
                i5 = ((int) (((double) ((this.cnl * this.cnj) / 128.0f)) * ((double) i5))) / 128;
            }
            this.cnc[i4] = mo73138gz(i5);
        }
        byte[] bM = mo73137bM(i3, i2);
        AppMethodBeat.m2505o(137130);
        return bM;
    }
}
