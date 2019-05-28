package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.pluginsdk.g.a.a.b.c;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class f {

    static final class a {
        static void a(boolean z, boolean z2, s sVar, g gVar) {
            AppMethodBeat.i(79513);
            ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "sendIORequest, fileAppend = %b, fileUpdate = %b", Boolean.valueOf(z), Boolean.valueOf(z2));
            if (sVar.field_maxRetryTimes <= 0 || sVar.field_retryTimes > 0 || z2) {
                sVar.field_reportId = gVar.vdK;
                sVar.field_status = 0;
                if (z2) {
                    sVar.field_maxRetryTimes = gVar.vdM;
                    sVar.field_retryTimes = gVar.vdM;
                    sVar.field_fileUpdated = true;
                    sVar.field_priority = gVar.priority;
                    if (gVar.fileSize > 0) {
                        sVar.field_fileSize = gVar.fileSize;
                    }
                    com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.h(sVar);
                } else {
                    sVar.field_retryTimes--;
                    sVar.field_priority = gVar.priority;
                    com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.h(sVar);
                    j.z(sVar.field_reportId, 12);
                }
                if (com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.ajh(gVar.vdC)) {
                    ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "urlKey = %s is already downloading", gVar.vdC);
                    if (gVar.cuA) {
                        j.z(gVar.vdK, 9);
                        j.z(gVar.vdK, 44);
                    }
                    AppMethodBeat.o(79513);
                    return;
                }
                ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "urlKey = %s, post network task", gVar.vdC);
                if (z2 && !z) {
                    c.veg.g(sVar.field_resType, sVar.field_subType, 0, bo.nullAsNil(sVar.field_groupId2).equals("NewXml"));
                }
                c d = c.d(sVar);
                d.ufy = z;
                d.veh = gVar.veh;
                if (!z) {
                    com.tencent.mm.pluginsdk.g.a.d.a.ajj(i.aiX(d.vdC));
                    com.tencent.mm.pluginsdk.g.a.d.a.ajj(i.aiX(d.vdC) + ".decompressed");
                    com.tencent.mm.pluginsdk.g.a.d.a.ajj(i.aiX(d.vdC) + ".decrypted");
                }
                com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.d(d);
                AppMethodBeat.o(79513);
                return;
            }
            ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "record_maxRetryTimes = %d, record_retryTimes = %d, retry times out, skip", Integer.valueOf(sVar.field_maxRetryTimes), Integer.valueOf(sVar.field_retryTimes));
            AppMethodBeat.o(79513);
        }
    }

    static final class b {
        static void a(s sVar, boolean z, boolean z2) {
            AppMethodBeat.i(79514);
            if (sVar == null) {
                ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "get null record, skip");
                AppMethodBeat.o(79514);
                return;
            }
            String str = sVar.field_urlKey;
            String str2 = sVar.field_filePath;
            String str3 = sVar.field_md5;
            boolean z3 = sVar.field_fileCompress;
            boolean z4 = sVar.field_fileEncrypt;
            byte[] bArr = sVar.field_eccSignature;
            int i = bo.getInt(sVar.field_fileVersion, 0);
            int i2 = sVar.field_keyVersion;
            String str4 = sVar.field_encryptKey;
            boolean z5 = sVar.field_deleted;
            ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "queried info: deleted = " + z5 + ", filePath = " + str2 + ", md5 = " + str3 + ", originalMd5 = " + sVar.field_originalMd5 + ", fileCompress = " + z3 + ", fileEncrypt = " + z4 + ", eccSignature = " + bArr + ", fileVersion = " + i + ", (encrypt key == empty) = " + bo.isNullOrNil(str4));
            ab.d("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "queried encryptKey = %s", str4);
            if (!z4) {
                if (z) {
                    j.z(sVar.field_reportId, 53);
                    j.z(sVar.field_reportId, 45);
                }
                if (!z3) {
                    ab.e("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "file is not encrypted nor compressed, just return");
                    AppMethodBeat.o(79514);
                    return;
                }
            }
            if (i2 != i && z4) {
                ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "file version(%d) != key version(%d), skip", Integer.valueOf(i), Integer.valueOf(i2));
                if (i2 >= 0) {
                    j.z(sVar.field_reportId, 52);
                    j.z(sVar.field_reportId, 45);
                }
                AppMethodBeat.o(79514);
            } else if (z5) {
                ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "this file should have been deleted, skip this decrypt-op");
                j.z(sVar.field_reportId, 51);
                j.z(sVar.field_reportId, 45);
                AppMethodBeat.o(79514);
            } else if (bo.isNullOrNil(str4) && z4) {
                ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "encryptKey invalid, skip");
                j.z(sVar.field_reportId, 54);
                j.z(sVar.field_reportId, 45);
                AppMethodBeat.o(79514);
            } else {
                if (bo.isNullOrNil(str3) || bo.isNullOrNil(str2)) {
                    ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "this decrypt-op is invalid, record.md5 = %s, record.filePath = %s", str3, str2);
                } else if (com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.ajh(str)) {
                    ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "request(%s) is downloading or queueing, hold this decrypt-op", str);
                    AppMethodBeat.o(79514);
                    return;
                } else if (!bo.nullAsNil(g.cz(str2)).equals(str3)) {
                    ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "md5 not match, file spoiled, skip this decrypt-op");
                    sVar.field_status = 3;
                    com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.h(sVar);
                    j.z(sVar.field_reportId, 56);
                    j.z(sVar.field_reportId, 45);
                    AppMethodBeat.o(79514);
                    return;
                } else if (!com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.ajh(str)) {
                    ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "request supposed to complete, send decrypt request %s", sVar.field_urlKey);
                    c.veg.g(sVar.field_resType, sVar.field_subType, 1, bo.nullAsNil(sVar.field_groupId2).equals("NewXml"));
                    if (z2) {
                        c.veg;
                        b.c(sVar);
                        AppMethodBeat.o(79514);
                        return;
                    }
                    c.veg.b(sVar);
                    AppMethodBeat.o(79514);
                    return;
                }
                AppMethodBeat.o(79514);
            }
        }
    }
}
