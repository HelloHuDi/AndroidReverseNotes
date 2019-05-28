package com.tencent.p177mm.plugin.emoji.p727g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.ArrayList;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.emoji.g.e */
public final class C45858e implements C1837a {
    /* renamed from: a */
    public final void mo5414a(C1197a c1197a) {
        AppMethodBeat.m2504i(53163);
        C7254cm c7254cm = c1197a.eAB;
        if (c7254cm.nao == 10002) {
            String a = C1946aa.m4148a(c7254cm.vED);
            if (C5046bo.isNullOrNil(a)) {
                C4990ab.m7420w("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "msg content is null");
                AppMethodBeat.m2505o(53163);
                return;
            }
            Map z = C5049br.m7595z(a, "sysmsg");
            if (z != null && z.size() > 0) {
                String str = (String) z.get(".sysmsg.$type");
                if (C5046bo.isNullOrNil(str) || !str.equalsIgnoreCase("NewRecommendEmotion")) {
                    C4990ab.m7412e("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "not emoji message type :".concat(String.valueOf(str)));
                } else {
                    ArrayList JG = C20377d.m31543JG(a);
                    C42952j.getEmojiStorageMgr().xYo.duF();
                    C42952j.getEmojiStorageMgr().xYo.mo74767ak(JG);
                    AppMethodBeat.m2505o(53163);
                    return;
                }
            }
            AppMethodBeat.m2505o(53163);
            return;
        }
        C4990ab.m7417i("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "not new xml type:%d ", Integer.valueOf(c7254cm.nao));
        AppMethodBeat.m2505o(53163);
    }
}
