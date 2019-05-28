package com.tencent.mm.plugin.wear.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.g.a.vk;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class b implements e {
    public final com.tencent.mm.ai.e.b b(a aVar) {
        AppMethodBeat.i(26456);
        cm cmVar = aVar.eAB;
        aw.ZK();
        if (bo.isNullOrNil((String) c.Ry().get(2, (Object) ""))) {
            AppMethodBeat.o(26456);
        } else {
            String a = aa.a(cmVar.vEB);
            String a2 = aa.a(cmVar.vEC);
            if (bo.isNullOrNil(a) || bo.isNullOrNil(a2)) {
                ab.e("MicroMsg.YoExtension", "neither from-user nor to-user can be empty");
                AppMethodBeat.o(26456);
            } else {
                String a3 = aa.a(cmVar.vED);
                ab.i("MicroMsg.YoExtension", "from  " + a + "content " + a3);
                a aVar2 = com.tencent.mm.plugin.wear.model.a.cUn().tXA;
                synchronized (aVar2.tYO) {
                    try {
                        vk ady = a.ady(a);
                        if (aVar2.tYO.containsKey(a) || ady.cSt.cSu == 1) {
                            ab.i("MicroMsg.wear.WearYoLogic", "Can not add Yo Message %s", a);
                            vk vkVar = new vk();
                            vkVar.cSs.cuy = 2;
                            vkVar.cSs.username = a;
                            com.tencent.mm.sdk.b.a.xxA.m(vkVar);
                        } else {
                            ab.i("MicroMsg.wear.WearYoLogic", "Can add Yo Message %s", a);
                            aVar2.tYO.put(a, new a(a, a3));
                        }
                    } finally {
                        AppMethodBeat.o(26456);
                    }
                }
                com.tencent.mm.plugin.wear.model.a.cUn().tXA.cUD();
            }
        }
        return null;
    }

    public final void a(e.c cVar) {
    }
}
