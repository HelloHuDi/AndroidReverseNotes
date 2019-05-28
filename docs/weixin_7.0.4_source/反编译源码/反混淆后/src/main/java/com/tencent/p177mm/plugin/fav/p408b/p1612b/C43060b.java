package com.tencent.p177mm.plugin.fav.p408b.p1612b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C37432o;
import com.tencent.p177mm.p230g.p231a.C45326gg;
import com.tencent.p177mm.plugin.fav.p407a.C39036aj;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.fav.b.b.b */
public final class C43060b extends C4884c<C45326gg> {
    public C43060b() {
        AppMethodBeat.m2504i(5319);
        this.xxI = C45326gg.class.getName().hashCode();
        AppMethodBeat.m2505o(5319);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(5320);
        C45326gg c45326gg = (C45326gg) c4883b;
        C4990ab.m7418v("MicroMsg.FavNotifyListener", "deal with fav notify");
        if (((C7604ae) C1720g.m3530M(C7604ae.class)).getSendService().ame()) {
            C4990ab.m7420w("MicroMsg.FavNotifyListener", "sending item, do not do sync");
            AppMethodBeat.m2505o(5320);
        } else {
            int i;
            byte[] bArr = c45326gg.cAF.cAG;
            if (bArr == null) {
                i = 1;
            } else {
                i = C37432o.m63092t(bArr, 0);
            }
            C1720g.m3540Rg().mo14541a(new C39036aj(i), 0);
            AppMethodBeat.m2505o(5320);
        }
        return false;
    }
}
