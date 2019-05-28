package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.d;
import com.tencent.liteav.basic.a.a;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;

public abstract class c {
    private static final String TAG = ("AudioCenter:" + c.class.getSimpleName());
    protected int mAECType = TXEAudioDef.TXE_AEC_NONE;
    protected int mBits = a.h;
    protected int mChannels = a.f;
    protected Context mContext;
    protected boolean mEnableHWEncoder = false;
    protected boolean mIsCustomRecord = false;
    protected boolean mIsEarphoneOn = false;
    protected boolean mIsMute = false;
    protected int mNSMode = -1;
    protected int mReverbType = TXEAudioDef.TXE_REVERB_TYPE_0;
    protected int mSampleRate = a.e;
    protected int mVoiceEnvironment = -1;
    protected int mVoiceKind = -1;
    protected float mVolume = 1.0f;
    protected WeakReference<d> mWeakRecordListener;

    public abstract boolean isRecording();

    public abstract void sendCustomPCMData(byte[] bArr);

    public abstract int stopRecord();

    public synchronized void setListener(d dVar) {
        TXCLog.i(TAG, "setListener:".concat(String.valueOf(dVar)));
        if (dVar == null) {
            this.mWeakRecordListener = null;
        } else {
            this.mWeakRecordListener = new WeakReference(dVar);
        }
    }

    public synchronized d getListener() {
        d dVar;
        if (this.mWeakRecordListener != null) {
            dVar = (d) this.mWeakRecordListener.get();
        } else {
            dVar = null;
        }
        return dVar;
    }

    public void setSamplerate(int i) {
        TXCLog.i(TAG, "setSampleRate: ".concat(String.valueOf(i)));
        this.mSampleRate = i;
    }

    public void setChannels(int i) {
        TXCLog.i(TAG, "setChannels: ".concat(String.valueOf(i)));
        this.mChannels = i;
    }

    public void setReverbType(int i) {
        TXCLog.i(TAG, "setReverbType: ".concat(String.valueOf(i)));
        this.mReverbType = i;
    }

    public void setAECType(int i) {
        TXCLog.i(TAG, "setAECType: ".concat(String.valueOf(i)));
        this.mAECType = i;
    }

    public void enableHWEncoder(boolean z) {
        TXCLog.i(TAG, "enableHWEncoder: ".concat(String.valueOf(z)));
        this.mEnableHWEncoder = z;
    }

    public void setMute(boolean z) {
        TXCLog.i(TAG, "setMute: ".concat(String.valueOf(z)));
        this.mIsMute = z;
    }

    public void setVolume(float f) {
        if (f <= 0.2f) {
            TXCLog.w(TAG, "setVolume, warning volume too low : ".concat(String.valueOf(f)));
        }
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.mVolume = f;
    }

    public void setEarphoneOn(boolean z) {
        TXCLog.i(TAG, "setEarphoneOn: ".concat(String.valueOf(z)));
        this.mIsEarphoneOn = z;
    }

    public void setNoiseSuppression(int i) {
        TXCLog.i(TAG, "setNoiseSuppression: ".concat(String.valueOf(i)));
        this.mNSMode = i;
    }

    public void setChangerType(int i, int i2) {
        TXCLog.i(TAG, "setChangerType: " + i + " " + i2);
        this.mVoiceKind = i;
        this.mVoiceEnvironment = i2;
    }

    public int startRecord(Context context) {
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
        return 0;
    }

    public void setIsCustomRecord(boolean z) {
        TXCLog.i(TAG, "setIsCustomRecord: ".concat(String.valueOf(z)));
        this.mIsCustomRecord = z;
    }

    public void setReverbParam(int i, float f) {
    }
}
