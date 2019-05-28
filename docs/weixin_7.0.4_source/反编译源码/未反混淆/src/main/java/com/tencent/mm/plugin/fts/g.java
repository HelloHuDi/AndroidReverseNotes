package com.tencent.mm.plugin.fts;

import android.os.Process;
import android.util.Log;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.n;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.wcdb.database.SQLiteDatabaseCorruptException;
import com.tencent.wcdb.database.SQLiteDiskIOException;
import com.tencent.wcdb.database.SQLiteException;
import java.util.concurrent.PriorityBlockingQueue;

public final class g implements m {
    a mBh = new a();

    class a extends Thread {
        int mBi = BaseClientBuilder.API_PRIORITY_OTHER;
        PriorityBlockingQueue<com.tencent.mm.plugin.fts.a.a.a> mBj = new PriorityBlockingQueue();
        volatile boolean mBk = false;
        com.tencent.mm.plugin.fts.a.a.a mBl;
        private boolean mBm;
        Runnable mBn;
        e mBo;
        boolean mBp = false;
        private int mTid = 0;

        public a() {
            super("SearchDaemon");
            AppMethodBeat.i(136570);
            AppMethodBeat.o(136570);
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized void vU(int i) {
            AppMethodBeat.i(136571);
            if (this.mBi == i || !isAlive()) {
                AppMethodBeat.o(136571);
            } else {
                if (i < 0) {
                    if (this.mBi >= 0) {
                        Process.setThreadPriority(this.mTid, -8);
                        this.mBi = i;
                        AppMethodBeat.o(136571);
                    }
                }
                if (i >= 0) {
                    if (this.mBi < 0) {
                        Process.setThreadPriority(this.mTid, this.mBm ? 10 : 0);
                    }
                }
                this.mBi = i;
                AppMethodBeat.o(136571);
            }
        }

        public final synchronized void quit() {
            AppMethodBeat.i(136572);
            this.mBk = true;
            interrupt();
            AppMethodBeat.o(136572);
        }

        public final synchronized void hy(boolean z) {
            int i = 0;
            synchronized (this) {
                AppMethodBeat.i(136573);
                if (this.mBm == z) {
                    AppMethodBeat.o(136573);
                } else {
                    this.mBm = z;
                    if (this.mBi >= 0 && isAlive() && this.mTid != 0) {
                        if (this.mBm) {
                            i = 10;
                        }
                        try {
                            Process.setThreadPriority(this.mTid, i);
                            ab.i("MicroMsg.FTS.FTSTaskDaemon", "*** Switch priority: " + (this.mBm ? "foreground" : "background"));
                            AppMethodBeat.o(136573);
                        } catch (SecurityException e) {
                            ab.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "setLowPriorityMode failed, tid=%d, p=%d", Integer.valueOf(this.mTid), Integer.valueOf(i));
                        }
                    }
                    AppMethodBeat.o(136573);
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:70:0x01e8 A:{SYNTHETIC, Splitter:B:70:0x01e8} */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x015f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            Throwable e;
            com.tencent.mm.plugin.fts.a.a.a aVar;
            AppMethodBeat.i(136574);
            this.mTid = Process.myTid();
            while (true) {
                String name;
                try {
                    Thread.interrupted();
                    if (this.mBk) {
                        a.bzU();
                        this.mBl = null;
                        this.mTid = 0;
                        AppMethodBeat.o(136574);
                        return;
                    }
                    this.mBl = null;
                    com.tencent.mm.plugin.fts.a.a.a aVar2 = (com.tencent.mm.plugin.fts.a.a.a) this.mBj.take();
                    if (aVar2 == null) {
                        a.bzU();
                        this.mBl = null;
                    } else {
                        try {
                            this.mBl = aVar2;
                            vU(aVar2.getPriority());
                            name = aVar2.getName();
                            try {
                                String obj;
                                if (bo.isNullOrNil(name)) {
                                    obj = aVar2.toString();
                                } else {
                                    obj = name;
                                }
                                long currentTimeMillis = System.currentTimeMillis();
                                try {
                                    int i;
                                    String format;
                                    String str;
                                    aVar2.execute();
                                    aVar2.mDp = (System.currentTimeMillis() - currentTimeMillis) + aVar2.mDp;
                                    e.K(aVar2.getId(), aVar2.mDp);
                                    e.L(aVar2.getId(), aVar2.mDp);
                                    if ((aVar2.mDq & 1) > 0) {
                                        i = 1;
                                    } else {
                                        i = 0;
                                    }
                                    if (i != 0 && aVar2.mDp > 1000 && aVar2.mDp < 3600000) {
                                        e.K(27, aVar2.mDp);
                                        e.L(27, aVar2.mDp);
                                    }
                                    if (aVar2 instanceof h) {
                                        format = String.format("[%s][Request=%s][Result=%s] Done, %dms", new Object[]{obj, r3.mEl.toString(), ((h) aVar2).mEm.toString(), Long.valueOf(aVar2.mDp)});
                                        i = r3.mEm.mEy.size();
                                    } else {
                                        format = String.format("[%s] Done, %dms", new Object[]{obj, Long.valueOf(aVar2.mDp)});
                                        i = 0;
                                    }
                                    e.i(aVar2.getId(), aVar2.mDp, (long) i);
                                    if (aVar2.mDr == null || aVar2.mDr.size() <= 1) {
                                        try {
                                            str = "";
                                        } catch (Exception e2) {
                                            e = e2;
                                            name = obj;
                                            aVar = aVar2;
                                        }
                                    } else {
                                        StringBuffer stringBuffer = new StringBuffer();
                                        for (int i2 = 1; i2 < aVar2.mDr.size(); i2++) {
                                            com.tencent.mm.plugin.fts.a.a.a.a aVar3 = (com.tencent.mm.plugin.fts.a.a.a.a) aVar2.mDr.get(i2 - 1);
                                            com.tencent.mm.plugin.fts.a.a.a.a aVar4 = (com.tencent.mm.plugin.fts.a.a.a.a) aVar2.mDr.get(i2);
                                            stringBuffer.append("{");
                                            stringBuffer.append(aVar4.mDt);
                                            stringBuffer.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                                            stringBuffer.append(aVar4.timestamp - aVar3.timestamp);
                                            stringBuffer.append("}");
                                        }
                                        str = String.format("%s", new Object[]{stringBuffer.toString()});
                                    }
                                    if (bo.isNullOrNil(str)) {
                                        str = format;
                                    } else {
                                        str = format + " " + str;
                                    }
                                    name = aVar2.aAo();
                                    if (!bo.isNullOrNil(name)) {
                                        str = str + " " + name;
                                    }
                                    ab.i("MicroMsg.FTS.FTSTaskDaemon", str);
                                    a.bzU();
                                    this.mBl = null;
                                } catch (Exception e3) {
                                    AppMethodBeat.o(136574);
                                    throw e3;
                                } catch (Throwable th) {
                                    aVar2.mDp = (System.currentTimeMillis() - currentTimeMillis) + aVar2.mDp;
                                    AppMethodBeat.o(136574);
                                }
                            } catch (Exception e4) {
                                e = e4;
                                aVar = aVar2;
                                if (aVar != null) {
                                }
                            }
                        } catch (Exception e5) {
                            e = e5;
                            name = null;
                            aVar = aVar2;
                        }
                    }
                } catch (Exception e6) {
                    e = e6;
                    name = null;
                    aVar = null;
                    if (aVar != null) {
                        a.bzU();
                        this.mBl = null;
                    } else {
                        try {
                            if (e instanceof InterruptedException) {
                                if (!aVar.isCancelled()) {
                                    this.mBj.put(aVar);
                                }
                                ab.i("MicroMsg.FTS.FTSTaskDaemon", "[%s][cancelled:%b] interruputed! %dms", name, Boolean.valueOf(aVar.isCancelled()), Long.valueOf(aVar.mDp));
                            } else if (e instanceof SQLiteDatabaseCorruptException) {
                                ab.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "[%s] failed with exception. \n", name);
                                if (this.mBo != null) {
                                    this.mBo.bAe();
                                }
                                e.vV(18);
                                if (!this.mBp) {
                                    com.tencent.mm.plugin.report.service.h.pYm.g("FTS", aVar + ": " + Log.getStackTraceString(e), null);
                                    this.mBp = true;
                                }
                            } else if (e instanceof n) {
                                ab.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "[%s] failed with exception.\n", name);
                                e.vV(6);
                            } else if (e instanceof SQLiteDiskIOException) {
                                ab.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "[%s] failed with exception.\n", name);
                                e.vV(7);
                            } else if (e instanceof NullPointerException) {
                                ab.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "[%s] failed with exception.\n", name);
                                e.vV(3);
                                if (this.mBn != null) {
                                    this.mBn.run();
                                }
                            } else if (e instanceof SQLiteException) {
                                ab.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "[%s] failed with exception.\n", name);
                                if (e.getMessage() == null || !e.getMessage().contains("the connection is read-only")) {
                                    e.vV(4);
                                } else {
                                    e.vV(17);
                                }
                                if (this.mBn != null) {
                                    this.mBn.run();
                                }
                            } else {
                                ab.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "[%s] failed with exception.\n", name);
                                e.vV(5);
                                if (this.mBn != null) {
                                    this.mBn.run();
                                }
                            }
                            a.bzU();
                            this.mBl = null;
                        } catch (Throwable th2) {
                            a.bzU();
                            this.mBl = null;
                            AppMethodBeat.o(136574);
                        }
                    }
                }
            }
        }
    }

    public g() {
        AppMethodBeat.i(136575);
        AppMethodBeat.o(136575);
    }

    public final boolean isStart() {
        AppMethodBeat.i(136576);
        if (this.mBh == null || !this.mBh.isAlive()) {
            AppMethodBeat.o(136576);
            return false;
        }
        AppMethodBeat.o(136576);
        return true;
    }

    public final void quit() {
        AppMethodBeat.i(136577);
        if (this.mBh == null || !this.mBh.isAlive()) {
            AppMethodBeat.o(136577);
            return;
        }
        this.mBh.quit();
        try {
            this.mBh.join();
        } catch (InterruptedException e) {
        }
        this.mBh = null;
        ab.i("MicroMsg.FTS.FTSTaskDaemon", "***** Search daemon quited.");
        AppMethodBeat.o(136577);
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(int i, com.tencent.mm.plugin.fts.a.a.a aVar) {
        AppMethodBeat.i(136578);
        if (this.mBh == null) {
            AppMethodBeat.o(136578);
            return null;
        }
        aVar.mPriority = i;
        a aVar2 = this.mBh;
        if (!aVar2.mBk) {
            int priority = aVar.getPriority();
            aVar2.mBj.put(aVar);
            if (aVar2.mBl == null) {
                aVar2.vU(priority);
            } else if (priority < aVar2.mBi) {
                aVar2.interrupt();
                aVar2.vU(priority);
            }
        }
        AppMethodBeat.o(136578);
        return aVar;
    }
}
