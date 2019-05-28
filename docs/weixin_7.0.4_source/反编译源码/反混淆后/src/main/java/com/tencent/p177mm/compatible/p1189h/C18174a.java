package com.tencent.p177mm.compatible.p1189h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.compatible.h.a */
public final class C18174a {
    public int cvG;
    public String euD;
    public long euE;
    public int euF;

    public C18174a() {
        AppMethodBeat.m2504i(93052);
        this.euD = null;
        this.euE = -1;
        this.euF = -1;
        this.cvG = -1;
        this.euD = null;
        this.euE = -1;
        this.euF = -1;
        this.cvG = -1;
        AppMethodBeat.m2505o(93052);
    }

    /* renamed from: Mk */
    public final String mo33663Mk() {
        AppMethodBeat.m2504i(93053);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.euD);
        stringBuffer.append(",");
        stringBuffer.append(this.euE);
        stringBuffer.append(",");
        stringBuffer.append(this.euF);
        stringBuffer.append(",");
        stringBuffer.append(this.cvG);
        C4990ab.m7410d("MicroMsg.AudioRecorderInfo", " getStatInfo " + stringBuffer.toString());
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(93053);
        return stringBuffer2;
    }
}
