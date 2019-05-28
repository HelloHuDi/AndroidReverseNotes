package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.sdk.platformtools.ab;

public final class o extends m implements k {
    byte[] cQr;
    private final b ehh;
    private f ehi;
    int lqx;
    int lqy;

    public o(int i, int i2, byte[] bArr) {
        String str;
        AppMethodBeat.i(54085);
        this.lqx = i;
        this.lqy = i2;
        a aVar = new a();
        aVar.fsJ = new bdo();
        aVar.fsK = new bdp();
        switch (i2) {
            case 1918:
                str = "/cgi-bin/qcwxmultitalk-bin/createtalkroom";
                break;
            case 1919:
                str = "/cgi-bin/qcwxmultitalk-bin/entertalkroom";
                break;
            case 1927:
                str = "/cgi-bin/qcwxmultitalk-bin/exittalkroom";
                break;
            case 1928:
                str = "/cgi-bin/qcwxmultitalk-bin/cancelcreatetalkroom";
                break;
            case 1929:
                str = "/cgi-bin/qcwxmultitalk-bin/rejectentertalkroom";
                break;
            case 1931:
                str = "/cgi-bin/qcwxmultitalk-bin/addmembers";
                break;
            case 1932:
                str = "/cgi-bin/qcwxmultitalk-bin/hellotalkroom";
                break;
            case 1933:
                str = "/cgi-bin/qcwxmultitalk-bin/miscinfo";
                break;
            case 1935:
                str = "/cgi-bin/qcwxmultitalk-bin/voiceackreq";
                break;
            case 1937:
                str = "/cgi-bin/qcwxmultitalk-bin/oiceredirectreq";
                break;
            case 1938:
                str = "/cgi-bin/qcwxmultitalk-bin/getgroupinfobatch";
                break;
            case 1939:
                str = "/cgi-bin/qcwxmultitalk-bin/memberwhisper";
                break;
            default:
                str = "";
                break;
        }
        ab.i("MicroMsg.MT.NetSceneMultiTalk", "netSceneMultiTalk cmdid %d cgiName %s", Integer.valueOf(i2), str);
        aVar.uri = str;
        aVar.fsI = this.lqy;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ((bdo) this.ehh.fsG.fsP).vJd = new SKBuiltinBuffer_t().setBuffer(bArr);
        AppMethodBeat.o(54085);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(54086);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(54086);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(54087);
        ab.d("MicroMsg.MT.NetSceneMultiTalk", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " " + this.lqy);
        this.cQr = aa.a(((bdp) ((b) qVar).fsH.fsP).vJd);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(54087);
    }

    public final int getType() {
        return this.lqy;
    }
}
