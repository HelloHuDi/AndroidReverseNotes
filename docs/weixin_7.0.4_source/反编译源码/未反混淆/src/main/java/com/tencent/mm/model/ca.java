package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.ai.e.c;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.z;
import java.util.Map;

public final class ca implements e {
    public final b b(a aVar) {
        AppMethodBeat.i(16351);
        cm cmVar = aVar.eAB;
        if (cmVar == null) {
            ab.e("MicroMsg.SysNoticeMsgExtension", "onPreAddMessage cmdAM is null");
            AppMethodBeat.o(16351);
        } else {
            try {
                Map z = br.z("<root>" + cmVar.vED + "</root>", "root");
                int intValue = Integer.valueOf((String) z.get(".root.newcount")).intValue();
                int intValue2 = Integer.valueOf((String) z.get(".root.version")).intValue();
                aw.ZK();
                z Ry = c.Ry();
                if (intValue2 == bo.h((Integer) Ry.get(12305, null))) {
                    ab.i("MicroMsg.SysNoticeMsgExtension", "ignore new sys notice count, same version");
                    AppMethodBeat.o(16351);
                } else {
                    Ry.set(12304, Integer.valueOf(intValue));
                    Ry.set(12305, Integer.valueOf(intValue2));
                    AppMethodBeat.o(16351);
                }
            } catch (Exception e) {
                ab.e("MicroMsg.SysNoticeMsgExtension", "exception:%s", bo.l(e));
            }
        }
        return null;
    }

    public final void a(c cVar) {
    }
}
