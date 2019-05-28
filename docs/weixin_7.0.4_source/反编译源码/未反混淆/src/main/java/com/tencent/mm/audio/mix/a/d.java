package com.tencent.mm.audio.mix.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ugc.TXRecordCommon;
import java.util.Arrays;

public final class d {
    public int channels = 2;
    public String ckD;
    public long ckG = 0;
    public boolean ckH = false;
    public int cku = 2;
    public byte[] ckv;
    public int sampleRate = TXRecordCommon.AUDIO_SAMPLERATE_44100;

    public final void reset() {
        AppMethodBeat.i(136978);
        this.sampleRate = TXRecordCommon.AUDIO_SAMPLERATE_44100;
        this.channels = TXRecordCommon.AUDIO_SAMPLERATE_44100;
        this.cku = 2;
        this.ckD = "";
        this.ckG = 0;
        if (this.ckv != null) {
            Arrays.fill(this.ckv, 0, this.ckv.length, (byte) 0);
        }
        AppMethodBeat.o(136978);
    }
}
