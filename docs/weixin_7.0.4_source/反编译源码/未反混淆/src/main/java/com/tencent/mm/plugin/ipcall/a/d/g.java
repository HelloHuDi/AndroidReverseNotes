package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aqp;
import com.tencent.mm.protocal.protobuf.aqq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.view.d;
import java.io.IOException;

public final class g extends m implements k {
    private b ehh = null;
    private f ehi;
    private aqp nys = null;
    public aqq nyt = null;

    public g(int i) {
        AppMethodBeat.i(21854);
        a aVar = new a();
        aVar.fsJ = new aqp();
        aVar.fsK = new aqq();
        aVar.fsI = d.MIC_PTU_ZIPAI_TOKYO;
        aVar.uri = "/cgi-bin/micromsg-bin/getwechatoutcoupons";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        this.nys = (aqp) this.ehh.fsG.fsP;
        this.nys.Scene = i;
        aqp aqp = this.nys;
        aw.ZK();
        aqp.wur = ((Integer) c.Ry().get(ac.a.USERFINO_IPCALL_REDDOT_RECHARGE_VERSION_INT, Integer.valueOf(0))).intValue();
        aqp = this.nys;
        aw.ZK();
        aqp.wus = ((Integer) c.Ry().get(ac.a.USERINFO_IPCALL_ADDRESS_ACCOUNT_ACTIVITY_TYPE_VERSION_INT, Integer.valueOf(0))).intValue();
        ab.i("MicroMsg.NetSceneIPCallGetWeChatOutCoupons", "NetSceneIPCallGetWeChatOutCoupons Scene:%d, RechargeWordingVersion:%d,AccountActivityWordingVersion:%d", Integer.valueOf(this.nys.Scene), Integer.valueOf(this.nys.wur), Integer.valueOf(this.nys.wus));
        AppMethodBeat.o(21854);
    }

    public final int getType() {
        return d.MIC_PTU_ZIPAI_TOKYO;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(21855);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(21855);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(21856);
        ab.i("MicroMsg.NetSceneIPCallGetWeChatOutCoupons", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nyt = (aqq) ((b) qVar).fsH.fsP;
        if ((i2 == 0 || i3 == 0) && i2 == 0 && i3 == 0) {
            aqq aqq = this.nyt;
            if (aqq != null) {
                ab.i("MicroMsg.IPCallUtil", "[royle]begin save response,Balance:%s,PVWording:%s,Coupons:%s,Wording:%s,Title:%s,Desc:%s,ImgPath:%s,UrlPath:%s,SmsDesc:%s,PackageMsg:%s", aqq.wuw, aqq.wux, aqq.wut, aqq.nzz, aqq.Title, aqq.Desc, aqq.wuu, aqq.wuv, aqq.wuy, aqq.wuE);
                try {
                    aw.ZK();
                    c.Ry().set(ac.a.USERINFO_IPCALL_ACCOUNT_CACHE_STRING, bo.cd(aqq.toByteArray()));
                } catch (IOException e) {
                    ab.i("MicroMsg.IPCallUtil", "[royle]save exception:%s", e.getMessage());
                }
            }
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(21856);
    }
}
