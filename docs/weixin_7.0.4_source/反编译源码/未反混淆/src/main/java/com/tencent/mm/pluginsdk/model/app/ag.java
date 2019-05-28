package com.tencent.mm.pluginsdk.model.app;

import android.graphics.BitmapFactory.Options;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.n;
import com.tencent.mm.g.a.vt;
import com.tencent.mm.i.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bwb;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.cdg;
import com.tencent.mm.protocal.protobuf.dv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Locale;

public final class ag extends m implements k {
    private bi cKd = null;
    private long cvx = 0;
    private d eFt = null;
    private b ehh;
    private f ehi;
    private String hcl;
    private vt qJq;
    private boolean vcA = false;
    private a vcB = null;
    private n vcw;
    private b vcz = null;

    interface a {
        void cC(int i, int i2);
    }

    public ag(long j, boolean z, d dVar, a aVar, String str, b bVar) {
        AppMethodBeat.i(27363);
        this.cvx = j;
        this.hcl = str;
        this.eFt = dVar;
        this.vcB = aVar;
        this.vcA = z;
        this.vcz = bVar;
        com.tencent.mm.ai.b.a aVar2 = new com.tencent.mm.ai.b.a();
        aVar2.fsJ = new bwb();
        aVar2.fsK = new bwc();
        aVar2.uri = "/cgi-bin/micromsg-bin/sendappmsg";
        aVar2.fsI = 222;
        aVar2.fsL = 107;
        aVar2.fsM = 1000000107;
        this.ehh = aVar2.acD();
        ab.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig NetSceneSendAppMsgForCdn msgId[%d], sceneResult[%s], sessionId[%s], attachInfo[%s]. stack[%s]", Long.valueOf(j), dVar, str, bVar, bo.dpG());
        AppMethodBeat.o(27363);
    }

    public final int getType() {
        return 222;
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(27364);
        this.ehi = fVar;
        aw.ZK();
        this.cKd = c.XO().jf(this.cvx);
        if (this.cKd == null || this.cKd.field_msgId != this.cvx) {
            ab.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra doscene msginfo null id:%d", Long.valueOf(this.cvx));
            this.vcB.cC(3, -1);
            AppMethodBeat.o(27364);
            return -1;
        }
        String str;
        int i;
        String string;
        j.b me = j.b.me(this.cKd.field_content);
        if (me == null) {
            ab.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra doscene AppMessage.Content.parse null id:%d", Long.valueOf(this.cvx));
            this.vcB.cC(3, -1);
        }
        bwb bwb = (bwb) this.ehh.fsG.fsP;
        dv dvVar = new dv();
        dvVar.fKh = me.appId;
        dvVar.vFF = this.cKd.field_talker + this.cKd.field_msgId + "T" + this.cKd.field_createTime;
        dvVar.pcX = (int) bo.anT();
        dvVar.ndF = this.cKd.field_talker;
        dvVar.ndG = r.Yz();
        dvVar.jCt = me.type;
        dvVar.vFE = me.sdkVer;
        dvVar.vFH = me.fgr;
        if (com.tencent.mm.aj.f.kq(this.cKd.field_talker)) {
            dvVar.vEG = com.tencent.mm.aj.a.e.rw(this.cKd.dqJ);
        } else {
            dvVar.vEG = bh.aae();
        }
        dvVar.vFJ = me.cMj;
        dvVar.vFK = me.cMk;
        dvVar.vFL = me.cMl;
        v.b nV = v.Zp().nV(this.hcl);
        if (nV != null) {
            this.qJq = new vt();
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
            aw.ZK();
            ad aoO = c.XM().aoO(this.cKd.field_talker);
            if (aoO != null) {
                this.qJq.cSG.cSN = aoO.Oi();
            }
            this.qJq.cSG.cSO = com.tencent.mm.model.n.mA(this.cKd.field_talker);
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
            bwb.wWS = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[]{this.qJq.cSG.cSH, this.qJq.cSG.cSJ, this.qJq.cSG.cSK, Integer.valueOf(u.ad(this.qJq.cSG.cSJ, this.qJq.cSG.cSK)), Integer.valueOf(this.qJq.cSG.cSQ), str});
        }
        if (nV != null && me.type == 33) {
            this.vcw = new n();
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
            this.vcw.csr.csw = bo.anT();
            this.vcw.csr.csx = 1;
        }
        ab.d("MicroMsg.NetSceneSendAppMsgForCdn", "stev summerbig SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", me.cMj, me.cMk, me.cMl);
        int i2 = 0;
        i = 0;
        if (!bo.isNullOrNil(this.cKd.field_imgPath)) {
            Options amj = com.tencent.mm.sdk.platformtools.d.amj(o.ahl().sj(this.cKd.field_imgPath));
            if (amj != null) {
                i2 = amj.outWidth;
                i = amj.outHeight;
            }
        }
        if (this.eFt.Jm()) {
            ab.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn app sceneResult crc[%d], safecdn[%b], hitcachetype[%d], aeskey[%s]", Integer.valueOf(this.eFt.field_filecrc), Boolean.valueOf(this.eFt.field_upload_by_safecdn), Integer.valueOf(this.eFt.field_UploadHitCacheType), this.eFt.field_aesKey);
            this.eFt.field_aesKey = "";
            bwb.wWT = 1;
        }
        bwb.vRy = this.eFt.field_filecrc;
        string = null;
        if (this.vcA) {
            string = "@cdn_" + this.eFt.field_fileId + "_" + this.eFt.field_aesKey + "_1";
        }
        dvVar.ncM = j.b.a(me, string, this.eFt, i2, i);
        bwb.wWQ = dvVar;
        if (this.vcz != null && (me.fgs != 0 || me.fgo > 26214400)) {
            bwb.guQ = this.vcz.field_signature;
            bwb.vHo = com.tencent.mm.i.a.efE;
        }
        bwb.Md5 = me.filemd5;
        if (bo.isNullOrNil(this.eFt.field_filemd5)) {
            ab.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig sceneResult filemd5 is null use content.filemd5[%s]", me.filemd5);
        } else {
            bwb.Md5 = this.eFt.field_filemd5;
        }
        ab.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig file md5[%s], HitMd5[%d], signature[%s], type[%d], sceneResult[%s], fromScene[%s]", bwb.Md5, Integer.valueOf(bwb.wWT), bo.anv(bwb.guQ), Integer.valueOf(bwb.vHo), this.eFt, bwb.wWS);
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(27364);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(27365);
        bwb bwb = (bwb) ((b) qVar).fsG.fsP;
        ab.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra onGYNetEnd [%d,%d,%s] msgId:%d, oldContent[%s], newContent[%s]", Integer.valueOf(i2), Integer.valueOf(i3), str, Long.valueOf(this.cvx), this.cKd.field_content, bwb.wWQ.ncM);
        if (i2 == 0 && i3 == 0) {
            bwc bwc = (bwc) ((b) qVar).fsH.fsP;
            ab.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn svrid[%d]. aeskey[%s], old content[%s]", Long.valueOf(bwc.ptF), bwc.vRw, this.cKd.field_content);
            if (this.eFt != null && this.eFt.Jm()) {
                if (bo.isNullOrNil(bwc.vRw)) {
                    ab.w("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn need aeskey but ret null");
                } else {
                    j.b me = j.b.me(this.cKd.field_content);
                    me.eyr = bwc.vRw;
                    this.cKd.setContent(j.b.a(me, null, null));
                    ab.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn aeskey[%s], new content[%s]", bwc.vRw, this.cKd.field_content);
                }
            }
            this.cKd.setStatus(2);
            this.cKd.eI(bwc.ptF);
            aw.ZK();
            c.XO().a(this.cKd.field_msgId, this.cKd);
            com.tencent.mm.modelstat.b.fRa.a(this.cKd, com.tencent.mm.af.k.k(this.cKd));
            this.ehi.onSceneEnd(i2, i3, str, this);
            this.vcB.cC(i2, i3);
            if (!(this.qJq == null || bo.isNullOrNil(this.qJq.cSG.url))) {
                this.qJq.cSG.cSI = "msg_" + Long.toString(bwc.ptF);
                com.tencent.mm.sdk.b.a.xxA.m(this.qJq);
            }
            if (this.vcw != null) {
                this.vcw.csr.csv = "msg_" + this.cKd.field_msgSvrId;
                com.tencent.mm.sdk.b.a.xxA.m(this.vcw);
            }
            AppMethodBeat.o(27365);
        } else if (i2 == 4 && i3 == 102) {
            ab.w("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn MM_ERR_GET_AESKEY_FAILED");
            this.ehi.onSceneEnd(i2, i3, str, this);
            this.vcB.cC(i2, i3);
            AppMethodBeat.o(27365);
        } else {
            this.cKd.setStatus(5);
            aw.ZK();
            c.XO().a(this.cKd.field_msgId, this.cKd);
            ab.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig send app msg failed, err=" + i2 + "," + i3);
            this.ehi.onSceneEnd(i2, i3, str, this);
            this.vcB.cC(i2, i3);
            AppMethodBeat.o(27365);
        }
    }
}
