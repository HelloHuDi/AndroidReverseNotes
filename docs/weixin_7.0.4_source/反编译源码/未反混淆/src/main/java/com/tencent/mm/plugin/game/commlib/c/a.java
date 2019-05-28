package com.tencent.mm.plugin.game.commlib.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;

public final class a {
    private static LinkedList<b> ilQ = new LinkedList();

    static {
        AppMethodBeat.i(59423);
        AppMethodBeat.o(59423);
    }

    public static void a(b bVar) {
        AppMethodBeat.i(59421);
        ilQ.add(bVar);
        AppMethodBeat.o(59421);
    }

    public static void bny() {
        AppMethodBeat.i(59422);
        Iterator it = ilQ.iterator();
        while (it.hasNext()) {
            ((b) it.next()).Pi();
        }
        AppMethodBeat.o(59422);
    }
}
