package com.tencent.p177mm.plugin.ipcall.p438a.p732d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.aqp;
import com.tencent.p177mm.protocal.protobuf.aqq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.view.C31128d;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.ipcall.a.d.g */
public final class C34373g extends C1207m implements C1918k {
    private C7472b ehh = null;
    private C1202f ehi;
    private aqp nys = null;
    public aqq nyt = null;

    public C34373g(int i) {
        AppMethodBeat.m2504i(21854);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aqp();
        c1196a.fsK = new aqq();
        c1196a.fsI = C31128d.MIC_PTU_ZIPAI_TOKYO;
        c1196a.uri = "/cgi-bin/micromsg-bin/getwechatoutcoupons";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        this.nys = (aqp) this.ehh.fsG.fsP;
        this.nys.Scene = i;
        aqp aqp = this.nys;
        C9638aw.m17190ZK();
        aqp.wur = ((Integer) C18628c.m29072Ry().get(C5127a.USERFINO_IPCALL_REDDOT_RECHARGE_VERSION_INT, Integer.valueOf(0))).intValue();
        aqp = this.nys;
        C9638aw.m17190ZK();
        aqp.wus = ((Integer) C18628c.m29072Ry().get(C5127a.USERINFO_IPCALL_ADDRESS_ACCOUNT_ACTIVITY_TYPE_VERSION_INT, Integer.valueOf(0))).intValue();
        C4990ab.m7417i("MicroMsg.NetSceneIPCallGetWeChatOutCoupons", "NetSceneIPCallGetWeChatOutCoupons Scene:%d, RechargeWordingVersion:%d,AccountActivityWordingVersion:%d", Integer.valueOf(this.nys.Scene), Integer.valueOf(this.nys.wur), Integer.valueOf(this.nys.wus));
        AppMethodBeat.m2505o(21854);
    }

    public final int getType() {
        return C31128d.MIC_PTU_ZIPAI_TOKYO;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(21855);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(21855);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(21856);
        C4990ab.m7417i("MicroMsg.NetSceneIPCallGetWeChatOutCoupons", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nyt = (aqq) ((C7472b) c1929q).fsH.fsP;
        if ((i2 == 0 || i3 == 0) && i2 == 0 && i3 == 0) {
            aqq aqq = this.nyt;
            if (aqq != null) {
                C4990ab.m7417i("MicroMsg.IPCallUtil", "[royle]begin save response,Balance:%s,PVWording:%s,Coupons:%s,Wording:%s,Title:%s,Desc:%s,ImgPath:%s,UrlPath:%s,SmsDesc:%s,PackageMsg:%s", aqq.wuw, aqq.wux, aqq.wut, aqq.nzz, aqq.Title, aqq.Desc, aqq.wuu, aqq.wuv, aqq.wuy, aqq.wuE);
                try {
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(C5127a.USERINFO_IPCALL_ACCOUNT_CACHE_STRING, C5046bo.m7543cd(aqq.toByteArray()));
                } catch (IOException e) {
                    C4990ab.m7417i("MicroMsg.IPCallUtil", "[royle]save exception:%s", e.getMessage());
                }
            }
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(21856);
    }
}
