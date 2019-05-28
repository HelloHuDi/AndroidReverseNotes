package com.tencent.mm.pluginsdk.model.app;

import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.np;
import com.tencent.mm.g.a.nr;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ckq;
import com.tencent.mm.protocal.protobuf.ckr;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class ai extends m implements k {
    b csH = null;
    String cvF;
    private boolean eFq = false;
    int eFs = 0;
    d eFt;
    c eFv = new c<nr>() {
        {
            AppMethodBeat.i(27377);
            this.xxI = nr.class.getName().hashCode();
            AppMethodBeat.o(27377);
        }

        private boolean a(nr nrVar) {
            AppMethodBeat.i(27378);
            if (nrVar.cJX.filePath.equals(ai.this.pJj.field_fileFullPath)) {
                String str = "";
                try {
                    str = URLEncoder.encode(nrVar.cJX.result, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    ab.printErrStackTrace("MicroMsg.NetSceneUploadAppAttach", e, "", new Object[0]);
                }
                if (ai.this.eFs == 1) {
                    aw.ZK();
                    bi jf = com.tencent.mm.model.c.XO().jf(ai.this.pJj.field_msgInfoId);
                    com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
                    dVar.l("20toUser", ai.this.toUser + ",");
                    dVar.l("21source", "4,");
                    dVar.l("22qrUrl", str + ",");
                    dVar.l("23md5", (ai.this.eFt == null ? "" : ai.this.eFt.field_filemd5) + ",");
                    dVar.l("24cdnFileId", (ai.this.eFt == null ? "" : ai.this.eFt.field_fileId) + ",");
                    dVar.l("25cdnAesKey", (ai.this.eFt == null ? "" : ai.this.eFt.field_aesKey) + ",");
                    str = "";
                    if (jf.bAA()) {
                        b me = b.me(jf.field_content);
                        if (me != null) {
                            str = me.appId;
                        }
                    }
                    dVar.l("26appip", str + ",");
                    dVar.l("27toUsersCount", n.mA(ai.this.toUser) + ",");
                    dVar.l("28codeType", Integer.valueOf(nrVar.cJX.cvn));
                    ab.i("MicroMsg.NetSceneUploadAppAttach", "report qrCodeImgChatting(13628): " + dVar.Fk());
                    o.y(13628, dVar.toString());
                }
                a.xxA.d(ai.this.eFv);
                AppMethodBeat.o(27378);
            } else {
                AppMethodBeat.o(27378);
            }
            return false;
        }
    };
    private com.tencent.mm.ai.b ehh;
    f ehi;
    String fFa = "";
    private g.a fFk = new g.a() {
        public final int a(String str, final int i, com.tencent.mm.i.c cVar, final d dVar, boolean z) {
            AppMethodBeat.i(27375);
            String str2 = "MicroMsg.NetSceneUploadAppAttach";
            String str3 = "summerbig cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s], progressing[%b], finish[%b], onlyCheckExist[%b]";
            Object[] objArr = new Object[7];
            objArr[0] = ai.this.fFa;
            objArr[1] = Integer.valueOf(i);
            objArr[2] = cVar;
            objArr[3] = dVar;
            objArr[4] = Boolean.valueOf(cVar != null);
            objArr[5] = Boolean.valueOf(dVar != null);
            objArr[6] = Boolean.valueOf(z);
            ab.d(str2, str3, objArr);
            am.aUq().b(ai.this.pJl, (com.tencent.mm.sdk.e.c) ai.this.pJj);
            boolean a;
            if (i == -21005) {
                ab.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", ai.this.fFa);
                AppMethodBeat.o(27375);
                return 0;
            } else if (i != 0) {
                l.jC(ai.this.pJj.xDa);
                am.aUq().b(ai.this.pJl, (com.tencent.mm.sdk.e.c) ai.this.pJj);
                ai.this.pJj.field_signature = "";
                a = am.aUq().a(ai.this.pJj, new String[0]);
                ab.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] rowid[%d], reset signature ret[%b]", Integer.valueOf(i), Long.valueOf(ai.this.pJl), Boolean.valueOf(a));
                ai.this.ehi.onSceneEnd(3, i, "", ai.this);
                new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.r(Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(ai.this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), "")).ajK();
                AppMethodBeat.o(27375);
                return 0;
            } else if (ai.this.pJj.field_status == 105) {
                ab.i("MicroMsg.NetSceneUploadAppAttach", "attach upload has paused, status:%d, rowid:%d", Long.valueOf(ai.this.pJj.field_status), Long.valueOf(ai.this.pJl));
                com.tencent.mm.al.f.afx().rN(ai.this.fFa);
                ai.this.ehi.onSceneEnd(3, i, "attach  has paused, status" + ai.this.pJj.field_status, ai.this);
                AppMethodBeat.o(27375);
                return 0;
            } else if (cVar != null) {
                ai.this.pJj.field_lastModifyTime = bo.anT();
                ai.this.pJj.field_offset = (long) cVar.field_finishedLength;
                a = am.aUq().a(ai.this.pJj, new String[0]);
                if (a) {
                    AppMethodBeat.o(27375);
                    return 0;
                }
                ab.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(a)));
                ai.this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                ai.this.ehi.onSceneEnd(3, i, "", ai.this);
                AppMethodBeat.o(27375);
                return 0;
            } else {
                if (dVar != null) {
                    if (dVar.field_retCode != 0) {
                        ab.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback sceneResult.retCode :%d arg[%s] info[%s]", Integer.valueOf(dVar.field_retCode), dVar.field_arg, dVar.field_transInfo, "", "", "", "", "", "", "", dVar.efY);
                        l.jC(ai.this.pJj.xDa);
                        am.aUq().b(ai.this.pJl, (com.tencent.mm.sdk.e.c) ai.this.pJj);
                        ai.this.pJj.field_signature = "";
                        a = am.aUq().a(ai.this.pJj, new String[0]);
                        ab.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] sceneResult.field_retCode[%d], rowid[%d], reset signature ret[%b]", Integer.valueOf(i), Integer.valueOf(dVar.field_retCode), Long.valueOf(ai.this.pJl), Boolean.valueOf(a));
                        String r = com.tencent.mm.plugin.report.a.r(Integer.valueOf(dVar.field_retCode), Integer.valueOf(1), Long.valueOf(ai.this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.efY);
                        new com.tencent.mm.g.b.a.f(r).ajK();
                        new com.tencent.mm.g.b.a.d(r).ajK();
                        ai.this.ehi.onSceneEnd(3, dVar.field_retCode, "", ai.this);
                    } else {
                        ab.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], signature[%s]", Integer.valueOf(dVar.field_UploadHitCacheType), Boolean.valueOf(z), Boolean.valueOf(dVar.field_exist_whencheck), bo.anv(ai.this.pJj.field_signature));
                        if (!z) {
                            a(i, dVar);
                        } else if (dVar.field_exist_whencheck) {
                            aw.Rg().a(new z(ai.this.csH, ai.this.pJj.field_fileFullPath, ai.this.toUser, new z.a() {
                                public final void a(String str, String str2, String str3, String str4, String str5, long j) {
                                    boolean z = true;
                                    AppMethodBeat.i(27370);
                                    String str6 = "MicroMsg.NetSceneUploadAppAttach";
                                    String str7 = "summerbig NetSceneCheckBigFileUpload exist_whencheck call back new md5[%s], aesKey[%s], signature[%s], aesKey[%s], signature[%s], amc null[%b], enableHitcheck[%b]";
                                    Object[] objArr = new Object[7];
                                    objArr[0] = str;
                                    objArr[1] = bo.anv(str2);
                                    objArr[2] = bo.anv(str3);
                                    objArr[3] = bo.anv(str4);
                                    objArr[4] = bo.anv(str5);
                                    if (ai.this.csH != null) {
                                        z = false;
                                    }
                                    objArr[5] = Boolean.valueOf(z);
                                    objArr[6] = Boolean.valueOf(ai.this.fFs);
                                    ab.i(str6, str7, objArr);
                                    if (!bo.isNullOrNil(str3)) {
                                        ai.this.pJj.field_signature = str3;
                                        ai.this.pJj.field_fakeAeskey = str4;
                                        ai.this.pJj.field_fakeSignature = str5;
                                    }
                                    AnonymousClass1.this.a(i, dVar);
                                    AppMethodBeat.o(27370);
                                }
                            }), 0);
                        } else {
                            ab.i("MicroMsg.NetSceneUploadAppAttach", "summerbig upload check but not exist");
                            aw.Rg().a(new z(null, ai.this.pJj.field_fileFullPath, ai.this.toUser, new z.a() {
                                public final void a(String str, String str2, String str3, String str4, String str5, long j) {
                                    boolean z;
                                    AppMethodBeat.i(27372);
                                    String str6 = "MicroMsg.NetSceneUploadAppAttach";
                                    String str7 = "summerbig NetSceneCheckBigFileUpload not exist_whencheck call back new md5[%s], aesKey[%s], signature[%s], aesKey[%s], signature[%s], amc null[%b], enableHitcheck[%b]";
                                    Object[] objArr = new Object[7];
                                    objArr[0] = str;
                                    objArr[1] = bo.anv(str2);
                                    objArr[2] = bo.anv(str3);
                                    objArr[3] = bo.anv(str4);
                                    objArr[4] = bo.anv(str5);
                                    if (ai.this.csH == null) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    objArr[5] = Boolean.valueOf(z);
                                    objArr[6] = Boolean.valueOf(ai.this.fFs);
                                    ab.i(str6, str7, objArr);
                                    if (!bo.isNullOrNil(str3)) {
                                        ai.this.pJj.field_signature = str3;
                                        ai.this.pJj.field_fakeAeskey = str4;
                                        ai.this.pJj.field_fakeSignature = str5;
                                        ai.this.pJj.field_lastModifyTime = bo.anU();
                                        if (ai.this.csH != null) {
                                            ai.this.csH.filemd5 = str;
                                            ai.this.csH.eyr = str2;
                                            ai.this.csH.fgo = (int) j;
                                            aw.ZK();
                                            bi jf = com.tencent.mm.model.c.XO().jf(ai.this.pJj.field_msgInfoId);
                                            jf.setContent(b.a(ai.this.csH, null, null));
                                            aw.ZK();
                                            com.tencent.mm.model.c.XO().a(jf.field_msgId, jf);
                                        }
                                    }
                                    ai.this.fFs = false;
                                    z = am.aUq().a(ai.this.pJj, new String[0]);
                                    if (z) {
                                        aw.RS().aa(new Runnable() {
                                            public final void run() {
                                                AppMethodBeat.i(27371);
                                                ab.i("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene again");
                                                ai.this.a(ai.this.ftf, ai.this.ehi);
                                                AppMethodBeat.o(27371);
                                            }
                                        });
                                        AppMethodBeat.o(27372);
                                        return;
                                    }
                                    ab.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(z)));
                                    ai.this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                                    ai.this.ehi.onSceneEnd(3, i, "", ai.this);
                                    AppMethodBeat.o(27372);
                                }
                            }), 0);
                        }
                    }
                }
                AppMethodBeat.o(27375);
                return 0;
            }
        }

        /* Access modifiers changed, original: final */
        public final void a(int i, final d dVar) {
            AppMethodBeat.i(27376);
            ai.this.pJj.field_status = 199;
            boolean a = am.aUq().a(ai.this.pJj, new String[0]);
            if (a) {
                l.a(ai.this.pJj.field_msgInfoId, ai.this.pJj.field_mediaSvrId, dVar);
                aw.Rg().a(new ag(ai.this.pJj.field_msgInfoId, true, dVar, new a() {
                    public final void cC(int i, int i2) {
                        AppMethodBeat.i(27374);
                        ab.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra NetSceneSendAppMsgForCdn callback %d,%d", Integer.valueOf(i), Integer.valueOf(i2));
                        if (i == 4 && i2 == 102) {
                            aw.RS().aa(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(27373);
                                    ai.this.fFs = false;
                                    ai.this.pJj.field_createTime = bo.anU();
                                    ai.this.pJj.field_lastModifyTime = bo.anT();
                                    ai.this.pJj.field_offset = 0;
                                    ai.this.pJj.field_status = 101;
                                    boolean a = am.aUq().a(ai.this.pJj, new String[0]);
                                    ab.i("MicroMsg.NetSceneUploadAppAttach", "summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", Boolean.valueOf(ai.this.fFs), Boolean.valueOf(a), Long.valueOf(ai.this.pJj.field_createTime));
                                    ai.this.a(ai.this.ftf, ai.this.ehi);
                                    AppMethodBeat.o(27373);
                                }
                            });
                            AppMethodBeat.o(27374);
                            return;
                        }
                        new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.r(Integer.valueOf(i2), Integer.valueOf(1), Long.valueOf(ai.this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.efY)).ajK();
                        if (i == 0 && i2 == 0) {
                            ai.this.d(dVar);
                        }
                        ai.this.ehi.onSceneEnd(i, i2, "", ai.this);
                        AppMethodBeat.o(27374);
                    }
                }, ai.this.cvF, ai.this.pJj), 0);
                AppMethodBeat.o(27376);
                return;
            }
            ab.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(a)));
            ai.this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
            ai.this.ehi.onSceneEnd(3, i, "", ai.this);
            AppMethodBeat.o(27376);
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] l(String str, byte[] bArr) {
            return null;
        }
    };
    boolean fFs = true;
    private String fgq = null;
    b pJj = null;
    long pJl = -1;
    int retCode = 0;
    long startTime = 0;
    String toUser;
    private boolean vcD = true;
    private long vcE = -1;

    public ai(long j, String str, String str2) {
        AppMethodBeat.i(27380);
        this.pJl = j;
        this.fgq = str;
        this.cvF = str2;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new ckq();
        aVar.fsK = new ckr();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadappattach";
        aVar.fsI = 220;
        aVar.fsL = 105;
        aVar.fsM = 1000000105;
        this.ehh = aVar.acD();
        ab.i("MicroMsg.NetSceneUploadAppAttach", "summerbig new NetSceneUploadAppAttach rowid[%d], emoticonmd5[%s], stack[%s]", Long.valueOf(j), str, bo.dpG());
        AppMethodBeat.o(27380);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(27381);
        this.ehi = fVar;
        this.pJj = new b();
        if (!am.aUq().b(this.pJl, (com.tencent.mm.sdk.e.c) this.pJj) || this.pJj == null) {
            ab.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.g.Mq() + " summerbig get info failed rowid:" + this.pJl);
            this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
            this.pJj = null;
            AppMethodBeat.o(27381);
            return -1;
        } else if (this.pJj.field_status != 101) {
            ab.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.g.Mq() + " summerbig get field_status failed rowid:" + this.pJl + " status:" + this.pJj.field_status);
            AppMethodBeat.o(27381);
            return -1;
        } else {
            Object obj;
            if (this.startTime == 0) {
                this.startTime = bo.anU();
                this.vcE = this.pJj.field_offset;
            }
            ab.i("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene rowid[%d], fileFullPath[%s], totalLen[%d],isUpload[%b], isUseCdn[%b], type[%d]", Long.valueOf(this.pJl), this.pJj.field_fileFullPath, Long.valueOf(this.pJj.field_totalLen), Boolean.valueOf(this.pJj.field_isUpload), Integer.valueOf(this.pJj.field_isUseCdn), Long.valueOf(this.pJj.field_type));
            if (bo.isNullOrNil(this.pJj.field_appId)) {
                ab.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : appId is null");
                if (!(this.pJj.field_type == 8 || this.pJj.field_type == 6)) {
                    this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                    AppMethodBeat.o(27381);
                    return -1;
                }
            }
            if (this.pJj.field_type == 8 || this.pJj.field_type == 9) {
                ab.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra cdn not support Emoji or voiceremind now type:%d", Long.valueOf(this.pJj.field_type));
                obj = null;
            } else {
                com.tencent.mm.al.f.afx();
                if (com.tencent.mm.al.b.lg(4) || this.pJj.field_isUseCdn == 1) {
                    aw.ZK();
                    bi jf = com.tencent.mm.model.c.XO().jf(this.pJj.field_msgInfoId);
                    if (jf.field_msgId != this.pJj.field_msgInfoId) {
                        ab.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra read msg info failed msgId[%d], rowid[%d], createtime[%d], len[%d], status[%d], upload[%b], useCdn[%d], mediaId[%s]", Long.valueOf(this.pJj.field_msgInfoId), Long.valueOf(this.pJj.xDa), Long.valueOf(this.pJj.field_createTime), Long.valueOf(this.pJj.field_totalLen), Long.valueOf(this.pJj.field_status), Boolean.valueOf(this.pJj.field_isUpload), Integer.valueOf(this.pJj.field_isUseCdn), this.pJj.field_mediaId);
                        this.toUser = null;
                        obj = null;
                    } else {
                        this.toUser = jf.field_talker;
                        String str = "";
                        if (!bo.isNullOrNil(jf.field_imgPath)) {
                            str = com.tencent.mm.at.o.ahl().sj(jf.field_imgPath);
                        }
                        int cs = com.tencent.mm.a.e.cs(str);
                        int cs2 = com.tencent.mm.a.e.cs(this.pJj.field_fileFullPath);
                        if (cs >= com.tencent.mm.i.a.efW) {
                            ab.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", str, Integer.valueOf(cs));
                            obj = null;
                        } else {
                            this.fFa = com.tencent.mm.al.c.a("upattach", this.pJj.field_createTime, jf.field_talker, this.pJl);
                            ab.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra genClientId field_createTime[%d], useCdnTransClientId[%s]", Long.valueOf(this.pJj.field_createTime), this.fFa);
                            if (bo.isNullOrNil(this.fFa)) {
                                ab.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra genClientId failed not use cdn rowid:%d", Long.valueOf(this.pJl));
                                obj = null;
                            } else {
                                Object obj2;
                                g gVar = new g();
                                String str2 = jf.field_content;
                                if (t.kH(jf.field_talker)) {
                                    int ox = bf.ox(jf.field_content);
                                    if (ox != -1) {
                                        str2 = (jf.field_content + " ").substring(ox + 2).trim();
                                    }
                                }
                                this.csH = b.me(bo.anj(str2));
                                if (this.csH != null) {
                                    ab.d("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra amc.cdnAttachUrl[%s], amc.aesKey[%s], amc.filemd5[%s], amc.type[%d]", this.csH.fgD, bo.anv(this.csH.eyr), this.csH.filemd5, Integer.valueOf(this.csH.type));
                                    gVar.field_fileId = this.csH.fgD;
                                    gVar.field_aesKey = this.csH.eyr;
                                    gVar.field_filemd5 = this.csH.filemd5;
                                    obj2 = (this.csH.fgs != 0 || this.csH.fgo > 26214400) ? 1 : null;
                                } else {
                                    ab.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra parse content xml failed");
                                    obj2 = null;
                                }
                                gVar.egl = this.fFk;
                                gVar.field_mediaId = this.fFa;
                                gVar.field_fullpath = this.pJj.field_fileFullPath;
                                gVar.field_thumbpath = str;
                                gVar.field_fileType = obj2 != null ? com.tencent.mm.i.a.efE : com.tencent.mm.i.a.MediaType_FILE;
                                gVar.field_svr_signature = obj2 != null ? bo.nullAsNil(this.pJj.field_signature) : "";
                                gVar.field_onlycheckexist = obj2 != null ? bo.isNullOrNil(this.pJj.field_signature) : false;
                                gVar.field_fake_bigfile_signature_aeskey = this.pJj.field_fakeAeskey;
                                gVar.field_fake_bigfile_signature = this.pJj.field_fakeSignature;
                                gVar.field_talker = jf.field_talker;
                                gVar.field_priority = com.tencent.mm.i.a.efC;
                                gVar.field_totalLen = cs2;
                                gVar.field_needStorage = false;
                                gVar.field_isStreamMedia = false;
                                gVar.field_enable_hitcheck = this.fFs;
                                gVar.field_chattype = t.kH(jf.field_talker) ? 1 : 0;
                                gVar.field_force_aeskeycdn = false;
                                gVar.field_trysafecdn = true;
                                ab.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra checkUseCdn msgId:%d file[%s][%d] thumb[%s][%d], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b] force_aeskeycdn[%b] trysafecdn[%b] aeskey[%s], md5[%s], signature[%s], faeskey[%s], fsignature[%s]", Long.valueOf(this.pJj.field_msgInfoId), gVar.field_fullpath, Integer.valueOf(cs2), str, Integer.valueOf(cs), this.fFa, Integer.valueOf(gVar.field_fileType), Boolean.valueOf(gVar.field_enable_hitcheck), Boolean.valueOf(gVar.field_onlycheckexist), Boolean.valueOf(gVar.field_force_aeskeycdn), Boolean.valueOf(gVar.field_trysafecdn), bo.anv(gVar.field_aesKey), gVar.field_filemd5, bo.anv(gVar.field_svr_signature), bo.anv(gVar.field_fake_bigfile_signature_aeskey), bo.anv(gVar.field_fake_bigfile_signature));
                                if (com.tencent.mm.al.f.afx().e(gVar)) {
                                    if (this.pJj.field_isUseCdn != 1) {
                                        this.pJj.field_isUseCdn = 1;
                                        boolean a = am.aUq().a(this.pJj, new String[0]);
                                        if (!a) {
                                            ab.e("MicroMsg.NetSceneUploadAppAttach", "summerbig checkUseCdn update info ret:".concat(String.valueOf(a)));
                                            this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                                            this.ehi.onSceneEnd(3, -1, "", this);
                                            obj = null;
                                        }
                                    }
                                    ab.i("MicroMsg.NetSceneUploadAppAttach", "summerbig checkUseCdn ret true useCdnTransClientId[%s]", this.fFa);
                                    obj = 1;
                                } else {
                                    ab.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra addSendTask failed.");
                                    this.fFa = "";
                                    obj = null;
                                }
                            }
                        }
                    }
                } else {
                    r2 = new Object[2];
                    com.tencent.mm.al.f.afx();
                    r2[0] = Boolean.valueOf(com.tencent.mm.al.b.lg(4));
                    r2[1] = Integer.valueOf(this.pJj.field_isUseCdn);
                    ab.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra not use cdn flag:%b getCdnInfo:%d", r2);
                    obj = null;
                }
            }
            if (obj != null) {
                ab.d("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene cdntra use cdn return -1 for onGYNetEnd client rowid:%d", Long.valueOf(this.pJl));
                AppMethodBeat.o(27381);
                return 0;
            } else if (this.pJj.field_netTimes > 3200) {
                l.jC(this.pJj.xDa);
                ab.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.g.Mq() + " summerbig doScene info.field_netTimes > DOSCENE_LIMIT SET ERROR! rowid:" + this.pJl);
                AppMethodBeat.o(27381);
                return -1;
            } else {
                b bVar = this.pJj;
                bVar.field_netTimes++;
                if (bo.isNullOrNil(this.pJj.field_clientAppDataId)) {
                    ab.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : clientAppDataId is null");
                    this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                    AppMethodBeat.o(27381);
                    return -1;
                } else if (this.pJj.field_totalLen <= 0 || this.pJj.field_totalLen > 26214400) {
                    ab.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : totalLen is invalid, totalLen = " + this.pJj.field_totalLen);
                    this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                    if (this.pJj.field_totalLen > 26214400) {
                        l.jC(this.pJj.xDa);
                    }
                    AppMethodBeat.o(27381);
                    return -1;
                } else if (bo.isNullOrNil(this.pJj.field_fileFullPath)) {
                    ab.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : fileFullPath is null");
                    this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                    AppMethodBeat.o(27381);
                    return -1;
                } else if (com.tencent.mm.a.e.cs(this.pJj.field_fileFullPath) > 26214400) {
                    ab.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene doScene : file is too large");
                    l.jC(this.pJj.xDa);
                    AppMethodBeat.o(27381);
                    return -1;
                } else {
                    byte[] f;
                    if (bo.isNullOrNil(this.fgq)) {
                        f = com.tencent.mm.a.e.f(this.pJj.field_fileFullPath, (int) this.pJj.field_offset, Utility.DEFAULT_STREAM_BUFFER_SIZE);
                    } else {
                        f = com.tencent.mm.a.e.f(this.pJj.field_fileFullPath, (int) this.pJj.field_offset, 32768);
                    }
                    if (bo.cb(f)) {
                        ab.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene doScene : data is null");
                        this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                        AppMethodBeat.o(27381);
                        return -1;
                    }
                    ckq ckq = (ckq) this.ehh.fsG.fsP;
                    ckq.fKh = this.pJj.field_appId;
                    ckq.vFE = (int) this.pJj.field_sdkVer;
                    ckq.xit = this.pJj.field_clientAppDataId;
                    ckq.jCt = (int) this.pJj.field_type;
                    ckq.jBB = r.Yz();
                    ckq.ptw = (int) this.pJj.field_totalLen;
                    ckq.ptx = (int) this.pJj.field_offset;
                    int a2;
                    if (this.fgq == null || !this.vcD) {
                        ckq.pty = f.length;
                        ckq.ptz = new SKBuiltinBuffer_t().setBuffer(f);
                        if (this.fgq != null) {
                            ckq.wdO = this.fgq;
                        }
                        a2 = a(eVar, this.ehh, this);
                        AppMethodBeat.o(27381);
                        return a2;
                    }
                    ckq.wdO = this.fgq;
                    ckq.ptw = (int) this.pJj.field_totalLen;
                    ckq.pty = 0;
                    ckq.ptz = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
                    this.vcD = false;
                    a2 = a(eVar, this.ehh, this);
                    AppMethodBeat.o(27381);
                    return a2;
                }
            }
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(27382);
        ab.d("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : errType = " + i2 + ", errCode = " + i3);
        if (i2 == 3 && i3 == -1 && !bo.isNullOrNil(this.fFa)) {
            ab.w("MicroMsg.NetSceneUploadAppAttach", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.fFa);
            AppMethodBeat.o(27382);
        } else if (i2 == 0 && i3 == 0) {
            ckr ckr = (ckr) ((com.tencent.mm.ai.b) qVar).fsH.fsP;
            if (ckr.fKh != null && this.fgq == null && (!ckr.fKh.equals(this.pJj.field_appId) || !ckr.xit.equals(this.pJj.field_clientAppDataId))) {
                ab.e("MicroMsg.NetSceneUploadAppAttach", "argument is not consistent");
                this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                this.ehi.onSceneEnd(3, -1, "", this);
                AppMethodBeat.o(27382);
            } else if (ckr.ptw < 0 || ((long) ckr.ptw) != this.pJj.field_totalLen || ckr.ptx < 0 || ((long) ckr.ptx) > this.pJj.field_totalLen) {
                ab.e("MicroMsg.NetSceneUploadAppAttach", "dataLen, startPos or totalLen is incorrect");
                this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                this.ehi.onSceneEnd(3, -1, "", this);
                AppMethodBeat.o(27382);
            } else {
                this.pJj.field_offset = (long) ckr.ptx;
                this.pJj.field_mediaSvrId = l.aiK(ckr.fKk) ? ckr.fKk : "";
                if (this.pJj.field_status == 105) {
                    ab.w("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd STATUS PAUSE [" + this.pJj.field_mediaSvrId + "," + this.pJj.field_offset + "] ");
                    this.ehi.onSceneEnd(i2, -1, "", this);
                    AppMethodBeat.o(27382);
                    return;
                }
                if (this.pJj.field_offset == this.pJj.field_totalLen) {
                    if (bo.isNullOrNil(this.pJj.field_mediaSvrId)) {
                        ab.e("MicroMsg.NetSceneUploadAppAttach", "finish upload but mediaid == null!");
                        this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                        this.ehi.onSceneEnd(3, -1, "", this);
                        l.jC(this.pJj.xDa);
                        AppMethodBeat.o(27382);
                        return;
                    }
                    this.pJj.field_status = 199;
                    h.pYm.e(10420, Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(this.pJj.field_totalLen - this.vcE));
                }
                boolean a = am.aUq().a(this.pJj, new String[0]);
                if (!a) {
                    ab.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd update info ret:".concat(String.valueOf(a)));
                    this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                    d(null);
                    this.ehi.onSceneEnd(3, -1, "", this);
                    AppMethodBeat.o(27382);
                } else if (this.pJj.field_status == 199) {
                    this.ehi.onSceneEnd(0, 0, "", this);
                    AppMethodBeat.o(27382);
                } else {
                    if (a(this.ftf, this.ehi) < 0) {
                        ab.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : doScene fail");
                        this.ehi.onSceneEnd(3, -1, "", this);
                    }
                    AppMethodBeat.o(27382);
                }
            }
        } else {
            ab.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : errType = " + i2 + ", errCode = " + i3);
            this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
            if (i2 == 4) {
                h.pYm.e(10420, Integer.valueOf(i3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(this.pJj.field_totalLen - this.vcE));
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(27382);
        }
    }

    public final int acn() {
        return 3200;
    }

    public final int getType() {
        return 220;
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }

    /* Access modifiers changed, original: final */
    public final void d(d dVar) {
        AppMethodBeat.i(27383);
        if (this.pJj.field_type != 2) {
            AppMethodBeat.o(27383);
            return;
        }
        com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100131");
        if (ll.isValid()) {
            this.eFs = com.tencent.mm.platformtools.ah.getInt((String) ll.dru().get("needUploadData"), 1);
        }
        if (this.eFq || this.eFs == 0) {
            AppMethodBeat.o(27383);
            return;
        }
        this.eFt = dVar;
        this.eFq = true;
        np npVar = new np();
        a.xxA.c(this.eFv);
        npVar.cJU.filePath = this.pJj.field_fileFullPath;
        a.xxA.m(npVar);
        AppMethodBeat.o(27383);
    }
}
