package com.tencent.mm.plugin.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.i.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import java.io.File;

public final class b implements Runnable {
    private int count = 0;
    public boolean isStop = false;

    public final void run() {
        AppMethodBeat.i(18643);
        if (this.isStop) {
            AppMethodBeat.o(18643);
            return;
        }
        String XW = c.XW();
        this.count = 0;
        long a = a(XW, new PLong());
        if (this.isStop) {
            AppMethodBeat.o(18643);
            return;
        }
        XW = c.XX();
        this.count = 0;
        long a2 = a(XW, new PLong());
        if (this.isStop) {
            AppMethodBeat.o(18643);
            return;
        }
        aw.ZK();
        XW = com.tencent.mm.model.c.getAccVideoPath();
        this.count = 0;
        long a3 = a(XW, new PLong());
        if (this.isStop) {
            AppMethodBeat.o(18643);
            return;
        }
        aw.ZK();
        XW = com.tencent.mm.model.c.XY();
        this.count = 0;
        long a4 = a(XW, new PLong());
        if (this.isStop) {
            AppMethodBeat.o(18643);
            return;
        }
        long sK = (com.tencent.mm.plugin.f.b.aZc().aZd().sK(43) + com.tencent.mm.plugin.f.b.aZc().aZd().sK(62)) + com.tencent.mm.plugin.f.b.aZc().aZd().sK(44);
        long sL = (com.tencent.mm.plugin.f.b.aZc().aZd().sL(43) + com.tencent.mm.plugin.f.b.aZc().aZd().sL(62)) + com.tencent.mm.plugin.f.b.aZc().aZd().sL(44);
        if (this.isStop) {
            AppMethodBeat.o(18643);
            return;
        }
        long sK2 = com.tencent.mm.plugin.f.b.aZc().aZd().sK(3);
        long sL2 = com.tencent.mm.plugin.f.b.aZc().aZd().sL(3);
        if (this.isStop) {
            AppMethodBeat.o(18643);
            return;
        }
        long sK3 = com.tencent.mm.plugin.f.b.aZc().aZd().sK(34);
        long sL3 = com.tencent.mm.plugin.f.b.aZc().aZd().sL(34);
        long sK4 = com.tencent.mm.plugin.f.b.aZc().aZd().sK(49);
        long sL4 = com.tencent.mm.plugin.f.b.aZc().aZd().sL(49);
        h.pYm.e(14556, Integer.valueOf(43), Long.valueOf(sK), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(sL));
        h.pYm.e(14556, Integer.valueOf(3), Long.valueOf(sK2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(sL2));
        h.pYm.e(14556, Integer.valueOf(34), Long.valueOf(sK3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(sL3));
        h.pYm.e(14556, Integer.valueOf(49), Long.valueOf(sK4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(sL4));
        h.pYm.e(14556, Integer.valueOf("image".hashCode()), Long.valueOf(a), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(r3.value));
        h.pYm.e(14556, Integer.valueOf("image2".hashCode()), Long.valueOf(a2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(r6.value));
        h.pYm.e(14556, Integer.valueOf("video".hashCode()), Long.valueOf(a3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(r7.value));
        h.pYm.e(14556, Integer.valueOf("voice".hashCode()), Long.valueOf(a4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(r12.value));
        long longValue = ((Long) g.RP().Ry().get(a.USERINFO_CALC_WX_SCAN_START_TIME_LONG, (Object) Long.valueOf(0))).longValue();
        long longValue2 = ((Long) g.RP().Ry().get(a.USERINFO_CALC_WX_SCAN_FINISH_TIME_LONG, (Object) Long.valueOf(0))).longValue() - longValue;
        h.pYm.e(14556, Integer.valueOf("cost".hashCode()), Integer.valueOf(0), Long.valueOf(longValue), Long.valueOf(r34), Long.valueOf(longValue2));
        ab.i("MicroMsg.ReportTask", "report wx[%d %d %d %d] folder[%d %d %d %d] count_wx[%d %d %d %d] count_folder[%d %d %d %d]", Long.valueOf(sK), Long.valueOf(sK2), Long.valueOf(sK3), Long.valueOf(sK4), Long.valueOf(a3), Long.valueOf(a2), Long.valueOf(a4), Long.valueOf(a), Long.valueOf(sL), Long.valueOf(sL2), Long.valueOf(sL3), Long.valueOf(sL4), Long.valueOf(r7.value), Long.valueOf(r6.value), Long.valueOf(r12.value), Long.valueOf(r3.value));
        AppMethodBeat.o(18643);
    }

    private long a(String str, PLong pLong) {
        long j = 0;
        AppMethodBeat.i(18644);
        if (this.count >= 10) {
            if (this.isStop) {
                AppMethodBeat.o(18644);
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
                    long a = a(append.append(str22).toString(), pLong);
                    if (a == -1) {
                        AppMethodBeat.o(18644);
                        return -1;
                    }
                    j += a;
                }
                AppMethodBeat.o(18644);
                return j;
            }
        }
        long length = file.length();
        if (length > 0) {
            pLong.value++;
        }
        AppMethodBeat.o(18644);
        return length;
    }
}
