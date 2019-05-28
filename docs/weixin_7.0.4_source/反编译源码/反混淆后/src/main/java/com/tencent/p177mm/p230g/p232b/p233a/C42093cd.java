package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.cd */
public final class C42093cd extends C46180a {
    public long cVR = 0;
    private long ddA = 0;
    private long ddB = 0;
    private long ddC = 0;
    private String ddc = "";
    public long ddd = 0;
    private String ddx = "";
    public long ddz = 0;
    public C42092a dfc;
    public long dfd = 0;
    public long dfe = 0;
    public long dff = 0;
    public long dfg = 0;
    public long dfh = 0;
    public long dfi = 0;
    public long dfj = 0;
    public long dfk = 0;
    public long dfl = 0;
    public long dfm = 0;
    public long dfn = 0;
    public long dfo = 0;
    public long dfp = 0;
    public long dfq = 0;

    /* renamed from: com.tencent.mm.g.b.a.cd$a */
    public enum C42092a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        static {
            AppMethodBeat.m2505o(128786);
        }

        private C42092a(int i) {
            this.value = i;
        }

        /* renamed from: hd */
        public static C42092a m74182hd(int i) {
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
        return 16023;
    }

    /* renamed from: gU */
    public final C42093cd mo67649gU(String str) {
        AppMethodBeat.m2504i(128787);
        this.ddx = mo74169t("InstanceId", str, true);
        AppMethodBeat.m2505o(128787);
        return this;
    }

    /* renamed from: gV */
    public final C42093cd mo67650gV(String str) {
        AppMethodBeat.m2504i(128788);
        this.ddc = mo74169t("AppId", str, true);
        AppMethodBeat.m2505o(128788);
        return this;
    }

    /* renamed from: Hd */
    public final C42093cd mo67646Hd() {
        AppMethodBeat.m2504i(128789);
        this.ddA = 0;
        super.mo74165ai("CostTimeMs", this.ddA);
        AppMethodBeat.m2505o(128789);
        return this;
    }

    /* renamed from: He */
    public final C42093cd mo67647He() {
        AppMethodBeat.m2504i(128790);
        this.ddB = 0;
        super.mo74166aj("StartTimeStampMs", this.ddB);
        AppMethodBeat.m2505o(128790);
        return this;
    }

    /* renamed from: Hf */
    public final C42093cd mo67648Hf() {
        AppMethodBeat.m2504i(128791);
        this.ddC = 0;
        super.mo74166aj("EndTimeStampMs", this.ddC);
        AppMethodBeat.m2505o(128791);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        int i;
        AppMethodBeat.m2504i(128792);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ddx);
        stringBuffer.append(str);
        stringBuffer.append(this.ddc);
        stringBuffer.append(str);
        stringBuffer.append(this.ddd);
        stringBuffer.append(str);
        if (this.dfc != null) {
            i = this.dfc.value;
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
        stringBuffer.append(this.dfd);
        stringBuffer.append(str);
        stringBuffer.append(this.dfe);
        stringBuffer.append(str);
        stringBuffer.append(this.dff);
        stringBuffer.append(str);
        stringBuffer.append(this.dfg);
        stringBuffer.append(str);
        stringBuffer.append(this.dfh);
        stringBuffer.append(str);
        stringBuffer.append(this.dfi);
        stringBuffer.append(str);
        stringBuffer.append(this.dfj);
        stringBuffer.append(str);
        stringBuffer.append(this.dfk);
        stringBuffer.append(str);
        stringBuffer.append(this.dfl);
        stringBuffer.append(str);
        stringBuffer.append(this.dfm);
        stringBuffer.append(str);
        stringBuffer.append(this.dfn);
        stringBuffer.append(str);
        stringBuffer.append(this.dfo);
        stringBuffer.append(str);
        stringBuffer.append(this.dfp);
        stringBuffer.append(str);
        stringBuffer.append(this.dfq);
        String stringBuffer2 = stringBuffer.toString();
        mo74164VX(stringBuffer2);
        AppMethodBeat.m2505o(128792);
        return stringBuffer2;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(128793);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.ddx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppId:").append(this.ddc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppVersion:").append(this.ddd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppState:").append(this.dfc);
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
        stringBuffer.append("fps:").append(this.dfd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("fpsVariance:").append(this.dfe);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("cpu:").append(this.dff);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("memory:").append(this.dfg);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("memoryDiff:").append(this.dfh);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("androidNativeMemory:").append(this.dfi);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("androidDalvikMemory:").append(this.dfj);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("runtimeDuration:").append(this.dfk);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("runtimeCount:").append(this.dfl);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("mainCanvasType:").append(this.dfm);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("triangles:").append(this.dfn);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("drawcall:").append(this.dfo);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("vertex:").append(this.dfp);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("useCommandBuffer:").append(this.dfq);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(128793);
        return stringBuffer2;
    }
}
