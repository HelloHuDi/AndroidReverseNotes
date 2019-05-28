package com.tencent.p177mm.model.p1207a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1201e;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1201e.C1198b;
import com.tencent.p177mm.p183ai.C1201e.C1199c;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.model.a.d */
public final class C45436d implements C1201e {
    /* renamed from: b */
    public final C1198b mo4453b(C1197a c1197a) {
        AppMethodBeat.m2504i(118144);
        C7254cm c7254cm = c1197a.eAB;
        if (c7254cm == null || c7254cm.vED == null) {
            C4990ab.m7414f("MicroMsg.abtest.AbTestMsgExtension", "[Abtest] AbTestMsgExtension failed, invalid cmdAM");
            AppMethodBeat.m2505o(118144);
        } else {
            Object a = C1946aa.m4148a(c7254cm.vED);
            C1720g.m3536RP().mo5239Ry().set(328193, a);
            C37900c aaK = C26407g.aaK();
            long currentTimeMillis = System.currentTimeMillis();
            try {
                aaK.mo60655oQ(a);
                String str = (String) C1720g.m3536RP().mo5239Ry().get(328197, null);
                if (C5046bo.isNullOrNil(str) || !(aaK.fnW == null || str.equals(aaK.fnW.fnS))) {
                    C1720g.m3536RP().mo5239Ry().set(328197, aaK.fnW.fnS);
                    C1720g.m3536RP().mo5239Ry().set(328195, Boolean.FALSE);
                    C1720g.m3536RP().mo5239Ry().set(328194, Boolean.FALSE);
                    C1720g.m3536RP().mo5239Ry().set(328196, Boolean.FALSE);
                    C4990ab.m7416i("MicroMsg.abtest.AbTestManager", "[cpan] new case id or new case id , reset click value.");
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.abtest.AbTestManager", "[Abtest] updateAbTestCase exception:%s", e.toString());
            }
            C4990ab.m7417i("MicroMsg.abtest.AbTestManager", "[Abtest] update use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            if (C26407g.aaK().aaI()) {
                C18608f.m29043oS(C26407g.aaK().fnW.fnS);
            }
            AppMethodBeat.m2505o(118144);
        }
        return null;
    }

    /* renamed from: a */
    public final void mo4452a(C1199c c1199c) {
    }
}
