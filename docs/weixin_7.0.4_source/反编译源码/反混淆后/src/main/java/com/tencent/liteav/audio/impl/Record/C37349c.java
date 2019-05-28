package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import com.tencent.liteav.audio.C8792d;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.p1587a.C41678a;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.liteav.audio.impl.Record.c */
public abstract class C37349c {
    private static final String TAG = ("AudioCenter:" + C37349c.class.getSimpleName());
    protected int mAECType = TXEAudioDef.TXE_AEC_NONE;
    protected int mBits = C41678a.f16926h;
    protected int mChannels = C41678a.f16924f;
    protected Context mContext;
    protected boolean mEnableHWEncoder = false;
    protected boolean mIsCustomRecord = false;
    protected boolean mIsEarphoneOn = false;
    protected boolean mIsMute = false;
    protected int mNSMode = -1;
    protected int mReverbType = TXEAudioDef.TXE_REVERB_TYPE_0;
    protected int mSampleRate = C41678a.f16923e;
    protected int mVoiceEnvironment = -1;
    protected int mVoiceKind = -1;
    protected float mVolume = 1.0f;
    protected WeakReference<C8792d> mWeakRecordListener;

    public abstract boolean isRecording();

    public abstract void sendCustomPCMData(byte[] bArr);

    public abstract int stopRecord();

    public synchronized void setListener(C8792d c8792d) {
        TXCLog.m15677i(TAG, "setListener:".concat(String.valueOf(c8792d)));
        if (c8792d == null) {
            this.mWeakRecordListener = null;
        } else {
            this.mWeakRecordListener = new WeakReference(c8792d);
        }
    }

    public synchronized C8792d getListener() {
        C8792d c8792d;
        if (this.mWeakRecordListener != null) {
            c8792d = (C8792d) this.mWeakRecordListener.get();
        } else {
            c8792d = null;
        }
        return c8792d;
    }

    public void setSamplerate(int i) {
        TXCLog.m15677i(TAG, "setSampleRate: ".concat(String.valueOf(i)));
        this.mSampleRate = i;
    }

    public void setChannels(int i) {
        TXCLog.m15677i(TAG, "setChannels: ".concat(String.valueOf(i)));
        this.mChannels = i;
    }

    public void setReverbType(int i) {
        TXCLog.m15677i(TAG, "setReverbType: ".concat(String.valueOf(i)));
        this.mReverbType = i;
    }

    public void setAECType(int i) {
        TXCLog.m15677i(TAG, "setAECType: ".concat(String.valueOf(i)));
        this.mAECType = i;
    }

    public void enableHWEncoder(boolean z) {
        TXCLog.m15677i(TAG, "enableHWEncoder: ".concat(String.valueOf(z)));
        this.mEnableHWEncoder = z;
    }

    public void setMute(boolean z) {
        TXCLog.m15677i(TAG, "setMute: ".concat(String.valueOf(z)));
        this.mIsMute = z;
    }

    public void setVolume(float f) {
        if (f <= 0.2f) {
            TXCLog.m15679w(TAG, "setVolume, warning volume too low : ".concat(String.valueOf(f)));
        }
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.mVolume = f;
    }

    public void setEarphoneOn(boolean z) {
        TXCLog.m15677i(TAG, "setEarphoneOn: ".concat(String.valueOf(z)));
        this.mIsEarphoneOn = z;
    }

    public void setNoiseSuppression(int i) {
        TXCLog.m15677i(TAG, "setNoiseSuppression: ".concat(String.valueOf(i)));
        this.mNSMode = i;
    }

    public void setChangerType(int i, int i2) {
        TXCLog.m15677i(TAG, "setChangerType: " + i + " " + i2);
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
        TXCLog.m15677i(TAG, "setIsCustomRecord: ".concat(String.valueOf(z)));
        this.mIsCustomRecord = z;
    }

    public void setReverbParam(int i, float f) {
    }
}
