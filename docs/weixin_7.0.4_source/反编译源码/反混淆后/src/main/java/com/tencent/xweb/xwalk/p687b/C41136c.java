package com.tencent.xweb.xwalk.p687b;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.util.GmsVersion;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.C44572a;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkUpdater.UpdateConfig;

/* renamed from: com.tencent.xweb.xwalk.b.c */
public class C41136c {
    static C41136c ATq;
    static C31155a ATr;

    /* renamed from: com.tencent.xweb.xwalk.b.c$a */
    public static class C31155a {
        static final /* synthetic */ boolean $assertionsDisabled = (!C41136c.class.desiredAssertionStatus());
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
            AppMethodBeat.m2504i(85455);
            AppMethodBeat.m2505o(85455);
        }

        public final UpdateConfig dWe() {
            AppMethodBeat.m2504i(85454);
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
                        AppMethodBeat.m2505o(85454);
                        throw assertionError;
                    }
                } else if (this.ATb != null && !this.ATb.isEmpty()) {
                    updateConfig = new UpdateConfig(this.ATb, false, null, this.ATg, this.ATn);
                } else if ($assertionsDisabled) {
                    updateConfig = new UpdateConfig(this.ATg, false, this.ATn);
                } else {
                    assertionError = new AssertionError("royle:no md5 info, maybe something wrong");
                    AppMethodBeat.m2505o(85454);
                    throw assertionError;
                }
                updateConfig.versionDetail = this.ATw;
                updateConfig.bUseCdn = this.bUseCdn;
                updateConfig.bTryUseSharedCore = this.bTryUseSharedCore;
                AppMethodBeat.m2505o(85454);
                return updateConfig;
            } catch (Exception e) {
                XWalkInitializer.addXWalkInitializeLog("create  UpdateConfig failed , args is not valid");
                C41136c.m71568a(null);
                AppMethodBeat.m2505o(85454);
                return null;
            }
        }
    }

    private C41136c() {
    }

    public static synchronized C41136c dVV() {
        C41136c c41136c;
        synchronized (C41136c.class) {
            AppMethodBeat.m2504i(85456);
            if (ATq == null) {
                ATq = new C41136c();
            }
            c41136c = ATq;
            AppMethodBeat.m2505o(85456);
        }
        return c41136c;
    }

    /* renamed from: SF */
    public static void m71566SF(int i) {
        AppMethodBeat.m2504i(85457);
        if (i == -10) {
            SharedPreferences sharedPreferencesForUpdateConfig = XWalkEnvironment.getSharedPreferencesForUpdateConfig();
            int i2 = sharedPreferencesForUpdateConfig.getInt("nTryUseSharedCoreCount", 0);
            XWalkInitializer.addXWalkInitializeLog("onUpdateFailed shared mode, current nTryUseSharedCoreCount: ".concat(String.valueOf(i2)));
            i2++;
            C41136c.dWd().ATy = i2;
            Editor edit = sharedPreferencesForUpdateConfig.edit();
            edit.putInt("nTryUseSharedCoreCount", i2);
            C41136c.m71567a(edit, i2);
            edit.commit();
            AppMethodBeat.m2505o(85457);
        } else if (NetworkUtil.isNetworkAvailable()) {
            SharedPreferences sharedPreferencesForUpdateConfig2 = XWalkEnvironment.getSharedPreferencesForUpdateConfig();
            int i3 = sharedPreferencesForUpdateConfig2.getInt("nTryCnt", 0) + 1;
            if (i == -3 || i == -4) {
                C41136c.dWd().ATt = false;
                C41136c.dWd().ATg = C41136c.dWd().ATu;
                C41136c.dWd().ATh = false;
                C41136c.m71568a(C41136c.dWd());
                XWalkInitializer.addXWalkInitializeLog("switch to full package update");
            } else if (i <= -2 && i >= -5) {
                i3 += 3;
            }
            if (i3 > 3) {
                XWalkInitializer.addXWalkInitializeLog("FailedTooManytimes at this version");
                XWalkInitializer.addXWalkInitializeLog("abandon Current Scheduler");
                C41136c.m71568a(null);
                AppMethodBeat.m2505o(85457);
                return;
            }
            C41136c.dWd().ATx = i3;
            Editor edit2 = sharedPreferencesForUpdateConfig2.edit();
            edit2.putInt("nTryCnt", i3);
            C41136c.m71567a(edit2, i3);
            edit2.commit();
            AppMethodBeat.m2505o(85457);
        } else {
            AppMethodBeat.m2505o(85457);
        }
    }

    /* renamed from: a */
    private static synchronized void m71567a(Editor editor, int i) {
        synchronized (C41136c.class) {
            AppMethodBeat.m2504i(85458);
            long currentTimeMillis = System.currentTimeMillis() + ((long) (GmsVersion.VERSION_PARMESAN * i));
            XWalkInitializer.addXWalkInitializeLog("rescheduler update time after " + ((GmsVersion.VERSION_PARMESAN * i) / 60000) + " minute");
            editor.putLong("nTimeToUpdate", currentTimeMillis);
            AppMethodBeat.m2505o(85458);
        }
    }

    /* renamed from: iM */
    static boolean m71570iM(String str, String str2) {
        AppMethodBeat.m2504i(85459);
        if (str != null) {
            boolean equals = str.equals(str2);
            AppMethodBeat.m2505o(85459);
            return equals;
        } else if (str == str2) {
            AppMethodBeat.m2505o(85459);
            return true;
        } else {
            AppMethodBeat.m2505o(85459);
            return false;
        }
    }

    public static boolean dVW() {
        AppMethodBeat.m2504i(85460);
        if (C41136c.dVX()) {
            XWalkInitializer.addXWalkInitializeLog("has scheduler for update");
            AppMethodBeat.m2505o(85460);
            return true;
        }
        AppMethodBeat.m2505o(85460);
        return false;
    }

    public static synchronized boolean dVX() {
        boolean z = false;
        synchronized (C41136c.class) {
            AppMethodBeat.m2504i(85461);
            if (C41136c.dWd() == null || C41136c.dWd().ATg == null || C41136c.dWd().ATg.isEmpty()) {
                AppMethodBeat.m2505o(85461);
            } else if (C41136c.dWd().ATn <= XWalkEnvironment.getInstalledNewstVersion()) {
                AppMethodBeat.m2505o(85461);
            } else {
                z = true;
                AppMethodBeat.m2505o(85461);
            }
        }
        return z;
    }

    public final synchronized boolean dVY() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.m2504i(85462);
            if (!C41136c.dVX()) {
                AppMethodBeat.m2505o(85462);
            } else if (System.currentTimeMillis() >= C41136c.dWd().ATv) {
                XWalkInitializer.addXWalkInitializeLog("time to update");
                z = true;
                AppMethodBeat.m2505o(85462);
            } else {
                XWalkInitializer.addXWalkInitializeLog("has scheduler waiting for update, but time is not up");
                AppMethodBeat.m2505o(85462);
            }
        }
        return z;
    }

    public final synchronized void dVZ() {
        AppMethodBeat.m2504i(85463);
        Editor edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        edit.putLong("nLastFetchConfigTime", 0);
        edit.commit();
        C41136c.dWd().ATs = 0;
        C41136c.dWd().ATv = 0;
        AppMethodBeat.m2505o(85463);
    }

    /* renamed from: a */
    public static synchronized void m71568a(C31155a c31155a) {
        synchronized (C41136c.class) {
            AppMethodBeat.m2504i(85464);
            ATr = c31155a;
            if (c31155a == null) {
                ATr = new C31155a();
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
            AppMethodBeat.m2505o(85464);
        }
    }

    public static void dWa() {
        AppMethodBeat.m2504i(85465);
        C41136c.dWd().ATs = System.currentTimeMillis();
        Editor edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        edit.putLong("nLastFetchConfigTime", C41136c.dWd().ATs);
        edit.commit();
        AppMethodBeat.m2505o(85465);
    }

    public static long dWb() {
        AppMethodBeat.m2504i(85466);
        long dTO = (long) C44572a.dTO();
        if (dTO < 0) {
            dTO = 86400000;
        }
        AppMethodBeat.m2505o(85466);
        return dTO;
    }

    /* renamed from: ah */
    private static boolean m71569ah(long j, long j2) {
        AppMethodBeat.m2504i(85467);
        long dWb = C41136c.dWb();
        if (j > j2 + dWb || dWb + j < j2) {
            AppMethodBeat.m2505o(85467);
            return true;
        }
        XWalkInitializer.addXWalkInitializeLog("the most recent time to fetch config is too close");
        AppMethodBeat.m2505o(85467);
        return false;
    }

    public static boolean dWc() {
        AppMethodBeat.m2504i(85468);
        long currentTimeMillis = System.currentTimeMillis();
        if (C41136c.m71569ah(currentTimeMillis, C41136c.dWd().ATs)) {
            long j = XWalkEnvironment.getSharedPreferencesForUpdateConfig().getLong("nLastFetchConfigTime", 0);
            C41136c.dWd().ATs = j;
            if (C41136c.m71569ah(currentTimeMillis, j)) {
                XWalkInitializer.addXWalkInitializeLog("enough time after last time fetch config");
                AppMethodBeat.m2505o(85468);
                return true;
            }
        }
        AppMethodBeat.m2505o(85468);
        return false;
    }

    public static C31155a dWd() {
        AppMethodBeat.m2504i(85469);
        C31155a c31155a;
        if (ATr != null) {
            c31155a = ATr;
            AppMethodBeat.m2505o(85469);
            return c31155a;
        }
        ATr = new C31155a();
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
            c31155a = ATr;
            AppMethodBeat.m2505o(85469);
            return c31155a;
        }
        c31155a = ATr;
        AppMethodBeat.m2505o(85469);
        return c31155a;
    }
}
