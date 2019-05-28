package com.tencent.p177mm.modelvideo;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.protocal.protobuf.bwr;
import com.tencent.p177mm.protocal.protobuf.bws;
import com.tencent.p177mm.protocal.protobuf.chk;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.modelvideo.e */
public final class C32836e extends C1207m implements C1918k {
    private String clientId = "";
    private C7472b ehh;
    private C1202f ehi;
    private long fVs = -1;
    private C26493s fVt = null;
    private C9545d fVu = null;

    public C32836e(long j, C26493s c26493s, C9545d c9545d, String str) {
        AppMethodBeat.m2504i(50679);
        C4990ab.m7417i("MicroMsg.NetSceneMassUploadSight", "massSendId %d, clientId %s", Long.valueOf(j), str);
        this.fVs = j;
        this.fVt = c26493s;
        this.fVu = c9545d;
        this.clientId = str;
        AppMethodBeat.m2505o(50679);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        int i = 0;
        AppMethodBeat.m2504i(50680);
        this.ehi = c1202f;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bwr();
        c1196a.fsK = new bws();
        c1196a.uri = "/cgi-bin/micromsg-bin/sendsight";
        c1196a.fsI = C31128d.MIC_PTU_ZIPAI_LIGHTWHITE;
        this.ehh = c1196a.acD();
        bwr bwr = (bwr) this.ehh.fsG.fsP;
        bwr.eyr = this.fVu.field_aesKey;
        bwr.qQm = this.clientId;
        bwr.cvZ = this.fVt.cMW;
        bwr.wXd = this.fVt.fXd;
        C37961o.all();
        Options amj = C5056d.amj(C9720t.m17304ui(this.fVt.getFileName()));
        if (amj != null) {
            bwr.fgJ = amj.outWidth;
            bwr.fgI = amj.outHeight;
        } else {
            C4990ab.m7421w("MicroMsg.NetSceneMassUploadSight", "sight send getImageOptions for thumb failed path:%s", r2);
        }
        bwr.fVJ = this.fVt.fXa;
        String[] split = C5046bo.m7532bc(this.fVt.fXl, "").split(",");
        if (split == null || split.length <= 0) {
            C4990ab.m7413e("MicroMsg.NetSceneMassUploadSight", "cdn upload video done, massSendId[%d], split username fail", Long.valueOf(this.fVs));
            AppMethodBeat.m2505o(50680);
            return -1;
        }
        int length = split.length;
        while (i < length) {
            String str = split[i];
            chk chk = new chk();
            chk.username = str;
            bwr.wXc.add(chk);
            i++;
        }
        bwr.url = this.fVu.field_fileId;
        bwr.fXd = this.fVt.frO;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(50680);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(50681);
        C4990ab.m7416i("MicroMsg.NetSceneMassUploadSight", "cdntra onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " useCdnTransClientId:" + this.clientId + " massSendId " + this.fVs);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(50681);
    }

    public final int getType() {
        return C31128d.MIC_PTU_ZIPAI_LIGHTWHITE;
    }
}
