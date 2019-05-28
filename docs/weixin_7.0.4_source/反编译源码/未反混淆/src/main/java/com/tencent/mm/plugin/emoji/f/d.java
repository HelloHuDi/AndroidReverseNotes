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
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.hs;
import com.tencent.mm.protocal.protobuf.ht;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.LinkedList;

public final class d extends m implements k {
    private final b ehh;
    private f ehi;
    private ArrayList<String> kWp;

    public d(ArrayList<String> arrayList) {
        AppMethodBeat.i(53099);
        a aVar = new a();
        aVar.fsJ = new hs();
        aVar.fsK = new ht();
        aVar.uri = "/cgi-bin/micromsg-bin/mmbatchemojibackup";
        this.ehh = aVar.acD();
        this.kWp = arrayList;
        AppMethodBeat.o(53099);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(53100);
        ab.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "netId:%d, errType:%d, errCode:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i3 == -434) {
            ab.w("MicroMsg.emoji.NetSceneBatchEmojiBackup", "[cpan] batch backup emoji failed. over size.");
            g.RP().Ry().set(ac.a.USERINFO_EMOJI_BACKUP_OVERSIZE_BOOLEAN, Boolean.TRUE);
            h.pYm.a(164, 4, 1, false);
        }
        if (i2 == 0 && i3 == 0) {
            g.RP().Ry().set(ac.a.USERINFO_EMOJI_BACKUP_OVERSIZE_BOOLEAN, Boolean.FALSE);
            com.tencent.mm.storage.emotion.d dVar = j.getEmojiStorageMgr().xYn;
            ArrayList arrayList = this.kWp;
            if (arrayList == null || arrayList.size() <= 0) {
                ab.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] LocalCustomEmoji failed. list is null");
            } else {
                ab.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] LocalCustomEmoji list size :%d.", Integer.valueOf(arrayList.size()));
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("UPDATE");
                stringBuilder.append(" EmojiInfo ");
                stringBuilder.append(" SET ");
                stringBuilder.append("source");
                stringBuilder.append("=");
                stringBuilder.append(EmojiInfo.zZf);
                stringBuilder.append(" where ");
                stringBuilder.append("md5");
                stringBuilder.append(" IN (");
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= arrayList.size()) {
                        break;
                    }
                    stringBuilder.append("'" + ((String) arrayList.get(i5)) + "'");
                    if (i5 < arrayList.size() - 1) {
                        stringBuilder.append(",");
                    }
                    i4 = i5 + 1;
                }
                stringBuilder.append(")");
                ab.d("MicroMsg.emoji.EmojiInfoStorage", stringBuilder.toString());
                dVar.bSd.hY("EmojiInfo", stringBuilder.toString());
            }
            h.pYm.a(164, 2, 1, false);
        } else {
            h.pYm.a(164, 3, 1, false);
        }
        ht htVar = (ht) this.ehh.fsH.fsP;
        if (htVar.vIL != null && htVar.vIL.size() > 0) {
            ab.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "[cpan] there are some emoji need to upload.");
            j.getEmojiStorageMgr().xYn.aG(htVar.vIL);
            g.RP().Ry().set(348165, Boolean.TRUE);
            com.tencent.mm.plugin.emoji.c.a.gn(true);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(53100);
    }

    public final int getType() {
        return 696;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(53101);
        this.ehi = fVar;
        ((hs) this.ehh.fsG.fsP).vII = new LinkedList(this.kWp);
        if (this.kWp == null || this.kWp.size() <= 0) {
            ab.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "need no backup custom emoji, list is null.");
            g.RP().Ry().set(348162, Boolean.FALSE);
            AppMethodBeat.o(53101);
            return -1;
        }
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(53101);
        return a;
    }
}
