package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class o extends a {
    private long cVR = 0;
    private String cWn = "";
    private String cWo = "";
    private String cWp = "";
    public long cWq = 0;
    private String cWr = "";
    private String cWs = "";
    public long cWt = 0;

    public final int getId() {
        return 16019;
    }

    public final o Fp() {
        this.cVR = 47;
        return this;
    }

    public final o eH(String str) {
        AppMethodBeat.i(91250);
        this.cWn = t("SearchId", str, true);
        AppMethodBeat.o(91250);
        return this;
    }

    public final o eI(String str) {
        AppMethodBeat.i(91251);
        this.cWo = t("SessionId", str, true);
        AppMethodBeat.o(91251);
        return this;
    }

    public final o eJ(String str) {
        AppMethodBeat.i(91252);
        this.cWp = t("Query", str, true);
        AppMethodBeat.o(91252);
        return this;
    }

    public final o eK(String str) {
        AppMethodBeat.i(91253);
        this.cWr = t("Path", str, true);
        AppMethodBeat.o(91253);
        return this;
    }

    public final o eL(String str) {
        AppMethodBeat.i(91254);
        this.cWs = t("WeappUsrname", str, true);
        AppMethodBeat.o(91254);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(91255);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cVR);
        stringBuffer.append(str);
        stringBuffer.append(this.cWn);
        stringBuffer.append(str);
        stringBuffer.append(this.cWo);
        stringBuffer.append(str);
        stringBuffer.append(this.cWp);
        stringBuffer.append(str);
        stringBuffer.append(this.cWq);
        stringBuffer.append(str);
        stringBuffer.append(this.cWr);
        stringBuffer.append(str);
        stringBuffer.append(this.cWs);
        stringBuffer.append(str);
        stringBuffer.append(this.cWt);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(91255);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(91256);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Scene:").append(this.cVR);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("SearchId:").append(this.cWn);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("SessionId:").append(this.cWo);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Query:").append(this.cWp);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("JumpType:").append(this.cWq);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Path:").append(this.cWr);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("WeappUsrname:").append(this.cWs);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ServiceType:").append(this.cWt);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(91256);
        return stringBuffer2;
    }
}
