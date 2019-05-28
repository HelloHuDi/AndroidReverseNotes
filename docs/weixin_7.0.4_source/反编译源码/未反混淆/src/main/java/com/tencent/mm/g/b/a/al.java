package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class al extends a {
    private long cTJ = 0;
    private long cVG = 0;
    private String cYX = "";
    private long cYY = 0;
    private long cYZ = 0;
    private long cZa = 0;
    private long cZb = 0;
    private long cZc = 0;
    private long cZd = 0;
    private long cZe = 0;
    private String cZf = "";
    private long cZg = 0;
    private String cZh = "";
    private long cZi = 0;
    private String cZj = "";
    private String cZk = "";
    private String cZl = "";
    private long cZm = 0;
    private long cZn = 0;
    private long cZo = 0;
    private long cZp = 1;

    public final int getId() {
        return 16638;
    }

    public final al aX(long j) {
        this.cTJ = j;
        return this;
    }

    public final al fm(String str) {
        AppMethodBeat.i(108841);
        this.cYX = t("PublishObjectId", str, true);
        AppMethodBeat.o(108841);
        return this;
    }

    public final String Fv() {
        return this.cYX;
    }

    public final al aY(long j) {
        this.cYY = j;
        return this;
    }

    public final al aZ(long j) {
        this.cYZ = j;
        return this;
    }

    public final al ba(long j) {
        this.cZa = j;
        return this;
    }

    public final al bb(long j) {
        this.cZb = j;
        return this;
    }

    public final al bc(long j) {
        this.cVG = j;
        return this;
    }

    public final al bd(long j) {
        this.cZc = j;
        return this;
    }

    public final al be(long j) {
        this.cZd = j;
        return this;
    }

    public final al bf(long j) {
        this.cZe = j;
        return this;
    }

    public final al fn(String str) {
        AppMethodBeat.i(108842);
        this.cZf = t("MusicId", str, true);
        AppMethodBeat.o(108842);
        return this;
    }

    public final al bg(long j) {
        this.cZg = j;
        return this;
    }

    public final al fo(String str) {
        AppMethodBeat.i(108843);
        this.cZh = t("PositionInfo", str, true);
        AppMethodBeat.o(108843);
        return this;
    }

    public final al bh(long j) {
        this.cZi = j;
        return this;
    }

    public final al fp(String str) {
        AppMethodBeat.i(108844);
        this.cZj = t("PositionLatitude", str, true);
        AppMethodBeat.o(108844);
        return this;
    }

    public final al fq(String str) {
        AppMethodBeat.i(108845);
        this.cZk = t("PositionLongitude", str, true);
        AppMethodBeat.o(108845);
        return this;
    }

    public final al fr(String str) {
        AppMethodBeat.i(108846);
        this.cZl = t("ActionTrace", str, true);
        AppMethodBeat.o(108846);
        return this;
    }

    public final al bi(long j) {
        this.cZm = j;
        return this;
    }

    public final al Fw() {
        this.cZn = 1;
        return this;
    }

    public final al bj(long j) {
        this.cZo = j;
        return this;
    }

    public final al bk(long j) {
        this.cZp = j;
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(108847);
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
        stringBuffer.append(this.cZa);
        stringBuffer.append(str);
        stringBuffer.append(this.cZb);
        stringBuffer.append(str);
        stringBuffer.append(this.cVG);
        stringBuffer.append(str);
        stringBuffer.append(this.cZc);
        stringBuffer.append(str);
        stringBuffer.append(this.cZd);
        stringBuffer.append(str);
        stringBuffer.append(this.cZe);
        stringBuffer.append(str);
        stringBuffer.append(this.cZf);
        stringBuffer.append(str);
        stringBuffer.append(this.cZg);
        stringBuffer.append(str);
        stringBuffer.append(this.cZh);
        stringBuffer.append(str);
        stringBuffer.append(this.cZi);
        stringBuffer.append(str);
        stringBuffer.append(this.cZj);
        stringBuffer.append(str);
        stringBuffer.append(this.cZk);
        stringBuffer.append(str);
        stringBuffer.append(this.cZl);
        stringBuffer.append(str);
        stringBuffer.append(this.cZm);
        stringBuffer.append(str);
        stringBuffer.append(this.cZn);
        stringBuffer.append(str);
        stringBuffer.append(this.cZo);
        stringBuffer.append(str);
        stringBuffer.append(this.cZp);
        str = stringBuffer.toString();
        VX(str);
        AppMethodBeat.o(108847);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(108848);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("NetType:").append(this.cTJ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("PublishObjectId:").append(this.cYX);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("EnterScene:").append(this.cYY);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("EnterTime:").append(this.cYZ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("StartEditTime:").append(this.cZa);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("SendTime:").append(this.cZb);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("VideoDuration:").append(this.cVG);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("VideoSource:").append(this.cZc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("EmojiWidgetCount:").append(this.cZd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("TextWidgetCount:").append(this.cZe);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("MusicId:").append(this.cZf);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("MusicOrder:").append(this.cZg);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("PositionInfo:").append(this.cZh);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("MusicRequestId:").append(this.cZi);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("PositionLatitude:").append(this.cZj);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("PositionLongitude:").append(this.cZk);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ActionTrace:").append(this.cZl);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("VideoObjectId:").append(this.cZm);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("IsClickSearchMusic:").append(this.cZn);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("IsSearchMusic:").append(this.cZo);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("IsPublicTimeLine:").append(this.cZp);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(108848);
        return stringBuffer2;
    }
}
