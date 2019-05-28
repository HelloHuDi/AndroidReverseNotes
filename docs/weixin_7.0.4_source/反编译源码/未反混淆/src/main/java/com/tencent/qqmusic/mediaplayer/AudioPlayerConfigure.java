package com.tencent.qqmusic.mediaplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public class AudioPlayerConfigure {
    private static final String LIB_PREFIX = "lib";
    private static final String LIB_SUFFIX = ".so";
    private static final String TAG = "AudioPlayerConfigure";
    static ISoLibraryLoader mISoLibraryLoader = new ISoLibraryLoader() {
        public final boolean load(String str) {
            AppMethodBeat.i(128391);
            System.loadLibrary(str);
            AppMethodBeat.o(128391);
            return true;
        }

        public final String findLibPath(String str) {
            AppMethodBeat.i(128392);
            if (!str.startsWith(AudioPlayerConfigure.LIB_PREFIX)) {
                str = AudioPlayerConfigure.LIB_PREFIX.concat(String.valueOf(str));
            }
            if (!str.endsWith(AudioPlayerConfigure.LIB_SUFFIX)) {
                str = str + AudioPlayerConfigure.LIB_SUFFIX;
            }
            AppMethodBeat.o(128392);
            return str;
        }
    };
    static int minAudioTrackWaitTimeMs = 300;
    private static boolean sIsNlogEnabled = false;

    static {
        AppMethodBeat.i(128352);
        AppMethodBeat.o(128352);
    }

    private static byte[] findLibPath(byte[] bArr) {
        AppMethodBeat.i(128348);
        byte[] bytes = mISoLibraryLoader.findLibPath(new String(bArr)).getBytes();
        AppMethodBeat.o(128348);
        return bytes;
    }

    public static void setSoLibraryLoader(ISoLibraryLoader iSoLibraryLoader) {
        if (iSoLibraryLoader != null) {
            mISoLibraryLoader = iSoLibraryLoader;
        }
    }

    public static ISoLibraryLoader getSoLibraryLoader() {
        return mISoLibraryLoader;
    }

    public static void setLog(ILog iLog) {
        AppMethodBeat.i(128349);
        if (iLog != null) {
            iLog.i(TAG, "QQMusicAudioPlayer codec version:1.2");
        }
        Logger.setLog(iLog);
        AppMethodBeat.o(128349);
    }

    public static boolean enableNativeLog(String str) {
        AppMethodBeat.i(128350);
        boolean enableNativeLog = enableNativeLog(NativeLibs.nlog.getName(), str);
        AppMethodBeat.o(128350);
        return enableNativeLog;
    }

    public static boolean enableNativeLog(String str, String str2) {
        AppMethodBeat.i(128351);
        if (sIsNlogEnabled) {
            AppMethodBeat.o(128351);
            return true;
        }
        String findLibPath = getSoLibraryLoader().findLibPath(str);
        Logger.i(TAG, "[enableNativeLog] loading log lib: ".concat(String.valueOf(findLibPath)));
        boolean z = str2 == null;
        if (NLog.init(str, str2, 0) && NativeLog.init(findLibPath) == 0) {
            sIsNlogEnabled = true;
            NLog.setWriteCallback(z);
            Logger.i(TAG, "[enableNativeLog] succeed");
        } else {
            Logger.e(TAG, "[enableNativeLog] failed");
        }
        boolean z2 = sIsNlogEnabled;
        AppMethodBeat.o(128351);
        return z2;
    }

    public static void setAudioTrackMinWaitTimeMs(int i) {
        minAudioTrackWaitTimeMs = i;
    }
}
