package com.tencent.mm.graphics.b;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b implements a {
    static final /* synthetic */ boolean $assertionsDisabled = (!b.class.desiredAssertionStatus());
    private Context eCA;
    private List<Double> eCB = new ArrayList(100);
    private int eCC = 0;
    public double eCD = 0.0d;
    public double eCE = 0.0d;
    public double eCF = 2.147483647E9d;
    public double eCG = 0.0d;
    public double eCH = 0.0d;

    static {
        AppMethodBeat.i(57079);
        AppMethodBeat.o(57079);
    }

    public b(Context context) {
        AppMethodBeat.i(57075);
        this.eCA = context;
        this.eCD = bK(context);
        ab.v("MicroMsg.MemoryRecord", "hy: init mem to " + this.eCD);
        AppMethodBeat.o(57075);
    }

    public final void Pw() {
        AppMethodBeat.i(57076);
        this.eCC = this.eCB.size();
        if (this.eCC == 0) {
            ab.w("MicroMsg.MemoryRecord", "hy: check frames 0!");
            AppMethodBeat.o(57076);
            return;
        }
        Double valueOf = Double.valueOf(0.0d);
        Double d = valueOf;
        for (Double valueOf2 : this.eCB) {
            d = Double.valueOf(d.doubleValue() + valueOf2.doubleValue());
            this.eCE = Math.max(this.eCE, valueOf2.doubleValue());
            this.eCF = Math.min(this.eCF, valueOf2.doubleValue());
        }
        Double valueOf3 = Double.valueOf(d.doubleValue() / ((double) this.eCC));
        this.eCH = valueOf3.doubleValue() - this.eCD;
        this.eCE -= this.eCD;
        this.eCF -= this.eCD;
        long j = 0;
        Iterator it = this.eCB.iterator();
        while (true) {
            long j2 = j;
            if (it.hasNext()) {
                j = (long) (Math.pow(((Double) it.next()).doubleValue() - valueOf3.doubleValue(), 2.0d) + ((double) j2));
            } else {
                this.eCG = Math.sqrt((double) (j2 / ((long) this.eCC)));
                AppMethodBeat.o(57076);
                return;
            }
        }
    }

    public final void Px() {
        AppMethodBeat.i(57077);
        if (this.eCB == null) {
            AppMethodBeat.o(57077);
        } else if (this.eCB.size() > Downloads.MIN_WAIT_FOR_NETWORK) {
            AppMethodBeat.o(57077);
        } else {
            if (this.eCA != null) {
                double bK = bK(this.eCA);
                this.eCD = Math.min(bK, this.eCD);
                if (this.eCD == bK) {
                    ab.v("MicroMsg.MemoryRecord", "hy: updating min mem to " + this.eCD);
                }
                this.eCB.add(Double.valueOf(bK));
            }
            AppMethodBeat.o(57077);
        }
    }

    private static double bK(Context context) {
        AppMethodBeat.i(57078);
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        MemoryInfo memoryInfo = new MemoryInfo();
        if ($assertionsDisabled || activityManager != null) {
            activityManager.getMemoryInfo(memoryInfo);
            double d = (((double) (memoryInfo.totalMem - memoryInfo.availMem)) / 1024.0d) / 1024.0d;
            AppMethodBeat.o(57078);
            return d;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(57078);
        throw assertionError;
    }
}
