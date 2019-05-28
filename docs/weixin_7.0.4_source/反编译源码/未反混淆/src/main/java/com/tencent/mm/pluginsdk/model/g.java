package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.l;
import com.tencent.mm.af.o;
import com.tencent.mm.af.p;
import com.tencent.mm.aj.a.e;
import com.tencent.mm.aj.f;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvoice.b;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.fav.ui.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.protocal.protobuf.aap;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.aas;
import com.tencent.mm.protocal.protobuf.aat;
import com.tencent.mm.protocal.protobuf.aau;
import com.tencent.mm.protocal.protobuf.aay;
import com.tencent.mm.protocal.protobuf.abe;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.abl;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.abt;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.protocal.protobuf.cfh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.ttpic.wav.WavFileHeader;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;

public final class g {
    private static final SimpleDateFormat pJi = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    static {
        AppMethodBeat.i(27295);
        AppMethodBeat.o(27295);
    }

    public static boolean a(Context context, cl clVar, String str, List<bi> list, boolean z) {
        AppMethodBeat.i(27277);
        if (list == null || list.isEmpty() || context == null) {
            ab.w("MicroMsg.GetFavRecordDataSource", "fill favorite event fail, event or msgs is null");
            clVar.cvA.cvG = R.string.boh;
            AppMethodBeat.o(27277);
            return false;
        }
        bi biVar;
        for (bi biVar2 : list) {
            if (bh.o(biVar2)) {
                switch (biVar2.getType() & CdnLogic.kBizGeneric) {
                    case 1:
                        biVar2.setContent(context.getString(R.string.tx));
                        break;
                    case 3:
                        biVar2.setContent(context.getString(R.string.sn));
                        biVar2.setType(1);
                        break;
                    case 43:
                        biVar2.setContent(context.getString(R.string.ud));
                        biVar2.setType(1);
                        break;
                    case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                        biVar2.setContent(context.getString(R.string.u7));
                        biVar2.setType(1);
                        break;
                    default:
                        break;
                }
            }
        }
        boolean kq = f.kq(str);
        boolean z2;
        if (list.size() != 1 || z) {
            clVar.cvA.cvC = new abf();
            clVar.cvA.cvD = new abt();
            if (context != null) {
                if (kq) {
                    if (e.rs(e.fD(((bi) list.get(0)).field_bizChatId))) {
                        clVar.cvA.cvC.alB(context.getString(R.string.dja));
                    } else {
                        if (e.rv(str) != null) {
                            clVar.cvA.cvC.alB(context.getString(R.string.bqi, new Object[]{r1.field_userName, e.rt(r0)}));
                        }
                    }
                } else if (t.kH(str)) {
                    clVar.cvA.cvC.alB(context.getString(R.string.dja));
                } else {
                    if (bo.nullAsNil(r.YB()).equals(bo.nullAsNil(s.mI(str)))) {
                        clVar.cvA.cvC.alB(context.getString(R.string.bqj, new Object[]{r0}));
                    } else {
                        clVar.cvA.cvC.alB(context.getString(R.string.bqi, new Object[]{r.YB(), s.mI(str)}));
                    }
                }
                ab.d("MicroMsg.GetFavRecordDataSource", "title %s", clVar.cvA.cvC.title);
            }
            clVar.cvA.cvC.a(aiz(str));
            clVar.cvA.type = 14;
            z2 = true;
            int i = 0;
            for (bi biVar22 : list) {
                if (b(context, clVar, biVar22)) {
                    i = 1;
                } else {
                    z2 = false;
                }
            }
            if (i != 0 && clVar.cvA.cvG > 0) {
                clVar.cvA.cvG = 0;
            }
            AppMethodBeat.o(27277);
            return z2;
        }
        biVar22 = (bi) list.get(0);
        if (biVar22.drC()) {
            o b = ((a) com.tencent.mm.kernel.g.K(a.class)).b(biVar22.field_msgId, biVar22.field_content);
            if (b.fjr == null || b.fjr.size() != 1) {
                clVar.cvA.cvC = new abf();
                clVar.cvA.cvD = new abt();
                clVar.cvA.cvC.a(aiz(str));
                clVar.cvA.type = 14;
                z2 = b(context, clVar, biVar22);
                AppMethodBeat.o(27277);
                return z2;
            }
            z2 = e.d(clVar, biVar22);
            AppMethodBeat.o(27277);
            return z2;
        }
        z2 = e.d(clVar, biVar22);
        AppMethodBeat.o(27277);
        return z2;
    }

    private static boolean b(Context context, cl clVar, bi biVar) {
        boolean z = false;
        AppMethodBeat.i(27278);
        if (clVar == null || biVar == null) {
            ab.w("MicroMsg.GetFavRecordDataSource", "fill favorite event fail, event or msg is null");
            if (clVar != null) {
                clVar.cvA.cvG = R.string.boh;
            }
            AppMethodBeat.o(27278);
        } else {
            bi ar = bi.ar(biVar);
            if (ar.isText()) {
                z = e(clVar, ar);
            } else if (ar.drD()) {
                z = k(clVar, ar);
            } else if (ar.bAC()) {
                z = a(clVar, ar);
            } else if (ar.drE()) {
                z = j(clVar, ar);
            } else if (ar.bws()) {
                z = b(clVar, ar);
            } else if (ar.bwt()) {
                z = b(clVar, ar);
            } else if (ar.drC()) {
                z = c(clVar, ar);
            } else if (ar.dtw()) {
                z = c(context, clVar, ar);
            } else if (!ar.bAA() || ar.dty()) {
                clVar.cvA.cvG = R.string.bop;
            } else {
                z = a(context, clVar, ar);
            }
            c.a(ar, clVar, z);
            AppMethodBeat.o(27278);
        }
        return z;
    }

    private static abl aiz(String str) {
        AppMethodBeat.i(27279);
        abl abl = new abl();
        abl.alD(str);
        abl.LN(1);
        abl.ml(bo.anU());
        abl.alF("");
        AppMethodBeat.o(27279);
        return abl;
    }

    private static aat ag(bi biVar) {
        AppMethodBeat.i(27280);
        aat aat = new aat();
        if (biVar == null) {
            AppMethodBeat.o(27280);
            return aat;
        }
        String substring;
        if (biVar.field_isSend == 0) {
            aat.alm(biVar.field_talker);
            aat.aln(r.Yz());
            if (t.kH(biVar.field_talker)) {
                if (biVar.field_content != null) {
                    substring = biVar.field_content.substring(0, Math.max(0, biVar.field_content.indexOf(58)));
                } else {
                    substring = "";
                }
                aat.alp(substring);
                if (!(bo.isNullOrNil(aat.whU) || biVar.drD())) {
                    biVar.setContent(biVar.field_content.substring(aat.whU.length() + 1));
                    if (biVar.field_content.length() > 0 && 10 == biVar.field_content.charAt(0)) {
                        biVar.setContent(biVar.field_content.substring(1));
                    }
                    if (biVar.dtF()) {
                        biVar.jx(biVar.field_transContent.substring(aat.whU.length() + 1));
                        if (biVar.field_transContent.length() > 0 && 10 == biVar.field_transContent.charAt(0)) {
                            biVar.jx(biVar.field_transContent.substring(1));
                        }
                    }
                }
            }
        } else {
            aat.alm(r.Yz());
            aat.aln(biVar.field_talker);
            if (t.kH(biVar.field_talker)) {
                aat.alp(aat.cEV);
            }
        }
        if (f.kq(biVar.field_talker)) {
            substring = biVar.field_bizChatUserId;
            if (substring == null) {
                substring = bf.oE(biVar.dqJ).userId;
            }
            aat.alp(substring);
        }
        aat.LI(1);
        aat.mi(biVar.field_createTime);
        aat.alq(biVar.field_msgSvrId);
        if (biVar.field_msgSvrId > 0) {
            aat.alo(biVar.field_msgSvrId);
        }
        AppMethodBeat.o(27280);
        return aat;
    }

    private static String b(aat aat) {
        AppMethodBeat.i(27282);
        String format = pJi.format(new Date(aat.createTime));
        AppMethodBeat.o(27282);
        return format;
    }

    private static boolean e(cl clVar, bi biVar) {
        String str;
        AppMethodBeat.i(27284);
        aas aas = new aas();
        aas.c(ag(biVar));
        aar aar = new aar();
        aar.akZ(ah(biVar));
        aar.LE(1);
        if (biVar.dtV()) {
            str = ah.getContext().getString(R.string.dtl, new Object[]{"@"}) + 10;
        } else {
            str = "";
        }
        if (biVar.dtM()) {
            aar.akI(str + biVar.field_content + "\n\n" + biVar.field_transContent);
        } else {
            aar.akI(str + biVar.field_content);
        }
        aar.oY(true);
        aar.oX(true);
        aar.a(aas);
        aar.alc(a(aas.whw));
        aar.ald(b(aas.whw));
        if (ad.aox(aas.whw.whU)) {
            str = com.tencent.mm.openim.room.a.a.A(((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(aas.whw.whU));
            if (!bo.isNullOrNil(str)) {
                aar.all(str);
            }
        }
        clVar.cvA.cvC.wiv.add(aar);
        abt abt = clVar.cvA.cvD;
        abt.wiK++;
        AppMethodBeat.o(27284);
        return true;
    }

    private static boolean j(cl clVar, bi biVar) {
        AppMethodBeat.i(27285);
        com.tencent.mm.at.e eVar = null;
        if (biVar.field_msgId > 0) {
            eVar = com.tencent.mm.at.o.ahl().fJ((long) ((int) biVar.field_msgId));
        }
        if ((eVar == null || eVar.fDy <= 0) && biVar.field_msgSvrId > 0) {
            eVar = com.tencent.mm.at.o.ahl().fI(biVar.field_msgSvrId);
        }
        if (eVar == null) {
            ab.w("MicroMsg.GetFavRecordDataSource", "getImgDataPath: try get imgInfo fail");
            clVar.cvA.cvG = R.string.bon;
            AppMethodBeat.o(27285);
            return false;
        }
        aas aas = new aas();
        aas.c(ag(biVar));
        aar aar = new aar();
        aar.akZ(ah(biVar));
        aar.LE(2);
        aar.akV(com.tencent.mm.at.o.ahl().q(com.tencent.mm.at.f.c(eVar), "", ""));
        if (eVar.agQ()) {
            eVar = com.tencent.mm.at.o.ahl().ly(eVar.fDJ);
            if (eVar.frO > eVar.offset) {
                aar.akV(com.tencent.mm.at.o.ahl().q("SERVERID://" + biVar.field_msgSvrId, "", ""));
            }
        }
        aar.akW(com.tencent.mm.at.o.ahl().I(biVar.field_imgPath, true));
        aar.a(aas);
        aar.alc(a(aas.whw));
        aar.ald(b(aas.whw));
        aar.mh(biVar.field_msgId);
        if (ad.aox(aas.whw.whU)) {
            String A = com.tencent.mm.openim.room.a.a.A(((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(aas.whw.whU));
            if (!bo.isNullOrNil(A)) {
                aar.all(A);
            }
        }
        clVar.cvA.cvC.wiv.add(aar);
        abt abt = clVar.cvA.cvD;
        abt.wiL++;
        AppMethodBeat.o(27285);
        return true;
    }

    private static boolean a(cl clVar, bi biVar) {
        AppMethodBeat.i(27286);
        aas aas = new aas();
        aas.c(ag(biVar));
        Map z = br.z(biVar.field_content, "msg");
        if (z != null) {
            try {
                aay aay = new aay();
                aay.alu((String) z.get(".msg.location.$label"));
                aay.E(Double.parseDouble((String) z.get(".msg.location.$x")));
                aay.D(Double.parseDouble((String) z.get(".msg.location.$y")));
                aay.LJ(Integer.valueOf((String) z.get(".msg.location.$scale")).intValue());
                aay.alv((String) z.get(".msg.location.$poiname"));
                aas.a(aay);
                aar aar = new aar();
                aar.akZ(ah(biVar));
                aar.LE(6);
                aar.oY(true);
                aar.oX(true);
                aar.a(aas);
                aar.alc(a(aas.whw));
                aar.ald(b(aas.whw));
                if (ad.aox(aas.whw.whU)) {
                    String A = com.tencent.mm.openim.room.a.a.A(((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(aas.whw.whU));
                    if (!bo.isNullOrNil(A)) {
                        aar.all(A);
                    }
                }
                clVar.cvA.cvC.wiv.add(aar);
                abt abt = clVar.cvA.cvD;
                abt.wiP++;
                AppMethodBeat.o(27286);
                return true;
            } catch (Exception e) {
                ab.e("MicroMsg.GetFavRecordDataSource", "parse failed, %s", e.getStackTrace().toString());
            }
        }
        clVar.cvA.cvG = R.string.bor;
        AppMethodBeat.o(27286);
        return false;
    }

    private static boolean k(cl clVar, bi biVar) {
        AppMethodBeat.i(27287);
        aas aas = new aas();
        aas.c(ag(biVar));
        aar aar = new aar();
        aar.akZ(ah(biVar));
        aar.LE(3);
        if (t.nv(biVar.field_talker)) {
            aar.akV(aiy(biVar.field_imgPath));
        } else {
            aar.akV(q.getFullPath(biVar.field_imgPath));
        }
        aar.oY(true);
        b uN = q.uN(biVar.field_imgPath);
        if (uN == null) {
            AppMethodBeat.o(27287);
            return false;
        }
        aar.akR(e.Kp(uN.getFormat()));
        aar.LD((int) new n(biVar.field_content).time);
        aar.a(aas);
        aar.alc(a(aas.whw));
        aar.ald(b(aas.whw));
        if (ad.aox(aas.whw.whU)) {
            String A = com.tencent.mm.openim.room.a.a.A(((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(aas.whw.whU));
            if (!bo.isNullOrNil(A)) {
                aar.all(A);
            }
        }
        clVar.cvA.cvC.wiv.add(aar);
        abt abt = clVar.cvA.cvD;
        abt.wiM++;
        AppMethodBeat.o(27287);
        return true;
    }

    private static String aiy(String str) {
        AppMethodBeat.i(27288);
        aw.ZK();
        String b = com.tencent.mm.sdk.platformtools.j.b(com.tencent.mm.model.c.XZ(), "recbiz_", str, ".rec", 2);
        if (bo.isNullOrNil(b)) {
            AppMethodBeat.o(27288);
            return null;
        } else if (new File(b).exists()) {
            AppMethodBeat.o(27288);
            return b;
        } else {
            AppMethodBeat.o(27288);
            return b;
        }
    }

    private static boolean b(cl clVar, bi biVar) {
        AppMethodBeat.i(27289);
        aas aas = new aas();
        aas.c(ag(biVar));
        aar aar = new aar();
        aar.akZ(ah(biVar));
        com.tencent.mm.modelvideo.o.all();
        aar.akV(com.tencent.mm.modelvideo.t.uh(biVar.field_imgPath));
        com.tencent.mm.modelvideo.o.all();
        aar.akW(com.tencent.mm.modelvideo.t.ui(biVar.field_imgPath));
        aar.akR(com.tencent.mm.a.e.cv(aar.wgx));
        if (biVar.bwt()) {
            aar.LE(15);
        } else {
            aar.LE(4);
        }
        com.tencent.mm.modelvideo.s ut = u.ut(biVar.field_imgPath);
        if (ut == null) {
            ab.i("MicroMsg.GetFavRecordDataSource", "video info null");
            clVar.cvA.cvG = R.string.bog;
            AppMethodBeat.o(27289);
            return false;
        }
        ab.i("MicroMsg.GetFavRecordDataSource", "video length is %d", Integer.valueOf(ut.frO));
        if (ut.frO > com.tencent.mm.m.b.Nc()) {
            clVar.cvA.cvG = R.string.bs4;
            AppMethodBeat.o(27289);
            return false;
        } else if (biVar.bwt() && u.uv(ut.getFileName())) {
            clVar.cvA.cvG = R.string.bog;
            AppMethodBeat.o(27289);
            return false;
        } else {
            aar.LD(ut.fXd);
            aar.a(aas);
            aar.alc(a(aas.whw));
            aar.ald(b(aas.whw));
            if (ad.aox(aas.whw.whU)) {
                String A = com.tencent.mm.openim.room.a.a.A(((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(aas.whw.whU));
                if (!bo.isNullOrNil(A)) {
                    aar.all(A);
                }
            }
            aar.mh(biVar.field_msgId);
            aar.mf((long) ut.frO);
            clVar.cvA.cvC.wiv.add(aar);
            abt abt = clVar.cvA.cvD;
            abt.wiN++;
            com.tencent.mm.modelvideo.s ut2 = u.ut(biVar.field_imgPath);
            aar.alf(ut2.cMn);
            cfh cfh = ut2.fXm;
            if (!(cfh == null || bo.isNullOrNil(cfh.fiM))) {
                aau aau = new aau();
                aau.fiG = cfh.fiG;
                aau.wid = cfh.wid;
                aau.fiJ = cfh.fiJ;
                aau.fiK = cfh.fiK;
                aau.fiI = cfh.fiI;
                aau.fiL = cfh.fiL;
                aau.fiM = cfh.fiM;
                aau.fiN = cfh.fiN;
                aar.a(aau);
            }
            AppMethodBeat.o(27289);
            return true;
        }
    }

    private static boolean c(Context context, cl clVar, bi biVar) {
        Object obj;
        AppMethodBeat.i(27290);
        aw.ZK();
        bi.a Rn = com.tencent.mm.model.c.XO().Rn(biVar.field_content);
        aas aas = new aas();
        aas.c(ag(biVar));
        String A;
        if (Rn != null && t.kv(Rn.ufB)) {
            aar aar = new aar();
            aar.akZ(ah(biVar));
            aar.LE(16);
            aar.akI(biVar.field_content);
            aar.oY(true);
            aar.oX(true);
            aar.a(aas);
            aar.alc(a(aas.whw));
            aar.ald(b(aas.whw));
            if (ad.aox(aas.whw.whU)) {
                A = com.tencent.mm.openim.room.a.a.A(((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(aas.whw.whU));
                if (!bo.isNullOrNil(A)) {
                    aar.all(A);
                }
                obj = aar;
            } else {
                aar obj2 = aar;
            }
        } else if (Rn == null || !ad.aox(Rn.svN)) {
            obj2 = a(biVar, context.getString(R.string.qy), aas);
        } else {
            if (TextUtils.isEmpty(((com.tencent.mm.openim.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.openim.a.b.class)).a(Rn.xZm, "openim_card_type_name", com.tencent.mm.openim.a.b.a.TYPE_WORDING))) {
                A = context.getResources().getString(R.string.qy);
            } else {
                A = String.format("[%s]", new Object[]{((com.tencent.mm.openim.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.openim.a.b.class)).a(Rn.xZm, "openim_card_type_name", com.tencent.mm.openim.a.b.a.TYPE_WORDING)});
            }
            obj2 = a(biVar, A, aas);
        }
        clVar.cvA.cvC.wiv.add(obj2);
        abt abt = clVar.cvA.cvD;
        abt.wiX++;
        AppMethodBeat.o(27290);
        return true;
    }

    private static aar a(bi biVar, com.tencent.mm.af.j.b bVar, int i) {
        AppMethodBeat.i(27291);
        aar aar = new aar();
        aar.akZ(ah(biVar));
        aar.akO(bVar.fgM);
        aar.akP(bVar.fgN);
        aar.akN(bVar.url);
        aar.oX(true);
        File file = new File(bo.bc(com.tencent.mm.at.o.ahl().I(biVar.field_imgPath, true), ""));
        if (file.exists()) {
            aar.akW(file.getAbsolutePath());
        } else {
            aar.oY(true);
        }
        aar.akH(bVar.title);
        aar.akI(bVar.description);
        aar.LE(i);
        aar.alg(bVar.canvasPageXml);
        AppMethodBeat.o(27291);
        return aar;
    }

    private static aar a(bi biVar, String str, aas aas) {
        AppMethodBeat.i(27292);
        aar aar = new aar();
        aar.akZ(ah(biVar));
        aar.LE(1);
        aar.akI(str);
        aar.oY(true);
        aar.oX(true);
        aar.a(aas);
        aar.alc(a(aas.whw));
        aar.ald(b(aas.whw));
        if (ad.aox(aas.whw.whU)) {
            String A = com.tencent.mm.openim.room.a.a.A(((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(aas.whw.whU));
            if (!bo.isNullOrNil(A)) {
                aar.all(A);
            }
        }
        AppMethodBeat.o(27292);
        return aar;
    }

    private static boolean a(Context context, cl clVar, bi biVar) {
        AppMethodBeat.i(27293);
        aas aas = new aas();
        aas.c(ag(biVar));
        String str = biVar.field_content;
        if (str == null) {
            clVar.cvA.cvG = R.string.bor;
            AppMethodBeat.o(27293);
            return false;
        }
        com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(str);
        if (me == null) {
            clVar.cvA.cvG = R.string.bor;
            AppMethodBeat.o(27293);
            return false;
        }
        aas.whw.alr(me.appId);
        aas.whw.alt(me.cMg);
        com.tencent.mm.pluginsdk.model.app.f bT = com.tencent.mm.pluginsdk.model.app.g.bT(me.appId, true);
        if (bT != null) {
            bT.xy();
        }
        aar aar;
        abt abt;
        com.tencent.mm.pluginsdk.model.app.b aiE;
        abe abe;
        switch (me.type) {
            case 1:
                aar = new aar();
                aar.akZ(ah(biVar));
                aar.LE(1);
                aar.akI(me.title);
                aar.oY(true);
                aar.oX(true);
                aar.a(aas);
                aar.alc(a(aas.whw));
                aar.ald(b(aas.whw));
                if (ad.aox(aas.whw.whU)) {
                    str = com.tencent.mm.openim.room.a.a.A(((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(aas.whw.whU));
                    if (!bo.isNullOrNil(str)) {
                        aar.all(str);
                    }
                }
                clVar.cvA.cvC.wiv.add(aar);
                abt = clVar.cvA.cvD;
                abt.wiK++;
                AppMethodBeat.o(27293);
                return true;
            case 2:
                aw.ZK();
                if (com.tencent.mm.model.c.isSDCardAvailable()) {
                    aiE = am.aUq().aiE(me.csD);
                    aar = new aar();
                    aar.akZ(ah(biVar));
                    if (aiE != null) {
                        aar.akV(aiE.field_fileFullPath);
                    }
                    str = com.tencent.mm.at.o.ahl().I(biVar.field_imgPath, true);
                    if (com.tencent.mm.a.e.ct(str)) {
                        aar.akW(str);
                    }
                    aar.LE(2);
                    aar.akH(me.title);
                    aar.akI(me.description);
                    aar.a(aas);
                    aar.alc(a(aas.whw));
                    aar.ald(b(aas.whw));
                    aar.mh(biVar.field_msgId);
                    if (ad.aox(aas.whw.whU)) {
                        str = com.tencent.mm.openim.room.a.a.A(((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(aas.whw.whU));
                        if (!bo.isNullOrNil(str)) {
                            aar.all(str);
                        }
                    }
                    clVar.cvA.cvC.wiv.add(aar);
                    abt = clVar.cvA.cvD;
                    abt.wiL++;
                    AppMethodBeat.o(27293);
                    return true;
                }
                clVar.cvA.cvG = R.string.box;
                AppMethodBeat.o(27293);
                return false;
            case 3:
                aar = a(biVar, me, 7);
                aar.a(aas);
                aar.alc(a(aas.whw));
                aar.ald(b(aas.whw));
                if (ad.aox(aas.whw.whU)) {
                    str = com.tencent.mm.openim.room.a.a.A(((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(aas.whw.whU));
                    if (!bo.isNullOrNil(str)) {
                        aar.all(str);
                    }
                }
                clVar.cvA.cvC.wiv.add(aar);
                abt = clVar.cvA.cvD;
                abt.wiQ++;
                AppMethodBeat.o(27293);
                return true;
            case 4:
                aar = a(biVar, me, 4);
                aar.a(aas);
                aar.alc(a(aas.whw));
                aar.ald(b(aas.whw));
                aar.mh(biVar.field_msgId);
                if (ad.aox(aas.whw.whU)) {
                    str = com.tencent.mm.openim.room.a.a.A(((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(aas.whw.whU));
                    if (!bo.isNullOrNil(str)) {
                        aar.all(str);
                    }
                }
                clVar.cvA.cvC.wiv.add(aar);
                abt = clVar.cvA.cvD;
                abt.wiN++;
                AppMethodBeat.o(27293);
                return true;
            case 5:
                if (me.url == null || me.url.equals("")) {
                    clVar.cvA.cvG = R.string.bol;
                    AppMethodBeat.o(27293);
                    return false;
                }
                aas.whw.als(me.url);
                aar = a(biVar, me, 5);
                aar.a(aas);
                aar.alc(a(aas.whw));
                aar.ald(b(aas.whw));
                if (ad.aox(aas.whw.whU)) {
                    str = com.tencent.mm.openim.room.a.a.A(((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(aas.whw.whU));
                    if (!bo.isNullOrNil(str)) {
                        aar.all(str);
                    }
                }
                abu abu = new abu();
                if (!bo.isNullOrNil(me.title)) {
                    abu.alQ(me.title);
                }
                if (!bo.isNullOrNil(me.description)) {
                    abu.alR(me.description);
                }
                if (!bo.isNullOrNil(me.thumburl)) {
                    abu.alT(me.thumburl);
                }
                if (!bo.isNullOrNil(me.canvasPageXml)) {
                    abu.alU(me.canvasPageXml);
                }
                if (abu.computeSize() > 0) {
                    abu.LO(1);
                    aas.a(abu);
                }
                clVar.cvA.cvC.wiv.add(aar);
                abt = clVar.cvA.cvD;
                abt.wiO++;
                AppMethodBeat.o(27293);
                return true;
            case 6:
                aw.ZK();
                if (com.tencent.mm.model.c.isSDCardAvailable()) {
                    aiE = am.aUq().aiE(me.csD);
                    aar = new aar();
                    if (aiE != null) {
                        aar.akV(aiE.field_fileFullPath);
                    }
                    aar.akZ(ah(biVar));
                    aar.LE(8);
                    aar.akR(me.fgp);
                    str = com.tencent.mm.at.o.ahl().I(biVar.field_imgPath, true);
                    if (bo.isNullOrNil(str)) {
                        aar.oY(true);
                    }
                    if (com.tencent.mm.a.e.ct(str)) {
                        aar.akW(str);
                    }
                    aar.akH(me.title);
                    aar.akI(me.description);
                    aar.a(aas);
                    aar.alc(a(aas.whw));
                    aar.ald(b(aas.whw));
                    aar.mh(biVar.field_msgId);
                    if (ad.aox(aas.whw.whU)) {
                        str = com.tencent.mm.openim.room.a.a.A(((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(aas.whw.whU));
                        if (!bo.isNullOrNil(str)) {
                            aar.all(str);
                        }
                    }
                    clVar.cvA.cvC.wiv.add(aar);
                    abt = clVar.cvA.cvD;
                    abt.fileCount++;
                    AppMethodBeat.o(27293);
                    return true;
                }
                clVar.cvA.cvG = R.string.box;
                AppMethodBeat.o(27293);
                return false;
            case 7:
                if (me.csD == null || me.csD.length() == 0) {
                    clVar.cvA.cvG = R.string.boi;
                } else {
                    aw.ZK();
                    if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                        clVar.cvA.cvG = R.string.box;
                        AppMethodBeat.o(27293);
                        return false;
                    }
                }
                clVar.cvA.cvG = R.string.bop;
                AppMethodBeat.o(27293);
                return false;
            case 10:
                abe = new abe();
                abe.alw(me.title);
                abe.alx(me.description);
                abe.LK(me.fgP);
                abe.alz(me.fgQ);
                abe.aly(me.thumburl);
                aas.a(abe);
                aar = new aar();
                aar.akZ(ah(biVar));
                aar.LE(10);
                aar.oY(true);
                aar.oX(true);
                aar.a(aas);
                aar.alc(a(aas.whw));
                aar.ald(b(aas.whw));
                if (ad.aox(aas.whw.whU)) {
                    str = com.tencent.mm.openim.room.a.a.A(((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(aas.whw.whU));
                    if (!bo.isNullOrNil(str)) {
                        aar.all(str);
                    }
                }
                clVar.cvA.cvC.wiv.add(aar);
                abt = clVar.cvA.cvD;
                abt.wiS++;
                AppMethodBeat.o(27293);
                return true;
            case 13:
                abe = new abe();
                abe.alw(me.title);
                abe.alx(me.description);
                abe.LK(me.fgV);
                abe.alz(me.fgW);
                abe.aly(me.thumburl);
                aas.a(abe);
                aar = new aar();
                aar.akZ(ah(biVar));
                aar.LE(11);
                aar.oY(true);
                aar.oX(true);
                aar.a(aas);
                aar.alc(a(aas.whw));
                aar.ald(b(aas.whw));
                if (ad.aox(aas.whw.whU)) {
                    str = com.tencent.mm.openim.room.a.a.A(((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(aas.whw.whU));
                    if (!bo.isNullOrNil(str)) {
                        aar.all(str);
                    }
                }
                clVar.cvA.cvC.wiv.add(aar);
                abt = clVar.cvA.cvD;
                abt.wiT++;
                AppMethodBeat.o(27293);
                return true;
            case 19:
                boolean z = me.fgU != null && me.fgU.contains("<recordxml>");
                if (!z) {
                    aar aar2 = new aar();
                    aar2.akZ(ah(biVar));
                    aar2.LE(17);
                    aar2.oY(true);
                    aar2.akH(me.title);
                    aar2.alh(me.fgU);
                    String str2 = me.description;
                    nt ntVar = new nt();
                    ntVar.cJY.type = 0;
                    ntVar.cJY.cKa = me.fgU;
                    com.tencent.mm.sdk.b.a.xxA.m(ntVar);
                    com.tencent.mm.protocal.b.a.c cVar = ntVar.cJZ.cKi;
                    if (cVar != null) {
                        Iterator it = cVar.fjr.iterator();
                        while (it.hasNext()) {
                            if (!bo.isNullOrNil(((aar) it.next()).whr)) {
                                clVar.cvA.cvG = R.string.bop;
                                AppMethodBeat.o(27293);
                                return false;
                            }
                        }
                    }
                    if (cVar != null) {
                        str = cVar.desc;
                    } else {
                        str = str2;
                    }
                    aar2.akI(str);
                    aar2.a(aas);
                    aar2.alc(a(aas.whw));
                    aar2.ald(b(aas.whw));
                    aar2.mh(biVar.field_msgId);
                    if (ad.aox(aas.whw.whU)) {
                        str = com.tencent.mm.openim.room.a.a.A(((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(aas.whw.whU));
                        if (!bo.isNullOrNil(str)) {
                            aar2.all(str);
                        }
                    }
                    clVar.cvA.cvC.wiv.add(aar2);
                    AppMethodBeat.o(27293);
                    return true;
                }
                break;
            case 20:
                abo abo = new abo();
                abo.alM(me.title);
                abo.alN(me.description);
                abo.alP(me.fgT);
                abo.alO(me.thumburl);
                aas.a(abo);
                aar = new aar();
                aar.akZ(ah(biVar));
                aar.LE(14);
                aar.oY(true);
                aar.oX(true);
                aar.a(aas);
                aar.alc(a(aas.whw));
                aar.ald(b(aas.whw));
                if (ad.aox(aas.whw.whU)) {
                    str = com.tencent.mm.openim.room.a.a.A(((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(aas.whw.whU));
                    if (!bo.isNullOrNil(str)) {
                        aar.all(str);
                    }
                }
                clVar.cvA.cvC.wiv.add(aar);
                abt = clVar.cvA.cvD;
                abt.wiW++;
                AppMethodBeat.o(27293);
                return true;
            case 33:
            case 36:
                aar = new aar();
                aar.akZ(ah(biVar));
                aar.akH(me.title);
                aar.akI(me.description);
                aar.LE(19);
                str = com.tencent.mm.at.o.ahl().I(biVar.field_imgPath, true);
                if (bo.isNullOrNil(str)) {
                    aar.oY(true);
                }
                if (com.tencent.mm.a.e.ct(str)) {
                    aar.akW(str);
                }
                aap aap = new aap();
                if (!bo.isNullOrNil(me.fiP)) {
                    aap.username = me.fiP;
                }
                if (!bo.isNullOrNil(me.fiQ)) {
                    aap.appId = me.fiQ;
                }
                if (!bo.isNullOrNil(me.fjb)) {
                    aap.iconUrl = me.fjb;
                }
                aap.type = me.fiR;
                aap.cBc = me.fiT;
                aap.csu = me.fiO;
                aap.wfO = me.cMh;
                aas.a(aap);
                aar.a(aas);
                aar.alc(a(aas.whw));
                aar.ald(b(aas.whw));
                aar.mh(biVar.field_msgId);
                if (ad.aox(aas.whw.whU)) {
                    str = com.tencent.mm.openim.room.a.a.A(((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(aas.whw.whU));
                    if (!bo.isNullOrNil(str)) {
                        aar.all(str);
                    }
                }
                clVar.cvA.cvC.wiv.add(aar);
                AppMethodBeat.o(27293);
                return true;
            case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                str = me.p(context, true);
                if (bo.isNullOrNil(str)) {
                    clVar.cvA.cvG = R.string.bop;
                    AppMethodBeat.o(27293);
                    return false;
                }
                clVar.cvA.cvC.wiv.add(a(biVar, str + me.title, aas));
                AppMethodBeat.o(27293);
                return true;
            case 46:
                clVar.cvA.cvC.wiv.add(a(biVar, context.getString(R.string.s4), aas));
                AppMethodBeat.o(27293);
                return true;
        }
        clVar.cvA.cvG = R.string.bop;
        AppMethodBeat.o(27293);
        return false;
    }

    private static boolean c(cl clVar, bi biVar) {
        AppMethodBeat.i(27294);
        try {
            o b = ((a) com.tencent.mm.kernel.g.K(a.class)).b(biVar.field_msgId, biVar.field_content);
            LinkedList<p> linkedList = b.fjr;
            if (linkedList != null) {
                int i = 0;
                for (p pVar : linkedList) {
                    if (!l.mg(pVar.fjC)) {
                        aas aas = new aas();
                        aas.c(ag(biVar));
                        aas.whw.alt(b.cMg);
                        aas.whw.als(pVar.url);
                        aar aar = new aar();
                        aar.akH(pVar.title);
                        aar.akI(pVar.fjz);
                        aar.akZ(ah(biVar));
                        if (bo.isNullOrNil(pVar.fjx)) {
                            aar.oY(true);
                        } else {
                            aar.akW(q.v(pVar.fjx, biVar.getType(), i == 0 ? "@T" : "@S"));
                        }
                        aar.oX(true);
                        abu abu = new abu();
                        if (!bo.isNullOrNil(pVar.title)) {
                            abu.alQ(pVar.title);
                        }
                        if (!bo.isNullOrNil(pVar.fjz)) {
                            abu.alR(pVar.fjz);
                        }
                        if (!bo.isNullOrNil(pVar.fjx)) {
                            abu.alT(l.a(pVar));
                        }
                        if (abu.computeSize() > 0) {
                            abu.LO(1);
                            aas.a(abu);
                        }
                        aar.LE(5);
                        aar.a(aas);
                        aar.alc(a(aas.whw));
                        aar.ald(b(aas.whw));
                        if (ad.aox(aas.whw.whU)) {
                            String A = com.tencent.mm.openim.room.a.a.A(((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(aas.whw.whU));
                            if (!bo.isNullOrNil(A)) {
                                aar.all(A);
                            }
                        }
                        clVar.cvA.cvC.wiv.add(aar);
                        abt abt = clVar.cvA.cvD;
                        abt.wiO++;
                        i++;
                    }
                }
                if (i == 0) {
                    clVar.cvA.cvG = R.string.bop;
                    AppMethodBeat.o(27294);
                    return false;
                }
                AppMethodBeat.o(27294);
                return true;
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.GetFavRecordDataSource", e, "", new Object[0]);
            ab.e("MicroMsg.GetFavRecordDataSource", "retransmit app msg error : %s", e.getLocalizedMessage());
        }
        clVar.cvA.cvG = R.string.bor;
        AppMethodBeat.o(27294);
        return false;
    }

    private static String a(aat aat) {
        AppMethodBeat.i(27281);
        String str = aat.whU;
        if (bo.isNullOrNil(str)) {
            str = aat.cEV;
        }
        if (e.rr(str)) {
            str = e.rt(str);
            AppMethodBeat.o(27281);
            return str;
        }
        str = s.mI(str);
        AppMethodBeat.o(27281);
        return str;
    }

    private static String ah(bi biVar) {
        AppMethodBeat.i(27283);
        String valueOf;
        if (biVar.field_isSend != 1) {
            valueOf = String.valueOf(biVar.field_msgSvrId);
            AppMethodBeat.o(27283);
            return valueOf;
        } else if (t.kH(biVar.field_talker) || biVar.field_talker.equals("filehelper")) {
            valueOf = String.format("%d", new Object[]{Long.valueOf(biVar.field_msgSvrId)});
            AppMethodBeat.o(27283);
            return valueOf;
        } else {
            valueOf = String.format("%s#%d", new Object[]{biVar.field_talker, Long.valueOf(biVar.field_msgSvrId)});
            AppMethodBeat.o(27283);
            return valueOf;
        }
    }
}
