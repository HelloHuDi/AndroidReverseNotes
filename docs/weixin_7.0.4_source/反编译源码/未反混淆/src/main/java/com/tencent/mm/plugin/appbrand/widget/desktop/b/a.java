package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a implements b {
    private List<Double> jbt = new ArrayList(100);
    public double jbu = 0.0d;
    public double jbv = Double.MAX_VALUE;
    public double jbw = Double.MIN_VALUE;

    public a() {
        AppMethodBeat.i(134236);
        AppMethodBeat.o(134236);
    }

    public final void Pw() {
        AppMethodBeat.i(134237);
        if (this.jbt == null) {
            AppMethodBeat.o(134237);
        } else if (this.jbt.size() > Downloads.MIN_WAIT_FOR_NETWORK) {
            AppMethodBeat.o(134237);
        } else {
            if (this.jbt.size() != 0) {
                double d;
                double d2 = 0.0d;
                Iterator it = this.jbt.iterator();
                while (true) {
                    d = d2;
                    if (!it.hasNext()) {
                        break;
                    }
                    double doubleValue = ((Double) it.next()).doubleValue();
                    d2 = d + doubleValue;
                    this.jbv = Math.min(this.jbv, doubleValue);
                    this.jbw = Math.max(this.jbw, doubleValue);
                }
                this.jbu = d / ((double) this.jbt.size());
            }
            AppMethodBeat.o(134237);
        }
    }

    public final void Px() {
        double d = 60.0d;
        double d2 = 0.0d;
        AppMethodBeat.i(134238);
        double d3 = c.jbx.eCK;
        if (d3 <= 60.0d) {
            d = d3;
        }
        if (d >= 0.0d) {
            d2 = d;
        }
        this.jbt.add(Double.valueOf(d2));
        AppMethodBeat.o(134238);
    }
}
