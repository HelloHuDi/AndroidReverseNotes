package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;

public final class a {
    private static e pJg;

    public interface a {
    }

    public static void jC(long j) {
        AppMethodBeat.i(135620);
        com.tencent.mm.plugin.s.a.aUq().lY(j);
        b bVar = new b();
        com.tencent.mm.plugin.s.a.aUq().b(j, (c) bVar);
        if (bVar.field_msgInfoId <= 0) {
            AppMethodBeat.o(135620);
            return;
        }
        bi jf = ((j) g.K(j.class)).bOr().jf(bVar.field_msgInfoId);
        if (jf.field_msgId != bVar.field_msgInfoId) {
            AppMethodBeat.o(135620);
            return;
        }
        jf.setStatus(5);
        ((j) g.K(j.class)).bOr().a(jf.field_msgId, jf);
        AppMethodBeat.o(135620);
    }

    public static boolean a(bi biVar, b bVar) {
        AppMethodBeat.i(135621);
        if (bVar == null || !e.ct(bVar.field_fileFullPath)) {
            AppMethodBeat.o(135621);
            return false;
        } else if (bVar.bCR() || (biVar.field_isSend == 1 && bVar.field_isUpload)) {
            AppMethodBeat.o(135621);
            return true;
        } else {
            AppMethodBeat.o(135621);
            return false;
        }
    }

    private static String X(String str, String str2, String str3) {
        String str4;
        int i = 1;
        AppMethodBeat.i(135623);
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
            if (e.ct(str4)) {
                while (i < 20) {
                    if (!e.ct(str + i + "_" + str2)) {
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
        AppMethodBeat.o(135623);
        return str4;
    }

    private static String a(String str, long j, int i, String str2, String str3, int i2, int i3, int i4) {
        AppMethodBeat.i(135624);
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
        ab.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach ret[%b], rowid[%d], field_totalLen[%d], type[%d], isLargeFile[%d], destFile[%s], stack[%s]", Boolean.valueOf(com.tencent.mm.plugin.s.a.aUq().b((c) bVar)), Long.valueOf(bVar.xDa), Long.valueOf(bVar.field_totalLen), Long.valueOf(bVar.field_type), Integer.valueOf(i4), str, bo.dpG());
        AppMethodBeat.o(135624);
        return str3;
    }

    private static String s(long j, String str) {
        AppMethodBeat.i(135625);
        ab.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach msgLocalId[%d], msgXml[%s], downloadPath[%s]", Long.valueOf(j), str, null);
        com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(str);
        if (me == null) {
            AppMethodBeat.o(135625);
            return null;
        }
        String X = X(com.tencent.mm.compatible.util.e.euQ, me.title, me.fgp);
        if (bo.isNullOrNil(me.csD) && !bo.isNullOrNil(me.fgD)) {
            me.csD = me.fgD.hashCode();
        }
        String a = a(X, j, me.sdkVer, me.appId, me.csD, me.fgo, me.type, me.fgs);
        AppMethodBeat.o(135625);
        return a;
    }

    public static b i(String str, long j) {
        AppMethodBeat.i(135619);
        b bVar = new b();
        if (bo.isNullOrNil(str)) {
            bVar = null;
        } else {
            ab.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s", str);
            long j2 = bo.getLong(str, -1);
            if (j2 != -1) {
                com.tencent.mm.plugin.s.a.aUq().b(j2, (c) bVar);
                if (bVar.xDa != j2) {
                    bVar = com.tencent.mm.plugin.s.a.aUq().aiE(str);
                    if (bVar == null || !bVar.field_mediaSvrId.equals(str)) {
                        ab.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 1");
                        bVar = null;
                    }
                }
            } else {
                bVar = com.tencent.mm.plugin.s.a.aUq().aiE(str);
                if (bVar == null || !bVar.field_mediaSvrId.equals(str)) {
                    ab.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 2");
                    bVar = null;
                }
            }
            ab.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s id %s", str, Long.valueOf(j2));
        }
        if (bVar == null) {
            bVar = com.tencent.mm.plugin.s.a.aUq().lZ(j);
        }
        if (bVar != null) {
            ab.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo info[%s], rowid[%d], isUpload[%b], fullpath[%s], totallen[%d], offset[%d], mediaSvrId[%s], mediaid[%s], msgid[%d], type[%d], stack[%s]", bVar, Long.valueOf(bVar.xDa), Boolean.valueOf(bVar.field_isUpload), bVar.field_fileFullPath, Long.valueOf(bVar.field_totalLen), Long.valueOf(bVar.field_offset), bVar.field_mediaSvrId, bVar.field_mediaId, Long.valueOf(bVar.field_msgInfoId), Long.valueOf(bVar.field_type), bo.dpG());
        } else {
            ab.w("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo is null stack[%s]", bo.dpG());
        }
        AppMethodBeat.o(135619);
        return bVar;
    }

    public static void af(bi biVar) {
        AppMethodBeat.i(135622);
        com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(biVar.field_content);
        if (me == null) {
            ab.e("MicroMsg.AppMsgLogic", "parse msgContent error, %s", biVar.field_content);
            AppMethodBeat.o(135622);
            return;
        }
        if (bo.isNullOrNil(me.csD) && !bo.isNullOrNil(me.fgD)) {
            ab.e("MicroMsg.AppMsgLogic", "msgContent format error, %s", biVar.field_content);
            me.csD = me.fgD.hashCode();
        }
        String str = me.csD;
        if (!a(biVar, i(str, biVar.field_msgId))) {
            Object obj;
            if (biVar == null) {
                obj = null;
            } else {
                Object obj2 = 1;
                String str2 = null;
                String str3 = null;
                String str4 = null;
                String str5 = null;
                String str6 = null;
                b i = i(str, biVar.field_msgId);
                com.tencent.mm.af.j.b me2 = com.tencent.mm.af.j.b.me(biVar.field_content);
                if (me2 != null) {
                    str2 = bo.nullAsNil(me2.title);
                    str3 = bo.nullAsNil(me2.fgp).toLowerCase();
                    str4 = bo.nullAsNil(me2.filemd5);
                    str5 = bo.nullAsNil(me2.cEV);
                    str6 = bo.nullAsNil(me2.eyr);
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
                        if (me2 != null && (me2.fgs != 0 || me2.fgo > 26214400)) {
                            if (bo.isNullOrNil(i.field_signature)) {
                                obj = null;
                            } else {
                                obj = 1;
                            }
                            obj2 = obj;
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
                if (obj2 == null) {
                    g.RO().eJo.a(new c(i, str6, str4, str2, str3, str5), 0);
                }
                obj = obj2;
            }
            if (obj != null) {
                pJg = new e(biVar.field_msgId, str, new com.tencent.mm.ai.g() {
                    final /* synthetic */ a pJh = null;

                    public final void a(int i, int i2, m mVar) {
                    }
                });
                g.RO().eJo.a(pJg, 0);
            }
        }
        AppMethodBeat.o(135622);
    }
}
