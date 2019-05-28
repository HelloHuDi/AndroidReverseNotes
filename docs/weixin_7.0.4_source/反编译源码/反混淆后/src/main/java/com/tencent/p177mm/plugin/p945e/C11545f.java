package com.tencent.p177mm.plugin.p945e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C45290m;
import com.tencent.p177mm.compatible.util.C1449k;
import com.tencent.p177mm.kernel.p238a.p715c.C42148a;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.sight.base.C29014b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.e.f */
public final class C11545f extends C42148a {
    public final void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(18528);
        int Lw = C45290m.m83509Lw();
        if ((Lw & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            C4990ab.m7417i("MicroMsg.SightInitTask", "load wechatsight_v7a, core number[%d]", Integer.valueOf(Lw >> 12));
            C1449k.m3079a("wechatsight_v7a", getClass().getClassLoader());
            if ((Lw >> 12) >= 4) {
                C29014b.qwW = 3;
                C29014b.qwY = 3;
                C29014b.qwZ = 544000;
                AppMethodBeat.m2505o(18528);
                return;
            }
            C29014b.qwW = 1;
            C29014b.qwY = 1;
            C29014b.qwZ = 640000;
            AppMethodBeat.m2505o(18528);
            return;
        }
        C4990ab.m7416i("MicroMsg.SightInitTask", "load wechatsight");
        C1449k.m3079a("wechatsight", getClass().getClassLoader());
        Assert.assertTrue("Can't remove libwechatsight.so yet.", false);
        C29014b.qwW = 1;
        C29014b.qwY = 1;
        C29014b.qwZ = 640000;
        AppMethodBeat.m2505o(18528);
    }

    public final String name() {
        return "boot-sight-init";
    }
}
