package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class bn extends a {
    public long dcT = 0;
    public long dcU = 0;
    public long dcV = 0;
    public long dcW = 0;
    public long dcX = 0;

    public final int getId() {
        return 15401;
    }

    public final String Fj() {
        AppMethodBeat.i(128641);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.dcT);
        stringBuffer.append(str);
        stringBuffer.append(this.dcU);
        stringBuffer.append(str);
        stringBuffer.append(this.dcV);
        stringBuffer.append(str);
        stringBuffer.append(this.dcW);
        stringBuffer.append(str);
        stringBuffer.append(this.dcX);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(128641);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(128642);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AllPackageSize:").append(this.dcT);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AllPackageClientStoragePercent:").append(this.dcU);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ClientStorageFreePercent:").append(this.dcV);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AbtestStatus:").append(this.dcW);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("WeappCountThatHasPackage:").append(this.dcX);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(128642);
        return stringBuffer2;
    }
}
