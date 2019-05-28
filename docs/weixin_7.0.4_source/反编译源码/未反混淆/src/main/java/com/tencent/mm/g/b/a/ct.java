package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class ct extends a {
    public long dig = 0;
    public long dih = 0;
    public long dii = 0;

    public final int getId() {
        return 16909;
    }

    public final String Fj() {
        AppMethodBeat.i(73309);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.dig);
        stringBuffer.append(str);
        stringBuffer.append(this.dih);
        stringBuffer.append(str);
        stringBuffer.append(this.dii);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(73309);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(73310);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ExptId:").append(this.dig);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("GroupId:").append(this.dih);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ExptSeq:").append(this.dii);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(73310);
        return stringBuffer2;
    }
}
