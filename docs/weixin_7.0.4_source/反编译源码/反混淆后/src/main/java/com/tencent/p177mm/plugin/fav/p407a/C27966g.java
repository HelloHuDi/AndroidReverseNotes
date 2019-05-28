package com.tencent.p177mm.plugin.fav.p407a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C9519bo;
import com.tencent.p177mm.plugin.fav.p407a.p1400a.C27960b;
import com.tencent.p177mm.plugin.fav.p407a.p1400a.C27961c;
import com.tencent.p177mm.plugin.fav.p407a.p1400a.C43051a;
import com.tencent.p177mm.protocal.protobuf.aap;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.aat;
import com.tencent.p177mm.protocal.protobuf.aay;
import com.tencent.p177mm.protocal.protobuf.aaz;
import com.tencent.p177mm.protocal.protobuf.abe;
import com.tencent.p177mm.protocal.protobuf.abf;
import com.tencent.p177mm.protocal.protobuf.abl;
import com.tencent.p177mm.protocal.protobuf.abo;
import com.tencent.p177mm.protocal.protobuf.abs;
import com.tencent.p177mm.protocal.protobuf.abu;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.fav.a.g */
public final class C27966g extends C9519bo {
    public static C4924a ccO = C9519bo.m16961Hm();
    private static C27967a meP = new C30691();
    private static C27967a meQ = new C30702();

    /* renamed from: com.tencent.mm.plugin.fav.a.g$1 */
    static class C30691 implements C27967a {
        C30691() {
        }

        public final void log(String str) {
            AppMethodBeat.m2504i(102630);
            C4990ab.m7410d("MicroMsg.FavItemInfo", str);
            AppMethodBeat.m2505o(102630);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.a.g$2 */
    static class C30702 implements C27967a {
        C30702() {
        }

        public final void log(String str) {
            AppMethodBeat.m2504i(102631);
            C4990ab.m7412e("MicroMsg.FavItemInfo", str);
            AppMethodBeat.m2505o(102631);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.a.g$a */
    interface C27967a {
        void log(String str);
    }

    public final /* synthetic */ Object clone() {
        AppMethodBeat.m2504i(102646);
        C27966g buB = buB();
        AppMethodBeat.m2505o(102646);
        return buB;
    }

    static {
        AppMethodBeat.m2504i(102647);
        AppMethodBeat.m2505o(102647);
    }

    public C27966g() {
        AppMethodBeat.m2504i(102632);
        this.field_flag = -1;
        this.field_fromUser = "";
        this.field_toUser = "";
        this.field_id = -1;
        this.field_realChatName = "";
        this.field_sourceType = -1;
        this.field_updateTime = -1;
        this.field_type = -1;
        this.field_updateSeq = -1;
        this.field_xml = "";
        this.field_itemStatus = 0;
        bus();
        AppMethodBeat.m2505o(102632);
    }

    private void bus() {
        AppMethodBeat.m2504i(102633);
        this.field_favProto = new abf();
        abl abl = new abl();
        abl.mo39126LN(1);
        this.field_favProto.mo74737a(abl);
        this.field_favProto.mo74746b(new abu());
        this.field_favProto.mo74743b(new aay());
        this.field_favProto.mo74744b(new abe());
        this.field_favProto.mo74745b(new abo());
        this.field_favProto.mo74734LL(-1);
        this.field_tagProto = new abs();
        this.field_favProto.mo74736a(new aaz());
        AppMethodBeat.m2505o(102633);
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public final boolean but() {
        return (this.field_favProto.whJ & 1) != 0;
    }

    public final boolean buu() {
        return (this.field_favProto.whJ & 2) != 0;
    }

    public final Bundle buv() {
        boolean z;
        AppMethodBeat.m2504i(102634);
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_ctrl_flag_open_chat", but());
        bundle.putBoolean("key_ctrl_flag_open_sns", buu());
        String str = "key_ctrl_flag_open_weibo";
        if ((this.field_favProto.whJ & 4) != 0) {
            z = true;
        } else {
            z = false;
        }
        bundle.putBoolean(str, z);
        str = "key_ctrl_flag_open_cplink";
        if ((this.field_favProto.whJ & 8) != 0) {
            z = true;
        } else {
            z = false;
        }
        bundle.putBoolean(str, z);
        str = "key_ctrl_flag_open_browser";
        if ((this.field_favProto.whJ & 16) != 0) {
            z = true;
        } else {
            z = false;
        }
        bundle.putBoolean(str, z);
        str = "key_ctrl_flag_open_weiyun";
        if ((this.field_favProto.whJ & 32) != 0) {
            z = true;
        } else {
            z = false;
        }
        bundle.putBoolean(str, z);
        str = "key_ctrl_flag_open_facebook";
        if ((this.field_favProto.whJ & 64) != 0) {
            z = true;
        } else {
            z = false;
        }
        bundle.putBoolean(str, z);
        C4990ab.m7417i("MicroMsg.FavItemInfo", "get ctrl args=[%s]", bundle.toString());
        AppMethodBeat.m2505o(102634);
        return bundle;
    }

    public final boolean buw() {
        if (this.field_itemStatus == 1 || this.field_itemStatus == 4 || this.field_itemStatus == 9 || this.field_itemStatus == 12 || this.field_itemStatus == 13 || this.field_itemStatus == 15 || this.field_itemStatus == 17) {
            return true;
        }
        return false;
    }

    public final boolean bux() {
        if (this.field_itemStatus == 3 || this.field_itemStatus == 6 || this.field_itemStatus == 11 || this.field_itemStatus == 14 || this.field_itemStatus == 16 || this.field_itemStatus == 18) {
            return true;
        }
        return false;
    }

    public final boolean isDownloading() {
        return this.field_itemStatus == 7;
    }

    public final boolean buy() {
        return this.field_itemStatus == 8;
    }

    public final boolean isDone() {
        return this.field_itemStatus == 10;
    }

    public final boolean buz() {
        if (this.field_itemStatus == 15 || this.field_itemStatus == 16) {
            return true;
        }
        return false;
    }

    public final boolean buA() {
        if (this.field_itemStatus == 12 || this.field_itemStatus == 13 || this.field_itemStatus == 14) {
            return true;
        }
        return false;
    }

    /* renamed from: LH */
    public final C27966g mo45881LH(String str) {
        AppMethodBeat.m2504i(102635);
        if (str == null || str.equals("")) {
            C4990ab.m7412e("MicroMsg.FavItemInfo", "klem, FavItemInfo xml null");
            AppMethodBeat.m2505o(102635);
        } else {
            Map z = C5049br.m7595z(str, "favitem");
            if (z == null) {
                C4990ab.m7412e("MicroMsg.FavItemInfo", "klem, FavItemInfo maps null");
                AppMethodBeat.m2505o(102635);
            } else {
                try {
                    bus();
                    abf abf = this.field_favProto;
                    abf.alB((String) z.get(".favitem.title"));
                    abf.alC((String) z.get(".favitem.desc"));
                    abf.alA((String) z.get(".favitem.remark"));
                    abf.mo74747mj(C5046bo.getLong((String) z.get(".favitem.remark.$time"), 0));
                    String str2 = (String) z.get(".favitem.edittime");
                    abf.mo74735LM(C5046bo.getInt((String) z.get(".favitem.version"), 0));
                    abf.mo74748mk(C5046bo.getLong(str2, 0));
                    abf.mo74734LL(C5046bo.getInt((String) z.get(".favitem.ctrlflag"), -1));
                    String str3 = ".favitem.source";
                    abl abl = abf.wit;
                    abl.mo39126LN(C5046bo.getInt((String) z.get(str3 + ".$sourcetype"), 0));
                    abl.alF((String) z.get(str3 + ".$sourceid"));
                    abl.alD((String) z.get(str3 + ".fromusr"));
                    abl.alE((String) z.get(str3 + ".tousr"));
                    abl.alG((String) z.get(str3 + ".realchatname"));
                    abl.mo39136ml(C5046bo.getLong((String) z.get(str3 + ".createtime"), 0));
                    abl.alH((String) z.get(str3 + ".msgid"));
                    abl.alI((String) z.get(str3 + ".eventid"));
                    abl.alJ((String) z.get(str3 + ".appid"));
                    abl.alK((String) z.get(str3 + ".link"));
                    abl.alL((String) z.get(str3 + ".brandid"));
                    C27960b.m44511a(str, abf);
                    str3 = ".favitem.locitem";
                    aay aay = abf.why;
                    if (!C5046bo.isNullOrNil((String) z.get(str3 + ".label"))) {
                        aay.alu((String) z.get(str3 + ".label"));
                    }
                    if (!C5046bo.isNullOrNil((String) z.get(str3 + ".poiname"))) {
                        aay.alv((String) z.get(str3 + ".poiname"));
                    }
                    str2 = (String) z.get(str3 + ".lng");
                    if (!C5046bo.isNullOrNil(str2)) {
                        aay.mo15620D(C5046bo.getDouble(str2, 0.0d));
                    }
                    str2 = (String) z.get(str3 + ".lat");
                    if (!C5046bo.isNullOrNil(str2)) {
                        aay.mo15621E(C5046bo.getDouble(str2, 0.0d));
                    }
                    str2 = (String) z.get(str3 + ".scale");
                    if (!C5046bo.isNullOrNil(str2)) {
                        if (str2.indexOf(46) != -1) {
                            aay.mo15622LJ(C5046bo.getInt(str2.substring(0, str2.indexOf(46)), -1));
                        } else {
                            aay.mo15622LJ(C5046bo.getInt(str2, -1));
                        }
                    }
                    str3 = ".favitem.weburlitem";
                    abu abu = abf.whA;
                    abu.alS((String) z.get(str3 + ".clean_url"));
                    abu.alR((String) z.get(str3 + ".pagedesc"));
                    abu.alT((String) z.get(str3 + ".pagethumb_url"));
                    abu.alQ((String) z.get(str3 + ".pagetitle"));
                    abu.mo27441LO(C5046bo.getInt((String) z.get(str3 + ".opencache"), 0));
                    abu.mo27442LP(C5046bo.getInt((String) z.get(str3 + ".contentattr"), 0));
                    abu.alU((String) z.get(str3 + ".canvasPageXml"));
                    str3 = ".favitem.productitem";
                    abe abe = abf.whC;
                    abe.alw((String) z.get(str3 + ".producttitle"));
                    abe.alx((String) z.get(str3 + ".productdesc"));
                    abe.aly((String) z.get(str3 + ".productthumb_url"));
                    abe.alz((String) z.get(str3 + ".productinfo"));
                    abe.mo27436LK(C5046bo.getInt((String) z.get(str3 + ".$type"), 0));
                    str3 = ".favitem.tvitem";
                    abo abo = abf.whE;
                    abo.alM((String) z.get(str3 + ".tvtitle"));
                    abo.alN((String) z.get(str3 + ".tvdesc"));
                    abo.alO((String) z.get(str3 + ".tvthumb_url"));
                    abo.alP((String) z.get(str3 + ".tvinfo"));
                    str3 = ".favitem.noteinfo";
                    aaz aaz = abf.vzK;
                    aaz.wim = (String) z.get(str3 + ".noteauthor");
                    aaz.win = (String) z.get(str3 + ".noteeditor");
                    str3 = ".favitem.appbranditem";
                    aap aap = abf.whN;
                    if (aap != null) {
                        aap.username = (String) z.get(str3 + ".username");
                        aap.appId = (String) z.get(str3 + ".appid");
                        aap.cBc = C5046bo.getInt((String) z.get(str3 + ".pkgtype"), 0);
                        aap.iconUrl = (String) z.get(str3 + ".iconurl");
                        aap.type = C5046bo.getInt((String) z.get(str3 + ".type"), 0);
                        aap.csu = (String) z.get(str3 + ".pagepath");
                        aap.wfO = (String) z.get(str3 + ".sourcedisplayname");
                    }
                    if (this.field_favProto.wit != null) {
                        abl abl2 = this.field_favProto.wit;
                        this.field_sourceId = abl2.wiC;
                        this.field_sourceType = abl2.cvp;
                        this.field_fromUser = abl2.cEV;
                        this.field_toUser = abl2.toUser;
                    }
                    this.field_edittime = this.field_favProto.lgR;
                    C27961c.m44513a(z, this.field_tagProto);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.FavItemInfo", e, "", new Object[0]);
                    C4990ab.m7413e("MicroMsg.FavItemInfo", "klem , FavItemInfo exception:+%s", e.toString());
                }
                AppMethodBeat.m2505o(102635);
            }
        }
        return this;
    }

    /* renamed from: LI */
    public final void mo45882LI(String str) {
        AppMethodBeat.m2504i(102636);
        C27967a c27967a = meP;
        c27967a.log("----dump favitem from[" + str + "] beg----");
        c27967a.log("type: " + this.field_type);
        c27967a.log("favId: " + this.field_id);
        c27967a.log("localId: " + this.field_localId);
        c27967a.log("itemStatus: " + this.field_itemStatus);
        c27967a.log("localSeq: " + this.field_localSeq);
        c27967a.log("updateSeq: " + this.field_updateSeq);
        c27967a.log("ctrlFlag: " + this.field_flag);
        c27967a.log("sourceId: " + this.field_sourceId);
        c27967a.log("sourceType: " + this.field_sourceType);
        c27967a.log("sourceCreateTime: " + this.field_sourceCreateTime);
        c27967a.log("updateTime: " + this.field_updateTime);
        c27967a.log("editTime: " + this.field_edittime);
        c27967a.log("fromuser: " + this.field_fromUser);
        c27967a.log("toUser: " + this.field_toUser);
        c27967a.log("realChatName: " + this.field_realChatName);
        if (this.field_favProto != null) {
            c27967a.log("remarktime: " + this.field_favProto.whH);
            c27967a.log("dataitemCount: " + this.field_favProto.wiv.size());
            if (this.field_favProto.wit != null) {
                c27967a.log(" ----source item----");
                abl abl = this.field_favProto.wit;
                c27967a.log("  sourceType: " + abl.cvp);
                c27967a.log("  fromUser: " + abl.cEV);
                c27967a.log("  toUser: " + abl.toUser);
                c27967a.log("  sourceId: " + abl.wiC);
                c27967a.log("  realChatName: " + abl.whU);
                c27967a.log("  createTime: " + abl.createTime);
                c27967a.log("  msgId: " + abl.cJb);
                c27967a.log("  eventId: " + abl.cOS);
                c27967a.log("  appId: " + abl.appId);
                c27967a.log("  link: " + abl.link);
                c27967a.log("  mediaId: " + abl.wia);
                c27967a.log("  brandId: " + abl.csl);
            }
            Iterator it = this.field_favProto.wiv.iterator();
            int i = 0;
            while (it.hasNext()) {
                aar aar = (aar) it.next();
                int i2 = i + 1;
                c27967a.log(" ----data item " + i + "----");
                c27967a.log("  dataId: " + aar.mnd);
                c27967a.log("  dataType: " + aar.dataType);
                c27967a.log("  dataSouceId: " + aar.wgH);
                c27967a.log("  svrDataStatus: " + aar.wgP);
                c27967a.log("  cdnThumbUrl: " + aar.fgE);
                c27967a.log("  cdnThumbKey: " + aar.wfV);
                c27967a.log("  cdnDataUrl: " + aar.wfZ);
                c27967a.log("  cdnDataKey: " + aar.wgb);
                c27967a.log("  cdnEncryVer: " + aar.wgd);
                c27967a.log("  fullmd5: " + aar.wgq);
                c27967a.log("  head256md5: " + aar.wgs);
                c27967a.log("  fullsize: " + aar.wgu);
                c27967a.log("  thumbMd5: " + aar.wgB);
                c27967a.log("  thumbHead256md5: " + aar.wgD);
                c27967a.log("  thumbfullsize: " + aar.wgF);
                c27967a.log("  duration: " + aar.duration);
                c27967a.log("  datafmt: " + aar.wgo);
                c27967a.log("  streamWebUrl: " + aar.wgg);
                c27967a.log("  streamDataUrl: " + aar.wgi);
                c27967a.log("  streamLowBandUrl: " + aar.wgk);
                c27967a.log("  ext: " + aar.cvq);
                if (aar.wgT != null) {
                    c27967a.log("  remarktime: " + aar.wgT.whH);
                    c27967a.log("  ctrlflag: " + aar.wgT.whJ);
                    c27967a.log("  edittime: " + aar.wgT.lgR);
                    if (aar.wgT.whw != null) {
                        c27967a.log("   ----data source item----");
                        aat aat = aar.wgT.whw;
                        c27967a.log("    sourceType: " + aat.cvp);
                        c27967a.log("    fromUser: " + aat.cEV);
                        c27967a.log("    toUser: " + aat.toUser);
                        c27967a.log("    realChatName: " + aat.whU);
                        c27967a.log("    createTime: " + aat.createTime);
                        c27967a.log("    msgId: " + aat.cJb);
                        c27967a.log("    eventId: " + aat.cOS);
                        c27967a.log("    appId: " + aat.appId);
                        c27967a.log("    link: " + aat.link);
                        c27967a.log("    mediaId: " + aat.wia);
                        c27967a.log("    brandId: " + aat.csl);
                    }
                    C27966g.m44516a("  ", c27967a, aar.wgT.why);
                    C27966g.m44520a("  ", c27967a, aar.wgT.whA);
                    C27966g.m44518a("  ", c27967a, aar.wgT.whC);
                    C27966g.m44519a("  ", c27967a, aar.wgT.whE);
                    C27966g.m44517a("  ", c27967a, aar.wgT.vzK);
                }
                i = i2;
            }
            C27966g.m44516a("", c27967a, this.field_favProto.why);
            C27966g.m44520a("", c27967a, this.field_favProto.whA);
            C27966g.m44518a("", c27967a, this.field_favProto.whC);
            C27966g.m44519a("", c27967a, this.field_favProto.whE);
            C27966g.m44517a("  ", c27967a, this.field_favProto.vzK);
        }
        c27967a.log("----dump favitem end----");
        AppMethodBeat.m2505o(102636);
    }

    /* renamed from: a */
    private static void m44519a(String str, C27967a c27967a, abo abo) {
        AppMethodBeat.m2504i(102637);
        if (abo == null) {
            AppMethodBeat.m2505o(102637);
            return;
        }
        c27967a.log(str + " ----tv item----");
        c27967a.log(str + "  title: " + abo.title);
        c27967a.log(str + "  desc: " + abo.desc);
        c27967a.log(str + "  thumbUrl: " + abo.thumbUrl);
        AppMethodBeat.m2505o(102637);
    }

    /* renamed from: a */
    private static void m44517a(String str, C27967a c27967a, aaz aaz) {
        AppMethodBeat.m2504i(102638);
        if (aaz == null) {
            AppMethodBeat.m2505o(102638);
            return;
        }
        c27967a.log(str + " ----noteInfoItem item----");
        c27967a.log(str + "  author: " + aaz.wim);
        c27967a.log(str + "  editor: " + aaz.win);
        AppMethodBeat.m2505o(102638);
    }

    /* renamed from: a */
    private static void m44518a(String str, C27967a c27967a, abe abe) {
        AppMethodBeat.m2504i(102639);
        if (abe == null) {
            AppMethodBeat.m2505o(102639);
            return;
        }
        c27967a.log(str + " ----product item----");
        c27967a.log(str + "  title: " + abe.title);
        c27967a.log(str + "  desc: " + abe.desc);
        c27967a.log(str + "  thumbUrl: " + abe.thumbUrl);
        c27967a.log(str + "  type: " + abe.type);
        AppMethodBeat.m2505o(102639);
    }

    /* renamed from: a */
    private static void m44516a(String str, C27967a c27967a, aay aay) {
        AppMethodBeat.m2504i(102640);
        if (aay == null) {
            AppMethodBeat.m2505o(102640);
            return;
        }
        c27967a.log(str + " ----loc item----");
        c27967a.log(str + "  lng: " + aay.lng);
        c27967a.log(str + "  lat: " + aay.lat);
        c27967a.log(str + "  scale: " + aay.cED);
        c27967a.log(str + "  label: " + aay.label);
        c27967a.log(str + "  poiname: " + aay.cIK);
        AppMethodBeat.m2505o(102640);
    }

    /* renamed from: a */
    private static void m44520a(String str, C27967a c27967a, abu abu) {
        AppMethodBeat.m2504i(102641);
        if (abu == null) {
            AppMethodBeat.m2505o(102641);
            return;
        }
        c27967a.log(str + " ----url item----");
        c27967a.log(str + "  title: " + abu.title);
        c27967a.log(str + "  desc: " + abu.desc);
        c27967a.log(str + "  cleanUrl: " + abu.wiY);
        c27967a.log(str + "  thumbUrl: " + abu.thumbUrl);
        c27967a.log(str + "  opencache: " + abu.wja);
        AppMethodBeat.m2505o(102641);
    }

    /* renamed from: LJ */
    public final boolean mo45883LJ(String str) {
        AppMethodBeat.m2504i(102642);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(102642);
            return false;
        }
        Iterator it = this.field_tagProto.wiJ.iterator();
        while (it.hasNext()) {
            if (str.equals((String) it.next())) {
                AppMethodBeat.m2505o(102642);
                return false;
            }
        }
        this.field_tagProto.wiJ.add(str);
        AppMethodBeat.m2505o(102642);
        return true;
    }

    /* renamed from: s */
    public static String m44521s(C27966g c27966g) {
        String str;
        StringBuffer stringBuffer;
        AppMethodBeat.m2504i(102643);
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("<favitem");
        stringBuffer2.append(" type='").append(c27966g.field_type).append("'");
        stringBuffer2.append(">");
        abf abf = c27966g.field_favProto;
        StringBuilder stringBuilder = new StringBuilder();
        if (!C5046bo.isNullOrNil(abf.title)) {
            stringBuilder.append("<title>").append(C5046bo.ani(abf.title)).append("</title>");
        }
        if (!C5046bo.isNullOrNil(abf.desc)) {
            stringBuilder.append("<desc>").append(C5046bo.ani(abf.desc)).append("</desc>");
        }
        if (abf.lgR > 0) {
            stringBuilder.append("<edittime>").append(abf.lgR).append("</edittime>");
        }
        if (!C5046bo.isNullOrNil(abf.hHV)) {
            stringBuilder.append("<remark ");
            if (abf.whH > 0) {
                stringBuilder.append(" time ='").append(abf.whH).append("'");
            }
            stringBuilder.append(">").append(C5046bo.ani(abf.hHV)).append("</remark>");
        }
        if (abf.whK) {
            stringBuilder.append("<ctrlflag>").append(abf.whJ).append("</ctrlflag>");
        }
        if (abf.wix) {
            stringBuilder.append("<version>").append(abf.version).append("</version>");
        } else if (c27966g.field_type == 18) {
            stringBuilder.append("<version>1</version>");
        }
        abl abl = abf.wit;
        if (abl == null || abl.computeSize() == 0) {
            C4990ab.m7420w("MicroMsg.FavSourceItemParser", "klem toXml, source item empty");
            str = "";
        } else {
            stringBuffer = new StringBuffer();
            stringBuffer.append("<source");
            if (abl.whP) {
                stringBuffer.append(" sourcetype='").append(abl.cvp).append("'");
            }
            if (abl.wiD) {
                stringBuffer.append(" sourceid='").append(abl.wiC).append("'");
            }
            stringBuffer.append(">");
            if (abl.whQ) {
                stringBuffer.append("<fromusr>").append(C5046bo.ani(abl.cEV)).append("</fromusr>");
            }
            if (abl.whR) {
                stringBuffer.append("<tousr>").append(C5046bo.ani(abl.toUser)).append("</tousr>");
            }
            if (abl.whV) {
                stringBuffer.append("<realchatname>").append(C5046bo.ani(abl.whU)).append("</realchatname>");
            }
            if (abl.whW) {
                stringBuffer.append("<msgid>").append(abl.cJb).append("</msgid>");
            }
            if (abl.whX) {
                stringBuffer.append("<eventid>").append(abl.cOS).append("</eventid>");
            }
            if (abl.whY) {
                stringBuffer.append("<appid>").append(abl.appId).append("</appid>");
            }
            if (abl.whZ) {
                stringBuffer.append("<link>").append(C5046bo.ani(abl.link)).append("</link>");
            }
            if (abl.wic) {
                stringBuffer.append("<brandid>").append(C5046bo.ani(abl.csl)).append("</brandid>");
            }
            stringBuffer.append("</source>");
            str = stringBuffer.toString();
        }
        stringBuilder.append(str);
        stringBuilder.append(C43051a.m76486bK(abf.wiv));
        aay aay = c27966g.field_favProto.why;
        if (aay == null || aay.computeSize() == 0) {
            C4990ab.m7410d("MicroMsg.FavLocItemParser", "klem toXml, loc item empty");
            str = "";
        } else {
            stringBuffer = new StringBuffer();
            stringBuffer.append("<locitem>");
            if (aay.wik) {
                stringBuffer.append("<label>").append(C5046bo.ani(aay.label)).append("</label>");
            }
            if (aay.wii) {
                stringBuffer.append("<lat>").append(aay.lat).append("</lat>");
            }
            if (aay.wih) {
                stringBuffer.append("<lng>").append(aay.lng).append("</lng>");
            }
            if (aay.wij) {
                stringBuffer.append("<scale>").append(aay.cED).append("</scale>");
            }
            if (aay.wil) {
                stringBuffer.append("<poiname>").append(aay.cIK).append("</poiname>");
            }
            stringBuffer.append("</locitem>");
            str = stringBuffer.toString();
        }
        stringBuilder.append(str);
        abu abu = c27966g.field_favProto.whA;
        if (abu == null || abu.computeSize() == 0) {
            C4990ab.m7410d("MicroMsg.FavUrlItemParser", "klem toXml, url item empty");
            str = "";
        } else {
            stringBuffer = new StringBuffer();
            stringBuffer.append("<weburlitem>");
            if (abu.wiZ) {
                stringBuffer.append("<clean_url>").append(C5046bo.ani(abu.wiY)).append("</clean_url>");
            }
            if (abu.wfT) {
                stringBuffer.append("<pagedesc>").append(C5046bo.ani(abu.desc)).append("</pagedesc>");
            }
            if (abu.wiq) {
                stringBuffer.append("<pagethumb_url>").append(C5046bo.ani(abu.thumbUrl)).append("</pagethumb_url>");
            }
            if (abu.wfS) {
                stringBuffer.append("<pagetitle>").append(C5046bo.ani(abu.title)).append("</pagetitle>");
            }
            if (abu.wjb) {
                stringBuffer.append("<opencache>").append(abu.wja).append("</opencache>");
            }
            if (abu.wjc) {
                stringBuffer.append("<contentattr>").append(abu.fgt).append("</contentattr>");
            }
            if (abu.whe) {
                stringBuffer.append("<canvasPageXml>").append(abu.canvasPageXml).append("</canvasPageXml>");
            }
            stringBuffer.append("</weburlitem>");
            str = stringBuffer.toString();
        }
        stringBuilder.append(str);
        abe abe = c27966g.field_favProto.whC;
        if (abe == null || abe.computeSize() == 0) {
            C4990ab.m7410d("MicroMsg.FavProductItemParser", "klem toXml, product item empty");
            str = "";
        } else {
            stringBuffer = new StringBuffer();
            stringBuffer.append("<productitem");
            if (abe.wis) {
                stringBuffer.append(" type='").append(abe.type).append("'");
            }
            stringBuffer.append(">");
            if (abe.wfS) {
                stringBuffer.append("<producttitle>").append(C5046bo.ani(abe.title)).append("</producttitle>");
            }
            if (abe.wfT) {
                stringBuffer.append("<productdesc>").append(C5046bo.ani(abe.desc)).append("</productdesc>");
            }
            if (abe.wiq) {
                stringBuffer.append("<productthumb_url>").append(C5046bo.ani(abe.thumbUrl)).append("</productthumb_url>");
            }
            if (abe.wir) {
                stringBuffer.append("<productinfo>").append(C5046bo.ani(abe.info)).append("</productinfo>");
            }
            stringBuffer.append("</productitem>");
            str = stringBuffer.toString();
        }
        stringBuilder.append(str);
        abo abo = c27966g.field_favProto.whE;
        if (abo == null || abo.computeSize() == 0) {
            C4990ab.m7410d("MicroMsg.FavTVItemParser", "klem toXml, product item empty");
            str = "";
        } else {
            stringBuffer = new StringBuffer();
            stringBuffer.append("<tvitem>");
            if (abo.wfS) {
                stringBuffer.append("<tvtitle>").append(C5046bo.ani(abo.title)).append("</tvtitle>");
            }
            if (abo.wfT) {
                stringBuffer.append("<tvdesc>").append(C5046bo.ani(abo.desc)).append("</tvdesc>");
            }
            if (abo.wiq) {
                stringBuffer.append("<tvthumb_url>").append(C5046bo.ani(abo.thumbUrl)).append("</tvthumb_url>");
            }
            if (abo.wir) {
                stringBuffer.append("<tvinfo>").append(C5046bo.ani(abo.info)).append("</tvinfo>");
            }
            stringBuffer.append("</tvitem>");
            str = stringBuffer.toString();
        }
        stringBuilder.append(str);
        aaz aaz = abf.vzK;
        if (aaz == null || aaz.computeSize() == 0) {
            C4990ab.m7420w("MicroMsg.FavNoteInfoItemParser", "klem toXml, source item empty");
            str = "";
        } else {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("<noteinfo>");
            stringBuffer3.append("<noteauthor>").append(C5046bo.ani(aaz.wim)).append("</noteauthor>");
            stringBuffer3.append("<noteeditor>").append(C5046bo.ani(aaz.win)).append("</noteeditor>");
            stringBuffer3.append("</noteinfo>");
            str = stringBuffer3.toString();
        }
        stringBuilder.append(str);
        stringBuffer2.append(stringBuilder.toString());
        stringBuffer2.append(C27961c.m44512a(c27966g.field_tagProto));
        stringBuffer2.append("</favitem>");
        str = stringBuffer2.toString();
        AppMethodBeat.m2505o(102643);
        return str;
    }

    public final C27966g buB() {
        AppMethodBeat.m2504i(102644);
        C27966g c27966g = new C27966g();
        c27966g.field_favProto = this.field_favProto;
        c27966g.field_sourceId = this.field_sourceId;
        c27966g.field_edittime = this.field_edittime;
        c27966g.field_ext = this.field_ext;
        c27966g.field_flag = this.field_flag;
        c27966g.field_fromUser = this.field_fromUser;
        c27966g.field_id = this.field_id;
        c27966g.field_itemStatus = this.field_itemStatus;
        c27966g.field_localId = this.field_localId;
        c27966g.field_localSeq = this.field_localSeq;
        c27966g.field_realChatName = this.field_realChatName;
        c27966g.field_tagProto = this.field_tagProto;
        c27966g.field_sourceCreateTime = this.field_sourceCreateTime;
        c27966g.field_updateSeq = this.field_updateSeq;
        c27966g.field_toUser = this.field_toUser;
        c27966g.field_updateTime = this.field_updateTime;
        c27966g.field_type = this.field_type;
        c27966g.field_xml = this.field_xml;
        c27966g.field_datatotalsize = this.field_datatotalsize;
        AppMethodBeat.m2505o(102644);
        return c27966g;
    }

    public final boolean buC() {
        AppMethodBeat.m2504i(102645);
        Iterator it = this.field_favProto.wiv.iterator();
        while (it.hasNext()) {
            if (((aar) it.next()).whl != 0) {
                AppMethodBeat.m2505o(102645);
                return true;
            }
        }
        AppMethodBeat.m2505o(102645);
        return false;
    }
}
