package com.tencent.p177mm.plugin.record.p492b;

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
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
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
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.pluginsdk.model.C30080q;
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

/* renamed from: com.tencent.mm.plugin.record.b.b */
public final class C46164b {
    private static final SimpleDateFormat pJi = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    static {
        AppMethodBeat.m2504i(135638);
        AppMethodBeat.m2505o(135638);
    }

    /* renamed from: a */
    public static boolean m86180a(Context context, C45316cl c45316cl, String str, List<C7620bi> list) {
        AppMethodBeat.m2504i(135626);
        if (list == null || list.isEmpty() || context == null) {
            C4990ab.m7420w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "fill favorite event fail, event or msgs is null");
            c45316cl.cvA.cvG = C25738R.string.boh;
            AppMethodBeat.m2505o(135626);
            return false;
        }
        String str2;
        for (C7620bi c7620bi : list) {
            if (C1831bh.m3770o(c7620bi)) {
                switch (c7620bi.getType() & CdnLogic.kBizGeneric) {
                    case 1:
                        c7620bi.setContent(context.getString(C25738R.string.f9236tx));
                        break;
                    case 3:
                        c7620bi.setContent(context.getString(C25738R.string.f9199sn));
                        c7620bi.setType(1);
                        break;
                    case 43:
                        c7620bi.setContent(context.getString(C25738R.string.f9253ud));
                        c7620bi.setType(1);
                        break;
                    case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                        c7620bi.setContent(context.getString(C25738R.string.f9246u7));
                        c7620bi.setType(1);
                        break;
                    default:
                        break;
                }
            }
        }
        boolean kq = C17903f.m28103kq(str);
        list.size();
        c45316cl.cvA.cvC = new abf();
        c45316cl.cvA.cvD = new abt();
        if (context != null) {
            if (kq) {
                if (C25754e.m40905rs(C25754e.m40900fD(((C7620bi) list.get(0)).field_bizChatId))) {
                    c45316cl.cvA.cvC.alB(context.getString(C25738R.string.dja));
                } else {
                    if (C25754e.m40908rv(str) != null) {
                        c45316cl.cvA.cvC.alB(context.getString(C25738R.string.bqi, new Object[]{r1.field_userName, C25754e.m40906rt(str2)}));
                    }
                }
            } else if (C1855t.m3896kH(str)) {
                c45316cl.cvA.cvC.alB(context.getString(C25738R.string.dja));
            } else {
                if (C5046bo.nullAsNil(C1853r.m3820YB()).equals(C5046bo.nullAsNil(C1854s.m3865mI(str)))) {
                    c45316cl.cvA.cvC.alB(context.getString(C25738R.string.bqj, new Object[]{str2}));
                } else {
                    c45316cl.cvA.cvC.alB(context.getString(C25738R.string.bqi, new Object[]{C1853r.m3820YB(), C1854s.m3865mI(str)}));
                }
            }
            C4990ab.m7411d("MicroMsg.GetFavRecordDataSourceForRecordMsg", "title %s", c45316cl.cvA.cvC.title);
        }
        abf abf = c45316cl.cvA.cvC;
        abl abl = new abl();
        abl.alD(str);
        abl.mo39126LN(1);
        abl.mo39136ml(C5046bo.anU());
        abl.alF("");
        abf.mo74737a(abl);
        c45316cl.cvA.type = 14;
        Object obj = null;
        boolean z = true;
        for (C7620bi c7620bi2 : list) {
            if (c7620bi2 == null) {
                C4990ab.m7420w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "fill favorite event fail, event or msg is null");
                c45316cl.cvA.cvG = C25738R.string.boh;
                kq = false;
            } else {
                C7620bi ar = C7620bi.m13569ar(c7620bi2);
                kq = false;
                aar aar;
                abt abt;
                aas aas;
                aar aar2;
                if (ar.isText()) {
                    aas aas2 = new aas();
                    aas2.mo48444c(C46164b.m86182ag(ar));
                    aar = new aar();
                    aar.akZ(C46164b.m86183ah(ar));
                    aar.mo27394LE(1);
                    if (ar.dtV()) {
                        str2 = C4996ah.getContext().getString(C25738R.string.dtl, new Object[]{"@"}) + 10;
                    } else {
                        str2 = "";
                    }
                    if (ar.dtM()) {
                        aar.akI(str2 + ar.field_content + "\n\n" + ar.field_transContent);
                    } else {
                        aar.akI(str2 + ar.field_content);
                    }
                    aar.mo27435oY(true);
                    aar.mo27434oX(true);
                    aar.mo27398a(aas2);
                    aar.alc(C46164b.m86177a(aas2.whw));
                    aar.ald(C46164b.m86184b(aas2.whw));
                    if (C7616ad.aox(aas2.whw.whU)) {
                        str2 = C42249a.m74595A(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(aas2.whw.whU));
                        if (!C5046bo.isNullOrNil(str2)) {
                            aar.all(str2);
                        }
                    }
                    c45316cl.cvA.cvC.wiv.add(aar);
                    abt = c45316cl.cvA.cvD;
                    abt.wiK++;
                    kq = true;
                } else if (ar.drD()) {
                    aas = new aas();
                    aas.mo48444c(C46164b.m86182ag(ar));
                    aar2 = new aar();
                    aar2.akZ(C46164b.m86183ah(ar));
                    aar2.mo27394LE(3);
                    aar2.mo27435oY(true);
                    aar2.mo27434oX(true);
                    aar2.mo27398a(aas);
                    aar2.alc(C46164b.m86177a(aas.whw));
                    aar2.ald(C46164b.m86184b(aas.whw));
                    if (C7616ad.aox(aas.whw.whU)) {
                        str2 = C42249a.m74595A(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(aas.whw.whU));
                        if (!C5046bo.isNullOrNil(str2)) {
                            aar2.all(str2);
                        }
                    }
                    c45316cl.cvA.cvC.wiv.add(aar2);
                    abt = c45316cl.cvA.cvD;
                    abt.wiM++;
                    kq = true;
                } else if (ar.bAC()) {
                    kq = C46164b.m86181a(c45316cl, ar);
                } else if (ar.drE()) {
                    C25822e c25822e = null;
                    if (ar.field_msgId > 0) {
                        c25822e = C32291o.ahl().mo73113fJ((long) ((int) ar.field_msgId));
                    }
                    if ((c25822e == null || c25822e.fDy <= 0) && ar.field_msgSvrId > 0) {
                        c25822e = C32291o.ahl().mo73112fI(ar.field_msgSvrId);
                    }
                    if (c25822e == null) {
                        C4990ab.m7420w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "getImgDataPath: try get imgInfo fail");
                        c45316cl.cvA.cvG = C25738R.string.bon;
                        kq = false;
                    } else {
                        C25822e ly;
                        int i;
                        aas = new aas();
                        aas.mo48444c(C46164b.m86182ag(ar));
                        aar = new aar();
                        aar.akZ(C46164b.m86183ah(ar));
                        aar.mo27394LE(2);
                        aar.akV(C32291o.ahl().mo73118q(C37478f.m63227c(c25822e), "", ""));
                        if (c25822e.agQ()) {
                            C25822e ly2 = C32291o.ahl().mo73116ly(c25822e.fDJ);
                            if (ly2.frO > ly2.offset) {
                                aar.akV(C32291o.ahl().mo73118q("SERVERID://" + ar.field_msgSvrId, "", ""));
                            }
                        }
                        aar.akW(C32291o.ahl().mo73074I(ar.field_imgPath, true));
                        aar.mo27398a(aas);
                        aar.alc(C46164b.m86177a(aas.whw));
                        aar.ald(C46164b.m86184b(aas.whw));
                        aar.mo27433mh(ar.field_msgId);
                        if (C7616ad.aox(aas.whw.whU)) {
                            str2 = C42249a.m74595A(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(aas.whw.whU));
                            if (!C5046bo.isNullOrNil(str2)) {
                                aar.all(str2);
                            }
                        }
                        if (c25822e.agQ() && c25822e.frO == 0) {
                            ly = C32291o.ahl().mo73116ly(c25822e.fDJ);
                        } else {
                            ly = c25822e;
                        }
                        if (ar.field_isSend == 1) {
                            if (ly.agQ()) {
                                i = 1;
                            } else {
                                i = 0;
                            }
                        } else if (ly.agQ()) {
                            if (C1173e.m2561ct(C32291o.ahl().mo73118q(C37478f.m63225a(ly).fDz, "", ""))) {
                                i = 1;
                            } else {
                                i = 0;
                            }
                        } else {
                            i = 0;
                        }
                        Map z2 = C5049br.m7595z(ly.fDK, "msg");
                        if (z2 == null) {
                            C4990ab.m7417i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "parse cdnInfo failed. [%s]", ly.fDK);
                        } else if (i == 1) {
                            aar.akL((String) z2.get(".msg.img.$cdnbigimgurl"));
                            aar.mo27431mf((long) C5046bo.getInt((String) z2.get(".msg.img.$length"), 0));
                            aar.akM((String) z2.get(".msg.img.$aeskey"));
                        }
                        c45316cl.cvA.cvC.wiv.add(aar);
                        abt = c45316cl.cvA.cvD;
                        abt.wiL++;
                        kq = true;
                    }
                } else if (ar.bws()) {
                    kq = C46164b.m86185b(c45316cl, ar);
                } else if (ar.bwt()) {
                    kq = C46164b.m86185b(c45316cl, ar);
                } else if (ar.getType() == 318767153) {
                    kq = C46164b.m86179a(context, c45316cl, ar, 3);
                } else if (ar.drC()) {
                    kq = C46164b.m86186c(c45316cl, ar);
                } else if (ar.dtx() || ar.dty()) {
                    kq = C46164b.m86179a(context, c45316cl, ar, 1);
                } else if (ar.getType() == 419430449) {
                    kq = C46164b.m86179a(context, c45316cl, ar, 2);
                } else if (ar.dtw()) {
                    Object obj2;
                    C5135a Rn = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15260Rn(ar.field_content);
                    aas aas3 = new aas();
                    aas3.mo48444c(C46164b.m86182ag(ar));
                    if (Rn != null && C1855t.m3897kv(Rn.ufB)) {
                        aar2 = new aar();
                        aar2.akZ(C46164b.m86183ah(ar));
                        aar2.mo27394LE(16);
                        aar2.akI(ar.field_content);
                        aar2.mo27435oY(true);
                        aar2.mo27434oX(true);
                        aar2.mo27398a(aas3);
                        aar2.alc(C46164b.m86177a(aas3.whw));
                        aar2.ald(C46164b.m86184b(aas3.whw));
                        if (C7616ad.aox(aas3.whw.whU)) {
                            str2 = C42249a.m74595A(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(aas3.whw.whU));
                            if (!C5046bo.isNullOrNil(str2)) {
                                aar2.all(str2);
                            }
                            obj2 = aar2;
                        } else {
                            aar obj22 = aar2;
                        }
                    } else if (Rn == null || !C7616ad.aox(Rn.svN)) {
                        obj22 = C46164b.m86176a(ar, context.getString(C25738R.string.f9147qy), aas3);
                    } else {
                        if (TextUtils.isEmpty(((C32873b) C1720g.m3528K(C32873b.class)).mo44300a(Rn.xZm, "openim_card_type_name", C32874a.TYPE_WORDING))) {
                            str2 = context.getResources().getString(C25738R.string.f9147qy);
                        } else {
                            str2 = String.format("[%s]", new Object[]{((C32873b) C1720g.m3528K(C32873b.class)).mo44300a(Rn.xZm, "openim_card_type_name", C32874a.TYPE_WORDING)});
                        }
                        obj22 = C46164b.m86176a(ar, str2, aas3);
                    }
                    c45316cl.cvA.cvC.wiv.add(obj22);
                    abt = c45316cl.cvA.cvD;
                    abt.wiX++;
                    kq = true;
                } else if (!ar.bAA()) {
                    c45316cl.cvA.cvG = C25738R.string.bop;
                    kq = C46164b.m86179a(context, c45316cl, ar, 3);
                } else if (ar.dty()) {
                    c45316cl.cvA.cvG = C25738R.string.bop;
                } else {
                    kq = C46164b.m86178a(context, c45316cl, ar);
                }
            }
            if (kq) {
                obj = 1;
            } else {
                z = false;
            }
        }
        if (obj != null && c45316cl.cvA.cvG > 0) {
            c45316cl.cvA.cvG = 0;
        }
        AppMethodBeat.m2505o(135626);
        return z;
    }

    /* renamed from: a */
    private static boolean m86179a(Context context, C45316cl c45316cl, C7620bi c7620bi, int i) {
        AppMethodBeat.m2504i(135627);
        aas aas = new aas();
        aas.mo48444c(C46164b.m86182ag(c7620bi));
        String str = null;
        if (i == 1) {
            str = context.getString(C25738R.string.f9100ph);
        } else if (i == 2) {
            str = context.getString(C25738R.string.f9191s_);
        } else if (i == 3) {
            str = context.getString(C25738R.string.f9232ts);
        }
        c45316cl.cvA.cvC.wiv.add(C46164b.m86176a(c7620bi, str, aas));
        AppMethodBeat.m2505o(135627);
        return true;
    }

    /* renamed from: ag */
    private static aat m86182ag(C7620bi c7620bi) {
        AppMethodBeat.m2504i(135628);
        aat aat = new aat();
        if (c7620bi == null) {
            AppMethodBeat.m2505o(135628);
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
        AppMethodBeat.m2505o(135628);
        return aat;
    }

    /* renamed from: b */
    private static String m86184b(aat aat) {
        AppMethodBeat.m2504i(135630);
        String format = pJi.format(new Date(aat.createTime));
        AppMethodBeat.m2505o(135630);
        return format;
    }

    /* renamed from: a */
    private static boolean m86181a(C45316cl c45316cl, C7620bi c7620bi) {
        AppMethodBeat.m2504i(135632);
        aas aas = new aas();
        aas.mo48444c(C46164b.m86182ag(c7620bi));
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
                aar.akZ(C46164b.m86183ah(c7620bi));
                aar.mo27394LE(6);
                aar.mo27435oY(true);
                aar.mo27434oX(true);
                aar.mo27398a(aas);
                aar.alc(C46164b.m86177a(aas.whw));
                aar.ald(C46164b.m86184b(aas.whw));
                if (C7616ad.aox(aas.whw.whU)) {
                    String A = C42249a.m74595A(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(aas.whw.whU));
                    if (!C5046bo.isNullOrNil(A)) {
                        aar.all(A);
                    }
                }
                c45316cl.cvA.cvC.wiv.add(aar);
                abt abt = c45316cl.cvA.cvD;
                abt.wiP++;
                AppMethodBeat.m2505o(135632);
                return true;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.GetFavRecordDataSourceForRecordMsg", "parse failed, %s", e.getStackTrace().toString());
            }
        }
        c45316cl.cvA.cvG = C25738R.string.bor;
        AppMethodBeat.m2505o(135632);
        return false;
    }

    /* renamed from: b */
    private static boolean m86185b(C45316cl c45316cl, C7620bi c7620bi) {
        AppMethodBeat.m2504i(135633);
        aas aas = new aas();
        aas.mo48444c(C46164b.m86182ag(c7620bi));
        aar aar = new aar();
        aar.akZ(C46164b.m86183ah(c7620bi));
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
            C4990ab.m7416i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "video info null");
            c45316cl.cvA.cvG = C25738R.string.bog;
            AppMethodBeat.m2505o(135633);
            return false;
        }
        C4990ab.m7417i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "video length is %d", Integer.valueOf(ut.frO));
        if (ut.frO > C42164b.m74341Nc()) {
            c45316cl.cvA.cvG = C25738R.string.bs4;
            AppMethodBeat.m2505o(135633);
            return false;
        } else if (c7620bi.bwt() && C26494u.m42270uv(ut.getFileName())) {
            c45316cl.cvA.cvG = C25738R.string.bog;
            AppMethodBeat.m2505o(135633);
            return false;
        } else {
            aar.mo27393LD(ut.fXd);
            aar.mo27398a(aas);
            aar.alc(C46164b.m86177a(aas.whw));
            aar.ald(C46164b.m86184b(aas.whw));
            if (C7616ad.aox(aas.whw.whU)) {
                String A = C42249a.m74595A(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(aas.whw.whU));
                if (!C5046bo.isNullOrNil(A)) {
                    aar.all(A);
                }
            }
            aar.mo27433mh(c7620bi.field_msgId);
            aar.mo27431mf((long) ut.frO);
            Map z = C5049br.m7595z(ut.alw(), "msg");
            if (z != null) {
                aar.akL((String) z.get(".msg.videomsg.$cdnvideourl"));
                aar.akM((String) z.get(".msg.videomsg.$aeskey"));
            } else {
                C4990ab.m7416i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "cdntra parse video recv xml failed");
            }
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
            AppMethodBeat.m2505o(135633);
            return true;
        }
    }

    /* renamed from: a */
    private static aar m86175a(C7620bi c7620bi, C8910b c8910b, int i) {
        AppMethodBeat.m2504i(135634);
        aar aar = new aar();
        aar.akZ(C46164b.m86183ah(c7620bi));
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
        AppMethodBeat.m2505o(135634);
        return aar;
    }

    /* renamed from: a */
    private static aar m86176a(C7620bi c7620bi, String str, aas aas) {
        AppMethodBeat.m2504i(135635);
        aar aar = new aar();
        aar.akZ(C46164b.m86183ah(c7620bi));
        aar.mo27394LE(1);
        aar.akI(str);
        aar.mo27435oY(true);
        aar.mo27434oX(true);
        aar.mo27398a(aas);
        aar.alc(C46164b.m86177a(aas.whw));
        aar.ald(C46164b.m86184b(aas.whw));
        if (C7616ad.aox(aas.whw.whU)) {
            String A = C42249a.m74595A(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(aas.whw.whU));
            if (!C5046bo.isNullOrNil(A)) {
                aar.all(A);
            }
        }
        AppMethodBeat.m2505o(135635);
        return aar;
    }

    /* renamed from: a */
    private static boolean m86178a(Context context, C45316cl c45316cl, C7620bi c7620bi) {
        AppMethodBeat.m2504i(135636);
        aas aas = new aas();
        aas.mo48444c(C46164b.m86182ag(c7620bi));
        String str = c7620bi.field_content;
        if (str == null) {
            c45316cl.cvA.cvG = C25738R.string.bor;
            AppMethodBeat.m2505o(135636);
            return false;
        }
        C8910b me = C8910b.m16064me(str);
        if (me == null) {
            c45316cl.cvA.cvG = C25738R.string.bor;
            AppMethodBeat.m2505o(135636);
            return false;
        }
        aas.whw.alr(me.appId);
        aas.whw.alt(me.cMg);
        C40439f bT = C46494g.m87739bT(me.appId, true);
        if (bT == null || !bT.mo63847xy()) {
            aar aar;
            abt abt;
            C30065b aiE;
            abe abe;
            switch (me.type) {
                case 1:
                    aar = new aar();
                    aar.akZ(C46164b.m86183ah(c7620bi));
                    aar.mo27394LE(1);
                    aar.akI(me.title);
                    aar.mo27435oY(true);
                    aar.mo27434oX(true);
                    aar.mo27398a(aas);
                    aar.alc(C46164b.m86177a(aas.whw));
                    aar.ald(C46164b.m86184b(aas.whw));
                    if (C7616ad.aox(aas.whw.whU)) {
                        str = C42249a.m74595A(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(aas.whw.whU));
                        if (!C5046bo.isNullOrNil(str)) {
                            aar.all(str);
                        }
                    }
                    c45316cl.cvA.cvC.wiv.add(aar);
                    abt = c45316cl.cvA.cvD;
                    abt.wiK++;
                    AppMethodBeat.m2505o(135636);
                    return true;
                case 2:
                    C1720g.m3537RQ();
                    if (C1720g.m3536RP().isSDCardAvailable()) {
                        aiE = C34832a.aUq().aiE(me.csD);
                        aar = new aar();
                        aar.akZ(C46164b.m86183ah(c7620bi));
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
                        aar.alc(C46164b.m86177a(aas.whw));
                        aar.ald(C46164b.m86184b(aas.whw));
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
                        AppMethodBeat.m2505o(135636);
                        return true;
                    }
                    c45316cl.cvA.cvG = C25738R.string.box;
                    AppMethodBeat.m2505o(135636);
                    return false;
                case 3:
                    aar = C46164b.m86175a(c7620bi, me, 7);
                    aar.mo27398a(aas);
                    aar.alc(C46164b.m86177a(aas.whw));
                    aar.ald(C46164b.m86184b(aas.whw));
                    if (C7616ad.aox(aas.whw.whU)) {
                        str = C42249a.m74595A(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(aas.whw.whU));
                        if (!C5046bo.isNullOrNil(str)) {
                            aar.all(str);
                        }
                    }
                    c45316cl.cvA.cvC.wiv.add(aar);
                    abt = c45316cl.cvA.cvD;
                    abt.wiQ++;
                    AppMethodBeat.m2505o(135636);
                    return true;
                case 4:
                    aar = C46164b.m86175a(c7620bi, me, 4);
                    aar.mo27398a(aas);
                    aar.alc(C46164b.m86177a(aas.whw));
                    aar.ald(C46164b.m86184b(aas.whw));
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
                    AppMethodBeat.m2505o(135636);
                    return true;
                case 5:
                    if (me.url == null || me.url.equals("")) {
                        c45316cl.cvA.cvG = C25738R.string.bol;
                        c45316cl.cvA.cvC.wiv.add(C46164b.m86176a(c7620bi, context.getString(C25738R.string.f9232ts), aas));
                        AppMethodBeat.m2505o(135636);
                        return true;
                    }
                    aas.whw.als(me.url);
                    aar = C46164b.m86175a(c7620bi, me, 5);
                    aar.mo27398a(aas);
                    aar.alc(C46164b.m86177a(aas.whw));
                    aar.ald(C46164b.m86184b(aas.whw));
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
                    AppMethodBeat.m2505o(135636);
                    return true;
                case 6:
                    C1720g.m3537RQ();
                    if (C1720g.m3536RP().isSDCardAvailable()) {
                        aiE = C34832a.aUq().aiE(me.csD);
                        aar = new aar();
                        if (aiE != null) {
                            aar.akV(aiE.field_fileFullPath);
                        }
                        aar.akZ(C46164b.m86183ah(c7620bi));
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
                        aar.alc(C46164b.m86177a(aas.whw));
                        aar.ald(C46164b.m86184b(aas.whw));
                        aar.mo27433mh(c7620bi.field_msgId);
                        if (C7616ad.aox(aas.whw.whU)) {
                            str = C42249a.m74595A(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(aas.whw.whU));
                            if (!C5046bo.isNullOrNil(str)) {
                                aar.all(str);
                            }
                        }
                        aar.akL(me.fgD);
                        aar.akM(me.eyr);
                        aar.alk(me.fgu);
                        aar.ali(me.eyr);
                        aar.alj(me.fgA);
                        c45316cl.cvA.cvC.wiv.add(aar);
                        abt = c45316cl.cvA.cvD;
                        abt.fileCount++;
                        AppMethodBeat.m2505o(135636);
                        return true;
                    }
                    c45316cl.cvA.cvG = C25738R.string.box;
                    AppMethodBeat.m2505o(135636);
                    return false;
                case 7:
                    if (me.csD == null || me.csD.length() == 0) {
                        c45316cl.cvA.cvG = C25738R.string.boi;
                    } else {
                        C1720g.m3537RQ();
                        if (!C1720g.m3536RP().isSDCardAvailable()) {
                            c45316cl.cvA.cvG = C25738R.string.box;
                            AppMethodBeat.m2505o(135636);
                            return false;
                        }
                    }
                    c45316cl.cvA.cvG = C25738R.string.bop;
                    AppMethodBeat.m2505o(135636);
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
                    aar.akZ(C46164b.m86183ah(c7620bi));
                    aar.mo27394LE(10);
                    aar.mo27435oY(true);
                    aar.mo27434oX(true);
                    aar.mo27398a(aas);
                    aar.alc(C46164b.m86177a(aas.whw));
                    aar.ald(C46164b.m86184b(aas.whw));
                    if (C7616ad.aox(aas.whw.whU)) {
                        str = C42249a.m74595A(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(aas.whw.whU));
                        if (!C5046bo.isNullOrNil(str)) {
                            aar.all(str);
                        }
                    }
                    c45316cl.cvA.cvC.wiv.add(aar);
                    abt = c45316cl.cvA.cvD;
                    abt.wiS++;
                    AppMethodBeat.m2505o(135636);
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
                    aar.akZ(C46164b.m86183ah(c7620bi));
                    aar.mo27394LE(11);
                    aar.mo27435oY(true);
                    aar.mo27434oX(true);
                    aar.mo27398a(aas);
                    aar.alc(C46164b.m86177a(aas.whw));
                    aar.ald(C46164b.m86184b(aas.whw));
                    if (C7616ad.aox(aas.whw.whU)) {
                        str = C42249a.m74595A(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(aas.whw.whU));
                        if (!C5046bo.isNullOrNil(str)) {
                            aar.all(str);
                        }
                    }
                    c45316cl.cvA.cvC.wiv.add(aar);
                    abt = c45316cl.cvA.cvD;
                    abt.wiT++;
                    AppMethodBeat.m2505o(135636);
                    return true;
                case 16:
                    c45316cl.cvA.cvC.wiv.add(C46164b.m86176a(c7620bi, context.getString(C25738R.string.f9203su), aas));
                    AppMethodBeat.m2505o(135636);
                    return true;
                case 19:
                    boolean z = me.fgU != null && me.fgU.contains("<recordxml>");
                    if (!z) {
                        aar aar2 = new aar();
                        aar2.akZ(C46164b.m86183ah(c7620bi));
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
                                    AppMethodBeat.m2505o(135636);
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
                        aar2.alc(C46164b.m86177a(aas.whw));
                        aar2.ald(C46164b.m86184b(aas.whw));
                        aar2.mo27433mh(c7620bi.field_msgId);
                        if (C7616ad.aox(aas.whw.whU)) {
                            str = C42249a.m74595A(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(aas.whw.whU));
                            if (!C5046bo.isNullOrNil(str)) {
                                aar2.all(str);
                            }
                        }
                        c45316cl.cvA.cvC.wiv.add(aar2);
                        AppMethodBeat.m2505o(135636);
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
                    aar.akZ(C46164b.m86183ah(c7620bi));
                    aar.mo27394LE(14);
                    aar.mo27435oY(true);
                    aar.mo27434oX(true);
                    aar.mo27398a(aas);
                    aar.alc(C46164b.m86177a(aas.whw));
                    aar.ald(C46164b.m86184b(aas.whw));
                    if (C7616ad.aox(aas.whw.whU)) {
                        str = C42249a.m74595A(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(aas.whw.whU));
                        if (!C5046bo.isNullOrNil(str)) {
                            aar.all(str);
                        }
                    }
                    c45316cl.cvA.cvC.wiv.add(aar);
                    abt = c45316cl.cvA.cvD;
                    abt.wiW++;
                    AppMethodBeat.m2505o(135636);
                    return true;
                case 24:
                    break;
                case 33:
                case 36:
                    if (me.fiR == 3) {
                        c45316cl.cvA.cvC.wiv.add(C46164b.m86176a(c7620bi, context.getString(C25738R.string.f9185s4), aas));
                        AppMethodBeat.m2505o(135636);
                        return true;
                    }
                    aar = new aar();
                    aar.akZ(C46164b.m86183ah(c7620bi));
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
                    aar.alc(C46164b.m86177a(aas.whw));
                    aar.ald(C46164b.m86184b(aas.whw));
                    aar.mo27433mh(c7620bi.field_msgId);
                    if (C7616ad.aox(aas.whw.whU)) {
                        str = C42249a.m74595A(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(aas.whw.whU));
                        if (!C5046bo.isNullOrNil(str)) {
                            aar.all(str);
                        }
                    }
                    c45316cl.cvA.cvC.wiv.add(aar);
                    AppMethodBeat.m2505o(135636);
                    return true;
                case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                    str = me.mo20339p(context, true);
                    if (C5046bo.isNullOrNil(str)) {
                        c45316cl.cvA.cvC.wiv.add(C46164b.m86176a(c7620bi, context.getString(C25738R.string.f9232ts), aas));
                        AppMethodBeat.m2505o(135636);
                        return true;
                    }
                    c45316cl.cvA.cvC.wiv.add(C46164b.m86176a(c7620bi, str + me.title, aas));
                    AppMethodBeat.m2505o(135636);
                    return true;
                case 46:
                    c45316cl.cvA.cvC.wiv.add(C46164b.m86176a(c7620bi, context.getString(C25738R.string.f9185s4), aas));
                    AppMethodBeat.m2505o(135636);
                    return true;
                default:
                    c45316cl.cvA.cvC.wiv.add(C46164b.m86176a(c7620bi, context.getString(C25738R.string.f9232ts), aas));
                    AppMethodBeat.m2505o(135636);
                    return true;
            }
            c45316cl.cvA.cvC.wiv.add(C46164b.m86176a(c7620bi, context.getString(C25738R.string.bse), aas));
            AppMethodBeat.m2505o(135636);
            return true;
        }
        c45316cl.cvA.cvC.wiv.add(C46164b.m86176a(c7620bi, context.getString(C25738R.string.f9148qz), aas));
        AppMethodBeat.m2505o(135636);
        return true;
    }

    /* renamed from: c */
    private static boolean m86186c(C45316cl c45316cl, C7620bi c7620bi) {
        AppMethodBeat.m2504i(135637);
        try {
            C32223o b = ((C27500a) C1720g.m3528K(C27500a.class)).mo35246b(c7620bi.field_msgId, c7620bi.field_content);
            LinkedList<C32224p> linkedList = b.fjr;
            if (linkedList != null) {
                int i = 0;
                for (C32224p c32224p : linkedList) {
                    if (!C1192l.m2624mg(c32224p.fjC)) {
                        aas aas = new aas();
                        aas.mo48444c(C46164b.m86182ag(c7620bi));
                        aas.whw.alt(b.cMg);
                        aas.whw.als(c32224p.url);
                        aar aar = new aar();
                        aar.akH(c32224p.title);
                        aar.akI(c32224p.fjz);
                        aar.akZ(C46164b.m86183ah(c7620bi));
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
                        aar.alc(C46164b.m86177a(aas.whw));
                        aar.ald(C46164b.m86184b(aas.whw));
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
                    AppMethodBeat.m2505o(135637);
                    return false;
                }
                AppMethodBeat.m2505o(135637);
                return true;
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.GetFavRecordDataSourceForRecordMsg", e, "", new Object[0]);
            C4990ab.m7413e("MicroMsg.GetFavRecordDataSourceForRecordMsg", "retransmit app msg error : %s", e.getLocalizedMessage());
        }
        c45316cl.cvA.cvG = C25738R.string.bor;
        AppMethodBeat.m2505o(135637);
        return false;
    }

    /* renamed from: a */
    private static String m86177a(aat aat) {
        AppMethodBeat.m2504i(135629);
        String str = aat.whU;
        if (C5046bo.isNullOrNil(str)) {
            str = aat.cEV;
        }
        if (C25754e.m40904rr(str)) {
            str = C25754e.m40906rt(str);
            AppMethodBeat.m2505o(135629);
            return str;
        }
        str = C1854s.m3865mI(str);
        AppMethodBeat.m2505o(135629);
        return str;
    }

    /* renamed from: ah */
    private static String m86183ah(C7620bi c7620bi) {
        AppMethodBeat.m2504i(135631);
        String valueOf;
        if (c7620bi.field_isSend != 1) {
            valueOf = String.valueOf(c7620bi.field_msgSvrId);
            AppMethodBeat.m2505o(135631);
            return valueOf;
        } else if (C1855t.m3896kH(c7620bi.field_talker) || c7620bi.field_talker.equals("filehelper")) {
            valueOf = String.format("%d", new Object[]{Long.valueOf(c7620bi.field_msgSvrId)});
            AppMethodBeat.m2505o(135631);
            return valueOf;
        } else {
            valueOf = String.format("%s#%d", new Object[]{c7620bi.field_talker, Long.valueOf(c7620bi.field_msgSvrId)});
            AppMethodBeat.m2505o(135631);
            return valueOf;
        }
    }
}
