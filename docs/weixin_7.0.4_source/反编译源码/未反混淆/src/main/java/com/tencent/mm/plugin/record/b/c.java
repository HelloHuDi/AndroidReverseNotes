package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.qk;
import com.tencent.mm.protocal.protobuf.ql;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class c extends m implements k {
    private b ehh;
    private f ehi;
    private final com.tencent.mm.pluginsdk.model.app.b pJj;

    public c(com.tencent.mm.pluginsdk.model.app.b bVar, String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(135639);
        a aVar = new a();
        aVar.fsJ = new qk();
        aVar.fsK = new ql();
        aVar.uri = "/cgi-bin/micromsg-bin/checkbigfiledownload";
        this.ehh = aVar.acD();
        this.pJj = bVar;
        qk qkVar = (qk) this.ehh.fsG.fsP;
        qkVar.vRw = str;
        qkVar.vXv = bVar.field_totalLen;
        qkVar.vXw = str2;
        qkVar.fMd = str3;
        qkVar.vXx = str4;
        qkVar.ndG = str5;
        qkVar.ndF = (String) g.RP().Ry().get(2, (Object) "");
        qkVar.vHo = com.tencent.mm.i.a.efE;
        ab.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig AESKey[%s] FileMd5[%s] FileName[%s] FileExt[%s] FileSize[%d] FileType[%d] stack[%s]", bo.anv(qkVar.vRw), qkVar.vXw, qkVar.fMd, qkVar.vXx, Long.valueOf(qkVar.vXv), Integer.valueOf(qkVar.vHo), bo.dpG());
        AppMethodBeat.o(135639);
    }

    public final int getType() {
        return 728;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(135640);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(135640);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(135641);
        ab.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig onGYNetEnd [%d, %d, %s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            ql qlVar = (ql) ((b) qVar).fsH.fsP;
            this.pJj.field_signature = qlVar.guQ;
            this.pJj.field_fakeAeskey = qlVar.vXz;
            this.pJj.field_fakeSignature = qlVar.vXA;
            boolean a = com.tencent.mm.plugin.s.a.aUq().a(this.pJj, new String[0]);
            ab.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig onGYNetEnd field_signature[%s], field_fakeAeskey[%s], field_fakeSignature[%s], update[%b]", bo.anv(this.pJj.field_signature), bo.anv(this.pJj.field_fakeAeskey), bo.anv(this.pJj.field_fakeSignature), Boolean.valueOf(a));
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(135641);
    }

    public final String getMediaId() {
        if (this.pJj != null) {
            return this.pJj.field_mediaSvrId;
        }
        return "";
    }
}
