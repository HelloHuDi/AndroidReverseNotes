package com.tencent.p177mm.plugin.emoji.p726f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.bby;
import com.tencent.p177mm.protocal.protobuf.bbz;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;

/* renamed from: com.tencent.mm.plugin.emoji.f.q */
public final class C42949q extends C1207m implements C1918k {
    private C1202f eIc;
    private final C7472b ehh;
    public String kWz;
    private int kXc;

    public C42949q(String str, int i) {
        AppMethodBeat.m2504i(53147);
        this.kWz = str;
        if (!C5046bo.isNullOrNil(str) && str.equals(String.valueOf(EmojiGroupInfo.yar))) {
            this.kWz = "com.tencent.xin.emoticon.tusiji";
        }
        this.kXc = i;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bby();
        c1196a.fsK = new bbz();
        c1196a.uri = "/cgi-bin/micromsg-bin/modemotionpack";
        c1196a.fsI = 413;
        c1196a.fsL = 212;
        c1196a.fsM = 1000000212;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(53147);
    }

    public final int getType() {
        return 413;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(53148);
        this.eIc = c1202f;
        bby bby = (bby) this.ehh.fsG.fsP;
        bby.ProductID = this.kWz;
        bby.OpCode = this.kXc;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(53148);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(53149);
        C4990ab.m7411d("MicroMsg.emoji.NetSceneModEmotionPack", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            if (this.kXc == 1) {
                C7060h.pYm.mo8378a(165, 2, 1, false);
            } else {
                C7060h.pYm.mo8378a(165, 4, 1, false);
            }
            this.eIc.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(53149);
            return;
        }
        this.eIc.onSceneEnd(i2, i3, str, this);
        if (this.kXc == 1) {
            C7060h.pYm.mo8378a(165, 3, 1, false);
            C4990ab.m7416i("MicroMsg.emoji.NetSceneModEmotionPack", "del tukiz failed  ");
            AppMethodBeat.m2505o(53149);
            return;
        }
        C7060h.pYm.mo8378a(165, 5, 1, false);
        C4990ab.m7417i("MicroMsg.emoji.NetSceneModEmotionPack", "del emoji failed md5:%s", this.kWz);
        AppMethodBeat.m2505o(53149);
    }
}
