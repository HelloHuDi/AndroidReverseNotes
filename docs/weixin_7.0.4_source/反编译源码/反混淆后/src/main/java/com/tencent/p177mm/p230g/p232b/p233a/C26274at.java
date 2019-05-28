package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.at */
public final class C26274at extends C46180a {
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

    /* renamed from: bV */
    public final C26274at mo43958bV(long j) {
        this.cTJ = j;
        return this;
    }

    /* renamed from: fD */
    public final C26274at mo43967fD(String str) {
        AppMethodBeat.m2504i(108869);
        this.cYX = mo74169t("PublishObjectId", str, true);
        AppMethodBeat.m2505o(108869);
        return this;
    }

    /* renamed from: bW */
    public final C26274at mo43959bW(long j) {
        this.cYY = j;
        return this;
    }

    /* renamed from: bX */
    public final C26274at mo43960bX(long j) {
        this.cYZ = j;
        return this;
    }

    /* renamed from: bY */
    public final C26274at mo43961bY(long j) {
        this.dac = j;
        return this;
    }

    /* renamed from: FV */
    public final C26274at mo43954FV() {
        this.dad = 1;
        return this;
    }

    /* renamed from: FW */
    public final C26274at mo43955FW() {
        this.dae = 1;
        return this;
    }

    /* renamed from: bZ */
    public final C26274at mo43962bZ(long j) {
        this.cZd = j;
        return this;
    }

    /* renamed from: ca */
    public final C26274at mo43963ca(long j) {
        this.cZe = j;
        return this;
    }

    /* renamed from: cb */
    public final C26274at mo43964cb(long j) {
        this.daf = j;
        return this;
    }

    /* renamed from: FX */
    public final C26274at mo43956FX() {
        this.dag = 1;
        return this;
    }

    /* renamed from: fE */
    public final C26274at mo43968fE(String str) {
        AppMethodBeat.m2504i(108870);
        this.dai = mo74169t("NewActionTrace", str, true);
        AppMethodBeat.m2505o(108870);
        return this;
    }

    /* renamed from: cc */
    public final C26274at mo43965cc(long j) {
        this.cZm = j;
        return this;
    }

    /* renamed from: FY */
    public final C26274at mo43957FY() {
        this.cZn = 1;
        return this;
    }

    /* renamed from: cd */
    public final C26274at mo43966cd(long j) {
        this.cZp = j;
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(108871);
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
        mo74164VX(str);
        AppMethodBeat.m2505o(108871);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(108872);
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
        AppMethodBeat.m2505o(108872);
        return stringBuffer2;
    }
}
