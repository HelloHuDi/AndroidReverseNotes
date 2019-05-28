package com.tencent.p177mm.plugin.backup.bakoldlogic.p917b;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C45160g;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p1393a.C27452a;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p917b.C11111i.C11112a;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p918d.C11124b;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p918d.C11131d;
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
import java.io.File;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.b.e */
public final class C33676e implements C45737j {
    /* renamed from: a */
    private static String m54985a(C25822e c25822e, C7620bi c7620bi) {
        AppMethodBeat.m2504i(17789);
        StringWriter stringWriter = new StringWriter();
        try {
            XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
            newSerializer.setOutput(stringWriter);
            if (C11131d.m18844kH(c7620bi.field_talker)) {
                stringWriter.write(C1829bf.m3762oy(c7620bi.field_content) + ":\n");
            }
            newSerializer.startTag(null, "msg");
            newSerializer.startTag(null, "img");
            Map z = C5049br.m7595z(c25822e.fDK, "msg");
            if (z != null) {
                newSerializer.attribute(null, "aeskey", ((String) z.get(".msg.img.$aeskey")));
                newSerializer.attribute(null, "encryver", ((String) z.get(".msg.img.$encryver")));
                newSerializer.attribute(null, "cdnthumbaeskey", ((String) z.get(".msg.img.$cdnthumbaeskey")));
                newSerializer.attribute(null, "cdnthumburl", ((String) z.get(".msg.img.$cdnthumburl")));
                newSerializer.attribute(null, "cdnthumblength", C5046bo.getLong((String) z.get(".msg.img.$cdnthumblength"), 10240));
                newSerializer.attribute(null, "cdnthumbheight", C5046bo.getInt((String) z.get(".msg.img.$cdnthumbheight"), 0));
                newSerializer.attribute(null, "cdnthumbwidth", C5046bo.getInt((String) z.get(".msg.img.$cdnthumbwidth"), 0));
                newSerializer.attribute(null, "cdnmidheight", C5046bo.getInt((String) z.get(".msg.img.$cdnmidheight"), 0));
                newSerializer.attribute(null, "cdnmidwidth", C5046bo.getInt((String) z.get(".msg.img.$cdnmidwidth"), 0));
                newSerializer.attribute(null, "cdnhdheight", C5046bo.getInt((String) z.get(".msg.img.$cdnhdheight"), 0));
                newSerializer.attribute(null, "cdnhdwidth", C5046bo.getInt((String) z.get(".msg.img.$cdnhdwidth"), 0));
                newSerializer.attribute(null, "cdnmidimgurl", ((String) z.get(".msg.img.$cdnmidimgurl")));
                long j = C5046bo.getLong((String) z.get(".msg.img.$length"), 0);
                String str = "length";
                StringBuilder stringBuilder = new StringBuilder();
                if (j == 0) {
                    j = (long) C1173e.m2560cs(C11124b.aUY().aUZ().aUo().mo73118q(c25822e.fDz, "", ""));
                }
                newSerializer.attribute(null, str, stringBuilder.append(j).toString());
                if (c7620bi.field_isSend != 1 || c25822e.fDC == 1) {
                    newSerializer.attribute(null, "cdnbigimgurl", ((String) z.get(".msg.img.$cdnbigimgurl")));
                    newSerializer.attribute(null, "hdlength", C5046bo.getLong((String) z.get(".msg.img.$hdlength"), 0));
                }
                newSerializer.attribute(null, "md5", ((String) z.get(".msg.img.$md5")));
            }
            newSerializer.endTag(null, "img");
            newSerializer.endTag(null, "msg");
            newSerializer.endDocument();
            stringWriter.flush();
            stringWriter.close();
            C4990ab.m7411d("MicroMsg.BakOldItemImg", "parseContent xml:%s", stringWriter.getBuffer().toString());
            AppMethodBeat.m2505o(17789);
            return stringWriter.getBuffer().toString();
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.BakOldItemImg", "packetImg xml error: " + e.toString());
            AppMethodBeat.m2505o(17789);
            return null;
        }
    }

    /* renamed from: a */
    public final int mo22812a(String str, C40522gu c40522gu, C7620bi c7620bi) {
        AppMethodBeat.m2504i(17790);
        if (c40522gu == null || c40522gu.vED == null) {
            C4990ab.m7412e("MicroMsg.BakOldItemImg", "recover bakitem or bakitem content is null");
            AppMethodBeat.m2505o(17790);
            return 0;
        }
        int i;
        String str2;
        C25822e fI;
        Object obj;
        String str3;
        String str4;
        String str5 = new String(C5046bo.m7532bc(c40522gu.vED.wVI, ""));
        C4990ab.m7410d("MicroMsg.BakOldItemImg", "recover msg" + c40522gu.ptF + " " + str5);
        String str6 = "MicroMsg.BakOldItemImg";
        String str7 = "recover bakitem:, buf:%d, BufferType:%d, MediaType%s, ids:%s";
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
        C4990ab.m7411d(str6, str7, objArr);
        C25822e c25822e = null;
        c7620bi.setContent(str5);
        C45160g aUo = C11124b.aUY().aUZ().aUo();
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
        Map z = C5049br.m7595z(str5, "msg");
        if (z == null || C5046bo.getLong((String) z.get(".msg.img.$hdlength"), 0) <= 0) {
            obj = null;
        } else {
            obj = 1;
        }
        String bc = C5046bo.m7532bc(C27452a.m43557a(c40522gu, 3), "");
        if (c40522gu.vJf == 3 && c40522gu.vJd != null) {
            C1173e.m2558b(C27452a.aUy() + "backupMeida/" + C27452a.m43552Fb(bc), bc, c40522gu.vJd.getBufferToBytes());
        }
        str2 = C5046bo.m7532bc(C27452a.m43557a(c40522gu, 2), "");
        if (c40522gu.vJf == 2 && c40522gu.vJd != null) {
            C1173e.m2558b(C27452a.aUy() + "backupMeida/" + C27452a.m43552Fb(str2), str2, c40522gu.vJd.getBufferToBytes());
        }
        C4990ab.m7411d("MicroMsg.BakOldItemImg", "hdName %s, imgName:%s", bc, str2);
        if (C5046bo.isNullOrNil(str2)) {
            C4990ab.m7412e("MicroMsg.BakOldItemImg", "imgName is null, imgName = hdName");
            str3 = bc;
        } else {
            str3 = str2;
        }
        byte[] b = C27452a.m43561b(c40522gu, 1);
        if (b == null) {
            C4990ab.m7416i("MicroMsg.BakOldItemImg", "getThumbBuf is null and read from mediapath");
            str2 = C27452a.m43555Fp(str3);
            String x = C1178g.m2591x((C5046bo.anU() + " ").getBytes());
            str6 = C27452a.aUy() + "backupMeida/" + C27452a.m43552Fb(x);
            str4 = str6 + x;
            File file = new File(str6);
            if (!file.exists()) {
                file.mkdirs();
            }
            int amy = C35985ad.amy(str4);
            if (amy > 0) {
                if (!C35985ad.m59190a(str2, CompressFormat.JPEG, str4, amy)) {
                    C4990ab.m7412e("MicroMsg.BakOldItemImg", "createLongPictureThumbNail failed");
                    AppMethodBeat.m2505o(17790);
                    return -1;
                }
            } else if (C5056d.m7628a(str2, 120, 120, CompressFormat.JPEG, 90, str4)) {
                C4990ab.m7410d("MicroMsg.BakOldItemImg", "insert: thumbName = ".concat(String.valueOf(x)));
            } else {
                C4990ab.m7412e("MicroMsg.BakOldItemImg", "createThumbNail failed");
                AppMethodBeat.m2505o(17790);
                return -1;
            }
            b = C1173e.m2571f(str4, 0, -1);
        } else {
            C4990ab.m7417i("MicroMsg.BakOldItemImg", "getThumbBuf len:%d", Integer.valueOf(b.length));
        }
        if (b == null) {
            C4990ab.m7412e("MicroMsg.BakOldItemImg", "img buf is null");
            AppMethodBeat.m2505o(17790);
            return -1;
        }
        String q = aUo.mo73118q(bc, "", "");
        String q2 = aUo.mo73118q(str3, "", "");
        long j = 0;
        if (fI.fDy == 0) {
            if (obj != null) {
                C45160g c45160g = aUo;
                str4 = bc;
                j = c45160g.mo73081a(b, c40522gu.ptF, true, str4, C27452a.m43563c(c40522gu, 3), str5, new PString(), new PInt(), new PInt());
                if (!C27452a.m43560b(c40522gu, 3, q)) {
                    C4990ab.m7413e("MicroMsg.BakOldItemImg", "writeItem MMBAK_HD_IMG failed:%s", q);
                }
            }
            long j2 = j;
            int c = C27452a.m43563c(c40522gu, 2);
            if (c <= 0) {
                c = C27452a.m43563c(c40522gu, 3);
            }
            PString pString = new PString();
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            long a = aUo.mo73081a(b, c40522gu.ptF, false, str3, c, str5, pString, pInt, pInt2);
            if (!C27452a.m43560b(c40522gu, 2, q2)) {
                C4990ab.m7413e("MicroMsg.BakOldItemImg", "writeItem MMBAK_IMG failed:%s", q);
            }
            if (a > 0) {
                c7620bi.mo14795jv(pString.value);
                c7620bi.mo14784hZ(pInt.value);
                c7620bi.mo14786ia(pInt2.value);
                if (j2 > 0) {
                    C25822e b2 = C11124b.aUY().aUZ().aUo().mo73105b(Long.valueOf(a));
                    b2.mo43798lu((int) j2);
                    C11124b.aUY().aUZ().aUo().mo73077a(Long.valueOf(a), b2);
                }
            } else {
                AppMethodBeat.m2505o(17790);
                return -1;
            }
        }
        str2 = fI.fDB;
        if (str2 == null || !str2.startsWith("THUMBNAIL_DIRPATH://")) {
            c7620bi.mo14795jv("THUMBNAIL://" + fI.fDy);
        } else {
            c7620bi.mo14795jv(str2);
        }
        C11131d.m18845l(c7620bi);
        AppMethodBeat.m2505o(17790);
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x0250  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x005a  */
    /* JADX WARNING: Missing block: B:39:0x01b7, code skipped:
            if (r0 != null) goto L_0x01b9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final int mo22811a(C40522gu c40522gu, C7620bi c7620bi, LinkedList<C19993u> linkedList) {
        int i;
        C25822e c25822e;
        String I;
        AppMethodBeat.m2504i(17788);
        if (C5046bo.isNullOrNil(c7620bi.field_content)) {
            i = 0;
        } else {
            i = c7620bi.field_content.getBytes().length;
        }
        if (c7620bi.field_isSend == 1) {
            C25822e fJ = C11124b.aUY().aUZ().aUo().mo73113fJ(c7620bi.field_msgId);
            if (fJ.fDy != 0) {
                c25822e = fJ;
                I = C11124b.aUY().aUZ().aUo().mo73074I(c7620bi.field_imgPath, true);
                if (C1173e.m2561ct(I)) {
                    AppMethodBeat.m2505o(17788);
                    return -1;
                }
                int a;
                i += C11111i.m18825a(new C11112a(I, c40522gu, linkedList, 1, "_thumb"));
                Object obj;
                String q;
                if (c7620bi.field_isSend == 1) {
                    obj = "";
                    q = C11124b.aUY().aUZ().aUo().mo73118q(c25822e.fDz, "", "");
                    if (c25822e.agQ()) {
                        c25822e = C11124b.aUY().aUZ().aUo().mo73116ly(c25822e.fDJ);
                        if (c25822e != null) {
                            obj = C11124b.aUY().aUZ().aUo().mo73118q(c25822e.fDz, "", "");
                            C4990ab.m7410d("MicroMsg.BakOldItemImg", "packet hd bigImgPath " + obj + " " + C1173e.m2560cs(obj));
                            C1173e.m2560cs(obj);
                            if (C1173e.m2561ct(obj)) {
                                a = C11111i.m18825a(new C11112a(obj, c40522gu, linkedList, 3, "_hd")) + i;
                            } else {
                                C4990ab.m7413e("MicroMsg.BakOldItemImg", "packet img.hasHdImg but hdbigImgPath has no file, hdbigImgPath:%s", obj);
                                a = i;
                            }
                            C1173e.m2560cs(q);
                            if (!(C5046bo.isNullOrNil(q) || q.equals(obj))) {
                                C4990ab.m7410d("MicroMsg.BakOldItemImg", "bigImgPath " + q + " " + C1173e.m2560cs(q));
                                a += C11111i.m18825a(new C11112a(q, c40522gu, linkedList, 2, false, null));
                            }
                        } else {
                            C4990ab.m7412e("MicroMsg.BakOldItemImg", "packet img.hasHdImg but img is null");
                        }
                    }
                    a = i;
                    C1173e.m2560cs(q);
                    C4990ab.m7410d("MicroMsg.BakOldItemImg", "bigImgPath " + q + " " + C1173e.m2560cs(q));
                    a += C11111i.m18825a(new C11112a(q, c40522gu, linkedList, 2, false, null));
                } else if (c25822e.agP()) {
                    q = C11124b.aUY().aUZ().aUo().mo73118q(c25822e.fDz, "", "");
                    String str = "";
                    if (c25822e.agQ()) {
                        int i2;
                        if (c25822e.agQ()) {
                            fJ = C11124b.aUY().aUZ().aUo().mo73116ly(c25822e.fDJ);
                        }
                        fJ = c25822e;
                        String str2 = "MicroMsg.BakOldItemImg";
                        String str3 = "packet hdinfo off:%d total:%d path:%s, compressType[%d]";
                        Object[] objArr = new Object[4];
                        if (fJ == null) {
                            i2 = -1;
                        } else {
                            i2 = fJ.offset;
                        }
                        objArr[0] = Integer.valueOf(i2);
                        if (fJ == null) {
                            i2 = -1;
                        } else {
                            i2 = fJ.frO;
                        }
                        objArr[1] = Integer.valueOf(i2);
                        if (fJ == null) {
                            I = BuildConfig.COMMAND;
                        } else {
                            I = fJ.fDz;
                        }
                        objArr[2] = I;
                        if (fJ == null) {
                            i2 = -1;
                        } else {
                            i2 = fJ.fDC;
                        }
                        objArr[3] = Integer.valueOf(i2);
                        C4990ab.m7417i(str2, str3, objArr);
                        if (fJ != null && fJ.fDC == 1) {
                            if (fJ.equals(c25822e) || fJ.offset != fJ.frO) {
                                fJ.equals(c25822e);
                            } else {
                                obj = C11124b.aUY().aUZ().aUo().mo73118q(fJ.fDz, "", "");
                                C4990ab.m7411d("MicroMsg.BakOldItemImg", "packet hdPath:%s, fileLen[%d]", obj, Integer.valueOf(C1173e.m2560cs(obj)));
                                if (C1173e.m2561ct(obj)) {
                                    i += C11111i.m18825a(new C11112a(obj, c40522gu, linkedList, 3, "_hd"));
                                    C1173e.m2560cs(obj);
                                    a = i;
                                } else {
                                    a = i;
                                }
                                if (C1173e.m2561ct(q)) {
                                    C1173e.m2560cs(q);
                                    if (!(C5046bo.isNullOrNil(q) || q.equals(r1))) {
                                        C4990ab.m7410d("MicroMsg.BakOldItemImg", "bigImgPath " + q + " " + C1173e.m2560cs(q));
                                        a += C11111i.m18825a(new C11112a(q, c40522gu, linkedList, 2, false, null));
                                    }
                                }
                            }
                        }
                    }
                    I = str;
                    a = i;
                    if (C1173e.m2561ct(q)) {
                    }
                } else {
                    a = i;
                }
                String a2 = C33676e.m54985a(c25822e, c7620bi);
                if (a2 == null) {
                    AppMethodBeat.m2505o(17788);
                    return a;
                }
                c40522gu.vED = new bts().alV(a2);
                a += a2.length();
                AppMethodBeat.m2505o(17788);
                return a;
            }
        }
        c25822e = C11124b.aUY().aUZ().aUo().mo73112fI(c7620bi.field_msgSvrId);
        I = C11124b.aUY().aUZ().aUo().mo73074I(c7620bi.field_imgPath, true);
        if (C1173e.m2561ct(I)) {
        }
    }
}
