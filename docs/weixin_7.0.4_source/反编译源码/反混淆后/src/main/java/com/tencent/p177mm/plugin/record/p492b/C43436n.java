package com.tencent.p177mm.plugin.record.p492b;

import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.memory.p259a.C7598c;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p181af.C8909j;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.p185a.C25754e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p230g.p231a.C45373tq;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.p993a.C12519g;
import com.tencent.p177mm.plugin.messenger.p993a.C34530b;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.plugin.record.p1016a.C16844j;
import com.tencent.p177mm.plugin.record.p1016a.C21592a;
import com.tencent.p177mm.plugin.record.p1016a.C34792i;
import com.tencent.p177mm.plugin.record.p1016a.C43429f;
import com.tencent.p177mm.protocal.p1338b.p1339a.C44099c;
import com.tencent.p177mm.protocal.p1338b.p1339a.C44100d;
import com.tencent.p177mm.protocal.protobuf.aap;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.aas;
import com.tencent.p177mm.protocal.protobuf.aat;
import com.tencent.p177mm.protocal.protobuf.aay;
import com.tencent.p177mm.protocal.protobuf.aaz;
import com.tencent.p177mm.protocal.protobuf.abe;
import com.tencent.p177mm.protocal.protobuf.abf;
import com.tencent.p177mm.protocal.protobuf.abo;
import com.tencent.p177mm.protocal.protobuf.abu;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
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

/* renamed from: com.tencent.mm.plugin.record.b.n */
public final class C43436n {
    private static final C1177f<Integer, C44099c> emX = new C7598c(32);

    /* renamed from: a */
    public static String m77553a(String str, String str2, abf abf, String str3) {
        AppMethodBeat.m2504i(135697);
        String str4;
        if (abf == null || abf.wiv == null) {
            C4990ab.m7412e("MicroMsg.RecordMsgLogic", "buildRecordAppMsgXML error: protoItem or datalist is null");
            str4 = "";
            AppMethodBeat.m2505o(135697);
            return str4;
        }
        LinkedList linkedList = abf.wiv;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<recordinfo>");
        stringBuilder.append("<title>").append(C5046bo.ani(str)).append("</title>");
        stringBuilder.append("<desc>").append(C5046bo.ani(str2)).append("</desc>");
        C43436n.m77556a(stringBuilder, abf);
        stringBuilder.append(C12985o.m20957bK(linkedList));
        stringBuilder.append("<favusername>").append(C5046bo.ani(str3)).append("</favusername>");
        stringBuilder.append("</recordinfo>");
        C8910b c8910b = new C8910b();
        c8910b.title = str;
        c8910b.description = str2;
        if (linkedList.size() <= 0 || C5046bo.isNullOrNil(((aar) linkedList.get(0)).wgo) || !((aar) linkedList.get(0)).wgo.equals(".htm")) {
            c8910b.type = 19;
            c8910b.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/favorite_record__w_unsupport&from=singlemessage&isappinstalled=0";
        } else {
            c8910b.type = 24;
            c8910b.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008";
        }
        c8910b.action = "view";
        c8910b.fgU = stringBuilder.toString();
        str4 = C8910b.m16061a(c8910b, null, null);
        AppMethodBeat.m2505o(135697);
        return str4;
    }

    /* renamed from: a */
    public static int m77548a(Context context, String str, String str2, List<C7620bi> list, C45316cl c45316cl, C44100d c44100d) {
        AppMethodBeat.m2504i(135700);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
            AppMethodBeat.m2505o(135700);
            return -1;
        } else if (list == null || list.isEmpty()) {
            C4990ab.m7420w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo error");
            AppMethodBeat.m2505o(135700);
            return -1;
        } else {
            if (c45316cl == null || c44100d == null) {
                c45316cl = new C45316cl();
                if (C46164b.m86180a(context, c45316cl, str2, (List) list)) {
                    c44100d = C43436n.m77552a(context, c45316cl, str2);
                } else {
                    AppMethodBeat.m2505o(135700);
                    return -1;
                }
            }
            C8910b a = C43436n.m77551a(c44100d.title, c44100d.desc, c45316cl.cvA.cvC);
            C7620bi c7620bi = new C7620bi();
            byte[] bArr = null;
            if (!C5046bo.isNullOrNil(c44100d.thumbPath)) {
                bArr = C5046bo.readFromFile(c44100d.thumbPath);
            } else if (c44100d.cKc == 0 && !C5046bo.isNullOrNil(c44100d.mjO)) {
                bArr = C5056d.m7636ai(C41730b.m73490a(c44100d.mjO, false, -1));
            }
            if (bArr != null) {
                String a2;
                if (bArr.length > 65536) {
                    a2 = C32291o.ahl().mo73094a(bArr, false, CompressFormat.JPEG);
                } else {
                    a2 = C32291o.ahl().mo73075W(bArr);
                }
                C4990ab.m7410d("MicroMsg.RecordMsgLogic", C1447g.m3075Mq() + " thumbData MsgInfo path:" + a2);
                if (!C5046bo.isNullOrNil(a2)) {
                    c7620bi.mo14795jv(a2);
                }
            }
            c7620bi.setContent(C8910b.m16061a(a, null, null));
            c7620bi.setStatus(1);
            c7620bi.mo14794ju(str);
            c7620bi.mo14775eJ(C1829bf.m3756oC(str));
            c7620bi.mo14781hO(1);
            c7620bi.setType(49);
            if (C17903f.m28103kq(str)) {
                c7620bi.mo14791ix(C25754e.aae());
            }
            long Z = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15281Z(c7620bi);
            C4990ab.m7410d("MicroMsg.RecordMsgLogic", C1447g.m3075Mq() + " msginfo insert id: " + Z);
            if (Z < 0) {
                C4990ab.m7412e("MicroMsg.RecordMsgLogic", C1447g.m3075Mq() + "insert msg failed :" + Z);
                int line = 0 - C1447g.getLine();
                AppMethodBeat.m2505o(135700);
                return line;
            }
            C4990ab.m7416i("MicroMsg.RecordMsgLogic", C1447g.getLine() + " new msg inserted to db , local id = " + Z);
            c7620bi.setMsgId(Z);
            C8909j c8909j = new C8909j();
            c8909j.field_xml = c7620bi.field_content;
            c8909j.field_title = a.title;
            c8909j.field_type = a.type;
            c8909j.field_description = a.description;
            c8909j.field_msgId = Z;
            C34832a.bYK().mo10101b((C4925c) c8909j);
            Iterator it = c45316cl.cvA.cvC.wiv.iterator();
            boolean z = false;
            while (it.hasNext()) {
                aar aar = (aar) it.next();
                if (C5046bo.isNullOrNil(aar.mnd)) {
                    String obj = aar.toString();
                    aar.akU(C1178g.m2591x((obj + aar.dataType + System.currentTimeMillis()).getBytes()));
                }
                if (z || C1173e.m2561ct(aar.wgx) || C1173e.m2561ct(aar.wgz) || !C5046bo.isNullOrNil(aar.wfZ) || !C5046bo.isNullOrNil(aar.fgE) || !C5046bo.isNullOrNil(aar.whr) || !C5046bo.isNullOrNil(aar.fgv)) {
                    z = true;
                }
            }
            C4990ab.m7411d("MicroMsg.RecordMsgLogic", "summerrecord needNetScene:%b", Boolean.valueOf(z));
            if (z) {
                C16844j c16844j = new C16844j();
                c16844j.field_msgId = Z;
                c16844j.field_title = a.title;
                c16844j.field_desc = a.description;
                c16844j.field_toUser = str;
                c16844j.field_dataProto = c45316cl.cvA.cvC;
                c16844j.field_type = 3;
                c16844j.field_localId = new Random().nextInt(2147483645) + 1;
                C4990ab.m7417i("MicroMsg.RecordMsgLogic", "summerrecord needNetScene insert ret:%b, id:%d, localid:%d", Boolean.valueOf(((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgStorage().mo10101b(c16844j)), Long.valueOf(Z), Integer.valueOf(c16844j.field_localId));
                ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgService().mo25040a(c16844j);
            } else {
                C4990ab.m7411d("MicroMsg.RecordMsgLogic", "summerrecord do not trans cdn, directly send msg id:%d", Long.valueOf(Z));
                ((C43429f) C1720g.m3528K(C43429f.class)).mo68985jB(Z);
            }
            AppMethodBeat.m2505o(135700);
            return 0;
        }
    }

    /* renamed from: a */
    public static C44100d m77552a(Context context, C45316cl c45316cl, String str) {
        String str2;
        int i = 0;
        AppMethodBeat.m2504i(135701);
        C44100d c44100d = new C44100d();
        SparseIntArray sparseIntArray = new SparseIntArray();
        if (C17903f.m28103kq(str)) {
            c44100d.title = c45316cl.cvA.cvC.title;
        } else if (C1855t.m3896kH(str)) {
            c44100d.title = context.getString(C25738R.string.dja);
        } else {
            if (C1853r.m3820YB().equals(((C34530b) C1720g.m3528K(C34530b.class)).mo55065mI(str))) {
                c44100d.title = context.getString(C25738R.string.bqj, new Object[]{C1853r.m3820YB()});
            } else {
                c44100d.title = context.getString(C25738R.string.bqi, new Object[]{C1853r.m3820YB(), ((C34530b) C1720g.m3528K(C34530b.class)).mo55065mI(str)});
            }
        }
        C4990ab.m7411d("MicroMsg.RecordMsgLogic", "msgInfo title %s", c44100d.title);
        LinkedList linkedList = new LinkedList();
        List list;
        if (c45316cl.cvA.cvC != null) {
            list = c45316cl.cvA.cvC.wiv;
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
                        linkedList.add(aar.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(C25738R.string.f9199sn) + IOUtils.LINE_SEPARATOR_UNIX);
                    }
                    if (i != 0) {
                        break;
                    }
                    C43436n.m77554a(c44100d, aar, (int) C25738R.drawable.avp);
                    i = 1;
                    break;
                case 3:
                    if (linkedList.size() >= 5) {
                        break;
                    }
                    linkedList.add(aar.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(C25738R.string.f9256ug) + IOUtils.LINE_SEPARATOR_UNIX);
                    break;
                case 4:
                    if (linkedList.size() < 5) {
                        linkedList.add(aar.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(C25738R.string.f9253ud) + IOUtils.LINE_SEPARATOR_UNIX);
                    }
                    if (i != 0) {
                        break;
                    }
                    C43436n.m77554a(c44100d, aar, (int) C1318a.app_attach_file_icon_video);
                    i = 1;
                    break;
                case 5:
                    if (linkedList.size() < 5) {
                        linkedList.add(aar.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(C25738R.string.f9248u9) + aar.title + IOUtils.LINE_SEPARATOR_UNIX);
                    }
                    if (i != 0) {
                        break;
                    }
                    C43436n.m77554a(c44100d, aar, (int) C1318a.app_attach_file_icon_webpage);
                    i = 1;
                    break;
                case 6:
                    if (linkedList.size() < 5) {
                        aay aay = aar.wgT.why;
                        StringBuilder append = new StringBuilder().append(aar.wgV).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(context.getString(C25738R.string.f9162rf));
                        if (C5046bo.isNullOrNil(aay.cIK) || aay.cIK.equals(context.getString(C25738R.string.f9162rf))) {
                            str2 = aay.label;
                        } else {
                            str2 = aay.cIK;
                        }
                        linkedList.add(append.append(str2).append(IOUtils.LINE_SEPARATOR_UNIX).toString());
                    }
                    if (i != 0) {
                        break;
                    }
                    c44100d.cKc = C1318a.app_attach_file_icon_location;
                    i = 1;
                    break;
                    break;
                case 7:
                    if (linkedList.size() < 5) {
                        linkedList.add(aar.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(C25738R.string.f9174rs) + aar.title + IOUtils.LINE_SEPARATOR_UNIX);
                    }
                    if (i != 0) {
                        break;
                    }
                    C43436n.m77554a(c44100d, aar, (int) C1318a.app_attach_file_icon_music);
                    i = 1;
                    break;
                case 8:
                    if (linkedList.size() < 5) {
                        linkedList.add(aar.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(C25738R.string.f9140qr) + aar.title + IOUtils.LINE_SEPARATOR_UNIX);
                    }
                    if (i != 0) {
                        break;
                    }
                    C43436n.m77554a(c44100d, aar, (int) C1318a.app_attach_file_icon_unknow);
                    i = 1;
                    break;
                case 10:
                case 11:
                    if (linkedList.size() < 5) {
                        linkedList.add(aar.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(C25738R.string.f9201ss) + aar.wgT.whC.title + IOUtils.LINE_SEPARATOR_UNIX);
                    }
                    if (i != 0) {
                        break;
                    }
                    C43436n.m77554a(c44100d, aar, (int) C1318a.app_attach_file_icon_unknow);
                    i = 1;
                    break;
                case 14:
                    if (linkedList.size() < 5) {
                        linkedList.add(aar.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(C25738R.string.f8820fy) + IOUtils.LINE_SEPARATOR_UNIX);
                    }
                    if (i != 0) {
                        break;
                    }
                    C43436n.m77554a(c44100d, aar, (int) C1318a.app_attach_file_icon_unknow);
                    i = 1;
                    break;
                case 15:
                    if (linkedList.size() < 5) {
                        linkedList.add(aar.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(C25738R.string.f9253ud) + IOUtils.LINE_SEPARATOR_UNIX);
                    }
                    if (i != 0) {
                        break;
                    }
                    C43436n.m77554a(c44100d, aar, (int) C1318a.app_attach_file_icon_video);
                    i = 1;
                    break;
                case 16:
                    if (linkedList.size() < 5) {
                        linkedList.add(aar.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(C25738R.string.f9145qw) + IOUtils.LINE_SEPARATOR_UNIX);
                    }
                    if (i != 0) {
                        break;
                    }
                    c44100d.mjO = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15260Rn(aar.desc).svN;
                    i = 1;
                    break;
                case 17:
                    if (linkedList.size() >= 5) {
                        break;
                    }
                    linkedList.add(aar.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(C25738R.string.f9212t5) + IOUtils.LINE_SEPARATOR_UNIX);
                    break;
                case 19:
                    if (linkedList.size() >= 5) {
                        break;
                    }
                    linkedList.add(aar.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + context.getString(C25738R.string.f8821fz) + aar.title + IOUtils.LINE_SEPARATOR_UNIX);
                    break;
                default:
                    break;
            }
        }
        str2 = "";
        c44100d.desc = "";
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
                c44100d.desc = str2;
                AppMethodBeat.m2505o(135701);
                return c44100d;
            }
        }
    }

    /* renamed from: a */
    public static int m77550a(String str, String str2, C7620bi c7620bi) {
        AppMethodBeat.m2504i(135703);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
            AppMethodBeat.m2505o(135703);
            return -1;
        } else if (c7620bi == null || C5046bo.isNullOrNil(c7620bi.field_content)) {
            C4990ab.m7420w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo error");
            AppMethodBeat.m2505o(135703);
            return -1;
        } else if (1 == c7620bi.field_status) {
            C4990ab.m7420w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo is sending");
            AppMethodBeat.m2505o(135703);
            return -1;
        } else {
            for (String str3 : C5046bo.m7508P(str.split(","))) {
                C4990ab.m7417i("MicroMsg.RecordMsgLogic", "send recordMsg, toUser[%s] msgId[%d], msgType[%d]", str3, Long.valueOf(c7620bi.field_msgId), Integer.valueOf(c7620bi.field_status));
                String oz = C1829bf.m3763oz(c7620bi.field_content);
                C8910b me = C8910b.m16064me(oz);
                if (me == null) {
                    C4990ab.m7420w("MicroMsg.RecordMsgLogic", "send record msg error, parse appmsg error");
                    AppMethodBeat.m2505o(135703);
                    return -1;
                }
                C44099c VI = C43436n.m77547VI(me.fgU);
                if (VI == null) {
                    C4990ab.m7420w("MicroMsg.RecordMsgLogic", "send record msg error, parse record data error");
                    AppMethodBeat.m2505o(135703);
                    return -1;
                }
                C7620bi c7620bi2 = new C7620bi();
                if (!C5046bo.isNullOrNil(c7620bi.field_imgPath)) {
                    String W = C32291o.ahl().mo73075W(C5046bo.readFromFile(C32291o.ahl().mo73074I(c7620bi.field_imgPath, true)));
                    C4990ab.m7410d("MicroMsg.RecordMsgLogic", C1447g.m3075Mq() + " thumbData from msg MsgInfo path:" + W);
                    if (!C5046bo.isNullOrNil(W)) {
                        c7620bi2.mo14795jv(W);
                    }
                }
                c7620bi2.setContent(oz);
                c7620bi2.setStatus(1);
                c7620bi2.mo14794ju(str3);
                c7620bi2.mo14775eJ(C1829bf.m3756oC(str3));
                c7620bi2.mo14781hO(1);
                c7620bi2.setType(49);
                long Z = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15281Z(c7620bi2);
                C4990ab.m7410d("MicroMsg.RecordMsgLogic", C1447g.m3075Mq() + " msginfo insert id: " + Z);
                if (Z < 0) {
                    C4990ab.m7412e("MicroMsg.RecordMsgLogic", C1447g.m3075Mq() + "insert msg failed :" + Z);
                    int line = 0 - C1447g.getLine();
                    AppMethodBeat.m2505o(135703);
                    return line;
                }
                Object obj;
                C4990ab.m7416i("MicroMsg.RecordMsgLogic", C1447g.getLine() + " new msg inserted to db , local id = " + Z);
                c7620bi2.setMsgId(Z);
                C45373tq c45373tq = new C45373tq();
                c45373tq.cPN.cPO = c7620bi.field_msgId;
                c45373tq.cPN.cPP = Z;
                C4879a.xxA.mo10055m(c45373tq);
                C8909j c8909j = new C8909j();
                c8909j.field_xml = c7620bi2.field_content;
                c8909j.field_title = me.title;
                c8909j.field_type = me.type;
                c8909j.field_description = me.description;
                c8909j.field_msgId = Z;
                C34832a.bYK().mo10101b((C4925c) c8909j);
                Iterator it = VI.fjr.iterator();
                while (it.hasNext()) {
                    aar aar = (aar) it.next();
                    if (C5046bo.isNullOrNil(aar.wfZ) && C5046bo.isNullOrNil(aar.fgE) && C5046bo.isNullOrNil(aar.whr)) {
                        if (!C5046bo.isNullOrNil(aar.fgv)) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = 1;
                    break;
                }
                obj = null;
                if (obj != null) {
                    C16844j c16844j = new C16844j();
                    abf abf = new abf();
                    abf.wiv.addAll(VI.fjr);
                    c16844j.field_msgId = Z;
                    c16844j.field_oriMsgId = c7620bi.field_msgId;
                    c16844j.field_toUser = str3;
                    c16844j.field_title = me.title;
                    c16844j.field_desc = C5046bo.m7532bc(VI.desc, me.description);
                    c16844j.field_dataProto = abf;
                    c16844j.field_type = 0;
                    c16844j.field_favFrom = VI.vzJ;
                    c16844j.field_localId = new Random().nextInt(2147483645) + 1;
                    ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgStorage().mo10101b(c16844j);
                    ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgService().mo25040a(c16844j);
                } else {
                    C4990ab.m7410d("MicroMsg.RecordMsgLogic", "do not check upload, directly send msg");
                    ((C43429f) C1720g.m3528K(C43429f.class)).mo68985jB(Z);
                }
                if (!C5046bo.isNullOrNil(str2)) {
                    C12519g.bOk().mo46456F(str3, str2, C1855t.m3925nK(str3));
                }
            }
            AppMethodBeat.m2505o(135703);
            return 0;
        }
    }

    /* renamed from: a */
    public static int m77549a(String str, abf abf, String str2, String str3, String str4, int i, String str5) {
        AppMethodBeat.m2504i(135704);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
            AppMethodBeat.m2505o(135704);
            return -1;
        } else if (abf == null || abf.wiv.isEmpty()) {
            C4990ab.m7420w("MicroMsg.RecordMsgLogic", "send record msg error, favprotoitem error");
            AppMethodBeat.m2505o(135704);
            return -1;
        } else {
            C8910b a = C43436n.m77551a(str2, str3, abf);
            C7620bi c7620bi = new C7620bi();
            byte[] bArr = null;
            if (!C5046bo.isNullOrNil(str4)) {
                bArr = C5046bo.readFromFile(str4);
            } else if (i != 0) {
                bArr = C5056d.m7636ai(C5056d.m7610LV(i));
            } else if (!C5046bo.isNullOrNil(str5)) {
                bArr = C5056d.m7636ai(C41730b.m73490a(str5, false, -1));
            }
            if (bArr != null) {
                String a2;
                if (bArr.length > 65536) {
                    a2 = C32291o.ahl().mo73094a(bArr, false, CompressFormat.JPEG);
                } else {
                    a2 = C32291o.ahl().mo73075W(bArr);
                }
                C4990ab.m7410d("MicroMsg.RecordMsgLogic", C1447g.m3075Mq() + " thumbData MsgInfo path:" + a2);
                if (!C5046bo.isNullOrNil(a2)) {
                    c7620bi.mo14795jv(a2);
                }
            }
            c7620bi.setContent(C8910b.m16061a(a, null, null));
            c7620bi.setStatus(1);
            c7620bi.mo14794ju(str);
            c7620bi.mo14775eJ(C1829bf.m3756oC(str));
            c7620bi.mo14781hO(1);
            c7620bi.setType(49);
            if (C17903f.m28103kq(str)) {
                c7620bi.mo14791ix(C25754e.aae());
            }
            long Z = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15281Z(c7620bi);
            C4990ab.m7410d("MicroMsg.RecordMsgLogic", C1447g.m3075Mq() + " msginfo insert id: " + Z);
            if (Z < 0) {
                C4990ab.m7412e("MicroMsg.RecordMsgLogic", C1447g.m3075Mq() + "insert msg failed :" + Z);
                int line = 0 - C1447g.getLine();
                AppMethodBeat.m2505o(135704);
                return line;
            }
            C4990ab.m7416i("MicroMsg.RecordMsgLogic", C1447g.getLine() + " new msg inserted to db , local id = " + Z);
            c7620bi.setMsgId(Z);
            C8909j c8909j = new C8909j();
            c8909j.field_xml = c7620bi.field_content;
            c8909j.field_title = a.title;
            c8909j.field_type = a.type;
            c8909j.field_description = a.description;
            c8909j.field_msgId = Z;
            C34832a.bYK().mo10101b((C4925c) c8909j);
            Iterator it = abf.wiv.iterator();
            while (it.hasNext()) {
                aar aar = (aar) it.next();
                if (C5046bo.isNullOrNil(aar.wfZ)) {
                    if (!C5046bo.isNullOrNil(aar.fgE)) {
                        break;
                    }
                }
                break;
            }
            C16844j c16844j = new C16844j();
            c16844j.field_msgId = Z;
            c16844j.field_title = a.title;
            c16844j.field_desc = a.description;
            c16844j.field_toUser = str;
            c16844j.field_dataProto = abf;
            c16844j.field_type = 1;
            c16844j.field_localId = new Random().nextInt(2147483645) + 1;
            ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgStorage().mo10101b(c16844j);
            ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgService().mo25040a(c16844j);
            AppMethodBeat.m2505o(135704);
            return 0;
        }
    }

    /* renamed from: jE */
    private static File m77566jE(long j) {
        AppMethodBeat.m2504i(135705);
        Object[] objArr = new Object[2];
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3537RQ();
        objArr[0] = stringBuilder.append(C1720g.m3536RP().eJM).append("record/").toString();
        objArr[1] = Long.valueOf(j);
        File file = new File(String.format("%s/%d/", objArr));
        if (!(file.exists() && file.isDirectory())) {
            file.mkdirs();
        }
        AppMethodBeat.m2505o(135705);
        return file;
    }

    /* renamed from: jF */
    public static void m77567jF(long j) {
        AppMethodBeat.m2504i(135706);
        boolean t = C1173e.m2575t(C43436n.m77566jE(j));
        C4990ab.m7417i("MicroMsg.RecordMsgLogic", "do clear resource, path %s, result %B", r0.getAbsolutePath(), Boolean.valueOf(t));
        AppMethodBeat.m2505o(135706);
    }

    /* renamed from: c */
    public static String m77558c(aar aar, long j) {
        int i = 1;
        AppMethodBeat.m2504i(135707);
        String str;
        if (aar == null) {
            str = "";
            AppMethodBeat.m2505o(135707);
            return str;
        }
        String str2 = aar.mnd;
        if (!C5046bo.isNullOrNil(str2) && C4996ah.bqo() && C1720g.m3531RK()) {
            File jE = C43436n.m77566jE(j);
            if (aar.dataType != 8 || C5046bo.isNullOrNil(aar.title)) {
                i = 0;
            } else {
                str2 = aar.title;
                int hashCode = aar.mnd.hashCode() & 255;
                r6 = new Object[3];
                StringBuilder stringBuilder = new StringBuilder();
                C1720g.m3537RQ();
                r6[0] = stringBuilder.append(C1720g.m3536RP().eJM).append("record/").toString();
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
            AppMethodBeat.m2505o(135707);
            return str;
        }
        str = "";
        AppMethodBeat.m2505o(135707);
        return str;
    }

    /* renamed from: d */
    public static boolean m77560d(aar aar, long j) {
        AppMethodBeat.m2504i(135708);
        boolean exists = new File(C43436n.m77558c(aar, j)).exists();
        AppMethodBeat.m2505o(135708);
        return exists;
    }

    /* renamed from: e */
    public static boolean m77561e(aar aar, long j) {
        AppMethodBeat.m2504i(135709);
        boolean exists = new File(C43436n.m77562f(aar, j)).exists();
        AppMethodBeat.m2505o(135709);
        return exists;
    }

    /* renamed from: f */
    public static String m77562f(aar aar, long j) {
        AppMethodBeat.m2504i(135710);
        String str;
        if (aar == null || C5046bo.isNullOrNil(aar.mnd)) {
            str = "";
            AppMethodBeat.m2505o(135710);
            return str;
        }
        str = new File(C43436n.m77566jE(j), C43436n.m77546LA(aar.mnd)).getAbsolutePath();
        AppMethodBeat.m2505o(135710);
        return str;
    }

    /* renamed from: LA */
    public static String m77546LA(String str) {
        AppMethodBeat.m2504i(135711);
        String str2 = str + "_t";
        AppMethodBeat.m2505o(135711);
        return str2;
    }

    /* renamed from: h */
    public static String m77564h(String str, long j, boolean z) {
        AppMethodBeat.m2504i(135712);
        String str2;
        if (z) {
            str2 = str + "@record_download@" + j;
            AppMethodBeat.m2505o(135712);
            return str2;
        }
        str2 = str + "@record_upload@" + j;
        AppMethodBeat.m2505o(135712);
        return str2;
    }

    static {
        AppMethodBeat.m2504i(135720);
        AppMethodBeat.m2505o(135720);
    }

    /* renamed from: VI */
    public static C44099c m77547VI(String str) {
        AppMethodBeat.m2504i(135713);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.RecordMsgLogic", "xml is null");
            AppMethodBeat.m2505o(135713);
            return null;
        }
        int hashCode = str.hashCode();
        C44099c c44099c = (C44099c) emX.get(Integer.valueOf(hashCode));
        if (c44099c != null) {
            C4990ab.m7410d("MicroMsg.RecordMsgLogic", "get record msg data from cache");
            AppMethodBeat.m2505o(135713);
            return c44099c;
        }
        Map z;
        if (str.trim().contains("<recordinfo>")) {
            z = C5049br.m7595z(str, "recordinfo");
        } else {
            z = C5049br.m7595z("<recordinfo>" + str + "</recordinfo>", "recordinfo");
        }
        if (z == null) {
            C4990ab.m7413e("MicroMsg.RecordMsgLogic", "values is null: %s", str);
            AppMethodBeat.m2505o(135713);
            return null;
        }
        C44099c c44099c2 = new C44099c();
        c44099c2.title = (String) z.get(".recordinfo.title");
        c44099c2.desc = (String) z.get(".recordinfo.desc");
        c44099c2.vzJ = (String) z.get(".recordinfo.favusername");
        if (z.get(".recordinfo.noteinfo") != null) {
            aaz aaz = new aaz();
            aaz.win = (String) z.get(".recordinfo.noteinfo.noteeditor");
            aaz.wim = (String) z.get(".recordinfo.noteinfo.noteauthor");
            c44099c2.vzK = aaz;
            c44099c2.lgR = C5046bo.getLong((String) z.get(".recordinfo.edittime"), 0);
        }
        C43436n.m77555a(str, c44099c2);
        emX.put(Integer.valueOf(hashCode), c44099c2);
        AppMethodBeat.m2505o(135713);
        return c44099c2;
    }

    /* renamed from: a */
    private static void m77555a(String str, C44099c c44099c) {
        AppMethodBeat.m2504i(135714);
        c44099c.fjr.clear();
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
                        String b = C5049br.m7594b(item);
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
                                            C4990ab.m7411d("MicroMsg.RecordMsgLogic", "recordXml: %s", C5049br.m7594b(item2));
                                            str2 = str3;
                                            break;
                                        }
                                    }
                                }
                            }
                            str2 = null;
                            if (b.trim().startsWith("<dataitem")) {
                                z = C5049br.m7595z(b, "dataitem");
                            } else {
                                z = null;
                            }
                            if (z == null) {
                                obj = null;
                            } else {
                                aar aar = new aar();
                                String str4 = ".dataitem";
                                aar.mo27394LE(C5046bo.getInt((String) z.get(str4 + ".$datatype"), 0));
                                aar.akZ((String) z.get(str4 + ".$datasourceid"));
                                aar.mo27395LF(C5046bo.getInt((String) z.get(str4 + ".$datastatus"), 0));
                                aar.akR((String) z.get(str4 + ".datafmt"));
                                aar.akH((String) z.get(str4 + ".datatitle"));
                                aar.akI((String) z.get(str4 + ".datadesc"));
                                aar.akJ((String) z.get(str4 + ".cdnthumburl"));
                                aar.akK((String) z.get(str4 + ".cdnthumbkey"));
                                aar.mo27391LB(C5046bo.getInt((String) z.get(str4 + ".thumbwidth"), 0));
                                aar.mo27392LC(C5046bo.getInt((String) z.get(str4 + ".thumbheight"), 0));
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
                                    aar.mo27393LD(C5046bo.getInt(str3, 0));
                                }
                                aar.akO((String) z.get(str4 + ".streamdataurl"));
                                aar.akP((String) z.get(str4 + ".streamlowbandurl"));
                                aar.akN((String) z.get(str4 + ".streamweburl"));
                                aar.akS((String) z.get(str4 + ".fullmd5"));
                                aar.akT((String) z.get(str4 + ".head256md5"));
                                str3 = (String) z.get(str4 + ".datasize");
                                if (!C5046bo.isNullOrNil(str3)) {
                                    aar.mo27431mf((long) C5046bo.getInt(str3, 0));
                                }
                                aar.akQ((String) z.get(str4 + ".dataext"));
                                aar.akX((String) z.get(str4 + ".thumbfullmd5"));
                                aar.akY((String) z.get(str4 + ".thumbhead256md5"));
                                str3 = (String) z.get(str4 + ".thumbsize");
                                if (!C5046bo.isNullOrNil(str3)) {
                                    aar.mo27432mg((long) C5046bo.getInt(str3, 0));
                                }
                                aar.ala((String) z.get(str4 + ".streamvideoid"));
                                str3 = (String) z.get(str4 + ".$dataid");
                                if (C5046bo.isNullOrNil(str3)) {
                                    str3 = String.valueOf(i);
                                }
                                aar.akU(str3);
                                str3 = (String) z.get(str4 + ".$htmlid");
                                if (!C5046bo.isNullOrNil(str3)) {
                                    aar.ale(str3);
                                }
                                aar.mo27396LG(C5046bo.getInt((String) z.get(str4 + ".$dataillegaltype"), 0));
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
                                aat.mo64043LI(C5046bo.getInt((String) z.get(str4 + ".$sourcetype"), 0));
                                str3 = (String) z.get(str4 + ".dataitemsource.fromusr");
                                if (!C5046bo.isNullOrNil(str3)) {
                                    aat.alm(str3);
                                    C4990ab.m7411d("MicroMsg.RecordMsgParser", "fromusr %s", aat.cEV);
                                }
                                str3 = (String) z.get(str4 + ".dataitemsource.realchatname");
                                if (!C5046bo.isNullOrNil(str3)) {
                                    aat.alp(str3);
                                    C4990ab.m7411d("MicroMsg.RecordMsgParser", "realChatname %s", aat.whU);
                                }
                                aat.alr((String) z.get(str4 + ".appid"));
                                aat.als((String) z.get(str4 + ".link"));
                                aat.alt((String) z.get(str4 + ".brandid"));
                                aas.mo48444c(aat);
                                String str5 = str4 + ".locitem";
                                if (z.containsKey(str5)) {
                                    aay aay = new aay();
                                    if (!C5046bo.isNullOrNil((String) z.get(str5 + ".label"))) {
                                        aay.alu((String) z.get(str5 + ".label"));
                                    }
                                    if (!C5046bo.isNullOrNil((String) z.get(str5 + ".poiname"))) {
                                        aay.alv((String) z.get(str5 + ".poiname"));
                                    }
                                    str3 = (String) z.get(str5 + ".lng");
                                    if (!C5046bo.isNullOrNil(str3)) {
                                        aay.mo15620D(C5046bo.getDouble(str3, 0.0d));
                                    }
                                    str3 = (String) z.get(str5 + ".lat");
                                    if (!C5046bo.isNullOrNil(str3)) {
                                        aay.mo15621E(C5046bo.getDouble(str3, 0.0d));
                                    }
                                    str3 = (String) z.get(str5 + ".scale");
                                    if (!C5046bo.isNullOrNil(str3)) {
                                        if (str3.indexOf(46) != -1) {
                                            aay.mo15622LJ(C5046bo.getInt(str3.substring(0, str3.indexOf(46)), -1));
                                        } else {
                                            aay.mo15622LJ(C5046bo.getInt(str3, -1));
                                        }
                                    }
                                    aas.mo48440a(aay);
                                } else {
                                    C4990ab.m7421w("MicroMsg.RecordMsgParser", "cur fav not contains %s", str5);
                                }
                                str5 = str4 + ".weburlitem";
                                if (z.containsKey(str5)) {
                                    abu abu = new abu();
                                    abu.alQ((String) z.get(str5 + ".title"));
                                    abu.alR((String) z.get(str5 + ".desc"));
                                    abu.alT((String) z.get(str5 + ".thumburl"));
                                    abu.alS((String) z.get(str5 + ".link"));
                                    abu.mo27441LO(C5046bo.getInt((String) z.get(str5 + ".opencache"), 0));
                                    aas.mo48443a(abu);
                                } else {
                                    C4990ab.m7421w("MicroMsg.RecordMsgParser", "cur fav not contains %s", str5);
                                }
                                str5 = str4 + ".productitem";
                                if (z.containsKey(str5)) {
                                    abe abe = new abe();
                                    abe.alw((String) z.get(str5 + ".title"));
                                    abe.alx((String) z.get(str5 + ".desc"));
                                    abe.aly((String) z.get(str5 + ".thumburl"));
                                    abe.alz((String) z.get(str5 + ".productinfo"));
                                    abe.mo27436LK(C5046bo.getInt((String) z.get(str5 + ".$type"), 0));
                                    aas.mo48441a(abe);
                                } else {
                                    C4990ab.m7421w("MicroMsg.RecordMsgParser", "cur fav not contains %s", str5);
                                }
                                str5 = str4 + ".tvitem";
                                if (z.containsKey(str5)) {
                                    abo abo = new abo();
                                    abo.alM((String) z.get(str5 + ".title"));
                                    abo.alN((String) z.get(str5 + ".desc"));
                                    abo.alO((String) z.get(str5 + ".thumburl"));
                                    abo.alP((String) z.get(str5 + ".tvinfo"));
                                    aas.mo48442a(abo);
                                } else {
                                    C4990ab.m7421w("MicroMsg.RecordMsgParser", "cur fav not contains %s", str5);
                                }
                                str4 = str4 + ".appbranditem";
                                if (z.containsKey(str4)) {
                                    aap aap = new aap();
                                    aap.username = (String) z.get(str4 + ".username");
                                    aap.appId = (String) z.get(str4 + ".appid");
                                    aap.cBc = C5046bo.getInt((String) z.get(str4 + ".pkgtype"), 0);
                                    aap.iconUrl = (String) z.get(str4 + ".iconurl");
                                    aap.type = C5046bo.getInt((String) z.get(str4 + ".type"), 0);
                                    aap.csu = (String) z.get(str4 + ".pagepath");
                                    aap.wfO = (String) z.get(str4 + ".sourcedisplayname");
                                    aas.mo48439a(aap);
                                } else {
                                    C4990ab.m7419v("MicroMsg.RecordMsgParser", "cur fav not contains %s", str4);
                                }
                                aar.mo27398a(aas);
                                aar obj2 = aar;
                            }
                            try {
                                c44099c.fjr.add(obj2);
                            } catch (Exception e) {
                                C4990ab.m7413e("MicroMsg.RecordMsgLogic", "get record msg data from xml error: %s", e.getMessage());
                                C4990ab.printErrStackTrace("MicroMsg.RecordMsgLogic", e, "", new Object[0]);
                                c44099c.fjr.clear();
                            }
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(135714);
        } catch (Exception e2) {
            C4990ab.m7413e("MicroMsg.RecordMsgLogic", "[parser] parseXML exception:%s", e2.toString());
            AppMethodBeat.m2505o(135714);
        }
    }

    /* renamed from: BH */
    public static int m77545BH(int i) {
        if (2 == i) {
            return C42129a.MediaType_FULLSIZEIMAGE;
        }
        if (4 == i) {
            return C42129a.MediaType_VIDEO;
        }
        return C42129a.MediaType_FILE;
    }

    /* renamed from: b */
    public static boolean m77557b(aar aar, long j, boolean z) {
        AppMethodBeat.m2504i(135715);
        if (aar == null) {
            C4990ab.m7420w("MicroMsg.RecordMsgLogic", "try download data fail, dataitem is null");
            AppMethodBeat.m2505o(135715);
            return false;
        }
        C34792i c34792i;
        String h = C43436n.m77564h(aar.mnd, j, true);
        C34792i VH = ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37079VH(h);
        if (VH == null) {
            c34792i = new C34792i();
            c34792i.field_cdnKey = aar.wgb;
            c34792i.field_cdnUrl = aar.wfZ;
            c34792i.field_dataId = aar.mnd;
            c34792i.field_mediaId = h;
            c34792i.field_totalLen = (int) aar.wgu;
            c34792i.field_localId = new Random().nextInt(2147483645) + 1;
            c34792i.field_path = C43436n.m77558c(aar, j);
            c34792i.field_type = 1;
            c34792i.field_fileType = C43436n.m77545BH(aar.dataType);
            c34792i.field_isThumb = false;
            c34792i.field_tpaeskey = aar.who;
            c34792i.field_tpauthkey = aar.fgA;
            c34792i.field_tpdataurl = aar.whr;
            boolean b = ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37084b(c34792i);
            C4990ab.m7411d("MicroMsg.RecordMsgLogic", "insert localId[%d] result[%B]", Integer.valueOf(c34792i.field_localId), Boolean.valueOf(b));
            if (!C5046bo.isNullOrNil(aar.whb) && aar.whb.equals("WeNoteHtmlFile")) {
                ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNService().mo37074a(c34792i);
            }
        } else {
            c34792i = VH;
        }
        C4990ab.m7411d("MicroMsg.RecordMsgLogic", "try download data, dump record cdninfo: %s", c34792i);
        if (4 == c34792i.field_status) {
            C4990ab.m7421w("MicroMsg.RecordMsgLogic", "try download, but cdn info out of date, code[%d]", Integer.valueOf(c34792i.field_errCode));
            AppMethodBeat.m2505o(135715);
            return false;
        }
        if (3 == c34792i.field_status) {
            C4990ab.m7417i("MicroMsg.RecordMsgLogic", "try download, but cdn info error, code[%d], can retry[%B]", Integer.valueOf(c34792i.field_errCode), Boolean.valueOf(z));
            if (z) {
                c34792i.field_status = 1;
                ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37085b(c34792i, "localId");
            } else {
                AppMethodBeat.m2505o(135715);
                return false;
            }
        }
        ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNService().run();
        AppMethodBeat.m2505o(135715);
        return true;
    }

    /* renamed from: g */
    public static boolean m77563g(aar aar, long j) {
        AppMethodBeat.m2504i(135716);
        if (aar == null) {
            C4990ab.m7420w("MicroMsg.RecordMsgLogic", "checkDataOutOfDate fail, dataitem is null");
            AppMethodBeat.m2505o(135716);
            return true;
        }
        C34792i VH = ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37079VH(C43436n.m77564h(aar.mnd, j, true));
        if (VH == null) {
            C4990ab.m7410d("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, not find cdn info");
            AppMethodBeat.m2505o(135716);
            return false;
        } else if (4 == VH.field_status) {
            C4990ab.m7421w("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, status err, code %d", Integer.valueOf(VH.field_errCode));
            AppMethodBeat.m2505o(135716);
            return true;
        } else {
            C4990ab.m7411d("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, find cdn info, status %d", Integer.valueOf(VH.field_status));
            AppMethodBeat.m2505o(135716);
            return false;
        }
    }

    /* renamed from: c */
    public static boolean m77559c(aar aar, long j, boolean z) {
        AppMethodBeat.m2504i(135717);
        if (aar == null) {
            C4990ab.m7420w("MicroMsg.RecordMsgLogic", "try download thumb error, dataitem is null");
            AppMethodBeat.m2505o(135717);
            return false;
        }
        C34792i c34792i;
        String LA = C43436n.m77546LA(aar.mnd);
        String h = C43436n.m77564h(LA, j, true);
        C34792i VH = ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37079VH(h);
        if (VH == null) {
            c34792i = new C34792i();
            c34792i.field_cdnKey = aar.wfV;
            c34792i.field_cdnUrl = aar.fgE;
            c34792i.field_dataId = LA;
            c34792i.field_mediaId = h;
            c34792i.field_totalLen = (int) aar.wgF;
            c34792i.field_localId = new Random().nextInt(2147483645) + 1;
            c34792i.field_path = C43436n.m77562f(aar, j);
            c34792i.field_type = 1;
            c34792i.field_fileType = C42129a.MediaType_FULLSIZEIMAGE;
            c34792i.field_isThumb = true;
            c34792i.field_tpdataurl = aar.fgv;
            c34792i.field_tpauthkey = aar.fgA;
            c34792i.field_tpaeskey = aar.fgB;
            boolean b = ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37084b(c34792i);
            C4990ab.m7411d("MicroMsg.RecordMsgLogic", "insert localId[%d] result[%B]", Integer.valueOf(c34792i.field_localId), Boolean.valueOf(b));
        } else {
            c34792i = VH;
        }
        C4990ab.m7419v("MicroMsg.RecordMsgLogic", "try download thumb, dump record cdninfo: %s", c34792i);
        if (4 == c34792i.field_status) {
            C4990ab.m7421w("MicroMsg.RecordMsgLogic", "try download thumb, but cdn info out of date, code[%d]", Integer.valueOf(c34792i.field_errCode));
            AppMethodBeat.m2505o(135717);
            return false;
        }
        if (3 == c34792i.field_status) {
            C4990ab.m7417i("MicroMsg.RecordMsgLogic", "try download thumb, but cdn info error, code[%d], can retry[%B]", Integer.valueOf(c34792i.field_errCode), Boolean.valueOf(z));
            if (z) {
                c34792i.field_status = 1;
                ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37085b(c34792i, "localId");
            } else {
                AppMethodBeat.m2505o(135717);
                return false;
            }
        }
        ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNService().run();
        AppMethodBeat.m2505o(135717);
        return true;
    }

    /* renamed from: mK */
    public static String m77568mK(String str) {
        AppMethodBeat.m2504i(135718);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
        String str2;
        if (aoO == null) {
            C4990ab.m7421w("MicroMsg.RecordMsgLogic", "wtf get contact null, username %s", str);
            str2 = "";
            AppMethodBeat.m2505o(135718);
            return str2;
        }
        str2 = aoO.mo16707Oj();
        if (C1855t.m3896kH(str2)) {
            List my = C37921n.m64074my(str);
            String Yz = C1853r.m3846Yz();
            if (my == null || my.isEmpty()) {
                C4990ab.m7420w("MicroMsg.RecordMsgLogic", "get members from username error, content empty");
            } else {
                my.remove(Yz);
                my.add(0, Yz);
                str2 = C37921n.m64058f(my, 3);
            }
        }
        AppMethodBeat.m2505o(135718);
        return str2;
    }

    /* renamed from: h */
    public static boolean m77565h(aar aar, long j) {
        AppMethodBeat.m2504i(135719);
        boolean amo = C5063r.amo(C43436n.m77558c(aar, j));
        AppMethodBeat.m2505o(135719);
        return amo;
    }

    /* renamed from: a */
    public static C8910b m77551a(String str, String str2, abf abf) {
        AppMethodBeat.m2504i(135698);
        LinkedList linkedList = abf.wiv;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<recordinfo>");
        stringBuilder.append("<title>").append(C5046bo.ani(str)).append("</title>");
        stringBuilder.append("<desc>").append(C5046bo.ani(str2)).append("</desc>");
        C43436n.m77556a(stringBuilder, abf);
        stringBuilder.append(C12985o.m20957bK(linkedList));
        stringBuilder.append("<favusername>").append(C5046bo.ani(C1853r.m3846Yz())).append("</favusername>");
        stringBuilder.append("</recordinfo>");
        C8910b c8910b = new C8910b();
        c8910b.title = str;
        if (str2 != null && str2.length() > 200) {
            str2 = str2.substring(0, 200);
        }
        c8910b.description = str2;
        if (C5046bo.m7548ek(linkedList) || C5046bo.isNullOrNil(((aar) linkedList.get(0)).wgo) || !((aar) linkedList.get(0)).wgo.equals(".htm")) {
            c8910b.type = 19;
            c8910b.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/favorite_record__w_unsupport&from=singlemessage&isappinstalled=0";
        } else {
            c8910b.type = 24;
            c8910b.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008";
        }
        c8910b.action = "view";
        c8910b.fgU = stringBuilder.toString();
        AppMethodBeat.m2505o(135698);
        return c8910b;
    }

    /* renamed from: a */
    private static void m77556a(StringBuilder stringBuilder, abf abf) {
        AppMethodBeat.m2504i(135699);
        if (abf.vzK != null) {
            stringBuilder.append("<noteinfo>");
            stringBuilder.append("<noteauthor>").append(C5046bo.ani(abf.vzK.wim)).append("</noteauthor>");
            stringBuilder.append("<noteeditor>").append(C5046bo.ani(abf.vzK.win)).append("</noteeditor>");
            stringBuilder.append("</noteinfo>");
            stringBuilder.append("<edittime>").append(abf.lgR).append("</edittime>");
        }
        AppMethodBeat.m2505o(135699);
    }

    /* renamed from: a */
    private static void m77554a(C44100d c44100d, aar aar, int i) {
        AppMethodBeat.m2504i(135702);
        String str = aar.wgz;
        if (C1173e.m2561ct(str)) {
            c44100d.thumbPath = str;
            AppMethodBeat.m2505o(135702);
            return;
        }
        c44100d.cKc = i;
        AppMethodBeat.m2505o(135702);
    }
}
