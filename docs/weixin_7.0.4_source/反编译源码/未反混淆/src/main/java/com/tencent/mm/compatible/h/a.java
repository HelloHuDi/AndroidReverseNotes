package com.tencent.mm.compatible.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class a {
    public int cvG;
    public String euD;
    public long euE;
    public int euF;

    public a() {
        AppMethodBeat.i(93052);
        this.euD = null;
        this.euE = -1;
        this.euF = -1;
        this.cvG = -1;
        this.euD = null;
        this.euE = -1;
        this.euF = -1;
        this.cvG = -1;
        AppMethodBeat.o(93052);
    }

    public final String Mk() {
        AppMethodBeat.i(93053);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.euD);
        stringBuffer.append(",");
        stringBuffer.append(this.euE);
        stringBuffer.append(",");
        stringBuffer.append(this.euF);
        stringBuffer.append(",");
        stringBuffer.append(this.cvG);
        ab.d("MicroMsg.AudioRecorderInfo", " getStatInfo " + stringBuffer.toString());
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(93053);
        return stringBuffer2;
    }
}
