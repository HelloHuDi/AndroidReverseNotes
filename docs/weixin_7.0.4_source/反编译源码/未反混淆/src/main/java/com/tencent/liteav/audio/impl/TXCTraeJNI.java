package com.tencent.liteav.audio.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.liteav.audio.TXCLiveBGMPlayer;
import com.tencent.liteav.audio.d;
import com.tencent.liteav.audio.impl.Play.TXCAudioBasePlayController;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.lang.ref.WeakReference;

public class TXCTraeJNI {
    private static Context mContext;
    private static WeakReference<d> mTraeRecordListener;

    public static native void nativeAppendLibraryPath(String str);

    public static native void nativeCacheClassForNative();

    public static native void nativeSetAudioMode(int i);

    public static native void nativeSetTraeConfig(String str);

    public static native boolean nativeTraeIsPlaying();

    public static native boolean nativeTraeIsRecording();

    public static native void nativeTraeSetChangerType(int i, int i2);

    public static native void nativeTraeSetRecordMute(boolean z);

    public static native void nativeTraeSetRecordReverb(int i);

    public static native void nativeTraeSetVolume(float f);

    public static native void nativeTraeStartPlay(Context context);

    public static native void nativeTraeStartRecord(Context context, int i, int i2, int i3);

    public static native void nativeTraeStopPlay();

    public static native void nativeTraeStopRecord(boolean z);

    static {
        AppMethodBeat.i(66566);
        b.e();
        nativeCacheClassForNative();
        AppMethodBeat.o(66566);
    }

    public static void setContext(Context context) {
        mContext = context;
    }

    public static void setTraeRecordListener(WeakReference<d> weakReference) {
        mTraeRecordListener = weakReference;
    }

    public static void onRecordRawPcmData(byte[] bArr, int i, int i2, int i3) {
        AppMethodBeat.i(66557);
        if (!(mTraeRecordListener == null || mTraeRecordListener.get() == null)) {
            ((d) mTraeRecordListener.get()).a(bArr, TXCTimeUtil.getTimeTick(), i, i2, i3, false);
        }
        AppMethodBeat.o(66557);
    }

    public static void onRecordPcmData(byte[] bArr, int i, int i2, int i3) {
        AppMethodBeat.i(66558);
        if (!(mTraeRecordListener == null || mTraeRecordListener.get() == null)) {
            ((d) mTraeRecordListener.get()).a(bArr, TXCTimeUtil.getTimeTick(), i, i2, i3);
        }
        AppMethodBeat.o(66558);
    }

    public static void onRecordEncData(byte[] bArr, long j, int i, int i2, int i3) {
        AppMethodBeat.i(66559);
        if (!(mTraeRecordListener == null || mTraeRecordListener.get() == null)) {
            ((d) mTraeRecordListener.get()).b(bArr, j, i, i2, i3);
        }
        AppMethodBeat.o(66559);
    }

    public static void onRecordError(int i, String str) {
        AppMethodBeat.i(66560);
        if (!(mTraeRecordListener == null || mTraeRecordListener.get() == null)) {
            ((d) mTraeRecordListener.get()).a(i, str);
        }
        AppMethodBeat.o(66560);
    }

    public static void SetAudioMode(int i) {
        AppMethodBeat.i(66561);
        a.a().a(i);
        AppMethodBeat.o(66561);
    }

    public static void InitTraeEngineLibrary(Context context) {
        AppMethodBeat.i(66562);
        if (context == null) {
            TXCLog.e("TXCAudioJNI", "nativeInitTraeEngine failed, context is null!");
            AppMethodBeat.o(66562);
            return;
        }
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String str = applicationInfo.nativeLibraryDir;
            String str2 = applicationInfo.dataDir + "/lib";
            String str3 = "/data/data/" + applicationInfo.packageName + "/lib";
            nativeAppendLibraryPath("add_libpath:".concat(String.valueOf(str)));
            nativeAppendLibraryPath("add_libpath:".concat(String.valueOf(str2)));
            nativeAppendLibraryPath("add_libpath:".concat(String.valueOf(str3)));
            AppMethodBeat.o(66562);
        } catch (UnsatisfiedLinkError e) {
            AppMethodBeat.o(66562);
        }
    }

    public static boolean nativeCheckTraeEngine(Context context) {
        AppMethodBeat.i(66563);
        if (context == null) {
            TXCLog.e("TXCAudioJNI", "nativeCheckTraeEngine failed, context is null!");
            AppMethodBeat.o(66563);
            return false;
        }
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String str = applicationInfo.nativeLibraryDir;
        String str2 = applicationInfo.dataDir + "/lib";
        String str3 = "/data/data/" + applicationInfo.packageName + "/lib";
        String f = b.f();
        if (f == null) {
            f = "";
        }
        String str4 = "/libtraeimp-rtmp-armeabi-v7a.so";
        String str5 = "/libtraeimp-rtmp-armeabi.so";
        if (new File(str + str4).exists()) {
            AppMethodBeat.o(66563);
            return true;
        } else if (new File(str2 + str4).exists()) {
            AppMethodBeat.o(66563);
            return true;
        } else if (new File(str3 + str4).exists()) {
            AppMethodBeat.o(66563);
            return true;
        } else if (new File(f + str4).exists()) {
            AppMethodBeat.o(66563);
            return true;
        } else if (new File(str + str5).exists()) {
            AppMethodBeat.o(66563);
            return true;
        } else if (new File(str2 + str5).exists()) {
            AppMethodBeat.o(66563);
            return true;
        } else if (new File(str3 + str5).exists()) {
            AppMethodBeat.o(66563);
            return true;
        } else if (new File(f + str5).exists()) {
            AppMethodBeat.o(66563);
            return true;
        } else {
            AppMethodBeat.o(66563);
            return false;
        }
    }

    public static boolean traeStartPlay(Context context) {
        AppMethodBeat.i(66564);
        if (!TXCAudioBasePlayController.nativeIsTracksEmpty() || TXCLiveBGMPlayer.getInstance().isPlaying()) {
            InitTraeEngineLibrary(context);
            nativeTraeStartPlay(context);
            AppMethodBeat.o(66564);
            return true;
        }
        AppMethodBeat.o(66564);
        return false;
    }

    public static boolean traeStopPlay() {
        AppMethodBeat.i(66565);
        if (!TXCAudioBasePlayController.nativeIsTracksEmpty() || TXCLiveBGMPlayer.getInstance().isPlaying()) {
            AppMethodBeat.o(66565);
            return false;
        }
        nativeTraeStopPlay();
        AppMethodBeat.o(66565);
        return true;
    }
}
