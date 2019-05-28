package com.tencent.p177mm.compatible.p219b;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.audiofx.NoiseSuppressor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p219b.C41935h.C26044a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.compatible.b.j */
public final class C41937j implements C26044a {
    private NoiseSuppressor epA = null;

    @TargetApi(16)
    public C41937j(AudioRecord audioRecord) {
        AppMethodBeat.m2504i(92896);
        boolean isAvailable = NoiseSuppressor.isAvailable();
        C4990ab.m7410d("MicroMsg.MMNoiseSuppressor", "available  ".concat(String.valueOf(isAvailable)));
        if (isAvailable) {
            this.epA = NoiseSuppressor.create(audioRecord.getAudioSessionId());
        }
        AppMethodBeat.m2505o(92896);
    }

    @TargetApi(16)
    public final boolean isAvailable() {
        AppMethodBeat.m2504i(92897);
        boolean isAvailable = NoiseSuppressor.isAvailable();
        AppMethodBeat.m2505o(92897);
        return isAvailable;
    }

    @TargetApi(16)
    /* renamed from: KJ */
    public final boolean mo43920KJ() {
        AppMethodBeat.m2504i(92898);
        if (this.epA != null) {
            try {
                int enabled = this.epA.setEnabled(true);
                if (enabled == 0) {
                    AppMethodBeat.m2505o(92898);
                    return true;
                }
                C4990ab.m7410d("MicroMsg.MMNoiseSuppressor", "setEnabled failed ".concat(String.valueOf(enabled)));
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.MMNoiseSuppressor", e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(92898);
        return false;
    }
}
