package com.tencent.xweb.xwalk.p686a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.C16395k.C16394a;
import java.util.HashMap;
import java.util.List;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;

/* renamed from: com.tencent.xweb.xwalk.a.f */
public final class C36603f implements C16394a {
    public String ASK = "";
    public C36604a ASL = null;
    public C36605g ASM = null;

    /* renamed from: com.tencent.xweb.xwalk.a.f$a */
    public interface C36604a {
        /* renamed from: Sy */
        void mo50916Sy(int i);

        /* renamed from: Sz */
        void mo50917Sz(int i);

        void dVI();
    }

    /* renamed from: a */
    public final void mo30119a(Context context, HashMap<String, String> hashMap) {
        AppMethodBeat.m2504i(85418);
        this.ASM = new C36605g();
        this.ASM.mo58395a((HashMap) hashMap, this.ASK, this.ASL);
        this.ASM.execute(new String[0]);
        this.ASK = "";
        this.ASL = null;
        AppMethodBeat.m2505o(85418);
    }

    public final boolean isBusy() {
        if (this.ASM == null || this.ASM.ASV) {
            return false;
        }
        return true;
    }

    /* renamed from: nQ */
    public static void m60691nQ(long j) {
        AppMethodBeat.m2504i(85419);
        SharedPreferences sharedPreferencesForPluginUpdateInfo = XWalkEnvironment.getSharedPreferencesForPluginUpdateInfo();
        if (sharedPreferencesForPluginUpdateInfo == null) {
            XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "set time sp is null");
            AppMethodBeat.m2505o(85419);
            return;
        }
        Editor edit = sharedPreferencesForPluginUpdateInfo.edit();
        edit.putLong(XWalkEnvironment.SP_KEY_PLUGIN_UPDATE_CONFIG_LAST_FETCH_TIME, j);
        edit.commit();
        AppMethodBeat.m2505o(85419);
    }

    public static boolean dVS() {
        AppMethodBeat.m2504i(85420);
        SharedPreferences sharedPreferencesForPluginUpdateInfo = XWalkEnvironment.getSharedPreferencesForPluginUpdateInfo();
        if (sharedPreferencesForPluginUpdateInfo == null) {
            AppMethodBeat.m2505o(85420);
            return false;
        }
        int i = sharedPreferencesForPluginUpdateInfo.getInt(XWalkEnvironment.SP_KEY_PLUGIN_UPDATE_PROCESS_ID, -1);
        if (i < 0) {
            AppMethodBeat.m2505o(85420);
            return false;
        }
        int myPid = Process.myPid();
        int myUid = Process.myUid();
        if (i == myPid) {
            XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "current process is updating plugin");
            AppMethodBeat.m2505o(85420);
            return true;
        }
        List runningAppProcesses;
        try {
            runningAppProcesses = ((ActivityManager) XWalkEnvironment.getApplicationContext().getSystemService("activity")).getRunningAppProcesses();
        } catch (Exception e) {
            Log.m81046e("XWalkPluginUp", e.getMessage());
            runningAppProcesses = null;
        }
        if (runningAppProcesses != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == i) {
                    if (runningAppProcessInfo.uid == myUid) {
                        XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "other process is in updating plugin progress");
                        AppMethodBeat.m2505o(85420);
                        return true;
                    }
                }
            }
        }
        XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "plugin update process pid invalid, clear");
        C36603f.dVT();
        AppMethodBeat.m2505o(85420);
        return false;
    }

    public static void dVT() {
        AppMethodBeat.m2504i(85421);
        SharedPreferences sharedPreferencesForPluginUpdateInfo = XWalkEnvironment.getSharedPreferencesForPluginUpdateInfo();
        if (sharedPreferencesForPluginUpdateInfo == null) {
            AppMethodBeat.m2505o(85421);
            return;
        }
        Editor edit = sharedPreferencesForPluginUpdateInfo.edit();
        edit.remove(XWalkEnvironment.SP_KEY_PLUGIN_UPDATE_PROCESS_ID);
        edit.commit();
        XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "plugin update progress finish");
        AppMethodBeat.m2505o(85421);
    }
}
