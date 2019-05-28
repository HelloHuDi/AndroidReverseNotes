package com.tencent.p177mm.plugin.voip_cs.p547b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.messenger.p993a.C12518f;
import com.tencent.p177mm.plugin.voip_cs.p547b.p1046c.C14096a;
import com.tencent.p177mm.plugin.voip_cs.p547b.p1046c.C14097d;
import com.tencent.p177mm.plugin.voip_cs.p547b.p1046c.C22487c;
import com.tencent.p177mm.plugin.voip_cs.p547b.p1046c.C29523b;
import com.tencent.p177mm.plugin.voip_cs.p547b.p1046c.C40046f;
import com.tencent.p177mm.plugin.voip_cs.p547b.p1046c.C46329e;
import com.tencent.p177mm.plugin.voip_cs.p547b.p1310b.C43747a;
import com.tencent.p177mm.plugin.voip_cs.p547b.p548a.C43744a;
import com.tencent.p177mm.protocal.protobuf.coj;
import com.tencent.p177mm.protocal.protobuf.cok;
import com.tencent.p177mm.protocal.protobuf.coo;
import com.tencent.p177mm.protocal.protobuf.coq;
import com.tencent.p177mm.protocal.protobuf.cou;
import com.tencent.p177mm.protocal.protobuf.cox;
import com.tencent.p177mm.protocal.protobuf.cpa;
import com.tencent.p177mm.protocal.protobuf.cpc;
import com.tencent.p177mm.protocal.protobuf.cpu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.util.Arrays;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.voip_cs.b.e */
public final class C22488e implements C1202f {
    public int nwE = 0;
    public int sPz = 0;
    public C43748b tdF;
    public int tdG = 0;
    public int tdH = 0;
    public int tdI = 0;
    public byte[] tdJ = null;
    public int tdK = 0;
    public int tdL = 0;
    public int tdM = 0;
    public String tdN = "";
    public int tdO = 0;
    public int tdP = 999;
    public C7564ap tdQ = new C7564ap(Looper.getMainLooper(), new C224901(), true);
    public C7564ap tdR = new C7564ap(Looper.getMainLooper(), new C224892(), true);
    public int tdc = 0;

    /* renamed from: com.tencent.mm.plugin.voip_cs.b.e$2 */
    class C224892 implements C5015a {
        C224892() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(135305);
            C4990ab.m7418v("MicroMsg.voipcs.VoipCSService", "voipcs heart beat");
            C1720g.m3540Rg().mo14539a(795, C22488e.this);
            C1720g.m3540Rg().mo14541a(new C29523b(C43749c.cMe().tew.sTZ, C43749c.cMe().tew.nwv), 0);
            AppMethodBeat.m2505o(135305);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip_cs.b.e$1 */
    class C224901 implements C5015a {
        C224901() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(135304);
            C4990ab.m7418v("MicroMsg.voipcs.VoipCSService", "voipcs repeat sync");
            C22488e.this.cMl();
            AppMethodBeat.m2505o(135304);
            return true;
        }
    }

    public C22488e() {
        AppMethodBeat.m2504i(135306);
        AppMethodBeat.m2505o(135306);
    }

    public final void cMl() {
        AppMethodBeat.m2504i(135307);
        C1720g.m3540Rg().mo14539a(818, (C1202f) this);
        C1720g.m3540Rg().mo14541a(new C40046f(C43749c.cMe().tew.sTZ, C43749c.cMe().tew.nwv, this.tdG), 0);
        AppMethodBeat.m2505o(135307);
    }

    /* renamed from: ao */
    public final void mo38044ao(String str, String str2, String str3) {
        AppMethodBeat.m2504i(135308);
        C4990ab.m7416i("MicroMsg.voipcs.VoipCSService", "start netscene invite for username:" + str + ",appid:" + str2 + ",voipCSContext:" + str3);
        this.tdN = str;
        this.tdM = 1;
        C43750d cMg = C43749c.cMg();
        C4990ab.m7410d("MicroMsg.VoipCSReportHelper", "markSendInvite");
        if (cMg.tdz == 0) {
            cMg.tdz = (int) (System.currentTimeMillis() / 1000);
        }
        byte[] bArr = null;
        if (!(str3 == null || str3.equals(""))) {
            bArr = str3.getBytes();
        }
        C1720g.m3540Rg().mo14539a(823, (C1202f) this);
        C43749c.cMe().tew.nwx = (int) (System.currentTimeMillis() / 1000);
        C1207m c22487c = new C22487c(C43749c.cMe().tew.nwx, str, C43749c.cMe().tew.netType, bArr, C43749c.cMe().tew.field_capInfo, str2);
        C4990ab.m7416i("MicroMsg.voipcs.VoipCSService", "capDump is " + Arrays.toString(C43749c.cMe().tew.field_capInfo));
        C1720g.m3540Rg().mo14541a(c22487c, 0);
        AppMethodBeat.m2505o(135308);
    }

    /* renamed from: b */
    private static void m34192b(int i, int i2, C1207m c1207m) {
        AppMethodBeat.m2504i(135309);
        C4990ab.m7416i("MicroMsg.voipcs.VoipCSService", "Redirect response:" + i + " errCode:" + i2);
        if (i2 != 0) {
            C4990ab.m7416i("MicroMsg.voipcs.VoipCSService", " redirect response with error code:".concat(String.valueOf(i2)));
            AppMethodBeat.m2505o(135309);
            return;
        }
        cox cox = (cox) ((C14097d) c1207m).ehh.fsH.fsP;
        C4990ab.m7416i("MicroMsg.voipcs.VoipCSService", "roomid " + cox.xeF + " key " + cox.wen + "relay addr cnt " + cox.vIO.size());
        LinkedList<coo> linkedList = cox.vIO;
        cok cok = new cok();
        for (coo coo : linkedList) {
            coj coj = new coj();
            C43749c.cMe();
            coj.xfs = C43747a.acg(coo.wCK);
            coj.wOO = coo.wOO;
            cok.xma.add(coj);
        }
        cok.xlZ = linkedList.size();
        C43749c.cMe().tew.mo63274a(cok, cok, null, 0, 0);
        AppMethodBeat.m2505o(135309);
    }

    /* renamed from: a */
    public final void mo38043a(cpc cpc) {
        AppMethodBeat.m2504i(135310);
        if (cpc.xmD <= this.tdG || C43749c.cMf().tdM == 3) {
            AppMethodBeat.m2505o(135310);
            return;
        }
        C4990ab.m7416i("MicroMsg.voipcs.VoipCSService", "get callee sync resp,notifySeq:" + cpc.xmD + ",calleeMemberId:" + cpc.xmE + ",calleeStatus:" + cpc.xmF + ",calleeSubStatus:" + cpc.xmG + ",recv roomId:" + cpc.xeF + ",recv roomKey:" + cpc.wen);
        if (C43749c.cMe().tew.sTZ == 0 || C43749c.cMe().tew.sTZ == cpc.xeF) {
            this.tdG = cpc.xmD;
            this.tdc = cpc.xmE;
            this.tdH = cpc.xmF;
            this.tdI = cpc.xmG;
            C43749c.cMg().tdc = this.tdc;
            if (this.tdH == 2) {
                C4990ab.m7416i("MicroMsg.voipcs.VoipCSService", "callee accept!");
                this.tdQ.stopTimer();
                cMl();
                C43749c.cMe().tew.nwv = cpc.wen;
                C4990ab.m7416i("MicroMsg.voipcs.VoipCSService", "csroomId:" + cpc.xeF + ",roomkey:" + cpc.wen);
                this.tdJ = cpc.xmH != null ? cpc.xmH.toByteArray() : null;
                if (C43749c.cMe().tew.field_capInfo == null) {
                    AppMethodBeat.m2505o(135310);
                    return;
                } else if (this.tdJ == null) {
                    AppMethodBeat.m2505o(135310);
                    return;
                } else {
                    int i;
                    C43749c.cMg().cMi();
                    C43749c.cMe().tew.sUb = this.tdJ;
                    C4990ab.m7416i("MicroMsg.voipcs.VoipCSService", "calleeCapDump is " + Arrays.toString(C43749c.cMe().tew.sUb));
                    C4990ab.m7416i("MicroMsg.voipcs.VoipCSService", "calleeCap length:" + this.tdJ.length);
                    if (C43749c.cMe().tew.sUb != null && C43749c.cMe().tew.exchangeCabInfo(C43749c.cMe().tew.sUb, C43749c.cMe().tew.sUb.length) < 0) {
                        C4990ab.m7416i("MicroMsg.voipcs.VoipCSService", "exchangeCabInfo fail!");
                    }
                    if (C43749c.cMe().tew.sUe == null) {
                        i = 0;
                    } else {
                        i = C43749c.cMe().tew.sUe.length;
                    }
                    if (C43749c.cMe().tew.setConfigInfo(C43749c.cMe().tew.sTY, C43749c.cMe().tew.sTZ, C43749c.cMe().tew.nwC, C43749c.cMe().tew.nwv, C43749c.cMe().tew.field_peerId, 1, C43749c.cMe().tew.sUf, C43749c.cMe().tew.sUg, C43749c.cMe().tew.sUd, i, C43749c.cMe().tew.sUe, this.tdP, 1, C43749c.cMe().tew.netType, C43749c.cMe().tew.sUY, C43749c.cMe().tew.sUZ, 255, 0, 0, null, 0) != 0) {
                        C4990ab.m7413e("MicroMsg.voipcs.VoipCSService", "setConfig fail, ret:%d", Integer.valueOf(C43749c.cMe().tew.setConfigInfo(C43749c.cMe().tew.sTY, C43749c.cMe().tew.sTZ, C43749c.cMe().tew.nwC, C43749c.cMe().tew.nwv, C43749c.cMe().tew.field_peerId, 1, C43749c.cMe().tew.sUf, C43749c.cMe().tew.sUg, C43749c.cMe().tew.sUd, i, C43749c.cMe().tew.sUe, this.tdP, 1, C43749c.cMe().tew.netType, C43749c.cMe().tew.sUY, C43749c.cMe().tew.sUZ, 255, 0, 0, null, 0)));
                    }
                    if (C43749c.cMe().tew.connectToPeer() != 0) {
                        C4990ab.m7413e("MicroMsg.voipcs.VoipCSService", "connectToPeer fail, ret:%d", Integer.valueOf(C43749c.cMe().tew.connectToPeer()));
                    }
                    if (this.tdR.doT()) {
                        this.tdR.mo16770ae(50000, 50000);
                    }
                    C43749c.cMg().tdi = 1;
                    AppMethodBeat.m2505o(135310);
                    return;
                }
            }
            if (!(this.tdH == 0 || this.tdH == 1 || this.tdH != 3)) {
                C4990ab.m7416i("MicroMsg.voipcs.VoipCSService", "callee hangup!");
                C43749c.cMg().dataType = 5;
                C43749c.cMg().cMh();
                C43749c.cMg().tdm = 2;
                if (this.tdI == 1) {
                    C43749c.cMg().tde = 12;
                } else if (this.tdI == 3) {
                    C43749c.cMg().tde = 99;
                }
                if (this.tdF != null) {
                    this.tdF.mo69456GV(1);
                }
            }
            AppMethodBeat.m2505o(135310);
            return;
        }
        C4990ab.m7416i("MicroMsg.voipcs.VoipCSService", "csRoomId:" + C43749c.cMe().tew.sTZ + ",recv roomId:" + cpc.xeF + ",current and recv not equal!!");
        AppMethodBeat.m2505o(135310);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(135311);
        C4990ab.m7417i("MicroMsg.voipcs.VoipCSService", "onSceneEnd :netId:%s,errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(c1207m.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
        String str2;
        if (i != 0 || i2 != 0) {
            C4990ab.m7417i("MicroMsg.voipcs.VoipCSService", "onSceneEnd  resp error!:netId:%s,errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(c1207m.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i != 0 && i != 4) {
                this.tdO = -1;
                this.tdF.onError(10);
                AppMethodBeat.m2505o(135311);
                return;
            } else if (c1207m.getType() == 823) {
                if (i2 == 406) {
                    C4990ab.m7416i("MicroMsg.voipcs.VoipCSService", "CS_INVITE_RESP_REPEAT_INVTIE 503..");
                    AppMethodBeat.m2505o(135311);
                    return;
                }
                C43749c.cMg().dataType = 1;
                this.tdO = 823;
                this.tdF.onError(i2);
                AppMethodBeat.m2505o(135311);
                return;
            } else if (!(c1207m.getType() == 880 || c1207m.getType() == 818 || c1207m.getType() != 106)) {
                this.tdF.mo69457gF("", "");
            }
        } else if (c1207m.getType() == 823) {
            coj coj;
            cou cou = (cou) ((C22487c) c1207m).ehh.fsH.fsP;
            long j = cou.xeF;
            long j2 = cou.wen;
            LinkedList<coo> linkedList = cou.vIO;
            LinkedList<coo> linkedList2 = cou.xmC;
            this.nwE = cou.xdw;
            this.tdP = cou.xmB;
            C4990ab.m7416i("MicroMsg.voipcs.VoipCSService", "tcpStartCnt : " + this.tdP);
            C43749c.cMe().tew.sUg = cou.nwL;
            this.tdK = cou.nwF;
            C43749c.cMe().tew.sUY = cou.nwQ;
            C43749c.cMe().tew.sUZ = cou.wPf.toByteArray();
            C43749c.cMe().tew.sUf = cou.nwM;
            cok cok = new cok();
            for (coo coo : linkedList) {
                coj = new coj();
                C43749c.cMe();
                coj.xfs = C43747a.acg(coo.wCK);
                coj.wOO = coo.wOO;
                cok.xma.add(coj);
            }
            cok.xlZ = linkedList.size();
            cok cok2 = new cok();
            for (coo coo2 : linkedList2) {
                coj = new coj();
                C43749c.cMe();
                coj.xfs = C43747a.acg(coo2.wCK);
                coj.wOO = coo2.wOO;
                cok2.xma.add(coj);
            }
            cok2.xlZ = linkedList2.size();
            C43749c.cMe().tew.sTZ = j;
            C43749c.cMe().tew.nwv = j2;
            C4990ab.m7416i("MicroMsg.voipcs.VoipCSService", "recv invite resp csRoomId : " + j + ",roomKey:" + j2);
            C43749c.cMe().tew.sVi = cou.xmz;
            C43749c.cMe().tew.sVj = cou.xmA;
            cpu cpu = new cpu();
            cpu.xnK = 0;
            cpu.xnL = 0;
            cpu.xnM = 0;
            cpu.userName = "";
            cpu.gDC = "";
            if (C43749c.cMe().tew.mo63275a(cok, cok, cok, cpu, null) != 0) {
                C4990ab.m7416i("MicroMsg.voipcs.VoipCSService", "setIp fail!");
            }
            C43750d cMg = C43749c.cMg();
            str2 = this.tdN;
            C4990ab.m7410d("MicroMsg.VoipCSReportHelper", "setVoipCSBaseInfo");
            cMg.tda = j;
            cMg.nwv = j2;
            cMg.tdb = str2;
            if (this.tdQ.doT()) {
                if (this.nwE > 0) {
                    long j3 = (long) (this.nwE * 1000);
                    this.tdQ.mo16770ae(j3, j3);
                } else {
                    this.tdQ.mo16770ae(4000, 4000);
                }
            }
            cMg = C43749c.cMg();
            C4990ab.m7410d("MicroMsg.VoipCSReportHelper", "markRecvInvite");
            if (cMg.tdz != 0) {
                cMg.tdA = (int) (System.currentTimeMillis() / 1000);
            }
            AppMethodBeat.m2505o(135311);
            return;
        } else if (c1207m.getType() == 818) {
            cpc cpc = (cpc) ((C40046f) c1207m).ehh.fsH.fsP;
            C4990ab.m7416i("MicroMsg.voipcs.VoipCSService", "sync status = " + cpc.xmF + ",notifySeq = " + cpc.xmD);
            mo38043a(cpc);
            AppMethodBeat.m2505o(135311);
            return;
        } else if (c1207m.getType() == 880) {
            coq coq = (coq) ((C14096a) c1207m).ehh.fsH.fsP;
            if (C43749c.cMe().tew.sTZ == coq.xeF && C43749c.cMe().tew.nwv == coq.wen) {
                C4990ab.m7416i("MicroMsg.voipcs.VoipCSService", "hangup success!");
            }
            C1720g.m3540Rg().mo14546b(880, (C1202f) this);
            C43749c.cMg().mo69459GW(C43744a.cMn().sTj.cLN());
            AppMethodBeat.m2505o(135311);
            return;
        } else if (c1207m.getType() == 106) {
            C12518f c12518f = (C12518f) c1207m;
            str2 = "";
            String str3 = "";
            if (c12518f.bOj() != null) {
                str2 = c12518f.bOj().vXm;
                str3 = c12518f.bOj().wyX.wVI;
            } else {
                C4990ab.m7416i("MicroMsg.voipcs.VoipCSService", "search Or Recommend items is null or empty !");
            }
            this.tdF.mo69457gF(str2, str3);
            AppMethodBeat.m2505o(135311);
            return;
        } else if (c1207m.getType() == 285) {
            C22488e.m34192b(i, i2, c1207m);
            AppMethodBeat.m2505o(135311);
            return;
        } else if (c1207m.getType() == 312) {
            cpa cpa = (cpa) ((C46329e) c1207m).ehh.fsH.fsP;
            if (cpa.xeF == C43749c.cMe().tew.sTZ && cpa.wen == C43749c.cMe().tew.nwv) {
                C4990ab.m7416i("MicroMsg.voipcs.VoipCSService", "report data success!");
            }
            AppMethodBeat.m2505o(135311);
            return;
        }
        AppMethodBeat.m2505o(135311);
    }
}
