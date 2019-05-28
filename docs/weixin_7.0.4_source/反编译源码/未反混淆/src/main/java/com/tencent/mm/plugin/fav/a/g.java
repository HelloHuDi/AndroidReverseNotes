package com.tencent.mm.plugin.fav.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bo;
import com.tencent.mm.plugin.fav.a.a.b;
import com.tencent.mm.plugin.fav.a.a.c;
import com.tencent.mm.protocal.protobuf.aap;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.aat;
import com.tencent.mm.protocal.protobuf.aay;
import com.tencent.mm.protocal.protobuf.aaz;
import com.tencent.mm.protocal.protobuf.abe;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.abl;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.abs;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Iterator;
import java.util.Map;

public final class g extends bo {
    public static com.tencent.mm.sdk.e.c.a ccO = bo.Hm();
    private static a meP = new a() {
        public final void log(String str) {
            AppMethodBeat.i(102630);
            ab.d("MicroMsg.FavItemInfo", str);
            AppMethodBeat.o(102630);
        }
    };
    private static a meQ = new a() {
        public final void log(String str) {
            AppMethodBeat.i(102631);
            ab.e("MicroMsg.FavItemInfo", str);
            AppMethodBeat.o(102631);
        }
    };

    interface a {
        void log(String str);
    }

    public final /* synthetic */ Object clone() {
        AppMethodBeat.i(102646);
        g buB = buB();
        AppMethodBeat.o(102646);
        return buB;
    }

    static {
        AppMethodBeat.i(102647);
        AppMethodBeat.o(102647);
    }

    public g() {
        AppMethodBeat.i(102632);
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
        AppMethodBeat.o(102632);
    }

    private void bus() {
        AppMethodBeat.i(102633);
        this.field_favProto = new abf();
        abl abl = new abl();
        abl.LN(1);
        this.field_favProto.a(abl);
        this.field_favProto.b(new abu());
        this.field_favProto.b(new aay());
        this.field_favProto.b(new abe());
        this.field_favProto.b(new abo());
        this.field_favProto.LL(-1);
        this.field_tagProto = new abs();
        this.field_favProto.a(new aaz());
        AppMethodBeat.o(102633);
    }

    public final com.tencent.mm.sdk.e.c.a Ag() {
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
        AppMethodBeat.i(102634);
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
        ab.i("MicroMsg.FavItemInfo", "get ctrl args=[%s]", bundle.toString());
        AppMethodBeat.o(102634);
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

    public final g LH(String str) {
        AppMethodBeat.i(102635);
        if (str == null || str.equals("")) {
            ab.e("MicroMsg.FavItemInfo", "klem, FavItemInfo xml null");
            AppMethodBeat.o(102635);
        } else {
            Map z = br.z(str, "favitem");
            if (z == null) {
                ab.e("MicroMsg.FavItemInfo", "klem, FavItemInfo maps null");
                AppMethodBeat.o(102635);
            } else {
                try {
                    bus();
                    abf abf = this.field_favProto;
                    abf.alB((String) z.get(".favitem.title"));
                    abf.alC((String) z.get(".favitem.desc"));
                    abf.alA((String) z.get(".favitem.remark"));
                    abf.mj(com.tencent.mm.sdk.platformtools.bo.getLong((String) z.get(".favitem.remark.$time"), 0));
                    String str2 = (String) z.get(".favitem.edittime");
                    abf.LM(com.tencent.mm.sdk.platformtools.bo.getInt((String) z.get(".favitem.version"), 0));
                    abf.mk(com.tencent.mm.sdk.platformtools.bo.getLong(str2, 0));
                    abf.LL(com.tencent.mm.sdk.platformtools.bo.getInt((String) z.get(".favitem.ctrlflag"), -1));
                    String str3 = ".favitem.source";
                    abl abl = abf.wit;
                    abl.LN(com.tencent.mm.sdk.platformtools.bo.getInt((String) z.get(str3 + ".$sourcetype"), 0));
                    abl.alF((String) z.get(str3 + ".$sourceid"));
                    abl.alD((String) z.get(str3 + ".fromusr"));
                    abl.alE((String) z.get(str3 + ".tousr"));
                    abl.alG((String) z.get(str3 + ".realchatname"));
                    abl.ml(com.tencent.mm.sdk.platformtools.bo.getLong((String) z.get(str3 + ".createtime"), 0));
                    abl.alH((String) z.get(str3 + ".msgid"));
                    abl.alI((String) z.get(str3 + ".eventid"));
                    abl.alJ((String) z.get(str3 + ".appid"));
                    abl.alK((String) z.get(str3 + ".link"));
                    abl.alL((String) z.get(str3 + ".brandid"));
                    b.a(str, abf);
                    str3 = ".favitem.locitem";
                    aay aay = abf.why;
                    if (!com.tencent.mm.sdk.platformtools.bo.isNullOrNil((String) z.get(str3 + ".label"))) {
                        aay.alu((String) z.get(str3 + ".label"));
                    }
                    if (!com.tencent.mm.sdk.platformtools.bo.isNullOrNil((String) z.get(str3 + ".poiname"))) {
                        aay.alv((String) z.get(str3 + ".poiname"));
                    }
                    str2 = (String) z.get(str3 + ".lng");
                    if (!com.tencent.mm.sdk.platformtools.bo.isNullOrNil(str2)) {
                        aay.D(com.tencent.mm.sdk.platformtools.bo.getDouble(str2, 0.0d));
                    }
                    str2 = (String) z.get(str3 + ".lat");
                    if (!com.tencent.mm.sdk.platformtools.bo.isNullOrNil(str2)) {
                        aay.E(com.tencent.mm.sdk.platformtools.bo.getDouble(str2, 0.0d));
                    }
                    str2 = (String) z.get(str3 + ".scale");
                    if (!com.tencent.mm.sdk.platformtools.bo.isNullOrNil(str2)) {
                        if (str2.indexOf(46) != -1) {
                            aay.LJ(com.tencent.mm.sdk.platformtools.bo.getInt(str2.substring(0, str2.indexOf(46)), -1));
                        } else {
                            aay.LJ(com.tencent.mm.sdk.platformtools.bo.getInt(str2, -1));
                        }
                    }
                    str3 = ".favitem.weburlitem";
                    abu abu = abf.whA;
                    abu.alS((String) z.get(str3 + ".clean_url"));
                    abu.alR((String) z.get(str3 + ".pagedesc"));
                    abu.alT((String) z.get(str3 + ".pagethumb_url"));
                    abu.alQ((String) z.get(str3 + ".pagetitle"));
                    abu.LO(com.tencent.mm.sdk.platformtools.bo.getInt((String) z.get(str3 + ".opencache"), 0));
                    abu.LP(com.tencent.mm.sdk.platformtools.bo.getInt((String) z.get(str3 + ".contentattr"), 0));
                    abu.alU((String) z.get(str3 + ".canvasPageXml"));
                    str3 = ".favitem.productitem";
                    abe abe = abf.whC;
                    abe.alw((String) z.get(str3 + ".producttitle"));
                    abe.alx((String) z.get(str3 + ".productdesc"));
                    abe.aly((String) z.get(str3 + ".productthumb_url"));
                    abe.alz((String) z.get(str3 + ".productinfo"));
                    abe.LK(com.tencent.mm.sdk.platformtools.bo.getInt((String) z.get(str3 + ".$type"), 0));
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
                        aap.cBc = com.tencent.mm.sdk.platformtools.bo.getInt((String) z.get(str3 + ".pkgtype"), 0);
                        aap.iconUrl = (String) z.get(str3 + ".iconurl");
                        aap.type = com.tencent.mm.sdk.platformtools.bo.getInt((String) z.get(str3 + ".type"), 0);
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
                    c.a(z, this.field_tagProto);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.FavItemInfo", e, "", new Object[0]);
                    ab.e("MicroMsg.FavItemInfo", "klem , FavItemInfo exception:+%s", e.toString());
                }
                AppMethodBeat.o(102635);
            }
        }
        return this;
    }

    public final void LI(String str) {
        AppMethodBeat.i(102636);
        a aVar = meP;
        aVar.log("----dump favitem from[" + str + "] beg----");
        aVar.log("type: " + this.field_type);
        aVar.log("favId: " + this.field_id);
        aVar.log("localId: " + this.field_localId);
        aVar.log("itemStatus: " + this.field_itemStatus);
        aVar.log("localSeq: " + this.field_localSeq);
        aVar.log("updateSeq: " + this.field_updateSeq);
        aVar.log("ctrlFlag: " + this.field_flag);
        aVar.log("sourceId: " + this.field_sourceId);
        aVar.log("sourceType: " + this.field_sourceType);
        aVar.log("sourceCreateTime: " + this.field_sourceCreateTime);
        aVar.log("updateTime: " + this.field_updateTime);
        aVar.log("editTime: " + this.field_edittime);
        aVar.log("fromuser: " + this.field_fromUser);
        aVar.log("toUser: " + this.field_toUser);
        aVar.log("realChatName: " + this.field_realChatName);
        if (this.field_favProto != null) {
            aVar.log("remarktime: " + this.field_favProto.whH);
            aVar.log("dataitemCount: " + this.field_favProto.wiv.size());
            if (this.field_favProto.wit != null) {
                aVar.log(" ----source item----");
                abl abl = this.field_favProto.wit;
                aVar.log("  sourceType: " + abl.cvp);
                aVar.log("  fromUser: " + abl.cEV);
                aVar.log("  toUser: " + abl.toUser);
                aVar.log("  sourceId: " + abl.wiC);
                aVar.log("  realChatName: " + abl.whU);
                aVar.log("  createTime: " + abl.createTime);
                aVar.log("  msgId: " + abl.cJb);
                aVar.log("  eventId: " + abl.cOS);
                aVar.log("  appId: " + abl.appId);
                aVar.log("  link: " + abl.link);
                aVar.log("  mediaId: " + abl.wia);
                aVar.log("  brandId: " + abl.csl);
            }
            Iterator it = this.field_favProto.wiv.iterator();
            int i = 0;
            while (it.hasNext()) {
                aar aar = (aar) it.next();
                int i2 = i + 1;
                aVar.log(" ----data item " + i + "----");
                aVar.log("  dataId: " + aar.mnd);
                aVar.log("  dataType: " + aar.dataType);
                aVar.log("  dataSouceId: " + aar.wgH);
                aVar.log("  svrDataStatus: " + aar.wgP);
                aVar.log("  cdnThumbUrl: " + aar.fgE);
                aVar.log("  cdnThumbKey: " + aar.wfV);
                aVar.log("  cdnDataUrl: " + aar.wfZ);
                aVar.log("  cdnDataKey: " + aar.wgb);
                aVar.log("  cdnEncryVer: " + aar.wgd);
                aVar.log("  fullmd5: " + aar.wgq);
                aVar.log("  head256md5: " + aar.wgs);
                aVar.log("  fullsize: " + aar.wgu);
                aVar.log("  thumbMd5: " + aar.wgB);
                aVar.log("  thumbHead256md5: " + aar.wgD);
                aVar.log("  thumbfullsize: " + aar.wgF);
                aVar.log("  duration: " + aar.duration);
                aVar.log("  datafmt: " + aar.wgo);
                aVar.log("  streamWebUrl: " + aar.wgg);
                aVar.log("  streamDataUrl: " + aar.wgi);
                aVar.log("  streamLowBandUrl: " + aar.wgk);
                aVar.log("  ext: " + aar.cvq);
                if (aar.wgT != null) {
                    aVar.log("  remarktime: " + aar.wgT.whH);
                    aVar.log("  ctrlflag: " + aar.wgT.whJ);
                    aVar.log("  edittime: " + aar.wgT.lgR);
                    if (aar.wgT.whw != null) {
                        aVar.log("   ----data source item----");
                        aat aat = aar.wgT.whw;
                        aVar.log("    sourceType: " + aat.cvp);
                        aVar.log("    fromUser: " + aat.cEV);
                        aVar.log("    toUser: " + aat.toUser);
                        aVar.log("    realChatName: " + aat.whU);
                        aVar.log("    createTime: " + aat.createTime);
                        aVar.log("    msgId: " + aat.cJb);
                        aVar.log("    eventId: " + aat.cOS);
                        aVar.log("    appId: " + aat.appId);
                        aVar.log("    link: " + aat.link);
                        aVar.log("    mediaId: " + aat.wia);
                        aVar.log("    brandId: " + aat.csl);
                    }
                    a("  ", aVar, aar.wgT.why);
                    a("  ", aVar, aar.wgT.whA);
                    a("  ", aVar, aar.wgT.whC);
                    a("  ", aVar, aar.wgT.whE);
                    a("  ", aVar, aar.wgT.vzK);
                }
                i = i2;
            }
            a("", aVar, this.field_favProto.why);
            a("", aVar, this.field_favProto.whA);
            a("", aVar, this.field_favProto.whC);
            a("", aVar, this.field_favProto.whE);
            a("  ", aVar, this.field_favProto.vzK);
        }
        aVar.log("----dump favitem end----");
        AppMethodBeat.o(102636);
    }

    private static void a(String str, a aVar, abo abo) {
        AppMethodBeat.i(102637);
        if (abo == null) {
            AppMethodBeat.o(102637);
            return;
        }
        aVar.log(str + " ----tv item----");
        aVar.log(str + "  title: " + abo.title);
        aVar.log(str + "  desc: " + abo.desc);
        aVar.log(str + "  thumbUrl: " + abo.thumbUrl);
        AppMethodBeat.o(102637);
    }

    private static void a(String str, a aVar, aaz aaz) {
        AppMethodBeat.i(102638);
        if (aaz == null) {
            AppMethodBeat.o(102638);
            return;
        }
        aVar.log(str + " ----noteInfoItem item----");
        aVar.log(str + "  author: " + aaz.wim);
        aVar.log(str + "  editor: " + aaz.win);
        AppMethodBeat.o(102638);
    }

    private static void a(String str, a aVar, abe abe) {
        AppMethodBeat.i(102639);
        if (abe == null) {
            AppMethodBeat.o(102639);
            return;
        }
        aVar.log(str + " ----product item----");
        aVar.log(str + "  title: " + abe.title);
        aVar.log(str + "  desc: " + abe.desc);
        aVar.log(str + "  thumbUrl: " + abe.thumbUrl);
        aVar.log(str + "  type: " + abe.type);
        AppMethodBeat.o(102639);
    }

    private static void a(String str, a aVar, aay aay) {
        AppMethodBeat.i(102640);
        if (aay == null) {
            AppMethodBeat.o(102640);
            return;
        }
        aVar.log(str + " ----loc item----");
        aVar.log(str + "  lng: " + aay.lng);
        aVar.log(str + "  lat: " + aay.lat);
        aVar.log(str + "  scale: " + aay.cED);
        aVar.log(str + "  label: " + aay.label);
        aVar.log(str + "  poiname: " + aay.cIK);
        AppMethodBeat.o(102640);
    }

    private static void a(String str, a aVar, abu abu) {
        AppMethodBeat.i(102641);
        if (abu == null) {
            AppMethodBeat.o(102641);
            return;
        }
        aVar.log(str + " ----url item----");
        aVar.log(str + "  title: " + abu.title);
        aVar.log(str + "  desc: " + abu.desc);
        aVar.log(str + "  cleanUrl: " + abu.wiY);
        aVar.log(str + "  thumbUrl: " + abu.thumbUrl);
        aVar.log(str + "  opencache: " + abu.wja);
        AppMethodBeat.o(102641);
    }

    public final boolean LJ(String str) {
        AppMethodBeat.i(102642);
        if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(str)) {
            AppMethodBeat.o(102642);
            return false;
        }
        Iterator it = this.field_tagProto.wiJ.iterator();
        while (it.hasNext()) {
            if (str.equals((String) it.next())) {
                AppMethodBeat.o(102642);
                return false;
            }
        }
        this.field_tagProto.wiJ.add(str);
        AppMethodBeat.o(102642);
        return true;
    }

    public static String s(g gVar) {
        String str;
        StringBuffer stringBuffer;
        AppMethodBeat.i(102643);
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("<favitem");
        stringBuffer2.append(" type='").append(gVar.field_type).append("'");
        stringBuffer2.append(">");
        abf abf = gVar.field_favProto;
        StringBuilder stringBuilder = new StringBuilder();
        if (!com.tencent.mm.sdk.platformtools.bo.isNullOrNil(abf.title)) {
            stringBuilder.append("<title>").append(com.tencent.mm.sdk.platformtools.bo.ani(abf.title)).append("</title>");
        }
        if (!com.tencent.mm.sdk.platformtools.bo.isNullOrNil(abf.desc)) {
            stringBuilder.append("<desc>").append(com.tencent.mm.sdk.platformtools.bo.ani(abf.desc)).append("</desc>");
        }
        if (abf.lgR > 0) {
            stringBuilder.append("<edittime>").append(abf.lgR).append("</edittime>");
        }
        if (!com.tencent.mm.sdk.platformtools.bo.isNullOrNil(abf.hHV)) {
            stringBuilder.append("<remark ");
            if (abf.whH > 0) {
                stringBuilder.append(" time ='").append(abf.whH).append("'");
            }
            stringBuilder.append(">").append(com.tencent.mm.sdk.platformtools.bo.ani(abf.hHV)).append("</remark>");
        }
        if (abf.whK) {
            stringBuilder.append("<ctrlflag>").append(abf.whJ).append("</ctrlflag>");
        }
        if (abf.wix) {
            stringBuilder.append("<version>").append(abf.version).append("</version>");
        } else if (gVar.field_type == 18) {
            stringBuilder.append("<version>1</version>");
        }
        abl abl = abf.wit;
        if (abl == null || abl.computeSize() == 0) {
            ab.w("MicroMsg.FavSourceItemParser", "klem toXml, source item empty");
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
                stringBuffer.append("<fromusr>").append(com.tencent.mm.sdk.platformtools.bo.ani(abl.cEV)).append("</fromusr>");
            }
            if (abl.whR) {
                stringBuffer.append("<tousr>").append(com.tencent.mm.sdk.platformtools.bo.ani(abl.toUser)).append("</tousr>");
            }
            if (abl.whV) {
                stringBuffer.append("<realchatname>").append(com.tencent.mm.sdk.platformtools.bo.ani(abl.whU)).append("</realchatname>");
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
                stringBuffer.append("<link>").append(com.tencent.mm.sdk.platformtools.bo.ani(abl.link)).append("</link>");
            }
            if (abl.wic) {
                stringBuffer.append("<brandid>").append(com.tencent.mm.sdk.platformtools.bo.ani(abl.csl)).append("</brandid>");
            }
            stringBuffer.append("</source>");
            str = stringBuffer.toString();
        }
        stringBuilder.append(str);
        stringBuilder.append(com.tencent.mm.plugin.fav.a.a.a.bK(abf.wiv));
        aay aay = gVar.field_favProto.why;
        if (aay == null || aay.computeSize() == 0) {
            ab.d("MicroMsg.FavLocItemParser", "klem toXml, loc item empty");
            str = "";
        } else {
            stringBuffer = new StringBuffer();
            stringBuffer.append("<locitem>");
            if (aay.wik) {
                stringBuffer.append("<label>").append(com.tencent.mm.sdk.platformtools.bo.ani(aay.label)).append("</label>");
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
        abu abu = gVar.field_favProto.whA;
        if (abu == null || abu.computeSize() == 0) {
            ab.d("MicroMsg.FavUrlItemParser", "klem toXml, url item empty");
            str = "";
        } else {
            stringBuffer = new StringBuffer();
            stringBuffer.append("<weburlitem>");
            if (abu.wiZ) {
                stringBuffer.append("<clean_url>").append(com.tencent.mm.sdk.platformtools.bo.ani(abu.wiY)).append("</clean_url>");
            }
            if (abu.wfT) {
                stringBuffer.append("<pagedesc>").append(com.tencent.mm.sdk.platformtools.bo.ani(abu.desc)).append("</pagedesc>");
            }
            if (abu.wiq) {
                stringBuffer.append("<pagethumb_url>").append(com.tencent.mm.sdk.platformtools.bo.ani(abu.thumbUrl)).append("</pagethumb_url>");
            }
            if (abu.wfS) {
                stringBuffer.append("<pagetitle>").append(com.tencent.mm.sdk.platformtools.bo.ani(abu.title)).append("</pagetitle>");
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
        abe abe = gVar.field_favProto.whC;
        if (abe == null || abe.computeSize() == 0) {
            ab.d("MicroMsg.FavProductItemParser", "klem toXml, product item empty");
            str = "";
        } else {
            stringBuffer = new StringBuffer();
            stringBuffer.append("<productitem");
            if (abe.wis) {
                stringBuffer.append(" type='").append(abe.type).append("'");
            }
            stringBuffer.append(">");
            if (abe.wfS) {
                stringBuffer.append("<producttitle>").append(com.tencent.mm.sdk.platformtools.bo.ani(abe.title)).append("</producttitle>");
            }
            if (abe.wfT) {
                stringBuffer.append("<productdesc>").append(com.tencent.mm.sdk.platformtools.bo.ani(abe.desc)).append("</productdesc>");
            }
            if (abe.wiq) {
                stringBuffer.append("<productthumb_url>").append(com.tencent.mm.sdk.platformtools.bo.ani(abe.thumbUrl)).append("</productthumb_url>");
            }
            if (abe.wir) {
                stringBuffer.append("<productinfo>").append(com.tencent.mm.sdk.platformtools.bo.ani(abe.info)).append("</productinfo>");
            }
            stringBuffer.append("</productitem>");
            str = stringBuffer.toString();
        }
        stringBuilder.append(str);
        abo abo = gVar.field_favProto.whE;
        if (abo == null || abo.computeSize() == 0) {
            ab.d("MicroMsg.FavTVItemParser", "klem toXml, product item empty");
            str = "";
        } else {
            stringBuffer = new StringBuffer();
            stringBuffer.append("<tvitem>");
            if (abo.wfS) {
                stringBuffer.append("<tvtitle>").append(com.tencent.mm.sdk.platformtools.bo.ani(abo.title)).append("</tvtitle>");
            }
            if (abo.wfT) {
                stringBuffer.append("<tvdesc>").append(com.tencent.mm.sdk.platformtools.bo.ani(abo.desc)).append("</tvdesc>");
            }
            if (abo.wiq) {
                stringBuffer.append("<tvthumb_url>").append(com.tencent.mm.sdk.platformtools.bo.ani(abo.thumbUrl)).append("</tvthumb_url>");
            }
            if (abo.wir) {
                stringBuffer.append("<tvinfo>").append(com.tencent.mm.sdk.platformtools.bo.ani(abo.info)).append("</tvinfo>");
            }
            stringBuffer.append("</tvitem>");
            str = stringBuffer.toString();
        }
        stringBuilder.append(str);
        aaz aaz = abf.vzK;
        if (aaz == null || aaz.computeSize() == 0) {
            ab.w("MicroMsg.FavNoteInfoItemParser", "klem toXml, source item empty");
            str = "";
        } else {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("<noteinfo>");
            stringBuffer3.append("<noteauthor>").append(com.tencent.mm.sdk.platformtools.bo.ani(aaz.wim)).append("</noteauthor>");
            stringBuffer3.append("<noteeditor>").append(com.tencent.mm.sdk.platformtools.bo.ani(aaz.win)).append("</noteeditor>");
            stringBuffer3.append("</noteinfo>");
            str = stringBuffer3.toString();
        }
        stringBuilder.append(str);
        stringBuffer2.append(stringBuilder.toString());
        stringBuffer2.append(c.a(gVar.field_tagProto));
        stringBuffer2.append("</favitem>");
        str = stringBuffer2.toString();
        AppMethodBeat.o(102643);
        return str;
    }

    public final g buB() {
        AppMethodBeat.i(102644);
        g gVar = new g();
        gVar.field_favProto = this.field_favProto;
        gVar.field_sourceId = this.field_sourceId;
        gVar.field_edittime = this.field_edittime;
        gVar.field_ext = this.field_ext;
        gVar.field_flag = this.field_flag;
        gVar.field_fromUser = this.field_fromUser;
        gVar.field_id = this.field_id;
        gVar.field_itemStatus = this.field_itemStatus;
        gVar.field_localId = this.field_localId;
        gVar.field_localSeq = this.field_localSeq;
        gVar.field_realChatName = this.field_realChatName;
        gVar.field_tagProto = this.field_tagProto;
        gVar.field_sourceCreateTime = this.field_sourceCreateTime;
        gVar.field_updateSeq = this.field_updateSeq;
        gVar.field_toUser = this.field_toUser;
        gVar.field_updateTime = this.field_updateTime;
        gVar.field_type = this.field_type;
        gVar.field_xml = this.field_xml;
        gVar.field_datatotalsize = this.field_datatotalsize;
        AppMethodBeat.o(102644);
        return gVar;
    }

    public final boolean buC() {
        AppMethodBeat.i(102645);
        Iterator it = this.field_favProto.wiv.iterator();
        while (it.hasNext()) {
            if (((aar) it.next()).whl != 0) {
                AppMethodBeat.o(102645);
                return true;
            }
        }
        AppMethodBeat.o(102645);
        return false;
    }
}
