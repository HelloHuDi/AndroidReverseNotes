package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;

public final class ce extends com.tencent.mm.plugin.report.a {
    private String ddc = "";
    public long ddd = 0;
    public long ddz = 0;
    private String dex = "";
    public a dfv;
    private String dfw = "";
    public long dfx = 0;
    public long dfy = 0;

    public enum a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        static {
            AppMethodBeat.o(128796);
        }

        private a(int i) {
            this.value = i;
        }

        public static a he(int i) {
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
        return 17120;
    }

    public final ce gW(String str) {
        AppMethodBeat.i(128797);
        this.ddc = t("AppId", str, true);
        AppMethodBeat.o(128797);
        return this;
    }

    public final ce gX(String str) {
        AppMethodBeat.i(128798);
        this.dfw = t("Provider", str, true);
        AppMethodBeat.o(128798);
        return this;
    }

    public final ce gY(String str) {
        AppMethodBeat.i(128799);
        this.dex = t("networkTypeStr", str, true);
        AppMethodBeat.o(128799);
        return this;
    }

    public final String Fj() {
        int i;
        AppMethodBeat.i(128800);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ddc);
        stringBuffer.append(str);
        stringBuffer.append(this.ddd);
        stringBuffer.append(str);
        if (this.dfv != null) {
            i = this.dfv.value;
        } else {
            i = -1;
        }
        stringBuffer.append(i);
        stringBuffer.append(str);
        stringBuffer.append(this.ddz);
        stringBuffer.append(str);
        stringBuffer.append(this.dfw);
        stringBuffer.append(str);
        stringBuffer.append(this.dfx);
        stringBuffer.append(str);
        stringBuffer.append(this.dfy);
        stringBuffer.append(str);
        stringBuffer.append(this.dex);
        String stringBuffer2 = stringBuffer.toString();
        VX(stringBuffer2);
        AppMethodBeat.o(128800);
        return stringBuffer2;
    }

    public final String Fk() {
        AppMethodBeat.i(128801);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AppId:").append(this.ddc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppVersion:").append(this.ddd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppState:").append(this.dfv);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppType:").append(this.ddz);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Provider:").append(this.dfw);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Version:").append(this.dfx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Stage:").append(this.dfy);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("networkTypeStr:").append(this.dex);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(128801);
        return stringBuffer2;
    }
}
