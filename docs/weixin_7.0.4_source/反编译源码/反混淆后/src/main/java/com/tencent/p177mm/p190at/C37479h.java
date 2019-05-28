package com.tencent.p177mm.p190at;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C42194e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1201e.C1199c;
import com.tencent.p177mm.p187al.C37458c;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p230g.p232b.p233a.C42099d;
import com.tencent.p177mm.p230g.p232b.p233a.C9514f;
import com.tencent.p177mm.p230g.p711c.C6575cy;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.emoji.p725b.C27730c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import java.io.ByteArrayOutputStream;
import java.util.Map;

/* renamed from: com.tencent.mm.at.h */
public final class C37479h extends C42194e {
    /* JADX WARNING: Removed duplicated region for block: B:27:0x01c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final C7620bi mo43844a(C7254cm c7254cm, String str, String str2, String str3) {
        AppMethodBeat.m2504i(78279);
        C45160g ahl = C32291o.ahl();
        C6575cy a = super.mo43844a(c7254cm, str, str2, str3);
        if (a.field_msgId != 0) {
            AppMethodBeat.m2505o(78279);
            return a;
        }
        long j = c7254cm.ptF;
        C25822e fI = ahl.mo73112fI(j);
        if (fI.cKK == j) {
            C5730e.deleteFile(ahl.mo73118q(fI.fDz, "", ""));
            C5730e.deleteFile(ahl.mo73118q(fI.fDE, "", ""));
            C5730e.deleteFile(ahl.mo73118q(fI.fDB, "", ""));
            C5730e.deleteFile(ahl.mo73118q(fI.fDB, "", "") + "hd");
            ahl.fni.delete("ImgInfo2", "msgSvrId=?", new String[]{String.valueOf(j)});
            if (fI.agQ()) {
                fI = ahl.mo73116ly(fI.fDJ);
                if (fI != null) {
                    C5730e.deleteFile(ahl.mo73118q(fI.fDz, "", ""));
                    C5730e.deleteFile(ahl.mo73118q(fI.fDE, "", ""));
                    C5730e.deleteFile(ahl.mo73118q(fI.fDB, "", ""));
                    C5730e.deleteFile(ahl.mo73118q(fI.fDB, "", "") + "hd");
                    ahl.fni.delete("ImgInfo2", "id=?", new String[]{fI.fDy});
                }
            }
        }
        if (c7254cm.vEE != 2) {
            C4990ab.m7412e("MicroMsg.ImgMsgExtension", "data type img, but has no imgstatus_hasimg ?!");
            AppMethodBeat.m2505o(78279);
            return a;
        }
        byte[] bArr;
        byte[] a2 = C1946aa.m4150a(c7254cm.vEF);
        if (C1947ae.giF) {
            C4990ab.m7420w("MicroMsg.ImgMsgExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
            bArr = null;
        } else {
            bArr = a2;
        }
        Map z = C5049br.m7595z(a.field_content, "msg");
        long j2 = -1;
        if (!C5046bo.isNullOrNil(a.field_content)) {
            Map z2;
            C4990ab.m7417i("MicroMsg.ImgMsgExtension", "cdntra content:[%s]", a.field_content);
            if (z == null) {
                C7060h.pYm.mo8378a(111, 190, 1, false);
            }
            if (z != null) {
                int i = C5046bo.getInt((String) z.get(".msg.img.$hdlength"), 0);
                int i2 = C5046bo.getInt((String) z.get(".msg.img.$tphdlength"), 0);
                if (i > 0) {
                    j = ahl.mo73082a(bArr, c7254cm.ptF, true, a.field_content, new PString(), new PInt(), new PInt());
                } else if (i2 > 0) {
                    j = ahl.mo73082a(bArr, c7254cm.ptF, true, a.field_content, new PString(), new PInt(), new PInt());
                }
                z2 = C5049br.m7595z(a.field_content, "msgoperation");
                if (z2 != null) {
                    a.mo14793jB((String) z2.get(".msgoperation.expinfo.expidstr"));
                    a.mo14790ie(C5046bo.getInt((String) z2.get(".msgoperation.imagemsg.downloadcontroltype"), 0));
                    C4990ab.m7417i("MicroMsg.ImgMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", a.dJE, Integer.valueOf(a.dJF));
                }
                j2 = j;
            }
            j = -1;
            z2 = C5049br.m7595z(a.field_content, "msgoperation");
            if (z2 != null) {
            }
            j2 = j;
        }
        String str4 = (String) z.get(".msg.img.$tpthumburl");
        PString pString = new PString();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        j = ahl.mo73082a(bArr, c7254cm.ptF, false, a.field_content, pString, pInt, pInt2);
        if (!(!C5046bo.m7540cb(bArr) || z == null || C5046bo.isNullOrNil(str4))) {
            pInt.value = C5046bo.getInt((String) z.get(".msg.img.$tpthumbwidth"), 0);
            pInt2.value = C5046bo.getInt((String) z.get(".msg.img.$tpthumbheight"), 0);
        }
        if (j > 0) {
            a.mo14795jv(pString.value);
            a.mo14784hZ(pInt.value);
            a.mo14786ia(pInt2.value);
            if (j2 > 0) {
                fI = C32291o.ahl().mo73105b(Long.valueOf(j));
                fI.mo43801lx(1);
                fI.mo43798lu((int) j2);
                C32291o.ahl().mo73077a(Long.valueOf(j), fI);
            }
        }
        String str5;
        final int i3;
        final String q;
        final long j3;
        final long anU;
        final String str6;
        final C6575cy c6575cy;
        final String str7;
        final String str8;
        if (C5046bo.m7540cb(bArr) && z != null && !C5046bo.isNullOrNil(str4)) {
            str5 = (String) z.get(".msg.img.$tpthumbaeskey");
            i3 = C5046bo.getInt((String) z.get(".msg.img.tpthumblength"), 0);
            String str9 = (String) z.get(".msg.img.$tpauthkey");
            q = ahl.mo73118q(C1178g.m2591x(("SERVERID://" + a.field_msgSvrId).getBytes()), "th_", "");
            j3 = a.field_msgSvrId;
            C4990ab.m7417i("MicroMsg.ImgMsgExtension", "getThumbByCdn msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", Long.valueOf(j3), str, str4, q);
            anU = C5046bo.anU();
            str6 = q + ".tmp";
            C42130g c42130g = new C42130g();
            c42130g.field_mediaId = C37458c.m63162a("downimgthumb", a.field_createTime, str, String.valueOf(j3));
            c42130g.field_fullpath = str6;
            c42130g.field_fileType = 19;
            c42130g.field_aesKey = str5;
            c42130g.field_authKey = str9;
            c42130g.egm = str4;
            c42130g.expectImageFormat = ((C27730c) C1720g.m3528K(C27730c.class)).bja() ? 2 : 1;
            c6575cy = a;
            str7 = str;
            str8 = str4;
            c42130g.egl = new C1628a() {
                /* renamed from: a */
                public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
                    AppMethodBeat.m2504i(78277);
                    C37479h.m63231a(i, c9545d, c6575cy, str7, j3, q, str8, i3, anU, str6);
                    AppMethodBeat.m2505o(78277);
                    return 0;
                }

                /* renamed from: a */
                public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                }

                /* renamed from: l */
                public final byte[] mo5084l(String str, byte[] bArr) {
                    return new byte[0];
                }
            };
            a.setStatus(4);
            C37461f.afx().mo51222b(c42130g, -1);
        } else if (C5046bo.m7540cb(bArr) && z != null) {
            str5 = (String) z.get(".msg.img.$cdnthumbaeskey");
            str8 = (String) z.get(".msg.img.$cdnthumburl");
            i3 = C5046bo.getInt((String) z.get(".msg.img.$cdnthumblength"), 0);
            q = ahl.mo73118q(C1178g.m2591x(("SERVERID://" + a.field_msgSvrId).getBytes()), "th_", "");
            j3 = a.field_msgSvrId;
            C4990ab.m7417i("MicroMsg.ImgMsgExtension", "getThumbByCdn msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", Long.valueOf(j3), str, str8, q);
            anU = C5046bo.anU();
            str6 = q + ".tmp";
            C42130g c42130g2 = new C42130g();
            c42130g2.field_mediaId = C37458c.m63162a("downimgthumb", a.field_createTime, str, String.valueOf(j3));
            c42130g2.field_fullpath = str6;
            c42130g2.field_fileType = C42129a.MediaType_THUMBIMAGE;
            c42130g2.field_totalLen = i3;
            c42130g2.field_aesKey = str5;
            c42130g2.field_fileId = str8;
            c42130g2.field_priority = C42129a.efD;
            c42130g2.field_chattype = C1855t.m3896kH(str) ? 1 : 0;
            c42130g2.expectImageFormat = ((C27730c) C1720g.m3528K(C27730c.class)).bja() ? 2 : 1;
            C4990ab.m7411d("MicroMsg.ImgMsgExtension", "get thumb by cdn [image] chatType[%d] fromUser[%s] ", Integer.valueOf(c42130g2.field_chattype), str);
            c6575cy = a;
            str7 = str;
            c42130g2.egl = new C1628a() {
                /* renamed from: a */
                public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
                    AppMethodBeat.m2504i(78278);
                    C37479h.m63231a(i, c9545d, c6575cy, str7, j3, q, str8, i3, anU, str6);
                    AppMethodBeat.m2505o(78278);
                    return 0;
                }

                /* renamed from: a */
                public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                }

                /* renamed from: l */
                public final byte[] mo5084l(String str, byte[] bArr) {
                    return null;
                }
            };
            a.setStatus(4);
            C37461f.afx().mo51222b(c42130g2, -1);
        }
        AppMethodBeat.m2505o(78279);
        return a;
    }

    /* renamed from: a */
    public static int m63231a(int i, C9545d c9545d, C7620bi c7620bi, String str, long j, String str2, String str3, int i2, long j2, String str4) {
        AppMethodBeat.m2504i(78280);
        String r;
        if (i != 0) {
            C4990ab.m7413e("MicroMsg.ImgMsgExtension", "getThumbByCdn failed. startRet:%d msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", Integer.valueOf(i), Long.valueOf(j), str, str3, str2);
            c7620bi.setStatus(5);
            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15302b(c7620bi.field_msgSvrId, c7620bi);
            r = C46180a.m86311r(Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(j2), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(C42129a.MediaType_THUMBIMAGE), Integer.valueOf(i2), "");
            new C9514f(r).ajK();
            new C42099d(r).ajK();
            C32291o.ahl().doNotify();
            AppMethodBeat.m2505o(78280);
            return 0;
        } else if (c9545d == null) {
            AppMethodBeat.m2505o(78280);
            return 0;
        } else {
            if (c9545d.field_retCode != 0) {
                C4990ab.m7413e("MicroMsg.ImgMsgExtension", "getThumbByCdn failed. sceneResult.field_retCode:%d msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", Integer.valueOf(c9545d.field_retCode), Long.valueOf(j), str, str3, str2);
                c7620bi.setStatus(5);
                if (!C5046bo.isNullOrNil(c7620bi.field_talker)) {
                    ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15302b(c7620bi.field_msgSvrId, c7620bi);
                }
            } else {
                long j3;
                if (C5063r.amp(str4)) {
                    String str5 = str2 + "_hevc";
                    C5730e.m8623aQ(str4, str5);
                    if (!C5730e.m8628ct(str2)) {
                        C5730e.atc(str2);
                    }
                    ((C27730c) C1720g.m3528K(C27730c.class)).nativeWxam2Pic(str5, str2);
                } else {
                    C5730e.m8623aQ(str4, str2);
                }
                c7620bi.setStatus(6);
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                C5056d.m7655c(str2, pInt, pInt2);
                c7620bi.mo14784hZ(pInt.value);
                c7620bi.mo14786ia(pInt2.value);
                C4990ab.m7417i("MicroMsg.ImgMsgExtension", "getThumbByCdn succ. sceneResult.field_retCode:%d msgSvrId:%d fromUser:%s thumb[%d,%d] thumbUrl:%s thumbPath:%s", Integer.valueOf(c9545d.field_retCode), Long.valueOf(j), str, Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), str3, str2);
                if (!C5046bo.isNullOrNil(c7620bi.field_talker)) {
                    ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15302b(c7620bi.field_msgSvrId, c7620bi);
                }
                C7060h.pYm.mo8378a(198, 1, (long) i2, false);
                C7060h.pYm.mo8378a(198, 2, 1, false);
                C7060h c7060h = C7060h.pYm;
                if (C1855t.m3896kH(str)) {
                    j3 = 4;
                } else {
                    j3 = 3;
                }
                c7060h.mo8378a(198, j3, 1, false);
            }
            Object[] objArr = new Object[16];
            objArr[0] = Integer.valueOf(c9545d == null ? i : c9545d.field_retCode);
            objArr[1] = Integer.valueOf(2);
            objArr[2] = Long.valueOf(j2);
            objArr[3] = Long.valueOf(C5046bo.anU());
            objArr[4] = Integer.valueOf(C37458c.m63165bW(C4996ah.getContext()));
            objArr[5] = Integer.valueOf(C42129a.MediaType_THUMBIMAGE);
            objArr[6] = Integer.valueOf(i2);
            objArr[7] = c9545d == null ? "" : c9545d.field_transInfo;
            objArr[8] = "";
            objArr[9] = "";
            objArr[10] = "";
            objArr[11] = "";
            objArr[12] = "";
            objArr[13] = "";
            objArr[14] = "";
            if (c9545d == null) {
                r = "";
            } else {
                r = c9545d.efY;
            }
            objArr[15] = r;
            new C9514f(C46180a.m86311r(objArr)).ajK();
            if (!(c9545d == null || c9545d.field_retCode == 0)) {
                objArr = new Object[16];
                if (c9545d != null) {
                    i = c9545d.field_retCode;
                }
                objArr[0] = Integer.valueOf(i);
                objArr[1] = Integer.valueOf(2);
                objArr[2] = Long.valueOf(j2);
                objArr[3] = Long.valueOf(C5046bo.anU());
                objArr[4] = Integer.valueOf(C37458c.m63165bW(C4996ah.getContext()));
                objArr[5] = Integer.valueOf(C42129a.MediaType_THUMBIMAGE);
                objArr[6] = Integer.valueOf(i2);
                objArr[7] = c9545d == null ? "" : c9545d.field_transInfo;
                objArr[8] = "";
                objArr[9] = "";
                objArr[10] = "";
                objArr[11] = "";
                objArr[12] = "";
                objArr[13] = "";
                objArr[14] = "";
                objArr[15] = c9545d == null ? "" : c9545d.efY;
                new C42099d(C46180a.m86311r(objArr)).ajK();
            }
            C32291o.ahl().doNotify();
            AppMethodBeat.m2505o(78280);
            return 0;
        }
    }

    /* renamed from: a */
    public final void mo4452a(C1199c c1199c) {
        AppMethodBeat.m2504i(78281);
        C32291o.ahl().mo73125x(c1199c.cKd);
        AppMethodBeat.m2505o(78281);
    }
}
