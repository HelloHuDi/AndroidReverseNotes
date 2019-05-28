package com.tencent.mm.plugin.sns.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.r;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.h.c;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.widget.d;
import com.tencent.mm.protocal.aa;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.ata;
import com.tencent.mm.protocal.protobuf.brf;
import com.tencent.mm.protocal.protobuf.can;
import com.tencent.mm.protocal.protobuf.cao;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.protocal.protobuf.cbx;
import com.tencent.mm.protocal.protobuf.cby;
import com.tencent.mm.protocal.protobuf.tb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public final class u extends m implements k {
    private static List<ar> qJB = new LinkedList();
    private static c qJD;
    private static boolean qJE = true;
    private String ecX = "";
    b ehh;
    f ehi;
    private a qJC = new a();

    class a {
        LinkedList<tb> mgm;
        ak mgn = new ak() {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(36303);
                g.RQ();
                if (!g.RN().QY()) {
                    AppMethodBeat.o(36303);
                } else if (a.this.mgm == null || a.this.mgm.isEmpty()) {
                    u uVar = u.this;
                    cby cby = (cby) uVar.ehh.fsH.fsP;
                    cbx cbx = (cbx) uVar.ehh.fsG.fsP;
                    byte[] j = aa.j(cbx.vTO.getBuffer().toByteArray(), cby.vTO.getBuffer().toByteArray());
                    if (j != null && j.length > 0) {
                        g.RQ();
                        g.RP().Ry().set(8195, bo.cd(j));
                    }
                    cbx.vTO.setBuffer(j);
                    if ((cby.vQe & cbx.vTN) == 0) {
                        uVar.ehi.onSceneEnd(0, 0, "", uVar);
                        AppMethodBeat.o(36303);
                        return;
                    }
                    uVar.a(uVar.ftf, uVar.ehi);
                    AppMethodBeat.o(36303);
                } else {
                    final tb tbVar = (tb) a.this.mgm.getFirst();
                    ab.d("MicroMsg.NetSceneNewSyncAlbum", "cmdId = " + tbVar.wat);
                    a.this.mgm.removeFirst();
                    switch (tbVar.wat) {
                        case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                            af.cno().post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(36301);
                                    if (!u.this.a(tbVar, a.this.mgn)) {
                                        a.this.mgn.sendEmptyMessage(0);
                                    }
                                    AppMethodBeat.o(36301);
                                }
                            });
                            AppMethodBeat.o(36303);
                            return;
                        case 46:
                            af.cno().post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(36302);
                                    if (!u.this.b(tbVar, a.this.mgn)) {
                                        a.this.mgn.sendEmptyMessage(0);
                                    }
                                    AppMethodBeat.o(36302);
                                }
                            });
                            AppMethodBeat.o(36303);
                            return;
                        default:
                            a.this.mgn.sendEmptyMessage(0);
                            AppMethodBeat.o(36303);
                            return;
                    }
                }
            }
        };

        a() {
            AppMethodBeat.i(36304);
            AppMethodBeat.o(36304);
        }
    }

    static {
        AppMethodBeat.i(36322);
        AppMethodBeat.o(36322);
    }

    public u() {
        AppMethodBeat.i(36305);
        ab.i("MicroMsg.NetSceneNewSyncAlbum", "NetSceneSnsSync %d", Integer.valueOf(256));
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new cbx();
        aVar.fsK = new cby();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnssync";
        aVar.fsI = 214;
        aVar.fsL = 102;
        aVar.fsM = 1000000102;
        this.ehh = aVar.acD();
        ((cbx) this.ehh.fsG.fsP).vTN = 256;
        this.ecX = r.Yz();
        if (qJE) {
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder stringBuilder = new StringBuilder();
            g.RQ();
            String stringBuilder2 = stringBuilder.append(g.RP().cachePath).append("ad_1100007").toString();
            ab.i("MicroMsg.NetSceneNewSyncAlbum", "filepath to list  ".concat(String.valueOf(stringBuilder2)));
            byte[] e = e.e(stringBuilder2, 0, -1);
            if (e != null) {
                try {
                    qJD = (c) new c().parseFrom(e);
                    ab.i("MicroMsg.NetSceneNewSyncAlbum", "fileToList " + (System.currentTimeMillis() - currentTimeMillis));
                    if (qJD == null) {
                        ab.i("MicroMsg.NetSceneNewSyncAlbum", "igNoreAbTestId parser error");
                    } else {
                        ab.i("MicroMsg.NetSceneNewSyncAlbum", "igNoreAbTestId size " + qJD.qQf.size());
                    }
                } catch (IOException e2) {
                    ab.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e2, "", new Object[0]);
                    e.deleteFile(stringBuilder2);
                }
            }
            qJE = false;
        }
        AppMethodBeat.o(36305);
    }

    public final int acn() {
        return 10;
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(36306);
        g.RQ();
        byte[] anf = bo.anf(bo.nullAsNil((String) g.RP().Ry().get(8195, null)));
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        sKBuiltinBuffer_t.setBuffer(anf);
        ((cbx) this.ehh.fsG.fsP).vTO = sKBuiltinBuffer_t;
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(36306);
        return a;
    }

    public static void kg(long j) {
        AppMethodBeat.i(36307);
        if (qJD == null) {
            qJD = new c();
        }
        qJD.qQf.add(Long.valueOf(j));
        AppMethodBeat.o(36307);
    }

    public static void kh(long j) {
        AppMethodBeat.i(36308);
        if (qJD != null) {
            qJD.qQf.remove(Long.valueOf(j));
        }
        AppMethodBeat.o(36308);
    }

    public static boolean ki(long j) {
        AppMethodBeat.i(36309);
        if (qJD == null) {
            AppMethodBeat.o(36309);
            return false;
        } else if (qJD.qQf.contains(Long.valueOf(j))) {
            AppMethodBeat.o(36309);
            return true;
        } else {
            AppMethodBeat.o(36309);
            return false;
        }
    }

    public static void cmZ() {
        AppMethodBeat.i(36310);
        if (qJD == null) {
            AppMethodBeat.o(36310);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        g.RQ();
        String stringBuilder2 = stringBuilder.append(g.RP().cachePath).append("ad_1100007").toString();
        ab.i("MicroMsg.NetSceneNewSyncAlbum", "listToFile to list  ".concat(String.valueOf(stringBuilder2)));
        try {
            byte[] toByteArray = qJD.toByteArray();
            e.b(stringBuilder2, toByteArray, toByteArray.length);
            ab.i("MicroMsg.NetSceneNewSyncAlbum", "listTofile " + (System.currentTimeMillis() - currentTimeMillis) + " igNoreAbTestId " + qJD.qQf.size());
            AppMethodBeat.o(36310);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "listToFile failed: ".concat(String.valueOf(stringBuilder2)), new Object[0]);
            AppMethodBeat.o(36310);
        }
    }

    public final boolean acI() {
        return true;
    }

    public final int getType() {
        return 214;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(36311);
        ab.d("MicroMsg.NetSceneNewSyncAlbum", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            cby cby = (cby) ((b) qVar).fsH.fsP;
            LinkedList linkedList = cby.vTR.jBw;
            if (linkedList == null || linkedList.size() <= 0) {
                if (!(cby.vTO == null || cby.vTO.getBuffer() == null)) {
                    byte[] j = aa.j(((cbx) ((b) qVar).fsG.fsP).vTO.getBuffer().toByteArray(), cby.vTO.getBuffer().toByteArray());
                    if (j != null && j.length > 0) {
                        g.RQ();
                        g.RP().Ry().set(8195, bo.cd(j));
                    }
                }
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(36311);
                return;
            }
            ab.d("MicroMsg.NetSceneNewSyncAlbum", "cmlList size:" + linkedList.size());
            a aVar = this.qJC;
            aVar.mgm = linkedList;
            aVar.mgn.sendEmptyMessage(0);
            AppMethodBeat.o(36311);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(36311);
    }

    public final boolean a(tb tbVar, final ak akVar) {
        AppMethodBeat.i(36312);
        try {
            final cbf cbf = (cbf) new cbf().parseFrom(tbVar.wau.getBuffer().toByteArray());
            String str = new String(cbf.xam.getBuffer().toByteArray());
            boolean z = str.indexOf("<contentStyle><![CDATA[1]]></contentStyle>") >= 0 || str.indexOf("<contentStyle>1</contentStyle>") >= 0;
            ab.i("MicroMsg.NetSceneNewSyncAlbum", "snsSync " + cbf.vQE + " " + i.jV(cbf.vQE) + " isPhoto " + z);
            if (z) {
                String jV = i.jV(cbf.vQE);
                l YX = af.cnJ().YX(cbf.vHl);
                if (bo.isNullOrNil(YX.field_newerIds)) {
                    af.cnJ().gq(cbf.vHl, jV);
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
                    ab.d("MicroMsg.NetSceneNewSyncAlbum", "snsync newerIds " + cbf.vQE + " S: " + jV + " list " + YX.field_newerIds + " newer " + str2);
                    if (z) {
                        af.cnJ().gq(cbf.vHl, str2);
                    }
                }
            }
            if (af.cnF().kv(cbf.vQE)) {
                ab.i("MicroMsg.NetSceneNewSyncAlbum", "this item has in your sns pass it");
                AppMethodBeat.o(36312);
                return false;
            }
            com.tencent.mm.sdk.b.a.xxA.m(new rn());
            af.bCo().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(36299);
                    if (!cbf.vHl.equals(u.this.ecX)) {
                        g.RQ();
                        if (g.RN().QY()) {
                            g.RQ();
                            String str = (String) g.RP().Ry().get(68377, null);
                            g.RQ();
                            if (!(bo.a((Integer) g.RP().Ry().get(68400, null), 0) == cbf.pcX && (bo.isNullOrNil(str) || str.equals(cbf.vHl)))) {
                                g.RQ();
                                g.RP().Ry().set(68377, cbf.vHl);
                                g.RQ();
                                g.RP().Ry().set(68400, Integer.valueOf(cbf.pcX));
                                g.RQ();
                                g.RP().Ry().set(68418, i.jV(cbf.vQE));
                                g.RQ();
                                g.RP().Ry().set(68419, Integer.valueOf(0));
                                com.tencent.mm.plugin.sns.i.f.k(1, i.jV(cbf.vQE), 0);
                            }
                            for (ar Zy : u.qJB) {
                                Zy.Zy();
                            }
                        } else {
                            ab.e("MicroMsg.NetSceneNewSyncAlbum", "mmcore has not set uin!!");
                            AppMethodBeat.o(36299);
                            return;
                        }
                    }
                    akVar.sendEmptyMessage(0);
                    AppMethodBeat.o(36299);
                }
            });
            AppMethodBeat.o(36312);
            return true;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            AppMethodBeat.o(36312);
            return false;
        }
    }

    public final boolean b(tb tbVar, ak akVar) {
        AppMethodBeat.i(36313);
        try {
            cao cao = (cao) new cao().parseFrom(tbVar.wau.getBuffer().toByteArray());
            long j = cao.vQE;
            long j2 = cao.wZM;
            final can can = cao.wZN;
            String str = cao.ptv;
            if (str == null) {
                str = "";
            }
            ab.i("MicroMsg.NetSceneNewSyncAlbum", "process action " + can.jCt + " " + j + " " + str);
            j f;
            boolean a;
            switch (can.jCt) {
                case 9:
                    f = af.cnK().f(j, (long) can.wZG, can.jCt);
                    if (f != null) {
                        f.cqD();
                        a = af.cnK().a(f.xDa, (com.tencent.mm.sdk.e.c) f);
                        aj.b(j, cao);
                        ab.i("MicroMsg.NetSceneNewSyncAlbum", " setdel flag  ".concat(String.valueOf(a)));
                        break;
                    }
                    break;
                case 10:
                    f = af.cnK().f(j, can.wZJ, can.jCt);
                    if (f != null) {
                        f.cqD();
                        a = af.cnK().a(f.xDa, (com.tencent.mm.sdk.e.c) f);
                        aj.b(j, cao);
                        ab.i("MicroMsg.NetSceneNewSyncAlbum", " setdel ad flag  ".concat(String.valueOf(a)));
                        break;
                    }
                    break;
                case 11:
                    com.tencent.mm.plugin.sns.storage.k cnK = af.cnK();
                    String concat = " update SnsComment set commentflag = 2 where snsID = ".concat(String.valueOf(j));
                    ab.i("MicroMsg.SnsCommentStorage", "set sns del ".concat(String.valueOf(concat)));
                    a = cnK.fni.hY("SnsComment", concat);
                    if (a) {
                        cnK.doNotify();
                    }
                    ab.i("MicroMsg.NetSceneNewSyncAlbum", "processSnsDelAction ".concat(String.valueOf(a)));
                    break;
                case 12:
                    com.tencent.mm.plugin.sns.storage.k cnK2 = af.cnK();
                    String str2 = " update SnsComment set commentflag = 1 where snsID = " + j + " and talker = '" + bo.vA(can.wPm) + "'";
                    ab.i("MicroMsg.SnsCommentStorage", "set sns del  by username ".concat(String.valueOf(str2)));
                    boolean hY = cnK2.fni.hY("SnsComment", str2);
                    if (hY) {
                        cnK2.doNotify();
                    }
                    ab.i("MicroMsg.NetSceneNewSyncAlbum", "processAdSnsDelAction ".concat(String.valueOf(hY)));
                    aj.b(j, cao);
                    break;
                case 13:
                    a(cao, can, j, j2, str);
                    break;
                case 14:
                    b(cao, can, j, j2, str);
                    break;
                case 15:
                    com.tencent.mm.plugin.sns.storage.i.kw(j);
                    n kD = af.cnF().kD(j);
                    TimeLineObject cqu = kD.cqu();
                    cqu.dtW = 1;
                    kD.c(cqu);
                    af.cnF().b(j, kD);
                    break;
                case 16:
                    brf brf = can.vFa;
                    if (m.kc(j)) {
                        m mVar = new m(j, brf);
                        g.RQ();
                        g.RO().eJo.a(mVar, 0);
                    }
                    try {
                        can can2 = cao.wZN;
                        String nullAsNil = bo.nullAsNil(cao.ptv);
                        long j3 = cao.wZM;
                        int i = bo.getInt(com.tencent.mm.m.g.Nu().getValue("SnsAdNotifyLimit"), 0);
                        int i2 = bo.getInt(com.tencent.mm.m.g.Nu().getValue("SnsAdNotifyLikeTimeLimit"), 0);
                        int i3 = bo.getInt(com.tencent.mm.m.g.Nu().getValue("SnsAdNotifyCommentTimeLimit"), 0);
                        if (brf != null) {
                            ab.i("MicroMsg.NetSceneNewSyncAlbum", "processAdAtAction clientId %s, snsId %s, aid %s, commentId %s, actionLimit %s", nullAsNil, Long.valueOf(j), Integer.valueOf(brf.wTz), Integer.valueOf(can2.wZG), Integer.valueOf(i));
                            if (brf.wTz == 0) {
                                h.pYm.k(955, 4, 1);
                            }
                        } else {
                            ab.i("MicroMsg.NetSceneNewSyncAlbum", "remindFriendsInfo is null!");
                            h.pYm.k(955, 3, 1);
                        }
                        if (!af.cnK().a(j, can2.wPm, can2.pcX, nullAsNil)) {
                            can can3 = cao.wZO;
                            j jVar = new j();
                            jVar.field_snsID = j;
                            jVar.field_parentID = j3;
                            jVar.field_createTime = can2.pcX;
                            jVar.field_talker = can2.wPm;
                            jVar.field_type = can2.jCt;
                            jVar.field_curActionBuf = can2.toByteArray();
                            jVar.field_refActionBuf = can3.toByteArray();
                            jVar.field_clientId = nullAsNil;
                            jVar.field_isSilence = d.fF(can2.wZL, 2) ? 1 : 0;
                            jVar.field_commentSvrID = can2.wZJ;
                            if (af.cnI().kv(j)) {
                                if ((i <= 0 && i2 <= 0 && i3 <= 0) || a.a(j, cao, i, i2, i3, true)) {
                                    if (!a.a(j, cao)) {
                                        ab.i("MicroMsg.NetSceneNewSyncAlbum", "pass comment ID " + jVar.field_snsID + " " + jVar.field_commentSvrID);
                                        break;
                                    }
                                }
                                ab.i("MicroMsg.NetSceneNewSyncAlbum", "check comment fail, pass comment ID " + jVar.field_snsID + " " + jVar.field_commentSvrID);
                                break;
                            }
                            af.cnK().b((com.tencent.mm.sdk.e.c) jVar);
                            af.cnK().y(j, d.fF(can2.wZL, 2));
                            break;
                        }
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
                        break;
                    }
                    break;
                default:
                    a(cao);
                    break;
            }
            final boolean z = !d.fF(can.wZL, 2);
            final ak akVar2 = akVar;
            af.bCo().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(36300);
                    if (z) {
                        for (ar arVar : u.qJB) {
                            ab.i("MicroMsg.NetSceneNewSyncAlbum", "notify list ");
                            arVar.Zx();
                        }
                    }
                    akVar2.sendEmptyMessage(0);
                    AppMethodBeat.o(36300);
                }
            });
            AppMethodBeat.o(36313);
            return true;
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e2, "", new Object[0]);
            AppMethodBeat.o(36313);
            return false;
        }
    }

    public static boolean kj(long j) {
        AppMethodBeat.i(36314);
        try {
            boolean a = a.a(j, null, bo.getInt(com.tencent.mm.m.g.Nu().getValue("SnsAdNotifyLimit"), 0), bo.getInt(com.tencent.mm.m.g.Nu().getValue("SnsAdNotifyLikeTimeLimit"), 0), bo.getInt(com.tencent.mm.m.g.Nu().getValue("SnsAdNotifyCommentTimeLimit"), 0), false);
            AppMethodBeat.o(36314);
            return a;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            AppMethodBeat.o(36314);
            return true;
        }
    }

    private static boolean a(cao cao) {
        AppMethodBeat.i(36315);
        can can = cao.wZN;
        long j = cao.vQE;
        String nullAsNil = bo.nullAsNil(cao.ptv);
        long j2 = cao.wZM;
        int i = bo.getInt(com.tencent.mm.m.g.Nu().getValue("SnsAdNotifyLimit"), 0);
        int i2 = bo.getInt(com.tencent.mm.m.g.Nu().getValue("SnsAdNotifyLikeTimeLimit"), 0);
        int i3 = bo.getInt(com.tencent.mm.m.g.Nu().getValue("SnsAdNotifyCommentTimeLimit"), 0);
        if ((i > 0 || i2 > 0 || i3 > 0) && ((can.jCt == 8 || can.jCt == 7) && !a.a(j, cao, i, i2, i3, true))) {
            ab.i("MicroMsg.NetSceneNewSyncAlbum", "pass the comment clientId " + nullAsNil + " snsId: " + j + " " + can.wZJ + " " + can.wZG + " actionLimit:" + i + " actionLikeTimeLimit:" + i2 + " actionCommentTimeLimit:" + i3);
            a.a(j, cao);
            AppMethodBeat.o(36315);
            return false;
        }
        try {
            ab.i("MicroMsg.NetSceneNewSyncAlbum", "processNormalAction clientId " + nullAsNil + " snsId: " + j + " " + can.wZJ + " " + can.wZG + " actionLimit: " + i);
            if (af.cnK().a(j, can.wPm, can.pcX, nullAsNil)) {
                AppMethodBeat.o(36315);
                return false;
            }
            can can2 = cao.wZO;
            j jVar = new j();
            jVar.field_snsID = j;
            jVar.field_parentID = j2;
            jVar.field_createTime = can.pcX;
            jVar.field_talker = can.wPm;
            jVar.field_type = can.jCt;
            jVar.field_curActionBuf = can.toByteArray();
            jVar.field_refActionBuf = can2.toByteArray();
            jVar.field_clientId = nullAsNil;
            jVar.field_isSilence = d.fF(can.wZL, 2) ? 1 : 0;
            if (can.jCt == 8 || can.jCt == 7) {
                jVar.field_commentSvrID = can.wZJ;
                if (!a.a(j, cao)) {
                    ab.i("MicroMsg.NetSceneNewSyncAlbum", "pass comment ID " + jVar.field_snsID + " " + jVar.field_commentSvrID);
                    AppMethodBeat.o(36315);
                    return false;
                }
            }
            jVar.field_commentSvrID = (long) can.wZG;
            if (!aj.a(j, cao)) {
                AppMethodBeat.o(36315);
                return false;
            }
            af.cnK().b((com.tencent.mm.sdk.e.c) jVar);
            af.cnK().y(j, d.fF(can.wZL, 2));
            AppMethodBeat.o(36315);
            return true;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            AppMethodBeat.o(36315);
            return false;
        }
    }

    private static boolean a(cao cao, can can, long j, long j2, String str) {
        AppMethodBeat.i(36316);
        try {
            ab.i("MicroMsg.NetSceneNewSyncAlbum", "processHbAction clientId " + str + " snsId: " + j + " " + can.wZJ + " " + can.wZG);
            if (com.tencent.mm.plugin.sns.lucky.a.g.cmw()) {
                if (af.cnK().a(j, can.wPm, can.pcX, str)) {
                    AppMethodBeat.o(36316);
                    return false;
                }
                can can2 = cao.wZO;
                j jVar = new j();
                jVar.field_snsID = j;
                jVar.field_parentID = j2;
                jVar.field_createTime = can.pcX;
                jVar.field_talker = can.wPm;
                jVar.field_type = can.jCt;
                jVar.field_curActionBuf = can.toByteArray();
                jVar.field_refActionBuf = can2.toByteArray();
                jVar.field_clientId = str;
                jVar.field_commentSvrID = (long) can.wZG;
                ab.i("MicroMsg.NetSceneNewSyncAlbum", "curAction.HBBuffer " + can.wZK);
                aj.c(j, cao);
                Zz();
                af.cnK().b((com.tencent.mm.sdk.e.c) jVar);
                AppMethodBeat.o(36316);
                return true;
            }
            ab.i("MicroMsg.NetSceneNewSyncAlbum", "passed because close lucky");
            AppMethodBeat.o(36316);
            return false;
        } catch (Exception e) {
            ab.e("MicroMsg.NetSceneNewSyncAlbum", "error processHbAction " + e.getMessage());
            ab.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            AppMethodBeat.o(36316);
            return false;
        }
    }

    private static boolean b(cao cao, can can, long j, long j2, String str) {
        AppMethodBeat.i(36317);
        try {
            ab.i("MicroMsg.NetSceneNewSyncAlbum", "processGrabHbAction clientId " + str + " snsId: " + j + " " + can.wZJ + " " + can.wZG);
            if (af.cnK().a(j, can.wPm, can.pcX, str)) {
                AppMethodBeat.o(36317);
                return false;
            }
            can can2 = cao.wZO;
            j jVar = new j();
            jVar.field_snsID = j;
            jVar.field_parentID = j2;
            jVar.field_createTime = can.pcX;
            jVar.field_talker = can.wPm;
            jVar.field_type = can.jCt;
            jVar.field_curActionBuf = can.toByteArray();
            jVar.field_refActionBuf = can2.toByteArray();
            jVar.field_clientId = str;
            jVar.field_commentSvrID = (long) can.wZG;
            ata ata = new ata();
            ab.i("MicroMsg.NetSceneNewSyncAlbum", "curAction.HBBuffer " + can.wZK);
            ata.parseFrom(com.tencent.mm.platformtools.aa.a(can.wZK));
            ab.i("MicroMsg.NetSceneNewSyncAlbum", "hbbuffer  " + ata.cSh);
            af.cnK().b((com.tencent.mm.sdk.e.c) jVar);
            AppMethodBeat.o(36317);
            return true;
        } catch (Exception e) {
            ab.e("MicroMsg.NetSceneNewSyncAlbum", "error processHbAction " + e.getMessage());
            ab.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            AppMethodBeat.o(36317);
            return false;
        }
    }

    public static void cna() {
        AppMethodBeat.i(36318);
        for (ar arVar : qJB) {
            if (arVar != null) {
                arVar.ZA();
            }
        }
        AppMethodBeat.o(36318);
    }

    private static void Zz() {
        AppMethodBeat.i(36319);
        for (ar arVar : qJB) {
            if (arVar != null) {
                arVar.Zz();
            }
        }
        AppMethodBeat.o(36319);
    }

    public static void a(ar arVar) {
        AppMethodBeat.i(36320);
        if (!qJB.contains(arVar)) {
            qJB.add(arVar);
        }
        AppMethodBeat.o(36320);
    }

    public static void b(ar arVar) {
        AppMethodBeat.i(36321);
        qJB.remove(arVar);
        AppMethodBeat.o(36321);
    }
}
