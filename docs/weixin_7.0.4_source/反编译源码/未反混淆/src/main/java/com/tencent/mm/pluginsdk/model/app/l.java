package com.tencent.mm.pluginsdk.model.app;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.o;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.tq;
import com.tencent.mm.i.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXDesignerSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiPageSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.record.b.e;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.bi;
import com.tencent.ttpic.util.VideoFilterUtil;
import java.io.IOException;

public final class l {
    private static e pJg;

    public interface a {
        void gK(int i, int i2);
    }

    public static boolean aiK(String str) {
        AppMethodBeat.i(27324);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(27324);
            return false;
        } else if (str.equals("0:0")) {
            AppMethodBeat.o(27324);
            return false;
        } else {
            AppMethodBeat.o(27324);
            return true;
        }
    }

    public static void jC(long j) {
        AppMethodBeat.i(27325);
        am.aUq().lY(j);
        b bVar = new b();
        am.aUq().b(j, (c) bVar);
        if (bVar.field_msgInfoId <= 0) {
            AppMethodBeat.o(27325);
            return;
        }
        aw.ZK();
        bi jf = com.tencent.mm.model.c.XO().jf(bVar.field_msgInfoId);
        if (jf.field_msgId != bVar.field_msgInfoId) {
            AppMethodBeat.o(27325);
            return;
        }
        jf.setStatus(5);
        aw.ZK();
        com.tencent.mm.model.c.XO().a(jf.field_msgId, jf);
        AppMethodBeat.o(27325);
    }

    public static int aiL(String str) {
        AppMethodBeat.i(27326);
        b me = b.me(str);
        if (me == null) {
            AppMethodBeat.o(27326);
            return -1;
        } else if (aiK(me.csD)) {
            b bVar = new b();
            long j = bo.getLong(me.csD, -1);
            if (j != -1) {
                am.aUq().b(j, (c) bVar);
                if (bVar.xDa != j) {
                    bVar = am.aUq().aiE(me.csD);
                    if (bVar == null || !bVar.field_mediaSvrId.equals(me.csD)) {
                        AppMethodBeat.o(27326);
                        return -1;
                    }
                }
            }
            bVar = am.aUq().aiE(me.csD);
            if (bVar == null || !bVar.field_mediaSvrId.equals(me.csD)) {
                AppMethodBeat.o(27326);
                return -1;
            }
            if (bVar.field_totalLen == 0) {
                AppMethodBeat.o(27326);
                return -1;
            }
            int i = (int) ((bVar.field_offset * 100) / bVar.field_totalLen);
            AppMethodBeat.o(27326);
            return i;
        } else {
            AppMethodBeat.o(27326);
            return -1;
        }
    }

    public static String s(long j, String str) {
        AppMethodBeat.i(27327);
        ab.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach msgLocalId[%d], msgXml[%s], downloadPath[%s]", Long.valueOf(j), str, null);
        b me = b.me(str);
        if (me == null) {
            AppMethodBeat.o(27327);
            return null;
        }
        String X = X(com.tencent.mm.compatible.util.e.euQ, me.title, me.fgp);
        if (bo.isNullOrNil(me.csD) && !bo.isNullOrNil(me.fgD)) {
            me.csD = me.fgD.hashCode();
        }
        String a = a(X, j, me.sdkVer, me.appId, me.csD, me.fgo, me.type, me.fgs);
        AppMethodBeat.o(27327);
        return a;
    }

    public static boolean a(bi biVar, b bVar) {
        AppMethodBeat.i(27329);
        if (bVar == null || !com.tencent.mm.vfs.e.ct(bVar.field_fileFullPath)) {
            AppMethodBeat.o(27329);
            return false;
        } else if (bVar.bCR() || (biVar.field_isSend == 1 && bVar.field_isUpload)) {
            AppMethodBeat.o(27329);
            return true;
        } else {
            AppMethodBeat.o(27329);
            return false;
        }
    }

    public static boolean d(String str, bi biVar) {
        AppMethodBeat.i(27330);
        if (biVar == null) {
            AppMethodBeat.o(27330);
            return false;
        }
        boolean z = true;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        b i = i(str, biVar.field_msgId);
        b me = b.me(biVar.field_content);
        if (me != null) {
            str2 = ah.nullAsNil(me.title);
            str3 = ah.nullAsNil(me.fgp).toLowerCase();
            str4 = ah.nullAsNil(me.filemd5);
            str5 = ah.nullAsNil(me.cEV);
            str6 = ah.nullAsNil(me.eyr);
        }
        String str7;
        if (i == null) {
            s(biVar.field_msgId, biVar.field_content);
            i = i(str, biVar.field_msgId);
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
                ab.i(str7, str8, objArr);
                if (me != null && (me.fgs != 0 || me.fgo > 26214400)) {
                    boolean z2;
                    if (ah.isNullOrNil(i.field_signature)) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    z = z2;
                }
            }
        } else {
            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(i.field_fileFullPath);
            if (i.field_status == 199 && !bVar.exists()) {
                ab.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist but file not!");
                s(biVar.field_msgId, biVar.field_content);
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
            objArr2[7] = Boolean.valueOf(bVar.exists());
            objArr2[8] = Long.valueOf(i.field_status);
            objArr2[9] = Integer.valueOf(i.field_signature == null ? -1 : i.field_signature.length());
            ab.i(str9, str7, objArr2);
        }
        if (!z) {
            aw.Rg().a(new com.tencent.mm.plugin.record.b.c(i, str6, str4, str2, str3, str5), 0);
        }
        AppMethodBeat.o(27330);
        return z;
    }

    public static b i(String str, long j) {
        AppMethodBeat.i(27331);
        b aiM = aiM(str);
        if (aiM == null) {
            aiM = am.aUq().lZ(j);
        }
        if (aiM != null) {
            ab.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo info[%s], rowid[%d], isUpload[%b], fullpath[%s], totallen[%d], offset[%d], mediaSvrId[%s], mediaid[%s], msgid[%d], type[%d], stack[%s]", aiM, Long.valueOf(aiM.xDa), Boolean.valueOf(aiM.field_isUpload), aiM.field_fileFullPath, Long.valueOf(aiM.field_totalLen), Long.valueOf(aiM.field_offset), aiM.field_mediaSvrId, aiM.field_mediaId, Long.valueOf(aiM.field_msgInfoId), Long.valueOf(aiM.field_type), ah.anW());
        } else {
            ab.w("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo is null stack[%s]", ah.anW());
        }
        AppMethodBeat.o(27331);
        return aiM;
    }

    public static String a(String str, long j, int i, String str2, String str3, int i2, int i3, int i4) {
        AppMethodBeat.i(27332);
        b bVar = new b();
        bVar.field_fileFullPath = str;
        bVar.field_appId = str2;
        bVar.field_sdkVer = (long) i;
        bVar.field_mediaSvrId = str3;
        bVar.field_totalLen = (long) i2;
        bVar.field_status = 101;
        bVar.field_isUpload = false;
        bVar.field_createTime = bo.anU();
        bVar.field_lastModifyTime = bo.anT();
        bVar.field_msgInfoId = j;
        bVar.field_netTimes = 0;
        bVar.field_type = (long) i3;
        ab.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach ret[%b], rowid[%d], field_totalLen[%d], type[%d], isLargeFile[%d], destFile[%s], stack[%s]", Boolean.valueOf(am.aUq().b((c) bVar)), Long.valueOf(bVar.xDa), Long.valueOf(bVar.field_totalLen), Long.valueOf(bVar.field_type), Integer.valueOf(i4), str, bo.dpG());
        AppMethodBeat.o(27332);
        return str3;
    }

    public static b a(String str, long j, int i, String str2, String str3, int i2) {
        AppMethodBeat.i(27333);
        b bVar = new b();
        bVar.field_fileFullPath = str;
        bVar.field_appId = str2;
        bVar.field_sdkVer = (long) i;
        bVar.field_mediaSvrId = str3;
        bVar.field_totalLen = (long) i2;
        bVar.field_status = 101;
        bVar.field_isUpload = false;
        bVar.field_createTime = bo.anU();
        bVar.field_lastModifyTime = bo.anT();
        bVar.field_msgInfoId = j;
        bVar.field_netTimes = 0;
        AppMethodBeat.o(27333);
        return bVar;
    }

    public static b a(String str, b bVar, String str2) {
        AppMethodBeat.i(27334);
        ab.i("MicroMsg.AppMsgLogic", g.Mq() + " summerbig buildUploadAttachInfo clientAppDataId:" + str + " attach file :" + str2);
        if (str2.replace("//", "/").startsWith(com.tencent.mm.compatible.util.e.eSi)) {
            ab.e("MicroMsg.AppMsgLogic", "summerbig Error attach path:%s", str2.replace("//", "/"));
            AppMethodBeat.o(27334);
            return null;
        }
        b bVar2 = new b();
        bVar2.field_totalLen = (long) bVar.fgo;
        bVar2.field_fileFullPath = str2;
        bVar2.field_sdkVer = (long) bVar.sdkVer;
        bVar2.field_appId = bVar.appId;
        bVar2.field_clientAppDataId = str;
        bVar2.field_type = (long) bVar.type;
        bVar2.field_status = 200;
        bVar2.field_isUpload = true;
        bVar2.field_createTime = bo.anU();
        bVar2.field_lastModifyTime = bo.anT();
        bVar2.field_mediaSvrId = bo.anU();
        am.aUq().b((c) bVar2);
        ab.d("MicroMsg.AppMsgLogic", g.Mq() + " summerbig buildUploadAttachInfo file:" + bVar2.field_fileFullPath + " rowid:" + bVar2.xDa + " clientAppDataId:" + bVar2.field_clientAppDataId);
        if (bVar2.xDa < 0) {
            ab.e("MicroMsg.AppMsgLogic", g.Mq() + " summerbig uploadAttach insert appattach info failed :" + bVar2.xDa);
            AppMethodBeat.o(27334);
            return null;
        }
        AppMethodBeat.o(27334);
        return bVar2;
    }

    public static int a(long j, String str, d dVar) {
        AppMethodBeat.i(27335);
        aw.ZK();
        bi jf = com.tencent.mm.model.c.XO().jf(j);
        int line;
        if (jf.field_msgId != j) {
            ab.e("MicroMsg.AppMsgLogic", g.Mq() + " getmsgFailed id:" + j);
            line = 0 - g.getLine();
            AppMethodBeat.o(27335);
            return line;
        }
        b me = b.me(jf.field_content);
        if (me == null) {
            ab.e("MicroMsg.AppMsgLogic", g.Mq() + " getmsgFailed id:" + j);
            line = 0 - g.getLine();
            AppMethodBeat.o(27335);
            return line;
        }
        me.csD = str;
        if (dVar != null) {
            me.eyr = dVar.field_aesKey == "" ? me.eyr : dVar.field_aesKey;
            me.fgD = dVar.field_fileId == "" ? me.fgD : dVar.field_fileId;
            me.filemd5 = dVar.field_filemd5 == "" ? me.filemd5 : dVar.field_filemd5;
            me.fgo = dVar.field_fileLength == 0 ? me.fgo : dVar.field_fileLength;
            me.fgE = dVar.field_thumbUrl == "" ? me.fgE : dVar.field_thumbUrl;
        }
        jf.setContent(b.a(me, me.csD, dVar));
        aw.ZK();
        com.tencent.mm.model.c.XO().a(jf.field_msgId, jf);
        j ma = am.dhN().ma(j);
        if (ma != null) {
            ma.field_xml = jf.field_content;
            am.dhN().c(ma, "msgId");
        }
        b lZ = am.aUq().lZ(j);
        lZ.field_mediaSvrId = str;
        lZ.field_offset = lZ.field_totalLen;
        am.aUq().a(lZ, new String[0]);
        AppMethodBeat.o(27335);
        return 0;
    }

    public static int a(b bVar, String str, String str2, String str3, String str4, byte[] bArr) {
        AppMethodBeat.i(27336);
        int a = a(bVar, str, str2, str3, str4, bArr, null);
        AppMethodBeat.o(27336);
        return a;
    }

    public static int a(b bVar, String str, String str2, String str3, String str4, byte[] bArr, String str5) {
        AppMethodBeat.i(27337);
        int a = a(bVar, str, str2, str3, str4, bArr, str5, "");
        AppMethodBeat.o(27337);
        return a;
    }

    public static String X(String str, String str2, String str3) {
        String str4;
        int i = 1;
        AppMethodBeat.i(27338);
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str);
        if (!bVar.exists()) {
            bVar.mkdirs();
        }
        if (bo.isNullOrNil(str2)) {
            str4 = str + "da_" + bo.anU();
            if (!bo.isNullOrNil(str3)) {
                str4 = str4 + "." + str3;
            }
        } else {
            if (!(bo.isNullOrNil(str3) || str2.endsWith(str3))) {
                str2 = str2 + "." + str3;
            }
            str4 = str + str2;
            if (com.tencent.mm.vfs.e.ct(str4)) {
                while (i < 20) {
                    if (!com.tencent.mm.vfs.e.ct(str + i + "_" + str2)) {
                        str4 = str + i + "_" + str2;
                        break;
                    }
                    i++;
                }
                if (i == 20) {
                    str4 = str + "da_" + bo.anU();
                    if (!bo.isNullOrNil(str3)) {
                        str4 = str4 + "." + str3;
                    }
                }
            }
        }
        try {
            if (!com.tencent.mm.vfs.j.w(new com.tencent.mm.vfs.b(str4).dMC().dMD()).equalsIgnoreCase(com.tencent.mm.vfs.j.w(new com.tencent.mm.vfs.b(str).dMD()))) {
                str4 = str + "da_" + bo.anU();
                ab.w("MicroMsg.AppMsgLogic", "maybe DirTraversal attach. %s", str4);
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.AppMsgLogic", e, "", new Object[0]);
            str4 = str + "da_" + bo.anU();
            if (!bo.isNullOrNil(str3)) {
                str4 = str4 + "." + str3;
            }
        }
        AppMethodBeat.o(27338);
        return str4;
    }

    public static int a(b bVar, String str, String str2, String str3, String str4, byte[] bArr, String str5, String str6) {
        b bVar2;
        int line;
        AppMethodBeat.i(27339);
        ab.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg attachFilePath[%s], content[%s]", str4, bVar);
        String str7 = System.currentTimeMillis();
        if (bo.isNullOrNil(str4)) {
            bVar2 = null;
        } else {
            b a = a(str7, bVar, str4);
            if (a == null) {
                line = 0 - g.getLine();
                AppMethodBeat.o(27339);
                return line;
            }
            bVar2 = a;
        }
        bi biVar = new bi();
        if (bArr != null && bArr.length > 0) {
            String a2;
            if (bVar.type == 33 || bVar.type == 36 || bVar.type == 44) {
                int i = (int) (com.tencent.mm.sdk.platformtools.d.anS().density * 240.0f);
                int i2 = (int) (com.tencent.mm.sdk.platformtools.d.anS().density * 240.0f);
                com.tencent.mm.af.a aVar = (com.tencent.mm.af.a) bVar.X(com.tencent.mm.af.a.class);
                String str8 = aVar != null ? aVar.ffl : "";
                boolean z = aVar != null ? aVar.ffm : false;
                Object obj = ((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_wxa_share_is_use_new, 0) == 1 ? 1 : null;
                if (f.IS_FLAVOR_RED || obj != null) {
                    a2 = o.ahl().a(bArr, CompressFormat.JPEG, str8, z);
                } else {
                    a2 = o.ahl().a(bArr, CompressFormat.JPEG, i, i2, str8, z);
                }
            } else if (bVar.type == 46) {
                a2 = o.ahl().a(bArr, CompressFormat.JPEG);
            } else {
                a2 = o.ahl().a(bArr, bVar.type == 2, CompressFormat.PNG);
            }
            ab.d("MicroMsg.AppMsgLogic", g.Mq() + " thumbData MsgInfo path:" + a2);
            if (!bo.isNullOrNil(a2)) {
                biVar.jv(a2);
                ab.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path".concat(String.valueOf(a2)));
            }
        }
        if (bVar2 != null) {
            bVar.csD = bVar2.xDa;
        }
        biVar.setContent(b.a(bVar, null, null));
        biVar.setStatus(1);
        biVar.ju(str3);
        biVar.eJ(bf.oC(str3));
        biVar.hO(1);
        biVar.setType(d(bVar));
        if (com.tencent.mm.aj.f.kq(biVar.field_talker)) {
            biVar.ix(com.tencent.mm.aj.a.e.aae());
            ab.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", biVar.dqJ);
        }
        aw.ZK();
        long Z = com.tencent.mm.model.c.XO().Z(biVar);
        ab.d("MicroMsg.AppMsgLogic", g.Mq() + " msginfo insert id: " + Z);
        if (Z < 0) {
            ab.e("MicroMsg.AppMsgLogic", g.Mq() + "insert msg failed :" + Z);
            line = 0 - g.getLine();
            AppMethodBeat.o(27339);
            return line;
        }
        ab.i("MicroMsg.AppMsgLogic", g.getLine() + " new msg inserted to db , local id = " + Z);
        biVar.setMsgId(Z);
        j jVar = new j();
        jVar.field_xml = biVar.field_content;
        jVar.field_appId = str;
        jVar.field_title = bVar.title;
        jVar.field_type = bVar.type;
        jVar.field_description = bVar.description;
        jVar.field_msgId = Z;
        jVar.field_source = str2;
        am.dhN().b((c) jVar);
        str7 = "MicroMsg.AppMsgLogic";
        String str9 = "summerbig sendAppMsg attInfo is null[%b]";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(bVar2 == null);
        ab.i(str7, str9, objArr);
        if (bVar2 != null) {
            bVar2.field_msgInfoId = Z;
            bVar2.field_status = 101;
            am.aUq().a(bVar2, new String[0]);
            if (bVar.type == 2 || !bo.isNullOrNil(str5)) {
                am.dhP().z(Z, str5);
            }
            am.dhP().run();
        } else {
            am.dhP();
            com.tencent.mm.pluginsdk.model.app.al.a.b(Z, str5, str6);
        }
        AppMethodBeat.o(27339);
        return 0;
    }

    public static int a(WXMediaMessage wXMediaMessage, String str, String str2, String str3, int i, String str4) {
        AppMethodBeat.i(27340);
        int a = a(wXMediaMessage, str, str2, str3, i, str4, null);
        AppMethodBeat.o(27340);
        return a;
    }

    public static int a(WXMediaMessage wXMediaMessage, String str, String str2, String str3, int i, String str4, String str5) {
        AppMethodBeat.i(27341);
        b bVar = new b();
        bVar.appId = str;
        bVar.appName = str2;
        bVar.fgr = i;
        int a = a(bVar, wXMediaMessage, str3, str4, str5);
        AppMethodBeat.o(27341);
        return a;
    }

    public static int a(b bVar, WXMediaMessage wXMediaMessage, String str) {
        AppMethodBeat.i(27342);
        int a = a(bVar, wXMediaMessage, str, null, null);
        AppMethodBeat.o(27342);
        return a;
    }

    private static int a(b bVar, WXMediaMessage wXMediaMessage, String str, String str2, String str3) {
        b bVar2;
        int line;
        String W;
        AppMethodBeat.i(27343);
        String b = b(bVar, wXMediaMessage, str2);
        ab.d("MicroMsg.AppMsgLogic", g.Mq() + "summerbig content url:" + bVar.url + " lowUrl:" + bVar.fgn + " attachlen:" + bVar.fgo + " attachid:" + bVar.csD + " attach file:" + b);
        String str4 = System.currentTimeMillis();
        if (bo.isNullOrNil(b)) {
            bVar2 = null;
        } else {
            b a = a(str4, bVar, b);
            if (a == null) {
                line = 0 - g.getLine();
                AppMethodBeat.o(27343);
                return line;
            }
            Options amj = com.tencent.mm.sdk.platformtools.d.amj(b);
            if (amj != null) {
                bVar.fgJ = amj.outWidth;
                bVar.fgI = amj.outHeight;
            }
            bVar2 = a;
        }
        bi biVar = new bi();
        if (wXMediaMessage.thumbData != null && wXMediaMessage.thumbData.length > 0) {
            if (wXMediaMessage.thumbData.length <= 65536 || wXMediaMessage.getType() == 36 || wXMediaMessage.getType() == 46) {
                W = o.ahl().W(wXMediaMessage.thumbData);
            } else {
                W = o.ahl().a(wXMediaMessage.thumbData, bVar.type == 2, CompressFormat.JPEG);
            }
            ab.d("MicroMsg.AppMsgLogic", g.Mq() + " summerbig thumbData MsgInfo path:" + W);
            if (!bo.isNullOrNil(W)) {
                biVar.jv(W);
            }
        }
        if (bVar2 != null) {
            bVar.csD = bVar2.xDa;
        }
        for (String W2 : bo.P(str.split(","))) {
            bVar.fgq = str2;
            biVar.setContent(b.a(bVar, null, null));
            biVar.setStatus(1);
            biVar.ju(W2);
            biVar.eJ(bf.oC(W2));
            biVar.hO(1);
            biVar.setType(d(bVar));
            if (com.tencent.mm.aj.f.kq(biVar.field_talker)) {
                biVar.ix(com.tencent.mm.aj.a.e.aae());
            }
            aw.ZK();
            long Z = com.tencent.mm.model.c.XO().Z(biVar);
            if (Z < 0) {
                ab.e("MicroMsg.AppMsgLogic", g.Mq() + " summerbig insert msg failed :" + Z);
                line = 0 - g.getLine();
                AppMethodBeat.o(27343);
                return line;
            }
            ab.i("MicroMsg.AppMsgLogic", g.getLine() + " summerbig new msg inserted to db , local id = " + Z);
            biVar.setMsgId(Z);
            j jVar = new j();
            jVar.field_xml = biVar.field_content;
            jVar.field_title = wXMediaMessage.title;
            jVar.field_type = wXMediaMessage.mediaObject.type();
            jVar.field_description = wXMediaMessage.description;
            jVar.field_msgId = Z;
            jVar.field_source = bVar.appName;
            am.dhN().b((c) jVar);
            if (bVar2 != null) {
                bVar2.field_msgInfoId = Z;
                bVar2.field_status = 101;
                ab.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg update attInfo field_msgInfoId[%d], field_status[%d], systemRowid[%d], type[%d]", Long.valueOf(bVar2.field_msgInfoId), Long.valueOf(bVar2.field_status), Long.valueOf(bVar2.xDa), Integer.valueOf(jVar.field_type));
                am.aUq().a(bVar2, new String[0]);
                if (!bo.isNullOrNil(str3)) {
                    am.dhP().z(bVar2.field_msgInfoId, str3);
                }
                am.dhP().run();
            } else {
                ab.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg dosceneSendAppMsg attInfo[%s], msgId[%d], sessionId[%s], type[%d]", bVar2, Long.valueOf(Z), str3, Integer.valueOf(jVar.field_type));
                am.dhP();
                com.tencent.mm.pluginsdk.model.app.al.a.A(Z, str3);
            }
        }
        AppMethodBeat.o(27343);
        return 0;
    }

    public static String bH(byte[] bArr) {
        AppMethodBeat.i(27344);
        if (bo.cb(bArr)) {
            ab.e("MicroMsg.AppMsgLogic", g.Mq() + " attachBuf is null");
            AppMethodBeat.o(27344);
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        aw.ZK();
        String stringBuilder2 = stringBuilder.append(com.tencent.mm.model.c.Ye()).append("ua_").append(bo.anU()).toString();
        ab.d("MicroMsg.AppMsgLogic", g.Mq() + " buildUploadAttachInfo file:" + stringBuilder2);
        if (com.tencent.mm.vfs.e.b(stringBuilder2, bArr, bArr.length) != 0) {
            ab.e("MicroMsg.AppMsgLogic", g.Mq() + " writeFile error file:" + stringBuilder2);
            AppMethodBeat.o(27344);
            return null;
        }
        AppMethodBeat.o(27344);
        return stringBuilder2;
    }

    public static String b(b bVar, WXMediaMessage wXMediaMessage, String str) {
        AppMethodBeat.i(27345);
        ab.d("MicroMsg.AppMsgLogic", g.Mq() + "mediaMessageToContent sdkver:" + wXMediaMessage.sdkVer + " title:" + wXMediaMessage.title + " desc:" + wXMediaMessage.description + " type:" + wXMediaMessage.mediaObject.type());
        bVar.sdkVer = wXMediaMessage.sdkVer;
        bVar.title = wXMediaMessage.title;
        bVar.description = wXMediaMessage.description;
        bVar.mediaTagName = wXMediaMessage.mediaTagName;
        bVar.messageAction = wXMediaMessage.messageAction;
        bVar.messageExt = wXMediaMessage.messageExt;
        IMediaObject iMediaObject = wXMediaMessage.mediaObject;
        bVar.type = iMediaObject.type();
        String str2;
        if (bVar.type == 7) {
            WXAppExtendObject wXAppExtendObject = (WXAppExtendObject) iMediaObject;
            bVar.extInfo = wXAppExtendObject.extInfo;
            if (bo.cb(wXAppExtendObject.fileData)) {
                bVar.fgo = (int) com.tencent.mm.vfs.e.asZ(wXAppExtendObject.filePath);
                ab.d("MicroMsg.AppMsgLogic", g.Mq() + " read file:" + wXAppExtendObject.filePath + " len:" + bVar.fgo);
                if (bVar.fgo > 0) {
                    bVar.fgp = com.tencent.mm.vfs.e.cv(wXAppExtendObject.filePath);
                    str2 = wXAppExtendObject.filePath;
                    AppMethodBeat.o(27345);
                    return str2;
                }
                AppMethodBeat.o(27345);
                return null;
            }
            ab.d("MicroMsg.AppMsgLogic", g.Mq() + " fileData:" + wXAppExtendObject.fileData.length);
            bVar.fgo = wXAppExtendObject.fileData.length;
            str2 = bH(wXAppExtendObject.fileData);
            AppMethodBeat.o(27345);
            return str2;
        } else if (bVar.type == 6) {
            WXFileObject wXFileObject = (WXFileObject) iMediaObject;
            if (bo.cb(wXFileObject.fileData)) {
                bVar.fgo = (int) com.tencent.mm.vfs.e.asZ(wXFileObject.filePath);
                ab.d("MicroMsg.AppMsgLogic", g.Mq() + " read file:" + wXFileObject.filePath + " len:" + bVar.fgo);
                if (bVar.fgo > 0) {
                    bVar.fgp = com.tencent.mm.vfs.e.cv(wXFileObject.filePath);
                    str2 = wXFileObject.filePath;
                    AppMethodBeat.o(27345);
                    return str2;
                }
                AppMethodBeat.o(27345);
                return null;
            }
            ab.d("MicroMsg.AppMsgLogic", g.Mq() + " fileData:" + wXFileObject.fileData.length);
            bVar.fgo = wXFileObject.fileData.length;
            str2 = bH(wXFileObject.fileData);
            AppMethodBeat.o(27345);
            return str2;
        } else if (bVar.type == 2) {
            WXImageObject wXImageObject = (WXImageObject) iMediaObject;
            if (!bo.cb(wXImageObject.imageData)) {
                ab.d("MicroMsg.AppMsgLogic", g.Mq() + " fileData:" + wXImageObject.imageData.length);
                bVar.fgo = wXImageObject.imageData.length;
                str2 = bH(wXImageObject.imageData);
                AppMethodBeat.o(27345);
                return str2;
            } else if (bo.isNullOrNil(wXImageObject.imagePath)) {
                AppMethodBeat.o(27345);
                return null;
            } else {
                bVar.fgo = (int) com.tencent.mm.vfs.e.asZ(wXImageObject.imagePath);
                ab.d("MicroMsg.AppMsgLogic", g.Mq() + " read file:" + wXImageObject.imagePath + " len:" + bVar.fgo);
                if (bVar.fgo > 0) {
                    bVar.fgp = com.tencent.mm.vfs.e.cv(wXImageObject.imagePath);
                    aw.ZK();
                    String w = com.tencent.mm.vfs.j.w(new com.tencent.mm.vfs.b(com.tencent.mm.model.c.Ye(), "appmsg_img_" + System.currentTimeMillis()).dMD());
                    Options amj = com.tencent.mm.sdk.platformtools.d.amj(wXImageObject.imagePath);
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
                        ab.e(w, str3, objArr);
                        AppMethodBeat.o(27345);
                        return null;
                    } else if (r.g(wXImageObject.imagePath, "", true)) {
                        ab.i("MicroMsg.AppMsgLogic", "this picture can send raw image but must copy [%s] to [%s]", wXImageObject.imagePath, w);
                        if (com.tencent.mm.vfs.e.y(wXImageObject.imagePath, w) < 0) {
                            ab.w("MicroMsg.AppMsgLogic", "copy file error path[%s, %s]", wXImageObject.imagePath, w);
                            AppMethodBeat.o(27345);
                            return null;
                        }
                        AppMethodBeat.o(27345);
                        return w;
                    } else {
                        if (amj.outWidth > VideoFilterUtil.IMAGE_HEIGHT || amj.outHeight > VideoFilterUtil.IMAGE_HEIGHT) {
                            Bitmap d = com.tencent.mm.sdk.platformtools.d.d(wXImageObject.imagePath, VideoFilterUtil.IMAGE_HEIGHT, VideoFilterUtil.IMAGE_HEIGHT, false);
                            if (d != null) {
                                try {
                                    com.tencent.mm.sdk.platformtools.d.a(d, 100, CompressFormat.JPEG, w, true);
                                } catch (IOException e) {
                                    ab.printErrStackTrace("MicroMsg.AppMsgLogic", e, "", new Object[0]);
                                    AppMethodBeat.o(27345);
                                    return null;
                                }
                            }
                            AppMethodBeat.o(27345);
                            return null;
                        } else if (com.tencent.mm.vfs.e.y(wXImageObject.imagePath, w) < 0) {
                            AppMethodBeat.o(27345);
                            return null;
                        }
                        AppMethodBeat.o(27345);
                        return w;
                    }
                }
                AppMethodBeat.o(27345);
                return null;
            }
        } else if (bVar.type == 3) {
            WXMusicObject wXMusicObject = (WXMusicObject) iMediaObject;
            bVar.url = wXMusicObject.musicUrl;
            bVar.fgn = wXMusicObject.musicLowBandUrl;
            bVar.fgM = wXMusicObject.musicDataUrl;
            bVar.fgN = wXMusicObject.musicLowBandDataUrl;
            AppMethodBeat.o(27345);
            return null;
        } else if (bVar.type == 4) {
            WXVideoObject wXVideoObject = (WXVideoObject) iMediaObject;
            bVar.url = wXVideoObject.videoUrl;
            bVar.fgn = wXVideoObject.videoLowBandUrl;
            AppMethodBeat.o(27345);
            return null;
        } else if (bVar.type == 5) {
            WXWebpageObject wXWebpageObject = (WXWebpageObject) iMediaObject;
            bVar.url = wXWebpageObject.webpageUrl;
            if (!bo.isNullOrNil(wXWebpageObject.extInfo)) {
                bVar.extInfo = wXWebpageObject.extInfo;
            }
            if (!bo.isNullOrNil(wXWebpageObject.canvasPageXml)) {
                bVar.canvasPageXml = wXWebpageObject.canvasPageXml;
            }
            AppMethodBeat.o(27345);
            return null;
        } else {
            WXEmojiSharedObject wXEmojiSharedObject;
            if (bVar.type == 36 || bVar.type == 46) {
                WXMiniProgramObject wXMiniProgramObject = (WXMiniProgramObject) iMediaObject;
                bVar.fiP = wXMiniProgramObject.userName;
                bVar.fiO = wXMiniProgramObject.path;
                bVar.url = wXMiniProgramObject.webpageUrl;
                WxaAttributes zb = ((com.tencent.mm.plugin.appbrand.service.d) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.d.class)).zb(wXMiniProgramObject.userName);
                if (zb != null) {
                    if (zb.ayL() != null) {
                        bVar.fja = zb.ayL().axy;
                    }
                    bVar.fjb = zb.field_brandIconURL;
                    ab.i("MicroMsg.AppMsgLogic", "add appbrand version and appbrand icon url : %d, %s", Integer.valueOf(bVar.fja), bVar.fjb);
                }
            } else if (bVar.type == 1) {
                bVar.title = ((WXTextObject) iMediaObject).text;
                AppMethodBeat.o(27345);
                return null;
            } else if (bVar.type == 8) {
                WXEmojiObject wXEmojiObject = (WXEmojiObject) iMediaObject;
                if (!bo.cb(wXEmojiObject.emojiData)) {
                    ab.d("MicroMsg.AppMsgLogic", g.Mq() + " fileData:" + wXEmojiObject.emojiData.length);
                    bVar.fgo = wXEmojiObject.emojiData.length;
                    str2 = bH(wXEmojiObject.emojiData);
                    AppMethodBeat.o(27345);
                    return str2;
                } else if (bo.isNullOrNil(wXEmojiObject.emojiPath)) {
                    bVar.fgq = str;
                } else {
                    bVar.fgo = (int) com.tencent.mm.vfs.e.asZ(wXEmojiObject.emojiPath);
                    ab.d("MicroMsg.AppMsgLogic", g.Mq() + " read file:" + wXEmojiObject.emojiPath + " len:" + bVar.fgo);
                    if (bVar.fgo > 0) {
                        bVar.fgp = com.tencent.mm.vfs.e.cv(wXEmojiObject.emojiPath);
                        str2 = wXEmojiObject.emojiPath;
                        AppMethodBeat.o(27345);
                        return str2;
                    }
                    AppMethodBeat.o(27345);
                    return null;
                }
            } else if (bVar.type == 15) {
                wXEmojiSharedObject = (WXEmojiSharedObject) iMediaObject;
                bVar.thumburl = wXEmojiSharedObject.thumburl;
                bVar.fgY = wXEmojiSharedObject.packageflag;
                bVar.fgX = wXEmojiSharedObject.packageid;
                bVar.showType = 8;
                bVar.url = wXEmojiSharedObject.url;
                AppMethodBeat.o(27345);
                return null;
            } else if (bVar.type == 13) {
                wXEmojiSharedObject = (WXEmojiSharedObject) iMediaObject;
                bVar.thumburl = wXEmojiSharedObject.thumburl;
                bVar.fgY = wXEmojiSharedObject.packageflag;
                bVar.fgX = wXEmojiSharedObject.packageid;
                bVar.showType = 8;
                bVar.url = wXEmojiSharedObject.url;
                AppMethodBeat.o(27345);
                return null;
            } else if (bVar.type == 25) {
                WXDesignerSharedObject wXDesignerSharedObject = (WXDesignerSharedObject) iMediaObject;
                bVar.thumburl = wXDesignerSharedObject.thumburl;
                bVar.url = wXDesignerSharedObject.url;
                bVar.fiD = wXDesignerSharedObject.designerUIN;
                bVar.designerName = wXDesignerSharedObject.designerName;
                bVar.designerRediretctUrl = wXDesignerSharedObject.designerRediretctUrl;
                bVar.showType = 18;
                AppMethodBeat.o(27345);
                return null;
            } else if (bVar.type == 27 || bVar.type == 26) {
                WXEmojiPageSharedObject wXEmojiPageSharedObject = (WXEmojiPageSharedObject) iMediaObject;
                bVar.thumburl = wXEmojiPageSharedObject.iconUrl;
                bVar.url = wXEmojiPageSharedObject.url;
                bVar.tid = wXEmojiPageSharedObject.tid;
                bVar.fiE = wXEmojiPageSharedObject.title;
                bVar.desc = wXEmojiPageSharedObject.desc;
                bVar.iconUrl = wXEmojiPageSharedObject.iconUrl;
                bVar.secondUrl = wXEmojiPageSharedObject.secondUrl;
                bVar.pageType = wXEmojiPageSharedObject.pageType;
                bVar.showType = 20;
                AppMethodBeat.o(27345);
                return null;
            }
            AppMethodBeat.o(27345);
            return null;
        }
    }

    public static b d(bi biVar, String str) {
        AppMethodBeat.i(27346);
        b aiM = aiM(str);
        if (aiM == null) {
            s(biVar.field_msgId, biVar.field_content);
            aiM = aiM(str);
            AppMethodBeat.o(27346);
            return aiM;
        }
        AppMethodBeat.o(27346);
        return aiM;
    }

    public static b aiM(String str) {
        AppMethodBeat.i(27347);
        b bVar = new b();
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(27347);
            return null;
        }
        ab.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s", str);
        long j = bo.getLong(str, -1);
        if (j != -1) {
            am.aUq().b(j, (c) bVar);
            if (bVar.xDa != j) {
                bVar = am.aUq().aiE(str);
                if (bVar == null || !bVar.field_mediaSvrId.equals(str)) {
                    ab.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 1");
                    bVar = null;
                }
            }
        } else {
            bVar = am.aUq().aiE(str);
            if (bVar == null || !bVar.field_mediaSvrId.equals(str)) {
                ab.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 2");
                bVar = null;
            }
        }
        ab.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s id %s", str, Long.valueOf(j));
        AppMethodBeat.o(27347);
        return bVar;
    }

    public static int d(b bVar) {
        AppMethodBeat.i(27349);
        if (bVar == null) {
            AppMethodBeat.o(27349);
            return 49;
        }
        int i = bVar.type;
        int i2 = bVar.showType;
        int i3 = bVar.ffZ;
        int i4 = bVar.fgO;
        int i5 = bVar.fii;
        ab.d("MicroMsg.AppMsgLogic", "getLocalAppMsgType showType " + i2 + " atype " + i + ", itemShowType = " + i3 + ", c2cNewAAType = " + i5);
        if (i3 == 4 || i4 != 0) {
            AppMethodBeat.o(27349);
            return 318767153;
        } else if (i == 2001) {
            if (i2 == 1) {
                AppMethodBeat.o(27349);
                return 469762097;
            } else if (i5 == 4) {
                AppMethodBeat.o(27349);
                return 503316529;
            } else {
                AppMethodBeat.o(27349);
                return 436207665;
            }
        } else if (i == 2002) {
            AppMethodBeat.o(27349);
            return 536870961;
        } else {
            switch (i2) {
                case 1:
                    if (i == 21) {
                        AppMethodBeat.o(27349);
                        return -1879048185;
                    }
                    AppMethodBeat.o(27349);
                    return 285212721;
                case 2:
                    if (i == 21) {
                        AppMethodBeat.o(27349);
                        return -1879048183;
                    }
                    AppMethodBeat.o(27349);
                    return 301989937;
                case 3:
                    if (i == 21) {
                        AppMethodBeat.o(27349);
                        return -1879048176;
                    }
                    AppMethodBeat.o(27349);
                    return -1879048189;
                case 4:
                    if (i == 21) {
                        AppMethodBeat.o(27349);
                        return -1879048183;
                    }
                    AppMethodBeat.o(27349);
                    return -1879048190;
                case 5:
                    AppMethodBeat.o(27349);
                    return -1879048191;
                case 17:
                    AppMethodBeat.o(27349);
                    return -1879048186;
                default:
                    switch (i) {
                        case 1:
                            AppMethodBeat.o(27349);
                            return 16777265;
                        case 2:
                            AppMethodBeat.o(27349);
                            return 268435505;
                        case 8:
                            AppMethodBeat.o(27349);
                            return 1048625;
                        case 10:
                            AppMethodBeat.o(27349);
                            return 335544369;
                        case 13:
                            AppMethodBeat.o(27349);
                            return 369098801;
                        case 16:
                            AppMethodBeat.o(27349);
                            return 452984881;
                        case 17:
                            AppMethodBeat.o(27349);
                            return -1879048186;
                        case 20:
                            AppMethodBeat.o(27349);
                            return 402653233;
                        case 33:
                            com.tencent.mm.af.a aVar = (com.tencent.mm.af.a) bVar.X(com.tencent.mm.af.a.class);
                            if (aVar != null && aVar.feY && (bVar.fiR == 2 || bVar.fiR == 3)) {
                                AppMethodBeat.o(27349);
                                return 553648177;
                            } else if (aVar != null && aVar.ffb && bVar.fiR == 3) {
                                AppMethodBeat.o(27349);
                                return 587202609;
                            } else {
                                AppMethodBeat.o(27349);
                                return 49;
                            }
                        case 34:
                            AppMethodBeat.o(27349);
                            return 520093745;
                        case 46:
                            AppMethodBeat.o(27349);
                            return 687865905;
                        case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                            AppMethodBeat.o(27349);
                            return 704643121;
                        case 2000:
                            AppMethodBeat.o(27349);
                            return 419430449;
                        case 671088689:
                            AppMethodBeat.o(27349);
                            return 671088689;
                        default:
                            AppMethodBeat.o(27349);
                            return 49;
                    }
            }
        }
    }

    public static int Kx(int i) {
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

    public static void a(bi biVar, final a aVar) {
        AppMethodBeat.i(27328);
        b me = b.me(biVar.field_content);
        if (me == null) {
            ab.e("MicroMsg.AppMsgLogic", "parse msgContent error, %s", biVar.field_content);
            AppMethodBeat.o(27328);
            return;
        }
        if (bo.isNullOrNil(me.csD) && !bo.isNullOrNil(me.fgD)) {
            ab.e("MicroMsg.AppMsgLogic", "msgContent format error, %s", biVar.field_content);
            me.csD = me.fgD.hashCode();
        }
        String str = me.csD;
        if (!a(biVar, i(str, biVar.field_msgId)) && d(str, biVar)) {
            pJg = new e(biVar.field_msgId, str, new com.tencent.mm.ai.g() {
                public final void a(int i, int i2, m mVar) {
                    AppMethodBeat.i(27323);
                    if (aVar != null) {
                        aVar.gK(i, i2);
                    }
                    AppMethodBeat.o(27323);
                }
            });
            aw.Rg().a(pJg, 0);
        }
        AppMethodBeat.o(27328);
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
    public static void al(bi biVar) {
        AppMethodBeat.i(27348);
        b me = b.me(biVar.field_content);
        if (me == null) {
            ab.e("MicroMsg.AppMsgLogic", "resend app message error: app content null");
            AppMethodBeat.o(27348);
            return;
        }
        byte[] e;
        b a;
        String str;
        String str2;
        b a2;
        bi biVar2;
        String a3;
        long Z;
        b aiM = aiM(me.csD);
        String str3 = "";
        if (!(aiM == null || aiM.field_fileFullPath == null || aiM.field_fileFullPath.equals(""))) {
            aw.ZK();
            str3 = X(com.tencent.mm.model.c.Ye(), me.title, me.fgp);
            com.tencent.mm.vfs.e.y(aiM.field_fileFullPath, str3);
        }
        if (!(biVar.field_imgPath == null || biVar.field_imgPath.equals(""))) {
            try {
                e = com.tencent.mm.vfs.e.e(o.ahl().I(biVar.field_imgPath, true), 0, -1);
            } catch (Exception e2) {
            }
            a = b.a(me);
            str = me.appName;
            str2 = System.currentTimeMillis();
            if (bo.isNullOrNil(str3)) {
                a2 = a(str2, a, str3);
                if (a2 == null) {
                    g.getLine();
                    AppMethodBeat.o(27348);
                    return;
                }
            }
            a2 = null;
            biVar2 = new bi();
            if (e != null && e.length > 0) {
                if (a.type != 46) {
                    a3 = o.ahl().a(e, CompressFormat.JPEG);
                } else {
                    boolean z;
                    if (a.type == 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    a3 = o.ahl().a(e, z, CompressFormat.PNG);
                }
                ab.d("MicroMsg.AppMsgLogic", g.Mq() + " thumbData MsgInfo path:" + a3);
                if (!bo.isNullOrNil(a3)) {
                    biVar2.jv(a3);
                    ab.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path".concat(String.valueOf(a3)));
                }
            }
            if (a2 != null) {
                a.csD = a2.xDa;
            }
            biVar2.setContent(b.a(a, null, null));
            biVar2.setStatus(1);
            biVar2.ju(biVar.field_talker);
            biVar2.eJ(bf.oC(biVar.field_talker));
            biVar2.hO(1);
            biVar2.setType(d(a));
            if (com.tencent.mm.aj.f.kq(biVar2.field_talker)) {
                biVar2.ix(com.tencent.mm.aj.a.e.aae());
                ab.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", biVar2.dqJ);
            }
            aw.ZK();
            Z = com.tencent.mm.model.c.XO().Z(biVar2);
            ab.d("MicroMsg.AppMsgLogic", g.Mq() + " msginfo insert id: " + Z);
            if (Z >= 0) {
                ab.e("MicroMsg.AppMsgLogic", g.Mq() + "insert msg failed :" + Z);
                g.getLine();
                AppMethodBeat.o(27348);
                return;
            }
            ab.i("MicroMsg.AppMsgLogic", g.getLine() + " new msg inserted to db , local id = " + Z);
            biVar2.setMsgId(Z);
            tq tqVar = new tq();
            tqVar.cPN.cPO = biVar.field_msgId;
            tqVar.cPN.cPP = Z;
            com.tencent.mm.sdk.b.a.xxA.m(tqVar);
            j jVar = new j();
            jVar.field_xml = biVar2.field_content;
            jVar.field_title = a.title;
            jVar.field_type = a.type;
            jVar.field_description = a.description;
            jVar.field_msgId = Z;
            jVar.field_source = str;
            am.dhN().b((c) jVar);
            if (a2 != null) {
                a2.field_msgInfoId = Z;
                a2.field_status = 101;
                am.aUq().a(a2, new String[0]);
                am.dhP().run();
                AppMethodBeat.o(27348);
                return;
            }
            am.dhP();
            com.tencent.mm.pluginsdk.model.app.al.a.jB(Z);
            AppMethodBeat.o(27348);
            return;
        }
        e = null;
        a = b.a(me);
        str = me.appName;
        str2 = System.currentTimeMillis();
        if (bo.isNullOrNil(str3)) {
        }
        biVar2 = new bi();
        if (a.type != 46) {
        }
        ab.d("MicroMsg.AppMsgLogic", g.Mq() + " thumbData MsgInfo path:" + a3);
        if (bo.isNullOrNil(a3)) {
        }
        if (a2 != null) {
        }
        biVar2.setContent(b.a(a, null, null));
        biVar2.setStatus(1);
        biVar2.ju(biVar.field_talker);
        biVar2.eJ(bf.oC(biVar.field_talker));
        biVar2.hO(1);
        biVar2.setType(d(a));
        if (com.tencent.mm.aj.f.kq(biVar2.field_talker)) {
        }
        aw.ZK();
        Z = com.tencent.mm.model.c.XO().Z(biVar2);
        ab.d("MicroMsg.AppMsgLogic", g.Mq() + " msginfo insert id: " + Z);
        if (Z >= 0) {
        }
    }
}
