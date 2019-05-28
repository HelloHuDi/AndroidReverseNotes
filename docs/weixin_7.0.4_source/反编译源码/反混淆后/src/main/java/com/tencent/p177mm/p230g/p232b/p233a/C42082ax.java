package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.ax */
public final class C42082ax extends C46180a {
    private long cYQ = 0;
    private String cZJ = "";
    private long cZK = 0;
    private long dau = 0;
    private long dav = 0;

    public final int getId() {
        return 17090;
    }

    /* renamed from: fN */
    public final C42082ax mo67598fN(String str) {
        AppMethodBeat.m2504i(138741);
        this.cZJ = mo74169t("StoryId", str, true);
        AppMethodBeat.m2505o(138741);
        return this;
    }

    /* renamed from: ck */
    public final C42082ax mo67594ck(long j) {
        this.dau = j;
        return this;
    }

    /* renamed from: cl */
    public final C42082ax mo67595cl(long j) {
        this.cYQ = j;
        return this;
    }

    /* renamed from: cm */
    public final C42082ax mo67596cm(long j) {
        this.cZK = j;
        return this;
    }

    /* renamed from: cn */
    public final C42082ax mo67597cn(long j) {
        this.dav = j;
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(138742);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cZJ);
        stringBuffer.append(str);
        stringBuffer.append(this.dau);
        stringBuffer.append(str);
        stringBuffer.append(this.cYQ);
        stringBuffer.append(str);
        stringBuffer.append(this.cZK);
        stringBuffer.append(str);
        stringBuffer.append(this.dav);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(138742);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(138743);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("StoryId:").append(this.cZJ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("VideoType:").append(this.dau);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("PreviewEnterScene:").append(this.cYQ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ProfileSource:").append(this.cZK);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("IsAlbumStarButton:").append(this.dav);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(138743);
        return stringBuffer2;
    }
}
