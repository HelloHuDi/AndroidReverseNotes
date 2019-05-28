package com.tencent.p177mm.pluginsdk.model;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1831bh;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.modelvoice.C26497b;
import com.tencent.p177mm.modelvoice.C32850q;
import com.tencent.p177mm.modelvoice.C42230n;
import com.tencent.p177mm.openim.p1210a.C32873b;
import com.tencent.p177mm.openim.p1210a.C32873b.C32874a;
import com.tencent.p177mm.openim.room.p266a.C42249a;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p181af.C1192l;
import com.tencent.p177mm.p181af.C32223o;
import com.tencent.p177mm.p181af.C32224p;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.p185a.C25754e;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.C37478f;
import com.tencent.p177mm.p230g.p231a.C18348nt;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p249m.C42164b;
import com.tencent.p177mm.plugin.biz.p1395a.C27500a;
import com.tencent.p177mm.plugin.fav.p410ui.C45932c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
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
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.C7620bi.C5135a;
import com.tencent.ttpic.wav.WavFileHeader;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.mm.pluginsdk.model.g */
public final class C40444g {
    private static final SimpleDateFormat pJi = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    static {
        AppMethodBeat.m2504i(27295);
        AppMethodBeat.m2505o(27295);
    }

    /* renamed from: a */
    public static boolean m69402a(Context context, C45316cl c45316cl, String str, List<C7620bi> list, boolean z) {
        AppMethodBeat.m2504i(27277);
        if (list == null || list.isEmpty() || context == null) {
            C4990ab.m7420w("MicroMsg.GetFavRecordDataSource", "fill favorite event fail, event or msgs is null");
            c45316cl.cvA.cvG = C25738R.string.boh;
            AppMethodBeat.m2505o(27277);
            return false;
        }
        C7620bi c7620bi;
        for (C7620bi c7620bi2 : list) {
            if (C1831bh.m3770o(c7620bi2)) {
                switch (c7620bi2.getType() & CdnLogic.kBizGeneric) {
                    case 1:
                        c7620bi2.setContent(context.getString(C25738R.string.f9236tx));
                        break;
                    case 3:
                        c7620bi2.setContent(context.getString(C25738R.string.f9199sn));
                        c7620bi2.setType(1);
                        break;
                    case 43:
                        c7620bi2.setContent(context.getString(C25738R.string.f9253ud));
                        c7620bi2.setType(1);
                        break;
                    case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                        c7620bi2.setContent(context.getString(C25738R.string.f9246u7));
                        c7620bi2.setType(1);
                        break;
                    default:
                        break;
                }
            }
        }
        boolean kq = C17903f.m28103kq(str);
        boolean z2;
        if (list.size() != 1 || z) {
            c45316cl.cvA.cvC = new abf();
            c45316cl.cvA.cvD = new abt();
            if (context != null) {
                if (kq) {
                    if (C25754e.m40905rs(C25754e.m40900fD(((C7620bi) list.get(0)).field_bizChatId))) {
                        c45316cl.cvA.cvC.alB(context.getString(C25738R.string.dja));
                    } else {
                        if (C25754e.m40908rv(str) != null) {
                            c45316cl.cvA.cvC.alB(context.getString(C25738R.string.bqi, new Object[]{r1.field_userName, C25754e.m40906rt(r0)}));
                        }
                    }
                } else if (C1855t.m3896kH(str)) {
                    c45316cl.cvA.cvC.alB(context.getString(C25738R.string.dja));
                } else {
                    if (C5046bo.nullAsNil(C1853r.m3820YB()).equals(C5046bo.nullAsNil(C1854s.m3865mI(str)))) {
                        c45316cl.cvA.cvC.alB(context.getString(C25738R.string.bqj, new Object[]{r0}));
                    } else {
                        c45316cl.cvA.cvC.alB(context.getString(C25738R.string.bqi, new Object[]{C1853r.m3820YB(), C1854s.m3865mI(str)}));
                    }
                }
                C4990ab.m7411d("MicroMsg.GetFavRecordDataSource", "title %s", c45316cl.cvA.cvC.title);
            }
            c45316cl.cvA.cvC.mo74737a(C40444g.aiz(str));
            c45316cl.cvA.type = 14;
            z2 = true;
            int i = 0;
            for (C7620bi c7620bi22 : list) {
                if (C40444g.m69407b(context, c45316cl, c7620bi22)) {
                    i = 1;
                } else {
                    z2 = false;
                }
            }
            if (i != 0 && c45316cl.cvA.cvG > 0) {
                c45316cl.cvA.cvG = 0;
            }
            AppMethodBeat.m2505o(27277);
            return z2;
        }
        c7620bi22 = (C7620bi) list.get(0);
        if (c7620bi22.drC()) {
            C32223o b = ((C27500a) C1720g.m3528K(C27500a.class)).mo35246b(c7620bi22.field_msgId, c7620bi22.field_content);
            if (b.fjr == null || b.fjr.size() != 1) {
                c45316cl.cvA.cvC = new abf();
                c45316cl.cvA.cvD = new abt();
                c45316cl.cvA.cvC.mo74737a(C40444g.aiz(str));
                c45316cl.cvA.type = 14;
                z2 = C40444g.m69407b(context, c45316cl, c7620bi22);
                AppMethodBeat.m2505o(27277);
                return z2;
            }
            z2 = C40443e.m69377d(c45316cl, c7620bi22);
            AppMethodBeat.m2505o(27277);
            return z2;
        }
        z2 = C40443e.m69377d(c45316cl, c7620bi22);
        AppMethodBeat.m2505o(27277);
        return z2;
    }

    /* renamed from: b */
    private static boolean m69407b(Context context, C45316cl c45316cl, C7620bi c7620bi) {
        boolean z = false;
        AppMethodBeat.m2504i(27278);
        if (c45316cl == null || c7620bi == null) {
            C4990ab.m7420w("MicroMsg.GetFavRecordDataSource", "fill favorite event fail, event or msg is null");
            if (c45316cl != null) {
                c45316cl.cvA.cvG = C25738R.string.boh;
            }
            AppMethodBeat.m2505o(27278);
        } else {
            C7620bi ar = C7620bi.m13569ar(c7620bi);
            if (ar.isText()) {
                z = C40444g.m69411e(c45316cl, ar);
            } else if (ar.drD()) {
                z = C40444g.m69413k(c45316cl, ar);
            } else if (ar.bAC()) {
                z = C40444g.m69403a(c45316cl, ar);
            } else if (ar.drE()) {
                z = C40444g.m69412j(c45316cl, ar);
            } else if (ar.bws()) {
                z = C40444g.m69408b(c45316cl, ar);
            } else if (ar.bwt()) {
                z = C40444g.m69408b(c45316cl, ar);
            } else if (ar.drC()) {
                z = C40444g.m69410c(c45316cl, ar);
            } else if (ar.dtw()) {
                z = C40444g.m69409c(context, c45316cl, ar);
            } else if (!ar.bAA() || ar.dty()) {
                c45316cl.cvA.cvG = C25738R.string.bop;
            } else {
                z = C40444g.m69401a(context, c45316cl, ar);
            }
            C45932c.m85255a(ar, c45316cl, z);
            AppMethodBeat.m2505o(27278);
        }
        return z;
    }

    private static abl aiz(String str) {
        AppMethodBeat.m2504i(27279);
        abl abl = new abl();
        abl.alD(str);
        abl.mo39126LN(1);
        abl.mo39136ml(C5046bo.anU());
        abl.alF("");
        AppMethodBeat.m2505o(27279);
        return abl;
    }

    /* renamed from: ag */
    private static aat m69404ag(C7620bi c7620bi) {
        AppMethodBeat.m2504i(27280);
        aat aat = new aat();
        if (c7620bi == null) {
            AppMethodBeat.m2505o(27280);
            return aat;
        }
        String substring;
        if (c7620bi.field_isSend == 0) {
            aat.alm(c7620bi.field_talker);
            aat.aln(C1853r.m3846Yz());
            if (C1855t.m3896kH(c7620bi.field_talker)) {
                if (c7620bi.field_content != null) {
                    substring = c7620bi.field_content.substring(0, Math.max(0, c7620bi.field_content.indexOf(58)));
                } else {
                    substring = "";
                }
                aat.alp(substring);
                if (!(C5046bo.isNullOrNil(aat.whU) || c7620bi.drD())) {
                    c7620bi.setContent(c7620bi.field_content.substring(aat.whU.length() + 1));
                    if (c7620bi.field_content.length() > 0 && 10 == c7620bi.field_content.charAt(0)) {
                        c7620bi.setContent(c7620bi.field_content.substring(1));
                    }
                    if (c7620bi.dtF()) {
                        c7620bi.mo14797jx(c7620bi.field_transContent.substring(aat.whU.length() + 1));
                        if (c7620bi.field_transContent.length() > 0 && 10 == c7620bi.field_transContent.charAt(0)) {
                            c7620bi.mo14797jx(c7620bi.field_transContent.substring(1));
                        }
                    }
                }
            }
        } else {
            aat.alm(C1853r.m3846Yz());
            aat.aln(c7620bi.field_talker);
            if (C1855t.m3896kH(c7620bi.field_talker)) {
                aat.alp(aat.cEV);
            }
        }
        if (C17903f.m28103kq(c7620bi.field_talker)) {
            substring = c7620bi.field_bizChatUserId;
            if (substring == null) {
                substring = C1829bf.m3758oE(c7620bi.dqJ).userId;
            }
            aat.alp(substring);
        }
        aat.mo64043LI(1);
        aat.mo64052mi(c7620bi.field_createTime);
        aat.alq(c7620bi.field_msgSvrId);
        if (c7620bi.field_msgSvrId > 0) {
            aat.alo(c7620bi.field_msgSvrId);
        }
        AppMethodBeat.m2505o(27280);
        return aat;
    }

    /* renamed from: b */
    private static String m69406b(aat aat) {
        AppMethodBeat.m2504i(27282);
        String format = pJi.format(new Date(aat.createTime));
        AppMethodBeat.m2505o(27282);
        return format;
    }

    /* renamed from: e */
    private static boolean m69411e(C45316cl c45316cl, C7620bi c7620bi) {
        String str;
        AppMethodBeat.m2504i(27284);
        aas aas = new aas();
        aas.mo48444c(C40444g.m69404ag(c7620bi));
        aar aar = new aar();
        aar.akZ(C40444g.m69405ah(c7620bi));
        aar.mo27394LE(1);
        if (c7620bi.dtV()) {
            str = C4996ah.getContext().getString(C25738R.string.dtl, new Object[]{"@"}) + 10;
        } else {
            str = "";
        }
        if (c7620bi.dtM()) {
            aar.akI(str + c7620bi.field_content + "\n\n" + c7620bi.field_transContent);
        } else {
            aar.akI(str + c7620bi.field_content);
        }
        aar.mo27435oY(true);
        aar.mo27434oX(true);
        aar.mo27398a(aas);
        aar.alc(C40444g.m69400a(aas.whw));
        aar.ald(C40444g.m69406b(aas.whw));
        if (C7616ad.aox(aas.whw.whU)) {
            str = C42249a.m74595A(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(aas.whw.whU));
            if (!C5046bo.isNullOrNil(str)) {
                aar.all(str);
            }
        }
        c45316cl.cvA.cvC.wiv.add(aar);
        abt abt = c45316cl.cvA.cvD;
        abt.wiK++;
        AppMethodBeat.m2505o(27284);
        return true;
    }

    /* renamed from: j */
    private static boolean m69412j(C45316cl c45316cl, C7620bi c7620bi) {
        AppMethodBeat.m2504i(27285);
        C25822e c25822e = null;
        if (c7620bi.field_msgId > 0) {
            c25822e = C32291o.ahl().mo73113fJ((long) ((int) c7620bi.field_msgId));
        }
        if ((c25822e == null || c25822e.fDy <= 0) && c7620bi.field_msgSvrId > 0) {
            c25822e = C32291o.ahl().mo73112fI(c7620bi.field_msgSvrId);
        }
        if (c25822e == null) {
            C4990ab.m7420w("MicroMsg.GetFavRecordDataSource", "getImgDataPath: try get imgInfo fail");
            c45316cl.cvA.cvG = C25738R.string.bon;
            AppMethodBeat.m2505o(27285);
            return false;
        }
        aas aas = new aas();
        aas.mo48444c(C40444g.m69404ag(c7620bi));
        aar aar = new aar();
        aar.akZ(C40444g.m69405ah(c7620bi));
        aar.mo27394LE(2);
        aar.akV(C32291o.ahl().mo73118q(C37478f.m63227c(c25822e), "", ""));
        if (c25822e.agQ()) {
            c25822e = C32291o.ahl().mo73116ly(c25822e.fDJ);
            if (c25822e.frO > c25822e.offset) {
                aar.akV(C32291o.ahl().mo73118q("SERVERID://" + c7620bi.field_msgSvrId, "", ""));
            }
        }
        aar.akW(C32291o.ahl().mo73074I(c7620bi.field_imgPath, true));
        aar.mo27398a(aas);
        aar.alc(C40444g.m69400a(aas.whw));
        aar.ald(C40444g.m69406b(aas.whw));
        aar.mo27433mh(c7620bi.field_msgId);
        if (C7616ad.aox(aas.whw.whU)) {
            String A = C42249a.m74595A(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(aas.whw.whU));
            if (!C5046bo.isNullOrNil(A)) {
                aar.all(A);
            }
        }
        c45316cl.cvA.cvC.wiv.add(aar);
        abt abt = c45316cl.cvA.cvD;
        abt.wiL++;
        AppMethodBeat.m2505o(27285);
        return true;
    }

    /* renamed from: a */
    private static boolean m69403a(C45316cl c45316cl, C7620bi c7620bi) {
        AppMethodBeat.m2504i(27286);
        aas aas = new aas();
        aas.mo48444c(C40444g.m69404ag(c7620bi));
        Map z = C5049br.m7595z(c7620bi.field_content, "msg");
        if (z != null) {
            try {
                aay aay = new aay();
                aay.alu((String) z.get(".msg.location.$label"));
                aay.mo15621E(Double.parseDouble((String) z.get(".msg.location.$x")));
                aay.mo15620D(Double.parseDouble((String) z.get(".msg.location.$y")));
                aay.mo15622LJ(Integer.valueOf((String) z.get(".msg.location.$scale")).intValue());
                aay.alv((String) z.get(".msg.location.$poiname"));
                aas.mo48440a(aay);
                aar aar = new aar();
                aar.akZ(C40444g.m69405ah(c7620bi));
                aar.mo27394LE(6);
                aar.mo27435oY(true);
                aar.mo27434oX(true);
                aar.mo27398a(aas);
                aar.alc(C40444g.m69400a(aas.whw));
                aar.ald(C40444g.m69406b(aas.whw));
                if (C7616ad.aox(aas.whw.whU)) {
                    String A = C42249a.m74595A(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(aas.whw.whU));
                    if (!C5046bo.isNullOrNil(A)) {
                        aar.all(A);
                    }
                }
                c45316cl.cvA.cvC.wiv.add(aar);
                abt abt = c45316cl.cvA.cvD;
                abt.wiP++;
                AppMethodBeat.m2505o(27286);
                return true;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.GetFavRecordDataSource", "parse failed, %s", e.getStackTrace().toString());
            }
        }
        c45316cl.cvA.cvG = C25738R.string.bor;
        AppMethodBeat.m2505o(27286);
        return false;
    }

    /* renamed from: k */
    private static boolean m69413k(C45316cl c45316cl, C7620bi c7620bi) {
        AppMethodBeat.m2504i(27287);
        aas aas = new aas();
        aas.mo48444c(C40444g.m69404ag(c7620bi));
        aar aar = new aar();
        aar.akZ(C40444g.m69405ah(c7620bi));
        aar.mo27394LE(3);
        if (C1855t.m3953nv(c7620bi.field_talker)) {
            aar.akV(C40444g.aiy(c7620bi.field_imgPath));
        } else {
            aar.akV(C32850q.getFullPath(c7620bi.field_imgPath));
        }
        aar.mo27435oY(true);
        C26497b uN = C32850q.m53727uN(c7620bi.field_imgPath);
        if (uN == null) {
            AppMethodBeat.m2505o(27287);
            return false;
        }
        aar.akR(C40443e.m69363Kp(uN.getFormat()));
        aar.mo27393LD((int) new C42230n(c7620bi.field_content).time);
        aar.mo27398a(aas);
        aar.alc(C40444g.m69400a(aas.whw));
        aar.ald(C40444g.m69406b(aas.whw));
        if (C7616ad.aox(aas.whw.whU)) {
            String A = C42249a.m74595A(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(aas.whw.whU));
            if (!C5046bo.isNullOrNil(A)) {
                aar.all(A);
            }
        }
        c45316cl.cvA.cvC.wiv.add(aar);
        abt abt = c45316cl.cvA.cvD;
        abt.wiM++;
        AppMethodBeat.m2505o(27287);
        return true;
    }

    private static String aiy(String str) {
        AppMethodBeat.m2504i(27288);
        C9638aw.m17190ZK();
        String b = C15428j.m23709b(C18628c.m29091XZ(), "recbiz_", str, ".rec", 2);
        if (C5046bo.isNullOrNil(b)) {
            AppMethodBeat.m2505o(27288);
            return null;
        } else if (new File(b).exists()) {
            AppMethodBeat.m2505o(27288);
            return b;
        } else {
            AppMethodBeat.m2505o(27288);
            return b;
        }
    }

    /* renamed from: b */
    private static boolean m69408b(C45316cl c45316cl, C7620bi c7620bi) {
        AppMethodBeat.m2504i(27289);
        aas aas = new aas();
        aas.mo48444c(C40444g.m69404ag(c7620bi));
        aar aar = new aar();
        aar.akZ(C40444g.m69405ah(c7620bi));
        C37961o.all();
        aar.akV(C9720t.m17303uh(c7620bi.field_imgPath));
        C37961o.all();
        aar.akW(C9720t.m17304ui(c7620bi.field_imgPath));
        aar.akR(C1173e.m2563cv(aar.wgx));
        if (c7620bi.bwt()) {
            aar.mo27394LE(15);
        } else {
            aar.mo27394LE(4);
        }
        C26493s ut = C26494u.m42268ut(c7620bi.field_imgPath);
        if (ut == null) {
            C4990ab.m7416i("MicroMsg.GetFavRecordDataSource", "video info null");
            c45316cl.cvA.cvG = C25738R.string.bog;
            AppMethodBeat.m2505o(27289);
            return false;
        }
        C4990ab.m7417i("MicroMsg.GetFavRecordDataSource", "video length is %d", Integer.valueOf(ut.frO));
        if (ut.frO > C42164b.m74341Nc()) {
            c45316cl.cvA.cvG = C25738R.string.bs4;
            AppMethodBeat.m2505o(27289);
            return false;
        } else if (c7620bi.bwt() && C26494u.m42270uv(ut.getFileName())) {
            c45316cl.cvA.cvG = C25738R.string.bog;
            AppMethodBeat.m2505o(27289);
            return false;
        } else {
            aar.mo27393LD(ut.fXd);
            aar.mo27398a(aas);
            aar.alc(C40444g.m69400a(aas.whw));
            aar.ald(C40444g.m69406b(aas.whw));
            if (C7616ad.aox(aas.whw.whU)) {
                String A = C42249a.m74595A(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(aas.whw.whU));
                if (!C5046bo.isNullOrNil(A)) {
                    aar.all(A);
                }
            }
            aar.mo27433mh(c7620bi.field_msgId);
            aar.mo27431mf((long) ut.frO);
            c45316cl.cvA.cvC.wiv.add(aar);
            abt abt = c45316cl.cvA.cvD;
            abt.wiN++;
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
            AppMethodBeat.m2505o(27289);
            return true;
        }
    }

    /* renamed from: c */
    private static boolean m69409c(Context context, C45316cl c45316cl, C7620bi c7620bi) {
        Object obj;
        AppMethodBeat.m2504i(27290);
        C9638aw.m17190ZK();
        C5135a Rn = C18628c.m29080XO().mo15260Rn(c7620bi.field_content);
        aas aas = new aas();
        aas.mo48444c(C40444g.m69404ag(c7620bi));
        String A;
        if (Rn != null && C1855t.m3897kv(Rn.ufB)) {
            aar aar = new aar();
            aar.akZ(C40444g.m69405ah(c7620bi));
            aar.mo27394LE(16);
            aar.akI(c7620bi.field_content);
            aar.mo27435oY(true);
            aar.mo27434oX(true);
            aar.mo27398a(aas);
            aar.alc(C40444g.m69400a(aas.whw));
            aar.ald(C40444g.m69406b(aas.whw));
            if (C7616ad.aox(aas.whw.whU)) {
                A = C42249a.m74595A(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(aas.whw.whU));
                if (!C5046bo.isNullOrNil(A)) {
                    aar.all(A);
                }
                obj = aar;
            } else {
                aar obj2 = aar;
            }
        } else if (Rn == null || !C7616ad.aox(Rn.svN)) {
            obj2 = C40444g.m69399a(c7620bi, context.getString(C25738R.string.f9147qy), aas);
        } else {
            if (TextUtils.isEmpty(((C32873b) C1720g.m3528K(C32873b.class)).mo44300a(Rn.xZm, "openim_card_type_name", C32874a.TYPE_WORDING))) {
                A = context.getResources().getString(C25738R.string.f9147qy);
            } else {
                A = String.format("[%s]", new Object[]{((C32873b) C1720g.m3528K(C32873b.class)).mo44300a(Rn.xZm, "openim_card_type_name", C32874a.TYPE_WORDING)});
            }
            obj2 = C40444g.m69399a(c7620bi, A, aas);
        }
        c45316cl.cvA.cvC.wiv.add(obj2);
        abt abt = c45316cl.cvA.cvD;
        abt.wiX++;
        AppMethodBeat.m2505o(27290);
        return true;
    }

    /* renamed from: a */
    private static aar m69398a(C7620bi c7620bi, C8910b c8910b, int i) {
        AppMethodBeat.m2504i(27291);
        aar aar = new aar();
        aar.akZ(C40444g.m69405ah(c7620bi));
        aar.akO(c8910b.fgM);
        aar.akP(c8910b.fgN);
        aar.akN(c8910b.url);
        aar.mo27434oX(true);
        File file = new File(C5046bo.m7532bc(C32291o.ahl().mo73074I(c7620bi.field_imgPath, true), ""));
        if (file.exists()) {
            aar.akW(file.getAbsolutePath());
        } else {
            aar.mo27435oY(true);
        }
        aar.akH(c8910b.title);
        aar.akI(c8910b.description);
        aar.mo27394LE(i);
        aar.alg(c8910b.canvasPageXml);
        AppMethodBeat.m2505o(27291);
        return aar;
    }

    /* renamed from: a */
    private static aar m69399a(C7620bi c7620bi, String str, aas aas) {
        AppMethodBeat.m2504i(27292);
        aar aar = new aar();
        aar.akZ(C40444g.m69405ah(c7620bi));
        aar.mo27394LE(1);
        aar.akI(str);
        aar.mo27435oY(true);
        aar.mo27434oX(true);
        aar.mo27398a(aas);
        aar.alc(C40444g.m69400a(aas.whw));
        aar.ald(C40444g.m69406b(aas.whw));
        if (C7616ad.aox(aas.whw.whU)) {
            String A = C42249a.m74595A(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(aas.whw.whU));
            if (!C5046bo.isNullOrNil(A)) {
                aar.all(A);
            }
        }
        AppMethodBeat.m2505o(27292);
        return aar;
    }

    /* renamed from: a */
    private static boolean m69401a(Context context, C45316cl c45316cl, C7620bi c7620bi) {
        AppMethodBeat.m2504i(27293);
        aas aas = new aas();
        aas.mo48444c(C40444g.m69404ag(c7620bi));
        String str = c7620bi.field_content;
        if (str == null) {
            c45316cl.cvA.cvG = C25738R.string.bor;
            AppMethodBeat.m2505o(27293);
            return false;
        }
        C8910b me = C8910b.m16064me(str);
        if (me == null) {
            c45316cl.cvA.cvG = C25738R.string.bor;
            AppMethodBeat.m2505o(27293);
            return false;
        }
        aas.whw.alr(me.appId);
        aas.whw.alt(me.cMg);
        C40439f bT = C46494g.m87739bT(me.appId, true);
        if (bT != null) {
            bT.mo63847xy();
        }
        aar aar;
        abt abt;
        C30065b aiE;
        abe abe;
        switch (me.type) {
            case 1:
                aar = new aar();
                aar.akZ(C40444g.m69405ah(c7620bi));
                aar.mo27394LE(1);
                aar.akI(me.title);
                aar.mo27435oY(true);
                aar.mo27434oX(true);
                aar.mo27398a(aas);
                aar.alc(C40444g.m69400a(aas.whw));
                aar.ald(C40444g.m69406b(aas.whw));
                if (C7616ad.aox(aas.whw.whU)) {
                    str = C42249a.m74595A(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(aas.whw.whU));
                    if (!C5046bo.isNullOrNil(str)) {
                        aar.all(str);
                    }
                }
                c45316cl.cvA.cvC.wiv.add(aar);
                abt = c45316cl.cvA.cvD;
                abt.wiK++;
                AppMethodBeat.m2505o(27293);
                return true;
            case 2:
                C9638aw.m17190ZK();
                if (C18628c.isSDCardAvailable()) {
                    aiE = C14877am.aUq().aiE(me.csD);
                    aar = new aar();
                    aar.akZ(C40444g.m69405ah(c7620bi));
                    if (aiE != null) {
                        aar.akV(aiE.field_fileFullPath);
                    }
                    str = C32291o.ahl().mo73074I(c7620bi.field_imgPath, true);
                    if (C1173e.m2561ct(str)) {
                        aar.akW(str);
                    }
                    aar.mo27394LE(2);
                    aar.akH(me.title);
                    aar.akI(me.description);
                    aar.mo27398a(aas);
                    aar.alc(C40444g.m69400a(aas.whw));
                    aar.ald(C40444g.m69406b(aas.whw));
                    aar.mo27433mh(c7620bi.field_msgId);
                    if (C7616ad.aox(aas.whw.whU)) {
                        str = C42249a.m74595A(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(aas.whw.whU));
                        if (!C5046bo.isNullOrNil(str)) {
                            aar.all(str);
                        }
                    }
                    c45316cl.cvA.cvC.wiv.add(aar);
                    abt = c45316cl.cvA.cvD;
                    abt.wiL++;
                    AppMethodBeat.m2505o(27293);
                    return true;
                }
                c45316cl.cvA.cvG = C25738R.string.box;
                AppMethodBeat.m2505o(27293);
                return false;
            case 3:
                aar = C40444g.m69398a(c7620bi, me, 7);
                aar.mo27398a(aas);
                aar.alc(C40444g.m69400a(aas.whw));
                aar.ald(C40444g.m69406b(aas.whw));
                if (C7616ad.aox(aas.whw.whU)) {
                    str = C42249a.m74595A(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(aas.whw.whU));
                    if (!C5046bo.isNullOrNil(str)) {
                        aar.all(str);
                    }
                }
                c45316cl.cvA.cvC.wiv.add(aar);
                abt = c45316cl.cvA.cvD;
                abt.wiQ++;
                AppMethodBeat.m2505o(27293);
                return true;
            case 4:
                aar = C40444g.m69398a(c7620bi, me, 4);
                aar.mo27398a(aas);
                aar.alc(C40444g.m69400a(aas.whw));
                aar.ald(C40444g.m69406b(aas.whw));
                aar.mo27433mh(c7620bi.field_msgId);
                if (C7616ad.aox(aas.whw.whU)) {
                    str = C42249a.m74595A(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(aas.whw.whU));
                    if (!C5046bo.isNullOrNil(str)) {
                        aar.all(str);
                    }
                }
                c45316cl.cvA.cvC.wiv.add(aar);
                abt = c45316cl.cvA.cvD;
                abt.wiN++;
                AppMethodBeat.m2505o(27293);
                return true;
            case 5:
                if (me.url == null || me.url.equals("")) {
                    c45316cl.cvA.cvG = C25738R.string.bol;
                    AppMethodBeat.m2505o(27293);
                    return false;
                }
                aas.whw.als(me.url);
                aar = C40444g.m69398a(c7620bi, me, 5);
                aar.mo27398a(aas);
                aar.alc(C40444g.m69400a(aas.whw));
                aar.ald(C40444g.m69406b(aas.whw));
                if (C7616ad.aox(aas.whw.whU)) {
                    str = C42249a.m74595A(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(aas.whw.whU));
                    if (!C5046bo.isNullOrNil(str)) {
                        aar.all(str);
                    }
                }
                abu abu = new abu();
                if (!C5046bo.isNullOrNil(me.title)) {
                    abu.alQ(me.title);
                }
                if (!C5046bo.isNullOrNil(me.description)) {
                    abu.alR(me.description);
                }
                if (!C5046bo.isNullOrNil(me.thumburl)) {
                    abu.alT(me.thumburl);
                }
                if (!C5046bo.isNullOrNil(me.canvasPageXml)) {
                    abu.alU(me.canvasPageXml);
                }
                if (abu.computeSize() > 0) {
                    abu.mo27441LO(1);
                    aas.mo48443a(abu);
                }
                c45316cl.cvA.cvC.wiv.add(aar);
                abt = c45316cl.cvA.cvD;
                abt.wiO++;
                AppMethodBeat.m2505o(27293);
                return true;
            case 6:
                C9638aw.m17190ZK();
                if (C18628c.isSDCardAvailable()) {
                    aiE = C14877am.aUq().aiE(me.csD);
                    aar = new aar();
                    if (aiE != null) {
                        aar.akV(aiE.field_fileFullPath);
                    }
                    aar.akZ(C40444g.m69405ah(c7620bi));
                    aar.mo27394LE(8);
                    aar.akR(me.fgp);
                    str = C32291o.ahl().mo73074I(c7620bi.field_imgPath, true);
                    if (C5046bo.isNullOrNil(str)) {
                        aar.mo27435oY(true);
                    }
                    if (C1173e.m2561ct(str)) {
                        aar.akW(str);
                    }
                    aar.akH(me.title);
                    aar.akI(me.description);
                    aar.mo27398a(aas);
                    aar.alc(C40444g.m69400a(aas.whw));
                    aar.ald(C40444g.m69406b(aas.whw));
                    aar.mo27433mh(c7620bi.field_msgId);
                    if (C7616ad.aox(aas.whw.whU)) {
                        str = C42249a.m74595A(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(aas.whw.whU));
                        if (!C5046bo.isNullOrNil(str)) {
                            aar.all(str);
                        }
                    }
                    c45316cl.cvA.cvC.wiv.add(aar);
                    abt = c45316cl.cvA.cvD;
                    abt.fileCount++;
                    AppMethodBeat.m2505o(27293);
                    return true;
                }
                c45316cl.cvA.cvG = C25738R.string.box;
                AppMethodBeat.m2505o(27293);
                return false;
            case 7:
                if (me.csD == null || me.csD.length() == 0) {
                    c45316cl.cvA.cvG = C25738R.string.boi;
                } else {
                    C9638aw.m17190ZK();
                    if (!C18628c.isSDCardAvailable()) {
                        c45316cl.cvA.cvG = C25738R.string.box;
                        AppMethodBeat.m2505o(27293);
                        return false;
                    }
                }
                c45316cl.cvA.cvG = C25738R.string.bop;
                AppMethodBeat.m2505o(27293);
                return false;
            case 10:
                abe = new abe();
                abe.alw(me.title);
                abe.alx(me.description);
                abe.mo27436LK(me.fgP);
                abe.alz(me.fgQ);
                abe.aly(me.thumburl);
                aas.mo48441a(abe);
                aar = new aar();
                aar.akZ(C40444g.m69405ah(c7620bi));
                aar.mo27394LE(10);
                aar.mo27435oY(true);
                aar.mo27434oX(true);
                aar.mo27398a(aas);
                aar.alc(C40444g.m69400a(aas.whw));
                aar.ald(C40444g.m69406b(aas.whw));
                if (C7616ad.aox(aas.whw.whU)) {
                    str = C42249a.m74595A(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(aas.whw.whU));
                    if (!C5046bo.isNullOrNil(str)) {
                        aar.all(str);
                    }
                }
                c45316cl.cvA.cvC.wiv.add(aar);
                abt = c45316cl.cvA.cvD;
                abt.wiS++;
                AppMethodBeat.m2505o(27293);
                return true;
            case 13:
                abe = new abe();
                abe.alw(me.title);
                abe.alx(me.description);
                abe.mo27436LK(me.fgV);
                abe.alz(me.fgW);
                abe.aly(me.thumburl);
                aas.mo48441a(abe);
                aar = new aar();
                aar.akZ(C40444g.m69405ah(c7620bi));
                aar.mo27394LE(11);
                aar.mo27435oY(true);
                aar.mo27434oX(true);
                aar.mo27398a(aas);
                aar.alc(C40444g.m69400a(aas.whw));
                aar.ald(C40444g.m69406b(aas.whw));
                if (C7616ad.aox(aas.whw.whU)) {
                    str = C42249a.m74595A(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(aas.whw.whU));
                    if (!C5046bo.isNullOrNil(str)) {
                        aar.all(str);
                    }
                }
                c45316cl.cvA.cvC.wiv.add(aar);
                abt = c45316cl.cvA.cvD;
                abt.wiT++;
                AppMethodBeat.m2505o(27293);
                return true;
            case 19:
                boolean z = me.fgU != null && me.fgU.contains("<recordxml>");
                if (!z) {
                    aar aar2 = new aar();
                    aar2.akZ(C40444g.m69405ah(c7620bi));
                    aar2.mo27394LE(17);
                    aar2.mo27435oY(true);
                    aar2.akH(me.title);
                    aar2.alh(me.fgU);
                    String str2 = me.description;
                    C18348nt c18348nt = new C18348nt();
                    c18348nt.cJY.type = 0;
                    c18348nt.cJY.cKa = me.fgU;
                    C4879a.xxA.mo10055m(c18348nt);
                    C44099c c44099c = c18348nt.cJZ.cKi;
                    if (c44099c != null) {
                        Iterator it = c44099c.fjr.iterator();
                        while (it.hasNext()) {
                            if (!C5046bo.isNullOrNil(((aar) it.next()).whr)) {
                                c45316cl.cvA.cvG = C25738R.string.bop;
                                AppMethodBeat.m2505o(27293);
                                return false;
                            }
                        }
                    }
                    if (c44099c != null) {
                        str = c44099c.desc;
                    } else {
                        str = str2;
                    }
                    aar2.akI(str);
                    aar2.mo27398a(aas);
                    aar2.alc(C40444g.m69400a(aas.whw));
                    aar2.ald(C40444g.m69406b(aas.whw));
                    aar2.mo27433mh(c7620bi.field_msgId);
                    if (C7616ad.aox(aas.whw.whU)) {
                        str = C42249a.m74595A(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(aas.whw.whU));
                        if (!C5046bo.isNullOrNil(str)) {
                            aar2.all(str);
                        }
                    }
                    c45316cl.cvA.cvC.wiv.add(aar2);
                    AppMethodBeat.m2505o(27293);
                    return true;
                }
                break;
            case 20:
                abo abo = new abo();
                abo.alM(me.title);
                abo.alN(me.description);
                abo.alP(me.fgT);
                abo.alO(me.thumburl);
                aas.mo48442a(abo);
                aar = new aar();
                aar.akZ(C40444g.m69405ah(c7620bi));
                aar.mo27394LE(14);
                aar.mo27435oY(true);
                aar.mo27434oX(true);
                aar.mo27398a(aas);
                aar.alc(C40444g.m69400a(aas.whw));
                aar.ald(C40444g.m69406b(aas.whw));
                if (C7616ad.aox(aas.whw.whU)) {
                    str = C42249a.m74595A(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(aas.whw.whU));
                    if (!C5046bo.isNullOrNil(str)) {
                        aar.all(str);
                    }
                }
                c45316cl.cvA.cvC.wiv.add(aar);
                abt = c45316cl.cvA.cvD;
                abt.wiW++;
                AppMethodBeat.m2505o(27293);
                return true;
            case 33:
            case 36:
                aar = new aar();
                aar.akZ(C40444g.m69405ah(c7620bi));
                aar.akH(me.title);
                aar.akI(me.description);
                aar.mo27394LE(19);
                str = C32291o.ahl().mo73074I(c7620bi.field_imgPath, true);
                if (C5046bo.isNullOrNil(str)) {
                    aar.mo27435oY(true);
                }
                if (C1173e.m2561ct(str)) {
                    aar.akW(str);
                }
                aap aap = new aap();
                if (!C5046bo.isNullOrNil(me.fiP)) {
                    aap.username = me.fiP;
                }
                if (!C5046bo.isNullOrNil(me.fiQ)) {
                    aap.appId = me.fiQ;
                }
                if (!C5046bo.isNullOrNil(me.fjb)) {
                    aap.iconUrl = me.fjb;
                }
                aap.type = me.fiR;
                aap.cBc = me.fiT;
                aap.csu = me.fiO;
                aap.wfO = me.cMh;
                aas.mo48439a(aap);
                aar.mo27398a(aas);
                aar.alc(C40444g.m69400a(aas.whw));
                aar.ald(C40444g.m69406b(aas.whw));
                aar.mo27433mh(c7620bi.field_msgId);
                if (C7616ad.aox(aas.whw.whU)) {
                    str = C42249a.m74595A(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(aas.whw.whU));
                    if (!C5046bo.isNullOrNil(str)) {
                        aar.all(str);
                    }
                }
                c45316cl.cvA.cvC.wiv.add(aar);
                AppMethodBeat.m2505o(27293);
                return true;
            case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                str = me.mo20339p(context, true);
                if (C5046bo.isNullOrNil(str)) {
                    c45316cl.cvA.cvG = C25738R.string.bop;
                    AppMethodBeat.m2505o(27293);
                    return false;
                }
                c45316cl.cvA.cvC.wiv.add(C40444g.m69399a(c7620bi, str + me.title, aas));
                AppMethodBeat.m2505o(27293);
                return true;
            case 46:
                c45316cl.cvA.cvC.wiv.add(C40444g.m69399a(c7620bi, context.getString(C25738R.string.f9185s4), aas));
                AppMethodBeat.m2505o(27293);
                return true;
        }
        c45316cl.cvA.cvG = C25738R.string.bop;
        AppMethodBeat.m2505o(27293);
        return false;
    }

    /* renamed from: c */
    private static boolean m69410c(C45316cl c45316cl, C7620bi c7620bi) {
        AppMethodBeat.m2504i(27294);
        try {
            C32223o b = ((C27500a) C1720g.m3528K(C27500a.class)).mo35246b(c7620bi.field_msgId, c7620bi.field_content);
            LinkedList<C32224p> linkedList = b.fjr;
            if (linkedList != null) {
                int i = 0;
                for (C32224p c32224p : linkedList) {
                    if (!C1192l.m2624mg(c32224p.fjC)) {
                        aas aas = new aas();
                        aas.mo48444c(C40444g.m69404ag(c7620bi));
                        aas.whw.alt(b.cMg);
                        aas.whw.als(c32224p.url);
                        aar aar = new aar();
                        aar.akH(c32224p.title);
                        aar.akI(c32224p.fjz);
                        aar.akZ(C40444g.m69405ah(c7620bi));
                        if (C5046bo.isNullOrNil(c32224p.fjx)) {
                            aar.mo27435oY(true);
                        } else {
                            aar.akW(C30080q.m47642v(c32224p.fjx, c7620bi.getType(), i == 0 ? "@T" : "@S"));
                        }
                        aar.mo27434oX(true);
                        abu abu = new abu();
                        if (!C5046bo.isNullOrNil(c32224p.title)) {
                            abu.alQ(c32224p.title);
                        }
                        if (!C5046bo.isNullOrNil(c32224p.fjz)) {
                            abu.alR(c32224p.fjz);
                        }
                        if (!C5046bo.isNullOrNil(c32224p.fjx)) {
                            abu.alT(C1192l.m2619a(c32224p));
                        }
                        if (abu.computeSize() > 0) {
                            abu.mo27441LO(1);
                            aas.mo48443a(abu);
                        }
                        aar.mo27394LE(5);
                        aar.mo27398a(aas);
                        aar.alc(C40444g.m69400a(aas.whw));
                        aar.ald(C40444g.m69406b(aas.whw));
                        if (C7616ad.aox(aas.whw.whU)) {
                            String A = C42249a.m74595A(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(aas.whw.whU));
                            if (!C5046bo.isNullOrNil(A)) {
                                aar.all(A);
                            }
                        }
                        c45316cl.cvA.cvC.wiv.add(aar);
                        abt abt = c45316cl.cvA.cvD;
                        abt.wiO++;
                        i++;
                    }
                }
                if (i == 0) {
                    c45316cl.cvA.cvG = C25738R.string.bop;
                    AppMethodBeat.m2505o(27294);
                    return false;
                }
                AppMethodBeat.m2505o(27294);
                return true;
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.GetFavRecordDataSource", e, "", new Object[0]);
            C4990ab.m7413e("MicroMsg.GetFavRecordDataSource", "retransmit app msg error : %s", e.getLocalizedMessage());
        }
        c45316cl.cvA.cvG = C25738R.string.bor;
        AppMethodBeat.m2505o(27294);
        return false;
    }

    /* renamed from: a */
    private static String m69400a(aat aat) {
        AppMethodBeat.m2504i(27281);
        String str = aat.whU;
        if (C5046bo.isNullOrNil(str)) {
            str = aat.cEV;
        }
        if (C25754e.m40904rr(str)) {
            str = C25754e.m40906rt(str);
            AppMethodBeat.m2505o(27281);
            return str;
        }
        str = C1854s.m3865mI(str);
        AppMethodBeat.m2505o(27281);
        return str;
    }

    /* renamed from: ah */
    private static String m69405ah(C7620bi c7620bi) {
        AppMethodBeat.m2504i(27283);
        String valueOf;
        if (c7620bi.field_isSend != 1) {
            valueOf = String.valueOf(c7620bi.field_msgSvrId);
            AppMethodBeat.m2505o(27283);
            return valueOf;
        } else if (C1855t.m3896kH(c7620bi.field_talker) || c7620bi.field_talker.equals("filehelper")) {
            valueOf = String.format("%d", new Object[]{Long.valueOf(c7620bi.field_msgSvrId)});
            AppMethodBeat.m2505o(27283);
            return valueOf;
        } else {
            valueOf = String.format("%s#%d", new Object[]{c7620bi.field_talker, Long.valueOf(c7620bi.field_msgSvrId)});
            AppMethodBeat.m2505o(27283);
            return valueOf;
        }
    }
}
