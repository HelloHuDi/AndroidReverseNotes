package com.tencent.p177mm.plugin.sns.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C42185ar;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p230g.p231a.C37794rn;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.lucky.p1298a.C21905g;
import com.tencent.p177mm.plugin.sns.p1025h.C21896c;
import com.tencent.p177mm.plugin.sns.p517i.C21902f;
import com.tencent.p177mm.plugin.sns.p520ui.widget.C39851d;
import com.tencent.p177mm.plugin.sns.storage.C21991i;
import com.tencent.p177mm.plugin.sns.storage.C21992j;
import com.tencent.p177mm.plugin.sns.storage.C29096k;
import com.tencent.p177mm.plugin.sns.storage.C29097l;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.C44098aa;
import com.tencent.p177mm.protocal.protobuf.C40573tb;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.ata;
import com.tencent.p177mm.protocal.protobuf.brf;
import com.tencent.p177mm.protocal.protobuf.can;
import com.tencent.p177mm.protocal.protobuf.cao;
import com.tencent.p177mm.protocal.protobuf.cbf;
import com.tencent.p177mm.protocal.protobuf.cbx;
import com.tencent.p177mm.protocal.protobuf.cby;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vfs.C5730e;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.model.u */
public final class C7101u extends C1207m implements C1918k {
    private static List<C42185ar> qJB = new LinkedList();
    private static C21896c qJD;
    private static boolean qJE = true;
    private String ecX = "";
    C7472b ehh;
    C1202f ehi;
    private C7104a qJC = new C7104a();

    /* renamed from: com.tencent.mm.plugin.sns.model.u$a */
    class C7104a {
        LinkedList<C40573tb> mgm;
        C7306ak mgn = new C71051();

        /* renamed from: com.tencent.mm.plugin.sns.model.u$a$1 */
        class C71051 extends C7306ak {
            C71051() {
            }

            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(36303);
                C1720g.m3537RQ();
                if (!C1720g.m3534RN().mo5161QY()) {
                    AppMethodBeat.m2505o(36303);
                } else if (C7104a.this.mgm == null || C7104a.this.mgm.isEmpty()) {
                    C7101u c7101u = C7101u.this;
                    cby cby = (cby) c7101u.ehh.fsH.fsP;
                    cbx cbx = (cbx) c7101u.ehh.fsG.fsP;
                    byte[] j = C44098aa.m79382j(cbx.vTO.getBuffer().toByteArray(), cby.vTO.getBuffer().toByteArray());
                    if (j != null && j.length > 0) {
                        C1720g.m3537RQ();
                        C1720g.m3536RP().mo5239Ry().set(8195, C5046bo.m7543cd(j));
                    }
                    cbx.vTO.setBuffer(j);
                    if ((cby.vQe & cbx.vTN) == 0) {
                        c7101u.ehi.onSceneEnd(0, 0, "", c7101u);
                        AppMethodBeat.m2505o(36303);
                        return;
                    }
                    c7101u.mo4456a(c7101u.ftf, c7101u.ehi);
                    AppMethodBeat.m2505o(36303);
                } else {
                    final C40573tb c40573tb = (C40573tb) C7104a.this.mgm.getFirst();
                    C4990ab.m7410d("MicroMsg.NetSceneNewSyncAlbum", "cmdId = " + c40573tb.wat);
                    C7104a.this.mgm.removeFirst();
                    switch (c40573tb.wat) {
                        case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                            C13373af.cno().post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(36301);
                                    if (!C7101u.this.mo15440a(c40573tb, C7104a.this.mgn)) {
                                        C7104a.this.mgn.sendEmptyMessage(0);
                                    }
                                    AppMethodBeat.m2505o(36301);
                                }
                            });
                            AppMethodBeat.m2505o(36303);
                            return;
                        case 46:
                            C13373af.cno().post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(36302);
                                    if (!C7101u.this.mo15441b(c40573tb, C7104a.this.mgn)) {
                                        C7104a.this.mgn.sendEmptyMessage(0);
                                    }
                                    AppMethodBeat.m2505o(36302);
                                }
                            });
                            AppMethodBeat.m2505o(36303);
                            return;
                        default:
                            C7104a.this.mgn.sendEmptyMessage(0);
                            AppMethodBeat.m2505o(36303);
                            return;
                    }
                }
            }
        }

        C7104a() {
            AppMethodBeat.m2504i(36304);
            AppMethodBeat.m2505o(36304);
        }
    }

    static {
        AppMethodBeat.m2504i(36322);
        AppMethodBeat.m2505o(36322);
    }

    public C7101u() {
        AppMethodBeat.m2504i(36305);
        C4990ab.m7417i("MicroMsg.NetSceneNewSyncAlbum", "NetSceneSnsSync %d", Integer.valueOf(256));
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cbx();
        c1196a.fsK = new cby();
        c1196a.uri = "/cgi-bin/micromsg-bin/mmsnssync";
        c1196a.fsI = 214;
        c1196a.fsL = 102;
        c1196a.fsM = 1000000102;
        this.ehh = c1196a.acD();
        ((cbx) this.ehh.fsG.fsP).vTN = 256;
        this.ecX = C1853r.m3846Yz();
        if (qJE) {
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder stringBuilder = new StringBuilder();
            C1720g.m3537RQ();
            String stringBuilder2 = stringBuilder.append(C1720g.m3536RP().cachePath).append("ad_1100007").toString();
            C4990ab.m7416i("MicroMsg.NetSceneNewSyncAlbum", "filepath to list  ".concat(String.valueOf(stringBuilder2)));
            byte[] e = C5730e.m8632e(stringBuilder2, 0, -1);
            if (e != null) {
                try {
                    qJD = (C21896c) new C21896c().parseFrom(e);
                    C4990ab.m7416i("MicroMsg.NetSceneNewSyncAlbum", "fileToList " + (System.currentTimeMillis() - currentTimeMillis));
                    if (qJD == null) {
                        C4990ab.m7416i("MicroMsg.NetSceneNewSyncAlbum", "igNoreAbTestId parser error");
                    } else {
                        C4990ab.m7416i("MicroMsg.NetSceneNewSyncAlbum", "igNoreAbTestId size " + qJD.qQf.size());
                    }
                } catch (IOException e2) {
                    C4990ab.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e2, "", new Object[0]);
                    C5730e.deleteFile(stringBuilder2);
                }
            }
            qJE = false;
        }
        AppMethodBeat.m2505o(36305);
    }

    public final int acn() {
        return 10;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(36306);
        C1720g.m3537RQ();
        byte[] anf = C5046bo.anf(C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(8195, null)));
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        sKBuiltinBuffer_t.setBuffer(anf);
        ((cbx) this.ehh.fsG.fsP).vTO = sKBuiltinBuffer_t;
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(36306);
        return a;
    }

    /* renamed from: kg */
    public static void m11899kg(long j) {
        AppMethodBeat.m2504i(36307);
        if (qJD == null) {
            qJD = new C21896c();
        }
        qJD.qQf.add(Long.valueOf(j));
        AppMethodBeat.m2505o(36307);
    }

    /* renamed from: kh */
    public static void m11900kh(long j) {
        AppMethodBeat.m2504i(36308);
        if (qJD != null) {
            qJD.qQf.remove(Long.valueOf(j));
        }
        AppMethodBeat.m2505o(36308);
    }

    /* renamed from: ki */
    public static boolean m11901ki(long j) {
        AppMethodBeat.m2504i(36309);
        if (qJD == null) {
            AppMethodBeat.m2505o(36309);
            return false;
        } else if (qJD.qQf.contains(Long.valueOf(j))) {
            AppMethodBeat.m2505o(36309);
            return true;
        } else {
            AppMethodBeat.m2505o(36309);
            return false;
        }
    }

    public static void cmZ() {
        AppMethodBeat.m2504i(36310);
        if (qJD == null) {
            AppMethodBeat.m2505o(36310);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3537RQ();
        String stringBuilder2 = stringBuilder.append(C1720g.m3536RP().cachePath).append("ad_1100007").toString();
        C4990ab.m7416i("MicroMsg.NetSceneNewSyncAlbum", "listToFile to list  ".concat(String.valueOf(stringBuilder2)));
        try {
            byte[] toByteArray = qJD.toByteArray();
            C5730e.m8624b(stringBuilder2, toByteArray, toByteArray.length);
            C4990ab.m7416i("MicroMsg.NetSceneNewSyncAlbum", "listTofile " + (System.currentTimeMillis() - currentTimeMillis) + " igNoreAbTestId " + qJD.qQf.size());
            AppMethodBeat.m2505o(36310);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "listToFile failed: ".concat(String.valueOf(stringBuilder2)), new Object[0]);
            AppMethodBeat.m2505o(36310);
        }
    }

    public final boolean acI() {
        return true;
    }

    public final int getType() {
        return 214;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(36311);
        C4990ab.m7410d("MicroMsg.NetSceneNewSyncAlbum", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            cby cby = (cby) ((C7472b) c1929q).fsH.fsP;
            LinkedList linkedList = cby.vTR.jBw;
            if (linkedList == null || linkedList.size() <= 0) {
                if (!(cby.vTO == null || cby.vTO.getBuffer() == null)) {
                    byte[] j = C44098aa.m79382j(((cbx) ((C7472b) c1929q).fsG.fsP).vTO.getBuffer().toByteArray(), cby.vTO.getBuffer().toByteArray());
                    if (j != null && j.length > 0) {
                        C1720g.m3537RQ();
                        C1720g.m3536RP().mo5239Ry().set(8195, C5046bo.m7543cd(j));
                    }
                }
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(36311);
                return;
            }
            C4990ab.m7410d("MicroMsg.NetSceneNewSyncAlbum", "cmlList size:" + linkedList.size());
            C7104a c7104a = this.qJC;
            c7104a.mgm = linkedList;
            c7104a.mgn.sendEmptyMessage(0);
            AppMethodBeat.m2505o(36311);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(36311);
    }

    /* renamed from: a */
    public final boolean mo15440a(C40573tb c40573tb, final C7306ak c7306ak) {
        AppMethodBeat.m2504i(36312);
        try {
            final cbf cbf = (cbf) new cbf().parseFrom(c40573tb.wau.getBuffer().toByteArray());
            String str = new String(cbf.xam.getBuffer().toByteArray());
            boolean z = str.indexOf("<contentStyle><![CDATA[1]]></contentStyle>") >= 0 || str.indexOf("<contentStyle>1</contentStyle>") >= 0;
            C4990ab.m7416i("MicroMsg.NetSceneNewSyncAlbum", "snsSync " + cbf.vQE + " " + C29036i.m46117jV(cbf.vQE) + " isPhoto " + z);
            if (z) {
                String jV = C29036i.m46117jV(cbf.vQE);
                C29097l YX = C13373af.cnJ().mo69179YX(cbf.vHl);
                if (C5046bo.isNullOrNil(YX.field_newerIds)) {
                    C13373af.cnJ().mo69183gq(cbf.vHl, jV);
                } else {
                    String[] split = YX.field_newerIds.split(",");
                    z = true;
                    for (Object equals : split) {
                        if (jV.equals(equals)) {
                            z = false;
                        }
                    }
                    int i = 0;
                    String str2 = jV;
                    while (i < 2 && i < split.length && z) {
                        str2 = str2 + "," + split[i];
                        i++;
                    }
                    C4990ab.m7410d("MicroMsg.NetSceneNewSyncAlbum", "snsync newerIds " + cbf.vQE + " S: " + jV + " list " + YX.field_newerIds + " newer " + str2);
                    if (z) {
                        C13373af.cnJ().mo69183gq(cbf.vHl, str2);
                    }
                }
            }
            if (C13373af.cnF().mo62942kv(cbf.vQE)) {
                C4990ab.m7416i("MicroMsg.NetSceneNewSyncAlbum", "this item has in your sns pass it");
                AppMethodBeat.m2505o(36312);
                return false;
            }
            C4879a.xxA.mo10055m(new C37794rn());
            C13373af.bCo().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(36299);
                    if (!cbf.vHl.equals(C7101u.this.ecX)) {
                        C1720g.m3537RQ();
                        if (C1720g.m3534RN().mo5161QY()) {
                            C1720g.m3537RQ();
                            String str = (String) C1720g.m3536RP().mo5239Ry().get(68377, null);
                            C1720g.m3537RQ();
                            if (!(C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(68400, null), 0) == cbf.pcX && (C5046bo.isNullOrNil(str) || str.equals(cbf.vHl)))) {
                                C1720g.m3537RQ();
                                C1720g.m3536RP().mo5239Ry().set(68377, cbf.vHl);
                                C1720g.m3537RQ();
                                C1720g.m3536RP().mo5239Ry().set(68400, Integer.valueOf(cbf.pcX));
                                C1720g.m3537RQ();
                                C1720g.m3536RP().mo5239Ry().set(68418, C29036i.m46117jV(cbf.vQE));
                                C1720g.m3537RQ();
                                C1720g.m3536RP().mo5239Ry().set(68419, Integer.valueOf(0));
                                C21902f.m33470k(1, C29036i.m46117jV(cbf.vQE), 0);
                            }
                            for (C42185ar Zy : C7101u.qJB) {
                                Zy.mo55685Zy();
                            }
                        } else {
                            C4990ab.m7412e("MicroMsg.NetSceneNewSyncAlbum", "mmcore has not set uin!!");
                            AppMethodBeat.m2505o(36299);
                            return;
                        }
                    }
                    c7306ak.sendEmptyMessage(0);
                    AppMethodBeat.m2505o(36299);
                }
            });
            AppMethodBeat.m2505o(36312);
            return true;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            AppMethodBeat.m2505o(36312);
            return false;
        }
    }

    /* renamed from: b */
    public final boolean mo15441b(C40573tb c40573tb, C7306ak c7306ak) {
        AppMethodBeat.m2504i(36313);
        try {
            cao cao = (cao) new cao().parseFrom(c40573tb.wau.getBuffer().toByteArray());
            long j = cao.vQE;
            long j2 = cao.wZM;
            final can can = cao.wZN;
            String str = cao.ptv;
            if (str == null) {
                str = "";
            }
            C4990ab.m7416i("MicroMsg.NetSceneNewSyncAlbum", "process action " + can.jCt + " " + j + " " + str);
            C21992j f;
            boolean a;
            switch (can.jCt) {
                case 9:
                    f = C13373af.cnK().mo47206f(j, (long) can.wZG, can.jCt);
                    if (f != null) {
                        f.cqD();
                        a = C13373af.cnK().mo16757a(f.xDa, (C4925c) f);
                        C34955aj.m57401b(j, cao);
                        C4990ab.m7416i("MicroMsg.NetSceneNewSyncAlbum", " setdel flag  ".concat(String.valueOf(a)));
                        break;
                    }
                    break;
                case 10:
                    f = C13373af.cnK().mo47206f(j, can.wZJ, can.jCt);
                    if (f != null) {
                        f.cqD();
                        a = C13373af.cnK().mo16757a(f.xDa, (C4925c) f);
                        C34955aj.m57401b(j, cao);
                        C4990ab.m7416i("MicroMsg.NetSceneNewSyncAlbum", " setdel ad flag  ".concat(String.valueOf(a)));
                        break;
                    }
                    break;
                case 11:
                    C29096k cnK = C13373af.cnK();
                    String concat = " update SnsComment set commentflag = 2 where snsID = ".concat(String.valueOf(j));
                    C4990ab.m7416i("MicroMsg.SnsCommentStorage", "set sns del ".concat(String.valueOf(concat)));
                    a = cnK.fni.mo10108hY("SnsComment", concat);
                    if (a) {
                        cnK.doNotify();
                    }
                    C4990ab.m7416i("MicroMsg.NetSceneNewSyncAlbum", "processSnsDelAction ".concat(String.valueOf(a)));
                    break;
                case 12:
                    C29096k cnK2 = C13373af.cnK();
                    String str2 = " update SnsComment set commentflag = 1 where snsID = " + j + " and talker = '" + C5046bo.m7586vA(can.wPm) + "'";
                    C4990ab.m7416i("MicroMsg.SnsCommentStorage", "set sns del  by username ".concat(String.valueOf(str2)));
                    boolean hY = cnK2.fni.mo10108hY("SnsComment", str2);
                    if (hY) {
                        cnK2.doNotify();
                    }
                    C4990ab.m7416i("MicroMsg.NetSceneNewSyncAlbum", "processAdSnsDelAction ".concat(String.valueOf(hY)));
                    C34955aj.m57401b(j, cao);
                    break;
                case 13:
                    C7101u.m11896a(cao, can, j, j2, str);
                    break;
                case 14:
                    C7101u.m11898b(cao, can, j, j2, str);
                    break;
                case 15:
                    C21991i.m33619kw(j);
                    C46236n kD = C13373af.cnF().mo62941kD(j);
                    TimeLineObject cqu = kD.cqu();
                    cqu.dtW = 1;
                    kD.mo74257c(cqu);
                    C13373af.cnF().mo62930b(j, kD);
                    break;
                case 16:
                    brf brf = can.vFa;
                    if (C13428m.m21567kc(j)) {
                        C1207m c13428m = new C13428m(j, brf);
                        C1720g.m3537RQ();
                        C1720g.m3535RO().eJo.mo14541a(c13428m, 0);
                    }
                    try {
                        can can2 = cao.wZN;
                        String nullAsNil = C5046bo.nullAsNil(cao.ptv);
                        long j3 = cao.wZM;
                        int i = C5046bo.getInt(C26373g.m41964Nu().getValue("SnsAdNotifyLimit"), 0);
                        int i2 = C5046bo.getInt(C26373g.m41964Nu().getValue("SnsAdNotifyLikeTimeLimit"), 0);
                        int i3 = C5046bo.getInt(C26373g.m41964Nu().getValue("SnsAdNotifyCommentTimeLimit"), 0);
                        if (brf != null) {
                            C4990ab.m7417i("MicroMsg.NetSceneNewSyncAlbum", "processAdAtAction clientId %s, snsId %s, aid %s, commentId %s, actionLimit %s", nullAsNil, Long.valueOf(j), Integer.valueOf(brf.wTz), Integer.valueOf(can2.wZG), Integer.valueOf(i));
                            if (brf.wTz == 0) {
                                C7060h.pYm.mo15419k(955, 4, 1);
                            }
                        } else {
                            C4990ab.m7416i("MicroMsg.NetSceneNewSyncAlbum", "remindFriendsInfo is null!");
                            C7060h.pYm.mo15419k(955, 3, 1);
                        }
                        if (!C13373af.cnK().mo47201a(j, can2.wPm, can2.pcX, nullAsNil)) {
                            can can3 = cao.wZO;
                            C21992j c21992j = new C21992j();
                            c21992j.field_snsID = j;
                            c21992j.field_parentID = j3;
                            c21992j.field_createTime = can2.pcX;
                            c21992j.field_talker = can2.wPm;
                            c21992j.field_type = can2.jCt;
                            c21992j.field_curActionBuf = can2.toByteArray();
                            c21992j.field_refActionBuf = can3.toByteArray();
                            c21992j.field_clientId = nullAsNil;
                            c21992j.field_isSilence = C39851d.m68264fF(can2.wZL, 2) ? 1 : 0;
                            c21992j.field_commentSvrID = can2.wZJ;
                            if (C13373af.cnI().mo69175kv(j)) {
                                if ((i <= 0 && i2 <= 0 && i3 <= 0) || C43555a.m77872a(j, cao, i, i2, i3, true)) {
                                    if (!C43555a.m77871a(j, cao)) {
                                        C4990ab.m7416i("MicroMsg.NetSceneNewSyncAlbum", "pass comment ID " + c21992j.field_snsID + " " + c21992j.field_commentSvrID);
                                        break;
                                    }
                                }
                                C4990ab.m7416i("MicroMsg.NetSceneNewSyncAlbum", "check comment fail, pass comment ID " + c21992j.field_snsID + " " + c21992j.field_commentSvrID);
                                break;
                            }
                            C13373af.cnK().mo10101b((C4925c) c21992j);
                            C13373af.cnK().mo47209y(j, C39851d.m68264fF(can2.wZL, 2));
                            break;
                        }
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
                        break;
                    }
                    break;
                default:
                    C7101u.m11895a(cao);
                    break;
            }
            final boolean z = !C39851d.m68264fF(can.wZL, 2);
            final C7306ak c7306ak2 = c7306ak;
            C13373af.bCo().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(36300);
                    if (z) {
                        for (C42185ar c42185ar : C7101u.qJB) {
                            C4990ab.m7416i("MicroMsg.NetSceneNewSyncAlbum", "notify list ");
                            c42185ar.mo55684Zx();
                        }
                    }
                    c7306ak2.sendEmptyMessage(0);
                    AppMethodBeat.m2505o(36300);
                }
            });
            AppMethodBeat.m2505o(36313);
            return true;
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e2, "", new Object[0]);
            AppMethodBeat.m2505o(36313);
            return false;
        }
    }

    /* renamed from: kj */
    public static boolean m11902kj(long j) {
        AppMethodBeat.m2504i(36314);
        try {
            boolean a = C43555a.m77872a(j, null, C5046bo.getInt(C26373g.m41964Nu().getValue("SnsAdNotifyLimit"), 0), C5046bo.getInt(C26373g.m41964Nu().getValue("SnsAdNotifyLikeTimeLimit"), 0), C5046bo.getInt(C26373g.m41964Nu().getValue("SnsAdNotifyCommentTimeLimit"), 0), false);
            AppMethodBeat.m2505o(36314);
            return a;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            AppMethodBeat.m2505o(36314);
            return true;
        }
    }

    /* renamed from: a */
    private static boolean m11895a(cao cao) {
        AppMethodBeat.m2504i(36315);
        can can = cao.wZN;
        long j = cao.vQE;
        String nullAsNil = C5046bo.nullAsNil(cao.ptv);
        long j2 = cao.wZM;
        int i = C5046bo.getInt(C26373g.m41964Nu().getValue("SnsAdNotifyLimit"), 0);
        int i2 = C5046bo.getInt(C26373g.m41964Nu().getValue("SnsAdNotifyLikeTimeLimit"), 0);
        int i3 = C5046bo.getInt(C26373g.m41964Nu().getValue("SnsAdNotifyCommentTimeLimit"), 0);
        if ((i > 0 || i2 > 0 || i3 > 0) && ((can.jCt == 8 || can.jCt == 7) && !C43555a.m77872a(j, cao, i, i2, i3, true))) {
            C4990ab.m7416i("MicroMsg.NetSceneNewSyncAlbum", "pass the comment clientId " + nullAsNil + " snsId: " + j + " " + can.wZJ + " " + can.wZG + " actionLimit:" + i + " actionLikeTimeLimit:" + i2 + " actionCommentTimeLimit:" + i3);
            C43555a.m77871a(j, cao);
            AppMethodBeat.m2505o(36315);
            return false;
        }
        try {
            C4990ab.m7416i("MicroMsg.NetSceneNewSyncAlbum", "processNormalAction clientId " + nullAsNil + " snsId: " + j + " " + can.wZJ + " " + can.wZG + " actionLimit: " + i);
            if (C13373af.cnK().mo47201a(j, can.wPm, can.pcX, nullAsNil)) {
                AppMethodBeat.m2505o(36315);
                return false;
            }
            can can2 = cao.wZO;
            C21992j c21992j = new C21992j();
            c21992j.field_snsID = j;
            c21992j.field_parentID = j2;
            c21992j.field_createTime = can.pcX;
            c21992j.field_talker = can.wPm;
            c21992j.field_type = can.jCt;
            c21992j.field_curActionBuf = can.toByteArray();
            c21992j.field_refActionBuf = can2.toByteArray();
            c21992j.field_clientId = nullAsNil;
            c21992j.field_isSilence = C39851d.m68264fF(can.wZL, 2) ? 1 : 0;
            if (can.jCt == 8 || can.jCt == 7) {
                c21992j.field_commentSvrID = can.wZJ;
                if (!C43555a.m77871a(j, cao)) {
                    C4990ab.m7416i("MicroMsg.NetSceneNewSyncAlbum", "pass comment ID " + c21992j.field_snsID + " " + c21992j.field_commentSvrID);
                    AppMethodBeat.m2505o(36315);
                    return false;
                }
            }
            c21992j.field_commentSvrID = (long) can.wZG;
            if (!C34955aj.m57398a(j, cao)) {
                AppMethodBeat.m2505o(36315);
                return false;
            }
            C13373af.cnK().mo10101b((C4925c) c21992j);
            C13373af.cnK().mo47209y(j, C39851d.m68264fF(can.wZL, 2));
            AppMethodBeat.m2505o(36315);
            return true;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            AppMethodBeat.m2505o(36315);
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m11896a(cao cao, can can, long j, long j2, String str) {
        AppMethodBeat.m2504i(36316);
        try {
            C4990ab.m7416i("MicroMsg.NetSceneNewSyncAlbum", "processHbAction clientId " + str + " snsId: " + j + " " + can.wZJ + " " + can.wZG);
            if (C21905g.cmw()) {
                if (C13373af.cnK().mo47201a(j, can.wPm, can.pcX, str)) {
                    AppMethodBeat.m2505o(36316);
                    return false;
                }
                can can2 = cao.wZO;
                C21992j c21992j = new C21992j();
                c21992j.field_snsID = j;
                c21992j.field_parentID = j2;
                c21992j.field_createTime = can.pcX;
                c21992j.field_talker = can.wPm;
                c21992j.field_type = can.jCt;
                c21992j.field_curActionBuf = can.toByteArray();
                c21992j.field_refActionBuf = can2.toByteArray();
                c21992j.field_clientId = str;
                c21992j.field_commentSvrID = (long) can.wZG;
                C4990ab.m7416i("MicroMsg.NetSceneNewSyncAlbum", "curAction.HBBuffer " + can.wZK);
                C34955aj.m57403c(j, cao);
                C7101u.m11892Zz();
                C13373af.cnK().mo10101b((C4925c) c21992j);
                AppMethodBeat.m2505o(36316);
                return true;
            }
            C4990ab.m7416i("MicroMsg.NetSceneNewSyncAlbum", "passed because close lucky");
            AppMethodBeat.m2505o(36316);
            return false;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.NetSceneNewSyncAlbum", "error processHbAction " + e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            AppMethodBeat.m2505o(36316);
            return false;
        }
    }

    /* renamed from: b */
    private static boolean m11898b(cao cao, can can, long j, long j2, String str) {
        AppMethodBeat.m2504i(36317);
        try {
            C4990ab.m7416i("MicroMsg.NetSceneNewSyncAlbum", "processGrabHbAction clientId " + str + " snsId: " + j + " " + can.wZJ + " " + can.wZG);
            if (C13373af.cnK().mo47201a(j, can.wPm, can.pcX, str)) {
                AppMethodBeat.m2505o(36317);
                return false;
            }
            can can2 = cao.wZO;
            C21992j c21992j = new C21992j();
            c21992j.field_snsID = j;
            c21992j.field_parentID = j2;
            c21992j.field_createTime = can.pcX;
            c21992j.field_talker = can.wPm;
            c21992j.field_type = can.jCt;
            c21992j.field_curActionBuf = can.toByteArray();
            c21992j.field_refActionBuf = can2.toByteArray();
            c21992j.field_clientId = str;
            c21992j.field_commentSvrID = (long) can.wZG;
            ata ata = new ata();
            C4990ab.m7416i("MicroMsg.NetSceneNewSyncAlbum", "curAction.HBBuffer " + can.wZK);
            ata.parseFrom(C1946aa.m4150a(can.wZK));
            C4990ab.m7416i("MicroMsg.NetSceneNewSyncAlbum", "hbbuffer  " + ata.cSh);
            C13373af.cnK().mo10101b((C4925c) c21992j);
            AppMethodBeat.m2505o(36317);
            return true;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.NetSceneNewSyncAlbum", "error processHbAction " + e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            AppMethodBeat.m2505o(36317);
            return false;
        }
    }

    public static void cna() {
        AppMethodBeat.m2504i(36318);
        for (C42185ar c42185ar : qJB) {
            if (c42185ar != null) {
                c42185ar.mo55683ZA();
            }
        }
        AppMethodBeat.m2505o(36318);
    }

    /* renamed from: Zz */
    private static void m11892Zz() {
        AppMethodBeat.m2504i(36319);
        for (C42185ar c42185ar : qJB) {
            if (c42185ar != null) {
                c42185ar.mo55686Zz();
            }
        }
        AppMethodBeat.m2505o(36319);
    }

    /* renamed from: a */
    public static void m11894a(C42185ar c42185ar) {
        AppMethodBeat.m2504i(36320);
        if (!qJB.contains(c42185ar)) {
            qJB.add(c42185ar);
        }
        AppMethodBeat.m2505o(36320);
    }

    /* renamed from: b */
    public static void m11897b(C42185ar c42185ar) {
        AppMethodBeat.m2504i(36321);
        qJB.remove(c42185ar);
        AppMethodBeat.m2505o(36321);
    }
}
