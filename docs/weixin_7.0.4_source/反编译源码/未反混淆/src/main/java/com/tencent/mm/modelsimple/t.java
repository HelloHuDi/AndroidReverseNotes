package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.e;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.pf;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.p;
import com.tencent.mm.model.r;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.b.g;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.protocal.protobuf.bti;
import com.tencent.mm.protocal.protobuf.btj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bi;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import org.xwalk.core.XWalkEnvironment;

public final class t extends m implements k {
    private static final al fPG = new al("deleteRevokeMessageThread");
    private final long cvx;
    private f ehi;
    private final b fAT;
    private final String fPH;

    static {
        AppMethodBeat.i(16602);
        AppMethodBeat.o(16602);
    }

    public t(bi biVar, String str) {
        int i;
        AppMethodBeat.i(16598);
        aw.ZK();
        Object obj = c.Ry().get(290818, Integer.valueOf(0));
        if (obj != null) {
            i = bo.getInt(obj.toString(), 0);
        } else {
            i = 0;
        }
        this.cvx = biVar.field_msgId;
        this.fPH = str;
        String str2 = null;
        int i2 = 0;
        int i3 = (int) (biVar.field_createTime / 1000);
        long j = biVar.field_msgSvrId;
        String Yz = r.Yz();
        String str3 = biVar.field_talker;
        if (biVar.dJz != 1) {
            String str4;
            switch (biVar.getType()) {
                case 1:
                case 42:
                case 48:
                case 66:
                    ab.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:text,newClientMsgId:%d", Integer.valueOf(p.m(r.Yz(), biVar.field_createTime).hashCode()));
                    i2 = r2;
                    break;
                case 3:
                    e fJ = o.ahl().fJ(biVar.field_msgId);
                    ab.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:img,talker:%s,hdId:%s,localId:%s,clientMsgId:%s", biVar.field_talker, Integer.valueOf(fJ.fDJ), Long.valueOf(fJ.fDy), biVar.dJC);
                    str2 = str4;
                    break;
                case 34:
                    com.tencent.mm.modelvoice.p uZ = com.tencent.mm.modelvoice.m.ama().uZ(biVar.field_imgPath);
                    if (uZ != null) {
                        ab.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:voice,clientMsgId:%s", uZ.clientId);
                        str2 = str4;
                        break;
                    }
                    break;
                case 43:
                case 62:
                    ab.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:video,clientMsgId:%s", biVar.field_imgPath);
                    str2 = str4;
                    break;
                case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                    ab.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:emoji,clientMsgId:%s", String.valueOf(ap.aps(biVar.field_content).time));
                    str2 = str4;
                    break;
                case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                case 1048625:
                case 268435505:
                case 553648177:
                case 587202609:
                    com.tencent.mm.pluginsdk.model.app.b lZ = am.aUq().lZ(biVar.field_msgId);
                    if (lZ != null) {
                        str4 = lZ.field_clientAppDataId;
                    } else {
                        str4 = biVar.field_talker + biVar.field_msgId + "T" + biVar.field_createTime;
                    }
                    ab.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:app msg/emoji/img,clientMsgId:%s", str4);
                    str2 = str4;
                    break;
            }
        }
        a aVar = new a();
        aVar.fsJ = new bti();
        aVar.fsK = new btj();
        aVar.uri = "/cgi-bin/micromsg-bin/revokemsg";
        aVar.fsI = g.CTRL_INDEX;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.fAT = aVar.acD();
        bti bti = (bti) this.fAT.fsG.fsP;
        bti.vFF = str2;
        bti.wVo = i2;
        bti.wVp = 0;
        bti.wVr = j;
        bti.pcX = i3;
        bti.ndG = Yz;
        bti.ndF = str3;
        bti.wVq = i;
        ab.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][NetSceneRevokeMsg]:clientMsgId:%s,newClientMsgId:%d,svrMsgId:%d,createTime:%d,fromUserName:%s,toUserName:%s,indexOfRequest:%d", bti.vFF, Integer.valueOf(bti.wVo), Integer.valueOf(bti.wVp), Integer.valueOf(bti.pcX), bti.ndG, bti.ndF, Integer.valueOf(bti.wVq));
        AppMethodBeat.o(16598);
    }

    public final int getType() {
        return g.CTRL_INDEX;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(16599);
        this.ehi = fVar;
        int a = a(eVar, this.fAT, this);
        AppMethodBeat.o(16599);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(16600);
        if (i2 == 0 && i3 == 0) {
            aw.ZK();
            final bi jf = c.XO().jf(this.cvx);
            if (jf.field_msgId == this.cvx) {
                btj ajB = ajB();
                ab.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSceneEnd.revokeMsg] msgId:%s,msgSvrId:%s,responseSysWording:%s", Long.valueOf(jf.field_msgId), Long.valueOf(jf.field_msgSvrId), ajB.wVt);
                int type = jf.getType();
                a(this.fPH, "  " + ah.getContext().getString(R.string.cg0), jf, jf.field_content);
                jf.hO(0);
                jf.ht(jf.dqI | 4);
                pf pfVar = new pf();
                pfVar.cLx.cvx = this.cvx;
                com.tencent.mm.sdk.b.a.xxA.m(pfVar);
                aw.ZK();
                c.XO().a(jf.field_msgId, jf);
                int i4 = 0;
                aw.ZK();
                Object obj = c.Ry().get(290818, Integer.valueOf(0));
                if (obj != null) {
                    i4 = bo.getInt(obj.toString(), 0);
                }
                i4++;
                aw.ZK();
                c.Ry().set(290818, Integer.valueOf(i4));
                jf.setType(type);
                com.tencent.mm.modelstat.b bVar;
                if (jf.bAA()) {
                    bVar = com.tencent.mm.modelstat.b.fRa;
                    type = com.tencent.mm.af.k.k(jf);
                    if (bVar.aka()) {
                        bVar.a(jf, com.tencent.mm.modelstat.b.b.revoke, type);
                    }
                } else {
                    bVar = com.tencent.mm.modelstat.b.fRa;
                    if (bVar.aka()) {
                        bVar.a(jf, com.tencent.mm.modelstat.b.b.revoke, 0);
                    }
                }
                fPG.m(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(16597);
                        ab.i("MicroMsg.NetSceneRevokeMsg", "delete invoke message! msg:%s", Long.valueOf(jf.field_msgId));
                        jf.setType(10002);
                        t.a(t.this.fPH, "", jf, "");
                        aw.ZK();
                        c.XO().a(jf.field_msgId, jf);
                        AppMethodBeat.o(16597);
                    }
                }, 300000);
            } else {
                ab.e("MicroMsg.NetSceneRevokeMsg", "cannot find the msg:%d after revoke.", Long.valueOf(this.cvx));
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(16600);
    }

    public static void a(String str, String str2, bi biVar, String str3) {
        AppMethodBeat.i(16601);
        if (biVar.getType() == 1 || biVar.getType() == 16777265) {
            biVar.setType(10002);
            biVar.setContent(String.format("<sysmsg type=\"invokeMessage\"><invokeMessage><text><![CDATA[%s]]></text><timestamp><![CDATA[%s]]></timestamp><link><text><![CDATA[%s]]></text></link><preContent><![CDATA[%s]]></preContent></invokeMessage></sysmsg>", new Object[]{str, Long.valueOf(System.currentTimeMillis()), str2, str3}));
            AppMethodBeat.o(16601);
            return;
        }
        biVar.setType(Downloads.MIN_WAIT_FOR_NETWORK);
        biVar.setContent(str);
        AppMethodBeat.o(16601);
    }

    public final btj ajB() {
        return (btj) this.fAT.fsH.fsP;
    }
}
