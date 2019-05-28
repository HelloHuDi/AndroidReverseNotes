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
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.cbz;
import com.tencent.mm.protocal.protobuf.ccc;
import com.tencent.mm.protocal.protobuf.ccd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

public final class w extends m implements k {
    private int czE;
    private b ehh;
    public f ehi;
    private long qJP;
    private int scene = 0;

    public w(int i, long j, String str, int i2, List<String> list, int i3) {
        AppMethodBeat.i(36330);
        ab.d("MicroMsg.NetSceneSnsTagMemberOption", "opCode " + i + " tagName " + str + " memberList " + list.size() + " scene " + i3);
        this.czE = i;
        this.qJP = j;
        this.scene = i3;
        a aVar = new a();
        aVar.fsJ = new ccc();
        aVar.fsK = new ccd();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnstagmemberoption";
        aVar.fsI = 291;
        aVar.fsL = 115;
        aVar.fsM = 1000000115;
        this.ehh = aVar.acD();
        ccc ccc = (ccc) this.ehh.fsG.fsP;
        ccc.OpCode = i;
        ccc.xbt = j;
        ccc.ncF = str;
        ccc.jBv = i2;
        ccc.Scene = this.scene;
        LinkedList linkedList = new LinkedList();
        for (String alV : list) {
            linkedList.add(new bts().alV(alV));
        }
        ccc.jBw = linkedList;
        ab.d("MicroMsg.NetSceneSnsTagMemberOption", "rr.req.rImpl " + ccc.toString());
        AppMethodBeat.o(36330);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(36331);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(36331);
        return a;
    }

    public final int getType() {
        return 291;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(36332);
        ab.d("MicroMsg.NetSceneSnsTagMemberOption", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            cbz cbz = ((ccd) ((b) qVar).fsH.fsP).xbv;
            ab.d("MicroMsg.NetSceneSnsTagMemberOption", "Resp.rImpl " + cbz.toString());
            t kF = af.cnL().kF(cbz.xbt);
            kF.field_tagId = cbz.xbt;
            kF.field_tagName = bo.bc(cbz.ncF, "");
            switch (this.czE) {
                case 1:
                case 2:
                case 3:
                    kF.field_count = cbz.jBv;
                    kF.m8do(cbz.jBw);
                    break;
            }
            af.cnL().a(kF);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(36332);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(36332);
    }
}
