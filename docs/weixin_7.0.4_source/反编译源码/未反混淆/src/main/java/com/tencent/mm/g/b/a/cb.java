package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;

public final class cb extends com.tencent.mm.plugin.report.a {
    private long cVR = 0;
    private String cYP = "";
    private long ddA = 0;
    private long ddB = 0;
    private long ddC = 0;
    private String ddc = "";
    private long ddd = 0;
    private String ddx = "";
    private long ddz = 0;
    private a deQ;
    private long deR = 0;
    private String dex = "";

    public enum a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        static {
            AppMethodBeat.o(128772);
        }

        private a(int i) {
            this.value = i;
        }

        public static a hc(int i) {
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
        return 16367;
    }

    public final cb gQ(String str) {
        AppMethodBeat.i(128773);
        this.ddx = t("InstanceId", str, true);
        AppMethodBeat.o(128773);
        return this;
    }

    public final cb gR(String str) {
        AppMethodBeat.i(128774);
        this.ddc = t("AppId", str, true);
        AppMethodBeat.o(128774);
        return this;
    }

    public final cb dU(long j) {
        this.ddd = j;
        return this;
    }

    public final cb a(a aVar) {
        this.deQ = aVar;
        return this;
    }

    public final cb dV(long j) {
        this.ddz = j;
        return this;
    }

    public final cb dW(long j) {
        this.cVR = j;
        return this;
    }

    public final cb gS(String str) {
        AppMethodBeat.i(128775);
        this.dex = t("networkTypeStr", str, true);
        AppMethodBeat.o(128775);
        return this;
    }

    public final cb dX(long j) {
        this.deR = j;
        return this;
    }

    public final cb gT(String str) {
        AppMethodBeat.i(128776);
        this.cYP = t("UserName", str, true);
        AppMethodBeat.o(128776);
        return this;
    }

    public final String Fj() {
        int i;
        AppMethodBeat.i(128777);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ddx);
        stringBuffer.append(str);
        stringBuffer.append(this.ddc);
        stringBuffer.append(str);
        stringBuffer.append(this.ddd);
        stringBuffer.append(str);
        if (this.deQ != null) {
            i = this.deQ.value;
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
        stringBuffer.append(this.dex);
        stringBuffer.append(str);
        stringBuffer.append(this.deR);
        stringBuffer.append(str);
        stringBuffer.append(this.cYP);
        String stringBuffer2 = stringBuffer.toString();
        VX(stringBuffer2);
        AppMethodBeat.o(128777);
        return stringBuffer2;
    }

    public final String Fk() {
        AppMethodBeat.i(128778);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.ddx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppId:").append(this.ddc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppVersion:").append(this.ddd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppState:").append(this.deQ);
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
        stringBuffer.append("networkTypeStr:").append(this.dex);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("isLaunch:").append(this.deR);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("UserName:").append(this.cYP);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(128778);
        return stringBuffer2;
    }
}
