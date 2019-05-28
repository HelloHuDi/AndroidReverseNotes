package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bo;

public final class d implements com.tencent.mm.sdk.platformtools.SensorController.a {
    private boolean mfR = false;
    public bf mfS = new bf(ah.getContext());
    long mfT = -1;
    public SensorController mfW = new SensorController(ah.getContext());
    public a nxu = null;

    public interface a {
        void iq(boolean z);
    }

    public d() {
        AppMethodBeat.i(21820);
        AppMethodBeat.o(21820);
    }

    public final void he(final boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(21821);
        ab.i("MicroMsg.IPCallSensorManager", "onSensorEvent, isON:" + z + "  hasSkip:" + this.mfR + " tick:" + bo.az(this.mfT) + "  lt:" + this.mfT);
        if (this.mfR) {
            if (z) {
                z2 = false;
            }
            this.mfR = z2;
            AppMethodBeat.o(21821);
        } else if (z || this.mfT == -1 || bo.az(this.mfT) <= 400) {
            this.mfR = false;
            ab.i("MicroMsg.IPCallSensorManager", "onSensorEvent, isNeedOffScreen: %b", Boolean.valueOf(z));
            new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(21819);
                    if (z) {
                        ab.i("MicroMsg.IPCallSensorManager", "light screen");
                        if (d.this.nxu != null) {
                            d.this.nxu.iq(false);
                        }
                    } else {
                        ab.i("MicroMsg.IPCallSensorManager", "off screen");
                        if (d.this.nxu != null) {
                            d.this.nxu.iq(true);
                        }
                    }
                    AppMethodBeat.o(21819);
                    return false;
                }
            }, false).ae(50, 50);
            AppMethodBeat.o(21821);
        } else {
            this.mfR = true;
            AppMethodBeat.o(21821);
        }
    }
}
