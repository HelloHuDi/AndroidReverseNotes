package com.tencent.p177mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.game.p1268a.C43156b;
import com.tencent.p177mm.plugin.game.p428f.C20964d;
import com.tencent.p177mm.plugin.game.p731d.C12115by;
import com.tencent.p177mm.plugin.game.p731d.C12121di;
import com.tencent.p177mm.plugin.game.p731d.C28181ag;
import com.tencent.p177mm.plugin.game.p731d.C34263ai;
import com.tencent.p177mm.plugin.game.p731d.C39184ah;
import com.tencent.p177mm.plugin.game.p731d.C43162be;
import com.tencent.p177mm.plugin.game.p731d.C6931af;
import com.tencent.p177mm.plugin.game.p731d.C6932am;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.game.model.ac */
public final class C28221ac extends C39216x {
    private C43162be mXU;
    public C12115by mXV;
    public C12157a mXW;
    public C39184ah mXX;
    public C12121di mXY;
    public C6932am mXZ;

    /* renamed from: com.tencent.mm.plugin.game.model.ac$a */
    public static class C12157a {
        public String desc;
        public C20992c mYa;
        public C6931af mYb;
        public C28181ag mYc;
        public C34263ai mYd;
    }

    public C28221ac(C43162be c43162be) {
        AppMethodBeat.m2504i(111372);
        if (c43162be == null) {
            this.mXU = new C43162be();
            AppMethodBeat.m2505o(111372);
            return;
        }
        this.mXU = c43162be;
        m44811hM(true);
        AppMethodBeat.m2505o(111372);
    }

    public C28221ac(byte[] bArr) {
        AppMethodBeat.m2504i(111373);
        this.mXU = new C43162be();
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.m2505o(111373);
            return;
        }
        try {
            this.mXU.parseFrom(bArr);
        } catch (IOException e) {
            C4990ab.m7413e("MicroMsg.GamePBDataIndex4", "Parsing Failed: %s", e.getMessage());
        }
        m44811hM(false);
        AppMethodBeat.m2505o(111373);
    }

    /* renamed from: hM */
    private void m44811hM(boolean z) {
        AppMethodBeat.m2504i(111374);
        bEL();
        m44812hN(z);
        AppMethodBeat.m2505o(111374);
    }

    /* renamed from: hN */
    private void m44812hN(boolean z) {
        AppMethodBeat.m2504i(111375);
        if (this.mXU == null || !z) {
            AppMethodBeat.m2505o(111375);
            return;
        }
        if (!(this.mXU.ncb == null || this.mXU.ncb.mZk == null)) {
            C20964d.m32218a(C39216x.m66823a(this.mXU.ncb.mZk));
        }
        ((C43156b) C1720g.m3528K(C43156b.class)).bCV().init(C4996ah.getContext());
        AppMethodBeat.m2505o(111375);
    }

    private void bEL() {
        AppMethodBeat.m2504i(111376);
        if (this.mXU == null) {
            AppMethodBeat.m2505o(111376);
            return;
        }
        this.mXV = this.mXU.nce;
        if (!(this.mXU.ncb == null || this.mXU.ncb.mZk == null)) {
            this.mXW = new C12157a();
            this.mXW.mYa = C39216x.m66823a(this.mXU.ncb.mZk);
            if (this.mXW.mYa != null) {
                this.mXW.mYa.mVk = this.mXU.ncb.Desc;
                this.mXW.mYa.scene = 10;
                this.mXW.mYa.cKG = 1002;
                this.mXW.mYa.position = 1;
            }
            this.mXW.mYb = this.mXU.ncb.naN;
            this.mXW.mYc = this.mXU.ncb.naM;
            this.mXW.desc = this.mXU.ncb.Desc;
            this.mXW.mYd = this.mXU.ncd;
        }
        this.mXX = this.mXU.ncc;
        this.mXY = this.mXU.ncf;
        this.mXZ = this.mXU.ncg;
        AppMethodBeat.m2505o(111376);
    }
}
