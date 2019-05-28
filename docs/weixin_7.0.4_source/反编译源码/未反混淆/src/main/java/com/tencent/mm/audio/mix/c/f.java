package com.tencent.mm.audio.mix.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.a;
import com.tencent.mm.audio.mix.h.b;

public final class f extends c {
    public f(String str, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8 = 0;
        AppMethodBeat.i(137032);
        b.i("MicroMsg.Mix.AudioVariableConvertProcess", "AudioVariableConvertProcess src:%s, srcSampleRate:%d, srcChannels:%d, srcBitDepth:%d, desSampleRate:%d, desChannels:%d, desBitDepth:%d", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
        this.cle = str;
        this.clf = a.eh(str);
        b.Dq();
        if (i4 <= 0) {
            i7 = 0;
        } else {
            i7 = 1;
        }
        if (i7 != 0) {
            this.ckY = i4;
        }
        if (i5 <= 0) {
            i7 = 0;
        } else {
            i7 = 1;
        }
        if (i7 != 0) {
            this.ckZ = i5;
        }
        if (i4 > 0) {
            i8 = 1;
        }
        if (i8 != 0) {
            this.cla = i6;
        }
        C(i, i2, i3);
        AppMethodBeat.o(137032);
    }
}
