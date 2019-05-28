package com.tencent.p177mm.plugin.fav.p407a.p1400a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.protocal.protobuf.aap;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.aas;
import com.tencent.p177mm.protocal.protobuf.aat;
import com.tencent.p177mm.protocal.protobuf.aau;
import com.tencent.p177mm.protocal.protobuf.aay;
import com.tencent.p177mm.protocal.protobuf.abe;
import com.tencent.p177mm.protocal.protobuf.abf;
import com.tencent.p177mm.protocal.protobuf.abo;
import com.tencent.p177mm.protocal.protobuf.abu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.io.ByteArrayInputStream;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/* renamed from: com.tencent.mm.plugin.fav.a.a.b */
public final class C27960b {
    /* renamed from: a */
    public static void m44511a(String str, abf abf) {
        AppMethodBeat.m2504i(102755);
        abf.wiv.clear();
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(str.getBytes())));
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("datalist");
            if (elementsByTagName != null) {
                NodeList childNodes = elementsByTagName.item(0).getChildNodes();
                if (childNodes != null && childNodes.getLength() > 0) {
                    int length = childNodes.getLength();
                    for (int i = 0; i < length; i++) {
                        String str2;
                        Map z;
                        Node item = childNodes.item(i);
                        String b = C5049br.m7594b(item);
                        NodeList elementsByTagName2 = ((Element) item).getElementsByTagName("recordxml");
                        if (elementsByTagName2 == null || elementsByTagName2.getLength() <= 0) {
                            str2 = null;
                        } else {
                            str2 = C5049br.m7594b(elementsByTagName2.item(0).getFirstChild());
                        }
                        if (b.trim().startsWith("<dataitem")) {
                            z = C5049br.m7595z(b, "dataitem");
                        } else {
                            z = null;
                        }
                        if (z != null) {
                            aar aar = new aar();
                            String str3 = ".dataitem";
                            aar.mo27394LE(C5046bo.getInt((String) z.get(str3 + ".$datatype"), 0));
                            aar.akZ((String) z.get(str3 + ".$datasourceid"));
                            aar.mo27395LF(C5046bo.getInt((String) z.get(str3 + ".$datastatus"), 0));
                            aar.akR((String) z.get(str3 + ".datafmt"));
                            aar.akH((String) z.get(str3 + ".datatitle"));
                            aar.akI((String) z.get(str3 + ".datadesc"));
                            aar.akJ((String) z.get(str3 + ".cdn_thumburl"));
                            aar.akK((String) z.get(str3 + ".cdn_thumbkey"));
                            aar.mo27391LB(C5046bo.getInt((String) z.get(str3 + ".thumb_width"), 0));
                            aar.mo27392LC(C5046bo.getInt((String) z.get(str3 + ".thumb_height"), 0));
                            aar.akL((String) z.get(str3 + ".cdn_dataurl"));
                            aar.akM((String) z.get(str3 + ".cdn_datakey"));
                            String str4 = (String) z.get(str3 + ".duration");
                            if (str4 != null && str4.length() > 0) {
                                aar.mo27393LD(C5046bo.getInt(str4, 0));
                            }
                            aar.akO((String) z.get(str3 + ".stream_dataurl"));
                            aar.akP((String) z.get(str3 + ".stream_lowbandurl"));
                            aar.akN((String) z.get(str3 + ".stream_weburl"));
                            aar.alg((String) z.get(str3 + ".canvasPageXml"));
                            aar.akS((String) z.get(str3 + ".fullmd5"));
                            aar.akT((String) z.get(str3 + ".head256md5"));
                            str4 = (String) z.get(str3 + ".fullsize");
                            if (!C5046bo.isNullOrNil(str4)) {
                                aar.mo27431mf((long) C5046bo.getInt(str4, 0));
                            }
                            aar.akQ((String) z.get(str3 + ".dataext"));
                            aar.akX((String) z.get(str3 + ".thumbfullmd5"));
                            aar.akY((String) z.get(str3 + ".thumbhead256md5"));
                            str4 = (String) z.get(str3 + ".thumbfullsize");
                            if (!C5046bo.isNullOrNil(str4)) {
                                aar.mo27432mg((long) C5046bo.getInt(str4, 0));
                            }
                            aar.ala((String) z.get(str3 + ".stream_videoid"));
                            str4 = (String) z.get(str3 + ".$dataid");
                            if (C5046bo.isNullOrNil(str4) || str4.length() < 32) {
                                str4 = C39037b.m66382cf(aar.toString(), aar.dataType);
                            }
                            aar.akU(str4);
                            aar.alb((String) z.get(str3 + ".datasrctitle"));
                            aar.alc((String) z.get(str3 + ".datasrcname"));
                            aar.ald((String) z.get(str3 + ".datasrctime"));
                            aar.alf((String) z.get(str3 + ".statextstr"));
                            aar.ale((String) z.get(str3 + ".$htmlid"));
                            aar.mo27396LG(C5046bo.getInt((String) z.get(str3 + ".$dataillegaltype"), 0));
                            if (str2 != null) {
                                aar.alh(str2);
                            }
                            aau aau = new aau();
                            aau.fiG = C5046bo.m7532bc((String) z.get(str3 + ".streamvideo.streamvideourl"), "");
                            aau.wid = C5046bo.ank((String) z.get(str3 + ".streamvideo.streamvideototaltime"));
                            aau.fiI = C5046bo.m7532bc((String) z.get(str3 + ".streamvideo.streamvideotitle"), "");
                            aau.fiJ = C5046bo.m7532bc((String) z.get(str3 + ".streamvideo.streamvideowording"), "");
                            aau.fiK = C5046bo.m7532bc((String) z.get(str3 + ".streamvideo.streamvideoweburl"), "");
                            aau.fiM = C5046bo.m7532bc((String) z.get(str3 + ".streamvideo.streamvideoaduxinfo"), "");
                            aau.fiN = C5046bo.m7532bc((String) z.get(str3 + ".streamvideo.streamvideopublishid"), "");
                            aar.mo27399a(aau);
                            aas aas = new aas();
                            String str5 = str3 + ".dataitemsource";
                            if (z.containsKey(str5)) {
                                aat aat = new aat();
                                aat.mo64043LI(C5046bo.getInt((String) z.get(str5 + ".$sourcetype"), 0));
                                aat.alo((String) z.get(str5 + ".$sourceid"));
                                aat.alm((String) z.get(str5 + ".fromusr"));
                                aat.aln((String) z.get(str5 + ".tousr"));
                                aat.alp((String) z.get(str5 + ".realchatname"));
                                aat.mo64052mi(C5046bo.getLong((String) z.get(str5 + ".createtime"), 0));
                                aat.alq((String) z.get(str5 + ".msgid"));
                                aat.cOS = (String) z.get(str5 + ".eventid");
                                aat.whX = true;
                                aat.alr((String) z.get(str5 + ".appid"));
                                aat.als((String) z.get(str5 + ".link"));
                                aat.alt((String) z.get(str5 + ".brandid"));
                                aas.mo48444c(aat);
                            } else {
                                C4990ab.m7419v("MicroMsg.FavDataItemParser", "cur fav not contains %s", str5);
                            }
                            str5 = str3 + ".locitem";
                            if (z.containsKey(str5)) {
                                aay aay = new aay();
                                if (!C5046bo.isNullOrNil((String) z.get(str5 + ".label"))) {
                                    aay.alu((String) z.get(str5 + ".label"));
                                }
                                if (!C5046bo.isNullOrNil((String) z.get(str5 + ".poiname"))) {
                                    aay.alv((String) z.get(str5 + ".poiname"));
                                }
                                str4 = (String) z.get(str5 + ".lng");
                                if (!C5046bo.isNullOrNil(str4)) {
                                    aay.mo15620D(C5046bo.getDouble(str4, 0.0d));
                                }
                                str4 = (String) z.get(str5 + ".lat");
                                if (!C5046bo.isNullOrNil(str4)) {
                                    aay.mo15621E(C5046bo.getDouble(str4, 0.0d));
                                }
                                str4 = (String) z.get(str5 + ".scale");
                                if (!C5046bo.isNullOrNil(str4)) {
                                    if (str4.indexOf(46) != -1) {
                                        aay.mo15622LJ(C5046bo.getInt(str4.substring(0, str4.indexOf(46)), -1));
                                    } else {
                                        aay.mo15622LJ(C5046bo.getInt(str4, -1));
                                    }
                                }
                                aas.mo48440a(aay);
                            } else {
                                C4990ab.m7419v("MicroMsg.FavDataItemParser", "cur fav not contains %s", str5);
                            }
                            str5 = str3 + ".weburlitem";
                            if (z.containsKey(str5)) {
                                abu abu = new abu();
                                abu.alS((String) z.get(str5 + ".clean_url"));
                                abu.alR((String) z.get(str5 + ".pagedesc"));
                                abu.alT((String) z.get(str5 + ".pagethumb_url"));
                                abu.alQ((String) z.get(str5 + ".pagetitle"));
                                abu.mo27441LO(C5046bo.getInt((String) z.get(str5 + ".opencache"), 0));
                                abu.mo27442LP(C5046bo.getInt((String) z.get(str5 + ".contentattr"), 0));
                                abu.alU((String) z.get(str5 + ".canvasPageXml"));
                                aas.mo48443a(abu);
                            } else {
                                C4990ab.m7419v("MicroMsg.FavDataItemParser", "cur fav not contains %s", str5);
                            }
                            str5 = str3 + ".productitem";
                            if (z.containsKey(str5)) {
                                abe abe = new abe();
                                abe.alw((String) z.get(str5 + ".producttitle"));
                                abe.alx((String) z.get(str5 + ".productdesc"));
                                abe.aly((String) z.get(str5 + ".productthumb_url"));
                                abe.alz((String) z.get(str5 + ".productinfo"));
                                abe.mo27436LK(C5046bo.getInt((String) z.get(str5 + ".$type"), 0));
                                aas.mo48441a(abe);
                            } else {
                                C4990ab.m7419v("MicroMsg.FavDataItemParser", "cur fav not contains %s", str5);
                            }
                            str5 = str3 + ".tvitem";
                            if (z.containsKey(str5)) {
                                abo abo = new abo();
                                abo.alM((String) z.get(str5 + ".tvtitle"));
                                abo.alN((String) z.get(str5 + ".tvdesc"));
                                abo.alO((String) z.get(str5 + ".tvthumb_url"));
                                abo.alP((String) z.get(str5 + ".tvinfo"));
                                aas.mo48442a(abo);
                            } else {
                                C4990ab.m7419v("MicroMsg.FavDataItemParser", "cur fav not contains %s", str5);
                            }
                            str3 = str3 + ".appbranditem";
                            if (z.containsKey(str3)) {
                                aap aap = new aap();
                                aap.username = (String) z.get(str3 + ".username");
                                aap.appId = (String) z.get(str3 + ".appid");
                                aap.cBc = C5046bo.getInt((String) z.get(str3 + ".pkgtype"), 0);
                                aap.iconUrl = (String) z.get(str3 + ".iconurl");
                                aap.type = C5046bo.getInt((String) z.get(str3 + ".type"), 0);
                                aap.csu = (String) z.get(str3 + ".pagepath");
                                aap.wfO = (String) z.get(str3 + ".sourcedisplayname");
                                aas.mo48439a(aap);
                            } else {
                                C4990ab.m7419v("MicroMsg.FavDataItemParser", "cur fav not contains %s", str3);
                            }
                            aar.mo27398a(aas);
                            abf.wiv.add(aar);
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(102755);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.FavProtoItemParser", "[parser] parseXML exception:%s", e.toString());
            AppMethodBeat.m2505o(102755);
        }
    }
}
