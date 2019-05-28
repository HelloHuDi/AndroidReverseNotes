package com.tencent.mm.pluginsdk.model.app;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.n;
import com.tencent.mm.g.a.vt;
import com.tencent.mm.g.a.vu;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bwb;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.cdg;
import com.tencent.mm.protocal.protobuf.dv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bi;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;
import junit.framework.Assert;

public final class af extends m implements k {
    bi cKd = null;
    long cvx = 0;
    private b ehh;
    f ehi;
    String fFa = "";
    private a fFk = new a() {
        public final int a(String str, int i, c cVar, final d dVar, boolean z) {
            AppMethodBeat.i(27359);
            ab.d("MicroMsg.NetSceneSendAppMsg", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", af.this.fFa, Integer.valueOf(i), cVar, dVar);
            if (i == -21005) {
                ab.d("MicroMsg.NetSceneSendAppMsg", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", af.this.fFa);
                AppMethodBeat.o(27359);
                return 0;
            } else if (i != 0) {
                af.this.cKd.setStatus(5);
                e.pXa.a(111, 34, 1, true);
                aw.ZK();
                com.tencent.mm.model.c.XO().a(af.this.cKd.field_msgId, af.this.cKd);
                new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.r(Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(af.this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), "")).ajK();
                af.this.ehi.onSceneEnd(3, i, "", af.this);
                AppMethodBeat.o(27359);
                return 0;
            } else {
                if (dVar != null) {
                    if (dVar.field_retCode != 0) {
                        ab.e("MicroMsg.NetSceneSendAppMsg", "cdntra sceneResult.retCode :%d arg[%s] info[%s]", Integer.valueOf(dVar.field_retCode), dVar.field_arg, dVar.field_transInfo, "", "", "", "", "", "", "", dVar.efY);
                        af.this.cKd.setStatus(5);
                        e.pXa.a(111, 34, 1, true);
                        aw.ZK();
                        com.tencent.mm.model.c.XO().a(af.this.cKd.field_msgId, af.this.cKd);
                        String r = com.tencent.mm.plugin.report.a.r(Integer.valueOf(dVar.field_retCode), Integer.valueOf(1), Long.valueOf(af.this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.efY);
                        new com.tencent.mm.g.b.a.f(r).ajK();
                        new com.tencent.mm.g.b.a.d(r).ajK();
                        af.this.ehi.onSceneEnd(3, dVar.field_retCode, "", af.this);
                    } else {
                        if (af.this.fVJ > 0 && dVar.field_fileLength > 0) {
                            ao.D("SendAppMsgThumbTooBig", af.this.fVJ + "," + dVar.field_fileLength + "," + dVar.field_fileId, af.this.fVJ * 2 > dVar.field_fileLength);
                        }
                        ab.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], aesKey[%s], md5[%s]", Integer.valueOf(dVar.field_UploadHitCacheType), Boolean.valueOf(z), Boolean.valueOf(dVar.field_exist_whencheck), bo.anv(dVar.field_aesKey), dVar.field_filemd5);
                        aw.Rg().a(new ag(af.this.cvx, false, dVar, new a() {
                            public final void cC(int i, int i2) {
                                AppMethodBeat.i(27358);
                                ab.d("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra NetSceneSendAppMsgForCdn callback %d,%d", Integer.valueOf(i), Integer.valueOf(i2));
                                new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.r(Integer.valueOf(i2), Integer.valueOf(1), Long.valueOf(af.this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(dVar.field_fileLength), dVar.field_transInfo, "", "", "", "", "", "", "", dVar.efY)).ajK();
                                af.this.ehi.onSceneEnd(i, i2, "", af.this);
                                AppMethodBeat.o(27358);
                            }
                        }, af.this.hcl, null), 0);
                    }
                }
                if (!(str == null || !str.equals(af.this.fFa) || af.this.qJr == null || af.this.qJr.cSV.cSW == -1)) {
                    com.tencent.mm.sdk.b.a.xxA.m(af.this.qJr);
                    af.this.qJr = null;
                }
                AppMethodBeat.o(27359);
                return 0;
            }
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] l(String str, byte[] bArr) {
            return null;
        }
    };
    int fVJ = 0;
    String hcl;
    private String mSignature;
    private vt qJq;
    vu qJr;
    long startTime = 0;
    private n vcw;

    public af(long j, String str, String str2) {
        AppMethodBeat.i(27360);
        this.cvx = j;
        this.hcl = str;
        this.mSignature = str2;
        b.a aVar = new b.a();
        aVar.fsJ = new bwb();
        aVar.fsK = new bwc();
        aVar.uri = "/cgi-bin/micromsg-bin/sendappmsg";
        aVar.fsI = 222;
        aVar.fsL = 107;
        aVar.fsM = 1000000107;
        this.ehh = aVar.acD();
        ab.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn NetSceneSendAppMsg msgid[%d], sessionid[%s], signature[%s], stack[%s]", Long.valueOf(j), str, bo.anv(str2), bo.dpG());
        AppMethodBeat.o(27360);
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(27361);
        this.ehi = fVar;
        if (this.startTime == 0) {
            this.startTime = bo.anU();
        }
        aw.ZK();
        this.cKd = com.tencent.mm.model.c.XO().jf(this.cvx);
        if (this.cKd == null || this.cKd.field_msgId != this.cvx) {
            AppMethodBeat.o(27361);
            return -1;
        }
        j.b bVar;
        j.b me = j.b.me(this.cKd.field_content);
        if (me == null) {
            ap aps = ap.aps(this.cKd.field_content);
            if (bo.isNullOrNil(aps.xXL)) {
                me = new j.b();
                me.fgq = aps.cvZ;
                me.type = 8;
                ab.i("MicroMsg.NetSceneSendAppMsg", "create new content. loss appid");
                bVar = me;
            } else {
                bVar = j.b.me(aps.xXL);
            }
        } else {
            bVar = me;
        }
        Assert.assertTrue("content != null [[" + this.cKd.field_content + "]]", bVar != null);
        if (bVar == null) {
            this.cKd = null;
            AppMethodBeat.o(27361);
            return -1;
        }
        String str;
        Object obj;
        String str2 = "";
        if (bo.isNullOrNil(this.cKd.field_imgPath)) {
            str = str2;
        } else {
            str = o.ahl().sj(this.cKd.field_imgPath);
        }
        v.b nU = v.Zp().nU(this.hcl);
        if (nU != null && nU.containsKey("_tmpl_webview_transfer_scene")) {
            this.qJr = new vu();
            this.qJr.cSV.cSW = nU.getInt("_tmpl_webview_transfer_scene", -1);
        }
        if (bVar.type == 8 || bVar.type == 9 || bVar.type == 6) {
            ab.i("MicroMsg.NetSceneSendAppMsg", "cdntra cdn not support Emoji or voiceremind now type:%d", Integer.valueOf(bVar.type));
            obj = null;
        } else if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.NetSceneSendAppMsg", "cdntra cdn not support no thumb msg type:%d", Integer.valueOf(bVar.type));
            obj = null;
        } else {
            this.fVJ = com.tencent.mm.a.e.cs(str);
            obj = (bVar.type == 33 || bVar.type == 36 || bVar.type == 46 || bVar.type == 44) ? 1 : null;
            if (obj != null || this.fVJ < 262144) {
                ab.i("MicroMsg.NetSceneSendAppMsg", "cdntra content.type:%d  thumbPath:%s,  thumbLength:%d ", Integer.valueOf(bVar.type), str, Integer.valueOf(this.fVJ));
                if (bo.isNullOrNil(bVar.csD)) {
                    if (obj == null) {
                        com.tencent.mm.al.f.afx();
                        if (!com.tencent.mm.al.b.lg(4)) {
                            Object[] objArr = new Object[1];
                            com.tencent.mm.al.f.afx();
                            objArr[0] = Boolean.valueOf(com.tencent.mm.al.b.lg(4));
                            ab.w("MicroMsg.NetSceneSendAppMsg", "cdntra not use cdn flag:%b ", objArr);
                            obj = null;
                        }
                    }
                    this.fFa = com.tencent.mm.al.c.a("upappmsg", this.cKd.field_createTime, this.cKd.field_talker, this.cKd.field_msgId);
                    if (bo.isNullOrNil(this.fFa)) {
                        ab.w("MicroMsg.NetSceneSendAppMsg", "cdntra genClientId failed not use cdn msgid:%d", Long.valueOf(this.cKd.field_msgId));
                        obj = null;
                    } else {
                        g gVar = new g();
                        gVar.egl = this.fFk;
                        gVar.field_mediaId = this.fFa;
                        gVar.field_fullpath = "";
                        gVar.field_thumbpath = str;
                        gVar.field_fileType = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
                        gVar.field_talker = this.cKd.field_talker;
                        gVar.field_priority = com.tencent.mm.i.a.efC;
                        gVar.field_needStorage = false;
                        gVar.field_isStreamMedia = false;
                        gVar.egl = this.fFk;
                        gVar.field_force_aeskeycdn = true;
                        gVar.field_trysafecdn = false;
                        ab.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra checkUseCdn content.type[%d], thumb[%s], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b], force_aeskeycdn[%b], trysafecdn[%b]", Integer.valueOf(bVar.type), str, this.fFa, Integer.valueOf(gVar.field_fileType), Boolean.valueOf(gVar.field_enable_hitcheck), Boolean.valueOf(gVar.field_onlycheckexist), Boolean.valueOf(gVar.field_force_aeskeycdn), Boolean.valueOf(gVar.field_trysafecdn));
                        if (com.tencent.mm.al.f.afx().e(gVar)) {
                            obj = 1;
                        } else {
                            ab.e("MicroMsg.NetSceneSendAppMsg", "cdntra addSendTask failed.");
                            this.fFa = "";
                            obj = null;
                        }
                    }
                } else {
                    ab.w("MicroMsg.NetSceneSendAppMsg", "cdntra attach has been upload by cdn msgid:%d", Long.valueOf(this.cvx));
                    obj = null;
                }
            } else {
                ab.w("MicroMsg.NetSceneSendAppMsg", "cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", str, Integer.valueOf(this.fVJ));
                obj = null;
            }
        }
        if (obj != null) {
            ab.d("MicroMsg.NetSceneSendAppMsg", "cdntra use cdn return -1 for onGYNetEnd clientId:%s", this.fFa);
            AppMethodBeat.o(27361);
            return 0;
        }
        String str3;
        bwb bwb = (bwb) this.ehh.fsG.fsP;
        dv dvVar = new dv();
        dvVar.fKh = bVar.appId;
        dvVar.vFF = this.cKd.field_talker + this.cKd.field_msgId + "T" + this.cKd.field_createTime;
        dvVar.ncM = j.b.a(bVar, null, null, 0, 0);
        dvVar.pcX = (int) bo.anT();
        dvVar.ndF = this.cKd.field_talker;
        dvVar.ndG = r.Yz();
        dvVar.jCt = bVar.type;
        dvVar.vFE = bVar.sdkVer;
        dvVar.vFH = bVar.fgr;
        if (com.tencent.mm.aj.f.kq(this.cKd.field_talker)) {
            dvVar.vEG = com.tencent.mm.aj.a.e.rw(this.cKd.dqJ);
        } else {
            dvVar.vEG = bh.aae();
        }
        dvVar.vFJ = bVar.cMj;
        dvVar.vFK = bVar.cMk;
        dvVar.vFL = bVar.cMl;
        v.b nV = v.Zp().nV(this.hcl);
        if (nV != null) {
            this.qJq = new vt();
            this.qJq.cSG.url = bVar.url;
            this.qJq.cSG.cSH = nV.getString("prePublishId", "");
            this.qJq.cSG.cSJ = nV.getString("preUsername", "");
            this.qJq.cSG.cSK = nV.getString("preChatName", "");
            this.qJq.cSG.cSL = nV.getInt("preMsgIndex", 0);
            this.qJq.cSG.cSP = nV.getInt("sendAppMsgScene", 0);
            this.qJq.cSG.cSQ = nV.getInt("getA8KeyScene", 0);
            this.qJq.cSG.cSR = nV.getString("referUrl", null);
            this.qJq.cSG.cSS = nV.getString("adExtStr", null);
            this.qJq.cSG.cSM = this.cKd.field_talker;
            this.qJq.cSG.cST = bVar.title;
            aw.ZK();
            ad aoO = com.tencent.mm.model.c.XM().aoO(this.cKd.field_talker);
            if (aoO != null) {
                this.qJq.cSG.cSN = aoO.Oi();
            }
            this.qJq.cSG.cSO = com.tencent.mm.model.n.mA(this.cKd.field_talker);
            str3 = "";
            if (bVar.cMn != null) {
                cdg cdg = new cdg();
                try {
                    cdg.parseFrom(Base64.decode(bVar.cMn, 0));
                    if (cdg.xcU != null) {
                        str3 = cdg.xcU.mVX;
                    }
                } catch (Exception e) {
                }
            }
            bwb.wWS = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[]{this.qJq.cSG.cSH, this.qJq.cSG.cSJ, this.qJq.cSG.cSK, Integer.valueOf(u.ad(this.qJq.cSG.cSJ, this.qJq.cSG.cSK)), Integer.valueOf(this.qJq.cSG.cSQ), str3});
        }
        if (nV != null && bVar.type == 33) {
            this.vcw = new n();
            int i = nV.getInt("fromScene", 1);
            this.vcw.csr.scene = i;
            this.vcw.csr.bQe = nV.getInt("appservicetype", 0);
            String string = nV.getString("preChatName", "");
            if (2 == i) {
                this.vcw.csr.cst = string + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + nV.getString("preUsername", "");
            } else {
                this.vcw.csr.cst = string;
            }
            str3 = this.cKd.field_talker;
            boolean z = nV.getBoolean("moreRetrAction", false);
            if (str3.endsWith("@chatroom")) {
                this.vcw.csr.action = z ? 5 : 2;
            } else {
                this.vcw.csr.action = z ? 4 : 1;
            }
            this.vcw.csr.css = bVar.fiZ + 1;
            this.vcw.csr.csu = bVar.fiO;
            this.vcw.csr.csl = bVar.fiP;
            this.vcw.csr.appId = bVar.fiQ;
            this.vcw.csr.csw = bo.anT();
            this.vcw.csr.csx = 1;
        }
        ab.d("MicroMsg.NetSceneSendAppMsg", "SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", bVar.cMj, bVar.cMk, bVar.cMl);
        if (!bo.isNullOrNil(str)) {
            byte[] e2 = com.tencent.mm.a.e.e(str, 0, -1);
            if (!bo.cb(e2)) {
                dvVar.vFG = new SKBuiltinBuffer_t().setBuffer(e2);
            }
        }
        str3 = "MicroMsg.NetSceneSendAppMsg";
        String str4 = "doScene thumbFile:[%s] thumbdata:%d";
        Object[] objArr2 = new Object[2];
        objArr2[0] = str;
        objArr2[1] = Integer.valueOf(dvVar.vFG != null ? dvVar.vFG.getILen() : -1);
        ab.d(str3, str4, objArr2);
        bwb.wWQ = dvVar;
        if (bVar.fgs != 0 || bVar.fgo > 26214400) {
            bwb.vHo = com.tencent.mm.i.a.efE;
        }
        bwb.Md5 = bVar.filemd5;
        bwb.guQ = this.mSignature;
        ab.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn file md5[%s], signature[%s], type[%d], fromScene[%s]", bwb.Md5, bo.anv(bwb.guQ), Integer.valueOf(bwb.vHo), bwb.wWS);
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(27361);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(27362);
        ab.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra onGYNetEnd [%d,%d,%s] msgId:%d, oldContent[%s]", Integer.valueOf(i2), Integer.valueOf(i3), str, Long.valueOf(this.cvx), this.cKd.field_content);
        if (i2 == 3 && i3 == -1 && !bo.isNullOrNil(this.fFa)) {
            ab.w("MicroMsg.NetSceneSendAppMsg", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.fFa);
            AppMethodBeat.o(27362);
        } else if (i2 == 0 && i3 == 0) {
            bwc bwc = (bwc) ((b) qVar).fsH.fsP;
            bwb bwb = (bwb) ((b) qVar).fsG.fsP;
            this.cKd.setStatus(2);
            this.cKd.eI(bwc.ptF);
            aw.ZK();
            com.tencent.mm.model.c.XO().a(this.cKd.field_msgId, this.cKd);
            com.tencent.mm.modelstat.b.fRa.a(this.cKd, com.tencent.mm.af.k.k(this.cKd));
            if (!(this.qJq == null || bo.isNullOrNil(this.qJq.cSG.url))) {
                this.qJq.cSG.cSI = "msg_" + Long.toString(bwc.ptF);
                com.tencent.mm.sdk.b.a.xxA.m(this.qJq);
            }
            if (!(this.qJr == null || this.qJr.cSV.cSW == -1)) {
                com.tencent.mm.sdk.b.a.xxA.m(this.qJr);
            }
            j.b me = j.b.me(this.cKd.field_content);
            if (me != null && "wx4310bbd51be7d979".equals(me.appId)) {
                Object obj = (bo.isNullOrNil(this.cKd.field_talker) || !t.kH(this.cKd.field_talker)) ? null : 1;
                String str2 = "";
                try {
                    str2 = URLEncoder.encode(me.description, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    ab.printErrStackTrace("MicroMsg.NetSceneSendAppMsg", e, "", new Object[0]);
                }
                ab.i("MicroMsg.NetSceneSendAppMsg", "androidSystemShareFixed(13717) %s", "1," + (obj != null ? 2 : 1) + ",," + str2);
                h.pYm.X(13717, r0);
            }
            if (this.vcw != null) {
                this.vcw.csr.csv = "msg_" + this.cKd.field_msgSvrId;
                com.tencent.mm.sdk.b.a.xxA.m(this.vcw);
            }
            if (bwb.wWQ.vFG != null) {
                h.pYm.e(10420, Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(bwb.wWQ.vFG.getILen()));
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(27362);
        } else {
            this.cKd.setStatus(5);
            e.pXa.a(111, 34, 1, true);
            aw.ZK();
            com.tencent.mm.model.c.XO().a(this.cKd.field_msgId, this.cKd);
            ab.e("MicroMsg.NetSceneSendAppMsg", "send app msg failed, err=" + i2 + "," + i3 + ", msgId " + this.cKd.field_msgId);
            if (i2 == 4) {
                h.pYm.e(10420, Integer.valueOf(i3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(0));
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(27362);
        }
    }

    public final int getType() {
        return 222;
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }
}
