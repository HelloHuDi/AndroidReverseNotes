package com.tencent.p177mm.plugin.record.p492b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.record.p1016a.C21592a;
import com.tencent.p177mm.plugin.record.p1016a.C21594c;
import com.tencent.p177mm.plugin.record.p1016a.C34792i;
import com.tencent.p177mm.plugin.record.p492b.C43431d.C34794a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.record.b.i */
public final class C25028i extends C24816h<C34792i> {
    private C1628a fFk = new C129821();

    /* renamed from: com.tencent.mm.plugin.record.b.i$1 */
    class C129821 implements C1628a {
        C129821() {
        }

        /* renamed from: a */
        public final int mo5082a(String str, int i, C18496c c18496c, final C9545d c9545d, boolean z) {
            AppMethodBeat.m2504i(135670);
            C4990ab.m7419v("MicroMsg.RecordMsgCDNService", "cdn transfer callback, startRet[%d], mediaId[%s]", Integer.valueOf(i), str);
            if (c18496c != null) {
                C4990ab.m7419v("MicroMsg.RecordMsgCDNService", "cdn transfer callback, mediaid[%s], totallen[%d], offset[%d]", c18496c.cHr, Integer.valueOf(c18496c.field_toltalLength), Integer.valueOf(c18496c.field_finishedLength));
            }
            if (i == -21006 || i == -21005) {
                C25028i.this.ceG();
                AppMethodBeat.m2505o(135670);
                return 0;
            }
            final C34792i VH = ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37079VH(str);
            if (VH == null) {
                C4990ab.m7421w("MicroMsg.RecordMsgCDNService", "onCdnCallback info null, mediaId[%s]", str);
                C25028i.this.ceG();
                AppMethodBeat.m2505o(135670);
                return 0;
            }
            if (i != 0) {
                C4990ab.m7421w("MicroMsg.RecordMsgCDNService", "[record] tran fail, startRet[%d], mediaId[%s], type[%d]", Integer.valueOf(i), str, Integer.valueOf(VH.field_type));
                if (-5103059 == i) {
                    VH.field_status = 4;
                } else {
                    VH.field_status = 3;
                }
                VH.field_errCode = i;
                ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37085b(VH, "localId");
            } else {
                if (c18496c != null) {
                    VH.field_offset = c18496c.field_finishedLength;
                    VH.field_totalLen = c18496c.field_toltalLength;
                    VH.field_status = 1;
                    ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37085b(VH, "localId");
                } else if (c9545d != null) {
                    String str2 = "MicroMsg.RecordMsgCDNService";
                    String str3 = "[record] summersafecdn cdnCallback upload attach by cdn, retCode:%d isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], aesKey[%s], md5[%s], mediaId:%s, isDownload:%b";
                    Object[] objArr = new Object[8];
                    objArr[0] = Integer.valueOf(c9545d.field_retCode);
                    objArr[1] = Integer.valueOf(c9545d.field_UploadHitCacheType);
                    objArr[2] = Boolean.valueOf(z);
                    objArr[3] = Boolean.valueOf(c9545d.field_exist_whencheck);
                    objArr[4] = C5046bo.anv(c9545d.field_aesKey);
                    objArr[5] = c9545d.field_filemd5;
                    objArr[6] = str;
                    objArr[7] = Boolean.valueOf(1 == VH.field_type);
                    C4990ab.m7417i(str2, str3, objArr);
                    if (c9545d.field_retCode >= 0) {
                        VH.field_status = 2;
                        if (1 == VH.field_type) {
                            String str4 = VH.field_path + ".temp";
                            str2 = VH.field_path;
                            if (C5046bo.isNullOrNil(str4) || C5046bo.isNullOrNil(str2)) {
                                C4990ab.m7420w("MicroMsg.RecordMsgCDNService", "do rename and copy file, but path error");
                            } else {
                                File file = new File(str4);
                                File file2 = new File(str2);
                                if (file.exists()) {
                                    boolean renameTo = file.renameTo(file2);
                                    C4990ab.m7419v("MicroMsg.RecordMsgCDNService", "rename file suc:%b, old:%s, new:%s", Boolean.valueOf(renameTo), str4, file2);
                                }
                            }
                            ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37082a(VH, "localId");
                        } else {
                            C4990ab.m7417i("MicroMsg.RecordMsgCDNService", "transfer done, mediaid=%s, md5=%s", c9545d.cHr, str);
                            C4990ab.m7411d("MicroMsg.RecordMsgCDNService", "transfer done, completeInfo=%s", c9545d);
                            C4990ab.m7411d("MicroMsg.RecordMsgCDNService", "summersafecdn cdnCallback upload field_aesKey[%s], field_fileId[%s]", c9545d.field_aesKey, c9545d.field_fileId);
                            if (c9545d.mo20809Jm()) {
                                C4990ab.m7417i("MicroMsg.RecordMsgCDNService", "summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s], newmd5[%s]", Boolean.valueOf(c9545d.field_upload_by_safecdn), Integer.valueOf(c9545d.field_UploadHitCacheType), Integer.valueOf(c9545d.field_filecrc), c9545d.field_aesKey, c9545d.field_mp4identifymd5);
                                C1720g.m3535RO().eJo.mo14541a(new C43431d(c9545d.field_fileId, c9545d.field_filemd5, c9545d.field_mp4identifymd5, c9545d.field_filecrc, new C34794a() {
                                    /* renamed from: ae */
                                    public final void mo25043ae(String str, int i, int i2) {
                                        AppMethodBeat.m2504i(135669);
                                        C4990ab.m7417i("MicroMsg.RecordMsgCDNService", "summersafecdn NetSceneCheckMd5 callback [%d, %d], [%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
                                        if (i == 4 && i2 == 102) {
                                            C4990ab.m7417i("MicroMsg.RecordMsgCDNService", "summersafecdn NetSceneCheckMd5 MM_ERR_GET_AESKEY_FAILED old status[%d, %d, %d]", Integer.valueOf(VH.field_status), Integer.valueOf(VH.field_offset), Integer.valueOf(VH.field_totalLen));
                                            VH.field_offset = 0;
                                            VH.field_totalLen = 0;
                                            VH.field_status = 0;
                                            ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37085b(VH, "localId");
                                            C25028i.this.mo41937a(VH, false);
                                            AppMethodBeat.m2505o(135669);
                                            return;
                                        }
                                        VH.field_cdnKey = str;
                                        VH.field_cdnUrl = c9545d.field_fileId;
                                        ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37085b(VH, "localId");
                                        C25028i.this.ceG();
                                        AppMethodBeat.m2505o(135669);
                                    }
                                }), 0);
                                AppMethodBeat.m2505o(135670);
                                return 0;
                            }
                            VH.field_cdnKey = c9545d.field_aesKey;
                            VH.field_cdnUrl = c9545d.field_fileId;
                            ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37085b(VH, "localId");
                        }
                    } else {
                        C4990ab.m7413e("MicroMsg.RecordMsgCDNService", "transfer error, mediaid=%s, retCode:%d", c9545d.cHr, Integer.valueOf(c9545d.field_retCode));
                        if (-5103059 == c9545d.field_retCode) {
                            VH.field_status = 4;
                        } else {
                            VH.field_status = 3;
                        }
                        VH.field_errCode = c9545d.field_retCode;
                        ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37085b(VH, "localId");
                    }
                }
                AppMethodBeat.m2505o(135670);
                return 0;
            }
            C25028i.this.ceG();
            AppMethodBeat.m2505o(135670);
            return 0;
        }

        /* renamed from: a */
        public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        /* renamed from: l */
        public final byte[] mo5084l(String str, byte[] bArr) {
            return null;
        }
    }

    public C25028i() {
        AppMethodBeat.m2504i(135671);
        AppMethodBeat.m2505o(135671);
    }

    /* Access modifiers changed, original: protected|final */
    public final List<C34792i> ceF() {
        AppMethodBeat.m2504i(135672);
        C4990ab.m7411d("MicroMsg.RecordMsgCDNService", "get to do jobs, size %d", Integer.valueOf(((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().ceA().size()));
        AppMethodBeat.m2505o(135672);
        return ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().ceA();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo41937a(C34792i c34792i, boolean z) {
        AppMethodBeat.m2504i(135673);
        C4990ab.m7417i("MicroMsg.RecordMsgCDNService", "summersafecdn doJob, md5:%s, mediaId:%s, jobType[%d], jobStatus[%s]", c34792i.field_dataId, c34792i.field_mediaId, Integer.valueOf(c34792i.field_type), Integer.valueOf(c34792i.field_status));
        if (-1 == c34792i.field_status) {
            AppMethodBeat.m2505o(135673);
            return;
        }
        C42130g c42130g = new C42130g();
        c42130g.egl = this.fFk;
        c42130g.field_mediaId = c34792i.field_mediaId;
        if (2 == c34792i.field_type) {
            c42130g.cRY = true;
            c42130g.field_priority = C42129a.efB;
            c42130g.field_needStorage = false;
            c42130g.field_totalLen = c34792i.field_totalLen;
            c42130g.field_aesKey = c34792i.field_cdnKey;
            c42130g.field_fileId = c34792i.field_cdnUrl;
            c42130g.egl = this.fFk;
            c42130g.field_fullpath = c34792i.field_path;
            c42130g.field_fileType = c34792i.field_fileType;
            c42130g.field_talker = c34792i.field_toUser;
            c42130g.field_force_aeskeycdn = false;
            c42130g.field_trysafecdn = true;
            c42130g.field_enable_hitcheck = z;
            C4990ab.m7417i("MicroMsg.RecordMsgCDNService", "[record] summersafecdn doJob TYPE_UPLOAD addSendTask field_force_aeskeycdn:%b, type[%d], aesKey[%s], fileId[%s], force_aeskeycdn[%b] trysafecdn[%b] enable_hitcheck[%b], mediaId:%s", Boolean.valueOf(c42130g.field_force_aeskeycdn), Integer.valueOf(c42130g.field_fileType), c42130g.field_aesKey, c42130g.field_fileId, Boolean.valueOf(c42130g.field_force_aeskeycdn), Boolean.valueOf(c42130g.field_trysafecdn), Boolean.valueOf(c42130g.field_enable_hitcheck), c42130g.field_mediaId);
            C37461f.afx().mo51225e(c42130g);
        } else {
            c42130g.cRY = false;
            c42130g.field_priority = C42129a.efC;
            c42130g.field_needStorage = false;
            c42130g.field_totalLen = c34792i.field_totalLen;
            c42130g.field_aesKey = c34792i.field_cdnKey;
            c42130g.field_fileId = c34792i.field_cdnUrl;
            c42130g.egl = this.fFk;
            c42130g.field_fullpath = c34792i.field_path + ".temp";
            c42130g.field_fileType = c34792i.field_fileType;
            if (!C5046bo.isNullOrNil(c34792i.field_tpdataurl)) {
                c42130g.field_fileType = 19;
                c42130g.field_authKey = c34792i.field_tpauthkey;
                c42130g.field_aesKey = c34792i.field_tpaeskey;
                c42130g.egm = c34792i.field_tpdataurl;
                c42130g.field_fileId = "";
            }
            C4990ab.m7417i("MicroMsg.RecordMsgCDNService", "[record] summersafecdn doJob TYPE_DOWNLOAD addSendTask field_force_aeskeycdn:%b, type[%d], aesKey[%s], fileId[%s], force_aeskeycdn[%b] trysafecdn[%b] enable_hitcheck[%b], mediaId:%s", Boolean.valueOf(c42130g.field_force_aeskeycdn), Integer.valueOf(c42130g.field_fileType), c42130g.field_aesKey, c42130g.field_fileId, Boolean.valueOf(c42130g.field_force_aeskeycdn), Boolean.valueOf(c42130g.field_trysafecdn), Boolean.valueOf(c42130g.field_enable_hitcheck), c42130g.field_mediaId);
            C37461f.afx().mo51222b(c42130g, -1);
        }
        C4990ab.m7411d("MicroMsg.RecordMsgCDNService", "summersafecdn doJob, isSend:%B totallen:%d, aseKey:%s, url[%s], fullPath[%s], fileType[%d], enable_hitcheck[%b], force_aeskeycdn[%b]", Boolean.valueOf(c42130g.cRY), Integer.valueOf(c42130g.field_totalLen), c42130g.field_aesKey, c42130g.field_fileId, c42130g.field_fullpath, Integer.valueOf(c42130g.field_fileType), Boolean.valueOf(c42130g.field_enable_hitcheck), Boolean.valueOf(c42130g.field_force_aeskeycdn));
        AppMethodBeat.m2505o(135673);
    }

    /* renamed from: a */
    public final void mo37074a(C21594c c21594c) {
        AppMethodBeat.m2504i(135674);
        if (c21594c instanceof C34792i) {
            mo41937a((C34792i) c21594c, true);
        }
        AppMethodBeat.m2505o(135674);
    }
}
