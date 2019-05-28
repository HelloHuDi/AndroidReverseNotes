package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.coh;
import com.tencent.mm.protocal.protobuf.coi;
import com.tencent.mm.protocal.protobuf.cpr;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.view.d;

public final class a extends n<coh, coi> {
    String TAG = "MicroMsg.NetSceneVoipAck";

    public a(int i, long j, int i2, byte[] bArr, byte[] bArr2, String str) {
        AppMethodBeat.i(4695);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new coh();
        aVar.fsK = new coi();
        aVar.uri = "/cgi-bin/micromsg-bin/voipack";
        aVar.fsI = d.MIC_PTU_QINGCHENG;
        aVar.fsL = 123;
        aVar.fsM = 1000000123;
        this.ehh = aVar.acD();
        coh coh = (coh) this.ehh.fsG.fsP;
        coh.wem = i;
        coh.wen = j;
        coh.xlP = i2;
        if (i2 != 1) {
            coh.xlL = 0;
            AppMethodBeat.o(4695);
            return;
        }
        coh.xlO = str;
        cpx cpx = new cpx();
        cpx.jCt = 2;
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        sKBuiltinBuffer_t.setBuffer(bArr);
        cpx.vJd = sKBuiltinBuffer_t;
        coh.xlM = cpx;
        cpx = new cpx();
        cpx.jCt = 3;
        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        sKBuiltinBuffer_t.setBuffer(bArr2);
        cpx.vJd = sKBuiltinBuffer_t;
        coh.xlN = cpx;
        coh.xlQ = System.currentTimeMillis();
        coh.xlL = 1;
        int bOK = ((com.tencent.mm.plugin.misc.a.a) g.K(com.tencent.mm.plugin.misc.a.a.class)).bOK();
        ab.i(this.TAG, "simType: %s", Integer.valueOf(bOK));
        bOK = bOK == 0 ? 0 : bOK == 1 ? 1 : 2;
        coh.xlR = bOK;
        AppMethodBeat.o(4695);
    }

    public final int getType() {
        return d.MIC_PTU_QINGCHENG;
    }

    public final f cKt() {
        AppMethodBeat.i(4696);
        AnonymousClass1 anonymousClass1 = new f() {
            public final void onSceneEnd(int i, int i2, String str, m mVar) {
                AppMethodBeat.i(4694);
                com.tencent.mm.plugin.voip.a.a.Logi(a.this.TAG, "ack response:" + i + " errCode:" + i2 + " status:" + a.this.sPK.mStatus);
                if (a.this.sPK.mStatus == 1) {
                    com.tencent.mm.plugin.voip.a.a.Logi(a.this.TAG, "reject ok!");
                    AppMethodBeat.o(4694);
                } else if (a.this.sPK.mStatus != 3) {
                    com.tencent.mm.plugin.voip.a.a.Loge(a.this.TAG, "ack response not within WAITCONNECT, ignored.");
                    AppMethodBeat.o(4694);
                } else if (i == 0) {
                    coi coi = (coi) a.this.cKx();
                    if (coi.xlL != 1) {
                        com.tencent.mm.plugin.voip.a.a.Logi(a.this.TAG, "onVoipAckResp: do not use preconnect");
                        AppMethodBeat.o(4694);
                        return;
                    }
                    a.this.sPK.sOR = true;
                    a.this.sPK.sPp.sUC = 1;
                    a.this.sPK.sPp.nwu = coi.wem;
                    a.this.sPK.sPp.nwv = coi.wen;
                    a.this.sPK.sPp.nwC = coi.xlS;
                    a.this.sPK.sPp.sUi = coi.xlW;
                    a.this.sPK.sPp.sUk = coi.xlX;
                    a.this.sPK.Gn(coi.xlU);
                    com.tencent.mm.plugin.voip.a.a.Logi(a.this.TAG, "ack ok, roomid =" + a.this.sPK.sPp.nwu + ",memberid = " + a.this.sPK.sPp.nwC);
                    final cpr cpr = coi.xlT;
                    if (cpr.nwQ > 0) {
                        cpr.nwQ--;
                        com.tencent.mm.plugin.voip.a.a.Logi(a.this.TAG, "zhengxue[ENCRYPT] got encryptStrategy[" + cpr.nwQ + "] from ackresp relaydata");
                    } else {
                        cpr.nwQ = 1;
                        com.tencent.mm.plugin.voip.a.a.Logi(a.this.TAG, "zhengxue[LOGIC]:got no EncryptStrategy in ackresp mrdata");
                    }
                    com.tencent.mm.plugin.voip.a.a.Logi(a.this.TAG, "ack with switchtcpcnt  =" + a.this.sPK.sPp.sUh + " RedirectReqThreshold =" + cpr.xnx + " BothSideSwitchFlag =" + cpr.xny + " WifiScanInterval =" + coi.xlX);
                    a.this.sPK.sPp.sVb = cpr.xny;
                    if (!(cpr.xnA == null || cpr.xnA.getBuffer() == null)) {
                        a.this.sPK.sPp.sUj = cpr.xnA.getBuffer().toByteArray();
                    }
                    a.this.sPK.Gm(cpr.xnc);
                    a.this.sPK.bo(cpr.xlM.vJd.getBuffer().toByteArray());
                    if (!(cpr.xnj == null || cpr.xnj.getBuffer() == null || cpr.xnv == null || cpr.xnv.getBuffer() == null)) {
                        a.this.sPK.a(cpr.xnj.getBuffer().toByteArray(), cpr.xni, cpr.nwQ, cpr.xnv.getBuffer().toByteArray());
                    }
                    a.this.sPK.i(cpr.xnm, cpr.xnn, cpr.xno, cpr.xnp, cpr.xnq);
                    a.this.sPK.bp(cpr.xlN.vJd.getBuffer().toByteArray());
                    g.RS().aa(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(4693);
                            a.this.sPK.a(cpr.xnd, cpr.xne, cpr.xnl, cpr.xnE);
                            a.this.sPK.Gl(cpr.xnu);
                            a.this.sPK.Gk(cpr.xnx);
                            if (!(cpr.xns == null || cpr.xnt == null)) {
                                a.this.sPK.b(cpr.xnr, cpr.xns.getBuffer().toByteArray(), cpr.xnt.getBuffer().toByteArray());
                            }
                            com.tencent.mm.plugin.voip.a.a.Logi(a.this.TAG, "ack success, try connect channel");
                            a.this.sPK.cIT();
                            AppMethodBeat.o(4693);
                        }
                    });
                    AppMethodBeat.o(4694);
                } else if (i == 4) {
                    a.this.sPK.sPp.sVH.sQe = 12;
                    a.this.sPK.sPp.sVH.sQf = i2;
                    a.this.sPK.v(1, i2, "");
                    AppMethodBeat.o(4694);
                } else {
                    a.this.sPK.sPp.sVH.sQe = 12;
                    a.this.sPK.sPp.sVH.sQf = i2;
                    a.this.sPK.v(1, -9004, "");
                    AppMethodBeat.o(4694);
                }
            }
        };
        AppMethodBeat.o(4696);
        return anonymousClass1;
    }
}
