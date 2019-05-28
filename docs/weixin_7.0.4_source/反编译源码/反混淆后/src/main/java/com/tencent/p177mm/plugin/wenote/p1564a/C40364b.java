package com.tencent.p177mm.plugin.wenote.p1564a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C32599lz;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wenote.model.C29981j;
import com.tencent.p177mm.plugin.wenote.model.C46453c;
import com.tencent.p177mm.protocal.protobuf.abh;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.wenote.a.b */
public final class C40364b extends C4884c<C32599lz> {
    public C40364b() {
        AppMethodBeat.m2504i(26588);
        this.xxI = C32599lz.class.getName().hashCode();
        AppMethodBeat.m2505o(26588);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(26589);
        C32599lz c32599lz = (C32599lz) c4883b;
        if (c32599lz.cHO.cHc) {
            C7060h.pYm.mo8381e(14789, Integer.valueOf(3));
        } else {
            C7060h.pYm.mo8381e(14789, Integer.valueOf(2));
        }
        C4990ab.m7416i("MicroMsg.OpenNoteFromSessionListener", "do OpenNoteFromSessionListener");
        C29981j c29981j = new C29981j();
        C46453c.ddG().uMN = c29981j;
        abh abh = new abh();
        abh.scene = c32599lz.cHO.scene;
        c29981j.mo48223a(c32599lz.cHO.cHP, Long.valueOf(c32599lz.cHO.cvx), c32599lz.cHO.cHc, c32599lz.cHO.context, 0, 0, abh);
        AppMethodBeat.m2505o(26589);
        return false;
    }
}
