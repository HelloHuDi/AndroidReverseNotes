package com.tencent.mm.plugin.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bwb;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.dv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class e extends m implements k {
    private String aeskey;
    private String ecX;
    private b ehh;
    private f ehi;
    private String fileId;
    private int oFD;
    private String oFE;
    private String oFF;

    public e(String str, String str2, int i, String str3, String str4, String str5) {
        AppMethodBeat.i(22900);
        this.fileId = str;
        this.aeskey = str2;
        this.oFD = i;
        this.ecX = str3;
        this.oFE = str4;
        this.oFF = str5;
        a aVar = new a();
        aVar.fsJ = new bwb();
        aVar.fsK = new bwc();
        aVar.uri = "/cgi-bin/micromsg-bin/sendappmsg";
        this.ehh = aVar.acD();
        ab.i("MicroMsg.MsgSynchronizeSendAppMsgNetScene", "MsgSynchronizeSendAppMsgNetScene action[%s], messagaction[%s], fileId[%s], fileLen[%d], selfName[%s], stack[%s]", str4, this.oFE, str, Integer.valueOf(i), str3, bo.dpG());
        AppMethodBeat.o(22900);
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(22901);
        this.ehi = fVar;
        j.b bVar = new j.b();
        bVar.title = "ChatSync";
        bVar.description = "ChatSync";
        bVar.type = 35;
        bVar.url = this.fileId;
        bVar.eyr = this.aeskey;
        bVar.fgK = this.aeskey;
        bVar.fgo = this.oFD;
        bVar.fgK = this.aeskey;
        bVar.showType = 0;
        bVar.action = "phone";
        bVar.messageAction = this.oFE;
        bVar.extInfo = "supportAfterSleep,supportGetMore";
        bVar.content = this.oFF;
        bwb bwb = (bwb) this.ehh.fsG.fsP;
        dv dvVar = new dv();
        dvVar.ndG = this.ecX;
        dvVar.vFE = bVar.sdkVer;
        dvVar.jCt = 35;
        dvVar.ndF = this.ecX;
        dvVar.ncM = j.b.a(bVar, null, null, 0, 0);
        dvVar.pcX = (int) bo.anT();
        bwb.wWQ = dvVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(22901);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(22902);
        ab.i("MicroMsg.MsgSynchronizeSendAppMsgNetScene", "msgSynchronize sendAppMsg onGYNetEnd. [%d,%d,%s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(22902);
    }

    public final int getType() {
        return 222;
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }
}
