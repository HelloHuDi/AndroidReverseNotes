package com.tencent.p177mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.HashSet;

/* renamed from: com.tencent.mm.plugin.webview.modeltools.l */
public final class C46433l {
    public HashMap<String, C46432a> upC = new HashMap();
    public HashMap<String, C46432a> upD = new HashMap();
    private HashSet<Integer> upE = new HashSet();

    /* renamed from: com.tencent.mm.plugin.webview.modeltools.l$a */
    public static class C46432a {
        public String desc;
        public String link;
        public String rid;
        public String title;
    }

    public C46433l() {
        AppMethodBeat.m2504i(7031);
        AppMethodBeat.m2505o(7031);
    }

    /* renamed from: bE */
    public final void mo74651bE(int i, String str) {
        AppMethodBeat.m2504i(7032);
        if (C5046bo.getBoolean(str, false)) {
            this.upE.add(Integer.valueOf(i));
            AppMethodBeat.m2505o(7032);
            return;
        }
        this.upE.remove(Integer.valueOf(i));
        AppMethodBeat.m2505o(7032);
    }

    /* renamed from: IS */
    public final boolean mo74650IS(int i) {
        AppMethodBeat.m2504i(7033);
        boolean remove = this.upE.remove(Integer.valueOf(i));
        AppMethodBeat.m2505o(7033);
        return remove;
    }
}
