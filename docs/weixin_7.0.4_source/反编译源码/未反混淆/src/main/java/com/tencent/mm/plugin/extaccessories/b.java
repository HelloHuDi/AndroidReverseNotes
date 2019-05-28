package com.tencent.mm.plugin.extaccessories;

import com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.g.a.nz;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.HashMap;

public final class b implements at {
    String eJM;
    private a lRE;

    public static class a extends c<nz> {
        public a() {
            AppMethodBeat.i(20465);
            this.xxI = nz.class.getName().hashCode();
            AppMethodBeat.o(20465);
        }

        private boolean a(nz nzVar) {
            AppMethodBeat.i(20466);
            if (nzVar instanceof nz) {
                ab.d("MicroMsg.extaccessories.SubCoreExtAccessories", "RegistSpenBuddyEvent");
                if (!(nzVar.cKo == null || nzVar.cKo.cKq == null || nzVar.cKo.cKp == null)) {
                    try {
                        new SlookWritingBuddy(nzVar.cKo.cKq).setImageWritingListener(new SubCoreExtAccessories$RegistSpenBuddyEventListener$1(this, nzVar));
                    } catch (Exception e) {
                        ab.e("MicroMsg.extaccessories.SubCoreExtAccessories", "exception in writingBuddy %s", e.getMessage());
                    }
                }
                AppMethodBeat.o(20466);
                return true;
            }
            ab.f("MicroMsg.extaccessories.SubCoreExtAccessories", "mismatched event");
            AppMethodBeat.o(20466);
            return false;
        }
    }

    public final HashMap<Integer, d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bA(boolean z) {
        AppMethodBeat.i(20468);
        aw.ZK();
        this.eJM = com.tencent.mm.model.c.getAccPath();
        File file = new File(this.eJM);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(this.eJM + "image/spen/");
        if (!file.exists()) {
            file.mkdirs();
        }
        AppMethodBeat.o(20468);
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(20469);
        ab.d("MicroMsg.extaccessories.SubCoreExtAccessories", "SubCoreExtAccessories reset");
        if (this.lRE == null) {
            this.lRE = new a();
        }
        com.tencent.mm.sdk.b.a.xxA.c(this.lRE);
        aw.RS().m(new Runnable() {
            public final void run() {
                AppMethodBeat.i(20463);
                if (!aw.RK()) {
                    AppMethodBeat.o(20463);
                } else if (bo.isNullOrNil(b.this.eJM)) {
                    AppMethodBeat.o(20463);
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    bo.o(b.this.eJM + "image/spen/", "spen_", 259200000);
                    ab.d("MicroMsg.extaccessories.SubCoreExtAccessories", "deleteOutOfDateFile cost %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.o(20463);
                }
            }
        }, 5000);
        AppMethodBeat.o(20469);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(20470);
        ab.d("MicroMsg.extaccessories.SubCoreExtAccessories", "SubCoreExtAccessories release");
        if (this.lRE != null) {
            com.tencent.mm.sdk.b.a.xxA.d(this.lRE);
        }
        AppMethodBeat.o(20470);
    }
}
