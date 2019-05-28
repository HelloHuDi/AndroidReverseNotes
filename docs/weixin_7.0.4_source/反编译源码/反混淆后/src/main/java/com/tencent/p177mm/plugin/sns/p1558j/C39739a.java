package com.tencent.p177mm.plugin.sns.p1558j;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p230g.p231a.C37721gh;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sight.base.C43528a;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C34955aj;
import com.tencent.p177mm.plugin.sns.model.C34957aq;
import com.tencent.p177mm.plugin.sns.model.C3892an;
import com.tencent.p177mm.plugin.sns.storage.C21984b;
import com.tencent.p177mm.plugin.sns.storage.C21990h;
import com.tencent.p177mm.plugin.sns.storage.C35002v;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.aau;
import com.tencent.p177mm.protocal.protobuf.abf;
import com.tencent.p177mm.protocal.protobuf.abl;
import com.tencent.p177mm.protocal.protobuf.abu;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5730e;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.sns.j.a */
public final class C39739a {
    /* renamed from: a */
    public static boolean m67958a(C45316cl c45316cl, C46236n c46236n) {
        AppMethodBeat.m2504i(38035);
        if (c46236n == null) {
            C4990ab.m7420w("MicroMsg.Sns.GetFavDataSource", "fill sight favorite event fail, event is null or tlObj is null");
            c45316cl.cvA.cvG = C25738R.string.boh;
            AppMethodBeat.m2505o(38035);
            return false;
        }
        abf abf = new abf();
        abl abl = new abl();
        TimeLineObject cqu = c46236n.cqu();
        bau bau = (bau) cqu.xfI.wbK.get(0);
        if (c46236n.mo74253DI(32) && cqu.xfI.wbJ == 15) {
            cqu.xfN.fiM = c46236n.cqq().qPj;
            cqu.xfN.fiN = cqu.f15074Id;
        }
        String jV = C29036i.m46117jV(c46236n.field_snsId);
        jV = String.format("%s#%s", new Object[]{jV, bau.f17915Id});
        abl.alD(c46236n.field_userName);
        abl.alE(C1853r.m3846Yz());
        abl.mo39126LN(2);
        abl.mo39136ml(C5046bo.anU());
        abl.alI(c46236n.cqA());
        abl.alF(jV);
        abf.mo74737a(abl);
        aar aar = new aar();
        aar.akZ(jV);
        String fZ = C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id);
        String j = C29036i.m46116j(bau);
        String e = C29036i.m46108e(bau);
        if (C5046bo.isNullOrNil(C34957aq.m57415a(c46236n.cqU(), bau))) {
            C4990ab.m7420w("MicroMsg.Sns.GetFavDataSource", "this sight had no download finish, can not favorite.");
            c45316cl.cvA.cvG = C25738R.string.boy;
            AppMethodBeat.m2505o(38035);
            return false;
        } else if (C5730e.m8628ct(fZ + j)) {
            int i;
            int i2;
            if (!C5730e.m8628ct(fZ + e)) {
                i = 320;
                int i3 = 240;
                if (bau.wEK != null && bau.wEK.wFy > 0.0f && bau.wEK.wFx > 0.0f) {
                    i = (int) bau.wEK.wFx;
                    i3 = (int) bau.wEK.wFy;
                }
                Bitmap ag = C21846d.m33390ag(fZ + j, i, i3);
                if (ag == null) {
                    C4990ab.m7416i("MicroMsg.Sns.GetFavDataSource", "fav error on get thumb:" + C5730e.m8628ct(fZ + e));
                    c45316cl.cvA.cvG = C25738R.string.boy;
                    AppMethodBeat.m2505o(38035);
                    return false;
                }
                try {
                    C5056d.m7625a(ag, 60, CompressFormat.JPEG, fZ + e, true);
                } catch (Exception e2) {
                    C4990ab.printErrStackTrace("MicroMsg.Sns.GetFavDataSource", e2, "save bmp error %s", e2.getMessage());
                    C4990ab.m7416i("MicroMsg.Sns.GetFavDataSource", "fav error on save thumb:" + C5730e.m8628ct(fZ + e));
                    c45316cl.cvA.cvG = C25738R.string.boy;
                    AppMethodBeat.m2505o(38035);
                    return false;
                }
            }
            aar.akV(fZ + j);
            aar.akW(fZ + e);
            aar.akH(C5046bo.isNullOrNil(bau.wES) ? cqu.xfF : bau.wES);
            aar.alg(cqu.rCK);
            if (!C5046bo.isNullOrNil(cqu.rCK)) {
                Map z = C5049br.m7595z(cqu.rCK, "adxml");
                if (z.size() > 0) {
                    aar.akH(C5046bo.m7532bc((String) z.get(".adxml.adCanvasInfo.shareTitle"), ""));
                    aar.akI(C5046bo.m7532bc((String) z.get(".adxml.adCanvasInfo.shareDesc"), ""));
                }
            }
            i = 4;
            if (c46236n.mo74253DI(32)) {
                C21984b cqo = c46236n.cqo();
                aau aau = new aau();
                aau.fiI = C5046bo.isNullOrNil(bau.wES) ? cqu.xfF : bau.wES;
                aau.wid = bau.rEd;
                aau.fiG = bau.wEO;
                aau.fiM = cqu.xfN.fiM;
                aau.fiN = cqu.xfN.fiN;
                if (C5046bo.isNullOrNil(aau.fiN)) {
                    aau.fiN = cqu.f15074Id;
                }
                aau.fiL = C5046bo.isNullOrNil(bau.wER) ? bau.wEH : bau.wER;
                if (cqo != null && cqo.qUn == 0) {
                    aau.fiK = cqo.qUp;
                    aau.fiJ = cqo.qUo;
                }
                aar.mo27399a(aau);
                i2 = 16;
                i = 15;
            } else {
                i2 = 4;
            }
            aar.mo27394LE(i);
            C43528a WR = C21846d.m33388WR(aar.wgx);
            if (WR != null) {
                aar.mo27393LD(WR.ckU());
            } else {
                aar.mo27393LD(1);
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(aar);
            abf.mo74738aE(linkedList);
            c45316cl.cvA.cvC = abf;
            c45316cl.cvA.type = i2;
            C39739a.m67956a(aar, c46236n);
            C4990ab.m7417i("MicroMsg.Sns.GetFavDataSource", "fill event Info sight dataType %d eventType %d", Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.m2505o(38035);
            return true;
        } else {
            C4990ab.m7416i("MicroMsg.Sns.GetFavDataSource", "fav error sight: " + C5730e.m8628ct(fZ + j) + " thumb:" + C5730e.m8628ct(fZ + e));
            c45316cl.cvA.cvG = C25738R.string.boy;
            AppMethodBeat.m2505o(38035);
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m67963a(C45316cl c45316cl, String str, String str2) {
        AppMethodBeat.m2504i(38036);
        boolean b = C39739a.m67964b(c45316cl, str, str2);
        AppMethodBeat.m2505o(38036);
        return b;
    }

    /* renamed from: b */
    public static boolean m67964b(C45316cl c45316cl, String str, String str2) {
        AppMethodBeat.m2504i(38037);
        if (c45316cl == null || !C35002v.m57485Zo(str2) || str == null) {
            C4990ab.m7420w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or url is null");
            if (c45316cl != null) {
                c45316cl.cvA.cvG = C25738R.string.boh;
            }
            AppMethodBeat.m2505o(38037);
            return false;
        } else if (C13373af.cnn()) {
            C4990ab.m7420w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
            c45316cl.cvA.cvG = C25738R.string.boz;
            AppMethodBeat.m2505o(38037);
            return false;
        } else {
            C46236n YT = C21990h.m33616YT(str2);
            if (YT == null) {
                C4990ab.m7420w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                c45316cl.cvA.cvG = C25738R.string.boi;
                AppMethodBeat.m2505o(38037);
                return false;
            } else if (YT.cqu().xfI == null || YT.cqu().xfI.wbJ != 26) {
                abu abu;
                String str3 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                bau a = C34955aj.m57394a(YT, 0);
                if (a != null) {
                    str3 = a.f17915Id;
                }
                String jV = C29036i.m46117jV(YT.field_snsId);
                str3 = String.format("%s#%s", new Object[]{jV, str3});
                abf abf = new abf();
                abl abl = new abl();
                C4990ab.m7417i("MicroMsg.Sns.GetFavDataSource", "fav sns url, from %s", YT.field_userName);
                abl.alD(YT.field_userName);
                abl.alE(C1853r.m3846Yz());
                abl.mo39126LN(2);
                abl.mo39136ml(((long) YT.field_createTime) * 1000);
                abl.alI(YT.cqA());
                abl.alF(str3);
                abl.alK(str);
                aar aar = new aar();
                aar.akZ(str3);
                if (a != null) {
                    str3 = C3892an.m6198fZ(C13373af.getAccSnsPath(), a.f17915Id) + C29036i.m46108e(a);
                    if (C5730e.m8628ct(str3)) {
                        aar.akW(str3);
                    } else {
                        aar.mo27435oY(true);
                        aar.akQ(a.wEH);
                        abu = new abu();
                        abu.alT(a.wEH);
                        abf.mo74746b(abu);
                    }
                } else {
                    aar.mo27435oY(true);
                }
                aar.mo27394LE(5);
                TimeLineObject cqu = YT.cqu();
                aar.akH(cqu.xfI.Title);
                aar.akI(cqu.xfI.Desc);
                aar.alg(cqu.rCK);
                if (!C5046bo.isNullOrNil(cqu.rCK)) {
                    Map z = C5049br.m7595z(cqu.rCK, "adxml");
                    if (z.size() > 0) {
                        aar.akH(C5046bo.m7532bc((String) z.get(".adxml.adCanvasInfo.shareTitle"), ""));
                        aar.akI(C5046bo.m7532bc((String) z.get(".adxml.adCanvasInfo.shareDesc"), ""));
                    }
                }
                C39739a.m67957a(aar, cqu);
                aar.mo27434oX(true);
                abf.wiv.add(aar);
                abu = new abu();
                abu.mo27442LP(cqu.fgt);
                abf.mo74746b(abu);
                abf.mo74737a(abl);
                c45316cl.cvA.cvC = abf;
                c45316cl.cvA.desc = cqu.xfI.Title;
                c45316cl.cvA.type = 5;
                AppMethodBeat.m2505o(38037);
                return true;
            } else {
                boolean a2 = C39739a.m67960a(c45316cl, str2);
                AppMethodBeat.m2505o(38037);
                return a2;
            }
        }
    }

    /* renamed from: a */
    public static boolean m67962a(C45316cl c45316cl, String str, CharSequence charSequence) {
        AppMethodBeat.m2504i(38038);
        if (C35002v.m57486Zp(str) || charSequence == null) {
            C4990ab.m7420w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or text is null");
            c45316cl.cvA.cvG = C25738R.string.boh;
            AppMethodBeat.m2505o(38038);
            return false;
        } else if (C13373af.cnn()) {
            C4990ab.m7420w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
            c45316cl.cvA.cvG = C25738R.string.boz;
            AppMethodBeat.m2505o(38038);
            return false;
        } else {
            C46236n YT = C13373af.cnF().mo62918YT(str);
            if (YT == null) {
                C4990ab.m7420w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                c45316cl.cvA.cvG = C25738R.string.boi;
                AppMethodBeat.m2505o(38038);
                return false;
            } else if (0 == YT.field_snsId) {
                C4990ab.m7420w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo.field_snsId is 0");
                c45316cl.cvA.cvG = C25738R.string.bog;
                AppMethodBeat.m2505o(38038);
                return false;
            } else {
                String jV = C29036i.m46117jV(YT.field_snsId);
                jV = String.format("%s#0", new Object[]{jV});
                abf abf = new abf();
                abl abl = new abl();
                C4990ab.m7417i("MicroMsg.Sns.GetFavDataSource", "fav sns text, from %s", YT.field_userName);
                abl.alD(YT.field_userName);
                abl.alE(C1853r.m3846Yz());
                abl.mo39126LN(2);
                abl.mo39136ml(((long) YT.field_createTime) * 1000);
                abl.alI(YT.cqA());
                abl.alF(jV);
                abf.mo74737a(abl);
                c45316cl.cvA.cvC = abf;
                c45316cl.cvA.desc = charSequence.toString();
                c45316cl.cvA.type = 1;
                AppMethodBeat.m2505o(38038);
                return true;
            }
        }
    }

    /* renamed from: a */
    public static boolean m67959a(C45316cl c45316cl, C46236n c46236n, String str) {
        AppMethodBeat.m2504i(38039);
        if (c45316cl == null || C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or media id is null");
            if (c45316cl != null) {
                c45316cl.cvA.cvG = C25738R.string.boh;
            }
            AppMethodBeat.m2505o(38039);
            return false;
        } else if (c46236n == null) {
            C4990ab.m7420w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
            c45316cl.cvA.cvG = C25738R.string.boi;
            AppMethodBeat.m2505o(38039);
            return false;
        } else {
            bau a = C34955aj.m57395a(c46236n, str);
            if (a == null) {
                C4990ab.m7420w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, mediaObj is null");
                c45316cl.cvA.cvG = C25738R.string.boi;
                AppMethodBeat.m2505o(38039);
                return false;
            }
            String jV = C29036i.m46117jV(c46236n.field_snsId);
            jV = String.format("%s#%s", new Object[]{jV, str});
            abf abf = new abf();
            abl abl = new abl();
            aar aar = new aar();
            C4990ab.m7417i("MicroMsg.Sns.GetFavDataSource", "fav sns image, from %s", c46236n.field_userName);
            abl.alD(c46236n.field_userName);
            abl.alE(C1853r.m3846Yz());
            abl.mo39126LN(2);
            abl.mo39136ml(((long) c46236n.field_createTime) * 1000);
            abl.alI(c46236n.cqA());
            abl.alF(jV);
            aar.akZ(jV);
            aar.akV(C3892an.m6198fZ(C13373af.getAccSnsPath(), str) + C29036i.m46121l(a));
            if (c46236n.cqu() != null) {
                aar.alg(c46236n.cqu().rCK);
                if (!C5046bo.isNullOrNil(c46236n.cqu().rCK)) {
                    Map z = C5049br.m7595z(c46236n.cqu().rCK, "adxml");
                    if (z.size() > 0) {
                        aar.akH(C5046bo.m7532bc((String) z.get(".adxml.adCanvasInfo.shareTitle"), ""));
                        aar.akI(C5046bo.m7532bc((String) z.get(".adxml.adCanvasInfo.shareDesc"), ""));
                    }
                }
            }
            C39739a.m67956a(aar, c46236n);
            jV = C3892an.m6198fZ(C13373af.getAccSnsPath(), a.f17915Id) + C29036i.m46108e(a);
            if (C5730e.m8628ct(aar.wgx) || !c46236n.field_userName.endsWith(C13373af.cnk())) {
                if (C5730e.m8628ct(jV)) {
                    aar.akW(jV);
                } else {
                    aar.mo27435oY(true);
                    aar.akQ(a.wEH);
                    abu abu = new abu();
                    abu.alT(a.wEH);
                    abf.mo74746b(abu);
                }
                aar.mo27394LE(2);
                abf.wiv.add(aar);
                abf.mo74737a(abl);
                c45316cl.cvA.cvC = abf;
                c45316cl.cvA.type = 2;
                AppMethodBeat.m2505o(38039);
                return true;
            }
            C4990ab.m7420w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, mediaObj is null");
            c45316cl.cvA.cvG = C25738R.string.boi;
            AppMethodBeat.m2505o(38039);
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m67961a(C45316cl c45316cl, String str, int i) {
        AppMethodBeat.m2504i(38040);
        if (C35002v.m57486Zp(str) || i < 0) {
            C4990ab.m7420w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or position errro");
            c45316cl.cvA.cvG = C25738R.string.boh;
            AppMethodBeat.m2505o(38040);
            return false;
        } else if (C13373af.cnn()) {
            C4990ab.m7420w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
            c45316cl.cvA.cvG = C25738R.string.boz;
            AppMethodBeat.m2505o(38040);
            return false;
        } else {
            C46236n YT = C13373af.cnF().mo62918YT(str);
            if (YT == null) {
                C4990ab.m7420w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                c45316cl.cvA.cvG = C25738R.string.boi;
                AppMethodBeat.m2505o(38040);
                return false;
            }
            bau a = C34955aj.m57394a(YT, i);
            if (a == null) {
                C4990ab.m7420w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, media obj is null");
                c45316cl.cvA.cvG = C25738R.string.boi;
                AppMethodBeat.m2505o(38040);
                return false;
            }
            boolean a2 = C39739a.m67959a(c45316cl, YT, a.f17915Id);
            AppMethodBeat.m2505o(38040);
            return a2;
        }
    }

    /* renamed from: a */
    private static void m67957a(aar aar, TimeLineObject timeLineObject) {
        AppMethodBeat.m2504i(38041);
        if (!(aar == null || timeLineObject == null || C5046bo.isNullOrNil(timeLineObject.rjC))) {
            aar.alf(timeLineObject.rjC);
        }
        AppMethodBeat.m2505o(38041);
    }

    /* renamed from: a */
    public static void m67956a(aar aar, C46236n c46236n) {
        AppMethodBeat.m2504i(38042);
        if (c46236n != null) {
            C39739a.m67957a(aar, c46236n.cqu());
        }
        AppMethodBeat.m2505o(38042);
    }

    /* renamed from: a */
    public static boolean m67960a(C45316cl c45316cl, String str) {
        int i = 0;
        AppMethodBeat.m2504i(38043);
        if (c45316cl == null || !C35002v.m57485Zo(str)) {
            C4990ab.m7420w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or url is null");
            if (c45316cl != null) {
                c45316cl.cvA.cvG = C25738R.string.boh;
            }
            AppMethodBeat.m2505o(38043);
            return false;
        } else if (C13373af.cnn()) {
            C4990ab.m7420w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
            c45316cl.cvA.cvG = C25738R.string.boz;
            AppMethodBeat.m2505o(38043);
            return false;
        } else {
            C46236n YT = C21990h.m33616YT(str);
            if (YT == null) {
                C4990ab.m7420w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                c45316cl.cvA.cvG = C25738R.string.boi;
                AppMethodBeat.m2505o(38043);
                return false;
            }
            String str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            bau a = C34955aj.m57394a(YT, 0);
            if (a != null) {
                str2 = a.f17915Id;
            }
            str2 = String.format("%s#%s", new Object[]{C29036i.m46117jV(YT.field_snsId), str2});
            abl abl = new abl();
            TimeLineObject cqu = YT.cqu();
            if (cqu == null) {
                C4990ab.m7416i("MicroMsg.Sns.GetFavDataSource", "fav NoteLink, tlObj is null , return");
                AppMethodBeat.m2505o(38043);
                return false;
            }
            C4990ab.m7417i("MicroMsg.Sns.GetFavDataSource", "fav NoteLink, from %s", YT.field_userName);
            abl.alD(YT.field_userName);
            abl.alE(C1853r.m3846Yz());
            abl.mo39126LN(2);
            abl.mo39136ml(((long) YT.field_createTime) * 1000);
            abl.alI(YT.cqA());
            abl.alF(str2);
            C37721gh c37721gh = new C37721gh();
            c37721gh.cAH.type = 30;
            c37721gh.cAH.cAO = 4;
            c37721gh.cAH.desc = cqu.xfI.wbM;
            C4879a.xxA.mo10055m(c37721gh);
            c37721gh.cAH.cvC.mo74737a(abl);
            c45316cl.cvA.cvC = c37721gh.cAH.cvC;
            if (c45316cl.cvA.cvC != null) {
                LinkedList linkedList = c45316cl.cvA.cvC.wiv;
                if (linkedList != null) {
                    while (i < linkedList.size()) {
                        aar aar = (aar) linkedList.get(i);
                        if (aar != null) {
                            aar.mo27434oX(true);
                            aar.mo27435oY(true);
                        }
                        i++;
                    }
                }
            }
            c45316cl.cvA.desc = cqu.xfI.Title;
            c45316cl.cvA.type = 18;
            AppMethodBeat.m2505o(38043);
            return true;
        }
    }
}
