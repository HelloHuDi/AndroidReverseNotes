package com.tencent.p177mm.plugin.appbrand.widget.desktop.p339b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.b.a */
public final class C36736a implements C33603b {
    private List<Double> jbt = new ArrayList(100);
    public double jbu = 0.0d;
    public double jbv = Double.MAX_VALUE;
    public double jbw = Double.MIN_VALUE;

    public C36736a() {
        AppMethodBeat.m2504i(134236);
        AppMethodBeat.m2505o(134236);
    }

    /* renamed from: Pw */
    public final void mo54169Pw() {
        AppMethodBeat.m2504i(134237);
        if (this.jbt == null) {
            AppMethodBeat.m2505o(134237);
        } else if (this.jbt.size() > Downloads.MIN_WAIT_FOR_NETWORK) {
            AppMethodBeat.m2505o(134237);
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
            AppMethodBeat.m2505o(134237);
        }
    }

    /* renamed from: Px */
    public final void mo54170Px() {
        double d = 60.0d;
        double d2 = 0.0d;
        AppMethodBeat.m2504i(134238);
        double d3 = C38578c.jbx.eCK;
        if (d3 <= 60.0d) {
            d = d3;
        }
        if (d >= 0.0d) {
            d2 = d;
        }
        this.jbt.add(Double.valueOf(d2));
        AppMethodBeat.m2505o(134238);
    }
}
