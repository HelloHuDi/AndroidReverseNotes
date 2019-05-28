package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.g.a.je;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class b implements e {
    public final com.tencent.mm.ai.e.b b(a aVar) {
        AppMethodBeat.i(27234);
        cm cmVar = aVar.eAB;
        if (cmVar == null || cmVar.nao != 47) {
            ab.f("MicroMsg.EmojiExtension", "parseEmojiMsg failed, invalid cmdAM");
            AppMethodBeat.o(27234);
        } else {
            String a = aa.a(cmVar.vEB);
            String a2 = aa.a(cmVar.vEC);
            aw.ZK();
            if (!((String) c.Ry().get(2, null)).equals(a)) {
                a2 = a;
            }
            ((d) g.M(d.class)).getEmojiMgr().a(a2, aa.a(cmVar.vED), cmVar.ptF, cmVar.vEG, aVar);
            com.tencent.mm.model.bf.b oE = bf.oE(cmVar.vEG);
            if (oE != null) {
                ab.i("MicroMsg.EmojiExtension", "bizClientMsgId = %s", oE.fmt);
                if (oE.fmx != null && oE.scene == 1) {
                    a2 = aa.a(cmVar.vEB);
                    aw.ZK();
                    c.Ry().set(73729, Integer.valueOf(1));
                    com.tencent.mm.storage.bf bfVar = new com.tencent.mm.storage.bf();
                    bfVar.field_content = ah.getContext().getString(R.string.d5d);
                    bfVar.field_createtime = bo.anT();
                    bfVar.field_imgpath = "";
                    bfVar.field_sayhicontent = bfVar.field_content;
                    bfVar.field_sayhiuser = a2;
                    bfVar.field_scene = 18;
                    bfVar.field_status = cmVar.jBT > 3 ? cmVar.jBT : 3;
                    bfVar.field_svrid = cmVar.ptF;
                    bfVar.field_talker = a2;
                    bfVar.field_type = cmVar.nao;
                    bfVar.field_isSend = 0;
                    bfVar.field_sayhiencryptuser = a2;
                    bfVar.field_ticket = oE.fmx;
                    com.tencent.mm.bi.d.akQ().a(bfVar);
                    je jeVar = new je();
                    jeVar.cEq.cEr = a2;
                    com.tencent.mm.sdk.b.a.xxA.m(jeVar);
                }
            }
            AppMethodBeat.o(27234);
        }
        return null;
    }

    public final void a(e.c cVar) {
    }
}
