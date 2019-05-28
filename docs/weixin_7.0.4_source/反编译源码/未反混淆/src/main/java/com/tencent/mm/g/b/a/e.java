package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;

public final class e extends com.tencent.mm.plugin.report.a {
    private String cUM = "";
    public long cUN = 0;
    public long cUO = 0;
    public long cUP = 0;
    public boolean cUQ;
    public long cUR = 0;
    public long cUS = 0;
    public long cUT = 0;
    private long cUU = 0;
    private long cUV = 0;
    public a cUW;

    public enum a {
        ok(0),
        cancel(1),
        error(2);
        
        final int value;

        static {
            AppMethodBeat.o(15825);
        }

        private a(int i) {
            this.value = i;
        }
    }

    public final int getId() {
        return 15749;
    }

    public final e er(String str) {
        AppMethodBeat.i(15826);
        this.cUM = t("ChatName", str, true);
        AppMethodBeat.o(15826);
        return this;
    }

    public final String Fj() {
        int i;
        AppMethodBeat.i(15829);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cUM);
        stringBuffer.append(str);
        stringBuffer.append(this.cUN);
        stringBuffer.append(str);
        stringBuffer.append(this.cUO);
        stringBuffer.append(str);
        stringBuffer.append(this.cUP);
        stringBuffer.append(str);
        if (this.cUQ) {
            i = 1;
        } else {
            i = 0;
        }
        stringBuffer.append(i);
        stringBuffer.append(str);
        stringBuffer.append(this.cUR);
        stringBuffer.append(str);
        stringBuffer.append(this.cUS);
        stringBuffer.append(str);
        stringBuffer.append(this.cUT);
        stringBuffer.append(str);
        stringBuffer.append(this.cUU);
        stringBuffer.append(str);
        stringBuffer.append(this.cUV);
        stringBuffer.append(str);
        if (this.cUW != null) {
            i = this.cUW.value;
        } else {
            i = -1;
        }
        stringBuffer.append(i);
        String stringBuffer2 = stringBuffer.toString();
        VX(stringBuffer2);
        AppMethodBeat.o(15829);
        return stringBuffer2;
    }

    public final String Fk() {
        AppMethodBeat.i(15830);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ChatName:").append(this.cUM);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("MemberCount:").append(this.cUN);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("MsgSvrId:").append(this.cUO);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("MsgCreateTime:").append(this.cUP);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("IsHdImgBool:").append(this.cUQ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ImgSize:").append(this.cUR);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ImgWidth:").append(this.cUS);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ImgHeight:").append(this.cUT);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("StartDownloadTimeStampMs:").append(this.cUU);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("FinishDownloadTimeStampMs:").append(this.cUV);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("FinishCode:").append(this.cUW);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(15830);
        return stringBuffer2;
    }

    public final e Fn() {
        AppMethodBeat.i(15827);
        this.cUU = bo.anU();
        super.aj("StartDownloadTimeStampMs", this.cUU);
        AppMethodBeat.o(15827);
        return this;
    }

    public final e Fo() {
        AppMethodBeat.i(15828);
        this.cUV = bo.anU();
        super.aj("FinishDownloadTimeStampMs", this.cUV);
        AppMethodBeat.o(15828);
        return this;
    }
}
