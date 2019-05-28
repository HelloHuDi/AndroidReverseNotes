package com.tencent.p177mm.plugin.sns.model;

import android.graphics.BitmapFactory.Options;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.graphics.MMBitmapFactory;
import com.tencent.p177mm.hardcoder.HardCoderJNI;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p187al.C31259b;
import com.tencent.p177mm.p187al.C37458c;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p230g.p232b.p233a.C42099d;
import com.tencent.p177mm.p230g.p232b.p233a.C9514f;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.lucky.p1298a.C21904b;
import com.tencent.p177mm.plugin.sns.p517i.C39737c;
import com.tencent.p177mm.plugin.sns.storage.C13478s;
import com.tencent.p177mm.plugin.sns.storage.C29098r;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.bar;
import com.tencent.p177mm.protocal.protobuf.bax;
import com.tencent.p177mm.protocal.protobuf.caq;
import com.tencent.p177mm.protocal.protobuf.ccj;
import com.tencent.p177mm.protocal.protobuf.cck;
import com.tencent.p177mm.protocal.protobuf.civ;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.p177mm.vfs.C5730e;
import java.io.ByteArrayOutputStream;

/* renamed from: com.tencent.mm.plugin.sns.model.z */
public final class C39762z extends C1207m implements C1918k {
    private int cNE;
    private C7472b ehh;
    public C1202f ehi;
    public String fFa;
    int fFb;
    private C1628a fFk;
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

    /* renamed from: com.tencent.mm.plugin.sns.model.z$1 */
    class C290591 implements C1628a {
        C290591() {
        }

        /* renamed from: a */
        public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
            AppMethodBeat.m2504i(36345);
            if (i == -21005) {
                C4990ab.m7411d("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", C39762z.this.fFa, Integer.valueOf(i), c18496c, c9545d);
                C39762z.this.ehi.onSceneEnd(3, -1, "doScene failed", C39762z.this);
                AppMethodBeat.m2505o(36345);
                return 0;
            } else if (c9545d != null && c9545d.field_retCode == 0) {
                C4990ab.m7417i("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", C39762z.this.fFa, Integer.valueOf(i), c18496c, c9545d);
                C39762z.this.mo62864a(c9545d.field_fileUrl, 1, c9545d.field_thumbUrl, 1, "upload_" + C39762z.this.fFa, c9545d.field_filemd5);
                C4990ab.m7416i("MicroMsg.NetSceneMMSnsUpload", "uploadsns cdndone pass: " + (System.currentTimeMillis() - C39762z.this.qKa) + " " + c9545d.field_filemd5);
                new C9514f(C46180a.m86311r(Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(C39762z.this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(C39762z.this.fFb), Integer.valueOf(c9545d.field_fileLength), c9545d.field_transInfo, "", "", "", "", "", "", "", c9545d.efY)).ajK();
                C39762z.this.ehi.onSceneEnd(0, 0, "doScene", C39762z.this);
                AppMethodBeat.m2505o(36345);
                return 0;
            } else if (c9545d != null && c9545d.field_retCode != 0) {
                C4990ab.m7417i("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", C39762z.this.fFa, Integer.valueOf(i), c18496c, c9545d);
                if (C39762z.this.qKb == 21) {
                    if (c9545d.field_retCode <= -10000 && c9545d.field_retCode > HardCoderJNI.ERR_CLIENT_CONNECT) {
                        C21904b.m33474kT(10);
                    } else if (c9545d.field_retCode <= HardCoderJNI.ERR_CLIENT_CONNECT && c9545d.field_retCode >= -22000) {
                        C21904b.m33474kT(11);
                    } else if (c9545d.field_retCode > -5103000 || c9545d.field_retCode < -5103087) {
                        C21904b.m33474kT(15);
                    } else {
                        C21904b.m33474kT(9);
                    }
                }
                C39762z.m68007a(C39762z.this, c9545d.field_retCode);
                String r = C46180a.m86311r(Integer.valueOf(c9545d.field_retCode), Integer.valueOf(1), Long.valueOf(C39762z.this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(C39762z.this.fFb), Integer.valueOf(c9545d.field_fileLength), c9545d.field_transInfo, "", "", "", "", "", "", "", c9545d.efY);
                new C9514f(r).ajK();
                new C42099d(r).ajK();
                C39762z.this.ehi.onSceneEnd(3, -1, "doScene failed", C39762z.this);
                AppMethodBeat.m2505o(36345);
                return 0;
            } else if (i != 0) {
                C4990ab.m7417i("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", C39762z.this.fFa, Integer.valueOf(i), c18496c, c9545d);
                C39762z.this.mo62863CQ(0);
                if (c9545d != null) {
                    new C9514f(C46180a.m86311r(Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(C39762z.this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(C39762z.this.fFb), Integer.valueOf(c9545d.field_fileLength), c9545d.field_transInfo, "", "", "", "", "", "", "", c9545d.efY)).ajK();
                }
                C39762z.this.ehi.onSceneEnd(3, -1, "doScene failed", C39762z.this);
                AppMethodBeat.m2505o(36345);
                return 0;
            } else {
                C4990ab.m7411d("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", C39762z.this.fFa, Integer.valueOf(i), c18496c, c9545d);
                AppMethodBeat.m2505o(36345);
                return 0;
            }
        }

        /* renamed from: a */
        public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        /* renamed from: l */
        public final byte[] mo5084l(String str, byte[] bArr) {
            return null;
        }
    }

    public C39762z(int i, String str, boolean z, int i2) {
        AppMethodBeat.m2504i(36346);
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
        this.fFk = new C290591();
        this.qKa = System.currentTimeMillis();
        this.cNE = i;
        this.qJW = str;
        this.qKb = i2;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ccj();
        c1196a.fsK = new cck();
        c1196a.uri = "/cgi-bin/micromsg-bin/mmsnsupload";
        c1196a.fsI = 207;
        c1196a.fsL = 95;
        c1196a.fsM = 1000000095;
        this.ehh = c1196a.acD();
        this.qJV = (ccj) this.ehh.fsG.fsP;
        C29098r kE = C13373af.cnu().mo25635kE((long) i);
        this.qJZ = z;
        C4990ab.m7416i("MicroMsg.NetSceneMMSnsUpload", "start snsupload netscene localId " + i + "  offset " + kE.offset + " path " + kE.rfE + " totallen " + kE.rfD);
        if (!z) {
            this.qJV.wGz = 1;
            C4990ab.m7416i("MicroMsg.NetSceneMMSnsUpload", "this is single upload");
        }
        try {
            Object obj;
            bax bax = (bax) new bax().parseFrom(kE.rfI);
            this.qJU = C29036i.m46082Xe(kE.rfE);
            this.path = C3892an.m6198fZ(C13373af.getAccSnsPath(), kE.rfE) + this.qJU;
            this.frO = (int) C5730e.asZ(this.path);
            this.qJX = C29036i.m46092Xo(this.path);
            C4990ab.m7416i("MicroMsg.NetSceneMMSnsUpload", "totallen " + this.frO + " isLongPic: " + this.qJX);
            String str2 = bax.wFE;
            if (C5046bo.isNullOrNil(str2)) {
                str2 = C1178g.m2591x((C5046bo.m7588yz()).getBytes());
                bax.wFE = str2;
                try {
                    kE.rfI = bax.toByteArray();
                    C13373af.cnu().mo25631a(kE.reX, kE);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.NetSceneMMSnsUpload", e, "", new Object[0]);
                }
            }
            this.qJV.ptw = this.frO;
            this.qJV.ptx = kE.offset;
            this.qJV.ptv = str2;
            this.fFa = str2;
            C4990ab.m7410d("MicroMsg.NetSceneMMSnsUpload", "filter style " + bax.wFd);
            this.qJV.wFd = bax.wFd;
            C4990ab.m7410d("MicroMsg.NetSceneMMSnsUpload", "syncWeibo " + bax.wFe);
            this.qJV.vEA = bax.Desc;
            this.qJV.wFe = bax.wFe;
            C4990ab.m7416i("MicroMsg.NetSceneMMSnsUpload", "request upload type " + kE.type + " md5: " + bax.cvZ + " appid " + bax.csB + " contenttype " + bax.aPA);
            this.qJV.jCt = kE.type;
            civ civ = new civ();
            civ.xhJ = bax.token;
            civ.xhK = bax.wFn;
            this.qJV.wNQ = civ;
            if (!C5046bo.isNullOrNil(bax.cvZ)) {
                this.qJV.wdO = bax.cvZ;
            }
            if (!C5046bo.isNullOrNil(bax.csB)) {
                this.qJV.fKh = bax.csB;
            }
            this.qJV.xbO = bax.aPA;
            if (C1947ae.gic) {
                this.qJV.jCt = 0;
            }
            if (this.startTime == 0) {
                this.startTime = C5046bo.anU();
                this.fFb = C42129a.MediaType_FRIENDS;
            }
            ccj ccj = this.qJV;
            C37461f.afx();
            if (!C31259b.m50439lg(32)) {
                Object[] objArr = new Object[1];
                C37461f.afx();
                objArr[0] = Boolean.valueOf(C31259b.m50439lg(32));
                C4990ab.m7421w("MicroMsg.NetSceneMMSnsUpload", "cdntra not use cdn flag:%b", objArr);
                obj = null;
            } else if (C1947ae.giR == 2) {
                obj = null;
            } else {
                this.fFa = ccj.ptv;
                if (C5046bo.isNullOrNil(this.fFa)) {
                    C4990ab.m7420w("MicroMsg.NetSceneMMSnsUpload", "cdntra genClientId failed not use cdn");
                    obj = null;
                } else {
                    obj = 1;
                }
            }
            if (obj != null) {
                this.qJY = true;
                AppMethodBeat.m2505o(36346);
                return;
            }
            if (!cnd()) {
                onError();
            }
            AppMethodBeat.m2505o(36346);
        } catch (Exception e2) {
            C4990ab.m7412e("MicroMsg.NetSceneMMSnsUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
            AppMethodBeat.m2505o(36346);
        }
    }

    private boolean cnd() {
        AppMethodBeat.m2504i(36347);
        C29098r kE = C13373af.cnu().mo25635kE((long) this.cNE);
        int i = kE.rfD - kE.offset;
        if (i > this.fFu) {
            i = this.fFu;
        }
        this.offset = kE.offset;
        byte[] e = C5730e.m8632e(this.path, this.offset, i);
        if (e == null || e.length <= 0) {
            AppMethodBeat.m2505o(36347);
            return false;
        }
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        sKBuiltinBuffer_t.setBuffer(e);
        this.qJV.vJd = sKBuiltinBuffer_t;
        this.qJV.ptx = this.offset;
        AppMethodBeat.m2505o(36347);
        return true;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
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

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(36348);
        C4990ab.m7416i("MicroMsg.NetSceneMMSnsUpload", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        cck cck = (cck) ((C7472b) c1929q).fsH.fsP;
        if (i2 == 4) {
            mo62863CQ(i3);
            if (this.qKb == 21) {
                C21904b.m33474kT(12);
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(36348);
        } else if (i2 == 0 && i3 == 0) {
            C29098r kE = C13373af.cnu().mo25635kE((long) this.cNE);
            if (cck.ptx < 0 || (cck.ptx > kE.rfD && kE.rfD > 0)) {
                onError();
                if (i2 == 3) {
                    C21904b.m33474kT(14);
                }
                AppMethodBeat.m2505o(36348);
            } else if (cck.ptx < kE.offset) {
                onError();
                if (i2 == 3) {
                    C21904b.m33474kT(14);
                }
                AppMethodBeat.m2505o(36348);
            } else {
                Object obj;
                C4990ab.m7410d("MicroMsg.NetSceneMMSnsUpload", " bufferUrl: " + cck.xbP.Url + " bufferUrlType: " + cck.xbP.jCt + "  id:" + cck.vQE + " thumb Count: " + cck.wFB + "  type " + cck.jCt + " startPos : " + cck.ptx);
                kE.offset = cck.ptx;
                C13373af.cnu().mo25631a(this.cNE, kE);
                if (kE.offset != kE.rfD || kE.rfD == 0) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    C4990ab.m7416i("MicroMsg.NetSceneMMSnsUpload", "uploadsns done pass: " + (System.currentTimeMillis() - this.qKa));
                    if (cck.wFC.size() == 0 || cck.wFC.size() <= 0) {
                        mo62864a(cck.xbP.Url, cck.xbP.jCt, "", 0, cck.vQE, this.qJV.wdO);
                    } else {
                        mo62864a(cck.xbP.Url, cck.xbP.jCt, ((caq) cck.wFC.get(0)).Url, ((caq) cck.wFC.get(0)).jCt, cck.vQE, this.qJV.wdO);
                    }
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    AppMethodBeat.m2505o(36348);
                    return;
                }
                if (cnd() && mo4456a(this.ftf, this.ehi) < 0) {
                    this.ehi.onSceneEnd(3, -1, "doScene failed", this);
                }
                AppMethodBeat.m2505o(36348);
            }
        } else {
            onError();
            if (this.qKb == 21) {
                C21904b.m33474kT(13);
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(36348);
        }
    }

    /* renamed from: a */
    public final boolean mo62864a(String str, int i, String str2, int i2, String str3, String str4) {
        bax bax;
        AppMethodBeat.m2504i(36349);
        C29098r kE = C13373af.cnu().mo25635kE((long) this.cNE);
        C4990ab.m7416i("MicroMsg.NetSceneMMSnsUpload", "upload ok " + str + "  " + str3 + "  " + i + " thumbUrl: " + str2);
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
        C39737c.m67953a(str, options.outMimeType, options.outWidth, options.outHeight, i3, C5730e.asZ(this.path));
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
        if (!C5046bo.isNullOrNil(str2)) {
            bar = new bar();
            bar.jCt = i2;
            bar.Url = str2;
            bax.wFC.add(bar);
        }
        try {
            kE.rfI = bax.toByteArray();
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.NetSceneMMSnsUpload", e2, "", new Object[0]);
        }
        kE.crq();
        C13373af.cnu().mo25631a(this.cNE, kE);
        C13373af.cnE().mo37396CV(this.cNE);
        if (C13373af.cnB() != null) {
            C13373af.cnB().cmp();
        }
        AppMethodBeat.m2505o(36349);
        return true;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: CQ */
    public final void mo62863CQ(int i) {
        AppMethodBeat.m2504i(36350);
        C29098r kE = C13373af.cnu().mo25635kE((long) this.cNE);
        try {
            bax bax = (bax) new bax().parseFrom(kE.rfI);
            bax.wFD = 1;
            bax.wFm = i;
            kE.rfI = bax.toByteArray();
        } catch (Exception e) {
        }
        C13373af.cnE().mo37396CV(this.cNE);
        C13373af.cnu().mo25631a(this.cNE, kE);
        AppMethodBeat.m2505o(36350);
    }

    private void onError() {
        AppMethodBeat.m2504i(36351);
        C29098r kE = C13373af.cnu().mo25635kE((long) this.cNE);
        kE.offset = 0;
        try {
            bax bax = (bax) new bax().parseFrom(kE.rfI);
            bax.wFE = "";
            kE.rfI = bax.toByteArray();
            C13373af.cnu().mo25631a(this.cNE, kE);
            C13373af.cnE().mo37396CV(this.cNE);
            AppMethodBeat.m2505o(36351);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.NetSceneMMSnsUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
            AppMethodBeat.m2505o(36351);
        }
    }

    public final void cancel() {
        AppMethodBeat.m2504i(36352);
        super.cancel();
        if (this.qJY && !C5046bo.isNullOrNil(this.fFa)) {
            C4990ab.m7416i("MicroMsg.NetSceneMMSnsUpload", "cancel by cdn " + this.fFa);
            C37461f.afx().mo51227rN(this.fFa);
        }
        AppMethodBeat.m2505o(36352);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        int i = 108;
        AppMethodBeat.m2504i(36353);
        this.ehi = c1202f;
        if (this.qJY) {
            this.fFa = this.qJV.ptv;
            if (C5046bo.isNullOrNil(this.fFa)) {
                C4990ab.m7420w("MicroMsg.NetSceneMMSnsUpload", "cdntra genClientId failed not use cdn");
            } else {
                C42130g c42130g = new C42130g();
                c42130g.egl = this.fFk;
                c42130g.field_mediaId = this.fFa;
                c42130g.field_fullpath = this.path;
                c42130g.field_thumbpath = "";
                c42130g.field_fileType = C42129a.MediaType_FRIENDS;
                c42130g.field_talker = "";
                c42130g.field_priority = C42129a.efC;
                c42130g.field_needStorage = true;
                c42130g.field_isStreamMedia = false;
                if (C13478s.crs()) {
                    if (!this.qJZ) {
                        i = 107;
                    }
                    c42130g.field_appType = i;
                } else if (C13478s.crr()) {
                    if (!this.qJZ) {
                        i = 107;
                    }
                    c42130g.field_appType = i;
                } else {
                    C37461f.afx();
                    if (C31259b.m50439lg(64)) {
                        c42130g.field_appType = this.qJZ ? 104 : 103;
                    } else {
                        c42130g.field_appType = this.qJZ ? 101 : 100;
                    }
                }
                c42130g.field_bzScene = 1;
                if (!C37461f.afx().mo51225e(c42130g)) {
                    C4990ab.m7413e("MicroMsg.NetSceneMMSnsUpload", "cdntra addSendTask failed. clientid:%s", this.fFa);
                    this.fFa = "";
                }
            }
            AppMethodBeat.m2505o(36353);
            return 0;
        }
        i = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(36353);
        return i;
    }
}
