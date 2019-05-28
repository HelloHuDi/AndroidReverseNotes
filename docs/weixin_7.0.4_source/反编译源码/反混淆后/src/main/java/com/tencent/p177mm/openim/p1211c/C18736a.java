package com.tencent.p177mm.openim.p1211c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C3473o;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import java.util.Map;

/* renamed from: com.tencent.mm.openim.c.a */
public final class C18736a implements C3473o {
    public final void onNewXmlReceived(String str, Map<String, String> map, C1197a c1197a) {
        AppMethodBeat.m2504i(78916);
        C4990ab.m7416i("MicroMsg.OpenIMChatRoomAddChatRoomMemberReceiver", "onNewXmlReceived() ");
        if (map != null) {
            C7254cm c7254cm = c1197a.eAB;
            if (C5046bo.m7563gW(c7254cm.nao, 10002)) {
                String a = C1946aa.m4148a(c7254cm.vED);
                if (C5046bo.isNullOrNil(a)) {
                    C4990ab.m7420w("MicroMsg.OpenIMChatRoomAddChatRoomMemberReceiver", "msg content is null");
                    AppMethodBeat.m2505o(78916);
                    return;
                }
                String a2 = C1946aa.m4148a(c7254cm.vEB);
                C7620bi Q = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15241Q(a2, c7254cm.ptF);
                Object obj = null;
                if (Q.field_msgId > 0) {
                    obj = 1;
                }
                Q.mo14774eI(c7254cm.ptF);
                Q.mo14775eJ(C1829bf.m3764q(a2, (long) c7254cm.pcX));
                Q.setType(10002);
                Q.setContent(a);
                Q.mo14781hO(0);
                Q.mo14794ju(a2);
                Q.mo14791ix(c7254cm.vEG);
                Q.dtR();
                C1829bf.m3743a(Q, c1197a);
                if (obj == null) {
                    C1829bf.m3752l(Q);
                    AppMethodBeat.m2505o(78916);
                    return;
                }
                ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15302b(c7254cm.ptF, Q);
                AppMethodBeat.m2505o(78916);
                return;
            }
            C4990ab.m7417i("MicroMsg.OpenIMChatRoomAddChatRoomMemberReceiver", "not new xml type:%d ", Integer.valueOf(c7254cm.nao));
        }
        AppMethodBeat.m2505o(78916);
    }
}
