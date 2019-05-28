package com.tencent.liteav.audio;

import android.content.Context;
import com.tencent.liteav.audio.impl.Record.a;
import com.tencent.liteav.audio.impl.Record.f;
import com.tencent.liteav.audio.impl.Record.h;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class TXCAudioUGCRecorder implements h {
    private static final String TAG = "AudioCenter:TXCAudioUGCRecorder";
    static TXCAudioUGCRecorder instance = new TXCAudioUGCRecorder();
    protected int mAECType = TXEAudioDef.TXE_AEC_NONE;
    private a mBGMRecorder = null;
    protected int mBits = com.tencent.liteav.basic.a.a.h;
    protected int mChannels = com.tencent.liteav.basic.a.a.f;
    protected Context mContext;
    private boolean mCurBGMRecordFlag = false;
    private long mEffectorObj = 0;
    private boolean mEnableBGMRecord = false;
    protected boolean mIsEarphoneOn = false;
    protected boolean mIsMute = false;
    private boolean mIsPause = false;
    private long mLastPTS = 0;
    protected int mReverbType = TXEAudioDef.TXE_REVERB_TYPE_0;
    protected int mSampleRate = com.tencent.liteav.basic.a.a.e;
    private float mSpeedRate = 1.0f;
    private int mVoiceEnvironment = -1;
    private int mVoiceKind = -1;
    private float mVolume = 1.0f;
    private WeakReference<d> mWeakRecordListener;

    private native void nativeClearCache(long j);

    private native long nativeCreateEffector(int i, int i2, int i3);

    private native void nativeDestroyEffector(long j);

    private native void nativeEnableEncoder(long j, boolean z);

    private native long nativeGetPcmCacheLen(long j);

    private native void nativeMixBGM(long j, boolean z);

    private native void nativeProcess(long j, byte[] bArr, int i);

    private native byte[] nativeReadOneFrame(long j);

    private native void nativeSetChangerType(long j, int i, int i2);

    private native void nativeSetReverbType(long j, int i);

    private native void nativeSetSpeedRate(long j, float f);

    private native void nativeSetVolume(long j, float f);

    static {
        AppMethodBeat.i(66500);
        b.e();
        AppMethodBeat.o(66500);
    }

    public static TXCAudioUGCRecorder getInstance() {
        return instance;
    }

    private TXCAudioUGCRecorder() {
    }

    public int startRecord(Context context) {
        AppMethodBeat.i(66475);
        TXCLog.i(TAG, JsApiStartRecordVoice.NAME);
        if (isRecording()) {
            if (this.mEnableBGMRecord == this.mCurBGMRecordFlag) {
                TXCLog.e(TAG, "startRecord failed! recorder is still running!");
                AppMethodBeat.o(66475);
                return -1;
            }
            TXCLog.e(TAG, "recorder is still running. will restart record! bgm record flag = " + this.mEnableBGMRecord);
            stopRecord();
            enableBGMRecord(!this.mCurBGMRecordFlag);
        }
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
        initEffector();
        if (this.mEnableBGMRecord) {
            TXCLog.i(TAG, "录制BGM");
            this.mCurBGMRecordFlag = true;
            this.mBGMRecorder = new a();
            this.mBGMRecorder.a(this);
            setEarphoneOn(true);
            this.mBGMRecorder.a(this.mContext, this.mSampleRate, this.mChannels, this.mBits);
        } else {
            TXCLog.i(TAG, "录制人声");
            this.mCurBGMRecordFlag = false;
            setEarphoneOn(false);
            f.a().a(this);
            f.a().a(this.mContext, this.mSampleRate, this.mChannels, this.mBits, this.mAECType);
        }
        AppMethodBeat.o(66475);
        return 0;
    }

    public int stopRecord() {
        AppMethodBeat.i(66476);
        TXCLog.i(TAG, JsApiStopRecordVoice.NAME);
        if (this.mBGMRecorder != null) {
            this.mBGMRecorder.a();
            this.mBGMRecorder = null;
        }
        f.a().b();
        enableBGMRecord(false);
        this.mIsPause = false;
        uninitEffector();
        AppMethodBeat.o(66476);
        return 0;
    }

    public void pause() {
        AppMethodBeat.i(66477);
        TXCLog.i(TAG, "pause");
        this.mIsPause = true;
        if (!this.mEnableBGMRecord && isRecording()) {
            TXCLog.i(TAG, "停止系统录音");
            f.a().b();
        }
        AppMethodBeat.o(66477);
    }

    public void resume() {
        AppMethodBeat.i(66478);
        TXCLog.i(TAG, "resume");
        this.mIsPause = false;
        if (!(this.mEnableBGMRecord || isRecording())) {
            TXCLog.i(TAG, "恢复系统录音");
            this.mCurBGMRecordFlag = false;
            setEarphoneOn(false);
            f.a().a(this);
            f.a().a(this.mContext, this.mSampleRate, this.mChannels, this.mBits, this.mAECType);
        }
        AppMethodBeat.o(66478);
    }

    public synchronized void setListener(d dVar) {
        AppMethodBeat.i(66479);
        if (dVar == null) {
            this.mWeakRecordListener = null;
            AppMethodBeat.o(66479);
        } else {
            this.mWeakRecordListener = new WeakReference(dVar);
            AppMethodBeat.o(66479);
        }
    }

    public synchronized d getListener() {
        d dVar;
        AppMethodBeat.i(66480);
        if (this.mWeakRecordListener != null) {
            dVar = (d) this.mWeakRecordListener.get();
            AppMethodBeat.o(66480);
        } else {
            dVar = null;
            AppMethodBeat.o(66480);
        }
        return dVar;
    }

    public void setChannels(int i) {
        AppMethodBeat.i(66481);
        TXCLog.i(TAG, "setChannels: ".concat(String.valueOf(i)));
        this.mChannels = i;
        AppMethodBeat.o(66481);
    }

    public int getChannels() {
        return this.mChannels;
    }

    public void setSampleRate(int i) {
        AppMethodBeat.i(66482);
        TXCLog.i(TAG, "setSampleRate: ".concat(String.valueOf(i)));
        this.mSampleRate = i;
        AppMethodBeat.o(66482);
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }

    public synchronized void setReverbType(int i) {
        AppMethodBeat.i(66483);
        TXCLog.i(TAG, "setReverbType: ".concat(String.valueOf(i)));
        this.mReverbType = i;
        if (this.mEffectorObj > 0) {
            nativeSetReverbType(this.mEffectorObj, i);
        }
        AppMethodBeat.o(66483);
    }

    public void setAECType(int i, Context context) {
        AppMethodBeat.i(66484);
        TXCLog.i(TAG, "setAECType: ".concat(String.valueOf(i)));
        this.mAECType = i;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
        AppMethodBeat.o(66484);
    }

    public void setMute(boolean z) {
        AppMethodBeat.i(66485);
        TXCLog.i(TAG, "setMute: ".concat(String.valueOf(z)));
        this.mIsMute = z;
        AppMethodBeat.o(66485);
    }

    public void enableBGMRecord(boolean z) {
        AppMethodBeat.i(66486);
        TXCLog.i(TAG, "enableBGMRecord: ".concat(String.valueOf(z)));
        this.mEnableBGMRecord = z;
        AppMethodBeat.o(66486);
    }

    public synchronized void setEarphoneOn(boolean z) {
        AppMethodBeat.i(66487);
        TXCLog.i(TAG, "setEarphoneOn: ".concat(String.valueOf(z)));
        this.mIsEarphoneOn = z;
        if (this.mEffectorObj > 0) {
            boolean z2 = false;
            if (z || this.mAECType == TXEAudioDef.TXE_AEC_SYSTEM) {
                z2 = true;
            }
            nativeMixBGM(this.mEffectorObj, z2);
        }
        AppMethodBeat.o(66487);
    }

    public boolean isRecording() {
        AppMethodBeat.i(66488);
        boolean b;
        if (this.mBGMRecorder != null) {
            b = this.mBGMRecorder.b();
            AppMethodBeat.o(66488);
            return b;
        }
        b = f.a().c();
        AppMethodBeat.o(66488);
        return b;
    }

    public void sendCustomPCMData(byte[] bArr) {
    }

    public synchronized long getPcmCacheLen() {
        long j = 0;
        synchronized (this) {
            AppMethodBeat.i(66489);
            if (this.mEffectorObj <= 0) {
                AppMethodBeat.o(66489);
            } else {
                j = nativeGetPcmCacheLen(this.mEffectorObj);
                AppMethodBeat.o(66489);
            }
        }
        return j;
    }

    public synchronized void setVolume(float f) {
        AppMethodBeat.i(66490);
        TXCLog.i(TAG, "setVolume: ".concat(String.valueOf(f)));
        this.mVolume = f;
        if (this.mEffectorObj <= 0) {
            AppMethodBeat.o(66490);
        } else {
            nativeSetVolume(this.mEffectorObj, f);
            AppMethodBeat.o(66490);
        }
    }

    public synchronized void setSpeedRate(float f) {
        AppMethodBeat.i(66491);
        TXCLog.i(TAG, "setSpeedRate: ".concat(String.valueOf(f)));
        this.mSpeedRate = f;
        if (this.mEffectorObj <= 0) {
            AppMethodBeat.o(66491);
        } else {
            nativeSetSpeedRate(this.mEffectorObj, this.mSpeedRate);
            AppMethodBeat.o(66491);
        }
    }

    public synchronized void clearCache() {
        AppMethodBeat.i(66492);
        TXCLog.i(TAG, "clearCache");
        if (this.mEffectorObj <= 0) {
            AppMethodBeat.o(66492);
        } else {
            nativeClearCache(this.mEffectorObj);
            AppMethodBeat.o(66492);
        }
    }

    public void onAudioRecordStart() {
        AppMethodBeat.i(66493);
        TXCLog.i(TAG, "sys audio record start");
        AppMethodBeat.o(66493);
    }

    public void onAudioRecordStop() {
        AppMethodBeat.i(66494);
        TXCLog.i(TAG, "sys audio record stop");
        f.a().a(null);
        AppMethodBeat.o(66494);
    }

    public void onAudioRecordError(int i, String str) {
        AppMethodBeat.i(66495);
        TXCLog.e(TAG, "sys audio record error: " + i + ", " + str);
        f.a().a(null);
        d listener = getListener();
        if (listener != null) {
            listener.a(i, str);
        }
        AppMethodBeat.o(66495);
    }

    public void onAudioRecordPCM(byte[] bArr, int i, long j) {
        AppMethodBeat.i(66496);
        if (this.mIsPause) {
            AppMethodBeat.o(66496);
        } else if (this.mEffectorObj > 0) {
            if (this.mIsMute) {
                Arrays.fill(bArr, (byte) 0);
            }
            if (this.mLastPTS >= j) {
                j = this.mLastPTS + 2;
            }
            synchronized (this) {
                try {
                    nativeProcess(this.mEffectorObj, bArr, i);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(66496);
                }
            }
            long j2 = j;
            while (true) {
                byte[] nativeReadOneFrame;
                synchronized (this) {
                    try {
                        nativeReadOneFrame = nativeReadOneFrame(this.mEffectorObj);
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(66496);
                        }
                    }
                }
                if (nativeReadOneFrame != null) {
                    this.mLastPTS = j2;
                    d listener = getListener();
                    if (listener != null) {
                        listener.b(nativeReadOneFrame, j2, this.mSampleRate, this.mChannels, this.mBits);
                    }
                }
                synchronized (this) {
                    try {
                        j2 += (long) ((1024000.0f / ((float) this.mSampleRate)) * this.mSpeedRate);
                    } catch (Throwable th2) {
                        while (true) {
                            AppMethodBeat.o(66496);
                        }
                    }
                }
                if (nativeReadOneFrame == null) {
                    break;
                }
            }
        } else {
            TXCLog.e(TAG, "effectorObj is null");
            AppMethodBeat.o(66496);
        }
    }

    private synchronized void initEffector() {
        AppMethodBeat.i(66497);
        uninitEffector();
        this.mEffectorObj = nativeCreateEffector(this.mSampleRate, this.mChannels, this.mBits);
        boolean z = false;
        if (this.mIsEarphoneOn || this.mAECType == TXEAudioDef.TXE_AEC_SYSTEM) {
            z = true;
        }
        nativeSetReverbType(this.mEffectorObj, this.mReverbType);
        nativeSetChangerType(this.mEffectorObj, this.mVoiceKind, this.mVoiceEnvironment);
        nativeMixBGM(this.mEffectorObj, z);
        nativeSetVolume(this.mEffectorObj, this.mVolume);
        nativeSetSpeedRate(this.mEffectorObj, this.mSpeedRate);
        nativeEnableEncoder(this.mEffectorObj, true);
        this.mLastPTS = 0;
        AppMethodBeat.o(66497);
    }

    private synchronized void uninitEffector() {
        AppMethodBeat.i(66498);
        if (this.mEffectorObj > 0) {
            nativeDestroyEffector(this.mEffectorObj);
            this.mEffectorObj = 0;
        }
        AppMethodBeat.o(66498);
    }

    public synchronized void setChangerType(int i, int i2) {
        AppMethodBeat.i(66499);
        TXCLog.i(TAG, "setChangerType: " + i + " " + i2);
        this.mVoiceKind = i;
        this.mVoiceEnvironment = i2;
        if (this.mEffectorObj <= 0) {
            AppMethodBeat.o(66499);
        } else {
            nativeSetChangerType(this.mEffectorObj, i, i2);
            AppMethodBeat.o(66499);
        }
    }
}
