package com.tencent.mm.ay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.bi;
import java.util.Map;

public final class c extends a {
    public c(Map<String, String> map, bi biVar) {
        super(map, biVar);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean Yt() {
        AppMethodBeat.i(5555);
        if (this.values == null) {
            AppMethodBeat.o(5555);
        } else if (this.TYPE.equals("chatroommuteexpt")) {
            String str = (String) this.values.get(".sysmsg.chatroommuteexpt.link.text");
            String str2 = ((String) this.values.get(".sysmsg.chatroommuteexpt.text")) + str;
            this.fKY.add(str);
            this.fKZ.addFirst(Integer.valueOf(str2.length() - str.length()));
            this.fLa.add(Integer.valueOf(str2.length()));
            this.fKW = str2;
            AppMethodBeat.o(5555);
        } else {
            AppMethodBeat.o(5555);
        }
        return false;
    }
}
