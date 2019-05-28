package com.tencent.qqmusic.mediaplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public class AudioPlayerConfigure {
    private static final String LIB_PREFIX = "lib";
    private static final String LIB_SUFFIX = ".so";
    private static final String TAG = "AudioPlayerConfigure";
    static ISoLibraryLoader mISoLibraryLoader = new C161221();
    static int minAudioTrackWaitTimeMs = 300;
    private static boolean sIsNlogEnabled = false;

    /* renamed from: com.tencent.qqmusic.mediaplayer.AudioPlayerConfigure$1 */
    static class C161221 implements ISoLibraryLoader {
        C161221() {
        }

        public final boolean load(String str) {
            AppMethodBeat.m2504i(128391);
            System.loadLibrary(str);
            AppMethodBeat.m2505o(128391);
            return true;
        }

        public final String findLibPath(String str) {
            AppMethodBeat.m2504i(128392);
            if (!str.startsWith(AudioPlayerConfigure.LIB_PREFIX)) {
                str = AudioPlayerConfigure.LIB_PREFIX.concat(String.valueOf(str));
            }
            if (!str.endsWith(AudioPlayerConfigure.LIB_SUFFIX)) {
                str = str + AudioPlayerConfigure.LIB_SUFFIX;
            }
            AppMethodBeat.m2505o(128392);
            return str;
        }
    }

    static {
        AppMethodBeat.m2504i(128352);
        AppMethodBeat.m2505o(128352);
    }

    private static byte[] findLibPath(byte[] bArr) {
        AppMethodBeat.m2504i(128348);
        byte[] bytes = mISoLibraryLoader.findLibPath(new String(bArr)).getBytes();
        AppMethodBeat.m2505o(128348);
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
        AppMethodBeat.m2504i(128349);
        if (iLog != null) {
            iLog.mo24634i(TAG, "QQMusicAudioPlayer codec version:1.2");
        }
        Logger.setLog(iLog);
        AppMethodBeat.m2505o(128349);
    }

    public static boolean enableNativeLog(String str) {
        AppMethodBeat.m2504i(128350);
        boolean enableNativeLog = enableNativeLog(NativeLibs.nlog.getName(), str);
        AppMethodBeat.m2505o(128350);
        return enableNativeLog;
    }

    public static boolean enableNativeLog(String str, String str2) {
        AppMethodBeat.m2504i(128351);
        if (sIsNlogEnabled) {
            AppMethodBeat.m2505o(128351);
            return true;
        }
        String findLibPath = getSoLibraryLoader().findLibPath(str);
        Logger.m71025i(TAG, "[enableNativeLog] loading log lib: ".concat(String.valueOf(findLibPath)));
        boolean z = str2 == null;
        if (NLog.init(str, str2, 0) && NativeLog.init(findLibPath) == 0) {
            sIsNlogEnabled = true;
            NLog.setWriteCallback(z);
            Logger.m71025i(TAG, "[enableNativeLog] succeed");
        } else {
            Logger.m71021e(TAG, "[enableNativeLog] failed");
        }
        boolean z2 = sIsNlogEnabled;
        AppMethodBeat.m2505o(128351);
        return z2;
    }

    public static void setAudioTrackMinWaitTimeMs(int i) {
        minAudioTrackWaitTimeMs = i;
    }
}
