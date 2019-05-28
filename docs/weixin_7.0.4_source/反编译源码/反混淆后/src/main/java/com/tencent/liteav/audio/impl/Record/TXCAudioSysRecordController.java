package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import android.os.Build;
import com.tencent.liteav.audio.C8792d;
import com.tencent.liteav.audio.TXCLiveBGMPlayer;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.impl.C32136a;
import com.tencent.liteav.audio.impl.C37350d;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.p1169f.C45104b;
import com.tencent.liteav.basic.p1587a.C41678a;
import com.tencent.liteav.basic.util.C17778b;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.ugc.TXRecordCommon;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class TXCAudioSysRecordController extends C37349c implements C0945h, C37350d {
    private static final String TAG = ("AudioCenter:" + TXCAudioSysRecordController.class.getSimpleName());
    private byte[] mBuf = null;
    private C45099d mCustomRecord = null;
    private long mEffectorObj = 0;
    private C41677e mHWEcoder = null;
    private long mLastPTS = 0;
    private boolean mNeedMix = false;
    private int mPosition = 0;
    private int mRecordSampleRate = C41678a.f16923e;
    private long mSoftEncObj = 0;

    private native void nativeAddEffect(long j, byte[] bArr);

    private native void nativeAddEffectAndSoftEnc(long j, long j2, byte[] bArr);

    private native long nativeCreateEffector(int i, int i2, int i3);

    private native long nativeCreateSoftEncoder(int i, int i2, int i3);

    private native void nativeDestorySoftEncoder(long j);

    private native void nativeDestroyEffector(long j);

    private native void nativeEnableEncoder(long j, boolean z);

    private native void nativeMixBGM(long j, boolean z);

    private native byte[] nativeReadOneEncFrame();

    private native byte[] nativeReadOneFrame(long j, int i);

    private native void nativeSetChangerType(long j, int i, int i2);

    private native void nativeSetInputInfo(long j, int i, int i2, int i3);

    private native void nativeSetNoiseSuppression(long j, int i);

    private native void nativeSetReverbParam(long j, int i, float f);

    private native void nativeSetReverbType(long j, int i);

    private native void nativeSetVolume(long j, float f);

    static {
        AppMethodBeat.m2504i(66704);
        C17778b.m27756e();
        AppMethodBeat.m2505o(66704);
    }

    public TXCAudioSysRecordController() {
        AppMethodBeat.m2504i(66682);
        C32136a.m52261a().mo52718a((C37350d) this);
        AppMethodBeat.m2505o(66682);
    }

    public int startRecord(Context context) {
        AppMethodBeat.m2504i(66683);
        TXCLog.m15677i(TAG, JsApiStartRecordVoice.NAME);
        super.startRecord(context);
        if (this.mIsCustomRecord) {
            setNoiseSuppression(-1);
            this.mRecordSampleRate = this.mSampleRate;
            this.mCustomRecord = new C45099d();
            this.mCustomRecord.mo52713a(this);
            this.mCustomRecord.mo52712a(this.mContext, this.mRecordSampleRate, this.mChannels, this.mBits);
        } else {
            if (this.mAECType == TXEAudioDef.TXE_AEC_SYSTEM) {
                if (this.mSampleRate > C45104b.m82752a().mo72885h()) {
                    this.mRecordSampleRate = C45104b.m82752a().mo72886i();
                } else {
                    this.mRecordSampleRate = C45104b.m82752a().mo72885h();
                }
                if (this.mRecordSampleRate == 0) {
                    this.mRecordSampleRate = TXRecordCommon.AUDIO_SAMPLERATE_16000;
                }
            } else {
                this.mRecordSampleRate = this.mSampleRate;
                if (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
                    String property = getProperty("ro.board.platform");
                    String property2 = getProperty("ro.build.version.emui");
                    if ((property.equalsIgnoreCase("hi3650") && property2.equalsIgnoreCase("EmotionUI_8.0.0")) || ((property.equalsIgnoreCase("kirin970") && property2.equalsIgnoreCase("EmotionUI_8.1.0")) || (property.equalsIgnoreCase("kirin970") && property2.equalsIgnoreCase("EmotionUI_8.2.0")))) {
                        TXCLog.m15676e(TAG, "Force record sample rate 16000, HUAWEI-" + property + "-" + property2);
                        this.mRecordSampleRate = TXRecordCommon.AUDIO_SAMPLERATE_16000;
                    }
                }
            }
            C45100f.m82736a().mo72870a(this);
            C45100f.m82736a().mo72869a(this.mContext, this.mRecordSampleRate, this.mChannels, this.mBits, this.mAECType);
        }
        if (!(this.mWeakRecordListener == null || this.mWeakRecordListener.get() == null)) {
            ((C8792d) this.mWeakRecordListener.get()).mo19855a(TXEAudioDef.TXE_AUDIO_NOTIFY_AUDIO_INFO, (this.mAECType == TXEAudioDef.TXE_AEC_SYSTEM ? "SYSTEM-AEC," : "NO-AEC,") + "采样率(" + this.mRecordSampleRate + "|" + this.mSampleRate + "),声道数" + this.mChannels);
        }
        AppMethodBeat.m2505o(66683);
        return 0;
    }

    private String getProperty(String str) {
        String str2;
        AppMethodBeat.m2504i(66684);
        String str3 = "unknown";
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            str2 = (String) cls.getMethod("get", new Class[]{String.class, String.class}).invoke(cls, new Object[]{str, str3});
        } catch (Exception e) {
            str2 = str3;
        }
        AppMethodBeat.m2505o(66684);
        return str2;
    }

    public int stopRecord() {
        AppMethodBeat.m2504i(66685);
        TXCLog.m15677i(TAG, JsApiStopRecordVoice.NAME);
        if (this.mCustomRecord != null) {
            this.mCustomRecord.mo72866c();
            this.mCustomRecord = null;
        }
        C45100f.m82736a().mo72871b();
        C32136a.m52261a().mo52719b((C37350d) this);
        this.mNeedMix = false;
        AppMethodBeat.m2505o(66685);
        return 0;
    }

    public void sendCustomPCMData(byte[] bArr) {
        AppMethodBeat.m2504i(66686);
        if (this.mCustomRecord != null) {
            this.mCustomRecord.mo72865a(bArr);
        }
        AppMethodBeat.m2505o(66686);
    }

    public boolean isRecording() {
        AppMethodBeat.m2504i(66687);
        boolean d;
        if (this.mCustomRecord != null) {
            d = this.mCustomRecord.mo72867d();
            AppMethodBeat.m2505o(66687);
            return d;
        }
        d = C45100f.m82736a().mo72872c();
        AppMethodBeat.m2505o(66687);
        return d;
    }

    public synchronized void setEarphoneOn(boolean z) {
        AppMethodBeat.m2504i(66688);
        super.setEarphoneOn(z);
        if (this.mEffectorObj > 0) {
            if (z || this.mAECType == TXEAudioDef.TXE_AEC_SYSTEM) {
                this.mNeedMix = true;
            } else {
                this.mNeedMix = false;
            }
            nativeMixBGM(this.mEffectorObj, this.mNeedMix);
        }
        AppMethodBeat.m2505o(66688);
    }

    public synchronized void setReverbType(int i) {
        AppMethodBeat.m2504i(66689);
        super.setReverbType(i);
        if (this.mEffectorObj > 0) {
            nativeSetReverbType(this.mEffectorObj, i);
        }
        AppMethodBeat.m2505o(66689);
    }

    public synchronized void setNoiseSuppression(int i) {
        AppMethodBeat.m2504i(66690);
        super.setNoiseSuppression(i);
        if (this.mEffectorObj > 0) {
            nativeSetNoiseSuppression(this.mEffectorObj, i);
        }
        AppMethodBeat.m2505o(66690);
    }

    public void setVolume(float f) {
        AppMethodBeat.m2504i(66691);
        super.setVolume(f);
        if (this.mEffectorObj != 0) {
            nativeSetVolume(this.mEffectorObj, f);
        }
        AppMethodBeat.m2505o(66691);
    }

    public synchronized void setReverbParam(int i, float f) {
        AppMethodBeat.m2504i(66692);
        super.setReverbParam(i, f);
        if (this.mEffectorObj != 0) {
            nativeSetReverbParam(this.mEffectorObj, i, f);
        }
        AppMethodBeat.m2505o(66692);
    }

    public void setChangerType(int i, int i2) {
        AppMethodBeat.m2504i(66693);
        super.setChangerType(i, i2);
        if (this.mEffectorObj != 0) {
            nativeSetChangerType(this.mEffectorObj, i, i2);
        }
        AppMethodBeat.m2505o(66693);
    }

    public synchronized void onAudioRecordStart() {
        AppMethodBeat.m2504i(66694);
        TXCLog.m15677i(TAG, "sys audio record start");
        uninitEffectAndEnc();
        initEffectAndEnc();
        AppMethodBeat.m2505o(66694);
    }

    public synchronized void onAudioRecordStop() {
        AppMethodBeat.m2504i(66695);
        TXCLog.m15677i(TAG, "sys audio record stop");
        C45100f.m82736a().mo72870a(null);
        uninitEffectAndEnc();
        AppMethodBeat.m2505o(66695);
    }

    public synchronized void onAudioRecordError(int i, String str) {
        AppMethodBeat.m2504i(66696);
        TXCLog.m15676e(TAG, "sys audio record error: " + i + ", " + str);
        C45100f.m82736a().mo72870a(null);
        uninitEffectAndEnc();
        if (this.mWeakRecordListener != null) {
            C8792d c8792d = (C8792d) this.mWeakRecordListener.get();
            if (c8792d != null) {
                c8792d.mo19855a(i, str);
            }
        }
        AppMethodBeat.m2505o(66696);
    }

    public synchronized void onAudioRecordPCM(byte[] bArr, int i, long j) {
        AppMethodBeat.m2504i(66697);
        if (this.mEffectorObj > 0) {
            long j2;
            if (this.mIsMute) {
                Arrays.fill(bArr, (byte) 0);
            }
            if (this.mLastPTS >= j) {
                j2 = this.mLastPTS + 2;
            } else {
                j2 = j;
            }
            long j3;
            byte[] nativeReadOneFrame;
            C8792d listener;
            if (this.mHWEcoder != null) {
                nativeAddEffect(this.mEffectorObj, bArr);
                j3 = j2;
                do {
                    nativeReadOneFrame = nativeReadOneFrame(this.mEffectorObj, ((this.mChannels * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) * this.mBits) / 8);
                    if (nativeReadOneFrame != null) {
                        this.mLastPTS = j3;
                        if (this.mHWEcoder != null) {
                            doHWEncode(nativeReadOneFrame, j3);
                        } else {
                            listener = getListener();
                            if (listener != null) {
                                listener.mo19858b(nativeReadOneFrame, j3, this.mSampleRate, this.mChannels, this.mBits);
                            }
                        }
                    }
                    j3 += (long) (1024000 / this.mSampleRate);
                } while (nativeReadOneFrame != null);
                AppMethodBeat.m2505o(66697);
            } else {
                nativeAddEffectAndSoftEnc(this.mEffectorObj, this.mSoftEncObj, bArr);
                j3 = j2;
                while (true) {
                    nativeReadOneFrame = nativeReadOneEncFrame();
                    if (nativeReadOneFrame == null) {
                        break;
                    }
                    this.mLastPTS = j3;
                    listener = getListener();
                    if (listener != null) {
                        listener.mo19858b(nativeReadOneFrame, j3, this.mSampleRate, this.mChannels, this.mBits);
                    }
                    j3 += (long) (1024000 / this.mSampleRate);
                }
                AppMethodBeat.m2505o(66697);
            }
        } else {
            TXCLog.m15676e(TAG, "effectorObj is null");
            AppMethodBeat.m2505o(66697);
        }
    }

    private void initEffectAndEnc() {
        boolean z;
        AppMethodBeat.m2504i(66698);
        this.mEffectorObj = nativeCreateEffector(this.mSampleRate, this.mChannels, this.mBits);
        if (this.mSampleRate != this.mRecordSampleRate) {
            nativeSetInputInfo(this.mEffectorObj, this.mRecordSampleRate, this.mChannels, this.mBits);
        }
        if (this.mIsEarphoneOn || this.mAECType == TXEAudioDef.TXE_AEC_SYSTEM) {
            z = true;
        } else {
            z = false;
        }
        nativeSetReverbType(this.mEffectorObj, this.mReverbType);
        nativeMixBGM(this.mEffectorObj, z);
        nativeSetNoiseSuppression(this.mEffectorObj, this.mNSMode);
        nativeSetChangerType(this.mEffectorObj, this.mVoiceKind, this.mVoiceEnvironment);
        if (this.mEnableHWEncoder) {
            this.mHWEcoder = new C41677e();
            C8792d listener = getListener();
            this.mHWEcoder.mo67224a(TXEAudioDef.TXE_AUDIO_TYPE_AAC, this.mSampleRate, this.mChannels, this.mBits, listener != null ? new WeakReference(listener) : null);
            this.mBuf = new byte[(((this.mChannels * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) * this.mBits) / 8)];
            this.mPosition = 0;
        } else {
            this.mSoftEncObj = nativeCreateSoftEncoder(this.mSampleRate, this.mChannels, this.mBits);
        }
        this.mLastPTS = 0;
        TXCLog.m15677i(TAG, "初始化直播录制:录制模式 = " + (this.mCustomRecord == null ? "麦克风录制" : "用户自定义录制") + ", 录制采样率 = " + this.mRecordSampleRate + ", 输出采样率 = " + this.mSampleRate + ", 是否混音 = " + z + ", 混响模式 = " + this.mReverbType + ", 是否启动硬编码 = " + this.mEnableHWEncoder + ", 噪声抑制mode = " + this.mNSMode);
        AppMethodBeat.m2505o(66698);
    }

    private void uninitEffectAndEnc() {
        AppMethodBeat.m2504i(66699);
        if (this.mEffectorObj != 0) {
            nativeDestroyEffector(this.mEffectorObj);
            this.mEffectorObj = 0;
        }
        if (this.mSoftEncObj != 0) {
            nativeDestorySoftEncoder(this.mSoftEncObj);
            this.mSoftEncObj = 0;
        }
        if (this.mHWEcoder != null) {
            this.mHWEcoder.mo67223a();
            this.mHWEcoder = null;
        }
        AppMethodBeat.m2505o(66699);
    }

    private void doHWEncode(byte[] bArr, long j) {
        AppMethodBeat.m2504i(66700);
        if (bArr == null || bArr.length == 0 || this.mBuf == null || this.mHWEcoder == null) {
            TXCLog.m15676e(TAG, "doHWEncode failed! data = " + bArr + ", buf = " + this.mBuf + ", encoder = " + this.mHWEcoder);
            AppMethodBeat.m2505o(66700);
            return;
        }
        int length = this.mBuf.length - this.mPosition;
        if (length > bArr.length) {
            length = bArr.length;
        }
        System.arraycopy(bArr, 0, this.mBuf, this.mPosition, length);
        this.mPosition = length + this.mPosition;
        if (this.mPosition == this.mBuf.length) {
            this.mPosition = 0;
            this.mHWEcoder.mo67225a(this.mBuf, j);
        }
        AppMethodBeat.m2505o(66700);
    }

    private void onRecordRawPcmData(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(66701);
        C8792d listener = getListener();
        if (listener != null) {
            long timeTick = TXCTimeUtil.getTimeTick();
            int i3 = this.mBits;
            boolean z = TXCLiveBGMPlayer.getInstance().isRunning() && !this.mNeedMix;
            listener.mo19857a(bArr, timeTick, i, i2, i3, z);
        }
        AppMethodBeat.m2505o(66701);
    }

    private void onRecordPcmData(byte[] bArr) {
        AppMethodBeat.m2504i(66702);
        C8792d listener = getListener();
        if (listener != null) {
            listener.mo19856a(bArr, TXCTimeUtil.getTimeTick(), this.mSampleRate, this.mChannels, this.mBits);
        }
        AppMethodBeat.m2505o(66702);
    }

    public void OnHeadsetState(boolean z) {
        AppMethodBeat.m2504i(66703);
        setEarphoneOn(z);
        AppMethodBeat.m2505o(66703);
    }
}
