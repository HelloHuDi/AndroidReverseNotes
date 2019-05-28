package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.audiofx.AutomaticGainControl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.h.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class i implements a {
    private AutomaticGainControl epz = null;

    @TargetApi(16)
    public i(AudioRecord audioRecord) {
        AppMethodBeat.i(92893);
        boolean isAvailable = AutomaticGainControl.isAvailable();
        ab.d("MicroMsg.MMAutomaticGainControl", "available  ".concat(String.valueOf(isAvailable)));
        if (isAvailable) {
            this.epz = AutomaticGainControl.create(audioRecord.getAudioSessionId());
        }
        AppMethodBeat.o(92893);
    }

    @TargetApi(16)
    public final boolean isAvailable() {
        AppMethodBeat.i(92894);
        boolean isAvailable = AutomaticGainControl.isAvailable();
        AppMethodBeat.o(92894);
        return isAvailable;
    }

    @TargetApi(16)
    public final boolean KJ() {
        AppMethodBeat.i(92895);
        if (this.epz != null) {
            try {
                int enabled = this.epz.setEnabled(true);
                if (enabled == 0) {
                    AppMethodBeat.o(92895);
                    return true;
                }
                ab.d("MicroMsg.MMAutomaticGainControl", "setEnabled failed ".concat(String.valueOf(enabled)));
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.MMAutomaticGainControl", e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(92895);
        return false;
    }
}
