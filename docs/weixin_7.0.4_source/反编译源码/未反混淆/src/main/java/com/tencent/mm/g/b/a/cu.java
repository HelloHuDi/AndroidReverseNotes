package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class cu extends a {
    public long cYo = 0;
    public long dig = 0;
    public long dih = 0;
    public long dii = 0;
    public long dij = 0;
    private String dik = "";
    private String dil = "";

    public final int getId() {
        return 15452;
    }

    public final cu hJ(String str) {
        AppMethodBeat.i(73311);
        this.dik = t("ExptKey", str, true);
        AppMethodBeat.o(73311);
        return this;
    }

    public final cu hK(String str) {
        AppMethodBeat.i(73312);
        this.dil = t("ExptVal", str, false);
        AppMethodBeat.o(73312);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(73313);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.dig);
        stringBuffer.append(str);
        stringBuffer.append(this.dih);
        stringBuffer.append(str);
        stringBuffer.append(this.dii);
        stringBuffer.append(str);
        stringBuffer.append(this.cYo);
        stringBuffer.append(str);
        stringBuffer.append(this.dij);
        stringBuffer.append(str);
        stringBuffer.append(this.dik);
        stringBuffer.append(str);
        stringBuffer.append(this.dil);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(73313);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(73314);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ExptId:").append(this.dig);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("GroupId:").append(this.dih);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ExptSeq:").append(this.dii);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("StartTimeStampSec:").append(this.cYo);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("EndTimeStampSec:").append(this.dij);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ExptKey:").append(this.dik);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ExptVal:").append(this.dil);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(73314);
        return stringBuffer2;
    }
}
