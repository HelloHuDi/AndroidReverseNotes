package com.tencent.p177mm.pluginsdk.model.app;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.p177mm.opensdk.modelmsg.WXDesignerSharedObject;
import com.tencent.p177mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.p177mm.opensdk.modelmsg.WXEmojiPageSharedObject;
import com.tencent.p177mm.opensdk.modelmsg.WXEmojiSharedObject;
import com.tencent.p177mm.opensdk.modelmsg.WXFileObject;
import com.tencent.p177mm.opensdk.modelmsg.WXImageObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.p177mm.opensdk.modelmsg.WXTextObject;
import com.tencent.p177mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.p177mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.p177mm.p181af.C41728a;
import com.tencent.p177mm.p181af.C8909j;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C32231g;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.p185a.C25754e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p230g.p231a.C45373tq;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.p177mm.plugin.appbrand.service.C42686d;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.record.p492b.C43430c;
import com.tencent.p177mm.plugin.record.p492b.C43432e;
import com.tencent.p177mm.pluginsdk.model.app.C30061al.C30062a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import com.tencent.ttpic.util.VideoFilterUtil;
import java.io.IOException;

/* renamed from: com.tencent.mm.pluginsdk.model.app.l */
public final class C4733l {
    private static C43432e pJg;

    /* renamed from: com.tencent.mm.pluginsdk.model.app.l$a */
    public interface C4734a {
        /* renamed from: gK */
        void mo9875gK(int i, int i2);
    }

    public static boolean aiK(String str) {
        AppMethodBeat.m2504i(27324);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(27324);
            return false;
        } else if (str.equals("0:0")) {
            AppMethodBeat.m2505o(27324);
            return false;
        } else {
            AppMethodBeat.m2505o(27324);
            return true;
        }
    }

    /* renamed from: jC */
    public static void m7104jC(long j) {
        AppMethodBeat.m2504i(27325);
        C14877am.aUq().mo48328lY(j);
        C30065b c30065b = new C30065b();
        C14877am.aUq().mo16761b(j, (C4925c) c30065b);
        if (c30065b.field_msgInfoId <= 0) {
            AppMethodBeat.m2505o(27325);
            return;
        }
        C9638aw.m17190ZK();
        C7620bi jf = C18628c.m29080XO().mo15340jf(c30065b.field_msgInfoId);
        if (jf.field_msgId != c30065b.field_msgInfoId) {
            AppMethodBeat.m2505o(27325);
            return;
        }
        jf.setStatus(5);
        C9638aw.m17190ZK();
        C18628c.m29080XO().mo15284a(jf.field_msgId, jf);
        AppMethodBeat.m2505o(27325);
    }

    public static int aiL(String str) {
        AppMethodBeat.m2504i(27326);
        C8910b me = C8910b.m16064me(str);
        if (me == null) {
            AppMethodBeat.m2505o(27326);
            return -1;
        } else if (C4733l.aiK(me.csD)) {
            C30065b c30065b = new C30065b();
            long j = C5046bo.getLong(me.csD, -1);
            if (j != -1) {
                C14877am.aUq().mo16761b(j, (C4925c) c30065b);
                if (c30065b.xDa != j) {
                    c30065b = C14877am.aUq().aiE(me.csD);
                    if (c30065b == null || !c30065b.field_mediaSvrId.equals(me.csD)) {
                        AppMethodBeat.m2505o(27326);
                        return -1;
                    }
                }
            }
            c30065b = C14877am.aUq().aiE(me.csD);
            if (c30065b == null || !c30065b.field_mediaSvrId.equals(me.csD)) {
                AppMethodBeat.m2505o(27326);
                return -1;
            }
            if (c30065b.field_totalLen == 0) {
                AppMethodBeat.m2505o(27326);
                return -1;
            }
            int i = (int) ((c30065b.field_offset * 100) / c30065b.field_totalLen);
            AppMethodBeat.m2505o(27326);
            return i;
        } else {
            AppMethodBeat.m2505o(27326);
            return -1;
        }
    }

    /* renamed from: s */
    public static String m7105s(long j, String str) {
        AppMethodBeat.m2504i(27327);
        C4990ab.m7417i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach msgLocalId[%d], msgXml[%s], downloadPath[%s]", Long.valueOf(j), str, null);
        C8910b me = C8910b.m16064me(str);
        if (me == null) {
            AppMethodBeat.m2505o(27327);
            return null;
        }
        String X = C4733l.m7083X(C6457e.euQ, me.title, me.fgp);
        if (C5046bo.isNullOrNil(me.csD) && !C5046bo.isNullOrNil(me.fgD)) {
            me.csD = me.fgD.hashCode();
        }
        String a = C4733l.m7094a(X, j, me.sdkVer, me.appId, me.csD, me.fgo, me.type, me.fgs);
        AppMethodBeat.m2505o(27327);
        return a;
    }

    /* renamed from: a */
    public static boolean m7096a(C7620bi c7620bi, C30065b c30065b) {
        AppMethodBeat.m2504i(27329);
        if (c30065b == null || !C5730e.m8628ct(c30065b.field_fileFullPath)) {
            AppMethodBeat.m2505o(27329);
            return false;
        } else if (c30065b.bCR() || (c7620bi.field_isSend == 1 && c30065b.field_isUpload)) {
            AppMethodBeat.m2505o(27329);
            return true;
        } else {
            AppMethodBeat.m2505o(27329);
            return false;
        }
    }

    /* renamed from: d */
    public static boolean m7102d(String str, C7620bi c7620bi) {
        AppMethodBeat.m2504i(27330);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(27330);
            return false;
        }
        boolean z = true;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        C30065b i = C4733l.m7103i(str, c7620bi.field_msgId);
        C8910b me = C8910b.m16064me(c7620bi.field_content);
        if (me != null) {
            str2 = C42252ah.nullAsNil(me.title);
            str3 = C42252ah.nullAsNil(me.fgp).toLowerCase();
            str4 = C42252ah.nullAsNil(me.filemd5);
            str5 = C42252ah.nullAsNil(me.cEV);
            str6 = C42252ah.nullAsNil(me.eyr);
        }
        String str7;
        if (i == null) {
            C4733l.m7105s(c7620bi.field_msgId, c7620bi.field_content);
            i = C4733l.m7103i(str, c7620bi.field_msgId);
            if (i != null) {
                str7 = "MicroMsg.AppMsgLogic";
                String str8 = "summerbig tryInitAttachInfo newInfo systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], signature len[%d]";
                Object[] objArr = new Object[8];
                objArr[0] = Long.valueOf(i.xDa);
                objArr[1] = Long.valueOf(i.field_totalLen);
                objArr[2] = i.field_fileFullPath;
                objArr[3] = Long.valueOf(i.field_type);
                objArr[4] = i.field_mediaId;
                objArr[5] = Long.valueOf(i.field_msgInfoId);
                objArr[6] = Boolean.valueOf(i.field_isUpload);
                objArr[7] = Integer.valueOf(i.field_signature == null ? -1 : i.field_signature.length());
                C4990ab.m7417i(str7, str8, objArr);
                if (me != null && (me.fgs != 0 || me.fgo > 26214400)) {
                    boolean z2;
                    if (C42252ah.isNullOrNil(i.field_signature)) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    z = z2;
                }
            }
        } else {
            C5728b c5728b = new C5728b(i.field_fileFullPath);
            if (i.field_status == 199 && !c5728b.exists()) {
                C4990ab.m7416i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist but file not!");
                C4733l.m7105s(c7620bi.field_msgId, c7620bi.field_content);
            }
            String str9 = "MicroMsg.AppMsgLogic";
            str7 = "summerbig tryInitAttachInfo info exist systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], file.exists[%b], status[%d], signature len[%d]";
            Object[] objArr2 = new Object[10];
            objArr2[0] = Long.valueOf(i.xDa);
            objArr2[1] = Long.valueOf(i.field_totalLen);
            objArr2[2] = i.field_fileFullPath;
            objArr2[3] = Long.valueOf(i.field_type);
            objArr2[4] = i.field_mediaId;
            objArr2[5] = Long.valueOf(i.field_msgInfoId);
            objArr2[6] = Boolean.valueOf(i.field_isUpload);
            objArr2[7] = Boolean.valueOf(c5728b.exists());
            objArr2[8] = Long.valueOf(i.field_status);
            objArr2[9] = Integer.valueOf(i.field_signature == null ? -1 : i.field_signature.length());
            C4990ab.m7417i(str9, str7, objArr2);
        }
        if (!z) {
            C9638aw.m17182Rg().mo14541a(new C43430c(i, str6, str4, str2, str3, str5), 0);
        }
        AppMethodBeat.m2505o(27330);
        return z;
    }

    /* renamed from: i */
    public static C30065b m7103i(String str, long j) {
        AppMethodBeat.m2504i(27331);
        C30065b aiM = C4733l.aiM(str);
        if (aiM == null) {
            aiM = C14877am.aUq().mo48329lZ(j);
        }
        if (aiM != null) {
            C4990ab.m7417i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo info[%s], rowid[%d], isUpload[%b], fullpath[%s], totallen[%d], offset[%d], mediaSvrId[%s], mediaid[%s], msgid[%d], type[%d], stack[%s]", aiM, Long.valueOf(aiM.xDa), Boolean.valueOf(aiM.field_isUpload), aiM.field_fileFullPath, Long.valueOf(aiM.field_totalLen), Long.valueOf(aiM.field_offset), aiM.field_mediaSvrId, aiM.field_mediaId, Long.valueOf(aiM.field_msgInfoId), Long.valueOf(aiM.field_type), C42252ah.anW());
        } else {
            C4990ab.m7421w("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo is null stack[%s]", C42252ah.anW());
        }
        AppMethodBeat.m2505o(27331);
        return aiM;
    }

    /* renamed from: a */
    public static String m7094a(String str, long j, int i, String str2, String str3, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(27332);
        C30065b c30065b = new C30065b();
        c30065b.field_fileFullPath = str;
        c30065b.field_appId = str2;
        c30065b.field_sdkVer = (long) i;
        c30065b.field_mediaSvrId = str3;
        c30065b.field_totalLen = (long) i2;
        c30065b.field_status = 101;
        c30065b.field_isUpload = false;
        c30065b.field_createTime = C5046bo.anU();
        c30065b.field_lastModifyTime = C5046bo.anT();
        c30065b.field_msgInfoId = j;
        c30065b.field_netTimes = 0;
        c30065b.field_type = (long) i3;
        C4990ab.m7417i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach ret[%b], rowid[%d], field_totalLen[%d], type[%d], isLargeFile[%d], destFile[%s], stack[%s]", Boolean.valueOf(C14877am.aUq().mo10101b((C4925c) c30065b)), Long.valueOf(c30065b.xDa), Long.valueOf(c30065b.field_totalLen), Long.valueOf(c30065b.field_type), Integer.valueOf(i4), str, C5046bo.dpG());
        AppMethodBeat.m2505o(27332);
        return str3;
    }

    /* renamed from: a */
    public static C30065b m7092a(String str, long j, int i, String str2, String str3, int i2) {
        AppMethodBeat.m2504i(27333);
        C30065b c30065b = new C30065b();
        c30065b.field_fileFullPath = str;
        c30065b.field_appId = str2;
        c30065b.field_sdkVer = (long) i;
        c30065b.field_mediaSvrId = str3;
        c30065b.field_totalLen = (long) i2;
        c30065b.field_status = 101;
        c30065b.field_isUpload = false;
        c30065b.field_createTime = C5046bo.anU();
        c30065b.field_lastModifyTime = C5046bo.anT();
        c30065b.field_msgInfoId = j;
        c30065b.field_netTimes = 0;
        AppMethodBeat.m2505o(27333);
        return c30065b;
    }

    /* renamed from: a */
    public static C30065b m7093a(String str, C8910b c8910b, String str2) {
        AppMethodBeat.m2504i(27334);
        C4990ab.m7416i("MicroMsg.AppMsgLogic", C1447g.m3075Mq() + " summerbig buildUploadAttachInfo clientAppDataId:" + str + " attach file :" + str2);
        if (str2.replace("//", "/").startsWith(C6457e.eSi)) {
            C4990ab.m7413e("MicroMsg.AppMsgLogic", "summerbig Error attach path:%s", str2.replace("//", "/"));
            AppMethodBeat.m2505o(27334);
            return null;
        }
        C30065b c30065b = new C30065b();
        c30065b.field_totalLen = (long) c8910b.fgo;
        c30065b.field_fileFullPath = str2;
        c30065b.field_sdkVer = (long) c8910b.sdkVer;
        c30065b.field_appId = c8910b.appId;
        c30065b.field_clientAppDataId = str;
        c30065b.field_type = (long) c8910b.type;
        c30065b.field_status = 200;
        c30065b.field_isUpload = true;
        c30065b.field_createTime = C5046bo.anU();
        c30065b.field_lastModifyTime = C5046bo.anT();
        c30065b.field_mediaSvrId = C5046bo.anU();
        C14877am.aUq().mo10101b((C4925c) c30065b);
        C4990ab.m7410d("MicroMsg.AppMsgLogic", C1447g.m3075Mq() + " summerbig buildUploadAttachInfo file:" + c30065b.field_fileFullPath + " rowid:" + c30065b.xDa + " clientAppDataId:" + c30065b.field_clientAppDataId);
        if (c30065b.xDa < 0) {
            C4990ab.m7412e("MicroMsg.AppMsgLogic", C1447g.m3075Mq() + " summerbig uploadAttach insert appattach info failed :" + c30065b.xDa);
            AppMethodBeat.m2505o(27334);
            return null;
        }
        AppMethodBeat.m2505o(27334);
        return c30065b;
    }

    /* renamed from: a */
    public static int m7084a(long j, String str, C9545d c9545d) {
        AppMethodBeat.m2504i(27335);
        C9638aw.m17190ZK();
        C7620bi jf = C18628c.m29080XO().mo15340jf(j);
        int line;
        if (jf.field_msgId != j) {
            C4990ab.m7412e("MicroMsg.AppMsgLogic", C1447g.m3075Mq() + " getmsgFailed id:" + j);
            line = 0 - C1447g.getLine();
            AppMethodBeat.m2505o(27335);
            return line;
        }
        C8910b me = C8910b.m16064me(jf.field_content);
        if (me == null) {
            C4990ab.m7412e("MicroMsg.AppMsgLogic", C1447g.m3075Mq() + " getmsgFailed id:" + j);
            line = 0 - C1447g.getLine();
            AppMethodBeat.m2505o(27335);
            return line;
        }
        me.csD = str;
        if (c9545d != null) {
            me.eyr = c9545d.field_aesKey == "" ? me.eyr : c9545d.field_aesKey;
            me.fgD = c9545d.field_fileId == "" ? me.fgD : c9545d.field_fileId;
            me.filemd5 = c9545d.field_filemd5 == "" ? me.filemd5 : c9545d.field_filemd5;
            me.fgo = c9545d.field_fileLength == 0 ? me.fgo : c9545d.field_fileLength;
            me.fgE = c9545d.field_thumbUrl == "" ? me.fgE : c9545d.field_thumbUrl;
        }
        jf.setContent(C8910b.m16061a(me, me.csD, c9545d));
        C9638aw.m17190ZK();
        C18628c.m29080XO().mo15284a(jf.field_msgId, jf);
        C8909j ma = C14877am.dhN().mo27204ma(j);
        if (ma != null) {
            ma.field_xml = jf.field_content;
            C14877am.dhN().mo10103c(ma, "msgId");
        }
        C30065b lZ = C14877am.aUq().mo48329lZ(j);
        lZ.field_mediaSvrId = str;
        lZ.field_offset = lZ.field_totalLen;
        C14877am.aUq().mo48326a(lZ, new String[0]);
        AppMethodBeat.m2505o(27335);
        return 0;
    }

    /* renamed from: a */
    public static int m7087a(C8910b c8910b, String str, String str2, String str3, String str4, byte[] bArr) {
        AppMethodBeat.m2504i(27336);
        int a = C4733l.m7088a(c8910b, str, str2, str3, str4, bArr, null);
        AppMethodBeat.m2505o(27336);
        return a;
    }

    /* renamed from: a */
    public static int m7088a(C8910b c8910b, String str, String str2, String str3, String str4, byte[] bArr, String str5) {
        AppMethodBeat.m2504i(27337);
        int a = C4733l.m7089a(c8910b, str, str2, str3, str4, bArr, str5, "");
        AppMethodBeat.m2505o(27337);
        return a;
    }

    /* renamed from: X */
    public static String m7083X(String str, String str2, String str3) {
        String str4;
        int i = 1;
        AppMethodBeat.m2504i(27338);
        C5728b c5728b = new C5728b(str);
        if (!c5728b.exists()) {
            c5728b.mkdirs();
        }
        if (C5046bo.isNullOrNil(str2)) {
            str4 = str + "da_" + C5046bo.anU();
            if (!C5046bo.isNullOrNil(str3)) {
                str4 = str4 + "." + str3;
            }
        } else {
            if (!(C5046bo.isNullOrNil(str3) || str2.endsWith(str3))) {
                str2 = str2 + "." + str3;
            }
            str4 = str + str2;
            if (C5730e.m8628ct(str4)) {
                while (i < 20) {
                    if (!C5730e.m8628ct(str + i + "_" + str2)) {
                        str4 = str + i + "_" + str2;
                        break;
                    }
                    i++;
                }
                if (i == 20) {
                    str4 = str + "da_" + C5046bo.anU();
                    if (!C5046bo.isNullOrNil(str3)) {
                        str4 = str4 + "." + str3;
                    }
                }
            }
        }
        try {
            if (!C5736j.m8649w(new C5728b(str4).dMC().dMD()).equalsIgnoreCase(C5736j.m8649w(new C5728b(str).dMD()))) {
                str4 = str + "da_" + C5046bo.anU();
                C4990ab.m7421w("MicroMsg.AppMsgLogic", "maybe DirTraversal attach. %s", str4);
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AppMsgLogic", e, "", new Object[0]);
            str4 = str + "da_" + C5046bo.anU();
            if (!C5046bo.isNullOrNil(str3)) {
                str4 = str4 + "." + str3;
            }
        }
        AppMethodBeat.m2505o(27338);
        return str4;
    }

    /* renamed from: a */
    public static int m7089a(C8910b c8910b, String str, String str2, String str3, String str4, byte[] bArr, String str5, String str6) {
        C30065b c30065b;
        int line;
        AppMethodBeat.m2504i(27339);
        C4990ab.m7417i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg attachFilePath[%s], content[%s]", str4, c8910b);
        String str7 = System.currentTimeMillis();
        if (C5046bo.isNullOrNil(str4)) {
            c30065b = null;
        } else {
            C30065b a = C4733l.m7093a(str7, c8910b, str4);
            if (a == null) {
                line = 0 - C1447g.getLine();
                AppMethodBeat.m2505o(27339);
                return line;
            }
            c30065b = a;
        }
        C7620bi c7620bi = new C7620bi();
        if (bArr != null && bArr.length > 0) {
            String a2;
            if (c8910b.type == 33 || c8910b.type == 36 || c8910b.type == 44) {
                int i = (int) (C5056d.anS().density * 240.0f);
                int i2 = (int) (C5056d.anS().density * 240.0f);
                C41728a c41728a = (C41728a) c8910b.mo20333X(C41728a.class);
                String str8 = c41728a != null ? c41728a.ffl : "";
                boolean z = c41728a != null ? c41728a.ffm : false;
                Object obj = ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_wxa_share_is_use_new, 0) == 1 ? 1 : null;
                if (C5058f.IS_FLAVOR_RED || obj != null) {
                    a2 = C32291o.ahl().mo73093a(bArr, CompressFormat.JPEG, str8, z);
                } else {
                    a2 = C32291o.ahl().mo73092a(bArr, CompressFormat.JPEG, i, i2, str8, z);
                }
            } else if (c8910b.type == 46) {
                a2 = C32291o.ahl().mo73091a(bArr, CompressFormat.JPEG);
            } else {
                a2 = C32291o.ahl().mo73094a(bArr, c8910b.type == 2, CompressFormat.PNG);
            }
            C4990ab.m7410d("MicroMsg.AppMsgLogic", C1447g.m3075Mq() + " thumbData MsgInfo path:" + a2);
            if (!C5046bo.isNullOrNil(a2)) {
                c7620bi.mo14795jv(a2);
                C4990ab.m7410d("MicroMsg.AppMsgLogic", "new thumbnail saved, path".concat(String.valueOf(a2)));
            }
        }
        if (c30065b != null) {
            c8910b.csD = c30065b.xDa;
        }
        c7620bi.setContent(C8910b.m16061a(c8910b, null, null));
        c7620bi.setStatus(1);
        c7620bi.mo14794ju(str3);
        c7620bi.mo14775eJ(C1829bf.m3756oC(str3));
        c7620bi.mo14781hO(1);
        c7620bi.setType(C4733l.m7100d(c8910b));
        if (C17903f.m28103kq(c7620bi.field_talker)) {
            c7620bi.mo14791ix(C25754e.aae());
            C4990ab.m7411d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", c7620bi.dqJ);
        }
        C9638aw.m17190ZK();
        long Z = C18628c.m29080XO().mo15281Z(c7620bi);
        C4990ab.m7410d("MicroMsg.AppMsgLogic", C1447g.m3075Mq() + " msginfo insert id: " + Z);
        if (Z < 0) {
            C4990ab.m7412e("MicroMsg.AppMsgLogic", C1447g.m3075Mq() + "insert msg failed :" + Z);
            line = 0 - C1447g.getLine();
            AppMethodBeat.m2505o(27339);
            return line;
        }
        C4990ab.m7416i("MicroMsg.AppMsgLogic", C1447g.getLine() + " new msg inserted to db , local id = " + Z);
        c7620bi.setMsgId(Z);
        C8909j c8909j = new C8909j();
        c8909j.field_xml = c7620bi.field_content;
        c8909j.field_appId = str;
        c8909j.field_title = c8910b.title;
        c8909j.field_type = c8910b.type;
        c8909j.field_description = c8910b.description;
        c8909j.field_msgId = Z;
        c8909j.field_source = str2;
        C14877am.dhN().mo10101b((C4925c) c8909j);
        str7 = "MicroMsg.AppMsgLogic";
        String str9 = "summerbig sendAppMsg attInfo is null[%b]";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(c30065b == null);
        C4990ab.m7417i(str7, str9, objArr);
        if (c30065b != null) {
            c30065b.field_msgInfoId = Z;
            c30065b.field_status = 101;
            C14877am.aUq().mo48326a(c30065b, new String[0]);
            if (c8910b.type == 2 || !C5046bo.isNullOrNil(str5)) {
                C14877am.dhP().mo48321z(Z, str5);
            }
            C14877am.dhP().run();
        } else {
            C14877am.dhP();
            C30062a.m47593b(Z, str5, str6);
        }
        AppMethodBeat.m2505o(27339);
        return 0;
    }

    /* renamed from: a */
    public static int m7090a(WXMediaMessage wXMediaMessage, String str, String str2, String str3, int i, String str4) {
        AppMethodBeat.m2504i(27340);
        int a = C4733l.m7091a(wXMediaMessage, str, str2, str3, i, str4, null);
        AppMethodBeat.m2505o(27340);
        return a;
    }

    /* renamed from: a */
    public static int m7091a(WXMediaMessage wXMediaMessage, String str, String str2, String str3, int i, String str4, String str5) {
        AppMethodBeat.m2504i(27341);
        C8910b c8910b = new C8910b();
        c8910b.appId = str;
        c8910b.appName = str2;
        c8910b.fgr = i;
        int a = C4733l.m7086a(c8910b, wXMediaMessage, str3, str4, str5);
        AppMethodBeat.m2505o(27341);
        return a;
    }

    /* renamed from: a */
    public static int m7085a(C8910b c8910b, WXMediaMessage wXMediaMessage, String str) {
        AppMethodBeat.m2504i(27342);
        int a = C4733l.m7086a(c8910b, wXMediaMessage, str, null, null);
        AppMethodBeat.m2505o(27342);
        return a;
    }

    /* renamed from: a */
    private static int m7086a(C8910b c8910b, WXMediaMessage wXMediaMessage, String str, String str2, String str3) {
        C30065b c30065b;
        int line;
        String W;
        AppMethodBeat.m2504i(27343);
        String b = C4733l.m7098b(c8910b, wXMediaMessage, str2);
        C4990ab.m7410d("MicroMsg.AppMsgLogic", C1447g.m3075Mq() + "summerbig content url:" + c8910b.url + " lowUrl:" + c8910b.fgn + " attachlen:" + c8910b.fgo + " attachid:" + c8910b.csD + " attach file:" + b);
        String str4 = System.currentTimeMillis();
        if (C5046bo.isNullOrNil(b)) {
            c30065b = null;
        } else {
            C30065b a = C4733l.m7093a(str4, c8910b, b);
            if (a == null) {
                line = 0 - C1447g.getLine();
                AppMethodBeat.m2505o(27343);
                return line;
            }
            Options amj = C5056d.amj(b);
            if (amj != null) {
                c8910b.fgJ = amj.outWidth;
                c8910b.fgI = amj.outHeight;
            }
            c30065b = a;
        }
        C7620bi c7620bi = new C7620bi();
        if (wXMediaMessage.thumbData != null && wXMediaMessage.thumbData.length > 0) {
            if (wXMediaMessage.thumbData.length <= 65536 || wXMediaMessage.getType() == 36 || wXMediaMessage.getType() == 46) {
                W = C32291o.ahl().mo73075W(wXMediaMessage.thumbData);
            } else {
                W = C32291o.ahl().mo73094a(wXMediaMessage.thumbData, c8910b.type == 2, CompressFormat.JPEG);
            }
            C4990ab.m7410d("MicroMsg.AppMsgLogic", C1447g.m3075Mq() + " summerbig thumbData MsgInfo path:" + W);
            if (!C5046bo.isNullOrNil(W)) {
                c7620bi.mo14795jv(W);
            }
        }
        if (c30065b != null) {
            c8910b.csD = c30065b.xDa;
        }
        for (String W2 : C5046bo.m7508P(str.split(","))) {
            c8910b.fgq = str2;
            c7620bi.setContent(C8910b.m16061a(c8910b, null, null));
            c7620bi.setStatus(1);
            c7620bi.mo14794ju(W2);
            c7620bi.mo14775eJ(C1829bf.m3756oC(W2));
            c7620bi.mo14781hO(1);
            c7620bi.setType(C4733l.m7100d(c8910b));
            if (C17903f.m28103kq(c7620bi.field_talker)) {
                c7620bi.mo14791ix(C25754e.aae());
            }
            C9638aw.m17190ZK();
            long Z = C18628c.m29080XO().mo15281Z(c7620bi);
            if (Z < 0) {
                C4990ab.m7412e("MicroMsg.AppMsgLogic", C1447g.m3075Mq() + " summerbig insert msg failed :" + Z);
                line = 0 - C1447g.getLine();
                AppMethodBeat.m2505o(27343);
                return line;
            }
            C4990ab.m7416i("MicroMsg.AppMsgLogic", C1447g.getLine() + " summerbig new msg inserted to db , local id = " + Z);
            c7620bi.setMsgId(Z);
            C8909j c8909j = new C8909j();
            c8909j.field_xml = c7620bi.field_content;
            c8909j.field_title = wXMediaMessage.title;
            c8909j.field_type = wXMediaMessage.mediaObject.type();
            c8909j.field_description = wXMediaMessage.description;
            c8909j.field_msgId = Z;
            c8909j.field_source = c8910b.appName;
            C14877am.dhN().mo10101b((C4925c) c8909j);
            if (c30065b != null) {
                c30065b.field_msgInfoId = Z;
                c30065b.field_status = 101;
                C4990ab.m7417i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg update attInfo field_msgInfoId[%d], field_status[%d], systemRowid[%d], type[%d]", Long.valueOf(c30065b.field_msgInfoId), Long.valueOf(c30065b.field_status), Long.valueOf(c30065b.xDa), Integer.valueOf(c8909j.field_type));
                C14877am.aUq().mo48326a(c30065b, new String[0]);
                if (!C5046bo.isNullOrNil(str3)) {
                    C14877am.dhP().mo48321z(c30065b.field_msgInfoId, str3);
                }
                C14877am.dhP().run();
            } else {
                C4990ab.m7417i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg dosceneSendAppMsg attInfo[%s], msgId[%d], sessionId[%s], type[%d]", c30065b, Long.valueOf(Z), str3, Integer.valueOf(c8909j.field_type));
                C14877am.dhP();
                C30062a.m47588A(Z, str3);
            }
        }
        AppMethodBeat.m2505o(27343);
        return 0;
    }

    /* renamed from: bH */
    public static String m7099bH(byte[] bArr) {
        AppMethodBeat.m2504i(27344);
        if (C5046bo.m7540cb(bArr)) {
            C4990ab.m7412e("MicroMsg.AppMsgLogic", C1447g.m3075Mq() + " attachBuf is null");
            AppMethodBeat.m2505o(27344);
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        C9638aw.m17190ZK();
        String stringBuilder2 = stringBuilder.append(C18628c.m29096Ye()).append("ua_").append(C5046bo.anU()).toString();
        C4990ab.m7410d("MicroMsg.AppMsgLogic", C1447g.m3075Mq() + " buildUploadAttachInfo file:" + stringBuilder2);
        if (C5730e.m8624b(stringBuilder2, bArr, bArr.length) != 0) {
            C4990ab.m7412e("MicroMsg.AppMsgLogic", C1447g.m3075Mq() + " writeFile error file:" + stringBuilder2);
            AppMethodBeat.m2505o(27344);
            return null;
        }
        AppMethodBeat.m2505o(27344);
        return stringBuilder2;
    }

    /* renamed from: b */
    public static String m7098b(C8910b c8910b, WXMediaMessage wXMediaMessage, String str) {
        AppMethodBeat.m2504i(27345);
        C4990ab.m7410d("MicroMsg.AppMsgLogic", C1447g.m3075Mq() + "mediaMessageToContent sdkver:" + wXMediaMessage.sdkVer + " title:" + wXMediaMessage.title + " desc:" + wXMediaMessage.description + " type:" + wXMediaMessage.mediaObject.type());
        c8910b.sdkVer = wXMediaMessage.sdkVer;
        c8910b.title = wXMediaMessage.title;
        c8910b.description = wXMediaMessage.description;
        c8910b.mediaTagName = wXMediaMessage.mediaTagName;
        c8910b.messageAction = wXMediaMessage.messageAction;
        c8910b.messageExt = wXMediaMessage.messageExt;
        IMediaObject iMediaObject = wXMediaMessage.mediaObject;
        c8910b.type = iMediaObject.type();
        String str2;
        if (c8910b.type == 7) {
            WXAppExtendObject wXAppExtendObject = (WXAppExtendObject) iMediaObject;
            c8910b.extInfo = wXAppExtendObject.extInfo;
            if (C5046bo.m7540cb(wXAppExtendObject.fileData)) {
                c8910b.fgo = (int) C5730e.asZ(wXAppExtendObject.filePath);
                C4990ab.m7410d("MicroMsg.AppMsgLogic", C1447g.m3075Mq() + " read file:" + wXAppExtendObject.filePath + " len:" + c8910b.fgo);
                if (c8910b.fgo > 0) {
                    c8910b.fgp = C5730e.m8630cv(wXAppExtendObject.filePath);
                    str2 = wXAppExtendObject.filePath;
                    AppMethodBeat.m2505o(27345);
                    return str2;
                }
                AppMethodBeat.m2505o(27345);
                return null;
            }
            C4990ab.m7410d("MicroMsg.AppMsgLogic", C1447g.m3075Mq() + " fileData:" + wXAppExtendObject.fileData.length);
            c8910b.fgo = wXAppExtendObject.fileData.length;
            str2 = C4733l.m7099bH(wXAppExtendObject.fileData);
            AppMethodBeat.m2505o(27345);
            return str2;
        } else if (c8910b.type == 6) {
            WXFileObject wXFileObject = (WXFileObject) iMediaObject;
            if (C5046bo.m7540cb(wXFileObject.fileData)) {
                c8910b.fgo = (int) C5730e.asZ(wXFileObject.filePath);
                C4990ab.m7410d("MicroMsg.AppMsgLogic", C1447g.m3075Mq() + " read file:" + wXFileObject.filePath + " len:" + c8910b.fgo);
                if (c8910b.fgo > 0) {
                    c8910b.fgp = C5730e.m8630cv(wXFileObject.filePath);
                    str2 = wXFileObject.filePath;
                    AppMethodBeat.m2505o(27345);
                    return str2;
                }
                AppMethodBeat.m2505o(27345);
                return null;
            }
            C4990ab.m7410d("MicroMsg.AppMsgLogic", C1447g.m3075Mq() + " fileData:" + wXFileObject.fileData.length);
            c8910b.fgo = wXFileObject.fileData.length;
            str2 = C4733l.m7099bH(wXFileObject.fileData);
            AppMethodBeat.m2505o(27345);
            return str2;
        } else if (c8910b.type == 2) {
            WXImageObject wXImageObject = (WXImageObject) iMediaObject;
            if (!C5046bo.m7540cb(wXImageObject.imageData)) {
                C4990ab.m7410d("MicroMsg.AppMsgLogic", C1447g.m3075Mq() + " fileData:" + wXImageObject.imageData.length);
                c8910b.fgo = wXImageObject.imageData.length;
                str2 = C4733l.m7099bH(wXImageObject.imageData);
                AppMethodBeat.m2505o(27345);
                return str2;
            } else if (C5046bo.isNullOrNil(wXImageObject.imagePath)) {
                AppMethodBeat.m2505o(27345);
                return null;
            } else {
                c8910b.fgo = (int) C5730e.asZ(wXImageObject.imagePath);
                C4990ab.m7410d("MicroMsg.AppMsgLogic", C1447g.m3075Mq() + " read file:" + wXImageObject.imagePath + " len:" + c8910b.fgo);
                if (c8910b.fgo > 0) {
                    c8910b.fgp = C5730e.m8630cv(wXImageObject.imagePath);
                    C9638aw.m17190ZK();
                    String w = C5736j.m8649w(new C5728b(C18628c.m29096Ye(), "appmsg_img_" + System.currentTimeMillis()).dMD());
                    Options amj = C5056d.amj(wXImageObject.imagePath);
                    if (amj == null || amj.outWidth <= 0 || amj.outHeight <= 0) {
                        boolean z;
                        w = "MicroMsg.AppMsgLogic";
                        String str3 = "options is null! %B, bitmapWidth = %d, bitmapHeight = %d";
                        Object[] objArr = new Object[3];
                        if (amj == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        objArr[0] = Boolean.valueOf(z);
                        objArr[1] = Integer.valueOf(amj == null ? -1 : amj.outWidth);
                        objArr[2] = Integer.valueOf(amj == null ? -1 : amj.outHeight);
                        C4990ab.m7413e(w, str3, objArr);
                        AppMethodBeat.m2505o(27345);
                        return null;
                    } else if (C1853r.m3854g(wXImageObject.imagePath, "", true)) {
                        C4990ab.m7417i("MicroMsg.AppMsgLogic", "this picture can send raw image but must copy [%s] to [%s]", wXImageObject.imagePath, w);
                        if (C5730e.m8644y(wXImageObject.imagePath, w) < 0) {
                            C4990ab.m7421w("MicroMsg.AppMsgLogic", "copy file error path[%s, %s]", wXImageObject.imagePath, w);
                            AppMethodBeat.m2505o(27345);
                            return null;
                        }
                        AppMethodBeat.m2505o(27345);
                        return w;
                    } else {
                        if (amj.outWidth > VideoFilterUtil.IMAGE_HEIGHT || amj.outHeight > VideoFilterUtil.IMAGE_HEIGHT) {
                            Bitmap d = C5056d.m7659d(wXImageObject.imagePath, VideoFilterUtil.IMAGE_HEIGHT, VideoFilterUtil.IMAGE_HEIGHT, false);
                            if (d != null) {
                                try {
                                    C5056d.m7625a(d, 100, CompressFormat.JPEG, w, true);
                                } catch (IOException e) {
                                    C4990ab.printErrStackTrace("MicroMsg.AppMsgLogic", e, "", new Object[0]);
                                    AppMethodBeat.m2505o(27345);
                                    return null;
                                }
                            }
                            AppMethodBeat.m2505o(27345);
                            return null;
                        } else if (C5730e.m8644y(wXImageObject.imagePath, w) < 0) {
                            AppMethodBeat.m2505o(27345);
                            return null;
                        }
                        AppMethodBeat.m2505o(27345);
                        return w;
                    }
                }
                AppMethodBeat.m2505o(27345);
                return null;
            }
        } else if (c8910b.type == 3) {
            WXMusicObject wXMusicObject = (WXMusicObject) iMediaObject;
            c8910b.url = wXMusicObject.musicUrl;
            c8910b.fgn = wXMusicObject.musicLowBandUrl;
            c8910b.fgM = wXMusicObject.musicDataUrl;
            c8910b.fgN = wXMusicObject.musicLowBandDataUrl;
            AppMethodBeat.m2505o(27345);
            return null;
        } else if (c8910b.type == 4) {
            WXVideoObject wXVideoObject = (WXVideoObject) iMediaObject;
            c8910b.url = wXVideoObject.videoUrl;
            c8910b.fgn = wXVideoObject.videoLowBandUrl;
            AppMethodBeat.m2505o(27345);
            return null;
        } else if (c8910b.type == 5) {
            WXWebpageObject wXWebpageObject = (WXWebpageObject) iMediaObject;
            c8910b.url = wXWebpageObject.webpageUrl;
            if (!C5046bo.isNullOrNil(wXWebpageObject.extInfo)) {
                c8910b.extInfo = wXWebpageObject.extInfo;
            }
            if (!C5046bo.isNullOrNil(wXWebpageObject.canvasPageXml)) {
                c8910b.canvasPageXml = wXWebpageObject.canvasPageXml;
            }
            AppMethodBeat.m2505o(27345);
            return null;
        } else {
            WXEmojiSharedObject wXEmojiSharedObject;
            if (c8910b.type == 36 || c8910b.type == 46) {
                WXMiniProgramObject wXMiniProgramObject = (WXMiniProgramObject) iMediaObject;
                c8910b.fiP = wXMiniProgramObject.userName;
                c8910b.fiO = wXMiniProgramObject.path;
                c8910b.url = wXMiniProgramObject.webpageUrl;
                WxaAttributes zb = ((C42686d) C1720g.m3528K(C42686d.class)).mo44618zb(wXMiniProgramObject.userName);
                if (zb != null) {
                    if (zb.ayL() != null) {
                        c8910b.fja = zb.ayL().axy;
                    }
                    c8910b.fjb = zb.field_brandIconURL;
                    C4990ab.m7417i("MicroMsg.AppMsgLogic", "add appbrand version and appbrand icon url : %d, %s", Integer.valueOf(c8910b.fja), c8910b.fjb);
                }
            } else if (c8910b.type == 1) {
                c8910b.title = ((WXTextObject) iMediaObject).text;
                AppMethodBeat.m2505o(27345);
                return null;
            } else if (c8910b.type == 8) {
                WXEmojiObject wXEmojiObject = (WXEmojiObject) iMediaObject;
                if (!C5046bo.m7540cb(wXEmojiObject.emojiData)) {
                    C4990ab.m7410d("MicroMsg.AppMsgLogic", C1447g.m3075Mq() + " fileData:" + wXEmojiObject.emojiData.length);
                    c8910b.fgo = wXEmojiObject.emojiData.length;
                    str2 = C4733l.m7099bH(wXEmojiObject.emojiData);
                    AppMethodBeat.m2505o(27345);
                    return str2;
                } else if (C5046bo.isNullOrNil(wXEmojiObject.emojiPath)) {
                    c8910b.fgq = str;
                } else {
                    c8910b.fgo = (int) C5730e.asZ(wXEmojiObject.emojiPath);
                    C4990ab.m7410d("MicroMsg.AppMsgLogic", C1447g.m3075Mq() + " read file:" + wXEmojiObject.emojiPath + " len:" + c8910b.fgo);
                    if (c8910b.fgo > 0) {
                        c8910b.fgp = C5730e.m8630cv(wXEmojiObject.emojiPath);
                        str2 = wXEmojiObject.emojiPath;
                        AppMethodBeat.m2505o(27345);
                        return str2;
                    }
                    AppMethodBeat.m2505o(27345);
                    return null;
                }
            } else if (c8910b.type == 15) {
                wXEmojiSharedObject = (WXEmojiSharedObject) iMediaObject;
                c8910b.thumburl = wXEmojiSharedObject.thumburl;
                c8910b.fgY = wXEmojiSharedObject.packageflag;
                c8910b.fgX = wXEmojiSharedObject.packageid;
                c8910b.showType = 8;
                c8910b.url = wXEmojiSharedObject.url;
                AppMethodBeat.m2505o(27345);
                return null;
            } else if (c8910b.type == 13) {
                wXEmojiSharedObject = (WXEmojiSharedObject) iMediaObject;
                c8910b.thumburl = wXEmojiSharedObject.thumburl;
                c8910b.fgY = wXEmojiSharedObject.packageflag;
                c8910b.fgX = wXEmojiSharedObject.packageid;
                c8910b.showType = 8;
                c8910b.url = wXEmojiSharedObject.url;
                AppMethodBeat.m2505o(27345);
                return null;
            } else if (c8910b.type == 25) {
                WXDesignerSharedObject wXDesignerSharedObject = (WXDesignerSharedObject) iMediaObject;
                c8910b.thumburl = wXDesignerSharedObject.thumburl;
                c8910b.url = wXDesignerSharedObject.url;
                c8910b.fiD = wXDesignerSharedObject.designerUIN;
                c8910b.designerName = wXDesignerSharedObject.designerName;
                c8910b.designerRediretctUrl = wXDesignerSharedObject.designerRediretctUrl;
                c8910b.showType = 18;
                AppMethodBeat.m2505o(27345);
                return null;
            } else if (c8910b.type == 27 || c8910b.type == 26) {
                WXEmojiPageSharedObject wXEmojiPageSharedObject = (WXEmojiPageSharedObject) iMediaObject;
                c8910b.thumburl = wXEmojiPageSharedObject.iconUrl;
                c8910b.url = wXEmojiPageSharedObject.url;
                c8910b.tid = wXEmojiPageSharedObject.tid;
                c8910b.fiE = wXEmojiPageSharedObject.title;
                c8910b.desc = wXEmojiPageSharedObject.desc;
                c8910b.iconUrl = wXEmojiPageSharedObject.iconUrl;
                c8910b.secondUrl = wXEmojiPageSharedObject.secondUrl;
                c8910b.pageType = wXEmojiPageSharedObject.pageType;
                c8910b.showType = 20;
                AppMethodBeat.m2505o(27345);
                return null;
            }
            AppMethodBeat.m2505o(27345);
            return null;
        }
    }

    /* renamed from: d */
    public static C30065b m7101d(C7620bi c7620bi, String str) {
        AppMethodBeat.m2504i(27346);
        C30065b aiM = C4733l.aiM(str);
        if (aiM == null) {
            C4733l.m7105s(c7620bi.field_msgId, c7620bi.field_content);
            aiM = C4733l.aiM(str);
            AppMethodBeat.m2505o(27346);
            return aiM;
        }
        AppMethodBeat.m2505o(27346);
        return aiM;
    }

    public static C30065b aiM(String str) {
        AppMethodBeat.m2504i(27347);
        C30065b c30065b = new C30065b();
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(27347);
            return null;
        }
        C4990ab.m7417i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s", str);
        long j = C5046bo.getLong(str, -1);
        if (j != -1) {
            C14877am.aUq().mo16761b(j, (C4925c) c30065b);
            if (c30065b.xDa != j) {
                c30065b = C14877am.aUq().aiE(str);
                if (c30065b == null || !c30065b.field_mediaSvrId.equals(str)) {
                    C4990ab.m7416i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 1");
                    c30065b = null;
                }
            }
        } else {
            c30065b = C14877am.aUq().aiE(str);
            if (c30065b == null || !c30065b.field_mediaSvrId.equals(str)) {
                C4990ab.m7416i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 2");
                c30065b = null;
            }
        }
        C4990ab.m7417i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s id %s", str, Long.valueOf(j));
        AppMethodBeat.m2505o(27347);
        return c30065b;
    }

    /* renamed from: d */
    public static int m7100d(C8910b c8910b) {
        AppMethodBeat.m2504i(27349);
        if (c8910b == null) {
            AppMethodBeat.m2505o(27349);
            return 49;
        }
        int i = c8910b.type;
        int i2 = c8910b.showType;
        int i3 = c8910b.ffZ;
        int i4 = c8910b.fgO;
        int i5 = c8910b.fii;
        C4990ab.m7410d("MicroMsg.AppMsgLogic", "getLocalAppMsgType showType " + i2 + " atype " + i + ", itemShowType = " + i3 + ", c2cNewAAType = " + i5);
        if (i3 == 4 || i4 != 0) {
            AppMethodBeat.m2505o(27349);
            return 318767153;
        } else if (i == 2001) {
            if (i2 == 1) {
                AppMethodBeat.m2505o(27349);
                return 469762097;
            } else if (i5 == 4) {
                AppMethodBeat.m2505o(27349);
                return 503316529;
            } else {
                AppMethodBeat.m2505o(27349);
                return 436207665;
            }
        } else if (i == 2002) {
            AppMethodBeat.m2505o(27349);
            return 536870961;
        } else {
            switch (i2) {
                case 1:
                    if (i == 21) {
                        AppMethodBeat.m2505o(27349);
                        return -1879048185;
                    }
                    AppMethodBeat.m2505o(27349);
                    return 285212721;
                case 2:
                    if (i == 21) {
                        AppMethodBeat.m2505o(27349);
                        return -1879048183;
                    }
                    AppMethodBeat.m2505o(27349);
                    return 301989937;
                case 3:
                    if (i == 21) {
                        AppMethodBeat.m2505o(27349);
                        return -1879048176;
                    }
                    AppMethodBeat.m2505o(27349);
                    return -1879048189;
                case 4:
                    if (i == 21) {
                        AppMethodBeat.m2505o(27349);
                        return -1879048183;
                    }
                    AppMethodBeat.m2505o(27349);
                    return -1879048190;
                case 5:
                    AppMethodBeat.m2505o(27349);
                    return -1879048191;
                case 17:
                    AppMethodBeat.m2505o(27349);
                    return -1879048186;
                default:
                    switch (i) {
                        case 1:
                            AppMethodBeat.m2505o(27349);
                            return 16777265;
                        case 2:
                            AppMethodBeat.m2505o(27349);
                            return 268435505;
                        case 8:
                            AppMethodBeat.m2505o(27349);
                            return 1048625;
                        case 10:
                            AppMethodBeat.m2505o(27349);
                            return 335544369;
                        case 13:
                            AppMethodBeat.m2505o(27349);
                            return 369098801;
                        case 16:
                            AppMethodBeat.m2505o(27349);
                            return 452984881;
                        case 17:
                            AppMethodBeat.m2505o(27349);
                            return -1879048186;
                        case 20:
                            AppMethodBeat.m2505o(27349);
                            return 402653233;
                        case 33:
                            C41728a c41728a = (C41728a) c8910b.mo20333X(C41728a.class);
                            if (c41728a != null && c41728a.feY && (c8910b.fiR == 2 || c8910b.fiR == 3)) {
                                AppMethodBeat.m2505o(27349);
                                return 553648177;
                            } else if (c41728a != null && c41728a.ffb && c8910b.fiR == 3) {
                                AppMethodBeat.m2505o(27349);
                                return 587202609;
                            } else {
                                AppMethodBeat.m2505o(27349);
                                return 49;
                            }
                        case 34:
                            AppMethodBeat.m2505o(27349);
                            return 520093745;
                        case 46:
                            AppMethodBeat.m2505o(27349);
                            return 687865905;
                        case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                            AppMethodBeat.m2505o(27349);
                            return 704643121;
                        case 2000:
                            AppMethodBeat.m2505o(27349);
                            return 419430449;
                        case 671088689:
                            AppMethodBeat.m2505o(27349);
                            return 671088689;
                        default:
                            AppMethodBeat.m2505o(27349);
                            return 49;
                    }
            }
        }
    }

    /* renamed from: Kx */
    public static int m7082Kx(int i) {
        switch (i) {
            case -1879048191:
            case -1879048190:
            case -1879048189:
            case -1879048186:
            case -1879048185:
            case -1879048183:
            case -1879048176:
            case 1048625:
            case 16777265:
            case 268435505:
            case 285212721:
            case 301989937:
            case 318767153:
            case 335544369:
            case 352321585:
            case 369098801:
            case 385876017:
            case 402653233:
            case 419430449:
            case 436207665:
            case 452984881:
            case 469762097:
            case 486539313:
            case 503316529:
            case 520093745:
            case 536870961:
            case 553648177:
            case 587202609:
            case 603979825:
            case 687865905:
            case 704643121:
                return 49;
            default:
                return i;
        }
    }

    /* renamed from: a */
    public static void m7095a(C7620bi c7620bi, final C4734a c4734a) {
        AppMethodBeat.m2504i(27328);
        C8910b me = C8910b.m16064me(c7620bi.field_content);
        if (me == null) {
            C4990ab.m7413e("MicroMsg.AppMsgLogic", "parse msgContent error, %s", c7620bi.field_content);
            AppMethodBeat.m2505o(27328);
            return;
        }
        if (C5046bo.isNullOrNil(me.csD) && !C5046bo.isNullOrNil(me.fgD)) {
            C4990ab.m7413e("MicroMsg.AppMsgLogic", "msgContent format error, %s", c7620bi.field_content);
            me.csD = me.fgD.hashCode();
        }
        String str = me.csD;
        if (!C4733l.m7096a(c7620bi, C4733l.m7103i(str, c7620bi.field_msgId)) && C4733l.m7102d(str, c7620bi)) {
            pJg = new C43432e(c7620bi.field_msgId, str, new C32231g() {
                /* renamed from: a */
                public final void mo8280a(int i, int i2, C1207m c1207m) {
                    AppMethodBeat.m2504i(27323);
                    if (c4734a != null) {
                        c4734a.mo9875gK(i, i2);
                    }
                    AppMethodBeat.m2505o(27323);
                }
            });
            C9638aw.m17182Rg().mo14541a(pJg, 0);
        }
        AppMethodBeat.m2505o(27328);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0174  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: al */
    public static void m7097al(C7620bi c7620bi) {
        AppMethodBeat.m2504i(27348);
        C8910b me = C8910b.m16064me(c7620bi.field_content);
        if (me == null) {
            C4990ab.m7412e("MicroMsg.AppMsgLogic", "resend app message error: app content null");
            AppMethodBeat.m2505o(27348);
            return;
        }
        byte[] e;
        C8910b a;
        String str;
        String str2;
        C30065b a2;
        C7620bi c7620bi2;
        String a3;
        long Z;
        C30065b aiM = C4733l.aiM(me.csD);
        String str3 = "";
        if (!(aiM == null || aiM.field_fileFullPath == null || aiM.field_fileFullPath.equals(""))) {
            C9638aw.m17190ZK();
            str3 = C4733l.m7083X(C18628c.m29096Ye(), me.title, me.fgp);
            C5730e.m8644y(aiM.field_fileFullPath, str3);
        }
        if (!(c7620bi.field_imgPath == null || c7620bi.field_imgPath.equals(""))) {
            try {
                e = C5730e.m8632e(C32291o.ahl().mo73074I(c7620bi.field_imgPath, true), 0, -1);
            } catch (Exception e2) {
            }
            a = C8910b.m16060a(me);
            str = me.appName;
            str2 = System.currentTimeMillis();
            if (C5046bo.isNullOrNil(str3)) {
                a2 = C4733l.m7093a(str2, a, str3);
                if (a2 == null) {
                    C1447g.getLine();
                    AppMethodBeat.m2505o(27348);
                    return;
                }
            }
            a2 = null;
            c7620bi2 = new C7620bi();
            if (e != null && e.length > 0) {
                if (a.type != 46) {
                    a3 = C32291o.ahl().mo73091a(e, CompressFormat.JPEG);
                } else {
                    boolean z;
                    if (a.type == 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    a3 = C32291o.ahl().mo73094a(e, z, CompressFormat.PNG);
                }
                C4990ab.m7410d("MicroMsg.AppMsgLogic", C1447g.m3075Mq() + " thumbData MsgInfo path:" + a3);
                if (!C5046bo.isNullOrNil(a3)) {
                    c7620bi2.mo14795jv(a3);
                    C4990ab.m7410d("MicroMsg.AppMsgLogic", "new thumbnail saved, path".concat(String.valueOf(a3)));
                }
            }
            if (a2 != null) {
                a.csD = a2.xDa;
            }
            c7620bi2.setContent(C8910b.m16061a(a, null, null));
            c7620bi2.setStatus(1);
            c7620bi2.mo14794ju(c7620bi.field_talker);
            c7620bi2.mo14775eJ(C1829bf.m3756oC(c7620bi.field_talker));
            c7620bi2.mo14781hO(1);
            c7620bi2.setType(C4733l.m7100d(a));
            if (C17903f.m28103kq(c7620bi2.field_talker)) {
                c7620bi2.mo14791ix(C25754e.aae());
                C4990ab.m7411d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", c7620bi2.dqJ);
            }
            C9638aw.m17190ZK();
            Z = C18628c.m29080XO().mo15281Z(c7620bi2);
            C4990ab.m7410d("MicroMsg.AppMsgLogic", C1447g.m3075Mq() + " msginfo insert id: " + Z);
            if (Z >= 0) {
                C4990ab.m7412e("MicroMsg.AppMsgLogic", C1447g.m3075Mq() + "insert msg failed :" + Z);
                C1447g.getLine();
                AppMethodBeat.m2505o(27348);
                return;
            }
            C4990ab.m7416i("MicroMsg.AppMsgLogic", C1447g.getLine() + " new msg inserted to db , local id = " + Z);
            c7620bi2.setMsgId(Z);
            C45373tq c45373tq = new C45373tq();
            c45373tq.cPN.cPO = c7620bi.field_msgId;
            c45373tq.cPN.cPP = Z;
            C4879a.xxA.mo10055m(c45373tq);
            C8909j c8909j = new C8909j();
            c8909j.field_xml = c7620bi2.field_content;
            c8909j.field_title = a.title;
            c8909j.field_type = a.type;
            c8909j.field_description = a.description;
            c8909j.field_msgId = Z;
            c8909j.field_source = str;
            C14877am.dhN().mo10101b((C4925c) c8909j);
            if (a2 != null) {
                a2.field_msgInfoId = Z;
                a2.field_status = 101;
                C14877am.aUq().mo48326a(a2, new String[0]);
                C14877am.dhP().run();
                AppMethodBeat.m2505o(27348);
                return;
            }
            C14877am.dhP();
            C30062a.m47603jB(Z);
            AppMethodBeat.m2505o(27348);
            return;
        }
        e = null;
        a = C8910b.m16060a(me);
        str = me.appName;
        str2 = System.currentTimeMillis();
        if (C5046bo.isNullOrNil(str3)) {
        }
        c7620bi2 = new C7620bi();
        if (a.type != 46) {
        }
        C4990ab.m7410d("MicroMsg.AppMsgLogic", C1447g.m3075Mq() + " thumbData MsgInfo path:" + a3);
        if (C5046bo.isNullOrNil(a3)) {
        }
        if (a2 != null) {
        }
        c7620bi2.setContent(C8910b.m16061a(a, null, null));
        c7620bi2.setStatus(1);
        c7620bi2.mo14794ju(c7620bi.field_talker);
        c7620bi2.mo14775eJ(C1829bf.m3756oC(c7620bi.field_talker));
        c7620bi2.mo14781hO(1);
        c7620bi2.setType(C4733l.m7100d(a));
        if (C17903f.m28103kq(c7620bi2.field_talker)) {
        }
        C9638aw.m17190ZK();
        Z = C18628c.m29080XO().mo15281Z(c7620bi2);
        C4990ab.m7410d("MicroMsg.AppMsgLogic", C1447g.m3075Mq() + " msginfo insert id: " + Z);
        if (Z >= 0) {
        }
    }
}
