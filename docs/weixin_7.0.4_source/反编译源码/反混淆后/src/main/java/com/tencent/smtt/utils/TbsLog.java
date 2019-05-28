package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsConfig;
import java.util.LinkedList;
import java.util.List;

public class TbsLog {
    public static final int TBSLOG_CODE_SDK_BASE = 1000;
    public static final int TBSLOG_CODE_SDK_CONFLICT_X5CORE = 993;
    public static final int TBSLOG_CODE_SDK_INIT = 999;
    public static final int TBSLOG_CODE_SDK_INVOKE_ERROR = 997;
    public static final int TBSLOG_CODE_SDK_LOAD_ERROR = 998;
    public static final int TBSLOG_CODE_SDK_NO_SHARE_X5CORE = 994;
    public static final int TBSLOG_CODE_SDK_SELF_MODE = 996;
    public static final int TBSLOG_CODE_SDK_THIRD_MODE = 995;
    public static final int TBSLOG_CODE_SDK_UNAVAIL_X5CORE = 992;
    public static final String X5LOGTAG = "x5logtag";
    /* renamed from: a */
    private static boolean f17302a = false;
    /* renamed from: b */
    private static boolean f17303b = true;
    /* renamed from: c */
    private static TbsLogClient f17304c = null;
    public static int sLogMaxCount = 10;
    public static List<String> sTbsLogList = new LinkedList();

    static {
        AppMethodBeat.m2504i(65337);
        AppMethodBeat.m2505o(65337);
    }

    public static void addLog(int i, String str, Object... objArr) {
        AppMethodBeat.m2504i(65336);
        synchronized (sTbsLogList) {
            try {
                if (sTbsLogList.size() > sLogMaxCount) {
                    int size = sTbsLogList.size() - sLogMaxCount;
                    while (true) {
                        int i2 = size - 1;
                        if (size <= 0 || sTbsLogList.size() <= 0) {
                            break;
                        }
                        sTbsLogList.remove(0);
                        size = i2;
                    }
                }
                String str2 = null;
                if (str != null) {
                    try {
                        str2 = String.format(str, objArr);
                    } catch (Exception e) {
                    }
                }
                if (str2 == null) {
                    str2 = "";
                }
                sTbsLogList.add(String.format("[%d][%d][%c][%d]%s", new Object[]{Long.valueOf(System.currentTimeMillis()), Integer.valueOf(1), Character.valueOf('0'), Integer.valueOf(i), str2}));
            } catch (Exception e2) {
            }
            try {
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(65336);
            }
        }
    }

    public static void app_extra(String str, Context context) {
        int i = 0;
        AppMethodBeat.m2504i(65322);
        try {
            Context applicationContext = context.getApplicationContext();
            String[] strArr = new String[]{TbsConfig.APP_DEMO, TbsConfig.APP_QB, "com.tencent.mm", TbsConfig.APP_QQ, TbsConfig.APP_DEMO_TEST, TbsConfig.APP_QZONE};
            String[] strArr2 = new String[]{"DEMO", "QB", "WX", "QQ", "TEST", "QZ"};
            while (i < 6) {
                if (applicationContext.getPackageName().contains(strArr[i])) {
                    m80434i(str, "app_extra pid:" + Process.myPid() + "; APP_TAG:" + strArr2[i] + "!");
                    break;
                }
                i++;
            }
            if (i == 6) {
                m80434i(str, "app_extra pid:" + Process.myPid() + "; APP_TAG:OTHER!");
            }
            AppMethodBeat.m2505o(65322);
        } catch (Throwable th) {
            m80438w(str, "app_extra exception:" + Log.getStackTraceString(th));
            AppMethodBeat.m2505o(65322);
        }
    }

    /* renamed from: d */
    public static void m80430d(String str, String str2) {
        if (f17304c == null) {
        }
    }

    /* renamed from: d */
    public static void m80431d(String str, String str2, boolean z) {
        AppMethodBeat.m2504i(65329);
        m80430d(str, str2);
        if (f17304c != null && f17302a && z) {
            f17304c.showLog(str + ": " + str2);
        }
        AppMethodBeat.m2505o(65329);
    }

    /* renamed from: e */
    public static void m80432e(String str, String str2) {
        AppMethodBeat.m2504i(65325);
        if (f17304c == null) {
            AppMethodBeat.m2505o(65325);
            return;
        }
        f17304c.writeLog("(E)-" + str + "-TBS:" + str2);
        AppMethodBeat.m2505o(65325);
    }

    /* renamed from: e */
    public static void m80433e(String str, String str2, boolean z) {
        AppMethodBeat.m2504i(65326);
        m80432e(str, str2);
        if (f17304c != null && f17302a && z) {
            f17304c.showLog(str + ": " + str2);
        }
        AppMethodBeat.m2505o(65326);
    }

    public static String getTbsLogFilePath() {
        AppMethodBeat.m2504i(65333);
        if (TbsLogClient.f16317c != null) {
            String absolutePath = TbsLogClient.f16317c.getAbsolutePath();
            AppMethodBeat.m2505o(65333);
            return absolutePath;
        }
        AppMethodBeat.m2505o(65333);
        return null;
    }

    /* renamed from: i */
    public static void m80434i(String str, String str2) {
        AppMethodBeat.m2504i(65323);
        if (f17304c == null) {
            AppMethodBeat.m2505o(65323);
            return;
        }
        f17304c.writeLog("(I)-" + str + "-TBS:" + str2);
        AppMethodBeat.m2505o(65323);
    }

    /* renamed from: i */
    public static void m80435i(String str, String str2, boolean z) {
        AppMethodBeat.m2504i(65324);
        m80434i(str, str2);
        if (f17304c != null && f17302a && z) {
            f17304c.showLog(str + ": " + str2);
        }
        AppMethodBeat.m2505o(65324);
    }

    public static synchronized void initIfNeed(Context context) {
        synchronized (TbsLog.class) {
            AppMethodBeat.m2504i(65334);
            if (f17304c == null) {
                setTbsLogClient(new TbsLogClient(context));
            }
            AppMethodBeat.m2505o(65334);
        }
    }

    public static void setLogView(TextView textView) {
        AppMethodBeat.m2504i(65331);
        if (textView == null || f17304c == null) {
            AppMethodBeat.m2505o(65331);
            return;
        }
        f17304c.setLogView(textView);
        AppMethodBeat.m2505o(65331);
    }

    public static boolean setTbsLogClient(TbsLogClient tbsLogClient) {
        AppMethodBeat.m2504i(65332);
        if (tbsLogClient == null) {
            AppMethodBeat.m2505o(65332);
            return false;
        }
        f17304c = tbsLogClient;
        TbsLogClient.setWriteLogJIT(f17303b);
        AppMethodBeat.m2505o(65332);
        return true;
    }

    public static void setWriteLogJIT(boolean z) {
        AppMethodBeat.m2504i(65321);
        f17303b = z;
        if (f17304c == null) {
            AppMethodBeat.m2505o(65321);
            return;
        }
        TbsLogClient.setWriteLogJIT(z);
        AppMethodBeat.m2505o(65321);
    }

    /* renamed from: v */
    public static void m80436v(String str, String str2) {
        if (f17304c == null) {
        }
    }

    /* renamed from: v */
    public static void m80437v(String str, String str2, boolean z) {
        AppMethodBeat.m2504i(65330);
        m80436v(str, str2);
        if (f17304c != null && f17302a && z) {
            f17304c.showLog(str + ": " + str2);
        }
        AppMethodBeat.m2505o(65330);
    }

    /* renamed from: w */
    public static void m80438w(String str, String str2) {
        AppMethodBeat.m2504i(65327);
        if (f17304c == null) {
            AppMethodBeat.m2505o(65327);
            return;
        }
        f17304c.writeLog("(W)-" + str + "-TBS:" + str2);
        AppMethodBeat.m2505o(65327);
    }

    /* renamed from: w */
    public static void m80439w(String str, String str2, boolean z) {
        AppMethodBeat.m2504i(65328);
        m80438w(str, str2);
        if (f17304c != null && f17302a && z) {
            f17304c.showLog(str + ": " + str2);
        }
        AppMethodBeat.m2505o(65328);
    }

    public static synchronized void writeLogToDisk() {
        synchronized (TbsLog.class) {
            AppMethodBeat.m2504i(65335);
            if (f17304c != null) {
                f17304c.writeLogToDisk();
            }
            AppMethodBeat.m2505o(65335);
        }
    }
}
