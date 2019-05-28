package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.by */
public final class C1593by extends C46180a {
    private String bUh = "";
    public long cVR = 0;
    private long ddA = 0;
    private long ddB = 0;
    public long ddC = 0;
    private String ddc = "";
    public long ddd = 0;
    public long ddg = 0;
    public long ddj = 0;
    private String ddx = "";
    public long ddz = 0;
    public C1594a dev;
    public long dew = 0;
    private String dex = "";

    /* renamed from: com.tencent.mm.g.b.a.by$a */
    public enum C1594a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        static {
            AppMethodBeat.m2505o(128736);
        }

        private C1594a(int i) {
            this.value = i;
        }

        /* renamed from: gZ */
        public static C1594a m3234gZ(int i) {
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
        return 16010;
    }

    /* renamed from: gE */
    public final C1593by mo5031gE(String str) {
        AppMethodBeat.m2504i(128737);
        this.ddx = mo74169t("InstanceId", str, true);
        AppMethodBeat.m2505o(128737);
        return this;
    }

    /* renamed from: gF */
    public final C1593by mo5032gF(String str) {
        AppMethodBeat.m2504i(128738);
        this.ddc = mo74169t("AppId", str, true);
        AppMethodBeat.m2505o(128738);
        return this;
    }

    /* renamed from: dO */
    public final C1593by mo5029dO(long j) {
        AppMethodBeat.m2504i(128739);
        this.ddA = j;
        super.mo74165ai("CostTimeMs", this.ddA);
        AppMethodBeat.m2505o(128739);
        return this;
    }

    /* renamed from: dP */
    public final C1593by mo5030dP(long j) {
        AppMethodBeat.m2504i(128740);
        this.ddB = j;
        super.mo74166aj("StartTimeStampMs", this.ddB);
        AppMethodBeat.m2505o(128740);
        return this;
    }

    /* renamed from: gG */
    public final C1593by mo5033gG(String str) {
        AppMethodBeat.m2504i(128742);
        this.bUh = mo74169t("path", str, true);
        AppMethodBeat.m2505o(128742);
        return this;
    }

    /* renamed from: gH */
    public final C1593by mo5034gH(String str) {
        AppMethodBeat.m2504i(128743);
        this.dex = mo74169t("networkTypeStr", str, true);
        AppMethodBeat.m2505o(128743);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        int i;
        AppMethodBeat.m2504i(128744);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ddx);
        stringBuffer.append(str);
        stringBuffer.append(this.ddc);
        stringBuffer.append(str);
        stringBuffer.append(this.ddd);
        stringBuffer.append(str);
        if (this.dev != null) {
            i = this.dev.value;
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
        stringBuffer.append(this.dex);
        String stringBuffer2 = stringBuffer.toString();
        mo74164VX(stringBuffer2);
        AppMethodBeat.m2505o(128744);
        return stringBuffer2;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(128745);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.ddx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppId:").append(this.ddc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppVersion:").append(this.ddd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppState:").append(this.dev);
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
        stringBuffer.append("networkTypeStr:").append(this.dex);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(128745);
        return stringBuffer2;
    }

    /* renamed from: Ha */
    public final C1593by mo5028Ha() {
        AppMethodBeat.m2504i(128741);
        this.ddC = C5046bo.anU();
        super.mo74166aj("EndTimeStampMs", this.ddC);
        AppMethodBeat.m2505o(128741);
        return this;
    }
}
