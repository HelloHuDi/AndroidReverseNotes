package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.b;
import com.tencent.mm.plugin.game.d.af;
import com.tencent.mm.plugin.game.d.ag;
import com.tencent.mm.plugin.game.d.ah;
import com.tencent.mm.plugin.game.d.ai;
import com.tencent.mm.plugin.game.d.am;
import com.tencent.mm.plugin.game.d.be;
import com.tencent.mm.plugin.game.d.by;
import com.tencent.mm.plugin.game.d.di;
import com.tencent.mm.plugin.game.f.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public final class ac extends x {
    private be mXU;
    public by mXV;
    public a mXW;
    public ah mXX;
    public di mXY;
    public am mXZ;

    public static class a {
        public String desc;
        public c mYa;
        public af mYb;
        public ag mYc;
        public ai mYd;
    }

    public ac(be beVar) {
        AppMethodBeat.i(111372);
        if (beVar == null) {
            this.mXU = new be();
            AppMethodBeat.o(111372);
            return;
        }
        this.mXU = beVar;
        hM(true);
        AppMethodBeat.o(111372);
    }

    public ac(byte[] bArr) {
        AppMethodBeat.i(111373);
        this.mXU = new be();
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.o(111373);
            return;
        }
        try {
            this.mXU.parseFrom(bArr);
        } catch (IOException e) {
            ab.e("MicroMsg.GamePBDataIndex4", "Parsing Failed: %s", e.getMessage());
        }
        hM(false);
        AppMethodBeat.o(111373);
    }

    private void hM(boolean z) {
        AppMethodBeat.i(111374);
        bEL();
        hN(z);
        AppMethodBeat.o(111374);
    }

    private void hN(boolean z) {
        AppMethodBeat.i(111375);
        if (this.mXU == null || !z) {
            AppMethodBeat.o(111375);
            return;
        }
        if (!(this.mXU.ncb == null || this.mXU.ncb.mZk == null)) {
            d.a(x.a(this.mXU.ncb.mZk));
        }
        ((b) g.K(b.class)).bCV().init(com.tencent.mm.sdk.platformtools.ah.getContext());
        AppMethodBeat.o(111375);
    }

    private void bEL() {
        AppMethodBeat.i(111376);
        if (this.mXU == null) {
            AppMethodBeat.o(111376);
            return;
        }
        this.mXV = this.mXU.nce;
        if (!(this.mXU.ncb == null || this.mXU.ncb.mZk == null)) {
            this.mXW = new a();
            this.mXW.mYa = x.a(this.mXU.ncb.mZk);
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
        AppMethodBeat.o(111376);
    }
}
