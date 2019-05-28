package com.tencent.xweb.xwalk.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.f;
import com.tencent.xweb.xwalk.b.a.d;
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

public final class g extends AsyncTask<String, Integer, Integer> {
    String ASK = "";
    com.tencent.xweb.xwalk.a.f.a ASL = null;
    private final Object ASN = new Object();
    a ASO = new a();
    private Map<String, b> ASP = new HashMap();
    private int ASQ = 0;
    private int ASR = 0;
    private int ASS = 0;
    private int AST = 0;
    private int ASU = 0;
    boolean ASV = false;

    public static class c implements DownloadListener {
        private g ASM;
        private c ASY;
        private d ASZ;

        c(g gVar, c cVar, d dVar) {
            this.ASM = gVar;
            this.ASY = cVar;
            this.ASZ = dVar;
        }

        public final void onDownloadStarted(int i) {
            AppMethodBeat.i(85427);
            if (this.ASY.dVM().equals(XWalkEnvironment.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO)) {
                f.dVq();
            }
            AppMethodBeat.o(85427);
        }

        public final void onDownloadUpdated(int i) {
            AppMethodBeat.i(85428);
            g gVar = this.ASM;
            String dVM = this.ASY.dVM();
            if (gVar.ASO.ASX == 3 && gVar.dVU() && gVar.ASK.equals(dVM)) {
                gVar.ASL.Sy(i);
            }
            AppMethodBeat.o(85428);
        }

        public final void onDownloadCancelled() {
            AppMethodBeat.i(85429);
            this.ASM.eW(this.ASY.dVM(), -3);
            if (this.ASY.dVM().equals(XWalkEnvironment.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO)) {
                f.dVs();
            }
            AppMethodBeat.o(85429);
        }

        public final void onDownloadCompleted(DownloadInfo downloadInfo) {
            AppMethodBeat.i(85430);
            if (this.ASY.dVM().equals(XWalkEnvironment.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO)) {
                f.dVr();
            }
            new AsyncTask<Void, Void, Integer>() {
                /* Access modifiers changed, original: protected|final|synthetic */
                public final /* synthetic */ void onPostExecute(Object obj) {
                    AppMethodBeat.i(85425);
                    if (((Integer) obj).intValue() == 0) {
                        c.this.ASM.eW(c.this.ASY.dVM(), 0);
                        AppMethodBeat.o(85425);
                        return;
                    }
                    c.this.ASM.eW(c.this.ASY.dVM(), -2);
                    AppMethodBeat.o(85425);
                }

                /* Access modifiers changed, original: protected|final|synthetic */
                public final /* synthetic */ Object doInBackground(Object[] objArr) {
                    AppMethodBeat.i(85426);
                    if (c.this.ASY == null && c.this.ASZ == null) {
                        Object valueOf = Integer.valueOf(-1);
                        AppMethodBeat.o(85426);
                        return valueOf;
                    }
                    Integer valueOf2 = Integer.valueOf(c.this.ASY.a(c.this.ASZ));
                    AppMethodBeat.o(85426);
                    return valueOf2;
                }
            }.execute(new Void[0]);
            AppMethodBeat.o(85430);
        }

        public final void onDownloadFailed(DownloadInfo downloadInfo) {
            AppMethodBeat.i(85431);
            this.ASM.eW(this.ASY.dVM(), -1);
            if (this.ASY.dVM().equals(XWalkEnvironment.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO)) {
                f.dVs();
            }
            AppMethodBeat.o(85431);
        }
    }

    public static class b {
        public AsyncTask fUH = null;
        public boolean sle = false;
        public int type = 1;
    }

    public static class a {
        public int ASX = 0;
        public int errCode = 0;
    }

    public g() {
        AppMethodBeat.i(85432);
        AppMethodBeat.o(85432);
    }

    static /* synthetic */ boolean a(g gVar) {
        AppMethodBeat.i(85442);
        boolean dVU = gVar.dVU();
        AppMethodBeat.o(85442);
        return dVU;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ void onPostExecute(Object obj) {
        AppMethodBeat.i(85439);
        Integer num = (Integer) obj;
        if (num.intValue() == -2 || num.intValue() == -3 || num.intValue() == -4) {
            a(5, num.intValue(), null);
        } else if (a(2, 1, null)) {
            f.nQ(System.currentTimeMillis());
            f.dVm();
            com.tencent.xweb.xwalk.b.g.a aVar = new com.tencent.xweb.xwalk.b.g.a();
            aVar.mUrl = XWalkEnvironment.getPluginConfigUrl();
            aVar.mFilePath = XWalkEnvironment.getPluginUpdateConfigFilePath();
            aVar.ATJ = true;
            com.tencent.xweb.xwalk.b.g.a(aVar, new com.tencent.xweb.xwalk.b.b() {
                public final void a(com.tencent.xweb.xwalk.b.g.c cVar) {
                    com.tencent.xweb.xwalk.b.a.c cVar2;
                    AppMethodBeat.i(85422);
                    f.dVn();
                    String str = cVar.mFilePath;
                    if (str == null) {
                        XWalkInitializer.addXWalkInitializeLog("parse plugin config failed ,path is empty");
                        cVar2 = null;
                    } else {
                        File file = new File(str);
                        if (file.exists()) {
                            cVar2 = com.tencent.xweb.xwalk.b.a.k(file, com.tencent.xweb.xwalk.b.a.a(file, (int) file.length(), "<Plugins>"));
                        } else {
                            XWalkInitializer.addXWalkInitializeLog("parse plugin config failed ,file not exist");
                            cVar2 = null;
                        }
                    }
                    if (cVar2 == null) {
                        XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "parse plugin config failed");
                        f.dVp();
                        g.a(g.this, -6);
                        AppMethodBeat.o(85422);
                    } else if (cVar2.ATi == null || cVar2.ATi.length == 0) {
                        XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "plugin config contains no plugin");
                        g.a(g.this, -7);
                        AppMethodBeat.o(85422);
                    } else {
                        Map hashMap = new HashMap();
                        for (c cVar3 : e.dVQ()) {
                            if (cVar3 == null) {
                                XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "process plugin null");
                            } else if (g.a(g.this) && !g.this.ASK.equals(cVar3.dVM())) {
                                XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "set only update " + g.this.ASK + ", skip " + cVar3.dVM());
                            } else if (!XWalkEnvironment.isForbidDownloadCode() || cVar3.dVN()) {
                                int i = cVar3.ASG;
                                if (g.a(g.this) || cVar3.dVO() || i != -1) {
                                    d a = AnonymousClass1.a(cVar2, cVar3.dVM(), i);
                                    if (a == null) {
                                        XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "no matched plugin version, skip " + cVar3.dVM());
                                    } else {
                                        d dVar = new d();
                                        dVar.version = a.ATk;
                                        com.tencent.xweb.xwalk.b.a.b a2 = AnonymousClass1.a(a, i);
                                        if (a2 == null) {
                                            dVar.url = a.ATg;
                                            dVar.cvZ = a.ATb;
                                            dVar.path = cVar3.aM(dVar.version, false);
                                            dVar.ASH = a.ATh;
                                            dVar.ASI = a.bUseCdn;
                                            dVar.isPatch = false;
                                        } else {
                                            dVar.url = a2.ATg;
                                            dVar.cvZ = a2.ATb;
                                            dVar.path = cVar3.aM(dVar.version, true);
                                            dVar.ASH = a2.ATh;
                                            dVar.ASI = a2.bUseCdn;
                                            dVar.isPatch = true;
                                        }
                                        if (dVar.path == null || dVar.path.isEmpty()) {
                                            XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "download path is empty, skip " + cVar3.dVM());
                                        } else if (!NetworkUtil.isNetworkAvailable()) {
                                            XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "network is not available, skip " + cVar3.dVM());
                                        } else if (dVar.ASH || NetworkUtil.isWifiAvailable()) {
                                            b bVar = new b();
                                            c cVar4 = new c(g.this, cVar3, dVar);
                                            WXFileDownloaderTask wXFileDownloaderTask = new WXFileDownloaderTask(false, cVar4, dVar.url, dVar.path, dVar.isPatch ? 2 : 1);
                                            if (dVar.ASI && wXFileDownloaderTask.isValid()) {
                                                XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "use wx file downloader, plugin: " + cVar3.dVM() + "isPatch: " + dVar.isPatch);
                                                bVar.fUH = wXFileDownloaderTask;
                                                bVar.type = 2;
                                            } else {
                                                XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "use default file downloader, plugin: " + cVar3.dVM() + "isPatch: " + dVar.isPatch);
                                                bVar.fUH = new HttpDownloadTask(false, cVar4, dVar.url, dVar.path);
                                                bVar.type = 1;
                                            }
                                            hashMap.put(cVar3.dVM(), bVar);
                                        } else {
                                            XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "can not use cellular, skip " + cVar3.dVM());
                                        }
                                    }
                                } else {
                                    XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "not installed before, do not need download now, skip " + cVar3.dVM());
                                }
                            } else {
                                XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "forbid download code, skip " + cVar3.dVM());
                            }
                        }
                        if (hashMap.size() == 0) {
                            XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "no available update, no task");
                            g.a(g.this, -8);
                            AppMethodBeat.o(85422);
                            return;
                        }
                        g.a(g.this, hashMap);
                        AppMethodBeat.o(85422);
                    }
                }

                public final void b(com.tencent.xweb.xwalk.b.g.c cVar) {
                    AppMethodBeat.i(85423);
                    XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "plugin config download failed: " + cVar.ATL);
                    f.dVo();
                    g.a(g.this, -5);
                    AppMethodBeat.o(85423);
                }

                private static d a(com.tencent.xweb.xwalk.b.a.c cVar, String str, int i) {
                    AppMethodBeat.i(85424);
                    if (cVar == null || cVar.ATi == null || cVar.ATi.length == 0 || str == null || str.isEmpty()) {
                        Log.e("XWalkPluginUp", "findMatchedPluginInfo params error");
                        AppMethodBeat.o(85424);
                        return null;
                    }
                    for (d dVar : cVar.ATi) {
                        if (str.equals(dVar.ATj) && dVar.ATk > i && dVar.AOK.dUw()) {
                            AppMethodBeat.o(85424);
                            return dVar;
                        }
                    }
                    AppMethodBeat.o(85424);
                    return null;
                }

                private static com.tencent.xweb.xwalk.b.a.b a(d dVar, int i) {
                    if (dVar == null || dVar.ATm == null || dVar.ATm.length == 0) {
                        return null;
                    }
                    for (com.tencent.xweb.xwalk.b.a.b bVar : dVar.ATm) {
                        if (bVar.ATf == i) {
                            return bVar;
                        }
                    }
                    return null;
                }
            });
        } else {
            XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "status change to fetch config failed");
        }
        super.onPostExecute(num);
        AppMethodBeat.o(85439);
    }

    public final void a(HashMap<String, String> hashMap, String str, com.tencent.xweb.xwalk.a.f.a aVar) {
        AppMethodBeat.i(85433);
        if (hashMap != null) {
            String str2 = (String) hashMap.get("UpdaterCheckType");
            if (str2 != null && str2.equals("1")) {
                f.nQ(0);
            }
        }
        this.ASK = str;
        this.ASL = aVar;
        AppMethodBeat.o(85433);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x006e A:{Catch:{ all -> 0x009d }} */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0055 A:{Catch:{ all -> 0x009d }} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006e A:{Catch:{ all -> 0x009d }} */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0055 A:{Catch:{ all -> 0x009d }} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006e A:{Catch:{ all -> 0x009d }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void eW(String str, int i) {
        AppMethodBeat.i(85434);
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
                            ((b) this.ASP.get(str)).sle = true;
                            for (Entry value : this.ASP.entrySet()) {
                                b bVar = (b) value.getValue();
                                if (bVar != null && !bVar.sle) {
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
                                    aN(i2, i3, i4);
                                    AppMethodBeat.o(85434);
                                }
                            }
                            i3 = 1;
                            i2 = this.ASO.ASX;
                            if (obj != null) {
                            }
                            i3 = this.ASO.ASX;
                            i4 = this.ASO.errCode;
                            aN(i2, i3, i4);
                            AppMethodBeat.o(85434);
                        case -1:
                            this.ASS++;
                        case 0:
                            this.ASU++;
                            ((b) this.ASP.get(str)).sle = true;
                            while (r3.hasNext()) {
                            }
                            i3 = 1;
                            i2 = this.ASO.ASX;
                            if (obj != null) {
                            }
                            i3 = this.ASO.ASX;
                            i4 = this.ASO.errCode;
                            aN(i2, i3, i4);
                            AppMethodBeat.o(85434);
                    }
                    ((b) this.ASP.get(str)).sle = true;
                    while (r3.hasNext()) {
                    }
                    i3 = 1;
                    i2 = this.ASO.ASX;
                    if (obj != null) {
                    }
                    i3 = this.ASO.ASX;
                    i4 = this.ASO.errCode;
                    aN(i2, i3, i4);
                    AppMethodBeat.o(85434);
                }
            } finally {
                AppMethodBeat.o(85434);
            }
        }
    }

    public final boolean a(int i, int i2, Map<String, b> map) {
        int i3;
        int i4;
        int i5;
        AppMethodBeat.i(85435);
        synchronized (this.ASN) {
            try {
                i3 = this.ASO.ASX;
                if (i > i3) {
                    this.ASO.ASX = i;
                    if (i2 != 1) {
                        this.ASO.errCode = i2;
                    }
                    b bVar;
                    if (this.ASO.ASX == 4) {
                        if (this.ASP.size() == 0) {
                            this.ASO.ASX = 5;
                        } else {
                            for (Entry value : this.ASP.entrySet()) {
                                bVar = (b) value.getValue();
                                if (!(bVar == null || bVar.sle)) {
                                    bVar.fUH.cancel(true);
                                }
                            }
                        }
                    } else if (this.ASO.ASX == 3 && map != null) {
                        for (Entry value2 : map.entrySet()) {
                            String str = (String) value2.getKey();
                            bVar = (b) value2.getValue();
                            this.ASP.put(str, bVar);
                            if (bVar.type == 1) {
                                ((HttpDownloadTask) bVar.fUH).execute(new Void[0]);
                            } else if (bVar.type == 2) {
                                ((WXFileDownloaderTask) bVar.fUH).execute(new Void[0]);
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
                AppMethodBeat.o(85435);
            }
        }
        aN(i3, i4, i5);
        if (i4 > i3) {
            return true;
        }
        AppMethodBeat.o(85435);
        return false;
    }

    private void aN(int i, int i2, int i3) {
        AppMethodBeat.i(85436);
        if (i2 <= i) {
            Log.i("XWalkPluginUp", "status not changed, return");
            AppMethodBeat.o(85436);
            return;
        }
        Log.i("XWalkPluginUp", "change status from " + i + " to " + i2 + " errcode: " + i3);
        if (dVU()) {
            if (i == 0 && i2 == 1) {
                this.ASL.dVI();
            } else if (i != 0 && i2 == 5) {
                this.ASL.Sz(i3);
            }
        }
        if (i2 == 5) {
            f.bX(15718, this.ASO.errCode + "," + this.ASQ + "," + this.ASR + "," + this.ASS + "," + this.AST + "," + this.ASU);
            f.dVT();
            this.ASV = true;
        }
        AppMethodBeat.o(85436);
    }

    /* Access modifiers changed, original: final */
    public final boolean dVU() {
        AppMethodBeat.i(85437);
        if (this.ASK == null || this.ASK.isEmpty() || this.ASL == null) {
            AppMethodBeat.o(85437);
            return false;
        }
        AppMethodBeat.o(85437);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onPreExecute() {
        AppMethodBeat.i(85438);
        a(1, 1, null);
        super.onPreExecute();
        AppMethodBeat.o(85438);
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        long j = 0;
        AppMethodBeat.i(85440);
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
                AppMethodBeat.o(85440);
                return valueOf;
            } else if (f.dVS()) {
                XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "is updating by others, return");
                valueOf = Integer.valueOf(-4);
                AppMethodBeat.o(85440);
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
                AppMethodBeat.o(85440);
                return valueOf;
            }
        }
        XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "network not available");
        Integer valueOf2 = Integer.valueOf(-2);
        AppMethodBeat.o(85440);
        return valueOf2;
    }
}
