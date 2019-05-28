package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.brk;
import com.tencent.mm.protocal.protobuf.brl;
import com.tencent.mm.protocal.protobuf.ks;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.LinkedList;

public final class g extends m implements k {
    private b ehh;
    private f ehi;

    public g(LinkedList<ks> linkedList, int i, int i2, int i3) {
        AppMethodBeat.i(13843);
        a aVar = new a();
        aVar.fsJ = new brk();
        aVar.fsK = new brl();
        aVar.uri = "/cgi-bin/micromsg-bin/reportshow";
        aVar.fsL = ErrorCode.NEEDDOWNLOAD_FALSE_6;
        aVar.fsM = 1000000176;
        this.ehh = aVar.acD();
        brk brk = (brk) this.ehh.fsG.fsP;
        brk.wTG = linkedList;
        brk.wTH = i;
        brk.wTI = i2;
        brk.vZZ = i3;
        ab.i("MicroMsg.NetSceneReportBizListShowInfo", "reportshow report_list size %d,enter_pos %d,exit_pos %d", Integer.valueOf(brk.wTG.size()), Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(13843);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(13844);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(13844);
    }

    public final int getType() {
        return 2645;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(13845);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(13845);
        return a;
    }
}
