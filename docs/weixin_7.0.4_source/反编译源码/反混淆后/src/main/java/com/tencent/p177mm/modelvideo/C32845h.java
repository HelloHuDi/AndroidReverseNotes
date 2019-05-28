package com.tencent.p177mm.modelvideo;

import android.graphics.BitmapFactory.Options;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1831bh;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.modelstat.C45457b;
import com.tencent.p177mm.modelvideo.C45459n.C42227a;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.network.C32856ab;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1205a;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.cfh;
import com.tencent.p177mm.protocal.protobuf.cls;
import com.tencent.p177mm.protocal.protobuf.clt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.smtt.sdk.TbsMediaPlayer.TbsMediaPlayerListener;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.modelvideo.h */
public final class C32845h extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    private int fVP = 0;
    private C9545d fVQ = null;
    private C32846a fVR = null;
    String fileName = null;

    /* renamed from: com.tencent.mm.modelvideo.h$a */
    public interface C32846a {
        /* renamed from: cC */
        void mo39619cC(int i, int i2);
    }

    public C32845h(String str, int i, C9545d c9545d, C32846a c32846a) {
        boolean z = false;
        AppMethodBeat.m2504i(50710);
        Assert.assertTrue(str != null);
        if (c9545d != null) {
            z = true;
        }
        Assert.assertTrue(z);
        Assert.assertTrue(true);
        this.fileName = str;
        this.fVQ = c9545d;
        this.fVR = c32846a;
        this.fVP = i;
        AppMethodBeat.m2505o(50710);
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
    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(50711);
        this.ehi = c1202f;
        C26493s ut = C26494u.m42268ut(this.fileName);
        if (ut == null) {
            C4990ab.m7412e("MicroMsg.NetSceneUploadVideoForCdn", "Get info Failed file:" + this.fileName);
            this.fVR.mo39619cC(3, -1);
            AppMethodBeat.m2505o(50711);
            return -1;
        }
        String aae;
        int i;
        String str;
        String str2;
        Object[] objArr;
        int a;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cls();
        c1196a.fsK = new clt();
        c1196a.uri = "/cgi-bin/micromsg-bin/uploadvideo";
        c1196a.fsI = 149;
        c1196a.fsL = 39;
        c1196a.fsM = 1000000039;
        this.ehh = c1196a.acD();
        cls cls = (cls) this.ehh.fsG.fsP;
        cls.xjp = 0;
        cls.xjo = this.fVQ.field_fileLength;
        cls.xjq = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        cls.wEt = 0;
        cls.wEs = this.fVQ.field_thumbimgLength;
        cls.wEu = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        cls.ndG = C1853r.m3846Yz();
        cls.ndF = this.fVQ.field_toUser;
        cls.vFF = this.fileName;
        if (ut.fXh == 1) {
            cls.xjr = 2;
        }
        if (ut.fXk == 3) {
            cls.xjr = 3;
        }
        cls.wYj = ut.fXd;
        cls.wdl = C32856ab.m53750ch(C4996ah.getContext()) ? 1 : 2;
        cls.wEv = 2;
        cls.xjg = this.fVQ.field_thumbimgLength;
        cls.xjs = this.fVQ.field_fileId;
        cls.wxU = this.fVQ.field_fileId;
        cls.vRx = 1;
        if (this.fVQ.mo20809Jm()) {
            C4990ab.m7417i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s]", alb(), Boolean.valueOf(this.fVQ.field_upload_by_safecdn), Integer.valueOf(this.fVQ.field_UploadHitCacheType), Integer.valueOf(this.fVQ.field_filecrc), this.fVQ.field_aesKey);
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
            aae = C1831bh.aae();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<msgsource>");
            stringBuilder.append("<videopreloadlen>").append(this.fVP).append("</videopreloadlen>");
            stringBuilder.append("</msgsource>");
            C7060h.pYm.mo8378a(354, 35, 1, false);
            aae = stringBuilder.toString();
        }
        cls.vEG = aae;
        cls.xjD = ut.cMn;
        cfh cfh = ut.fXm;
        if (cfh != null && !C5046bo.isNullOrNil(cfh.fiG)) {
            cls.xjv = C5046bo.m7532bc(cfh.fiG, "");
            cls.xjw = cfh.wid;
            cls.xjx = C5046bo.m7532bc(cfh.fiI, "");
            cls.xjz = C5046bo.m7532bc(cfh.fiK, "");
            cls.xjy = C5046bo.m7532bc(cfh.fiJ, "");
            cls.xjA = C5046bo.m7532bc(cfh.fiL, "");
        } else if (!(cfh == null || C5046bo.isNullOrNil(cfh.fiK) || C5046bo.isNullOrNil(cfh.fiJ))) {
            cls.xjz = cfh.fiK;
            cls.xjy = cfh.fiJ;
        }
        if (cfh != null) {
            cls.xjC = C5046bo.m7532bc(cfh.fiM, "");
            cls.xjB = C5046bo.m7532bc(cfh.fiN, "");
        }
        C37961o.all();
        Options amj = C5056d.amj(C9720t.m17304ui(this.fileName));
        if (amj != null) {
            cls.xji = amj.outWidth;
            cls.xjh = amj.outHeight;
        } else {
            C4990ab.m7421w("MicroMsg.NetSceneUploadVideoForCdn", "cdntra getImageOptions for thumb failed path:%s", aae);
        }
        C37961o.all();
        aae = C9720t.m17303uh(this.fileName);
        C45459n alj = C45459n.alj();
        if (!C5046bo.isNullOrNil(aae)) {
            C42227a c42227a = (C42227a) alj.fWm.get(aae);
            if (c42227a != null) {
                i = c42227a.fWD;
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
                objArr[8] = C5046bo.anv(cls.wxW);
                objArr[9] = Integer.valueOf(cls.xjr);
                objArr[10] = cls.xju;
                objArr[11] = Integer.valueOf(cls.wWT);
                objArr[12] = Integer.valueOf(cls.vRy);
                objArr[13] = cls.xjE;
                objArr[14] = C5046bo.anv(cls.vRw);
                objArr[15] = cls.xjv;
                objArr[16] = Integer.valueOf(cls.xjw);
                objArr[17] = cls.xjx;
                objArr[18] = cls.xjA;
                objArr[19] = cls.vEG;
                objArr[20] = Integer.valueOf(cls.vRz);
                objArr[21] = Integer.valueOf(cls.vFH);
                C4990ab.m7417i(str, str2, objArr);
                a = mo4457a(c1902e, this.ehh, this);
                AppMethodBeat.m2505o(50711);
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
        objArr[8] = C5046bo.anv(cls.wxW);
        objArr[9] = Integer.valueOf(cls.xjr);
        objArr[10] = cls.xju;
        objArr[11] = Integer.valueOf(cls.wWT);
        objArr[12] = Integer.valueOf(cls.vRy);
        objArr[13] = cls.xjE;
        objArr[14] = C5046bo.anv(cls.vRw);
        objArr[15] = cls.xjv;
        objArr[16] = Integer.valueOf(cls.xjw);
        objArr[17] = cls.xjx;
        objArr[18] = cls.xjA;
        objArr[19] = cls.vEG;
        objArr[20] = Integer.valueOf(cls.vRz);
        objArr[21] = Integer.valueOf(cls.vFH);
        C4990ab.m7417i(str, str2, objArr);
        a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(50711);
        return a;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    public final int acn() {
        return 1;
    }

    /* renamed from: a */
    public final void mo4458a(C1205a c1205a) {
        AppMethodBeat.m2504i(50712);
        C26494u.m42261um(this.fileName);
        AppMethodBeat.m2505o(50712);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(50713);
        C4990ab.m7417i("MicroMsg.NetSceneUploadVideoForCdn", "%s cdntra onGYNetEnd errtype[%d %d]", alb(), Integer.valueOf(i2), Integer.valueOf(i3));
        clt clt = (clt) ((C7472b) c1929q).fsH.fsP;
        C26493s ut = C26494u.m42268ut(this.fileName);
        if (ut == null) {
            C4990ab.m7412e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
            this.ehi.onSceneEnd(i2, i3, str, this);
            this.fVR.mo39619cC(3, -1);
            AppMethodBeat.m2505o(50713);
        } else if (i2 == 4 && i3 == 102) {
            C4990ab.m7412e("MicroMsg.NetSceneUploadVideoForCdn", "summersafecdn ERR: MM_ERR_GET_AESKEY_FAILED errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + ut.getUser());
            this.ehi.onSceneEnd(i2, i3, str, this);
            this.fVR.mo39619cC(i2, i3);
            AppMethodBeat.m2505o(50713);
        } else if (i2 == 4 && i3 == -22) {
            C4990ab.m7412e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd BLACK  errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + ut.getUser());
            C26494u.m42262un(this.fileName);
            this.ehi.onSceneEnd(i2, i3, str, this);
            this.fVR.mo39619cC(i2, i3);
            AppMethodBeat.m2505o(50713);
        } else if (i2 == 4 && i3 != 0) {
            C4990ab.m7412e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd SERVER FAILED errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + ut.getUser());
            C26494u.m42261um(this.fileName);
            this.ehi.onSceneEnd(i2, i3, str, this);
            this.fVR.mo39619cC(i2, i3);
            AppMethodBeat.m2505o(50713);
        } else if (i2 == 0 && i3 == 0) {
            boolean z;
            ut.fXb = C5046bo.anT();
            ut.cKK = clt.ptF;
            C4990ab.m7417i("MicroMsg.NetSceneUploadVideoForCdn", "%s dkmsgid  set svrmsgid %d -> %d", alb(), Long.valueOf(ut.cKK), Integer.valueOf(C1947ae.giA));
            if (!(CdnLogic.kMediaTypeFavoriteBigFile != C1947ae.giz || C1947ae.giA == 0 || ut.cKK == 0)) {
                ut.cKK = (long) C1947ae.giA;
                C1947ae.giA = 0;
            }
            ut.status = 199;
            ut.bJt = 1284;
            if (this.fVQ.mo20809Jm()) {
                C4990ab.m7417i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn aeskey[%s], old RecvXml[%s]", alb(), clt.vRw, ut.alw());
                if (C5046bo.isNullOrNil(clt.vRw)) {
                    C4990ab.m7421w("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn need aeskey but ret null", alb());
                } else {
                    int i4;
                    C4990ab.m7417i("MicroMsg.NetSceneUploadVideoForCdn", "cdn callback new build cdnInfo:%s", ((("<msg><videomsg aeskey=\"" + clt.vRw + "\" cdnthumbaeskey=\"" + clt.vRw + "\" cdnvideourl=\"" + this.fVQ.field_fileId + "\" ") + "cdnthumburl=\"" + this.fVQ.field_fileId + "\" ") + "length=\"" + this.fVQ.field_fileLength + "\" ") + "cdnthumblength=\"" + this.fVQ.field_thumbimgLength + "\"/></msg>");
                    ut.fXj = r1;
                    C9720t all = C37961o.all();
                    C37961o.all();
                    boolean s = all.mo21062s(C9720t.m17303uh(this.fileName), this.fVQ.field_fileId, clt.vRw);
                    C7060h c7060h = C7060h.pYm;
                    Object[] objArr = new Object[2];
                    if (s) {
                        i4 = 1;
                    } else {
                        i4 = 2;
                    }
                    objArr[0] = Integer.valueOf(i4 + TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR);
                    objArr[1] = Integer.valueOf(ut.frO);
                    c7060h.mo8381e(12696, objArr);
                    C4990ab.m7417i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn aeskey[%s], new RecvXml[%s], saveret[%b]", alb(), clt.vRw, ut.alw(), Boolean.valueOf(s));
                }
            }
            C26494u.m42253f(ut);
            C26494u.m42247d(ut);
            C45457b.fRa.mo73265j(((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf((long) ut.fXe));
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(ut.getUser());
            if (aoO == null || ((int) aoO.ewQ) <= 0) {
                z = false;
            } else {
                z = aoO.dsf();
            }
            if (z || C1855t.m3943nl(ut.getUser())) {
                C4990ab.m7417i("MicroMsg.NetSceneUploadVideoForCdn", "%s upload to biz :%s", alb(), ut.getUser());
                if (ut.cKK < 0) {
                    C4990ab.m7412e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: finish video invaild MSGSVRID :" + ut.cKK + " file:" + this.fileName + " toUser:" + ut.getUser());
                    C26494u.m42261um(this.fileName);
                    this.fVR.mo39619cC(3, -1);
                }
            } else {
                C4990ab.m7417i("MicroMsg.NetSceneUploadVideoForCdn", "%s not upload to biz", alb());
                if (ut.cKK <= 0) {
                    C4990ab.m7412e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: finish video invaild MSGSVRID :" + ut.cKK + " file:" + this.fileName + " toUser:" + ut.getUser());
                    C26494u.m42261um(this.fileName);
                    this.fVR.mo39619cC(3, -1);
                }
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            this.fVR.mo39619cC(0, 0);
            AppMethodBeat.m2505o(50713);
        } else {
            C4990ab.m7412e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + ut.getUser());
            C26494u.m42261um(this.fileName);
            this.ehi.onSceneEnd(i2, i3, str, this);
            this.fVR.mo39619cC(i2, i3);
            AppMethodBeat.m2505o(50713);
        }
    }

    public final int getType() {
        return 149;
    }

    private String alb() {
        AppMethodBeat.m2504i(50714);
        String str = this.fileName + "_" + hashCode();
        AppMethodBeat.m2505o(50714);
        return str;
    }
}
