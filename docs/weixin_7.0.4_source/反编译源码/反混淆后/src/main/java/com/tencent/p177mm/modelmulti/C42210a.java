package com.tencent.p177mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p178a.C37432o;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p182ah.C41732d;
import com.tencent.p177mm.p182ah.C41733e;
import com.tencent.p177mm.p182ah.C41733e.C25750c;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p230g.p231a.C26203mx;
import com.tencent.p177mm.p230g.p231a.C26225qu;
import com.tencent.p177mm.p230g.p231a.C32643tr;
import com.tencent.p177mm.p230g.p231a.C42035pg;
import com.tencent.p177mm.p230g.p231a.C45368sw;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.account.C32923a;
import com.tencent.p177mm.plugin.account.friend.p272a.C45499p;
import com.tencent.p177mm.plugin.bbom.C45754c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C21279r;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C21280t;
import com.tencent.p177mm.plugin.sns.p1024b.C21877n;
import com.tencent.p177mm.plugin.story.api.C35168e;
import com.tencent.p177mm.protocal.protobuf.C40573tb;
import com.tencent.p177mm.protocal.protobuf.C7285uy;
import com.tencent.p177mm.protocal.protobuf.act;
import com.tencent.p177mm.protocal.protobuf.auw;
import com.tencent.p177mm.protocal.protobuf.bbn;
import com.tencent.p177mm.protocal.protobuf.bbq;
import com.tencent.p177mm.protocal.protobuf.bbv;
import com.tencent.p177mm.protocal.protobuf.bcf;
import com.tencent.p177mm.protocal.protobuf.bcq;
import com.tencent.p177mm.protocal.protobuf.bdx;
import com.tencent.p177mm.protocal.protobuf.bmt;
import com.tencent.p177mm.protocal.protobuf.cgc;
import com.tencent.p177mm.protocal.protobuf.cme;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.RegionCodeDecoder;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.ttpic.wav.WavFileHeader;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.modelmulti.a */
public final class C42210a implements C21279r {

    /* renamed from: com.tencent.mm.modelmulti.a$1 */
    class C312741 implements C25750c {
        C312741() {
        }

        /* renamed from: cr */
        public final int mo4442cr(int i, int i2) {
            return 0;
        }
    }

    /* renamed from: a */
    public final void mo36640a(C40573tb c40573tb, byte[] bArr, boolean z, C21280t c21280t) {
        AppMethodBeat.m2504i(16492);
        String a;
        C7616ad aoO;
        C7616ad aoO2;
        C17880h c17880h;
        switch (c40573tb.wat) {
            case 13:
                bcf bcf = (bcf) new bcf().parseFrom(bArr);
                if (1 == bcf.wGK) {
                    C9638aw.m17190ZK();
                    C18628c.m29086XU().mo15361e(C1946aa.m4148a(bcf.wcB), bcf.wGu == 1, bcf.wGL == 1);
                    AppMethodBeat.m2505o(16492);
                    return;
                }
                C4990ab.m7412e("MicroMsg.BigBallOfMudSyncExtension", "unknown micro blog type:" + bcf.wGK);
                AppMethodBeat.m2505o(16492);
                return;
            case 15:
                bbq bbq = (bbq) new bbq().parseFrom(bArr);
                if (bbq != null) {
                    C4990ab.m7410d("MicroMsg.BigBallOfMudSyncExtension", "processModChatRoomMember username:" + bbq.wcB + " nickname:" + bbq.wyX);
                    a = C1946aa.m4148a(bbq.wcB);
                    C9638aw.m17190ZK();
                    aoO = C18628c.m29078XM().aoO(a);
                    aoO.setUsername(a);
                    aoO.mo14703iB(C1946aa.m4148a(bbq.wyX));
                    aoO.mo14704iC(C1946aa.m4148a(bbq.wce));
                    aoO.mo14705iD(C1946aa.m4148a(bbq.wcf));
                    aoO.mo14685hA(bbq.guN);
                    aoO.mo14729iz(C1946aa.m4148a(bbq.wFK));
                    aoO.mo14707iF(C1946aa.m4148a(bbq.wFM));
                    aoO.mo14708iG(C1946aa.m4148a(bbq.wFL));
                    aoO.mo14688hD(bbq.wbA);
                    C17880h c17880h2 = new C17880h();
                    c17880h2.bJt = -1;
                    c17880h2.username = aoO.field_username;
                    c17880h2.frV = bbq.vXn;
                    c17880h2.frW = bbq.vXm;
                    C4990ab.m7411d("MicroMsg.BigBallOfMudSyncExtension", "dkhurl chatmember %s b[%s] s[%s]", c17880h2.getUsername(), c17880h2.ack(), c17880h2.acl());
                    c17880h2.mo33385cB(true);
                    if (bbq.wGb == 3 || bbq.wGb == 4) {
                        aoO.mo14701hz(bbq.wGb);
                        c17880h2.dtR = bbq.wGb;
                    } else if (bbq.wGb == 2) {
                        aoO.mo14701hz(3);
                        c17880h2.dtR = 3;
                        aoO.mo14701hz(3);
                        if (!C1853r.m3846Yz().equals(aoO.field_username)) {
                            C17884o.acd();
                            C41732d.m73516E(aoO.field_username, false);
                            C17884o.acd();
                            C41732d.m73516E(aoO.field_username, true);
                            C17884o.acv().mo67495pZ(aoO.field_username);
                        }
                    }
                    C17884o.act().mo33391b(c17880h2);
                    C9638aw.m17190ZK();
                    C18628c.m29078XM().mo15701Y(aoO);
                    C16527d qP = C41747z.aeR().mo43729qP(aoO.field_username);
                    qP.field_username = aoO.field_username;
                    qP.field_brandList = bbq.guX;
                    C7285uy c7285uy = bbq.wCa;
                    if (c7285uy != null) {
                        qP.field_brandFlag = c7285uy.gvb;
                        qP.field_brandInfo = c7285uy.gvd;
                        qP.field_brandIconURL = c7285uy.gve;
                        qP.field_extInfo = c7285uy.gvc;
                    }
                    if (!C41747z.aeR().mo43726e(qP)) {
                        C41747z.aeR().mo43724d(qP);
                    }
                }
                AppMethodBeat.m2505o(16492);
                return;
            case 22:
                auw auw = (auw) new auw().parseFrom(bArr);
                C45499p c45499p = new C45499p();
                c45499p.username = auw.jBB;
                c45499p.gvE = auw.wyY;
                c45499p.fvK = (int) C5046bo.anT();
                C32923a.getInviteFriendOpenStg().mo21239b(c45499p);
                AppMethodBeat.m2505o(16492);
                return;
            case 23:
                act act = (act) new act().parseFrom(bArr);
                switch (act.wkw) {
                    case 1:
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().set(17, Integer.valueOf(act.pvD));
                        AppMethodBeat.m2505o(16492);
                        return;
                    case 4:
                        AppMethodBeat.m2505o(16492);
                        return;
                    default:
                        C4990ab.m7412e("MicroMsg.BigBallOfMudSyncExtension", "unknown function switch id:" + act.wkw);
                        AppMethodBeat.m2505o(16492);
                        return;
                }
            case 24:
                bmt bmt = (bmt) new bmt().parseFrom(bArr);
                Assert.assertTrue(bmt != null);
                Assert.assertTrue(C5046bo.nullAsNil(bmt.jBB).length() > 0);
                if (C7616ad.aow(bmt.jBB)) {
                    C9638aw.m17190ZK();
                    aoO2 = C18628c.m29078XM().aoO(bmt.jBB);
                    if (aoO2 == null || ((int) aoO2.ewQ) == 0) {
                        aoO2 = new C7616ad(bmt.jBB);
                        aoO2.mo16682NH();
                        aoO2.mo14703iB(bmt.vXl);
                        aoO2.mo14729iz(bmt.vXl);
                        aoO2.mo14688hD(4);
                        C9638aw.m17190ZK();
                        if (C18628c.m29078XM().mo15708aa(aoO2) == -1) {
                            C4990ab.m7412e("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: insert contact failed");
                            AppMethodBeat.m2505o(16492);
                            return;
                        }
                        C41730b.m73503pV(aoO2.field_username);
                    } else if (!C5046bo.nullAsNil(bmt.vXl).equals(C5046bo.nullAsNil(aoO2.field_username))) {
                        aoO2.mo14703iB(bmt.vXl);
                        aoO2.mo14729iz(bmt.vXl);
                        C9638aw.m17190ZK();
                        if (C18628c.m29078XM().mo15724b(aoO2.field_username, aoO2) == -1) {
                            C4990ab.m7412e("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: update contact failed");
                        }
                    }
                    C26203mx c26203mx = new C26203mx();
                    c26203mx.cIO.opType = 1;
                    c26203mx.cIO.cIS = bmt.jBB;
                    c26203mx.cIO.cIT = bmt.wPH;
                    c26203mx.cIO.cIU = bmt.wbH;
                    C4879a.xxA.mo10055m(c26203mx);
                    AppMethodBeat.m2505o(16492);
                    return;
                }
                C4990ab.m7420w("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: qcontact should ends with @t.qq.com");
                AppMethodBeat.m2505o(16492);
                return;
            case 25:
                cgc cgc = (cgc) new cgc().parseFrom(bArr);
                Assert.assertTrue(cgc != null);
                Assert.assertTrue(C5046bo.nullAsNil(cgc.jBB).length() > 0);
                if (C7616ad.aou(cgc.jBB)) {
                    C9638aw.m17190ZK();
                    aoO2 = C18628c.m29078XM().aoO(cgc.jBB);
                    if (aoO2 == null || ((int) aoO2.ewQ) == 0) {
                        aoO2 = new C7616ad(cgc.jBB);
                        aoO2.mo14729iz(cgc.vXl);
                        aoO2.mo14688hD(1);
                        aoO2.mo16682NH();
                        C9638aw.m17190ZK();
                        if (C18628c.m29078XM().mo15708aa(aoO2) == -1) {
                            C4990ab.m7412e("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: insert contact failed");
                            AppMethodBeat.m2505o(16492);
                            return;
                        }
                        a = aoO2.field_username;
                        if (a == null) {
                            C4990ab.m7420w("MicroMsg.AvatarLogic", "setMBTAvatarImgFlag failed : invalid username");
                        } else if (a.endsWith("@t.qq.com")) {
                            c17880h = new C17880h();
                            c17880h.username = a;
                            c17880h.dtR = 3;
                            c17880h.bJt = 3;
                            C17884o.act().mo33391b(c17880h);
                        } else {
                            C4990ab.m7420w("MicroMsg.AvatarLogic", "setMBTAvatarImgFlag failed : invalid username");
                        }
                    } else if (!C5046bo.nullAsNil(cgc.vXl).equals(C5046bo.nullAsNil(aoO2.field_username))) {
                        aoO2.mo14729iz(cgc.vXl);
                        C9638aw.m17190ZK();
                        if (C18628c.m29078XM().mo15724b(aoO2.field_username, aoO2) == -1) {
                            C4990ab.m7412e("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: update contact failed");
                        }
                    }
                    C45368sw c45368sw = new C45368sw();
                    c45368sw.cOY.opType = 1;
                    c45368sw.cOY.cIS = cgc.jBB;
                    c45368sw.cOY.cIT = cgc.wPH;
                    c45368sw.cOY.cIU = cgc.wbH;
                    C4879a.xxA.mo10055m(c45368sw);
                    AppMethodBeat.m2505o(16492);
                    return;
                }
                C4990ab.m7420w("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: tcontact should ends with @t.qq.com");
                AppMethodBeat.m2505o(16492);
                return;
            case 33:
                bbn bbn = (bbn) new bbn().parseFrom(bArr);
                Assert.assertTrue(bbn != null);
                Assert.assertTrue(C5046bo.nullAsNil(bbn.jBB).length() > 0);
                aoO = new C7616ad();
                aoO.setUsername(bbn.jBB);
                aoO.setType(bbn.jCt);
                aoO.mo14685hA(bbn.guN);
                aoO.mo14724iW(RegionCodeDecoder.m7796aC(bbn.guW, bbn.guO, bbn.guP));
                aoO.mo14718iQ(bbn.guQ);
                C17880h c17880h3 = new C17880h();
                c17880h3.bJt = -1;
                c17880h3.username = bbn.jBB;
                c17880h3.frV = bbn.vXn;
                c17880h3.frW = bbn.vXm;
                C4990ab.m7411d("MicroMsg.BigBallOfMudSyncExtension", "dkhurl bottle %s b[%s] s[%s]", c17880h3.getUsername(), c17880h3.ack(), c17880h3.acl());
                C4990ab.m7410d("MicroMsg.BigBallOfMudSyncExtension", "bottlecontact imgflag:" + bbn.wGb + " hd:" + bbn.wGc);
                c17880h3.mo33385cB(bbn.wGc != 0);
                if (bbn.wGb == 3 || bbn.wGb == 4) {
                    aoO.mo14701hz(bbn.wGb);
                    c17880h3.dtR = bbn.wGb;
                } else if (bbn.wGb == 2) {
                    aoO.mo14701hz(3);
                    c17880h3.dtR = 3;
                    C17884o.acd();
                    C41732d.m73516E(bbn.jBB, false);
                    C17884o.acd();
                    C41732d.m73516E(bbn.jBB, true);
                    C17884o.acv().mo67495pZ(bbn.jBB);
                } else {
                    aoO.mo14701hz(3);
                    c17880h3.dtR = 3;
                }
                C17884o.act().mo33391b(c17880h3);
                C9638aw.m17190ZK();
                C18628c.m29078XM().mo15700X(aoO);
                AppMethodBeat.m2505o(16492);
                return;
            case 35:
                String str;
                String str2;
                bcq bcq = (bcq) new bcq().parseFrom(bArr);
                Assert.assertTrue(bcq != null);
                String Yz = C1853r.m3846Yz();
                int i = bcq.vOw;
                if (i == 2) {
                    Yz = C7616ad.aoC(Yz);
                    C9638aw.m17190ZK();
                    str = Yz;
                    str2 = (String) C18628c.m29072Ry().get(12553, null);
                } else {
                    C9638aw.m17190ZK();
                    str = Yz;
                    str2 = (String) C18628c.m29072Ry().get(12297, null);
                }
                boolean z2 = false;
                if (str2 == null || !str2.equals(bcq.wGV)) {
                    C17884o.acd();
                    C41732d.m73516E(str, true);
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(i == 2 ? 12553 : 12297, bcq.wGV);
                    z2 = true;
                }
                C4990ab.m7411d("MicroMsg.BigBallOfMudSyncExtension", "ModUserImg beRemove:%b imgtype:%d md5:%s big:%s sm:%s", Boolean.valueOf(z2), Integer.valueOf(i), bcq.wGV, bcq.vXm, bcq.vXn);
                c17880h = new C17880h();
                c17880h.username = str;
                c17880h.frW = bcq.vXm;
                c17880h.frV = bcq.vXn;
                if (!C5046bo.isNullOrNil(c17880h.acl())) {
                    if (i == 1) {
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().set(59, Boolean.TRUE);
                    } else {
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().set(60, Boolean.TRUE);
                    }
                }
                c17880h.mo33385cB(false);
                c17880h.bJt = 56;
                if (!C5046bo.isNullOrNil(bcq.wGV)) {
                    c17880h.mo33385cB(true);
                }
                C17884o.act().mo33391b(c17880h);
                if (z2) {
                    new C41733e().mo67507a(str, new C312741());
                }
                AppMethodBeat.m2505o(16492);
                return;
            case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                cme cme = (cme) new cme().parseFrom(bArr);
                C4990ab.m7417i("MicroMsg.BigBallOfMudSyncExtension", "snsExtFlag:%s, snsExtFlagEx:%s, snsPrivacyRecent:%s", Integer.valueOf(cme.wBZ.guY), Integer.valueOf(cme.wBZ.xbQ), Integer.valueOf(cme.wBZ.xbR));
                C9638aw.m17190ZK();
                a = (String) C18628c.m29072Ry().get(2, null);
                if (a == null || a.length() <= 0) {
                    AppMethodBeat.m2505o(16492);
                    return;
                }
                if (C21877n.qFy != null) {
                    C21877n.qFy.mo47112a(a, cme.wBZ);
                }
                C4990ab.m7417i("MicroMsg.BigBallOfMudSyncExtension", "storyExtFlag:%s", Integer.valueOf(cme.xkj.xeE));
                ((C35168e) C1720g.m3530M(C35168e.class)).updateStoryUserInfo(a, cme.xkj);
                C16527d qX = C17903f.m28104qX(C1853r.m3846Yz());
                if (qX == null) {
                    qX = new C16527d();
                }
                qX.field_username = a;
                qX.field_brandList = cme.guX;
                if (!(!qX.adQ() || qX.mo30481cJ(false) == null || qX.mo30481cJ(false).aer() == null || C5046bo.isNullOrNil(qX.adX()))) {
                    qX.field_enterpriseFather = qX.adX();
                    C4990ab.m7411d("MicroMsg.BigBallOfMudSyncExtension", "processModUserInfoExt, %s set enterpriseFather %s", a, qX.field_enterpriseFather);
                }
                if (!C41747z.aeR().mo43726e(qX)) {
                    C41747z.aeR().mo43724d(qX);
                }
                int i2 = cme.xjS;
                int i3 = cme.xjT;
                int i4 = cme.xjU;
                C4990ab.m7410d("MicroMsg.BigBallOfMudSyncExtension", "roomSize :" + i2 + " rommquota: " + i3 + " invite: " + i4);
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(135175, Integer.valueOf(i2));
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(135176, Integer.valueOf(i3));
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(135177, Integer.valueOf(i4));
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(144385, Integer.valueOf(cme.xjY));
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(cme.wlv));
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(339975, Integer.valueOf(cme.xkg));
                C4990ab.m7417i("MicroMsg.BigBallOfMudSyncExtension", "hy: sync do cmd pay wallet type: %d %d", Integer.valueOf(cme.xkg), Integer.valueOf(cme.wlv));
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERINFO_PROFILE_WEIDIANINFO_STRING, C5046bo.m7532bc(cme.duq, ""));
                C4990ab.m7411d("MicroMsg.BigBallOfMudSyncExtension", "weidianinfo:%s", cme.duq);
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(147457, Long.valueOf(cme.xkh));
                C4990ab.m7411d("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.ExtStatus:%s", Long.valueOf(cme.xkh));
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERINFO_F2F_RING_TONE_STRING, cme.xki);
                c17880h = new C17880h();
                c17880h.bJt = -1;
                c17880h.username = a;
                c17880h.frW = cme.vXm;
                c17880h.frV = cme.vXn;
                c17880h.mo33385cB(true);
                c17880h.dtR = 3;
                C4990ab.m7411d("MicroMsg.BigBallOfMudSyncExtension", "dkavatar user:[%s] big:[%s] sm:[%s]", c17880h.getUsername(), c17880h.ack(), c17880h.acl());
                C17884o.act().mo33391b(c17880h);
                Object obj = cme.wGm;
                Object obj2 = cme.wGn;
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(274433, obj2);
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(274434, obj);
                if (cme.vEU != null) {
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(286721, cme.vEU.vLl);
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(286722, cme.vEU.vLm);
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(286723, cme.vEU.vLn);
                }
                if (!(cme.xke == null || cme.xke.wLS == null || cme.xke.wLS.getILen() <= 0)) {
                    C4990ab.m7417i("MicroMsg.BigBallOfMudSyncExtension", "tomgest PatternLockInfo %d", Integer.valueOf(cme.xke.wLS.getILen()));
                    C32643tr c32643tr = new C32643tr();
                    c32643tr.cPQ.cPR = cme.xke;
                    C4879a.xxA.mo10055m(c32643tr);
                }
                AppMethodBeat.m2505o(16492);
                return;
            case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                bdx bdx = (bdx) new bdx().parseFrom(bArr);
                C4990ab.m7411d("MicroMsg.BigBallOfMudSyncExtension", "rollback, msgtype is %d, msgid is %d", Integer.valueOf(bdx.nao), Long.valueOf(bdx.ptF));
                if (C1855t.m3947np(bdx.ndG)) {
                    C42035pg c42035pg = new C42035pg();
                    c42035pg.cLy.cvx = bdx.ptF;
                    C4879a.xxA.mo10055m(c42035pg);
                }
                AppMethodBeat.m2505o(16492);
                return;
            case 204:
                C26225qu c26225qu = new C26225qu();
                c26225qu.cMZ.data = bArr;
                C4879a.xxA.mo10055m(c26225qu);
                AppMethodBeat.m2505o(16492);
                return;
            case 999999:
                try {
                    int t = C37432o.m63092t(bArr, 0);
                    C4990ab.m7411d("MicroMsg.BigBallOfMudSyncExtension", "local test synccmd, sleep %d", Integer.valueOf(t));
                    if (t > 0) {
                        Thread.sleep((long) t);
                    }
                    AppMethodBeat.m2505o(16492);
                    return;
                } catch (InterruptedException e) {
                    C4990ab.printErrStackTrace("MicroMsg.BigBallOfMudSyncExtension", e, "", new Object[0]);
                    AppMethodBeat.m2505o(16492);
                    return;
                }
            default:
                C4990ab.m7412e("MicroMsg.BigBallOfMudSyncExtension", "doCmd: no processing method, cmd id=" + c40573tb.wat);
                AppMethodBeat.m2505o(16492);
                return;
        }
    }

    /* renamed from: a */
    public static boolean m74470a(C7616ad c7616ad) {
        AppMethodBeat.m2504i(16493);
        String str;
        String str2;
        Object[] objArr;
        if (c7616ad == null || C5046bo.isNullOrNil(c7616ad.field_username)) {
            String str3;
            str = "MicroMsg.BigBallOfMudSyncExtension";
            str2 = "dealModContactExtInfo username:%s ";
            objArr = new Object[1];
            if (c7616ad == null) {
                str3 = "-1";
            } else {
                str3 = c7616ad.field_username;
            }
            objArr[0] = str3;
            C4990ab.m7421w(str, str2, objArr);
            AppMethodBeat.m2505o(16493);
            return false;
        }
        C9638aw.m17190ZK();
        byte[] aoS = C18628c.m29078XM().aoS(c7616ad.field_username);
        if (C5046bo.m7540cb(aoS)) {
            str = "MicroMsg.BigBallOfMudSyncExtension";
            str2 = "dealModContactExtInfo username:%s  buf:%d";
            objArr = new Object[2];
            objArr[0] = c7616ad.field_username;
            objArr[1] = Integer.valueOf(aoS == null ? -1 : aoS.length);
            C4990ab.m7421w(str, str2, objArr);
            AppMethodBeat.m2505o(16493);
            return false;
        }
        bbv bbv;
        try {
            bbv = (bbv) new bbv().parseFrom(aoS);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BigBallOfMudSyncExtension", e, "", new Object[0]);
            bbv = null;
        }
        C9638aw.m17190ZK();
        C18628c.m29078XM().aoT(c7616ad.field_username);
        if (bbv == null) {
            C4990ab.m7412e("MicroMsg.BigBallOfMudSyncExtension", "dkinit dealModContactExtInfo failed parse buf failed.");
            AppMethodBeat.m2505o(16493);
            return false;
        }
        boolean a = C45754c.m84563a(c7616ad, bbv, false);
        AppMethodBeat.m2505o(16493);
        return a;
    }
}
