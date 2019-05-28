package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

public final class m implements e {
    private int audioSampleRate;
    private float bSi;
    private int bitrate;
    private int eTa;
    private int eWK;
    private boolean fdh;
    private String owG;

    public m(int i, String str, float f, int i2, int i3, int i4, boolean z) {
        AppMethodBeat.i(76627);
        this.eTa = i;
        this.owG = str;
        this.bSi = f;
        this.bitrate = i2;
        this.eWK = i3;
        this.audioSampleRate = i4;
        this.fdh = z;
        ab.d("MicroMsg.MMSightMP4Muxer", "create MMSightMP4Muxer, bufId: %s, recordPath: %s, fps: %s, bitrate: %s, videoDuration: %s, audioSampleRate%s, mute: %s", Integer.valueOf(i), str, Float.valueOf(f), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z));
        AppMethodBeat.o(76627);
    }

    public final boolean bPO() {
        String str;
        AppMethodBeat.i(76628);
        long yz = bo.yz();
        String WP = d.WP(this.owG);
        try {
            if (!e.ct(WP)) {
                WP = null;
            }
            str = WP;
        } catch (Exception e) {
            str = null;
        }
        ab.i("MicroMsg.MMSightMP4Muxer", "start mux, bufId: %s, aacFile: %s", Integer.valueOf(this.eTa), str);
        ab.i("MicroMsg.MMSightMP4Muxer", "mux sight end, duration %ds, used %sms", Integer.valueOf(SightVideoJNI.muxingLock(this.eTa, str, this.audioSampleRate, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, 1, 0, this.owG, this.bSi, Math.max(1000, this.eWK), this.bitrate, b.qwW, 8, 2, 23.0f, null, 0, false, this.fdh)), Long.valueOf(bo.az(yz)));
        if (!bo.isNullOrNil(str)) {
            try {
                e.deleteFile(str);
            } catch (Exception e2) {
            }
        }
        if (r2 >= 0) {
            AppMethodBeat.o(76628);
            return true;
        }
        AppMethodBeat.o(76628);
        return false;
    }
}
