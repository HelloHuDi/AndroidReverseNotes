package com.tencent.xweb.xwalk.p686a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.C24532f;
import com.tencent.xweb.xwalk.p686a.C36603f.C36604a;
import com.tencent.xweb.xwalk.p687b.C24553a;
import com.tencent.xweb.xwalk.p687b.C24553a.C16409b;
import com.tencent.xweb.xwalk.p687b.C24553a.C16410c;
import com.tencent.xweb.xwalk.p687b.C24553a.C24554d;
import com.tencent.xweb.xwalk.p687b.C31154b;
import com.tencent.xweb.xwalk.p687b.C6053g;
import com.tencent.xweb.xwalk.p687b.C6053g.C6055a;
import com.tencent.xweb.xwalk.p687b.C6053g.C6057c;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.xwalk.core.Log;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkLibraryLoader.DownloadInfo;
import org.xwalk.core.XWalkLibraryLoader.DownloadListener;
import org.xwalk.core.XWalkLibraryLoader.HttpDownloadTask;
import org.xwalk.core.XWalkLibraryLoader.WXFileDownloaderTask;

/* renamed from: com.tencent.xweb.xwalk.a.g */
public final class C36605g extends AsyncTask<String, Integer, Integer> {
    String ASK = "";
    C36604a ASL = null;
    private final Object ASN = new Object();
    C36606a ASO = new C36606a();
    private Map<String, C31153b> ASP = new HashMap();
    private int ASQ = 0;
    private int ASR = 0;
    private int ASS = 0;
    private int AST = 0;
    private int ASU = 0;
    boolean ASV = false;

    /* renamed from: com.tencent.xweb.xwalk.a.g$1 */
    class C60521 implements C31154b {
        C60521() {
        }

        /* renamed from: a */
        public final void mo13335a(C6057c c6057c) {
            C16410c c16410c;
            AppMethodBeat.m2504i(85422);
            C24532f.dVn();
            String str = c6057c.mFilePath;
            if (str == null) {
                XWalkInitializer.addXWalkInitializeLog("parse plugin config failed ,path is empty");
                c16410c = null;
            } else {
                File file = new File(str);
                if (file.exists()) {
                    c16410c = C24553a.m38222k(file, C24553a.m38217a(file, (int) file.length(), "<Plugins>"));
                } else {
                    XWalkInitializer.addXWalkInitializeLog("parse plugin config failed ,file not exist");
                    c16410c = null;
                }
            }
            if (c16410c == null) {
                XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "parse plugin config failed");
                C24532f.dVp();
                C36605g.m60696a(C36605g.this, -6);
                AppMethodBeat.m2505o(85422);
            } else if (c16410c.ATi == null || c16410c.ATi.length == 0) {
                XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "plugin config contains no plugin");
                C36605g.m60696a(C36605g.this, -7);
                AppMethodBeat.m2505o(85422);
            } else {
                Map hashMap = new HashMap();
                for (C24550c c24550c : C36602e.dVQ()) {
                    if (c24550c == null) {
                        XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "process plugin null");
                    } else if (C36605g.m60695a(C36605g.this) && !C36605g.this.ASK.equals(c24550c.dVM())) {
                        XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "set only update " + C36605g.this.ASK + ", skip " + c24550c.dVM());
                    } else if (!XWalkEnvironment.isForbidDownloadCode() || c24550c.dVN()) {
                        int i = c24550c.ASG;
                        if (C36605g.m60695a(C36605g.this) || c24550c.dVO() || i != -1) {
                            C24554d a = C60521.m9526a(c16410c, c24550c.dVM(), i);
                            if (a == null) {
                                XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "no matched plugin version, skip " + c24550c.dVM());
                            } else {
                                C6051d c6051d = new C6051d();
                                c6051d.version = a.ATk;
                                C16409b a2 = C60521.m9525a(a, i);
                                if (a2 == null) {
                                    c6051d.url = a.ATg;
                                    c6051d.cvZ = a.ATb;
                                    c6051d.path = c24550c.mo13331aM(c6051d.version, false);
                                    c6051d.ASH = a.ATh;
                                    c6051d.ASI = a.bUseCdn;
                                    c6051d.isPatch = false;
                                } else {
                                    c6051d.url = a2.ATg;
                                    c6051d.cvZ = a2.ATb;
                                    c6051d.path = c24550c.mo13331aM(c6051d.version, true);
                                    c6051d.ASH = a2.ATh;
                                    c6051d.ASI = a2.bUseCdn;
                                    c6051d.isPatch = true;
                                }
                                if (c6051d.path == null || c6051d.path.isEmpty()) {
                                    XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "download path is empty, skip " + c24550c.dVM());
                                } else if (!NetworkUtil.isNetworkAvailable()) {
                                    XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "network is not available, skip " + c24550c.dVM());
                                } else if (c6051d.ASH || NetworkUtil.isWifiAvailable()) {
                                    C31153b c31153b = new C31153b();
                                    C24552c c24552c = new C24552c(C36605g.this, c24550c, c6051d);
                                    WXFileDownloaderTask wXFileDownloaderTask = new WXFileDownloaderTask(false, c24552c, c6051d.url, c6051d.path, c6051d.isPatch ? 2 : 1);
                                    if (c6051d.ASI && wXFileDownloaderTask.isValid()) {
                                        XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "use wx file downloader, plugin: " + c24550c.dVM() + "isPatch: " + c6051d.isPatch);
                                        c31153b.fUH = wXFileDownloaderTask;
                                        c31153b.type = 2;
                                    } else {
                                        XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "use default file downloader, plugin: " + c24550c.dVM() + "isPatch: " + c6051d.isPatch);
                                        c31153b.fUH = new HttpDownloadTask(false, c24552c, c6051d.url, c6051d.path);
                                        c31153b.type = 1;
                                    }
                                    hashMap.put(c24550c.dVM(), c31153b);
                                } else {
                                    XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "can not use cellular, skip " + c24550c.dVM());
                                }
                            }
                        } else {
                            XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "not installed before, do not need download now, skip " + c24550c.dVM());
                        }
                    } else {
                        XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "forbid download code, skip " + c24550c.dVM());
                    }
                }
                if (hashMap.size() == 0) {
                    XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "no available update, no task");
                    C36605g.m60696a(C36605g.this, -8);
                    AppMethodBeat.m2505o(85422);
                    return;
                }
                C36605g.m60697a(C36605g.this, hashMap);
                AppMethodBeat.m2505o(85422);
            }
        }

        /* renamed from: b */
        public final void mo13336b(C6057c c6057c) {
            AppMethodBeat.m2504i(85423);
            XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "plugin config download failed: " + c6057c.ATL);
            C24532f.dVo();
            C36605g.m60696a(C36605g.this, -5);
            AppMethodBeat.m2505o(85423);
        }

        /* renamed from: a */
        private static C24554d m9526a(C16410c c16410c, String str, int i) {
            AppMethodBeat.m2504i(85424);
            if (c16410c == null || c16410c.ATi == null || c16410c.ATi.length == 0 || str == null || str.isEmpty()) {
                Log.m81046e("XWalkPluginUp", "findMatchedPluginInfo params error");
                AppMethodBeat.m2505o(85424);
                return null;
            }
            for (C24554d c24554d : c16410c.ATi) {
                if (str.equals(c24554d.ATj) && c24554d.ATk > i && c24554d.AOK.dUw()) {
                    AppMethodBeat.m2505o(85424);
                    return c24554d;
                }
            }
            AppMethodBeat.m2505o(85424);
            return null;
        }

        /* renamed from: a */
        private static C16409b m9525a(C24554d c24554d, int i) {
            if (c24554d == null || c24554d.ATm == null || c24554d.ATm.length == 0) {
                return null;
            }
            for (C16409b c16409b : c24554d.ATm) {
                if (c16409b.ATf == i) {
                    return c16409b;
                }
            }
            return null;
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.a.g$c */
    public static class C24552c implements DownloadListener {
        private C36605g ASM;
        private C24550c ASY;
        private C6051d ASZ;

        /* renamed from: com.tencent.xweb.xwalk.a.g$c$1 */
        class C245511 extends AsyncTask<Void, Void, Integer> {
            C245511() {
            }

            /* Access modifiers changed, original: protected|final|synthetic */
            public final /* synthetic */ void onPostExecute(Object obj) {
                AppMethodBeat.m2504i(85425);
                if (((Integer) obj).intValue() == 0) {
                    C24552c.this.ASM.mo58399eW(C24552c.this.ASY.dVM(), 0);
                    AppMethodBeat.m2505o(85425);
                    return;
                }
                C24552c.this.ASM.mo58399eW(C24552c.this.ASY.dVM(), -2);
                AppMethodBeat.m2505o(85425);
            }

            /* Access modifiers changed, original: protected|final|synthetic */
            public final /* synthetic */ Object doInBackground(Object[] objArr) {
                AppMethodBeat.m2504i(85426);
                if (C24552c.this.ASY == null && C24552c.this.ASZ == null) {
                    Object valueOf = Integer.valueOf(-1);
                    AppMethodBeat.m2505o(85426);
                    return valueOf;
                }
                Integer valueOf2 = Integer.valueOf(C24552c.this.ASY.mo13330a(C24552c.this.ASZ));
                AppMethodBeat.m2505o(85426);
                return valueOf2;
            }
        }

        C24552c(C36605g c36605g, C24550c c24550c, C6051d c6051d) {
            this.ASM = c36605g;
            this.ASY = c24550c;
            this.ASZ = c6051d;
        }

        public final void onDownloadStarted(int i) {
            AppMethodBeat.m2504i(85427);
            if (this.ASY.dVM().equals(XWalkEnvironment.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO)) {
                C24532f.dVq();
            }
            AppMethodBeat.m2505o(85427);
        }

        public final void onDownloadUpdated(int i) {
            AppMethodBeat.m2504i(85428);
            C36605g c36605g = this.ASM;
            String dVM = this.ASY.dVM();
            if (c36605g.ASO.ASX == 3 && c36605g.dVU() && c36605g.ASK.equals(dVM)) {
                c36605g.ASL.mo50916Sy(i);
            }
            AppMethodBeat.m2505o(85428);
        }

        public final void onDownloadCancelled() {
            AppMethodBeat.m2504i(85429);
            this.ASM.mo58399eW(this.ASY.dVM(), -3);
            if (this.ASY.dVM().equals(XWalkEnvironment.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO)) {
                C24532f.dVs();
            }
            AppMethodBeat.m2505o(85429);
        }

        public final void onDownloadCompleted(DownloadInfo downloadInfo) {
            AppMethodBeat.m2504i(85430);
            if (this.ASY.dVM().equals(XWalkEnvironment.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO)) {
                C24532f.dVr();
            }
            new C245511().execute(new Void[0]);
            AppMethodBeat.m2505o(85430);
        }

        public final void onDownloadFailed(DownloadInfo downloadInfo) {
            AppMethodBeat.m2504i(85431);
            this.ASM.mo58399eW(this.ASY.dVM(), -1);
            if (this.ASY.dVM().equals(XWalkEnvironment.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO)) {
                C24532f.dVs();
            }
            AppMethodBeat.m2505o(85431);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.a.g$b */
    public static class C31153b {
        public AsyncTask fUH = null;
        public boolean sle = false;
        public int type = 1;
    }

    /* renamed from: com.tencent.xweb.xwalk.a.g$a */
    public static class C36606a {
        public int ASX = 0;
        public int errCode = 0;
    }

    public C36605g() {
        AppMethodBeat.m2504i(85432);
        AppMethodBeat.m2505o(85432);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m60695a(C36605g c36605g) {
        AppMethodBeat.m2504i(85442);
        boolean dVU = c36605g.dVU();
        AppMethodBeat.m2505o(85442);
        return dVU;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ void onPostExecute(Object obj) {
        AppMethodBeat.m2504i(85439);
        Integer num = (Integer) obj;
        if (num.intValue() == -2 || num.intValue() == -3 || num.intValue() == -4) {
            mo58396a(5, num.intValue(), null);
        } else if (mo58396a(2, 1, null)) {
            C36603f.m60691nQ(System.currentTimeMillis());
            C24532f.dVm();
            C6055a c6055a = new C6055a();
            c6055a.mUrl = XWalkEnvironment.getPluginConfigUrl();
            c6055a.mFilePath = XWalkEnvironment.getPluginUpdateConfigFilePath();
            c6055a.ATJ = true;
            C6053g.m9531a(c6055a, new C60521());
        } else {
            XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "status change to fetch config failed");
        }
        super.onPostExecute(num);
        AppMethodBeat.m2505o(85439);
    }

    /* renamed from: a */
    public final void mo58395a(HashMap<String, String> hashMap, String str, C36604a c36604a) {
        AppMethodBeat.m2504i(85433);
        if (hashMap != null) {
            String str2 = (String) hashMap.get("UpdaterCheckType");
            if (str2 != null && str2.equals("1")) {
                C36603f.m60691nQ(0);
            }
        }
        this.ASK = str;
        this.ASL = c36604a;
        AppMethodBeat.m2505o(85433);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x006e A:{Catch:{ all -> 0x009d }} */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0055 A:{Catch:{ all -> 0x009d }} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006e A:{Catch:{ all -> 0x009d }} */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0055 A:{Catch:{ all -> 0x009d }} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006e A:{Catch:{ all -> 0x009d }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: eW */
    public final void mo58399eW(String str, int i) {
        AppMethodBeat.m2504i(85434);
        XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "onNotifyResult: " + str + " install retCode: " + i);
        synchronized (this.ASN) {
            try {
                if (this.ASO.ASX == 5) {
                } else {
                    Object obj;
                    int i2;
                    int i3;
                    int i4;
                    switch (i) {
                        case -3:
                            this.ASR++;
                        case -2:
                            this.AST++;
                            ((C31153b) this.ASP.get(str)).sle = true;
                            for (Entry value : this.ASP.entrySet()) {
                                C31153b c31153b = (C31153b) value.getValue();
                                if (c31153b != null && !c31153b.sle) {
                                    obj = null;
                                    i2 = this.ASO.ASX;
                                    if (obj != null) {
                                        this.ASP.clear();
                                        this.ASO.ASX = 5;
                                        if (this.ASS > 0 || this.AST > 0) {
                                            this.ASO.errCode = -9;
                                        }
                                    }
                                    i3 = this.ASO.ASX;
                                    i4 = this.ASO.errCode;
                                    m60698aN(i2, i3, i4);
                                    AppMethodBeat.m2505o(85434);
                                }
                            }
                            i3 = 1;
                            i2 = this.ASO.ASX;
                            if (obj != null) {
                            }
                            i3 = this.ASO.ASX;
                            i4 = this.ASO.errCode;
                            m60698aN(i2, i3, i4);
                            AppMethodBeat.m2505o(85434);
                        case -1:
                            this.ASS++;
                        case 0:
                            this.ASU++;
                            ((C31153b) this.ASP.get(str)).sle = true;
                            while (r3.hasNext()) {
                            }
                            i3 = 1;
                            i2 = this.ASO.ASX;
                            if (obj != null) {
                            }
                            i3 = this.ASO.ASX;
                            i4 = this.ASO.errCode;
                            m60698aN(i2, i3, i4);
                            AppMethodBeat.m2505o(85434);
                    }
                    ((C31153b) this.ASP.get(str)).sle = true;
                    while (r3.hasNext()) {
                    }
                    i3 = 1;
                    i2 = this.ASO.ASX;
                    if (obj != null) {
                    }
                    i3 = this.ASO.ASX;
                    i4 = this.ASO.errCode;
                    m60698aN(i2, i3, i4);
                    AppMethodBeat.m2505o(85434);
                }
            } finally {
                AppMethodBeat.m2505o(85434);
            }
        }
    }

    /* renamed from: a */
    public final boolean mo58396a(int i, int i2, Map<String, C31153b> map) {
        int i3;
        int i4;
        int i5;
        AppMethodBeat.m2504i(85435);
        synchronized (this.ASN) {
            try {
                i3 = this.ASO.ASX;
                if (i > i3) {
                    this.ASO.ASX = i;
                    if (i2 != 1) {
                        this.ASO.errCode = i2;
                    }
                    C31153b c31153b;
                    if (this.ASO.ASX == 4) {
                        if (this.ASP.size() == 0) {
                            this.ASO.ASX = 5;
                        } else {
                            for (Entry value : this.ASP.entrySet()) {
                                c31153b = (C31153b) value.getValue();
                                if (!(c31153b == null || c31153b.sle)) {
                                    c31153b.fUH.cancel(true);
                                }
                            }
                        }
                    } else if (this.ASO.ASX == 3 && map != null) {
                        for (Entry value2 : map.entrySet()) {
                            String str = (String) value2.getKey();
                            c31153b = (C31153b) value2.getValue();
                            this.ASP.put(str, c31153b);
                            if (c31153b.type == 1) {
                                ((HttpDownloadTask) c31153b.fUH).execute(new Void[0]);
                            } else if (c31153b.type == 2) {
                                ((WXFileDownloaderTask) c31153b.fUH).execute(new Void[0]);
                            } else {
                                this.ASP.remove(str);
                            }
                        }
                        this.ASQ = this.ASP.size();
                    }
                }
                i4 = this.ASO.ASX;
                i5 = this.ASO.errCode;
            } finally {
                AppMethodBeat.m2505o(85435);
            }
        }
        m60698aN(i3, i4, i5);
        if (i4 > i3) {
            return true;
        }
        AppMethodBeat.m2505o(85435);
        return false;
    }

    /* renamed from: aN */
    private void m60698aN(int i, int i2, int i3) {
        AppMethodBeat.m2504i(85436);
        if (i2 <= i) {
            Log.m81049i("XWalkPluginUp", "status not changed, return");
            AppMethodBeat.m2505o(85436);
            return;
        }
        Log.m81049i("XWalkPluginUp", "change status from " + i + " to " + i2 + " errcode: " + i3);
        if (dVU()) {
            if (i == 0 && i2 == 1) {
                this.ASL.dVI();
            } else if (i != 0 && i2 == 5) {
                this.ASL.mo50917Sz(i3);
            }
        }
        if (i2 == 5) {
            C24532f.m38172bX(15718, this.ASO.errCode + "," + this.ASQ + "," + this.ASR + "," + this.ASS + "," + this.AST + "," + this.ASU);
            C36603f.dVT();
            this.ASV = true;
        }
        AppMethodBeat.m2505o(85436);
    }

    /* Access modifiers changed, original: final */
    public final boolean dVU() {
        AppMethodBeat.m2504i(85437);
        if (this.ASK == null || this.ASK.isEmpty() || this.ASL == null) {
            AppMethodBeat.m2505o(85437);
            return false;
        }
        AppMethodBeat.m2505o(85437);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onPreExecute() {
        AppMethodBeat.m2504i(85438);
        mo58396a(1, 1, null);
        super.onPreExecute();
        AppMethodBeat.m2505o(85438);
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        long j = 0;
        AppMethodBeat.m2504i(85440);
        if (NetworkUtil.isNetworkAvailable()) {
            int i;
            long currentTimeMillis = System.currentTimeMillis();
            SharedPreferences sharedPreferencesForPluginUpdateInfo = XWalkEnvironment.getSharedPreferencesForPluginUpdateInfo();
            if (sharedPreferencesForPluginUpdateInfo == null) {
                XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "get time sp is null");
            } else {
                j = sharedPreferencesForPluginUpdateInfo.getLong(XWalkEnvironment.SP_KEY_PLUGIN_UPDATE_CONFIG_LAST_FETCH_TIME, 0);
            }
            if (currentTimeMillis - j >= 90000000 || currentTimeMillis < j) {
                i = 1;
            } else {
                i = 0;
            }
            Object valueOf;
            if (i == 0) {
                XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "too close, no need to fetch");
                valueOf = Integer.valueOf(-3);
                AppMethodBeat.m2505o(85440);
                return valueOf;
            } else if (C36603f.dVS()) {
                XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "is updating by others, return");
                valueOf = Integer.valueOf(-4);
                AppMethodBeat.m2505o(85440);
                return valueOf;
            } else {
                sharedPreferencesForPluginUpdateInfo = XWalkEnvironment.getSharedPreferencesForPluginUpdateInfo();
                if (sharedPreferencesForPluginUpdateInfo != null) {
                    int myPid = Process.myPid();
                    Editor edit = sharedPreferencesForPluginUpdateInfo.edit();
                    edit.putInt(XWalkEnvironment.SP_KEY_PLUGIN_UPDATE_PROCESS_ID, myPid);
                    edit.commit();
                    XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "plugin update progress start pid ".concat(String.valueOf(myPid)));
                }
                valueOf = Integer.valueOf(0);
                AppMethodBeat.m2505o(85440);
                return valueOf;
            }
        }
        XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "network not available");
        Integer valueOf2 = Integer.valueOf(-2);
        AppMethodBeat.m2505o(85440);
        return valueOf2;
    }
}
