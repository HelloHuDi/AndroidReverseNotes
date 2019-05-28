package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class r extends a {
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

    public final String Fj() {
        AppMethodBeat.i(138450);
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
        VX(str);
        AppMethodBeat.o(138450);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(138451);
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
        AppMethodBeat.o(138451);
        return stringBuffer2;
    }
}
