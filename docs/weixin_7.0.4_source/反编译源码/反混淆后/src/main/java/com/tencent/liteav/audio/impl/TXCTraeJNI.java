package com.tencent.liteav.audio.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.liteav.audio.C8792d;
import com.tencent.liteav.audio.TXCLiveBGMPlayer;
import com.tencent.liteav.audio.impl.Play.TXCAudioBasePlayController;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.C17778b;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.lang.ref.WeakReference;

public class TXCTraeJNI {
    private static Context mContext;
    private static WeakReference<C8792d> mTraeRecordListener;

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
        AppMethodBeat.m2504i(66566);
        C17778b.m27756e();
        nativeCacheClassForNative();
        AppMethodBeat.m2505o(66566);
    }

    public static void setContext(Context context) {
        mContext = context;
    }

    public static void setTraeRecordListener(WeakReference<C8792d> weakReference) {
        mTraeRecordListener = weakReference;
    }

    public static void onRecordRawPcmData(byte[] bArr, int i, int i2, int i3) {
        AppMethodBeat.m2504i(66557);
        if (!(mTraeRecordListener == null || mTraeRecordListener.get() == null)) {
            ((C8792d) mTraeRecordListener.get()).mo19857a(bArr, TXCTimeUtil.getTimeTick(), i, i2, i3, false);
        }
        AppMethodBeat.m2505o(66557);
    }

    public static void onRecordPcmData(byte[] bArr, int i, int i2, int i3) {
        AppMethodBeat.m2504i(66558);
        if (!(mTraeRecordListener == null || mTraeRecordListener.get() == null)) {
            ((C8792d) mTraeRecordListener.get()).mo19856a(bArr, TXCTimeUtil.getTimeTick(), i, i2, i3);
        }
        AppMethodBeat.m2505o(66558);
    }

    public static void onRecordEncData(byte[] bArr, long j, int i, int i2, int i3) {
        AppMethodBeat.m2504i(66559);
        if (!(mTraeRecordListener == null || mTraeRecordListener.get() == null)) {
            ((C8792d) mTraeRecordListener.get()).mo19858b(bArr, j, i, i2, i3);
        }
        AppMethodBeat.m2505o(66559);
    }

    public static void onRecordError(int i, String str) {
        AppMethodBeat.m2504i(66560);
        if (!(mTraeRecordListener == null || mTraeRecordListener.get() == null)) {
            ((C8792d) mTraeRecordListener.get()).mo19855a(i, str);
        }
        AppMethodBeat.m2505o(66560);
    }

    public static void SetAudioMode(int i) {
        AppMethodBeat.m2504i(66561);
        C32136a.m52261a().mo52716a(i);
        AppMethodBeat.m2505o(66561);
    }

    public static void InitTraeEngineLibrary(Context context) {
        AppMethodBeat.m2504i(66562);
        if (context == null) {
            TXCLog.m15676e("TXCAudioJNI", "nativeInitTraeEngine failed, context is null!");
            AppMethodBeat.m2505o(66562);
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
            AppMethodBeat.m2505o(66562);
        } catch (UnsatisfiedLinkError e) {
            AppMethodBeat.m2505o(66562);
        }
    }

    public static boolean nativeCheckTraeEngine(Context context) {
        AppMethodBeat.m2504i(66563);
        if (context == null) {
            TXCLog.m15676e("TXCAudioJNI", "nativeCheckTraeEngine failed, context is null!");
            AppMethodBeat.m2505o(66563);
            return false;
        }
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String str = applicationInfo.nativeLibraryDir;
        String str2 = applicationInfo.dataDir + "/lib";
        String str3 = "/data/data/" + applicationInfo.packageName + "/lib";
        String f = C17778b.m27757f();
        if (f == null) {
            f = "";
        }
        String str4 = "/libtraeimp-rtmp-armeabi-v7a.so";
        String str5 = "/libtraeimp-rtmp-armeabi.so";
        if (new File(str + str4).exists()) {
            AppMethodBeat.m2505o(66563);
            return true;
        } else if (new File(str2 + str4).exists()) {
            AppMethodBeat.m2505o(66563);
            return true;
        } else if (new File(str3 + str4).exists()) {
            AppMethodBeat.m2505o(66563);
            return true;
        } else if (new File(f + str4).exists()) {
            AppMethodBeat.m2505o(66563);
            return true;
        } else if (new File(str + str5).exists()) {
            AppMethodBeat.m2505o(66563);
            return true;
        } else if (new File(str2 + str5).exists()) {
            AppMethodBeat.m2505o(66563);
            return true;
        } else if (new File(str3 + str5).exists()) {
            AppMethodBeat.m2505o(66563);
            return true;
        } else if (new File(f + str5).exists()) {
            AppMethodBeat.m2505o(66563);
            return true;
        } else {
            AppMethodBeat.m2505o(66563);
            return false;
        }
    }

    public static boolean traeStartPlay(Context context) {
        AppMethodBeat.m2504i(66564);
        if (!TXCAudioBasePlayController.nativeIsTracksEmpty() || TXCLiveBGMPlayer.getInstance().isPlaying()) {
            InitTraeEngineLibrary(context);
            nativeTraeStartPlay(context);
            AppMethodBeat.m2505o(66564);
            return true;
        }
        AppMethodBeat.m2505o(66564);
        return false;
    }

    public static boolean traeStopPlay() {
        AppMethodBeat.m2504i(66565);
        if (!TXCAudioBasePlayController.nativeIsTracksEmpty() || TXCLiveBGMPlayer.getInstance().isPlaying()) {
            AppMethodBeat.m2505o(66565);
            return false;
        }
        nativeTraeStopPlay();
        AppMethodBeat.m2505o(66565);
        return true;
    }
}
