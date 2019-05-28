package com.tencent.mm.at;

import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.g;
import com.tencent.mm.ai.m;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.t;
import com.tencent.mm.modelstat.h;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.akx;
import com.tencent.mm.protocal.protobuf.aky;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.storage.bi;
import com.tencent.ttpic.util.ActUtil;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import junit.framework.Assert;

public final class k extends m implements com.tencent.mm.network.k {
    String TAG;
    bi csG;
    private long cvx;
    long eFm;
    private final b ehh;
    f ehi;
    private int fDC;
    final g fEW;
    public final long fEX;
    private int fEY;
    private h fEZ;
    String fFa;
    int fFb;
    private String fFc;
    public String fFd;
    int fFe;
    public boolean fFf;
    private int fFg;
    private String fFh;
    private int fFi;
    boolean fFj;
    private a fFk;
    int frO;
    private int startOffset;
    long startTime;
    private int token;

    public k(long j, long j2, int i, g gVar) {
        this(j, j2, i, gVar, -1);
    }

    public k(long j, long j2, int i, final g gVar, int i2) {
        e b;
        AppMethodBeat.i(78313);
        this.TAG = "MicroMsg.NetSceneGetMsgImg";
        this.fEZ = null;
        this.cvx = -1;
        this.csG = null;
        this.fFa = "";
        this.startTime = 0;
        this.startOffset = -1;
        this.fFb = 0;
        this.fFc = "";
        this.fFd = "";
        this.frO = 0;
        this.fFe = -1;
        this.fFf = false;
        this.fFg = -1;
        this.fFh = null;
        this.fFi = 0;
        this.token = -1;
        this.fFj = false;
        this.fFk = new a() {
            public final int a(String str, int i, c cVar, d dVar, boolean z) {
                AppMethodBeat.i(78311);
                Object[] objArr;
                String r;
                if (i == -21006) {
                    ab.i(k.this.TAG, "cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", k.this.fFa);
                    AppMethodBeat.o(78311);
                    return 0;
                } else if (i != 0) {
                    i.lC((int) k.this.fEX);
                    i.lB((int) k.this.fEX);
                    objArr = new Object[16];
                    objArr[0] = Integer.valueOf(i);
                    objArr[1] = Integer.valueOf(2);
                    objArr[2] = Long.valueOf(k.this.startTime);
                    objArr[3] = Long.valueOf(bo.anU());
                    objArr[4] = Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext()));
                    objArr[5] = Integer.valueOf(k.this.fFb);
                    objArr[6] = Integer.valueOf(k.this.frO);
                    objArr[7] = dVar == null ? "" : dVar.field_transInfo;
                    objArr[8] = "";
                    objArr[9] = "";
                    objArr[10] = "";
                    objArr[11] = "";
                    objArr[12] = "";
                    objArr[13] = "";
                    objArr[14] = "";
                    objArr[15] = dVar == null ? "" : dVar.efY;
                    r = com.tencent.mm.plugin.report.a.r(objArr);
                    new com.tencent.mm.g.b.a.f(r).ajK();
                    new com.tencent.mm.g.b.a.d(r).ajK();
                    k.this.ehi.onSceneEnd(3, i, "", k.this);
                    AppMethodBeat.o(78311);
                    return 0;
                } else {
                    e b = o.ahl().b(Long.valueOf(k.this.eFm));
                    if (cVar == null) {
                        if (dVar != null) {
                            if (dVar.field_retCode != 0) {
                                i.lB((int) k.this.fEX);
                                ab.e(k.this.TAG, "cdntra sceneResult.retCode :%d", Integer.valueOf(dVar.field_retCode));
                                k.this.ehi.onSceneEnd(3, dVar.field_retCode, "", k.this);
                            } else {
                                ab.i(k.this.TAG, "cdntra getimg ok. need convert:%b", Boolean.valueOf(dVar.field_convert2baseline));
                                com.tencent.mm.plugin.report.service.h hVar;
                                if (b.fDC == 1) {
                                    com.tencent.mm.plugin.report.service.h.pYm.a(198, 26, (long) b.frO, false);
                                    com.tencent.mm.plugin.report.service.h.pYm.a(198, 27, 1, false);
                                    hVar = com.tencent.mm.plugin.report.service.h.pYm;
                                    if (k.this.csG != null) {
                                        r = k.this.csG.field_talker;
                                    } else {
                                        r = "";
                                    }
                                    hVar.a(198, t.kH(r) ? 29 : 28, 1, false);
                                } else {
                                    long j;
                                    com.tencent.mm.plugin.report.service.h.pYm.a(198, 21, (long) b.frO, false);
                                    com.tencent.mm.plugin.report.service.h.pYm.a(198, 22, 1, false);
                                    hVar = com.tencent.mm.plugin.report.service.h.pYm;
                                    if (k.this.csG != null) {
                                        r = k.this.csG.field_talker;
                                    } else {
                                        r = "";
                                    }
                                    if (t.kH(r)) {
                                        j = 24;
                                    } else {
                                        j = 23;
                                    }
                                    hVar.a(198, j, 1, false);
                                }
                                if (dVar.field_convert2baseline) {
                                    ab.i(k.this.TAG, "cdntra need convert2baseline. file:%s", k.this.fFd);
                                    boolean Convert2Baseline = MMNativeJpeg.Convert2Baseline(k.this.fFd, 60);
                                    ab.i(k.this.TAG, "convert result:%b", Boolean.valueOf(Convert2Baseline));
                                }
                                if (k.this.fFj) {
                                    k.a(k.this, b, b.offset, b.offset, 0);
                                } else {
                                    k.a(k.this, b, k.this.frO, b.offset, k.this.frO - b.offset);
                                }
                            }
                            objArr = new Object[16];
                            objArr[0] = Integer.valueOf(dVar.field_retCode);
                            objArr[1] = Integer.valueOf(2);
                            objArr[2] = Long.valueOf(k.this.startTime);
                            objArr[3] = Long.valueOf(bo.anU());
                            objArr[4] = Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext()));
                            objArr[5] = Integer.valueOf(k.this.fFb);
                            objArr[6] = Integer.valueOf(k.this.frO);
                            objArr[7] = dVar == null ? "" : dVar.field_transInfo;
                            objArr[8] = "";
                            objArr[9] = "";
                            objArr[10] = "";
                            objArr[11] = "";
                            objArr[12] = "";
                            objArr[13] = "";
                            objArr[14] = "";
                            objArr[15] = dVar == null ? "" : dVar.efY;
                            new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.r(objArr)).ajK();
                            if (dVar.field_retCode != 0) {
                                objArr = new Object[16];
                                objArr[0] = Integer.valueOf(dVar.field_retCode);
                                objArr[1] = Integer.valueOf(2);
                                objArr[2] = Long.valueOf(k.this.startTime);
                                objArr[3] = Long.valueOf(bo.anU());
                                objArr[4] = Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext()));
                                objArr[5] = Integer.valueOf(k.this.fFb);
                                objArr[6] = Integer.valueOf(k.this.frO);
                                objArr[7] = dVar == null ? "" : dVar.field_transInfo;
                                objArr[8] = "";
                                objArr[9] = "";
                                objArr[10] = "";
                                objArr[11] = "";
                                objArr[12] = "";
                                objArr[13] = "";
                                objArr[14] = "";
                                objArr[15] = dVar == null ? "" : dVar.efY;
                                new com.tencent.mm.g.b.a.d(com.tencent.mm.plugin.report.a.r(objArr)).ajK();
                            }
                        }
                        AppMethodBeat.o(78311);
                        return 0;
                    } else if (cVar.field_finishedLength == k.this.frO) {
                        ab.d(k.this.TAG, "cdntra ignore progress 100%");
                        AppMethodBeat.o(78311);
                        return 0;
                    } else {
                        k.this.fFj = true;
                        if (!k.this.fFf) {
                            k.this.fFf = cVar.field_mtlnotify;
                        }
                        ab.i(k.this.TAG, "cdntra progresscallback id:%s finish:%d total:%d,  canshowProgressimg:%b", k.this.fFa, Integer.valueOf(cVar.field_finishedLength), Integer.valueOf(cVar.field_toltalLength), Boolean.valueOf(k.this.fFf));
                        k.a(k.this, b, k.this.frO, b.offset, cVar.field_finishedLength - b.offset);
                        AppMethodBeat.o(78311);
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
        boolean z = j >= 0 && j2 >= 0 && gVar != null;
        Assert.assertTrue(z);
        this.fEW = gVar;
        this.fDC = i;
        this.fEX = j;
        this.eFm = j;
        this.cvx = j2;
        this.fFg = i2;
        e b2 = o.ahl().b(Long.valueOf(this.eFm));
        if (i == 1) {
            this.eFm = (long) b2.fDJ;
            b = o.ahl().b(Long.valueOf(this.eFm));
        } else {
            b = b2;
        }
        this.TAG += "[" + this.eFm + "]";
        b.a aVar = new b.a();
        aVar.fsJ = new akx();
        aVar.fsK = new aky();
        aVar.uri = "/cgi-bin/micromsg-bin/getmsgimg";
        aVar.fsI = 109;
        aVar.fsL = 10;
        aVar.fsM = 1000000010;
        this.ehh = aVar.acD();
        akx akx = (akx) this.ehh.fsG.fsP;
        this.csG = ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().jf(j2);
        akx.ptx = b.offset;
        akx.ptw = b.frO;
        ab.d(this.TAG, "cdntra offset:%d total:%d stack:[%s]", Integer.valueOf(b.offset), Integer.valueOf(b.frO), bo.dpG());
        akx.ptF = this.csG.field_msgSvrId;
        akx.vEB = new bts().alV(this.csG.field_talker);
        akx.vEC = new bts().alV((String) com.tencent.mm.kernel.g.RP().Ry().get(2, null));
        akx.wqw = i;
        if (b.offset == 0) {
            this.fEZ = new h(109, false, (long) b.frO);
        }
        this.fEY = Utility.DEFAULT_STREAM_BUFFER_SIZE;
        if (gVar != null) {
            final int i3 = b.offset;
            final int i4 = b.frO;
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(78310);
                    gVar.a(i3, i4, k.this);
                    AppMethodBeat.o(78310);
                }
            });
        }
        AppMethodBeat.o(78313);
    }

    public final int acn() {
        if (this.fDC == 0) {
            return 100;
        }
        return ActUtil.HEIGHT;
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }

    public final void cancel() {
        AppMethodBeat.i(78314);
        if (!(bo.isNullOrNil(this.fFa) || com.tencent.mm.al.f.afx() == null)) {
            ab.d(this.TAG, "cancel recv task");
            com.tencent.mm.al.f.afx().rO(this.fFa);
        }
        super.cancel();
        AppMethodBeat.o(78314);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(78315);
        this.ehi = fVar;
        akx akx = (akx) this.ehh.fsG.fsP;
        e b = o.ahl().b(Long.valueOf(this.eFm));
        if (b.fDy == 0) {
            com.tencent.mm.plugin.report.service.h.pYm.a(111, 195, 1, false);
            ab.e(this.TAG, "doScene id:%d  img:%s", Long.valueOf(this.eFm), b);
            AppMethodBeat.o(78315);
            return -1;
        } else if (b.status != 0) {
            com.tencent.mm.plugin.report.service.h.pYm.a(111, 194, 1, false);
            ab.e(this.TAG, "doSceneError, id:%d, status:%d", Long.valueOf(b.fDy), Integer.valueOf(b.status));
            AppMethodBeat.o(78315);
            return -1;
        } else {
            String str;
            int i;
            Object obj;
            if (b.fDz.startsWith("SERVERID://")) {
                this.fFc = com.tencent.mm.a.g.x(b.fDz.getBytes());
                this.fFd = o.ahl().q(this.fFc, null, ".temp");
                b.sb(this.fFc + ".temp");
                o.ahl().a(Long.valueOf(this.eFm), b);
            } else {
                this.fFc = b.fDz;
                this.fFd = o.ahl().q(this.fFc, null, "");
            }
            ab.i(this.TAG, "doscene id:%d comp:%d off:%d total:%d name:%s tmp:%s full:%s", Long.valueOf(b.fDy), Integer.valueOf(this.fDC), Integer.valueOf(b.offset), Integer.valueOf(b.frO), str, this.fFc, this.fFd);
            if (this.startTime == 0) {
                this.startTime = bo.anU();
                this.startOffset = b.offset;
                if (this.fDC == 1) {
                    i = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
                } else {
                    i = com.tencent.mm.i.a.MediaType_IMAGE;
                }
                this.fFb = i;
            }
            if (bo.isNullOrNil(b.fDK)) {
                obj = null;
            } else {
                Map z = br.z(b.fDK, "msg");
                if (z == null) {
                    ab.e(this.TAG, "parse cdnInfo failed. [%s]", b.fDK);
                    obj = null;
                } else {
                    String str2;
                    String str3;
                    this.frO = 0;
                    if (this.fDC != 1) {
                        str = (String) z.get(".msg.img.$cdnmidimgurl");
                        this.frO = bo.getInt((String) z.get(".msg.img.$length"), 0);
                        str2 = str;
                    } else {
                        str = (String) z.get(".msg.img.$cdnbigimgurl");
                        this.frO = bo.getInt((String) z.get(".msg.img.$hdlength"), 0);
                        str2 = str;
                    }
                    if (this.fDC != 1) {
                        str = (String) z.get(".msg.img.$tpurl");
                        if (!bo.isNullOrNil(str)) {
                            this.frO = bo.getInt((String) z.get(".msg.img.$tplength"), 0);
                            str3 = str;
                        }
                        str3 = str;
                    } else {
                        str = (String) z.get(".msg.img.$tphdurl");
                        if (!bo.isNullOrNil(str)) {
                            this.frO = bo.getInt((String) z.get(".msg.img.$tphdlength"), 0);
                        }
                        str3 = str;
                    }
                    ab.d(this.TAG, "cdntra read xml  comptype:%d totallen:%d url:[%s] [%s]", Integer.valueOf(this.fDC), Integer.valueOf(this.frO), str2, str3);
                    if (bo.isNullOrNil(str2) && bo.isNullOrNil(str3)) {
                        ab.e(this.TAG, "cdntra get cdnUrlfailed.");
                        obj = null;
                    } else {
                        str = (String) z.get(".msg.img.$aeskey");
                        if (bo.isNullOrNil(str)) {
                            ab.e(this.TAG, "cdntra get aes key failed.");
                            obj = null;
                        } else {
                            this.fFa = com.tencent.mm.al.c.a("downimg", (long) b.fDG, this.csG.field_talker, this.csG.field_msgId);
                            if (bo.isNullOrNil(this.fFa)) {
                                ab.w(this.TAG, "cdntra genClientId failed not use cdn imgLocalId:%d", Long.valueOf(this.eFm));
                                obj = null;
                            } else {
                                String str4 = (String) z.get(".msg.img.$md5");
                                if (bo.isNullOrNil(str3) && !bo.isNullOrNil(str4) && (bo.isNullOrNil((String) z.get(".msg.img.$cdnbigimgurl")) || this.fDC == 1)) {
                                    com.tencent.mm.plugin.i.b.bGD();
                                    String es = com.tencent.mm.plugin.i.b.XT().es(str4, this.frO);
                                    int asZ = (int) com.tencent.mm.vfs.e.asZ(es);
                                    int i2 = this.frO - asZ;
                                    String str5 = this.TAG;
                                    String str6 = "MediaCheckDuplicationStorage: totallen:%s md5:%s big:%s NOcompress:%s  dup(len:%d path:%s) diffLen:%d to:%s";
                                    Object[] objArr = new Object[8];
                                    objArr[0] = Integer.valueOf(this.frO);
                                    objArr[1] = str4;
                                    objArr[2] = z.get(".msg.img.$cdnbigimgurl");
                                    objArr[3] = Boolean.valueOf(this.fDC == 1);
                                    objArr[4] = Integer.valueOf(asZ);
                                    objArr[5] = es;
                                    objArr[6] = Integer.valueOf(i2);
                                    objArr[7] = this.fFd;
                                    ab.i(str5, str6, objArr);
                                    if (bo.isNullOrNil(es)) {
                                        this.fFh = str4;
                                        this.fFi = this.frO;
                                    } else if (i2 >= 0 && i2 <= 16) {
                                        boolean z2 = false;
                                        if (!bo.isEqual(es, this.fFd)) {
                                            z2 = com.tencent.mm.vfs.e.y(es, this.fFd) >= 0;
                                        }
                                        ab.i(this.TAG, "MediaCheckDuplicationStorage copy dup file now :%s -> %s [%b]", es, this.fFd, Boolean.valueOf(z2));
                                        a(b, this.frO, this.frO, 0, null);
                                        if (this.csG != null) {
                                            ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().a(new com.tencent.mm.plugin.messenger.foundation.a.a.h.c(this.csG.field_talker, "update", this.csG));
                                        }
                                        com.tencent.mm.plugin.report.service.h.pYm.e(13267, str2, Long.valueOf(this.csG.field_msgSvrId), str4, Long.valueOf(this.csG.field_createTime / 1000), this.csG.field_talker, Integer.valueOf(3), Integer.valueOf(asZ));
                                        obj = 1;
                                    }
                                }
                                com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
                                gVar.field_mediaId = this.fFa;
                                gVar.field_fullpath = this.fFd;
                                gVar.field_fileType = this.fFb;
                                gVar.field_totalLen = this.frO;
                                gVar.field_aesKey = str;
                                gVar.field_fileId = str2;
                                gVar.field_priority = com.tencent.mm.i.a.efC;
                                gVar.egl = this.fFk;
                                gVar.field_chattype = t.kH(this.csG.field_talker) ? 1 : 0;
                                gVar.expectImageFormat = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.emoji.b.c.class)).bja() ? 2 : 1;
                                if (!bo.isNullOrNil(str3)) {
                                    str = (String) z.get(".msg.img.$tpauthkey");
                                    gVar.field_fileType = 19;
                                    gVar.field_authKey = str;
                                    gVar.egm = str3;
                                    gVar.field_fileId = "";
                                }
                                ab.i(this.TAG, "cdnautostart %s %b", "image_" + this.csG.field_msgId, Boolean.valueOf(com.tencent.mm.al.f.afx().fyQ.contains("image_" + this.csG.field_msgId)));
                                if (com.tencent.mm.al.f.afx().fyQ.contains("image_" + this.csG.field_msgId)) {
                                    com.tencent.mm.al.f.afx().fyQ.remove("image_" + this.csG.field_msgId);
                                    gVar.field_autostart = true;
                                } else {
                                    gVar.field_autostart = false;
                                }
                                if (com.tencent.mm.al.f.afx().b(gVar, this.fFg)) {
                                    ab.i(this.TAG, "add recv task");
                                    obj = 1;
                                } else {
                                    com.tencent.mm.plugin.report.service.h.pYm.a(111, 196, 1, false);
                                    ab.e(this.TAG, "addRecvTask failed :%s", this.fFa);
                                    this.fFa = "";
                                    obj = null;
                                }
                            }
                        }
                    }
                }
            }
            if (obj != null) {
                ab.d(this.TAG, "cdntra this img use cdn : %s", this.fFa);
                AppMethodBeat.o(78315);
                return 0;
            }
            ab.d(this.TAG, "cdntra this img NOT USE CDN: %s", this.fFa);
            b.se("");
            b.bJt = 4096;
            o.ahl().a(Long.valueOf(this.eFm), b);
            akx.ptx = b.offset;
            akx.pty = this.fEY;
            akx.ptw = b.frO;
            if (this.fEZ != null) {
                this.fEZ.akj();
            }
            i = a(eVar, this.ehh, this);
            AppMethodBeat.o(78315);
            return i;
        }
    }

    public final int getType() {
        return 109;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(78316);
        if (i2 == 3 && i3 == -1 && !bo.isNullOrNil(this.fFa)) {
            ab.w(this.TAG, "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.fFa);
            AppMethodBeat.o(78316);
        } else if (i2 == 0 && i3 == 0) {
            aky aky = (aky) ((b) qVar).fsH.fsP;
            e b = o.ahl().b(Long.valueOf(this.eFm));
            Object obj = null;
            if (aky.pty <= 0) {
                ab.e(this.TAG, "flood control, malformed data_len");
                obj = -1;
            } else if (aky.ptz == null || aky.pty != aky.ptz.getILen()) {
                ab.e(this.TAG, "flood control, malformed data is null or dataLen not match with data buf length");
                obj = -1;
            } else if (aky.ptx < 0 || aky.ptx + aky.pty > aky.ptw) {
                ab.e(this.TAG, "flood control, malformed start pos");
                obj = -1;
            } else if (aky.ptx != b.offset) {
                ab.e(this.TAG, "flood control, malformed start_pos");
                obj = -1;
            } else if (aky.ptw <= 0) {
                ab.e(this.TAG, "flood control, malformed total_len");
                obj = -1;
            }
            if (obj != null) {
                com.tencent.mm.plugin.report.service.h.pYm.a(111, 192, 1, false);
                com.tencent.mm.plugin.report.service.h.pYm.e(10420, Integer.valueOf(-1), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(this.fFb), Integer.valueOf(this.frO - this.startOffset));
                this.ehi.onSceneEnd(4, -1, "", this);
                AppMethodBeat.o(78316);
                return;
            }
            if (a(b, aky.ptw, aky.ptx, aky.pty, aky.ptz.getBuffer().wR) && a(this.ftf, this.ehi) < 0) {
                this.ehi.onSceneEnd(3, -1, "", this);
            }
            AppMethodBeat.o(78316);
        } else {
            if (i2 == 4) {
                com.tencent.mm.plugin.report.service.h.pYm.a(111, 193, 1, false);
                com.tencent.mm.plugin.report.service.h.pYm.e(10420, Integer.valueOf(i3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(this.fFb), Integer.valueOf(this.frO - this.startOffset));
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(78316);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0149  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(final e eVar, int i, int i2, int i3, byte[] bArr) {
        String str;
        AppMethodBeat.i(78317);
        eVar.lt(i);
        eVar.setOffset(i2 + i3);
        this.fEY = i3;
        if (bArr != null) {
            com.tencent.mm.vfs.e.a(this.fFd, bArr, bArr.length);
        }
        ab.d(this.TAG, "onGYNetEnd : offset = " + eVar.offset + " totalLen = " + eVar.frO + " stack:[%s]", bo.dpG());
        if (eVar.agP()) {
            boolean z;
            String amq = r.amq(this.fFd);
            boolean amn = r.amn(this.fFd);
            String str2 = this.fFd + "_hevc";
            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(this.fFd);
            boolean amp = r.amp(this.fFd);
            if (amp) {
                bVar.o(new com.tencent.mm.vfs.b(str2));
                if (((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.emoji.b.c.class)).nativeWxam2Pic(str2, this.fFd) != 0) {
                    ab.w(this.TAG, "download hevc decode failed");
                    z = false;
                } else {
                    amq = r.amq(this.fFd);
                    z = amn;
                }
                ab.d(this.TAG, "hevc download is hevc %b", Boolean.TRUE);
            } else {
                z = amn;
            }
            if (z) {
                String str3 = this.fFc + amq;
                String q = o.ahl().q(this.fFc, null, amq);
                ab.i(this.TAG, "sceneEndproc ext:%s tmp:%s tmpfull:%s full:%s ", amq, this.fFc, this.fFd, q);
                String IP = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.emoji.b.c.class)).IP(str3);
                String IP2 = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.emoji.b.c.class)).IP(q);
                if (amp) {
                    new com.tencent.mm.vfs.b(str2).o(new com.tencent.mm.vfs.b(IP2));
                    bVar.o(new com.tencent.mm.vfs.b(q));
                } else {
                    if (com.tencent.mm.vfs.e.asZ(IP2) > 0) {
                        com.tencent.mm.vfs.e.deleteFile(IP2);
                        com.tencent.mm.plugin.report.service.h.pYm.k(944, 10, 1);
                    }
                    bVar.o(new com.tencent.mm.vfs.b(q));
                }
                eVar.sb(str3);
                eVar.sf(IP);
                eVar.sa(f.sh(q));
                eVar.lx(this.fDC);
                str = q;
                if (o.ahl().a(Long.valueOf(this.eFm), eVar) >= 0) {
                    ab.e(this.TAG, "onGYNetEnd : update img fail");
                    this.ehi.onSceneEnd(3, -1, "", this);
                    AppMethodBeat.o(78317);
                    return false;
                }
                if (this.fEW != null) {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(78312);
                            k.this.fEW.a(eVar.offset, eVar.frO, k.this);
                            AppMethodBeat.o(78312);
                        }
                    });
                }
                ab.d(this.TAG, "cdntra check iscompleted :%b clientid:%s", Boolean.valueOf(eVar.agP()), this.fFa);
                if (eVar.agP()) {
                    if (bo.isNullOrNil(this.fFa)) {
                        com.tencent.mm.plugin.report.service.h.pYm.e(10420, Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(this.fFb), Integer.valueOf(i - this.startOffset));
                    }
                    z = false;
                    if (this.fFe > 0) {
                        z = o.ahl().a(str, eVar.fDB, this.fFe, 1, this.csG.dJw, this.csG.dJx);
                    }
                    if (z) {
                        eVar.agR();
                        ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().a(this.csG.field_msgId, this.csG);
                    }
                    o.ahl().a(Long.valueOf(this.eFm), eVar);
                    ab.d(this.TAG, "cdntra ext:%s %s %s  MediaCheckDuplicationStorage md5:%s", this.fFd, str, eVar.fDz, this.fFh);
                    if (this.fEZ != null) {
                        this.fEZ.fS((long) eVar.frO);
                    }
                    if (!bo.isNullOrNil(this.fFh) && this.fFi > 0) {
                        com.tencent.mm.plugin.i.b.bGD();
                        com.tencent.mm.plugin.i.b.XT().y(this.fFh, this.fFi, str);
                    }
                    this.ehi.onSceneEnd(0, 0, "", this);
                    AppMethodBeat.o(78317);
                    return false;
                }
                AppMethodBeat.o(78317);
                return true;
            }
            bVar.delete();
        }
        str = null;
        if (o.ahl().a(Long.valueOf(this.eFm), eVar) >= 0) {
        }
    }
}
