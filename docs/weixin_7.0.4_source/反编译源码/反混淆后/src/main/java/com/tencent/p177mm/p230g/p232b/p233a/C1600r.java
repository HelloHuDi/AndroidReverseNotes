package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.r */
public final class C1600r extends C46180a {
    public long cWV = 0;
    public long cWW = 0;
    public long cWX = 0;
    public long cWY = 0;
    public long cWZ = 0;
    public long cXa = 0;
    public long cXb = 0;
    public long cXc = 0;
    public long cXd = 0;

    public final int getId() {
        return 15435;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(138450);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cWV);
        stringBuffer.append(str);
        stringBuffer.append(this.cWW);
        stringBuffer.append(str);
        stringBuffer.append(this.cWX);
        stringBuffer.append(str);
        stringBuffer.append(this.cWY);
        stringBuffer.append(str);
        stringBuffer.append(this.cWZ);
        stringBuffer.append(str);
        stringBuffer.append(this.cXa);
        stringBuffer.append(str);
        stringBuffer.append(this.cXb);
        stringBuffer.append(str);
        stringBuffer.append(this.cXc);
        stringBuffer.append(str);
        stringBuffer.append(this.cXd);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(138450);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(138451);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Source:").append(this.cWV);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("CaptureTime:").append(this.cWW);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Result:").append(this.cWX);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("UploadTime:").append(this.cWY);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("OCRTranslateTime:").append(this.cWZ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("TotalTime:").append(this.cXa);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ShowOriginCount:").append(this.cXb);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("HasSaveResultImage:").append(this.cXc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("HasSaveOriginImage:").append(this.cXd);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(138451);
        return stringBuffer2;
    }
}
