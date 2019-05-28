package com.tencent.p177mm.compatible.p219b;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.audiofx.AutomaticGainControl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p219b.C41935h.C26044a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.compatible.b.i */
public final class C41936i implements C26044a {
    private AutomaticGainControl epz = null;

    @TargetApi(16)
    public C41936i(AudioRecord audioRecord) {
        AppMethodBeat.m2504i(92893);
        boolean isAvailable = AutomaticGainControl.isAvailable();
        C4990ab.m7410d("MicroMsg.MMAutomaticGainControl", "available  ".concat(String.valueOf(isAvailable)));
        if (isAvailable) {
            this.epz = AutomaticGainControl.create(audioRecord.getAudioSessionId());
        }
        AppMethodBeat.m2505o(92893);
    }

    @TargetApi(16)
    public final boolean isAvailable() {
        AppMethodBeat.m2504i(92894);
        boolean isAvailable = AutomaticGainControl.isAvailable();
        AppMethodBeat.m2505o(92894);
        return isAvailable;
    }

    @TargetApi(16)
    /* renamed from: KJ */
    public final boolean mo43920KJ() {
        AppMethodBeat.m2504i(92895);
        if (this.epz != null) {
            try {
                int enabled = this.epz.setEnabled(true);
                if (enabled == 0) {
                    AppMethodBeat.m2505o(92895);
                    return true;
                }
                C4990ab.m7410d("MicroMsg.MMAutomaticGainControl", "setEnabled failed ".concat(String.valueOf(enabled)));
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.MMAutomaticGainControl", e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(92895);
        return false;
    }
}
