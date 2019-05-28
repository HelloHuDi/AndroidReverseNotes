package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.aag;
import com.tencent.mm.protocal.protobuf.axh;
import com.tencent.mm.protocal.protobuf.blr;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class l extends m implements k {
    private b ehh;
    private f ehi;
    private LinkedList<axh> lSF = null;
    public blr lSG = null;
    public String lSH;
    public String lSI;
    public String lSJ = null;
    public String lSK = null;
    public String lSL = null;
    public float lSM;
    public int lSN;
    public String lSO;

    public l(String str, String str2, int i) {
        AppMethodBeat.i(78);
        a aVar = new a();
        aVar.fsJ = new aaf();
        aVar.fsK = new aag();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/faceidentifyprepage";
        aVar.fsI = 1147;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        aaf aaf = (aaf) this.ehh.fsG.fsP;
        aaf.csB = str;
        aaf.wfo = str2;
        aaf.lSN = i;
        AppMethodBeat.o(78);
    }

    public final int getType() {
        return 1147;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(79);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(79);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(80);
        ab.i("MicroMsg.NetSceneFaceGetConfirmPageInfo", "alvinluo errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        aag aag = (aag) ((b) qVar).fsH.fsP;
        if (aag != null) {
            this.lSF = aag.vWz;
            this.lSG = aag.wfp;
            this.lSJ = aag.wfr;
            this.lSK = aag.wfs;
            this.lSL = aag.wft;
            this.lSM = aag.wfu;
            this.lSN = aag.lSN;
            this.lSO = aag.lSO;
            this.lSH = aag.wfv;
            this.lSI = aag.wfq;
            ab.d("MicroMsg.NetSceneFaceGetConfirmPageInfo", "Light threshold is A : " + this.lSM);
            ab.d("MicroMsg.NetSceneFaceGetConfirmPageInfo", "check_alive_type is  : " + this.lSN);
            if (this.ehi != null) {
                this.ehi.onSceneEnd(i2, i3, str, this);
            }
        }
        AppMethodBeat.o(80);
    }

    public final String toString() {
        AppMethodBeat.i(81);
        String str = "NetSceneFaceGetConfirmPageInfo{callback=" + this.ehi + ", rr=" + this.ehh + ", mFaceConfirmInfoList=" + this.lSF + ", mPromptButtonInfo=" + this.lSG + ", bizHeadUrl='" + this.lSH + '\'' + ", bizNickName='" + this.lSI + '\'' + ", mHeaderPrompt='" + this.lSJ + '\'' + ", mFeedbackUrl='" + this.lSK + '\'' + ", mComplainUrl='" + this.lSL + '\'' + ", mLight_threshold=" + this.lSM + ", check_alive_type=" + this.lSN + ", business_tips='" + this.lSO + '\'' + '}';
        AppMethodBeat.o(81);
        return str;
    }
}
