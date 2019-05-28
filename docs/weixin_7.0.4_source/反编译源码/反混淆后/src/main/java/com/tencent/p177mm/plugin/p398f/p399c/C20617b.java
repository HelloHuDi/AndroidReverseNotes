package com.tencent.p177mm.plugin.p398f.p399c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.plugin.p1614i.C43217c;
import com.tencent.p177mm.plugin.p398f.C45913b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pointers.PLong;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.f.c.b */
public final class C20617b implements Runnable {
    private int count = 0;
    public boolean isStop = false;

    public final void run() {
        AppMethodBeat.m2504i(18643);
        if (this.isStop) {
            AppMethodBeat.m2505o(18643);
            return;
        }
        String XW = C43217c.m76863XW();
        this.count = 0;
        long a = m31847a(XW, new PLong());
        if (this.isStop) {
            AppMethodBeat.m2505o(18643);
            return;
        }
        XW = C43217c.m76864XX();
        this.count = 0;
        long a2 = m31847a(XW, new PLong());
        if (this.isStop) {
            AppMethodBeat.m2505o(18643);
            return;
        }
        C9638aw.m17190ZK();
        XW = C18628c.getAccVideoPath();
        this.count = 0;
        long a3 = m31847a(XW, new PLong());
        if (this.isStop) {
            AppMethodBeat.m2505o(18643);
            return;
        }
        C9638aw.m17190ZK();
        XW = C18628c.m29090XY();
        this.count = 0;
        long a4 = m31847a(XW, new PLong());
        if (this.isStop) {
            AppMethodBeat.m2505o(18643);
            return;
        }
        long sK = (C45913b.aZc().aZd().mo61900sK(43) + C45913b.aZc().aZd().mo61900sK(62)) + C45913b.aZc().aZd().mo61900sK(44);
        long sL = (C45913b.aZc().aZd().mo61901sL(43) + C45913b.aZc().aZd().mo61901sL(62)) + C45913b.aZc().aZd().mo61901sL(44);
        if (this.isStop) {
            AppMethodBeat.m2505o(18643);
            return;
        }
        long sK2 = C45913b.aZc().aZd().mo61900sK(3);
        long sL2 = C45913b.aZc().aZd().mo61901sL(3);
        if (this.isStop) {
            AppMethodBeat.m2505o(18643);
            return;
        }
        long sK3 = C45913b.aZc().aZd().mo61900sK(34);
        long sL3 = C45913b.aZc().aZd().mo61901sL(34);
        long sK4 = C45913b.aZc().aZd().mo61900sK(49);
        long sL4 = C45913b.aZc().aZd().mo61901sL(49);
        C7060h.pYm.mo8381e(14556, Integer.valueOf(43), Long.valueOf(sK), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(sL));
        C7060h.pYm.mo8381e(14556, Integer.valueOf(3), Long.valueOf(sK2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(sL2));
        C7060h.pYm.mo8381e(14556, Integer.valueOf(34), Long.valueOf(sK3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(sL3));
        C7060h.pYm.mo8381e(14556, Integer.valueOf(49), Long.valueOf(sK4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(sL4));
        C7060h.pYm.mo8381e(14556, Integer.valueOf("image".hashCode()), Long.valueOf(a), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(r3.value));
        C7060h.pYm.mo8381e(14556, Integer.valueOf("image2".hashCode()), Long.valueOf(a2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(r6.value));
        C7060h.pYm.mo8381e(14556, Integer.valueOf("video".hashCode()), Long.valueOf(a3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(r7.value));
        C7060h.pYm.mo8381e(14556, Integer.valueOf("voice".hashCode()), Long.valueOf(a4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(r12.value));
        long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CALC_WX_SCAN_START_TIME_LONG, (Object) Long.valueOf(0))).longValue();
        long longValue2 = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CALC_WX_SCAN_FINISH_TIME_LONG, (Object) Long.valueOf(0))).longValue() - longValue;
        C7060h.pYm.mo8381e(14556, Integer.valueOf("cost".hashCode()), Integer.valueOf(0), Long.valueOf(longValue), Long.valueOf(r34), Long.valueOf(longValue2));
        C4990ab.m7417i("MicroMsg.ReportTask", "report wx[%d %d %d %d] folder[%d %d %d %d] count_wx[%d %d %d %d] count_folder[%d %d %d %d]", Long.valueOf(sK), Long.valueOf(sK2), Long.valueOf(sK3), Long.valueOf(sK4), Long.valueOf(a3), Long.valueOf(a2), Long.valueOf(a4), Long.valueOf(a), Long.valueOf(sL), Long.valueOf(sL2), Long.valueOf(sL3), Long.valueOf(sL4), Long.valueOf(r7.value), Long.valueOf(r6.value), Long.valueOf(r12.value), Long.valueOf(r3.value));
        AppMethodBeat.m2505o(18643);
    }

    /* renamed from: a */
    private long m31847a(String str, PLong pLong) {
        long j = 0;
        AppMethodBeat.m2504i(18644);
        if (this.count >= 10) {
            if (this.isStop) {
                AppMethodBeat.m2505o(18644);
                return -1;
            }
            this.count = 0;
        }
        File file = new File(str);
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                for (String str2 : list) {
                    String str22;
                    StringBuilder append = new StringBuilder().append(str);
                    if (!str.endsWith("/")) {
                        str22 = "/".concat(String.valueOf(str22));
                    }
                    long a = m31847a(append.append(str22).toString(), pLong);
                    if (a == -1) {
                        AppMethodBeat.m2505o(18644);
                        return -1;
                    }
                    j += a;
                }
                AppMethodBeat.m2505o(18644);
                return j;
            }
        }
        long length = file.length();
        if (length > 0) {
            pLong.value++;
        }
        AppMethodBeat.m2505o(18644);
        return length;
    }
}
