package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.ca */
public final class C26279ca extends C46180a {
    public long cVR = 0;
    private long ddA = 0;
    private long ddB = 0;
    public long ddC = 0;
    private String ddc = "";
    public long ddd = 0;
    public long ddg = 0;
    private String ddx = "";
    public long ddz = 0;
    public C26280a deJ;
    private String deK = "";
    private String deL = "";
    public long dep = 0;

    /* renamed from: com.tencent.mm.g.b.a.ca$a */
    public enum C26280a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        static {
            AppMethodBeat.m2505o(128760);
        }

        private C26280a(int i) {
            this.value = i;
        }

        /* renamed from: hb */
        public static C26280a m41746hb(int i) {
            switch (i) {
                case 1:
                    return release;
                case 2:
                    return debug;
                case 3:
                    return demo;
                default:
                    return null;
            }
        }
    }

    public final int getId() {
        return 15815;
    }

    /* renamed from: gM */
    public final C26279ca mo44029gM(String str) {
        AppMethodBeat.m2504i(128761);
        this.ddx = mo74169t("InstanceId", str, true);
        AppMethodBeat.m2505o(128761);
        return this;
    }

    /* renamed from: gN */
    public final C26279ca mo44030gN(String str) {
        AppMethodBeat.m2504i(128762);
        this.ddc = mo74169t("AppId", str, true);
        AppMethodBeat.m2505o(128762);
        return this;
    }

    /* renamed from: dS */
    public final C26279ca mo44027dS(long j) {
        AppMethodBeat.m2504i(128763);
        this.ddA = j;
        super.mo74165ai("CostTimeMs", this.ddA);
        AppMethodBeat.m2505o(128763);
        return this;
    }

    /* renamed from: dT */
    public final C26279ca mo44028dT(long j) {
        AppMethodBeat.m2504i(128764);
        this.ddB = j;
        super.mo74166aj("StartTimeStampMs", this.ddB);
        AppMethodBeat.m2505o(128764);
        return this;
    }

    /* renamed from: gO */
    public final C26279ca mo44031gO(String str) {
        AppMethodBeat.m2504i(128766);
        this.deK = mo74169t(DownloadInfo.FILENAME, str, true);
        AppMethodBeat.m2505o(128766);
        return this;
    }

    /* renamed from: gP */
    public final C26279ca mo44032gP(String str) {
        AppMethodBeat.m2504i(128767);
        this.deL = mo74169t("libVersion", str, true);
        AppMethodBeat.m2505o(128767);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        int i;
        AppMethodBeat.m2504i(128768);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ddx);
        stringBuffer.append(str);
        stringBuffer.append(this.ddc);
        stringBuffer.append(str);
        stringBuffer.append(this.ddd);
        stringBuffer.append(str);
        if (this.deJ != null) {
            i = this.deJ.value;
        } else {
            i = -1;
        }
        stringBuffer.append(i);
        stringBuffer.append(str);
        stringBuffer.append(this.ddz);
        stringBuffer.append(str);
        stringBuffer.append(this.ddA);
        stringBuffer.append(str);
        stringBuffer.append(this.cVR);
        stringBuffer.append(str);
        stringBuffer.append(this.ddB);
        stringBuffer.append(str);
        stringBuffer.append(this.ddC);
        stringBuffer.append(str);
        stringBuffer.append(this.ddg);
        stringBuffer.append(str);
        stringBuffer.append(this.deK);
        stringBuffer.append(str);
        stringBuffer.append(this.deL);
        stringBuffer.append(str);
        stringBuffer.append(this.dep);
        String stringBuffer2 = stringBuffer.toString();
        mo74164VX(stringBuffer2);
        AppMethodBeat.m2505o(128768);
        return stringBuffer2;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(128769);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.ddx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppId:").append(this.ddc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppVersion:").append(this.ddd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppState:").append(this.deJ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppType:").append(this.ddz);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("CostTimeMs:").append(this.ddA);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Scene:").append(this.cVR);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("StartTimeStampMs:").append(this.ddB);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("EndTimeStampMs:").append(this.ddC);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("isPreload:").append(this.ddg);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("fileName:").append(this.deK);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("libVersion:").append(this.deL);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("fileSize:").append(this.dep);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(128769);
        return stringBuffer2;
    }

    /* renamed from: Hc */
    public final C26279ca mo44026Hc() {
        AppMethodBeat.m2504i(128765);
        this.ddC = C5046bo.anU();
        super.mo74166aj("EndTimeStampMs", this.ddC);
        AppMethodBeat.m2505o(128765);
        return this;
    }
}
