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
import com.tencent.mm.protocal.protobuf.gm;
import com.tencent.mm.protocal.protobuf.gn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac;
import java.util.LinkedList;
import java.util.List;

public final class c extends m implements k {
    public final b ehh;
    private f ehi;
    public int gvO;
    private int kWn;
    private List<String> kWo;

    public c(int i, int i2, List<String> list) {
        AppMethodBeat.i(53096);
        a aVar = new a();
        aVar.fsJ = new gm();
        aVar.fsK = new gn();
        aVar.uri = "/cgi-bin/micromsg-bin/mmbackupemojioperate";
        this.ehh = aVar.acD();
        this.kWn = i;
        this.gvO = i2;
        this.kWo = list;
        AppMethodBeat.o(53096);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(53097);
        ab.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i3 == -434) {
            ab.w("MicroMsg.emoji.NetSceneBackupEmojiOperate", "[cpan] batch backup emoji failed. over size.");
            g.RP().Ry().set(ac.a.USERINFO_EMOJI_BACKUP_OVERSIZE_BOOLEAN, Boolean.TRUE);
            h.pYm.a(164, 7, 1, false);
        }
        if (i2 == 0 && i3 == 0) {
            g.RP().Ry().set(ac.a.USERINFO_EMOJI_BACKUP_OVERSIZE_BOOLEAN, Boolean.FALSE);
            if (this.gvO == 1 || this.gvO == 4) {
                h.pYm.a(164, 5, 1, false);
            } else {
                h.pYm.a(164, 8, 1, false);
            }
        } else if (this.gvO == 1 || this.gvO == 4) {
            h.pYm.a(164, 6, 1, false);
        } else {
            h.pYm.a(164, 9, 1, false);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(53097);
    }

    public final int getType() {
        return 698;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(53098);
        this.ehi = fVar;
        gm gmVar = (gm) this.ehh.fsG.fsP;
        gmVar.vIJ = this.gvO;
        gmVar.vII = new LinkedList(this.kWo);
        gmVar.vIK = this.kWn;
        if (gmVar.vII == null || gmVar.vII.size() <= 0) {
            ab.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "empty md5 list.");
        } else {
            ab.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "do scene delte md5 list size:%s", Integer.valueOf(gmVar.vII.size()));
            for (int i = 0; i < gmVar.vII.size(); i++) {
                ab.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "do scene delte md5:%s", gmVar.vII.get(i));
            }
        }
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(53098);
        return a;
    }
}
