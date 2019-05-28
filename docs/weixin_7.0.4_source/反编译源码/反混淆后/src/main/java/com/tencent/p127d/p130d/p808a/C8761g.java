package com.tencent.p127d.p130d.p808a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p127d.p130d.p131b.C0921d.C0922a;
import com.tencent.p127d.p135f.C45085h;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: com.tencent.d.d.a.g */
public final class C8761g implements C32111b {
    private final List<C0922a> Atc = new ArrayList();
    private final Pattern yNM = Pattern.compile("^/system/xbin/ku\\.sud$|^daemonsu:|^k_worker/[1-9]\\d*:[1-9]\\d*$|^kr_worker/[1-9]\\d*:[1-9]\\d*$|^km_worker/[1-9]\\d*:[1-9]\\d*$|^tworker/[1-9]\\d*:[1-9]\\d*$|^tu_worker/[1-9]\\d*:[1-9]\\d*$|^tq_worker/[1-9]\\d*:[1-9]\\d*$|^kworker/[1-9]\\d{2}$|^permmgrd$|^360sguard$|^/data/data/[\\w\\-\\.]+/");

    public C8761g() {
        AppMethodBeat.m2504i(114512);
        AppMethodBeat.m2505o(114512);
    }

    /* renamed from: a */
    public final void mo19822a(C0922a c0922a) {
        AppMethodBeat.m2504i(114513);
        if (c0922a.uid != 0) {
            AppMethodBeat.m2505o(114513);
        } else if (c0922a.Atj != 1) {
            AppMethodBeat.m2505o(114513);
        } else {
            this.Atc.add(c0922a);
            AppMethodBeat.m2505o(114513);
        }
    }

    public final boolean dQl() {
        AppMethodBeat.m2504i(114514);
        for (C0922a c0922a : this.Atc) {
            new StringBuilder("SingleProcessAnalyzer : ").append(c0922a.toString());
            C45085h.dQH();
            if (c0922a.name != null && this.yNM.matcher(c0922a.name).find()) {
                new StringBuilder("SingleProcessAnalyzer match : ").append(c0922a.toString());
                C45085h.dQG();
                AppMethodBeat.m2505o(114514);
                return true;
            }
        }
        AppMethodBeat.m2505o(114514);
        return false;
    }
}
