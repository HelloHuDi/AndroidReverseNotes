package com.tencent.p177mm.pluginsdk.p592g.p593a.p594a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p1570d.C40433a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C14839b.C14845c;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C14839b.C14851b;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C14856q;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C14856q.C14857a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C44049s;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C4722h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.pluginsdk.g.a.a.h */
final class C40426h implements C4722h {
    C40426h() {
    }

    /* renamed from: a */
    public final void mo9857a(C44049s c44049s, int i) {
        AppMethodBeat.m2504i(79520);
        if (c44049s.field_expireTime != 0 && c44049s.field_expireTime <= C5046bo.anT()) {
            C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "urlKey(%s) exceed expire time(%d), delete", c44049s.field_urlKey, Long.valueOf(c44049s.field_expireTime));
            C14856q diy = C14857a.vfA;
            String str = c44049s.field_urlKey;
            if (diy.hrm) {
                diy.vfx.mo69740pI(str);
            }
            C40433a.ajj(c44049s.field_filePath);
            C40433a.ajj(c44049s.field_filePath + ".decompressed");
            C40433a.ajj(c44049s.field_filePath + ".decrypted");
            C14857a.vfA.mo27172AH(c44049s.field_urlKey);
            AppMethodBeat.m2505o(79520);
        } else if (i == 0) {
            C4990ab.m7416i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "network unavailable, skip");
            AppMethodBeat.m2505o(79520);
        } else if (2 == i && 1 == c44049s.field_networkType) {
            C4990ab.m7416i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "network type = gprs, record network type = wifi, skip this ");
            AppMethodBeat.m2505o(79520);
        } else if (c44049s.field_deleted) {
            C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "record(%s), should have been deleted", c44049s.field_urlKey);
            C40433a.ajj(c44049s.field_filePath);
            C40433a.ajj(c44049s.field_filePath + ".decompressed");
            C40433a.ajj(c44049s.field_filePath + ".decrypted");
            AppMethodBeat.m2505o(79520);
        } else if (!c44049s.field_needRetry) {
            C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "no need retry, resType %d, subType %d, version %s", Integer.valueOf(c44049s.field_resType), Integer.valueOf(c44049s.field_subType), c44049s.field_fileVersion);
            AppMethodBeat.m2505o(79520);
        } else if (c44049s.field_status == 2) {
            long ek = C40433a.m69347ek(c44049s.field_filePath);
            if (c44049s.field_contentLength > ek) {
                C4990ab.m7416i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "content-length > fileSize, resume download");
                if (0 == ek) {
                    if (!c44049s.field_needRetry) {
                        C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "no need retry, resType %d, subType %d, version %s", Integer.valueOf(c44049s.field_resType), Integer.valueOf(c44049s.field_subType), c44049s.field_fileVersion);
                        AppMethodBeat.m2505o(79520);
                        return;
                    } else if (1 != i) {
                        C4990ab.m7416i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "fileSize = 0, completed file may be deleted by user, skip this because it's not wifi");
                        AppMethodBeat.m2505o(79520);
                        return;
                    } else {
                        for (C14851b c14851b : C14845c.veg.dic()) {
                            C5046bo.getInt(c44049s.field_fileVersion, 0);
                            if (c14851b.die()) {
                                C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "filterNotRetry by %s, resType %d, subType %d, version %s", c14851b.getClass().getName(), Integer.valueOf(c44049s.field_resType), Integer.valueOf(c44049s.field_subType), c44049s.field_fileVersion);
                                AppMethodBeat.m2505o(79520);
                                return;
                            }
                        }
                        c44049s.field_fileUpdated = true;
                        C14845c.veg.mo27153g(c44049s.field_resType, c44049s.field_subType, 0, C5046bo.nullAsNil(c44049s.field_groupId2).equals("NewXml"));
                        C14857a.vfA.mo27179h(c44049s);
                    }
                }
                C14857a.vfA.mo27178d(C14852c.m23110d(c44049s));
                AppMethodBeat.m2505o(79520);
            } else if (C40426h.m69337e(c44049s)) {
                C4990ab.m7416i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 check ok, file download complete, throw event to do decrypt");
                C40426h.m69338f(c44049s);
                AppMethodBeat.m2505o(79520);
            } else {
                C4990ab.m7416i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "file invalid, re-download");
                C40426h.m69336a(c44049s, 1 == i);
                AppMethodBeat.m2505o(79520);
            }
        } else if (c44049s.field_status == 1 || c44049s.field_status == 0) {
            C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "db status: downloading or waiting, db content-length %d", Long.valueOf(c44049s.field_contentLength));
            if (C14857a.vfA.ajh(c44049s.field_urlKey)) {
                C4990ab.m7416i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "request already in downloading queue");
                AppMethodBeat.m2505o(79520);
                return;
            }
            C4990ab.m7410d("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "check md5");
            if (C40426h.m69337e(c44049s)) {
                C4990ab.m7416i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 match, request complete, throw event to do decrypt");
                c44049s.field_status = 2;
                c44049s.field_contentLength = C40433a.m69347ek(c44049s.field_filePath);
                C14857a.vfA.mo27179h(c44049s);
                C40426h.m69338f(c44049s);
                AppMethodBeat.m2505o(79520);
                return;
            }
            if (0 == C40433a.m69347ek(c44049s.field_filePath)) {
                c44049s.field_fileUpdated = true;
                C14857a.vfA.mo27179h(c44049s);
                C14845c.veg.mo27153g(c44049s.field_resType, c44049s.field_subType, 0, C5046bo.nullAsNil(c44049s.field_groupId2).equals("NewXml"));
            }
            C4990ab.m7416i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 not match,  download");
            C14857a.vfA.mo27178d(C14852c.m23110d(c44049s));
            AppMethodBeat.m2505o(79520);
        } else {
            if (c44049s.field_status == 4 || c44049s.field_status == 3) {
                C4990ab.m7416i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "file invalid, re-download");
                c44049s.field_status = 0;
                C40426h.m69336a(c44049s, true);
            }
            AppMethodBeat.m2505o(79520);
        }
    }

    /* renamed from: e */
    private static boolean m69337e(C44049s c44049s) {
        AppMethodBeat.m2504i(79521);
        boolean equals = C5046bo.nullAsNil(C1178g.m2587cz(c44049s.field_filePath)).equals(c44049s.field_md5);
        AppMethodBeat.m2505o(79521);
        return equals;
    }

    /* renamed from: f */
    private static void m69338f(C44049s c44049s) {
        AppMethodBeat.m2504i(79523);
        if (c44049s.field_fileCompress || c44049s.field_fileEncrypt) {
            C4990ab.m7416i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "send query and decrypt request");
            C14845c.veg.mo27149b(c44049s);
            AppMethodBeat.m2505o(79523);
            return;
        }
        C14845c.veg.mo27151e(c44049s.field_resType, c44049s.field_subType, c44049s.field_filePath, C5046bo.getInt(c44049s.field_fileVersion, 0));
        AppMethodBeat.m2505o(79523);
    }

    /* renamed from: a */
    private static void m69336a(C44049s c44049s, boolean z) {
        AppMethodBeat.m2504i(79522);
        C14857a.vfA.mo27172AH(c44049s.field_urlKey);
        C40433a.ajj(c44049s.field_filePath);
        C40433a.ajj(c44049s.field_filePath + ".decompressed");
        C40433a.ajj(c44049s.field_filePath + ".decrypted");
        if (2 == c44049s.field_status && !z) {
            C4990ab.m7416i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "delete completed but invalid file, but forceDL = false, skip this downloading");
            AppMethodBeat.m2505o(79522);
        } else if (c44049s.field_maxRetryTimes <= 0 || c44049s.field_retryTimes > 0) {
            c44049s.field_retryTimes--;
            c44049s.field_fileUpdated = true;
            C14857a.vfA.mo27179h(c44049s);
            C23236j.m35639z(c44049s.field_reportId, 12);
            C4990ab.m7416i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "post network task");
            C14852c d = C14852c.m23110d(c44049s);
            d.ufy = false;
            C14857a.vfA.mo27178d(d);
            AppMethodBeat.m2505o(79522);
        } else {
            C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "record_maxRetryTimes = %d, record_retryTimes = %d, retry times out, skip ", Integer.valueOf(c44049s.field_maxRetryTimes), Integer.valueOf(c44049s.field_retryTimes));
            AppMethodBeat.m2505o(79522);
        }
    }
}
