package com.tencent.p177mm.plugin.wenote.model.p585a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

/* renamed from: com.tencent.mm.plugin.wenote.model.a.q */
public final class C29979q implements Serializable {
    public boolean mgQ = false;
    public boolean uOr = false;
    public long uOs = -1;
    public long uOt = -1;
    public String uOu = "";
    public String uOv = "";
    public int uOw = 0;
    public int uOx = 0;

    public final String ddR() {
        AppMethodBeat.m2504i(26684);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("topIsOpenFromSession=").append(this.uOr).append(" topLocalId=").append(this.uOs).append(" topMsgId=").append(this.uOt).append(" topTitle=").append(this.uOu).append(" topNoteXml=").append(this.uOv).append(" topLastPosition=").append(this.uOw).append(" topLastOffset=").append(this.uOx);
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(26684);
        return stringBuilder2;
    }
}
