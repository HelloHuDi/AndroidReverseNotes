package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.bn */
public final class C32665bn extends C46180a {
    public long dcT = 0;
    public long dcU = 0;
    public long dcV = 0;
    public long dcW = 0;
    public long dcX = 0;

    public final int getId() {
        return 15401;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(128641);
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
        mo74164VX(str);
        AppMethodBeat.m2505o(128641);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(128642);
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
        AppMethodBeat.m2505o(128642);
        return stringBuffer2;
    }
}
