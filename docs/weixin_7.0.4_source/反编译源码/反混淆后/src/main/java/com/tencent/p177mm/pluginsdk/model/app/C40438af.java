package com.tencent.p177mm.pluginsdk.model.app;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1831bh;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C32798u;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelstat.C45457b;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p181af.C1191k;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.p185a.C25754e;
import com.tencent.p177mm.p187al.C31259b;
import com.tencent.p177mm.p187al.C37458c;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p230g.p231a.C18336n;
import com.tencent.p177mm.p230g.p231a.C18433vt;
import com.tencent.p177mm.p230g.p231a.C26265vu;
import com.tencent.p177mm.p230g.p232b.p233a.C42099d;
import com.tencent.p177mm.p230g.p232b.p233a.C9514f;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.app.C46492ag.C46491a;
import com.tencent.p177mm.protocal.protobuf.C46534dv;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.bwb;
import com.tencent.p177mm.protocal.protobuf.bwc;
import com.tencent.p177mm.protocal.protobuf.cdg;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5013ao;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C44218ap;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.pluginsdk.model.app.af */
public final class C40438af extends C1207m implements C1918k {
    C7620bi cKd = null;
    long cvx = 0;
    private C7472b ehh;
    C1202f ehi;
    String fFa = "";
    private C1628a fFk = new C300531();
    int fVJ = 0;
    String hcl;
    private String mSignature;
    private C18433vt qJq;
    C26265vu qJr;
    long startTime = 0;
    private C18336n vcw;

    /* renamed from: com.tencent.mm.pluginsdk.model.app.af$1 */
    class C300531 implements C1628a {
        C300531() {
        }

        /* renamed from: a */
        public final int mo5082a(String str, int i, C18496c c18496c, final C9545d c9545d, boolean z) {
            AppMethodBeat.m2504i(27359);
            C4990ab.m7411d("MicroMsg.NetSceneSendAppMsg", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", C40438af.this.fFa, Integer.valueOf(i), c18496c, c9545d);
            if (i == -21005) {
                C4990ab.m7411d("MicroMsg.NetSceneSendAppMsg", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", C40438af.this.fFa);
                AppMethodBeat.m2505o(27359);
                return 0;
            } else if (i != 0) {
                C40438af.this.cKd.setStatus(5);
                C7053e.pXa.mo8378a(111, 34, 1, true);
                C9638aw.m17190ZK();
                C18628c.m29080XO().mo15284a(C40438af.this.cKd.field_msgId, C40438af.this.cKd);
                new C9514f(C46180a.m86311r(Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(C40438af.this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(C42129a.MediaType_FILE), Integer.valueOf(0), "")).ajK();
                C40438af.this.ehi.onSceneEnd(3, i, "", C40438af.this);
                AppMethodBeat.m2505o(27359);
                return 0;
            } else {
                if (c9545d != null) {
                    if (c9545d.field_retCode != 0) {
                        C4990ab.m7413e("MicroMsg.NetSceneSendAppMsg", "cdntra sceneResult.retCode :%d arg[%s] info[%s]", Integer.valueOf(c9545d.field_retCode), c9545d.field_arg, c9545d.field_transInfo, "", "", "", "", "", "", "", c9545d.efY);
                        C40438af.this.cKd.setStatus(5);
                        C7053e.pXa.mo8378a(111, 34, 1, true);
                        C9638aw.m17190ZK();
                        C18628c.m29080XO().mo15284a(C40438af.this.cKd.field_msgId, C40438af.this.cKd);
                        String r = C46180a.m86311r(Integer.valueOf(c9545d.field_retCode), Integer.valueOf(1), Long.valueOf(C40438af.this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(C42129a.MediaType_FILE), Integer.valueOf(c9545d.field_fileLength), c9545d.field_transInfo, "", "", "", "", "", "", "", c9545d.efY);
                        new C9514f(r).ajK();
                        new C42099d(r).ajK();
                        C40438af.this.ehi.onSceneEnd(3, c9545d.field_retCode, "", C40438af.this);
                    } else {
                        if (C40438af.this.fVJ > 0 && c9545d.field_fileLength > 0) {
                            C5013ao.m7453D("SendAppMsgThumbTooBig", C40438af.this.fVJ + "," + c9545d.field_fileLength + "," + c9545d.field_fileId, C40438af.this.fVJ * 2 > c9545d.field_fileLength);
                        }
                        C4990ab.m7417i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], aesKey[%s], md5[%s]", Integer.valueOf(c9545d.field_UploadHitCacheType), Boolean.valueOf(z), Boolean.valueOf(c9545d.field_exist_whencheck), C5046bo.anv(c9545d.field_aesKey), c9545d.field_filemd5);
                        C9638aw.m17182Rg().mo14541a(new C46492ag(C40438af.this.cvx, false, c9545d, new C46491a() {
                            /* renamed from: cC */
                            public final void mo48315cC(int i, int i2) {
                                AppMethodBeat.m2504i(27358);
                                C4990ab.m7411d("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra NetSceneSendAppMsgForCdn callback %d,%d", Integer.valueOf(i), Integer.valueOf(i2));
                                new C9514f(C46180a.m86311r(Integer.valueOf(i2), Integer.valueOf(1), Long.valueOf(C40438af.this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(C42129a.MediaType_FILE), Integer.valueOf(c9545d.field_fileLength), c9545d.field_transInfo, "", "", "", "", "", "", "", c9545d.efY)).ajK();
                                C40438af.this.ehi.onSceneEnd(i, i2, "", C40438af.this);
                                AppMethodBeat.m2505o(27358);
                            }
                        }, C40438af.this.hcl, null), 0);
                    }
                }
                if (!(str == null || !str.equals(C40438af.this.fFa) || C40438af.this.qJr == null || C40438af.this.qJr.cSV.cSW == -1)) {
                    C4879a.xxA.mo10055m(C40438af.this.qJr);
                    C40438af.this.qJr = null;
                }
                AppMethodBeat.m2505o(27359);
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

    public C40438af(long j, String str, String str2) {
        AppMethodBeat.m2504i(27360);
        this.cvx = j;
        this.hcl = str;
        this.mSignature = str2;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bwb();
        c1196a.fsK = new bwc();
        c1196a.uri = "/cgi-bin/micromsg-bin/sendappmsg";
        c1196a.fsI = 222;
        c1196a.fsL = 107;
        c1196a.fsM = 1000000107;
        this.ehh = c1196a.acD();
        C4990ab.m7417i("MicroMsg.NetSceneSendAppMsg", "summersafecdn NetSceneSendAppMsg msgid[%d], sessionid[%s], signature[%s], stack[%s]", Long.valueOf(j), str, C5046bo.anv(str2), C5046bo.dpG());
        AppMethodBeat.m2505o(27360);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(27361);
        this.ehi = c1202f;
        if (this.startTime == 0) {
            this.startTime = C5046bo.anU();
        }
        C9638aw.m17190ZK();
        this.cKd = C18628c.m29080XO().mo15340jf(this.cvx);
        if (this.cKd == null || this.cKd.field_msgId != this.cvx) {
            AppMethodBeat.m2505o(27361);
            return -1;
        }
        C8910b c8910b;
        C8910b me = C8910b.m16064me(this.cKd.field_content);
        if (me == null) {
            C44218ap aps = C44218ap.aps(this.cKd.field_content);
            if (C5046bo.isNullOrNil(aps.xXL)) {
                me = new C8910b();
                me.fgq = aps.cvZ;
                me.type = 8;
                C4990ab.m7416i("MicroMsg.NetSceneSendAppMsg", "create new content. loss appid");
                c8910b = me;
            } else {
                c8910b = C8910b.m16064me(aps.xXL);
            }
        } else {
            c8910b = me;
        }
        Assert.assertTrue("content != null [[" + this.cKd.field_content + "]]", c8910b != null);
        if (c8910b == null) {
            this.cKd = null;
            AppMethodBeat.m2505o(27361);
            return -1;
        }
        String str;
        Object obj;
        String str2 = "";
        if (C5046bo.isNullOrNil(this.cKd.field_imgPath)) {
            str = str2;
        } else {
            str = C32291o.ahl().mo73119sj(this.cKd.field_imgPath);
        }
        C32800b nU = C37922v.m64076Zp().mo60673nU(this.hcl);
        if (nU != null && nU.containsKey("_tmpl_webview_transfer_scene")) {
            this.qJr = new C26265vu();
            this.qJr.cSV.cSW = nU.getInt("_tmpl_webview_transfer_scene", -1);
        }
        if (c8910b.type == 8 || c8910b.type == 9 || c8910b.type == 6) {
            C4990ab.m7417i("MicroMsg.NetSceneSendAppMsg", "cdntra cdn not support Emoji or voiceremind now type:%d", Integer.valueOf(c8910b.type));
            obj = null;
        } else if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7417i("MicroMsg.NetSceneSendAppMsg", "cdntra cdn not support no thumb msg type:%d", Integer.valueOf(c8910b.type));
            obj = null;
        } else {
            this.fVJ = C1173e.m2560cs(str);
            obj = (c8910b.type == 33 || c8910b.type == 36 || c8910b.type == 46 || c8910b.type == 44) ? 1 : null;
            if (obj != null || this.fVJ < 262144) {
                C4990ab.m7417i("MicroMsg.NetSceneSendAppMsg", "cdntra content.type:%d  thumbPath:%s,  thumbLength:%d ", Integer.valueOf(c8910b.type), str, Integer.valueOf(this.fVJ));
                if (C5046bo.isNullOrNil(c8910b.csD)) {
                    if (obj == null) {
                        C37461f.afx();
                        if (!C31259b.m50439lg(4)) {
                            Object[] objArr = new Object[1];
                            C37461f.afx();
                            objArr[0] = Boolean.valueOf(C31259b.m50439lg(4));
                            C4990ab.m7421w("MicroMsg.NetSceneSendAppMsg", "cdntra not use cdn flag:%b ", objArr);
                            obj = null;
                        }
                    }
                    this.fFa = C37458c.m63162a("upappmsg", this.cKd.field_createTime, this.cKd.field_talker, this.cKd.field_msgId);
                    if (C5046bo.isNullOrNil(this.fFa)) {
                        C4990ab.m7421w("MicroMsg.NetSceneSendAppMsg", "cdntra genClientId failed not use cdn msgid:%d", Long.valueOf(this.cKd.field_msgId));
                        obj = null;
                    } else {
                        C42130g c42130g = new C42130g();
                        c42130g.egl = this.fFk;
                        c42130g.field_mediaId = this.fFa;
                        c42130g.field_fullpath = "";
                        c42130g.field_thumbpath = str;
                        c42130g.field_fileType = C42129a.MediaType_THUMBIMAGE;
                        c42130g.field_talker = this.cKd.field_talker;
                        c42130g.field_priority = C42129a.efC;
                        c42130g.field_needStorage = false;
                        c42130g.field_isStreamMedia = false;
                        c42130g.egl = this.fFk;
                        c42130g.field_force_aeskeycdn = true;
                        c42130g.field_trysafecdn = false;
                        C4990ab.m7417i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra checkUseCdn content.type[%d], thumb[%s], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b], force_aeskeycdn[%b], trysafecdn[%b]", Integer.valueOf(c8910b.type), str, this.fFa, Integer.valueOf(c42130g.field_fileType), Boolean.valueOf(c42130g.field_enable_hitcheck), Boolean.valueOf(c42130g.field_onlycheckexist), Boolean.valueOf(c42130g.field_force_aeskeycdn), Boolean.valueOf(c42130g.field_trysafecdn));
                        if (C37461f.afx().mo51225e(c42130g)) {
                            obj = 1;
                        } else {
                            C4990ab.m7412e("MicroMsg.NetSceneSendAppMsg", "cdntra addSendTask failed.");
                            this.fFa = "";
                            obj = null;
                        }
                    }
                } else {
                    C4990ab.m7421w("MicroMsg.NetSceneSendAppMsg", "cdntra attach has been upload by cdn msgid:%d", Long.valueOf(this.cvx));
                    obj = null;
                }
            } else {
                C4990ab.m7421w("MicroMsg.NetSceneSendAppMsg", "cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", str, Integer.valueOf(this.fVJ));
                obj = null;
            }
        }
        if (obj != null) {
            C4990ab.m7411d("MicroMsg.NetSceneSendAppMsg", "cdntra use cdn return -1 for onGYNetEnd clientId:%s", this.fFa);
            AppMethodBeat.m2505o(27361);
            return 0;
        }
        String str3;
        bwb bwb = (bwb) this.ehh.fsG.fsP;
        C46534dv c46534dv = new C46534dv();
        c46534dv.fKh = c8910b.appId;
        c46534dv.vFF = this.cKd.field_talker + this.cKd.field_msgId + "T" + this.cKd.field_createTime;
        c46534dv.ncM = C8910b.m16062a(c8910b, null, null, 0, 0);
        c46534dv.pcX = (int) C5046bo.anT();
        c46534dv.ndF = this.cKd.field_talker;
        c46534dv.ndG = C1853r.m3846Yz();
        c46534dv.jCt = c8910b.type;
        c46534dv.vFE = c8910b.sdkVer;
        c46534dv.vFH = c8910b.fgr;
        if (C17903f.m28103kq(this.cKd.field_talker)) {
            c46534dv.vEG = C25754e.m40909rw(this.cKd.dqJ);
        } else {
            c46534dv.vEG = C1831bh.aae();
        }
        c46534dv.vFJ = c8910b.cMj;
        c46534dv.vFK = c8910b.cMk;
        c46534dv.vFL = c8910b.cMl;
        C32800b nV = C37922v.m64076Zp().mo60674nV(this.hcl);
        if (nV != null) {
            this.qJq = new C18433vt();
            this.qJq.cSG.url = c8910b.url;
            this.qJq.cSG.cSH = nV.getString("prePublishId", "");
            this.qJq.cSG.cSJ = nV.getString("preUsername", "");
            this.qJq.cSG.cSK = nV.getString("preChatName", "");
            this.qJq.cSG.cSL = nV.getInt("preMsgIndex", 0);
            this.qJq.cSG.cSP = nV.getInt("sendAppMsgScene", 0);
            this.qJq.cSG.cSQ = nV.getInt("getA8KeyScene", 0);
            this.qJq.cSG.cSR = nV.getString("referUrl", null);
            this.qJq.cSG.cSS = nV.getString("adExtStr", null);
            this.qJq.cSG.cSM = this.cKd.field_talker;
            this.qJq.cSG.cST = c8910b.title;
            C9638aw.m17190ZK();
            C7616ad aoO = C18628c.m29078XM().aoO(this.cKd.field_talker);
            if (aoO != null) {
                this.qJq.cSG.cSN = aoO.mo16706Oi();
            }
            this.qJq.cSG.cSO = C37921n.m64060mA(this.cKd.field_talker);
            str3 = "";
            if (c8910b.cMn != null) {
                cdg cdg = new cdg();
                try {
                    cdg.parseFrom(Base64.decode(c8910b.cMn, 0));
                    if (cdg.xcU != null) {
                        str3 = cdg.xcU.mVX;
                    }
                } catch (Exception e) {
                }
            }
            bwb.wWS = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[]{this.qJq.cSG.cSH, this.qJq.cSG.cSJ, this.qJq.cSG.cSK, Integer.valueOf(C32798u.m53583ad(this.qJq.cSG.cSJ, this.qJq.cSG.cSK)), Integer.valueOf(this.qJq.cSG.cSQ), str3});
        }
        if (nV != null && c8910b.type == 33) {
            this.vcw = new C18336n();
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
            this.vcw.csr.css = c8910b.fiZ + 1;
            this.vcw.csr.csu = c8910b.fiO;
            this.vcw.csr.csl = c8910b.fiP;
            this.vcw.csr.appId = c8910b.fiQ;
            this.vcw.csr.csw = C5046bo.anT();
            this.vcw.csr.csx = 1;
        }
        C4990ab.m7411d("MicroMsg.NetSceneSendAppMsg", "SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", c8910b.cMj, c8910b.cMk, c8910b.cMl);
        if (!C5046bo.isNullOrNil(str)) {
            byte[] e2 = C1173e.m2569e(str, 0, -1);
            if (!C5046bo.m7540cb(e2)) {
                c46534dv.vFG = new SKBuiltinBuffer_t().setBuffer(e2);
            }
        }
        str3 = "MicroMsg.NetSceneSendAppMsg";
        String str4 = "doScene thumbFile:[%s] thumbdata:%d";
        Object[] objArr2 = new Object[2];
        objArr2[0] = str;
        objArr2[1] = Integer.valueOf(c46534dv.vFG != null ? c46534dv.vFG.getILen() : -1);
        C4990ab.m7411d(str3, str4, objArr2);
        bwb.wWQ = c46534dv;
        if (c8910b.fgs != 0 || c8910b.fgo > 26214400) {
            bwb.vHo = C42129a.efE;
        }
        bwb.Md5 = c8910b.filemd5;
        bwb.guQ = this.mSignature;
        C4990ab.m7417i("MicroMsg.NetSceneSendAppMsg", "summersafecdn file md5[%s], signature[%s], type[%d], fromScene[%s]", bwb.Md5, C5046bo.anv(bwb.guQ), Integer.valueOf(bwb.vHo), bwb.wWS);
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(27361);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(27362);
        C4990ab.m7417i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra onGYNetEnd [%d,%d,%s] msgId:%d, oldContent[%s]", Integer.valueOf(i2), Integer.valueOf(i3), str, Long.valueOf(this.cvx), this.cKd.field_content);
        if (i2 == 3 && i3 == -1 && !C5046bo.isNullOrNil(this.fFa)) {
            C4990ab.m7421w("MicroMsg.NetSceneSendAppMsg", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.fFa);
            AppMethodBeat.m2505o(27362);
        } else if (i2 == 0 && i3 == 0) {
            bwc bwc = (bwc) ((C7472b) c1929q).fsH.fsP;
            bwb bwb = (bwb) ((C7472b) c1929q).fsG.fsP;
            this.cKd.setStatus(2);
            this.cKd.mo14774eI(bwc.ptF);
            C9638aw.m17190ZK();
            C18628c.m29080XO().mo15284a(this.cKd.field_msgId, this.cKd);
            C45457b.fRa.mo73256a(this.cKd, C1191k.m2615k(this.cKd));
            if (!(this.qJq == null || C5046bo.isNullOrNil(this.qJq.cSG.url))) {
                this.qJq.cSG.cSI = "msg_" + Long.toString(bwc.ptF);
                C4879a.xxA.mo10055m(this.qJq);
            }
            if (!(this.qJr == null || this.qJr.cSV.cSW == -1)) {
                C4879a.xxA.mo10055m(this.qJr);
            }
            C8910b me = C8910b.m16064me(this.cKd.field_content);
            if (me != null && "wx4310bbd51be7d979".equals(me.appId)) {
                Object obj = (C5046bo.isNullOrNil(this.cKd.field_talker) || !C1855t.m3896kH(this.cKd.field_talker)) ? null : 1;
                String str2 = "";
                try {
                    str2 = URLEncoder.encode(me.description, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    C4990ab.printErrStackTrace("MicroMsg.NetSceneSendAppMsg", e, "", new Object[0]);
                }
                C4990ab.m7417i("MicroMsg.NetSceneSendAppMsg", "androidSystemShareFixed(13717) %s", "1," + (obj != null ? 2 : 1) + ",," + str2);
                C7060h.pYm.mo8374X(13717, r0);
            }
            if (this.vcw != null) {
                this.vcw.csr.csv = "msg_" + this.cKd.field_msgSvrId;
                C4879a.xxA.mo10055m(this.vcw);
            }
            if (bwb.wWQ.vFG != null) {
                C7060h.pYm.mo8381e(10420, Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(C42129a.MediaType_THUMBIMAGE), Integer.valueOf(bwb.wWQ.vFG.getILen()));
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(27362);
        } else {
            this.cKd.setStatus(5);
            C7053e.pXa.mo8378a(111, 34, 1, true);
            C9638aw.m17190ZK();
            C18628c.m29080XO().mo15284a(this.cKd.field_msgId, this.cKd);
            C4990ab.m7412e("MicroMsg.NetSceneSendAppMsg", "send app msg failed, err=" + i2 + "," + i3 + ", msgId " + this.cKd.field_msgId);
            if (i2 == 4) {
                C7060h.pYm.mo8381e(10420, Integer.valueOf(i3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(C42129a.MediaType_THUMBIMAGE), Integer.valueOf(0));
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(27362);
        }
    }

    public final int getType() {
        return 222;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }
}
