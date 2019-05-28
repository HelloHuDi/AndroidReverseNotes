package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.audiofx.AcousticEchoCanceler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.h.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class f implements a {
    private AcousticEchoCanceler eoW = null;

    @TargetApi(16)
    public f(AudioRecord audioRecord) {
        AppMethodBeat.i(92838);
        boolean isAvailable = AcousticEchoCanceler.isAvailable();
        ab.d("MicroMsg.MMAcousticEchoCanceler", "available  ".concat(String.valueOf(isAvailable)));
        if (isAvailable) {
            this.eoW = AcousticEchoCanceler.create(audioRecord.getAudioSessionId());
        }
        AppMethodBeat.o(92838);
    }

    @TargetApi(16)
    public final boolean isAvailable() {
        AppMethodBeat.i(92839);
        boolean isAvailable = AcousticEchoCanceler.isAvailable();
        AppMethodBeat.o(92839);
        return isAvailable;
    }

    @TargetApi(16)
    public final boolean KJ() {
        AppMethodBeat.i(92840);
        if (this.eoW != null) {
            try {
                int enabled = this.eoW.setEnabled(true);
                if (enabled == 0) {
                    AppMethodBeat.o(92840);
                    return true;
                }
                ab.d("MicroMsg.MMAcousticEchoCanceler", "setEnabled failed ".concat(String.valueOf(enabled)));
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.MMAcousticEchoCanceler", e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(92840);
        return false;
    }
}
