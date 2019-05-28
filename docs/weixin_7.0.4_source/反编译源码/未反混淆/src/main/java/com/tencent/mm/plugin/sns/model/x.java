package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.protocal.protobuf.cbz;
import com.tencent.mm.protocal.protobuf.cce;
import com.tencent.mm.protocal.protobuf.ccf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class x extends m implements k {
    private int czE;
    private b ehh;
    public f ehi;
    private long qJQ = 0;

    public x(long j, String str) {
        AppMethodBeat.i(36333);
        ab.d("MicroMsg.NetSceneSnsTagOption", "opcode 3 snsTagId " + j + " tagName " + str);
        this.qJQ = j;
        this.czE = 3;
        a aVar = new a();
        aVar.fsJ = new cce();
        aVar.fsK = new ccf();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnstagoption";
        aVar.fsI = 290;
        aVar.fsL = 114;
        aVar.fsM = 1000000114;
        this.ehh = aVar.acD();
        cce cce = (cce) this.ehh.fsG.fsP;
        cce.OpCode = 3;
        cce.xbt = j;
        cce.ncF = str;
        AppMethodBeat.o(36333);
    }

    public final int getType() {
        return 290;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(36334);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(36334);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(36335);
        ab.d("MicroMsg.NetSceneSnsTagOption", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            cbz cbz = ((ccf) ((b) qVar).fsH.fsP).xbv;
            ab.d("MicroMsg.NetSceneSnsTagOption", cbz.toString());
            switch (this.czE) {
                case 1:
                case 2:
                    t kF = af.cnL().kF(cbz.xbt);
                    kF.field_tagId = cbz.xbt;
                    kF.field_tagName = bo.bc(cbz.ncF, "");
                    kF.field_count = cbz.jBv;
                    kF.m8do(cbz.jBw);
                    af.cnL().a(kF);
                    break;
                case 3:
                    ab.d("MicroMsg.NetSceneSnsTagOption", "MM_SNS_TAG_DEL ".concat(String.valueOf(af.cnL().kG(this.qJQ))));
                    break;
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(36335);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(36335);
    }
}
