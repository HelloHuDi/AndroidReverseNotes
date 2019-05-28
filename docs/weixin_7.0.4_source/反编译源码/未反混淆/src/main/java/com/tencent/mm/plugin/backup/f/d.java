package com.tencent.mm.plugin.backup.f;

import android.graphics.Bitmap.CompressFormat;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.e;
import com.tencent.mm.at.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.backup.f.h.a;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.gu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.b;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class d implements l {
    private static String a(e eVar, bi biVar) {
        AppMethodBeat.i(17455);
        StringWriter stringWriter = new StringWriter();
        try {
            XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
            newSerializer.setOutput(stringWriter);
            if (c.kH(biVar.field_talker)) {
                stringWriter.write(bf.oy(biVar.field_content) + ":\n");
            }
            newSerializer.startTag(null, "msg");
            newSerializer.startTag(null, "img");
            Map z = br.z(eVar.fDK, "msg");
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
                if (bo.getLong((String) z.get(".msg.img.$length"), 0) == 0) {
                    newSerializer.attribute(null, "length", com.tencent.mm.vfs.e.asZ(com.tencent.mm.plugin.backup.h.d.aUr().aUs().aUo().q(eVar.fDz, "", "")));
                }
                if (biVar.field_isSend != 1 || eVar.fDC == 1) {
                    newSerializer.attribute(null, "cdnbigimgurl", ((String) z.get(".msg.img.$cdnbigimgurl")));
                    newSerializer.attribute(null, "hdlength", bo.getLong((String) z.get(".msg.img.$hdlength"), 0));
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
            ab.d("MicroMsg.BackupItemImg", "parseContent xml:%s", stringWriter.getBuffer().toString());
            AppMethodBeat.o(17455);
            return stringWriter.getBuffer().toString();
        } catch (Exception e) {
            ab.e("MicroMsg.BackupItemImg", "packetImg xml error: " + e.toString());
            AppMethodBeat.o(17455);
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
    public final int a(String str, gu guVar, bi biVar) {
        AppMethodBeat.i(17456);
        if (guVar == null || guVar.vED == null) {
            ab.e("MicroMsg.BackupItemImg", "recover bakitem or bakitem content is null");
            AppMethodBeat.o(17456);
            return 0;
        }
        int i;
        String str2;
        e fI;
        long j;
        Object obj;
        String bc;
        byte[] b;
        String str3 = new String(bo.bc(guVar.vED.wVI, ""));
        ab.d("MicroMsg.BackupItemImg", "recover msg:" + guVar.ptF + " " + str3);
        String str4 = "MicroMsg.BackupItemImg";
        String str5 = "recover backupItemImg:, buf:%d, BufferType:%d, MediaType%s, ids:%s";
        Object[] objArr = new Object[4];
        if (guVar.vJd == null) {
            i = 0;
        } else {
            i = guVar.vJd.getILen();
        }
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(guVar.vJf);
        if (guVar.vJc == null) {
            str2 = "";
        } else {
            str2 = guVar.vJc.toString();
        }
        objArr[2] = str2;
        if (guVar.vJb == null) {
            str2 = "";
        } else {
            str2 = guVar.vJb.toString();
        }
        objArr[3] = str2;
        ab.d(str4, str5, objArr);
        e eVar = null;
        biVar.setContent(str3);
        g aUo = com.tencent.mm.plugin.backup.h.d.aUr().aUs().aUo();
        if (biVar.field_isSend == 1) {
            if (biVar.field_msgId != 0) {
                eVar = aUo.fJ(biVar.field_msgId);
            }
            if (eVar == null || eVar.fDy == 0) {
                fI = aUo.fI(biVar.field_msgSvrId);
            } else {
                fI = eVar;
            }
        } else {
            fI = aUo.fI(biVar.field_msgSvrId);
        }
        Map z = br.z(str3, "msg");
        long j2 = 0;
        if (z != null) {
            j2 = bo.getLong((String) z.get(".msg.img.$hdlength"), 0);
            if (j2 > 0) {
                String str6;
                String str7;
                j = j2;
                obj = 1;
                bc = bo.bc(com.tencent.mm.plugin.backup.b.g.a(guVar, 3), "");
                if (guVar.vJf == 3 && guVar.vJd != null) {
                    com.tencent.mm.plugin.backup.b.g.b(com.tencent.mm.plugin.backup.b.g.Fa(bc), bc, guVar.vJd.getBufferToBytes());
                }
                str2 = bo.bc(com.tencent.mm.plugin.backup.b.g.a(guVar, 2), "");
                if (guVar.vJf == 2 && guVar.vJd != null) {
                    com.tencent.mm.plugin.backup.b.g.b(com.tencent.mm.plugin.backup.b.g.Fa(str2), str2, guVar.vJd.getBufferToBytes());
                }
                ab.d("MicroMsg.BackupItemImg", "hdName %s, imgName:%s", bc, str2);
                if (bo.isNullOrNil(str2)) {
                    str6 = str2;
                } else {
                    ab.e("MicroMsg.BackupItemImg", "imgName is null, imgName = hdName");
                    str6 = bc;
                }
                b = com.tencent.mm.plugin.backup.b.g.b(guVar, 1);
                if (b != null) {
                    ab.i("MicroMsg.BackupItemImg", "getThumbBuf is null and read from mediapath");
                    str2 = com.tencent.mm.plugin.backup.b.g.Fa(str6) + str6;
                    String x = com.tencent.mm.a.g.x((bo.anU() + " ").getBytes());
                    str4 = com.tencent.mm.plugin.backup.b.g.Fa(x);
                    str7 = str4 + x;
                    b bVar = new b(str4);
                    if (!bVar.exists()) {
                        bVar.mkdirs();
                    }
                    int amy = ad.amy(str7);
                    if (amy > 0) {
                        if (!ad.a(str2, CompressFormat.JPEG, str7, amy)) {
                            ab.e("MicroMsg.BackupItemImg", "createLongPictureThumbNail failed");
                            AppMethodBeat.o(17456);
                            return -1;
                        }
                    } else if (com.tencent.mm.sdk.platformtools.d.a(str2, 120, 120, CompressFormat.JPEG, 90, str7)) {
                        ab.d("MicroMsg.BackupItemImg", "insert: thumbName = ".concat(String.valueOf(x)));
                    } else {
                        ab.e("MicroMsg.BackupItemImg", "createThumbNail failed");
                        AppMethodBeat.o(17456);
                        return -1;
                    }
                    b = com.tencent.mm.vfs.e.e(str7, 0, -1);
                } else {
                    ab.i("MicroMsg.BackupItemImg", "getThumbBuf len:%d", Integer.valueOf(b.length));
                }
                if (b != null) {
                    ab.e("MicroMsg.BackupItemImg", "img buf is null");
                    AppMethodBeat.o(17456);
                    return -1;
                }
                String q = aUo.q(bc, "", "");
                String q2 = aUo.q(str6, "", "");
                long j3 = 0;
                if (fI.fDy == 0) {
                    int c;
                    PString pString;
                    PInt pInt;
                    PInt pInt2;
                    int c2 = com.tencent.mm.plugin.backup.b.g.c(guVar, 2);
                    if (obj != null) {
                        g gVar = aUo;
                        str7 = bc;
                        j3 = gVar.a(b, guVar.ptF, true, str7, com.tencent.mm.plugin.backup.b.g.c(guVar, 3), str3, new PString(), new PInt(), new PInt());
                        if (!com.tencent.mm.plugin.backup.b.g.b(guVar, 3, q)) {
                            ab.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE_HD failed:%s", q);
                            if (((long) c2) == j) {
                                if (com.tencent.mm.plugin.backup.b.g.b(guVar, 3, q2)) {
                                    ab.i("MicroMsg.BackupItemImg", "writeItem, try take img for hd img success:%s", q2);
                                    j = j3;
                                    Object obj2 = null;
                                    if (c2 > 0) {
                                        c = com.tencent.mm.plugin.backup.b.g.c(guVar, 3);
                                    } else {
                                        c = c2;
                                    }
                                    pString = new PString();
                                    pInt = new PInt();
                                    pInt2 = new PInt();
                                    j2 = aUo.a(b, guVar.ptF, false, str6, c, str3, pString, pInt, pInt2);
                                    if (!(obj2 == null || com.tencent.mm.plugin.backup.b.g.b(guVar, 2, q2))) {
                                        ab.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE failed:%s", q);
                                    }
                                    if (j2 <= 0) {
                                        biVar.jv(pString.value);
                                        biVar.hZ(pInt.value);
                                        biVar.ia(pInt2.value);
                                        if (j > 0) {
                                            e b2 = com.tencent.mm.plugin.backup.h.d.aUr().aUs().aUo().b(Long.valueOf(j2));
                                            b2.lu((int) j);
                                            com.tencent.mm.plugin.backup.h.d.aUr().aUs().aUo().a(Long.valueOf(j2), b2);
                                        }
                                    } else {
                                        AppMethodBeat.o(17456);
                                        return -1;
                                    }
                                }
                                ab.e("MicroMsg.BackupItemImg", "writeItem, try take img for hd img failed:%s", q2);
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
                    j2 = aUo.a(b, guVar.ptF, false, str6, c, str3, pString, pInt, pInt2);
                    ab.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE failed:%s", q);
                    if (j2 <= 0) {
                    }
                } else {
                    str2 = fI.fDB;
                    if (str2 == null || !str2.startsWith("THUMBNAIL_DIRPATH://")) {
                        biVar.jv("THUMBNAIL://" + fI.fDy);
                    } else {
                        biVar.jv(str2);
                    }
                }
                c.l(biVar);
                AppMethodBeat.o(17456);
                return 0;
            }
        }
        j = j2;
        obj = null;
        bc = bo.bc(com.tencent.mm.plugin.backup.b.g.a(guVar, 3), "");
        com.tencent.mm.plugin.backup.b.g.b(com.tencent.mm.plugin.backup.b.g.Fa(bc), bc, guVar.vJd.getBufferToBytes());
        str2 = bo.bc(com.tencent.mm.plugin.backup.b.g.a(guVar, 2), "");
        com.tencent.mm.plugin.backup.b.g.b(com.tencent.mm.plugin.backup.b.g.Fa(str2), str2, guVar.vJd.getBufferToBytes());
        ab.d("MicroMsg.BackupItemImg", "hdName %s, imgName:%s", bc, str2);
        if (bo.isNullOrNil(str2)) {
        }
        b = com.tencent.mm.plugin.backup.b.g.b(guVar, 1);
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
    public final int a(gu guVar, boolean z, bi biVar, String str, LinkedList<u> linkedList, HashMap<Long, a> hashMap, boolean z2, long j) {
        int i;
        e eVar;
        String I;
        String a;
        AppMethodBeat.i(17454);
        if (bo.isNullOrNil(biVar.field_content)) {
            i = 0;
        } else {
            i = biVar.field_content.getBytes().length;
        }
        if (biVar.field_isSend == 1) {
            e fJ = com.tencent.mm.plugin.backup.h.d.aUr().aUs().aUo().fJ(biVar.field_msgId);
            if (fJ.fDy != 0) {
                eVar = fJ;
                I = com.tencent.mm.plugin.backup.h.d.aUr().aUs().aUo().I(biVar.field_imgPath, true);
                if (com.tencent.mm.vfs.e.ct(I)) {
                    i += i.a(new i.a(I, guVar, (LinkedList) linkedList, 1, z, "_thumb", z2));
                }
                Object obj;
                String q;
                if (biVar.field_isSend != 1) {
                    obj = "";
                    q = com.tencent.mm.plugin.backup.h.d.aUr().aUs().aUo().q(eVar.fDz, "", "");
                    if (eVar.agQ()) {
                        eVar = com.tencent.mm.plugin.backup.h.d.aUr().aUs().aUo().ly(eVar.fDJ);
                        if (eVar != null) {
                            obj = com.tencent.mm.plugin.backup.h.d.aUr().aUs().aUo().q(eVar.fDz, "", "");
                            ab.d("MicroMsg.BackupItemImg", "packet hd bigImgPath " + obj + " " + com.tencent.mm.vfs.e.asZ(obj));
                            com.tencent.mm.vfs.e.asZ(obj);
                            if (com.tencent.mm.vfs.e.ct(obj)) {
                                i += i.a(new i.a((String) obj, guVar, (LinkedList) linkedList, 3, z, "_hd", z2));
                            } else {
                                ab.e("MicroMsg.BackupItemImg", "packet img.hasHdImg but hdbigImgPath has no file, hdbigImgPath:%s", obj);
                            }
                        } else {
                            ab.e("MicroMsg.BackupItemImg", "packet img.hasHdImg but img is null");
                        }
                    }
                    com.tencent.mm.vfs.e.asZ(q);
                    if (!(bo.isNullOrNil(q) || q.equals(obj))) {
                        ab.d("MicroMsg.BackupItemImg", "bigImgPath " + q + " " + com.tencent.mm.vfs.e.asZ(q));
                        i += i.a(new i.a(q, guVar, (LinkedList) linkedList, 2, z, z2, null));
                    }
                } else if (eVar.agP()) {
                    q = com.tencent.mm.plugin.backup.h.d.aUr().aUs().aUo().q(eVar.fDz, "", "");
                    obj = "";
                    if (eVar.agQ()) {
                        fJ = com.tencent.mm.plugin.backup.h.d.aUr().aUs().aUo().ly(eVar.fDJ);
                    }
                    fJ = null;
                    if (fJ != null) {
                        ab.i("MicroMsg.BackupItemImg", "packet receive img hdinfo, offset[%d], totalLen[%d], compressType[%d], path:%s", Integer.valueOf(fJ.offset), Integer.valueOf(fJ.frO), Integer.valueOf(fJ.fDC), fJ.fDz);
                    }
                    if (fJ != null && fJ.fDC == 1) {
                        if (fJ.equals(eVar) || fJ.offset != fJ.frO) {
                            fJ.equals(eVar);
                        } else {
                            obj = com.tencent.mm.plugin.backup.h.d.aUr().aUs().aUo().q(fJ.fDz, "", "");
                            ab.d("MicroMsg.BackupItemImg", "packet hdPath:%s, fileLen[%d]", obj, Long.valueOf(com.tencent.mm.vfs.e.asZ(obj)));
                            if (com.tencent.mm.vfs.e.ct(obj)) {
                                i += i.a(new i.a((String) obj, guVar, (LinkedList) linkedList, 3, z, "_hd", z2));
                                com.tencent.mm.vfs.e.asZ(obj);
                            }
                        }
                    }
                    if (com.tencent.mm.vfs.e.ct(q)) {
                        com.tencent.mm.vfs.e.asZ(q);
                        if (!(bo.isNullOrNil(q) || q.equals(r1))) {
                            ab.d("MicroMsg.BackupItemImg", "bigImgPath " + q + " " + com.tencent.mm.vfs.e.asZ(q));
                            i += i.a(new i.a(q, guVar, (LinkedList) linkedList, 2, z, z2, null));
                        }
                    }
                }
                a = a(eVar, biVar);
                if (a != null) {
                    AppMethodBeat.o(17454);
                    return i;
                }
                guVar.vED = new bts().alV(a);
                i += a.length();
                AppMethodBeat.o(17454);
                return i;
            }
        }
        eVar = com.tencent.mm.plugin.backup.h.d.aUr().aUs().aUo().fI(biVar.field_msgSvrId);
        I = com.tencent.mm.plugin.backup.h.d.aUr().aUs().aUo().I(biVar.field_imgPath, true);
        if (com.tencent.mm.vfs.e.ct(I)) {
        }
        if (biVar.field_isSend != 1) {
        }
        a = a(eVar, biVar);
        if (a != null) {
        }
    }
}
