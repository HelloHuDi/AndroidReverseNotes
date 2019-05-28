package com.tencent.xweb.xwalk.b;

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
import com.tencent.xweb.XWebCoreContentProvider;
import com.tencent.xweb.w;
import com.tencent.xweb.xwalk.b;
import com.tencent.xweb.xwalk.b.a.e;
import com.tencent.xweb.xwalk.b.g.a;
import com.tencent.xweb.xwalk.b.g.c;
import java.util.HashMap;
import org.xwalk.core.Log;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWalkUpdater.ErrorInfo;

public final class f extends AsyncTask<String, Integer, Integer> {
    static XWalkUpdater ASF;
    private static String ATD = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    private HashMap<String, String> ATC;

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ void onPostExecute(Object obj) {
        AppMethodBeat.i(85489);
        Integer num = (Integer) obj;
        b dUo;
        if (num.intValue() == 1) {
            dUo = w.dUo();
            if (dUo != null) {
                dUo.aMy();
            }
            b(c.dWd());
        } else if (num.intValue() == 2) {
            if (NetworkUtil.isNetworkAvailable()) {
                XWalkEnvironment.addXWalkInitializeLog("doFetchUpdateConfigNew begin!!");
                a aVar = new a();
                aVar.mUrl = XWalkEnvironment.getXWalkUpdateConfigUrl();
                aVar.mFilePath = XWalkEnvironment.getUpdateConfigFullPath();
                aVar.ATJ = true;
                c.dWa();
                com.tencent.xweb.util.f.dVe();
                g.a(aVar, new b() {
                    public final void a(c cVar) {
                        boolean z = false;
                        AppMethodBeat.i(85479);
                        a.a avv = a.avv(cVar.mFilePath);
                        if (avv == null) {
                            com.tencent.xweb.util.f.nI(35);
                            com.tencent.xweb.util.f.dVf();
                            com.tencent.xweb.util.f.bX(15123, "0,190301," + cVar.ATL + "," + cVar.mNetWorkType + "," + cVar.mRetryTimes + "," + cVar.ATM + "," + cVar.mTotalSize);
                            XWalkEnvironment.addXWalkInitializeLog("ConfigParser failed ");
                            b dUo = w.dUo();
                            if (dUo != null) {
                                dUo.aMA();
                            }
                            AppMethodBeat.o(85479);
                            return;
                        }
                        c.a aVar;
                        try {
                            com.tencent.xweb.a.a(avv.ATe, avv.ATc);
                        } catch (Exception e) {
                            XWalkEnvironment.addXWalkInitializeLog("apply cmds failed , " + e.getMessage());
                        }
                        XWalkEnvironment.addXWalkInitializeLog("doFetchUpdateConfigNew onTaskSucceed!!");
                        com.tencent.xweb.util.f.nN(cVar.ATM);
                        com.tencent.xweb.util.f.bX(15123, avv.ATc + ",190301," + cVar.ATL + "," + cVar.mNetWorkType + "," + cVar.mRetryTimes + "," + cVar.ATM + "," + cVar.mTotalSize + "," + f.ATD);
                        c.dVV();
                        if (avv != null) {
                            Log.i("Scheduler", "onConfigDownLoaded get config ,config version is " + avv.ATc);
                            if (!XWalkEnvironment.isForbidDownloadCode() || XWalkEnvironment.isInTestMode()) {
                                c.a dWd = c.dWd();
                                if (!(dWd == null || dWd.ATc == avv.ATc)) {
                                    aVar = new c.a();
                                    e a = d.a(avv);
                                    if (a == null || a.ATn <= XWalkEnvironment.getInstalledNewstVersion()) {
                                        aVar = null;
                                    } else {
                                        XWalkInitializer.addXWalkInitializeLog("got matched version");
                                        aVar.ATc = avv.ATc;
                                        aVar.ATb = a.ATb;
                                        aVar.ATn = a.ATn;
                                        aVar.ATw = a.ATo.ATp;
                                        aVar.ATh = a.ATh;
                                        aVar.bUseCdn = a.bUseCdn;
                                        aVar.bTryUseSharedCore = a.bTryUseSharedCore;
                                        a.b a2 = d.a(a);
                                        aVar.ATu = a.ATg;
                                        if (a2 != null) {
                                            aVar.ATt = true;
                                            aVar.ATg = a2.ATg;
                                            aVar.cdy = a2.ATb;
                                            aVar.ATh = a2.ATh;
                                            aVar.bUseCdn = a2.bUseCdn;
                                        } else {
                                            aVar.ATt = false;
                                            aVar.ATg = a.ATg;
                                        }
                                        int random = (int) (((double) a.ATl) * Math.random());
                                        aVar.ATv = ((long) ((random * 60) * 1000)) + System.currentTimeMillis();
                                        XWalkInitializer.addXWalkInitializeLog("schedul after " + random + " minute to update");
                                    }
                                    if (aVar != null) {
                                        if (aVar.ATn == dWd.ATn && aVar.ATh == dWd.ATh && aVar.bUseCdn == dWd.bUseCdn && aVar.ATt == dWd.ATt && c.iM(aVar.ATb, dWd.ATb) && c.iM(aVar.ATu, dWd.ATu) && (!aVar.ATt || c.iM(aVar.cdy, dWd.cdy))) {
                                            z = true;
                                        }
                                        if (z) {
                                            XWalkInitializer.addXWalkInitializeLog("got same version to scheduler, abandon it ");
                                        } else {
                                            if (c.dVX()) {
                                                XWalkInitializer.addXWalkInitializeLog("got new scheduler replace current , version is " + aVar.ATn);
                                            }
                                            c.a(aVar);
                                            f.c(aVar);
                                            AppMethodBeat.o(85479);
                                        }
                                    }
                                }
                            }
                            XWalkInitializer.addXWalkInitializeLog("it's gp version , dont down load any runtime version");
                        }
                        aVar = null;
                        f.c(aVar);
                        AppMethodBeat.o(85479);
                    }

                    public final void b(c cVar) {
                        AppMethodBeat.i(85480);
                        b dUo = w.dUo();
                        if (dUo != null) {
                            dUo.aMA();
                        }
                        com.tencent.xweb.util.f.nI(35);
                        com.tencent.xweb.util.f.dVf();
                        com.tencent.xweb.util.f.bX(15123, "0,190301," + cVar.ATL + "," + cVar.mNetWorkType + "," + cVar.mRetryTimes + "," + cVar.ATM + "," + cVar.mTotalSize + "," + f.ATD);
                        XWalkEnvironment.addXWalkInitializeLog("get config onTaskFailed ");
                        AppMethodBeat.o(85480);
                    }
                });
            } else {
                dUo = w.dUo();
                if (dUo != null) {
                    dUo.aMA();
                }
                XWalkEnvironment.addXWalkInitializeLog("network not available!!");
            }
        }
        super.onPostExecute(num);
        AppMethodBeat.o(85489);
    }

    public f(XWalkUpdater xWalkUpdater, HashMap<String, String> hashMap) {
        AppMethodBeat.i(85481);
        ASF = xWalkUpdater;
        this.ATC = hashMap;
        if (hashMap != null) {
            String str = (String) hashMap.get("UpdaterCheckType");
            ATD = str;
            if (str != null && ATD.equals("1")) {
                c.dVV().dVZ();
            } else if (ATD != null && ATD.equals("2")) {
                c.dVV().dVZ();
                com.tencent.xweb.util.f.nI(93);
            } else if (ATD == null || !ATD.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                ATD = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            } else {
                c.dWd().ATh = true;
                com.tencent.xweb.util.f.nI(94);
            }
        }
        XWalkInitializer.addXWalkInitializeLog("XWalkUpdateChecker notify received !! mNotifyType = " + ATD);
        AppMethodBeat.o(85481);
    }

    private static boolean b(c.a aVar) {
        AppMethodBeat.i(85482);
        if (dWf()) {
            AppMethodBeat.o(85482);
            return false;
        }
        if (!XWalkEnvironment.isSelfProvider()) {
            dWg();
            ErrorInfo updateRuntimeFromProvider = ASF.updateRuntimeFromProvider(aVar);
            try {
                String packageName = XWalkEnvironment.getPackageName();
                String str = updateRuntimeFromProvider.errorCode + "," + packageName + "," + updateRuntimeFromProvider.targetVer + "," + updateRuntimeFromProvider.readFileListFailedCount + "," + updateRuntimeFromProvider.noMatchedVersionCount + "," + updateRuntimeFromProvider.copyFailedCount + "," + updateRuntimeFromProvider.md5FailedCount + "," + updateRuntimeFromProvider.extractFailedCount + "," + updateRuntimeFromProvider.setVersionFailedCount + "," + updateRuntimeFromProvider.extractRetryFailedCount;
                ContentResolver contentResolver = XWalkEnvironment.getContentResolver();
                if (contentResolver != null) {
                    Uri b = XWebCoreContentProvider.b("com.tencent.mm", packageName, 3, 0, "");
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("15626", str);
                    contentResolver.insert(b, contentValues);
                }
            } catch (Exception e) {
                XWalkInitializer.addXWalkInitializeLog("_doStartUpdate report error");
            }
            if (updateRuntimeFromProvider.errorCode == 0) {
                dWi();
                AppMethodBeat.o(85482);
                return true;
            } else if (updateRuntimeFromProvider.errorCode == -10) {
                int i = updateRuntimeFromProvider.errorCode;
                dWh();
                c.SF(i);
                AppMethodBeat.o(85482);
                return false;
            } else {
                dWh();
            }
        }
        XWalkInitializer.addXWalkInitializeLog("_doStartUpdate go on");
        b dUo;
        if (!NetworkUtil.isNetworkAvailable()) {
            dUo = w.dUo();
            if (dUo != null) {
                dUo.aMz();
            }
            AppMethodBeat.o(85482);
            return false;
        } else if (!aVar.ATh && !NetworkUtil.isWifiAvailable()) {
            XWalkInitializer.addXWalkInitializeLog("current network is not wifi , this scheduler not support mobile data");
            dUo = w.dUo();
            if (dUo != null) {
                dUo.aMz();
            }
            AppMethodBeat.o(85482);
            return false;
        } else if (ASF.updateXWalkRuntime(aVar.dWe())) {
            dWg();
            AppMethodBeat.o(85482);
            return true;
        } else {
            AppMethodBeat.o(85482);
            return false;
        }
    }

    public static boolean dWf() {
        AppMethodBeat.i(85483);
        int i = XWalkEnvironment.getSharedPreferencesForUpdateConfig().getInt("UpdatingProcessId", -1);
        if (i == Process.myPid()) {
            XWalkInitializer.addXWalkInitializeLog("current process is in updating progress");
            AppMethodBeat.o(85483);
            return true;
        } else if (i < 0) {
            AppMethodBeat.o(85483);
            return false;
        } else {
            ActivityManager activityManager = (ActivityManager) XWalkEnvironment.getApplicationContext().getSystemService("activity");
            Process.myPid();
            int myUid = Process.myUid();
            for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == i) {
                    if (runningAppProcessInfo.uid == myUid) {
                        XWalkInitializer.addXWalkInitializeLog("some process is in updating progress");
                        AppMethodBeat.o(85483);
                        return true;
                    }
                    dWh();
                    AppMethodBeat.o(85483);
                    return false;
                }
            }
            dWh();
            AppMethodBeat.o(85483);
            return false;
        }
    }

    public static void dWg() {
        AppMethodBeat.i(85484);
        int myPid = Process.myPid();
        Editor edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        edit.putInt("UpdatingProcessId", myPid);
        edit.commit();
        XWalkInitializer.addXWalkInitializeLog("start updating progress");
        AppMethodBeat.o(85484);
    }

    public static void dWh() {
        AppMethodBeat.i(85485);
        Process.myPid();
        Editor edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        edit.remove("UpdatingProcessId");
        edit.commit();
        XWalkInitializer.addXWalkInitializeLog("finish updating progress");
        AppMethodBeat.o(85485);
    }

    public static void dWi() {
        AppMethodBeat.i(85486);
        XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        dWh();
        c.a(null);
        AppMethodBeat.o(85486);
    }

    public static void SF(int i) {
        AppMethodBeat.i(139029);
        dWh();
        c.SF(i);
        AppMethodBeat.o(139029);
    }

    static void c(c.a aVar) {
        AppMethodBeat.i(85488);
        if (aVar != null) {
            if (!XWalkEnvironment.hasAvailableVersion()) {
                XWalkInitializer.addXWalkInitializeLog("no availableversion installed, do start download ");
                b(aVar);
            } else if (aVar.ATv <= System.currentTimeMillis()) {
                b(aVar);
            }
            b dUo = w.dUo();
            if (dUo != null) {
                dUo.aMy();
            }
            AppMethodBeat.o(85488);
            return;
        }
        AppMethodBeat.o(85488);
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        int i;
        AppMethodBeat.i(85490);
        if (!c.dWc() || dWf()) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            Integer valueOf = Integer.valueOf(2);
            AppMethodBeat.o(85490);
            return valueOf;
        }
        if (c.dVV().dVY()) {
            XWalkInitializer.addXWalkInitializeLog("time to update");
            i = 1;
        } else {
            i = 0;
        }
        Object valueOf2;
        if (i == 0 || dWf()) {
            valueOf2 = Integer.valueOf(0);
            AppMethodBeat.o(85490);
            return valueOf2;
        }
        valueOf2 = Integer.valueOf(1);
        AppMethodBeat.o(85490);
        return valueOf2;
    }
}
