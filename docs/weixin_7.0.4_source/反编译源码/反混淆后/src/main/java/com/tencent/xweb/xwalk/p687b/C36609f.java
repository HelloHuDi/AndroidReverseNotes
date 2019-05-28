package com.tencent.xweb.xwalk.p687b;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Process;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.xweb.C16403w;
import com.tencent.xweb.C44572a;
import com.tencent.xweb.XWebCoreContentProvider;
import com.tencent.xweb.util.C24532f;
import com.tencent.xweb.xwalk.C6060b;
import com.tencent.xweb.xwalk.p687b.C24553a.C16409b;
import com.tencent.xweb.xwalk.p687b.C24553a.C16411e;
import com.tencent.xweb.xwalk.p687b.C24553a.C24555a;
import com.tencent.xweb.xwalk.p687b.C41136c.C31155a;
import com.tencent.xweb.xwalk.p687b.C6053g.C6055a;
import com.tencent.xweb.xwalk.p687b.C6053g.C6057c;
import java.util.HashMap;
import org.xwalk.core.Log;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWalkUpdater.ErrorInfo;

/* renamed from: com.tencent.xweb.xwalk.b.f */
public final class C36609f extends AsyncTask<String, Integer, Integer> {
    static XWalkUpdater ASF;
    private static String ATD = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    private HashMap<String, String> ATC;

    /* renamed from: com.tencent.xweb.xwalk.b.f$1 */
    static class C366101 implements C31154b {
        C366101() {
        }

        /* renamed from: a */
        public final void mo13335a(C6057c c6057c) {
            boolean z = false;
            AppMethodBeat.m2504i(85479);
            C24555a avv = C24553a.avv(c6057c.mFilePath);
            if (avv == null) {
                C24532f.m38181nI(35);
                C24532f.dVf();
                C24532f.m38172bX(15123, "0,190301," + c6057c.ATL + "," + c6057c.mNetWorkType + "," + c6057c.mRetryTimes + "," + c6057c.ATM + "," + c6057c.mTotalSize);
                XWalkEnvironment.addXWalkInitializeLog("ConfigParser failed ");
                C6060b dUo = C16403w.dUo();
                if (dUo != null) {
                    dUo.aMA();
                }
                AppMethodBeat.m2505o(85479);
                return;
            }
            C31155a c31155a;
            try {
                C44572a.m80956a(avv.ATe, avv.ATc);
            } catch (Exception e) {
                XWalkEnvironment.addXWalkInitializeLog("apply cmds failed , " + e.getMessage());
            }
            XWalkEnvironment.addXWalkInitializeLog("doFetchUpdateConfigNew onTaskSucceed!!");
            C24532f.m38186nN(c6057c.ATM);
            C24532f.m38172bX(15123, avv.ATc + ",190301," + c6057c.ATL + "," + c6057c.mNetWorkType + "," + c6057c.mRetryTimes + "," + c6057c.ATM + "," + c6057c.mTotalSize + "," + C36609f.ATD);
            C41136c.dVV();
            if (avv != null) {
                Log.m81049i("Scheduler", "onConfigDownLoaded get config ,config version is " + avv.ATc);
                if (!XWalkEnvironment.isForbidDownloadCode() || XWalkEnvironment.isInTestMode()) {
                    C31155a dWd = C41136c.dWd();
                    if (!(dWd == null || dWd.ATc == avv.ATc)) {
                        c31155a = new C31155a();
                        C16411e a = C36607d.m60704a(avv);
                        if (a == null || a.ATn <= XWalkEnvironment.getInstalledNewstVersion()) {
                            c31155a = null;
                        } else {
                            XWalkInitializer.addXWalkInitializeLog("got matched version");
                            c31155a.ATc = avv.ATc;
                            c31155a.ATb = a.ATb;
                            c31155a.ATn = a.ATn;
                            c31155a.ATw = a.ATo.ATp;
                            c31155a.ATh = a.ATh;
                            c31155a.bUseCdn = a.bUseCdn;
                            c31155a.bTryUseSharedCore = a.bTryUseSharedCore;
                            C16409b a2 = C36607d.m60703a(a);
                            c31155a.ATu = a.ATg;
                            if (a2 != null) {
                                c31155a.ATt = true;
                                c31155a.ATg = a2.ATg;
                                c31155a.cdy = a2.ATb;
                                c31155a.ATh = a2.ATh;
                                c31155a.bUseCdn = a2.bUseCdn;
                            } else {
                                c31155a.ATt = false;
                                c31155a.ATg = a.ATg;
                            }
                            int random = (int) (((double) a.ATl) * Math.random());
                            c31155a.ATv = ((long) ((random * 60) * 1000)) + System.currentTimeMillis();
                            XWalkInitializer.addXWalkInitializeLog("schedul after " + random + " minute to update");
                        }
                        if (c31155a != null) {
                            if (c31155a.ATn == dWd.ATn && c31155a.ATh == dWd.ATh && c31155a.bUseCdn == dWd.bUseCdn && c31155a.ATt == dWd.ATt && C41136c.m71570iM(c31155a.ATb, dWd.ATb) && C41136c.m71570iM(c31155a.ATu, dWd.ATu) && (!c31155a.ATt || C41136c.m71570iM(c31155a.cdy, dWd.cdy))) {
                                z = true;
                            }
                            if (z) {
                                XWalkInitializer.addXWalkInitializeLog("got same version to scheduler, abandon it ");
                            } else {
                                if (C41136c.dVX()) {
                                    XWalkInitializer.addXWalkInitializeLog("got new scheduler replace current , version is " + c31155a.ATn);
                                }
                                C41136c.m71568a(c31155a);
                                C36609f.m60708c(c31155a);
                                AppMethodBeat.m2505o(85479);
                            }
                        }
                    }
                }
                XWalkInitializer.addXWalkInitializeLog("it's gp version , dont down load any runtime version");
            }
            c31155a = null;
            C36609f.m60708c(c31155a);
            AppMethodBeat.m2505o(85479);
        }

        /* renamed from: b */
        public final void mo13336b(C6057c c6057c) {
            AppMethodBeat.m2504i(85480);
            C6060b dUo = C16403w.dUo();
            if (dUo != null) {
                dUo.aMA();
            }
            C24532f.m38181nI(35);
            C24532f.dVf();
            C24532f.m38172bX(15123, "0,190301," + c6057c.ATL + "," + c6057c.mNetWorkType + "," + c6057c.mRetryTimes + "," + c6057c.ATM + "," + c6057c.mTotalSize + "," + C36609f.ATD);
            XWalkEnvironment.addXWalkInitializeLog("get config onTaskFailed ");
            AppMethodBeat.m2505o(85480);
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ void onPostExecute(Object obj) {
        AppMethodBeat.m2504i(85489);
        Integer num = (Integer) obj;
        C6060b dUo;
        if (num.intValue() == 1) {
            dUo = C16403w.dUo();
            if (dUo != null) {
                dUo.aMy();
            }
            C36609f.m60707b(C41136c.dWd());
        } else if (num.intValue() == 2) {
            if (NetworkUtil.isNetworkAvailable()) {
                XWalkEnvironment.addXWalkInitializeLog("doFetchUpdateConfigNew begin!!");
                C6055a c6055a = new C6055a();
                c6055a.mUrl = XWalkEnvironment.getXWalkUpdateConfigUrl();
                c6055a.mFilePath = XWalkEnvironment.getUpdateConfigFullPath();
                c6055a.ATJ = true;
                C41136c.dWa();
                C24532f.dVe();
                C6053g.m9531a(c6055a, new C366101());
            } else {
                dUo = C16403w.dUo();
                if (dUo != null) {
                    dUo.aMA();
                }
                XWalkEnvironment.addXWalkInitializeLog("network not available!!");
            }
        }
        super.onPostExecute(num);
        AppMethodBeat.m2505o(85489);
    }

    public C36609f(XWalkUpdater xWalkUpdater, HashMap<String, String> hashMap) {
        AppMethodBeat.m2504i(85481);
        ASF = xWalkUpdater;
        this.ATC = hashMap;
        if (hashMap != null) {
            String str = (String) hashMap.get("UpdaterCheckType");
            ATD = str;
            if (str != null && ATD.equals("1")) {
                C41136c.dVV().dVZ();
            } else if (ATD != null && ATD.equals("2")) {
                C41136c.dVV().dVZ();
                C24532f.m38181nI(93);
            } else if (ATD == null || !ATD.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                ATD = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            } else {
                C41136c.dWd().ATh = true;
                C24532f.m38181nI(94);
            }
        }
        XWalkInitializer.addXWalkInitializeLog("XWalkUpdateChecker notify received !! mNotifyType = " + ATD);
        AppMethodBeat.m2505o(85481);
    }

    /* renamed from: b */
    private static boolean m60707b(C31155a c31155a) {
        AppMethodBeat.m2504i(85482);
        if (C36609f.dWf()) {
            AppMethodBeat.m2505o(85482);
            return false;
        }
        if (!XWalkEnvironment.isSelfProvider()) {
            C36609f.dWg();
            ErrorInfo updateRuntimeFromProvider = ASF.updateRuntimeFromProvider(c31155a);
            try {
                String packageName = XWalkEnvironment.getPackageName();
                String str = updateRuntimeFromProvider.errorCode + "," + packageName + "," + updateRuntimeFromProvider.targetVer + "," + updateRuntimeFromProvider.readFileListFailedCount + "," + updateRuntimeFromProvider.noMatchedVersionCount + "," + updateRuntimeFromProvider.copyFailedCount + "," + updateRuntimeFromProvider.md5FailedCount + "," + updateRuntimeFromProvider.extractFailedCount + "," + updateRuntimeFromProvider.setVersionFailedCount + "," + updateRuntimeFromProvider.extractRetryFailedCount;
                ContentResolver contentResolver = XWalkEnvironment.getContentResolver();
                if (contentResolver != null) {
                    Uri b = XWebCoreContentProvider.m89065b("com.tencent.mm", packageName, 3, 0, "");
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("15626", str);
                    contentResolver.insert(b, contentValues);
                }
            } catch (Exception e) {
                XWalkInitializer.addXWalkInitializeLog("_doStartUpdate report error");
            }
            if (updateRuntimeFromProvider.errorCode == 0) {
                C36609f.dWi();
                AppMethodBeat.m2505o(85482);
                return true;
            } else if (updateRuntimeFromProvider.errorCode == -10) {
                int i = updateRuntimeFromProvider.errorCode;
                C36609f.dWh();
                C41136c.m71566SF(i);
                AppMethodBeat.m2505o(85482);
                return false;
            } else {
                C36609f.dWh();
            }
        }
        XWalkInitializer.addXWalkInitializeLog("_doStartUpdate go on");
        C6060b dUo;
        if (!NetworkUtil.isNetworkAvailable()) {
            dUo = C16403w.dUo();
            if (dUo != null) {
                dUo.aMz();
            }
            AppMethodBeat.m2505o(85482);
            return false;
        } else if (!c31155a.ATh && !NetworkUtil.isWifiAvailable()) {
            XWalkInitializer.addXWalkInitializeLog("current network is not wifi , this scheduler not support mobile data");
            dUo = C16403w.dUo();
            if (dUo != null) {
                dUo.aMz();
            }
            AppMethodBeat.m2505o(85482);
            return false;
        } else if (ASF.updateXWalkRuntime(c31155a.dWe())) {
            C36609f.dWg();
            AppMethodBeat.m2505o(85482);
            return true;
        } else {
            AppMethodBeat.m2505o(85482);
            return false;
        }
    }

    public static boolean dWf() {
        AppMethodBeat.m2504i(85483);
        int i = XWalkEnvironment.getSharedPreferencesForUpdateConfig().getInt("UpdatingProcessId", -1);
        if (i == Process.myPid()) {
            XWalkInitializer.addXWalkInitializeLog("current process is in updating progress");
            AppMethodBeat.m2505o(85483);
            return true;
        } else if (i < 0) {
            AppMethodBeat.m2505o(85483);
            return false;
        } else {
            ActivityManager activityManager = (ActivityManager) XWalkEnvironment.getApplicationContext().getSystemService("activity");
            Process.myPid();
            int myUid = Process.myUid();
            for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == i) {
                    if (runningAppProcessInfo.uid == myUid) {
                        XWalkInitializer.addXWalkInitializeLog("some process is in updating progress");
                        AppMethodBeat.m2505o(85483);
                        return true;
                    }
                    C36609f.dWh();
                    AppMethodBeat.m2505o(85483);
                    return false;
                }
            }
            C36609f.dWh();
            AppMethodBeat.m2505o(85483);
            return false;
        }
    }

    public static void dWg() {
        AppMethodBeat.m2504i(85484);
        int myPid = Process.myPid();
        Editor edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        edit.putInt("UpdatingProcessId", myPid);
        edit.commit();
        XWalkInitializer.addXWalkInitializeLog("start updating progress");
        AppMethodBeat.m2505o(85484);
    }

    public static void dWh() {
        AppMethodBeat.m2504i(85485);
        Process.myPid();
        Editor edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        edit.remove("UpdatingProcessId");
        edit.commit();
        XWalkInitializer.addXWalkInitializeLog("finish updating progress");
        AppMethodBeat.m2505o(85485);
    }

    public static void dWi() {
        AppMethodBeat.m2504i(85486);
        XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        C36609f.dWh();
        C41136c.m71568a(null);
        AppMethodBeat.m2505o(85486);
    }

    /* renamed from: SF */
    public static void m60706SF(int i) {
        AppMethodBeat.m2504i(139029);
        C36609f.dWh();
        C41136c.m71566SF(i);
        AppMethodBeat.m2505o(139029);
    }

    /* renamed from: c */
    static void m60708c(C31155a c31155a) {
        AppMethodBeat.m2504i(85488);
        if (c31155a != null) {
            if (!XWalkEnvironment.hasAvailableVersion()) {
                XWalkInitializer.addXWalkInitializeLog("no availableversion installed, do start download ");
                C36609f.m60707b(c31155a);
            } else if (c31155a.ATv <= System.currentTimeMillis()) {
                C36609f.m60707b(c31155a);
            }
            C6060b dUo = C16403w.dUo();
            if (dUo != null) {
                dUo.aMy();
            }
            AppMethodBeat.m2505o(85488);
            return;
        }
        AppMethodBeat.m2505o(85488);
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        int i;
        AppMethodBeat.m2504i(85490);
        if (!C41136c.dWc() || C36609f.dWf()) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            Integer valueOf = Integer.valueOf(2);
            AppMethodBeat.m2505o(85490);
            return valueOf;
        }
        if (C41136c.dVV().dVY()) {
            XWalkInitializer.addXWalkInitializeLog("time to update");
            i = 1;
        } else {
            i = 0;
        }
        Object valueOf2;
        if (i == 0 || C36609f.dWf()) {
            valueOf2 = Integer.valueOf(0);
            AppMethodBeat.m2505o(85490);
            return valueOf2;
        }
        valueOf2 = Integer.valueOf(1);
        AppMethodBeat.m2505o(85490);
        return valueOf2;
    }
}
