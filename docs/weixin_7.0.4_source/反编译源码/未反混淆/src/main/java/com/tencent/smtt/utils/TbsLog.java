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
    private static boolean a = false;
    private static boolean b = true;
    private static TbsLogClient c = null;
    public static int sLogMaxCount = 10;
    public static List<String> sTbsLogList = new LinkedList();

    static {
        AppMethodBeat.i(65337);
        AppMethodBeat.o(65337);
    }

    public static void addLog(int i, String str, Object... objArr) {
        AppMethodBeat.i(65336);
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
                AppMethodBeat.o(65336);
            }
        }
    }

    public static void app_extra(String str, Context context) {
        int i = 0;
        AppMethodBeat.i(65322);
        try {
            Context applicationContext = context.getApplicationContext();
            String[] strArr = new String[]{TbsConfig.APP_DEMO, TbsConfig.APP_QB, "com.tencent.mm", TbsConfig.APP_QQ, TbsConfig.APP_DEMO_TEST, TbsConfig.APP_QZONE};
            String[] strArr2 = new String[]{"DEMO", "QB", "WX", "QQ", "TEST", "QZ"};
            while (i < 6) {
                if (applicationContext.getPackageName().contains(strArr[i])) {
                    i(str, "app_extra pid:" + Process.myPid() + "; APP_TAG:" + strArr2[i] + "!");
                    break;
                }
                i++;
            }
            if (i == 6) {
                i(str, "app_extra pid:" + Process.myPid() + "; APP_TAG:OTHER!");
            }
            AppMethodBeat.o(65322);
        } catch (Throwable th) {
            w(str, "app_extra exception:" + Log.getStackTraceString(th));
            AppMethodBeat.o(65322);
        }
    }

    public static void d(String str, String str2) {
        if (c == null) {
        }
    }

    public static void d(String str, String str2, boolean z) {
        AppMethodBeat.i(65329);
        d(str, str2);
        if (c != null && a && z) {
            c.showLog(str + ": " + str2);
        }
        AppMethodBeat.o(65329);
    }

    public static void e(String str, String str2) {
        AppMethodBeat.i(65325);
        if (c == null) {
            AppMethodBeat.o(65325);
            return;
        }
        c.writeLog("(E)-" + str + "-TBS:" + str2);
        AppMethodBeat.o(65325);
    }

    public static void e(String str, String str2, boolean z) {
        AppMethodBeat.i(65326);
        e(str, str2);
        if (c != null && a && z) {
            c.showLog(str + ": " + str2);
        }
        AppMethodBeat.o(65326);
    }

    public static String getTbsLogFilePath() {
        AppMethodBeat.i(65333);
        if (TbsLogClient.c != null) {
            String absolutePath = TbsLogClient.c.getAbsolutePath();
            AppMethodBeat.o(65333);
            return absolutePath;
        }
        AppMethodBeat.o(65333);
        return null;
    }

    public static void i(String str, String str2) {
        AppMethodBeat.i(65323);
        if (c == null) {
            AppMethodBeat.o(65323);
            return;
        }
        c.writeLog("(I)-" + str + "-TBS:" + str2);
        AppMethodBeat.o(65323);
    }

    public static void i(String str, String str2, boolean z) {
        AppMethodBeat.i(65324);
        i(str, str2);
        if (c != null && a && z) {
            c.showLog(str + ": " + str2);
        }
        AppMethodBeat.o(65324);
    }

    public static synchronized void initIfNeed(Context context) {
        synchronized (TbsLog.class) {
            AppMethodBeat.i(65334);
            if (c == null) {
                setTbsLogClient(new TbsLogClient(context));
            }
            AppMethodBeat.o(65334);
        }
    }

    public static void setLogView(TextView textView) {
        AppMethodBeat.i(65331);
        if (textView == null || c == null) {
            AppMethodBeat.o(65331);
            return;
        }
        c.setLogView(textView);
        AppMethodBeat.o(65331);
    }

    public static boolean setTbsLogClient(TbsLogClient tbsLogClient) {
        AppMethodBeat.i(65332);
        if (tbsLogClient == null) {
            AppMethodBeat.o(65332);
            return false;
        }
        c = tbsLogClient;
        TbsLogClient.setWriteLogJIT(b);
        AppMethodBeat.o(65332);
        return true;
    }

    public static void setWriteLogJIT(boolean z) {
        AppMethodBeat.i(65321);
        b = z;
        if (c == null) {
            AppMethodBeat.o(65321);
            return;
        }
        TbsLogClient.setWriteLogJIT(z);
        AppMethodBeat.o(65321);
    }

    public static void v(String str, String str2) {
        if (c == null) {
        }
    }

    public static void v(String str, String str2, boolean z) {
        AppMethodBeat.i(65330);
        v(str, str2);
        if (c != null && a && z) {
            c.showLog(str + ": " + str2);
        }
        AppMethodBeat.o(65330);
    }

    public static void w(String str, String str2) {
        AppMethodBeat.i(65327);
        if (c == null) {
            AppMethodBeat.o(65327);
            return;
        }
        c.writeLog("(W)-" + str + "-TBS:" + str2);
        AppMethodBeat.o(65327);
    }

    public static void w(String str, String str2, boolean z) {
        AppMethodBeat.i(65328);
        w(str, str2);
        if (c != null && a && z) {
            c.showLog(str + ": " + str2);
        }
        AppMethodBeat.o(65328);
    }

    public static synchronized void writeLogToDisk() {
        synchronized (TbsLog.class) {
            AppMethodBeat.i(65335);
            if (c != null) {
                c.writeLogToDisk();
            }
            AppMethodBeat.o(65335);
        }
    }
}
