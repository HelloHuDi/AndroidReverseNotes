package com.tencent.p177mm.plugin.mmsight.model.p456a;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

@TargetApi(18)
@Deprecated
/* renamed from: com.tencent.mm.plugin.mmsight.model.a.o */
public final class C34545o implements C21291e {
    boolean cFy;
    MediaMuxer owN;
    int owO;
    int owP;
    long owQ;

    public final boolean bPO() {
        return false;
    }

    /* renamed from: d */
    public final void mo55073d(MediaFormat mediaFormat) {
        AppMethodBeat.m2504i(76661);
        try {
            if (this.owN != null && this.owO == -1) {
                this.owO = this.owN.addTrack(mediaFormat);
                C4990ab.m7417i("MicroMsg.MMSightSystemMediaMuxer", "addX264Track, x264TrackIndex: %s", Integer.valueOf(this.owO));
                if (!(this.cFy || this.owO == -1 || this.owP == -1)) {
                    C4990ab.m7416i("MicroMsg.MMSightSystemMediaMuxer", "start!");
                    this.owN.start();
                    this.cFy = true;
                }
            }
            AppMethodBeat.m2505o(76661);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MMSightSystemMediaMuxer", "addX264Track error: %s", e.getMessage());
            AppMethodBeat.m2505o(76661);
        }
    }

    /* renamed from: e */
    public final void mo55074e(MediaFormat mediaFormat) {
        AppMethodBeat.m2504i(76662);
        try {
            if (this.owN != null && this.owP == -1) {
                this.owP = this.owN.addTrack(mediaFormat);
                C4990ab.m7417i("MicroMsg.MMSightSystemMediaMuxer", "addAACTrack, aacTrackIndex: %s", Integer.valueOf(this.owP));
                if (!(this.cFy || this.owP == -1 || this.owO == -1)) {
                    C4990ab.m7416i("MicroMsg.MMSightSystemMediaMuxer", "start!");
                    this.owN.start();
                    this.cFy = true;
                }
            }
            AppMethodBeat.m2505o(76662);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MMSightSystemMediaMuxer", "addAACTrack error: %s", e.getMessage());
            AppMethodBeat.m2505o(76662);
        }
    }
}
