package com.tencent.xweb.xwalk.a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.List;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;

public final class f implements com.tencent.xweb.k.a {
    public String ASK = "";
    public a ASL = null;
    public g ASM = null;

    public interface a {
        void Sy(int i);

        void Sz(int i);

        void dVI();
    }

    public final void a(Context context, HashMap<String, String> hashMap) {
        AppMethodBeat.i(85418);
        this.ASM = new g();
        this.ASM.a((HashMap) hashMap, this.ASK, this.ASL);
        this.ASM.execute(new String[0]);
        this.ASK = "";
        this.ASL = null;
        AppMethodBeat.o(85418);
    }

    public final boolean isBusy() {
        if (this.ASM == null || this.ASM.ASV) {
            return false;
        }
        return true;
    }

    public static void nQ(long j) {
        AppMethodBeat.i(85419);
        SharedPreferences sharedPreferencesForPluginUpdateInfo = XWalkEnvironment.getSharedPreferencesForPluginUpdateInfo();
        if (sharedPreferencesForPluginUpdateInfo == null) {
            XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "set time sp is null");
            AppMethodBeat.o(85419);
            return;
        }
        Editor edit = sharedPreferencesForPluginUpdateInfo.edit();
        edit.putLong(XWalkEnvironment.SP_KEY_PLUGIN_UPDATE_CONFIG_LAST_FETCH_TIME, j);
        edit.commit();
        AppMethodBeat.o(85419);
    }

    public static boolean dVS() {
        AppMethodBeat.i(85420);
        SharedPreferences sharedPreferencesForPluginUpdateInfo = XWalkEnvironment.getSharedPreferencesForPluginUpdateInfo();
        if (sharedPreferencesForPluginUpdateInfo == null) {
            AppMethodBeat.o(85420);
            return false;
        }
        int i = sharedPreferencesForPluginUpdateInfo.getInt(XWalkEnvironment.SP_KEY_PLUGIN_UPDATE_PROCESS_ID, -1);
        if (i < 0) {
            AppMethodBeat.o(85420);
            return false;
        }
        int myPid = Process.myPid();
        int myUid = Process.myUid();
        if (i == myPid) {
            XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "current process is updating plugin");
            AppMethodBeat.o(85420);
            return true;
        }
        List runningAppProcesses;
        try {
            runningAppProcesses = ((ActivityManager) XWalkEnvironment.getApplicationContext().getSystemService("activity")).getRunningAppProcesses();
        } catch (Exception e) {
            Log.e("XWalkPluginUp", e.getMessage());
            runningAppProcesses = null;
        }
        if (runningAppProcesses != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == i) {
                    if (runningAppProcessInfo.uid == myUid) {
                        XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "other process is in updating plugin progress");
                        AppMethodBeat.o(85420);
                        return true;
                    }
                }
            }
        }
        XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "plugin update process pid invalid, clear");
        dVT();
        AppMethodBeat.o(85420);
        return false;
    }

    public static void dVT() {
        AppMethodBeat.i(85421);
        SharedPreferences sharedPreferencesForPluginUpdateInfo = XWalkEnvironment.getSharedPreferencesForPluginUpdateInfo();
        if (sharedPreferencesForPluginUpdateInfo == null) {
            AppMethodBeat.o(85421);
            return;
        }
        Editor edit = sharedPreferencesForPluginUpdateInfo.edit();
        edit.remove(XWalkEnvironment.SP_KEY_PLUGIN_UPDATE_PROCESS_ID);
        edit.commit();
        XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "plugin update progress finish");
        AppMethodBeat.o(85421);
    }
}
