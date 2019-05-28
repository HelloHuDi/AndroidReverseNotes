package com.tencent.p177mm.plugin.record.p492b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p184aj.p185a.C25754e;
import com.tencent.p177mm.protocal.protobuf.aap;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.aas;
import com.tencent.p177mm.protocal.protobuf.aat;
import com.tencent.p177mm.protocal.protobuf.aay;
import com.tencent.p177mm.protocal.protobuf.abe;
import com.tencent.p177mm.protocal.protobuf.abo;
import com.tencent.p177mm.protocal.protobuf.abu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.record.b.o */
public final class C12985o {
    /* renamed from: bK */
    public static String m20957bK(List<aar> list) {
        AppMethodBeat.m2504i(135721);
        String str;
        if (list == null || list.size() == 0) {
            C4990ab.m7420w("MicroMsg.RecordMsgParser", "klem toXml data list empty");
            str = "";
            AppMethodBeat.m2505o(135721);
            return str;
        }
        int size = list.size();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<datalist count='").append(size).append("'>");
        for (int i = 0; i < size; i++) {
            aar aar = (aar) list.get(i);
            stringBuffer.append("<dataitem ");
            if (aar.wgn) {
                stringBuffer.append("datatype='").append(aar.dataType).append("'");
            }
            if (aar.wgQ) {
                stringBuffer.append(" datastatus='").append(aar.wgP).append("'");
            }
            if (aar.wgw) {
                stringBuffer.append(" dataid='").append(aar.mnd).append("'");
            }
            if (aar.whc) {
                stringBuffer.append(" htmlid='").append(aar.whb).append("'");
            }
            if (aar.whi) {
                stringBuffer.append(" dataillegaltype='").append(aar.whh).append("'");
            }
            if (aar.wgI) {
                stringBuffer.append(" datasourceid='").append(aar.wgH).append("'");
            }
            stringBuffer.append(">");
            if (aar.wgp) {
                stringBuffer.append("<datafmt>").append(aar.wgo).append("</datafmt>");
            }
            if (aar.wfS) {
                stringBuffer.append("<datatitle>").append(C5046bo.ani(aar.title)).append("</datatitle>");
            }
            if (aar.wfT) {
                stringBuffer.append("<datadesc>").append(C5046bo.ani(aar.desc)).append("</datadesc>");
            }
            if (aar.wfU) {
                stringBuffer.append("<cdnthumburl>").append(C5046bo.ani(aar.fgE)).append("</cdnthumburl>");
            }
            if (aar.wfX) {
                stringBuffer.append("<thumbwidth>").append(aar.fgJ).append("</thumbwidth>");
            }
            if (aar.wfY) {
                stringBuffer.append("<thumbheight>").append(aar.fgI).append("</thumbheight>");
            }
            if (aar.wga) {
                stringBuffer.append("<cdndataurl>").append(C5046bo.ani(aar.wfZ)).append("</cdndataurl>");
            }
            if (aar.wfW) {
                stringBuffer.append("<cdnthumbkey>").append(C5046bo.ani(aar.wfV)).append("</cdnthumbkey>");
            }
            if (aar.wgc) {
                stringBuffer.append("<cdndatakey>").append(C5046bo.ani(aar.wgb)).append("</cdndatakey>");
            }
            if (aar.wge) {
                stringBuffer.append("<cdnencryver>").append(aar.wgd).append("</cdnencryver>");
            }
            if (aar.wgf) {
                stringBuffer.append("<duration>").append(aar.duration).append("</duration>");
            }
            if (aar.wgh) {
                stringBuffer.append("<streamweburl>").append(C5046bo.ani(aar.wgg)).append("</streamweburl>");
            }
            if (aar.wgj) {
                stringBuffer.append("<streamdataurl>").append(C5046bo.ani(aar.wgi)).append("</streamdataurl>");
            }
            if (aar.wgl) {
                stringBuffer.append("<streamlowbandurl>").append(C5046bo.ani(aar.wgk)).append("</streamlowbandurl>");
            }
            if (aar.wgm) {
                stringBuffer.append("<dataext>").append(C5046bo.ani(aar.cvq)).append("</dataext>");
            }
            if (aar.wgr) {
                stringBuffer.append("<fullmd5>").append(aar.wgq).append("</fullmd5>");
            }
            if (aar.wgt) {
                stringBuffer.append("<head256md5>").append(aar.wgs).append("</head256md5>");
            }
            if (aar.wgv) {
                stringBuffer.append("<datasize>").append(aar.wgu).append("</datasize>");
            }
            if (aar.wgC) {
                stringBuffer.append("<thumbfullmd5>").append(aar.wgB).append("</thumbfullmd5>");
            }
            if (aar.wgE) {
                stringBuffer.append("<thumbhead256md5>").append(aar.wgD).append("</thumbhead256md5>");
            }
            if (aar.wgG) {
                stringBuffer.append("<thumbsize>").append(aar.wgF).append("</thumbsize>");
            }
            if (aar.wgK) {
                stringBuffer.append("<streamvideoid>").append(C5046bo.ani(aar.wgJ)).append("</streamvideoid>");
            }
            if (aar.wgS) {
                stringBuffer.append("<sourcetitle>").append(C5046bo.ani(aar.wgR)).append("</sourcetitle>");
            }
            if (aar.wgW) {
                stringBuffer.append("<sourcename>").append(C5046bo.ani(aar.wgV)).append("</sourcename>");
            }
            if (aar.whv) {
                stringBuffer.append("<sourcedesc>").append(C5046bo.ani(aar.whu)).append("</sourcedesc>");
            }
            if (aar.wgY) {
                stringBuffer.append("<sourcetime>").append(C5046bo.ani(aar.wgX)).append("</sourcetime>");
            }
            if (aar.whd) {
                stringBuffer.append("<statextstr>").append(C5046bo.ani(aar.cMn)).append("</statextstr>");
            }
            if (aar.whk) {
                stringBuffer.append("<recordxml>").append(aar.whj).append("</recordxml>");
            }
            aas aas = aar.wgT;
            if (aas == null || aas.whw == null || aas.whw.computeSize() == 0) {
                C4990ab.m7420w("MicroMsg.RecordMsgParser", "klem toXml, data source item empty");
            } else {
                aat aat = aas.whw;
                if (aat.whY) {
                    stringBuffer.append("<appid>").append(aat.appId).append("</appid>");
                }
                if (aat.whZ) {
                    stringBuffer.append("<link>").append(C5046bo.ani(aat.link)).append("</link>");
                }
                if (aat.wic) {
                    stringBuffer.append("<brandid>").append(C5046bo.ani(aat.csl)).append("</brandid>");
                }
                if (aat.whQ && aat.whV) {
                    if (aat.cEV.equals(aat.whU)) {
                        stringBuffer.append("<dataitemsource><fromusr>").append(C5046bo.ani(aat.cEV)).append("</fromusr></dataitemsource>");
                    } else if (C1855t.m3896kH(aat.cEV) || C25754e.m40904rr(aat.whU)) {
                        stringBuffer.append("<dataitemsource><realchatname>").append(C5046bo.ani(aat.whU)).append("</realchatname></dataitemsource>");
                    }
                } else if (aat.whQ) {
                    stringBuffer.append("<dataitemsource><fromusr>").append(C5046bo.ani(aat.cEV)).append("</fromusr></dataitemsource>");
                } else if (aat.whV) {
                    stringBuffer.append("<dataitemsource><realchatname>").append(C5046bo.ani(aat.whU)).append("</realchatname></dataitemsource>");
                }
            }
            aas = aar.wgT;
            if (aas == null || aas.why == null || aas.why.computeSize() == 0) {
                C4990ab.m7420w("MicroMsg.RecordMsgParser", "klem toXml, loc item empty");
            } else {
                aay aay = aas.why;
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
            }
            aas = aar.wgT;
            if (aas == null || aas.whA == null || aas.whA.computeSize() == 0) {
                C4990ab.m7420w("MicroMsg.RecordMsgParser", "klem toXml, url item empty");
            } else {
                abu abu = aas.whA;
                stringBuffer.append("<weburlitem>");
                if (abu.wiZ) {
                    stringBuffer.append("<link>").append(C5046bo.ani(abu.wiY)).append("</link>");
                }
                if (abu.wfT) {
                    stringBuffer.append("<desc>").append(C5046bo.ani(abu.desc)).append("</desc>");
                }
                if (abu.wiq) {
                    stringBuffer.append("<thumburl>").append(C5046bo.ani(abu.thumbUrl)).append("</thumburl>");
                }
                if (abu.wfS) {
                    stringBuffer.append("<title>").append(C5046bo.ani(abu.title)).append("</title>");
                }
                if (abu.wjb) {
                    stringBuffer.append("<opencache>").append(abu.wja).append("</opencache>");
                }
                if (abu.wjc) {
                    stringBuffer.append("<contentattr>").append(abu.fgt).append("</contentattr>");
                }
                stringBuffer.append("</weburlitem>");
            }
            aas = aar.wgT;
            if (aas == null || aas.whC == null || aas.whC.computeSize() == 0) {
                C4990ab.m7420w("MicroMsg.RecordMsgParser", "klem toXml, product item empty");
            } else {
                abe abe = aas.whC;
                stringBuffer.append("<productitem");
                if (abe.wis) {
                    stringBuffer.append(" type='").append(abe.type).append("'");
                }
                stringBuffer.append(">");
                if (abe.wfS) {
                    stringBuffer.append("<title>").append(C5046bo.ani(abe.title)).append("</title>");
                }
                if (abe.wfT) {
                    stringBuffer.append("<desc>").append(C5046bo.ani(abe.desc)).append("</desc>");
                }
                if (abe.wiq) {
                    stringBuffer.append("<thumburl>").append(C5046bo.ani(abe.thumbUrl)).append("</thumburl>");
                }
                if (abe.wir) {
                    stringBuffer.append("<productinfo>").append(C5046bo.ani(abe.info)).append("</productinfo>");
                }
                stringBuffer.append("</productitem>");
            }
            aas = aar.wgT;
            if (aas == null || aas.whE == null || aas.whE.computeSize() == 0) {
                C4990ab.m7420w("MicroMsg.RecordMsgParser", "klem toXml, product item empty");
            } else {
                abo abo = aas.whE;
                stringBuffer.append("<tvitem>");
                if (abo.wfS) {
                    stringBuffer.append("<title>").append(C5046bo.ani(abo.title)).append("</title>");
                }
                if (abo.wfT) {
                    stringBuffer.append("<desc>").append(C5046bo.ani(abo.desc)).append("</desc>");
                }
                if (abo.wiq) {
                    stringBuffer.append("<thumburl>").append(C5046bo.ani(abo.thumbUrl)).append("</thumburl>");
                }
                if (abo.wir) {
                    stringBuffer.append("<tvinfo>").append(C5046bo.ani(abo.info)).append("</tvinfo>");
                }
                stringBuffer.append("</tvitem>");
            }
            aas aas2 = aar.wgT;
            if (aas2 == null || aas2.whN == null) {
                C4990ab.m7412e("MicroMsg.RecordMsgParser", "setAppBrandXml toXml, item empty");
            } else {
                aap aap = aas2.whN;
                if (aap != null) {
                    stringBuffer.append("<appbranditem>");
                    stringBuffer.append("<username>").append(C5046bo.ani(aap.username)).append("</username>");
                    stringBuffer.append("<appid>").append(C5046bo.ani(aap.appId)).append("</appid>");
                    stringBuffer.append("<pkgtype>").append(aap.cBc).append("</pkgtype>");
                    stringBuffer.append("<iconurl>").append(C5046bo.ani(aap.iconUrl)).append("</iconurl>");
                    stringBuffer.append("<type>").append(aap.type).append("</type>");
                    stringBuffer.append("<pagepath>").append(C5046bo.ani(aap.csu)).append("</pagepath>");
                    stringBuffer.append("<sourcedisplayname>").append(C5046bo.ani(aap.wfO)).append("</sourcedisplayname>");
                    stringBuffer.append("</appbranditem>");
                }
            }
            stringBuffer.append("</dataitem>");
        }
        stringBuffer.append("</datalist>");
        str = stringBuffer.toString();
        AppMethodBeat.m2505o(135721);
        return str;
    }
}
