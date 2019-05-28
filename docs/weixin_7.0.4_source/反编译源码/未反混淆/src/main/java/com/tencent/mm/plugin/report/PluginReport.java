package com.tencent.mm.plugin.report;

import com.tencent.matrix.mrs.core.MatrixReport;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.report.service.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mrs.a.a;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PluginReport extends f implements b, c, c {
    private q pWZ;

    public void installed() {
        AppMethodBeat.i(72658);
        alias(c.class);
        AppMethodBeat.o(72658);
    }

    public void dependency() {
        AppMethodBeat.i(72659);
        dependsOn(p.class);
        AppMethodBeat.o(72659);
    }

    public void configure(g gVar) {
        AppMethodBeat.i(72660);
        if (ah.bqo()) {
            ab.i("Matrix.PluginReport", "load matrixmrs so");
            k.a("matrixmrs", PluginReport.class.getClassLoader());
        }
        this.pWZ = new q(j.class);
        com.tencent.mm.kernel.g.a(q.class, new e(this.pWZ));
        e eVar = e.pXa;
        ab.i("MicroMsg.ReportService", "instance set %s", h.pYm);
        eVar.pXb = r1;
        MatrixReport.setMrsCallback(new a());
        com.tencent.mrs.a.j(gVar.cc);
        AppMethodBeat.o(72660);
    }

    public void execute(g gVar) {
    }

    public List<String> collectStoragePaths() {
        AppMethodBeat.i(72661);
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"logcat/"});
        AppMethodBeat.o(72661);
        return linkedList;
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        AppMethodBeat.i(72662);
        com.tencent.mrs.a.dPc();
        AppMethodBeat.o(72662);
    }

    public void onAccountRelease() {
    }

    public String toString() {
        return "plugin-report";
    }
}
