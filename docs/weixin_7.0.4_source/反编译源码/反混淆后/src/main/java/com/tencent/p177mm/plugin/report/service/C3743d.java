package com.tencent.p177mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.tencent.mm.plugin.report.service.d */
public final class C3743d {
    public String cvZ;
    public long pXP;
    public long pXQ;
    public String pXR;
    public boolean pXS;
    public String value;

    public C3743d(long j, String str, long j2, boolean z) {
        AppMethodBeat.m2504i(72719);
        this.pXP = j;
        this.value = str;
        this.pXQ = j2;
        this.pXS = z;
        this.pXR = new SimpleDateFormat("[yy-MM-dd HH:mm:ss:SSS]").format(new Date(j2));
        AppMethodBeat.m2505o(72719);
    }

    public final String toString() {
        AppMethodBeat.m2504i(72720);
        String str = this.pXR + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + this.value;
        AppMethodBeat.m2505o(72720);
        return str;
    }
}
