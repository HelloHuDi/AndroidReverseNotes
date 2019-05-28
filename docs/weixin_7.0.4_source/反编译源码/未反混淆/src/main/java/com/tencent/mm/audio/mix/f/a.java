package com.tencent.mm.audio.mix.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.ugc.TXRecordCommon;

public final class a {
    public static boolean E(int i, int i2, int i3) {
        AppMethodBeat.i(137135);
        if (!gA(i)) {
            AppMethodBeat.o(137135);
            return false;
        } else if (!gB(i2)) {
            AppMethodBeat.o(137135);
            return false;
        } else if (gC(i3)) {
            AppMethodBeat.o(137135);
            return true;
        } else {
            AppMethodBeat.o(137135);
            return false;
        }
    }

    private static boolean gA(int i) {
        AppMethodBeat.i(137136);
        if (i <= 0) {
            b.e("MicroMsg.Mix.AudioMixConfig", "sampleRate is illegal! %d", Integer.valueOf(i));
            AppMethodBeat.o(137136);
            return false;
        } else if (i == TXRecordCommon.AUDIO_SAMPLERATE_44100) {
            AppMethodBeat.o(137136);
            return true;
        } else {
            AppMethodBeat.o(137136);
            return false;
        }
    }

    private static boolean gB(int i) {
        AppMethodBeat.i(137137);
        if (i <= 0) {
            b.e("MicroMsg.Mix.AudioMixConfig", "channels is illegal, %d", Integer.valueOf(i));
            AppMethodBeat.o(137137);
            return false;
        } else if (i == 2) {
            AppMethodBeat.o(137137);
            return true;
        } else {
            AppMethodBeat.o(137137);
            return false;
        }
    }

    private static boolean gC(int i) {
        AppMethodBeat.i(137138);
        if (i <= 0) {
            b.e("MicroMsg.Mix.AudioMixConfig", "encode is illegal, %d", Integer.valueOf(i));
        }
        if (i == 2) {
            AppMethodBeat.o(137138);
            return true;
        }
        AppMethodBeat.o(137138);
        return false;
    }
}
