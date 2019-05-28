package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;

public final class c extends com.tencent.mm.plugin.report.a {
    private String cTx = "";
    public long cTy = 0;
    public a cTz;

    public enum a {
        NoDownLoad(0),
        DownLoading(1),
        DownLoaded(2),
        DownLoadFail(3);
        
        final int value;

        static {
            AppMethodBeat.o(128635);
        }

        private a(int i) {
            this.value = i;
        }
    }

    public final int getId() {
        return 15586;
    }

    public final c eq(String str) {
        AppMethodBeat.i(128636);
        this.cTx = t("Url", str, true);
        AppMethodBeat.o(128636);
        return this;
    }

    public final String Fj() {
        int i;
        AppMethodBeat.i(128637);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cTx);
        stringBuffer.append(str);
        stringBuffer.append(this.cTy);
        stringBuffer.append(str);
        if (this.cTz != null) {
            i = this.cTz.value;
        } else {
            i = -1;
        }
        stringBuffer.append(i);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(128637);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(128638);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Url:").append(this.cTx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("DownLoadCostStampMs:").append(this.cTy);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("PreLoadStatus:").append(this.cTz);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(128638);
        return stringBuffer2;
    }
}
