package com.tencent.p177mm.plugin.voip_cs.p747c;

import android.hardware.Camera.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.voip.video.C46326a;
import com.tencent.p177mm.plugin.voip_cs.p547b.C43749c;
import com.tencent.p177mm.plugin.voip_cs.p547b.C43750d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.voip_cs.c.a */
public final class C46929a extends C46326a {
    public C46929a(int i, int i2) {
        super(i, i2);
    }

    public final void cMB() {
        AppMethodBeat.m2504i(135436);
        try {
            if (this.sZv != null) {
                int i;
                Size previewSize = this.sZv.getPreviewSize();
                C43750d cMg = C43749c.cMg();
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
                C4990ab.m7410d("MicroMsg.VoipCSReportHelper", "setCameraInfo");
                cMg.tcW = i;
                cMg.tcS = i2;
                cMg.tcT = i3;
                cMg.tcU = i4;
                cMg.tcV = i5;
            }
            AppMethodBeat.m2505o(135436);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.CSCaptureRender", "getCameraDataForVoipCS failed" + e.getMessage());
            AppMethodBeat.m2505o(135436);
        }
    }
}
