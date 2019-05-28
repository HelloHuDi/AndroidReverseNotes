package com.tencent.p177mm.compatible.p219b;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.audiofx.AcousticEchoCanceler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p219b.C41935h.C26044a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.compatible.b.f */
public final class C31266f implements C26044a {
    private AcousticEchoCanceler eoW = null;

    @TargetApi(16)
    public C31266f(AudioRecord audioRecord) {
        AppMethodBeat.m2504i(92838);
        boolean isAvailable = AcousticEchoCanceler.isAvailable();
        C4990ab.m7410d("MicroMsg.MMAcousticEchoCanceler", "available  ".concat(String.valueOf(isAvailable)));
        if (isAvailable) {
            this.eoW = AcousticEchoCanceler.create(audioRecord.getAudioSessionId());
        }
        AppMethodBeat.m2505o(92838);
    }

    @TargetApi(16)
    public final boolean isAvailable() {
        AppMethodBeat.m2504i(92839);
        boolean isAvailable = AcousticEchoCanceler.isAvailable();
        AppMethodBeat.m2505o(92839);
        return isAvailable;
    }

    @TargetApi(16)
    /* renamed from: KJ */
    public final boolean mo43920KJ() {
        AppMethodBeat.m2504i(92840);
        if (this.eoW != null) {
            try {
                int enabled = this.eoW.setEnabled(true);
                if (enabled == 0) {
                    AppMethodBeat.m2505o(92840);
                    return true;
                }
                C4990ab.m7410d("MicroMsg.MMAcousticEchoCanceler", "setEnabled failed ".concat(String.valueOf(enabled)));
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.MMAcousticEchoCanceler", e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(92840);
        return false;
    }
}
