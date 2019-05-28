package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bod;
import com.tencent.mm.protocal.protobuf.clu;
import com.tencent.mm.protocal.protobuf.coa;
import com.tencent.mm.protocal.protobuf.cof;
import com.tencent.mm.protocal.protobuf.sf;
import com.tencent.mm.protocal.protobuf.sg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a extends m implements k {
    public static int svO = 1;
    public static int svP = 2;
    public static int svQ = 3;
    private int Scene;
    private String cMr;
    private b fsB;
    private String mFileName;
    public int mState = -1;
    private f oRe;
    private String svJ;
    private int svK;
    private coa svL;
    private long svM;
    private String svN;
    public cof svR;
    public clu svS;
    public bod svT;
    int svU;

    public a(String str, int i, String str2) {
        AppMethodBeat.i(25572);
        a(str, i, -1, -1, str2, 0, "", "");
        AppMethodBeat.o(25572);
    }

    public a(String str, int i, int i2, long j, String str2) {
        AppMethodBeat.i(25573);
        a(str, i, i2, j, str2, 0, "", "");
        AppMethodBeat.o(25573);
    }

    public a(String str, int i, String str2, int i2, String str3, String str4) {
        AppMethodBeat.i(25574);
        a(str, i, -1, -1, str2, i2, str3, str4);
        AppMethodBeat.o(25574);
    }

    public a(String str, int i, int i2, long j, String str2, int i3, String str3, String str4) {
        AppMethodBeat.i(25575);
        a(str, i, i2, j, str2, i3, str3, str4);
        AppMethodBeat.o(25575);
    }

    private void a(String str, int i, int i2, long j, String str2, int i3, String str3, String str4) {
        AppMethodBeat.i(25576);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new sf();
        aVar.fsK = new sg();
        aVar.uri = "/cgi-bin/micromsg-bin/checkvoicetrans";
        aVar.fsI = 546;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.mFileName = str2;
        this.fsB = aVar.acD();
        ab.i("MicroMsg.NetSceneCheckVoiceTrans", "voiceId:%s, totalLen:%d, encodeType: %d, svrMsgId: %s", str, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j));
        if (i2 >= 0) {
            this.svL = d.bm(i2, str2);
        }
        if (j > 0) {
            this.svM = j;
        }
        this.svJ = str;
        this.svK = i;
        this.Scene = i3;
        this.svN = str3;
        this.cMr = str4;
        AppMethodBeat.o(25576);
    }

    public final int getType() {
        return 546;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(25577);
        this.oRe = fVar;
        sf sfVar = (sf) this.fsB.fsG.fsP;
        sfVar.vZx = this.svJ;
        sfVar.ptw = this.svK;
        sfVar.vZy = this.svL;
        sfVar.ptF = this.svM;
        sfVar.Scene = this.Scene;
        sfVar.ndG = this.svN;
        sfVar.ndF = this.cMr;
        int a = a(eVar, this.fsB, this);
        AppMethodBeat.o(25577);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(25578);
        if (i2 == 0 && i3 == 0) {
            sg sgVar = (sg) this.fsB.fsH.fsP;
            if (sgVar == null) {
                AppMethodBeat.o(25578);
                return;
            }
            this.svR = sgVar.vZz;
            this.mState = sgVar.jBT;
            this.svS = sgVar.vZA;
            this.svT = sgVar.vZB;
            this.svU = sgVar.vZC;
        } else {
            ab.i("MicroMsg.NetSceneCheckVoiceTrans", "end checkVoiceTrans, & errType:%d, errCode:%d, voiceId: %s ", Integer.valueOf(i2), Integer.valueOf(i3), this.svJ);
        }
        this.oRe.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(25578);
    }

    public final boolean cDR() {
        AppMethodBeat.i(25579);
        if (this.svR == null || bo.isNullOrNil(this.svR.xlH)) {
            AppMethodBeat.o(25579);
            return false;
        }
        AppMethodBeat.o(25579);
        return true;
    }
}
