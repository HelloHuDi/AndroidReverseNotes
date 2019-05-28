package com.tencent.p177mm.plugin.wear.model.p1322g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1201e;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1201e.C1198b;
import com.tencent.p177mm.p183ai.C1201e.C1199c;
import com.tencent.p177mm.p230g.p231a.C42077vk;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.wear.model.C43841a;
import com.tencent.p177mm.plugin.wear.model.p1322g.C35562a.C35563a;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.wear.model.g.b */
public final class C22744b implements C1201e {
    /* renamed from: b */
    public final C1198b mo4453b(C1197a c1197a) {
        AppMethodBeat.m2504i(26456);
        C7254cm c7254cm = c1197a.eAB;
        C9638aw.m17190ZK();
        if (C5046bo.isNullOrNil((String) C18628c.m29072Ry().get(2, (Object) ""))) {
            AppMethodBeat.m2505o(26456);
        } else {
            String a = C1946aa.m4148a(c7254cm.vEB);
            String a2 = C1946aa.m4148a(c7254cm.vEC);
            if (C5046bo.isNullOrNil(a) || C5046bo.isNullOrNil(a2)) {
                C4990ab.m7412e("MicroMsg.YoExtension", "neither from-user nor to-user can be empty");
                AppMethodBeat.m2505o(26456);
            } else {
                String a3 = C1946aa.m4148a(c7254cm.vED);
                C4990ab.m7416i("MicroMsg.YoExtension", "from  " + a + "content " + a3);
                C35562a c35562a = C43841a.cUn().tXA;
                synchronized (c35562a.tYO) {
                    try {
                        C42077vk ady = C35562a.ady(a);
                        if (c35562a.tYO.containsKey(a) || ady.cSt.cSu == 1) {
                            C4990ab.m7417i("MicroMsg.wear.WearYoLogic", "Can not add Yo Message %s", a);
                            C42077vk c42077vk = new C42077vk();
                            c42077vk.cSs.cuy = 2;
                            c42077vk.cSs.username = a;
                            C4879a.xxA.mo10055m(c42077vk);
                        } else {
                            C4990ab.m7417i("MicroMsg.wear.WearYoLogic", "Can add Yo Message %s", a);
                            c35562a.tYO.put(a, new C35563a(a, a3));
                        }
                    } finally {
                        AppMethodBeat.m2505o(26456);
                    }
                }
                C43841a.cUn().tXA.cUD();
            }
        }
        return null;
    }

    /* renamed from: a */
    public final void mo4452a(C1199c c1199c) {
    }
}
