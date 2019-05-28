package com.tencent.p177mm.plugin.shake.p1019b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.plugin.normsg.p473a.C6998b;
import com.tencent.p177mm.protocal.protobuf.C7285uy;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.bym;
import com.tencent.p177mm.protocal.protobuf.byn;
import com.tencent.p177mm.protocal.protobuf.byo;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7309bd;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.shake.b.a */
public final class C34893a extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    private String kfM;
    List<C34894d> qrD;
    private int qrE;
    int ret;

    public C34893a(byte[] bArr) {
        AppMethodBeat.m2504i(24411);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new byn();
        c1196a.fsK = new byo();
        c1196a.uri = "/cgi-bin/micromsg-bin/shakeget";
        c1196a.fsI = ErrorCode.STARTDOWNLOAD_3;
        this.ehh = c1196a.acD();
        byn byn = (byn) this.ehh.fsG.fsP;
        byn.vJd = new SKBuiltinBuffer_t().setBuffer(bArr);
        byn.wXL = 1;
        byn.vIl = new SKBuiltinBuffer_t().setBuffer(C6998b.oTO.bVS());
        AppMethodBeat.m2505o(24411);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(24412);
        C4990ab.m7410d("MicroMsg.NetSceneShakeGet", "doScene");
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(24412);
        return a;
    }

    public final int getType() {
        return ErrorCode.STARTDOWNLOAD_3;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(24413);
        C4990ab.m7410d("MicroMsg.NetSceneShakeGet", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        byo byo = (byo) this.ehh.fsH.fsP;
        this.qrD = new LinkedList();
        this.qrE = byo.wXN;
        this.ret = byo.Ret;
        this.kfM = byo.phA;
        int i4 = byo.jBv;
        C4990ab.m7410d("MicroMsg.NetSceneShakeGet", "size:".concat(String.valueOf(i4)));
        C9638aw.m17190ZK();
        C7309bd XM = C18628c.m29078XM();
        if (i4 > 0) {
            C13247e cjS = C28987m.cjS();
            cjS.cjI();
            C4990ab.m7416i("MicroMsg.NewShakeItemStorage", "delOldRecord count:".concat(String.valueOf(i4)));
            if (cjS.bSd.mo10108hY("shakeitem1", "DELETE FROM shakeitem1 WHERE shakeItemID NOT IN ( SELECT shakeItemID FROM shakeitem1 ORDER BY shakeItemID DESC LIMIT " + (100 > i4 ? 100 - i4 : 0) + " )")) {
                C4990ab.m7416i("MicroMsg.NewShakeItemStorage", "delOldRecord success count:".concat(String.valueOf(i4)));
                cjS.doNotify();
            }
            for (i4--; i4 >= 0; i4--) {
                boolean z;
                int i5;
                if (!C1853r.m3846Yz().equals(((bym) byo.wXM.get(i4)).jBB)) {
                    C16527d qP = C41747z.aeR().mo43729qP(((bym) byo.wXM.get(i4)).jBB);
                    qP.field_username = ((bym) byo.wXM.get(i4)).jBB;
                    qP.field_brandList = ((bym) byo.wXM.get(i4)).guX;
                    C7285uy c7285uy = ((bym) byo.wXM.get(i4)).wCa;
                    if (c7285uy != null) {
                        qP.field_brandFlag = c7285uy.gvb;
                        qP.field_brandInfo = c7285uy.gvd;
                        qP.field_brandIconURL = c7285uy.gve;
                        qP.field_extInfo = c7285uy.gvc;
                    }
                    if (!C41747z.aeR().mo43726e(qP)) {
                        C41747z.aeR().mo43724d(qP);
                    }
                }
                C34894d c34894d = new C34894d((bym) byo.wXM.get(i4));
                C17880h c17880h = new C17880h();
                c17880h.username = c34894d.field_username;
                if (c34894d.field_hasHDImg > 0) {
                    z = true;
                } else {
                    z = false;
                }
                c17880h.mo33385cB(z);
                c17880h.dtR = c34894d.field_imgstatus;
                c17880h.frW = ((bym) byo.wXM.get(i4)).vXm;
                c17880h.frV = ((bym) byo.wXM.get(i4)).vXn;
                C17884o.act().mo33391b(c17880h);
                c17880h.bJt = -1;
                C4990ab.m7411d("MicroMsg.NetSceneShakeGet", "dkhurl search %s b[%s] s[%s]", c17880h.getUsername(), c17880h.ack(), c17880h.acl());
                if (XM.aoJ(c34894d.field_username)) {
                    i5 = 1;
                } else {
                    i5 = 0;
                }
                c34894d.field_reserved2 = i5;
                C7616ad aoO = XM.aoO(c34894d.field_username);
                if (aoO != null && ((int) aoO.ewQ) > 0) {
                    cjS.mo25303WC(aoO.field_username);
                    cjS.mo25303WC(aoO.field_encryptUsername);
                }
                cjS.mo25304a(c34894d, false);
                C9638aw.m17190ZK();
                C18628c.m29101Yn().mo56748x(c34894d.field_username, this.qrE, ((bym) byo.wXM.get(i4)).wlF);
                c34894d.scene = this.qrE;
                this.qrD.add(c34894d);
                C4990ab.m7418v("MicroMsg.NetSceneShakeGet", "item info: " + c34894d.field_username + " " + c34894d.field_nickname);
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(24413);
    }
}
