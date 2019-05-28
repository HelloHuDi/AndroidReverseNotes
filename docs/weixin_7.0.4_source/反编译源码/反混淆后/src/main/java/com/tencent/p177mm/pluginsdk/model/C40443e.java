package com.tencent.p177mm.pluginsdk.model;

import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.modelvoice.C26497b;
import com.tencent.p177mm.modelvoice.C32850q;
import com.tencent.p177mm.modelvoice.C42230n;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p181af.C1192l;
import com.tencent.p177mm.p181af.C32223o;
import com.tencent.p177mm.p181af.C32224p;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.C37478f;
import com.tencent.p177mm.p230g.p231a.C18348nt;
import com.tencent.p177mm.p230g.p231a.C37721gh;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p249m.C42164b;
import com.tencent.p177mm.p612ui.tools.C5584f;
import com.tencent.p177mm.plugin.biz.p1395a.C27500a;
import com.tencent.p177mm.plugin.fav.p410ui.C45932c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.plugin.record.C34797b;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.protocal.p1338b.p1339a.C44099c;
import com.tencent.p177mm.protocal.protobuf.aap;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.aas;
import com.tencent.p177mm.protocal.protobuf.aat;
import com.tencent.p177mm.protocal.protobuf.aau;
import com.tencent.p177mm.protocal.protobuf.aay;
import com.tencent.p177mm.protocal.protobuf.abe;
import com.tencent.p177mm.protocal.protobuf.abf;
import com.tencent.p177mm.protocal.protobuf.abl;
import com.tencent.p177mm.protocal.protobuf.abo;
import com.tencent.p177mm.protocal.protobuf.abt;
import com.tencent.p177mm.protocal.protobuf.abu;
import com.tencent.p177mm.protocal.protobuf.cfh;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C15428j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.tencent.mm.pluginsdk.model.e */
public final class C40443e {
    /* renamed from: a */
    public static boolean m69370a(C45316cl c45316cl, Intent intent) {
        AppMethodBeat.m2504i(27237);
        if (c45316cl == null) {
            C4990ab.m7420w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null");
            AppMethodBeat.m2505o(27237);
            return false;
        }
        double doubleExtra = intent.getDoubleExtra("kwebmap_slat", 0.0d);
        double doubleExtra2 = intent.getDoubleExtra("kwebmap_lng", 0.0d);
        int intExtra = intent.getIntExtra("kwebmap_scale", 0);
        String bc = C5046bo.m7532bc(intent.getStringExtra("Kwebmap_locaion"), "");
        String stringExtra = intent.getStringExtra("kPoiName");
        intent.getCharSequenceExtra("kRemark");
        intent.getStringArrayListExtra("kTags");
        aay aay = new aay();
        aay.alu(bc);
        aay.mo15621E(doubleExtra);
        aay.mo15620D(doubleExtra2);
        aay.mo15622LJ(intExtra);
        aay.alv(stringExtra);
        abf abf = new abf();
        abl abl = new abl();
        String Yz = C1853r.m3846Yz();
        abl.alD(Yz);
        abl.alE(Yz);
        abl.mo39126LN(6);
        abl.mo39136ml(C5046bo.anU());
        abf.mo74743b(aay);
        abf.mo74737a(abl);
        c45316cl.cvA.cvC = abf;
        c45316cl.cvA.type = 6;
        AppMethodBeat.m2505o(27237);
        return true;
    }

    /* renamed from: a */
    public static boolean m69373a(C45316cl c45316cl, String str, String str2, String str3) {
        AppMethodBeat.m2504i(27238);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
            c45316cl.cvA.cvG = C25738R.string.boh;
            AppMethodBeat.m2505o(27238);
            return false;
        }
        C4990ab.m7411d("MicroMsg.GetFavDataSource", "do fill event info(fav simple file), title %s, desc %s, path %s, sourceType %d", str2, str3, str, Integer.valueOf(13));
        if (new C5728b(str).length() > ((long) C42164b.m74341Nc())) {
            c45316cl.cvA.cvG = C25738R.string.bs4;
            AppMethodBeat.m2505o(27238);
            return false;
        }
        abf abf = new abf();
        abl abl = new abl();
        aar aar = new aar();
        aar.akV(str);
        aar.mo27394LE(8);
        aar.akR(C5730e.m8630cv(str));
        aar.mo27435oY(true);
        aar.akH(str2);
        aar.akI(str3);
        abl.alD(C1853r.m3846Yz());
        abl.alE(C1853r.m3846Yz());
        abl.mo39126LN(13);
        abl.mo39136ml(C5046bo.anU());
        abf.mo74737a(abl);
        abf.wiv.add(aar);
        c45316cl.cvA.title = aar.title;
        c45316cl.cvA.desc = aar.title;
        c45316cl.cvA.cvC = abf;
        c45316cl.cvA.type = 8;
        AppMethodBeat.m2505o(27238);
        return true;
    }

    /* renamed from: b */
    public static boolean m69375b(C45316cl c45316cl, String str, int i) {
        AppMethodBeat.m2504i(27239);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
            c45316cl.cvA.cvG = C25738R.string.boh;
            AppMethodBeat.m2505o(27239);
            return false;
        }
        C4990ab.m7411d("MicroMsg.GetFavDataSource", "do fill event info(fav simple text), %s, sourceType %d", str, Integer.valueOf(i));
        abf abf = new abf();
        abl abl = new abl();
        abl.alD(C1853r.m3846Yz());
        abl.alE(C1853r.m3846Yz());
        abl.mo39126LN(i);
        abl.mo39136ml(C5046bo.anU());
        abf.mo74737a(abl);
        c45316cl.cvA.desc = str;
        c45316cl.cvA.cvC = abf;
        c45316cl.cvA.type = 1;
        AppMethodBeat.m2505o(27239);
        return true;
    }

    /* renamed from: a */
    public static boolean m69368a(C45316cl c45316cl, int i, String str) {
        AppMethodBeat.m2504i(27240);
        if (c45316cl == null || C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
            if (c45316cl != null) {
                c45316cl.cvA.cvG = C25738R.string.boh;
            }
            AppMethodBeat.m2505o(27240);
            return false;
        }
        C4990ab.m7417i("MicroMsg.GetFavDataSource", "do fill event info(fav simple image), path %s sourceType %d", str, Integer.valueOf(i));
        abf abf = new abf();
        abl abl = new abl();
        aar aar = new aar();
        aar.mo27394LE(2);
        aar.akV(str);
        aar.akU(C1178g.m2591x((aar.toString() + 2 + System.currentTimeMillis()).getBytes()));
        C37721gh c37721gh = new C37721gh();
        c37721gh.cAH.type = 27;
        c37721gh.cAH.cAJ = aar;
        C4879a.xxA.mo10055m(c37721gh);
        String str2 = c37721gh.cAI.thumbPath;
        C5056d.m7656c(str, 150, 150, CompressFormat.JPEG, 90, str2);
        aar.akW(str2);
        abl.alD(C1853r.m3846Yz());
        abl.alE(C1853r.m3846Yz());
        abl.mo39126LN(i);
        abl.mo39136ml(C5046bo.anU());
        abf.mo74737a(abl);
        abf.wiv.add(aar);
        c45316cl.cvA.title = aar.title;
        c45316cl.cvA.cvC = abf;
        c45316cl.cvA.type = 2;
        AppMethodBeat.m2505o(27240);
        return true;
    }

    /* renamed from: a */
    public static boolean m69369a(C45316cl c45316cl, long j) {
        AppMethodBeat.m2504i(27241);
        boolean d = C40443e.m69377d(c45316cl, ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(j));
        AppMethodBeat.m2505o(27241);
        return d;
    }

    /* renamed from: d */
    public static boolean m69377d(C45316cl c45316cl, C7620bi c7620bi) {
        boolean z = false;
        AppMethodBeat.m2504i(27242);
        if (c45316cl == null || c7620bi == null) {
            C4990ab.m7420w("MicroMsg.GetFavDataSource", "fill favorite event fail, event or msg is null");
            if (c45316cl != null) {
                c45316cl.cvA.cvG = C25738R.string.boh;
            }
            AppMethodBeat.m2505o(27242);
        } else {
            C7620bi ar = C7620bi.m13569ar(c7620bi);
            if (ar.isText()) {
                z = C40443e.m69379e(c45316cl, ar);
            } else if (ar.drD()) {
                z = C40443e.m69381g(c45316cl, ar);
            } else if (ar.bAC()) {
                z = C40443e.m69372a(c45316cl, ar);
            } else if (ar.drE()) {
                z = C40443e.m69380f(c45316cl, ar);
            } else if (ar.bws() || ar.bwt()) {
                z = C40443e.m69382h(c45316cl, ar);
            } else if (ar.drC()) {
                z = C40443e.m69376c(c45316cl, ar);
            } else if (ar.dtw() || !ar.bAA() || ar.dty()) {
                c45316cl.cvA.cvG = C25738R.string.bop;
            } else {
                z = C40443e.m69384i(c45316cl, ar);
            }
            c45316cl.cvA.cvq = ar.field_content;
            if (z || c45316cl.cvA.cvG == 0) {
                C45932c.m85255a(ar, c45316cl, z);
            }
            AppMethodBeat.m2505o(27242);
        }
        return z;
    }

    /* renamed from: ak */
    private static abl m69374ak(C7620bi c7620bi) {
        AppMethodBeat.m2504i(27243);
        abl abl = new abl();
        if (c7620bi.field_isSend == 1) {
            abl.alD(C1853r.m3846Yz());
            abl.alE(c7620bi.field_talker);
            if (C1855t.m3896kH(c7620bi.field_talker)) {
                abl.alG(abl.cEV);
            }
        } else {
            abl.alD(c7620bi.field_talker);
            abl.alE(C1853r.m3846Yz());
            if (C1855t.m3896kH(c7620bi.field_talker)) {
                String substring;
                if (c7620bi.field_content != null) {
                    substring = c7620bi.field_content.substring(0, Math.max(0, c7620bi.field_content.indexOf(58)));
                } else {
                    substring = "";
                }
                abl.alG(substring);
                if (!(C5046bo.isNullOrNil(abl.whU) || c7620bi.drD())) {
                    c7620bi.setContent(c7620bi.field_content.substring(abl.whU.length() + 1));
                    if (c7620bi.field_content.length() > 0 && 10 == c7620bi.field_content.charAt(0)) {
                        c7620bi.setContent(c7620bi.field_content.substring(1));
                    }
                    if (c7620bi.dtF()) {
                        c7620bi.mo14797jx(c7620bi.field_transContent.substring(abl.whU.length() + 1));
                        if (c7620bi.field_transContent.length() > 0 && 10 == c7620bi.field_transContent.charAt(0)) {
                            c7620bi.mo14797jx(c7620bi.field_transContent.substring(1));
                        }
                    }
                }
            }
        }
        abl.mo39126LN(1);
        abl.mo39136ml(c7620bi.field_createTime);
        abl.alH(c7620bi.field_msgSvrId);
        if (c7620bi.field_msgSvrId > 0) {
            abl.alF(c7620bi.field_msgSvrId);
        }
        AppMethodBeat.m2505o(27243);
        return abl;
    }

    /* renamed from: e */
    private static boolean m69379e(C45316cl c45316cl, C7620bi c7620bi) {
        AppMethodBeat.m2504i(27244);
        abf abf = new abf();
        abf.mo74737a(C40443e.m69374ak(c7620bi));
        c45316cl.cvA.cvC = abf;
        c45316cl.cvA.desc = c7620bi.field_content;
        c45316cl.cvA.type = 1;
        if (C5584f.asg(c45316cl.cvA.desc) > C42164b.m74337MY()) {
            c45316cl.cvA.cvG = C25738R.string.bs2;
            AppMethodBeat.m2505o(27244);
            return false;
        }
        AppMethodBeat.m2505o(27244);
        return true;
    }

    /* renamed from: f */
    private static boolean m69380f(C45316cl c45316cl, C7620bi c7620bi) {
        AppMethodBeat.m2504i(27245);
        C25822e c25822e = null;
        if (c7620bi.field_msgId > 0) {
            c25822e = C32291o.ahl().mo73113fJ(c7620bi.field_msgId);
        }
        if ((c25822e == null || c25822e.fDy <= 0) && c7620bi.field_msgSvrId > 0) {
            c25822e = C32291o.ahl().mo73112fI(c7620bi.field_msgSvrId);
        }
        if (c25822e == null) {
            C4990ab.m7420w("MicroMsg.GetFavDataSource", "getImgDataPath: try get imgInfo fail");
            c45316cl.cvA.cvG = C25738R.string.bon;
            AppMethodBeat.m2505o(27245);
            return false;
        }
        abf abf = new abf();
        abf.mo74737a(C40443e.m69374ak(c7620bi));
        aar aar = new aar();
        C40443e.m69367a(aar, c7620bi);
        aar.mo27394LE(2);
        aar.akV(C32291o.ahl().mo73118q(C37478f.m63227c(c25822e), "", ""));
        if (c25822e.agQ()) {
            c25822e = C32291o.ahl().mo73116ly(c25822e.fDJ);
            if (c25822e.frO > c25822e.offset) {
                aar.akV(C32291o.ahl().mo73118q("SERVERID://" + c7620bi.field_msgSvrId, "", ""));
            }
        }
        aar.akW(C32291o.ahl().mo73074I(c7620bi.field_imgPath, true));
        LinkedList linkedList = new LinkedList();
        linkedList.add(aar);
        abf.mo74738aE(linkedList);
        c45316cl.cvA.cvC = abf;
        c45316cl.cvA.type = 2;
        AppMethodBeat.m2505o(27245);
        return true;
    }

    /* renamed from: a */
    private static boolean m69372a(C45316cl c45316cl, C7620bi c7620bi) {
        AppMethodBeat.m2504i(27246);
        abf abf = new abf();
        abf.mo74737a(C40443e.m69374ak(c7620bi));
        Map z = C5049br.m7595z(c7620bi.field_content, "msg");
        if (z != null) {
            try {
                aay aay = new aay();
                aay.alu((String) z.get(".msg.location.$label"));
                aay.mo15621E(Double.parseDouble((String) z.get(".msg.location.$x")));
                aay.mo15620D(Double.parseDouble((String) z.get(".msg.location.$y")));
                aay.mo15622LJ(Integer.valueOf((String) z.get(".msg.location.$scale")).intValue());
                aay.alv((String) z.get(".msg.location.$poiname"));
                abf.mo74743b(aay);
                c45316cl.cvA.type = 6;
                c45316cl.cvA.cvC = abf;
                AppMethodBeat.m2505o(27246);
                return true;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.GetFavDataSource", "parse failed, %s", e.getStackTrace().toString());
            }
        }
        c45316cl.cvA.cvG = C25738R.string.bor;
        AppMethodBeat.m2505o(27246);
        return false;
    }

    /* renamed from: g */
    private static boolean m69381g(C45316cl c45316cl, C7620bi c7620bi) {
        AppMethodBeat.m2504i(27248);
        abf abf = new abf();
        abf.mo74737a(C40443e.m69374ak(c7620bi));
        aar aar = new aar();
        C40443e.m69367a(aar, c7620bi);
        if (C1855t.m3953nv(c7620bi.field_talker)) {
            aar.akV(C40443e.aiy(c7620bi.field_imgPath));
        } else {
            aar.akV(C32850q.getFullPath(c7620bi.field_imgPath));
        }
        aar.mo27394LE(3);
        aar.mo27435oY(true);
        C26497b uN = C32850q.m53727uN(c7620bi.field_imgPath);
        if (uN == null) {
            AppMethodBeat.m2505o(27248);
            return false;
        }
        aar.akR(C40443e.m69363Kp(uN.getFormat()));
        aar.mo27393LD((int) new C42230n(c7620bi.field_content).time);
        LinkedList linkedList = new LinkedList();
        linkedList.add(aar);
        abf.mo74738aE(linkedList);
        c45316cl.cvA.cvC = abf;
        c45316cl.cvA.type = 3;
        AppMethodBeat.m2505o(27248);
        return true;
    }

    private static String aiy(String str) {
        AppMethodBeat.m2504i(27249);
        String b = C15428j.m23709b(C34797b.m57159XZ(), "recbiz_", str, ".rec", 2);
        if (C5046bo.isNullOrNil(b)) {
            AppMethodBeat.m2505o(27249);
            return null;
        } else if (new C5728b(b).exists()) {
            AppMethodBeat.m2505o(27249);
            return b;
        } else {
            AppMethodBeat.m2505o(27249);
            return b;
        }
    }

    /* renamed from: Kp */
    public static String m69363Kp(int i) {
        if (i == 1) {
            return "speex";
        }
        if (i == 4) {
            return "silk";
        }
        return "amr";
    }

    /* renamed from: h */
    private static boolean m69382h(C45316cl c45316cl, C7620bi c7620bi) {
        AppMethodBeat.m2504i(27250);
        abf abf = new abf();
        abf.mo74737a(C40443e.m69374ak(c7620bi));
        aar aar = new aar();
        C40443e.m69367a(aar, c7620bi);
        C37961o.all();
        aar.akW(C9720t.m17304ui(c7620bi.field_imgPath));
        aar.akR(C5730e.m8630cv(aar.wgx));
        C26493s ut = C26494u.m42268ut(c7620bi.field_imgPath);
        if (ut == null) {
            C4990ab.m7420w("MicroMsg.GetFavDataSource", "[doFileFavVideoEventInfo] null == info");
            c45316cl.cvA.cvG = C25738R.string.bog;
            AppMethodBeat.m2505o(27250);
            return false;
        }
        C4990ab.m7417i("MicroMsg.GetFavDataSource", "video length is %d", Integer.valueOf(ut.frO));
        if (ut.frO > C42164b.m74341Nc()) {
            c45316cl.cvA.cvG = C25738R.string.bs4;
            AppMethodBeat.m2505o(27250);
            return false;
        } else if (c7620bi.bwt() && C26494u.m42270uv(ut.getFileName())) {
            c45316cl.cvA.cvG = C25738R.string.bog;
            AppMethodBeat.m2505o(27250);
            return false;
        } else {
            if (ut.alz()) {
                C37961o.all();
                C4990ab.m7417i("MicroMsg.GetFavDataSource", "this video had finish download, set orgn path [%s]", C9720t.m17303uh(c7620bi.field_imgPath));
                aar.akV(r5);
            } else {
                C4990ab.m7416i("MicroMsg.GetFavDataSource", "this video had not finish download, set orgn path null");
                aar.akV("");
            }
            aar.mo27393LD(ut.fXd);
            LinkedList linkedList = new LinkedList();
            linkedList.add(aar);
            abf.mo74738aE(linkedList);
            c45316cl.cvA.cvC = abf;
            if (c7620bi.bwt()) {
                c45316cl.cvA.type = 16;
                aar.mo27394LE(15);
            } else {
                c45316cl.cvA.type = 4;
                aar.mo27394LE(4);
            }
            C26493s ut2 = C26494u.m42268ut(c7620bi.field_imgPath);
            aar.alf(ut2.cMn);
            cfh cfh = ut2.fXm;
            if (!(cfh == null || C5046bo.isNullOrNil(cfh.fiM))) {
                aau aau = new aau();
                aau.fiG = cfh.fiG;
                aau.wid = cfh.wid;
                aau.fiJ = cfh.fiJ;
                aau.fiK = cfh.fiK;
                aau.fiI = cfh.fiI;
                aau.fiL = cfh.fiL;
                aau.fiM = cfh.fiM;
                aau.fiN = cfh.fiN;
                aar.mo27399a(aau);
            }
            AppMethodBeat.m2505o(27250);
            return true;
        }
    }

    /* renamed from: a */
    private static aar m69365a(C7620bi c7620bi, C8910b c8910b, int i) {
        AppMethodBeat.m2504i(27251);
        aar aar = new aar();
        C40443e.m69367a(aar, c7620bi);
        aar.akO(c8910b.fgM);
        aar.akP(c8910b.fgN);
        aar.akN(c8910b.url);
        aar.mo27434oX(true);
        C5728b c5728b = new C5728b(C5046bo.m7532bc(C32291o.ahl().mo73074I(c7620bi.field_imgPath, true), ""));
        if (c5728b.exists()) {
            aar.akW(C5736j.m8649w(c5728b.dMD()));
        } else {
            aar.mo27435oY(true);
        }
        aar.akH(c8910b.title);
        aar.akI(c8910b.description);
        aar.alg(c8910b.canvasPageXml);
        aar.mo27394LE(i);
        aar.alf(c8910b.cMn);
        AppMethodBeat.m2505o(27251);
        return aar;
    }

    /* renamed from: i */
    private static boolean m69384i(C45316cl c45316cl, C7620bi c7620bi) {
        AppMethodBeat.m2504i(27252);
        abf abf = new abf();
        abf.mo74737a(C40443e.m69374ak(c7620bi));
        String str = c7620bi.field_content;
        if (str == null) {
            c45316cl.cvA.cvG = C25738R.string.bor;
            AppMethodBeat.m2505o(27252);
            return false;
        }
        C8910b me = C8910b.m16064me(str);
        if (me == null) {
            c45316cl.cvA.cvG = C25738R.string.bor;
            AppMethodBeat.m2505o(27252);
            return false;
        }
        c45316cl.cvA.cvC = abf;
        abl abl = abf.wit;
        abl.alJ(me.appId);
        abl.alL(me.cMg);
        C30065b aiE;
        aar aar;
        String I;
        aar a;
        abe abe;
        switch (me.type) {
            case 1:
                c45316cl.cvA.cvC = abf;
                c45316cl.cvA.desc = me.title;
                c45316cl.cvA.type = 1;
                AppMethodBeat.m2505o(27252);
                return true;
            case 2:
                if (C1720g.m3536RP().isSDCardAvailable()) {
                    aiE = C34832a.aUq().aiE(me.csD);
                    aar = new aar();
                    C40443e.m69367a(aar, c7620bi);
                    if (aiE != null) {
                        aar.akV(aiE.field_fileFullPath);
                    }
                    I = C32291o.ahl().mo73074I(c7620bi.field_imgPath, true);
                    if (C5730e.m8628ct(I)) {
                        aar.akW(I);
                    }
                    aar.mo27394LE(2);
                    aar.akH(me.title);
                    aar.akI(me.description);
                    abf.wiv.add(aar);
                    c45316cl.cvA.type = 2;
                    AppMethodBeat.m2505o(27252);
                    return true;
                }
                c45316cl.cvA.cvG = C25738R.string.box;
                AppMethodBeat.m2505o(27252);
                return false;
            case 3:
                abf.wiv.add(C40443e.m69365a(c7620bi, me, 7));
                c45316cl.cvA.type = 7;
                AppMethodBeat.m2505o(27252);
                return true;
            case 4:
                a = C40443e.m69365a(c7620bi, me, 4);
                abf.alB(a.title);
                abf.alC(a.desc);
                abf.wiv.add(a);
                c45316cl.cvA.type = 4;
                AppMethodBeat.m2505o(27252);
                return true;
            case 5:
                if (me.url == null || me.url.equals("")) {
                    c45316cl.cvA.cvG = C25738R.string.bol;
                    AppMethodBeat.m2505o(27252);
                    return false;
                }
                abf.wit.alK(me.url);
                if (!C5046bo.isNullOrNil(me.thumburl)) {
                    abu abu = new abu();
                    abu.alT(me.thumburl);
                    abf.mo74746b(abu);
                }
                a = C40443e.m69365a(c7620bi, me, 5);
                abf.wiv.add(a);
                abf.alB(a.title);
                abf.alC(a.desc);
                c45316cl.cvA.type = 5;
                AppMethodBeat.m2505o(27252);
                return true;
            case 6:
                if (C1720g.m3536RP().isSDCardAvailable()) {
                    aiE = C34832a.aUq().aiE(me.csD);
                    aar = new aar();
                    if (aiE != null) {
                        aar.akV(aiE.field_fileFullPath);
                    }
                    C40443e.m69367a(aar, c7620bi);
                    aar.mo27394LE(8);
                    aar.akR(me.fgp);
                    I = C32291o.ahl().mo73074I(c7620bi.field_imgPath, true);
                    if (C5046bo.isNullOrNil(I)) {
                        aar.mo27435oY(true);
                    }
                    if (C5730e.m8628ct(I)) {
                        aar.akW(I);
                    }
                    aar.akH(me.title);
                    aar.akI(me.description);
                    abf.wiv.add(aar);
                    c45316cl.cvA.desc = me.title;
                    c45316cl.cvA.type = 8;
                    AppMethodBeat.m2505o(27252);
                    return true;
                }
                c45316cl.cvA.cvG = C25738R.string.box;
                AppMethodBeat.m2505o(27252);
                return false;
            case 7:
                if (me.csD == null || me.csD.length() == 0) {
                    c45316cl.cvA.cvG = C25738R.string.boi;
                } else if (!C1720g.m3536RP().isSDCardAvailable()) {
                    c45316cl.cvA.cvG = C25738R.string.box;
                    AppMethodBeat.m2505o(27252);
                    return false;
                }
                c45316cl.cvA.cvG = C25738R.string.bop;
                AppMethodBeat.m2505o(27252);
                return false;
            case 10:
                abe = new abe();
                abe.alw(me.title);
                abe.alx(me.description);
                abe.mo27436LK(me.fgP);
                abe.alz(me.fgQ);
                abe.aly(me.thumburl);
                c45316cl.cvA.title = me.title;
                c45316cl.cvA.desc = me.description;
                c45316cl.cvA.type = 10;
                abf.mo74744b(abe);
                AppMethodBeat.m2505o(27252);
                return true;
            case 13:
                abe = new abe();
                abe.alw(me.title);
                abe.alx(me.description);
                abe.mo27436LK(me.fgV);
                abe.alz(me.fgW);
                abe.aly(me.thumburl);
                c45316cl.cvA.title = me.title;
                c45316cl.cvA.desc = me.description;
                c45316cl.cvA.type = 11;
                abf.mo74744b(abe);
                AppMethodBeat.m2505o(27252);
                return true;
            case 19:
            case 24:
                c45316cl.cvA.cvD = new abt();
                boolean a2 = C40443e.m69371a(c45316cl, me, abf, c7620bi);
                AppMethodBeat.m2505o(27252);
                return a2;
            case 20:
                abo abo = new abo();
                abo.alM(me.title);
                abo.alN(me.description);
                abo.alP(me.fgT);
                abo.alO(me.thumburl);
                c45316cl.cvA.title = me.title;
                c45316cl.cvA.desc = me.description;
                c45316cl.cvA.type = 15;
                abf.mo74745b(abo);
                AppMethodBeat.m2505o(27252);
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
                C40443e.m69367a(aar, c7620bi);
                aar.mo27394LE(19);
                String I2 = C32291o.ahl().mo73074I(c7620bi.field_imgPath, true);
                if (C5046bo.isNullOrNil(I2)) {
                    aar.mo27435oY(true);
                }
                if (C5730e.m8628ct(I2)) {
                    aar.akW(I2);
                }
                aar.akH(me.title);
                aar.akI(me.description);
                abf.wiv.add(aar);
                c45316cl.cvA.title = me.title;
                c45316cl.cvA.desc = me.description;
                c45316cl.cvA.type = 19;
                abf.mo74742b(aap);
                AppMethodBeat.m2505o(27252);
                return true;
            default:
                c45316cl.cvA.cvG = C25738R.string.bop;
                AppMethodBeat.m2505o(27252);
                return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x010f A:{Catch:{ Exception -> 0x0114 }} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00af A:{Catch:{ Exception -> 0x0114 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    private static boolean m69376c(C45316cl c45316cl, C7620bi c7620bi) {
        AppMethodBeat.m2504i(27253);
        abf abf = new abf();
        abl ak = C40443e.m69374ak(c7620bi);
        abf.mo74737a(ak);
        try {
            C32223o b = ((C27500a) C1720g.m3528K(C27500a.class)).mo35246b(c7620bi.field_msgId, c7620bi.field_content);
            LinkedList linkedList = b.fjr;
            ak.alL(b.cMg);
            if (linkedList != null && linkedList.size() > c45316cl.cvA.cvE) {
                C4990ab.m7417i("MicroMsg.GetFavDataSource", "favorite biz msg, index is %d", Integer.valueOf(c45316cl.cvA.cvE));
                C32224p c32224p = (C32224p) linkedList.get(c45316cl.cvA.cvE);
                if (C1192l.m2624mg(c32224p.fjC)) {
                    c45316cl.cvA.cvG = C25738R.string.bop;
                    AppMethodBeat.m2505o(27253);
                    return false;
                }
                String ack;
                ak.alK(c32224p.url);
                if (c45316cl.cvA.cvE > 0) {
                    ak.alF("");
                }
                aar aar = new aar();
                aar.akH(c32224p.title);
                aar.akI(c32224p.fjz);
                C40443e.m69367a(aar, c7620bi);
                String a = C1192l.m2619a(c32224p);
                if (C5046bo.isNullOrNil(a)) {
                    C17880h qo = C17884o.act().mo33392qo(c7620bi.field_talker);
                    if (qo != null) {
                        ack = qo.ack();
                        if (C5046bo.isNullOrNil(ack)) {
                            aar.akW(C30080q.m47642v(ack, c7620bi.getType(), c45316cl.cvA.cvE > 0 ? "@S" : "@T"));
                            aar.mo27435oY(false);
                            if (C5046bo.isNullOrNil(aar.wgz) || !C5730e.m8628ct(aar.wgz)) {
                                aar.akQ(ack);
                                aar.mo27435oY(true);
                                abu abu = new abu();
                                abu.alT(ack);
                                abf.mo74746b(abu);
                            }
                        } else {
                            aar.mo27435oY(true);
                        }
                        aar.mo27434oX(true);
                        aar.mo27394LE(5);
                        abf.wiv.add(aar);
                        c45316cl.cvA.cvC = abf;
                        c45316cl.cvA.desc = c32224p.title;
                        c45316cl.cvA.type = 5;
                        AppMethodBeat.m2505o(27253);
                        return true;
                    }
                }
                ack = a;
                if (C5046bo.isNullOrNil(ack)) {
                }
                aar.mo27434oX(true);
                aar.mo27394LE(5);
                abf.wiv.add(aar);
                c45316cl.cvA.cvC = abf;
                c45316cl.cvA.desc = c32224p.title;
                c45316cl.cvA.type = 5;
                AppMethodBeat.m2505o(27253);
                return true;
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.GetFavDataSource", e, "", new Object[0]);
            C4990ab.m7413e("MicroMsg.GetFavDataSource", "retransmit app msg error : %s", e.getLocalizedMessage());
        }
        c45316cl.cvA.cvG = C25738R.string.bor;
        AppMethodBeat.m2505o(27253);
        return false;
    }

    /* renamed from: a */
    private static boolean m69371a(C45316cl c45316cl, C8910b c8910b, abf abf, C7620bi c7620bi) {
        AppMethodBeat.m2504i(27255);
        C18348nt c18348nt = new C18348nt();
        c18348nt.cJY.type = 0;
        c18348nt.cJY.cKa = c8910b.fgU;
        C4879a.xxA.mo10055m(c18348nt);
        C44099c c44099c = c18348nt.cJZ.cKi;
        if (c44099c == null) {
            C4990ab.m7420w("MicroMsg.GetFavDataSource", "fill favorite event fail, parse record msg null");
            c45316cl.cvA.cvG = C25738R.string.bor;
            AppMethodBeat.m2505o(27255);
            return false;
        }
        abf.alB(c44099c.title);
        Iterator it = c44099c.fjr.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2;
            aar aar = (aar) it.next();
            aar aar2 = null;
            abt abt;
            switch (aar.dataType) {
                case 1:
                    aar = C40443e.m69392q(aar);
                    abt = c45316cl.cvA.cvD;
                    abt.wiK++;
                    aar2 = aar;
                    break;
                case 2:
                    aar = C40443e.m69385j(aar, c7620bi.field_msgId);
                    abt = c45316cl.cvA.cvD;
                    abt.wiL++;
                    aar2 = aar;
                    break;
                case 3:
                    aar = C40443e.m69383i(aar, c7620bi.field_msgId);
                    abt = c45316cl.cvA.cvD;
                    abt.wiM++;
                    aar2 = aar;
                    break;
                case 4:
                case 15:
                    aar = C40443e.m69387l(aar, c7620bi.field_msgId);
                    abt = c45316cl.cvA.cvD;
                    abt.wiN++;
                    aar2 = aar;
                    break;
                case 5:
                    aar = C40443e.m69386k(aar, c7620bi.field_msgId);
                    abt = c45316cl.cvA.cvD;
                    abt.wiO++;
                    aar2 = aar;
                    break;
                case 6:
                    aar = C40443e.m69393r(aar);
                    abt = c45316cl.cvA.cvD;
                    abt.wiP++;
                    aar2 = aar;
                    break;
                case 7:
                    aar = C40443e.m69388m(aar, c7620bi.field_msgId);
                    abt = c45316cl.cvA.cvD;
                    abt.wiQ++;
                    aar2 = aar;
                    break;
                case 8:
                    aar = C40443e.m69389n(aar, c7620bi.field_msgId);
                    abt = c45316cl.cvA.cvD;
                    abt.fileCount++;
                    aar2 = aar;
                    break;
                case 10:
                    aar = C40443e.m69364a(aar, aar.dataType);
                    abt = c45316cl.cvA.cvD;
                    abt.wiS++;
                    aar2 = aar;
                    break;
                case 11:
                    aar = C40443e.m69364a(aar, aar.dataType);
                    abt = c45316cl.cvA.cvD;
                    abt.wiT++;
                    aar2 = aar;
                    break;
                case 12:
                case 14:
                    aar = C40443e.m69395t(aar);
                    abt = c45316cl.cvA.cvD;
                    abt.wiW++;
                    aar2 = aar;
                    break;
                case 16:
                    aar = C40443e.m69396u(aar);
                    abt = c45316cl.cvA.cvD;
                    abt.wiX++;
                    aar2 = aar;
                    break;
                case 17:
                    aar2 = C40443e.m69394s(aar);
                    break;
                case 19:
                    aar2 = C40443e.m69390o(aar, c7620bi.field_msgId);
                    break;
                case 20:
                    aar2 = C40443e.m69397v(aar);
                    break;
            }
            if (aar2 != null) {
                i2 = i + 1;
                aar2.akZ(C40443e.m69378e(c7620bi, i));
                abf.wiv.add(aar2);
            } else {
                i2 = i;
            }
            i = i2;
        }
        if (C5046bo.isNullOrNil(((aar) c44099c.fjr.get(0)).wgo) || !((aar) c44099c.fjr.get(0)).wgo.equals(".htm")) {
            c45316cl.cvA.type = 14;
        } else {
            c45316cl.cvA.type = 18;
        }
        AppMethodBeat.m2505o(27255);
        return true;
    }

    /* renamed from: p */
    private static aar m69391p(aar aar) {
        AppMethodBeat.m2504i(27256);
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
        aat.mo64043LI(1);
        aat.mo64052mi(C5046bo.anU());
        aas.mo48444c(aat);
        aar2.mo27398a(aas);
        aar2.alc(aar.wgV);
        aar2.ald(aar.wgX);
        aar2.all(aar.whu);
        aar2.mo27435oY(true);
        aar2.mo27434oX(true);
        aar2.ale(aar.whb);
        aar2.mo27396LG(aar.whh);
        aar2.akS(aar.wgq);
        aar2.akT(aar.wgs);
        aar2.mo27431mf(aar.wgu);
        aar2.akX(aar.wgB);
        aar2.akY(aar.wgD);
        aar2.mo27432mg(aar.wgF);
        AppMethodBeat.m2505o(27256);
        return aar2;
    }

    /* renamed from: q */
    private static aar m69392q(aar aar) {
        AppMethodBeat.m2504i(27258);
        aar p = C40443e.m69391p(aar);
        p.mo27394LE(1);
        p.akI(aar.desc);
        AppMethodBeat.m2505o(27258);
        return p;
    }

    /* renamed from: i */
    private static aar m69383i(aar aar, long j) {
        AppMethodBeat.m2504i(27259);
        aar p = C40443e.m69391p(aar);
        p.mo27394LE(3);
        if (!C5046bo.isNullOrNil(aar.whb)) {
            C18348nt c18348nt = new C18348nt();
            c18348nt.cJY.type = 1;
            c18348nt.cJY.cAv = aar;
            c18348nt.cJY.cvx = j;
            C4879a.xxA.mo10055m(c18348nt);
            if (C5046bo.isNullOrNil(c18348nt.cJZ.dataPath) && C5046bo.isNullOrNil(c18348nt.cJZ.thumbPath)) {
                C4990ab.m7412e("MicroMsg.GetFavDataSource", "cloneImgItem:not record plugin ? get paths error");
            }
            p.akV(c18348nt.cJZ.dataPath);
            p.mo27393LD(aar.duration);
            p.mo27435oY(true);
            p.mo27434oX(false);
            p.akR(aar.wgo);
        }
        AppMethodBeat.m2505o(27259);
        return p;
    }

    /* renamed from: j */
    private static aar m69385j(aar aar, long j) {
        AppMethodBeat.m2504i(27260);
        aar p = C40443e.m69391p(aar);
        p.mo27394LE(2);
        C18348nt c18348nt = new C18348nt();
        c18348nt.cJY.type = 1;
        c18348nt.cJY.cAv = aar;
        c18348nt.cJY.cvx = j;
        C4879a.xxA.mo10055m(c18348nt);
        if (C5046bo.isNullOrNil(c18348nt.cJZ.dataPath) && C5046bo.isNullOrNil(c18348nt.cJZ.thumbPath)) {
            C4990ab.m7412e("MicroMsg.GetFavDataSource", "cloneImgItem:not record plugin ? get paths error");
        }
        p.akV(c18348nt.cJZ.dataPath);
        p.akW(c18348nt.cJZ.thumbPath);
        p.mo27435oY(false);
        p.mo27434oX(false);
        AppMethodBeat.m2505o(27260);
        return p;
    }

    /* renamed from: k */
    private static aar m69386k(aar aar, long j) {
        AppMethodBeat.m2504i(27261);
        aar p = C40443e.m69391p(aar);
        C40443e.m69366a(p, aar);
        p.mo27394LE(5);
        C18348nt c18348nt = new C18348nt();
        c18348nt.cJY.type = 1;
        c18348nt.cJY.cAv = aar;
        c18348nt.cJY.cvx = j;
        C4879a.xxA.mo10055m(c18348nt);
        if (C5046bo.isNullOrNil(c18348nt.cJZ.dataPath) && C5046bo.isNullOrNil(c18348nt.cJZ.thumbPath)) {
            C4990ab.m7412e("MicroMsg.GetFavDataSource", "cloneUrlItem:not record plugin ? get paths error");
        }
        p.akW(c18348nt.cJZ.thumbPath);
        p.mo27435oY(false);
        if (!(aar.wgT == null || aar.wgT.whA == null)) {
            abu abu = new abu();
            abu.alQ(aar.wgT.whA.title);
            abu.alR(aar.wgT.whA.desc);
            abu.alT(aar.wgT.whA.thumbUrl);
            abu.mo27441LO(aar.wgT.whA.wja);
            abu.alS(aar.wgT.whA.wiY);
            p.wgT.mo48443a(abu);
        }
        AppMethodBeat.m2505o(27261);
        return p;
    }

    /* renamed from: l */
    private static aar m69387l(aar aar, long j) {
        AppMethodBeat.m2504i(27262);
        aar p = C40443e.m69391p(aar);
        C40443e.m69366a(p, aar);
        if (aar.dataType == 15) {
            p.mo27394LE(15);
        } else {
            p.mo27394LE(4);
        }
        C18348nt c18348nt = new C18348nt();
        c18348nt.cJY.type = 1;
        c18348nt.cJY.cAv = aar;
        c18348nt.cJY.cvx = j;
        C4879a.xxA.mo10055m(c18348nt);
        if (C5046bo.isNullOrNil(c18348nt.cJZ.dataPath) && C5046bo.isNullOrNil(c18348nt.cJZ.thumbPath)) {
            C4990ab.m7412e("MicroMsg.GetFavDataSource", "cloneVideoItem:not record plugin ? get paths error");
        }
        p.mo27434oX(false);
        p.akV(c18348nt.cJZ.dataPath);
        p.mo27435oY(false);
        p.akW(c18348nt.cJZ.thumbPath);
        p.mo27393LD(aar.duration);
        AppMethodBeat.m2505o(27262);
        return p;
    }

    /* renamed from: r */
    private static aar m69393r(aar aar) {
        AppMethodBeat.m2504i(27263);
        aar p = C40443e.m69391p(aar);
        p.mo27394LE(6);
        if (!(aar.wgT == null || aar.wgT.why == null)) {
            aay aay = new aay();
            aay.alu(aar.wgT.why.label);
            aay.mo15621E(aar.wgT.why.lat);
            aay.mo15620D(aar.wgT.why.lng);
            aay.mo15622LJ(aar.wgT.why.cED);
            aay.alv(aar.wgT.why.cIK);
            p.wgT.mo48440a(aay);
        }
        AppMethodBeat.m2505o(27263);
        return p;
    }

    /* renamed from: m */
    private static aar m69388m(aar aar, long j) {
        AppMethodBeat.m2504i(27264);
        aar p = C40443e.m69391p(aar);
        C40443e.m69366a(p, aar);
        p.mo27394LE(7);
        C18348nt c18348nt = new C18348nt();
        c18348nt.cJY.type = 1;
        c18348nt.cJY.cAv = aar;
        c18348nt.cJY.cvx = j;
        C4879a.xxA.mo10055m(c18348nt);
        if (C5046bo.isNullOrNil(c18348nt.cJZ.dataPath) && C5046bo.isNullOrNil(c18348nt.cJZ.thumbPath)) {
            C4990ab.m7412e("MicroMsg.GetFavDataSource", "cloneMusicItem:not record plugin ? get paths error");
        }
        p.akW(c18348nt.cJZ.thumbPath);
        p.mo27435oY(false);
        AppMethodBeat.m2505o(27264);
        return p;
    }

    /* renamed from: n */
    private static aar m69389n(aar aar, long j) {
        AppMethodBeat.m2504i(27265);
        aar p = C40443e.m69391p(aar);
        C40443e.m69366a(p, aar);
        p.mo27394LE(8);
        C18348nt c18348nt = new C18348nt();
        c18348nt.cJY.type = 1;
        c18348nt.cJY.cAv = aar;
        c18348nt.cJY.cvx = j;
        C4879a.xxA.mo10055m(c18348nt);
        if (C5046bo.isNullOrNil(c18348nt.cJZ.dataPath) && C5046bo.isNullOrNil(c18348nt.cJZ.thumbPath)) {
            C4990ab.m7412e("MicroMsg.GetFavDataSource", "cloneFileItem:not record plugin ? get paths error");
        }
        p.akV(c18348nt.cJZ.dataPath);
        p.akW(c18348nt.cJZ.thumbPath);
        p.mo27434oX(false);
        p.akR(aar.wgo);
        AppMethodBeat.m2505o(27265);
        return p;
    }

    /* renamed from: s */
    private static aar m69394s(aar aar) {
        AppMethodBeat.m2504i(27266);
        aar p = C40443e.m69391p(aar);
        p.akH(aar.title);
        p.akI(aar.desc);
        p.mo27394LE(17);
        p.alh(aar.whj);
        AppMethodBeat.m2505o(27266);
        return p;
    }

    /* renamed from: o */
    private static aar m69390o(aar aar, long j) {
        AppMethodBeat.m2504i(27267);
        aar p = C40443e.m69391p(aar);
        p.akH(aar.title);
        p.akI(aar.desc);
        p.mo27394LE(19);
        C18348nt c18348nt = new C18348nt();
        c18348nt.cJY.type = 1;
        c18348nt.cJY.cAv = aar;
        c18348nt.cJY.cvx = j;
        C4879a.xxA.mo10055m(c18348nt);
        if (C5046bo.isNullOrNil(c18348nt.cJZ.thumbPath)) {
            C4990ab.m7412e("MicroMsg.GetFavDataSource", "cloneAppBrandItem:not record plugin ? get paths error");
        } else {
            p.mo27435oY(false);
            p.akW(c18348nt.cJZ.thumbPath);
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
            p.wgT.mo48439a(aap);
        }
        AppMethodBeat.m2505o(27267);
        return p;
    }

    /* renamed from: a */
    private static aar m69364a(aar aar, int i) {
        AppMethodBeat.m2504i(27268);
        aar p = C40443e.m69391p(aar);
        p.mo27394LE(i);
        if (!(aar.wgT == null || aar.wgT.whC == null)) {
            abe abe = new abe();
            abe.alw(aar.wgT.whC.title);
            abe.alx(aar.wgT.whC.desc);
            abe.mo27436LK(aar.wgT.whC.type);
            abe.alz(aar.wgT.whC.info);
            abe.aly(aar.wgT.whC.thumbUrl);
            p.wgT.mo48441a(abe);
        }
        AppMethodBeat.m2505o(27268);
        return p;
    }

    /* renamed from: t */
    private static aar m69395t(aar aar) {
        AppMethodBeat.m2504i(27269);
        aar p = C40443e.m69391p(aar);
        p.mo27394LE(14);
        if (!(aar.wgT == null || aar.wgT.whE == null)) {
            abo abo = new abo();
            abo.alM(aar.wgT.whE.title);
            abo.alN(aar.wgT.whE.desc);
            abo.alP(aar.wgT.whE.info);
            abo.alO(aar.wgT.whE.thumbUrl);
            p.wgT.mo48442a(abo);
        }
        AppMethodBeat.m2505o(27269);
        return p;
    }

    /* renamed from: u */
    private static aar m69396u(aar aar) {
        AppMethodBeat.m2504i(27270);
        aar p = C40443e.m69391p(aar);
        p.mo27394LE(16);
        p.akI(aar.desc);
        AppMethodBeat.m2505o(27270);
        return p;
    }

    /* renamed from: v */
    private static aar m69397v(aar aar) {
        AppMethodBeat.m2504i(27271);
        aar p = C40443e.m69391p(aar);
        p.mo27394LE(20);
        p.mo27393LD(aar.duration);
        AppMethodBeat.m2505o(27271);
        return p;
    }

    /* renamed from: a */
    private static void m69367a(aar aar, C7620bi c7620bi) {
        AppMethodBeat.m2504i(27247);
        if (c7620bi.field_isSend != 1) {
            aar.akZ(String.valueOf(c7620bi.field_msgSvrId));
            AppMethodBeat.m2505o(27247);
        } else if (C1855t.m3896kH(c7620bi.field_talker) || c7620bi.field_talker.equals("filehelper")) {
            aar.akZ(String.valueOf(c7620bi.field_msgSvrId));
            AppMethodBeat.m2505o(27247);
        } else {
            aar.akZ(c7620bi.field_talker + "#" + String.valueOf(c7620bi.field_msgSvrId));
            AppMethodBeat.m2505o(27247);
        }
    }

    /* renamed from: e */
    private static String m69378e(C7620bi c7620bi, int i) {
        AppMethodBeat.m2504i(27254);
        String format;
        if (c7620bi.field_isSend != 1) {
            format = String.format("%d$%d", new Object[]{Long.valueOf(c7620bi.field_msgSvrId), Integer.valueOf(i)});
            AppMethodBeat.m2505o(27254);
            return format;
        } else if (C1855t.m3896kH(c7620bi.field_talker) || c7620bi.field_talker.equals("filehelper")) {
            format = String.format("%d$%d", new Object[]{Long.valueOf(c7620bi.field_msgSvrId), Integer.valueOf(i)});
            AppMethodBeat.m2505o(27254);
            return format;
        } else {
            format = String.format("%s#%d$%d", new Object[]{c7620bi.field_talker, Long.valueOf(c7620bi.field_msgSvrId), Integer.valueOf(i)});
            AppMethodBeat.m2505o(27254);
            return format;
        }
    }

    /* renamed from: a */
    private static void m69366a(aar aar, aar aar2) {
        AppMethodBeat.m2504i(27257);
        aar.akO(aar2.wgi);
        aar.akP(aar2.wgk);
        aar.akN(aar2.wgg);
        aar.akH(aar2.title);
        aar.akI(aar2.desc);
        AppMethodBeat.m2505o(27257);
    }
}
