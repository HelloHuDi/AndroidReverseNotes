package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.clm;
import com.tencent.mm.protocal.protobuf.cln;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.List;

public final class s extends m implements k {
    private final b ehh;
    private f ehi;
    private int gvO;
    private List<String> kXe = new ArrayList();

    public s(List<String> list, int i) {
        AppMethodBeat.i(53153);
        a aVar = new a();
        aVar.fsJ = new clm();
        aVar.fsK = new cln();
        aVar.uri = "/cgi-bin/micromsg-bin/mmuploadmypanellist";
        aVar.fsI = 717;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        this.kXe = list;
        this.gvO = i;
        AppMethodBeat.o(53153);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(53154);
        ab.i("MicroMsg.emoji.NetSceneUploadMyPanelList", "errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            g.RP().Ry().set(ac.a.USERINFO_EMOJI_SYNC_STORE_EMOJI_UPLODD_LONG, Long.valueOf(System.currentTimeMillis()));
            g.RP().Ry().set(ac.a.USERINFO_EMOJI_SYNC_STORE_EMOJI_UPLODD_FINISH_BOOLEAN, Boolean.TRUE);
            h.pYm.a(165, 0, 1, false);
        } else {
            g.RP().Ry().set(ac.a.USERINFO_EMOJI_SYNC_STORE_EMOJI_UPLODD_LONG, Long.valueOf((System.currentTimeMillis() - 86400000) + 3600000));
            h.pYm.a(165, 1, 1, false);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(53154);
    }

    public final int getType() {
        return 717;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(53155);
        this.ehi = fVar;
        clm clm = (clm) this.ehh.fsG.fsP;
        clm.OpCode = this.gvO;
        if (this.kXe != null) {
            for (Object obj : this.kXe) {
                Object obj2;
                if (!bo.isNullOrNil(obj2) && obj2.equals(String.valueOf(EmojiGroupInfo.yar))) {
                    obj2 = "com.tencent.xin.emoticon.tusiji";
                }
                clm.xjj.add(obj2);
                ab.d("MicroMsg.emoji.NetSceneUploadMyPanelList", "product id is:%s", obj2);
            }
            ab.i("MicroMsg.emoji.NetSceneUploadMyPanelList", "opcode is:%d mProductIdList size:%s", Integer.valueOf(this.gvO), Integer.valueOf(this.kXe.size()));
        }
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(53155);
        return a;
    }
}
