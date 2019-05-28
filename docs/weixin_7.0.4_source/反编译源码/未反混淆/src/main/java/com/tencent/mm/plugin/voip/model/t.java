package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.b;
import com.tencent.mm.plugin.voip.model.a.m;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.mm.protocal.protobuf.cpf;
import com.tencent.mm.protocal.protobuf.cpg;
import com.tencent.mm.protocal.protobuf.cpr;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.protocal.protobuf.cqi;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import java.util.LinkedList;

public final class t {
    k sNl = null;
    private int sTA = 0;
    cpr sTy = new cpr();
    private cpg sTz = null;

    public t(k kVar) {
        AppMethodBeat.i(4682);
        this.sNl = kVar;
        AppMethodBeat.o(4682);
    }

    public final void GB(int i) {
        AppMethodBeat.i(4683);
        byte[] GF = a.GF(i);
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        sKBuiltinBuffer_t.setBuffer(GF);
        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
        try {
            sKBuiltinBuffer_t2.setBuffer(sKBuiltinBuffer_t.toByteArray());
            cpf cpf = new cpf();
            cpf.wat = 3;
            cpf.wau = sKBuiltinBuffer_t2;
            cpf.ndG = r.Yz();
            cpg cpg = new cpg();
            cpg.jBv = 1;
            cpg.jBw.add(cpf);
            a(cpg, false, 4);
            AppMethodBeat.o(4683);
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e, "", new Object[0]);
            AppMethodBeat.o(4683);
        }
    }

    private void a(cpg cpg) {
        AppMethodBeat.i(4684);
        if (cpg == null) {
            a.Loge("MicroMsg.Voip.VoipSyncHandle", "failed to pushVoipCmdList , VoipCmdList = null");
            this.sTA++;
            AppMethodBeat.o(4684);
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
                AppMethodBeat.o(4684);
                return;
            }
        }
    }

    private void b(cpg cpg) {
        AppMethodBeat.i(4685);
        if (this.sTz == null || this.sTz.jBv <= 0) {
            AppMethodBeat.o(4685);
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
                AppMethodBeat.o(4685);
                return;
            }
        }
    }

    public final void cKs() {
        AppMethodBeat.i(4686);
        if (this.sTz == null) {
            AppMethodBeat.o(4686);
            return;
        }
        this.sTz.jBw.clear();
        this.sTz.jBv = 0;
        this.sTz = null;
        this.sTA = 0;
        AppMethodBeat.o(4686);
    }

    public final int a(cpg cpg, boolean z, int i) {
        AppMethodBeat.i(4687);
        if (this.sNl.sPp.nwu == 0) {
            a.Loge("MicroMsg.Voip.VoipSyncHandle", g.Mq() + "failed to do voip sync , roomid = 0");
            AppMethodBeat.o(4687);
        } else if (this.sNl.sPv) {
            a.Loge("MicroMsg.Voip.VoipSyncHandle", g.Mq() + "voip syncing, push to cache...");
            a(cpg);
            AppMethodBeat.o(4687);
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
            b(cpg2);
            this.sTA = 0;
            if (this.sNl.sPt == null) {
                this.sNl.sPt = "".getBytes();
            }
            a.Logi("MicroMsg.Voip.VoipSyncHandle", "____doVoipSync, fromjni:" + z + ",cmdList:" + cpg2.jBv + ",syncKey.length:" + this.sNl.sPt.length + ",selector:" + i);
            new m(this.sNl.sPp.nwu, cpg2, this.sNl.sPt, this.sNl.sPp.nwv, i).cKw();
            AppMethodBeat.o(4687);
        }
        return 0;
    }

    public final void a(cqi cqi, int i) {
        AppMethodBeat.i(4688);
        a.Logi("MicroMsg.Voip.VoipSyncHandle", "onStatusChanged:  status:" + cqi.jBT);
        if (cqi.jBT == 1) {
            this.sNl.sOO = true;
            if (1 == i) {
                this.sNl.sPp.sVH.cJb();
            }
            if (3 == i) {
                this.sNl.sPp.sVH.cJc();
            }
            a.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[DataAccept]onVoipSyncStatus:ACCEPTdata Flag: ".concat(String.valueOf(i)));
            this.sNl.sPq.bGL();
            b.cIj().sSP.cKr();
            this.sNl.sOP = true;
            if (this.sNl.sOR) {
                this.sNl.sOR = false;
                if (this.sNl.sON) {
                    a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus:ACCEPT, pre-connect already success");
                    this.sNl.cIO();
                } else if (this.sNl.sOQ) {
                    a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACCEPT, pre-connect already fail");
                    this.sNl.v(1, -9000, "");
                } else {
                    a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACCEPT, pre-connect still connecting...");
                }
            }
            h.pYm.e(11519, Integer.valueOf(b.cIj().cJZ()), Long.valueOf(b.cIj().cKa()), Long.valueOf(b.cIj().cIK()), Integer.valueOf(2));
            this.sNl.cIT();
            this.sNl.cIV();
            AppMethodBeat.o(4688);
        } else if (cqi.jBT == 6) {
            a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACKED");
            a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: try use pre-connect");
            this.sNl.sOR = true;
            this.sNl.sPp.sUC = 1;
            this.sNl.cIT();
            AppMethodBeat.o(4688);
        } else if (cqi.jBT == 8) {
            a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACK BUSY");
            this.sNl.sPp.sVH.sQf = 211;
            this.sNl.sPp.sVH.sQe = 11;
            this.sNl.sPp.sVH.sQq = 12;
            h.pYm.e(11519, Integer.valueOf(b.cIj().cJZ()), Long.valueOf(b.cIj().cKa()), Long.valueOf(b.cIj().cIK()), Integer.valueOf(3));
            this.sNl.v(1, 211, "");
            this.sNl.cIV();
            AppMethodBeat.o(4688);
        } else if (cqi.jBT == 2) {
            a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus...MM_VOIP_SYNC_STATUS_REJECT");
            this.sNl.sPp.sVH.sQe = 103;
            this.sNl.sPp.sVH.sQq = 4;
            this.sNl.sPp.sVH.sQx = (int) (System.currentTimeMillis() - this.sNl.sPp.sVH.beginTime);
            h.pYm.e(11519, Integer.valueOf(b.cIj().cJZ()), Long.valueOf(b.cIj().cKa()), Long.valueOf(b.cIj().cIK()), Integer.valueOf(1));
            this.sNl.cIV();
            this.sNl.v(4, 0, "");
            AppMethodBeat.o(4688);
        } else if (cqi.jBT == 3) {
            this.sNl.sPp.sVH.sQq = 5;
            AppMethodBeat.o(4688);
        } else if (cqi.jBT == 4) {
            a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus...MM_VOIP_SYNC_STATUS_SHUTDOWN");
            if (this.sNl.mStatus < 6) {
                this.sNl.sPp.sVH.sQr = 1;
            }
            this.sNl.sPp.sVH.sQe = 110;
            this.sNl.v(6, 0, "");
            this.sNl.cIV();
            AppMethodBeat.o(4688);
        } else {
            a.Logi("MicroMsg.Voip.VoipSyncHandle", "onStatusChanged: unknow status:" + cqi.jBT);
            AppMethodBeat.o(4688);
        }
    }

    public final void a(final cpx cpx) {
        AppMethodBeat.i(4689);
        com.tencent.mm.kernel.g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(4681);
                a.Logi("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData begin");
                try {
                    cpr cpr = (cpr) new cpr().parseFrom(cpx.vJd.getBuffer().toByteArray());
                    if (!(cpr.xlM == null || cpr.xlM.vJd == null || cpr.xlM.vJd.getBuffer() == null)) {
                        t.this.sTy.xlM = cpr.xlM;
                    }
                    if (!(cpr.xlN.vJd == null || cpr.xlN.vJd.getBuffer() == null)) {
                        t.this.sTy.xlN = cpr.xlN;
                    }
                    if (cpr.xnc != 0) {
                        t.this.sTy.xnc = cpr.xnc;
                    }
                    if (!(cpr.xnd == null || cpr.xnd.xlZ == 0)) {
                        t.this.sTy.xnd = cpr.xnd;
                    }
                    if (!(cpr.xne == null || cpr.xne.xlZ == 0)) {
                        t.this.sTy.xne = cpr.xne;
                    }
                    if (!(cpr.xnE == null || cpr.xnE.size() == 0)) {
                        t.this.sTy.xnE = cpr.xnE;
                        t.this.sTy.xnD = cpr.xnE.size();
                    }
                    if (cpr.xng != 0) {
                        t.this.sTy.xng = cpr.xng;
                    }
                    if (cpr.xnh != 0) {
                        t.this.sTy.xnh = cpr.xnh;
                    }
                    if (cpr.xnl.xlZ != 0) {
                        t.this.sTy.xnl = cpr.xnl;
                    }
                    if (cpr.xnm > 0) {
                        t.this.sTy.xnm = cpr.xnm;
                    } else {
                        t.this.sTy.xnm = 0;
                        a.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no ARQstrategy in mrdata");
                    }
                    if (cpr.nwQ > 0) {
                        t.this.sTy.nwQ = cpr.nwQ - 1;
                        a.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[ENCRYPT] got encryptStrategy[" + t.this.sTy.nwQ + "] from relaydata");
                    } else {
                        t.this.sTy.nwQ = 1;
                        a.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no EncryptStrategy in mrdata");
                    }
                    if (cpr.xnn > 0) {
                        t.this.sTy.xnn = cpr.xnn;
                        t.this.sTy.xno = cpr.xno;
                        t.this.sTy.xnp = cpr.xnp;
                        t.this.sTy.xnq = cpr.xnq;
                        a.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got ARQCacheLen: " + cpr.xnn + ", ARQRttThreshold: " + cpr.xno + ", ARQUsedRateThreshold: " + cpr.xnp + ", ARQRespRateThreshold: " + cpr.xnq);
                    } else {
                        a.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no ARQKeyParameters in mrdata");
                    }
                    if (cpr.xnu > 0) {
                        t.this.sTy.xnu = cpr.xnu;
                    } else {
                        t.this.sTy.xnu = 0;
                        a.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no QosStrategy in mrdata");
                    }
                    t.this.sTy.xnx = cpr.xnx;
                    if (cpr.xnz != null) {
                        t.this.sTy.xnz = cpr.xnz;
                    }
                    t.this.sTy.xnC = cpr.xnC;
                    t.this.sTy.xnB = cpr.xnB;
                    t.this.sNl.sPB.a(cpr.xnC, cpr.xnB, t.this.sNl.sPp.nwu, t.this.sNl.sPp.nwv);
                    int i = (t.this.sTy.xlM == null || t.this.sTy.xlM.vJd == null || t.this.sTy.xlM.vJd.getBuffer() == null || t.this.sTy.xnc == 0 || t.this.sTy.xlN == null || t.this.sTy.xlN.vJd == null || t.this.sTy.xlN.vJd.getBuffer() == null || t.this.sTy.xnd == null || t.this.sTy.xnd.xlZ == 0 || t.this.sTy.xne == null || t.this.sTy.xne.xlZ == 0 || t.this.sTy.xnl == null || t.this.sTy.xnl.xlZ == 0) ? 0 : 1;
                    if (i == 0) {
                        a.Logi("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData end");
                        AppMethodBeat.o(4681);
                        return;
                    }
                    a.Logi("MicroMsg.Voip.VoipSyncHandle", "multiRelayData recv all, update. RedirectReqThreshold = " + t.this.sTy.xnx + " BothSideSwitchFlag = " + cpr.xny);
                    t.this.sNl.Gm(t.this.sTy.xnc);
                    t.this.sNl.bo(t.this.sTy.xlM.vJd.getBuffer().toByteArray());
                    if (!(cpr.xnj == null || cpr.xnj.getBuffer() == null || cpr.xnv == null || cpr.xnv.getBuffer() == null)) {
                        t.this.sNl.a(cpr.xnj.getBuffer().toByteArray(), cpr.xni, t.this.sTy.nwQ, cpr.xnv.getBuffer().toByteArray());
                    }
                    if (b.cIj().cJZ() != 0) {
                        t.this.sNl.bp(t.this.sTy.xlN.vJd.getBuffer().toByteArray());
                    }
                    a.Logi("MicroMsg.Voip.VoipSyncHandle", "onMultiRelayData natsvr =" + t.this.sTy.xnD);
                    t.this.sNl.a(t.this.sTy.xnd, t.this.sTy.xne, t.this.sTy.xnl, t.this.sTy.xnE);
                    t.this.sNl.i(t.this.sTy.xnm, t.this.sTy.xnn, t.this.sTy.xno, t.this.sTy.xnp, t.this.sTy.xnq);
                    t.this.sNl.Gl(t.this.sTy.xnu);
                    k kVar = t.this.sNl;
                    int i2 = t.this.sTy.xng;
                    int i3 = t.this.sTy.xnh;
                    kVar.sPp.sUf = i2;
                    kVar.sPp.sUg = i3;
                    t.this.sNl.Gk(t.this.sTy.xnx);
                    t.this.sNl.sPp.sVb = cpr.xny;
                    if (!(cpr.xnA == null || cpr.xnA.getBuffer() == null)) {
                        t.this.sNl.sPp.sUj = cpr.xnA.getBuffer().toByteArray();
                    }
                    if (!(cpr.xns == null || cpr.xns.getBuffer() == null || cpr.xnt == null || cpr.xnt.getBuffer() == null)) {
                        t.this.sNl.b(cpr.xnr, cpr.xns.getBuffer().toByteArray(), cpr.xnt.getBuffer().toByteArray());
                    }
                    kVar = t.this.sNl;
                    awi awi = t.this.sTy.xnz;
                    v2protocal v2protocal = kVar.sPp;
                    a.Logd("MicroMsg.Voip", "v2protocal updateJbmBitrateRsSvrParam BitrateFlag : " + awi.wzZ + " Bitrate: " + awi.wAa);
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
                    t.this.sNl.cIT();
                    a.Logi("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData end");
                    AppMethodBeat.o(4681);
                } catch (IOException e) {
                    ab.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e, "", new Object[0]);
                    AppMethodBeat.o(4681);
                }
            }
        });
        AppMethodBeat.o(4689);
    }

    public final void b(cpx cpx) {
        AppMethodBeat.i(4690);
        this.sNl.bq(cpx.vJd.getBuffer().toByteArray());
        AppMethodBeat.o(4690);
    }

    public final void c(SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        AppMethodBeat.i(4691);
        int bv = a.bv(sKBuiltinBuffer_t.getBuffer().toByteArray());
        a.Logi("MicroMsg.Voip.VoipSyncHandle", "voipSync remote status changed, status = ".concat(String.valueOf(bv)));
        this.sNl.Gg(bv & 255);
        AppMethodBeat.o(4691);
    }

    public final void q(com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(4692);
        ab.i("MicroMsg.Voip.VoipSyncHandle", "____VoipSyncResp");
        this.sNl.sPv = false;
        cqk cqk = (cqk) ((m) mVar).cKx();
        this.sNl.sPp.parseSyncKeyBuff(this.sNl.sPt, this.sNl.sPt.length);
        int i = this.sNl.sPp.field_statusSyncKey;
        int i2 = this.sNl.sPp.field_relayDataSyncKey;
        int i3 = this.sNl.sPp.field_connectingStatusKey;
        this.sNl.sPp.parseSyncKeyBuff(cqk.vTO.getBuffer().toByteArray(), cqk.vTO.getILen());
        int i4 = this.sNl.sPp.field_statusSyncKey;
        int i5 = this.sNl.sPp.field_relayDataSyncKey;
        int i6 = this.sNl.sPp.field_connectingStatusKey;
        ab.i("MicroMsg.Voip.VoipSyncHandle", "VoipSyncResp: oldStatusSyncKey:" + i + " oldRelayDataSyncKey:" + i2 + " oldConnectingStatusSyncKey:" + i3);
        ab.i("MicroMsg.Voip.VoipSyncHandle", "VoipSyncResp: newStatusSyncKey:" + i4 + " newRelayDataSyncKey:" + i5 + " newConnectingStatusSyncKey:" + i6);
        this.sNl.sPt = cqk.vTO.getBuffer().toByteArray();
        ab.i("MicroMsg.Voip.VoipSyncHandle", "voipSync response: continueflag=" + cqk.vQe);
        LinkedList linkedList = cqk.xor.jBw;
        if (linkedList != null && linkedList.size() != 0) {
            ab.i("MicroMsg.Voip.VoipSyncHandle", " syncOnSceneEnd cmdlist size" + linkedList.size());
            ab.i("MicroMsg.Voip.VoipSyncHandle", " syncOnSceneEnd cmdlist size:" + linkedList.size() + ",selector = " + ((m) mVar).cKv());
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= linkedList.size()) {
                    break;
                }
                cpf cpf = (cpf) linkedList.get(i8);
                int i9 = cpf.wat;
                ab.i("MicroMsg.Voip.VoipSyncHandle", "__parse sync resp, item cmdid:".concat(String.valueOf(i9)));
                if (i9 == 1) {
                    if (i4 > i) {
                        if (this.sNl.sPp.nwu == 0) {
                            a.Loge("MicroMsg.Voip.VoipSyncHandle", "voipSyncStatus ignored , roomid = 0");
                        } else {
                            try {
                                cqi cqi = (cqi) new cqi().parseFrom(cpf.wau.getBuffer().toByteArray());
                                a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus in...from user=" + cpf.ndG + ",itemStatus =  " + cqi.jBT);
                                a(cqi, 3);
                            } catch (IOException e) {
                                ab.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e, "", new Object[0]);
                            }
                        }
                    }
                } else if (i9 == 2) {
                    if (i5 > i2) {
                        if (this.sNl.sPp.nwu == 0) {
                            a.Loge("MicroMsg.Voip.VoipSyncHandle", "RelayData ignored , roomid = 0");
                        } else {
                            try {
                                cpx cpx = (cpx) new cpx().parseFrom(cpf.wau.getBuffer().toByteArray());
                                a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncRelayData ...relayType = " + cpx.jCt + ",from user = " + cpf.ndG);
                                if (cpx.jCt == 5) {
                                    a(cpx);
                                } else if (cpx.jCt == 3) {
                                    this.sNl.bp(cpx.vJd.getBuffer().toByteArray());
                                    if (!(cpx.vJd == null || cpx.vJd.getBuffer() == null)) {
                                        this.sTy.xlN = cpx;
                                    }
                                } else if (cpx.jCt == 2) {
                                    this.sNl.bo(cpx.vJd.getBuffer().toByteArray());
                                    if (!(cpx.vJd == null || cpx.vJd.getBuffer() == null)) {
                                        this.sTy.xlM = cpx;
                                    }
                                } else if (cpx.jCt == 1) {
                                    b(cpx);
                                }
                            } catch (IOException e2) {
                                ab.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e2, "", new Object[0]);
                            }
                        }
                    }
                } else if (i9 == 3 && i6 > i3) {
                    if (this.sNl.sPp.nwu == 0) {
                        ab.e("MicroMsg.Voip.VoipSyncHandle", "voipSync(ClientStatus) ignored , roomid = 0");
                    } else {
                        try {
                            SKBuiltinBuffer_t parseFrom = new SKBuiltinBuffer_t().parseFrom(cpf.wau.getBuffer().toByteArray());
                            if (cpf.ndG.equals(r.Yz())) {
                                a.Loge("MicroMsg.Voip.VoipSyncHandle", "svr response: local connecting status changed.");
                            } else {
                                c(parseFrom);
                            }
                        } catch (IOException e22) {
                            ab.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e22, "", new Object[0]);
                        }
                    }
                }
                i7 = i8 + 1;
            }
        }
        ab.i("MicroMsg.Voip.VoipSyncHandle", "__parse sync resp end");
        if ((this.sTz != null && this.sTz.jBv > 0) || this.sTA > 0) {
            a(null, false, 7);
        }
        AppMethodBeat.o(4692);
    }
}
