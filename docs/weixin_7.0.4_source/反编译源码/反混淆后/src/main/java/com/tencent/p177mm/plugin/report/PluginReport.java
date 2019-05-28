package com.tencent.p177mm.plugin.report;

import com.tencent.matrix.mrs.core.MatrixReport;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mrs.C5769a;
import com.tencent.mrs.p655a.C7372a;
import com.tencent.p177mm.compatible.util.C1449k;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1671c;
import com.tencent.p177mm.kernel.api.bucket.C6616b;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.kernel.p242c.C6625e;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.report.service.C7063j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.report.PluginReport */
public class PluginReport extends C7597f implements C6616b, C1671c, C7051c {
    private C7485q pWZ;

    public void installed() {
        AppMethodBeat.m2504i(72658);
        alias(C7051c.class);
        AppMethodBeat.m2505o(72658);
    }

    public void dependency() {
        AppMethodBeat.m2504i(72659);
        dependsOn(C6983p.class);
        AppMethodBeat.m2505o(72659);
    }

    public void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(72660);
        if (C4996ah.bqo()) {
            C4990ab.m7416i("Matrix.PluginReport", "load matrixmrs so");
            C1449k.m3079a("matrixmrs", PluginReport.class.getClassLoader());
        }
        this.pWZ = new C7485q(C7063j.class);
        C1720g.m3543a(C7485q.class, new C6625e(this.pWZ));
        C7053e c7053e = C7053e.pXa;
        C4990ab.m7417i("MicroMsg.ReportService", "instance set %s", C7060h.pYm);
        c7053e.pXb = r1;
        MatrixReport.setMrsCallback(new C7372a());
        C5769a.m8680j(c1681g.f1233cc);
        AppMethodBeat.m2505o(72660);
    }

    public void execute(C1681g c1681g) {
    }

    public List<String> collectStoragePaths() {
        AppMethodBeat.m2504i(72661);
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"logcat/"});
        AppMethodBeat.m2505o(72661);
        return linkedList;
    }

    public void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(72662);
        C5769a.dPc();
        AppMethodBeat.m2505o(72662);
    }

    public void onAccountRelease() {
    }

    public String toString() {
        return "plugin-report";
    }
}
