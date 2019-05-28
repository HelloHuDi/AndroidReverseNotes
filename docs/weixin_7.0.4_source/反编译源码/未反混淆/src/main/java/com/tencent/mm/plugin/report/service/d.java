package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class d {
    public String cvZ;
    public long pXP;
    public long pXQ;
    public String pXR;
    public boolean pXS;
    public String value;

    public d(long j, String str, long j2, boolean z) {
        AppMethodBeat.i(72719);
        this.pXP = j;
        this.value = str;
        this.pXQ = j2;
        this.pXS = z;
        this.pXR = new SimpleDateFormat("[yy-MM-dd HH:mm:ss:SSS]").format(new Date(j2));
        AppMethodBeat.o(72719);
    }

    public final String toString() {
        AppMethodBeat.i(72720);
        String str = this.pXR + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + this.value;
        AppMethodBeat.o(72720);
        return str;
    }
}
