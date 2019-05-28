package com.tencent.mm.at;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.al.c;
import com.tencent.mm.al.f;
import com.tencent.mm.g.c.cy;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.e;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.storage.bi;
import java.io.ByteArrayOutputStream;
import java.util.Map;

public final class h extends e {
    /* JADX WARNING: Removed duplicated region for block: B:27:0x01c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final bi a(cm cmVar, String str, String str2, String str3) {
        AppMethodBeat.i(78279);
        g ahl = o.ahl();
        cy a = super.a(cmVar, str, str2, str3);
        if (a.field_msgId != 0) {
            AppMethodBeat.o(78279);
            return a;
        }
        long j = cmVar.ptF;
        e fI = ahl.fI(j);
        if (fI.cKK == j) {
            com.tencent.mm.vfs.e.deleteFile(ahl.q(fI.fDz, "", ""));
            com.tencent.mm.vfs.e.deleteFile(ahl.q(fI.fDE, "", ""));
            com.tencent.mm.vfs.e.deleteFile(ahl.q(fI.fDB, "", ""));
            com.tencent.mm.vfs.e.deleteFile(ahl.q(fI.fDB, "", "") + "hd");
            ahl.fni.delete("ImgInfo2", "msgSvrId=?", new String[]{String.valueOf(j)});
            if (fI.agQ()) {
                fI = ahl.ly(fI.fDJ);
                if (fI != null) {
                    com.tencent.mm.vfs.e.deleteFile(ahl.q(fI.fDz, "", ""));
                    com.tencent.mm.vfs.e.deleteFile(ahl.q(fI.fDE, "", ""));
                    com.tencent.mm.vfs.e.deleteFile(ahl.q(fI.fDB, "", ""));
                    com.tencent.mm.vfs.e.deleteFile(ahl.q(fI.fDB, "", "") + "hd");
                    ahl.fni.delete("ImgInfo2", "id=?", new String[]{fI.fDy});
                }
            }
        }
        if (cmVar.vEE != 2) {
            ab.e("MicroMsg.ImgMsgExtension", "data type img, but has no imgstatus_hasimg ?!");
            AppMethodBeat.o(78279);
            return a;
        }
        byte[] bArr;
        byte[] a2 = aa.a(cmVar.vEF);
        if (ae.giF) {
            ab.w("MicroMsg.ImgMsgExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
            bArr = null;
        } else {
            bArr = a2;
        }
        Map z = br.z(a.field_content, "msg");
        long j2 = -1;
        if (!bo.isNullOrNil(a.field_content)) {
            Map z2;
            ab.i("MicroMsg.ImgMsgExtension", "cdntra content:[%s]", a.field_content);
            if (z == null) {
                com.tencent.mm.plugin.report.service.h.pYm.a(111, 190, 1, false);
            }
            if (z != null) {
                int i = bo.getInt((String) z.get(".msg.img.$hdlength"), 0);
                int i2 = bo.getInt((String) z.get(".msg.img.$tphdlength"), 0);
                if (i > 0) {
                    j = ahl.a(bArr, cmVar.ptF, true, a.field_content, new PString(), new PInt(), new PInt());
                } else if (i2 > 0) {
                    j = ahl.a(bArr, cmVar.ptF, true, a.field_content, new PString(), new PInt(), new PInt());
                }
                z2 = br.z(a.field_content, "msgoperation");
                if (z2 != null) {
                    a.jB((String) z2.get(".msgoperation.expinfo.expidstr"));
                    a.ie(bo.getInt((String) z2.get(".msgoperation.imagemsg.downloadcontroltype"), 0));
                    ab.i("MicroMsg.ImgMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", a.dJE, Integer.valueOf(a.dJF));
                }
                j2 = j;
            }
            j = -1;
            z2 = br.z(a.field_content, "msgoperation");
            if (z2 != null) {
            }
            j2 = j;
        }
        String str4 = (String) z.get(".msg.img.$tpthumburl");
        PString pString = new PString();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        j = ahl.a(bArr, cmVar.ptF, false, a.field_content, pString, pInt, pInt2);
        if (!(!bo.cb(bArr) || z == null || bo.isNullOrNil(str4))) {
            pInt.value = bo.getInt((String) z.get(".msg.img.$tpthumbwidth"), 0);
            pInt2.value = bo.getInt((String) z.get(".msg.img.$tpthumbheight"), 0);
        }
        if (j > 0) {
            a.jv(pString.value);
            a.hZ(pInt.value);
            a.ia(pInt2.value);
            if (j2 > 0) {
                fI = o.ahl().b(Long.valueOf(j));
                fI.lx(1);
                fI.lu((int) j2);
                o.ahl().a(Long.valueOf(j), fI);
            }
        }
        String str5;
        final int i3;
        final String q;
        final long j3;
        final long anU;
        final String str6;
        final cy cyVar;
        final String str7;
        final String str8;
        if (bo.cb(bArr) && z != null && !bo.isNullOrNil(str4)) {
            str5 = (String) z.get(".msg.img.$tpthumbaeskey");
            i3 = bo.getInt((String) z.get(".msg.img.tpthumblength"), 0);
            String str9 = (String) z.get(".msg.img.$tpauthkey");
            q = ahl.q(g.x(("SERVERID://" + a.field_msgSvrId).getBytes()), "th_", "");
            j3 = a.field_msgSvrId;
            ab.i("MicroMsg.ImgMsgExtension", "getThumbByCdn msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", Long.valueOf(j3), str, str4, q);
            anU = bo.anU();
            str6 = q + ".tmp";
            com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
            gVar.field_mediaId = c.a("downimgthumb", a.field_createTime, str, String.valueOf(j3));
            gVar.field_fullpath = str6;
            gVar.field_fileType = 19;
            gVar.field_aesKey = str5;
            gVar.field_authKey = str9;
            gVar.egm = str4;
            gVar.expectImageFormat = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.emoji.b.c.class)).bja() ? 2 : 1;
            cyVar = a;
            str7 = str;
            str8 = str4;
            gVar.egl = new a() {
                public final int a(String str, int i, com.tencent.mm.i.c cVar, d dVar, boolean z) {
                    AppMethodBeat.i(78277);
                    h.a(i, dVar, cyVar, str7, j3, q, str8, i3, anU, str6);
                    AppMethodBeat.o(78277);
                    return 0;
                }

                public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                }

                public final byte[] l(String str, byte[] bArr) {
                    return new byte[0];
                }
            };
            a.setStatus(4);
            f.afx().b(gVar, -1);
        } else if (bo.cb(bArr) && z != null) {
            str5 = (String) z.get(".msg.img.$cdnthumbaeskey");
            str8 = (String) z.get(".msg.img.$cdnthumburl");
            i3 = bo.getInt((String) z.get(".msg.img.$cdnthumblength"), 0);
            q = ahl.q(g.x(("SERVERID://" + a.field_msgSvrId).getBytes()), "th_", "");
            j3 = a.field_msgSvrId;
            ab.i("MicroMsg.ImgMsgExtension", "getThumbByCdn msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", Long.valueOf(j3), str, str8, q);
            anU = bo.anU();
            str6 = q + ".tmp";
            com.tencent.mm.i.g gVar2 = new com.tencent.mm.i.g();
            gVar2.field_mediaId = c.a("downimgthumb", a.field_createTime, str, String.valueOf(j3));
            gVar2.field_fullpath = str6;
            gVar2.field_fileType = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
            gVar2.field_totalLen = i3;
            gVar2.field_aesKey = str5;
            gVar2.field_fileId = str8;
            gVar2.field_priority = com.tencent.mm.i.a.efD;
            gVar2.field_chattype = t.kH(str) ? 1 : 0;
            gVar2.expectImageFormat = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.emoji.b.c.class)).bja() ? 2 : 1;
            ab.d("MicroMsg.ImgMsgExtension", "get thumb by cdn [image] chatType[%d] fromUser[%s] ", Integer.valueOf(gVar2.field_chattype), str);
            cyVar = a;
            str7 = str;
            gVar2.egl = new a() {
                public final int a(String str, int i, com.tencent.mm.i.c cVar, d dVar, boolean z) {
                    AppMethodBeat.i(78278);
                    h.a(i, dVar, cyVar, str7, j3, q, str8, i3, anU, str6);
                    AppMethodBeat.o(78278);
                    return 0;
                }

                public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                }

                public final byte[] l(String str, byte[] bArr) {
                    return null;
                }
            };
            a.setStatus(4);
            f.afx().b(gVar2, -1);
        }
        AppMethodBeat.o(78279);
        return a;
    }

    public static int a(int i, d dVar, bi biVar, String str, long j, String str2, String str3, int i2, long j2, String str4) {
        AppMethodBeat.i(78280);
        String r;
        if (i != 0) {
            ab.e("MicroMsg.ImgMsgExtension", "getThumbByCdn failed. startRet:%d msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", Integer.valueOf(i), Long.valueOf(j), str, str3, str2);
            biVar.setStatus(5);
            ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().b(biVar.field_msgSvrId, biVar);
            r = com.tencent.mm.plugin.report.a.r(Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(j2), Long.valueOf(bo.anU()), Integer.valueOf(c.bW(ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(i2), "");
            new com.tencent.mm.g.b.a.f(r).ajK();
            new com.tencent.mm.g.b.a.d(r).ajK();
            o.ahl().doNotify();
            AppMethodBeat.o(78280);
            return 0;
        } else if (dVar == null) {
            AppMethodBeat.o(78280);
            return 0;
        } else {
            if (dVar.field_retCode != 0) {
                ab.e("MicroMsg.ImgMsgExtension", "getThumbByCdn failed. sceneResult.field_retCode:%d msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", Integer.valueOf(dVar.field_retCode), Long.valueOf(j), str, str3, str2);
                biVar.setStatus(5);
                if (!bo.isNullOrNil(biVar.field_talker)) {
                    ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().b(biVar.field_msgSvrId, biVar);
                }
            } else {
                long j3;
                if (r.amp(str4)) {
                    String str5 = str2 + "_hevc";
                    com.tencent.mm.vfs.e.aQ(str4, str5);
                    if (!com.tencent.mm.vfs.e.ct(str2)) {
                        com.tencent.mm.vfs.e.atc(str2);
                    }
                    ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.emoji.b.c.class)).nativeWxam2Pic(str5, str2);
                } else {
                    com.tencent.mm.vfs.e.aQ(str4, str2);
                }
                biVar.setStatus(6);
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                com.tencent.mm.sdk.platformtools.d.c(str2, pInt, pInt2);
                biVar.hZ(pInt.value);
                biVar.ia(pInt2.value);
                ab.i("MicroMsg.ImgMsgExtension", "getThumbByCdn succ. sceneResult.field_retCode:%d msgSvrId:%d fromUser:%s thumb[%d,%d] thumbUrl:%s thumbPath:%s", Integer.valueOf(dVar.field_retCode), Long.valueOf(j), str, Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), str3, str2);
                if (!bo.isNullOrNil(biVar.field_talker)) {
                    ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().b(biVar.field_msgSvrId, biVar);
                }
                com.tencent.mm.plugin.report.service.h.pYm.a(198, 1, (long) i2, false);
                com.tencent.mm.plugin.report.service.h.pYm.a(198, 2, 1, false);
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                if (t.kH(str)) {
                    j3 = 4;
                } else {
                    j3 = 3;
                }
                hVar.a(198, j3, 1, false);
            }
            Object[] objArr = new Object[16];
            objArr[0] = Integer.valueOf(dVar == null ? i : dVar.field_retCode);
            objArr[1] = Integer.valueOf(2);
            objArr[2] = Long.valueOf(j2);
            objArr[3] = Long.valueOf(bo.anU());
            objArr[4] = Integer.valueOf(c.bW(ah.getContext()));
            objArr[5] = Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE);
            objArr[6] = Integer.valueOf(i2);
            objArr[7] = dVar == null ? "" : dVar.field_transInfo;
            objArr[8] = "";
            objArr[9] = "";
            objArr[10] = "";
            objArr[11] = "";
            objArr[12] = "";
            objArr[13] = "";
            objArr[14] = "";
            if (dVar == null) {
                r = "";
            } else {
                r = dVar.efY;
            }
            objArr[15] = r;
            new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.r(objArr)).ajK();
            if (!(dVar == null || dVar.field_retCode == 0)) {
                objArr = new Object[16];
                if (dVar != null) {
                    i = dVar.field_retCode;
                }
                objArr[0] = Integer.valueOf(i);
                objArr[1] = Integer.valueOf(2);
                objArr[2] = Long.valueOf(j2);
                objArr[3] = Long.valueOf(bo.anU());
                objArr[4] = Integer.valueOf(c.bW(ah.getContext()));
                objArr[5] = Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE);
                objArr[6] = Integer.valueOf(i2);
                objArr[7] = dVar == null ? "" : dVar.field_transInfo;
                objArr[8] = "";
                objArr[9] = "";
                objArr[10] = "";
                objArr[11] = "";
                objArr[12] = "";
                objArr[13] = "";
                objArr[14] = "";
                objArr[15] = dVar == null ? "" : dVar.efY;
                new com.tencent.mm.g.b.a.d(com.tencent.mm.plugin.report.a.r(objArr)).ajK();
            }
            o.ahl().doNotify();
            AppMethodBeat.o(78280);
            return 0;
        }
    }

    public final void a(com.tencent.mm.ai.e.c cVar) {
        AppMethodBeat.i(78281);
        o.ahl().x(cVar.cKd);
        AppMethodBeat.o(78281);
    }
}
