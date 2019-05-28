package com.tencent.xweb;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Debug;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.c.k;
import com.tencent.xweb.i.a;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class m {
    private static m AMq = null;
    public a AMA = a.RT_TYPE_AUTO;
    public boolean AMB = false;
    String AMC = "";
    public Context AMr;
    d AMs = d.WV_KIND_NONE;
    public boolean AMt = false;
    public boolean AMu = false;
    public boolean AMv = false;
    public boolean AMw = false;
    boolean AMx = false;
    public boolean AMy = false;
    public boolean AMz = false;

    public static void jy(Context context) {
        AppMethodBeat.i(3825);
        if (AMq != null) {
            AppMethodBeat.o(3825);
            return;
        }
        m mVar = new m();
        AMq = mVar;
        mVar.AMr = context.getApplicationContext();
        XWalkEnvironment.init(context);
        AMq.AMu = context.getSharedPreferences("wcwebview", 0).getBoolean("bShowVersion", false);
        AMq.AMv = context.getSharedPreferences("wcwebview", 0).getBoolean("bShowX5Version", false);
        AMq.AMw = context.getSharedPreferences("wcwebview", 0).getBoolean("bShowSavePage", false);
        try {
            AMq.AMA = a.valueOf(context.getSharedPreferences("wcwebview", 0).getString("V8type", "RT_TYPE_AUTO"));
        } catch (Exception e) {
        }
        AMq.AMt = XWalkEnvironment.getSharedPreferences().getBoolean("ENABLEREMOTEDEBUG", false);
        String testDownLoadUrl = XWalkEnvironment.getTestDownLoadUrl(context);
        m mVar2 = AMq;
        boolean z = (testDownLoadUrl == null || testDownLoadUrl.isEmpty()) ? false : true;
        mVar2.AMB = z;
        AMq.AMy = context.getSharedPreferences("wcwebview", 0).getBoolean("bWaitforDebugger", false);
        if (AMq.AMy) {
            testDownLoadUrl = AMq.AMr.getSharedPreferences("wcwebview", 4).getString("strDebugProcess", "");
            if (testDownLoadUrl != null && testDownLoadUrl.equals(XWalkEnvironment.getProcessName())) {
                Debug.waitForDebugger();
                Log.w("WebDebugCfg", "strDebugProcess is ".concat(String.valueOf(testDownLoadUrl)));
            }
        }
        AMq.AMz = context.getSharedPreferences("wcwebview", 0).getBoolean("ignore_crashwatch", false);
        AppMethodBeat.o(3825);
    }

    public static m dTZ() {
        return AMq;
    }

    public final d avg(String str) {
        AppMethodBeat.i(3826);
        d dVar;
        if (this.AMC.equals(str)) {
            dVar = this.AMs;
            AppMethodBeat.o(3826);
            return dVar;
        } else if (str == null || str.isEmpty() || this.AMr == null) {
            dVar = d.WV_KIND_NONE;
            AppMethodBeat.o(3826);
            return dVar;
        } else {
            this.AMC = str;
            SharedPreferences sharedPreferences = this.AMr.getSharedPreferences("wcwebview", 0);
            if (sharedPreferences == null) {
                dVar = d.WV_KIND_NONE;
                AppMethodBeat.o(3826);
                return dVar;
            }
            String string = sharedPreferences.getString("HardCodeWebView".concat(String.valueOf(str)), "");
            if (string == null || string.isEmpty() || string.equals(d.WV_KIND_NONE.toString())) {
                string = sharedPreferences.getString("ABTestWebView".concat(String.valueOf(str)), "");
            }
            if (string == null || string.isEmpty()) {
                this.AMs = d.WV_KIND_NONE;
            } else {
                try {
                    this.AMs = d.valueOf(string);
                } catch (Exception e) {
                    this.AMs = d.WV_KIND_NONE;
                }
            }
            dVar = this.AMs;
            AppMethodBeat.o(3826);
            return dVar;
        }
    }

    public final void a(String str, d dVar) {
        AppMethodBeat.i(3827);
        if (this.AMr == null || str == null || str.isEmpty()) {
            AppMethodBeat.o(3827);
            return;
        }
        this.AMC = str;
        this.AMs = dVar;
        this.AMr.getSharedPreferences("wcwebview", 0).edit().putString("HardCodeWebView".concat(String.valueOf(str)), dVar.toString()).commit();
        AppMethodBeat.o(3827);
    }

    public final void rw(boolean z) {
        AppMethodBeat.i(3828);
        if (z == this.AMt) {
            AppMethodBeat.o(3828);
            return;
        }
        this.AMt = z;
        XWalkEnvironment.getSharedPreferences().edit().putBoolean("ENABLEREMOTEDEBUG", z).commit();
        AppMethodBeat.o(3828);
    }

    public final void rx(boolean z) {
        AppMethodBeat.i(3829);
        if (z == this.AMw) {
            AppMethodBeat.o(3829);
            return;
        }
        this.AMw = z;
        this.AMr.getSharedPreferences("wcwebview", 0).edit().putBoolean("bShowSavePage", this.AMw).commit();
        AppMethodBeat.o(3829);
    }

    public final void a(String[] strArr, d.a aVar) {
        AppMethodBeat.i(3830);
        if (strArr == null || strArr.length == 0) {
            AppMethodBeat.o(3830);
            return;
        }
        Editor edit = this.AMr.getSharedPreferences("wcwebview", 4).edit();
        for (String toLowerCase : strArr) {
            edit.putString("force_fr_" + toLowerCase.toLowerCase(), aVar.toString());
        }
        edit.commit();
        AppMethodBeat.o(3830);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(3831);
        if (this.AMA == aVar) {
            AppMethodBeat.o(3831);
            return;
        }
        this.AMA = aVar;
        this.AMr.getSharedPreferences("wcwebview", 0).edit().putString("V8type", aVar.toString()).commit();
        AppMethodBeat.o(3831);
    }

    public final void ry(boolean z) {
        AppMethodBeat.i(3832);
        if (z == this.AMB) {
            AppMethodBeat.o(3832);
            return;
        }
        this.AMB = z;
        Editor edit;
        if (this.AMB) {
            if (XWalkEnvironment.isIaDevice()) {
                XWalkEnvironment.setTestDownLoadUrl(this.AMr, "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_x86_test.xml");
            } else {
                XWalkEnvironment.setTestDownLoadUrl(this.AMr, "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_test.xml");
            }
            edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
            edit.putLong("nLastFetchConfigTime", 0);
            edit.commit();
            k.f(d.WV_KIND_CW).excute("STR_CMD_CLEAR_SCHEDULER", null);
            AppMethodBeat.o(3832);
            return;
        }
        XWalkEnvironment.setTestDownLoadUrl(this.AMr, "");
        edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        edit.putLong("nLastFetchConfigTime", 0);
        edit.commit();
        k.f(d.WV_KIND_CW).excute("STR_CMD_CLEAR_SCHEDULER", null);
        AppMethodBeat.o(3832);
    }
}
