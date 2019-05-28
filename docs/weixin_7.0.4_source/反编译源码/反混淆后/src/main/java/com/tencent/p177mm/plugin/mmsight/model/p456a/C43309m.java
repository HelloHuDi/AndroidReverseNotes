package com.tencent.p177mm.plugin.mmsight.model.p456a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sight.base.C29014b;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.mmsight.model.a.m */
public final class C43309m implements C21291e {
    private int audioSampleRate;
    private float bSi;
    private int bitrate;
    private int eTa;
    private int eWK;
    private boolean fdh;
    private String owG;

    public C43309m(int i, String str, float f, int i2, int i3, int i4, boolean z) {
        AppMethodBeat.m2504i(76627);
        this.eTa = i;
        this.owG = str;
        this.bSi = f;
        this.bitrate = i2;
        this.eWK = i3;
        this.audioSampleRate = i4;
        this.fdh = z;
        C4990ab.m7411d("MicroMsg.MMSightMP4Muxer", "create MMSightMP4Muxer, bufId: %s, recordPath: %s, fps: %s, bitrate: %s, videoDuration: %s, audioSampleRate%s, mute: %s", Integer.valueOf(i), str, Float.valueOf(f), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z));
        AppMethodBeat.m2505o(76627);
    }

    public final boolean bPO() {
        String str;
        AppMethodBeat.m2504i(76628);
        long yz = C5046bo.m7588yz();
        String WP = C21846d.m33386WP(this.owG);
        try {
            if (!C5730e.m8628ct(WP)) {
                WP = null;
            }
            str = WP;
        } catch (Exception e) {
            str = null;
        }
        C4990ab.m7417i("MicroMsg.MMSightMP4Muxer", "start mux, bufId: %s, aacFile: %s", Integer.valueOf(this.eTa), str);
        C4990ab.m7417i("MicroMsg.MMSightMP4Muxer", "mux sight end, duration %ds, used %sms", Integer.valueOf(SightVideoJNI.muxingLock(this.eTa, str, this.audioSampleRate, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, 1, 0, this.owG, this.bSi, Math.max(1000, this.eWK), this.bitrate, C29014b.qwW, 8, 2, 23.0f, null, 0, false, this.fdh)), Long.valueOf(C5046bo.m7525az(yz)));
        if (!C5046bo.isNullOrNil(str)) {
            try {
                C5730e.deleteFile(str);
            } catch (Exception e2) {
            }
        }
        if (r2 >= 0) {
            AppMethodBeat.m2505o(76628);
            return true;
        }
        AppMethodBeat.m2505o(76628);
        return false;
    }
}
