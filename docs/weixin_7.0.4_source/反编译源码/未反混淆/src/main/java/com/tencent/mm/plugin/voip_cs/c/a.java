package com.tencent.mm.plugin.voip_cs.c;

import android.hardware.Camera.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip_cs.b.c;
import com.tencent.mm.plugin.voip_cs.b.d;
import com.tencent.mm.sdk.platformtools.ab;

public final class a extends com.tencent.mm.plugin.voip.video.a {
    public a(int i, int i2) {
        super(i, i2);
    }

    public final void cMB() {
        AppMethodBeat.i(135436);
        try {
            if (this.sZv != null) {
                int i;
                Size previewSize = this.sZv.getPreviewSize();
                d cMg = c.cMg();
                if (this.sZy) {
                    i = 1;
                } else {
                    i = 0;
                }
                this.sZv.getPreviewFrameRate();
                int i2 = this.sZL;
                int i3 = this.sZM;
                int i4 = previewSize.width;
                int i5 = previewSize.height;
                ab.d("MicroMsg.VoipCSReportHelper", "setCameraInfo");
                cMg.tcW = i;
                cMg.tcS = i2;
                cMg.tcT = i3;
                cMg.tcU = i4;
                cMg.tcV = i5;
            }
            AppMethodBeat.o(135436);
        } catch (Exception e) {
            ab.e("MicroMsg.CSCaptureRender", "getCameraDataForVoipCS failed" + e.getMessage());
            AppMethodBeat.o(135436);
        }
    }
}
