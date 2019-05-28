package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

public final class a implements com.tencent.mm.model.bz.a {
    public final void a(com.tencent.mm.ai.e.a aVar) {
        AppMethodBeat.i(103956);
        cm cmVar = aVar.eAB;
        if (cmVar.nao == 10002) {
            String a = aa.a(cmVar.vED);
            if (bo.isNullOrNil(a)) {
                ab.w("MicroMsg.ChatroomAccessVerifySysCmdMsgListener", "msg content is null");
                AppMethodBeat.o(103956);
                return;
            }
            int i;
            String a2 = aa.a(cmVar.vEB);
            bi Q = ((j) g.K(j.class)).bOr().Q(a2, cmVar.ptF);
            if (Q.field_msgId > 0) {
                i = 1;
            } else {
                i = 0;
            }
            Q.eI(cmVar.ptF);
            Q.eJ(bf.q(a2, (long) cmVar.pcX));
            Q.setType(10002);
            Q.setContent(a);
            Q.hO(0);
            Q.ju(a2);
            Q.ix(cmVar.vEG);
            Q.dtR();
            bf.a(Q, aVar);
            if (i == 0) {
                bf.l(Q);
                AppMethodBeat.o(103956);
                return;
            }
            ((j) g.K(j.class)).bOr().b(cmVar.ptF, Q);
            AppMethodBeat.o(103956);
            return;
        }
        ab.i("MicroMsg.ChatroomAccessVerifySysCmdMsgListener", "not new xml type:%d ", Integer.valueOf(cmVar.nao));
        AppMethodBeat.o(103956);
    }
}
