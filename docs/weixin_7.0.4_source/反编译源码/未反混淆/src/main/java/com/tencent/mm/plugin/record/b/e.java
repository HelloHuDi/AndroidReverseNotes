package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.g;
import com.tencent.mm.ai.m;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.xj;
import com.tencent.mm.protocal.protobuf.xk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;

public final class e extends m implements k {
    private String cHr;
    bi cKd;
    public long cvx;
    private b ehh;
    f ehi;
    g fEW;
    String fFa;
    private com.tencent.mm.i.g.a fFk;
    private long jvz;
    com.tencent.mm.pluginsdk.model.app.b pJj;
    public long pJl;
    private int pJm;
    String pJn;
    private boolean pJo;
    private boolean pJp;
    private boolean pJq;
    public int retCode;
    long startTime;
    private int type;

    public interface a {
        void ceD();
    }

    public e(String str) {
        this(str, 0, null);
    }

    public e(long j, String str, g gVar) {
        this(str, j, gVar);
        this.cvx = j;
    }

    public e(long j, long j2, g gVar) {
        AppMethodBeat.i(135655);
        this.pJj = null;
        this.pJl = -1;
        this.cHr = "";
        this.cvx = 0;
        this.cKd = null;
        this.fFa = "";
        this.startTime = 0;
        this.pJm = -1;
        this.pJn = "";
        this.type = 0;
        this.retCode = 0;
        this.pJo = false;
        this.pJp = false;
        this.jvz = 0;
        this.pJq = false;
        this.fFk = new com.tencent.mm.i.g.a() {
            public final int a(String str, final int i, c cVar, final d dVar, boolean z) {
                AppMethodBeat.i(135653);
                String str2 = "MicroMsg.NetSceneDownloadAppAttach";
                String str3 = "summerbig callback mediaId[%s], startRet[%d], progressInfo[%s], sceneResult[%s], finish[%b]";
                Object[] objArr = new Object[5];
                objArr[0] = str;
                objArr[1] = Integer.valueOf(i);
                objArr[2] = cVar;
                objArr[3] = dVar;
                objArr[4] = Boolean.valueOf(cVar == null);
                ab.d(str2, str3, objArr);
                if (i == -21006) {
                    ab.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", e.this.fFa);
                    AppMethodBeat.o(135653);
                    return 0;
                } else if (i != 0) {
                    a.jC(e.this.pJj.xDa);
                    new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.r(Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(e.this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), "")).ajK();
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(135645);
                            e.this.ehi.onSceneEnd(3, i, "", e.this);
                            AppMethodBeat.o(135645);
                        }
                    });
                    AppMethodBeat.o(135653);
                    return 0;
                } else {
                    e.this.pJj = a.i(str, e.this.cvx);
                    if (e.this.pJj == null) {
                        ab.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig attachInfo is null");
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(135646);
                                e.this.ehi.onSceneEnd(3, i, "", e.this);
                                AppMethodBeat.o(135646);
                            }
                        });
                        AppMethodBeat.o(135653);
                        return 0;
                    } else if (e.this.pJj.field_status == 102) {
                        ab.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig dancy attach download has paused, status:%d", Long.valueOf(e.this.pJj.field_status));
                        com.tencent.mm.al.f.afx().rN(e.this.fFa);
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(135647);
                                e.this.ehi.onSceneEnd(3, i, "attach  has paused, status=" + e.this.pJj.field_status, e.this);
                                AppMethodBeat.o(135647);
                            }
                        });
                        AppMethodBeat.o(135653);
                        return 0;
                    } else if (cVar == null) {
                        if (dVar != null) {
                            if (dVar.field_retCode != 0) {
                                a.jC(e.this.pJj.xDa);
                                ab.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra sceneResult.retCode :%d", Integer.valueOf(dVar.field_retCode));
                            } else {
                                String str4;
                                new File(e.this.pJn).renameTo(new File(e.this.pJj.field_fileFullPath));
                                e.this.pJj.field_status = 199;
                                e.this.pJj.field_offset = e.this.pJj.field_totalLen;
                                com.tencent.mm.plugin.s.a.aUq().a(e.this.pJj, new String[0]);
                                h.pYm.a(198, 45, e.this.pJj.field_totalLen, false);
                                h.pYm.a(198, 46, 1, false);
                                h hVar = h.pYm;
                                if (e.this.cKd == null) {
                                    str4 = "";
                                } else {
                                    str4 = e.this.cKd.field_talker;
                                }
                                hVar.a(198, t.kH(str4) ? 48 : 47, 1, false);
                                bi jf = ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().jf(e.this.pJj.field_msgInfoId);
                                if (jf.field_status == 5) {
                                    jf.setStatus(3);
                                    ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().a(jf.field_msgId, jf);
                                } else {
                                    ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().a(new com.tencent.mm.plugin.messenger.foundation.a.a.h.c(jf.field_talker, "update", jf));
                                }
                            }
                            new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.r(Integer.valueOf(dVar.field_retCode), Integer.valueOf(2), Long.valueOf(e.this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(e.this.pJj.field_totalLen), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.efY)).ajK();
                            if (dVar.field_retCode != 0) {
                                new com.tencent.mm.g.b.a.d(com.tencent.mm.plugin.report.a.r(Integer.valueOf(dVar.field_retCode), Integer.valueOf(2), Long.valueOf(e.this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(e.this.pJj.field_totalLen), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.efY)).ajK();
                            }
                            if (e.this.fEW != null) {
                                al.d(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(135650);
                                        e.this.fEW.a((int) e.this.pJj.field_offset, (int) e.this.pJj.field_totalLen, e.this);
                                        AppMethodBeat.o(135650);
                                    }
                                });
                            }
                            if (dVar.field_retCode != 0) {
                                al.d(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(135651);
                                        e.this.ehi.onSceneEnd(3, dVar.field_retCode, "", e.this);
                                        AppMethodBeat.o(135651);
                                    }
                                });
                            } else {
                                al.d(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(135652);
                                        e.this.ehi.onSceneEnd(0, 0, "", e.this);
                                        AppMethodBeat.o(135652);
                                    }
                                });
                            }
                        }
                        AppMethodBeat.o(135653);
                        return 0;
                    } else if (((long) cVar.field_finishedLength) == e.this.pJj.field_totalLen) {
                        ab.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra ignore progress 100%");
                        AppMethodBeat.o(135653);
                        return 0;
                    } else if (e.this.pJj.field_offset > ((long) cVar.field_finishedLength)) {
                        ab.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdnEndProc error oldpos:%d newpos:%d", Long.valueOf(e.this.pJj.field_offset), Integer.valueOf(cVar.field_finishedLength));
                        a.jC(e.this.pJj.xDa);
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(135648);
                                e.this.ehi.onSceneEnd(3, i, "", e.this);
                                AppMethodBeat.o(135648);
                            }
                        });
                        AppMethodBeat.o(135653);
                        return 0;
                    } else {
                        e.this.pJj.field_offset = (long) cVar.field_finishedLength;
                        com.tencent.mm.plugin.s.a.aUq().a(e.this.pJj, new String[0]);
                        if (e.this.fEW != null) {
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(135649);
                                    e.this.fEW.a((int) e.this.pJj.field_offset, (int) e.this.pJj.field_totalLen, e.this);
                                    AppMethodBeat.o(135649);
                                }
                            });
                        }
                        ab.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra progresscallback id:%s finish:%d total:%d", e.this.fFa, Integer.valueOf(cVar.field_finishedLength), Integer.valueOf(cVar.field_toltalLength));
                        AppMethodBeat.o(135653);
                        return 0;
                    }
                }
            }

            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            public final byte[] l(String str, byte[] bArr) {
                return null;
            }
        };
        this.jvz = j2;
        this.cvx = j;
        this.pJj = com.tencent.mm.plugin.s.a.aUq().lZ(j);
        this.fEW = gVar;
        this.pJp = true;
        if (this.pJj == null) {
            ab.e("MicroMsg.NetSceneDownloadAppAttach", "big appMsg, info is null, msgid = , svrId".concat(String.valueOf(j)), Long.valueOf(j2));
            AppMethodBeat.o(135655);
            return;
        }
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new xj();
        aVar.fsK = new xk();
        aVar.uri = "/cgi-bin/micromsg-bin/downloadappattach";
        aVar.fsI = 221;
        aVar.fsL = 106;
        aVar.fsM = 1000000106;
        this.ehh = aVar.acD();
        AppMethodBeat.o(135655);
    }

    public e(com.tencent.mm.pluginsdk.model.app.b bVar) {
        AppMethodBeat.i(135656);
        this.pJj = null;
        this.pJl = -1;
        this.cHr = "";
        this.cvx = 0;
        this.cKd = null;
        this.fFa = "";
        this.startTime = 0;
        this.pJm = -1;
        this.pJn = "";
        this.type = 0;
        this.retCode = 0;
        this.pJo = false;
        this.pJp = false;
        this.jvz = 0;
        this.pJq = false;
        this.fFk = /* anonymous class already generated */;
        this.pJj = bVar;
        this.pJo = true;
        this.cHr = this.pJj.field_mediaId;
        this.fEW = null;
        this.type = 0;
        if (bVar == null) {
            ab.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig <init>, info is null, mediaId = " + this.cHr);
            AppMethodBeat.o(135656);
            return;
        }
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new xj();
        aVar.fsK = new xk();
        aVar.uri = "/cgi-bin/micromsg-bin/downloadappattach";
        aVar.fsI = 221;
        aVar.fsL = 106;
        aVar.fsM = 1000000106;
        this.ehh = aVar.acD();
        ab.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig NetSceneDownloadAppAttach info fullpath[%s], justSaveFile[%b], stack[%s]", bVar.field_fileFullPath, Boolean.TRUE, bo.dpG());
        AppMethodBeat.o(135656);
    }

    private e(String str, long j, g gVar) {
        AppMethodBeat.i(135657);
        this.pJj = null;
        this.pJl = -1;
        this.cHr = "";
        this.cvx = 0;
        this.cKd = null;
        this.fFa = "";
        this.startTime = 0;
        this.pJm = -1;
        this.pJn = "";
        this.type = 0;
        this.retCode = 0;
        this.pJo = false;
        this.pJp = false;
        this.jvz = 0;
        this.pJq = false;
        this.fFk = /* anonymous class already generated */;
        this.cHr = str;
        this.cvx = j;
        this.fEW = gVar;
        this.type = 0;
        this.pJj = com.tencent.mm.plugin.s.a.aUq().aiE(str);
        if (this.pJj == null) {
            this.pJj = com.tencent.mm.plugin.s.a.aUq().lZ(j);
        }
        if (this.pJj == null) {
            ab.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig <init>, info is null, mediaId = ".concat(String.valueOf(str)));
            AppMethodBeat.o(135657);
            return;
        }
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new xj();
        aVar.fsK = new xk();
        aVar.uri = "/cgi-bin/micromsg-bin/downloadappattach";
        aVar.fsI = 221;
        aVar.fsL = 106;
        aVar.fsM = 1000000106;
        this.ehh = aVar.acD();
        ab.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig NetSceneDownloadAppAttach , type[%d], info fullpath[%s], field_type[%d], signature[%s], stack[%s]", Integer.valueOf(0), this.pJj.field_fileFullPath, Long.valueOf(this.pJj.field_type), this.pJj.field_signature, bo.dpG());
        AppMethodBeat.o(135657);
    }

    public final void ceC() {
        AppMethodBeat.i(135658);
        this.pJq = true;
        if (this.pJq) {
            com.tencent.mm.a.e.e(this.pJj.field_fileFullPath, "#!AMR\n".getBytes());
        }
        AppMethodBeat.o(135658);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(135659);
        if (!this.pJo) {
            com.tencent.mm.al.f.afx().rO(this.fFa);
            this.pJj = com.tencent.mm.plugin.s.a.aUq().lZ(this.cvx);
            if (this.pJj == null) {
                ab.i("MicroMsg.NetSceneDownloadAppAttach", "pause get by msgid  %是is null then get by mediaId %s", Long.valueOf(this.cvx), this.cHr);
                this.pJj = com.tencent.mm.plugin.s.a.aUq().aiE(this.cHr);
            }
        }
        ab.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig pause listener[%s], info[%s], justSaveFile[%b], stack[%s]", aVar, this.pJj, Boolean.valueOf(this.pJo), bo.dpG());
        if (this.pJj == null) {
            AppMethodBeat.o(135659);
            return;
        }
        if (this.pJj.field_status == 101 && aVar != null) {
            aVar.ceD();
        }
        this.pJj.field_status = 102;
        if (!this.pJo) {
            boolean a = com.tencent.mm.plugin.s.a.aUq().a(this.pJj, new String[0]);
            ab.i("MicroMsg.NetSceneDownloadAppAttach", "pause done %s", Boolean.valueOf(a));
        }
        AppMethodBeat.o(135659);
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(135660);
        this.ehi = fVar;
        if (this.pJj == null) {
            ab.e("MicroMsg.NetSceneDownloadAppAttach", com.tencent.mm.compatible.util.g.Mq() + " get info failed mediaId:" + this.cHr);
            this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
            AppMethodBeat.o(135660);
            return -1;
        }
        this.cKd = ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().jf(this.cvx);
        if (this.cKd == null || this.cKd.field_msgId != this.cvx) {
            ab.e("MicroMsg.NetSceneDownloadAppAttach", com.tencent.mm.compatible.util.g.Mq() + " get msginfo failed mediaId:%s  msgId:%d", this.cHr, Long.valueOf(this.cvx));
            this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
            AppMethodBeat.o(135660);
            return -1;
        }
        if (this.startTime == 0) {
            this.startTime = bo.anU();
            this.pJm = (int) this.pJj.field_offset;
        }
        xj xjVar;
        int a;
        if (this.jvz != 0) {
            xjVar = (xj) this.ehh.fsG.fsP;
            xjVar.jBB = r.Yz();
            xjVar.ptw = (int) this.pJj.field_totalLen;
            xjVar.ptx = (int) this.pJj.field_offset;
            xjVar.pty = 0;
            xjVar.jCt = 40;
            xjVar.ptF = this.jvz;
            a = a(eVar, this.ehh, this);
            AppMethodBeat.o(135660);
            return a;
        }
        Object obj;
        String str = this.cKd.field_content;
        if (t.kH(this.cKd.field_talker)) {
            int ox = bf.ox(this.cKd.field_content);
            if (ox != -1) {
                str = (this.cKd.field_content + " ").substring(ox + 2).trim();
            }
        }
        com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(bo.anj(str));
        if (me == null) {
            ab.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn cdntra parse content xml failed: mediaId:%s", this.cHr);
            obj = null;
        } else {
            ab.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra checkUseCdn msgid:%d total:%d fullpath:%s fileid:%s aeskey:%s ", Long.valueOf(this.cvx), Long.valueOf(this.pJj.field_totalLen), this.pJj.field_fileFullPath, me.fgD, bo.anv(me.eyr));
            if ((bo.isNullOrNil(me.fgD) && bo.isNullOrNil(me.fgu)) || bo.isNullOrNil(me.eyr)) {
                ab.w("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra checkUseCdn msgId:%d Not use CDN  cdnAttachUrl:%s aes:%s ", Long.valueOf(this.cvx), me.fgD, bo.anv(me.eyr));
                obj = null;
            } else {
                this.fFa = com.tencent.mm.al.c.a("downattach", this.pJj.field_createTime, this.cKd.field_talker, this.pJl);
                if (bo.isNullOrNil(this.fFa)) {
                    ab.w("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra genClientId failed not use cdn rowid:%d", Long.valueOf(this.pJl));
                    obj = null;
                } else {
                    com.tencent.mm.a.e.cx(this.pJj.field_fileFullPath);
                    this.pJn = this.pJj.field_fileFullPath + "_tmp";
                    com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
                    gVar.field_mediaId = this.fFa;
                    gVar.field_fullpath = this.pJn;
                    a = (me.fgs != 0 || me.fgo > 26214400) ? com.tencent.mm.i.a.efE : com.tencent.mm.i.a.MediaType_FILE;
                    gVar.field_fileType = a;
                    gVar.field_totalLen = (int) this.pJj.field_totalLen;
                    gVar.field_aesKey = me.eyr;
                    gVar.field_fileId = me.fgD;
                    gVar.field_svr_signature = this.pJj.field_signature;
                    gVar.field_fake_bigfile_signature_aeskey = this.pJj.field_fakeAeskey;
                    gVar.field_fake_bigfile_signature = this.pJj.field_fakeSignature;
                    gVar.field_onlycheckexist = false;
                    gVar.field_priority = com.tencent.mm.i.a.efC;
                    gVar.egl = this.fFk;
                    gVar.field_chattype = t.kH(this.cKd.field_talker) ? 1 : 0;
                    if (!bo.isNullOrNil(me.fgu)) {
                        gVar.field_fileType = 19;
                        gVar.field_authKey = me.fgA;
                        gVar.egm = me.fgu;
                        gVar.field_fileId = "";
                    }
                    ab.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn addRecvTask taskInfo field_fileType[%d], fileFullPath[%s], aeskey[%s], signature[%s], faeskey[%s], fsignature[%s], onlycheckexist[%s]", Integer.valueOf(gVar.field_fileType), gVar.field_fullpath, bo.anv(gVar.field_aesKey), bo.anv(gVar.field_svr_signature), bo.anv(gVar.field_fake_bigfile_signature_aeskey), bo.anv(gVar.field_fake_bigfile_signature), Boolean.valueOf(gVar.field_onlycheckexist));
                    if (com.tencent.mm.al.f.afx().b(gVar, -1)) {
                        if (this.pJj.field_isUseCdn != 1) {
                            this.pJj.field_isUseCdn = 1;
                            boolean a2 = com.tencent.mm.plugin.s.a.aUq().a(this.pJj, new String[0]);
                            if (!a2) {
                                ab.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn update info ret:".concat(String.valueOf(a2)));
                                this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                                this.ehi.onSceneEnd(3, -1, "", this);
                                obj = null;
                            }
                        }
                        obj = 1;
                    } else {
                        ab.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra addSendTask failed.");
                        this.fFa = "";
                        obj = null;
                    }
                }
            }
        }
        if (obj != null) {
            ab.d("MicroMsg.NetSceneDownloadAppAttach", "cdntra use cdn return -1 for onGYNetEnd mediaid:%s", this.cHr);
            AppMethodBeat.o(135660);
            return 0;
        }
        if (this.pJj.field_status == 102) {
            this.pJj.field_status = 101;
            if (!this.pJo) {
                com.tencent.mm.plugin.s.a.aUq().a(this.pJj, new String[0]);
            }
        }
        this.pJl = this.pJj.xDa;
        if (bo.isNullOrNil(this.pJj.field_mediaSvrId) && this.jvz == 0) {
            ab.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : mediaId is null");
            this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
            AppMethodBeat.o(135660);
            return -1;
        } else if (this.pJj.field_totalLen <= 0 || this.pJj.field_totalLen > 26214400) {
            ab.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : totalLen is invalid, totalLen = " + this.pJj.field_totalLen);
            this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
            AppMethodBeat.o(135660);
            return -1;
        } else if (bo.isNullOrNil(this.pJj.field_fileFullPath) && this.jvz == 0) {
            ab.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : fileFullPath is null");
            this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
            AppMethodBeat.o(135660);
            return -1;
        } else {
            a = com.tencent.mm.a.e.cs(this.pJj.field_fileFullPath);
            if (this.pJq) {
                a -= 6;
                if (a <= 0) {
                    a = 0;
                }
            }
            if (((long) a) != this.pJj.field_offset) {
                ab.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : fileFullPath is invalid, fileLength = " + a + ", info.field_offset = " + this.pJj.field_offset);
                this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                AppMethodBeat.o(135660);
                return -1;
            }
            ab.i("MicroMsg.NetSceneDownloadAppAttach", "downing attach by non cdn, appId: %s,  mediaId: %s, sdkVer: %d", this.pJj.field_appId, this.pJj.field_mediaSvrId, Long.valueOf(this.pJj.field_sdkVer));
            xjVar = (xj) this.ehh.fsG.fsP;
            xjVar.fKh = this.pJj.field_appId;
            xjVar.fKk = this.pJj.field_mediaSvrId;
            xjVar.vFE = (int) this.pJj.field_sdkVer;
            xjVar.jBB = r.Yz();
            xjVar.ptw = (int) this.pJj.field_totalLen;
            xjVar.ptx = (int) this.pJj.field_offset;
            xjVar.pty = 0;
            if (this.jvz != 0) {
                xjVar.ptF = this.jvz;
            }
            if (this.type != 0) {
                xjVar.jCt = this.type;
            } else {
                xjVar.jCt = (int) this.pJj.field_type;
            }
            a = a(eVar, this.ehh, this);
            AppMethodBeat.o(135660);
            return a;
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(135661);
        ab.d("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : errType = " + i2 + ", errCode = " + i3);
        if (i2 == 3 && i3 == -1 && !bo.isNullOrNil(this.fFa)) {
            ab.w("MicroMsg.NetSceneDownloadAppAttach", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.fFa);
            AppMethodBeat.o(135661);
        } else if (i2 == 0 && i3 == 0) {
            xk xkVar = (xk) ((b) qVar).fsH.fsP;
            this.pJj.field_totalLen = (long) xkVar.ptw;
            if (xkVar.fKk != null && !xkVar.fKk.equals(this.pJj.field_mediaSvrId)) {
                ab.e("MicroMsg.NetSceneDownloadAppAttach", "argument is not consistent");
                this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                this.ehi.onSceneEnd(3, -1, "", this);
                AppMethodBeat.o(135661);
            } else if (((long) xkVar.ptx) != this.pJj.field_offset) {
                ab.e("MicroMsg.NetSceneDownloadAppAttach", "startPos, totalLen is incorrect startpos:" + xkVar.ptx);
                this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                this.ehi.onSceneEnd(3, -1, "", this);
                AppMethodBeat.o(135661);
            } else if (((long) xkVar.pty) + this.pJj.field_offset > this.pJj.field_totalLen) {
                ab.e("MicroMsg.NetSceneDownloadAppAttach", "data buffer is incorrect datalen:" + xkVar.pty + " off:" + this.pJj.field_offset + " total?:" + this.pJj.field_totalLen);
                this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                this.ehi.onSceneEnd(3, -1, "", this);
                AppMethodBeat.o(135661);
            } else {
                byte[] a = aa.a(xkVar.ptz);
                if (a == null || a.length == 0 || a.length != xkVar.pty) {
                    ab.e("MicroMsg.NetSceneDownloadAppAttach", "data buffer is incorrect");
                    this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                    this.ehi.onSceneEnd(3, -1, "", this);
                    AppMethodBeat.o(135661);
                    return;
                }
                String str2 = new String(a);
                ab.d("MicroMsg.NetSceneDownloadAppAttach", "dancy download big appmsg : %s", Boolean.valueOf(this.pJp));
                if (this.pJj.field_offset < this.pJj.field_totalLen && this.pJp) {
                    bi jf = ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().jf(this.pJj.field_msgInfoId);
                    StringBuffer stringBuffer;
                    if (!str2.startsWith("<appmsg")) {
                        if (!jf.field_content.startsWith("<msg>")) {
                            stringBuffer = new StringBuffer();
                            stringBuffer.append(jf.field_content).append(str2);
                            this.pJj.field_fullXml = stringBuffer.toString();
                        }
                        if (str2.endsWith("</appmsg>") || this.pJj.field_offset + ((long) a.length) == this.pJj.field_totalLen) {
                            if (t.kH(jf.field_talker)) {
                                String[] split = jf.field_content.split(IOUtils.LINE_SEPARATOR_UNIX, 2);
                                String str3 = split[0];
                                StringBuffer stringBuffer2 = new StringBuffer();
                                stringBuffer2.append(str3).append("\n<msg>").append(split.length > 1 ? split[1] : "").append(str2).append("</msg>");
                                this.pJj.field_fullXml = stringBuffer2.toString();
                            } else {
                                stringBuffer = new StringBuffer();
                                stringBuffer.append("<msg>").append(this.pJj.field_fullXml).append("</msg>");
                                this.pJj.field_fullXml = stringBuffer.toString();
                            }
                        }
                    } else if (!t.kH(jf.field_talker)) {
                        this.pJj.field_fullXml = str2;
                    } else if (!bo.isNullOrNil(jf.field_content)) {
                        this.pJj.field_fullXml = new StringBuffer().append(jf.field_content.split(IOUtils.LINE_SEPARATOR_UNIX, 2)[0]).append(IOUtils.LINE_SEPARATOR_UNIX).toString();
                        stringBuffer = new StringBuffer();
                        stringBuffer.append(this.pJj.field_fullXml).append(str2);
                        this.pJj.field_fullXml = stringBuffer.toString();
                    }
                    jf.setContent(this.pJj.field_fullXml);
                    ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().a(this.pJj.field_msgInfoId, jf);
                    ab.d("MicroMsg.NetSceneDownloadAppAttach", "dancy download full xml succed! xml: [%s]", str2);
                }
                int e = com.tencent.mm.a.e.e(this.pJj.field_fileFullPath, a);
                if (bo.isNullOrNil(this.pJj.field_fileFullPath) || e == 0) {
                    com.tencent.mm.pluginsdk.model.app.b bVar = this.pJj;
                    bVar.field_offset += (long) a.length;
                    if (this.pJj.field_offset == this.pJj.field_totalLen) {
                        this.pJj.field_status = 199;
                    }
                    if (this.fEW != null) {
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(135654);
                                e.this.fEW.a((int) e.this.pJj.field_offset, (int) e.this.pJj.field_totalLen, e.this);
                                AppMethodBeat.o(135654);
                            }
                        });
                    }
                    if (!(this.pJo ? true : com.tencent.mm.plugin.s.a.aUq().a(this.pJj, new String[0]))) {
                        ab.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd update info ret:".concat(String.valueOf(e)));
                        this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                        this.ehi.onSceneEnd(3, -1, "", this);
                        AppMethodBeat.o(135661);
                        return;
                    } else if (this.pJj.field_status == 199) {
                        h.pYm.e(10420, Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(this.pJj.field_totalLen - ((long) this.pJm)));
                        bi jf2 = ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().jf(this.pJj.field_msgInfoId);
                        ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().a(new com.tencent.mm.plugin.messenger.foundation.a.a.h.c(jf2.field_talker, "update", jf2));
                        this.ehi.onSceneEnd(0, 0, "", this);
                        AppMethodBeat.o(135661);
                        return;
                    } else if (this.pJj.field_status == 102) {
                        this.ehi.onSceneEnd(3, -1, "", this);
                        this.retCode = -20102;
                        AppMethodBeat.o(135661);
                        return;
                    } else {
                        if (a(this.ftf, this.ehi) < 0) {
                            ab.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : doScene fail");
                            this.ehi.onSceneEnd(3, -1, "", this);
                        }
                        AppMethodBeat.o(135661);
                        return;
                    }
                }
                ab.e("MicroMsg.NetSceneDownloadAppAttach", "append to file failed:".concat(String.valueOf(e)));
                this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                this.ehi.onSceneEnd(3, -1, "", this);
                AppMethodBeat.o(135661);
            }
        } else {
            ab.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : errType = " + i2 + ", errCode = " + i3);
            this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
            if (i2 == 4) {
                h.pYm.e(10420, Integer.valueOf(i3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0));
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(135661);
        }
    }

    public final int getType() {
        return 221;
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }

    public final int acn() {
        return 400;
    }

    public final String getMediaId() {
        if (this.pJj == null) {
            return "";
        }
        return this.pJj.field_mediaSvrId;
    }
}
