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
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C44120gm;
import com.tencent.p177mm.protocal.protobuf.C44121gn;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.emoji.f.c */
public final class C33949c extends C1207m implements C1918k {
    public final C7472b ehh;
    private C1202f ehi;
    public int gvO;
    private int kWn;
    private List<String> kWo;

    public C33949c(int i, int i2, List<String> list) {
        AppMethodBeat.m2504i(53096);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C44120gm();
        c1196a.fsK = new C44121gn();
        c1196a.uri = "/cgi-bin/micromsg-bin/mmbackupemojioperate";
        this.ehh = c1196a.acD();
        this.kWn = i;
        this.gvO = i2;
        this.kWo = list;
        AppMethodBeat.m2505o(53096);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(53097);
        C4990ab.m7417i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i3 == -434) {
            C4990ab.m7420w("MicroMsg.emoji.NetSceneBackupEmojiOperate", "[cpan] batch backup emoji failed. over size.");
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_BACKUP_OVERSIZE_BOOLEAN, Boolean.TRUE);
            C7060h.pYm.mo8378a(164, 7, 1, false);
        }
        if (i2 == 0 && i3 == 0) {
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_BACKUP_OVERSIZE_BOOLEAN, Boolean.FALSE);
            if (this.gvO == 1 || this.gvO == 4) {
                C7060h.pYm.mo8378a(164, 5, 1, false);
            } else {
                C7060h.pYm.mo8378a(164, 8, 1, false);
            }
        } else if (this.gvO == 1 || this.gvO == 4) {
            C7060h.pYm.mo8378a(164, 6, 1, false);
        } else {
            C7060h.pYm.mo8378a(164, 9, 1, false);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(53097);
    }

    public final int getType() {
        return 698;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(53098);
        this.ehi = c1202f;
        C44120gm c44120gm = (C44120gm) this.ehh.fsG.fsP;
        c44120gm.vIJ = this.gvO;
        c44120gm.vII = new LinkedList(this.kWo);
        c44120gm.vIK = this.kWn;
        if (c44120gm.vII == null || c44120gm.vII.size() <= 0) {
            C4990ab.m7416i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "empty md5 list.");
        } else {
            C4990ab.m7417i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "do scene delte md5 list size:%s", Integer.valueOf(c44120gm.vII.size()));
            for (int i = 0; i < c44120gm.vII.size(); i++) {
                C4990ab.m7417i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "do scene delte md5:%s", c44120gm.vII.get(i));
            }
        }
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(53098);
        return a;
    }
}
