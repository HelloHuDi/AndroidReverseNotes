package com.tencent.mm.audio.c;

import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.e;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.ab;

public final class a {
    public static AudioTrack a(boolean z, int i, int i2, int i3) {
        AudioTrack eVar;
        int i4 = 3;
        AppMethodBeat.i(55761);
        int i5 = z ? 3 : 0;
        if (q.etd.epG) {
            q.etd.dump();
            if (z && q.etd.eqj >= 0) {
                i5 = q.etd.eqj;
            } else if (!z && q.etd.eqk >= 0) {
                i5 = q.etd.eqk;
            }
        }
        int minBufferSize = AudioTrack.getMinBufferSize(i, i2, 2);
        ab.i("AudioDeviceFactory", "speakerOn: %b, type: %d, sampleRate: %d, channelConfig: %d, PlayBufSize: %d, bufTimes: %d", Boolean.valueOf(z), Integer.valueOf(i5), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(minBufferSize), Integer.valueOf(i3));
        AudioTrack eVar2 = new e(i5, i, i2, i3 * minBufferSize);
        if (eVar2.getState() == 0) {
            eVar2.release();
            ab.i("AudioDeviceFactory", "reconstruct AudioTrack");
            if (i5 != 0) {
                i4 = 0;
            }
            eVar = new e(i4, i, i2, i3 * minBufferSize);
        } else {
            eVar = eVar2;
        }
        ab.i("AudioDeviceFactory", "AudioTrack state: " + eVar.getState());
        AppMethodBeat.o(55761);
        return eVar;
    }
}
