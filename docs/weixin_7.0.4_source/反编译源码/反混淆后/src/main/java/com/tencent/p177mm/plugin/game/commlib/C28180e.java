package com.tencent.p177mm.plugin.game.commlib;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.game.commlib.e */
public final class C28180e {
    private static LinkedList<String> mTx = new LinkedList();
    private static final String mTy = C4996ah.getPackageName();
    private static final String mTz = (C4996ah.getPackageName() + ":tools");

    /* renamed from: com.tencent.mm.plugin.game.commlib.e$a */
    static class C3219a implements C37866a {
        private C3219a() {
        }

        /* renamed from: a */
        public final void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(116985);
            C45985a.bDc();
            AppMethodBeat.m2505o(116985);
        }
    }

    static {
        AppMethodBeat.m2504i(116988);
        mTx.add(mTz);
        AppMethodBeat.m2505o(116988);
    }

    /* renamed from: NL */
    public static void m44759NL(String str) {
        AppMethodBeat.m2504i(116986);
        if (str.equals(mTy) || mTx.contains(str)) {
            C45985a.bDc();
        }
        AppMethodBeat.m2505o(116986);
    }

    public static void bDo() {
        AppMethodBeat.m2504i(116987);
        Iterator it = mTx.iterator();
        while (it.hasNext()) {
            C9549f.m17012a((String) it.next(), null, C3219a.class, null);
        }
        AppMethodBeat.m2505o(116987);
    }
}
