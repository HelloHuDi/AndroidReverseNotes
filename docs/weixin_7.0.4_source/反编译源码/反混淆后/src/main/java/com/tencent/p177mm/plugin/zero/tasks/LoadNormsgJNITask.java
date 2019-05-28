package com.tencent.p177mm.plugin.zero.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1449k;
import com.tencent.p177mm.kernel.p238a.p715c.C42148a;
import com.tencent.p177mm.kernel.p241b.C1681g;

/* renamed from: com.tencent.mm.plugin.zero.tasks.LoadNormsgJNITask */
public final class LoadNormsgJNITask extends C42148a {
    public final void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(58780);
        C1449k.m3079a("stlport_shared", getClass().getClassLoader());
        C1449k.m3079a("wechatxlog", getClass().getClassLoader());
        C1449k.m3079a("wechatnormsg", getClass().getClassLoader());
        AppMethodBeat.m2505o(58780);
    }

    public final String name() {
        return "boot-load-wechatnormsg-library";
    }
}
