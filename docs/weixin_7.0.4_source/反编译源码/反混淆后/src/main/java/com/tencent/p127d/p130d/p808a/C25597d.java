package com.tencent.p127d.p130d.p808a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p127d.p130d.p131b.C0921d.C0922a;
import com.tencent.p127d.p135f.C45085h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* renamed from: com.tencent.d.d.a.d */
public final class C25597d implements C32111b {
    private final HashSet<Integer> Atd = new HashSet();
    private final List<C0922a> Ate = new ArrayList();

    public C25597d() {
        AppMethodBeat.m2504i(114506);
        AppMethodBeat.m2505o(114506);
    }

    /* renamed from: a */
    public final void mo19822a(C0922a c0922a) {
        AppMethodBeat.m2504i(114507);
        if (c0922a.uid != 0) {
            AppMethodBeat.m2505o(114507);
        } else if (c0922a.Atj != 1 || "/sbin/adbd".equals(c0922a.name)) {
            if (c0922a.Atj > 1 && "sh".equals(c0922a.name) && "/system/bin/sh".equals(c0922a.name)) {
                new StringBuilder("ProcessRelationAnalyzer child : ").append(c0922a.toString());
                C45085h.dQH();
                this.Ate.add(c0922a);
            }
            AppMethodBeat.m2505o(114507);
        } else {
            new StringBuilder("ProcessRelationAnalyzer parent : ").append(c0922a.toString());
            C45085h.dQH();
            this.Atd.add(Integer.valueOf(c0922a.pid));
            AppMethodBeat.m2505o(114507);
        }
    }

    public final boolean dQl() {
        AppMethodBeat.m2504i(114508);
        for (C0922a c0922a : this.Ate) {
            if (this.Atd.contains(Integer.valueOf(c0922a.Atj))) {
                new StringBuilder("ProcessRelationAnalyzer match : ").append(c0922a.toString());
                C45085h.dQG();
                AppMethodBeat.m2505o(114508);
                return true;
            }
        }
        AppMethodBeat.m2505o(114508);
        return false;
    }
}
