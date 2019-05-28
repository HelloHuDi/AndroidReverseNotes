package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.al */
public final class C1585al extends C46180a {
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

    /* renamed from: aX */
    public final C1585al mo4995aX(long j) {
        this.cTJ = j;
        return this;
    }

    /* renamed from: fm */
    public final C1585al mo5009fm(String str) {
        AppMethodBeat.m2504i(108841);
        this.cYX = mo74169t("PublishObjectId", str, true);
        AppMethodBeat.m2505o(108841);
        return this;
    }

    /* renamed from: Fv */
    public final String mo4993Fv() {
        return this.cYX;
    }

    /* renamed from: aY */
    public final C1585al mo4996aY(long j) {
        this.cYY = j;
        return this;
    }

    /* renamed from: aZ */
    public final C1585al mo4997aZ(long j) {
        this.cYZ = j;
        return this;
    }

    /* renamed from: ba */
    public final C1585al mo4998ba(long j) {
        this.cZa = j;
        return this;
    }

    /* renamed from: bb */
    public final C1585al mo4999bb(long j) {
        this.cZb = j;
        return this;
    }

    /* renamed from: bc */
    public final C1585al mo5000bc(long j) {
        this.cVG = j;
        return this;
    }

    /* renamed from: bd */
    public final C1585al mo5001bd(long j) {
        this.cZc = j;
        return this;
    }

    /* renamed from: be */
    public final C1585al mo5002be(long j) {
        this.cZd = j;
        return this;
    }

    /* renamed from: bf */
    public final C1585al mo5003bf(long j) {
        this.cZe = j;
        return this;
    }

    /* renamed from: fn */
    public final C1585al mo5010fn(String str) {
        AppMethodBeat.m2504i(108842);
        this.cZf = mo74169t("MusicId", str, true);
        AppMethodBeat.m2505o(108842);
        return this;
    }

    /* renamed from: bg */
    public final C1585al mo5004bg(long j) {
        this.cZg = j;
        return this;
    }

    /* renamed from: fo */
    public final C1585al mo5011fo(String str) {
        AppMethodBeat.m2504i(108843);
        this.cZh = mo74169t("PositionInfo", str, true);
        AppMethodBeat.m2505o(108843);
        return this;
    }

    /* renamed from: bh */
    public final C1585al mo5005bh(long j) {
        this.cZi = j;
        return this;
    }

    /* renamed from: fp */
    public final C1585al mo5012fp(String str) {
        AppMethodBeat.m2504i(108844);
        this.cZj = mo74169t("PositionLatitude", str, true);
        AppMethodBeat.m2505o(108844);
        return this;
    }

    /* renamed from: fq */
    public final C1585al mo5013fq(String str) {
        AppMethodBeat.m2504i(108845);
        this.cZk = mo74169t("PositionLongitude", str, true);
        AppMethodBeat.m2505o(108845);
        return this;
    }

    /* renamed from: fr */
    public final C1585al mo5014fr(String str) {
        AppMethodBeat.m2504i(108846);
        this.cZl = mo74169t("ActionTrace", str, true);
        AppMethodBeat.m2505o(108846);
        return this;
    }

    /* renamed from: bi */
    public final C1585al mo5006bi(long j) {
        this.cZm = j;
        return this;
    }

    /* renamed from: Fw */
    public final C1585al mo4994Fw() {
        this.cZn = 1;
        return this;
    }

    /* renamed from: bj */
    public final C1585al mo5007bj(long j) {
        this.cZo = j;
        return this;
    }

    /* renamed from: bk */
    public final C1585al mo5008bk(long j) {
        this.cZp = j;
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(108847);
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
        mo74164VX(str);
        AppMethodBeat.m2505o(108847);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(108848);
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
        AppMethodBeat.m2505o(108848);
        return stringBuffer2;
    }
}
