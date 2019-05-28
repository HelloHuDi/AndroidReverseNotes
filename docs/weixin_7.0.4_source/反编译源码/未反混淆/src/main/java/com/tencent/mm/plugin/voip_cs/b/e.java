package com.tencent.mm.plugin.voip_cs.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip_cs.b.c.b;
import com.tencent.mm.plugin.voip_cs.b.c.c;
import com.tencent.mm.plugin.voip_cs.b.c.d;
import com.tencent.mm.protocal.protobuf.coj;
import com.tencent.mm.protocal.protobuf.cok;
import com.tencent.mm.protocal.protobuf.coo;
import com.tencent.mm.protocal.protobuf.coq;
import com.tencent.mm.protocal.protobuf.cou;
import com.tencent.mm.protocal.protobuf.cox;
import com.tencent.mm.protocal.protobuf.cpa;
import com.tencent.mm.protocal.protobuf.cpc;
import com.tencent.mm.protocal.protobuf.cpu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import java.util.Arrays;
import java.util.LinkedList;

public final class e implements f {
    public int nwE = 0;
    public int sPz = 0;
    public b tdF;
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
    public ap tdQ = new ap(Looper.getMainLooper(), new a() {
        public final boolean BI() {
            AppMethodBeat.i(135304);
            ab.v("MicroMsg.voipcs.VoipCSService", "voipcs repeat sync");
            e.this.cMl();
            AppMethodBeat.o(135304);
            return true;
        }
    }, true);
    public ap tdR = new ap(Looper.getMainLooper(), new a() {
        public final boolean BI() {
            AppMethodBeat.i(135305);
            ab.v("MicroMsg.voipcs.VoipCSService", "voipcs heart beat");
            g.Rg().a(795, e.this);
            g.Rg().a(new b(c.cMe().tew.sTZ, c.cMe().tew.nwv), 0);
            AppMethodBeat.o(135305);
            return true;
        }
    }, true);
    public int tdc = 0;

    public e() {
        AppMethodBeat.i(135306);
        AppMethodBeat.o(135306);
    }

    public final void cMl() {
        AppMethodBeat.i(135307);
        g.Rg().a(818, (f) this);
        g.Rg().a(new com.tencent.mm.plugin.voip_cs.b.c.f(c.cMe().tew.sTZ, c.cMe().tew.nwv, this.tdG), 0);
        AppMethodBeat.o(135307);
    }

    public final void ao(String str, String str2, String str3) {
        AppMethodBeat.i(135308);
        ab.i("MicroMsg.voipcs.VoipCSService", "start netscene invite for username:" + str + ",appid:" + str2 + ",voipCSContext:" + str3);
        this.tdN = str;
        this.tdM = 1;
        d cMg = c.cMg();
        ab.d("MicroMsg.VoipCSReportHelper", "markSendInvite");
        if (cMg.tdz == 0) {
            cMg.tdz = (int) (System.currentTimeMillis() / 1000);
        }
        byte[] bArr = null;
        if (!(str3 == null || str3.equals(""))) {
            bArr = str3.getBytes();
        }
        g.Rg().a(823, (f) this);
        c.cMe().tew.nwx = (int) (System.currentTimeMillis() / 1000);
        m cVar = new c(c.cMe().tew.nwx, str, c.cMe().tew.netType, bArr, c.cMe().tew.field_capInfo, str2);
        ab.i("MicroMsg.voipcs.VoipCSService", "capDump is " + Arrays.toString(c.cMe().tew.field_capInfo));
        g.Rg().a(cVar, 0);
        AppMethodBeat.o(135308);
    }

    private static void b(int i, int i2, m mVar) {
        AppMethodBeat.i(135309);
        ab.i("MicroMsg.voipcs.VoipCSService", "Redirect response:" + i + " errCode:" + i2);
        if (i2 != 0) {
            ab.i("MicroMsg.voipcs.VoipCSService", " redirect response with error code:".concat(String.valueOf(i2)));
            AppMethodBeat.o(135309);
            return;
        }
        cox cox = (cox) ((d) mVar).ehh.fsH.fsP;
        ab.i("MicroMsg.voipcs.VoipCSService", "roomid " + cox.xeF + " key " + cox.wen + "relay addr cnt " + cox.vIO.size());
        LinkedList<coo> linkedList = cox.vIO;
        cok cok = new cok();
        for (coo coo : linkedList) {
            coj coj = new coj();
            c.cMe();
            coj.xfs = com.tencent.mm.plugin.voip_cs.b.b.a.acg(coo.wCK);
            coj.wOO = coo.wOO;
            cok.xma.add(coj);
        }
        cok.xlZ = linkedList.size();
        c.cMe().tew.a(cok, cok, null, 0, 0);
        AppMethodBeat.o(135309);
    }

    public final void a(cpc cpc) {
        AppMethodBeat.i(135310);
        if (cpc.xmD <= this.tdG || c.cMf().tdM == 3) {
            AppMethodBeat.o(135310);
            return;
        }
        ab.i("MicroMsg.voipcs.VoipCSService", "get callee sync resp,notifySeq:" + cpc.xmD + ",calleeMemberId:" + cpc.xmE + ",calleeStatus:" + cpc.xmF + ",calleeSubStatus:" + cpc.xmG + ",recv roomId:" + cpc.xeF + ",recv roomKey:" + cpc.wen);
        if (c.cMe().tew.sTZ == 0 || c.cMe().tew.sTZ == cpc.xeF) {
            this.tdG = cpc.xmD;
            this.tdc = cpc.xmE;
            this.tdH = cpc.xmF;
            this.tdI = cpc.xmG;
            c.cMg().tdc = this.tdc;
            if (this.tdH == 2) {
                ab.i("MicroMsg.voipcs.VoipCSService", "callee accept!");
                this.tdQ.stopTimer();
                cMl();
                c.cMe().tew.nwv = cpc.wen;
                ab.i("MicroMsg.voipcs.VoipCSService", "csroomId:" + cpc.xeF + ",roomkey:" + cpc.wen);
                this.tdJ = cpc.xmH != null ? cpc.xmH.toByteArray() : null;
                if (c.cMe().tew.field_capInfo == null) {
                    AppMethodBeat.o(135310);
                    return;
                } else if (this.tdJ == null) {
                    AppMethodBeat.o(135310);
                    return;
                } else {
                    int i;
                    c.cMg().cMi();
                    c.cMe().tew.sUb = this.tdJ;
                    ab.i("MicroMsg.voipcs.VoipCSService", "calleeCapDump is " + Arrays.toString(c.cMe().tew.sUb));
                    ab.i("MicroMsg.voipcs.VoipCSService", "calleeCap length:" + this.tdJ.length);
                    if (c.cMe().tew.sUb != null && c.cMe().tew.exchangeCabInfo(c.cMe().tew.sUb, c.cMe().tew.sUb.length) < 0) {
                        ab.i("MicroMsg.voipcs.VoipCSService", "exchangeCabInfo fail!");
                    }
                    if (c.cMe().tew.sUe == null) {
                        i = 0;
                    } else {
                        i = c.cMe().tew.sUe.length;
                    }
                    if (c.cMe().tew.setConfigInfo(c.cMe().tew.sTY, c.cMe().tew.sTZ, c.cMe().tew.nwC, c.cMe().tew.nwv, c.cMe().tew.field_peerId, 1, c.cMe().tew.sUf, c.cMe().tew.sUg, c.cMe().tew.sUd, i, c.cMe().tew.sUe, this.tdP, 1, c.cMe().tew.netType, c.cMe().tew.sUY, c.cMe().tew.sUZ, 255, 0, 0, null, 0) != 0) {
                        ab.e("MicroMsg.voipcs.VoipCSService", "setConfig fail, ret:%d", Integer.valueOf(c.cMe().tew.setConfigInfo(c.cMe().tew.sTY, c.cMe().tew.sTZ, c.cMe().tew.nwC, c.cMe().tew.nwv, c.cMe().tew.field_peerId, 1, c.cMe().tew.sUf, c.cMe().tew.sUg, c.cMe().tew.sUd, i, c.cMe().tew.sUe, this.tdP, 1, c.cMe().tew.netType, c.cMe().tew.sUY, c.cMe().tew.sUZ, 255, 0, 0, null, 0)));
                    }
                    if (c.cMe().tew.connectToPeer() != 0) {
                        ab.e("MicroMsg.voipcs.VoipCSService", "connectToPeer fail, ret:%d", Integer.valueOf(c.cMe().tew.connectToPeer()));
                    }
                    if (this.tdR.doT()) {
                        this.tdR.ae(50000, 50000);
                    }
                    c.cMg().tdi = 1;
                    AppMethodBeat.o(135310);
                    return;
                }
            }
            if (!(this.tdH == 0 || this.tdH == 1 || this.tdH != 3)) {
                ab.i("MicroMsg.voipcs.VoipCSService", "callee hangup!");
                c.cMg().dataType = 5;
                c.cMg().cMh();
                c.cMg().tdm = 2;
                if (this.tdI == 1) {
                    c.cMg().tde = 12;
                } else if (this.tdI == 3) {
                    c.cMg().tde = 99;
                }
                if (this.tdF != null) {
                    this.tdF.GV(1);
                }
            }
            AppMethodBeat.o(135310);
            return;
        }
        ab.i("MicroMsg.voipcs.VoipCSService", "csRoomId:" + c.cMe().tew.sTZ + ",recv roomId:" + cpc.xeF + ",current and recv not equal!!");
        AppMethodBeat.o(135310);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(135311);
        ab.i("MicroMsg.voipcs.VoipCSService", "onSceneEnd :netId:%s,errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(mVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
        String str2;
        if (i != 0 || i2 != 0) {
            ab.i("MicroMsg.voipcs.VoipCSService", "onSceneEnd  resp error!:netId:%s,errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(mVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i != 0 && i != 4) {
                this.tdO = -1;
                this.tdF.onError(10);
                AppMethodBeat.o(135311);
                return;
            } else if (mVar.getType() == 823) {
                if (i2 == 406) {
                    ab.i("MicroMsg.voipcs.VoipCSService", "CS_INVITE_RESP_REPEAT_INVTIE 503..");
                    AppMethodBeat.o(135311);
                    return;
                }
                c.cMg().dataType = 1;
                this.tdO = 823;
                this.tdF.onError(i2);
                AppMethodBeat.o(135311);
                return;
            } else if (!(mVar.getType() == 880 || mVar.getType() == 818 || mVar.getType() != 106)) {
                this.tdF.gF("", "");
            }
        } else if (mVar.getType() == 823) {
            coj coj;
            cou cou = (cou) ((c) mVar).ehh.fsH.fsP;
            long j = cou.xeF;
            long j2 = cou.wen;
            LinkedList<coo> linkedList = cou.vIO;
            LinkedList<coo> linkedList2 = cou.xmC;
            this.nwE = cou.xdw;
            this.tdP = cou.xmB;
            ab.i("MicroMsg.voipcs.VoipCSService", "tcpStartCnt : " + this.tdP);
            c.cMe().tew.sUg = cou.nwL;
            this.tdK = cou.nwF;
            c.cMe().tew.sUY = cou.nwQ;
            c.cMe().tew.sUZ = cou.wPf.toByteArray();
            c.cMe().tew.sUf = cou.nwM;
            cok cok = new cok();
            for (coo coo : linkedList) {
                coj = new coj();
                c.cMe();
                coj.xfs = com.tencent.mm.plugin.voip_cs.b.b.a.acg(coo.wCK);
                coj.wOO = coo.wOO;
                cok.xma.add(coj);
            }
            cok.xlZ = linkedList.size();
            cok cok2 = new cok();
            for (coo coo2 : linkedList2) {
                coj = new coj();
                c.cMe();
                coj.xfs = com.tencent.mm.plugin.voip_cs.b.b.a.acg(coo2.wCK);
                coj.wOO = coo2.wOO;
                cok2.xma.add(coj);
            }
            cok2.xlZ = linkedList2.size();
            c.cMe().tew.sTZ = j;
            c.cMe().tew.nwv = j2;
            ab.i("MicroMsg.voipcs.VoipCSService", "recv invite resp csRoomId : " + j + ",roomKey:" + j2);
            c.cMe().tew.sVi = cou.xmz;
            c.cMe().tew.sVj = cou.xmA;
            cpu cpu = new cpu();
            cpu.xnK = 0;
            cpu.xnL = 0;
            cpu.xnM = 0;
            cpu.userName = "";
            cpu.gDC = "";
            if (c.cMe().tew.a(cok, cok, cok, cpu, null) != 0) {
                ab.i("MicroMsg.voipcs.VoipCSService", "setIp fail!");
            }
            d cMg = c.cMg();
            str2 = this.tdN;
            ab.d("MicroMsg.VoipCSReportHelper", "setVoipCSBaseInfo");
            cMg.tda = j;
            cMg.nwv = j2;
            cMg.tdb = str2;
            if (this.tdQ.doT()) {
                if (this.nwE > 0) {
                    long j3 = (long) (this.nwE * 1000);
                    this.tdQ.ae(j3, j3);
                } else {
                    this.tdQ.ae(4000, 4000);
                }
            }
            cMg = c.cMg();
            ab.d("MicroMsg.VoipCSReportHelper", "markRecvInvite");
            if (cMg.tdz != 0) {
                cMg.tdA = (int) (System.currentTimeMillis() / 1000);
            }
            AppMethodBeat.o(135311);
            return;
        } else if (mVar.getType() == 818) {
            cpc cpc = (cpc) ((com.tencent.mm.plugin.voip_cs.b.c.f) mVar).ehh.fsH.fsP;
            ab.i("MicroMsg.voipcs.VoipCSService", "sync status = " + cpc.xmF + ",notifySeq = " + cpc.xmD);
            a(cpc);
            AppMethodBeat.o(135311);
            return;
        } else if (mVar.getType() == 880) {
            coq coq = (coq) ((com.tencent.mm.plugin.voip_cs.b.c.a) mVar).ehh.fsH.fsP;
            if (c.cMe().tew.sTZ == coq.xeF && c.cMe().tew.nwv == coq.wen) {
                ab.i("MicroMsg.voipcs.VoipCSService", "hangup success!");
            }
            g.Rg().b(880, (f) this);
            c.cMg().GW(com.tencent.mm.plugin.voip_cs.b.a.a.cMn().sTj.cLN());
            AppMethodBeat.o(135311);
            return;
        } else if (mVar.getType() == 106) {
            com.tencent.mm.plugin.messenger.a.f fVar = (com.tencent.mm.plugin.messenger.a.f) mVar;
            str2 = "";
            String str3 = "";
            if (fVar.bOj() != null) {
                str2 = fVar.bOj().vXm;
                str3 = fVar.bOj().wyX.wVI;
            } else {
                ab.i("MicroMsg.voipcs.VoipCSService", "search Or Recommend items is null or empty !");
            }
            this.tdF.gF(str2, str3);
            AppMethodBeat.o(135311);
            return;
        } else if (mVar.getType() == 285) {
            b(i, i2, mVar);
            AppMethodBeat.o(135311);
            return;
        } else if (mVar.getType() == 312) {
            cpa cpa = (cpa) ((com.tencent.mm.plugin.voip_cs.b.c.e) mVar).ehh.fsH.fsP;
            if (cpa.xeF == c.cMe().tew.sTZ && cpa.wen == c.cMe().tew.nwv) {
                ab.i("MicroMsg.voipcs.VoipCSService", "report data success!");
            }
            AppMethodBeat.o(135311);
            return;
        }
        AppMethodBeat.o(135311);
    }
}
