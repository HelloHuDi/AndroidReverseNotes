package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class ax extends a {
    private long cYQ = 0;
    private String cZJ = "";
    private long cZK = 0;
    private long dau = 0;
    private long dav = 0;

    public final int getId() {
        return 17090;
    }

    public final ax fN(String str) {
        AppMethodBeat.i(138741);
        this.cZJ = t("StoryId", str, true);
        AppMethodBeat.o(138741);
        return this;
    }

    public final ax ck(long j) {
        this.dau = j;
        return this;
    }

    public final ax cl(long j) {
        this.cYQ = j;
        return this;
    }

    public final ax cm(long j) {
        this.cZK = j;
        return this;
    }

    public final ax cn(long j) {
        this.dav = j;
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(138742);
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
        VX(str);
        AppMethodBeat.o(138742);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(138743);
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
        AppMethodBeat.o(138743);
        return stringBuffer2;
    }
}
