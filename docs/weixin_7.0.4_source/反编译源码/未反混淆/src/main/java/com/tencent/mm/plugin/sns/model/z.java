package com.tencent.mm.plugin.sns.model;

import android.graphics.BitmapFactory.Options;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bar;
import com.tencent.mm.protocal.protobuf.bax;
import com.tencent.mm.protocal.protobuf.caq;
import com.tencent.mm.protocal.protobuf.ccj;
import com.tencent.mm.protocal.protobuf.cck;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.io.ByteArrayOutputStream;

public final class z extends m implements k {
    private int cNE;
    private b ehh;
    public f ehi;
    public String fFa;
    int fFb;
    private a fFk;
    private int fFu;
    private int frO;
    private int offset;
    private String path;
    private String qJU;
    private ccj qJV;
    private String qJW;
    private boolean qJX;
    private boolean qJY;
    private boolean qJZ;
    long qKa;
    int qKb;
    long startTime;

    public z(int i, String str, boolean z, int i2) {
        AppMethodBeat.i(36346);
        this.fFu = Utility.DEFAULT_STREAM_BUFFER_SIZE;
        this.offset = 0;
        this.path = "";
        this.qJU = "";
        this.cNE = 0;
        this.qJW = "";
        this.fFa = "";
        this.qJX = false;
        this.qJY = false;
        this.qJZ = false;
        this.qKa = 0;
        this.startTime = 0;
        this.fFb = 0;
        this.qKb = 0;
        this.fFk = new a() {
            public final int a(String str, int i, c cVar, d dVar, boolean z) {
                AppMethodBeat.i(36345);
                if (i == -21005) {
                    ab.d("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", z.this.fFa, Integer.valueOf(i), cVar, dVar);
                    z.this.ehi.onSceneEnd(3, -1, "doScene failed", z.this);
                    AppMethodBeat.o(36345);
                    return 0;
                } else if (dVar != null && dVar.field_retCode == 0) {
                    ab.i("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", z.this.fFa, Integer.valueOf(i), cVar, dVar);
                    z.this.a(dVar.field_fileUrl, 1, dVar.field_thumbUrl, 1, "upload_" + z.this.fFa, dVar.field_filemd5);
                    ab.i("MicroMsg.NetSceneMMSnsUpload", "uploadsns cdndone pass: " + (System.currentTimeMillis() - z.this.qKa) + " " + dVar.field_filemd5);
                    new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.r(Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(z.this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(z.this.fFb), Integer.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.efY)).ajK();
                    z.this.ehi.onSceneEnd(0, 0, "doScene", z.this);
                    AppMethodBeat.o(36345);
                    return 0;
                } else if (dVar != null && dVar.field_retCode != 0) {
                    ab.i("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", z.this.fFa, Integer.valueOf(i), cVar, dVar);
                    if (z.this.qKb == 21) {
                        if (dVar.field_retCode <= -10000 && dVar.field_retCode > HardCoderJNI.ERR_CLIENT_CONNECT) {
                            com.tencent.mm.plugin.sns.lucky.a.b.kT(10);
                        } else if (dVar.field_retCode <= HardCoderJNI.ERR_CLIENT_CONNECT && dVar.field_retCode >= -22000) {
                            com.tencent.mm.plugin.sns.lucky.a.b.kT(11);
                        } else if (dVar.field_retCode > -5103000 || dVar.field_retCode < -5103087) {
                            com.tencent.mm.plugin.sns.lucky.a.b.kT(15);
                        } else {
                            com.tencent.mm.plugin.sns.lucky.a.b.kT(9);
                        }
                    }
                    z.a(z.this, dVar.field_retCode);
                    String r = com.tencent.mm.plugin.report.a.r(Integer.valueOf(dVar.field_retCode), Integer.valueOf(1), Long.valueOf(z.this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(z.this.fFb), Integer.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.efY);
                    new com.tencent.mm.g.b.a.f(r).ajK();
                    new com.tencent.mm.g.b.a.d(r).ajK();
                    z.this.ehi.onSceneEnd(3, -1, "doScene failed", z.this);
                    AppMethodBeat.o(36345);
                    return 0;
                } else if (i != 0) {
                    ab.i("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", z.this.fFa, Integer.valueOf(i), cVar, dVar);
                    z.this.CQ(0);
                    if (dVar != null) {
                        new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.r(Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(z.this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(z.this.fFb), Integer.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.efY)).ajK();
                    }
                    z.this.ehi.onSceneEnd(3, -1, "doScene failed", z.this);
                    AppMethodBeat.o(36345);
                    return 0;
                } else {
                    ab.d("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", z.this.fFa, Integer.valueOf(i), cVar, dVar);
                    AppMethodBeat.o(36345);
                    return 0;
                }
            }

            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            public final byte[] l(String str, byte[] bArr) {
                return null;
            }
        };
        this.qKa = System.currentTimeMillis();
        this.cNE = i;
        this.qJW = str;
        this.qKb = i2;
        b.a aVar = new b.a();
        aVar.fsJ = new ccj();
        aVar.fsK = new cck();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsupload";
        aVar.fsI = 207;
        aVar.fsL = 95;
        aVar.fsM = 1000000095;
        this.ehh = aVar.acD();
        this.qJV = (ccj) this.ehh.fsG.fsP;
        r kE = af.cnu().kE((long) i);
        this.qJZ = z;
        ab.i("MicroMsg.NetSceneMMSnsUpload", "start snsupload netscene localId " + i + "  offset " + kE.offset + " path " + kE.rfE + " totallen " + kE.rfD);
        if (!z) {
            this.qJV.wGz = 1;
            ab.i("MicroMsg.NetSceneMMSnsUpload", "this is single upload");
        }
        try {
            Object obj;
            bax bax = (bax) new bax().parseFrom(kE.rfI);
            this.qJU = i.Xe(kE.rfE);
            this.path = an.fZ(af.getAccSnsPath(), kE.rfE) + this.qJU;
            this.frO = (int) e.asZ(this.path);
            this.qJX = i.Xo(this.path);
            ab.i("MicroMsg.NetSceneMMSnsUpload", "totallen " + this.frO + " isLongPic: " + this.qJX);
            String str2 = bax.wFE;
            if (bo.isNullOrNil(str2)) {
                str2 = g.x((bo.yz()).getBytes());
                bax.wFE = str2;
                try {
                    kE.rfI = bax.toByteArray();
                    af.cnu().a(kE.reX, kE);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.NetSceneMMSnsUpload", e, "", new Object[0]);
                }
            }
            this.qJV.ptw = this.frO;
            this.qJV.ptx = kE.offset;
            this.qJV.ptv = str2;
            this.fFa = str2;
            ab.d("MicroMsg.NetSceneMMSnsUpload", "filter style " + bax.wFd);
            this.qJV.wFd = bax.wFd;
            ab.d("MicroMsg.NetSceneMMSnsUpload", "syncWeibo " + bax.wFe);
            this.qJV.vEA = bax.Desc;
            this.qJV.wFe = bax.wFe;
            ab.i("MicroMsg.NetSceneMMSnsUpload", "request upload type " + kE.type + " md5: " + bax.cvZ + " appid " + bax.csB + " contenttype " + bax.aPA);
            this.qJV.jCt = kE.type;
            civ civ = new civ();
            civ.xhJ = bax.token;
            civ.xhK = bax.wFn;
            this.qJV.wNQ = civ;
            if (!bo.isNullOrNil(bax.cvZ)) {
                this.qJV.wdO = bax.cvZ;
            }
            if (!bo.isNullOrNil(bax.csB)) {
                this.qJV.fKh = bax.csB;
            }
            this.qJV.xbO = bax.aPA;
            if (ae.gic) {
                this.qJV.jCt = 0;
            }
            if (this.startTime == 0) {
                this.startTime = bo.anU();
                this.fFb = com.tencent.mm.i.a.MediaType_FRIENDS;
            }
            ccj ccj = this.qJV;
            com.tencent.mm.al.f.afx();
            if (!com.tencent.mm.al.b.lg(32)) {
                Object[] objArr = new Object[1];
                com.tencent.mm.al.f.afx();
                objArr[0] = Boolean.valueOf(com.tencent.mm.al.b.lg(32));
                ab.w("MicroMsg.NetSceneMMSnsUpload", "cdntra not use cdn flag:%b", objArr);
                obj = null;
            } else if (ae.giR == 2) {
                obj = null;
            } else {
                this.fFa = ccj.ptv;
                if (bo.isNullOrNil(this.fFa)) {
                    ab.w("MicroMsg.NetSceneMMSnsUpload", "cdntra genClientId failed not use cdn");
                    obj = null;
                } else {
                    obj = 1;
                }
            }
            if (obj != null) {
                this.qJY = true;
                AppMethodBeat.o(36346);
                return;
            }
            if (!cnd()) {
                onError();
            }
            AppMethodBeat.o(36346);
        } catch (Exception e2) {
            ab.e("MicroMsg.NetSceneMMSnsUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
            AppMethodBeat.o(36346);
        }
    }

    private boolean cnd() {
        AppMethodBeat.i(36347);
        r kE = af.cnu().kE((long) this.cNE);
        int i = kE.rfD - kE.offset;
        if (i > this.fFu) {
            i = this.fFu;
        }
        this.offset = kE.offset;
        byte[] e = e.e(this.path, this.offset, i);
        if (e == null || e.length <= 0) {
            AppMethodBeat.o(36347);
            return false;
        }
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        sKBuiltinBuffer_t.setBuffer(e);
        this.qJV.vJd = sKBuiltinBuffer_t;
        this.qJV.ptx = this.offset;
        AppMethodBeat.o(36347);
        return true;
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }

    public final int acn() {
        if (this.qJX) {
            return 675;
        }
        return 100;
    }

    public final int getType() {
        return 207;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(36348);
        ab.i("MicroMsg.NetSceneMMSnsUpload", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        cck cck = (cck) ((b) qVar).fsH.fsP;
        if (i2 == 4) {
            CQ(i3);
            if (this.qKb == 21) {
                com.tencent.mm.plugin.sns.lucky.a.b.kT(12);
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(36348);
        } else if (i2 == 0 && i3 == 0) {
            r kE = af.cnu().kE((long) this.cNE);
            if (cck.ptx < 0 || (cck.ptx > kE.rfD && kE.rfD > 0)) {
                onError();
                if (i2 == 3) {
                    com.tencent.mm.plugin.sns.lucky.a.b.kT(14);
                }
                AppMethodBeat.o(36348);
            } else if (cck.ptx < kE.offset) {
                onError();
                if (i2 == 3) {
                    com.tencent.mm.plugin.sns.lucky.a.b.kT(14);
                }
                AppMethodBeat.o(36348);
            } else {
                Object obj;
                ab.d("MicroMsg.NetSceneMMSnsUpload", " bufferUrl: " + cck.xbP.Url + " bufferUrlType: " + cck.xbP.jCt + "  id:" + cck.vQE + " thumb Count: " + cck.wFB + "  type " + cck.jCt + " startPos : " + cck.ptx);
                kE.offset = cck.ptx;
                af.cnu().a(this.cNE, kE);
                if (kE.offset != kE.rfD || kE.rfD == 0) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    ab.i("MicroMsg.NetSceneMMSnsUpload", "uploadsns done pass: " + (System.currentTimeMillis() - this.qKa));
                    if (cck.wFC.size() == 0 || cck.wFC.size() <= 0) {
                        a(cck.xbP.Url, cck.xbP.jCt, "", 0, cck.vQE, this.qJV.wdO);
                    } else {
                        a(cck.xbP.Url, cck.xbP.jCt, ((caq) cck.wFC.get(0)).Url, ((caq) cck.wFC.get(0)).jCt, cck.vQE, this.qJV.wdO);
                    }
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    AppMethodBeat.o(36348);
                    return;
                }
                if (cnd() && a(this.ftf, this.ehi) < 0) {
                    this.ehi.onSceneEnd(3, -1, "doScene failed", this);
                }
                AppMethodBeat.o(36348);
            }
        } else {
            onError();
            if (this.qKb == 21) {
                com.tencent.mm.plugin.sns.lucky.a.b.kT(13);
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(36348);
        }
    }

    public final boolean a(String str, int i, String str2, int i2, String str3, String str4) {
        bax bax;
        AppMethodBeat.i(36349);
        r kE = af.cnu().kE((long) this.cNE);
        ab.i("MicroMsg.NetSceneMMSnsUpload", "upload ok " + str + "  " + str3 + "  " + i + " thumbUrl: " + str2);
        Options options = new Options();
        options.inJustDecodeBounds = true;
        MMBitmapFactory.decodeFile(this.path, options);
        String toLowerCase = options.outMimeType != null ? options.outMimeType.toLowerCase() : "";
        int i3 = -1;
        if (toLowerCase.endsWith("jpg") || toLowerCase.endsWith("jpeg")) {
            i3 = MMNativeJpeg.queryQuality(this.path);
            if (i3 == 0) {
                i3 = -1;
            }
        }
        com.tencent.mm.plugin.sns.i.c.a(str, options.outMimeType, options.outWidth, options.outHeight, i3, e.asZ(this.path));
        kE.rfH = str3;
        try {
            bax = (bax) new bax().parseFrom(kE.rfI);
        } catch (Exception e) {
            bax = null;
        }
        if (bax == null) {
            bax = new bax();
        }
        bar bar = new bar();
        bar.jCt = i;
        bar.Url = str;
        bax.wFA = bar;
        bax.wFD = 0;
        bax.cvZ = str4;
        if (!bo.isNullOrNil(str2)) {
            bar = new bar();
            bar.jCt = i2;
            bar.Url = str2;
            bax.wFC.add(bar);
        }
        try {
            kE.rfI = bax.toByteArray();
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.NetSceneMMSnsUpload", e2, "", new Object[0]);
        }
        kE.crq();
        af.cnu().a(this.cNE, kE);
        af.cnE().CV(this.cNE);
        if (af.cnB() != null) {
            af.cnB().cmp();
        }
        AppMethodBeat.o(36349);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final void CQ(int i) {
        AppMethodBeat.i(36350);
        r kE = af.cnu().kE((long) this.cNE);
        try {
            bax bax = (bax) new bax().parseFrom(kE.rfI);
            bax.wFD = 1;
            bax.wFm = i;
            kE.rfI = bax.toByteArray();
        } catch (Exception e) {
        }
        af.cnE().CV(this.cNE);
        af.cnu().a(this.cNE, kE);
        AppMethodBeat.o(36350);
    }

    private void onError() {
        AppMethodBeat.i(36351);
        r kE = af.cnu().kE((long) this.cNE);
        kE.offset = 0;
        try {
            bax bax = (bax) new bax().parseFrom(kE.rfI);
            bax.wFE = "";
            kE.rfI = bax.toByteArray();
            af.cnu().a(this.cNE, kE);
            af.cnE().CV(this.cNE);
            AppMethodBeat.o(36351);
        } catch (Exception e) {
            ab.e("MicroMsg.NetSceneMMSnsUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
            AppMethodBeat.o(36351);
        }
    }

    public final void cancel() {
        AppMethodBeat.i(36352);
        super.cancel();
        if (this.qJY && !bo.isNullOrNil(this.fFa)) {
            ab.i("MicroMsg.NetSceneMMSnsUpload", "cancel by cdn " + this.fFa);
            com.tencent.mm.al.f.afx().rN(this.fFa);
        }
        AppMethodBeat.o(36352);
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        int i = 108;
        AppMethodBeat.i(36353);
        this.ehi = fVar;
        if (this.qJY) {
            this.fFa = this.qJV.ptv;
            if (bo.isNullOrNil(this.fFa)) {
                ab.w("MicroMsg.NetSceneMMSnsUpload", "cdntra genClientId failed not use cdn");
            } else {
                com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
                gVar.egl = this.fFk;
                gVar.field_mediaId = this.fFa;
                gVar.field_fullpath = this.path;
                gVar.field_thumbpath = "";
                gVar.field_fileType = com.tencent.mm.i.a.MediaType_FRIENDS;
                gVar.field_talker = "";
                gVar.field_priority = com.tencent.mm.i.a.efC;
                gVar.field_needStorage = true;
                gVar.field_isStreamMedia = false;
                if (s.crs()) {
                    if (!this.qJZ) {
                        i = 107;
                    }
                    gVar.field_appType = i;
                } else if (s.crr()) {
                    if (!this.qJZ) {
                        i = 107;
                    }
                    gVar.field_appType = i;
                } else {
                    com.tencent.mm.al.f.afx();
                    if (com.tencent.mm.al.b.lg(64)) {
                        gVar.field_appType = this.qJZ ? 104 : 103;
                    } else {
                        gVar.field_appType = this.qJZ ? 101 : 100;
                    }
                }
                gVar.field_bzScene = 1;
                if (!com.tencent.mm.al.f.afx().e(gVar)) {
                    ab.e("MicroMsg.NetSceneMMSnsUpload", "cdntra addSendTask failed. clientid:%s", this.fFa);
                    this.fFa = "";
                }
            }
            AppMethodBeat.o(36353);
            return 0;
        }
        i = a(eVar, this.ehh, this);
        AppMethodBeat.o(36353);
        return i;
    }
}
