package com.tencent.p177mm.pluginsdk.p592g.p593a.p594a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p1570d.C40433a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C14839b.C14845c;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C14856q.C14857a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C44049s;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.pluginsdk.g.a.a.f */
final class C40424f {

    /* renamed from: com.tencent.mm.pluginsdk.g.a.a.f$a */
    static final class C4712a {
        /* renamed from: a */
        static void m7064a(boolean z, boolean z2, C44049s c44049s, C46488g c46488g) {
            AppMethodBeat.m2504i(79513);
            C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "sendIORequest, fileAppend = %b, fileUpdate = %b", Boolean.valueOf(z), Boolean.valueOf(z2));
            if (c44049s.field_maxRetryTimes <= 0 || c44049s.field_retryTimes > 0 || z2) {
                c44049s.field_reportId = c46488g.vdK;
                c44049s.field_status = 0;
                if (z2) {
                    c44049s.field_maxRetryTimes = c46488g.vdM;
                    c44049s.field_retryTimes = c46488g.vdM;
                    c44049s.field_fileUpdated = true;
                    c44049s.field_priority = c46488g.priority;
                    if (c46488g.fileSize > 0) {
                        c44049s.field_fileSize = c46488g.fileSize;
                    }
                    C14857a.vfA.mo27179h(c44049s);
                } else {
                    c44049s.field_retryTimes--;
                    c44049s.field_priority = c46488g.priority;
                    C14857a.vfA.mo27179h(c44049s);
                    C23236j.m35639z(c44049s.field_reportId, 12);
                }
                if (C14857a.vfA.ajh(c46488g.vdC)) {
                    C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "urlKey = %s is already downloading", c46488g.vdC);
                    if (c46488g.cuA) {
                        C23236j.m35639z(c46488g.vdK, 9);
                        C23236j.m35639z(c46488g.vdK, 44);
                    }
                    AppMethodBeat.m2505o(79513);
                    return;
                }
                C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "urlKey = %s, post network task", c46488g.vdC);
                if (z2 && !z) {
                    C14845c.veg.mo27153g(c44049s.field_resType, c44049s.field_subType, 0, C5046bo.nullAsNil(c44049s.field_groupId2).equals("NewXml"));
                }
                C14852c d = C14852c.m23110d(c44049s);
                d.ufy = z;
                d.veh = c46488g.veh;
                if (!z) {
                    C40433a.ajj(C30039i.aiX(d.vdC));
                    C40433a.ajj(C30039i.aiX(d.vdC) + ".decompressed");
                    C40433a.ajj(C30039i.aiX(d.vdC) + ".decrypted");
                }
                C14857a.vfA.mo27178d(d);
                AppMethodBeat.m2505o(79513);
                return;
            }
            C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "record_maxRetryTimes = %d, record_retryTimes = %d, retry times out, skip", Integer.valueOf(c44049s.field_maxRetryTimes), Integer.valueOf(c44049s.field_retryTimes));
            AppMethodBeat.m2505o(79513);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.g.a.a.f$b */
    static final class C35785b {
        /* renamed from: a */
        static void m58651a(C44049s c44049s, boolean z, boolean z2) {
            AppMethodBeat.m2504i(79514);
            if (c44049s == null) {
                C4990ab.m7416i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "get null record, skip");
                AppMethodBeat.m2505o(79514);
                return;
            }
            String str = c44049s.field_urlKey;
            String str2 = c44049s.field_filePath;
            String str3 = c44049s.field_md5;
            boolean z3 = c44049s.field_fileCompress;
            boolean z4 = c44049s.field_fileEncrypt;
            byte[] bArr = c44049s.field_eccSignature;
            int i = C5046bo.getInt(c44049s.field_fileVersion, 0);
            int i2 = c44049s.field_keyVersion;
            String str4 = c44049s.field_encryptKey;
            boolean z5 = c44049s.field_deleted;
            C4990ab.m7416i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "queried info: deleted = " + z5 + ", filePath = " + str2 + ", md5 = " + str3 + ", originalMd5 = " + c44049s.field_originalMd5 + ", fileCompress = " + z3 + ", fileEncrypt = " + z4 + ", eccSignature = " + bArr + ", fileVersion = " + i + ", (encrypt key == empty) = " + C5046bo.isNullOrNil(str4));
            C4990ab.m7411d("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "queried encryptKey = %s", str4);
            if (!z4) {
                if (z) {
                    C23236j.m35639z(c44049s.field_reportId, 53);
                    C23236j.m35639z(c44049s.field_reportId, 45);
                }
                if (!z3) {
                    C4990ab.m7412e("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "file is not encrypted nor compressed, just return");
                    AppMethodBeat.m2505o(79514);
                    return;
                }
            }
            if (i2 != i && z4) {
                C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "file version(%d) != key version(%d), skip", Integer.valueOf(i), Integer.valueOf(i2));
                if (i2 >= 0) {
                    C23236j.m35639z(c44049s.field_reportId, 52);
                    C23236j.m35639z(c44049s.field_reportId, 45);
                }
                AppMethodBeat.m2505o(79514);
            } else if (z5) {
                C4990ab.m7416i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "this file should have been deleted, skip this decrypt-op");
                C23236j.m35639z(c44049s.field_reportId, 51);
                C23236j.m35639z(c44049s.field_reportId, 45);
                AppMethodBeat.m2505o(79514);
            } else if (C5046bo.isNullOrNil(str4) && z4) {
                C4990ab.m7416i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "encryptKey invalid, skip");
                C23236j.m35639z(c44049s.field_reportId, 54);
                C23236j.m35639z(c44049s.field_reportId, 45);
                AppMethodBeat.m2505o(79514);
            } else {
                if (C5046bo.isNullOrNil(str3) || C5046bo.isNullOrNil(str2)) {
                    C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "this decrypt-op is invalid, record.md5 = %s, record.filePath = %s", str3, str2);
                } else if (C14857a.vfA.ajh(str)) {
                    C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "request(%s) is downloading or queueing, hold this decrypt-op", str);
                    AppMethodBeat.m2505o(79514);
                    return;
                } else if (!C5046bo.nullAsNil(C1178g.m2587cz(str2)).equals(str3)) {
                    C4990ab.m7416i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "md5 not match, file spoiled, skip this decrypt-op");
                    c44049s.field_status = 3;
                    C14857a.vfA.mo27179h(c44049s);
                    C23236j.m35639z(c44049s.field_reportId, 56);
                    C23236j.m35639z(c44049s.field_reportId, 45);
                    AppMethodBeat.m2505o(79514);
                    return;
                } else if (!C14857a.vfA.ajh(str)) {
                    C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "request supposed to complete, send decrypt request %s", c44049s.field_urlKey);
                    C14845c.veg.mo27153g(c44049s.field_resType, c44049s.field_subType, 1, C5046bo.nullAsNil(c44049s.field_groupId2).equals("NewXml"));
                    if (z2) {
                        C14845c.veg;
                        C14839b.m23096c(c44049s);
                        AppMethodBeat.m2505o(79514);
                        return;
                    }
                    C14845c.veg.mo27149b(c44049s);
                    AppMethodBeat.m2505o(79514);
                    return;
                }
                AppMethodBeat.m2505o(79514);
            }
        }
    }
}
