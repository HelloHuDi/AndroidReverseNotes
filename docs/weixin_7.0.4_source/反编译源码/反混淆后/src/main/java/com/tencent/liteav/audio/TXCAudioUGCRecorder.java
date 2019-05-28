package com.tencent.liteav.audio;

import android.content.Context;
import com.tencent.liteav.audio.impl.Record.C0945h;
import com.tencent.liteav.audio.impl.Record.C45100f;
import com.tencent.liteav.audio.impl.Record.C8793a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.p1587a.C41678a;
import com.tencent.liteav.basic.util.C17778b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class TXCAudioUGCRecorder implements C0945h {
    private static final String TAG = "AudioCenter:TXCAudioUGCRecorder";
    static TXCAudioUGCRecorder instance = new TXCAudioUGCRecorder();
    protected int mAECType = TXEAudioDef.TXE_AEC_NONE;
    private C8793a mBGMRecorder = null;
    protected int mBits = C41678a.f16926h;
    protected int mChannels = C41678a.f16924f;
    protected Context mContext;
    private boolean mCurBGMRecordFlag = false;
    private long mEffectorObj = 0;
    private boolean mEnableBGMRecord = false;
    protected boolean mIsEarphoneOn = false;
    protected boolean mIsMute = false;
    private boolean mIsPause = false;
    private long mLastPTS = 0;
    protected int mReverbType = TXEAudioDef.TXE_REVERB_TYPE_0;
    protected int mSampleRate = C41678a.f16923e;
    private float mSpeedRate = 1.0f;
    private int mVoiceEnvironment = -1;
    private int mVoiceKind = -1;
    private float mVolume = 1.0f;
    private WeakReference<C8792d> mWeakRecordListener;

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
        AppMethodBeat.m2504i(66500);
        C17778b.m27756e();
        AppMethodBeat.m2505o(66500);
    }

    public static TXCAudioUGCRecorder getInstance() {
        return instance;
    }

    private TXCAudioUGCRecorder() {
    }

    public int startRecord(Context context) {
        AppMethodBeat.m2504i(66475);
        TXCLog.m15677i(TAG, JsApiStartRecordVoice.NAME);
        if (isRecording()) {
            if (this.mEnableBGMRecord == this.mCurBGMRecordFlag) {
                TXCLog.m15676e(TAG, "startRecord failed! recorder is still running!");
                AppMethodBeat.m2505o(66475);
                return -1;
            }
            TXCLog.m15676e(TAG, "recorder is still running. will restart record! bgm record flag = " + this.mEnableBGMRecord);
            stopRecord();
            enableBGMRecord(!this.mCurBGMRecordFlag);
        }
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
        initEffector();
        if (this.mEnableBGMRecord) {
            TXCLog.m15677i(TAG, "录制BGM");
            this.mCurBGMRecordFlag = true;
            this.mBGMRecorder = new C8793a();
            this.mBGMRecorder.mo19861a(this);
            setEarphoneOn(true);
            this.mBGMRecorder.mo19860a(this.mContext, this.mSampleRate, this.mChannels, this.mBits);
        } else {
            TXCLog.m15677i(TAG, "录制人声");
            this.mCurBGMRecordFlag = false;
            setEarphoneOn(false);
            C45100f.m82736a().mo72870a(this);
            C45100f.m82736a().mo72869a(this.mContext, this.mSampleRate, this.mChannels, this.mBits, this.mAECType);
        }
        AppMethodBeat.m2505o(66475);
        return 0;
    }

    public int stopRecord() {
        AppMethodBeat.m2504i(66476);
        TXCLog.m15677i(TAG, JsApiStopRecordVoice.NAME);
        if (this.mBGMRecorder != null) {
            this.mBGMRecorder.mo19859a();
            this.mBGMRecorder = null;
        }
        C45100f.m82736a().mo72871b();
        enableBGMRecord(false);
        this.mIsPause = false;
        uninitEffector();
        AppMethodBeat.m2505o(66476);
        return 0;
    }

    public void pause() {
        AppMethodBeat.m2504i(66477);
        TXCLog.m15677i(TAG, "pause");
        this.mIsPause = true;
        if (!this.mEnableBGMRecord && isRecording()) {
            TXCLog.m15677i(TAG, "停止系统录音");
            C45100f.m82736a().mo72871b();
        }
        AppMethodBeat.m2505o(66477);
    }

    public void resume() {
        AppMethodBeat.m2504i(66478);
        TXCLog.m15677i(TAG, "resume");
        this.mIsPause = false;
        if (!(this.mEnableBGMRecord || isRecording())) {
            TXCLog.m15677i(TAG, "恢复系统录音");
            this.mCurBGMRecordFlag = false;
            setEarphoneOn(false);
            C45100f.m82736a().mo72870a(this);
            C45100f.m82736a().mo72869a(this.mContext, this.mSampleRate, this.mChannels, this.mBits, this.mAECType);
        }
        AppMethodBeat.m2505o(66478);
    }

    public synchronized void setListener(C8792d c8792d) {
        AppMethodBeat.m2504i(66479);
        if (c8792d == null) {
            this.mWeakRecordListener = null;
            AppMethodBeat.m2505o(66479);
        } else {
            this.mWeakRecordListener = new WeakReference(c8792d);
            AppMethodBeat.m2505o(66479);
        }
    }

    public synchronized C8792d getListener() {
        C8792d c8792d;
        AppMethodBeat.m2504i(66480);
        if (this.mWeakRecordListener != null) {
            c8792d = (C8792d) this.mWeakRecordListener.get();
            AppMethodBeat.m2505o(66480);
        } else {
            c8792d = null;
            AppMethodBeat.m2505o(66480);
        }
        return c8792d;
    }

    public void setChannels(int i) {
        AppMethodBeat.m2504i(66481);
        TXCLog.m15677i(TAG, "setChannels: ".concat(String.valueOf(i)));
        this.mChannels = i;
        AppMethodBeat.m2505o(66481);
    }

    public int getChannels() {
        return this.mChannels;
    }

    public void setSampleRate(int i) {
        AppMethodBeat.m2504i(66482);
        TXCLog.m15677i(TAG, "setSampleRate: ".concat(String.valueOf(i)));
        this.mSampleRate = i;
        AppMethodBeat.m2505o(66482);
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }

    public synchronized void setReverbType(int i) {
        AppMethodBeat.m2504i(66483);
        TXCLog.m15677i(TAG, "setReverbType: ".concat(String.valueOf(i)));
        this.mReverbType = i;
        if (this.mEffectorObj > 0) {
            nativeSetReverbType(this.mEffectorObj, i);
        }
        AppMethodBeat.m2505o(66483);
    }

    public void setAECType(int i, Context context) {
        AppMethodBeat.m2504i(66484);
        TXCLog.m15677i(TAG, "setAECType: ".concat(String.valueOf(i)));
        this.mAECType = i;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
        AppMethodBeat.m2505o(66484);
    }

    public void setMute(boolean z) {
        AppMethodBeat.m2504i(66485);
        TXCLog.m15677i(TAG, "setMute: ".concat(String.valueOf(z)));
        this.mIsMute = z;
        AppMethodBeat.m2505o(66485);
    }

    public void enableBGMRecord(boolean z) {
        AppMethodBeat.m2504i(66486);
        TXCLog.m15677i(TAG, "enableBGMRecord: ".concat(String.valueOf(z)));
        this.mEnableBGMRecord = z;
        AppMethodBeat.m2505o(66486);
    }

    public synchronized void setEarphoneOn(boolean z) {
        AppMethodBeat.m2504i(66487);
        TXCLog.m15677i(TAG, "setEarphoneOn: ".concat(String.valueOf(z)));
        this.mIsEarphoneOn = z;
        if (this.mEffectorObj > 0) {
            boolean z2 = false;
            if (z || this.mAECType == TXEAudioDef.TXE_AEC_SYSTEM) {
                z2 = true;
            }
            nativeMixBGM(this.mEffectorObj, z2);
        }
        AppMethodBeat.m2505o(66487);
    }

    public boolean isRecording() {
        AppMethodBeat.m2504i(66488);
        boolean b;
        if (this.mBGMRecorder != null) {
            b = this.mBGMRecorder.mo19862b();
            AppMethodBeat.m2505o(66488);
            return b;
        }
        b = C45100f.m82736a().mo72872c();
        AppMethodBeat.m2505o(66488);
        return b;
    }

    public void sendCustomPCMData(byte[] bArr) {
    }

    public synchronized long getPcmCacheLen() {
        long j = 0;
        synchronized (this) {
            AppMethodBeat.m2504i(66489);
            if (this.mEffectorObj <= 0) {
                AppMethodBeat.m2505o(66489);
            } else {
                j = nativeGetPcmCacheLen(this.mEffectorObj);
                AppMethodBeat.m2505o(66489);
            }
        }
        return j;
    }

    public synchronized void setVolume(float f) {
        AppMethodBeat.m2504i(66490);
        TXCLog.m15677i(TAG, "setVolume: ".concat(String.valueOf(f)));
        this.mVolume = f;
        if (this.mEffectorObj <= 0) {
            AppMethodBeat.m2505o(66490);
        } else {
            nativeSetVolume(this.mEffectorObj, f);
            AppMethodBeat.m2505o(66490);
        }
    }

    public synchronized void setSpeedRate(float f) {
        AppMethodBeat.m2504i(66491);
        TXCLog.m15677i(TAG, "setSpeedRate: ".concat(String.valueOf(f)));
        this.mSpeedRate = f;
        if (this.mEffectorObj <= 0) {
            AppMethodBeat.m2505o(66491);
        } else {
            nativeSetSpeedRate(this.mEffectorObj, this.mSpeedRate);
            AppMethodBeat.m2505o(66491);
        }
    }

    public synchronized void clearCache() {
        AppMethodBeat.m2504i(66492);
        TXCLog.m15677i(TAG, "clearCache");
        if (this.mEffectorObj <= 0) {
            AppMethodBeat.m2505o(66492);
        } else {
            nativeClearCache(this.mEffectorObj);
            AppMethodBeat.m2505o(66492);
        }
    }

    public void onAudioRecordStart() {
        AppMethodBeat.m2504i(66493);
        TXCLog.m15677i(TAG, "sys audio record start");
        AppMethodBeat.m2505o(66493);
    }

    public void onAudioRecordStop() {
        AppMethodBeat.m2504i(66494);
        TXCLog.m15677i(TAG, "sys audio record stop");
        C45100f.m82736a().mo72870a(null);
        AppMethodBeat.m2505o(66494);
    }

    public void onAudioRecordError(int i, String str) {
        AppMethodBeat.m2504i(66495);
        TXCLog.m15676e(TAG, "sys audio record error: " + i + ", " + str);
        C45100f.m82736a().mo72870a(null);
        C8792d listener = getListener();
        if (listener != null) {
            listener.mo19855a(i, str);
        }
        AppMethodBeat.m2505o(66495);
    }

    public void onAudioRecordPCM(byte[] bArr, int i, long j) {
        AppMethodBeat.m2504i(66496);
        if (this.mIsPause) {
            AppMethodBeat.m2505o(66496);
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
                    AppMethodBeat.m2505o(66496);
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
                            AppMethodBeat.m2505o(66496);
                        }
                    }
                }
                if (nativeReadOneFrame != null) {
                    this.mLastPTS = j2;
                    C8792d listener = getListener();
                    if (listener != null) {
                        listener.mo19858b(nativeReadOneFrame, j2, this.mSampleRate, this.mChannels, this.mBits);
                    }
                }
                synchronized (this) {
                    try {
                        j2 += (long) ((1024000.0f / ((float) this.mSampleRate)) * this.mSpeedRate);
                    } catch (Throwable th2) {
                        while (true) {
                            AppMethodBeat.m2505o(66496);
                        }
                    }
                }
                if (nativeReadOneFrame == null) {
                    break;
                }
            }
        } else {
            TXCLog.m15676e(TAG, "effectorObj is null");
            AppMethodBeat.m2505o(66496);
        }
    }

    private synchronized void initEffector() {
        AppMethodBeat.m2504i(66497);
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
        AppMethodBeat.m2505o(66497);
    }

    private synchronized void uninitEffector() {
        AppMethodBeat.m2504i(66498);
        if (this.mEffectorObj > 0) {
            nativeDestroyEffector(this.mEffectorObj);
            this.mEffectorObj = 0;
        }
        AppMethodBeat.m2505o(66498);
    }

    public synchronized void setChangerType(int i, int i2) {
        AppMethodBeat.m2504i(66499);
        TXCLog.m15677i(TAG, "setChangerType: " + i + " " + i2);
        this.mVoiceKind = i;
        this.mVoiceEnvironment = i2;
        if (this.mEffectorObj <= 0) {
            AppMethodBeat.m2505o(66499);
        } else {
            nativeSetChangerType(this.mEffectorObj, i, i2);
            AppMethodBeat.m2505o(66499);
        }
    }
}
