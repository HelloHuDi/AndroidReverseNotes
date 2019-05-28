package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
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
import java.io.File;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class e implements j {
    private static String a(com.tencent.mm.at.e eVar, bi biVar) {
        AppMethodBeat.i(17789);
        StringWriter stringWriter = new StringWriter();
        try {
            XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
            newSerializer.setOutput(stringWriter);
            if (d.kH(biVar.field_talker)) {
                stringWriter.write(bf.oy(biVar.field_content) + ":\n");
            }
            newSerializer.startTag(null, "msg");
            newSerializer.startTag(null, "img");
            Map z = br.z(eVar.fDK, "msg");
            if (z != null) {
                newSerializer.attribute(null, "aeskey", ((String) z.get(".msg.img.$aeskey")));
                newSerializer.attribute(null, "encryver", ((String) z.get(".msg.img.$encryver")));
                newSerializer.attribute(null, "cdnthumbaeskey", ((String) z.get(".msg.img.$cdnthumbaeskey")));
                newSerializer.attribute(null, "cdnthumburl", ((String) z.get(".msg.img.$cdnthumburl")));
                newSerializer.attribute(null, "cdnthumblength", bo.getLong((String) z.get(".msg.img.$cdnthumblength"), 10240));
                newSerializer.attribute(null, "cdnthumbheight", bo.getInt((String) z.get(".msg.img.$cdnthumbheight"), 0));
                newSerializer.attribute(null, "cdnthumbwidth", bo.getInt((String) z.get(".msg.img.$cdnthumbwidth"), 0));
                newSerializer.attribute(null, "cdnmidheight", bo.getInt((String) z.get(".msg.img.$cdnmidheight"), 0));
                newSerializer.attribute(null, "cdnmidwidth", bo.getInt((String) z.get(".msg.img.$cdnmidwidth"), 0));
                newSerializer.attribute(null, "cdnhdheight", bo.getInt((String) z.get(".msg.img.$cdnhdheight"), 0));
                newSerializer.attribute(null, "cdnhdwidth", bo.getInt((String) z.get(".msg.img.$cdnhdwidth"), 0));
                newSerializer.attribute(null, "cdnmidimgurl", ((String) z.get(".msg.img.$cdnmidimgurl")));
                long j = bo.getLong((String) z.get(".msg.img.$length"), 0);
                String str = "length";
                StringBuilder stringBuilder = new StringBuilder();
                if (j == 0) {
                    j = (long) com.tencent.mm.a.e.cs(b.aUY().aUZ().aUo().q(eVar.fDz, "", ""));
                }
                newSerializer.attribute(null, str, stringBuilder.append(j).toString());
                if (biVar.field_isSend != 1 || eVar.fDC == 1) {
                    newSerializer.attribute(null, "cdnbigimgurl", ((String) z.get(".msg.img.$cdnbigimgurl")));
                    newSerializer.attribute(null, "hdlength", bo.getLong((String) z.get(".msg.img.$hdlength"), 0));
                }
                newSerializer.attribute(null, "md5", ((String) z.get(".msg.img.$md5")));
            }
            newSerializer.endTag(null, "img");
            newSerializer.endTag(null, "msg");
            newSerializer.endDocument();
            stringWriter.flush();
            stringWriter.close();
            ab.d("MicroMsg.BakOldItemImg", "parseContent xml:%s", stringWriter.getBuffer().toString());
            AppMethodBeat.o(17789);
            return stringWriter.getBuffer().toString();
        } catch (Exception e) {
            ab.e("MicroMsg.BakOldItemImg", "packetImg xml error: " + e.toString());
            AppMethodBeat.o(17789);
            return null;
        }
    }

    public final int a(String str, gu guVar, bi biVar) {
        AppMethodBeat.i(17790);
        if (guVar == null || guVar.vED == null) {
            ab.e("MicroMsg.BakOldItemImg", "recover bakitem or bakitem content is null");
            AppMethodBeat.o(17790);
            return 0;
        }
        int i;
        String str2;
        com.tencent.mm.at.e fI;
        Object obj;
        String str3;
        String str4;
        String str5 = new String(bo.bc(guVar.vED.wVI, ""));
        ab.d("MicroMsg.BakOldItemImg", "recover msg" + guVar.ptF + " " + str5);
        String str6 = "MicroMsg.BakOldItemImg";
        String str7 = "recover bakitem:, buf:%d, BufferType:%d, MediaType%s, ids:%s";
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
        ab.d(str6, str7, objArr);
        com.tencent.mm.at.e eVar = null;
        biVar.setContent(str5);
        g aUo = b.aUY().aUZ().aUo();
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
        Map z = br.z(str5, "msg");
        if (z == null || bo.getLong((String) z.get(".msg.img.$hdlength"), 0) <= 0) {
            obj = null;
        } else {
            obj = 1;
        }
        String bc = bo.bc(a.a(guVar, 3), "");
        if (guVar.vJf == 3 && guVar.vJd != null) {
            com.tencent.mm.a.e.b(a.aUy() + "backupMeida/" + a.Fb(bc), bc, guVar.vJd.getBufferToBytes());
        }
        str2 = bo.bc(a.a(guVar, 2), "");
        if (guVar.vJf == 2 && guVar.vJd != null) {
            com.tencent.mm.a.e.b(a.aUy() + "backupMeida/" + a.Fb(str2), str2, guVar.vJd.getBufferToBytes());
        }
        ab.d("MicroMsg.BakOldItemImg", "hdName %s, imgName:%s", bc, str2);
        if (bo.isNullOrNil(str2)) {
            ab.e("MicroMsg.BakOldItemImg", "imgName is null, imgName = hdName");
            str3 = bc;
        } else {
            str3 = str2;
        }
        byte[] b = a.b(guVar, 1);
        if (b == null) {
            ab.i("MicroMsg.BakOldItemImg", "getThumbBuf is null and read from mediapath");
            str2 = a.Fp(str3);
            String x = com.tencent.mm.a.g.x((bo.anU() + " ").getBytes());
            str6 = a.aUy() + "backupMeida/" + a.Fb(x);
            str4 = str6 + x;
            File file = new File(str6);
            if (!file.exists()) {
                file.mkdirs();
            }
            int amy = ad.amy(str4);
            if (amy > 0) {
                if (!ad.a(str2, CompressFormat.JPEG, str4, amy)) {
                    ab.e("MicroMsg.BakOldItemImg", "createLongPictureThumbNail failed");
                    AppMethodBeat.o(17790);
                    return -1;
                }
            } else if (com.tencent.mm.sdk.platformtools.d.a(str2, 120, 120, CompressFormat.JPEG, 90, str4)) {
                ab.d("MicroMsg.BakOldItemImg", "insert: thumbName = ".concat(String.valueOf(x)));
            } else {
                ab.e("MicroMsg.BakOldItemImg", "createThumbNail failed");
                AppMethodBeat.o(17790);
                return -1;
            }
            b = com.tencent.mm.a.e.f(str4, 0, -1);
        } else {
            ab.i("MicroMsg.BakOldItemImg", "getThumbBuf len:%d", Integer.valueOf(b.length));
        }
        if (b == null) {
            ab.e("MicroMsg.BakOldItemImg", "img buf is null");
            AppMethodBeat.o(17790);
            return -1;
        }
        String q = aUo.q(bc, "", "");
        String q2 = aUo.q(str3, "", "");
        long j = 0;
        if (fI.fDy == 0) {
            if (obj != null) {
                g gVar = aUo;
                str4 = bc;
                j = gVar.a(b, guVar.ptF, true, str4, a.c(guVar, 3), str5, new PString(), new PInt(), new PInt());
                if (!a.b(guVar, 3, q)) {
                    ab.e("MicroMsg.BakOldItemImg", "writeItem MMBAK_HD_IMG failed:%s", q);
                }
            }
            long j2 = j;
            int c = a.c(guVar, 2);
            if (c <= 0) {
                c = a.c(guVar, 3);
            }
            PString pString = new PString();
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            long a = aUo.a(b, guVar.ptF, false, str3, c, str5, pString, pInt, pInt2);
            if (!a.b(guVar, 2, q2)) {
                ab.e("MicroMsg.BakOldItemImg", "writeItem MMBAK_IMG failed:%s", q);
            }
            if (a > 0) {
                biVar.jv(pString.value);
                biVar.hZ(pInt.value);
                biVar.ia(pInt2.value);
                if (j2 > 0) {
                    com.tencent.mm.at.e b2 = b.aUY().aUZ().aUo().b(Long.valueOf(a));
                    b2.lu((int) j2);
                    b.aUY().aUZ().aUo().a(Long.valueOf(a), b2);
                }
            } else {
                AppMethodBeat.o(17790);
                return -1;
            }
        }
        str2 = fI.fDB;
        if (str2 == null || !str2.startsWith("THUMBNAIL_DIRPATH://")) {
            biVar.jv("THUMBNAIL://" + fI.fDy);
        } else {
            biVar.jv(str2);
        }
        d.l(biVar);
        AppMethodBeat.o(17790);
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x0250  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x005a  */
    /* JADX WARNING: Missing block: B:39:0x01b7, code skipped:
            if (r0 != null) goto L_0x01b9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(gu guVar, bi biVar, LinkedList<u> linkedList) {
        int i;
        com.tencent.mm.at.e eVar;
        String I;
        AppMethodBeat.i(17788);
        if (bo.isNullOrNil(biVar.field_content)) {
            i = 0;
        } else {
            i = biVar.field_content.getBytes().length;
        }
        if (biVar.field_isSend == 1) {
            com.tencent.mm.at.e fJ = b.aUY().aUZ().aUo().fJ(biVar.field_msgId);
            if (fJ.fDy != 0) {
                eVar = fJ;
                I = b.aUY().aUZ().aUo().I(biVar.field_imgPath, true);
                if (com.tencent.mm.a.e.ct(I)) {
                    AppMethodBeat.o(17788);
                    return -1;
                }
                int a;
                i += i.a(new i.a(I, guVar, linkedList, 1, "_thumb"));
                Object obj;
                String q;
                if (biVar.field_isSend == 1) {
                    obj = "";
                    q = b.aUY().aUZ().aUo().q(eVar.fDz, "", "");
                    if (eVar.agQ()) {
                        eVar = b.aUY().aUZ().aUo().ly(eVar.fDJ);
                        if (eVar != null) {
                            obj = b.aUY().aUZ().aUo().q(eVar.fDz, "", "");
                            ab.d("MicroMsg.BakOldItemImg", "packet hd bigImgPath " + obj + " " + com.tencent.mm.a.e.cs(obj));
                            com.tencent.mm.a.e.cs(obj);
                            if (com.tencent.mm.a.e.ct(obj)) {
                                a = i.a(new i.a(obj, guVar, linkedList, 3, "_hd")) + i;
                            } else {
                                ab.e("MicroMsg.BakOldItemImg", "packet img.hasHdImg but hdbigImgPath has no file, hdbigImgPath:%s", obj);
                                a = i;
                            }
                            com.tencent.mm.a.e.cs(q);
                            if (!(bo.isNullOrNil(q) || q.equals(obj))) {
                                ab.d("MicroMsg.BakOldItemImg", "bigImgPath " + q + " " + com.tencent.mm.a.e.cs(q));
                                a += i.a(new i.a(q, guVar, linkedList, 2, false, null));
                            }
                        } else {
                            ab.e("MicroMsg.BakOldItemImg", "packet img.hasHdImg but img is null");
                        }
                    }
                    a = i;
                    com.tencent.mm.a.e.cs(q);
                    ab.d("MicroMsg.BakOldItemImg", "bigImgPath " + q + " " + com.tencent.mm.a.e.cs(q));
                    a += i.a(new i.a(q, guVar, linkedList, 2, false, null));
                } else if (eVar.agP()) {
                    q = b.aUY().aUZ().aUo().q(eVar.fDz, "", "");
                    String str = "";
                    if (eVar.agQ()) {
                        int i2;
                        if (eVar.agQ()) {
                            fJ = b.aUY().aUZ().aUo().ly(eVar.fDJ);
                        }
                        fJ = eVar;
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
                        ab.i(str2, str3, objArr);
                        if (fJ != null && fJ.fDC == 1) {
                            if (fJ.equals(eVar) || fJ.offset != fJ.frO) {
                                fJ.equals(eVar);
                            } else {
                                obj = b.aUY().aUZ().aUo().q(fJ.fDz, "", "");
                                ab.d("MicroMsg.BakOldItemImg", "packet hdPath:%s, fileLen[%d]", obj, Integer.valueOf(com.tencent.mm.a.e.cs(obj)));
                                if (com.tencent.mm.a.e.ct(obj)) {
                                    i += i.a(new i.a(obj, guVar, linkedList, 3, "_hd"));
                                    com.tencent.mm.a.e.cs(obj);
                                    a = i;
                                } else {
                                    a = i;
                                }
                                if (com.tencent.mm.a.e.ct(q)) {
                                    com.tencent.mm.a.e.cs(q);
                                    if (!(bo.isNullOrNil(q) || q.equals(r1))) {
                                        ab.d("MicroMsg.BakOldItemImg", "bigImgPath " + q + " " + com.tencent.mm.a.e.cs(q));
                                        a += i.a(new i.a(q, guVar, linkedList, 2, false, null));
                                    }
                                }
                            }
                        }
                    }
                    I = str;
                    a = i;
                    if (com.tencent.mm.a.e.ct(q)) {
                    }
                } else {
                    a = i;
                }
                String a2 = a(eVar, biVar);
                if (a2 == null) {
                    AppMethodBeat.o(17788);
                    return a;
                }
                guVar.vED = new bts().alV(a2);
                a += a2.length();
                AppMethodBeat.o(17788);
                return a;
            }
        }
        eVar = b.aUY().aUZ().aUo().fI(biVar.field_msgSvrId);
        I = b.aUY().aUZ().aUo().I(biVar.field_imgPath, true);
        if (com.tencent.mm.a.e.ct(I)) {
        }
    }
}
