package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class ap extends a {
    private String cWo = "";
    private int cZA = 0;
    private int cZB = 0;
    private int cZC = 0;
    private String cZD = "";
    private int cZE = 0;
    private int cZF = 0;
    private String cZG = "";
    private long cZH = 0;
    private int cZz = 0;

    public final int getId() {
        return 16887;
    }

    public final ap fw(String str) {
        AppMethodBeat.i(108854);
        this.cWo = t("SessionId", str, true);
        AppMethodBeat.o(108854);
        return this;
    }

    public final ap gJ(int i) {
        this.cZz = i;
        return this;
    }

    public final int FB() {
        return this.cZz;
    }

    public final ap gK(int i) {
        this.cZA = i;
        return this;
    }

    public final ap gL(int i) {
        this.cZB = i;
        return this;
    }

    public final ap gM(int i) {
        this.cZC = i;
        return this;
    }

    public final int FC() {
        return this.cZC;
    }

    public final ap fx(String str) {
        AppMethodBeat.i(108855);
        this.cZD = t("ExposeNewUinList", str, true);
        AppMethodBeat.o(108855);
        return this;
    }

    public final ap gN(int i) {
        this.cZE = i;
        return this;
    }

    public final ap gO(int i) {
        this.cZF = i;
        return this;
    }

    public final int FD() {
        return this.cZF;
    }

    public final ap fy(String str) {
        AppMethodBeat.i(108856);
        this.cZG = t("ExposeBeforeUinList", str, true);
        AppMethodBeat.o(108856);
        return this;
    }

    public final ap bD(long j) {
        this.cZH = j;
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(108857);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cWo);
        stringBuffer.append(str);
        stringBuffer.append(this.cZz);
        stringBuffer.append(str);
        stringBuffer.append(this.cZA);
        stringBuffer.append(str);
        stringBuffer.append(this.cZB);
        stringBuffer.append(str);
        stringBuffer.append(this.cZC);
        stringBuffer.append(str);
        stringBuffer.append(this.cZD);
        stringBuffer.append(str);
        stringBuffer.append(this.cZE);
        stringBuffer.append(str);
        stringBuffer.append(this.cZF);
        stringBuffer.append(str);
        stringBuffer.append(this.cZG);
        stringBuffer.append(str);
        stringBuffer.append(this.cZH);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(108857);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(108858);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionId:").append(this.cWo);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ExposeViewId:").append(this.cZz);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ExposeOrder:").append(this.cZA);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ExposeNewUinCount:").append(this.cZB);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ExposeNewFavorUinCount:").append(this.cZC);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ExposeNewUinList:").append(this.cZD);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ExposeBeforeUinCount:").append(this.cZE);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ExposeBeforeFavorUinCount:").append(this.cZF);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ExposeBeforeUinList:").append(this.cZG);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("InteractiveUserCount:").append(this.cZH);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(108858);
        return stringBuffer2;
    }
}
