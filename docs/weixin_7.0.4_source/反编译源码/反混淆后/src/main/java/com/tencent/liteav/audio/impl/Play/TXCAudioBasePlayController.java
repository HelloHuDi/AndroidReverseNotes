package com.tencent.liteav.audio.impl.Play;

import android.content.Context;
import android.os.Environment;
import com.tencent.liteav.audio.C0943a;
import com.tencent.liteav.audio.C8791c;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.p811g.C25648a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TXCAudioBasePlayController implements C8791c {
    private static final String TAG = ("AudioCenter:" + TXCAudioBasePlayController.class.getSimpleName());
    protected float mAutoAdjustMaxCache = C0943a.f1042d;
    protected float mAutoAdjustMinCache = C0943a.f1043e;
    protected float mCacheTime = C0943a.f1040b;
    protected Context mContext;
    protected boolean mIsAutoAdjustCache = C0943a.f1041c;
    protected boolean mIsHWAcceleration = false;
    protected boolean mIsMute = C0943a.f1044f;
    protected volatile boolean mIsPlaying = false;
    protected boolean mIsRealTimePlay = false;
    protected long mJitterBuffer = 0;
    protected C8791c mListener;
    protected int mSmoothMode = 0;

    public static native byte[] nativeGetMixedTracksData(int i);

    public static native boolean nativeIsTracksEmpty();

    public static native void nativeSetTempPath(String str);

    public native void nativeAddData(long j, byte[] bArr, int i, long j2);

    public native long nativeCreateJitterBuffer(boolean z, TXCAudioBasePlayController tXCAudioBasePlayController);

    public native void nativeDestoryJitterBuffer(long j);

    public native void nativeEnableAutoAdjustCache(long j, boolean z);

    public native void nativeEnableRealTimePlay(long j, boolean z);

    public native long nativeGetCacheDuration(long j);

    public native float nativeGetCacheThreshold(long j);

    public native int nativeGetChannel(long j);

    public native long nativeGetCurPts(long j);

    public native TXAudioJitterBufferReportInfo nativeGetLoadingInfo(long j);

    public native long nativeGetNetRecvTS(long j);

    public native int nativeGetRecvJitter(long j);

    public native int nativeGetSamplerate(long j);

    public native void nativeSetAutoAdjustMaxCache(long j, float f);

    public native void nativeSetAutoAdjustMinCache(long j, float f);

    public native void nativeSetCacheTime(long j, float f);

    public native void nativeSetJitterCycle(long j, long j2);

    public native void nativeSetLoadingThreshold(long j, long j2);

    public native void nativeSetMute(long j, boolean z);

    public native void nativeSetRTCPlayHungryTimeThreshold(long j, int i);

    public native void nativeSetRealtimeJitterCycle(long j, long j2);

    public native void nativeSetSmoothAdjust(long j, long j2);

    public native void nativeSetSmoothMode(long j, long j2);

    public native void nativeSetSmoothSpeed(long j, float f);

    static {
        AppMethodBeat.m2504i(66623);
        nativeSetTempPath(Environment.getExternalStorageDirectory().getAbsolutePath());
        AppMethodBeat.m2505o(66623);
    }

    public TXCAudioBasePlayController(Context context) {
        this.mContext = context;
    }

    public static void setAudioMode(Context context, int i) {
        AppMethodBeat.m2504i(66604);
        C41675b.m73085a(context, i);
        C41676c.m73087a(context, i);
        AppMethodBeat.m2505o(66604);
    }

    public synchronized void setListener(C8791c c8791c) {
        this.mListener = c8791c;
    }

    public void setCacheTime(float f) {
        AppMethodBeat.m2504i(66605);
        TXCLog.m15677i(TAG, "set cache time to ".concat(String.valueOf(f)));
        nativeSetCacheTime(this.mJitterBuffer, f);
        this.mCacheTime = f;
        AppMethodBeat.m2505o(66605);
    }

    public void enableAutojustCache(boolean z) {
        AppMethodBeat.m2504i(66606);
        TXCLog.m15677i(TAG, "set auto adjust cache to ".concat(String.valueOf(z)));
        nativeEnableAutoAdjustCache(this.mJitterBuffer, z);
        this.mIsAutoAdjustCache = z;
        AppMethodBeat.m2505o(66606);
    }

    public void setAutoAdjustMaxCache(float f) {
        AppMethodBeat.m2504i(66607);
        TXCLog.m15677i(TAG, "set auto adjust max cache to ".concat(String.valueOf(f)));
        nativeSetAutoAdjustMaxCache(this.mJitterBuffer, f);
        this.mAutoAdjustMaxCache = f;
        AppMethodBeat.m2505o(66607);
    }

    public void setAutoAdjustMinCache(float f) {
        AppMethodBeat.m2504i(66608);
        TXCLog.m15677i(TAG, "set auto adjust min cache to ".concat(String.valueOf(f)));
        nativeSetAutoAdjustMinCache(this.mJitterBuffer, f);
        this.mAutoAdjustMinCache = f;
        AppMethodBeat.m2505o(66608);
    }

    public void enableHWAcceleration(boolean z) {
        AppMethodBeat.m2504i(66609);
        TXCLog.m15677i(TAG, "set hw acceleration to ".concat(String.valueOf(z)));
        this.mIsHWAcceleration = z;
        AppMethodBeat.m2505o(66609);
    }

    public void setSmootheMode(int i) {
        AppMethodBeat.m2504i(66610);
        TXCLog.m15677i(TAG, "set careful mode to ".concat(String.valueOf(i)));
        this.mSmoothMode = i;
        AppMethodBeat.m2505o(66610);
    }

    public long getCacheDuration() {
        AppMethodBeat.m2504i(66611);
        long nativeGetCacheDuration = nativeGetCacheDuration(this.mJitterBuffer);
        AppMethodBeat.m2505o(66611);
        return nativeGetCacheDuration;
    }

    public void enableRealTimePlay(boolean z) {
        AppMethodBeat.m2504i(66612);
        if (z == this.mIsRealTimePlay) {
            AppMethodBeat.m2505o(66612);
            return;
        }
        TXCLog.m15677i(TAG, "set real-time play to ".concat(String.valueOf(z)));
        nativeEnableRealTimePlay(this.mJitterBuffer, z);
        this.mIsRealTimePlay = z;
        AppMethodBeat.m2505o(66612);
    }

    public TXAudioJitterBufferReportInfo getReportInfo() {
        AppMethodBeat.m2504i(66613);
        if (!this.mIsPlaying || this.mJitterBuffer == 0) {
            AppMethodBeat.m2505o(66613);
            return null;
        }
        TXAudioJitterBufferReportInfo nativeGetLoadingInfo = nativeGetLoadingInfo(this.mJitterBuffer);
        AppMethodBeat.m2505o(66613);
        return nativeGetLoadingInfo;
    }

    public long getCurPts() {
        AppMethodBeat.m2504i(66614);
        long nativeGetCurPts = nativeGetCurPts(this.mJitterBuffer);
        AppMethodBeat.m2505o(66614);
        return nativeGetCurPts;
    }

    public int getRecvJitter() {
        AppMethodBeat.m2504i(66615);
        int nativeGetRecvJitter = nativeGetRecvJitter(this.mJitterBuffer);
        AppMethodBeat.m2505o(66615);
        return nativeGetRecvJitter;
    }

    public long getCurRecvTS() {
        AppMethodBeat.m2504i(66616);
        long nativeGetNetRecvTS = nativeGetNetRecvTS(this.mJitterBuffer);
        AppMethodBeat.m2505o(66616);
        return nativeGetNetRecvTS;
    }

    public float getCacheThreshold() {
        AppMethodBeat.m2504i(66617);
        float nativeGetCacheThreshold = nativeGetCacheThreshold(this.mJitterBuffer);
        AppMethodBeat.m2505o(66617);
        return nativeGetCacheThreshold;
    }

    public boolean isPlaying() {
        return this.mIsPlaying;
    }

    public int startPlay() {
        this.mIsPlaying = true;
        return TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
    }

    public int playData(C25648a c25648a) {
        return TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
    }

    public int stopPlay() {
        this.mIsPlaying = false;
        this.mCacheTime = C0943a.f1040b;
        this.mIsAutoAdjustCache = C0943a.f1041c;
        this.mAutoAdjustMaxCache = C0943a.f1042d;
        this.mAutoAdjustMinCache = C0943a.f1043e;
        this.mIsRealTimePlay = false;
        this.mIsHWAcceleration = false;
        this.mIsMute = C0943a.f1044f;
        this.mSmoothMode = 0;
        return TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
    }

    public void setMute(boolean z) {
        AppMethodBeat.m2504i(66618);
        if (z != this.mIsMute) {
            nativeSetMute(this.mJitterBuffer, z);
        }
        TXCLog.m15677i(TAG, "set mute to ".concat(String.valueOf(z)));
        this.mIsMute = z;
        AppMethodBeat.m2505o(66618);
    }

    public synchronized void onPlayPcmData(byte[] bArr, long j) {
        AppMethodBeat.m2504i(66619);
        if (this.mListener != null) {
            this.mListener.onPlayPcmData(bArr, j);
        }
        AppMethodBeat.m2505o(66619);
    }

    public synchronized void onPlayError(int i, String str) {
        AppMethodBeat.m2504i(66620);
        if (this.mListener != null) {
            this.mListener.onPlayError(i, str);
        }
        AppMethodBeat.m2505o(66620);
    }

    public synchronized void onPlayJitterStateNotify(int i) {
        AppMethodBeat.m2504i(66621);
        TXCLog.m15676e(TAG, "onPlayJitterStateNotify  cur state ".concat(String.valueOf(i)));
        if (this.mListener != null) {
            this.mListener.onPlayJitterStateNotify(i);
        }
        AppMethodBeat.m2505o(66621);
    }

    public synchronized void onPlayAudioInfoChanged(C25648a c25648a, C25648a c25648a2) {
        AppMethodBeat.m2504i(66622);
        if (this.mListener != null) {
            this.mListener.onPlayAudioInfoChanged(c25648a, c25648a2);
        }
        AppMethodBeat.m2505o(66622);
    }
}
