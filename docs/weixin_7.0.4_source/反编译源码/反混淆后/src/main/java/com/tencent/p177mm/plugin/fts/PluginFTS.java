package com.tencent.p177mm.plugin.fts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1671c;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.kernel.p238a.p240b.C1654a;
import com.tencent.p177mm.kernel.p238a.p240b.C1655b;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.model.C1841cc.C1840a;
import com.tencent.p177mm.model.C6664ak;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C26111d;
import com.tencent.p177mm.p230g.p231a.C32645ts;
import com.tencent.p177mm.p230g.p231a.C6464cc;
import com.tencent.p177mm.p230g.p231a.C9298bc;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.fts.C43125g.C43124a;
import com.tencent.p177mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.p177mm.plugin.fts.p1265c.C20853a;
import com.tencent.p177mm.plugin.fts.p1265c.C39136b;
import com.tencent.p177mm.plugin.fts.p1265c.C39137d;
import com.tencent.p177mm.plugin.fts.p1265c.C46910c;
import com.tencent.p177mm.plugin.fts.p1265c.C46911e;
import com.tencent.p177mm.plugin.fts.p419a.C12028m;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.C20848k;
import com.tencent.p177mm.plugin.fts.p419a.C28113j;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.fts.p419a.C3163e;
import com.tencent.p177mm.plugin.fts.p419a.C34202c;
import com.tencent.p177mm.plugin.fts.p419a.C34205g;
import com.tencent.p177mm.plugin.fts.p419a.C34207i;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20846i;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28106a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C20847d;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C3159c;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e.C39133b;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3157b;
import com.tencent.p177mm.plugin.fts.p423b.C12036b;
import com.tencent.p177mm.plugin.fts.p423b.C28115a;
import com.tencent.p177mm.plugin.fts.p423b.C34211c;
import com.tencent.p177mm.plugin.fts.p423b.C34219f;
import com.tencent.p177mm.plugin.fts.p423b.C34220g;
import com.tencent.p177mm.plugin.fts.p423b.C39134d;
import com.tencent.p177mm.plugin.fts.p423b.C45971e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.fts.PluginFTS */
public class PluginFTS extends C7597f implements C1655b, C9562c, C12029n {
    public static boolean mBA;
    private C1840a mBB = new C459644();
    private C4884c mBC = new C431185();
    private C4884c mBD = new C208326();
    private C1202f mBE = new C208337();
    private C4884c mBF = new C208348();
    private BroadcastReceiver mBG = new C208369();
    private ConcurrentHashMap<Integer, C34207i> mBH = new ConcurrentHashMap();
    private C43123f mBI;
    private SparseArray<C20847d> mBJ = new SparseArray();
    private C3159c mBK;
    private SparseArray<C3157b> mBL = new SparseArray();
    private SparseArray<C20848k> mBM = new SparseArray();
    private C4884c mBN = new C459632();
    private volatile C43125g mBr;
    private volatile C45972d mBs;
    private volatile boolean mBt = false;
    private volatile boolean mBu = false;
    private boolean mBv = false;
    private boolean mBw = false;
    private boolean mBx;
    private Runnable mBy = new C431171();
    private C39138e mBz = new C412803();

    /* renamed from: com.tencent.mm.plugin.fts.PluginFTS$10 */
    class C1202410 extends C28106a {
        boolean apm = false;
        String mBR = C4988aa.m7403gw(C4996ah.getContext());

        C1202410() {
            AppMethodBeat.m2504i(136594);
            AppMethodBeat.m2505o(136594);
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(136595);
            this.apm = ((int) ((C12029n) C1720g.m3530M(C12029n.class)).getFTSIndexDB().mo54777J(-3, 0)) != this.mBR.hashCode();
            if (this.apm) {
                C4879a.xxA.mo10055m(new C32645ts());
            }
            AppMethodBeat.m2505o(136595);
            return true;
        }

        public final String aAo() {
            AppMethodBeat.m2504i(136596);
            String format = String.format("{changed: %b}", new Object[]{Boolean.valueOf(this.apm)});
            AppMethodBeat.m2505o(136596);
            return format;
        }

        public final String getName() {
            return "CheckLanguageUpdate";
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.PluginFTS$6 */
    class C208326 extends C4884c<C26111d> {
        C208326() {
            AppMethodBeat.m2504i(136586);
            this.xxI = C26111d.class.getName().hashCode();
            AppMethodBeat.m2505o(136586);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            boolean z;
            AppMethodBeat.m2504i(136587);
            C26111d c26111d = (C26111d) c4883b;
            C43125g access$500 = PluginFTS.this.mBr;
            boolean z2 = c26111d.crQ.crR;
            if (access$500.mBh != null) {
                access$500.mBh.mo68633hy(z2);
            }
            PluginFTS pluginFTS = PluginFTS.this;
            if (c26111d.crQ.crR) {
                z = false;
            } else {
                z = true;
            }
            pluginFTS.mBw = z;
            AppMethodBeat.m2505o(136587);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.PluginFTS$7 */
    class C208337 implements C1202f {
        C208337() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(136588);
            C1720g.m3537RQ();
            if (C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(15, null)) != 0) {
                C1720g.m3540Rg().mo14546b(138, PluginFTS.this.mBE);
                PluginFTS.this.mBt = true;
                C4990ab.m7416i("MicroMsg.FTS.PluginFTS", "*** User has finished initializing.");
                PluginFTS.access$1200(PluginFTS.this);
            }
            AppMethodBeat.m2505o(136588);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.PluginFTS$8 */
    class C208348 extends C4884c<C32645ts> {

        /* renamed from: com.tencent.mm.plugin.fts.PluginFTS$8$1 */
        class C208351 extends C28106a {
            String mBP = "";

            C208351() {
            }

            public final boolean execute() {
                AppMethodBeat.m2504i(136589);
                this.mBP = C4988aa.m7403gw(C4996ah.getContext());
                PluginFTS.this.mBs.mo54778K(-3, (long) this.mBP.hashCode());
                AppMethodBeat.m2505o(136589);
                return true;
            }

            public final String toString() {
                AppMethodBeat.m2504i(136590);
                String str = "LanguageUpdate(\"" + this.mBP + "\")";
                AppMethodBeat.m2505o(136590);
                return str;
            }
        }

        C208348() {
            AppMethodBeat.m2504i(136591);
            this.xxI = C32645ts.class.getName().hashCode();
            AppMethodBeat.m2505o(136591);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(136592);
            PluginFTS.this.mBr.mo23853a(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, new C208351());
            AppMethodBeat.m2505o(136592);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.PluginFTS$9 */
    class C208369 extends BroadcastReceiver {
        C208369() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(136593);
            if (intent == null || intent.getAction() == null) {
                AppMethodBeat.m2505o(136593);
                return;
            }
            C4990ab.m7416i("MicroMsg.FTS.PluginFTS", "*** Charging notified: " + intent.getAction());
            if (intent.getAction().equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                PluginFTS.this.mBv = true;
                AppMethodBeat.m2505o(136593);
                return;
            }
            if (intent.getAction().equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                PluginFTS.this.mBv = false;
            }
            AppMethodBeat.m2505o(136593);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.PluginFTS$a */
    class C20837a extends C28106a {
        private C20837a() {
        }

        /* synthetic */ C20837a(PluginFTS pluginFTS, byte b) {
            this();
        }

        public final boolean execute() {
            String[] split;
            AppMethodBeat.m2504i(136597);
            mo46026Ng("start");
            try {
                for (String split2 : new String(C5730e.m8632e("assets:///fts_t2s.txt", 0, -1)).split(IOUtils.LINE_SEPARATOR_UNIX)) {
                    split = split2.split(",");
                    C34205g.ghK.put(split[0], split[1]);
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.FTS.PluginFTS", e, e.getMessage(), new Object[0]);
            }
            mo46026Ng("t2s");
            try {
                String[] split3 = new String(C5730e.m8632e("assets:///fts_py.txt", 0, -1)).split(IOUtils.LINE_SEPARATOR_UNIX);
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
                            C34205g.mDm.mo62033Ni(Ni);
                        }
                        C34205g.mDn.put(obj, strArr);
                    }
                }
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("MicroMsg.FTS.PluginFTS", e2, e2.getMessage(), new Object[0]);
            }
            mo46026Ng("py");
            C3163e.mCL.mCN = C45972d.bAc().length() / 1048576;
            C3163e.mCL.mCO = PluginFTS.this.mBs.mo54777J(-301, 0);
            C3163e.mCL.mCP = PluginFTS.this.mBs.mo54777J(-302, 0);
            C3163e.mCL.mCR = PluginFTS.this.mBs.mo54777J(-303, 0);
            C3163e.mCL.mCQ = PluginFTS.this.mBs.mo54777J(-304, 0);
            long J = ((C12029n) C1720g.m3530M(C12029n.class)).getFTSIndexDB().mo54777J(-300, 0);
            long currentTimeMillis = System.currentTimeMillis();
            if (C3161d.m5400L(J, currentTimeMillis)) {
                C4990ab.m7416i("MicroMsg.FTS.PluginFTS", "not need to report fts data");
            } else {
                C3163e.bAj();
                ((C12029n) C1720g.m3530M(C12029n.class)).getFTSIndexDB().mo54778K(-300, currentTimeMillis);
            }
            mo46026Ng("reportData");
            AppMethodBeat.m2505o(136597);
            return true;
        }

        public final String aAo() {
            AppMethodBeat.m2504i(136598);
            String format = String.format("{T2S: %d PY: %d}", new Object[]{Integer.valueOf(C34205g.ghK.size()), Integer.valueOf(C34205g.mDn.size())});
            AppMethodBeat.m2505o(136598);
            return format;
        }

        public final String getName() {
            return "InitResourceTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.PluginFTS$b */
    class C20838b extends C28106a {
        private C20838b() {
        }

        /* synthetic */ C20838b(PluginFTS pluginFTS, byte b) {
            this();
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(136599);
            C1720g.m3537RQ();
            if (2 != ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_FTS_MASTER_DB_VERISON_INT_SYNC, Integer.valueOf(0))).intValue()) {
                C45972d.bAb();
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_FTS_MASTER_DB_VERISON_INT_SYNC, Integer.valueOf(2));
            }
            C1720g.m3537RQ();
            C5728b c5728b = new C5728b(C1720g.m3536RP().cachePath, "IndexMicroMsg.db");
            if (c5728b.exists()) {
                c5728b.delete();
            } else {
                C4990ab.m7417i("MicroMsg.FTS.PluginFTS", "not exist fts3DBFile %s", C5736j.m8649w(c5728b.dMD()));
            }
            C1720g.m3537RQ();
            c5728b = new C5728b(C1720g.m3536RP().cachePath, "FTS5IndexMicroMsg.db");
            if (c5728b.exists()) {
                c5728b.delete();
            } else {
                C4990ab.m7417i("MicroMsg.FTS.PluginFTS", "not exist fts5DBUnEncrypt %s", C5736j.m8649w(c5728b.dMD()));
            }
            try {
                PluginFTS pluginFTS = PluginFTS.this;
                C1720g.m3537RQ();
                pluginFTS.mBs = new C45972d(C1720g.m3536RP().cachePath);
                PluginFTS.access$600(PluginFTS.this);
                PluginFTS.access$700(PluginFTS.this);
                PluginFTS.access$800(PluginFTS.this);
                PluginFTS.access$900(PluginFTS.this);
            } catch (Exception e) {
                if (PluginFTS.mBA) {
                    AppMethodBeat.m2505o(136599);
                } else {
                    C4990ab.printErrStackTrace("MicroMsg.FTS.PluginFTS", e, "Index database corruption detected", new Object[0]);
                    C3163e.m5423vV(19);
                    PluginFTS.access$300(PluginFTS.this);
                    PluginFTS.access$400(PluginFTS.this);
                    if (PluginFTS.this.mBs != null) {
                        PluginFTS.this.mBs.close();
                    }
                    C45972d.bAb();
                    C7060h.pYm.mo8382g("FTS", "InitSearchTask: " + Log.getStackTraceString(e), null);
                }
            }
            AppMethodBeat.m2505o(136599);
            return true;
        }

        public final String getName() {
            return "InitSearchTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.PluginFTS$3 */
    class C412803 implements C39138e {
        C412803() {
        }

        public final void bAe() {
            AppMethodBeat.m2504i(136582);
            C1720g.m3537RQ();
            int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_FTS_MASTER_DB_CORRUPT_REBUILD_TIME_INT_SYNC, Integer.valueOf(3))).intValue();
            C4990ab.m7413e("MicroMsg.FTS.PluginFTS", "DB onCorrupt dbCorruptRebuildTimes: %d", Integer.valueOf(intValue));
            if (intValue > 0) {
                intValue--;
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_FTS_MASTER_DB_CORRUPT_REBUILD_TIME_INT_SYNC, Integer.valueOf(intValue));
                PluginFTS.access$300(PluginFTS.this);
                PluginFTS.access$400(PluginFTS.this);
                PluginFTS.this.mBs.close();
                C45972d.bAb();
                PluginFTS.this.mBr.mo23853a(-131072, new C20838b(PluginFTS.this, (byte) 0));
            }
            AppMethodBeat.m2505o(136582);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.PluginFTS$1 */
    class C431171 implements Runnable {
        C431171() {
        }

        public final void run() {
            AppMethodBeat.m2504i(136579);
            if (PluginFTS.this.mBs != null) {
                PluginFTS.this.mBs.rollback();
            }
            AppMethodBeat.m2505o(136579);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.PluginFTS$5 */
    class C431185 extends C4884c<C6464cc> {
        C431185() {
            AppMethodBeat.m2504i(136584);
            this.xxI = C6464cc.class.getName().hashCode();
            AppMethodBeat.m2505o(136584);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(136585);
            if (((C6464cc) c4883b) instanceof C6464cc) {
                PluginFTS.this.mBC.dead();
                PluginFTS.this.mBu = true;
                C4990ab.m7416i("MicroMsg.FTS.PluginFTS", "All account post reset");
                PluginFTS.access$1200(PluginFTS.this);
            }
            AppMethodBeat.m2505o(136585);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.PluginFTS$2 */
    class C459632 extends C4884c<C9298bc> {
        C459632() {
            super(0);
            AppMethodBeat.m2504i(136580);
            this.xxI = C9298bc.class.getName().hashCode();
            AppMethodBeat.m2505o(136580);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(136581);
            PluginFTS.access$1700(PluginFTS.this);
            AppMethodBeat.m2505o(136581);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.PluginFTS$4 */
    class C459644 implements C1840a {
        C459644() {
        }

        public final boolean aaG() {
            AppMethodBeat.m2504i(136583);
            C4990ab.m7421w("MicroMsg.FTS.PluginFTS", "HERE UninitForUEH is called! stg:%s ", PluginFTS.this.mBs);
            PluginFTS.mBA = true;
            if (PluginFTS.this.mBs != null) {
                PluginFTS.this.mBs.rollback();
                PluginFTS.this.mBs.close();
            }
            AppMethodBeat.m2505o(136583);
            return true;
        }
    }

    public PluginFTS() {
        AppMethodBeat.m2504i(136600);
        AppMethodBeat.m2505o(136600);
    }

    static /* synthetic */ void access$1200(PluginFTS pluginFTS) {
        AppMethodBeat.m2504i(136648);
        pluginFTS.waitAndStartDaemon();
        AppMethodBeat.m2505o(136648);
    }

    static /* synthetic */ void access$1700(PluginFTS pluginFTS) {
        AppMethodBeat.m2504i(136649);
        pluginFTS.addCheckLanguageTask();
        AppMethodBeat.m2505o(136649);
    }

    static /* synthetic */ void access$300(PluginFTS pluginFTS) {
        AppMethodBeat.m2504i(136642);
        pluginFTS.destroyNativeLogic();
        AppMethodBeat.m2505o(136642);
    }

    static /* synthetic */ void access$400(PluginFTS pluginFTS) {
        AppMethodBeat.m2504i(136643);
        pluginFTS.destroyStorage();
        AppMethodBeat.m2505o(136643);
    }

    static /* synthetic */ void access$600(PluginFTS pluginFTS) {
        AppMethodBeat.m2504i(136644);
        pluginFTS.registerStorage();
        AppMethodBeat.m2505o(136644);
    }

    static /* synthetic */ void access$700(PluginFTS pluginFTS) {
        AppMethodBeat.m2504i(136645);
        pluginFTS.createIndexStorage();
        AppMethodBeat.m2505o(136645);
    }

    static /* synthetic */ void access$800(PluginFTS pluginFTS) {
        AppMethodBeat.m2504i(136646);
        pluginFTS.registerSearchLogic();
        AppMethodBeat.m2505o(136646);
    }

    static /* synthetic */ void access$900(PluginFTS pluginFTS) {
        AppMethodBeat.m2504i(136647);
        pluginFTS.createNativeLogic();
        AppMethodBeat.m2505o(136647);
    }

    public boolean isCharging() {
        return this.mBv;
    }

    public boolean isInBackground() {
        return this.mBw;
    }

    public void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(136601);
        C5728b c5728b = new C5728b(C34202c.mCx);
        if (!c5728b.exists()) {
            c5728b.mkdirs();
        }
        if (this.mBr != null) {
            this.mBr.quit();
        }
        initFTSTaskDaemon();
        Intent registerReceiver = C4996ah.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
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
        C4996ah.getContext().registerReceiver(this.mBG, intentFilter);
        C1720g.m3538RR().mo5418a(this.mBB);
        this.mBD.dnU();
        this.mBF.dnU();
        this.mBC.dnU();
        this.mBN.dnU();
        C1720g.m3540Rg().mo14539a(138, this.mBE);
        this.mBr.mo23853a(-131072, new C20838b(this, (byte) 0));
        this.mBr.mo23853a(-131071, new C20837a(this, (byte) 0));
        this.mBK = new C12054c();
        addCheckLanguageTask();
        AppMethodBeat.m2505o(136601);
    }

    public void onAccountRelease() {
        AppMethodBeat.m2504i(136602);
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
            C4996ah.getContext().unregisterReceiver(this.mBG);
        } catch (Exception e) {
        }
        this.mBD.dead();
        this.mBC.dead();
        this.mBN.dead();
        this.mBF.dead();
        C1720g.m3540Rg().mo14546b(138, this.mBE);
        C1720g.m3538RR().mo5419b(this.mBB);
        this.mBt = false;
        this.mBu = false;
        AppMethodBeat.m2505o(136602);
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(136603);
        if (c1681g.mo5181SG()) {
            C1720g.m3542a(C6664ak.class, new C34219f());
        }
        AppMethodBeat.m2505o(136603);
    }

    public void initFTSTaskDaemon() {
        AppMethodBeat.m2504i(136604);
        if (this.mBr == null) {
            this.mBr = new C43125g();
            C43125g c43125g = this.mBr;
            if (c43125g.mBh == null || !c43125g.mBh.isAlive()) {
                c43125g.mBh = new C43124a();
                C4990ab.m7416i("MicroMsg.FTS.FTSTaskDaemon", "***** Search daemon initialized, waiting for starting.");
            } else {
                C4990ab.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", new Throwable(), "Duplicated daemon initialization detected, working queue maybe dirty!", new Object[0]);
            }
            c43125g = this.mBr;
            Runnable runnable = this.mBy;
            if (c43125g.mBh != null) {
                c43125g.mBh.mBn = runnable;
            }
            this.mBr.mBh.mBo = this.mBz;
        }
        AppMethodBeat.m2505o(136604);
    }

    public C12028m getFTSTaskDaemon() {
        AppMethodBeat.m2504i(136605);
        initFTSTaskDaemon();
        C43125g c43125g = this.mBr;
        AppMethodBeat.m2505o(136605);
        return c43125g;
    }

    public C45972d getFTSIndexDB() {
        return this.mBs;
    }

    public void parallelsDependency() {
        AppMethodBeat.m2504i(136606);
        C1654a.m3349a(this, C1671c.class).mo5129aJ(C1720g.m3528K(C6822c.class));
        AppMethodBeat.m2505o(136606);
    }

    private void registerSearchLogic() {
        AppMethodBeat.m2504i(136607);
        registerNativeLogic(1, new C45971e());
        registerNativeLogic(2, new C28115a());
        registerNativeLogic(3, new C34211c());
        registerNativeLogic(4, new C12036b());
        registerNativeLogic(8, new C39134d());
        registerNativeLogic(Downloads.MIN_WAIT_FOR_NETWORK, new C34220g());
        AppMethodBeat.m2505o(136607);
    }

    private void registerStorage() {
        AppMethodBeat.m2504i(136608);
        registerIndexStorage(new C46911e());
        registerIndexStorage(new C20853a());
        registerIndexStorage(new C39136b());
        registerIndexStorage(new C46910c());
        registerIndexStorage(new C39137d());
        AppMethodBeat.m2505o(136608);
    }

    private void createNativeLogic() {
        AppMethodBeat.m2504i(136609);
        C4990ab.m7416i("MicroMsg.FTS.PluginFTS", "Create Native Logic");
        for (int i = 0; i < this.mBM.size(); i++) {
            C20848k c20848k = (C20848k) this.mBM.get(this.mBM.keyAt(i));
            if (c20848k != null) {
                try {
                    c20848k.create();
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.FTS.PluginFTS", "Create Native Logic name=%s \nexception=%s", c20848k.getName(), C5046bo.m7574l(e));
                }
            }
        }
        AppMethodBeat.m2505o(136609);
    }

    private void destroyNativeLogic() {
        AppMethodBeat.m2504i(136610);
        C4990ab.m7416i("MicroMsg.FTS.PluginFTS", "Destroy Native Logic");
        for (int i = 0; i < this.mBM.size(); i++) {
            C20848k c20848k = (C20848k) this.mBM.get(this.mBM.keyAt(i));
            if (c20848k != null) {
                try {
                    c20848k.destroy();
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.FTS.PluginFTS", "Create Native Logic name=%s \nexception=%s", c20848k.getName(), C5046bo.m7574l(e));
                }
            }
        }
        AppMethodBeat.m2505o(136610);
    }

    private void destroyNativeUILogic() {
        AppMethodBeat.m2504i(136611);
        this.mBJ.clear();
        AppMethodBeat.m2505o(136611);
    }

    private void destroyItemClickHandler() {
        AppMethodBeat.m2504i(136612);
        this.mBL.clear();
        AppMethodBeat.m2505o(136612);
    }

    private void createIndexStorage() {
        AppMethodBeat.m2504i(136613);
        C4990ab.m7416i("MicroMsg.FTS.PluginFTS", "Create Index Storage");
        LinkedList linkedList = new LinkedList();
        for (C34207i add : this.mBH.values()) {
            linkedList.add(add);
        }
        Collections.sort(linkedList);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < linkedList.size()) {
                ((C34207i) linkedList.get(i2)).create();
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(136613);
                return;
            }
        }
    }

    private void destroyStorage() {
        AppMethodBeat.m2504i(136614);
        C4990ab.m7416i("MicroMsg.FTS.PluginFTS", "Destroy Index Storage");
        for (C34207i c34207i : this.mBH.values()) {
            if (c34207i != null) {
                c34207i.destroy();
            }
        }
        AppMethodBeat.m2505o(136614);
    }

    private void waitAndStartDaemon() {
        AppMethodBeat.m2504i(136615);
        C1720g.m3537RQ();
        this.mBt = C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(15, null)) != 0;
        if (this.mBt) {
            C4990ab.m7416i("MicroMsg.FTS.PluginFTS", "waitAndStartDaemon user is initialized.");
        } else {
            C1720g.m3540Rg().mo14539a(138, this.mBE);
            C4990ab.m7416i("MicroMsg.FTS.PluginFTS", "waitAndStartDaemon wait for account initialized");
        }
        if (this.mBu) {
            C4990ab.m7416i("MicroMsg.FTS.PluginFTS", "waitAndStartDaemon all account post reset.");
        } else {
            C4990ab.m7416i("MicroMsg.FTS.PluginFTS", "waitAndStartDaemon wait for all account post reset.");
        }
        if (this.mBt && this.mBu) {
            startDaemon();
        }
        AppMethodBeat.m2505o(136615);
    }

    private void startDaemon() {
        AppMethodBeat.m2504i(136616);
        if (!this.mBr.isStart()) {
            C43125g c43125g = this.mBr;
            c43125g.mBh.start();
            C4990ab.m7416i("MicroMsg.FTS.FTSTaskDaemon", "***** Search daemon started with TID: " + c43125g.mBh.getId());
        }
        AppMethodBeat.m2505o(136616);
    }

    public C28106a search(int i, C20846i c20846i) {
        AppMethodBeat.m2504i(136617);
        C28106a c31363b;
        if (!isFTSContextReady()) {
            C31363b c31363b2 = new C31363b(-2, c20846i);
            C7305d.post(c31363b2, "FTSExceptionHandler");
            AppMethodBeat.m2505o(136617);
            return c31363b2;
        } else if (!isFTSIndexReady()) {
            c31363b = new C31363b(-4, c20846i);
            C7305d.post(c31363b, "FTSExceptionHandler");
            AppMethodBeat.m2505o(136617);
            return c31363b;
        } else if (this.mBM.indexOfKey(i) >= 0) {
            C20848k c20848k = (C20848k) this.mBM.get(i);
            if (c20848k.isCreated()) {
                c31363b = c20848k.mo23884a(c20846i);
                AppMethodBeat.m2505o(136617);
                return c31363b;
            }
            c31363b = new C31363b(-2, c20846i);
            C7305d.post(c31363b, "FTSExceptionHandler");
            AppMethodBeat.m2505o(136617);
            return c31363b;
        } else {
            C4990ab.m7413e("MicroMsg.FTS.PluginFTS", "Not Found Search Logic, LogicArraySize=%d", Integer.valueOf(this.mBM.size()));
            c31363b = new C31363b(-2, c20846i);
            C7305d.post(c31363b, "FTSExceptionHandler");
            AppMethodBeat.m2505o(136617);
            return c31363b;
        }
    }

    public void cancelSearchTask(C28106a c28106a) {
        AppMethodBeat.m2504i(136618);
        if (isFTSContextReady()) {
            C43125g c43125g = this.mBr;
            if (c43125g.mBh != null) {
                C43124a c43124a = c43125g.mBh;
                c28106a.mCancelled = true;
                c43124a.mBj.remove(c28106a);
                if (c43124a.mBl == c28106a) {
                    c43124a.interrupt();
                }
            }
        }
        AppMethodBeat.m2505o(136618);
    }

    public void updateTopHitsRank(String str, C45966l c45966l, int i) {
        AppMethodBeat.m2504i(136619);
        if (isFTSContextReady() && this.mBM.indexOfKey(1) >= 0) {
            ((C20848k) this.mBM.get(1)).mo36116a(str, c45966l, i, C3161d.bAi());
        }
        AppMethodBeat.m2505o(136619);
    }

    public void addSOSHistory(String str) {
        AppMethodBeat.m2504i(136620);
        if (isFTSContextReady() && this.mBM.indexOfKey(8) >= 0) {
            ((C20848k) this.mBM.get(8)).addSOSHistory(str);
        }
        AppMethodBeat.m2505o(136620);
    }

    public void deleteSOSHistory() {
        AppMethodBeat.m2504i(136621);
        if (isFTSContextReady() && this.mBM.indexOfKey(8) >= 0) {
            ((C20848k) this.mBM.get(8)).deleteSOSHistory();
        }
        AppMethodBeat.m2505o(136621);
    }

    public void deleteSOSHistory(String str) {
        AppMethodBeat.m2504i(136622);
        if (isFTSContextReady() && this.mBM.indexOfKey(8) >= 0) {
            ((C20848k) this.mBM.get(8)).deleteSOSHistory(str);
        }
        AppMethodBeat.m2505o(136622);
    }

    public void registerIndexStorage(C34207i c34207i) {
        AppMethodBeat.m2504i(136623);
        this.mBH.put(Integer.valueOf(c34207i.getType()), c34207i);
        AppMethodBeat.m2505o(136623);
    }

    public void unregisterIndexStorage(int i) {
        AppMethodBeat.m2504i(136624);
        if (this.mBH.containsKey(Integer.valueOf(i))) {
            try {
                ((C34207i) this.mBH.get(Integer.valueOf(i))).destroy();
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.FTS.PluginFTS", "Destroy Index Storage name=%s \nexception=%s", r0.getName(), C5046bo.m7574l(e));
            }
        }
        this.mBH.remove(Integer.valueOf(i));
        AppMethodBeat.m2505o(136624);
    }

    public C34207i getFTSIndexStorage(int i) {
        AppMethodBeat.m2504i(136625);
        C34207i c34207i = (C34207i) this.mBH.get(Integer.valueOf(i));
        AppMethodBeat.m2505o(136625);
        return c34207i;
    }

    public C28113j getFTSMainDB() {
        AppMethodBeat.m2504i(136626);
        if (this.mBI == null) {
            this.mBI = new C43123f();
        }
        C43123f c43123f = this.mBI;
        AppMethodBeat.m2505o(136626);
        return c43123f;
    }

    public int stringCompareUtfBinary(String str, String str2) {
        AppMethodBeat.m2504i(136627);
        int stringCompareUtfBinary = FTSJNIUtils.stringCompareUtfBinary(str, str2);
        AppMethodBeat.m2505o(136627);
        return stringCompareUtfBinary;
    }

    public void registerFTSUILogic(C20847d c20847d) {
        AppMethodBeat.m2504i(136628);
        try {
            this.mBJ.put(c20847d.getType(), c20847d);
            AppMethodBeat.m2505o(136628);
        } catch (Exception e) {
            AppMethodBeat.m2505o(136628);
        }
    }

    public void unregisterFTSUILogic(int i) {
        AppMethodBeat.m2504i(136629);
        try {
            this.mBJ.remove(i);
            AppMethodBeat.m2505o(136629);
        } catch (Exception e) {
            AppMethodBeat.m2505o(136629);
        }
    }

    public void setFTSImageLoader(C3159c c3159c) {
        this.mBK = c3159c;
    }

    public C3159c getFTSImageLoader() {
        return this.mBK;
    }

    public LinkedList<C45970e> createFTSUIUnitList(HashSet<Integer> hashSet, Context context, C39133b c39133b, int i) {
        AppMethodBeat.m2504i(136630);
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            C20847d c20847d = (C20847d) this.mBJ.get(((Integer) it.next()).intValue());
            if (c20847d != null) {
                linkedList2.add(c20847d);
            }
        }
        Collections.sort(linkedList2);
        Iterator it2 = linkedList2.iterator();
        while (it2.hasNext()) {
            linkedList.add(((C20847d) it2.next()).mo5978a(context, c39133b, i));
        }
        AppMethodBeat.m2505o(136630);
        return linkedList;
    }

    public C45970e createFTSUIUnit(int i, Context context, C39133b c39133b, int i2) {
        AppMethodBeat.m2504i(136631);
        C20847d c20847d = (C20847d) this.mBJ.get(i);
        if (c20847d != null) {
            C45970e a = c20847d.mo5978a(context, c39133b, i2);
            AppMethodBeat.m2505o(136631);
            return a;
        }
        AppMethodBeat.m2505o(136631);
        return null;
    }

    public void registerItemClickHandler(int i, C3157b c3157b) {
        AppMethodBeat.m2504i(136632);
        this.mBL.put(i, c3157b);
        AppMethodBeat.m2505o(136632);
    }

    public void unregisterItemClickHandler(int i) {
        AppMethodBeat.m2504i(136633);
        this.mBL.remove(i);
        AppMethodBeat.m2505o(136633);
    }

    public C3157b getItemClickHandler(int i) {
        AppMethodBeat.m2504i(136634);
        C3157b c3157b = (C3157b) this.mBL.get(i);
        AppMethodBeat.m2505o(136634);
        return c3157b;
    }

    public void registerNativeLogic(int i, C20848k c20848k) {
        AppMethodBeat.m2504i(136635);
        this.mBM.put(i, c20848k);
        AppMethodBeat.m2505o(136635);
    }

    public void unregisterNativeLogic(int i) {
        AppMethodBeat.m2504i(136636);
        if (this.mBM.indexOfKey(i) >= 0) {
            try {
                ((C20848k) this.mBM.get(i)).destroy();
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.FTS.PluginFTS", "Destroy Native Logic name=%s \nexception=%s", r0.getName(), C5046bo.m7574l(e));
            }
        }
        this.mBM.remove(i);
        AppMethodBeat.m2505o(136636);
    }

    public boolean isFTSContextReady() {
        AppMethodBeat.m2504i(136637);
        boolean isStart = getFTSTaskDaemon().isStart();
        AppMethodBeat.m2505o(136637);
        return isStart;
    }

    public boolean isFTSIndexReady() {
        return this.mBx;
    }

    public void setFTSIndexReady(boolean z) {
        AppMethodBeat.m2504i(136638);
        C4990ab.m7417i("MicroMsg.FTS.PluginFTS", "setFTSIndexReady %s", Boolean.valueOf(z));
        this.mBx = z;
        AppMethodBeat.m2505o(136638);
    }

    public C45971e getTopHitsLogic() {
        AppMethodBeat.m2504i(136639);
        C45971e c45971e = (C45971e) this.mBM.get(1);
        AppMethodBeat.m2505o(136639);
        return c45971e;
    }

    private void addCheckLanguageTask() {
        AppMethodBeat.m2504i(136640);
        ((C12029n) C1720g.m3530M(C12029n.class)).getFTSTaskDaemon().mo23853a(65536, new C1202410());
        AppMethodBeat.m2505o(136640);
    }
}
