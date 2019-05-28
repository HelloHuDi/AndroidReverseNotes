package com.tencent.p177mm.pluginsdk.model.app;

import android.graphics.BitmapFactory.Options;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1831bh;
import com.tencent.p177mm.model.C1853r;
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
import com.tencent.p177mm.p181af.C1191k;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.p185a.C25754e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p230g.p231a.C18336n;
import com.tencent.p177mm.p230g.p231a.C18433vt;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.protocal.protobuf.C46534dv;
import com.tencent.p177mm.protocal.protobuf.bwb;
import com.tencent.p177mm.protocal.protobuf.bwc;
import com.tencent.p177mm.protocal.protobuf.cdg;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Locale;

/* renamed from: com.tencent.mm.pluginsdk.model.app.ag */
public final class C46492ag extends C1207m implements C1918k {
    private C7620bi cKd = null;
    private long cvx = 0;
    private C9545d eFt = null;
    private C7472b ehh;
    private C1202f ehi;
    private String hcl;
    private C18433vt qJq;
    private boolean vcA = false;
    private C46491a vcB = null;
    private C18336n vcw;
    private C30065b vcz = null;

    /* renamed from: com.tencent.mm.pluginsdk.model.app.ag$a */
    interface C46491a {
        /* renamed from: cC */
        void mo48315cC(int i, int i2);
    }

    public C46492ag(long j, boolean z, C9545d c9545d, C46491a c46491a, String str, C30065b c30065b) {
        AppMethodBeat.m2504i(27363);
        this.cvx = j;
        this.hcl = str;
        this.eFt = c9545d;
        this.vcB = c46491a;
        this.vcA = z;
        this.vcz = c30065b;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bwb();
        c1196a.fsK = new bwc();
        c1196a.uri = "/cgi-bin/micromsg-bin/sendappmsg";
        c1196a.fsI = 222;
        c1196a.fsL = 107;
        c1196a.fsM = 1000000107;
        this.ehh = c1196a.acD();
        C4990ab.m7417i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig NetSceneSendAppMsgForCdn msgId[%d], sceneResult[%s], sessionId[%s], attachInfo[%s]. stack[%s]", Long.valueOf(j), c9545d, str, c30065b, C5046bo.dpG());
        AppMethodBeat.m2505o(27363);
    }

    public final int getType() {
        return 222;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(27364);
        this.ehi = c1202f;
        C9638aw.m17190ZK();
        this.cKd = C18628c.m29080XO().mo15340jf(this.cvx);
        if (this.cKd == null || this.cKd.field_msgId != this.cvx) {
            C4990ab.m7413e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra doscene msginfo null id:%d", Long.valueOf(this.cvx));
            this.vcB.mo48315cC(3, -1);
            AppMethodBeat.m2505o(27364);
            return -1;
        }
        String str;
        int i;
        String string;
        C8910b me = C8910b.m16064me(this.cKd.field_content);
        if (me == null) {
            C4990ab.m7413e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra doscene AppMessage.Content.parse null id:%d", Long.valueOf(this.cvx));
            this.vcB.mo48315cC(3, -1);
        }
        bwb bwb = (bwb) this.ehh.fsG.fsP;
        C46534dv c46534dv = new C46534dv();
        c46534dv.fKh = me.appId;
        c46534dv.vFF = this.cKd.field_talker + this.cKd.field_msgId + "T" + this.cKd.field_createTime;
        c46534dv.pcX = (int) C5046bo.anT();
        c46534dv.ndF = this.cKd.field_talker;
        c46534dv.ndG = C1853r.m3846Yz();
        c46534dv.jCt = me.type;
        c46534dv.vFE = me.sdkVer;
        c46534dv.vFH = me.fgr;
        if (C17903f.m28103kq(this.cKd.field_talker)) {
            c46534dv.vEG = C25754e.m40909rw(this.cKd.dqJ);
        } else {
            c46534dv.vEG = C1831bh.aae();
        }
        c46534dv.vFJ = me.cMj;
        c46534dv.vFK = me.cMk;
        c46534dv.vFL = me.cMl;
        C32800b nV = C37922v.m64076Zp().mo60674nV(this.hcl);
        if (nV != null) {
            this.qJq = new C18433vt();
            this.qJq.cSG.url = me.url;
            this.qJq.cSG.cSH = nV.getString("prePublishId", "");
            this.qJq.cSG.cSJ = nV.getString("preUsername", "");
            this.qJq.cSG.cSK = nV.getString("preChatName", "");
            this.qJq.cSG.cSL = nV.getInt("preMsgIndex", 0);
            this.qJq.cSG.cSP = nV.getInt("sendAppMsgScene", 0);
            this.qJq.cSG.cSQ = nV.getInt("getA8KeyScene", 0);
            this.qJq.cSG.cSR = nV.getString("referUrl", null);
            this.qJq.cSG.cSS = nV.getString("adExtStr", null);
            this.qJq.cSG.cSM = this.cKd.field_talker;
            this.qJq.cSG.cST = me.title;
            C9638aw.m17190ZK();
            C7616ad aoO = C18628c.m29078XM().aoO(this.cKd.field_talker);
            if (aoO != null) {
                this.qJq.cSG.cSN = aoO.mo16706Oi();
            }
            this.qJq.cSG.cSO = C37921n.m64060mA(this.cKd.field_talker);
            str = "";
            if (me.cMn != null) {
                cdg cdg = new cdg();
                try {
                    cdg.parseFrom(Base64.decode(me.cMn, 0));
                    if (cdg.xcU != null) {
                        str = cdg.xcU.mVX;
                    }
                } catch (Exception e) {
                }
            }
            bwb.wWS = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[]{this.qJq.cSG.cSH, this.qJq.cSG.cSJ, this.qJq.cSG.cSK, Integer.valueOf(C32798u.m53583ad(this.qJq.cSG.cSJ, this.qJq.cSG.cSK)), Integer.valueOf(this.qJq.cSG.cSQ), str});
        }
        if (nV != null && me.type == 33) {
            this.vcw = new C18336n();
            i = nV.getInt("fromScene", 1);
            this.vcw.csr.scene = i;
            this.vcw.csr.bQe = nV.getInt("appservicetype", 0);
            string = nV.getString("preChatName", "");
            if (2 == i) {
                this.vcw.csr.cst = string + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + nV.getString("preUsername", "");
            } else {
                this.vcw.csr.cst = string;
            }
            str = this.cKd.field_talker;
            boolean z = nV.getBoolean("moreRetrAction", false);
            if (str.endsWith("@chatroom")) {
                this.vcw.csr.action = z ? 5 : 2;
            } else {
                this.vcw.csr.action = z ? 4 : 1;
            }
            this.vcw.csr.css = me.fiZ + 1;
            this.vcw.csr.csu = me.fiO;
            this.vcw.csr.csl = me.fiP;
            this.vcw.csr.appId = me.fiQ;
            this.vcw.csr.csw = C5046bo.anT();
            this.vcw.csr.csx = 1;
        }
        C4990ab.m7411d("MicroMsg.NetSceneSendAppMsgForCdn", "stev summerbig SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", me.cMj, me.cMk, me.cMl);
        int i2 = 0;
        i = 0;
        if (!C5046bo.isNullOrNil(this.cKd.field_imgPath)) {
            Options amj = C5056d.amj(C32291o.ahl().mo73119sj(this.cKd.field_imgPath));
            if (amj != null) {
                i2 = amj.outWidth;
                i = amj.outHeight;
            }
        }
        if (this.eFt.mo20809Jm()) {
            C4990ab.m7417i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn app sceneResult crc[%d], safecdn[%b], hitcachetype[%d], aeskey[%s]", Integer.valueOf(this.eFt.field_filecrc), Boolean.valueOf(this.eFt.field_upload_by_safecdn), Integer.valueOf(this.eFt.field_UploadHitCacheType), this.eFt.field_aesKey);
            this.eFt.field_aesKey = "";
            bwb.wWT = 1;
        }
        bwb.vRy = this.eFt.field_filecrc;
        string = null;
        if (this.vcA) {
            string = "@cdn_" + this.eFt.field_fileId + "_" + this.eFt.field_aesKey + "_1";
        }
        c46534dv.ncM = C8910b.m16062a(me, string, this.eFt, i2, i);
        bwb.wWQ = c46534dv;
        if (this.vcz != null && (me.fgs != 0 || me.fgo > 26214400)) {
            bwb.guQ = this.vcz.field_signature;
            bwb.vHo = C42129a.efE;
        }
        bwb.Md5 = me.filemd5;
        if (C5046bo.isNullOrNil(this.eFt.field_filemd5)) {
            C4990ab.m7417i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig sceneResult filemd5 is null use content.filemd5[%s]", me.filemd5);
        } else {
            bwb.Md5 = this.eFt.field_filemd5;
        }
        C4990ab.m7417i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig file md5[%s], HitMd5[%d], signature[%s], type[%d], sceneResult[%s], fromScene[%s]", bwb.Md5, Integer.valueOf(bwb.wWT), C5046bo.anv(bwb.guQ), Integer.valueOf(bwb.vHo), this.eFt, bwb.wWS);
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(27364);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(27365);
        bwb bwb = (bwb) ((C7472b) c1929q).fsG.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra onGYNetEnd [%d,%d,%s] msgId:%d, oldContent[%s], newContent[%s]", Integer.valueOf(i2), Integer.valueOf(i3), str, Long.valueOf(this.cvx), this.cKd.field_content, bwb.wWQ.ncM);
        if (i2 == 0 && i3 == 0) {
            bwc bwc = (bwc) ((C7472b) c1929q).fsH.fsP;
            C4990ab.m7417i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn svrid[%d]. aeskey[%s], old content[%s]", Long.valueOf(bwc.ptF), bwc.vRw, this.cKd.field_content);
            if (this.eFt != null && this.eFt.mo20809Jm()) {
                if (C5046bo.isNullOrNil(bwc.vRw)) {
                    C4990ab.m7420w("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn need aeskey but ret null");
                } else {
                    C8910b me = C8910b.m16064me(this.cKd.field_content);
                    me.eyr = bwc.vRw;
                    this.cKd.setContent(C8910b.m16061a(me, null, null));
                    C4990ab.m7417i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn aeskey[%s], new content[%s]", bwc.vRw, this.cKd.field_content);
                }
            }
            this.cKd.setStatus(2);
            this.cKd.mo14774eI(bwc.ptF);
            C9638aw.m17190ZK();
            C18628c.m29080XO().mo15284a(this.cKd.field_msgId, this.cKd);
            C45457b.fRa.mo73256a(this.cKd, C1191k.m2615k(this.cKd));
            this.ehi.onSceneEnd(i2, i3, str, this);
            this.vcB.mo48315cC(i2, i3);
            if (!(this.qJq == null || C5046bo.isNullOrNil(this.qJq.cSG.url))) {
                this.qJq.cSG.cSI = "msg_" + Long.toString(bwc.ptF);
                C4879a.xxA.mo10055m(this.qJq);
            }
            if (this.vcw != null) {
                this.vcw.csr.csv = "msg_" + this.cKd.field_msgSvrId;
                C4879a.xxA.mo10055m(this.vcw);
            }
            AppMethodBeat.m2505o(27365);
        } else if (i2 == 4 && i3 == 102) {
            C4990ab.m7420w("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn MM_ERR_GET_AESKEY_FAILED");
            this.ehi.onSceneEnd(i2, i3, str, this);
            this.vcB.mo48315cC(i2, i3);
            AppMethodBeat.m2505o(27365);
        } else {
            this.cKd.setStatus(5);
            C9638aw.m17190ZK();
            C18628c.m29080XO().mo15284a(this.cKd.field_msgId, this.cKd);
            C4990ab.m7412e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig send app msg failed, err=" + i2 + "," + i3);
            this.ehi.onSceneEnd(i2, i3, str, this);
            this.vcB.mo48315cC(i2, i3);
            AppMethodBeat.m2505o(27365);
        }
    }
}
