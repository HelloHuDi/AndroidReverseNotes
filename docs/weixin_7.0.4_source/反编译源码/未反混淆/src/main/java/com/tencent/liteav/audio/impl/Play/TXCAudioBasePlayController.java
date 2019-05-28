package com.tencent.liteav.audio.impl.Play;

import android.content.Context;
import android.os.Environment;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.a;
import com.tencent.liteav.audio.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TXCAudioBasePlayController implements c {
    private static final String TAG = ("AudioCenter:" + TXCAudioBasePlayController.class.getSimpleName());
    protected float mAutoAdjustMaxCache = a.d;
    protected float mAutoAdjustMinCache = a.e;
    protected float mCacheTime = a.b;
    protected Context mContext;
    protected boolean mIsAutoAdjustCache = a.c;
    protected boolean mIsHWAcceleration = false;
    protected boolean mIsMute = a.f;
    protected volatile boolean mIsPlaying = false;
    protected boolean mIsRealTimePlay = false;
    protected long mJitterBuffer = 0;
    protected c mListener;
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
        AppMethodBeat.i(66623);
        nativeSetTempPath(Environment.getExternalStorageDirectory().getAbsolutePath());
        AppMethodBeat.o(66623);
    }

    public TXCAudioBasePlayController(Context context) {
        this.mContext = context;
    }

    public static void setAudioMode(Context context, int i) {
        AppMethodBeat.i(66604);
        b.a(context, i);
        c.a(context, i);
        AppMethodBeat.o(66604);
    }

    public synchronized void setListener(c cVar) {
        this.mListener = cVar;
    }

    public void setCacheTime(float f) {
        AppMethodBeat.i(66605);
        TXCLog.i(TAG, "set cache time to ".concat(String.valueOf(f)));
        nativeSetCacheTime(this.mJitterBuffer, f);
        this.mCacheTime = f;
        AppMethodBeat.o(66605);
    }

    public void enableAutojustCache(boolean z) {
        AppMethodBeat.i(66606);
        TXCLog.i(TAG, "set auto adjust cache to ".concat(String.valueOf(z)));
        nativeEnableAutoAdjustCache(this.mJitterBuffer, z);
        this.mIsAutoAdjustCache = z;
        AppMethodBeat.o(66606);
    }

    public void setAutoAdjustMaxCache(float f) {
        AppMethodBeat.i(66607);
        TXCLog.i(TAG, "set auto adjust max cache to ".concat(String.valueOf(f)));
        nativeSetAutoAdjustMaxCache(this.mJitterBuffer, f);
        this.mAutoAdjustMaxCache = f;
        AppMethodBeat.o(66607);
    }

    public void setAutoAdjustMinCache(float f) {
        AppMethodBeat.i(66608);
        TXCLog.i(TAG, "set auto adjust min cache to ".concat(String.valueOf(f)));
        nativeSetAutoAdjustMinCache(this.mJitterBuffer, f);
        this.mAutoAdjustMinCache = f;
        AppMethodBeat.o(66608);
    }

    public void enableHWAcceleration(boolean z) {
        AppMethodBeat.i(66609);
        TXCLog.i(TAG, "set hw acceleration to ".concat(String.valueOf(z)));
        this.mIsHWAcceleration = z;
        AppMethodBeat.o(66609);
    }

    public void setSmootheMode(int i) {
        AppMethodBeat.i(66610);
        TXCLog.i(TAG, "set careful mode to ".concat(String.valueOf(i)));
        this.mSmoothMode = i;
        AppMethodBeat.o(66610);
    }

    public long getCacheDuration() {
        AppMethodBeat.i(66611);
        long nativeGetCacheDuration = nativeGetCacheDuration(this.mJitterBuffer);
        AppMethodBeat.o(66611);
        return nativeGetCacheDuration;
    }

    public void enableRealTimePlay(boolean z) {
        AppMethodBeat.i(66612);
        if (z == this.mIsRealTimePlay) {
            AppMethodBeat.o(66612);
            return;
        }
        TXCLog.i(TAG, "set real-time play to ".concat(String.valueOf(z)));
        nativeEnableRealTimePlay(this.mJitterBuffer, z);
        this.mIsRealTimePlay = z;
        AppMethodBeat.o(66612);
    }

    public TXAudioJitterBufferReportInfo getReportInfo() {
        AppMethodBeat.i(66613);
        if (!this.mIsPlaying || this.mJitterBuffer == 0) {
            AppMethodBeat.o(66613);
            return null;
        }
        TXAudioJitterBufferReportInfo nativeGetLoadingInfo = nativeGetLoadingInfo(this.mJitterBuffer);
        AppMethodBeat.o(66613);
        return nativeGetLoadingInfo;
    }

    public long getCurPts() {
        AppMethodBeat.i(66614);
        long nativeGetCurPts = nativeGetCurPts(this.mJitterBuffer);
        AppMethodBeat.o(66614);
        return nativeGetCurPts;
    }

    public int getRecvJitter() {
        AppMethodBeat.i(66615);
        int nativeGetRecvJitter = nativeGetRecvJitter(this.mJitterBuffer);
        AppMethodBeat.o(66615);
        return nativeGetRecvJitter;
    }

    public long getCurRecvTS() {
        AppMethodBeat.i(66616);
        long nativeGetNetRecvTS = nativeGetNetRecvTS(this.mJitterBuffer);
        AppMethodBeat.o(66616);
        return nativeGetNetRecvTS;
    }

    public float getCacheThreshold() {
        AppMethodBeat.i(66617);
        float nativeGetCacheThreshold = nativeGetCacheThreshold(this.mJitterBuffer);
        AppMethodBeat.o(66617);
        return nativeGetCacheThreshold;
    }

    public boolean isPlaying() {
        return this.mIsPlaying;
    }

    public int startPlay() {
        this.mIsPlaying = true;
        return TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
    }

    public int playData(com.tencent.liteav.basic.g.a aVar) {
        return TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
    }

    public int stopPlay() {
        this.mIsPlaying = false;
        this.mCacheTime = a.b;
        this.mIsAutoAdjustCache = a.c;
        this.mAutoAdjustMaxCache = a.d;
        this.mAutoAdjustMinCache = a.e;
        this.mIsRealTimePlay = false;
        this.mIsHWAcceleration = false;
        this.mIsMute = a.f;
        this.mSmoothMode = 0;
        return TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
    }

    public void setMute(boolean z) {
        AppMethodBeat.i(66618);
        if (z != this.mIsMute) {
            nativeSetMute(this.mJitterBuffer, z);
        }
        TXCLog.i(TAG, "set mute to ".concat(String.valueOf(z)));
        this.mIsMute = z;
        AppMethodBeat.o(66618);
    }

    public synchronized void onPlayPcmData(byte[] bArr, long j) {
        AppMethodBeat.i(66619);
        if (this.mListener != null) {
            this.mListener.onPlayPcmData(bArr, j);
        }
        AppMethodBeat.o(66619);
    }

    public synchronized void onPlayError(int i, String str) {
        AppMethodBeat.i(66620);
        if (this.mListener != null) {
            this.mListener.onPlayError(i, str);
        }
        AppMethodBeat.o(66620);
    }

    public synchronized void onPlayJitterStateNotify(int i) {
        AppMethodBeat.i(66621);
        TXCLog.e(TAG, "onPlayJitterStateNotify  cur state ".concat(String.valueOf(i)));
        if (this.mListener != null) {
            this.mListener.onPlayJitterStateNotify(i);
        }
        AppMethodBeat.o(66621);
    }

    public synchronized void onPlayAudioInfoChanged(com.tencent.liteav.basic.g.a aVar, com.tencent.liteav.basic.g.a aVar2) {
        AppMethodBeat.i(66622);
        if (this.mListener != null) {
            this.mListener.onPlayAudioInfoChanged(aVar, aVar2);
        }
        AppMethodBeat.o(66622);
    }
}
