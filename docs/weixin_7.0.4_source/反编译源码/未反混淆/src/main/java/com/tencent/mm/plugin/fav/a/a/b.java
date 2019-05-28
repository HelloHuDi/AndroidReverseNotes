package com.tencent.mm.plugin.fav.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aap;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.aas;
import com.tencent.mm.protocal.protobuf.aat;
import com.tencent.mm.protocal.protobuf.aau;
import com.tencent.mm.protocal.protobuf.aay;
import com.tencent.mm.protocal.protobuf.abe;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.io.ByteArrayInputStream;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class b {
    public static void a(String str, abf abf) {
        AppMethodBeat.i(102755);
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
                        String b = br.b(item);
                        NodeList elementsByTagName2 = ((Element) item).getElementsByTagName("recordxml");
                        if (elementsByTagName2 == null || elementsByTagName2.getLength() <= 0) {
                            str2 = null;
                        } else {
                            str2 = br.b(elementsByTagName2.item(0).getFirstChild());
                        }
                        if (b.trim().startsWith("<dataitem")) {
                            z = br.z(b, "dataitem");
                        } else {
                            z = null;
                        }
                        if (z != null) {
                            aar aar = new aar();
                            String str3 = ".dataitem";
                            aar.LE(bo.getInt((String) z.get(str3 + ".$datatype"), 0));
                            aar.akZ((String) z.get(str3 + ".$datasourceid"));
                            aar.LF(bo.getInt((String) z.get(str3 + ".$datastatus"), 0));
                            aar.akR((String) z.get(str3 + ".datafmt"));
                            aar.akH((String) z.get(str3 + ".datatitle"));
                            aar.akI((String) z.get(str3 + ".datadesc"));
                            aar.akJ((String) z.get(str3 + ".cdn_thumburl"));
                            aar.akK((String) z.get(str3 + ".cdn_thumbkey"));
                            aar.LB(bo.getInt((String) z.get(str3 + ".thumb_width"), 0));
                            aar.LC(bo.getInt((String) z.get(str3 + ".thumb_height"), 0));
                            aar.akL((String) z.get(str3 + ".cdn_dataurl"));
                            aar.akM((String) z.get(str3 + ".cdn_datakey"));
                            String str4 = (String) z.get(str3 + ".duration");
                            if (str4 != null && str4.length() > 0) {
                                aar.LD(bo.getInt(str4, 0));
                            }
                            aar.akO((String) z.get(str3 + ".stream_dataurl"));
                            aar.akP((String) z.get(str3 + ".stream_lowbandurl"));
                            aar.akN((String) z.get(str3 + ".stream_weburl"));
                            aar.alg((String) z.get(str3 + ".canvasPageXml"));
                            aar.akS((String) z.get(str3 + ".fullmd5"));
                            aar.akT((String) z.get(str3 + ".head256md5"));
                            str4 = (String) z.get(str3 + ".fullsize");
                            if (!bo.isNullOrNil(str4)) {
                                aar.mf((long) bo.getInt(str4, 0));
                            }
                            aar.akQ((String) z.get(str3 + ".dataext"));
                            aar.akX((String) z.get(str3 + ".thumbfullmd5"));
                            aar.akY((String) z.get(str3 + ".thumbhead256md5"));
                            str4 = (String) z.get(str3 + ".thumbfullsize");
                            if (!bo.isNullOrNil(str4)) {
                                aar.mg((long) bo.getInt(str4, 0));
                            }
                            aar.ala((String) z.get(str3 + ".stream_videoid"));
                            str4 = (String) z.get(str3 + ".$dataid");
                            if (bo.isNullOrNil(str4) || str4.length() < 32) {
                                str4 = com.tencent.mm.plugin.fav.a.b.cf(aar.toString(), aar.dataType);
                            }
                            aar.akU(str4);
                            aar.alb((String) z.get(str3 + ".datasrctitle"));
                            aar.alc((String) z.get(str3 + ".datasrcname"));
                            aar.ald((String) z.get(str3 + ".datasrctime"));
                            aar.alf((String) z.get(str3 + ".statextstr"));
                            aar.ale((String) z.get(str3 + ".$htmlid"));
                            aar.LG(bo.getInt((String) z.get(str3 + ".$dataillegaltype"), 0));
                            if (str2 != null) {
                                aar.alh(str2);
                            }
                            aau aau = new aau();
                            aau.fiG = bo.bc((String) z.get(str3 + ".streamvideo.streamvideourl"), "");
                            aau.wid = bo.ank((String) z.get(str3 + ".streamvideo.streamvideototaltime"));
                            aau.fiI = bo.bc((String) z.get(str3 + ".streamvideo.streamvideotitle"), "");
                            aau.fiJ = bo.bc((String) z.get(str3 + ".streamvideo.streamvideowording"), "");
                            aau.fiK = bo.bc((String) z.get(str3 + ".streamvideo.streamvideoweburl"), "");
                            aau.fiM = bo.bc((String) z.get(str3 + ".streamvideo.streamvideoaduxinfo"), "");
                            aau.fiN = bo.bc((String) z.get(str3 + ".streamvideo.streamvideopublishid"), "");
                            aar.a(aau);
                            aas aas = new aas();
                            String str5 = str3 + ".dataitemsource";
                            if (z.containsKey(str5)) {
                                aat aat = new aat();
                                aat.LI(bo.getInt((String) z.get(str5 + ".$sourcetype"), 0));
                                aat.alo((String) z.get(str5 + ".$sourceid"));
                                aat.alm((String) z.get(str5 + ".fromusr"));
                                aat.aln((String) z.get(str5 + ".tousr"));
                                aat.alp((String) z.get(str5 + ".realchatname"));
                                aat.mi(bo.getLong((String) z.get(str5 + ".createtime"), 0));
                                aat.alq((String) z.get(str5 + ".msgid"));
                                aat.cOS = (String) z.get(str5 + ".eventid");
                                aat.whX = true;
                                aat.alr((String) z.get(str5 + ".appid"));
                                aat.als((String) z.get(str5 + ".link"));
                                aat.alt((String) z.get(str5 + ".brandid"));
                                aas.c(aat);
                            } else {
                                ab.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", str5);
                            }
                            str5 = str3 + ".locitem";
                            if (z.containsKey(str5)) {
                                aay aay = new aay();
                                if (!bo.isNullOrNil((String) z.get(str5 + ".label"))) {
                                    aay.alu((String) z.get(str5 + ".label"));
                                }
                                if (!bo.isNullOrNil((String) z.get(str5 + ".poiname"))) {
                                    aay.alv((String) z.get(str5 + ".poiname"));
                                }
                                str4 = (String) z.get(str5 + ".lng");
                                if (!bo.isNullOrNil(str4)) {
                                    aay.D(bo.getDouble(str4, 0.0d));
                                }
                                str4 = (String) z.get(str5 + ".lat");
                                if (!bo.isNullOrNil(str4)) {
                                    aay.E(bo.getDouble(str4, 0.0d));
                                }
                                str4 = (String) z.get(str5 + ".scale");
                                if (!bo.isNullOrNil(str4)) {
                                    if (str4.indexOf(46) != -1) {
                                        aay.LJ(bo.getInt(str4.substring(0, str4.indexOf(46)), -1));
                                    } else {
                                        aay.LJ(bo.getInt(str4, -1));
                                    }
                                }
                                aas.a(aay);
                            } else {
                                ab.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", str5);
                            }
                            str5 = str3 + ".weburlitem";
                            if (z.containsKey(str5)) {
                                abu abu = new abu();
                                abu.alS((String) z.get(str5 + ".clean_url"));
                                abu.alR((String) z.get(str5 + ".pagedesc"));
                                abu.alT((String) z.get(str5 + ".pagethumb_url"));
                                abu.alQ((String) z.get(str5 + ".pagetitle"));
                                abu.LO(bo.getInt((String) z.get(str5 + ".opencache"), 0));
                                abu.LP(bo.getInt((String) z.get(str5 + ".contentattr"), 0));
                                abu.alU((String) z.get(str5 + ".canvasPageXml"));
                                aas.a(abu);
                            } else {
                                ab.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", str5);
                            }
                            str5 = str3 + ".productitem";
                            if (z.containsKey(str5)) {
                                abe abe = new abe();
                                abe.alw((String) z.get(str5 + ".producttitle"));
                                abe.alx((String) z.get(str5 + ".productdesc"));
                                abe.aly((String) z.get(str5 + ".productthumb_url"));
                                abe.alz((String) z.get(str5 + ".productinfo"));
                                abe.LK(bo.getInt((String) z.get(str5 + ".$type"), 0));
                                aas.a(abe);
                            } else {
                                ab.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", str5);
                            }
                            str5 = str3 + ".tvitem";
                            if (z.containsKey(str5)) {
                                abo abo = new abo();
                                abo.alM((String) z.get(str5 + ".tvtitle"));
                                abo.alN((String) z.get(str5 + ".tvdesc"));
                                abo.alO((String) z.get(str5 + ".tvthumb_url"));
                                abo.alP((String) z.get(str5 + ".tvinfo"));
                                aas.a(abo);
                            } else {
                                ab.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", str5);
                            }
                            str3 = str3 + ".appbranditem";
                            if (z.containsKey(str3)) {
                                aap aap = new aap();
                                aap.username = (String) z.get(str3 + ".username");
                                aap.appId = (String) z.get(str3 + ".appid");
                                aap.cBc = bo.getInt((String) z.get(str3 + ".pkgtype"), 0);
                                aap.iconUrl = (String) z.get(str3 + ".iconurl");
                                aap.type = bo.getInt((String) z.get(str3 + ".type"), 0);
                                aap.csu = (String) z.get(str3 + ".pagepath");
                                aap.wfO = (String) z.get(str3 + ".sourcedisplayname");
                                aas.a(aap);
                            } else {
                                ab.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", str3);
                            }
                            aar.a(aas);
                            abf.wiv.add(aar);
                        }
                    }
                }
            }
            AppMethodBeat.o(102755);
        } catch (Exception e) {
            ab.e("MicroMsg.FavProtoItemParser", "[parser] parseXML exception:%s", e.toString());
            AppMethodBeat.o(102755);
        }
    }
}
