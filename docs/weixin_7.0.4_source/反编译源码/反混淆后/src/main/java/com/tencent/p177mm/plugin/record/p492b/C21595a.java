package com.tencent.p177mm.plugin.record.p492b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C32231g;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;

/* renamed from: com.tencent.mm.plugin.record.b.a */
public final class C21595a {
    private static C43432e pJg;

    /* renamed from: com.tencent.mm.plugin.record.b.a$1 */
    static class C215961 implements C32231g {
        final /* synthetic */ C21597a pJh = null;

        C215961() {
        }

        /* renamed from: a */
        public final void mo8280a(int i, int i2, C1207m c1207m) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.record.b.a$a */
    public interface C21597a {
    }

    /* renamed from: jC */
    public static void m33071jC(long j) {
        AppMethodBeat.m2504i(135620);
        C34832a.aUq().mo48328lY(j);
        C30065b c30065b = new C30065b();
        C34832a.aUq().mo16761b(j, (C4925c) c30065b);
        if (c30065b.field_msgInfoId <= 0) {
            AppMethodBeat.m2505o(135620);
            return;
        }
        C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(c30065b.field_msgInfoId);
        if (jf.field_msgId != c30065b.field_msgInfoId) {
            AppMethodBeat.m2505o(135620);
            return;
        }
        jf.setStatus(5);
        ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(jf.field_msgId, jf);
        AppMethodBeat.m2505o(135620);
    }

    /* renamed from: a */
    public static boolean m33068a(C7620bi c7620bi, C30065b c30065b) {
        AppMethodBeat.m2504i(135621);
        if (c30065b == null || !C5730e.m8628ct(c30065b.field_fileFullPath)) {
            AppMethodBeat.m2505o(135621);
            return false;
        } else if (c30065b.bCR() || (c7620bi.field_isSend == 1 && c30065b.field_isUpload)) {
            AppMethodBeat.m2505o(135621);
            return true;
        } else {
            AppMethodBeat.m2505o(135621);
            return false;
        }
    }

    /* renamed from: X */
    private static String m33066X(String str, String str2, String str3) {
        String str4;
        int i = 1;
        AppMethodBeat.m2504i(135623);
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
        AppMethodBeat.m2505o(135623);
        return str4;
    }

    /* renamed from: a */
    private static String m33067a(String str, long j, int i, String str2, String str3, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(135624);
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
        C4990ab.m7417i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach ret[%b], rowid[%d], field_totalLen[%d], type[%d], isLargeFile[%d], destFile[%s], stack[%s]", Boolean.valueOf(C34832a.aUq().mo10101b((C4925c) c30065b)), Long.valueOf(c30065b.xDa), Long.valueOf(c30065b.field_totalLen), Long.valueOf(c30065b.field_type), Integer.valueOf(i4), str, C5046bo.dpG());
        AppMethodBeat.m2505o(135624);
        return str3;
    }

    /* renamed from: s */
    private static String m33072s(long j, String str) {
        AppMethodBeat.m2504i(135625);
        C4990ab.m7417i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach msgLocalId[%d], msgXml[%s], downloadPath[%s]", Long.valueOf(j), str, null);
        C8910b me = C8910b.m16064me(str);
        if (me == null) {
            AppMethodBeat.m2505o(135625);
            return null;
        }
        String X = C21595a.m33066X(C6457e.euQ, me.title, me.fgp);
        if (C5046bo.isNullOrNil(me.csD) && !C5046bo.isNullOrNil(me.fgD)) {
            me.csD = me.fgD.hashCode();
        }
        String a = C21595a.m33067a(X, j, me.sdkVer, me.appId, me.csD, me.fgo, me.type, me.fgs);
        AppMethodBeat.m2505o(135625);
        return a;
    }

    /* renamed from: i */
    public static C30065b m33070i(String str, long j) {
        AppMethodBeat.m2504i(135619);
        C30065b c30065b = new C30065b();
        if (C5046bo.isNullOrNil(str)) {
            c30065b = null;
        } else {
            C4990ab.m7417i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s", str);
            long j2 = C5046bo.getLong(str, -1);
            if (j2 != -1) {
                C34832a.aUq().mo16761b(j2, (C4925c) c30065b);
                if (c30065b.xDa != j2) {
                    c30065b = C34832a.aUq().aiE(str);
                    if (c30065b == null || !c30065b.field_mediaSvrId.equals(str)) {
                        C4990ab.m7416i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 1");
                        c30065b = null;
                    }
                }
            } else {
                c30065b = C34832a.aUq().aiE(str);
                if (c30065b == null || !c30065b.field_mediaSvrId.equals(str)) {
                    C4990ab.m7416i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 2");
                    c30065b = null;
                }
            }
            C4990ab.m7417i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s id %s", str, Long.valueOf(j2));
        }
        if (c30065b == null) {
            c30065b = C34832a.aUq().mo48329lZ(j);
        }
        if (c30065b != null) {
            C4990ab.m7417i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo info[%s], rowid[%d], isUpload[%b], fullpath[%s], totallen[%d], offset[%d], mediaSvrId[%s], mediaid[%s], msgid[%d], type[%d], stack[%s]", c30065b, Long.valueOf(c30065b.xDa), Boolean.valueOf(c30065b.field_isUpload), c30065b.field_fileFullPath, Long.valueOf(c30065b.field_totalLen), Long.valueOf(c30065b.field_offset), c30065b.field_mediaSvrId, c30065b.field_mediaId, Long.valueOf(c30065b.field_msgInfoId), Long.valueOf(c30065b.field_type), C5046bo.dpG());
        } else {
            C4990ab.m7421w("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo is null stack[%s]", C5046bo.dpG());
        }
        AppMethodBeat.m2505o(135619);
        return c30065b;
    }

    /* renamed from: af */
    public static void m33069af(C7620bi c7620bi) {
        AppMethodBeat.m2504i(135622);
        C8910b me = C8910b.m16064me(c7620bi.field_content);
        if (me == null) {
            C4990ab.m7413e("MicroMsg.AppMsgLogic", "parse msgContent error, %s", c7620bi.field_content);
            AppMethodBeat.m2505o(135622);
            return;
        }
        if (C5046bo.isNullOrNil(me.csD) && !C5046bo.isNullOrNil(me.fgD)) {
            C4990ab.m7413e("MicroMsg.AppMsgLogic", "msgContent format error, %s", c7620bi.field_content);
            me.csD = me.fgD.hashCode();
        }
        String str = me.csD;
        if (!C21595a.m33068a(c7620bi, C21595a.m33070i(str, c7620bi.field_msgId))) {
            Object obj;
            if (c7620bi == null) {
                obj = null;
            } else {
                Object obj2 = 1;
                String str2 = null;
                String str3 = null;
                String str4 = null;
                String str5 = null;
                String str6 = null;
                C30065b i = C21595a.m33070i(str, c7620bi.field_msgId);
                C8910b me2 = C8910b.m16064me(c7620bi.field_content);
                if (me2 != null) {
                    str2 = C5046bo.nullAsNil(me2.title);
                    str3 = C5046bo.nullAsNil(me2.fgp).toLowerCase();
                    str4 = C5046bo.nullAsNil(me2.filemd5);
                    str5 = C5046bo.nullAsNil(me2.cEV);
                    str6 = C5046bo.nullAsNil(me2.eyr);
                }
                String str7;
                if (i == null) {
                    C21595a.m33072s(c7620bi.field_msgId, c7620bi.field_content);
                    i = C21595a.m33070i(str, c7620bi.field_msgId);
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
                        if (me2 != null && (me2.fgs != 0 || me2.fgo > 26214400)) {
                            if (C5046bo.isNullOrNil(i.field_signature)) {
                                obj = null;
                            } else {
                                obj = 1;
                            }
                            obj2 = obj;
                        }
                    }
                } else {
                    C5728b c5728b = new C5728b(i.field_fileFullPath);
                    if (i.field_status == 199 && !c5728b.exists()) {
                        C4990ab.m7416i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist but file not!");
                        C21595a.m33072s(c7620bi.field_msgId, c7620bi.field_content);
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
                if (obj2 == null) {
                    C1720g.m3535RO().eJo.mo14541a(new C43430c(i, str6, str4, str2, str3, str5), 0);
                }
                obj = obj2;
            }
            if (obj != null) {
                pJg = new C43432e(c7620bi.field_msgId, str, new C215961());
                C1720g.m3535RO().eJo.mo14541a(pJg, 0);
            }
        }
        AppMethodBeat.m2505o(135622);
    }
}
