package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class at extends a {
    private long cTJ = 0;
    private String cYX = "";
    private long cYY = 0;
    private long cYZ = 0;
    private long cZd = 0;
    private long cZe = 0;
    private long cZm = 0;
    private long cZn = 0;
    private long cZp = 0;
    private long dac = 0;
    private long dad = 0;
    private long dae = 0;
    private long daf = 0;
    private long dag = 0;
    private long dah = 0;
    private String dai = "";

    public final int getId() {
        return 16639;
    }

    public final at bV(long j) {
        this.cTJ = j;
        return this;
    }

    public final at fD(String str) {
        AppMethodBeat.i(108869);
        this.cYX = t("PublishObjectId", str, true);
        AppMethodBeat.o(108869);
        return this;
    }

    public final at bW(long j) {
        this.cYY = j;
        return this;
    }

    public final at bX(long j) {
        this.cYZ = j;
        return this;
    }

    public final at bY(long j) {
        this.dac = j;
        return this;
    }

    public final at FV() {
        this.dad = 1;
        return this;
    }

    public final at FW() {
        this.dae = 1;
        return this;
    }

    public final at bZ(long j) {
        this.cZd = j;
        return this;
    }

    public final at ca(long j) {
        this.cZe = j;
        return this;
    }

    public final at cb(long j) {
        this.daf = j;
        return this;
    }

    public final at FX() {
        this.dag = 1;
        return this;
    }

    public final at fE(String str) {
        AppMethodBeat.i(108870);
        this.dai = t("NewActionTrace", str, true);
        AppMethodBeat.o(108870);
        return this;
    }

    public final at cc(long j) {
        this.cZm = j;
        return this;
    }

    public final at FY() {
        this.cZn = 1;
        return this;
    }

    public final at cd(long j) {
        this.cZp = j;
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(108871);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cTJ);
        stringBuffer.append(str);
        stringBuffer.append(this.cYX);
        stringBuffer.append(str);
        stringBuffer.append(this.cYY);
        stringBuffer.append(str);
        stringBuffer.append(this.cYZ);
        stringBuffer.append(str);
        stringBuffer.append(this.dac);
        stringBuffer.append(str);
        stringBuffer.append(this.dad);
        stringBuffer.append(str);
        stringBuffer.append(this.dae);
        stringBuffer.append(str);
        stringBuffer.append(this.cZd);
        stringBuffer.append(str);
        stringBuffer.append(this.cZe);
        stringBuffer.append(str);
        stringBuffer.append(this.daf);
        stringBuffer.append(str);
        stringBuffer.append(this.dag);
        stringBuffer.append(str);
        stringBuffer.append(this.dah);
        stringBuffer.append(str);
        stringBuffer.append(this.dai);
        stringBuffer.append(str);
        stringBuffer.append(this.cZm);
        stringBuffer.append(str);
        stringBuffer.append(this.cZn);
        stringBuffer.append(str);
        stringBuffer.append(this.cZp);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(108871);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(108872);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("NetType:").append(this.cTJ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("PublishObjectId:").append(this.cYX);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("EnterScene:").append(this.cYY);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("EnterTime:").append(this.cYZ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("QuitTime:").append(this.dac);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("HasRecordVideo:").append(this.dad);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("HasEnterAllbum:").append(this.dae);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("EmojiWidgetCount:").append(this.cZd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("TextWidgetCount:").append(this.cZe);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("isAddMusic:").append(this.daf);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("isAddPosition:").append(this.dag);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ActionTrace:").append(this.dah);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("NewActionTrace:").append(this.dai);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("VideoObjectId:").append(this.cZm);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("IsClickSearchMusic:").append(this.cZn);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("IsPublicTimeLine:").append(this.cZp);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(108872);
        return stringBuffer2;
    }
}
