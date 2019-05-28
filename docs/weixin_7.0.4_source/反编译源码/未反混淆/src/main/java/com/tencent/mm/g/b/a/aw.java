package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class aw extends a {
    private long cYQ = 0;
    private long cYZ = 0;
    private String dap = "";
    private String daq = "";
    private long dar = 0;
    private String das = "";
    private String dat = "";

    public final int getId() {
        return 16842;
    }

    public final aw ch(long j) {
        this.cYZ = j;
        return this;
    }

    public final aw ci(long j) {
        this.cYQ = j;
        return this;
    }

    public final aw fK(String str) {
        AppMethodBeat.i(108877);
        this.dap = t("WaitPlayVideoList", str, true);
        AppMethodBeat.o(108877);
        return this;
    }

    public final String FZ() {
        return this.dap;
    }

    public final aw cj(long j) {
        this.dar = j;
        return this;
    }

    public final aw fL(String str) {
        AppMethodBeat.i(108878);
        this.das = t("WaitPlayVideoList1", str, true);
        AppMethodBeat.o(108878);
        return this;
    }

    public final String Ga() {
        return this.das;
    }

    public final aw fM(String str) {
        AppMethodBeat.i(108879);
        this.dat = t("WaitPlayVideoList2", str, true);
        AppMethodBeat.o(108879);
        return this;
    }

    public final String Gb() {
        return this.dat;
    }

    public final String Fj() {
        AppMethodBeat.i(108880);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cYZ);
        stringBuffer.append(str);
        stringBuffer.append(this.cYQ);
        stringBuffer.append(str);
        stringBuffer.append(this.dap);
        stringBuffer.append(str);
        stringBuffer.append(this.daq);
        stringBuffer.append(str);
        stringBuffer.append(this.dar);
        stringBuffer.append(str);
        stringBuffer.append(this.das);
        stringBuffer.append(str);
        stringBuffer.append(this.dat);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(108880);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(108881);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("EnterTime:").append(this.cYZ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("PreviewEnterScene:").append(this.cYQ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("WaitPlayVideoList:").append(this.dap);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("WaitPlayUinList:").append(this.daq);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("index:").append(this.dar);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("WaitPlayVideoList1:").append(this.das);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("WaitPlayVideoList2:").append(this.dat);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(108881);
        return stringBuffer2;
    }
}
