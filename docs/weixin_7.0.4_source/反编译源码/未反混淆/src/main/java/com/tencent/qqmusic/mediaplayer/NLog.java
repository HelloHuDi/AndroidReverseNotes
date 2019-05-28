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

    private static native void d(String str, String str2);

    private static native void e(String str, String str2);

    private static native String getLogPath();

    private static native void i(String str, String str2);

    private static native void setLogWriteCallback(int i);

    private static native boolean start(String str, int i);

    private static native void stop();

    private static native void w(String str, String str2);

    private static void WriteLogCallback(int i, String str, String str2) {
        AppMethodBeat.i(128441);
        switch (i) {
            case 1:
                Logger.d(str, str2);
                AppMethodBeat.o(128441);
                return;
            case 2:
                Logger.i(str, str2);
                AppMethodBeat.o(128441);
                return;
            case 3:
                Logger.w(str, str2);
                AppMethodBeat.o(128441);
                return;
            case 4:
                Logger.e(str, str2);
                AppMethodBeat.o(128441);
                return;
            default:
                Logger.i(str, str2);
                AppMethodBeat.o(128441);
                return;
        }
    }

    public static boolean Start(String str, int i) {
        boolean z = false;
        AppMethodBeat.i(128442);
        if (mIsLoadSuccess) {
            try {
                z = start(str, i);
                AppMethodBeat.o(128442);
            } catch (UnsatisfiedLinkError e) {
                Logger.e(TAG, e);
                AppMethodBeat.o(128442);
            }
        } else {
            Logger.e(TAG, "Not load NLog lib!!!");
            AppMethodBeat.o(128442);
        }
        return z;
    }

    public static void Stop() {
        AppMethodBeat.i(128443);
        if (mIsLoadSuccess) {
            try {
                stop();
                AppMethodBeat.o(128443);
                return;
            } catch (UnsatisfiedLinkError e) {
                Logger.e(TAG, e);
                AppMethodBeat.o(128443);
                return;
            }
        }
        Logger.e(TAG, "Not load NLog lib!!!");
        AppMethodBeat.o(128443);
    }

    public static void setWriteCallback(boolean z) {
        AppMethodBeat.i(128444);
        if (mIsLoadSuccess) {
            try {
                setLogWriteCallback(z ? 1 : 0);
                AppMethodBeat.o(128444);
                return;
            } catch (UnsatisfiedLinkError e) {
                Logger.e(TAG, e);
                AppMethodBeat.o(128444);
                return;
            }
        }
        Logger.e(TAG, "Not load NLog lib!!!");
        AppMethodBeat.o(128444);
    }

    public static String GetLogPath() {
        AppMethodBeat.i(128445);
        String logPath;
        if (mIsLoadSuccess) {
            try {
                logPath = getLogPath();
                AppMethodBeat.o(128445);
                return logPath;
            } catch (UnsatisfiedLinkError e) {
                Logger.e(TAG, e);
                logPath = "";
                AppMethodBeat.o(128445);
                return logPath;
            }
        }
        Logger.e(TAG, "Not load NLog lib!!!");
        logPath = "";
        AppMethodBeat.o(128445);
        return logPath;
    }

    public static void D(String str, String str2) {
        AppMethodBeat.i(128446);
        if (mIsLoadSuccess) {
            try {
                d(str, str2);
                AppMethodBeat.o(128446);
                return;
            } catch (UnsatisfiedLinkError e) {
                Logger.e(TAG, e);
                AppMethodBeat.o(128446);
                return;
            }
        }
        Logger.e(TAG, "Not load NLog lib!!!");
        AppMethodBeat.o(128446);
    }

    public static void I(String str, String str2) {
        AppMethodBeat.i(128447);
        if (mIsLoadSuccess) {
            try {
                i(str, str2);
                AppMethodBeat.o(128447);
                return;
            } catch (UnsatisfiedLinkError e) {
                Logger.e(TAG, e);
                AppMethodBeat.o(128447);
                return;
            }
        }
        Logger.e(TAG, "Not load NLog lib!!!");
        AppMethodBeat.o(128447);
    }

    public static void W(String str, String str2) {
        AppMethodBeat.i(128448);
        if (mIsLoadSuccess) {
            try {
                w(str, str2);
                AppMethodBeat.o(128448);
                return;
            } catch (UnsatisfiedLinkError e) {
                Logger.e(TAG, e);
                AppMethodBeat.o(128448);
                return;
            }
        }
        Logger.e(TAG, "Not load NLog lib!!!");
        AppMethodBeat.o(128448);
    }

    public static void E(String str, String str2) {
        AppMethodBeat.i(128449);
        if (mIsLoadSuccess) {
            try {
                e(str, str2);
                AppMethodBeat.o(128449);
                return;
            } catch (UnsatisfiedLinkError e) {
                Logger.e(TAG, e);
                AppMethodBeat.o(128449);
                return;
            }
        }
        Logger.e(TAG, "Not load NLog lib!!!");
        AppMethodBeat.o(128449);
    }

    public static void D(String str, String str2, Throwable th) {
        AppMethodBeat.i(128450);
        d(str, str2 + IOUtils.LINE_SEPARATOR_UNIX + Log.getStackTraceString(th));
        AppMethodBeat.o(128450);
    }

    public static void I(String str, String str2, Throwable th) {
        AppMethodBeat.i(128451);
        i(str, str2 + IOUtils.LINE_SEPARATOR_UNIX + Log.getStackTraceString(th));
        AppMethodBeat.o(128451);
    }

    public static void W(String str, String str2, Throwable th) {
        AppMethodBeat.i(128452);
        w(str, str2 + IOUtils.LINE_SEPARATOR_UNIX + Log.getStackTraceString(th));
        AppMethodBeat.o(128452);
    }

    public static void E(String str, String str2, Throwable th) {
        AppMethodBeat.i(128453);
        e(str, str2 + IOUtils.LINE_SEPARATOR_UNIX + Log.getStackTraceString(th));
        AppMethodBeat.o(128453);
    }

    public static boolean init(String str, String str2, int i) {
        AppMethodBeat.i(128454);
        if (AudioPlayerConfigure.getSoLibraryLoader().load(str)) {
            mIsLoadSuccess = true;
            Start(str2, i);
            AppMethodBeat.o(128454);
            return true;
        }
        AppMethodBeat.o(128454);
        return false;
    }
}
