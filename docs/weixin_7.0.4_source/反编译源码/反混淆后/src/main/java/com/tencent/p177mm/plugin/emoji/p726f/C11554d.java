package com.tencent.p177mm.plugin.emoji.p726f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.p1252c.C27731a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C40527ht;
import com.tencent.p177mm.protocal.protobuf.C46548hs;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.emotion.C30303d;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.emoji.f.d */
public final class C11554d extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    private ArrayList<String> kWp;

    public C11554d(ArrayList<String> arrayList) {
        AppMethodBeat.m2504i(53099);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C46548hs();
        c1196a.fsK = new C40527ht();
        c1196a.uri = "/cgi-bin/micromsg-bin/mmbatchemojibackup";
        this.ehh = c1196a.acD();
        this.kWp = arrayList;
        AppMethodBeat.m2505o(53099);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(53100);
        C4990ab.m7417i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "netId:%d, errType:%d, errCode:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i3 == -434) {
            C4990ab.m7420w("MicroMsg.emoji.NetSceneBatchEmojiBackup", "[cpan] batch backup emoji failed. over size.");
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_BACKUP_OVERSIZE_BOOLEAN, Boolean.TRUE);
            C7060h.pYm.mo8378a(164, 4, 1, false);
        }
        if (i2 == 0 && i3 == 0) {
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_BACKUP_OVERSIZE_BOOLEAN, Boolean.FALSE);
            C30303d c30303d = C42952j.getEmojiStorageMgr().xYn;
            ArrayList arrayList = this.kWp;
            if (arrayList == null || arrayList.size() <= 0) {
                C4990ab.m7416i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] LocalCustomEmoji failed. list is null");
            } else {
                C4990ab.m7417i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] LocalCustomEmoji list size :%d.", Integer.valueOf(arrayList.size()));
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
                C4990ab.m7410d("MicroMsg.emoji.EmojiInfoStorage", stringBuilder.toString());
                c30303d.bSd.mo10108hY("EmojiInfo", stringBuilder.toString());
            }
            C7060h.pYm.mo8378a(164, 2, 1, false);
        } else {
            C7060h.pYm.mo8378a(164, 3, 1, false);
        }
        C40527ht c40527ht = (C40527ht) this.ehh.fsH.fsP;
        if (c40527ht.vIL != null && c40527ht.vIL.size() > 0) {
            C4990ab.m7416i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "[cpan] there are some emoji need to upload.");
            C42952j.getEmojiStorageMgr().xYn.mo48567aG(c40527ht.vIL);
            C1720g.m3536RP().mo5239Ry().set(348165, Boolean.TRUE);
            C27731a.m44047gn(true);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(53100);
    }

    public final int getType() {
        return 696;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(53101);
        this.ehi = c1202f;
        ((C46548hs) this.ehh.fsG.fsP).vII = new LinkedList(this.kWp);
        if (this.kWp == null || this.kWp.size() <= 0) {
            C4990ab.m7416i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "need no backup custom emoji, list is null.");
            C1720g.m3536RP().mo5239Ry().set(348162, Boolean.FALSE);
            AppMethodBeat.m2505o(53101);
            return -1;
        }
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(53101);
        return a;
    }
}
