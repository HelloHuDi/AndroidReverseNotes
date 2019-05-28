package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;

public final class b extends a {
    public long cTr = 0;
    private long cTs = 0;
    public long cTt = 0;
    public long cTu = 0;
    public long cTv = 0;
    public long cTw = 0;

    public final int getId() {
        return 16113;
    }

    public final b aM(long j) {
        AppMethodBeat.i(15817);
        this.cTr = j;
        super.aj("FirstInputTimeStampMs", this.cTr);
        AppMethodBeat.o(15817);
        return this;
    }

    public final b aN(long j) {
        AppMethodBeat.i(15819);
        this.cTs = j;
        super.aj("LastInputTimeStampMs", this.cTs);
        AppMethodBeat.o(15819);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(15821);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cTr);
        stringBuffer.append(str);
        stringBuffer.append(this.cTs);
        stringBuffer.append(str);
        stringBuffer.append(this.cTt);
        stringBuffer.append(str);
        stringBuffer.append(this.cTu);
        stringBuffer.append(str);
        stringBuffer.append(this.cTv);
        stringBuffer.append(str);
        stringBuffer.append(this.cTw);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(15821);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(15822);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FirstInputTimeStampMs:").append(this.cTr);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("LastInputTimeStampMs:").append(this.cTs);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("SendStampMs:").append(this.cTt);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ClickCount:").append(this.cTu);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("TextLength:").append(this.cTv);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("EmojiCount:").append(this.cTw);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(15822);
        return stringBuffer2;
    }

    public final b Fl() {
        AppMethodBeat.i(15818);
        b aM = aM(bo.anU());
        AppMethodBeat.o(15818);
        return aM;
    }

    public final b Fm() {
        AppMethodBeat.i(15820);
        b aN = aN(bo.anU());
        AppMethodBeat.o(15820);
        return aN;
    }
}
