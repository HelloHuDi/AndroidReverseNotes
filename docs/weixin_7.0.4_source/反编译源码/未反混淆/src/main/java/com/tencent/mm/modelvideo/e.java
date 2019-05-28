package com.tencent.mm.modelvideo;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.i.d;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bwr;
import com.tencent.mm.protocal.protobuf.bws;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class e extends m implements k {
    private String clientId = "";
    private b ehh;
    private f ehi;
    private long fVs = -1;
    private s fVt = null;
    private d fVu = null;

    public e(long j, s sVar, d dVar, String str) {
        AppMethodBeat.i(50679);
        ab.i("MicroMsg.NetSceneMassUploadSight", "massSendId %d, clientId %s", Long.valueOf(j), str);
        this.fVs = j;
        this.fVt = sVar;
        this.fVu = dVar;
        this.clientId = str;
        AppMethodBeat.o(50679);
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        int i = 0;
        AppMethodBeat.i(50680);
        this.ehi = fVar;
        a aVar = new a();
        aVar.fsJ = new bwr();
        aVar.fsK = new bws();
        aVar.uri = "/cgi-bin/micromsg-bin/sendsight";
        aVar.fsI = com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTWHITE;
        this.ehh = aVar.acD();
        bwr bwr = (bwr) this.ehh.fsG.fsP;
        bwr.eyr = this.fVu.field_aesKey;
        bwr.qQm = this.clientId;
        bwr.cvZ = this.fVt.cMW;
        bwr.wXd = this.fVt.fXd;
        o.all();
        Options amj = com.tencent.mm.sdk.platformtools.d.amj(t.ui(this.fVt.getFileName()));
        if (amj != null) {
            bwr.fgJ = amj.outWidth;
            bwr.fgI = amj.outHeight;
        } else {
            ab.w("MicroMsg.NetSceneMassUploadSight", "sight send getImageOptions for thumb failed path:%s", r2);
        }
        bwr.fVJ = this.fVt.fXa;
        String[] split = bo.bc(this.fVt.fXl, "").split(",");
        if (split == null || split.length <= 0) {
            ab.e("MicroMsg.NetSceneMassUploadSight", "cdn upload video done, massSendId[%d], split username fail", Long.valueOf(this.fVs));
            AppMethodBeat.o(50680);
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
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(50680);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(50681);
        ab.i("MicroMsg.NetSceneMassUploadSight", "cdntra onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " useCdnTransClientId:" + this.clientId + " massSendId " + this.fVs);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(50681);
    }

    public final int getType() {
        return com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTWHITE;
    }
}
