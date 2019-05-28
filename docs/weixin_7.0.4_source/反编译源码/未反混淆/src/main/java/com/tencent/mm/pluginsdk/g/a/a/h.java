package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.pluginsdk.g.a.a.b.b;
import com.tencent.mm.pluginsdk.g.a.a.b.c;
import com.tencent.mm.pluginsdk.g.a.c.q;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class h implements com.tencent.mm.pluginsdk.g.a.c.h {
    h() {
    }

    public final void a(s sVar, int i) {
        AppMethodBeat.i(79520);
        if (sVar.field_expireTime != 0 && sVar.field_expireTime <= bo.anT()) {
            ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "urlKey(%s) exceed expire time(%d), delete", sVar.field_urlKey, Long.valueOf(sVar.field_expireTime));
            q diy = a.vfA;
            String str = sVar.field_urlKey;
            if (diy.hrm) {
                diy.vfx.pI(str);
            }
            com.tencent.mm.pluginsdk.g.a.d.a.ajj(sVar.field_filePath);
            com.tencent.mm.pluginsdk.g.a.d.a.ajj(sVar.field_filePath + ".decompressed");
            com.tencent.mm.pluginsdk.g.a.d.a.ajj(sVar.field_filePath + ".decrypted");
            a.vfA.AH(sVar.field_urlKey);
            AppMethodBeat.o(79520);
        } else if (i == 0) {
            ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "network unavailable, skip");
            AppMethodBeat.o(79520);
        } else if (2 == i && 1 == sVar.field_networkType) {
            ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "network type = gprs, record network type = wifi, skip this ");
            AppMethodBeat.o(79520);
        } else if (sVar.field_deleted) {
            ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "record(%s), should have been deleted", sVar.field_urlKey);
            com.tencent.mm.pluginsdk.g.a.d.a.ajj(sVar.field_filePath);
            com.tencent.mm.pluginsdk.g.a.d.a.ajj(sVar.field_filePath + ".decompressed");
            com.tencent.mm.pluginsdk.g.a.d.a.ajj(sVar.field_filePath + ".decrypted");
            AppMethodBeat.o(79520);
        } else if (!sVar.field_needRetry) {
            ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "no need retry, resType %d, subType %d, version %s", Integer.valueOf(sVar.field_resType), Integer.valueOf(sVar.field_subType), sVar.field_fileVersion);
            AppMethodBeat.o(79520);
        } else if (sVar.field_status == 2) {
            long ek = com.tencent.mm.pluginsdk.g.a.d.a.ek(sVar.field_filePath);
            if (sVar.field_contentLength > ek) {
                ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "content-length > fileSize, resume download");
                if (0 == ek) {
                    if (!sVar.field_needRetry) {
                        ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "no need retry, resType %d, subType %d, version %s", Integer.valueOf(sVar.field_resType), Integer.valueOf(sVar.field_subType), sVar.field_fileVersion);
                        AppMethodBeat.o(79520);
                        return;
                    } else if (1 != i) {
                        ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "fileSize = 0, completed file may be deleted by user, skip this because it's not wifi");
                        AppMethodBeat.o(79520);
                        return;
                    } else {
                        for (b bVar : c.veg.dic()) {
                            bo.getInt(sVar.field_fileVersion, 0);
                            if (bVar.die()) {
                                ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "filterNotRetry by %s, resType %d, subType %d, version %s", bVar.getClass().getName(), Integer.valueOf(sVar.field_resType), Integer.valueOf(sVar.field_subType), sVar.field_fileVersion);
                                AppMethodBeat.o(79520);
                                return;
                            }
                        }
                        sVar.field_fileUpdated = true;
                        c.veg.g(sVar.field_resType, sVar.field_subType, 0, bo.nullAsNil(sVar.field_groupId2).equals("NewXml"));
                        a.vfA.h(sVar);
                    }
                }
                a.vfA.d(c.d(sVar));
                AppMethodBeat.o(79520);
            } else if (e(sVar)) {
                ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 check ok, file download complete, throw event to do decrypt");
                f(sVar);
                AppMethodBeat.o(79520);
            } else {
                ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "file invalid, re-download");
                a(sVar, 1 == i);
                AppMethodBeat.o(79520);
            }
        } else if (sVar.field_status == 1 || sVar.field_status == 0) {
            ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "db status: downloading or waiting, db content-length %d", Long.valueOf(sVar.field_contentLength));
            if (a.vfA.ajh(sVar.field_urlKey)) {
                ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "request already in downloading queue");
                AppMethodBeat.o(79520);
                return;
            }
            ab.d("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "check md5");
            if (e(sVar)) {
                ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 match, request complete, throw event to do decrypt");
                sVar.field_status = 2;
                sVar.field_contentLength = com.tencent.mm.pluginsdk.g.a.d.a.ek(sVar.field_filePath);
                a.vfA.h(sVar);
                f(sVar);
                AppMethodBeat.o(79520);
                return;
            }
            if (0 == com.tencent.mm.pluginsdk.g.a.d.a.ek(sVar.field_filePath)) {
                sVar.field_fileUpdated = true;
                a.vfA.h(sVar);
                c.veg.g(sVar.field_resType, sVar.field_subType, 0, bo.nullAsNil(sVar.field_groupId2).equals("NewXml"));
            }
            ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 not match,  download");
            a.vfA.d(c.d(sVar));
            AppMethodBeat.o(79520);
        } else {
            if (sVar.field_status == 4 || sVar.field_status == 3) {
                ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "file invalid, re-download");
                sVar.field_status = 0;
                a(sVar, true);
            }
            AppMethodBeat.o(79520);
        }
    }

    private static boolean e(s sVar) {
        AppMethodBeat.i(79521);
        boolean equals = bo.nullAsNil(g.cz(sVar.field_filePath)).equals(sVar.field_md5);
        AppMethodBeat.o(79521);
        return equals;
    }

    private static void f(s sVar) {
        AppMethodBeat.i(79523);
        if (sVar.field_fileCompress || sVar.field_fileEncrypt) {
            ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "send query and decrypt request");
            c.veg.b(sVar);
            AppMethodBeat.o(79523);
            return;
        }
        c.veg.e(sVar.field_resType, sVar.field_subType, sVar.field_filePath, bo.getInt(sVar.field_fileVersion, 0));
        AppMethodBeat.o(79523);
    }

    private static void a(s sVar, boolean z) {
        AppMethodBeat.i(79522);
        a.vfA.AH(sVar.field_urlKey);
        com.tencent.mm.pluginsdk.g.a.d.a.ajj(sVar.field_filePath);
        com.tencent.mm.pluginsdk.g.a.d.a.ajj(sVar.field_filePath + ".decompressed");
        com.tencent.mm.pluginsdk.g.a.d.a.ajj(sVar.field_filePath + ".decrypted");
        if (2 == sVar.field_status && !z) {
            ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "delete completed but invalid file, but forceDL = false, skip this downloading");
            AppMethodBeat.o(79522);
        } else if (sVar.field_maxRetryTimes <= 0 || sVar.field_retryTimes > 0) {
            sVar.field_retryTimes--;
            sVar.field_fileUpdated = true;
            a.vfA.h(sVar);
            j.z(sVar.field_reportId, 12);
            ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "post network task");
            c d = c.d(sVar);
            d.ufy = false;
            a.vfA.d(d);
            AppMethodBeat.o(79522);
        } else {
            ab.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "record_maxRetryTimes = %d, record_retryTimes = %d, retry times out, skip ", Integer.valueOf(sVar.field_maxRetryTimes), Integer.valueOf(sVar.field_retryTimes));
            AppMethodBeat.o(79522);
        }
    }
}
