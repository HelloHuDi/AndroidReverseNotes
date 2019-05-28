package com.tencent.p127d.p130d.p808a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p127d.p130d.p131b.C0921d.C0922a;
import com.tencent.p127d.p135f.C45085h;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.d.d.a.c */
public final class C37316c implements C32111b {
    private final List<C0922a> Atc = new ArrayList();

    public C37316c() {
        AppMethodBeat.m2504i(114503);
        AppMethodBeat.m2505o(114503);
    }

    /* renamed from: a */
    public final void mo19822a(C0922a c0922a) {
        AppMethodBeat.m2504i(114504);
        if (c0922a.uid != 0) {
            AppMethodBeat.m2505o(114504);
        } else if (TextUtils.isEmpty(c0922a.Atk) || !"u:r:zygote:s0".equals(c0922a.Atk)) {
            AppMethodBeat.m2505o(114504);
        } else if (TextUtils.isEmpty(c0922a.name) || "zygote".equals(c0922a.name) || "zygote64".equals(c0922a.name)) {
            AppMethodBeat.m2505o(114504);
        } else {
            new StringBuilder("JavaProcessAnalyzer match : ").append(c0922a.toString());
            C45085h.dQG();
            this.Atc.add(c0922a);
            AppMethodBeat.m2505o(114504);
        }
    }

    public final boolean dQl() {
        AppMethodBeat.m2504i(114505);
        if (this.Atc.size() > 0) {
            AppMethodBeat.m2505o(114505);
            return true;
        }
        AppMethodBeat.m2505o(114505);
        return false;
    }
}
