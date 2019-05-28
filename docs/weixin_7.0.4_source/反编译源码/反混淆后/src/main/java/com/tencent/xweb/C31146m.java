package com.tencent.xweb;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Debug;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.C31139d.C31140a;
import com.tencent.xweb.C41128i.C36587a;
import com.tencent.xweb.WebView.C44570d;
import com.tencent.xweb.p1115c.C44581k;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.xweb.m */
public final class C31146m {
    private static C31146m AMq = null;
    public C36587a AMA = C36587a.RT_TYPE_AUTO;
    public boolean AMB = false;
    String AMC = "";
    public Context AMr;
    C44570d AMs = C44570d.WV_KIND_NONE;
    public boolean AMt = false;
    public boolean AMu = false;
    public boolean AMv = false;
    public boolean AMw = false;
    boolean AMx = false;
    public boolean AMy = false;
    public boolean AMz = false;

    /* renamed from: jy */
    public static void m50231jy(Context context) {
        AppMethodBeat.m2504i(3825);
        if (AMq != null) {
            AppMethodBeat.m2505o(3825);
            return;
        }
        C31146m c31146m = new C31146m();
        AMq = c31146m;
        c31146m.AMr = context.getApplicationContext();
        XWalkEnvironment.init(context);
        AMq.AMu = context.getSharedPreferences("wcwebview", 0).getBoolean("bShowVersion", false);
        AMq.AMv = context.getSharedPreferences("wcwebview", 0).getBoolean("bShowX5Version", false);
        AMq.AMw = context.getSharedPreferences("wcwebview", 0).getBoolean("bShowSavePage", false);
        try {
            AMq.AMA = C36587a.valueOf(context.getSharedPreferences("wcwebview", 0).getString("V8type", "RT_TYPE_AUTO"));
        } catch (Exception e) {
        }
        AMq.AMt = XWalkEnvironment.getSharedPreferences().getBoolean("ENABLEREMOTEDEBUG", false);
        String testDownLoadUrl = XWalkEnvironment.getTestDownLoadUrl(context);
        C31146m c31146m2 = AMq;
        boolean z = (testDownLoadUrl == null || testDownLoadUrl.isEmpty()) ? false : true;
        c31146m2.AMB = z;
        AMq.AMy = context.getSharedPreferences("wcwebview", 0).getBoolean("bWaitforDebugger", false);
        if (AMq.AMy) {
            testDownLoadUrl = AMq.AMr.getSharedPreferences("wcwebview", 4).getString("strDebugProcess", "");
            if (testDownLoadUrl != null && testDownLoadUrl.equals(XWalkEnvironment.getProcessName())) {
                Debug.waitForDebugger();
                Log.m81051w("WebDebugCfg", "strDebugProcess is ".concat(String.valueOf(testDownLoadUrl)));
            }
        }
        AMq.AMz = context.getSharedPreferences("wcwebview", 0).getBoolean("ignore_crashwatch", false);
        AppMethodBeat.m2505o(3825);
    }

    public static C31146m dTZ() {
        return AMq;
    }

    public final C44570d avg(String str) {
        AppMethodBeat.m2504i(3826);
        C44570d c44570d;
        if (this.AMC.equals(str)) {
            c44570d = this.AMs;
            AppMethodBeat.m2505o(3826);
            return c44570d;
        } else if (str == null || str.isEmpty() || this.AMr == null) {
            c44570d = C44570d.WV_KIND_NONE;
            AppMethodBeat.m2505o(3826);
            return c44570d;
        } else {
            this.AMC = str;
            SharedPreferences sharedPreferences = this.AMr.getSharedPreferences("wcwebview", 0);
            if (sharedPreferences == null) {
                c44570d = C44570d.WV_KIND_NONE;
                AppMethodBeat.m2505o(3826);
                return c44570d;
            }
            String string = sharedPreferences.getString("HardCodeWebView".concat(String.valueOf(str)), "");
            if (string == null || string.isEmpty() || string.equals(C44570d.WV_KIND_NONE.toString())) {
                string = sharedPreferences.getString("ABTestWebView".concat(String.valueOf(str)), "");
            }
            if (string == null || string.isEmpty()) {
                this.AMs = C44570d.WV_KIND_NONE;
            } else {
                try {
                    this.AMs = C44570d.valueOf(string);
                } catch (Exception e) {
                    this.AMs = C44570d.WV_KIND_NONE;
                }
            }
            c44570d = this.AMs;
            AppMethodBeat.m2505o(3826);
            return c44570d;
        }
    }

    /* renamed from: a */
    public final void mo50905a(String str, C44570d c44570d) {
        AppMethodBeat.m2504i(3827);
        if (this.AMr == null || str == null || str.isEmpty()) {
            AppMethodBeat.m2505o(3827);
            return;
        }
        this.AMC = str;
        this.AMs = c44570d;
        this.AMr.getSharedPreferences("wcwebview", 0).edit().putString("HardCodeWebView".concat(String.valueOf(str)), c44570d.toString()).commit();
        AppMethodBeat.m2505o(3827);
    }

    /* renamed from: rw */
    public final void mo50908rw(boolean z) {
        AppMethodBeat.m2504i(3828);
        if (z == this.AMt) {
            AppMethodBeat.m2505o(3828);
            return;
        }
        this.AMt = z;
        XWalkEnvironment.getSharedPreferences().edit().putBoolean("ENABLEREMOTEDEBUG", z).commit();
        AppMethodBeat.m2505o(3828);
    }

    /* renamed from: rx */
    public final void mo50909rx(boolean z) {
        AppMethodBeat.m2504i(3829);
        if (z == this.AMw) {
            AppMethodBeat.m2505o(3829);
            return;
        }
        this.AMw = z;
        this.AMr.getSharedPreferences("wcwebview", 0).edit().putBoolean("bShowSavePage", this.AMw).commit();
        AppMethodBeat.m2505o(3829);
    }

    /* renamed from: a */
    public final void mo50906a(String[] strArr, C31140a c31140a) {
        AppMethodBeat.m2504i(3830);
        if (strArr == null || strArr.length == 0) {
            AppMethodBeat.m2505o(3830);
            return;
        }
        Editor edit = this.AMr.getSharedPreferences("wcwebview", 4).edit();
        for (String toLowerCase : strArr) {
            edit.putString("force_fr_" + toLowerCase.toLowerCase(), c31140a.toString());
        }
        edit.commit();
        AppMethodBeat.m2505o(3830);
    }

    /* renamed from: a */
    public final void mo50904a(C36587a c36587a) {
        AppMethodBeat.m2504i(3831);
        if (this.AMA == c36587a) {
            AppMethodBeat.m2505o(3831);
            return;
        }
        this.AMA = c36587a;
        this.AMr.getSharedPreferences("wcwebview", 0).edit().putString("V8type", c36587a.toString()).commit();
        AppMethodBeat.m2505o(3831);
    }

    /* renamed from: ry */
    public final void mo50910ry(boolean z) {
        AppMethodBeat.m2504i(3832);
        if (z == this.AMB) {
            AppMethodBeat.m2505o(3832);
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
            C44581k.m80968f(C44570d.WV_KIND_CW).excute("STR_CMD_CLEAR_SCHEDULER", null);
            AppMethodBeat.m2505o(3832);
            return;
        }
        XWalkEnvironment.setTestDownLoadUrl(this.AMr, "");
        edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        edit.putLong("nLastFetchConfigTime", 0);
        edit.commit();
        C44581k.m80968f(C44570d.WV_KIND_CW).excute("STR_CMD_CLEAR_SCHEDULER", null);
        AppMethodBeat.m2505o(3832);
    }
}
