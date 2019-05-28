package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.g.a.rs;
import com.tencent.mm.g.b.a.f;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.plugin.mmsight.model.h;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.protocal.protobuf.baa;
import com.tencent.mm.protocal.protobuf.bar;
import com.tencent.mm.protocal.protobuf.bax;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.io.ByteArrayOutputStream;

public final class ac {
    private int cNE;
    private String clientId;
    String fFa;
    int fFb;
    private com.tencent.mm.i.g.a fFk;
    int fWD;
    private String hxH;
    private String mPath;
    private long qKa;
    r qKs;
    a qKt;
    private bax qKu;
    long startTime;
    private String thumbPath;

    public interface a {
        void kJ(boolean z);
    }

    public ac(int i, r rVar, String str, String str2, a aVar) {
        AppMethodBeat.i(36375);
        this.clientId = "";
        this.qKa = 0;
        this.startTime = 0;
        this.fFb = 0;
        this.hxH = "";
        this.qKu = new bax();
        this.fFk = new com.tencent.mm.i.g.a() {
            public final int a(String str, int i, c cVar, d dVar, boolean z) {
                AppMethodBeat.i(36374);
                if (i == -21005) {
                    ab.d("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", ac.this.fFa, Integer.valueOf(i), cVar, dVar);
                    ac.this.qKt.kJ(true);
                    AppMethodBeat.o(36374);
                    return 0;
                } else if (dVar != null && dVar.field_retCode == 0) {
                    ab.i("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", ac.this.fFa, Integer.valueOf(i), cVar, dVar);
                    ac.this.ae(dVar.field_fileUrl, dVar.field_thumbUrl, "upload_" + ac.this.fFa);
                    new f(com.tencent.mm.plugin.report.a.r(Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(ac.this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(ac.this.fFb), Integer.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.efY)).ajK();
                    n alj = n.alj();
                    int i2 = ac.this.fWD;
                    if (dVar != null) {
                        String str2 = dVar.field_fileUrl;
                        String str3 = str2.hashCode();
                        com.tencent.mm.modelvideo.n.a aVar = (com.tencent.mm.modelvideo.n.a) alj.fWm.get(str3);
                        if (aVar == null) {
                            aVar = new com.tencent.mm.modelvideo.n.a();
                        }
                        String str4 = "";
                        aVar.dqJ = str4;
                        aVar.toUser = str4;
                        aVar.fWz = str4;
                        aVar.fWD = i2;
                        aVar.fWC = 1;
                        aVar.cEZ = str2;
                        aVar.fVQ = dVar;
                        aVar.startTime = bo.anU();
                        alj.fWm.put(str3, aVar);
                        ab.i("MicroMsg.SubCoreMediaRpt", "note sns video sendScene %d snsKey[%s] url[%s]", Integer.valueOf(i2), str3, str2);
                    }
                    ac.this.qKt.kJ(true);
                    AppMethodBeat.o(36374);
                    return 0;
                } else if (dVar != null && dVar.field_retCode != 0) {
                    ab.i("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", ac.this.fFa, Integer.valueOf(i), cVar, dVar);
                    ac.this.CQ(0);
                    String r = com.tencent.mm.plugin.report.a.r(Integer.valueOf(dVar.field_retCode), Integer.valueOf(1), Long.valueOf(ac.this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(ac.this.fFb), Integer.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.efY);
                    new f(r).ajK();
                    new com.tencent.mm.g.b.a.d(r).ajK();
                    ac.this.qKt.kJ(false);
                    AppMethodBeat.o(36374);
                    return 0;
                } else if (i != 0) {
                    ab.i("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", ac.this.fFa, Integer.valueOf(i), cVar, dVar);
                    ac.this.CQ(0);
                    if (dVar != null) {
                        new f(com.tencent.mm.plugin.report.a.r(Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(ac.this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(ac.this.fFb), Integer.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.efY)).ajK();
                    }
                    ac.this.qKt.kJ(false);
                    AppMethodBeat.o(36374);
                    return 0;
                } else {
                    ab.d("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", ac.this.fFa, Integer.valueOf(i), cVar, dVar);
                    AppMethodBeat.o(36374);
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
        this.mPath = str;
        this.thumbPath = str2;
        this.qKt = aVar;
        this.cNE = i;
        this.qKs = rVar;
        try {
            this.qKu = (bax) new bax().parseFrom(rVar.rfI);
            this.clientId = this.qKu.wFE;
            this.hxH = this.qKu.cvZ;
            if (bo.isNullOrNil(this.clientId)) {
                this.clientId = g.x((bo.yz()).getBytes());
                this.qKu.wFE = this.clientId;
                try {
                    rVar.rfI = this.qKu.toByteArray();
                    af.cnu().a(rVar.reX, rVar);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.SightCdnUpload", e, "", new Object[0]);
                }
            }
            int asZ = (int) e.asZ(str);
            ab.i("MicroMsg.SightCdnUpload", "sightupload %d videopath %s sightFileSize %d md5 %s", Integer.valueOf(i), str, Integer.valueOf(asZ), this.hxH);
            AppMethodBeat.o(36375);
        } catch (Exception e2) {
            ab.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
            AppMethodBeat.o(36375);
        }
    }

    public final boolean cne() {
        AppMethodBeat.i(36376);
        String cz = g.cz(this.mPath);
        if (bo.isNullOrNil(this.hxH) || this.hxH.equals(cz)) {
            baa baa;
            if (this.qKu.wFH != null) {
                baa = this.qKu.wFH;
            } else {
                baa = new baa();
            }
            ab.i("MicroMsg.SightCdnUpload", "check upload %s %d %s", this.mPath, Integer.valueOf(baa.wDQ), Boolean.valueOf(baa.wDP));
            com.tencent.mm.plugin.sight.base.a WR = com.tencent.mm.plugin.sight.base.d.WR(this.mPath);
            if (WR != null) {
                ab.i("MicroMsg.SightCdnUpload", "mediaInfo: %s", WR);
                long j = (bo.isNullOrNil(baa.csB) || !baa.csB.contains("wx5dfbe0a95623607b")) ? baa.wDP ? (long) com.tencent.mm.modelcontrol.d.afF().afH().duration : (long) com.tencent.mm.modelcontrol.d.afF().afI().duration : (long) com.tencent.mm.m.g.Nu().getInt("WeiShiShareSnsSightTimeLength", 10);
                if (j <= 0) {
                    j = 10;
                }
                ab.i("MicroMsg.SightCdnUpload", "maxVideoLen: %s", Long.valueOf((j * 1000) + 3000));
                if (((long) WR.eWK) >= (j * 1000) + 3000) {
                    ab.i("MicroMsg.SightCdnUpload", "checkUpload isNotSafeSightVideo videoDuration: %s ", Integer.valueOf(WR.eWK));
                    CQ(-2);
                    this.qKt.kJ(false);
                    AppMethodBeat.o(36376);
                    return false;
                }
            }
            if (baa.wDP) {
                int i = h.ouu;
                if (baa.wDQ >= 3) {
                    onError();
                    AppMethodBeat.o(36376);
                    return false;
                }
                ab.i("MicroMsg.SightCdnUpload", "try need remux %d %s", Integer.valueOf(i), this.mPath);
                final b rsVar = new rs();
                rsVar.callback = new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(36371);
                        ab.i("MicroMsg.SightCdnUpload", "event callback errcode %d", Integer.valueOf(rsVar.cNI.result));
                        if (rsVar.cNI.result >= 0) {
                            ac.a(ac.this);
                            ac.this.a(baa);
                            AppMethodBeat.o(36371);
                            return;
                        }
                        ac.this.onError();
                        AppMethodBeat.o(36371);
                    }
                };
                rsVar.cNH.cNL = new com.tencent.mm.plugin.mmsight.model.d() {
                    public final boolean bOc() {
                        AppMethodBeat.i(36372);
                        ab.i("MicroMsg.SightCdnUpload", "iUpdateVideoFile");
                        ac.a(ac.this);
                        AppMethodBeat.o(36372);
                        return false;
                    }
                };
                rsVar.cNH.cNp = this.mPath;
                rsVar.cNH.scene = i;
                rsVar.cNH.cNJ = baa;
                rsVar.cNH.cNK = new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(36373);
                        baa.wDQ++;
                        try {
                            ab.i("MicroMsg.SightCdnUpload", "add try count %d", Integer.valueOf(baa.wDQ));
                            bax bax = (bax) new bax().parseFrom(ac.this.qKs.rfI);
                            bax.wFH = baa;
                            ac.this.qKs.rfI = bax.toByteArray();
                            af.cnu().a(ac.this.qKs.reX, ac.this.qKs);
                            AppMethodBeat.o(36373);
                        } catch (Exception e) {
                            ab.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in checkUploadaddCount %s", e.getMessage());
                            AppMethodBeat.o(36373);
                        }
                    }
                };
                com.tencent.mm.sdk.b.a.xxA.a(rsVar, af.cns());
                AppMethodBeat.o(36376);
                return true;
            }
            a(baa);
            AppMethodBeat.o(36376);
            return true;
        }
        ab.i("MicroMsg.SightCdnUpload", "checkUpload isNotSafeSightVideo old srcmd5 %s newmd5 %s ", this.hxH, cz);
        CQ(-2);
        this.qKt.kJ(false);
        AppMethodBeat.o(36376);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final boolean a(baa baa) {
        AppMethodBeat.i(36377);
        if (this.startTime == 0) {
            this.startTime = bo.anU();
            this.fFb = com.tencent.mm.i.a.efI;
        }
        String str = this.clientId;
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.SightCdnUpload", "cdntra genClientId failed not use cdn");
            AppMethodBeat.o(36377);
            return false;
        }
        com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
        gVar.egl = this.fFk;
        gVar.field_mediaId = str;
        gVar.field_fullpath = this.mPath;
        gVar.field_thumbpath = this.thumbPath;
        gVar.field_fileType = com.tencent.mm.i.a.efI;
        gVar.field_talker = "";
        gVar.field_priority = com.tencent.mm.i.a.efC;
        gVar.field_needStorage = true;
        gVar.field_isStreamMedia = false;
        gVar.field_appType = 102;
        gVar.field_bzScene = 1;
        if (bo.isNullOrNil(baa.csB) || !baa.csB.contains("wx5dfbe0a95623607b")) {
            VideoTransPara afH;
            com.tencent.mm.modelcontrol.d.afF();
            if (baa.wDP) {
                afH = com.tencent.mm.modelcontrol.d.afF().afH();
            } else {
                afH = com.tencent.mm.modelcontrol.d.afF().afI();
            }
            gVar.field_largesvideo = com.tencent.mm.modelcontrol.d.a(afH);
        } else {
            gVar.field_largesvideo = com.tencent.mm.m.g.Nu().getInt("WeiShiShareSnsSightTimeLength", 10);
        }
        String cz = g.cz(this.mPath);
        if (!bo.isNullOrNil(this.hxH) && !this.hxH.equals(cz)) {
            ab.i("MicroMsg.SightCdnUpload", "isNotSafeSightVideo old srcmd5 %s newmd5 %s ", this.hxH, cz);
            CQ(-2);
            this.qKt.kJ(false);
            AppMethodBeat.o(36377);
            return false;
        } else if (com.tencent.mm.al.f.afx().e(gVar)) {
            int i = (baa == null || !baa.wDP) ? 5 : 4;
            this.fWD = i;
            AppMethodBeat.o(36377);
            return true;
        } else {
            ab.e("MicroMsg.SightCdnUpload", "cdntra addSendTask failed. clientid:%s", str);
            AppMethodBeat.o(36377);
            return false;
        }
    }

    public final boolean ae(String str, String str2, String str3) {
        bax bax;
        AppMethodBeat.i(36378);
        r kE = af.cnu().kE((long) this.cNE);
        ab.d("MicroMsg.SightCdnUpload", "upload ok " + str + "  " + str3 + "  1");
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
        bar.jCt = 1;
        bar.Url = str;
        bax.wFA = bar;
        bax.wFD = 0;
        com.tencent.mm.al.f.afy();
        bax.wFc = com.tencent.mm.al.a.rJ(this.mPath);
        ab.i("MicroMsg.SightCdnUpload", "onPostScene videomd5 %s", bax.wFc);
        if (!bo.isNullOrNil(str2)) {
            bar = new bar();
            bar.jCt = 1;
            bar.Url = str2;
            bax.wFC.add(bar);
        }
        try {
            kE.rfI = bax.toByteArray();
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.SightCdnUpload", e2, "", new Object[0]);
        }
        kE.crq();
        af.cnu().a(this.cNE, kE);
        af.cnE().CV(this.cNE);
        if (af.cnB() != null) {
            af.cnB().cmp();
        }
        AppMethodBeat.o(36378);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final void CQ(int i) {
        AppMethodBeat.i(36379);
        ab.i("MicroMsg.SightCdnUpload", "snsupload sight by cdn error!");
        r kE = af.cnu().kE((long) this.cNE);
        try {
            bax bax = (bax) new bax().parseFrom(kE.rfI);
            bax.wFD = 1;
            bax.wFm = i;
            if (this.qKu.wFH != null) {
                this.qKu.wFH.wDQ = 0;
            }
            kE.rfI = bax.toByteArray();
        } catch (Exception e) {
        }
        af.cnE().CV(this.cNE);
        af.cnu().a(this.cNE, kE);
        AppMethodBeat.o(36379);
    }

    /* Access modifiers changed, original: final */
    public final void onError() {
        AppMethodBeat.i(36380);
        ab.i("MicroMsg.SightCdnUpload", "snsupload sight by cdn error!");
        r kE = af.cnu().kE((long) this.cNE);
        kE.offset = 0;
        try {
            bax bax = (bax) new bax().parseFrom(kE.rfI);
            bax.wFE = "";
            if (bax.wFH != null) {
                bax.wFH.wDQ = 0;
            }
            kE.rfI = bax.toByteArray();
            af.cnu().a(this.cNE, kE);
            af.cnE().CV(this.cNE);
            AppMethodBeat.o(36380);
        } catch (Exception e) {
            ab.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
            AppMethodBeat.o(36380);
        }
    }
}
