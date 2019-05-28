package com.tencent.mm.plugin.emoji.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.ArrayList;
import java.util.Map;

public final class e implements a {
    public final void a(com.tencent.mm.ai.e.a aVar) {
        AppMethodBeat.i(53163);
        cm cmVar = aVar.eAB;
        if (cmVar.nao == 10002) {
            String a = aa.a(cmVar.vED);
            if (bo.isNullOrNil(a)) {
                ab.w("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "msg content is null");
                AppMethodBeat.o(53163);
                return;
            }
            Map z = br.z(a, "sysmsg");
            if (z != null && z.size() > 0) {
                String str = (String) z.get(".sysmsg.$type");
                if (bo.isNullOrNil(str) || !str.equalsIgnoreCase("NewRecommendEmotion")) {
                    ab.e("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "not emoji message type :".concat(String.valueOf(str)));
                } else {
                    ArrayList JG = d.JG(a);
                    j.getEmojiStorageMgr().xYo.duF();
                    j.getEmojiStorageMgr().xYo.ak(JG);
                    AppMethodBeat.o(53163);
                    return;
                }
            }
            AppMethodBeat.o(53163);
            return;
        }
        ab.i("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "not new xml type:%d ", Integer.valueOf(cmVar.nao));
        AppMethodBeat.o(53163);
    }
}
