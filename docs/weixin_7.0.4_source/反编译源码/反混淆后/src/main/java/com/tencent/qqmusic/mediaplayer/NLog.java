package com.tencent.qqmusic.mediaplayer;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.ttpic.baseutils.IOUtils;

public class NLog {
    private static final int LEVEL_DEBUG = 1;
    private static final int LEVEL_ERROR = 4;
    private static final int LEVEL_INFO = 2;
    private static final int LEVEL_WARNING = 3;
    private static final String TAG = "NLog";
    private static volatile boolean mIsLoadSuccess = false;

    /* renamed from: d */
    private static native void m80418d(String str, String str2);

    /* renamed from: e */
    private static native void m80419e(String str, String str2);

    private static native String getLogPath();

    /* renamed from: i */
    private static native void m80420i(String str, String str2);

    private static native void setLogWriteCallback(int i);

    private static native boolean start(String str, int i);

    private static native void stop();

    /* renamed from: w */
    private static native void m80421w(String str, String str2);

    private static void WriteLogCallback(int i, String str, String str2) {
        AppMethodBeat.m2504i(128441);
        switch (i) {
            case 1:
                Logger.m71020d(str, str2);
                AppMethodBeat.m2505o(128441);
                return;
            case 2:
                Logger.m71025i(str, str2);
                AppMethodBeat.m2505o(128441);
                return;
            case 3:
                Logger.m71027w(str, str2);
                AppMethodBeat.m2505o(128441);
                return;
            case 4:
                Logger.m71021e(str, str2);
                AppMethodBeat.m2505o(128441);
                return;
            default:
                Logger.m71025i(str, str2);
                AppMethodBeat.m2505o(128441);
                return;
        }
    }

    public static boolean Start(String str, int i) {
        boolean z = false;
        AppMethodBeat.m2504i(128442);
        if (mIsLoadSuccess) {
            try {
                z = start(str, i);
                AppMethodBeat.m2505o(128442);
            } catch (UnsatisfiedLinkError e) {
                Logger.m71024e(TAG, e);
                AppMethodBeat.m2505o(128442);
            }
        } else {
            Logger.m71021e(TAG, "Not load NLog lib!!!");
            AppMethodBeat.m2505o(128442);
        }
        return z;
    }

    public static void Stop() {
        AppMethodBeat.m2504i(128443);
        if (mIsLoadSuccess) {
            try {
                stop();
                AppMethodBeat.m2505o(128443);
                return;
            } catch (UnsatisfiedLinkError e) {
                Logger.m71024e(TAG, e);
                AppMethodBeat.m2505o(128443);
                return;
            }
        }
        Logger.m71021e(TAG, "Not load NLog lib!!!");
        AppMethodBeat.m2505o(128443);
    }

    public static void setWriteCallback(boolean z) {
        AppMethodBeat.m2504i(128444);
        if (mIsLoadSuccess) {
            try {
                setLogWriteCallback(z ? 1 : 0);
                AppMethodBeat.m2505o(128444);
                return;
            } catch (UnsatisfiedLinkError e) {
                Logger.m71024e(TAG, e);
                AppMethodBeat.m2505o(128444);
                return;
            }
        }
        Logger.m71021e(TAG, "Not load NLog lib!!!");
        AppMethodBeat.m2505o(128444);
    }

    public static String GetLogPath() {
        AppMethodBeat.m2504i(128445);
        String logPath;
        if (mIsLoadSuccess) {
            try {
                logPath = getLogPath();
                AppMethodBeat.m2505o(128445);
                return logPath;
            } catch (UnsatisfiedLinkError e) {
                Logger.m71024e(TAG, e);
                logPath = "";
                AppMethodBeat.m2505o(128445);
                return logPath;
            }
        }
        Logger.m71021e(TAG, "Not load NLog lib!!!");
        logPath = "";
        AppMethodBeat.m2505o(128445);
        return logPath;
    }

    /* renamed from: D */
    public static void m80410D(String str, String str2) {
        AppMethodBeat.m2504i(128446);
        if (mIsLoadSuccess) {
            try {
                m80418d(str, str2);
                AppMethodBeat.m2505o(128446);
                return;
            } catch (UnsatisfiedLinkError e) {
                Logger.m71024e(TAG, e);
                AppMethodBeat.m2505o(128446);
                return;
            }
        }
        Logger.m71021e(TAG, "Not load NLog lib!!!");
        AppMethodBeat.m2505o(128446);
    }

    /* renamed from: I */
    public static void m80414I(String str, String str2) {
        AppMethodBeat.m2504i(128447);
        if (mIsLoadSuccess) {
            try {
                m80420i(str, str2);
                AppMethodBeat.m2505o(128447);
                return;
            } catch (UnsatisfiedLinkError e) {
                Logger.m71024e(TAG, e);
                AppMethodBeat.m2505o(128447);
                return;
            }
        }
        Logger.m71021e(TAG, "Not load NLog lib!!!");
        AppMethodBeat.m2505o(128447);
    }

    /* renamed from: W */
    public static void m80416W(String str, String str2) {
        AppMethodBeat.m2504i(128448);
        if (mIsLoadSuccess) {
            try {
                m80421w(str, str2);
                AppMethodBeat.m2505o(128448);
                return;
            } catch (UnsatisfiedLinkError e) {
                Logger.m71024e(TAG, e);
                AppMethodBeat.m2505o(128448);
                return;
            }
        }
        Logger.m71021e(TAG, "Not load NLog lib!!!");
        AppMethodBeat.m2505o(128448);
    }

    /* renamed from: E */
    public static void m80412E(String str, String str2) {
        AppMethodBeat.m2504i(128449);
        if (mIsLoadSuccess) {
            try {
                m80419e(str, str2);
                AppMethodBeat.m2505o(128449);
                return;
            } catch (UnsatisfiedLinkError e) {
                Logger.m71024e(TAG, e);
                AppMethodBeat.m2505o(128449);
                return;
            }
        }
        Logger.m71021e(TAG, "Not load NLog lib!!!");
        AppMethodBeat.m2505o(128449);
    }

    /* renamed from: D */
    public static void m80411D(String str, String str2, Throwable th) {
        AppMethodBeat.m2504i(128450);
        m80418d(str, str2 + IOUtils.LINE_SEPARATOR_UNIX + Log.getStackTraceString(th));
        AppMethodBeat.m2505o(128450);
    }

    /* renamed from: I */
    public static void m80415I(String str, String str2, Throwable th) {
        AppMethodBeat.m2504i(128451);
        m80420i(str, str2 + IOUtils.LINE_SEPARATOR_UNIX + Log.getStackTraceString(th));
        AppMethodBeat.m2505o(128451);
    }

    /* renamed from: W */
    public static void m80417W(String str, String str2, Throwable th) {
        AppMethodBeat.m2504i(128452);
        m80421w(str, str2 + IOUtils.LINE_SEPARATOR_UNIX + Log.getStackTraceString(th));
        AppMethodBeat.m2505o(128452);
    }

    /* renamed from: E */
    public static void m80413E(String str, String str2, Throwable th) {
        AppMethodBeat.m2504i(128453);
        m80419e(str, str2 + IOUtils.LINE_SEPARATOR_UNIX + Log.getStackTraceString(th));
        AppMethodBeat.m2505o(128453);
    }

    public static boolean init(String str, String str2, int i) {
        AppMethodBeat.m2504i(128454);
        if (AudioPlayerConfigure.getSoLibraryLoader().load(str)) {
            mIsLoadSuccess = true;
            Start(str2, i);
            AppMethodBeat.m2505o(128454);
            return true;
        }
        AppMethodBeat.m2505o(128454);
        return false;
    }
}
