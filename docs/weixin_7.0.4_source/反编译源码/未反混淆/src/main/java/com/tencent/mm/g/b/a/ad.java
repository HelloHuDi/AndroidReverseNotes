package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.ttpic.baseutils.IOUtils;

public final class ad extends a {
    private String cYr = "";
    public long cYs = 0;
    public long cYt = 0;
    public long cYu = 0;
    private String cYv = "";
    public long cYw = 0;
    public long cYx = 0;
    private String cYy = "";
    private String cYz = "";

    public final int getId() {
        return 14452;
    }

    public final ad eY(String str) {
        AppMethodBeat.i(70613);
        this.cYr = t("statId", str, true);
        AppMethodBeat.o(70613);
        return this;
    }

    public final ad eZ(String str) {
        AppMethodBeat.i(70614);
        this.cYv = t("appid", str, true);
        AppMethodBeat.o(70614);
        return this;
    }

    public final ad fa(String str) {
        AppMethodBeat.i(70615);
        this.cYy = t(DownloadInfo.NETTYPE, str, true);
        AppMethodBeat.o(70615);
        return this;
    }

    public final ad fb(String str) {
        AppMethodBeat.i(70616);
        this.cYz = t("jsError", str, true);
        AppMethodBeat.o(70616);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(70617);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cYr);
        stringBuffer.append(str);
        stringBuffer.append(this.cYs);
        stringBuffer.append(str);
        stringBuffer.append(this.cYt);
        stringBuffer.append(str);
        stringBuffer.append(this.cYu);
        stringBuffer.append(str);
        stringBuffer.append(this.cYv);
        stringBuffer.append(str);
        stringBuffer.append(this.cYw);
        stringBuffer.append(str);
        stringBuffer.append(this.cYx);
        stringBuffer.append(str);
        stringBuffer.append(this.cYy);
        stringBuffer.append(str);
        stringBuffer.append(this.cYz);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(70617);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(70618);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("statId:").append(this.cYr);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("statEvent:").append(this.cYs);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("statTimeStamp:").append(this.cYt);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("success:").append(this.cYu);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("appid:").append(this.cYv);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("searchType:").append(this.cYw);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("hasInitData:").append(this.cYx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("netType:").append(this.cYy);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("jsError:").append(this.cYz);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(70618);
        return stringBuffer2;
    }
}
