package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.quality.a.a;

public class QualitySessionRuntime extends QualitySession {
    public boolean hrs;
    public o htn;
    public long iDb;
    public long iDc;
    public long iDd;
    public AppStartupPerformanceReportBundle iDe;
    public int iDf;
    public final a iDg = new a();
    public final e iDh = new e();
    public final j iDi = new j();
    public boolean iDj = false;
    public long iDk = 0;

    QualitySessionRuntime(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(132708);
        AppMethodBeat.o(132708);
    }
}
