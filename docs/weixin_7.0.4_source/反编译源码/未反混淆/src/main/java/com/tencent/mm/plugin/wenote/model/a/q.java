package com.tencent.mm.plugin.wenote.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public final class q implements Serializable {
    public boolean mgQ = false;
    public boolean uOr = false;
    public long uOs = -1;
    public long uOt = -1;
    public String uOu = "";
    public String uOv = "";
    public int uOw = 0;
    public int uOx = 0;

    public final String ddR() {
        AppMethodBeat.i(26684);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("topIsOpenFromSession=").append(this.uOr).append(" topLocalId=").append(this.uOs).append(" topMsgId=").append(this.uOt).append(" topTitle=").append(this.uOu).append(" topNoteXml=").append(this.uOv).append(" topLastPosition=").append(this.uOw).append(" topLastOffset=").append(this.uOx);
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(26684);
        return stringBuilder2;
    }
}
