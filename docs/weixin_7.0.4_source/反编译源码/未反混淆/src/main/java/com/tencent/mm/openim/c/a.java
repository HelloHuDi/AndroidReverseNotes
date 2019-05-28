package com.tencent.mm.openim.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.Map;

public final class a implements o {
    public final void onNewXmlReceived(String str, Map<String, String> map, com.tencent.mm.ai.e.a aVar) {
        AppMethodBeat.i(78916);
        ab.i("MicroMsg.OpenIMChatRoomAddChatRoomMemberReceiver", "onNewXmlReceived() ");
        if (map != null) {
            cm cmVar = aVar.eAB;
            if (bo.gW(cmVar.nao, 10002)) {
                String a = aa.a(cmVar.vED);
                if (bo.isNullOrNil(a)) {
                    ab.w("MicroMsg.OpenIMChatRoomAddChatRoomMemberReceiver", "msg content is null");
                    AppMethodBeat.o(78916);
                    return;
                }
                String a2 = aa.a(cmVar.vEB);
                bi Q = ((j) g.K(j.class)).bOr().Q(a2, cmVar.ptF);
                Object obj = null;
                if (Q.field_msgId > 0) {
                    obj = 1;
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
                if (obj == null) {
                    bf.l(Q);
                    AppMethodBeat.o(78916);
                    return;
                }
                ((j) g.K(j.class)).bOr().b(cmVar.ptF, Q);
                AppMethodBeat.o(78916);
                return;
            }
            ab.i("MicroMsg.OpenIMChatRoomAddChatRoomMemberReceiver", "not new xml type:%d ", Integer.valueOf(cmVar.nao));
        }
        AppMethodBeat.o(78916);
    }
}
