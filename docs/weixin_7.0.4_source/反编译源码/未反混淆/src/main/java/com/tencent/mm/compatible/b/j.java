package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.audiofx.NoiseSuppressor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.h.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class j implements a {
    private NoiseSuppressor epA = null;

    @TargetApi(16)
    public j(AudioRecord audioRecord) {
        AppMethodBeat.i(92896);
        boolean isAvailable = NoiseSuppressor.isAvailable();
        ab.d("MicroMsg.MMNoiseSuppressor", "available  ".concat(String.valueOf(isAvailable)));
        if (isAvailable) {
            this.epA = NoiseSuppressor.create(audioRecord.getAudioSessionId());
        }
        AppMethodBeat.o(92896);
    }

    @TargetApi(16)
    public final boolean isAvailable() {
        AppMethodBeat.i(92897);
        boolean isAvailable = NoiseSuppressor.isAvailable();
        AppMethodBeat.o(92897);
        return isAvailable;
    }

    @TargetApi(16)
    public final boolean KJ() {
        AppMethodBeat.i(92898);
        if (this.epA != null) {
            try {
                int enabled = this.epA.setEnabled(true);
                if (enabled == 0) {
                    AppMethodBeat.o(92898);
                    return true;
                }
                ab.d("MicroMsg.MMNoiseSuppressor", "setEnabled failed ".concat(String.valueOf(enabled)));
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.MMNoiseSuppressor", e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(92898);
        return false;
    }
}
