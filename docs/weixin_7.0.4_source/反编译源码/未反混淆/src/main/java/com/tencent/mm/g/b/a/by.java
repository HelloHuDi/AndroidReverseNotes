package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;

public final class by extends com.tencent.mm.plugin.report.a {
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
    public a dev;
    public long dew = 0;
    private String dex = "";

    public enum a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        static {
            AppMethodBeat.o(128736);
        }

        private a(int i) {
            this.value = i;
        }

        public static a gZ(int i) {
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

    public final by gE(String str) {
        AppMethodBeat.i(128737);
        this.ddx = t("InstanceId", str, true);
        AppMethodBeat.o(128737);
        return this;
    }

    public final by gF(String str) {
        AppMethodBeat.i(128738);
        this.ddc = t("AppId", str, true);
        AppMethodBeat.o(128738);
        return this;
    }

    public final by dO(long j) {
        AppMethodBeat.i(128739);
        this.ddA = j;
        super.ai("CostTimeMs", this.ddA);
        AppMethodBeat.o(128739);
        return this;
    }

    public final by dP(long j) {
        AppMethodBeat.i(128740);
        this.ddB = j;
        super.aj("StartTimeStampMs", this.ddB);
        AppMethodBeat.o(128740);
        return this;
    }

    public final by gG(String str) {
        AppMethodBeat.i(128742);
        this.bUh = t("path", str, true);
        AppMethodBeat.o(128742);
        return this;
    }

    public final by gH(String str) {
        AppMethodBeat.i(128743);
        this.dex = t("networkTypeStr", str, true);
        AppMethodBeat.o(128743);
        return this;
    }

    public final String Fj() {
        int i;
        AppMethodBeat.i(128744);
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
        VX(stringBuffer2);
        AppMethodBeat.o(128744);
        return stringBuffer2;
    }

    public final String Fk() {
        AppMethodBeat.i(128745);
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
        AppMethodBeat.o(128745);
        return stringBuffer2;
    }

    public final by Ha() {
        AppMethodBeat.i(128741);
        this.ddC = bo.anU();
        super.aj("EndTimeStampMs", this.ddC);
        AppMethodBeat.o(128741);
        return this;
    }
}
