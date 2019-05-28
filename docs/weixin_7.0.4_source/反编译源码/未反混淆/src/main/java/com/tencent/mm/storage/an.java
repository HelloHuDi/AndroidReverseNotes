package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.util.List;

final class an {
    protected final long xXI = TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC;
    private am xXJ = new am();

    public an() {
        AppMethodBeat.i(1266);
        StringBuilder stringBuilder = new StringBuilder();
        g.RQ();
        byte[] e = e.e(stringBuilder.append(g.RP().cachePath).append("checkmsgid.ini").toString(), 0, -1);
        if (!bo.cb(e)) {
            try {
                this.xXJ.parseFrom(e);
                if (dsW()) {
                    dsV();
                }
                AppMethodBeat.o(1266);
                return;
            } catch (Exception e2) {
                ab.w("MicroMsg.DelSvrIdMgr", "DelSvrIDs parse Error");
                ab.e("MicroMsg.DelSvrIdMgr", "exception:%s", bo.l(e2));
            }
        }
        AppMethodBeat.o(1266);
    }

    private void dsV() {
        AppMethodBeat.i(1267);
        ab.i("MicroMsg.DelSvrIdMgr", "summerdel toFile tid[%d] [%d, %d ,%d] stack[%s]", Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(this.xXJ.xXF.size()), Integer.valueOf(this.xXJ.xXG.size()), Integer.valueOf(this.xXJ.xXH.size()), bo.dpG());
        try {
            this.xXJ.xXE.clear();
            this.xXJ.xXD.clear();
            this.xXJ.xXC.clear();
            am amVar = new am();
            amVar.xXF.addAll(this.xXJ.xXF);
            amVar.xXG.addAll(this.xXJ.xXG);
            amVar.xXH.addAll(this.xXJ.xXH);
            byte[] toByteArray = amVar.toByteArray();
            StringBuilder stringBuilder = new StringBuilder();
            g.RQ();
            e.b(stringBuilder.append(g.RP().cachePath).append("checkmsgid.ini").toString(), toByteArray, toByteArray.length);
            String str = "MicroMsg.DelSvrIdMgr";
            String str2 = "summerdel toFile done [%d, %d, %d] data len[%d]";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(amVar.xXF.size());
            objArr[1] = Integer.valueOf(amVar.xXG.size());
            objArr[2] = Integer.valueOf(amVar.xXH.size());
            objArr[3] = Integer.valueOf(toByteArray == null ? -1 : toByteArray.length);
            ab.i(str, str2, objArr);
            AppMethodBeat.o(1267);
        } catch (Exception e) {
            com.tencent.mm.plugin.report.e.pXa.a(111, 168, 1, false);
            ab.printErrStackTrace("MicroMsg.DelSvrIdMgr", e, "summerdel ", new Object[0]);
            AppMethodBeat.o(1267);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean mR(long j) {
        AppMethodBeat.i(1268);
        if (dsW()) {
            dsV();
        }
        if (this.xXJ.xXF.contains(Long.valueOf(j)) || this.xXJ.xXG.contains(Long.valueOf(j)) || this.xXJ.xXH.contains(Long.valueOf(j))) {
            AppMethodBeat.o(1268);
            return true;
        }
        AppMethodBeat.o(1268);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void m(int i, long j, long j2) {
        AppMethodBeat.i(1269);
        b(i, j, j2, true);
        AppMethodBeat.o(1269);
    }

    /* Access modifiers changed, original: protected|final */
    public final void b(int i, long j, long j2, boolean z) {
        AppMethodBeat.i(1270);
        if (j == 0) {
            AppMethodBeat.o(1270);
            return;
        }
        if (z) {
            dsW();
        }
        switch (i - ((int) (j2 / TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC))) {
            case 0:
                this.xXJ.xXF.add(Long.valueOf(j));
                break;
            case 1:
                this.xXJ.xXG.add(Long.valueOf(j));
                break;
            case 2:
                this.xXJ.xXH.add(Long.valueOf(j));
                break;
            default:
                ab.e("MicroMsg.DelSvrIdMgr", "should not add to thease lists, dayIndex:%d", Integer.valueOf(i - ((int) (j2 / TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC))));
                break;
        }
        if (z) {
            dsV();
        }
        AppMethodBeat.o(1270);
    }

    /* Access modifiers changed, original: protected|final */
    public final void p(List<Integer> list, List<Long> list2) {
        AppMethodBeat.i(1271);
        ab.i("MicroMsg.DelSvrIdMgr", "add size:%d", Integer.valueOf(list.size()));
        dsW();
        int anT = (int) (bo.anT() / TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC);
        for (int i = 0; i < list.size(); i++) {
            b(anT, (long) ((Integer) list.get(i)).intValue(), ((Long) list2.get(i)).longValue(), false);
        }
        dsV();
        AppMethodBeat.o(1271);
    }

    private boolean dsW() {
        AppMethodBeat.i(1272);
        ab.v("MicroMsg.DelSvrIdMgr", "checkOldData todayIndex:%d, t0Size:%d, t1Size:%d, t2Size:%d", Integer.valueOf(this.xXJ.xXB), Integer.valueOf(this.xXJ.xXF.size()), Integer.valueOf(this.xXJ.xXG.size()), Integer.valueOf(this.xXJ.xXH.size()));
        int anT = (int) (bo.anT() / TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC);
        int i = anT - this.xXJ.xXB;
        this.xXJ.xXB = anT;
        switch (i) {
            case 0:
                AppMethodBeat.o(1272);
                return false;
            case 1:
                this.xXJ.xXH = this.xXJ.xXG;
                this.xXJ.xXG = this.xXJ.xXF;
                this.xXJ.xXF.clear();
                AppMethodBeat.o(1272);
                return true;
            case 2:
                this.xXJ.xXH = this.xXJ.xXF;
                this.xXJ.xXG.clear();
                this.xXJ.xXF.clear();
                AppMethodBeat.o(1272);
                return true;
            default:
                this.xXJ.xXH.clear();
                this.xXJ.xXG.clear();
                this.xXJ.xXF.clear();
                AppMethodBeat.o(1272);
                return true;
        }
    }
}
