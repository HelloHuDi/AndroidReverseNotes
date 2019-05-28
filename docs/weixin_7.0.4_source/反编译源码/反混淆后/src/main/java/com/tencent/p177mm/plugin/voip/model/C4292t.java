package com.tencent.p177mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.voip.C43727b;
import com.tencent.p177mm.plugin.voip.model.p746a.C24846m;
import com.tencent.p177mm.plugin.voip.p1417a.C46317a;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.awi;
import com.tencent.p177mm.protocal.protobuf.cpf;
import com.tencent.p177mm.protocal.protobuf.cpg;
import com.tencent.p177mm.protocal.protobuf.cpr;
import com.tencent.p177mm.protocal.protobuf.cpx;
import com.tencent.p177mm.protocal.protobuf.cqi;
import com.tencent.p177mm.protocal.protobuf.cqk;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.IOException;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.voip.model.t */
public final class C4292t {
    C14047k sNl = null;
    private int sTA = 0;
    cpr sTy = new cpr();
    private cpg sTz = null;

    public C4292t(C14047k c14047k) {
        AppMethodBeat.m2504i(4682);
        this.sNl = c14047k;
        AppMethodBeat.m2505o(4682);
    }

    /* renamed from: GB */
    public final void mo9301GB(int i) {
        AppMethodBeat.m2504i(4683);
        byte[] GF = C46317a.m86980GF(i);
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        sKBuiltinBuffer_t.setBuffer(GF);
        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
        try {
            sKBuiltinBuffer_t2.setBuffer(sKBuiltinBuffer_t.toByteArray());
            cpf cpf = new cpf();
            cpf.wat = 3;
            cpf.wau = sKBuiltinBuffer_t2;
            cpf.ndG = C1853r.m3846Yz();
            cpg cpg = new cpg();
            cpg.jBv = 1;
            cpg.jBw.add(cpf);
            mo9302a(cpg, false, 4);
            AppMethodBeat.m2505o(4683);
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e, "", new Object[0]);
            AppMethodBeat.m2505o(4683);
        }
    }

    /* renamed from: a */
    private void m6653a(cpg cpg) {
        AppMethodBeat.m2504i(4684);
        if (cpg == null) {
            C46317a.Loge("MicroMsg.Voip.VoipSyncHandle", "failed to pushVoipCmdList , VoipCmdList = null");
            this.sTA++;
            AppMethodBeat.m2505o(4684);
            return;
        }
        if (this.sTz == null) {
            this.sTz = new cpg();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < cpg.jBv) {
                this.sTz.jBw.add((cpf) cpg.jBw.get(i2));
                i = i2 + 1;
            } else {
                this.sTz.jBv = this.sTz.jBw.size();
                AppMethodBeat.m2505o(4684);
                return;
            }
        }
    }

    /* renamed from: b */
    private void m6654b(cpg cpg) {
        AppMethodBeat.m2504i(4685);
        if (this.sTz == null || this.sTz.jBv <= 0) {
            AppMethodBeat.m2505o(4685);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.sTz.jBv) {
                cpg.jBw.add((cpf) this.sTz.jBw.get(i2));
                i = i2 + 1;
            } else {
                cpg.jBv = cpg.jBw.size();
                cKs();
                AppMethodBeat.m2505o(4685);
                return;
            }
        }
    }

    public final void cKs() {
        AppMethodBeat.m2504i(4686);
        if (this.sTz == null) {
            AppMethodBeat.m2505o(4686);
            return;
        }
        this.sTz.jBw.clear();
        this.sTz.jBv = 0;
        this.sTz = null;
        this.sTA = 0;
        AppMethodBeat.m2505o(4686);
    }

    /* renamed from: a */
    public final int mo9302a(cpg cpg, boolean z, int i) {
        AppMethodBeat.m2504i(4687);
        if (this.sNl.sPp.nwu == 0) {
            C46317a.Loge("MicroMsg.Voip.VoipSyncHandle", C1447g.m3075Mq() + "failed to do voip sync , roomid = 0");
            AppMethodBeat.m2505o(4687);
        } else if (this.sNl.sPv) {
            C46317a.Loge("MicroMsg.Voip.VoipSyncHandle", C1447g.m3075Mq() + "voip syncing, push to cache...");
            m6653a(cpg);
            AppMethodBeat.m2505o(4687);
        } else {
            cpg cpg2;
            this.sNl.sPv = true;
            if (cpg == null) {
                cpg2 = new cpg();
                cpg2.jBv = 0;
                cpg2.jBw = new LinkedList();
            } else {
                cpg2 = cpg;
            }
            m6654b(cpg2);
            this.sTA = 0;
            if (this.sNl.sPt == null) {
                this.sNl.sPt = "".getBytes();
            }
            C46317a.Logi("MicroMsg.Voip.VoipSyncHandle", "____doVoipSync, fromjni:" + z + ",cmdList:" + cpg2.jBv + ",syncKey.length:" + this.sNl.sPt.length + ",selector:" + i);
            new C24846m(this.sNl.sPp.nwu, cpg2, this.sNl.sPt, this.sNl.sPp.nwv, i).cKw();
            AppMethodBeat.m2505o(4687);
        }
        return 0;
    }

    /* renamed from: a */
    public final void mo9304a(cqi cqi, int i) {
        AppMethodBeat.m2504i(4688);
        C46317a.Logi("MicroMsg.Voip.VoipSyncHandle", "onStatusChanged:  status:" + cqi.jBT);
        if (cqi.jBT == 1) {
            this.sNl.sOO = true;
            if (1 == i) {
                this.sNl.sPp.sVH.cJb();
            }
            if (3 == i) {
                this.sNl.sPp.sVH.cJc();
            }
            C46317a.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[DataAccept]onVoipSyncStatus:ACCEPTdata Flag: ".concat(String.valueOf(i)));
            this.sNl.sPq.bGL();
            C43727b.cIj().sSP.cKr();
            this.sNl.sOP = true;
            if (this.sNl.sOR) {
                this.sNl.sOR = false;
                if (this.sNl.sON) {
                    C46317a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus:ACCEPT, pre-connect already success");
                    this.sNl.cIO();
                } else if (this.sNl.sOQ) {
                    C46317a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACCEPT, pre-connect already fail");
                    this.sNl.mo26330v(1, -9000, "");
                } else {
                    C46317a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACCEPT, pre-connect still connecting...");
                }
            }
            C7060h.pYm.mo8381e(11519, Integer.valueOf(C43727b.cIj().cJZ()), Long.valueOf(C43727b.cIj().cKa()), Long.valueOf(C43727b.cIj().cIK()), Integer.valueOf(2));
            this.sNl.cIT();
            this.sNl.cIV();
            AppMethodBeat.m2505o(4688);
        } else if (cqi.jBT == 6) {
            C46317a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACKED");
            C46317a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: try use pre-connect");
            this.sNl.sOR = true;
            this.sNl.sPp.sUC = 1;
            this.sNl.cIT();
            AppMethodBeat.m2505o(4688);
        } else if (cqi.jBT == 8) {
            C46317a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACK BUSY");
            this.sNl.sPp.sVH.sQf = 211;
            this.sNl.sPp.sVH.sQe = 11;
            this.sNl.sPp.sVH.sQq = 12;
            C7060h.pYm.mo8381e(11519, Integer.valueOf(C43727b.cIj().cJZ()), Long.valueOf(C43727b.cIj().cKa()), Long.valueOf(C43727b.cIj().cIK()), Integer.valueOf(3));
            this.sNl.mo26330v(1, 211, "");
            this.sNl.cIV();
            AppMethodBeat.m2505o(4688);
        } else if (cqi.jBT == 2) {
            C46317a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus...MM_VOIP_SYNC_STATUS_REJECT");
            this.sNl.sPp.sVH.sQe = 103;
            this.sNl.sPp.sVH.sQq = 4;
            this.sNl.sPp.sVH.sQx = (int) (System.currentTimeMillis() - this.sNl.sPp.sVH.beginTime);
            C7060h.pYm.mo8381e(11519, Integer.valueOf(C43727b.cIj().cJZ()), Long.valueOf(C43727b.cIj().cKa()), Long.valueOf(C43727b.cIj().cIK()), Integer.valueOf(1));
            this.sNl.cIV();
            this.sNl.mo26330v(4, 0, "");
            AppMethodBeat.m2505o(4688);
        } else if (cqi.jBT == 3) {
            this.sNl.sPp.sVH.sQq = 5;
            AppMethodBeat.m2505o(4688);
        } else if (cqi.jBT == 4) {
            C46317a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus...MM_VOIP_SYNC_STATUS_SHUTDOWN");
            if (this.sNl.mStatus < 6) {
                this.sNl.sPp.sVH.sQr = 1;
            }
            this.sNl.sPp.sVH.sQe = 110;
            this.sNl.mo26330v(6, 0, "");
            this.sNl.cIV();
            AppMethodBeat.m2505o(4688);
        } else {
            C46317a.Logi("MicroMsg.Voip.VoipSyncHandle", "onStatusChanged: unknow status:" + cqi.jBT);
            AppMethodBeat.m2505o(4688);
        }
    }

    /* renamed from: a */
    public final void mo9303a(final cpx cpx) {
        AppMethodBeat.m2504i(4689);
        C1720g.m3539RS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(4681);
                C46317a.Logi("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData begin");
                try {
                    cpr cpr = (cpr) new cpr().parseFrom(cpx.vJd.getBuffer().toByteArray());
                    if (!(cpr.xlM == null || cpr.xlM.vJd == null || cpr.xlM.vJd.getBuffer() == null)) {
                        C4292t.this.sTy.xlM = cpr.xlM;
                    }
                    if (!(cpr.xlN.vJd == null || cpr.xlN.vJd.getBuffer() == null)) {
                        C4292t.this.sTy.xlN = cpr.xlN;
                    }
                    if (cpr.xnc != 0) {
                        C4292t.this.sTy.xnc = cpr.xnc;
                    }
                    if (!(cpr.xnd == null || cpr.xnd.xlZ == 0)) {
                        C4292t.this.sTy.xnd = cpr.xnd;
                    }
                    if (!(cpr.xne == null || cpr.xne.xlZ == 0)) {
                        C4292t.this.sTy.xne = cpr.xne;
                    }
                    if (!(cpr.xnE == null || cpr.xnE.size() == 0)) {
                        C4292t.this.sTy.xnE = cpr.xnE;
                        C4292t.this.sTy.xnD = cpr.xnE.size();
                    }
                    if (cpr.xng != 0) {
                        C4292t.this.sTy.xng = cpr.xng;
                    }
                    if (cpr.xnh != 0) {
                        C4292t.this.sTy.xnh = cpr.xnh;
                    }
                    if (cpr.xnl.xlZ != 0) {
                        C4292t.this.sTy.xnl = cpr.xnl;
                    }
                    if (cpr.xnm > 0) {
                        C4292t.this.sTy.xnm = cpr.xnm;
                    } else {
                        C4292t.this.sTy.xnm = 0;
                        C46317a.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no ARQstrategy in mrdata");
                    }
                    if (cpr.nwQ > 0) {
                        C4292t.this.sTy.nwQ = cpr.nwQ - 1;
                        C46317a.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[ENCRYPT] got encryptStrategy[" + C4292t.this.sTy.nwQ + "] from relaydata");
                    } else {
                        C4292t.this.sTy.nwQ = 1;
                        C46317a.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no EncryptStrategy in mrdata");
                    }
                    if (cpr.xnn > 0) {
                        C4292t.this.sTy.xnn = cpr.xnn;
                        C4292t.this.sTy.xno = cpr.xno;
                        C4292t.this.sTy.xnp = cpr.xnp;
                        C4292t.this.sTy.xnq = cpr.xnq;
                        C46317a.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got ARQCacheLen: " + cpr.xnn + ", ARQRttThreshold: " + cpr.xno + ", ARQUsedRateThreshold: " + cpr.xnp + ", ARQRespRateThreshold: " + cpr.xnq);
                    } else {
                        C46317a.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no ARQKeyParameters in mrdata");
                    }
                    if (cpr.xnu > 0) {
                        C4292t.this.sTy.xnu = cpr.xnu;
                    } else {
                        C4292t.this.sTy.xnu = 0;
                        C46317a.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no QosStrategy in mrdata");
                    }
                    C4292t.this.sTy.xnx = cpr.xnx;
                    if (cpr.xnz != null) {
                        C4292t.this.sTy.xnz = cpr.xnz;
                    }
                    C4292t.this.sTy.xnC = cpr.xnC;
                    C4292t.this.sTy.xnB = cpr.xnB;
                    C4292t.this.sNl.sPB.mo69415a(cpr.xnC, cpr.xnB, C4292t.this.sNl.sPp.nwu, C4292t.this.sNl.sPp.nwv);
                    int i = (C4292t.this.sTy.xlM == null || C4292t.this.sTy.xlM.vJd == null || C4292t.this.sTy.xlM.vJd.getBuffer() == null || C4292t.this.sTy.xnc == 0 || C4292t.this.sTy.xlN == null || C4292t.this.sTy.xlN.vJd == null || C4292t.this.sTy.xlN.vJd.getBuffer() == null || C4292t.this.sTy.xnd == null || C4292t.this.sTy.xnd.xlZ == 0 || C4292t.this.sTy.xne == null || C4292t.this.sTy.xne.xlZ == 0 || C4292t.this.sTy.xnl == null || C4292t.this.sTy.xnl.xlZ == 0) ? 0 : 1;
                    if (i == 0) {
                        C46317a.Logi("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData end");
                        AppMethodBeat.m2505o(4681);
                        return;
                    }
                    C46317a.Logi("MicroMsg.Voip.VoipSyncHandle", "multiRelayData recv all, update. RedirectReqThreshold = " + C4292t.this.sTy.xnx + " BothSideSwitchFlag = " + cpr.xny);
                    C4292t.this.sNl.mo26295Gm(C4292t.this.sTy.xnc);
                    C4292t.this.sNl.mo26303bo(C4292t.this.sTy.xlM.vJd.getBuffer().toByteArray());
                    if (!(cpr.xnj == null || cpr.xnj.getBuffer() == null || cpr.xnv == null || cpr.xnv.getBuffer() == null)) {
                        C4292t.this.sNl.mo26299a(cpr.xnj.getBuffer().toByteArray(), cpr.xni, C4292t.this.sTy.nwQ, cpr.xnv.getBuffer().toByteArray());
                    }
                    if (C43727b.cIj().cJZ() != 0) {
                        C4292t.this.sNl.mo26304bp(C4292t.this.sTy.xlN.vJd.getBuffer().toByteArray());
                    }
                    C46317a.Logi("MicroMsg.Voip.VoipSyncHandle", "onMultiRelayData natsvr =" + C4292t.this.sTy.xnD);
                    C4292t.this.sNl.mo26298a(C4292t.this.sTy.xnd, C4292t.this.sTy.xne, C4292t.this.sTy.xnl, C4292t.this.sTy.xnE);
                    C4292t.this.sNl.mo26323i(C4292t.this.sTy.xnm, C4292t.this.sTy.xnn, C4292t.this.sTy.xno, C4292t.this.sTy.xnp, C4292t.this.sTy.xnq);
                    C4292t.this.sNl.mo26294Gl(C4292t.this.sTy.xnu);
                    C14047k c14047k = C4292t.this.sNl;
                    int i2 = C4292t.this.sTy.xng;
                    int i3 = C4292t.this.sTy.xnh;
                    c14047k.sPp.sUf = i2;
                    c14047k.sPp.sUg = i3;
                    C4292t.this.sNl.mo26293Gk(C4292t.this.sTy.xnx);
                    C4292t.this.sNl.sPp.sVb = cpr.xny;
                    if (!(cpr.xnA == null || cpr.xnA.getBuffer() == null)) {
                        C4292t.this.sNl.sPp.sUj = cpr.xnA.getBuffer().toByteArray();
                    }
                    if (!(cpr.xns == null || cpr.xns.getBuffer() == null || cpr.xnt == null || cpr.xnt.getBuffer() == null)) {
                        C4292t.this.sNl.mo26302b(cpr.xnr, cpr.xns.getBuffer().toByteArray(), cpr.xnt.getBuffer().toByteArray());
                    }
                    c14047k = C4292t.this.sNl;
                    awi awi = C4292t.this.sTy.xnz;
                    v2protocal v2protocal = c14047k.sPp;
                    C46317a.Logd("MicroMsg.Voip", "v2protocal updateJbmBitrateRsSvrParam BitrateFlag : " + awi.wzZ + " Bitrate: " + awi.wAa);
                    v2protocal.field_jbmParamArraySize = 27;
                    v2protocal.field_jbmBitratRsSvrParamArray = new int[v2protocal.field_jbmParamArraySize];
                    v2protocal.field_jbmBitratRsSvrParamArray[0] = awi.wzY;
                    v2protocal.field_jbmBitratRsSvrParamArray[1] = awi.wzZ;
                    v2protocal.field_jbmBitratRsSvrParamArray[2] = awi.wAa;
                    v2protocal.field_jbmBitratRsSvrParamArray[3] = awi.wAb;
                    v2protocal.field_jbmBitratRsSvrParamArray[4] = awi.wAc;
                    v2protocal.field_jbmBitratRsSvrParamArray[5] = awi.wAd;
                    v2protocal.field_jbmBitratRsSvrParamArray[6] = awi.wAe;
                    v2protocal.field_jbmBitratRsSvrParamArray[7] = awi.wAh;
                    v2protocal.field_jbmBitratRsSvrParamArray[8] = awi.wAi;
                    v2protocal.field_jbmBitratRsSvrParamArray[9] = awi.wAl;
                    v2protocal.field_jbmBitratRsSvrParamArray[10] = awi.wAm;
                    v2protocal.field_jbmBitratRsSvrParamArray[11] = awi.wAp;
                    v2protocal.field_jbmBitratRsSvrParamArray[12] = awi.wAq;
                    v2protocal.field_jbmBitratRsSvrParamArray[13] = awi.wAt;
                    v2protocal.field_jbmBitratRsSvrParamArray[14] = awi.wAu;
                    v2protocal.field_jbmBitratRsSvrParamArray[15] = awi.wAx;
                    v2protocal.field_jbmBitratRsSvrParamArray[16] = awi.wAy;
                    v2protocal.field_jbmBitratRsSvrParamArray[17] = awi.wAB;
                    v2protocal.field_jbmBitratRsSvrParamArray[18] = awi.wAC;
                    v2protocal.field_jbmBitratRsSvrParamArray[19] = awi.wAF;
                    v2protocal.field_jbmBitratRsSvrParamArray[20] = awi.wAG;
                    v2protocal.field_jbmBitratRsSvrParamArray[21] = awi.wAJ;
                    v2protocal.field_jbmBitratRsSvrParamArray[22] = awi.wAK;
                    v2protocal.field_jbmBitratRsSvrParamArray[23] = awi.wAN;
                    v2protocal.field_jbmBitratRsSvrParamArray[24] = awi.wAO;
                    v2protocal.field_jbmBitratRsSvrParamArray[25] = awi.wAR;
                    v2protocal.field_jbmBitratRsSvrParamArray[26] = awi.wAS;
                    v2protocal.field_jbmParamDoubleArraySize = 20;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray = new double[v2protocal.field_jbmParamDoubleArraySize];
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[0] = awi.wAf;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[1] = awi.wAg;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[2] = awi.wAj;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[3] = awi.wAk;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[4] = awi.wAn;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[5] = awi.wAo;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[6] = awi.wAr;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[7] = awi.wAs;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[8] = awi.wAv;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[9] = awi.wAw;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[10] = awi.wAz;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[11] = awi.wAA;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[12] = awi.wAD;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[13] = awi.wAE;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[14] = awi.wAH;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[15] = awi.wAI;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[16] = awi.wAL;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[17] = awi.wAM;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[18] = awi.wAP;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[19] = awi.wAQ;
                    C4292t.this.sNl.cIT();
                    C46317a.Logi("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData end");
                    AppMethodBeat.m2505o(4681);
                } catch (IOException e) {
                    C4990ab.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e, "", new Object[0]);
                    AppMethodBeat.m2505o(4681);
                }
            }
        });
        AppMethodBeat.m2505o(4689);
    }

    /* renamed from: b */
    public final void mo9305b(cpx cpx) {
        AppMethodBeat.m2504i(4690);
        this.sNl.mo26305bq(cpx.vJd.getBuffer().toByteArray());
        AppMethodBeat.m2505o(4690);
    }

    /* renamed from: c */
    public final void mo9306c(SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        AppMethodBeat.m2504i(4691);
        int bv = C46317a.m86990bv(sKBuiltinBuffer_t.getBuffer().toByteArray());
        C46317a.Logi("MicroMsg.Voip.VoipSyncHandle", "voipSync remote status changed, status = ".concat(String.valueOf(bv)));
        this.sNl.mo26289Gg(bv & 255);
        AppMethodBeat.m2505o(4691);
    }

    /* renamed from: q */
    public final void mo9308q(C1207m c1207m) {
        AppMethodBeat.m2504i(4692);
        C4990ab.m7416i("MicroMsg.Voip.VoipSyncHandle", "____VoipSyncResp");
        this.sNl.sPv = false;
        cqk cqk = (cqk) ((C24846m) c1207m).cKx();
        this.sNl.sPp.parseSyncKeyBuff(this.sNl.sPt, this.sNl.sPt.length);
        int i = this.sNl.sPp.field_statusSyncKey;
        int i2 = this.sNl.sPp.field_relayDataSyncKey;
        int i3 = this.sNl.sPp.field_connectingStatusKey;
        this.sNl.sPp.parseSyncKeyBuff(cqk.vTO.getBuffer().toByteArray(), cqk.vTO.getILen());
        int i4 = this.sNl.sPp.field_statusSyncKey;
        int i5 = this.sNl.sPp.field_relayDataSyncKey;
        int i6 = this.sNl.sPp.field_connectingStatusKey;
        C4990ab.m7416i("MicroMsg.Voip.VoipSyncHandle", "VoipSyncResp: oldStatusSyncKey:" + i + " oldRelayDataSyncKey:" + i2 + " oldConnectingStatusSyncKey:" + i3);
        C4990ab.m7416i("MicroMsg.Voip.VoipSyncHandle", "VoipSyncResp: newStatusSyncKey:" + i4 + " newRelayDataSyncKey:" + i5 + " newConnectingStatusSyncKey:" + i6);
        this.sNl.sPt = cqk.vTO.getBuffer().toByteArray();
        C4990ab.m7416i("MicroMsg.Voip.VoipSyncHandle", "voipSync response: continueflag=" + cqk.vQe);
        LinkedList linkedList = cqk.xor.jBw;
        if (linkedList != null && linkedList.size() != 0) {
            C4990ab.m7416i("MicroMsg.Voip.VoipSyncHandle", " syncOnSceneEnd cmdlist size" + linkedList.size());
            C4990ab.m7416i("MicroMsg.Voip.VoipSyncHandle", " syncOnSceneEnd cmdlist size:" + linkedList.size() + ",selector = " + ((C24846m) c1207m).cKv());
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= linkedList.size()) {
                    break;
                }
                cpf cpf = (cpf) linkedList.get(i8);
                int i9 = cpf.wat;
                C4990ab.m7416i("MicroMsg.Voip.VoipSyncHandle", "__parse sync resp, item cmdid:".concat(String.valueOf(i9)));
                if (i9 == 1) {
                    if (i4 > i) {
                        if (this.sNl.sPp.nwu == 0) {
                            C46317a.Loge("MicroMsg.Voip.VoipSyncHandle", "voipSyncStatus ignored , roomid = 0");
                        } else {
                            try {
                                cqi cqi = (cqi) new cqi().parseFrom(cpf.wau.getBuffer().toByteArray());
                                C46317a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus in...from user=" + cpf.ndG + ",itemStatus =  " + cqi.jBT);
                                mo9304a(cqi, 3);
                            } catch (IOException e) {
                                C4990ab.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e, "", new Object[0]);
                            }
                        }
                    }
                } else if (i9 == 2) {
                    if (i5 > i2) {
                        if (this.sNl.sPp.nwu == 0) {
                            C46317a.Loge("MicroMsg.Voip.VoipSyncHandle", "RelayData ignored , roomid = 0");
                        } else {
                            try {
                                cpx cpx = (cpx) new cpx().parseFrom(cpf.wau.getBuffer().toByteArray());
                                C46317a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncRelayData ...relayType = " + cpx.jCt + ",from user = " + cpf.ndG);
                                if (cpx.jCt == 5) {
                                    mo9303a(cpx);
                                } else if (cpx.jCt == 3) {
                                    this.sNl.mo26304bp(cpx.vJd.getBuffer().toByteArray());
                                    if (!(cpx.vJd == null || cpx.vJd.getBuffer() == null)) {
                                        this.sTy.xlN = cpx;
                                    }
                                } else if (cpx.jCt == 2) {
                                    this.sNl.mo26303bo(cpx.vJd.getBuffer().toByteArray());
                                    if (!(cpx.vJd == null || cpx.vJd.getBuffer() == null)) {
                                        this.sTy.xlM = cpx;
                                    }
                                } else if (cpx.jCt == 1) {
                                    mo9305b(cpx);
                                }
                            } catch (IOException e2) {
                                C4990ab.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e2, "", new Object[0]);
                            }
                        }
                    }
                } else if (i9 == 3 && i6 > i3) {
                    if (this.sNl.sPp.nwu == 0) {
                        C4990ab.m7412e("MicroMsg.Voip.VoipSyncHandle", "voipSync(ClientStatus) ignored , roomid = 0");
                    } else {
                        try {
                            SKBuiltinBuffer_t parseFrom = new SKBuiltinBuffer_t().parseFrom(cpf.wau.getBuffer().toByteArray());
                            if (cpf.ndG.equals(C1853r.m3846Yz())) {
                                C46317a.Loge("MicroMsg.Voip.VoipSyncHandle", "svr response: local connecting status changed.");
                            } else {
                                mo9306c(parseFrom);
                            }
                        } catch (IOException e22) {
                            C4990ab.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e22, "", new Object[0]);
                        }
                    }
                }
                i7 = i8 + 1;
            }
        }
        C4990ab.m7416i("MicroMsg.Voip.VoipSyncHandle", "__parse sync resp end");
        if ((this.sTz != null && this.sTz.jBv > 0) || this.sTA > 0) {
            mo9302a(null, false, 7);
        }
        AppMethodBeat.m2505o(4692);
    }
}
