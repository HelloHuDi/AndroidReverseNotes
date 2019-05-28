package com.tencent.mm.plugin.sns.j;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.aau;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.abl;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;
import java.util.Map;

public final class a {
    public static boolean a(cl clVar, n nVar) {
        AppMethodBeat.i(38035);
        if (nVar == null) {
            ab.w("MicroMsg.Sns.GetFavDataSource", "fill sight favorite event fail, event is null or tlObj is null");
            clVar.cvA.cvG = R.string.boh;
            AppMethodBeat.o(38035);
            return false;
        }
        abf abf = new abf();
        abl abl = new abl();
        TimeLineObject cqu = nVar.cqu();
        bau bau = (bau) cqu.xfI.wbK.get(0);
        if (nVar.DI(32) && cqu.xfI.wbJ == 15) {
            cqu.xfN.fiM = nVar.cqq().qPj;
            cqu.xfN.fiN = cqu.Id;
        }
        String jV = i.jV(nVar.field_snsId);
        jV = String.format("%s#%s", new Object[]{jV, bau.Id});
        abl.alD(nVar.field_userName);
        abl.alE(r.Yz());
        abl.LN(2);
        abl.ml(bo.anU());
        abl.alI(nVar.cqA());
        abl.alF(jV);
        abf.a(abl);
        aar aar = new aar();
        aar.akZ(jV);
        String fZ = an.fZ(af.getAccSnsPath(), bau.Id);
        String j = i.j(bau);
        String e = i.e(bau);
        if (bo.isNullOrNil(aq.a(nVar.cqU(), bau))) {
            ab.w("MicroMsg.Sns.GetFavDataSource", "this sight had no download finish, can not favorite.");
            clVar.cvA.cvG = R.string.boy;
            AppMethodBeat.o(38035);
            return false;
        } else if (e.ct(fZ + j)) {
            int i;
            int i2;
            if (!e.ct(fZ + e)) {
                i = 320;
                int i3 = 240;
                if (bau.wEK != null && bau.wEK.wFy > 0.0f && bau.wEK.wFx > 0.0f) {
                    i = (int) bau.wEK.wFx;
                    i3 = (int) bau.wEK.wFy;
                }
                Bitmap ag = d.ag(fZ + j, i, i3);
                if (ag == null) {
                    ab.i("MicroMsg.Sns.GetFavDataSource", "fav error on get thumb:" + e.ct(fZ + e));
                    clVar.cvA.cvG = R.string.boy;
                    AppMethodBeat.o(38035);
                    return false;
                }
                try {
                    com.tencent.mm.sdk.platformtools.d.a(ag, 60, CompressFormat.JPEG, fZ + e, true);
                } catch (Exception e2) {
                    ab.printErrStackTrace("MicroMsg.Sns.GetFavDataSource", e2, "save bmp error %s", e2.getMessage());
                    ab.i("MicroMsg.Sns.GetFavDataSource", "fav error on save thumb:" + e.ct(fZ + e));
                    clVar.cvA.cvG = R.string.boy;
                    AppMethodBeat.o(38035);
                    return false;
                }
            }
            aar.akV(fZ + j);
            aar.akW(fZ + e);
            aar.akH(bo.isNullOrNil(bau.wES) ? cqu.xfF : bau.wES);
            aar.alg(cqu.rCK);
            if (!bo.isNullOrNil(cqu.rCK)) {
                Map z = br.z(cqu.rCK, "adxml");
                if (z.size() > 0) {
                    aar.akH(bo.bc((String) z.get(".adxml.adCanvasInfo.shareTitle"), ""));
                    aar.akI(bo.bc((String) z.get(".adxml.adCanvasInfo.shareDesc"), ""));
                }
            }
            i = 4;
            if (nVar.DI(32)) {
                b cqo = nVar.cqo();
                aau aau = new aau();
                aau.fiI = bo.isNullOrNil(bau.wES) ? cqu.xfF : bau.wES;
                aau.wid = bau.rEd;
                aau.fiG = bau.wEO;
                aau.fiM = cqu.xfN.fiM;
                aau.fiN = cqu.xfN.fiN;
                if (bo.isNullOrNil(aau.fiN)) {
                    aau.fiN = cqu.Id;
                }
                aau.fiL = bo.isNullOrNil(bau.wER) ? bau.wEH : bau.wER;
                if (cqo != null && cqo.qUn == 0) {
                    aau.fiK = cqo.qUp;
                    aau.fiJ = cqo.qUo;
                }
                aar.a(aau);
                i2 = 16;
                i = 15;
            } else {
                i2 = 4;
            }
            aar.LE(i);
            com.tencent.mm.plugin.sight.base.a WR = d.WR(aar.wgx);
            if (WR != null) {
                aar.LD(WR.ckU());
            } else {
                aar.LD(1);
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(aar);
            abf.aE(linkedList);
            clVar.cvA.cvC = abf;
            clVar.cvA.type = i2;
            a(aar, nVar);
            ab.i("MicroMsg.Sns.GetFavDataSource", "fill event Info sight dataType %d eventType %d", Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.o(38035);
            return true;
        } else {
            ab.i("MicroMsg.Sns.GetFavDataSource", "fav error sight: " + e.ct(fZ + j) + " thumb:" + e.ct(fZ + e));
            clVar.cvA.cvG = R.string.boy;
            AppMethodBeat.o(38035);
            return false;
        }
    }

    public static boolean a(cl clVar, String str, String str2) {
        AppMethodBeat.i(38036);
        boolean b = b(clVar, str, str2);
        AppMethodBeat.o(38036);
        return b;
    }

    public static boolean b(cl clVar, String str, String str2) {
        AppMethodBeat.i(38037);
        if (clVar == null || !v.Zo(str2) || str == null) {
            ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or url is null");
            if (clVar != null) {
                clVar.cvA.cvG = R.string.boh;
            }
            AppMethodBeat.o(38037);
            return false;
        } else if (af.cnn()) {
            ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
            clVar.cvA.cvG = R.string.boz;
            AppMethodBeat.o(38037);
            return false;
        } else {
            n YT = h.YT(str2);
            if (YT == null) {
                ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                clVar.cvA.cvG = R.string.boi;
                AppMethodBeat.o(38037);
                return false;
            } else if (YT.cqu().xfI == null || YT.cqu().xfI.wbJ != 26) {
                abu abu;
                String str3 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                bau a = aj.a(YT, 0);
                if (a != null) {
                    str3 = a.Id;
                }
                String jV = i.jV(YT.field_snsId);
                str3 = String.format("%s#%s", new Object[]{jV, str3});
                abf abf = new abf();
                abl abl = new abl();
                ab.i("MicroMsg.Sns.GetFavDataSource", "fav sns url, from %s", YT.field_userName);
                abl.alD(YT.field_userName);
                abl.alE(r.Yz());
                abl.LN(2);
                abl.ml(((long) YT.field_createTime) * 1000);
                abl.alI(YT.cqA());
                abl.alF(str3);
                abl.alK(str);
                aar aar = new aar();
                aar.akZ(str3);
                if (a != null) {
                    str3 = an.fZ(af.getAccSnsPath(), a.Id) + i.e(a);
                    if (e.ct(str3)) {
                        aar.akW(str3);
                    } else {
                        aar.oY(true);
                        aar.akQ(a.wEH);
                        abu = new abu();
                        abu.alT(a.wEH);
                        abf.b(abu);
                    }
                } else {
                    aar.oY(true);
                }
                aar.LE(5);
                TimeLineObject cqu = YT.cqu();
                aar.akH(cqu.xfI.Title);
                aar.akI(cqu.xfI.Desc);
                aar.alg(cqu.rCK);
                if (!bo.isNullOrNil(cqu.rCK)) {
                    Map z = br.z(cqu.rCK, "adxml");
                    if (z.size() > 0) {
                        aar.akH(bo.bc((String) z.get(".adxml.adCanvasInfo.shareTitle"), ""));
                        aar.akI(bo.bc((String) z.get(".adxml.adCanvasInfo.shareDesc"), ""));
                    }
                }
                a(aar, cqu);
                aar.oX(true);
                abf.wiv.add(aar);
                abu = new abu();
                abu.LP(cqu.fgt);
                abf.b(abu);
                abf.a(abl);
                clVar.cvA.cvC = abf;
                clVar.cvA.desc = cqu.xfI.Title;
                clVar.cvA.type = 5;
                AppMethodBeat.o(38037);
                return true;
            } else {
                boolean a2 = a(clVar, str2);
                AppMethodBeat.o(38037);
                return a2;
            }
        }
    }

    public static boolean a(cl clVar, String str, CharSequence charSequence) {
        AppMethodBeat.i(38038);
        if (v.Zp(str) || charSequence == null) {
            ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or text is null");
            clVar.cvA.cvG = R.string.boh;
            AppMethodBeat.o(38038);
            return false;
        } else if (af.cnn()) {
            ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
            clVar.cvA.cvG = R.string.boz;
            AppMethodBeat.o(38038);
            return false;
        } else {
            n YT = af.cnF().YT(str);
            if (YT == null) {
                ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                clVar.cvA.cvG = R.string.boi;
                AppMethodBeat.o(38038);
                return false;
            } else if (0 == YT.field_snsId) {
                ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo.field_snsId is 0");
                clVar.cvA.cvG = R.string.bog;
                AppMethodBeat.o(38038);
                return false;
            } else {
                String jV = i.jV(YT.field_snsId);
                jV = String.format("%s#0", new Object[]{jV});
                abf abf = new abf();
                abl abl = new abl();
                ab.i("MicroMsg.Sns.GetFavDataSource", "fav sns text, from %s", YT.field_userName);
                abl.alD(YT.field_userName);
                abl.alE(r.Yz());
                abl.LN(2);
                abl.ml(((long) YT.field_createTime) * 1000);
                abl.alI(YT.cqA());
                abl.alF(jV);
                abf.a(abl);
                clVar.cvA.cvC = abf;
                clVar.cvA.desc = charSequence.toString();
                clVar.cvA.type = 1;
                AppMethodBeat.o(38038);
                return true;
            }
        }
    }

    public static boolean a(cl clVar, n nVar, String str) {
        AppMethodBeat.i(38039);
        if (clVar == null || bo.isNullOrNil(str)) {
            ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or media id is null");
            if (clVar != null) {
                clVar.cvA.cvG = R.string.boh;
            }
            AppMethodBeat.o(38039);
            return false;
        } else if (nVar == null) {
            ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
            clVar.cvA.cvG = R.string.boi;
            AppMethodBeat.o(38039);
            return false;
        } else {
            bau a = aj.a(nVar, str);
            if (a == null) {
                ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, mediaObj is null");
                clVar.cvA.cvG = R.string.boi;
                AppMethodBeat.o(38039);
                return false;
            }
            String jV = i.jV(nVar.field_snsId);
            jV = String.format("%s#%s", new Object[]{jV, str});
            abf abf = new abf();
            abl abl = new abl();
            aar aar = new aar();
            ab.i("MicroMsg.Sns.GetFavDataSource", "fav sns image, from %s", nVar.field_userName);
            abl.alD(nVar.field_userName);
            abl.alE(r.Yz());
            abl.LN(2);
            abl.ml(((long) nVar.field_createTime) * 1000);
            abl.alI(nVar.cqA());
            abl.alF(jV);
            aar.akZ(jV);
            aar.akV(an.fZ(af.getAccSnsPath(), str) + i.l(a));
            if (nVar.cqu() != null) {
                aar.alg(nVar.cqu().rCK);
                if (!bo.isNullOrNil(nVar.cqu().rCK)) {
                    Map z = br.z(nVar.cqu().rCK, "adxml");
                    if (z.size() > 0) {
                        aar.akH(bo.bc((String) z.get(".adxml.adCanvasInfo.shareTitle"), ""));
                        aar.akI(bo.bc((String) z.get(".adxml.adCanvasInfo.shareDesc"), ""));
                    }
                }
            }
            a(aar, nVar);
            jV = an.fZ(af.getAccSnsPath(), a.Id) + i.e(a);
            if (e.ct(aar.wgx) || !nVar.field_userName.endsWith(af.cnk())) {
                if (e.ct(jV)) {
                    aar.akW(jV);
                } else {
                    aar.oY(true);
                    aar.akQ(a.wEH);
                    abu abu = new abu();
                    abu.alT(a.wEH);
                    abf.b(abu);
                }
                aar.LE(2);
                abf.wiv.add(aar);
                abf.a(abl);
                clVar.cvA.cvC = abf;
                clVar.cvA.type = 2;
                AppMethodBeat.o(38039);
                return true;
            }
            ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, mediaObj is null");
            clVar.cvA.cvG = R.string.boi;
            AppMethodBeat.o(38039);
            return false;
        }
    }

    public static boolean a(cl clVar, String str, int i) {
        AppMethodBeat.i(38040);
        if (v.Zp(str) || i < 0) {
            ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or position errro");
            clVar.cvA.cvG = R.string.boh;
            AppMethodBeat.o(38040);
            return false;
        } else if (af.cnn()) {
            ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
            clVar.cvA.cvG = R.string.boz;
            AppMethodBeat.o(38040);
            return false;
        } else {
            n YT = af.cnF().YT(str);
            if (YT == null) {
                ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                clVar.cvA.cvG = R.string.boi;
                AppMethodBeat.o(38040);
                return false;
            }
            bau a = aj.a(YT, i);
            if (a == null) {
                ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, media obj is null");
                clVar.cvA.cvG = R.string.boi;
                AppMethodBeat.o(38040);
                return false;
            }
            boolean a2 = a(clVar, YT, a.Id);
            AppMethodBeat.o(38040);
            return a2;
        }
    }

    private static void a(aar aar, TimeLineObject timeLineObject) {
        AppMethodBeat.i(38041);
        if (!(aar == null || timeLineObject == null || bo.isNullOrNil(timeLineObject.rjC))) {
            aar.alf(timeLineObject.rjC);
        }
        AppMethodBeat.o(38041);
    }

    public static void a(aar aar, n nVar) {
        AppMethodBeat.i(38042);
        if (nVar != null) {
            a(aar, nVar.cqu());
        }
        AppMethodBeat.o(38042);
    }

    public static boolean a(cl clVar, String str) {
        int i = 0;
        AppMethodBeat.i(38043);
        if (clVar == null || !v.Zo(str)) {
            ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or url is null");
            if (clVar != null) {
                clVar.cvA.cvG = R.string.boh;
            }
            AppMethodBeat.o(38043);
            return false;
        } else if (af.cnn()) {
            ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
            clVar.cvA.cvG = R.string.boz;
            AppMethodBeat.o(38043);
            return false;
        } else {
            n YT = h.YT(str);
            if (YT == null) {
                ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                clVar.cvA.cvG = R.string.boi;
                AppMethodBeat.o(38043);
                return false;
            }
            String str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            bau a = aj.a(YT, 0);
            if (a != null) {
                str2 = a.Id;
            }
            str2 = String.format("%s#%s", new Object[]{i.jV(YT.field_snsId), str2});
            abl abl = new abl();
            TimeLineObject cqu = YT.cqu();
            if (cqu == null) {
                ab.i("MicroMsg.Sns.GetFavDataSource", "fav NoteLink, tlObj is null , return");
                AppMethodBeat.o(38043);
                return false;
            }
            ab.i("MicroMsg.Sns.GetFavDataSource", "fav NoteLink, from %s", YT.field_userName);
            abl.alD(YT.field_userName);
            abl.alE(r.Yz());
            abl.LN(2);
            abl.ml(((long) YT.field_createTime) * 1000);
            abl.alI(YT.cqA());
            abl.alF(str2);
            gh ghVar = new gh();
            ghVar.cAH.type = 30;
            ghVar.cAH.cAO = 4;
            ghVar.cAH.desc = cqu.xfI.wbM;
            com.tencent.mm.sdk.b.a.xxA.m(ghVar);
            ghVar.cAH.cvC.a(abl);
            clVar.cvA.cvC = ghVar.cAH.cvC;
            if (clVar.cvA.cvC != null) {
                LinkedList linkedList = clVar.cvA.cvC.wiv;
                if (linkedList != null) {
                    while (i < linkedList.size()) {
                        aar aar = (aar) linkedList.get(i);
                        if (aar != null) {
                            aar.oX(true);
                            aar.oY(true);
                        }
                        i++;
                    }
                }
            }
            clVar.cvA.desc = cqu.xfI.Title;
            clVar.cvA.type = 18;
            AppMethodBeat.o(38043);
            return true;
        }
    }
}
