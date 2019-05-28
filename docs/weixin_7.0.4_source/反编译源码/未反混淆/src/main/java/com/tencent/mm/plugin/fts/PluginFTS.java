package com.tencent.mm.plugin.fts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.g.a.cc;
import com.tencent.mm.g.a.d;
import com.tencent.mm.g.a.ts;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class PluginFTS extends f implements com.tencent.mm.kernel.a.b.b, c, n {
    public static boolean mBA;
    private com.tencent.mm.model.cc.a mBB = new com.tencent.mm.model.cc.a() {
        public final boolean aaG() {
            AppMethodBeat.i(136583);
            ab.w("MicroMsg.FTS.PluginFTS", "HERE UninitForUEH is called! stg:%s ", PluginFTS.this.mBs);
            PluginFTS.mBA = true;
            if (PluginFTS.this.mBs != null) {
                PluginFTS.this.mBs.rollback();
                PluginFTS.this.mBs.close();
            }
            AppMethodBeat.o(136583);
            return true;
        }
    };
    private com.tencent.mm.sdk.b.c mBC = new com.tencent.mm.sdk.b.c<cc>() {
        {
            AppMethodBeat.i(136584);
            this.xxI = cc.class.getName().hashCode();
            AppMethodBeat.o(136584);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(136585);
            if (((cc) bVar) instanceof cc) {
                PluginFTS.this.mBC.dead();
                PluginFTS.this.mBu = true;
                ab.i("MicroMsg.FTS.PluginFTS", "All account post reset");
                PluginFTS.access$1200(PluginFTS.this);
            }
            AppMethodBeat.o(136585);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c mBD = new com.tencent.mm.sdk.b.c<d>() {
        {
            AppMethodBeat.i(136586);
            this.xxI = d.class.getName().hashCode();
            AppMethodBeat.o(136586);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            boolean z;
            AppMethodBeat.i(136587);
            d dVar = (d) bVar;
            g access$500 = PluginFTS.this.mBr;
            boolean z2 = dVar.crQ.crR;
            if (access$500.mBh != null) {
                access$500.mBh.hy(z2);
            }
            PluginFTS pluginFTS = PluginFTS.this;
            if (dVar.crQ.crR) {
                z = false;
            } else {
                z = true;
            }
            pluginFTS.mBw = z;
            AppMethodBeat.o(136587);
            return false;
        }
    };
    private com.tencent.mm.ai.f mBE = new com.tencent.mm.ai.f() {
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(136588);
            g.RQ();
            if (bo.h((Integer) g.RP().Ry().get(15, null)) != 0) {
                g.Rg().b(138, PluginFTS.this.mBE);
                PluginFTS.this.mBt = true;
                ab.i("MicroMsg.FTS.PluginFTS", "*** User has finished initializing.");
                PluginFTS.access$1200(PluginFTS.this);
            }
            AppMethodBeat.o(136588);
        }
    };
    private com.tencent.mm.sdk.b.c mBF = new com.tencent.mm.sdk.b.c<ts>() {
        {
            AppMethodBeat.i(136591);
            this.xxI = ts.class.getName().hashCode();
            AppMethodBeat.o(136591);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(136592);
            PluginFTS.this.mBr.a(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, new com.tencent.mm.plugin.fts.a.a.a() {
                String mBP = "";

                public final boolean execute() {
                    AppMethodBeat.i(136589);
                    this.mBP = aa.gw(ah.getContext());
                    PluginFTS.this.mBs.K(-3, (long) this.mBP.hashCode());
                    AppMethodBeat.o(136589);
                    return true;
                }

                public final String toString() {
                    AppMethodBeat.i(136590);
                    String str = "LanguageUpdate(\"" + this.mBP + "\")";
                    AppMethodBeat.o(136590);
                    return str;
                }
            });
            AppMethodBeat.o(136592);
            return false;
        }
    };
    private BroadcastReceiver mBG = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(136593);
            if (intent == null || intent.getAction() == null) {
                AppMethodBeat.o(136593);
                return;
            }
            ab.i("MicroMsg.FTS.PluginFTS", "*** Charging notified: " + intent.getAction());
            if (intent.getAction().equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                PluginFTS.this.mBv = true;
                AppMethodBeat.o(136593);
                return;
            }
            if (intent.getAction().equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                PluginFTS.this.mBv = false;
            }
            AppMethodBeat.o(136593);
        }
    };
    private ConcurrentHashMap<Integer, i> mBH = new ConcurrentHashMap();
    private f mBI;
    private SparseArray<com.tencent.mm.plugin.fts.a.d.d> mBJ = new SparseArray();
    private com.tencent.mm.plugin.fts.a.d.c mBK;
    private SparseArray<com.tencent.mm.plugin.fts.a.d.a.b> mBL = new SparseArray();
    private SparseArray<k> mBM = new SparseArray();
    private com.tencent.mm.sdk.b.c mBN = new com.tencent.mm.sdk.b.c<bc>() {
        {
            AppMethodBeat.i(136580);
            this.xxI = bc.class.getName().hashCode();
            AppMethodBeat.o(136580);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(136581);
            PluginFTS.access$1700(PluginFTS.this);
            AppMethodBeat.o(136581);
            return false;
        }
    };
    private volatile g mBr;
    private volatile d mBs;
    private volatile boolean mBt = false;
    private volatile boolean mBu = false;
    private boolean mBv = false;
    private boolean mBw = false;
    private boolean mBx;
    private Runnable mBy = new Runnable() {
        public final void run() {
            AppMethodBeat.i(136579);
            if (PluginFTS.this.mBs != null) {
                PluginFTS.this.mBs.rollback();
            }
            AppMethodBeat.o(136579);
        }
    };
    private e mBz = new e() {
        public final void bAe() {
            AppMethodBeat.i(136582);
            g.RQ();
            int intValue = ((Integer) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_FTS_MASTER_DB_CORRUPT_REBUILD_TIME_INT_SYNC, Integer.valueOf(3))).intValue();
            ab.e("MicroMsg.FTS.PluginFTS", "DB onCorrupt dbCorruptRebuildTimes: %d", Integer.valueOf(intValue));
            if (intValue > 0) {
                intValue--;
                g.RQ();
                g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_FTS_MASTER_DB_CORRUPT_REBUILD_TIME_INT_SYNC, Integer.valueOf(intValue));
                PluginFTS.access$300(PluginFTS.this);
                PluginFTS.access$400(PluginFTS.this);
                PluginFTS.this.mBs.close();
                d.bAb();
                PluginFTS.this.mBr.a(-131072, new b(PluginFTS.this, (byte) 0));
            }
            AppMethodBeat.o(136582);
        }
    };

    class a extends com.tencent.mm.plugin.fts.a.a.a {
        private a() {
        }

        /* synthetic */ a(PluginFTS pluginFTS, byte b) {
            this();
        }

        public final boolean execute() {
            String[] split;
            AppMethodBeat.i(136597);
            Ng("start");
            try {
                for (String split2 : new String(e.e("assets:///fts_t2s.txt", 0, -1)).split(IOUtils.LINE_SEPARATOR_UNIX)) {
                    split = split2.split(",");
                    com.tencent.mm.plugin.fts.a.g.ghK.put(split[0], split[1]);
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.FTS.PluginFTS", e, e.getMessage(), new Object[0]);
            }
            Ng("t2s");
            try {
                String[] split3 = new String(e.e("assets:///fts_py.txt", 0, -1)).split(IOUtils.LINE_SEPARATOR_UNIX);
                for (String split4 : split3) {
                    int i;
                    split = split4.split(",");
                    Object obj = split[0];
                    String[] strArr = new String[(split.length - 1)];
                    for (i = 0; i < strArr.length; i++) {
                        if (i + 1 < split.length) {
                            strArr[i] = split[i + 1];
                        }
                    }
                    if (strArr.length > 0) {
                        for (String Ni : strArr) {
                            com.tencent.mm.plugin.fts.a.g.mDm.Ni(Ni);
                        }
                        com.tencent.mm.plugin.fts.a.g.mDn.put(obj, strArr);
                    }
                }
            } catch (Exception e2) {
                ab.printErrStackTrace("MicroMsg.FTS.PluginFTS", e2, e2.getMessage(), new Object[0]);
            }
            Ng("py");
            com.tencent.mm.plugin.fts.a.e.mCL.mCN = d.bAc().length() / 1048576;
            com.tencent.mm.plugin.fts.a.e.mCL.mCO = PluginFTS.this.mBs.J(-301, 0);
            com.tencent.mm.plugin.fts.a.e.mCL.mCP = PluginFTS.this.mBs.J(-302, 0);
            com.tencent.mm.plugin.fts.a.e.mCL.mCR = PluginFTS.this.mBs.J(-303, 0);
            com.tencent.mm.plugin.fts.a.e.mCL.mCQ = PluginFTS.this.mBs.J(-304, 0);
            long J = ((n) g.M(n.class)).getFTSIndexDB().J(-300, 0);
            long currentTimeMillis = System.currentTimeMillis();
            if (com.tencent.mm.plugin.fts.a.d.L(J, currentTimeMillis)) {
                ab.i("MicroMsg.FTS.PluginFTS", "not need to report fts data");
            } else {
                com.tencent.mm.plugin.fts.a.e.bAj();
                ((n) g.M(n.class)).getFTSIndexDB().K(-300, currentTimeMillis);
            }
            Ng("reportData");
            AppMethodBeat.o(136597);
            return true;
        }

        public final String aAo() {
            AppMethodBeat.i(136598);
            String format = String.format("{T2S: %d PY: %d}", new Object[]{Integer.valueOf(com.tencent.mm.plugin.fts.a.g.ghK.size()), Integer.valueOf(com.tencent.mm.plugin.fts.a.g.mDn.size())});
            AppMethodBeat.o(136598);
            return format;
        }

        public final String getName() {
            return "InitResourceTask";
        }
    }

    class b extends com.tencent.mm.plugin.fts.a.a.a {
        private b() {
        }

        /* synthetic */ b(PluginFTS pluginFTS, byte b) {
            this();
        }

        public final boolean execute() {
            AppMethodBeat.i(136599);
            g.RQ();
            if (2 != ((Integer) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_FTS_MASTER_DB_VERISON_INT_SYNC, Integer.valueOf(0))).intValue()) {
                d.bAb();
                g.RQ();
                g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_FTS_MASTER_DB_VERISON_INT_SYNC, Integer.valueOf(2));
            }
            g.RQ();
            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(g.RP().cachePath, "IndexMicroMsg.db");
            if (bVar.exists()) {
                bVar.delete();
            } else {
                ab.i("MicroMsg.FTS.PluginFTS", "not exist fts3DBFile %s", j.w(bVar.dMD()));
            }
            g.RQ();
            bVar = new com.tencent.mm.vfs.b(g.RP().cachePath, "FTS5IndexMicroMsg.db");
            if (bVar.exists()) {
                bVar.delete();
            } else {
                ab.i("MicroMsg.FTS.PluginFTS", "not exist fts5DBUnEncrypt %s", j.w(bVar.dMD()));
            }
            try {
                PluginFTS pluginFTS = PluginFTS.this;
                g.RQ();
                pluginFTS.mBs = new d(g.RP().cachePath);
                PluginFTS.access$600(PluginFTS.this);
                PluginFTS.access$700(PluginFTS.this);
                PluginFTS.access$800(PluginFTS.this);
                PluginFTS.access$900(PluginFTS.this);
            } catch (Exception e) {
                if (PluginFTS.mBA) {
                    AppMethodBeat.o(136599);
                } else {
                    ab.printErrStackTrace("MicroMsg.FTS.PluginFTS", e, "Index database corruption detected", new Object[0]);
                    com.tencent.mm.plugin.fts.a.e.vV(19);
                    PluginFTS.access$300(PluginFTS.this);
                    PluginFTS.access$400(PluginFTS.this);
                    if (PluginFTS.this.mBs != null) {
                        PluginFTS.this.mBs.close();
                    }
                    d.bAb();
                    h.pYm.g("FTS", "InitSearchTask: " + Log.getStackTraceString(e), null);
                }
            }
            AppMethodBeat.o(136599);
            return true;
        }

        public final String getName() {
            return "InitSearchTask";
        }
    }

    public PluginFTS() {
        AppMethodBeat.i(136600);
        AppMethodBeat.o(136600);
    }

    static /* synthetic */ void access$1200(PluginFTS pluginFTS) {
        AppMethodBeat.i(136648);
        pluginFTS.waitAndStartDaemon();
        AppMethodBeat.o(136648);
    }

    static /* synthetic */ void access$1700(PluginFTS pluginFTS) {
        AppMethodBeat.i(136649);
        pluginFTS.addCheckLanguageTask();
        AppMethodBeat.o(136649);
    }

    static /* synthetic */ void access$300(PluginFTS pluginFTS) {
        AppMethodBeat.i(136642);
        pluginFTS.destroyNativeLogic();
        AppMethodBeat.o(136642);
    }

    static /* synthetic */ void access$400(PluginFTS pluginFTS) {
        AppMethodBeat.i(136643);
        pluginFTS.destroyStorage();
        AppMethodBeat.o(136643);
    }

    static /* synthetic */ void access$600(PluginFTS pluginFTS) {
        AppMethodBeat.i(136644);
        pluginFTS.registerStorage();
        AppMethodBeat.o(136644);
    }

    static /* synthetic */ void access$700(PluginFTS pluginFTS) {
        AppMethodBeat.i(136645);
        pluginFTS.createIndexStorage();
        AppMethodBeat.o(136645);
    }

    static /* synthetic */ void access$800(PluginFTS pluginFTS) {
        AppMethodBeat.i(136646);
        pluginFTS.registerSearchLogic();
        AppMethodBeat.o(136646);
    }

    static /* synthetic */ void access$900(PluginFTS pluginFTS) {
        AppMethodBeat.i(136647);
        pluginFTS.createNativeLogic();
        AppMethodBeat.o(136647);
    }

    public boolean isCharging() {
        return this.mBv;
    }

    public boolean isInBackground() {
        return this.mBw;
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        AppMethodBeat.i(136601);
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fts.a.c.mCx);
        if (!bVar.exists()) {
            bVar.mkdirs();
        }
        if (this.mBr != null) {
            this.mBr.quit();
        }
        initFTSTaskDaemon();
        Intent registerReceiver = ah.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            boolean z = intExtra == 2 || intExtra == 5;
            this.mBv = z;
        } else {
            this.mBv = false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        ah.getContext().registerReceiver(this.mBG, intentFilter);
        g.RR().a(this.mBB);
        this.mBD.dnU();
        this.mBF.dnU();
        this.mBC.dnU();
        this.mBN.dnU();
        g.Rg().a(138, this.mBE);
        this.mBr.a(-131072, new b(this, (byte) 0));
        this.mBr.a(-131071, new a(this, (byte) 0));
        this.mBK = new c();
        addCheckLanguageTask();
        AppMethodBeat.o(136601);
    }

    public void onAccountRelease() {
        AppMethodBeat.i(136602);
        destroyNativeLogic();
        destroyNativeUILogic();
        destroyItemClickHandler();
        destroyStorage();
        if (this.mBr != null) {
            this.mBr.quit();
            this.mBr = null;
        }
        if (this.mBs != null) {
            this.mBs.close();
            this.mBs = null;
        }
        if (this.mBK != null) {
            this.mBK.bAa();
            this.mBK = null;
        }
        try {
            ah.getContext().unregisterReceiver(this.mBG);
        } catch (Exception e) {
        }
        this.mBD.dead();
        this.mBC.dead();
        this.mBN.dead();
        this.mBF.dead();
        g.Rg().b(138, this.mBE);
        g.RR().b(this.mBB);
        this.mBt = false;
        this.mBu = false;
        AppMethodBeat.o(136602);
    }

    public void execute(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(136603);
        if (gVar.SG()) {
            g.a(ak.class, new com.tencent.mm.plugin.fts.b.f());
        }
        AppMethodBeat.o(136603);
    }

    public void initFTSTaskDaemon() {
        AppMethodBeat.i(136604);
        if (this.mBr == null) {
            this.mBr = new g();
            g gVar = this.mBr;
            if (gVar.mBh == null || !gVar.mBh.isAlive()) {
                gVar.mBh = new a();
                ab.i("MicroMsg.FTS.FTSTaskDaemon", "***** Search daemon initialized, waiting for starting.");
            } else {
                ab.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", new Throwable(), "Duplicated daemon initialization detected, working queue maybe dirty!", new Object[0]);
            }
            gVar = this.mBr;
            Runnable runnable = this.mBy;
            if (gVar.mBh != null) {
                gVar.mBh.mBn = runnable;
            }
            this.mBr.mBh.mBo = this.mBz;
        }
        AppMethodBeat.o(136604);
    }

    public com.tencent.mm.plugin.fts.a.m getFTSTaskDaemon() {
        AppMethodBeat.i(136605);
        initFTSTaskDaemon();
        g gVar = this.mBr;
        AppMethodBeat.o(136605);
        return gVar;
    }

    public d getFTSIndexDB() {
        return this.mBs;
    }

    public void parallelsDependency() {
        AppMethodBeat.i(136606);
        com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).aJ(g.K(com.tencent.mm.plugin.chatroom.a.c.class));
        AppMethodBeat.o(136606);
    }

    private void registerSearchLogic() {
        AppMethodBeat.i(136607);
        registerNativeLogic(1, new com.tencent.mm.plugin.fts.b.e());
        registerNativeLogic(2, new com.tencent.mm.plugin.fts.b.a());
        registerNativeLogic(3, new com.tencent.mm.plugin.fts.b.c());
        registerNativeLogic(4, new com.tencent.mm.plugin.fts.b.b());
        registerNativeLogic(8, new com.tencent.mm.plugin.fts.b.d());
        registerNativeLogic(Downloads.MIN_WAIT_FOR_NETWORK, new com.tencent.mm.plugin.fts.b.g());
        AppMethodBeat.o(136607);
    }

    private void registerStorage() {
        AppMethodBeat.i(136608);
        registerIndexStorage(new com.tencent.mm.plugin.fts.c.e());
        registerIndexStorage(new com.tencent.mm.plugin.fts.c.a());
        registerIndexStorage(new com.tencent.mm.plugin.fts.c.b());
        registerIndexStorage(new com.tencent.mm.plugin.fts.c.c());
        registerIndexStorage(new com.tencent.mm.plugin.fts.c.d());
        AppMethodBeat.o(136608);
    }

    private void createNativeLogic() {
        AppMethodBeat.i(136609);
        ab.i("MicroMsg.FTS.PluginFTS", "Create Native Logic");
        for (int i = 0; i < this.mBM.size(); i++) {
            k kVar = (k) this.mBM.get(this.mBM.keyAt(i));
            if (kVar != null) {
                try {
                    kVar.create();
                } catch (Exception e) {
                    ab.e("MicroMsg.FTS.PluginFTS", "Create Native Logic name=%s \nexception=%s", kVar.getName(), bo.l(e));
                }
            }
        }
        AppMethodBeat.o(136609);
    }

    private void destroyNativeLogic() {
        AppMethodBeat.i(136610);
        ab.i("MicroMsg.FTS.PluginFTS", "Destroy Native Logic");
        for (int i = 0; i < this.mBM.size(); i++) {
            k kVar = (k) this.mBM.get(this.mBM.keyAt(i));
            if (kVar != null) {
                try {
                    kVar.destroy();
                } catch (Exception e) {
                    ab.e("MicroMsg.FTS.PluginFTS", "Create Native Logic name=%s \nexception=%s", kVar.getName(), bo.l(e));
                }
            }
        }
        AppMethodBeat.o(136610);
    }

    private void destroyNativeUILogic() {
        AppMethodBeat.i(136611);
        this.mBJ.clear();
        AppMethodBeat.o(136611);
    }

    private void destroyItemClickHandler() {
        AppMethodBeat.i(136612);
        this.mBL.clear();
        AppMethodBeat.o(136612);
    }

    private void createIndexStorage() {
        AppMethodBeat.i(136613);
        ab.i("MicroMsg.FTS.PluginFTS", "Create Index Storage");
        LinkedList linkedList = new LinkedList();
        for (i add : this.mBH.values()) {
            linkedList.add(add);
        }
        Collections.sort(linkedList);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < linkedList.size()) {
                ((i) linkedList.get(i2)).create();
                i = i2 + 1;
            } else {
                AppMethodBeat.o(136613);
                return;
            }
        }
    }

    private void destroyStorage() {
        AppMethodBeat.i(136614);
        ab.i("MicroMsg.FTS.PluginFTS", "Destroy Index Storage");
        for (i iVar : this.mBH.values()) {
            if (iVar != null) {
                iVar.destroy();
            }
        }
        AppMethodBeat.o(136614);
    }

    private void waitAndStartDaemon() {
        AppMethodBeat.i(136615);
        g.RQ();
        this.mBt = bo.h((Integer) g.RP().Ry().get(15, null)) != 0;
        if (this.mBt) {
            ab.i("MicroMsg.FTS.PluginFTS", "waitAndStartDaemon user is initialized.");
        } else {
            g.Rg().a(138, this.mBE);
            ab.i("MicroMsg.FTS.PluginFTS", "waitAndStartDaemon wait for account initialized");
        }
        if (this.mBu) {
            ab.i("MicroMsg.FTS.PluginFTS", "waitAndStartDaemon all account post reset.");
        } else {
            ab.i("MicroMsg.FTS.PluginFTS", "waitAndStartDaemon wait for all account post reset.");
        }
        if (this.mBt && this.mBu) {
            startDaemon();
        }
        AppMethodBeat.o(136615);
    }

    private void startDaemon() {
        AppMethodBeat.i(136616);
        if (!this.mBr.isStart()) {
            g gVar = this.mBr;
            gVar.mBh.start();
            ab.i("MicroMsg.FTS.FTSTaskDaemon", "***** Search daemon started with TID: " + gVar.mBh.getId());
        }
        AppMethodBeat.o(136616);
    }

    public com.tencent.mm.plugin.fts.a.a.a search(int i, com.tencent.mm.plugin.fts.a.a.i iVar) {
        AppMethodBeat.i(136617);
        com.tencent.mm.plugin.fts.a.a.a bVar;
        if (!isFTSContextReady()) {
            b bVar2 = new b(-2, iVar);
            com.tencent.mm.sdk.g.d.post(bVar2, "FTSExceptionHandler");
            AppMethodBeat.o(136617);
            return bVar2;
        } else if (!isFTSIndexReady()) {
            bVar = new b(-4, iVar);
            com.tencent.mm.sdk.g.d.post(bVar, "FTSExceptionHandler");
            AppMethodBeat.o(136617);
            return bVar;
        } else if (this.mBM.indexOfKey(i) >= 0) {
            k kVar = (k) this.mBM.get(i);
            if (kVar.isCreated()) {
                bVar = kVar.a(iVar);
                AppMethodBeat.o(136617);
                return bVar;
            }
            bVar = new b(-2, iVar);
            com.tencent.mm.sdk.g.d.post(bVar, "FTSExceptionHandler");
            AppMethodBeat.o(136617);
            return bVar;
        } else {
            ab.e("MicroMsg.FTS.PluginFTS", "Not Found Search Logic, LogicArraySize=%d", Integer.valueOf(this.mBM.size()));
            bVar = new b(-2, iVar);
            com.tencent.mm.sdk.g.d.post(bVar, "FTSExceptionHandler");
            AppMethodBeat.o(136617);
            return bVar;
        }
    }

    public void cancelSearchTask(com.tencent.mm.plugin.fts.a.a.a aVar) {
        AppMethodBeat.i(136618);
        if (isFTSContextReady()) {
            g gVar = this.mBr;
            if (gVar.mBh != null) {
                a aVar2 = gVar.mBh;
                aVar.mCancelled = true;
                aVar2.mBj.remove(aVar);
                if (aVar2.mBl == aVar) {
                    aVar2.interrupt();
                }
            }
        }
        AppMethodBeat.o(136618);
    }

    public void updateTopHitsRank(String str, l lVar, int i) {
        AppMethodBeat.i(136619);
        if (isFTSContextReady() && this.mBM.indexOfKey(1) >= 0) {
            ((k) this.mBM.get(1)).a(str, lVar, i, com.tencent.mm.plugin.fts.a.d.bAi());
        }
        AppMethodBeat.o(136619);
    }

    public void addSOSHistory(String str) {
        AppMethodBeat.i(136620);
        if (isFTSContextReady() && this.mBM.indexOfKey(8) >= 0) {
            ((k) this.mBM.get(8)).addSOSHistory(str);
        }
        AppMethodBeat.o(136620);
    }

    public void deleteSOSHistory() {
        AppMethodBeat.i(136621);
        if (isFTSContextReady() && this.mBM.indexOfKey(8) >= 0) {
            ((k) this.mBM.get(8)).deleteSOSHistory();
        }
        AppMethodBeat.o(136621);
    }

    public void deleteSOSHistory(String str) {
        AppMethodBeat.i(136622);
        if (isFTSContextReady() && this.mBM.indexOfKey(8) >= 0) {
            ((k) this.mBM.get(8)).deleteSOSHistory(str);
        }
        AppMethodBeat.o(136622);
    }

    public void registerIndexStorage(i iVar) {
        AppMethodBeat.i(136623);
        this.mBH.put(Integer.valueOf(iVar.getType()), iVar);
        AppMethodBeat.o(136623);
    }

    public void unregisterIndexStorage(int i) {
        AppMethodBeat.i(136624);
        if (this.mBH.containsKey(Integer.valueOf(i))) {
            try {
                ((i) this.mBH.get(Integer.valueOf(i))).destroy();
            } catch (Exception e) {
                ab.e("MicroMsg.FTS.PluginFTS", "Destroy Index Storage name=%s \nexception=%s", r0.getName(), bo.l(e));
            }
        }
        this.mBH.remove(Integer.valueOf(i));
        AppMethodBeat.o(136624);
    }

    public i getFTSIndexStorage(int i) {
        AppMethodBeat.i(136625);
        i iVar = (i) this.mBH.get(Integer.valueOf(i));
        AppMethodBeat.o(136625);
        return iVar;
    }

    public com.tencent.mm.plugin.fts.a.j getFTSMainDB() {
        AppMethodBeat.i(136626);
        if (this.mBI == null) {
            this.mBI = new f();
        }
        f fVar = this.mBI;
        AppMethodBeat.o(136626);
        return fVar;
    }

    public int stringCompareUtfBinary(String str, String str2) {
        AppMethodBeat.i(136627);
        int stringCompareUtfBinary = FTSJNIUtils.stringCompareUtfBinary(str, str2);
        AppMethodBeat.o(136627);
        return stringCompareUtfBinary;
    }

    public void registerFTSUILogic(com.tencent.mm.plugin.fts.a.d.d dVar) {
        AppMethodBeat.i(136628);
        try {
            this.mBJ.put(dVar.getType(), dVar);
            AppMethodBeat.o(136628);
        } catch (Exception e) {
            AppMethodBeat.o(136628);
        }
    }

    public void unregisterFTSUILogic(int i) {
        AppMethodBeat.i(136629);
        try {
            this.mBJ.remove(i);
            AppMethodBeat.o(136629);
        } catch (Exception e) {
            AppMethodBeat.o(136629);
        }
    }

    public void setFTSImageLoader(com.tencent.mm.plugin.fts.a.d.c cVar) {
        this.mBK = cVar;
    }

    public com.tencent.mm.plugin.fts.a.d.c getFTSImageLoader() {
        return this.mBK;
    }

    public LinkedList<com.tencent.mm.plugin.fts.a.d.e> createFTSUIUnitList(HashSet<Integer> hashSet, Context context, com.tencent.mm.plugin.fts.a.d.e.b bVar, int i) {
        AppMethodBeat.i(136630);
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.fts.a.d.d dVar = (com.tencent.mm.plugin.fts.a.d.d) this.mBJ.get(((Integer) it.next()).intValue());
            if (dVar != null) {
                linkedList2.add(dVar);
            }
        }
        Collections.sort(linkedList2);
        Iterator it2 = linkedList2.iterator();
        while (it2.hasNext()) {
            linkedList.add(((com.tencent.mm.plugin.fts.a.d.d) it2.next()).a(context, bVar, i));
        }
        AppMethodBeat.o(136630);
        return linkedList;
    }

    public com.tencent.mm.plugin.fts.a.d.e createFTSUIUnit(int i, Context context, com.tencent.mm.plugin.fts.a.d.e.b bVar, int i2) {
        AppMethodBeat.i(136631);
        com.tencent.mm.plugin.fts.a.d.d dVar = (com.tencent.mm.plugin.fts.a.d.d) this.mBJ.get(i);
        if (dVar != null) {
            com.tencent.mm.plugin.fts.a.d.e a = dVar.a(context, bVar, i2);
            AppMethodBeat.o(136631);
            return a;
        }
        AppMethodBeat.o(136631);
        return null;
    }

    public void registerItemClickHandler(int i, com.tencent.mm.plugin.fts.a.d.a.b bVar) {
        AppMethodBeat.i(136632);
        this.mBL.put(i, bVar);
        AppMethodBeat.o(136632);
    }

    public void unregisterItemClickHandler(int i) {
        AppMethodBeat.i(136633);
        this.mBL.remove(i);
        AppMethodBeat.o(136633);
    }

    public com.tencent.mm.plugin.fts.a.d.a.b getItemClickHandler(int i) {
        AppMethodBeat.i(136634);
        com.tencent.mm.plugin.fts.a.d.a.b bVar = (com.tencent.mm.plugin.fts.a.d.a.b) this.mBL.get(i);
        AppMethodBeat.o(136634);
        return bVar;
    }

    public void registerNativeLogic(int i, k kVar) {
        AppMethodBeat.i(136635);
        this.mBM.put(i, kVar);
        AppMethodBeat.o(136635);
    }

    public void unregisterNativeLogic(int i) {
        AppMethodBeat.i(136636);
        if (this.mBM.indexOfKey(i) >= 0) {
            try {
                ((k) this.mBM.get(i)).destroy();
            } catch (Exception e) {
                ab.e("MicroMsg.FTS.PluginFTS", "Destroy Native Logic name=%s \nexception=%s", r0.getName(), bo.l(e));
            }
        }
        this.mBM.remove(i);
        AppMethodBeat.o(136636);
    }

    public boolean isFTSContextReady() {
        AppMethodBeat.i(136637);
        boolean isStart = getFTSTaskDaemon().isStart();
        AppMethodBeat.o(136637);
        return isStart;
    }

    public boolean isFTSIndexReady() {
        return this.mBx;
    }

    public void setFTSIndexReady(boolean z) {
        AppMethodBeat.i(136638);
        ab.i("MicroMsg.FTS.PluginFTS", "setFTSIndexReady %s", Boolean.valueOf(z));
        this.mBx = z;
        AppMethodBeat.o(136638);
    }

    public com.tencent.mm.plugin.fts.b.e getTopHitsLogic() {
        AppMethodBeat.i(136639);
        com.tencent.mm.plugin.fts.b.e eVar = (com.tencent.mm.plugin.fts.b.e) this.mBM.get(1);
        AppMethodBeat.o(136639);
        return eVar;
    }

    private void addCheckLanguageTask() {
        AppMethodBeat.i(136640);
        ((n) g.M(n.class)).getFTSTaskDaemon().a(65536, new com.tencent.mm.plugin.fts.a.a.a() {
            boolean apm = false;
            String mBR = aa.gw(ah.getContext());

            {
                AppMethodBeat.i(136594);
                AppMethodBeat.o(136594);
            }

            public final boolean execute() {
                AppMethodBeat.i(136595);
                this.apm = ((int) ((n) g.M(n.class)).getFTSIndexDB().J(-3, 0)) != this.mBR.hashCode();
                if (this.apm) {
                    com.tencent.mm.sdk.b.a.xxA.m(new ts());
                }
                AppMethodBeat.o(136595);
                return true;
            }

            public final String aAo() {
                AppMethodBeat.i(136596);
                String format = String.format("{changed: %b}", new Object[]{Boolean.valueOf(this.apm)});
                AppMethodBeat.o(136596);
                return format;
            }

            public final String getName() {
                return "CheckLanguageUpdate";
            }
        });
        AppMethodBeat.o(136640);
    }
}
