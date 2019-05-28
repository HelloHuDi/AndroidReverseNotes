package com.tencent.p177mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p230g.p231a.C6523mp;
import com.tencent.p177mm.plugin.label.p1277b.C43236c;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.label.d */
public final class C21159d extends C4884c<C6523mp> {
    public C21159d() {
        AppMethodBeat.m2504i(22511);
        this.xxI = C6523mp.class.getName().hashCode();
        AppMethodBeat.m2505o(22511);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(22513);
        boolean aiv = C21159d.aiv();
        AppMethodBeat.m2505o(22513);
        return aiv;
    }

    private static boolean aiv() {
        int i;
        AppMethodBeat.m2504i(22512);
        C9638aw.m17190ZK();
        if (System.currentTimeMillis() - ((Long) C18628c.m29072Ry().get(209408, Long.valueOf(0))).longValue() > 86400000) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            C4990ab.m7416i("MicroMsg.Label.PostTaskGetContactLabelListener", "cpan[callback] get contact label list.");
            C9638aw.m17182Rg().mo14541a(new C43236c(), 0);
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(209408, Long.valueOf((System.currentTimeMillis() - 86400000) + 1800000));
        }
        AppMethodBeat.m2505o(22512);
        return false;
    }
}
