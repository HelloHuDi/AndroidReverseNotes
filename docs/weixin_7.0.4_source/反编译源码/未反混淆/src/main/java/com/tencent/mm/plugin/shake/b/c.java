package com.tencent.mm.plugin.shake.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.e;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.List;

public final class c extends b implements f {
    private Context context;
    float ecs = -85.0f;
    float ect = -1000.0f;
    private a ecy = new a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            boolean z2;
            boolean z3;
            AppMethodBeat.i(24418);
            e akf = e.akf();
            if (i == 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (c.this.fwu == null) {
                z3 = false;
            } else {
                z3 = c.this.fwu.fBD;
            }
            akf.a(2002, z2, z3, f, f2, (int) d2);
            ab.i("MicroMsg.ShakeFriendService", "getlocaion lat %f lng %f hasGetLbsInfo " + c.this.qfz, Float.valueOf(f2), Float.valueOf(f));
            if (z) {
                if (c.this.qrF && c.this.ecs == -85.0f && c.this.ect == -1000.0f) {
                    c.this.qrF = false;
                    c.this.ecs = f2;
                    c.this.ect = f;
                    c.this.qfw = (int) d2;
                    c.this.qfv = i;
                    c.this.qfz = true;
                }
                AppMethodBeat.o(24418);
                return false;
            }
            AppMethodBeat.o(24418);
            return true;
        }
    };
    d fwu;
    int qfv = 1;
    int qfw = -1000;
    boolean qfz = false;
    boolean qrF = true;
    b qrG;
    a qrH;
    private int qrI = 0;
    ak qrJ = new ak();
    Runnable qrK = new Runnable() {
        public final void run() {
            AppMethodBeat.i(24417);
            if (!(c.this.qrJ == null || c.this.qrK == null)) {
                c.this.qrJ.removeCallbacks(c.this.qrK);
            }
            if (c.this.qrH != null) {
                aw.Rg().c(c.this.qrH);
            }
            if (!(c.this.qrG == null || c.this.qrG.cQr == null)) {
                c.this.qrH = new a(c.this.qrG.cQr);
            }
            if (c.this.qrH != null) {
                aw.Rg().a(c.this.qrH, 0);
            }
            AppMethodBeat.o(24417);
        }
    };

    public c(Context context, l.a aVar) {
        super(aVar);
        AppMethodBeat.i(24419);
        this.context = context;
        AppMethodBeat.o(24419);
    }

    public final void init() {
        AppMethodBeat.i(24420);
        aw.Rg().a(161, (f) this);
        aw.Rg().a((int) ErrorCode.STARTDOWNLOAD_3, (f) this);
        aw.Rg().a(1251, (f) this);
        cjv();
        AppMethodBeat.o(24420);
    }

    public final void start() {
        AppMethodBeat.i(24421);
        reset();
        init();
        this.qrG = new b(this.ect, this.ecs, this.qfw, this.qfv, "", "");
        aw.Rg().a(this.qrG, 0);
        if (!this.qfz) {
            if (this.fwu == null) {
                cjv();
            }
            this.fwu.b(this.ecy, true);
        }
        if (this.qrI <= 0) {
            this.qrI++;
        } else if (this.qrI <= 0 || this.qrI > 10) {
            this.qrI = 0;
        } else {
            this.qrI++;
            AppMethodBeat.o(24421);
            return;
        }
        ab.i("MicroMsg.ShakeFriendService", "do doGetLbsCard");
        aw.Rg().a(new com.tencent.mm.plugin.shake.c.a.b(this.ect, this.ecs), 0);
        AppMethodBeat.o(24421);
    }

    private void cjv() {
        AppMethodBeat.i(24422);
        this.fwu = d.agz();
        this.qrF = true;
        this.fwu.a(this.ecy, true);
        AppMethodBeat.o(24422);
    }

    public final void reset() {
        AppMethodBeat.i(24423);
        if (this.qrG != null) {
            aw.Rg().c(this.qrG);
        }
        if (this.qrH != null) {
            aw.Rg().c(this.qrH);
        }
        if (!(this.qrJ == null || this.qrK == null)) {
            this.qrJ.removeCallbacks(this.qrK);
        }
        AppMethodBeat.o(24423);
    }

    public final void cjw() {
        AppMethodBeat.i(24426);
        super.cjw();
        aw.Rg().b(161, (f) this);
        aw.Rg().b((int) ErrorCode.STARTDOWNLOAD_3, (f) this);
        aw.Rg().b(1251, (f) this);
        if (this.fwu != null) {
            this.fwu.c(this.ecy);
        }
        AppMethodBeat.o(24426);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(24427);
        switch (mVar.getType()) {
            case 161:
                b bVar = (b) mVar;
                if (bVar.cju() == 3 || bVar.cju() == 4) {
                    ab.v("MicroMsg.ShakeFriendService", "onSceneEnd ignore location report response");
                    AppMethodBeat.o(24427);
                    return;
                } else if (i2 == 0 && i == 0 && bVar.ret == 0) {
                    this.qrJ.postDelayed(this.qrK, 3000);
                    AppMethodBeat.o(24427);
                    return;
                } else {
                    ab.e("MicroMsg.ShakeFriendService", "onSceneEnd reprot failed");
                    this.qrT.b(null, 3);
                    AppMethodBeat.o(24427);
                    return;
                }
            case ErrorCode.STARTDOWNLOAD_3 /*162*/:
                a aVar = (a) mVar;
                if (i2 == 0 && i == 0 && aVar.ret == 0) {
                    List list = aVar.qrD;
                    if (list.size() == 0) {
                        ab.i("MicroMsg.ShakeFriendService", "empty shake get list");
                        this.qrT.b(null, 3);
                        AppMethodBeat.o(24427);
                        return;
                    }
                    this.qrT.b(list, 1);
                    AppMethodBeat.o(24427);
                    return;
                }
                this.qrT.b(null, 3);
                AppMethodBeat.o(24427);
                return;
            case 1251:
                com.tencent.mm.plugin.shake.c.a.b bVar2 = (com.tencent.mm.plugin.shake.c.a.b) mVar;
                if (i2 == 0 && i == 0) {
                    if (this.qrT != null) {
                        this.qrT.a(1251, bVar2.qsm, 1);
                        break;
                    }
                } else if (this.qrT != null) {
                    this.qrT.a(1251, null, 2);
                    AppMethodBeat.o(24427);
                    return;
                }
                break;
        }
        AppMethodBeat.o(24427);
    }

    public final void pause() {
        AppMethodBeat.i(24424);
        if (this.fwu != null) {
            this.fwu.c(this.ecy);
        }
        AppMethodBeat.o(24424);
    }

    public final void resume() {
        AppMethodBeat.i(24425);
        if (this.fwu != null) {
            this.fwu.a(this.ecy, true);
        }
        AppMethodBeat.o(24425);
    }
}
