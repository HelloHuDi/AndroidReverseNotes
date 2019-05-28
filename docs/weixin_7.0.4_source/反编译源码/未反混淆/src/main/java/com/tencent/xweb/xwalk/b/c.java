package com.tencent.xweb.xwalk.b;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.util.GmsVersion;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkUpdater.UpdateConfig;

public class c {
    static c ATq;
    static a ATr;

    public static class a {
        static final /* synthetic */ boolean $assertionsDisabled = (!c.class.desiredAssertionStatus());
        public String ATb;
        public String ATc;
        public String ATg;
        public boolean ATh;
        public int ATn;
        public long ATs;
        public boolean ATt;
        public String ATu;
        public long ATv;
        public String ATw;
        public int ATx;
        public int ATy;
        public boolean bTryUseSharedCore;
        public boolean bUseCdn;
        public String cdy;

        static {
            AppMethodBeat.i(85455);
            AppMethodBeat.o(85455);
        }

        public final UpdateConfig dWe() {
            AppMethodBeat.i(85454);
            try {
                UpdateConfig updateConfig;
                AssertionError assertionError;
                if (this.ATt) {
                    if (this.ATb != null && !this.ATb.isEmpty() && this.cdy != null && !this.cdy.isEmpty()) {
                        updateConfig = new UpdateConfig(this.cdy, true, this.ATb, this.ATg, this.ATn);
                    } else if ($assertionsDisabled) {
                        updateConfig = new UpdateConfig(this.ATg, true, this.ATn);
                    } else {
                        assertionError = new AssertionError("royle:no md5 info, maybe something wrong");
                        AppMethodBeat.o(85454);
                        throw assertionError;
                    }
                } else if (this.ATb != null && !this.ATb.isEmpty()) {
                    updateConfig = new UpdateConfig(this.ATb, false, null, this.ATg, this.ATn);
                } else if ($assertionsDisabled) {
                    updateConfig = new UpdateConfig(this.ATg, false, this.ATn);
                } else {
                    assertionError = new AssertionError("royle:no md5 info, maybe something wrong");
                    AppMethodBeat.o(85454);
                    throw assertionError;
                }
                updateConfig.versionDetail = this.ATw;
                updateConfig.bUseCdn = this.bUseCdn;
                updateConfig.bTryUseSharedCore = this.bTryUseSharedCore;
                AppMethodBeat.o(85454);
                return updateConfig;
            } catch (Exception e) {
                XWalkInitializer.addXWalkInitializeLog("create  UpdateConfig failed , args is not valid");
                c.a(null);
                AppMethodBeat.o(85454);
                return null;
            }
        }
    }

    private c() {
    }

    public static synchronized c dVV() {
        c cVar;
        synchronized (c.class) {
            AppMethodBeat.i(85456);
            if (ATq == null) {
                ATq = new c();
            }
            cVar = ATq;
            AppMethodBeat.o(85456);
        }
        return cVar;
    }

    public static void SF(int i) {
        AppMethodBeat.i(85457);
        if (i == -10) {
            SharedPreferences sharedPreferencesForUpdateConfig = XWalkEnvironment.getSharedPreferencesForUpdateConfig();
            int i2 = sharedPreferencesForUpdateConfig.getInt("nTryUseSharedCoreCount", 0);
            XWalkInitializer.addXWalkInitializeLog("onUpdateFailed shared mode, current nTryUseSharedCoreCount: ".concat(String.valueOf(i2)));
            i2++;
            dWd().ATy = i2;
            Editor edit = sharedPreferencesForUpdateConfig.edit();
            edit.putInt("nTryUseSharedCoreCount", i2);
            a(edit, i2);
            edit.commit();
            AppMethodBeat.o(85457);
        } else if (NetworkUtil.isNetworkAvailable()) {
            SharedPreferences sharedPreferencesForUpdateConfig2 = XWalkEnvironment.getSharedPreferencesForUpdateConfig();
            int i3 = sharedPreferencesForUpdateConfig2.getInt("nTryCnt", 0) + 1;
            if (i == -3 || i == -4) {
                dWd().ATt = false;
                dWd().ATg = dWd().ATu;
                dWd().ATh = false;
                a(dWd());
                XWalkInitializer.addXWalkInitializeLog("switch to full package update");
            } else if (i <= -2 && i >= -5) {
                i3 += 3;
            }
            if (i3 > 3) {
                XWalkInitializer.addXWalkInitializeLog("FailedTooManytimes at this version");
                XWalkInitializer.addXWalkInitializeLog("abandon Current Scheduler");
                a(null);
                AppMethodBeat.o(85457);
                return;
            }
            dWd().ATx = i3;
            Editor edit2 = sharedPreferencesForUpdateConfig2.edit();
            edit2.putInt("nTryCnt", i3);
            a(edit2, i3);
            edit2.commit();
            AppMethodBeat.o(85457);
        } else {
            AppMethodBeat.o(85457);
        }
    }

    private static synchronized void a(Editor editor, int i) {
        synchronized (c.class) {
            AppMethodBeat.i(85458);
            long currentTimeMillis = System.currentTimeMillis() + ((long) (GmsVersion.VERSION_PARMESAN * i));
            XWalkInitializer.addXWalkInitializeLog("rescheduler update time after " + ((GmsVersion.VERSION_PARMESAN * i) / 60000) + " minute");
            editor.putLong("nTimeToUpdate", currentTimeMillis);
            AppMethodBeat.o(85458);
        }
    }

    static boolean iM(String str, String str2) {
        AppMethodBeat.i(85459);
        if (str != null) {
            boolean equals = str.equals(str2);
            AppMethodBeat.o(85459);
            return equals;
        } else if (str == str2) {
            AppMethodBeat.o(85459);
            return true;
        } else {
            AppMethodBeat.o(85459);
            return false;
        }
    }

    public static boolean dVW() {
        AppMethodBeat.i(85460);
        if (dVX()) {
            XWalkInitializer.addXWalkInitializeLog("has scheduler for update");
            AppMethodBeat.o(85460);
            return true;
        }
        AppMethodBeat.o(85460);
        return false;
    }

    public static synchronized boolean dVX() {
        boolean z = false;
        synchronized (c.class) {
            AppMethodBeat.i(85461);
            if (dWd() == null || dWd().ATg == null || dWd().ATg.isEmpty()) {
                AppMethodBeat.o(85461);
            } else if (dWd().ATn <= XWalkEnvironment.getInstalledNewstVersion()) {
                AppMethodBeat.o(85461);
            } else {
                z = true;
                AppMethodBeat.o(85461);
            }
        }
        return z;
    }

    public final synchronized boolean dVY() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(85462);
            if (!dVX()) {
                AppMethodBeat.o(85462);
            } else if (System.currentTimeMillis() >= dWd().ATv) {
                XWalkInitializer.addXWalkInitializeLog("time to update");
                z = true;
                AppMethodBeat.o(85462);
            } else {
                XWalkInitializer.addXWalkInitializeLog("has scheduler waiting for update, but time is not up");
                AppMethodBeat.o(85462);
            }
        }
        return z;
    }

    public final synchronized void dVZ() {
        AppMethodBeat.i(85463);
        Editor edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        edit.putLong("nLastFetchConfigTime", 0);
        edit.commit();
        dWd().ATs = 0;
        dWd().ATv = 0;
        AppMethodBeat.o(85463);
    }

    public static synchronized void a(a aVar) {
        synchronized (c.class) {
            AppMethodBeat.i(85464);
            ATr = aVar;
            if (aVar == null) {
                ATr = new a();
            }
            Editor edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
            edit.putString("strMd5", ATr.ATb);
            edit.putString("strUrl", ATr.ATg);
            edit.putString("strFullPackageUrl", ATr.ATu);
            edit.putString("strConfigVer", ATr.ATc);
            edit.putBoolean("bIsPatchUpdate", ATr.ATt);
            edit.putBoolean("bCanUseCellular", ATr.ATh);
            edit.putBoolean("bUseCdn", ATr.bUseCdn);
            edit.putLong("nTimeToUpdate", ATr.ATv);
            edit.putInt("nApkVer", ATr.ATn);
            edit.putInt("nTryCnt", ATr.ATx);
            edit.putInt("nTryUseSharedCoreCount", ATr.ATy);
            edit.putString("strPatchMd5", ATr.cdy);
            edit.putString("strVersionDetail", ATr.ATw);
            edit.putBoolean("bTryUseSharedCore", ATr.bTryUseSharedCore);
            edit.commit();
            AppMethodBeat.o(85464);
        }
    }

    public static void dWa() {
        AppMethodBeat.i(85465);
        dWd().ATs = System.currentTimeMillis();
        Editor edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        edit.putLong("nLastFetchConfigTime", dWd().ATs);
        edit.commit();
        AppMethodBeat.o(85465);
    }

    public static long dWb() {
        AppMethodBeat.i(85466);
        long dTO = (long) com.tencent.xweb.a.dTO();
        if (dTO < 0) {
            dTO = 86400000;
        }
        AppMethodBeat.o(85466);
        return dTO;
    }

    private static boolean ah(long j, long j2) {
        AppMethodBeat.i(85467);
        long dWb = dWb();
        if (j > j2 + dWb || dWb + j < j2) {
            AppMethodBeat.o(85467);
            return true;
        }
        XWalkInitializer.addXWalkInitializeLog("the most recent time to fetch config is too close");
        AppMethodBeat.o(85467);
        return false;
    }

    public static boolean dWc() {
        AppMethodBeat.i(85468);
        long currentTimeMillis = System.currentTimeMillis();
        if (ah(currentTimeMillis, dWd().ATs)) {
            long j = XWalkEnvironment.getSharedPreferencesForUpdateConfig().getLong("nLastFetchConfigTime", 0);
            dWd().ATs = j;
            if (ah(currentTimeMillis, j)) {
                XWalkInitializer.addXWalkInitializeLog("enough time after last time fetch config");
                AppMethodBeat.o(85468);
                return true;
            }
        }
        AppMethodBeat.o(85468);
        return false;
    }

    public static a dWd() {
        AppMethodBeat.i(85469);
        a aVar;
        if (ATr != null) {
            aVar = ATr;
            AppMethodBeat.o(85469);
            return aVar;
        }
        ATr = new a();
        SharedPreferences sharedPreferencesForUpdateConfig = XWalkEnvironment.getSharedPreferencesForUpdateConfig();
        ATr.ATs = sharedPreferencesForUpdateConfig.getLong("nLastFetchConfigTime", 0);
        if (sharedPreferencesForUpdateConfig.contains("strUrl")) {
            ATr.ATb = sharedPreferencesForUpdateConfig.getString("strMd5", null);
            ATr.ATg = sharedPreferencesForUpdateConfig.getString("strUrl", null);
            ATr.ATu = sharedPreferencesForUpdateConfig.getString("strFullPackageUrl", null);
            ATr.ATc = sharedPreferencesForUpdateConfig.getString("strConfigVer", null);
            ATr.ATt = sharedPreferencesForUpdateConfig.getBoolean("bIsPatchUpdate", false);
            ATr.ATv = sharedPreferencesForUpdateConfig.getLong("nTimeToUpdate", 0);
            ATr.ATn = sharedPreferencesForUpdateConfig.getInt("nApkVer", 0);
            ATr.ATx = sharedPreferencesForUpdateConfig.getInt("nTryCnt", 0);
            ATr.ATy = sharedPreferencesForUpdateConfig.getInt("nTryUseSharedCoreCount", 0);
            ATr.cdy = sharedPreferencesForUpdateConfig.getString("strPatchMd5", null);
            ATr.ATw = sharedPreferencesForUpdateConfig.getString("strVersionDetail", null);
            ATr.ATh = sharedPreferencesForUpdateConfig.getBoolean("bCanUseCellular", false);
            ATr.bUseCdn = sharedPreferencesForUpdateConfig.getBoolean("bUseCdn", false);
            ATr.bTryUseSharedCore = sharedPreferencesForUpdateConfig.getBoolean("bTryUseSharedCore", true);
            aVar = ATr;
            AppMethodBeat.o(85469);
            return aVar;
        }
        aVar = ATr;
        AppMethodBeat.o(85469);
        return aVar;
    }
}
