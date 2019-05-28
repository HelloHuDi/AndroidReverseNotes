package com.tencent.mm.modelvideo;

import android.graphics.BitmapFactory.Options;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.i.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cfh;
import com.tencent.mm.protocal.protobuf.cls;
import com.tencent.mm.protocal.protobuf.clt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.smtt.sdk.TbsMediaPlayer.TbsMediaPlayerListener;
import junit.framework.Assert;

public final class h extends m implements k {
    private b ehh;
    private f ehi;
    private int fVP = 0;
    private d fVQ = null;
    private a fVR = null;
    String fileName = null;

    public interface a {
        void cC(int i, int i2);
    }

    public h(String str, int i, d dVar, a aVar) {
        boolean z = false;
        AppMethodBeat.i(50710);
        Assert.assertTrue(str != null);
        if (dVar != null) {
            z = true;
        }
        Assert.assertTrue(z);
        Assert.assertTrue(true);
        this.fileName = str;
        this.fVQ = dVar;
        this.fVR = aVar;
        this.fVP = i;
        AppMethodBeat.o(50710);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0342  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x034a  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0352  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x035a  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0362  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x036a  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x021b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(50711);
        this.ehi = fVar;
        s ut = u.ut(this.fileName);
        if (ut == null) {
            ab.e("MicroMsg.NetSceneUploadVideoForCdn", "Get info Failed file:" + this.fileName);
            this.fVR.cC(3, -1);
            AppMethodBeat.o(50711);
            return -1;
        }
        String aae;
        int i;
        String str;
        String str2;
        Object[] objArr;
        int a;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new cls();
        aVar.fsK = new clt();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadvideo";
        aVar.fsI = 149;
        aVar.fsL = 39;
        aVar.fsM = 1000000039;
        this.ehh = aVar.acD();
        cls cls = (cls) this.ehh.fsG.fsP;
        cls.xjp = 0;
        cls.xjo = this.fVQ.field_fileLength;
        cls.xjq = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        cls.wEt = 0;
        cls.wEs = this.fVQ.field_thumbimgLength;
        cls.wEu = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        cls.ndG = r.Yz();
        cls.ndF = this.fVQ.field_toUser;
        cls.vFF = this.fileName;
        if (ut.fXh == 1) {
            cls.xjr = 2;
        }
        if (ut.fXk == 3) {
            cls.xjr = 3;
        }
        cls.wYj = ut.fXd;
        cls.wdl = com.tencent.mm.network.ab.ch(ah.getContext()) ? 1 : 2;
        cls.wEv = 2;
        cls.xjg = this.fVQ.field_thumbimgLength;
        cls.xjs = this.fVQ.field_fileId;
        cls.wxU = this.fVQ.field_fileId;
        cls.vRx = 1;
        if (this.fVQ.Jm()) {
            ab.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s]", alb(), Boolean.valueOf(this.fVQ.field_upload_by_safecdn), Integer.valueOf(this.fVQ.field_UploadHitCacheType), Integer.valueOf(this.fVQ.field_filecrc), this.fVQ.field_aesKey);
            cls.wWT = 1;
            cls.vRw = "";
            cls.wxW = "";
        } else {
            cls.vRw = this.fVQ.field_aesKey;
            cls.wxW = this.fVQ.field_aesKey;
        }
        cls.xju = this.fVQ.field_filemd5;
        cls.xjE = this.fVQ.field_mp4identifymd5;
        cls.vRy = this.fVQ.field_filecrc;
        if (this.fVP <= 0 || this.fVP > 1048576) {
            aae = bh.aae();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<msgsource>");
            stringBuilder.append("<videopreloadlen>").append(this.fVP).append("</videopreloadlen>");
            stringBuilder.append("</msgsource>");
            com.tencent.mm.plugin.report.service.h.pYm.a(354, 35, 1, false);
            aae = stringBuilder.toString();
        }
        cls.vEG = aae;
        cls.xjD = ut.cMn;
        cfh cfh = ut.fXm;
        if (cfh != null && !bo.isNullOrNil(cfh.fiG)) {
            cls.xjv = bo.bc(cfh.fiG, "");
            cls.xjw = cfh.wid;
            cls.xjx = bo.bc(cfh.fiI, "");
            cls.xjz = bo.bc(cfh.fiK, "");
            cls.xjy = bo.bc(cfh.fiJ, "");
            cls.xjA = bo.bc(cfh.fiL, "");
        } else if (!(cfh == null || bo.isNullOrNil(cfh.fiK) || bo.isNullOrNil(cfh.fiJ))) {
            cls.xjz = cfh.fiK;
            cls.xjy = cfh.fiJ;
        }
        if (cfh != null) {
            cls.xjC = bo.bc(cfh.fiM, "");
            cls.xjB = bo.bc(cfh.fiN, "");
        }
        o.all();
        Options amj = com.tencent.mm.sdk.platformtools.d.amj(t.ui(this.fileName));
        if (amj != null) {
            cls.xji = amj.outWidth;
            cls.xjh = amj.outHeight;
        } else {
            ab.w("MicroMsg.NetSceneUploadVideoForCdn", "cdntra getImageOptions for thumb failed path:%s", aae);
        }
        o.all();
        aae = t.uh(this.fileName);
        n alj = n.alj();
        if (!bo.isNullOrNil(aae)) {
            com.tencent.mm.modelvideo.n.a aVar2 = (com.tencent.mm.modelvideo.n.a) alj.fWm.get(aae);
            if (aVar2 != null) {
                i = aVar2.fWD;
                switch (i) {
                    case 1:
                        cls.vRz = 1;
                        cls.vFH = 2;
                        break;
                    case 2:
                        cls.vRz = 1;
                        cls.vFH = 1;
                        break;
                    case 3:
                    case 6:
                        cls.vRz = 2;
                        cls.vFH = 3;
                        break;
                    case 7:
                        cls.vRz = 3;
                        cls.vFH = 4;
                        break;
                    case 8:
                        cls.vRz = 1;
                        cls.vFH = 5;
                        break;
                    default:
                        cls.vRz = 0;
                        cls.vFH = 0;
                        break;
                }
                str = "MicroMsg.NetSceneUploadVideoForCdn";
                str2 = "%s summersafecdn cdntra doscene file:%s touser:%s aes:%d fileid:%s thumb:[%d %d %d], thumbaeskey [%s] funcFlag: %d, md5:%s HitMd5:%d CRC32:%d, VideoNewMd5:%s AESKey:%s stream %s streamtime: %d title %s thumburl %s msgSource[%s] msgForwardType[%d] Source[%d]";
                objArr = new Object[22];
                objArr[0] = alb();
                objArr[1] = this.fileName;
                objArr[2] = this.fVQ.field_toUser;
                if (this.fVQ.field_aesKey != null) {
                    i = -1;
                } else {
                    i = this.fVQ.field_aesKey.length();
                }
                objArr[3] = Integer.valueOf(i);
                objArr[4] = this.fVQ.field_fileId;
                objArr[5] = Integer.valueOf(this.fVQ.field_thumbimgLength);
                objArr[6] = Integer.valueOf(cls.xji);
                objArr[7] = Integer.valueOf(cls.xjh);
                objArr[8] = bo.anv(cls.wxW);
                objArr[9] = Integer.valueOf(cls.xjr);
                objArr[10] = cls.xju;
                objArr[11] = Integer.valueOf(cls.wWT);
                objArr[12] = Integer.valueOf(cls.vRy);
                objArr[13] = cls.xjE;
                objArr[14] = bo.anv(cls.vRw);
                objArr[15] = cls.xjv;
                objArr[16] = Integer.valueOf(cls.xjw);
                objArr[17] = cls.xjx;
                objArr[18] = cls.xjA;
                objArr[19] = cls.vEG;
                objArr[20] = Integer.valueOf(cls.vRz);
                objArr[21] = Integer.valueOf(cls.vFH);
                ab.i(str, str2, objArr);
                a = a(eVar, this.ehh, this);
                AppMethodBeat.o(50711);
                return a;
            }
        }
        i = 0;
        switch (i) {
            case 1:
                break;
            case 2:
                break;
            case 3:
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            default:
                break;
        }
        str = "MicroMsg.NetSceneUploadVideoForCdn";
        str2 = "%s summersafecdn cdntra doscene file:%s touser:%s aes:%d fileid:%s thumb:[%d %d %d], thumbaeskey [%s] funcFlag: %d, md5:%s HitMd5:%d CRC32:%d, VideoNewMd5:%s AESKey:%s stream %s streamtime: %d title %s thumburl %s msgSource[%s] msgForwardType[%d] Source[%d]";
        objArr = new Object[22];
        objArr[0] = alb();
        objArr[1] = this.fileName;
        objArr[2] = this.fVQ.field_toUser;
        if (this.fVQ.field_aesKey != null) {
        }
        objArr[3] = Integer.valueOf(i);
        objArr[4] = this.fVQ.field_fileId;
        objArr[5] = Integer.valueOf(this.fVQ.field_thumbimgLength);
        objArr[6] = Integer.valueOf(cls.xji);
        objArr[7] = Integer.valueOf(cls.xjh);
        objArr[8] = bo.anv(cls.wxW);
        objArr[9] = Integer.valueOf(cls.xjr);
        objArr[10] = cls.xju;
        objArr[11] = Integer.valueOf(cls.wWT);
        objArr[12] = Integer.valueOf(cls.vRy);
        objArr[13] = cls.xjE;
        objArr[14] = bo.anv(cls.vRw);
        objArr[15] = cls.xjv;
        objArr[16] = Integer.valueOf(cls.xjw);
        objArr[17] = cls.xjx;
        objArr[18] = cls.xjA;
        objArr[19] = cls.vEG;
        objArr[20] = Integer.valueOf(cls.vRz);
        objArr[21] = Integer.valueOf(cls.vFH);
        ab.i(str, str2, objArr);
        a = a(eVar, this.ehh, this);
        AppMethodBeat.o(50711);
        return a;
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }

    public final int acn() {
        return 1;
    }

    public final void a(com.tencent.mm.ai.m.a aVar) {
        AppMethodBeat.i(50712);
        u.um(this.fileName);
        AppMethodBeat.o(50712);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(50713);
        ab.i("MicroMsg.NetSceneUploadVideoForCdn", "%s cdntra onGYNetEnd errtype[%d %d]", alb(), Integer.valueOf(i2), Integer.valueOf(i3));
        clt clt = (clt) ((b) qVar).fsH.fsP;
        s ut = u.ut(this.fileName);
        if (ut == null) {
            ab.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
            this.ehi.onSceneEnd(i2, i3, str, this);
            this.fVR.cC(3, -1);
            AppMethodBeat.o(50713);
        } else if (i2 == 4 && i3 == 102) {
            ab.e("MicroMsg.NetSceneUploadVideoForCdn", "summersafecdn ERR: MM_ERR_GET_AESKEY_FAILED errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + ut.getUser());
            this.ehi.onSceneEnd(i2, i3, str, this);
            this.fVR.cC(i2, i3);
            AppMethodBeat.o(50713);
        } else if (i2 == 4 && i3 == -22) {
            ab.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd BLACK  errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + ut.getUser());
            u.un(this.fileName);
            this.ehi.onSceneEnd(i2, i3, str, this);
            this.fVR.cC(i2, i3);
            AppMethodBeat.o(50713);
        } else if (i2 == 4 && i3 != 0) {
            ab.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd SERVER FAILED errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + ut.getUser());
            u.um(this.fileName);
            this.ehi.onSceneEnd(i2, i3, str, this);
            this.fVR.cC(i2, i3);
            AppMethodBeat.o(50713);
        } else if (i2 == 0 && i3 == 0) {
            boolean z;
            ut.fXb = bo.anT();
            ut.cKK = clt.ptF;
            ab.i("MicroMsg.NetSceneUploadVideoForCdn", "%s dkmsgid  set svrmsgid %d -> %d", alb(), Long.valueOf(ut.cKK), Integer.valueOf(ae.giA));
            if (!(CdnLogic.kMediaTypeFavoriteBigFile != ae.giz || ae.giA == 0 || ut.cKK == 0)) {
                ut.cKK = (long) ae.giA;
                ae.giA = 0;
            }
            ut.status = 199;
            ut.bJt = 1284;
            if (this.fVQ.Jm()) {
                ab.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn aeskey[%s], old RecvXml[%s]", alb(), clt.vRw, ut.alw());
                if (bo.isNullOrNil(clt.vRw)) {
                    ab.w("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn need aeskey but ret null", alb());
                } else {
                    int i4;
                    ab.i("MicroMsg.NetSceneUploadVideoForCdn", "cdn callback new build cdnInfo:%s", ((("<msg><videomsg aeskey=\"" + clt.vRw + "\" cdnthumbaeskey=\"" + clt.vRw + "\" cdnvideourl=\"" + this.fVQ.field_fileId + "\" ") + "cdnthumburl=\"" + this.fVQ.field_fileId + "\" ") + "length=\"" + this.fVQ.field_fileLength + "\" ") + "cdnthumblength=\"" + this.fVQ.field_thumbimgLength + "\"/></msg>");
                    ut.fXj = r1;
                    t all = o.all();
                    o.all();
                    boolean s = all.s(t.uh(this.fileName), this.fVQ.field_fileId, clt.vRw);
                    com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                    Object[] objArr = new Object[2];
                    if (s) {
                        i4 = 1;
                    } else {
                        i4 = 2;
                    }
                    objArr[0] = Integer.valueOf(i4 + TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR);
                    objArr[1] = Integer.valueOf(ut.frO);
                    hVar.e(12696, objArr);
                    ab.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn aeskey[%s], new RecvXml[%s], saveret[%b]", alb(), clt.vRw, ut.alw(), Boolean.valueOf(s));
                }
            }
            u.f(ut);
            u.d(ut);
            com.tencent.mm.modelstat.b.fRa.j(((j) g.K(j.class)).bOr().jf((long) ut.fXe));
            ad aoO = ((j) g.K(j.class)).XM().aoO(ut.getUser());
            if (aoO == null || ((int) aoO.ewQ) <= 0) {
                z = false;
            } else {
                z = aoO.dsf();
            }
            if (z || t.nl(ut.getUser())) {
                ab.i("MicroMsg.NetSceneUploadVideoForCdn", "%s upload to biz :%s", alb(), ut.getUser());
                if (ut.cKK < 0) {
                    ab.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: finish video invaild MSGSVRID :" + ut.cKK + " file:" + this.fileName + " toUser:" + ut.getUser());
                    u.um(this.fileName);
                    this.fVR.cC(3, -1);
                }
            } else {
                ab.i("MicroMsg.NetSceneUploadVideoForCdn", "%s not upload to biz", alb());
                if (ut.cKK <= 0) {
                    ab.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: finish video invaild MSGSVRID :" + ut.cKK + " file:" + this.fileName + " toUser:" + ut.getUser());
                    u.um(this.fileName);
                    this.fVR.cC(3, -1);
                }
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            this.fVR.cC(0, 0);
            AppMethodBeat.o(50713);
        } else {
            ab.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + ut.getUser());
            u.um(this.fileName);
            this.ehi.onSceneEnd(i2, i3, str, this);
            this.fVR.cC(i2, i3);
            AppMethodBeat.o(50713);
        }
    }

    public final int getType() {
        return 149;
    }

    private String alb() {
        AppMethodBeat.i(50714);
        String str = this.fileName + "_" + hashCode();
        AppMethodBeat.o(50714);
        return str;
    }
}
