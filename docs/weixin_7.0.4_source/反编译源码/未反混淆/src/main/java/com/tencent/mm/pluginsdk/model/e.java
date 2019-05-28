package com.tencent.mm.pluginsdk.model;

import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.af.l;
import com.tencent.mm.af.p;
import com.tencent.mm.ah.h;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.fav.ui.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
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
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.vfs.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class e {
    public static boolean a(cl clVar, Intent intent) {
        AppMethodBeat.i(27237);
        if (clVar == null) {
            ab.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null");
            AppMethodBeat.o(27237);
            return false;
        }
        double doubleExtra = intent.getDoubleExtra("kwebmap_slat", 0.0d);
        double doubleExtra2 = intent.getDoubleExtra("kwebmap_lng", 0.0d);
        int intExtra = intent.getIntExtra("kwebmap_scale", 0);
        String bc = bo.bc(intent.getStringExtra("Kwebmap_locaion"), "");
        String stringExtra = intent.getStringExtra("kPoiName");
        intent.getCharSequenceExtra("kRemark");
        intent.getStringArrayListExtra("kTags");
        aay aay = new aay();
        aay.alu(bc);
        aay.E(doubleExtra);
        aay.D(doubleExtra2);
        aay.LJ(intExtra);
        aay.alv(stringExtra);
        abf abf = new abf();
        abl abl = new abl();
        String Yz = r.Yz();
        abl.alD(Yz);
        abl.alE(Yz);
        abl.LN(6);
        abl.ml(bo.anU());
        abf.b(aay);
        abf.a(abl);
        clVar.cvA.cvC = abf;
        clVar.cvA.type = 6;
        AppMethodBeat.o(27237);
        return true;
    }

    public static boolean a(cl clVar, String str, String str2, String str3) {
        AppMethodBeat.i(27238);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
            clVar.cvA.cvG = R.string.boh;
            AppMethodBeat.o(27238);
            return false;
        }
        ab.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple file), title %s, desc %s, path %s, sourceType %d", str2, str3, str, Integer.valueOf(13));
        if (new b(str).length() > ((long) com.tencent.mm.m.b.Nc())) {
            clVar.cvA.cvG = R.string.bs4;
            AppMethodBeat.o(27238);
            return false;
        }
        abf abf = new abf();
        abl abl = new abl();
        aar aar = new aar();
        aar.akV(str);
        aar.LE(8);
        aar.akR(com.tencent.mm.vfs.e.cv(str));
        aar.oY(true);
        aar.akH(str2);
        aar.akI(str3);
        abl.alD(r.Yz());
        abl.alE(r.Yz());
        abl.LN(13);
        abl.ml(bo.anU());
        abf.a(abl);
        abf.wiv.add(aar);
        clVar.cvA.title = aar.title;
        clVar.cvA.desc = aar.title;
        clVar.cvA.cvC = abf;
        clVar.cvA.type = 8;
        AppMethodBeat.o(27238);
        return true;
    }

    public static boolean b(cl clVar, String str, int i) {
        AppMethodBeat.i(27239);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
            clVar.cvA.cvG = R.string.boh;
            AppMethodBeat.o(27239);
            return false;
        }
        ab.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple text), %s, sourceType %d", str, Integer.valueOf(i));
        abf abf = new abf();
        abl abl = new abl();
        abl.alD(r.Yz());
        abl.alE(r.Yz());
        abl.LN(i);
        abl.ml(bo.anU());
        abf.a(abl);
        clVar.cvA.desc = str;
        clVar.cvA.cvC = abf;
        clVar.cvA.type = 1;
        AppMethodBeat.o(27239);
        return true;
    }

    public static boolean a(cl clVar, int i, String str) {
        AppMethodBeat.i(27240);
        if (clVar == null || bo.isNullOrNil(str)) {
            ab.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
            if (clVar != null) {
                clVar.cvA.cvG = R.string.boh;
            }
            AppMethodBeat.o(27240);
            return false;
        }
        ab.i("MicroMsg.GetFavDataSource", "do fill event info(fav simple image), path %s sourceType %d", str, Integer.valueOf(i));
        abf abf = new abf();
        abl abl = new abl();
        aar aar = new aar();
        aar.LE(2);
        aar.akV(str);
        aar.akU(g.x((aar.toString() + 2 + System.currentTimeMillis()).getBytes()));
        gh ghVar = new gh();
        ghVar.cAH.type = 27;
        ghVar.cAH.cAJ = aar;
        a.xxA.m(ghVar);
        String str2 = ghVar.cAI.thumbPath;
        d.c(str, 150, 150, CompressFormat.JPEG, 90, str2);
        aar.akW(str2);
        abl.alD(r.Yz());
        abl.alE(r.Yz());
        abl.LN(i);
        abl.ml(bo.anU());
        abf.a(abl);
        abf.wiv.add(aar);
        clVar.cvA.title = aar.title;
        clVar.cvA.cvC = abf;
        clVar.cvA.type = 2;
        AppMethodBeat.o(27240);
        return true;
    }

    public static boolean a(cl clVar, long j) {
        AppMethodBeat.i(27241);
        boolean d = d(clVar, ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().jf(j));
        AppMethodBeat.o(27241);
        return d;
    }

    public static boolean d(cl clVar, bi biVar) {
        boolean z = false;
        AppMethodBeat.i(27242);
        if (clVar == null || biVar == null) {
            ab.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event or msg is null");
            if (clVar != null) {
                clVar.cvA.cvG = R.string.boh;
            }
            AppMethodBeat.o(27242);
        } else {
            bi ar = bi.ar(biVar);
            if (ar.isText()) {
                z = e(clVar, ar);
            } else if (ar.drD()) {
                z = g(clVar, ar);
            } else if (ar.bAC()) {
                z = a(clVar, ar);
            } else if (ar.drE()) {
                z = f(clVar, ar);
            } else if (ar.bws() || ar.bwt()) {
                z = h(clVar, ar);
            } else if (ar.drC()) {
                z = c(clVar, ar);
            } else if (ar.dtw() || !ar.bAA() || ar.dty()) {
                clVar.cvA.cvG = R.string.bop;
            } else {
                z = i(clVar, ar);
            }
            clVar.cvA.cvq = ar.field_content;
            if (z || clVar.cvA.cvG == 0) {
                c.a(ar, clVar, z);
            }
            AppMethodBeat.o(27242);
        }
        return z;
    }

    private static abl ak(bi biVar) {
        AppMethodBeat.i(27243);
        abl abl = new abl();
        if (biVar.field_isSend == 1) {
            abl.alD(r.Yz());
            abl.alE(biVar.field_talker);
            if (t.kH(biVar.field_talker)) {
                abl.alG(abl.cEV);
            }
        } else {
            abl.alD(biVar.field_talker);
            abl.alE(r.Yz());
            if (t.kH(biVar.field_talker)) {
                String substring;
                if (biVar.field_content != null) {
                    substring = biVar.field_content.substring(0, Math.max(0, biVar.field_content.indexOf(58)));
                } else {
                    substring = "";
                }
                abl.alG(substring);
                if (!(bo.isNullOrNil(abl.whU) || biVar.drD())) {
                    biVar.setContent(biVar.field_content.substring(abl.whU.length() + 1));
                    if (biVar.field_content.length() > 0 && 10 == biVar.field_content.charAt(0)) {
                        biVar.setContent(biVar.field_content.substring(1));
                    }
                    if (biVar.dtF()) {
                        biVar.jx(biVar.field_transContent.substring(abl.whU.length() + 1));
                        if (biVar.field_transContent.length() > 0 && 10 == biVar.field_transContent.charAt(0)) {
                            biVar.jx(biVar.field_transContent.substring(1));
                        }
                    }
                }
            }
        }
        abl.LN(1);
        abl.ml(biVar.field_createTime);
        abl.alH(biVar.field_msgSvrId);
        if (biVar.field_msgSvrId > 0) {
            abl.alF(biVar.field_msgSvrId);
        }
        AppMethodBeat.o(27243);
        return abl;
    }

    private static boolean e(cl clVar, bi biVar) {
        AppMethodBeat.i(27244);
        abf abf = new abf();
        abf.a(ak(biVar));
        clVar.cvA.cvC = abf;
        clVar.cvA.desc = biVar.field_content;
        clVar.cvA.type = 1;
        if (f.asg(clVar.cvA.desc) > com.tencent.mm.m.b.MY()) {
            clVar.cvA.cvG = R.string.bs2;
            AppMethodBeat.o(27244);
            return false;
        }
        AppMethodBeat.o(27244);
        return true;
    }

    private static boolean f(cl clVar, bi biVar) {
        AppMethodBeat.i(27245);
        com.tencent.mm.at.e eVar = null;
        if (biVar.field_msgId > 0) {
            eVar = o.ahl().fJ(biVar.field_msgId);
        }
        if ((eVar == null || eVar.fDy <= 0) && biVar.field_msgSvrId > 0) {
            eVar = o.ahl().fI(biVar.field_msgSvrId);
        }
        if (eVar == null) {
            ab.w("MicroMsg.GetFavDataSource", "getImgDataPath: try get imgInfo fail");
            clVar.cvA.cvG = R.string.bon;
            AppMethodBeat.o(27245);
            return false;
        }
        abf abf = new abf();
        abf.a(ak(biVar));
        aar aar = new aar();
        a(aar, biVar);
        aar.LE(2);
        aar.akV(o.ahl().q(com.tencent.mm.at.f.c(eVar), "", ""));
        if (eVar.agQ()) {
            eVar = o.ahl().ly(eVar.fDJ);
            if (eVar.frO > eVar.offset) {
                aar.akV(o.ahl().q("SERVERID://" + biVar.field_msgSvrId, "", ""));
            }
        }
        aar.akW(o.ahl().I(biVar.field_imgPath, true));
        LinkedList linkedList = new LinkedList();
        linkedList.add(aar);
        abf.aE(linkedList);
        clVar.cvA.cvC = abf;
        clVar.cvA.type = 2;
        AppMethodBeat.o(27245);
        return true;
    }

    private static boolean a(cl clVar, bi biVar) {
        AppMethodBeat.i(27246);
        abf abf = new abf();
        abf.a(ak(biVar));
        Map z = br.z(biVar.field_content, "msg");
        if (z != null) {
            try {
                aay aay = new aay();
                aay.alu((String) z.get(".msg.location.$label"));
                aay.E(Double.parseDouble((String) z.get(".msg.location.$x")));
                aay.D(Double.parseDouble((String) z.get(".msg.location.$y")));
                aay.LJ(Integer.valueOf((String) z.get(".msg.location.$scale")).intValue());
                aay.alv((String) z.get(".msg.location.$poiname"));
                abf.b(aay);
                clVar.cvA.type = 6;
                clVar.cvA.cvC = abf;
                AppMethodBeat.o(27246);
                return true;
            } catch (Exception e) {
                ab.e("MicroMsg.GetFavDataSource", "parse failed, %s", e.getStackTrace().toString());
            }
        }
        clVar.cvA.cvG = R.string.bor;
        AppMethodBeat.o(27246);
        return false;
    }

    private static boolean g(cl clVar, bi biVar) {
        AppMethodBeat.i(27248);
        abf abf = new abf();
        abf.a(ak(biVar));
        aar aar = new aar();
        a(aar, biVar);
        if (t.nv(biVar.field_talker)) {
            aar.akV(aiy(biVar.field_imgPath));
        } else {
            aar.akV(q.getFullPath(biVar.field_imgPath));
        }
        aar.LE(3);
        aar.oY(true);
        com.tencent.mm.modelvoice.b uN = q.uN(biVar.field_imgPath);
        if (uN == null) {
            AppMethodBeat.o(27248);
            return false;
        }
        aar.akR(Kp(uN.getFormat()));
        aar.LD((int) new n(biVar.field_content).time);
        LinkedList linkedList = new LinkedList();
        linkedList.add(aar);
        abf.aE(linkedList);
        clVar.cvA.cvC = abf;
        clVar.cvA.type = 3;
        AppMethodBeat.o(27248);
        return true;
    }

    private static String aiy(String str) {
        AppMethodBeat.i(27249);
        String b = com.tencent.mm.sdk.platformtools.j.b(com.tencent.mm.plugin.record.b.XZ(), "recbiz_", str, ".rec", 2);
        if (bo.isNullOrNil(b)) {
            AppMethodBeat.o(27249);
            return null;
        } else if (new b(b).exists()) {
            AppMethodBeat.o(27249);
            return b;
        } else {
            AppMethodBeat.o(27249);
            return b;
        }
    }

    public static String Kp(int i) {
        if (i == 1) {
            return "speex";
        }
        if (i == 4) {
            return "silk";
        }
        return "amr";
    }

    private static boolean h(cl clVar, bi biVar) {
        AppMethodBeat.i(27250);
        abf abf = new abf();
        abf.a(ak(biVar));
        aar aar = new aar();
        a(aar, biVar);
        com.tencent.mm.modelvideo.o.all();
        aar.akW(com.tencent.mm.modelvideo.t.ui(biVar.field_imgPath));
        aar.akR(com.tencent.mm.vfs.e.cv(aar.wgx));
        s ut = u.ut(biVar.field_imgPath);
        if (ut == null) {
            ab.w("MicroMsg.GetFavDataSource", "[doFileFavVideoEventInfo] null == info");
            clVar.cvA.cvG = R.string.bog;
            AppMethodBeat.o(27250);
            return false;
        }
        ab.i("MicroMsg.GetFavDataSource", "video length is %d", Integer.valueOf(ut.frO));
        if (ut.frO > com.tencent.mm.m.b.Nc()) {
            clVar.cvA.cvG = R.string.bs4;
            AppMethodBeat.o(27250);
            return false;
        } else if (biVar.bwt() && u.uv(ut.getFileName())) {
            clVar.cvA.cvG = R.string.bog;
            AppMethodBeat.o(27250);
            return false;
        } else {
            if (ut.alz()) {
                com.tencent.mm.modelvideo.o.all();
                ab.i("MicroMsg.GetFavDataSource", "this video had finish download, set orgn path [%s]", com.tencent.mm.modelvideo.t.uh(biVar.field_imgPath));
                aar.akV(r5);
            } else {
                ab.i("MicroMsg.GetFavDataSource", "this video had not finish download, set orgn path null");
                aar.akV("");
            }
            aar.LD(ut.fXd);
            LinkedList linkedList = new LinkedList();
            linkedList.add(aar);
            abf.aE(linkedList);
            clVar.cvA.cvC = abf;
            if (biVar.bwt()) {
                clVar.cvA.type = 16;
                aar.LE(15);
            } else {
                clVar.cvA.type = 4;
                aar.LE(4);
            }
            s ut2 = u.ut(biVar.field_imgPath);
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
            AppMethodBeat.o(27250);
            return true;
        }
    }

    private static aar a(bi biVar, com.tencent.mm.af.j.b bVar, int i) {
        AppMethodBeat.i(27251);
        aar aar = new aar();
        a(aar, biVar);
        aar.akO(bVar.fgM);
        aar.akP(bVar.fgN);
        aar.akN(bVar.url);
        aar.oX(true);
        b bVar2 = new b(bo.bc(o.ahl().I(biVar.field_imgPath, true), ""));
        if (bVar2.exists()) {
            aar.akW(com.tencent.mm.vfs.j.w(bVar2.dMD()));
        } else {
            aar.oY(true);
        }
        aar.akH(bVar.title);
        aar.akI(bVar.description);
        aar.alg(bVar.canvasPageXml);
        aar.LE(i);
        aar.alf(bVar.cMn);
        AppMethodBeat.o(27251);
        return aar;
    }

    private static boolean i(cl clVar, bi biVar) {
        AppMethodBeat.i(27252);
        abf abf = new abf();
        abf.a(ak(biVar));
        String str = biVar.field_content;
        if (str == null) {
            clVar.cvA.cvG = R.string.bor;
            AppMethodBeat.o(27252);
            return false;
        }
        com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(str);
        if (me == null) {
            clVar.cvA.cvG = R.string.bor;
            AppMethodBeat.o(27252);
            return false;
        }
        clVar.cvA.cvC = abf;
        abl abl = abf.wit;
        abl.alJ(me.appId);
        abl.alL(me.cMg);
        com.tencent.mm.pluginsdk.model.app.b aiE;
        aar aar;
        String I;
        aar a;
        abe abe;
        switch (me.type) {
            case 1:
                clVar.cvA.cvC = abf;
                clVar.cvA.desc = me.title;
                clVar.cvA.type = 1;
                AppMethodBeat.o(27252);
                return true;
            case 2:
                if (com.tencent.mm.kernel.g.RP().isSDCardAvailable()) {
                    aiE = com.tencent.mm.plugin.s.a.aUq().aiE(me.csD);
                    aar = new aar();
                    a(aar, biVar);
                    if (aiE != null) {
                        aar.akV(aiE.field_fileFullPath);
                    }
                    I = o.ahl().I(biVar.field_imgPath, true);
                    if (com.tencent.mm.vfs.e.ct(I)) {
                        aar.akW(I);
                    }
                    aar.LE(2);
                    aar.akH(me.title);
                    aar.akI(me.description);
                    abf.wiv.add(aar);
                    clVar.cvA.type = 2;
                    AppMethodBeat.o(27252);
                    return true;
                }
                clVar.cvA.cvG = R.string.box;
                AppMethodBeat.o(27252);
                return false;
            case 3:
                abf.wiv.add(a(biVar, me, 7));
                clVar.cvA.type = 7;
                AppMethodBeat.o(27252);
                return true;
            case 4:
                a = a(biVar, me, 4);
                abf.alB(a.title);
                abf.alC(a.desc);
                abf.wiv.add(a);
                clVar.cvA.type = 4;
                AppMethodBeat.o(27252);
                return true;
            case 5:
                if (me.url == null || me.url.equals("")) {
                    clVar.cvA.cvG = R.string.bol;
                    AppMethodBeat.o(27252);
                    return false;
                }
                abf.wit.alK(me.url);
                if (!bo.isNullOrNil(me.thumburl)) {
                    abu abu = new abu();
                    abu.alT(me.thumburl);
                    abf.b(abu);
                }
                a = a(biVar, me, 5);
                abf.wiv.add(a);
                abf.alB(a.title);
                abf.alC(a.desc);
                clVar.cvA.type = 5;
                AppMethodBeat.o(27252);
                return true;
            case 6:
                if (com.tencent.mm.kernel.g.RP().isSDCardAvailable()) {
                    aiE = com.tencent.mm.plugin.s.a.aUq().aiE(me.csD);
                    aar = new aar();
                    if (aiE != null) {
                        aar.akV(aiE.field_fileFullPath);
                    }
                    a(aar, biVar);
                    aar.LE(8);
                    aar.akR(me.fgp);
                    I = o.ahl().I(biVar.field_imgPath, true);
                    if (bo.isNullOrNil(I)) {
                        aar.oY(true);
                    }
                    if (com.tencent.mm.vfs.e.ct(I)) {
                        aar.akW(I);
                    }
                    aar.akH(me.title);
                    aar.akI(me.description);
                    abf.wiv.add(aar);
                    clVar.cvA.desc = me.title;
                    clVar.cvA.type = 8;
                    AppMethodBeat.o(27252);
                    return true;
                }
                clVar.cvA.cvG = R.string.box;
                AppMethodBeat.o(27252);
                return false;
            case 7:
                if (me.csD == null || me.csD.length() == 0) {
                    clVar.cvA.cvG = R.string.boi;
                } else if (!com.tencent.mm.kernel.g.RP().isSDCardAvailable()) {
                    clVar.cvA.cvG = R.string.box;
                    AppMethodBeat.o(27252);
                    return false;
                }
                clVar.cvA.cvG = R.string.bop;
                AppMethodBeat.o(27252);
                return false;
            case 10:
                abe = new abe();
                abe.alw(me.title);
                abe.alx(me.description);
                abe.LK(me.fgP);
                abe.alz(me.fgQ);
                abe.aly(me.thumburl);
                clVar.cvA.title = me.title;
                clVar.cvA.desc = me.description;
                clVar.cvA.type = 10;
                abf.b(abe);
                AppMethodBeat.o(27252);
                return true;
            case 13:
                abe = new abe();
                abe.alw(me.title);
                abe.alx(me.description);
                abe.LK(me.fgV);
                abe.alz(me.fgW);
                abe.aly(me.thumburl);
                clVar.cvA.title = me.title;
                clVar.cvA.desc = me.description;
                clVar.cvA.type = 11;
                abf.b(abe);
                AppMethodBeat.o(27252);
                return true;
            case 19:
            case 24:
                clVar.cvA.cvD = new abt();
                boolean a2 = a(clVar, me, abf, biVar);
                AppMethodBeat.o(27252);
                return a2;
            case 20:
                abo abo = new abo();
                abo.alM(me.title);
                abo.alN(me.description);
                abo.alP(me.fgT);
                abo.alO(me.thumburl);
                clVar.cvA.title = me.title;
                clVar.cvA.desc = me.description;
                clVar.cvA.type = 15;
                abf.b(abo);
                AppMethodBeat.o(27252);
                return true;
            case 33:
            case 36:
                aap aap = new aap();
                aap.username = me.fiP;
                aap.appId = me.fiQ;
                aap.cBc = me.fiT;
                aap.iconUrl = me.fjb;
                aap.csu = me.fiO;
                aap.wfO = me.cMh;
                aar = new aar();
                a(aar, biVar);
                aar.LE(19);
                String I2 = o.ahl().I(biVar.field_imgPath, true);
                if (bo.isNullOrNil(I2)) {
                    aar.oY(true);
                }
                if (com.tencent.mm.vfs.e.ct(I2)) {
                    aar.akW(I2);
                }
                aar.akH(me.title);
                aar.akI(me.description);
                abf.wiv.add(aar);
                clVar.cvA.title = me.title;
                clVar.cvA.desc = me.description;
                clVar.cvA.type = 19;
                abf.b(aap);
                AppMethodBeat.o(27252);
                return true;
            default:
                clVar.cvA.cvG = R.string.bop;
                AppMethodBeat.o(27252);
                return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x010f A:{Catch:{ Exception -> 0x0114 }} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00af A:{Catch:{ Exception -> 0x0114 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean c(cl clVar, bi biVar) {
        AppMethodBeat.i(27253);
        abf abf = new abf();
        abl ak = ak(biVar);
        abf.a(ak);
        try {
            com.tencent.mm.af.o b = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.biz.a.a.class)).b(biVar.field_msgId, biVar.field_content);
            LinkedList linkedList = b.fjr;
            ak.alL(b.cMg);
            if (linkedList != null && linkedList.size() > clVar.cvA.cvE) {
                ab.i("MicroMsg.GetFavDataSource", "favorite biz msg, index is %d", Integer.valueOf(clVar.cvA.cvE));
                p pVar = (p) linkedList.get(clVar.cvA.cvE);
                if (l.mg(pVar.fjC)) {
                    clVar.cvA.cvG = R.string.bop;
                    AppMethodBeat.o(27253);
                    return false;
                }
                String ack;
                ak.alK(pVar.url);
                if (clVar.cvA.cvE > 0) {
                    ak.alF("");
                }
                aar aar = new aar();
                aar.akH(pVar.title);
                aar.akI(pVar.fjz);
                a(aar, biVar);
                String a = l.a(pVar);
                if (bo.isNullOrNil(a)) {
                    h qo = com.tencent.mm.ah.o.act().qo(biVar.field_talker);
                    if (qo != null) {
                        ack = qo.ack();
                        if (bo.isNullOrNil(ack)) {
                            aar.akW(q.v(ack, biVar.getType(), clVar.cvA.cvE > 0 ? "@S" : "@T"));
                            aar.oY(false);
                            if (bo.isNullOrNil(aar.wgz) || !com.tencent.mm.vfs.e.ct(aar.wgz)) {
                                aar.akQ(ack);
                                aar.oY(true);
                                abu abu = new abu();
                                abu.alT(ack);
                                abf.b(abu);
                            }
                        } else {
                            aar.oY(true);
                        }
                        aar.oX(true);
                        aar.LE(5);
                        abf.wiv.add(aar);
                        clVar.cvA.cvC = abf;
                        clVar.cvA.desc = pVar.title;
                        clVar.cvA.type = 5;
                        AppMethodBeat.o(27253);
                        return true;
                    }
                }
                ack = a;
                if (bo.isNullOrNil(ack)) {
                }
                aar.oX(true);
                aar.LE(5);
                abf.wiv.add(aar);
                clVar.cvA.cvC = abf;
                clVar.cvA.desc = pVar.title;
                clVar.cvA.type = 5;
                AppMethodBeat.o(27253);
                return true;
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.GetFavDataSource", e, "", new Object[0]);
            ab.e("MicroMsg.GetFavDataSource", "retransmit app msg error : %s", e.getLocalizedMessage());
        }
        clVar.cvA.cvG = R.string.bor;
        AppMethodBeat.o(27253);
        return false;
    }

    private static boolean a(cl clVar, com.tencent.mm.af.j.b bVar, abf abf, bi biVar) {
        AppMethodBeat.i(27255);
        nt ntVar = new nt();
        ntVar.cJY.type = 0;
        ntVar.cJY.cKa = bVar.fgU;
        a.xxA.m(ntVar);
        com.tencent.mm.protocal.b.a.c cVar = ntVar.cJZ.cKi;
        if (cVar == null) {
            ab.w("MicroMsg.GetFavDataSource", "fill favorite event fail, parse record msg null");
            clVar.cvA.cvG = R.string.bor;
            AppMethodBeat.o(27255);
            return false;
        }
        abf.alB(cVar.title);
        Iterator it = cVar.fjr.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2;
            aar aar = (aar) it.next();
            aar aar2 = null;
            abt abt;
            switch (aar.dataType) {
                case 1:
                    aar = q(aar);
                    abt = clVar.cvA.cvD;
                    abt.wiK++;
                    aar2 = aar;
                    break;
                case 2:
                    aar = j(aar, biVar.field_msgId);
                    abt = clVar.cvA.cvD;
                    abt.wiL++;
                    aar2 = aar;
                    break;
                case 3:
                    aar = i(aar, biVar.field_msgId);
                    abt = clVar.cvA.cvD;
                    abt.wiM++;
                    aar2 = aar;
                    break;
                case 4:
                case 15:
                    aar = l(aar, biVar.field_msgId);
                    abt = clVar.cvA.cvD;
                    abt.wiN++;
                    aar2 = aar;
                    break;
                case 5:
                    aar = k(aar, biVar.field_msgId);
                    abt = clVar.cvA.cvD;
                    abt.wiO++;
                    aar2 = aar;
                    break;
                case 6:
                    aar = r(aar);
                    abt = clVar.cvA.cvD;
                    abt.wiP++;
                    aar2 = aar;
                    break;
                case 7:
                    aar = m(aar, biVar.field_msgId);
                    abt = clVar.cvA.cvD;
                    abt.wiQ++;
                    aar2 = aar;
                    break;
                case 8:
                    aar = n(aar, biVar.field_msgId);
                    abt = clVar.cvA.cvD;
                    abt.fileCount++;
                    aar2 = aar;
                    break;
                case 10:
                    aar = a(aar, aar.dataType);
                    abt = clVar.cvA.cvD;
                    abt.wiS++;
                    aar2 = aar;
                    break;
                case 11:
                    aar = a(aar, aar.dataType);
                    abt = clVar.cvA.cvD;
                    abt.wiT++;
                    aar2 = aar;
                    break;
                case 12:
                case 14:
                    aar = t(aar);
                    abt = clVar.cvA.cvD;
                    abt.wiW++;
                    aar2 = aar;
                    break;
                case 16:
                    aar = u(aar);
                    abt = clVar.cvA.cvD;
                    abt.wiX++;
                    aar2 = aar;
                    break;
                case 17:
                    aar2 = s(aar);
                    break;
                case 19:
                    aar2 = o(aar, biVar.field_msgId);
                    break;
                case 20:
                    aar2 = v(aar);
                    break;
            }
            if (aar2 != null) {
                i2 = i + 1;
                aar2.akZ(e(biVar, i));
                abf.wiv.add(aar2);
            } else {
                i2 = i;
            }
            i = i2;
        }
        if (bo.isNullOrNil(((aar) cVar.fjr.get(0)).wgo) || !((aar) cVar.fjr.get(0)).wgo.equals(".htm")) {
            clVar.cvA.type = 14;
        } else {
            clVar.cvA.type = 18;
        }
        AppMethodBeat.o(27255);
        return true;
    }

    private static aar p(aar aar) {
        AppMethodBeat.i(27256);
        aar aar2 = new aar();
        aas aas = new aas();
        aat aat = new aat();
        aat aat2 = aar.wgT.whw;
        if (aat2.whQ) {
            aat.alm(aat2.cEV);
        }
        if (aat2.whR) {
            aat.aln(aat2.toUser);
        }
        if (aat2.whV) {
            aat.alp(aat2.whU);
        }
        aat.LI(1);
        aat.mi(bo.anU());
        aas.c(aat);
        aar2.a(aas);
        aar2.alc(aar.wgV);
        aar2.ald(aar.wgX);
        aar2.all(aar.whu);
        aar2.oY(true);
        aar2.oX(true);
        aar2.ale(aar.whb);
        aar2.LG(aar.whh);
        aar2.akS(aar.wgq);
        aar2.akT(aar.wgs);
        aar2.mf(aar.wgu);
        aar2.akX(aar.wgB);
        aar2.akY(aar.wgD);
        aar2.mg(aar.wgF);
        AppMethodBeat.o(27256);
        return aar2;
    }

    private static aar q(aar aar) {
        AppMethodBeat.i(27258);
        aar p = p(aar);
        p.LE(1);
        p.akI(aar.desc);
        AppMethodBeat.o(27258);
        return p;
    }

    private static aar i(aar aar, long j) {
        AppMethodBeat.i(27259);
        aar p = p(aar);
        p.LE(3);
        if (!bo.isNullOrNil(aar.whb)) {
            nt ntVar = new nt();
            ntVar.cJY.type = 1;
            ntVar.cJY.cAv = aar;
            ntVar.cJY.cvx = j;
            a.xxA.m(ntVar);
            if (bo.isNullOrNil(ntVar.cJZ.dataPath) && bo.isNullOrNil(ntVar.cJZ.thumbPath)) {
                ab.e("MicroMsg.GetFavDataSource", "cloneImgItem:not record plugin ? get paths error");
            }
            p.akV(ntVar.cJZ.dataPath);
            p.LD(aar.duration);
            p.oY(true);
            p.oX(false);
            p.akR(aar.wgo);
        }
        AppMethodBeat.o(27259);
        return p;
    }

    private static aar j(aar aar, long j) {
        AppMethodBeat.i(27260);
        aar p = p(aar);
        p.LE(2);
        nt ntVar = new nt();
        ntVar.cJY.type = 1;
        ntVar.cJY.cAv = aar;
        ntVar.cJY.cvx = j;
        a.xxA.m(ntVar);
        if (bo.isNullOrNil(ntVar.cJZ.dataPath) && bo.isNullOrNil(ntVar.cJZ.thumbPath)) {
            ab.e("MicroMsg.GetFavDataSource", "cloneImgItem:not record plugin ? get paths error");
        }
        p.akV(ntVar.cJZ.dataPath);
        p.akW(ntVar.cJZ.thumbPath);
        p.oY(false);
        p.oX(false);
        AppMethodBeat.o(27260);
        return p;
    }

    private static aar k(aar aar, long j) {
        AppMethodBeat.i(27261);
        aar p = p(aar);
        a(p, aar);
        p.LE(5);
        nt ntVar = new nt();
        ntVar.cJY.type = 1;
        ntVar.cJY.cAv = aar;
        ntVar.cJY.cvx = j;
        a.xxA.m(ntVar);
        if (bo.isNullOrNil(ntVar.cJZ.dataPath) && bo.isNullOrNil(ntVar.cJZ.thumbPath)) {
            ab.e("MicroMsg.GetFavDataSource", "cloneUrlItem:not record plugin ? get paths error");
        }
        p.akW(ntVar.cJZ.thumbPath);
        p.oY(false);
        if (!(aar.wgT == null || aar.wgT.whA == null)) {
            abu abu = new abu();
            abu.alQ(aar.wgT.whA.title);
            abu.alR(aar.wgT.whA.desc);
            abu.alT(aar.wgT.whA.thumbUrl);
            abu.LO(aar.wgT.whA.wja);
            abu.alS(aar.wgT.whA.wiY);
            p.wgT.a(abu);
        }
        AppMethodBeat.o(27261);
        return p;
    }

    private static aar l(aar aar, long j) {
        AppMethodBeat.i(27262);
        aar p = p(aar);
        a(p, aar);
        if (aar.dataType == 15) {
            p.LE(15);
        } else {
            p.LE(4);
        }
        nt ntVar = new nt();
        ntVar.cJY.type = 1;
        ntVar.cJY.cAv = aar;
        ntVar.cJY.cvx = j;
        a.xxA.m(ntVar);
        if (bo.isNullOrNil(ntVar.cJZ.dataPath) && bo.isNullOrNil(ntVar.cJZ.thumbPath)) {
            ab.e("MicroMsg.GetFavDataSource", "cloneVideoItem:not record plugin ? get paths error");
        }
        p.oX(false);
        p.akV(ntVar.cJZ.dataPath);
        p.oY(false);
        p.akW(ntVar.cJZ.thumbPath);
        p.LD(aar.duration);
        AppMethodBeat.o(27262);
        return p;
    }

    private static aar r(aar aar) {
        AppMethodBeat.i(27263);
        aar p = p(aar);
        p.LE(6);
        if (!(aar.wgT == null || aar.wgT.why == null)) {
            aay aay = new aay();
            aay.alu(aar.wgT.why.label);
            aay.E(aar.wgT.why.lat);
            aay.D(aar.wgT.why.lng);
            aay.LJ(aar.wgT.why.cED);
            aay.alv(aar.wgT.why.cIK);
            p.wgT.a(aay);
        }
        AppMethodBeat.o(27263);
        return p;
    }

    private static aar m(aar aar, long j) {
        AppMethodBeat.i(27264);
        aar p = p(aar);
        a(p, aar);
        p.LE(7);
        nt ntVar = new nt();
        ntVar.cJY.type = 1;
        ntVar.cJY.cAv = aar;
        ntVar.cJY.cvx = j;
        a.xxA.m(ntVar);
        if (bo.isNullOrNil(ntVar.cJZ.dataPath) && bo.isNullOrNil(ntVar.cJZ.thumbPath)) {
            ab.e("MicroMsg.GetFavDataSource", "cloneMusicItem:not record plugin ? get paths error");
        }
        p.akW(ntVar.cJZ.thumbPath);
        p.oY(false);
        AppMethodBeat.o(27264);
        return p;
    }

    private static aar n(aar aar, long j) {
        AppMethodBeat.i(27265);
        aar p = p(aar);
        a(p, aar);
        p.LE(8);
        nt ntVar = new nt();
        ntVar.cJY.type = 1;
        ntVar.cJY.cAv = aar;
        ntVar.cJY.cvx = j;
        a.xxA.m(ntVar);
        if (bo.isNullOrNil(ntVar.cJZ.dataPath) && bo.isNullOrNil(ntVar.cJZ.thumbPath)) {
            ab.e("MicroMsg.GetFavDataSource", "cloneFileItem:not record plugin ? get paths error");
        }
        p.akV(ntVar.cJZ.dataPath);
        p.akW(ntVar.cJZ.thumbPath);
        p.oX(false);
        p.akR(aar.wgo);
        AppMethodBeat.o(27265);
        return p;
    }

    private static aar s(aar aar) {
        AppMethodBeat.i(27266);
        aar p = p(aar);
        p.akH(aar.title);
        p.akI(aar.desc);
        p.LE(17);
        p.alh(aar.whj);
        AppMethodBeat.o(27266);
        return p;
    }

    private static aar o(aar aar, long j) {
        AppMethodBeat.i(27267);
        aar p = p(aar);
        p.akH(aar.title);
        p.akI(aar.desc);
        p.LE(19);
        nt ntVar = new nt();
        ntVar.cJY.type = 1;
        ntVar.cJY.cAv = aar;
        ntVar.cJY.cvx = j;
        a.xxA.m(ntVar);
        if (bo.isNullOrNil(ntVar.cJZ.thumbPath)) {
            ab.e("MicroMsg.GetFavDataSource", "cloneAppBrandItem:not record plugin ? get paths error");
        } else {
            p.oY(false);
            p.akW(ntVar.cJZ.thumbPath);
        }
        if (!(aar.wgT == null || aar.wgT.whN == null)) {
            aap aap = new aap();
            aap.username = aar.wgT.whN.username;
            aap.appId = aar.wgT.whN.appId;
            aap.cBc = aar.wgT.whN.cBc;
            aap.iconUrl = aar.wgT.whN.iconUrl;
            aap.type = aar.wgT.whN.type;
            aap.csu = aar.wgT.whN.csu;
            aap.wfO = aar.wgT.whN.wfO;
            p.wgT.a(aap);
        }
        AppMethodBeat.o(27267);
        return p;
    }

    private static aar a(aar aar, int i) {
        AppMethodBeat.i(27268);
        aar p = p(aar);
        p.LE(i);
        if (!(aar.wgT == null || aar.wgT.whC == null)) {
            abe abe = new abe();
            abe.alw(aar.wgT.whC.title);
            abe.alx(aar.wgT.whC.desc);
            abe.LK(aar.wgT.whC.type);
            abe.alz(aar.wgT.whC.info);
            abe.aly(aar.wgT.whC.thumbUrl);
            p.wgT.a(abe);
        }
        AppMethodBeat.o(27268);
        return p;
    }

    private static aar t(aar aar) {
        AppMethodBeat.i(27269);
        aar p = p(aar);
        p.LE(14);
        if (!(aar.wgT == null || aar.wgT.whE == null)) {
            abo abo = new abo();
            abo.alM(aar.wgT.whE.title);
            abo.alN(aar.wgT.whE.desc);
            abo.alP(aar.wgT.whE.info);
            abo.alO(aar.wgT.whE.thumbUrl);
            p.wgT.a(abo);
        }
        AppMethodBeat.o(27269);
        return p;
    }

    private static aar u(aar aar) {
        AppMethodBeat.i(27270);
        aar p = p(aar);
        p.LE(16);
        p.akI(aar.desc);
        AppMethodBeat.o(27270);
        return p;
    }

    private static aar v(aar aar) {
        AppMethodBeat.i(27271);
        aar p = p(aar);
        p.LE(20);
        p.LD(aar.duration);
        AppMethodBeat.o(27271);
        return p;
    }

    private static void a(aar aar, bi biVar) {
        AppMethodBeat.i(27247);
        if (biVar.field_isSend != 1) {
            aar.akZ(String.valueOf(biVar.field_msgSvrId));
            AppMethodBeat.o(27247);
        } else if (t.kH(biVar.field_talker) || biVar.field_talker.equals("filehelper")) {
            aar.akZ(String.valueOf(biVar.field_msgSvrId));
            AppMethodBeat.o(27247);
        } else {
            aar.akZ(biVar.field_talker + "#" + String.valueOf(biVar.field_msgSvrId));
            AppMethodBeat.o(27247);
        }
    }

    private static String e(bi biVar, int i) {
        AppMethodBeat.i(27254);
        String format;
        if (biVar.field_isSend != 1) {
            format = String.format("%d$%d", new Object[]{Long.valueOf(biVar.field_msgSvrId), Integer.valueOf(i)});
            AppMethodBeat.o(27254);
            return format;
        } else if (t.kH(biVar.field_talker) || biVar.field_talker.equals("filehelper")) {
            format = String.format("%d$%d", new Object[]{Long.valueOf(biVar.field_msgSvrId), Integer.valueOf(i)});
            AppMethodBeat.o(27254);
            return format;
        } else {
            format = String.format("%s#%d$%d", new Object[]{biVar.field_talker, Long.valueOf(biVar.field_msgSvrId), Integer.valueOf(i)});
            AppMethodBeat.o(27254);
            return format;
        }
    }

    private static void a(aar aar, aar aar2) {
        AppMethodBeat.i(27257);
        aar.akO(aar2.wgi);
        aar.akP(aar2.wgk);
        aar.akN(aar2.wgg);
        aar.akH(aar2.title);
        aar.akI(aar2.desc);
        AppMethodBeat.o(27257);
    }
}
