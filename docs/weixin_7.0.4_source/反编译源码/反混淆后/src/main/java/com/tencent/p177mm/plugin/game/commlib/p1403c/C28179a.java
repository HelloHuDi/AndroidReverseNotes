package com.tencent.p177mm.plugin.game.commlib.p1403c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.game.commlib.c.a */
public final class C28179a {
    private static LinkedList<C39182b> ilQ = new LinkedList();

    static {
        AppMethodBeat.m2504i(59423);
        AppMethodBeat.m2505o(59423);
    }

    /* renamed from: a */
    public static void m44758a(C39182b c39182b) {
        AppMethodBeat.m2504i(59421);
        ilQ.add(c39182b);
        AppMethodBeat.m2505o(59421);
    }

    public static void bny() {
        AppMethodBeat.m2504i(59422);
        Iterator it = ilQ.iterator();
        while (it.hasNext()) {
            ((C39182b) it.next()).mo38820Pi();
        }
        AppMethodBeat.m2505o(59422);
    }
}
