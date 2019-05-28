package com.tencent.mm.bl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ajb;
import com.tencent.mm.protocal.protobuf.ajc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a extends m implements k {
    private b ehh;
    private f ehi = null;
    private ajb gcw;
    public ajc gcx;
    public com.tencent.mm.api.f gcy;
    private String gcz = null;

    public a(com.tencent.mm.api.f fVar) {
        AppMethodBeat.i(35455);
        if (fVar == null) {
            AppMethodBeat.o(35455);
            return;
        }
        this.gcy = fVar;
        ab.i("MicroMsg.NetSceneGetFuncMsg", "new NetSceneGetFuncMsg, cgi: %s, cmdId: %s, functionMsgId: %s", fVar.field_cgi, Integer.valueOf(fVar.field_cmdid), fVar.field_functionmsgid);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new ajb();
        aVar.fsK = new ajc();
        aVar.fsI = 825;
        aVar.uri = fVar.field_cgi;
        aVar.fsL = fVar.field_cmdid;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        this.gcw = (ajb) this.ehh.fsG.fsP;
        this.gcw.woV = fVar.field_functionmsgid;
        if (fVar.field_custombuff != null) {
            this.gcw.woW = fVar.field_custombuff;
        }
        this.gcw.woX = fVar.field_businessInfo;
        AppMethodBeat.o(35455);
    }

    public final int getType() {
        return 825;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(35456);
        if (this.gcy != null) {
            ab.i("MicroMsg.NetSceneGetFuncMsg", "doScene, functionMsgId: %s", this.gcy.field_functionmsgid);
            this.gcy.field_status = 1;
        }
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(35456);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(35457);
        this.gcx = (ajc) ((b) qVar).fsH.fsP;
        this.gcz = this.gcx.woW;
        ab.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, errType: %s, errCode: %s, errMsg: %s, opCode: %s, responseCustomBuff==null: %s, response.version: %s", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(this.gcx.OpCode), Boolean.valueOf(bo.isNullOrNil(this.gcz)), Long.valueOf(this.gcx.woY));
        if (!bo.isNullOrNil(this.gcz)) {
            this.gcw = (ajb) this.ehh.fsG.fsP;
            this.gcw.woW = this.gcz;
        }
        if (i2 == 0 || i3 == 0) {
            h.pYm.a((long) this.gcy.field_reportid, (long) this.gcy.field_successkey, 1, false);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(35457);
        } else if (i2 == 4) {
            ab.i("MicroMsg.NetSceneGetFuncMsg", "server error");
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(35457);
        } else {
            ab.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, local error");
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(35457);
        }
    }
}
