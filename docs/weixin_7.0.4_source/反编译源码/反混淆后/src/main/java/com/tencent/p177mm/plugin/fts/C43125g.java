package com.tencent.p177mm.plugin.fts;

import android.os.Process;
import android.util.Log;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.fts.p419a.C12028m;
import com.tencent.p177mm.plugin.fts.p419a.C3163e;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20844h;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28106a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28106a.C28107a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45967n;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.wcdb.database.SQLiteDatabaseCorruptException;
import com.tencent.wcdb.database.SQLiteDiskIOException;
import com.tencent.wcdb.database.SQLiteException;
import java.util.concurrent.PriorityBlockingQueue;

/* renamed from: com.tencent.mm.plugin.fts.g */
public final class C43125g implements C12028m {
    C43124a mBh = new C43124a();

    /* renamed from: com.tencent.mm.plugin.fts.g$a */
    class C43124a extends Thread {
        int mBi = BaseClientBuilder.API_PRIORITY_OTHER;
        PriorityBlockingQueue<C28106a> mBj = new PriorityBlockingQueue();
        volatile boolean mBk = false;
        C28106a mBl;
        private boolean mBm;
        Runnable mBn;
        C39138e mBo;
        boolean mBp = false;
        private int mTid = 0;

        public C43124a() {
            super("SearchDaemon");
            AppMethodBeat.m2504i(136570);
            AppMethodBeat.m2505o(136570);
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        /* renamed from: vU */
        public final synchronized void mo68636vU(int i) {
            AppMethodBeat.m2504i(136571);
            if (this.mBi == i || !isAlive()) {
                AppMethodBeat.m2505o(136571);
            } else {
                if (i < 0) {
                    if (this.mBi >= 0) {
                        Process.setThreadPriority(this.mTid, -8);
                        this.mBi = i;
                        AppMethodBeat.m2505o(136571);
                    }
                }
                if (i >= 0) {
                    if (this.mBi < 0) {
                        Process.setThreadPriority(this.mTid, this.mBm ? 10 : 0);
                    }
                }
                this.mBi = i;
                AppMethodBeat.m2505o(136571);
            }
        }

        public final synchronized void quit() {
            AppMethodBeat.m2504i(136572);
            this.mBk = true;
            interrupt();
            AppMethodBeat.m2505o(136572);
        }

        /* renamed from: hy */
        public final synchronized void mo68633hy(boolean z) {
            int i = 0;
            synchronized (this) {
                AppMethodBeat.m2504i(136573);
                if (this.mBm == z) {
                    AppMethodBeat.m2505o(136573);
                } else {
                    this.mBm = z;
                    if (this.mBi >= 0 && isAlive() && this.mTid != 0) {
                        if (this.mBm) {
                            i = 10;
                        }
                        try {
                            Process.setThreadPriority(this.mTid, i);
                            C4990ab.m7416i("MicroMsg.FTS.FTSTaskDaemon", "*** Switch priority: " + (this.mBm ? "foreground" : "background"));
                            AppMethodBeat.m2505o(136573);
                        } catch (SecurityException e) {
                            C4990ab.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "setLowPriorityMode failed, tid=%d, p=%d", Integer.valueOf(this.mTid), Integer.valueOf(i));
                        }
                    }
                    AppMethodBeat.m2505o(136573);
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:70:0x01e8 A:{SYNTHETIC, Splitter:B:70:0x01e8} */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x015f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            Throwable e;
            C28106a c28106a;
            AppMethodBeat.m2504i(136574);
            this.mTid = Process.myTid();
            while (true) {
                String name;
                try {
                    Thread.interrupted();
                    if (this.mBk) {
                        C12030a.bzU();
                        this.mBl = null;
                        this.mTid = 0;
                        AppMethodBeat.m2505o(136574);
                        return;
                    }
                    this.mBl = null;
                    C28106a c28106a2 = (C28106a) this.mBj.take();
                    if (c28106a2 == null) {
                        C12030a.bzU();
                        this.mBl = null;
                    } else {
                        try {
                            this.mBl = c28106a2;
                            mo68636vU(c28106a2.getPriority());
                            name = c28106a2.getName();
                            try {
                                String obj;
                                if (C5046bo.isNullOrNil(name)) {
                                    obj = c28106a2.toString();
                                } else {
                                    obj = name;
                                }
                                long currentTimeMillis = System.currentTimeMillis();
                                try {
                                    int i;
                                    String format;
                                    String str;
                                    c28106a2.execute();
                                    c28106a2.mDp = (System.currentTimeMillis() - currentTimeMillis) + c28106a2.mDp;
                                    C3163e.m5419K(c28106a2.getId(), c28106a2.mDp);
                                    C3163e.m5420L(c28106a2.getId(), c28106a2.mDp);
                                    if ((c28106a2.mDq & 1) > 0) {
                                        i = 1;
                                    } else {
                                        i = 0;
                                    }
                                    if (i != 0 && c28106a2.mDp > 1000 && c28106a2.mDp < 3600000) {
                                        C3163e.m5419K(27, c28106a2.mDp);
                                        C3163e.m5420L(27, c28106a2.mDp);
                                    }
                                    if (c28106a2 instanceof C20844h) {
                                        format = String.format("[%s][Request=%s][Result=%s] Done, %dms", new Object[]{obj, r3.mEl.toString(), ((C20844h) c28106a2).mEm.toString(), Long.valueOf(c28106a2.mDp)});
                                        i = r3.mEm.mEy.size();
                                    } else {
                                        format = String.format("[%s] Done, %dms", new Object[]{obj, Long.valueOf(c28106a2.mDp)});
                                        i = 0;
                                    }
                                    C3163e.m5422i(c28106a2.getId(), c28106a2.mDp, (long) i);
                                    if (c28106a2.mDr == null || c28106a2.mDr.size() <= 1) {
                                        try {
                                            str = "";
                                        } catch (Exception e2) {
                                            e = e2;
                                            name = obj;
                                            c28106a = c28106a2;
                                        }
                                    } else {
                                        StringBuffer stringBuffer = new StringBuffer();
                                        for (int i2 = 1; i2 < c28106a2.mDr.size(); i2++) {
                                            C28107a c28107a = (C28107a) c28106a2.mDr.get(i2 - 1);
                                            C28107a c28107a2 = (C28107a) c28106a2.mDr.get(i2);
                                            stringBuffer.append("{");
                                            stringBuffer.append(c28107a2.mDt);
                                            stringBuffer.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                                            stringBuffer.append(c28107a2.timestamp - c28107a.timestamp);
                                            stringBuffer.append("}");
                                        }
                                        str = String.format("%s", new Object[]{stringBuffer.toString()});
                                    }
                                    if (C5046bo.isNullOrNil(str)) {
                                        str = format;
                                    } else {
                                        str = format + " " + str;
                                    }
                                    name = c28106a2.aAo();
                                    if (!C5046bo.isNullOrNil(name)) {
                                        str = str + " " + name;
                                    }
                                    C4990ab.m7416i("MicroMsg.FTS.FTSTaskDaemon", str);
                                    C12030a.bzU();
                                    this.mBl = null;
                                } catch (Exception e3) {
                                    AppMethodBeat.m2505o(136574);
                                    throw e3;
                                } catch (Throwable th) {
                                    c28106a2.mDp = (System.currentTimeMillis() - currentTimeMillis) + c28106a2.mDp;
                                    AppMethodBeat.m2505o(136574);
                                }
                            } catch (Exception e4) {
                                e = e4;
                                c28106a = c28106a2;
                                if (c28106a != null) {
                                }
                            }
                        } catch (Exception e5) {
                            e = e5;
                            name = null;
                            c28106a = c28106a2;
                        }
                    }
                } catch (Exception e6) {
                    e = e6;
                    name = null;
                    c28106a = null;
                    if (c28106a != null) {
                        C12030a.bzU();
                        this.mBl = null;
                    } else {
                        try {
                            if (e instanceof InterruptedException) {
                                if (!c28106a.isCancelled()) {
                                    this.mBj.put(c28106a);
                                }
                                C4990ab.m7417i("MicroMsg.FTS.FTSTaskDaemon", "[%s][cancelled:%b] interruputed! %dms", name, Boolean.valueOf(c28106a.isCancelled()), Long.valueOf(c28106a.mDp));
                            } else if (e instanceof SQLiteDatabaseCorruptException) {
                                C4990ab.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "[%s] failed with exception. \n", name);
                                if (this.mBo != null) {
                                    this.mBo.bAe();
                                }
                                C3163e.m5423vV(18);
                                if (!this.mBp) {
                                    C7060h.pYm.mo8382g("FTS", c28106a + ": " + Log.getStackTraceString(e), null);
                                    this.mBp = true;
                                }
                            } else if (e instanceof C45967n) {
                                C4990ab.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "[%s] failed with exception.\n", name);
                                C3163e.m5423vV(6);
                            } else if (e instanceof SQLiteDiskIOException) {
                                C4990ab.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "[%s] failed with exception.\n", name);
                                C3163e.m5423vV(7);
                            } else if (e instanceof NullPointerException) {
                                C4990ab.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "[%s] failed with exception.\n", name);
                                C3163e.m5423vV(3);
                                if (this.mBn != null) {
                                    this.mBn.run();
                                }
                            } else if (e instanceof SQLiteException) {
                                C4990ab.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "[%s] failed with exception.\n", name);
                                if (e.getMessage() == null || !e.getMessage().contains("the connection is read-only")) {
                                    C3163e.m5423vV(4);
                                } else {
                                    C3163e.m5423vV(17);
                                }
                                if (this.mBn != null) {
                                    this.mBn.run();
                                }
                            } else {
                                C4990ab.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "[%s] failed with exception.\n", name);
                                C3163e.m5423vV(5);
                                if (this.mBn != null) {
                                    this.mBn.run();
                                }
                            }
                            C12030a.bzU();
                            this.mBl = null;
                        } catch (Throwable th2) {
                            C12030a.bzU();
                            this.mBl = null;
                            AppMethodBeat.m2505o(136574);
                        }
                    }
                }
            }
        }
    }

    public C43125g() {
        AppMethodBeat.m2504i(136575);
        AppMethodBeat.m2505o(136575);
    }

    public final boolean isStart() {
        AppMethodBeat.m2504i(136576);
        if (this.mBh == null || !this.mBh.isAlive()) {
            AppMethodBeat.m2505o(136576);
            return false;
        }
        AppMethodBeat.m2505o(136576);
        return true;
    }

    public final void quit() {
        AppMethodBeat.m2504i(136577);
        if (this.mBh == null || !this.mBh.isAlive()) {
            AppMethodBeat.m2505o(136577);
            return;
        }
        this.mBh.quit();
        try {
            this.mBh.join();
        } catch (InterruptedException e) {
        }
        this.mBh = null;
        C4990ab.m7416i("MicroMsg.FTS.FTSTaskDaemon", "***** Search daemon quited.");
        AppMethodBeat.m2505o(136577);
    }

    /* renamed from: a */
    public final C28106a mo23853a(int i, C28106a c28106a) {
        AppMethodBeat.m2504i(136578);
        if (this.mBh == null) {
            AppMethodBeat.m2505o(136578);
            return null;
        }
        c28106a.mPriority = i;
        C43124a c43124a = this.mBh;
        if (!c43124a.mBk) {
            int priority = c28106a.getPriority();
            c43124a.mBj.put(c28106a);
            if (c43124a.mBl == null) {
                c43124a.mo68636vU(priority);
            } else if (priority < c43124a.mBi) {
                c43124a.interrupt();
                c43124a.mo68636vU(priority);
            }
        }
        AppMethodBeat.m2505o(136578);
        return c28106a;
    }
}
