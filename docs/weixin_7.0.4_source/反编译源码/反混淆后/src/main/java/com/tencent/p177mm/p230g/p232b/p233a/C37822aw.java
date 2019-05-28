package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.aw */
public final class C37822aw extends C46180a {
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

    /* renamed from: ch */
    public final C37822aw mo60522ch(long j) {
        this.cYZ = j;
        return this;
    }

    /* renamed from: ci */
    public final C37822aw mo60523ci(long j) {
        this.cYQ = j;
        return this;
    }

    /* renamed from: fK */
    public final C37822aw mo60525fK(String str) {
        AppMethodBeat.m2504i(108877);
        this.dap = mo74169t("WaitPlayVideoList", str, true);
        AppMethodBeat.m2505o(108877);
        return this;
    }

    /* renamed from: FZ */
    public final String mo60519FZ() {
        return this.dap;
    }

    /* renamed from: cj */
    public final C37822aw mo60524cj(long j) {
        this.dar = j;
        return this;
    }

    /* renamed from: fL */
    public final C37822aw mo60526fL(String str) {
        AppMethodBeat.m2504i(108878);
        this.das = mo74169t("WaitPlayVideoList1", str, true);
        AppMethodBeat.m2505o(108878);
        return this;
    }

    /* renamed from: Ga */
    public final String mo60520Ga() {
        return this.das;
    }

    /* renamed from: fM */
    public final C37822aw mo60527fM(String str) {
        AppMethodBeat.m2504i(108879);
        this.dat = mo74169t("WaitPlayVideoList2", str, true);
        AppMethodBeat.m2505o(108879);
        return this;
    }

    /* renamed from: Gb */
    public final String mo60521Gb() {
        return this.dat;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(108880);
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
        mo74164VX(str);
        AppMethodBeat.m2505o(108880);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(108881);
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
        AppMethodBeat.m2505o(108881);
        return stringBuffer2;
    }
}
