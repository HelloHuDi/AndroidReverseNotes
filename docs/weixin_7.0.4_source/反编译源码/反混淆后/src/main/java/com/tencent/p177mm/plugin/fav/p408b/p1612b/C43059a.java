package com.tencent.p177mm.plugin.fav.p408b.p1612b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C9306cg;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.fav.b.b.a */
public final class C43059a extends C4884c<C9306cg> {
    public C43059a() {
        AppMethodBeat.m2504i(5317);
        this.xxI = C9306cg.class.getName().hashCode();
        AppMethodBeat.m2505o(5317);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(5318);
        C9306cg c9306cg = (C9306cg) c4883b;
        C4990ab.m7417i("MicroMsg.Fav.DelFavoriteItemListener", "do delete favitem, localId %d", Long.valueOf(c9306cg.cvt.cvv));
        C27966g iE = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(c9306cg.cvt.cvv);
        c9306cg.cvu.cvi = C39037b.m66398i(iE);
        AppMethodBeat.m2505o(5318);
        return false;
    }
}
