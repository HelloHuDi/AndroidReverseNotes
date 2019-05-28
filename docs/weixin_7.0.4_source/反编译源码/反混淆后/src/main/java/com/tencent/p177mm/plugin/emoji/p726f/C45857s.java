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
import com.tencent.p177mm.protocal.protobuf.clm;
import com.tencent.p177mm.protocal.protobuf.cln;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.emoji.f.s */
public final class C45857s extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    private int gvO;
    private List<String> kXe = new ArrayList();

    public C45857s(List<String> list, int i) {
        AppMethodBeat.m2504i(53153);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new clm();
        c1196a.fsK = new cln();
        c1196a.uri = "/cgi-bin/micromsg-bin/mmuploadmypanellist";
        c1196a.fsI = 717;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        this.kXe = list;
        this.gvO = i;
        AppMethodBeat.m2505o(53153);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(53154);
        C4990ab.m7417i("MicroMsg.emoji.NetSceneUploadMyPanelList", "errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_SYNC_STORE_EMOJI_UPLODD_LONG, Long.valueOf(System.currentTimeMillis()));
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_SYNC_STORE_EMOJI_UPLODD_FINISH_BOOLEAN, Boolean.TRUE);
            C7060h.pYm.mo8378a(165, 0, 1, false);
        } else {
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_SYNC_STORE_EMOJI_UPLODD_LONG, Long.valueOf((System.currentTimeMillis() - 86400000) + 3600000));
            C7060h.pYm.mo8378a(165, 1, 1, false);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(53154);
    }

    public final int getType() {
        return 717;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(53155);
        this.ehi = c1202f;
        clm clm = (clm) this.ehh.fsG.fsP;
        clm.OpCode = this.gvO;
        if (this.kXe != null) {
            for (Object obj : this.kXe) {
                Object obj2;
                if (!C5046bo.isNullOrNil(obj2) && obj2.equals(String.valueOf(EmojiGroupInfo.yar))) {
                    obj2 = "com.tencent.xin.emoticon.tusiji";
                }
                clm.xjj.add(obj2);
                C4990ab.m7411d("MicroMsg.emoji.NetSceneUploadMyPanelList", "product id is:%s", obj2);
            }
            C4990ab.m7417i("MicroMsg.emoji.NetSceneUploadMyPanelList", "opcode is:%d mProductIdList size:%s", Integer.valueOf(this.gvO), Integer.valueOf(this.kXe.size()));
        }
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(53155);
        return a;
    }
}
