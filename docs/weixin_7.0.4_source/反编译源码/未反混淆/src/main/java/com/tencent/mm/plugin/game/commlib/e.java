package com.tencent.mm.plugin.game.commlib;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.Iterator;
import java.util.LinkedList;

public final class e {
    private static LinkedList<String> mTx = new LinkedList();
    private static final String mTy = ah.getPackageName();
    private static final String mTz = (ah.getPackageName() + ":tools");

    static class a implements com.tencent.mm.ipcinvoker.a {
        private a() {
        }

        public final void a(Object obj, c cVar) {
            AppMethodBeat.i(116985);
            a.bDc();
            AppMethodBeat.o(116985);
        }
    }

    static {
        AppMethodBeat.i(116988);
        mTx.add(mTz);
        AppMethodBeat.o(116988);
    }

    public static void NL(String str) {
        AppMethodBeat.i(116986);
        if (str.equals(mTy) || mTx.contains(str)) {
            a.bDc();
        }
        AppMethodBeat.o(116986);
    }

    public static void bDo() {
        AppMethodBeat.i(116987);
        Iterator it = mTx.iterator();
        while (it.hasNext()) {
            f.a((String) it.next(), null, a.class, null);
        }
        AppMethodBeat.o(116987);
    }
}
