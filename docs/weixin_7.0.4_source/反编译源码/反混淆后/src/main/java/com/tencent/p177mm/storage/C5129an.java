package com.tencent.p177mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.util.List;

/* renamed from: com.tencent.mm.storage.an */
final class C5129an {
    protected final long xXI = TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC;
    private C7308am xXJ = new C7308am();

    public C5129an() {
        AppMethodBeat.m2504i(1266);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3537RQ();
        byte[] e = C5730e.m8632e(stringBuilder.append(C1720g.m3536RP().cachePath).append("checkmsgid.ini").toString(), 0, -1);
        if (!C5046bo.m7540cb(e)) {
            try {
                this.xXJ.parseFrom(e);
                if (dsW()) {
                    dsV();
                }
                AppMethodBeat.m2505o(1266);
                return;
            } catch (Exception e2) {
                C4990ab.m7420w("MicroMsg.DelSvrIdMgr", "DelSvrIDs parse Error");
                C4990ab.m7413e("MicroMsg.DelSvrIdMgr", "exception:%s", C5046bo.m7574l(e2));
            }
        }
        AppMethodBeat.m2505o(1266);
    }

    private void dsV() {
        AppMethodBeat.m2504i(1267);
        C4990ab.m7417i("MicroMsg.DelSvrIdMgr", "summerdel toFile tid[%d] [%d, %d ,%d] stack[%s]", Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(this.xXJ.xXF.size()), Integer.valueOf(this.xXJ.xXG.size()), Integer.valueOf(this.xXJ.xXH.size()), C5046bo.dpG());
        try {
            this.xXJ.xXE.clear();
            this.xXJ.xXD.clear();
            this.xXJ.xXC.clear();
            C7308am c7308am = new C7308am();
            c7308am.xXF.addAll(this.xXJ.xXF);
            c7308am.xXG.addAll(this.xXJ.xXG);
            c7308am.xXH.addAll(this.xXJ.xXH);
            byte[] toByteArray = c7308am.toByteArray();
            StringBuilder stringBuilder = new StringBuilder();
            C1720g.m3537RQ();
            C5730e.m8624b(stringBuilder.append(C1720g.m3536RP().cachePath).append("checkmsgid.ini").toString(), toByteArray, toByteArray.length);
            String str = "MicroMsg.DelSvrIdMgr";
            String str2 = "summerdel toFile done [%d, %d, %d] data len[%d]";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(c7308am.xXF.size());
            objArr[1] = Integer.valueOf(c7308am.xXG.size());
            objArr[2] = Integer.valueOf(c7308am.xXH.size());
            objArr[3] = Integer.valueOf(toByteArray == null ? -1 : toByteArray.length);
            C4990ab.m7417i(str, str2, objArr);
            AppMethodBeat.m2505o(1267);
        } catch (Exception e) {
            C7053e.pXa.mo8378a(111, 168, 1, false);
            C4990ab.printErrStackTrace("MicroMsg.DelSvrIdMgr", e, "summerdel ", new Object[0]);
            AppMethodBeat.m2505o(1267);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: mR */
    public final boolean mo10527mR(long j) {
        AppMethodBeat.m2504i(1268);
        if (dsW()) {
            dsV();
        }
        if (this.xXJ.xXF.contains(Long.valueOf(j)) || this.xXJ.xXG.contains(Long.valueOf(j)) || this.xXJ.xXH.contains(Long.valueOf(j))) {
            AppMethodBeat.m2505o(1268);
            return true;
        }
        AppMethodBeat.m2505o(1268);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: m */
    public final void mo10526m(int i, long j, long j2) {
        AppMethodBeat.m2504i(1269);
        mo10525b(i, j, j2, true);
        AppMethodBeat.m2505o(1269);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: b */
    public final void mo10525b(int i, long j, long j2, boolean z) {
        AppMethodBeat.m2504i(1270);
        if (j == 0) {
            AppMethodBeat.m2505o(1270);
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
                C4990ab.m7413e("MicroMsg.DelSvrIdMgr", "should not add to thease lists, dayIndex:%d", Integer.valueOf(i - ((int) (j2 / TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC))));
                break;
        }
        if (z) {
            dsV();
        }
        AppMethodBeat.m2505o(1270);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: p */
    public final void mo10528p(List<Integer> list, List<Long> list2) {
        AppMethodBeat.m2504i(1271);
        C4990ab.m7417i("MicroMsg.DelSvrIdMgr", "add size:%d", Integer.valueOf(list.size()));
        dsW();
        int anT = (int) (C5046bo.anT() / TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC);
        for (int i = 0; i < list.size(); i++) {
            mo10525b(anT, (long) ((Integer) list.get(i)).intValue(), ((Long) list2.get(i)).longValue(), false);
        }
        dsV();
        AppMethodBeat.m2505o(1271);
    }

    private boolean dsW() {
        AppMethodBeat.m2504i(1272);
        C4990ab.m7419v("MicroMsg.DelSvrIdMgr", "checkOldData todayIndex:%d, t0Size:%d, t1Size:%d, t2Size:%d", Integer.valueOf(this.xXJ.xXB), Integer.valueOf(this.xXJ.xXF.size()), Integer.valueOf(this.xXJ.xXG.size()), Integer.valueOf(this.xXJ.xXH.size()));
        int anT = (int) (C5046bo.anT() / TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC);
        int i = anT - this.xXJ.xXB;
        this.xXJ.xXB = anT;
        switch (i) {
            case 0:
                AppMethodBeat.m2505o(1272);
                return false;
            case 1:
                this.xXJ.xXH = this.xXJ.xXG;
                this.xXJ.xXG = this.xXJ.xXF;
                this.xXJ.xXF.clear();
                AppMethodBeat.m2505o(1272);
                return true;
            case 2:
                this.xXJ.xXH = this.xXJ.xXF;
                this.xXJ.xXG.clear();
                this.xXJ.xXF.clear();
                AppMethodBeat.m2505o(1272);
                return true;
            default:
                this.xXJ.xXH.clear();
                this.xXJ.xXG.clear();
                this.xXJ.xXF.clear();
                AppMethodBeat.m2505o(1272);
                return true;
        }
    }
}
