package com.tencent.p177mm.plugin.zero.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1449k;
import com.tencent.p177mm.kernel.p238a.p715c.C42148a;
import com.tencent.p177mm.kernel.p241b.C1681g;

/* renamed from: com.tencent.mm.plugin.zero.tasks.b */
public final class C35782b extends C42148a {
    public final void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(58786);
        C1449k.m3079a("commonimgdec", getClass().getClassLoader());
        C1449k.m3079a("wechatcommon", getClass().getClassLoader());
        AppMethodBeat.m2505o(58786);
    }

    public final String name() {
        return "boot-load-wechatcommon-library";
    }
}
