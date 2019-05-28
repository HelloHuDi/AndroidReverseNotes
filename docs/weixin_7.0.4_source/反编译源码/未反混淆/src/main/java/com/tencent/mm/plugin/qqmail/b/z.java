package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.qqmail.b.ab.e;
import com.tencent.mm.plugin.qqmail.b.ab.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

public final class z {
    ArrayList<aa> puX = new ArrayList();
    ab puY = ac.ccD();
    y puZ = null;
    boolean pva = false;
    f pvb = new f() {
        public final void ad(String str, int i, int i2) {
            AppMethodBeat.i(68031);
            if (i == i2) {
                ab.i("MicroMsg.ShareMailQueue", "finished one job, queue.size = %d", Integer.valueOf(z.this.puX.size()));
                if (z.this.puZ != null) {
                    z.this.puZ.Vl(str);
                }
                if (z.this.puX.size() > 0) {
                    ab.i("MicroMsg.ShareMailQueue", "continue to send next mail");
                    z.this.b((aa) z.this.puX.remove(0));
                    z.this.puY.a((f) this, z.this.pvc);
                    AppMethodBeat.o(68031);
                    return;
                }
                ab.i("MicroMsg.ShareMailQueue", "finished sent all mails");
                z.this.pva = false;
            }
            AppMethodBeat.o(68031);
        }
    };
    e pvc = new e() {
        public final void Vn(String str) {
            AppMethodBeat.i(68032);
            if (z.this.puZ != null) {
                y yVar = z.this.puZ;
                if (bo.isNullOrNil(str)) {
                    ab.w("MicroMsg.ShareMailInfoMgr", "notify fail error, subject is null");
                } else {
                    y.Vm(str);
                    yVar.Vl(str);
                }
            }
            if (z.this.puX.size() > 0) {
                ab.i("MicroMsg.ShareMailQueue", "continue to send next mail");
                z.this.b((aa) z.this.puX.remove(0));
                z.this.puY.a(z.this.pvb, (e) this);
                AppMethodBeat.o(68032);
                return;
            }
            ab.i("MicroMsg.ShareMailQueue", "final job fail");
            z.this.pva = false;
            AppMethodBeat.o(68032);
        }
    };

    public z() {
        AppMethodBeat.i(68033);
        AppMethodBeat.o(68033);
    }

    public final void a(aa aaVar) {
        AppMethodBeat.i(68034);
        if (g.RN().QY()) {
            if (this.puZ == null) {
                this.puZ = new y();
            }
            y yVar = this.puZ;
            String str = aaVar.ptN;
            if (bo.isNullOrNil(str)) {
                ab.w("MicroMsg.ShareMailInfoMgr", "add info fail, info is null");
            } else {
                w wVar = new w();
                wVar.ptN = str;
                yVar.puW.oof.add(wVar);
                yVar.save();
            }
            this.puX.add(aaVar);
            ab.d("MicroMsg.ShareMailQueue", "add a new job, queue.size: %d", Integer.valueOf(this.puX.size()));
            if (!this.pva) {
                ab.d("MicroMsg.ShareMailQueue", "start execute");
                if (this.puX.size() > 0) {
                    this.pva = true;
                    b((aa) this.puX.remove(0));
                    this.puY.a(this.pvb, this.pvc);
                }
            }
            AppMethodBeat.o(68034);
            return;
        }
        AppMethodBeat.o(68034);
    }

    /* Access modifiers changed, original: final */
    public final void b(aa aaVar) {
        AppMethodBeat.i(68035);
        this.puY.clearData();
        this.puY.cEV = aaVar.cEV;
        this.puY.ptN = aaVar.ptN;
        this.puY.pur = aaVar.pur;
        this.puY.pus = aaVar.pus;
        this.puY.pve = aaVar.pve;
        this.puY.X(aaVar.pvf);
        this.puY.Y(aaVar.pvg);
        this.puY.Z(aaVar.pvh);
        AppMethodBeat.o(68035);
    }
}
