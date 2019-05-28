package com.tencent.mm.plugin.record.b;

import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.af.j.b;
import com.tencent.mm.aj.a.e;
import com.tencent.mm.at.o;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.tq;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.record.a.i;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.b.a.d;
import com.tencent.mm.protocal.protobuf.aap;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.aas;
import com.tencent.mm.protocal.protobuf.aat;
import com.tencent.mm.protocal.protobuf.aay;
import com.tencent.mm.protocal.protobuf.aaz;
import com.tencent.mm.protocal.protobuf.abe;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class n {
    private static final f<Integer, c> emX = new com.tencent.mm.memory.a.c(32);

    public static String a(String str, String str2, abf abf, String str3) {
        AppMethodBeat.i(135697);
        String str4;
        if (abf == null || abf.wiv == null) {
            ab.e("MicroMsg.RecordMsgLogic", "buildRecordAppMsgXML error: protoItem or datalist is null");
            str4 = "";
            AppMethodBeat.o(135697);
            return str4;
        }
        LinkedList linkedList = abf.wiv;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<recordinfo>");
        stringBuilder.append("<title>").append(bo.ani(str)).append("</title>");
        stringBuilder.append("<desc>").append(bo.ani(str2)).append("</desc>");
        a(stringBuilder, abf);
        stringBuilder.append(o.bK(linkedList));
        stringBuilder.append("<favusername>").append(bo.ani(str3)).append("</favusername>");
        stringBuilder.append("</recordinfo>");
        b bVar = new b();
        bVar.title = str;
        bVar.description = str2;
        if (linkedList.size() <= 0 || bo.isNullOrNil(((aar) linkedList.get(0)).wgo) || !((aar) linkedList.get(0)).wgo.equals(".htm")) {
            bVar.type = 19;
            bVar.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/favorite_record__w_unsupport&from=singlemessage&isappinstalled=0";
        } else {
            bVar.type = 24;
            bVar.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008";
        }
        bVar.action = "view";
        bVar.fgU = stringBuilder.toString();
        str4 = b.a(bVar, null, null);
        AppMethodBeat.o(135697);
        return str4;
    }

    public static int a(Context context, String str, String str2, List<bi> list, cl clVar, d dVar) {
        AppMethodBeat.i(135700);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
            AppMethodBeat.o(135700);
            return -1;
        } else if (list == null || list.isEmpty()) {
            ab.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo error");
            AppMethodBeat.o(135700);
            return -1;
        } else {
            if (clVar == null || dVar == null) {
                clVar = new cl();
                if (b.a(context, clVar, str2, (List) list)) {
                    dVar = a(context, clVar, str2);
                } else {
                    AppMethodBeat.o(135700);
                    return -1;
                }
            }
            b a = a(dVar.title, dVar.desc, clVar.cvA.cvC);
            bi biVar = new bi();
            byte[] bArr = null;
            if (!bo.isNullOrNil(dVar.thumbPath)) {
                bArr = bo.readFromFile(dVar.thumbPath);
            } else if (dVar.cKc == 0 && !bo.isNullOrNil(dVar.mjO)) {
                bArr = com.tencent.mm.sdk.platformtools.d.ai(com.tencent.mm.ah.b.a(dVar.mjO, false, -1));
            }
            if (bArr != null) {
                String a2;
                if (bArr.length > 65536) {
                    a2 = o.ahl().a(bArr, false, CompressFormat.JPEG);
                } else {
                    a2 = o.ahl().W(bArr);
                }
                ab.d("MicroMsg.RecordMsgLogic", g.Mq() + " thumbData MsgInfo path:" + a2);
                if (!bo.isNullOrNil(a2)) {
                    biVar.jv(a2);
                }
            }
            biVar.setContent(b.a(a, null, null));
            biVar.setStatus(1);
            biVar.ju(str);
            biVar.eJ(bf.oC(str));
            biVar.hO(1);
            biVar.setType(49);
            if (com.tencent.mm.aj.f.kq(str)) {
                biVar.ix(e.aae());
            }
            long Z = ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().Z(biVar);
            ab.d("MicroMsg.RecordMsgLogic", g.Mq() + " msginfo insert id: " + Z);
            if (Z < 0) {
                ab.e("MicroMsg.RecordMsgLogic", g.Mq() + "insert msg failed :" + Z);
                int line = 0 - g.getLine();
                AppMethodBeat.o(135700);
                return line;
            }
            ab.i("MicroMsg.RecordMsgLogic", g.getLine() + " new msg inserted to db , local id = " + Z);
            biVar.setMsgId(Z);
            com.tencent.mm.af.j jVar = new com.tencent.mm.af.j();
            jVar.field_xml = biVar.field_content;
            jVar.field_title = a.title;
            jVar.field_type = a.type;
            jVar.field_description = a.description;
            jVar.field_msgId = Z;
            a.bYK().b((com.tencent.mm.sdk.e.c) jVar);
            Iterator it = clVar.cvA.cvC.wiv.iterator();
            boolean z = false;
            while (it.hasNext()) {
                aar aar = (aar) it.next();
                if (bo.isNullOrNil(aar.mnd)) {
                    String obj = aar.toString();
                    aar.akU(com.tencent.mm.a.g.x((obj + aar.dataType + System.currentTimeMillis()).getBytes()));
                }
                if (z || com.tencent.mm.a.e.ct(aar.wgx) || com.tencent.mm.a.e.ct(aar.wgz) || !bo.isNullOrNil(aar.wfZ) || !bo.isNullOrNil(aar.fgE) || !bo.isNullOrNil(aar.whr) || !bo.isNullOrNil(aar.fgv)) {
                    z = true;
                }
            }
            ab.d("MicroMsg.RecordMsgLogic", "summerrecord needNetScene:%b", Boolean.valueOf(z));
            if (z) {
                com.tencent.mm.plugin.record.a.j jVar2 = new com.tencent.mm.plugin.record.a.j();
                jVar2.field_msgId = Z;
                jVar2.field_title = a.title;
                jVar2.field_desc = a.description;
                jVar2.field_toUser = str;
                jVar2.field_dataProto = clVar.cvA.cvC;
                jVar2.field_type = 3;
                jVar2.field_localId = new Random().nextInt(2147483645) + 1;
                ab.i("MicroMsg.RecordMsgLogic", "summerrecord needNetScene insert ret:%b, id:%d, localid:%d", Boolean.valueOf(((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().b(jVar2)), Long.valueOf(Z), Integer.valueOf(jVar2.field_localId));
                ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(jVar2);
            } else {
                ab.d("MicroMsg.RecordMsgLogic", "summerrecord do not trans cdn, directly send msg id:%d", Long.valueOf(Z));
                ((com.tencent.mm.plugin.record.a.f) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.record.a.f.class)).jB(Z);
            }
            AppMethodBeat.o(135700);
            return 0;
        }
    }

    public static d a(Context context, cl clVar, String str) {
        String str2;
        int i = 0;
        AppMethodBeat.i(135701);
        d dVar = new d();
        SparseIntArray sparseIntArray = new SparseIntArray();
        if (com.tencent.mm.aj.f.kq(str)) {
            dVar.title = clVar.cvA.cvC.title;
        } else if (t.kH(str)) {
            dVar.title = context.getString(R.string.dja);
        } else {
            if (r.YB().equals(((com.tencent.mm.plugin.messenger.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.a.b.class)).mI(str))) {
                dVar.title = context.getString(R.string.bqj, new Object[]{r.YB()});
            } else {
                dVar.title = context.getString(R.string.bqi, new Object[]{r.YB(), ((com.tencent.mm.plugin.messenger.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.a.b.class)).mI(str)});
            }
        }
        ab.d("MicroMsg.RecordMsgLogic", "msgInfo title %s", dVar.title);
        LinkedList linkedList = new LinkedList();
        List list;
        if (clVar.cvA.cvC != null) {
            list = clVar.cvA.cvC.wiv;
        } else {
            list = new LinkedList();
        }
        for (aar aar : list) {
            sparseIntArray.put(aar.dataType, sparseIntArray.get(aar.dataType) + 1);
            switch (aar.dataType) {
                case 1:
                    if (linkedList.size() >= 5) {
                        break;
                    }
                    linkedList.add(aar.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + aar.desc + IOUtils.LINE_SEPARATOR_UNIX);
                    break;
                case 2:
                    if (linkedList.size() < 5) {
                        linkedList.add(aar.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(R.string.sn) + IOUtils.LINE_SEPARATOR_UNIX);
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, aar, (int) R.drawable.avp);
                    i = 1;
                    break;
                case 3:
                    if (linkedList.size() >= 5) {
                        break;
                    }
                    linkedList.add(aar.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(R.string.ug) + IOUtils.LINE_SEPARATOR_UNIX);
                    break;
                case 4:
                    if (linkedList.size() < 5) {
                        linkedList.add(aar.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(R.string.ud) + IOUtils.LINE_SEPARATOR_UNIX);
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, aar, (int) R.raw.app_attach_file_icon_video);
                    i = 1;
                    break;
                case 5:
                    if (linkedList.size() < 5) {
                        linkedList.add(aar.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(R.string.u9) + aar.title + IOUtils.LINE_SEPARATOR_UNIX);
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, aar, (int) R.raw.app_attach_file_icon_webpage);
                    i = 1;
                    break;
                case 6:
                    if (linkedList.size() < 5) {
                        aay aay = aar.wgT.why;
                        StringBuilder append = new StringBuilder().append(aar.wgV).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(context.getString(R.string.rf));
                        if (bo.isNullOrNil(aay.cIK) || aay.cIK.equals(context.getString(R.string.rf))) {
                            str2 = aay.label;
                        } else {
                            str2 = aay.cIK;
                        }
                        linkedList.add(append.append(str2).append(IOUtils.LINE_SEPARATOR_UNIX).toString());
                    }
                    if (i != 0) {
                        break;
                    }
                    dVar.cKc = R.raw.app_attach_file_icon_location;
                    i = 1;
                    break;
                    break;
                case 7:
                    if (linkedList.size() < 5) {
                        linkedList.add(aar.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(R.string.rs) + aar.title + IOUtils.LINE_SEPARATOR_UNIX);
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, aar, (int) R.raw.app_attach_file_icon_music);
                    i = 1;
                    break;
                case 8:
                    if (linkedList.size() < 5) {
                        linkedList.add(aar.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(R.string.qr) + aar.title + IOUtils.LINE_SEPARATOR_UNIX);
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, aar, (int) R.raw.app_attach_file_icon_unknow);
                    i = 1;
                    break;
                case 10:
                case 11:
                    if (linkedList.size() < 5) {
                        linkedList.add(aar.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(R.string.ss) + aar.wgT.whC.title + IOUtils.LINE_SEPARATOR_UNIX);
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, aar, (int) R.raw.app_attach_file_icon_unknow);
                    i = 1;
                    break;
                case 14:
                    if (linkedList.size() < 5) {
                        linkedList.add(aar.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(R.string.fy) + IOUtils.LINE_SEPARATOR_UNIX);
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, aar, (int) R.raw.app_attach_file_icon_unknow);
                    i = 1;
                    break;
                case 15:
                    if (linkedList.size() < 5) {
                        linkedList.add(aar.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(R.string.ud) + IOUtils.LINE_SEPARATOR_UNIX);
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, aar, (int) R.raw.app_attach_file_icon_video);
                    i = 1;
                    break;
                case 16:
                    if (linkedList.size() < 5) {
                        linkedList.add(aar.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(R.string.qw) + IOUtils.LINE_SEPARATOR_UNIX);
                    }
                    if (i != 0) {
                        break;
                    }
                    dVar.mjO = ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().Rn(aar.desc).svN;
                    i = 1;
                    break;
                case 17:
                    if (linkedList.size() >= 5) {
                        break;
                    }
                    linkedList.add(aar.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(R.string.t5) + IOUtils.LINE_SEPARATOR_UNIX);
                    break;
                case 19:
                    if (linkedList.size() >= 5) {
                        break;
                    }
                    linkedList.add(aar.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(R.string.fz) + aar.title + IOUtils.LINE_SEPARATOR_UNIX);
                    break;
                default:
                    break;
            }
        }
        str2 = "";
        dVar.desc = "";
        Iterator it = linkedList.iterator();
        while (true) {
            String str3 = str2;
            if (it.hasNext()) {
                str2 = str3 + ((String) it.next());
            } else {
                str2 = str3.trim();
                if (linkedList.size() >= 5) {
                    str2 = str2 + "...";
                }
                dVar.desc = str2;
                AppMethodBeat.o(135701);
                return dVar;
            }
        }
    }

    public static int a(String str, String str2, bi biVar) {
        AppMethodBeat.i(135703);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
            AppMethodBeat.o(135703);
            return -1;
        } else if (biVar == null || bo.isNullOrNil(biVar.field_content)) {
            ab.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo error");
            AppMethodBeat.o(135703);
            return -1;
        } else if (1 == biVar.field_status) {
            ab.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo is sending");
            AppMethodBeat.o(135703);
            return -1;
        } else {
            for (String str3 : bo.P(str.split(","))) {
                ab.i("MicroMsg.RecordMsgLogic", "send recordMsg, toUser[%s] msgId[%d], msgType[%d]", str3, Long.valueOf(biVar.field_msgId), Integer.valueOf(biVar.field_status));
                String oz = bf.oz(biVar.field_content);
                b me = b.me(oz);
                if (me == null) {
                    ab.w("MicroMsg.RecordMsgLogic", "send record msg error, parse appmsg error");
                    AppMethodBeat.o(135703);
                    return -1;
                }
                c VI = VI(me.fgU);
                if (VI == null) {
                    ab.w("MicroMsg.RecordMsgLogic", "send record msg error, parse record data error");
                    AppMethodBeat.o(135703);
                    return -1;
                }
                bi biVar2 = new bi();
                if (!bo.isNullOrNil(biVar.field_imgPath)) {
                    String W = o.ahl().W(bo.readFromFile(o.ahl().I(biVar.field_imgPath, true)));
                    ab.d("MicroMsg.RecordMsgLogic", g.Mq() + " thumbData from msg MsgInfo path:" + W);
                    if (!bo.isNullOrNil(W)) {
                        biVar2.jv(W);
                    }
                }
                biVar2.setContent(oz);
                biVar2.setStatus(1);
                biVar2.ju(str3);
                biVar2.eJ(bf.oC(str3));
                biVar2.hO(1);
                biVar2.setType(49);
                long Z = ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().Z(biVar2);
                ab.d("MicroMsg.RecordMsgLogic", g.Mq() + " msginfo insert id: " + Z);
                if (Z < 0) {
                    ab.e("MicroMsg.RecordMsgLogic", g.Mq() + "insert msg failed :" + Z);
                    int line = 0 - g.getLine();
                    AppMethodBeat.o(135703);
                    return line;
                }
                Object obj;
                ab.i("MicroMsg.RecordMsgLogic", g.getLine() + " new msg inserted to db , local id = " + Z);
                biVar2.setMsgId(Z);
                tq tqVar = new tq();
                tqVar.cPN.cPO = biVar.field_msgId;
                tqVar.cPN.cPP = Z;
                com.tencent.mm.sdk.b.a.xxA.m(tqVar);
                com.tencent.mm.af.j jVar = new com.tencent.mm.af.j();
                jVar.field_xml = biVar2.field_content;
                jVar.field_title = me.title;
                jVar.field_type = me.type;
                jVar.field_description = me.description;
                jVar.field_msgId = Z;
                a.bYK().b((com.tencent.mm.sdk.e.c) jVar);
                Iterator it = VI.fjr.iterator();
                while (it.hasNext()) {
                    aar aar = (aar) it.next();
                    if (bo.isNullOrNil(aar.wfZ) && bo.isNullOrNil(aar.fgE) && bo.isNullOrNil(aar.whr)) {
                        if (!bo.isNullOrNil(aar.fgv)) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = 1;
                    break;
                }
                obj = null;
                if (obj != null) {
                    com.tencent.mm.plugin.record.a.j jVar2 = new com.tencent.mm.plugin.record.a.j();
                    abf abf = new abf();
                    abf.wiv.addAll(VI.fjr);
                    jVar2.field_msgId = Z;
                    jVar2.field_oriMsgId = biVar.field_msgId;
                    jVar2.field_toUser = str3;
                    jVar2.field_title = me.title;
                    jVar2.field_desc = bo.bc(VI.desc, me.description);
                    jVar2.field_dataProto = abf;
                    jVar2.field_type = 0;
                    jVar2.field_favFrom = VI.vzJ;
                    jVar2.field_localId = new Random().nextInt(2147483645) + 1;
                    ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().b(jVar2);
                    ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(jVar2);
                } else {
                    ab.d("MicroMsg.RecordMsgLogic", "do not check upload, directly send msg");
                    ((com.tencent.mm.plugin.record.a.f) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.record.a.f.class)).jB(Z);
                }
                if (!bo.isNullOrNil(str2)) {
                    com.tencent.mm.plugin.messenger.a.g.bOk().F(str3, str2, t.nK(str3));
                }
            }
            AppMethodBeat.o(135703);
            return 0;
        }
    }

    public static int a(String str, abf abf, String str2, String str3, String str4, int i, String str5) {
        AppMethodBeat.i(135704);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
            AppMethodBeat.o(135704);
            return -1;
        } else if (abf == null || abf.wiv.isEmpty()) {
            ab.w("MicroMsg.RecordMsgLogic", "send record msg error, favprotoitem error");
            AppMethodBeat.o(135704);
            return -1;
        } else {
            b a = a(str2, str3, abf);
            bi biVar = new bi();
            byte[] bArr = null;
            if (!bo.isNullOrNil(str4)) {
                bArr = bo.readFromFile(str4);
            } else if (i != 0) {
                bArr = com.tencent.mm.sdk.platformtools.d.ai(com.tencent.mm.sdk.platformtools.d.LV(i));
            } else if (!bo.isNullOrNil(str5)) {
                bArr = com.tencent.mm.sdk.platformtools.d.ai(com.tencent.mm.ah.b.a(str5, false, -1));
            }
            if (bArr != null) {
                String a2;
                if (bArr.length > 65536) {
                    a2 = o.ahl().a(bArr, false, CompressFormat.JPEG);
                } else {
                    a2 = o.ahl().W(bArr);
                }
                ab.d("MicroMsg.RecordMsgLogic", g.Mq() + " thumbData MsgInfo path:" + a2);
                if (!bo.isNullOrNil(a2)) {
                    biVar.jv(a2);
                }
            }
            biVar.setContent(b.a(a, null, null));
            biVar.setStatus(1);
            biVar.ju(str);
            biVar.eJ(bf.oC(str));
            biVar.hO(1);
            biVar.setType(49);
            if (com.tencent.mm.aj.f.kq(str)) {
                biVar.ix(e.aae());
            }
            long Z = ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().Z(biVar);
            ab.d("MicroMsg.RecordMsgLogic", g.Mq() + " msginfo insert id: " + Z);
            if (Z < 0) {
                ab.e("MicroMsg.RecordMsgLogic", g.Mq() + "insert msg failed :" + Z);
                int line = 0 - g.getLine();
                AppMethodBeat.o(135704);
                return line;
            }
            ab.i("MicroMsg.RecordMsgLogic", g.getLine() + " new msg inserted to db , local id = " + Z);
            biVar.setMsgId(Z);
            com.tencent.mm.af.j jVar = new com.tencent.mm.af.j();
            jVar.field_xml = biVar.field_content;
            jVar.field_title = a.title;
            jVar.field_type = a.type;
            jVar.field_description = a.description;
            jVar.field_msgId = Z;
            a.bYK().b((com.tencent.mm.sdk.e.c) jVar);
            Iterator it = abf.wiv.iterator();
            while (it.hasNext()) {
                aar aar = (aar) it.next();
                if (bo.isNullOrNil(aar.wfZ)) {
                    if (!bo.isNullOrNil(aar.fgE)) {
                        break;
                    }
                }
                break;
            }
            com.tencent.mm.plugin.record.a.j jVar2 = new com.tencent.mm.plugin.record.a.j();
            jVar2.field_msgId = Z;
            jVar2.field_title = a.title;
            jVar2.field_desc = a.description;
            jVar2.field_toUser = str;
            jVar2.field_dataProto = abf;
            jVar2.field_type = 1;
            jVar2.field_localId = new Random().nextInt(2147483645) + 1;
            ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().b(jVar2);
            ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(jVar2);
            AppMethodBeat.o(135704);
            return 0;
        }
    }

    private static File jE(long j) {
        AppMethodBeat.i(135705);
        Object[] objArr = new Object[2];
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.RQ();
        objArr[0] = stringBuilder.append(com.tencent.mm.kernel.g.RP().eJM).append("record/").toString();
        objArr[1] = Long.valueOf(j);
        File file = new File(String.format("%s/%d/", objArr));
        if (!(file.exists() && file.isDirectory())) {
            file.mkdirs();
        }
        AppMethodBeat.o(135705);
        return file;
    }

    public static void jF(long j) {
        AppMethodBeat.i(135706);
        boolean t = com.tencent.mm.a.e.t(jE(j));
        ab.i("MicroMsg.RecordMsgLogic", "do clear resource, path %s, result %B", r0.getAbsolutePath(), Boolean.valueOf(t));
        AppMethodBeat.o(135706);
    }

    public static String c(aar aar, long j) {
        int i = 1;
        AppMethodBeat.i(135707);
        String str;
        if (aar == null) {
            str = "";
            AppMethodBeat.o(135707);
            return str;
        }
        String str2 = aar.mnd;
        if (!bo.isNullOrNil(str2) && ah.bqo() && com.tencent.mm.kernel.g.RK()) {
            File jE = jE(j);
            if (aar.dataType != 8 || bo.isNullOrNil(aar.title)) {
                i = 0;
            } else {
                str2 = aar.title;
                int hashCode = aar.mnd.hashCode() & 255;
                r6 = new Object[3];
                StringBuilder stringBuilder = new StringBuilder();
                com.tencent.mm.kernel.g.RQ();
                r6[0] = stringBuilder.append(com.tencent.mm.kernel.g.RP().eJM).append("record/").toString();
                r6[1] = Long.valueOf(j);
                r6[2] = Integer.valueOf(hashCode);
                jE = new File(String.format("%s/%d/%d/", r6));
                if (!(jE.exists() && jE.isDirectory())) {
                    jE.mkdirs();
                }
            }
            if (aar.wgo != null && aar.wgo.trim().length() > 0 && i == 0) {
                str2 = str2 + "." + aar.wgo;
            }
            str = new File(jE, str2).getAbsolutePath();
            AppMethodBeat.o(135707);
            return str;
        }
        str = "";
        AppMethodBeat.o(135707);
        return str;
    }

    public static boolean d(aar aar, long j) {
        AppMethodBeat.i(135708);
        boolean exists = new File(c(aar, j)).exists();
        AppMethodBeat.o(135708);
        return exists;
    }

    public static boolean e(aar aar, long j) {
        AppMethodBeat.i(135709);
        boolean exists = new File(f(aar, j)).exists();
        AppMethodBeat.o(135709);
        return exists;
    }

    public static String f(aar aar, long j) {
        AppMethodBeat.i(135710);
        String str;
        if (aar == null || bo.isNullOrNil(aar.mnd)) {
            str = "";
            AppMethodBeat.o(135710);
            return str;
        }
        str = new File(jE(j), LA(aar.mnd)).getAbsolutePath();
        AppMethodBeat.o(135710);
        return str;
    }

    public static String LA(String str) {
        AppMethodBeat.i(135711);
        String str2 = str + "_t";
        AppMethodBeat.o(135711);
        return str2;
    }

    public static String h(String str, long j, boolean z) {
        AppMethodBeat.i(135712);
        String str2;
        if (z) {
            str2 = str + "@record_download@" + j;
            AppMethodBeat.o(135712);
            return str2;
        }
        str2 = str + "@record_upload@" + j;
        AppMethodBeat.o(135712);
        return str2;
    }

    static {
        AppMethodBeat.i(135720);
        AppMethodBeat.o(135720);
    }

    public static c VI(String str) {
        AppMethodBeat.i(135713);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.RecordMsgLogic", "xml is null");
            AppMethodBeat.o(135713);
            return null;
        }
        int hashCode = str.hashCode();
        c cVar = (c) emX.get(Integer.valueOf(hashCode));
        if (cVar != null) {
            ab.d("MicroMsg.RecordMsgLogic", "get record msg data from cache");
            AppMethodBeat.o(135713);
            return cVar;
        }
        Map z;
        if (str.trim().contains("<recordinfo>")) {
            z = br.z(str, "recordinfo");
        } else {
            z = br.z("<recordinfo>" + str + "</recordinfo>", "recordinfo");
        }
        if (z == null) {
            ab.e("MicroMsg.RecordMsgLogic", "values is null: %s", str);
            AppMethodBeat.o(135713);
            return null;
        }
        c cVar2 = new c();
        cVar2.title = (String) z.get(".recordinfo.title");
        cVar2.desc = (String) z.get(".recordinfo.desc");
        cVar2.vzJ = (String) z.get(".recordinfo.favusername");
        if (z.get(".recordinfo.noteinfo") != null) {
            aaz aaz = new aaz();
            aaz.win = (String) z.get(".recordinfo.noteinfo.noteeditor");
            aaz.wim = (String) z.get(".recordinfo.noteinfo.noteauthor");
            cVar2.vzK = aaz;
            cVar2.lgR = bo.getLong((String) z.get(".recordinfo.edittime"), 0);
        }
        a(str, cVar2);
        emX.put(Integer.valueOf(hashCode), cVar2);
        AppMethodBeat.o(135713);
        return cVar2;
    }

    private static void a(String str, c cVar) {
        AppMethodBeat.i(135714);
        cVar.fjr.clear();
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(str.getBytes())));
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("datalist");
            if (elementsByTagName != null) {
                NodeList childNodes = elementsByTagName.item(0).getChildNodes();
                if (childNodes != null && childNodes.getLength() > 0) {
                    int length = childNodes.getLength();
                    for (int i = 0; i < length; i++) {
                        Node item = childNodes.item(i);
                        String b = br.b(item);
                        if (item instanceof Element) {
                            String str2;
                            String str3;
                            Map z;
                            Object obj;
                            NodeList elementsByTagName2 = ((Element) item).getElementsByTagName("recordxml");
                            if (elementsByTagName2 != null && elementsByTagName2.getLength() > 0) {
                                NodeList childNodes2 = elementsByTagName2.item(0).getChildNodes();
                                if (childNodes2 != null && childNodes2.getLength() > 0) {
                                    int length2 = childNodes2.getLength();
                                    for (int i2 = 0; i2 < length2; i2++) {
                                        Node item2 = childNodes2.item(i2);
                                        if (item2 instanceof Element) {
                                            ab.d("MicroMsg.RecordMsgLogic", "recordXml: %s", br.b(item2));
                                            str2 = str3;
                                            break;
                                        }
                                    }
                                }
                            }
                            str2 = null;
                            if (b.trim().startsWith("<dataitem")) {
                                z = br.z(b, "dataitem");
                            } else {
                                z = null;
                            }
                            if (z == null) {
                                obj = null;
                            } else {
                                aar aar = new aar();
                                String str4 = ".dataitem";
                                aar.LE(bo.getInt((String) z.get(str4 + ".$datatype"), 0));
                                aar.akZ((String) z.get(str4 + ".$datasourceid"));
                                aar.LF(bo.getInt((String) z.get(str4 + ".$datastatus"), 0));
                                aar.akR((String) z.get(str4 + ".datafmt"));
                                aar.akH((String) z.get(str4 + ".datatitle"));
                                aar.akI((String) z.get(str4 + ".datadesc"));
                                aar.akJ((String) z.get(str4 + ".cdnthumburl"));
                                aar.akK((String) z.get(str4 + ".cdnthumbkey"));
                                aar.LB(bo.getInt((String) z.get(str4 + ".thumbwidth"), 0));
                                aar.LC(bo.getInt((String) z.get(str4 + ".thumbheight"), 0));
                                aar.akL((String) z.get(str4 + ".cdndataurl"));
                                aar.akM((String) z.get(str4 + ".cdndatakey"));
                                aar.fgv = (String) z.get(str4 + ".tpthumburl");
                                aar.whn = true;
                                aar.ali((String) z.get(str4 + ".tpaeskey"));
                                aar.alj((String) z.get(str4 + ".tpauthkey"));
                                aar.alk((String) z.get(str4 + ".tpdataurl"));
                                aar.fgB = (String) z.get(str4 + ".tpthumbaeskey");
                                aar.wht = true;
                                str3 = (String) z.get(str4 + ".duration");
                                if (str3 != null && str3.length() > 0) {
                                    aar.LD(bo.getInt(str3, 0));
                                }
                                aar.akO((String) z.get(str4 + ".streamdataurl"));
                                aar.akP((String) z.get(str4 + ".streamlowbandurl"));
                                aar.akN((String) z.get(str4 + ".streamweburl"));
                                aar.akS((String) z.get(str4 + ".fullmd5"));
                                aar.akT((String) z.get(str4 + ".head256md5"));
                                str3 = (String) z.get(str4 + ".datasize");
                                if (!bo.isNullOrNil(str3)) {
                                    aar.mf((long) bo.getInt(str3, 0));
                                }
                                aar.akQ((String) z.get(str4 + ".dataext"));
                                aar.akX((String) z.get(str4 + ".thumbfullmd5"));
                                aar.akY((String) z.get(str4 + ".thumbhead256md5"));
                                str3 = (String) z.get(str4 + ".thumbsize");
                                if (!bo.isNullOrNil(str3)) {
                                    aar.mg((long) bo.getInt(str3, 0));
                                }
                                aar.ala((String) z.get(str4 + ".streamvideoid"));
                                str3 = (String) z.get(str4 + ".$dataid");
                                if (bo.isNullOrNil(str3)) {
                                    str3 = String.valueOf(i);
                                }
                                aar.akU(str3);
                                str3 = (String) z.get(str4 + ".$htmlid");
                                if (!bo.isNullOrNil(str3)) {
                                    aar.ale(str3);
                                }
                                aar.LG(bo.getInt((String) z.get(str4 + ".$dataillegaltype"), 0));
                                aar.alb((String) z.get(str4 + ".sourcetitle"));
                                aar.alc((String) z.get(str4 + ".sourcename"));
                                aar.all((String) z.get(str4 + ".sourcedesc"));
                                aar.ald((String) z.get(str4 + ".sourcetime"));
                                aar.alf((String) z.get(str4 + ".statextstr"));
                                if (str2 != null) {
                                    aar.alh(str2);
                                }
                                aas aas = new aas();
                                aat aat = new aat();
                                aat.LI(bo.getInt((String) z.get(str4 + ".$sourcetype"), 0));
                                str3 = (String) z.get(str4 + ".dataitemsource.fromusr");
                                if (!bo.isNullOrNil(str3)) {
                                    aat.alm(str3);
                                    ab.d("MicroMsg.RecordMsgParser", "fromusr %s", aat.cEV);
                                }
                                str3 = (String) z.get(str4 + ".dataitemsource.realchatname");
                                if (!bo.isNullOrNil(str3)) {
                                    aat.alp(str3);
                                    ab.d("MicroMsg.RecordMsgParser", "realChatname %s", aat.whU);
                                }
                                aat.alr((String) z.get(str4 + ".appid"));
                                aat.als((String) z.get(str4 + ".link"));
                                aat.alt((String) z.get(str4 + ".brandid"));
                                aas.c(aat);
                                String str5 = str4 + ".locitem";
                                if (z.containsKey(str5)) {
                                    aay aay = new aay();
                                    if (!bo.isNullOrNil((String) z.get(str5 + ".label"))) {
                                        aay.alu((String) z.get(str5 + ".label"));
                                    }
                                    if (!bo.isNullOrNil((String) z.get(str5 + ".poiname"))) {
                                        aay.alv((String) z.get(str5 + ".poiname"));
                                    }
                                    str3 = (String) z.get(str5 + ".lng");
                                    if (!bo.isNullOrNil(str3)) {
                                        aay.D(bo.getDouble(str3, 0.0d));
                                    }
                                    str3 = (String) z.get(str5 + ".lat");
                                    if (!bo.isNullOrNil(str3)) {
                                        aay.E(bo.getDouble(str3, 0.0d));
                                    }
                                    str3 = (String) z.get(str5 + ".scale");
                                    if (!bo.isNullOrNil(str3)) {
                                        if (str3.indexOf(46) != -1) {
                                            aay.LJ(bo.getInt(str3.substring(0, str3.indexOf(46)), -1));
                                        } else {
                                            aay.LJ(bo.getInt(str3, -1));
                                        }
                                    }
                                    aas.a(aay);
                                } else {
                                    ab.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", str5);
                                }
                                str5 = str4 + ".weburlitem";
                                if (z.containsKey(str5)) {
                                    abu abu = new abu();
                                    abu.alQ((String) z.get(str5 + ".title"));
                                    abu.alR((String) z.get(str5 + ".desc"));
                                    abu.alT((String) z.get(str5 + ".thumburl"));
                                    abu.alS((String) z.get(str5 + ".link"));
                                    abu.LO(bo.getInt((String) z.get(str5 + ".opencache"), 0));
                                    aas.a(abu);
                                } else {
                                    ab.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", str5);
                                }
                                str5 = str4 + ".productitem";
                                if (z.containsKey(str5)) {
                                    abe abe = new abe();
                                    abe.alw((String) z.get(str5 + ".title"));
                                    abe.alx((String) z.get(str5 + ".desc"));
                                    abe.aly((String) z.get(str5 + ".thumburl"));
                                    abe.alz((String) z.get(str5 + ".productinfo"));
                                    abe.LK(bo.getInt((String) z.get(str5 + ".$type"), 0));
                                    aas.a(abe);
                                } else {
                                    ab.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", str5);
                                }
                                str5 = str4 + ".tvitem";
                                if (z.containsKey(str5)) {
                                    abo abo = new abo();
                                    abo.alM((String) z.get(str5 + ".title"));
                                    abo.alN((String) z.get(str5 + ".desc"));
                                    abo.alO((String) z.get(str5 + ".thumburl"));
                                    abo.alP((String) z.get(str5 + ".tvinfo"));
                                    aas.a(abo);
                                } else {
                                    ab.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", str5);
                                }
                                str4 = str4 + ".appbranditem";
                                if (z.containsKey(str4)) {
                                    aap aap = new aap();
                                    aap.username = (String) z.get(str4 + ".username");
                                    aap.appId = (String) z.get(str4 + ".appid");
                                    aap.cBc = bo.getInt((String) z.get(str4 + ".pkgtype"), 0);
                                    aap.iconUrl = (String) z.get(str4 + ".iconurl");
                                    aap.type = bo.getInt((String) z.get(str4 + ".type"), 0);
                                    aap.csu = (String) z.get(str4 + ".pagepath");
                                    aap.wfO = (String) z.get(str4 + ".sourcedisplayname");
                                    aas.a(aap);
                                } else {
                                    ab.v("MicroMsg.RecordMsgParser", "cur fav not contains %s", str4);
                                }
                                aar.a(aas);
                                aar obj2 = aar;
                            }
                            try {
                                cVar.fjr.add(obj2);
                            } catch (Exception e) {
                                ab.e("MicroMsg.RecordMsgLogic", "get record msg data from xml error: %s", e.getMessage());
                                ab.printErrStackTrace("MicroMsg.RecordMsgLogic", e, "", new Object[0]);
                                cVar.fjr.clear();
                            }
                        }
                    }
                }
            }
            AppMethodBeat.o(135714);
        } catch (Exception e2) {
            ab.e("MicroMsg.RecordMsgLogic", "[parser] parseXML exception:%s", e2.toString());
            AppMethodBeat.o(135714);
        }
    }

    public static int BH(int i) {
        if (2 == i) {
            return com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
        }
        if (4 == i) {
            return com.tencent.mm.i.a.MediaType_VIDEO;
        }
        return com.tencent.mm.i.a.MediaType_FILE;
    }

    public static boolean b(aar aar, long j, boolean z) {
        AppMethodBeat.i(135715);
        if (aar == null) {
            ab.w("MicroMsg.RecordMsgLogic", "try download data fail, dataitem is null");
            AppMethodBeat.o(135715);
            return false;
        }
        i iVar;
        String h = h(aar.mnd, j, true);
        i VH = ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().VH(h);
        if (VH == null) {
            iVar = new i();
            iVar.field_cdnKey = aar.wgb;
            iVar.field_cdnUrl = aar.wfZ;
            iVar.field_dataId = aar.mnd;
            iVar.field_mediaId = h;
            iVar.field_totalLen = (int) aar.wgu;
            iVar.field_localId = new Random().nextInt(2147483645) + 1;
            iVar.field_path = c(aar, j);
            iVar.field_type = 1;
            iVar.field_fileType = BH(aar.dataType);
            iVar.field_isThumb = false;
            iVar.field_tpaeskey = aar.who;
            iVar.field_tpauthkey = aar.fgA;
            iVar.field_tpdataurl = aar.whr;
            boolean b = ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(iVar);
            ab.d("MicroMsg.RecordMsgLogic", "insert localId[%d] result[%B]", Integer.valueOf(iVar.field_localId), Boolean.valueOf(b));
            if (!bo.isNullOrNil(aar.whb) && aar.whb.equals("WeNoteHtmlFile")) {
                ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().a(iVar);
            }
        } else {
            iVar = VH;
        }
        ab.d("MicroMsg.RecordMsgLogic", "try download data, dump record cdninfo: %s", iVar);
        if (4 == iVar.field_status) {
            ab.w("MicroMsg.RecordMsgLogic", "try download, but cdn info out of date, code[%d]", Integer.valueOf(iVar.field_errCode));
            AppMethodBeat.o(135715);
            return false;
        }
        if (3 == iVar.field_status) {
            ab.i("MicroMsg.RecordMsgLogic", "try download, but cdn info error, code[%d], can retry[%B]", Integer.valueOf(iVar.field_errCode), Boolean.valueOf(z));
            if (z) {
                iVar.field_status = 1;
                ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(iVar, "localId");
            } else {
                AppMethodBeat.o(135715);
                return false;
            }
        }
        ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
        AppMethodBeat.o(135715);
        return true;
    }

    public static boolean g(aar aar, long j) {
        AppMethodBeat.i(135716);
        if (aar == null) {
            ab.w("MicroMsg.RecordMsgLogic", "checkDataOutOfDate fail, dataitem is null");
            AppMethodBeat.o(135716);
            return true;
        }
        i VH = ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().VH(h(aar.mnd, j, true));
        if (VH == null) {
            ab.d("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, not find cdn info");
            AppMethodBeat.o(135716);
            return false;
        } else if (4 == VH.field_status) {
            ab.w("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, status err, code %d", Integer.valueOf(VH.field_errCode));
            AppMethodBeat.o(135716);
            return true;
        } else {
            ab.d("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, find cdn info, status %d", Integer.valueOf(VH.field_status));
            AppMethodBeat.o(135716);
            return false;
        }
    }

    public static boolean c(aar aar, long j, boolean z) {
        AppMethodBeat.i(135717);
        if (aar == null) {
            ab.w("MicroMsg.RecordMsgLogic", "try download thumb error, dataitem is null");
            AppMethodBeat.o(135717);
            return false;
        }
        i iVar;
        String LA = LA(aar.mnd);
        String h = h(LA, j, true);
        i VH = ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().VH(h);
        if (VH == null) {
            iVar = new i();
            iVar.field_cdnKey = aar.wfV;
            iVar.field_cdnUrl = aar.fgE;
            iVar.field_dataId = LA;
            iVar.field_mediaId = h;
            iVar.field_totalLen = (int) aar.wgF;
            iVar.field_localId = new Random().nextInt(2147483645) + 1;
            iVar.field_path = f(aar, j);
            iVar.field_type = 1;
            iVar.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
            iVar.field_isThumb = true;
            iVar.field_tpdataurl = aar.fgv;
            iVar.field_tpauthkey = aar.fgA;
            iVar.field_tpaeskey = aar.fgB;
            boolean b = ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(iVar);
            ab.d("MicroMsg.RecordMsgLogic", "insert localId[%d] result[%B]", Integer.valueOf(iVar.field_localId), Boolean.valueOf(b));
        } else {
            iVar = VH;
        }
        ab.v("MicroMsg.RecordMsgLogic", "try download thumb, dump record cdninfo: %s", iVar);
        if (4 == iVar.field_status) {
            ab.w("MicroMsg.RecordMsgLogic", "try download thumb, but cdn info out of date, code[%d]", Integer.valueOf(iVar.field_errCode));
            AppMethodBeat.o(135717);
            return false;
        }
        if (3 == iVar.field_status) {
            ab.i("MicroMsg.RecordMsgLogic", "try download thumb, but cdn info error, code[%d], can retry[%B]", Integer.valueOf(iVar.field_errCode), Boolean.valueOf(z));
            if (z) {
                iVar.field_status = 1;
                ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(iVar, "localId");
            } else {
                AppMethodBeat.o(135717);
                return false;
            }
        }
        ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
        AppMethodBeat.o(135717);
        return true;
    }

    public static String mK(String str) {
        AppMethodBeat.i(135718);
        ad aoO = ((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(str);
        String str2;
        if (aoO == null) {
            ab.w("MicroMsg.RecordMsgLogic", "wtf get contact null, username %s", str);
            str2 = "";
            AppMethodBeat.o(135718);
            return str2;
        }
        str2 = aoO.Oj();
        if (t.kH(str2)) {
            List my = com.tencent.mm.model.n.my(str);
            String Yz = r.Yz();
            if (my == null || my.isEmpty()) {
                ab.w("MicroMsg.RecordMsgLogic", "get members from username error, content empty");
            } else {
                my.remove(Yz);
                my.add(0, Yz);
                str2 = com.tencent.mm.model.n.f(my, 3);
            }
        }
        AppMethodBeat.o(135718);
        return str2;
    }

    public static boolean h(aar aar, long j) {
        AppMethodBeat.i(135719);
        boolean amo = com.tencent.mm.sdk.platformtools.r.amo(c(aar, j));
        AppMethodBeat.o(135719);
        return amo;
    }

    public static b a(String str, String str2, abf abf) {
        AppMethodBeat.i(135698);
        LinkedList linkedList = abf.wiv;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<recordinfo>");
        stringBuilder.append("<title>").append(bo.ani(str)).append("</title>");
        stringBuilder.append("<desc>").append(bo.ani(str2)).append("</desc>");
        a(stringBuilder, abf);
        stringBuilder.append(o.bK(linkedList));
        stringBuilder.append("<favusername>").append(bo.ani(r.Yz())).append("</favusername>");
        stringBuilder.append("</recordinfo>");
        b bVar = new b();
        bVar.title = str;
        if (str2 != null && str2.length() > 200) {
            str2 = str2.substring(0, 200);
        }
        bVar.description = str2;
        if (bo.ek(linkedList) || bo.isNullOrNil(((aar) linkedList.get(0)).wgo) || !((aar) linkedList.get(0)).wgo.equals(".htm")) {
            bVar.type = 19;
            bVar.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/favorite_record__w_unsupport&from=singlemessage&isappinstalled=0";
        } else {
            bVar.type = 24;
            bVar.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008";
        }
        bVar.action = "view";
        bVar.fgU = stringBuilder.toString();
        AppMethodBeat.o(135698);
        return bVar;
    }

    private static void a(StringBuilder stringBuilder, abf abf) {
        AppMethodBeat.i(135699);
        if (abf.vzK != null) {
            stringBuilder.append("<noteinfo>");
            stringBuilder.append("<noteauthor>").append(bo.ani(abf.vzK.wim)).append("</noteauthor>");
            stringBuilder.append("<noteeditor>").append(bo.ani(abf.vzK.win)).append("</noteeditor>");
            stringBuilder.append("</noteinfo>");
            stringBuilder.append("<edittime>").append(abf.lgR).append("</edittime>");
        }
        AppMethodBeat.o(135699);
    }

    private static void a(d dVar, aar aar, int i) {
        AppMethodBeat.i(135702);
        String str = aar.wgz;
        if (com.tencent.mm.a.e.ct(str)) {
            dVar.thumbPath = str;
            AppMethodBeat.o(135702);
            return;
        }
        dVar.cKc = i;
        AppMethodBeat.o(135702);
    }
}
