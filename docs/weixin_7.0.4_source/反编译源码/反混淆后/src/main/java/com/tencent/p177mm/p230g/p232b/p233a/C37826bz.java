package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.bz */
public final class C37826bz extends C46180a {
    private String bUh = "";
    public long cVR = 0;
    private long ddA = 0;
    public long ddB = 0;
    public long ddC = 0;
    private String ddc = "";
    public long ddd = 0;
    public long ddg = 0;
    public long ddj = 0;
    private String ddx = "";
    public long ddz = 0;
    public C37825a deC;
    public long deD = 0;
    public long deE = 0;
    public long dew = 0;
    private String dex = "";

    /* renamed from: com.tencent.mm.g.b.a.bz$a */
    public enum C37825a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        static {
            AppMethodBeat.m2505o(128748);
        }

        private C37825a(int i) {
            this.value = i;
        }

        /* renamed from: ha */
        public static C37825a m63768ha(int i) {
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
        return 16009;
    }

    /* renamed from: gI */
    public final C37826bz mo60532gI(String str) {
        AppMethodBeat.m2504i(128749);
        this.ddx = mo74169t("InstanceId", str, true);
        AppMethodBeat.m2505o(128749);
        return this;
    }

    /* renamed from: gJ */
    public final C37826bz mo60533gJ(String str) {
        AppMethodBeat.m2504i(128750);
        this.ddc = mo74169t("AppId", str, true);
        AppMethodBeat.m2505o(128750);
        return this;
    }

    /* renamed from: dQ */
    public final C37826bz mo60530dQ(long j) {
        AppMethodBeat.m2504i(128751);
        this.ddA = j;
        super.mo74165ai("CostTimeMs", this.ddA);
        AppMethodBeat.m2505o(128751);
        return this;
    }

    /* renamed from: dR */
    public final C37826bz mo60531dR(long j) {
        AppMethodBeat.m2504i(128752);
        this.ddB = j;
        super.mo74166aj("StartTimeStampMs", this.ddB);
        AppMethodBeat.m2505o(128752);
        return this;
    }

    /* renamed from: gK */
    public final C37826bz mo60534gK(String str) {
        AppMethodBeat.m2504i(128754);
        this.bUh = mo74169t("path", str, true);
        AppMethodBeat.m2505o(128754);
        return this;
    }

    /* renamed from: gL */
    public final C37826bz mo60535gL(String str) {
        AppMethodBeat.m2504i(128755);
        this.dex = mo74169t("networkTypeStr", str, true);
        AppMethodBeat.m2505o(128755);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        int i;
        AppMethodBeat.m2504i(128756);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ddx);
        stringBuffer.append(str);
        stringBuffer.append(this.ddc);
        stringBuffer.append(str);
        stringBuffer.append(this.ddd);
        stringBuffer.append(str);
        if (this.deC != null) {
            i = this.deC.value;
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
        stringBuffer.append(this.bUh);
        stringBuffer.append(str);
        stringBuffer.append(this.ddj);
        stringBuffer.append(str);
        stringBuffer.append(this.dew);
        stringBuffer.append(str);
        stringBuffer.append(this.ddg);
        stringBuffer.append(str);
        stringBuffer.append(this.deD);
        stringBuffer.append(str);
        stringBuffer.append(this.dex);
        stringBuffer.append(str);
        stringBuffer.append(this.deE);
        String stringBuffer2 = stringBuffer.toString();
        mo74164VX(stringBuffer2);
        AppMethodBeat.m2505o(128756);
        return stringBuffer2;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(128757);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.ddx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppId:").append(this.ddc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppVersion:").append(this.ddd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppState:").append(this.deC);
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
        stringBuffer.append("path:").append(this.bUh);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("isDownloadCode:").append(this.ddj);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("isPatch:").append(this.dew);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("isPreload:").append(this.ddg);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("isPreloadPageFrame:").append(this.deD);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("networkTypeStr:").append(this.dex);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("isSplitCodeLib:").append(this.deE);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(128757);
        return stringBuffer2;
    }

    /* renamed from: Hb */
    public final C37826bz mo60529Hb() {
        AppMethodBeat.m2504i(128753);
        this.ddC = C5046bo.anU();
        super.mo74166aj("EndTimeStampMs", this.ddC);
        AppMethodBeat.m2505o(128753);
        return this;
    }
}
