package com.tencent.p177mm.plugin.voip.model.p746a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.misc.p994a.C12534a;
import com.tencent.p177mm.plugin.voip.p1417a.C46317a;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.coh;
import com.tencent.p177mm.protocal.protobuf.coi;
import com.tencent.p177mm.protocal.protobuf.cpr;
import com.tencent.p177mm.protocal.protobuf.cpx;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.plugin.voip.model.a.a */
public final class C35349a extends C22456n<coh, coi> {
    String TAG = "MicroMsg.NetSceneVoipAck";

    /* renamed from: com.tencent.mm.plugin.voip.model.a.a$1 */
    class C353501 implements C1202f {
        C353501() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(4694);
            C46317a.Logi(C35349a.this.TAG, "ack response:" + i + " errCode:" + i2 + " status:" + C35349a.this.sPK.mStatus);
            if (C35349a.this.sPK.mStatus == 1) {
                C46317a.Logi(C35349a.this.TAG, "reject ok!");
                AppMethodBeat.m2505o(4694);
            } else if (C35349a.this.sPK.mStatus != 3) {
                C46317a.Loge(C35349a.this.TAG, "ack response not within WAITCONNECT, ignored.");
                AppMethodBeat.m2505o(4694);
            } else if (i == 0) {
                coi coi = (coi) C35349a.this.cKx();
                if (coi.xlL != 1) {
                    C46317a.Logi(C35349a.this.TAG, "onVoipAckResp: do not use preconnect");
                    AppMethodBeat.m2505o(4694);
                    return;
                }
                C35349a.this.sPK.sOR = true;
                C35349a.this.sPK.sPp.sUC = 1;
                C35349a.this.sPK.sPp.nwu = coi.wem;
                C35349a.this.sPK.sPp.nwv = coi.wen;
                C35349a.this.sPK.sPp.nwC = coi.xlS;
                C35349a.this.sPK.sPp.sUi = coi.xlW;
                C35349a.this.sPK.sPp.sUk = coi.xlX;
                C35349a.this.sPK.mo26296Gn(coi.xlU);
                C46317a.Logi(C35349a.this.TAG, "ack ok, roomid =" + C35349a.this.sPK.sPp.nwu + ",memberid = " + C35349a.this.sPK.sPp.nwC);
                final cpr cpr = coi.xlT;
                if (cpr.nwQ > 0) {
                    cpr.nwQ--;
                    C46317a.Logi(C35349a.this.TAG, "zhengxue[ENCRYPT] got encryptStrategy[" + cpr.nwQ + "] from ackresp relaydata");
                } else {
                    cpr.nwQ = 1;
                    C46317a.Logi(C35349a.this.TAG, "zhengxue[LOGIC]:got no EncryptStrategy in ackresp mrdata");
                }
                C46317a.Logi(C35349a.this.TAG, "ack with switchtcpcnt  =" + C35349a.this.sPK.sPp.sUh + " RedirectReqThreshold =" + cpr.xnx + " BothSideSwitchFlag =" + cpr.xny + " WifiScanInterval =" + coi.xlX);
                C35349a.this.sPK.sPp.sVb = cpr.xny;
                if (!(cpr.xnA == null || cpr.xnA.getBuffer() == null)) {
                    C35349a.this.sPK.sPp.sUj = cpr.xnA.getBuffer().toByteArray();
                }
                C35349a.this.sPK.mo26295Gm(cpr.xnc);
                C35349a.this.sPK.mo26303bo(cpr.xlM.vJd.getBuffer().toByteArray());
                if (!(cpr.xnj == null || cpr.xnj.getBuffer() == null || cpr.xnv == null || cpr.xnv.getBuffer() == null)) {
                    C35349a.this.sPK.mo26299a(cpr.xnj.getBuffer().toByteArray(), cpr.xni, cpr.nwQ, cpr.xnv.getBuffer().toByteArray());
                }
                C35349a.this.sPK.mo26323i(cpr.xnm, cpr.xnn, cpr.xno, cpr.xnp, cpr.xnq);
                C35349a.this.sPK.mo26304bp(cpr.xlN.vJd.getBuffer().toByteArray());
                C1720g.m3539RS().mo10302aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(4693);
                        C35349a.this.sPK.mo26298a(cpr.xnd, cpr.xne, cpr.xnl, cpr.xnE);
                        C35349a.this.sPK.mo26294Gl(cpr.xnu);
                        C35349a.this.sPK.mo26293Gk(cpr.xnx);
                        if (!(cpr.xns == null || cpr.xnt == null)) {
                            C35349a.this.sPK.mo26302b(cpr.xnr, cpr.xns.getBuffer().toByteArray(), cpr.xnt.getBuffer().toByteArray());
                        }
                        C46317a.Logi(C35349a.this.TAG, "ack success, try connect channel");
                        C35349a.this.sPK.cIT();
                        AppMethodBeat.m2505o(4693);
                    }
                });
                AppMethodBeat.m2505o(4694);
            } else if (i == 4) {
                C35349a.this.sPK.sPp.sVH.sQe = 12;
                C35349a.this.sPK.sPp.sVH.sQf = i2;
                C35349a.this.sPK.mo26330v(1, i2, "");
                AppMethodBeat.m2505o(4694);
            } else {
                C35349a.this.sPK.sPp.sVH.sQe = 12;
                C35349a.this.sPK.sPp.sVH.sQf = i2;
                C35349a.this.sPK.mo26330v(1, -9004, "");
                AppMethodBeat.m2505o(4694);
            }
        }
    }

    public C35349a(int i, long j, int i2, byte[] bArr, byte[] bArr2, String str) {
        AppMethodBeat.m2504i(4695);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new coh();
        c1196a.fsK = new coi();
        c1196a.uri = "/cgi-bin/micromsg-bin/voipack";
        c1196a.fsI = C31128d.MIC_PTU_QINGCHENG;
        c1196a.fsL = 123;
        c1196a.fsM = 1000000123;
        this.ehh = c1196a.acD();
        coh coh = (coh) this.ehh.fsG.fsP;
        coh.wem = i;
        coh.wen = j;
        coh.xlP = i2;
        if (i2 != 1) {
            coh.xlL = 0;
            AppMethodBeat.m2505o(4695);
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
        int bOK = ((C12534a) C1720g.m3528K(C12534a.class)).bOK();
        C4990ab.m7417i(this.TAG, "simType: %s", Integer.valueOf(bOK));
        bOK = bOK == 0 ? 0 : bOK == 1 ? 1 : 2;
        coh.xlR = bOK;
        AppMethodBeat.m2505o(4695);
    }

    public final int getType() {
        return C31128d.MIC_PTU_QINGCHENG;
    }

    public final C1202f cKt() {
        AppMethodBeat.m2504i(4696);
        C353501 c353501 = new C353501();
        AppMethodBeat.m2505o(4696);
        return c353501;
    }
}
