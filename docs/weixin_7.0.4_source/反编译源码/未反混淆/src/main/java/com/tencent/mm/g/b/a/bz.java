package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;

public final class bz extends com.tencent.mm.plugin.report.a {
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
    public a deC;
    public long deD = 0;
    public long deE = 0;
    public long dew = 0;
    private String dex = "";

    public enum a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        static {
            AppMethodBeat.o(128748);
        }

        private a(int i) {
            this.value = i;
        }

        public static a ha(int i) {
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

    public final bz gI(String str) {
        AppMethodBeat.i(128749);
        this.ddx = t("InstanceId", str, true);
        AppMethodBeat.o(128749);
        return this;
    }

    public final bz gJ(String str) {
        AppMethodBeat.i(128750);
        this.ddc = t("AppId", str, true);
        AppMethodBeat.o(128750);
        return this;
    }

    public final bz dQ(long j) {
        AppMethodBeat.i(128751);
        this.ddA = j;
        super.ai("CostTimeMs", this.ddA);
        AppMethodBeat.o(128751);
        return this;
    }

    public final bz dR(long j) {
        AppMethodBeat.i(128752);
        this.ddB = j;
        super.aj("StartTimeStampMs", this.ddB);
        AppMethodBeat.o(128752);
        return this;
    }

    public final bz gK(String str) {
        AppMethodBeat.i(128754);
        this.bUh = t("path", str, true);
        AppMethodBeat.o(128754);
        return this;
    }

    public final bz gL(String str) {
        AppMethodBeat.i(128755);
        this.dex = t("networkTypeStr", str, true);
        AppMethodBeat.o(128755);
        return this;
    }

    public final String Fj() {
        int i;
        AppMethodBeat.i(128756);
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
        VX(stringBuffer2);
        AppMethodBeat.o(128756);
        return stringBuffer2;
    }

    public final String Fk() {
        AppMethodBeat.i(128757);
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
        AppMethodBeat.o(128757);
        return stringBuffer2;
    }

    public final bz Hb() {
        AppMethodBeat.i(128753);
        this.ddC = bo.anU();
        super.aj("EndTimeStampMs", this.ddC);
        AppMethodBeat.o(128753);
        return this;
    }
}
