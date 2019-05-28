package com.tencent.p177mm.plugin.backup.p346f;

import android.graphics.Bitmap.CompressFormat;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C45160g;
import com.tencent.p177mm.plugin.backup.p1394h.C38658d;
import com.tencent.p177mm.plugin.backup.p1394h.C45748c;
import com.tencent.p177mm.plugin.backup.p342b.C38635g;
import com.tencent.p177mm.plugin.backup.p346f.C11149i.C11150a;
import com.tencent.p177mm.plugin.backup.p346f.C45745h.C19972a;
import com.tencent.p177mm.plugin.backup.p921i.C19993u;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.protocal.protobuf.C40522gu;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.platformtools.C35985ad;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* renamed from: com.tencent.mm.plugin.backup.f.d */
public final class C38653d implements C27487l {
    /* renamed from: a */
    private static String m65553a(C25822e c25822e, C7620bi c7620bi) {
        AppMethodBeat.m2504i(17455);
        StringWriter stringWriter = new StringWriter();
        try {
            XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
            newSerializer.setOutput(stringWriter);
            if (C45748c.m84549kH(c7620bi.field_talker)) {
                stringWriter.write(C1829bf.m3762oy(c7620bi.field_content) + ":\n");
            }
            newSerializer.startTag(null, "msg");
            newSerializer.startTag(null, "img");
            Map z = C5049br.m7595z(c25822e.fDK, "msg");
            if (z != null) {
                if (z.get(".msg.img.$aeskey") == null) {
                    newSerializer.attribute(null, "aeskey", "");
                }
                if (z.get(".msg.img.$encryver") == null) {
                    newSerializer.attribute(null, "encryver", "");
                }
                if (z.get(".msg.img.$cdnthumbaeskey") == null) {
                    newSerializer.attribute(null, "cdnthumbaeskey", "");
                }
                if (z.get(".msg.img.$cdnthumburl") == null) {
                    newSerializer.attribute(null, "cdnthumburl", "");
                }
                if (z.get(".msg.img.$cdnthumblength") == null) {
                    newSerializer.attribute(null, "cdnthumblength", "10240");
                }
                if (z.get(".msg.img.$cdnthumbheight") == null) {
                    newSerializer.attribute(null, "cdnthumbheight", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                if (z.get(".msg.img.$cdnthumbwidth") == null) {
                    newSerializer.attribute(null, "cdnthumbwidth", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                if (z.get(".msg.img.$cdnmidheight") == null) {
                    newSerializer.attribute(null, "cdnmidheight", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                if (z.get(".msg.img.$cdnmidwidth") == null) {
                    newSerializer.attribute(null, "cdnmidwidth", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                if (z.get(".msg.img.$cdnhdheight") == null) {
                    newSerializer.attribute(null, "cdnhdheight", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                if (z.get(".msg.img.$cdnhdwidth") == null) {
                    newSerializer.attribute(null, "cdnhdwidth", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                if (z.get(".msg.img.$cdnmidimgurl") == null) {
                    newSerializer.attribute(null, "cdnmidimgurl", "");
                }
                if (C5046bo.getLong((String) z.get(".msg.img.$length"), 0) == 0) {
                    newSerializer.attribute(null, "length", C5730e.asZ(C38658d.aUr().aUs().aUo().mo73118q(c25822e.fDz, "", "")));
                }
                if (c7620bi.field_isSend != 1 || c25822e.fDC == 1) {
                    newSerializer.attribute(null, "cdnbigimgurl", ((String) z.get(".msg.img.$cdnbigimgurl")));
                    newSerializer.attribute(null, "hdlength", C5046bo.getLong((String) z.get(".msg.img.$hdlength"), 0));
                }
                z.remove(".msg.img.$cdnbigimgurl");
                z.remove(".msg.img.$hdlength");
                if (z.get(".msg.img.$md5") == null) {
                    newSerializer.attribute(null, "md5", "");
                }
                for (String str : z.keySet()) {
                    if (str.startsWith(".msg.img.$")) {
                        newSerializer.attribute(null, str.substring(10), (String) z.get(str));
                    }
                }
            }
            newSerializer.endTag(null, "img");
            newSerializer.endTag(null, "msg");
            newSerializer.endDocument();
            stringWriter.flush();
            stringWriter.close();
            C4990ab.m7411d("MicroMsg.BackupItemImg", "parseContent xml:%s", stringWriter.getBuffer().toString());
            AppMethodBeat.m2505o(17455);
            return stringWriter.getBuffer().toString();
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.BackupItemImg", "packetImg xml error: " + e.toString());
            AppMethodBeat.m2505o(17455);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:96:0x03f1  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0315  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x03be  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0359  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x03f5  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x026d  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x025c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final int mo35220a(String str, C40522gu c40522gu, C7620bi c7620bi) {
        AppMethodBeat.m2504i(17456);
        if (c40522gu == null || c40522gu.vED == null) {
            C4990ab.m7412e("MicroMsg.BackupItemImg", "recover bakitem or bakitem content is null");
            AppMethodBeat.m2505o(17456);
            return 0;
        }
        int i;
        String str2;
        C25822e fI;
        long j;
        Object obj;
        String bc;
        byte[] b;
        String str3 = new String(C5046bo.m7532bc(c40522gu.vED.wVI, ""));
        C4990ab.m7410d("MicroMsg.BackupItemImg", "recover msg:" + c40522gu.ptF + " " + str3);
        String str4 = "MicroMsg.BackupItemImg";
        String str5 = "recover backupItemImg:, buf:%d, BufferType:%d, MediaType%s, ids:%s";
        Object[] objArr = new Object[4];
        if (c40522gu.vJd == null) {
            i = 0;
        } else {
            i = c40522gu.vJd.getILen();
        }
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(c40522gu.vJf);
        if (c40522gu.vJc == null) {
            str2 = "";
        } else {
            str2 = c40522gu.vJc.toString();
        }
        objArr[2] = str2;
        if (c40522gu.vJb == null) {
            str2 = "";
        } else {
            str2 = c40522gu.vJb.toString();
        }
        objArr[3] = str2;
        C4990ab.m7411d(str4, str5, objArr);
        C25822e c25822e = null;
        c7620bi.setContent(str3);
        C45160g aUo = C38658d.aUr().aUs().aUo();
        if (c7620bi.field_isSend == 1) {
            if (c7620bi.field_msgId != 0) {
                c25822e = aUo.mo73113fJ(c7620bi.field_msgId);
            }
            if (c25822e == null || c25822e.fDy == 0) {
                fI = aUo.mo73112fI(c7620bi.field_msgSvrId);
            } else {
                fI = c25822e;
            }
        } else {
            fI = aUo.mo73112fI(c7620bi.field_msgSvrId);
        }
        Map z = C5049br.m7595z(str3, "msg");
        long j2 = 0;
        if (z != null) {
            j2 = C5046bo.getLong((String) z.get(".msg.img.$hdlength"), 0);
            if (j2 > 0) {
                String str6;
                String str7;
                j = j2;
                obj = 1;
                bc = C5046bo.m7532bc(C38635g.m65511a(c40522gu, 3), "");
                if (c40522gu.vJf == 3 && c40522gu.vJd != null) {
                    C38635g.m65516b(C38635g.m65503Fa(bc), bc, c40522gu.vJd.getBufferToBytes());
                }
                str2 = C5046bo.m7532bc(C38635g.m65511a(c40522gu, 2), "");
                if (c40522gu.vJf == 2 && c40522gu.vJd != null) {
                    C38635g.m65516b(C38635g.m65503Fa(str2), str2, c40522gu.vJd.getBufferToBytes());
                }
                C4990ab.m7411d("MicroMsg.BackupItemImg", "hdName %s, imgName:%s", bc, str2);
                if (C5046bo.isNullOrNil(str2)) {
                    str6 = str2;
                } else {
                    C4990ab.m7412e("MicroMsg.BackupItemImg", "imgName is null, imgName = hdName");
                    str6 = bc;
                }
                b = C38635g.m65520b(c40522gu, 1);
                if (b != null) {
                    C4990ab.m7416i("MicroMsg.BackupItemImg", "getThumbBuf is null and read from mediapath");
                    str2 = C38635g.m65503Fa(str6) + str6;
                    String x = C1178g.m2591x((C5046bo.anU() + " ").getBytes());
                    str4 = C38635g.m65503Fa(x);
                    str7 = str4 + x;
                    C5728b c5728b = new C5728b(str4);
                    if (!c5728b.exists()) {
                        c5728b.mkdirs();
                    }
                    int amy = C35985ad.amy(str7);
                    if (amy > 0) {
                        if (!C35985ad.m59190a(str2, CompressFormat.JPEG, str7, amy)) {
                            C4990ab.m7412e("MicroMsg.BackupItemImg", "createLongPictureThumbNail failed");
                            AppMethodBeat.m2505o(17456);
                            return -1;
                        }
                    } else if (C5056d.m7628a(str2, 120, 120, CompressFormat.JPEG, 90, str7)) {
                        C4990ab.m7410d("MicroMsg.BackupItemImg", "insert: thumbName = ".concat(String.valueOf(x)));
                    } else {
                        C4990ab.m7412e("MicroMsg.BackupItemImg", "createThumbNail failed");
                        AppMethodBeat.m2505o(17456);
                        return -1;
                    }
                    b = C5730e.m8632e(str7, 0, -1);
                } else {
                    C4990ab.m7417i("MicroMsg.BackupItemImg", "getThumbBuf len:%d", Integer.valueOf(b.length));
                }
                if (b != null) {
                    C4990ab.m7412e("MicroMsg.BackupItemImg", "img buf is null");
                    AppMethodBeat.m2505o(17456);
                    return -1;
                }
                String q = aUo.mo73118q(bc, "", "");
                String q2 = aUo.mo73118q(str6, "", "");
                long j3 = 0;
                if (fI.fDy == 0) {
                    int c;
                    PString pString;
                    PInt pInt;
                    PInt pInt2;
                    int c2 = C38635g.m65522c(c40522gu, 2);
                    if (obj != null) {
                        C45160g c45160g = aUo;
                        str7 = bc;
                        j3 = c45160g.mo73081a(b, c40522gu.ptF, true, str7, C38635g.m65522c(c40522gu, 3), str3, new PString(), new PInt(), new PInt());
                        if (!C38635g.m65519b(c40522gu, 3, q)) {
                            C4990ab.m7413e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE_HD failed:%s", q);
                            if (((long) c2) == j) {
                                if (C38635g.m65519b(c40522gu, 3, q2)) {
                                    C4990ab.m7417i("MicroMsg.BackupItemImg", "writeItem, try take img for hd img success:%s", q2);
                                    j = j3;
                                    Object obj2 = null;
                                    if (c2 > 0) {
                                        c = C38635g.m65522c(c40522gu, 3);
                                    } else {
                                        c = c2;
                                    }
                                    pString = new PString();
                                    pInt = new PInt();
                                    pInt2 = new PInt();
                                    j2 = aUo.mo73081a(b, c40522gu.ptF, false, str6, c, str3, pString, pInt, pInt2);
                                    if (!(obj2 == null || C38635g.m65519b(c40522gu, 2, q2))) {
                                        C4990ab.m7413e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE failed:%s", q);
                                    }
                                    if (j2 <= 0) {
                                        c7620bi.mo14795jv(pString.value);
                                        c7620bi.mo14784hZ(pInt.value);
                                        c7620bi.mo14786ia(pInt2.value);
                                        if (j > 0) {
                                            C25822e b2 = C38658d.aUr().aUs().aUo().mo73105b(Long.valueOf(j2));
                                            b2.mo43798lu((int) j);
                                            C38658d.aUr().aUs().aUo().mo73077a(Long.valueOf(j2), b2);
                                        }
                                    } else {
                                        AppMethodBeat.m2505o(17456);
                                        return -1;
                                    }
                                }
                                C4990ab.m7413e("MicroMsg.BackupItemImg", "writeItem, try take img for hd img failed:%s", q2);
                            }
                        }
                    }
                    j = j3;
                    int obj22 = 1;
                    if (c2 > 0) {
                    }
                    pString = new PString();
                    pInt = new PInt();
                    pInt2 = new PInt();
                    j2 = aUo.mo73081a(b, c40522gu.ptF, false, str6, c, str3, pString, pInt, pInt2);
                    C4990ab.m7413e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE failed:%s", q);
                    if (j2 <= 0) {
                    }
                } else {
                    str2 = fI.fDB;
                    if (str2 == null || !str2.startsWith("THUMBNAIL_DIRPATH://")) {
                        c7620bi.mo14795jv("THUMBNAIL://" + fI.fDy);
                    } else {
                        c7620bi.mo14795jv(str2);
                    }
                }
                C45748c.m84550l(c7620bi);
                AppMethodBeat.m2505o(17456);
                return 0;
            }
        }
        j = j2;
        obj = null;
        bc = C5046bo.m7532bc(C38635g.m65511a(c40522gu, 3), "");
        C38635g.m65516b(C38635g.m65503Fa(bc), bc, c40522gu.vJd.getBufferToBytes());
        str2 = C5046bo.m7532bc(C38635g.m65511a(c40522gu, 2), "");
        C38635g.m65516b(C38635g.m65503Fa(str2), str2, c40522gu.vJd.getBufferToBytes());
        C4990ab.m7411d("MicroMsg.BackupItemImg", "hdName %s, imgName:%s", bc, str2);
        if (C5046bo.isNullOrNil(str2)) {
        }
        b = C38635g.m65520b(c40522gu, 1);
        if (b != null) {
        }
        if (b != null) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x014f  */
    /* JADX WARNING: Missing block: B:36:0x01b2, code skipped:
            if (r0 != null) goto L_0x01b4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final int mo35219a(C40522gu c40522gu, boolean z, C7620bi c7620bi, String str, LinkedList<C19993u> linkedList, HashMap<Long, C19972a> hashMap, boolean z2, long j) {
        int i;
        C25822e c25822e;
        String I;
        String a;
        AppMethodBeat.m2504i(17454);
        if (C5046bo.isNullOrNil(c7620bi.field_content)) {
            i = 0;
        } else {
            i = c7620bi.field_content.getBytes().length;
        }
        if (c7620bi.field_isSend == 1) {
            C25822e fJ = C38658d.aUr().aUs().aUo().mo73113fJ(c7620bi.field_msgId);
            if (fJ.fDy != 0) {
                c25822e = fJ;
                I = C38658d.aUr().aUs().aUo().mo73074I(c7620bi.field_imgPath, true);
                if (C5730e.m8628ct(I)) {
                    i += C11149i.m18856a(new C11150a(I, c40522gu, (LinkedList) linkedList, 1, z, "_thumb", z2));
                }
                Object obj;
                String q;
                if (c7620bi.field_isSend != 1) {
                    obj = "";
                    q = C38658d.aUr().aUs().aUo().mo73118q(c25822e.fDz, "", "");
                    if (c25822e.agQ()) {
                        c25822e = C38658d.aUr().aUs().aUo().mo73116ly(c25822e.fDJ);
                        if (c25822e != null) {
                            obj = C38658d.aUr().aUs().aUo().mo73118q(c25822e.fDz, "", "");
                            C4990ab.m7410d("MicroMsg.BackupItemImg", "packet hd bigImgPath " + obj + " " + C5730e.asZ(obj));
                            C5730e.asZ(obj);
                            if (C5730e.m8628ct(obj)) {
                                i += C11149i.m18856a(new C11150a((String) obj, c40522gu, (LinkedList) linkedList, 3, z, "_hd", z2));
                            } else {
                                C4990ab.m7413e("MicroMsg.BackupItemImg", "packet img.hasHdImg but hdbigImgPath has no file, hdbigImgPath:%s", obj);
                            }
                        } else {
                            C4990ab.m7412e("MicroMsg.BackupItemImg", "packet img.hasHdImg but img is null");
                        }
                    }
                    C5730e.asZ(q);
                    if (!(C5046bo.isNullOrNil(q) || q.equals(obj))) {
                        C4990ab.m7410d("MicroMsg.BackupItemImg", "bigImgPath " + q + " " + C5730e.asZ(q));
                        i += C11149i.m18856a(new C11150a(q, c40522gu, (LinkedList) linkedList, 2, z, z2, null));
                    }
                } else if (c25822e.agP()) {
                    q = C38658d.aUr().aUs().aUo().mo73118q(c25822e.fDz, "", "");
                    obj = "";
                    if (c25822e.agQ()) {
                        fJ = C38658d.aUr().aUs().aUo().mo73116ly(c25822e.fDJ);
                    }
                    fJ = null;
                    if (fJ != null) {
                        C4990ab.m7417i("MicroMsg.BackupItemImg", "packet receive img hdinfo, offset[%d], totalLen[%d], compressType[%d], path:%s", Integer.valueOf(fJ.offset), Integer.valueOf(fJ.frO), Integer.valueOf(fJ.fDC), fJ.fDz);
                    }
                    if (fJ != null && fJ.fDC == 1) {
                        if (fJ.equals(c25822e) || fJ.offset != fJ.frO) {
                            fJ.equals(c25822e);
                        } else {
                            obj = C38658d.aUr().aUs().aUo().mo73118q(fJ.fDz, "", "");
                            C4990ab.m7411d("MicroMsg.BackupItemImg", "packet hdPath:%s, fileLen[%d]", obj, Long.valueOf(C5730e.asZ(obj)));
                            if (C5730e.m8628ct(obj)) {
                                i += C11149i.m18856a(new C11150a((String) obj, c40522gu, (LinkedList) linkedList, 3, z, "_hd", z2));
                                C5730e.asZ(obj);
                            }
                        }
                    }
                    if (C5730e.m8628ct(q)) {
                        C5730e.asZ(q);
                        if (!(C5046bo.isNullOrNil(q) || q.equals(r1))) {
                            C4990ab.m7410d("MicroMsg.BackupItemImg", "bigImgPath " + q + " " + C5730e.asZ(q));
                            i += C11149i.m18856a(new C11150a(q, c40522gu, (LinkedList) linkedList, 2, z, z2, null));
                        }
                    }
                }
                a = C38653d.m65553a(c25822e, c7620bi);
                if (a != null) {
                    AppMethodBeat.m2505o(17454);
                    return i;
                }
                c40522gu.vED = new bts().alV(a);
                i += a.length();
                AppMethodBeat.m2505o(17454);
                return i;
            }
        }
        c25822e = C38658d.aUr().aUs().aUo().mo73112fI(c7620bi.field_msgSvrId);
        I = C38658d.aUr().aUs().aUo().mo73074I(c7620bi.field_imgPath, true);
        if (C5730e.m8628ct(I)) {
        }
        if (c7620bi.field_isSend != 1) {
        }
        a = C38653d.m65553a(c25822e, c7620bi);
        if (a != null) {
        }
    }
}
