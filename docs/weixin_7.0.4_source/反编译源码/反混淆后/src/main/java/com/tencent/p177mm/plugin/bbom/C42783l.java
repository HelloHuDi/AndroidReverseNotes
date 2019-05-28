package com.tencent.p177mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C26415ao.C9635b.C9636a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p230g.p231a.C45339km;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C28495s;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.plugin.bbom.l */
public final class C42783l implements C28495s<C7254cm> {
    /* renamed from: e */
    public final /* synthetic */ void mo35243e(C1331a c1331a) {
        AppMethodBeat.m2504i(18267);
        final String a = C1946aa.m4148a(((C7254cm) c1331a).vEB);
        if (C1855t.m3896kH(a)) {
            C9638aw.m17190ZK();
            final C7577u ob = C18628c.m29087XV().mo14886ob(a);
            C9638aw.m17190ZK();
            C7616ad aoO = C18628c.m29078XM().aoO(a);
            if (aoO == null || ((int) aoO.ewQ) <= 0) {
                C26417a.flu.mo20966a(a, null, new C9636a() {
                    /* renamed from: o */
                    public final void mo6218o(String str, boolean z) {
                        AppMethodBeat.m2504i(18266);
                        if (ob != null && ob.drU()) {
                            C45339km c45339km = new C45339km();
                            c45339km.cGi.chatroomName = a;
                            c45339km.cGi.cGj = ob.drT();
                            C4879a.xxA.mo10055m(c45339km);
                        }
                        AppMethodBeat.m2505o(18266);
                    }
                });
                AppMethodBeat.m2505o(18267);
                return;
            } else if (ob.drU()) {
                C45339km c45339km = new C45339km();
                c45339km.cGi.chatroomName = a;
                c45339km.cGi.cGj = ob.drT();
                C4879a.xxA.mo10055m(c45339km);
            }
        }
        AppMethodBeat.m2505o(18267);
    }

    /* renamed from: f */
    public final /* synthetic */ void mo35244f(C1331a c1331a) {
        AppMethodBeat.m2504i(18268);
        String a = C1946aa.m4148a(((C7254cm) c1331a).vEB);
        if (!(C5046bo.isNullOrNil(a) || ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoQ(a))) {
            C26417a.flu.mo20967ai(a, "");
        }
        AppMethodBeat.m2505o(18268);
    }
}
