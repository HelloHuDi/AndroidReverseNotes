package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.e;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.o;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.g.a.pg;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.g.a.sw;
import com.tencent.mm.g.a.tr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.account.friend.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bbq;
import com.tencent.mm.protocal.protobuf.bbv;
import com.tencent.mm.protocal.protobuf.bcf;
import com.tencent.mm.protocal.protobuf.bcq;
import com.tencent.mm.protocal.protobuf.bdx;
import com.tencent.mm.protocal.protobuf.bmt;
import com.tencent.mm.protocal.protobuf.cgc;
import com.tencent.mm.protocal.protobuf.cme;
import com.tencent.mm.protocal.protobuf.tb;
import com.tencent.mm.protocal.protobuf.uy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.ttpic.wav.WavFileHeader;
import junit.framework.Assert;

public final class a implements r {
    public final void a(tb tbVar, byte[] bArr, boolean z, t tVar) {
        AppMethodBeat.i(16492);
        String a;
        ad aoO;
        ad aoO2;
        h hVar;
        switch (tbVar.wat) {
            case 13:
                bcf bcf = (bcf) new bcf().parseFrom(bArr);
                if (1 == bcf.wGK) {
                    aw.ZK();
                    c.XU().e(aa.a(bcf.wcB), bcf.wGu == 1, bcf.wGL == 1);
                    AppMethodBeat.o(16492);
                    return;
                }
                ab.e("MicroMsg.BigBallOfMudSyncExtension", "unknown micro blog type:" + bcf.wGK);
                AppMethodBeat.o(16492);
                return;
            case 15:
                bbq bbq = (bbq) new bbq().parseFrom(bArr);
                if (bbq != null) {
                    ab.d("MicroMsg.BigBallOfMudSyncExtension", "processModChatRoomMember username:" + bbq.wcB + " nickname:" + bbq.wyX);
                    a = aa.a(bbq.wcB);
                    aw.ZK();
                    aoO = c.XM().aoO(a);
                    aoO.setUsername(a);
                    aoO.iB(aa.a(bbq.wyX));
                    aoO.iC(aa.a(bbq.wce));
                    aoO.iD(aa.a(bbq.wcf));
                    aoO.hA(bbq.guN);
                    aoO.iz(aa.a(bbq.wFK));
                    aoO.iF(aa.a(bbq.wFM));
                    aoO.iG(aa.a(bbq.wFL));
                    aoO.hD(bbq.wbA);
                    h hVar2 = new h();
                    hVar2.bJt = -1;
                    hVar2.username = aoO.field_username;
                    hVar2.frV = bbq.vXn;
                    hVar2.frW = bbq.vXm;
                    ab.d("MicroMsg.BigBallOfMudSyncExtension", "dkhurl chatmember %s b[%s] s[%s]", hVar2.getUsername(), hVar2.ack(), hVar2.acl());
                    hVar2.cB(true);
                    if (bbq.wGb == 3 || bbq.wGb == 4) {
                        aoO.hz(bbq.wGb);
                        hVar2.dtR = bbq.wGb;
                    } else if (bbq.wGb == 2) {
                        aoO.hz(3);
                        hVar2.dtR = 3;
                        aoO.hz(3);
                        if (!com.tencent.mm.model.r.Yz().equals(aoO.field_username)) {
                            o.acd();
                            d.E(aoO.field_username, false);
                            o.acd();
                            d.E(aoO.field_username, true);
                            o.acv().pZ(aoO.field_username);
                        }
                    }
                    o.act().b(hVar2);
                    aw.ZK();
                    c.XM().Y(aoO);
                    com.tencent.mm.aj.d qP = z.aeR().qP(aoO.field_username);
                    qP.field_username = aoO.field_username;
                    qP.field_brandList = bbq.guX;
                    uy uyVar = bbq.wCa;
                    if (uyVar != null) {
                        qP.field_brandFlag = uyVar.gvb;
                        qP.field_brandInfo = uyVar.gvd;
                        qP.field_brandIconURL = uyVar.gve;
                        qP.field_extInfo = uyVar.gvc;
                    }
                    if (!z.aeR().e(qP)) {
                        z.aeR().d(qP);
                    }
                }
                AppMethodBeat.o(16492);
                return;
            case 22:
                auw auw = (auw) new auw().parseFrom(bArr);
                p pVar = new p();
                pVar.username = auw.jBB;
                pVar.gvE = auw.wyY;
                pVar.fvK = (int) bo.anT();
                com.tencent.mm.plugin.account.a.getInviteFriendOpenStg().b(pVar);
                AppMethodBeat.o(16492);
                return;
            case 23:
                act act = (act) new act().parseFrom(bArr);
                switch (act.wkw) {
                    case 1:
                        aw.ZK();
                        c.Ry().set(17, Integer.valueOf(act.pvD));
                        AppMethodBeat.o(16492);
                        return;
                    case 4:
                        AppMethodBeat.o(16492);
                        return;
                    default:
                        ab.e("MicroMsg.BigBallOfMudSyncExtension", "unknown function switch id:" + act.wkw);
                        AppMethodBeat.o(16492);
                        return;
                }
            case 24:
                bmt bmt = (bmt) new bmt().parseFrom(bArr);
                Assert.assertTrue(bmt != null);
                Assert.assertTrue(bo.nullAsNil(bmt.jBB).length() > 0);
                if (ad.aow(bmt.jBB)) {
                    aw.ZK();
                    aoO2 = c.XM().aoO(bmt.jBB);
                    if (aoO2 == null || ((int) aoO2.ewQ) == 0) {
                        aoO2 = new ad(bmt.jBB);
                        aoO2.NH();
                        aoO2.iB(bmt.vXl);
                        aoO2.iz(bmt.vXl);
                        aoO2.hD(4);
                        aw.ZK();
                        if (c.XM().aa(aoO2) == -1) {
                            ab.e("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: insert contact failed");
                            AppMethodBeat.o(16492);
                            return;
                        }
                        b.pV(aoO2.field_username);
                    } else if (!bo.nullAsNil(bmt.vXl).equals(bo.nullAsNil(aoO2.field_username))) {
                        aoO2.iB(bmt.vXl);
                        aoO2.iz(bmt.vXl);
                        aw.ZK();
                        if (c.XM().b(aoO2.field_username, aoO2) == -1) {
                            ab.e("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: update contact failed");
                        }
                    }
                    mx mxVar = new mx();
                    mxVar.cIO.opType = 1;
                    mxVar.cIO.cIS = bmt.jBB;
                    mxVar.cIO.cIT = bmt.wPH;
                    mxVar.cIO.cIU = bmt.wbH;
                    com.tencent.mm.sdk.b.a.xxA.m(mxVar);
                    AppMethodBeat.o(16492);
                    return;
                }
                ab.w("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: qcontact should ends with @t.qq.com");
                AppMethodBeat.o(16492);
                return;
            case 25:
                cgc cgc = (cgc) new cgc().parseFrom(bArr);
                Assert.assertTrue(cgc != null);
                Assert.assertTrue(bo.nullAsNil(cgc.jBB).length() > 0);
                if (ad.aou(cgc.jBB)) {
                    aw.ZK();
                    aoO2 = c.XM().aoO(cgc.jBB);
                    if (aoO2 == null || ((int) aoO2.ewQ) == 0) {
                        aoO2 = new ad(cgc.jBB);
                        aoO2.iz(cgc.vXl);
                        aoO2.hD(1);
                        aoO2.NH();
                        aw.ZK();
                        if (c.XM().aa(aoO2) == -1) {
                            ab.e("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: insert contact failed");
                            AppMethodBeat.o(16492);
                            return;
                        }
                        a = aoO2.field_username;
                        if (a == null) {
                            ab.w("MicroMsg.AvatarLogic", "setMBTAvatarImgFlag failed : invalid username");
                        } else if (a.endsWith("@t.qq.com")) {
                            hVar = new h();
                            hVar.username = a;
                            hVar.dtR = 3;
                            hVar.bJt = 3;
                            o.act().b(hVar);
                        } else {
                            ab.w("MicroMsg.AvatarLogic", "setMBTAvatarImgFlag failed : invalid username");
                        }
                    } else if (!bo.nullAsNil(cgc.vXl).equals(bo.nullAsNil(aoO2.field_username))) {
                        aoO2.iz(cgc.vXl);
                        aw.ZK();
                        if (c.XM().b(aoO2.field_username, aoO2) == -1) {
                            ab.e("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: update contact failed");
                        }
                    }
                    sw swVar = new sw();
                    swVar.cOY.opType = 1;
                    swVar.cOY.cIS = cgc.jBB;
                    swVar.cOY.cIT = cgc.wPH;
                    swVar.cOY.cIU = cgc.wbH;
                    com.tencent.mm.sdk.b.a.xxA.m(swVar);
                    AppMethodBeat.o(16492);
                    return;
                }
                ab.w("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: tcontact should ends with @t.qq.com");
                AppMethodBeat.o(16492);
                return;
            case 33:
                bbn bbn = (bbn) new bbn().parseFrom(bArr);
                Assert.assertTrue(bbn != null);
                Assert.assertTrue(bo.nullAsNil(bbn.jBB).length() > 0);
                aoO = new ad();
                aoO.setUsername(bbn.jBB);
                aoO.setType(bbn.jCt);
                aoO.hA(bbn.guN);
                aoO.iW(RegionCodeDecoder.aC(bbn.guW, bbn.guO, bbn.guP));
                aoO.iQ(bbn.guQ);
                h hVar3 = new h();
                hVar3.bJt = -1;
                hVar3.username = bbn.jBB;
                hVar3.frV = bbn.vXn;
                hVar3.frW = bbn.vXm;
                ab.d("MicroMsg.BigBallOfMudSyncExtension", "dkhurl bottle %s b[%s] s[%s]", hVar3.getUsername(), hVar3.ack(), hVar3.acl());
                ab.d("MicroMsg.BigBallOfMudSyncExtension", "bottlecontact imgflag:" + bbn.wGb + " hd:" + bbn.wGc);
                hVar3.cB(bbn.wGc != 0);
                if (bbn.wGb == 3 || bbn.wGb == 4) {
                    aoO.hz(bbn.wGb);
                    hVar3.dtR = bbn.wGb;
                } else if (bbn.wGb == 2) {
                    aoO.hz(3);
                    hVar3.dtR = 3;
                    o.acd();
                    d.E(bbn.jBB, false);
                    o.acd();
                    d.E(bbn.jBB, true);
                    o.acv().pZ(bbn.jBB);
                } else {
                    aoO.hz(3);
                    hVar3.dtR = 3;
                }
                o.act().b(hVar3);
                aw.ZK();
                c.XM().X(aoO);
                AppMethodBeat.o(16492);
                return;
            case 35:
                String str;
                String str2;
                bcq bcq = (bcq) new bcq().parseFrom(bArr);
                Assert.assertTrue(bcq != null);
                String Yz = com.tencent.mm.model.r.Yz();
                int i = bcq.vOw;
                if (i == 2) {
                    Yz = ad.aoC(Yz);
                    aw.ZK();
                    str = Yz;
                    str2 = (String) c.Ry().get(12553, null);
                } else {
                    aw.ZK();
                    str = Yz;
                    str2 = (String) c.Ry().get(12297, null);
                }
                boolean z2 = false;
                if (str2 == null || !str2.equals(bcq.wGV)) {
                    o.acd();
                    d.E(str, true);
                    aw.ZK();
                    c.Ry().set(i == 2 ? 12553 : 12297, bcq.wGV);
                    z2 = true;
                }
                ab.d("MicroMsg.BigBallOfMudSyncExtension", "ModUserImg beRemove:%b imgtype:%d md5:%s big:%s sm:%s", Boolean.valueOf(z2), Integer.valueOf(i), bcq.wGV, bcq.vXm, bcq.vXn);
                hVar = new h();
                hVar.username = str;
                hVar.frW = bcq.vXm;
                hVar.frV = bcq.vXn;
                if (!bo.isNullOrNil(hVar.acl())) {
                    if (i == 1) {
                        aw.ZK();
                        c.Ry().set(59, Boolean.TRUE);
                    } else {
                        aw.ZK();
                        c.Ry().set(60, Boolean.TRUE);
                    }
                }
                hVar.cB(false);
                hVar.bJt = 56;
                if (!bo.isNullOrNil(bcq.wGV)) {
                    hVar.cB(true);
                }
                o.act().b(hVar);
                if (z2) {
                    new e().a(str, new e.c() {
                        public final int cr(int i, int i2) {
                            return 0;
                        }
                    });
                }
                AppMethodBeat.o(16492);
                return;
            case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                cme cme = (cme) new cme().parseFrom(bArr);
                ab.i("MicroMsg.BigBallOfMudSyncExtension", "snsExtFlag:%s, snsExtFlagEx:%s, snsPrivacyRecent:%s", Integer.valueOf(cme.wBZ.guY), Integer.valueOf(cme.wBZ.xbQ), Integer.valueOf(cme.wBZ.xbR));
                aw.ZK();
                a = (String) c.Ry().get(2, null);
                if (a == null || a.length() <= 0) {
                    AppMethodBeat.o(16492);
                    return;
                }
                if (n.qFy != null) {
                    n.qFy.a(a, cme.wBZ);
                }
                ab.i("MicroMsg.BigBallOfMudSyncExtension", "storyExtFlag:%s", Integer.valueOf(cme.xkj.xeE));
                ((com.tencent.mm.plugin.story.api.e) g.M(com.tencent.mm.plugin.story.api.e.class)).updateStoryUserInfo(a, cme.xkj);
                com.tencent.mm.aj.d qX = f.qX(com.tencent.mm.model.r.Yz());
                if (qX == null) {
                    qX = new com.tencent.mm.aj.d();
                }
                qX.field_username = a;
                qX.field_brandList = cme.guX;
                if (!(!qX.adQ() || qX.cJ(false) == null || qX.cJ(false).aer() == null || bo.isNullOrNil(qX.adX()))) {
                    qX.field_enterpriseFather = qX.adX();
                    ab.d("MicroMsg.BigBallOfMudSyncExtension", "processModUserInfoExt, %s set enterpriseFather %s", a, qX.field_enterpriseFather);
                }
                if (!z.aeR().e(qX)) {
                    z.aeR().d(qX);
                }
                int i2 = cme.xjS;
                int i3 = cme.xjT;
                int i4 = cme.xjU;
                ab.d("MicroMsg.BigBallOfMudSyncExtension", "roomSize :" + i2 + " rommquota: " + i3 + " invite: " + i4);
                aw.ZK();
                c.Ry().set(135175, Integer.valueOf(i2));
                aw.ZK();
                c.Ry().set(135176, Integer.valueOf(i3));
                aw.ZK();
                c.Ry().set(135177, Integer.valueOf(i4));
                aw.ZK();
                c.Ry().set(144385, Integer.valueOf(cme.xjY));
                aw.ZK();
                c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(cme.wlv));
                aw.ZK();
                c.Ry().set(339975, Integer.valueOf(cme.xkg));
                ab.i("MicroMsg.BigBallOfMudSyncExtension", "hy: sync do cmd pay wallet type: %d %d", Integer.valueOf(cme.xkg), Integer.valueOf(cme.wlv));
                aw.ZK();
                c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_PROFILE_WEIDIANINFO_STRING, bo.bc(cme.duq, ""));
                ab.d("MicroMsg.BigBallOfMudSyncExtension", "weidianinfo:%s", cme.duq);
                aw.ZK();
                c.Ry().set(147457, Long.valueOf(cme.xkh));
                ab.d("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.ExtStatus:%s", Long.valueOf(cme.xkh));
                aw.ZK();
                c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_F2F_RING_TONE_STRING, cme.xki);
                hVar = new h();
                hVar.bJt = -1;
                hVar.username = a;
                hVar.frW = cme.vXm;
                hVar.frV = cme.vXn;
                hVar.cB(true);
                hVar.dtR = 3;
                ab.d("MicroMsg.BigBallOfMudSyncExtension", "dkavatar user:[%s] big:[%s] sm:[%s]", hVar.getUsername(), hVar.ack(), hVar.acl());
                o.act().b(hVar);
                Object obj = cme.wGm;
                Object obj2 = cme.wGn;
                aw.ZK();
                c.Ry().set(274433, obj2);
                aw.ZK();
                c.Ry().set(274434, obj);
                if (cme.vEU != null) {
                    aw.ZK();
                    c.Ry().set(286721, cme.vEU.vLl);
                    aw.ZK();
                    c.Ry().set(286722, cme.vEU.vLm);
                    aw.ZK();
                    c.Ry().set(286723, cme.vEU.vLn);
                }
                if (!(cme.xke == null || cme.xke.wLS == null || cme.xke.wLS.getILen() <= 0)) {
                    ab.i("MicroMsg.BigBallOfMudSyncExtension", "tomgest PatternLockInfo %d", Integer.valueOf(cme.xke.wLS.getILen()));
                    tr trVar = new tr();
                    trVar.cPQ.cPR = cme.xke;
                    com.tencent.mm.sdk.b.a.xxA.m(trVar);
                }
                AppMethodBeat.o(16492);
                return;
            case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                bdx bdx = (bdx) new bdx().parseFrom(bArr);
                ab.d("MicroMsg.BigBallOfMudSyncExtension", "rollback, msgtype is %d, msgid is %d", Integer.valueOf(bdx.nao), Long.valueOf(bdx.ptF));
                if (com.tencent.mm.model.t.np(bdx.ndG)) {
                    pg pgVar = new pg();
                    pgVar.cLy.cvx = bdx.ptF;
                    com.tencent.mm.sdk.b.a.xxA.m(pgVar);
                }
                AppMethodBeat.o(16492);
                return;
            case 204:
                qu quVar = new qu();
                quVar.cMZ.data = bArr;
                com.tencent.mm.sdk.b.a.xxA.m(quVar);
                AppMethodBeat.o(16492);
                return;
            case 999999:
                try {
                    int t = com.tencent.mm.a.o.t(bArr, 0);
                    ab.d("MicroMsg.BigBallOfMudSyncExtension", "local test synccmd, sleep %d", Integer.valueOf(t));
                    if (t > 0) {
                        Thread.sleep((long) t);
                    }
                    AppMethodBeat.o(16492);
                    return;
                } catch (InterruptedException e) {
                    ab.printErrStackTrace("MicroMsg.BigBallOfMudSyncExtension", e, "", new Object[0]);
                    AppMethodBeat.o(16492);
                    return;
                }
            default:
                ab.e("MicroMsg.BigBallOfMudSyncExtension", "doCmd: no processing method, cmd id=" + tbVar.wat);
                AppMethodBeat.o(16492);
                return;
        }
    }

    public static boolean a(ad adVar) {
        AppMethodBeat.i(16493);
        String str;
        String str2;
        Object[] objArr;
        if (adVar == null || bo.isNullOrNil(adVar.field_username)) {
            String str3;
            str = "MicroMsg.BigBallOfMudSyncExtension";
            str2 = "dealModContactExtInfo username:%s ";
            objArr = new Object[1];
            if (adVar == null) {
                str3 = "-1";
            } else {
                str3 = adVar.field_username;
            }
            objArr[0] = str3;
            ab.w(str, str2, objArr);
            AppMethodBeat.o(16493);
            return false;
        }
        aw.ZK();
        byte[] aoS = c.XM().aoS(adVar.field_username);
        if (bo.cb(aoS)) {
            str = "MicroMsg.BigBallOfMudSyncExtension";
            str2 = "dealModContactExtInfo username:%s  buf:%d";
            objArr = new Object[2];
            objArr[0] = adVar.field_username;
            objArr[1] = Integer.valueOf(aoS == null ? -1 : aoS.length);
            ab.w(str, str2, objArr);
            AppMethodBeat.o(16493);
            return false;
        }
        bbv bbv;
        try {
            bbv = (bbv) new bbv().parseFrom(aoS);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BigBallOfMudSyncExtension", e, "", new Object[0]);
            bbv = null;
        }
        aw.ZK();
        c.XM().aoT(adVar.field_username);
        if (bbv == null) {
            ab.e("MicroMsg.BigBallOfMudSyncExtension", "dkinit dealModContactExtInfo failed parse buf failed.");
            AppMethodBeat.o(16493);
            return false;
        }
        boolean a = com.tencent.mm.plugin.bbom.c.a(adVar, bbv, false);
        AppMethodBeat.o(16493);
        return a;
    }
}
