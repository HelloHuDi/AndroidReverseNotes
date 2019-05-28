package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.List;

public final class i extends h<com.tencent.mm.plugin.record.a.i> {
    private a fFk = new a() {
        public final int a(String str, int i, c cVar, final d dVar, boolean z) {
            AppMethodBeat.i(135670);
            ab.v("MicroMsg.RecordMsgCDNService", "cdn transfer callback, startRet[%d], mediaId[%s]", Integer.valueOf(i), str);
            if (cVar != null) {
                ab.v("MicroMsg.RecordMsgCDNService", "cdn transfer callback, mediaid[%s], totallen[%d], offset[%d]", cVar.cHr, Integer.valueOf(cVar.field_toltalLength), Integer.valueOf(cVar.field_finishedLength));
            }
            if (i == -21006 || i == -21005) {
                i.this.ceG();
                AppMethodBeat.o(135670);
                return 0;
            }
            final com.tencent.mm.plugin.record.a.i VH = ((com.tencent.mm.plugin.record.a.a) g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().VH(str);
            if (VH == null) {
                ab.w("MicroMsg.RecordMsgCDNService", "onCdnCallback info null, mediaId[%s]", str);
                i.this.ceG();
                AppMethodBeat.o(135670);
                return 0;
            }
            if (i != 0) {
                ab.w("MicroMsg.RecordMsgCDNService", "[record] tran fail, startRet[%d], mediaId[%s], type[%d]", Integer.valueOf(i), str, Integer.valueOf(VH.field_type));
                if (-5103059 == i) {
                    VH.field_status = 4;
                } else {
                    VH.field_status = 3;
                }
                VH.field_errCode = i;
                ((com.tencent.mm.plugin.record.a.a) g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(VH, "localId");
            } else {
                if (cVar != null) {
                    VH.field_offset = cVar.field_finishedLength;
                    VH.field_totalLen = cVar.field_toltalLength;
                    VH.field_status = 1;
                    ((com.tencent.mm.plugin.record.a.a) g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(VH, "localId");
                } else if (dVar != null) {
                    String str2 = "MicroMsg.RecordMsgCDNService";
                    String str3 = "[record] summersafecdn cdnCallback upload attach by cdn, retCode:%d isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], aesKey[%s], md5[%s], mediaId:%s, isDownload:%b";
                    Object[] objArr = new Object[8];
                    objArr[0] = Integer.valueOf(dVar.field_retCode);
                    objArr[1] = Integer.valueOf(dVar.field_UploadHitCacheType);
                    objArr[2] = Boolean.valueOf(z);
                    objArr[3] = Boolean.valueOf(dVar.field_exist_whencheck);
                    objArr[4] = bo.anv(dVar.field_aesKey);
                    objArr[5] = dVar.field_filemd5;
                    objArr[6] = str;
                    objArr[7] = Boolean.valueOf(1 == VH.field_type);
                    ab.i(str2, str3, objArr);
                    if (dVar.field_retCode >= 0) {
                        VH.field_status = 2;
                        if (1 == VH.field_type) {
                            String str4 = VH.field_path + ".temp";
                            str2 = VH.field_path;
                            if (bo.isNullOrNil(str4) || bo.isNullOrNil(str2)) {
                                ab.w("MicroMsg.RecordMsgCDNService", "do rename and copy file, but path error");
                            } else {
                                File file = new File(str4);
                                File file2 = new File(str2);
                                if (file.exists()) {
                                    boolean renameTo = file.renameTo(file2);
                                    ab.v("MicroMsg.RecordMsgCDNService", "rename file suc:%b, old:%s, new:%s", Boolean.valueOf(renameTo), str4, file2);
                                }
                            }
                            ((com.tencent.mm.plugin.record.a.a) g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(VH, "localId");
                        } else {
                            ab.i("MicroMsg.RecordMsgCDNService", "transfer done, mediaid=%s, md5=%s", dVar.cHr, str);
                            ab.d("MicroMsg.RecordMsgCDNService", "transfer done, completeInfo=%s", dVar);
                            ab.d("MicroMsg.RecordMsgCDNService", "summersafecdn cdnCallback upload field_aesKey[%s], field_fileId[%s]", dVar.field_aesKey, dVar.field_fileId);
                            if (dVar.Jm()) {
                                ab.i("MicroMsg.RecordMsgCDNService", "summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s], newmd5[%s]", Boolean.valueOf(dVar.field_upload_by_safecdn), Integer.valueOf(dVar.field_UploadHitCacheType), Integer.valueOf(dVar.field_filecrc), dVar.field_aesKey, dVar.field_mp4identifymd5);
                                g.RO().eJo.a(new d(dVar.field_fileId, dVar.field_filemd5, dVar.field_mp4identifymd5, dVar.field_filecrc, new d.a() {
                                    public final void ae(String str, int i, int i2) {
                                        AppMethodBeat.i(135669);
                                        ab.i("MicroMsg.RecordMsgCDNService", "summersafecdn NetSceneCheckMd5 callback [%d, %d], [%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
                                        if (i == 4 && i2 == 102) {
                                            ab.i("MicroMsg.RecordMsgCDNService", "summersafecdn NetSceneCheckMd5 MM_ERR_GET_AESKEY_FAILED old status[%d, %d, %d]", Integer.valueOf(VH.field_status), Integer.valueOf(VH.field_offset), Integer.valueOf(VH.field_totalLen));
                                            VH.field_offset = 0;
                                            VH.field_totalLen = 0;
                                            VH.field_status = 0;
                                            ((com.tencent.mm.plugin.record.a.a) g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(VH, "localId");
                                            i.this.a(VH, false);
                                            AppMethodBeat.o(135669);
                                            return;
                                        }
                                        VH.field_cdnKey = str;
                                        VH.field_cdnUrl = dVar.field_fileId;
                                        ((com.tencent.mm.plugin.record.a.a) g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(VH, "localId");
                                        i.this.ceG();
                                        AppMethodBeat.o(135669);
                                    }
                                }), 0);
                                AppMethodBeat.o(135670);
                                return 0;
                            }
                            VH.field_cdnKey = dVar.field_aesKey;
                            VH.field_cdnUrl = dVar.field_fileId;
                            ((com.tencent.mm.plugin.record.a.a) g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(VH, "localId");
                        }
                    } else {
                        ab.e("MicroMsg.RecordMsgCDNService", "transfer error, mediaid=%s, retCode:%d", dVar.cHr, Integer.valueOf(dVar.field_retCode));
                        if (-5103059 == dVar.field_retCode) {
                            VH.field_status = 4;
                        } else {
                            VH.field_status = 3;
                        }
                        VH.field_errCode = dVar.field_retCode;
                        ((com.tencent.mm.plugin.record.a.a) g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(VH, "localId");
                    }
                }
                AppMethodBeat.o(135670);
                return 0;
            }
            i.this.ceG();
            AppMethodBeat.o(135670);
            return 0;
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] l(String str, byte[] bArr) {
            return null;
        }
    };

    public i() {
        AppMethodBeat.i(135671);
        AppMethodBeat.o(135671);
    }

    /* Access modifiers changed, original: protected|final */
    public final List<com.tencent.mm.plugin.record.a.i> ceF() {
        AppMethodBeat.i(135672);
        ab.d("MicroMsg.RecordMsgCDNService", "get to do jobs, size %d", Integer.valueOf(((com.tencent.mm.plugin.record.a.a) g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().ceA().size()));
        AppMethodBeat.o(135672);
        return ((com.tencent.mm.plugin.record.a.a) g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().ceA();
    }

    /* Access modifiers changed, original: final */
    public final void a(com.tencent.mm.plugin.record.a.i iVar, boolean z) {
        AppMethodBeat.i(135673);
        ab.i("MicroMsg.RecordMsgCDNService", "summersafecdn doJob, md5:%s, mediaId:%s, jobType[%d], jobStatus[%s]", iVar.field_dataId, iVar.field_mediaId, Integer.valueOf(iVar.field_type), Integer.valueOf(iVar.field_status));
        if (-1 == iVar.field_status) {
            AppMethodBeat.o(135673);
            return;
        }
        com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
        gVar.egl = this.fFk;
        gVar.field_mediaId = iVar.field_mediaId;
        if (2 == iVar.field_type) {
            gVar.cRY = true;
            gVar.field_priority = com.tencent.mm.i.a.efB;
            gVar.field_needStorage = false;
            gVar.field_totalLen = iVar.field_totalLen;
            gVar.field_aesKey = iVar.field_cdnKey;
            gVar.field_fileId = iVar.field_cdnUrl;
            gVar.egl = this.fFk;
            gVar.field_fullpath = iVar.field_path;
            gVar.field_fileType = iVar.field_fileType;
            gVar.field_talker = iVar.field_toUser;
            gVar.field_force_aeskeycdn = false;
            gVar.field_trysafecdn = true;
            gVar.field_enable_hitcheck = z;
            ab.i("MicroMsg.RecordMsgCDNService", "[record] summersafecdn doJob TYPE_UPLOAD addSendTask field_force_aeskeycdn:%b, type[%d], aesKey[%s], fileId[%s], force_aeskeycdn[%b] trysafecdn[%b] enable_hitcheck[%b], mediaId:%s", Boolean.valueOf(gVar.field_force_aeskeycdn), Integer.valueOf(gVar.field_fileType), gVar.field_aesKey, gVar.field_fileId, Boolean.valueOf(gVar.field_force_aeskeycdn), Boolean.valueOf(gVar.field_trysafecdn), Boolean.valueOf(gVar.field_enable_hitcheck), gVar.field_mediaId);
            f.afx().e(gVar);
        } else {
            gVar.cRY = false;
            gVar.field_priority = com.tencent.mm.i.a.efC;
            gVar.field_needStorage = false;
            gVar.field_totalLen = iVar.field_totalLen;
            gVar.field_aesKey = iVar.field_cdnKey;
            gVar.field_fileId = iVar.field_cdnUrl;
            gVar.egl = this.fFk;
            gVar.field_fullpath = iVar.field_path + ".temp";
            gVar.field_fileType = iVar.field_fileType;
            if (!bo.isNullOrNil(iVar.field_tpdataurl)) {
                gVar.field_fileType = 19;
                gVar.field_authKey = iVar.field_tpauthkey;
                gVar.field_aesKey = iVar.field_tpaeskey;
                gVar.egm = iVar.field_tpdataurl;
                gVar.field_fileId = "";
            }
            ab.i("MicroMsg.RecordMsgCDNService", "[record] summersafecdn doJob TYPE_DOWNLOAD addSendTask field_force_aeskeycdn:%b, type[%d], aesKey[%s], fileId[%s], force_aeskeycdn[%b] trysafecdn[%b] enable_hitcheck[%b], mediaId:%s", Boolean.valueOf(gVar.field_force_aeskeycdn), Integer.valueOf(gVar.field_fileType), gVar.field_aesKey, gVar.field_fileId, Boolean.valueOf(gVar.field_force_aeskeycdn), Boolean.valueOf(gVar.field_trysafecdn), Boolean.valueOf(gVar.field_enable_hitcheck), gVar.field_mediaId);
            f.afx().b(gVar, -1);
        }
        ab.d("MicroMsg.RecordMsgCDNService", "summersafecdn doJob, isSend:%B totallen:%d, aseKey:%s, url[%s], fullPath[%s], fileType[%d], enable_hitcheck[%b], force_aeskeycdn[%b]", Boolean.valueOf(gVar.cRY), Integer.valueOf(gVar.field_totalLen), gVar.field_aesKey, gVar.field_fileId, gVar.field_fullpath, Integer.valueOf(gVar.field_fileType), Boolean.valueOf(gVar.field_enable_hitcheck), Boolean.valueOf(gVar.field_force_aeskeycdn));
        AppMethodBeat.o(135673);
    }

    public final void a(com.tencent.mm.plugin.record.a.c cVar) {
        AppMethodBeat.i(135674);
        if (cVar instanceof com.tencent.mm.plugin.record.a.i) {
            a((com.tencent.mm.plugin.record.a.i) cVar, true);
        }
        AppMethodBeat.o(135674);
    }
}
