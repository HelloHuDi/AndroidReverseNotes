package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public final class i {
    public k ptG;

    public i(String str) {
        AppMethodBeat.i(67928);
        this.ptG = new k(str, 10);
        AppMethodBeat.o(67928);
    }

    public final j cQ(String str, int i) {
        AppMethodBeat.i(67929);
        byte[] readFromFile = k.readFromFile(this.ptG.ptQ + cR(str, i));
        if (readFromFile == null || readFromFile.length == 0) {
            AppMethodBeat.o(67929);
            return null;
        }
        try {
            j jVar = (j) new j().parseFrom(readFromFile);
            AppMethodBeat.o(67929);
            return jVar;
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.DraftBoxMgr", e, "", new Object[0]);
            AppMethodBeat.o(67929);
            return null;
        }
    }

    public static String cR(String str, int i) {
        String str2;
        AppMethodBeat.i(67930);
        if (str == null || str.length() == 0) {
            str2 = g.RP().Ry().get(9, null);
        } else {
            str2 = str + "_" + i;
        }
        AppMethodBeat.o(67930);
        return str2;
    }
}
