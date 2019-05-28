package com.tencent.liteav.audio.impl.Play;

import android.content.Context;
import com.tencent.liteav.audio.C8790b;
import com.tencent.liteav.audio.C8791c;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.impl.TXCTraeJNI;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.p1169f.C45104b;
import com.tencent.liteav.basic.p1587a.C41678a;
import com.tencent.liteav.basic.p811g.C25648a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ugc.TXRecordCommon;

/* renamed from: com.tencent.liteav.audio.impl.Play.c */
public class C41676c extends TXCAudioBasePlayController implements C8791c {
    /* renamed from: a */
    private static final String f16903a = ("AudioCenter:" + C41676c.class.getSimpleName());
    /* renamed from: b */
    private C25648a f16904b;

    static {
        AppMethodBeat.m2504i(66634);
        AppMethodBeat.m2505o(66634);
    }

    public C41676c(Context context) {
        super(context);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.m2504i(66628);
        if (this.mJitterBuffer != 0) {
            nativeDestoryJitterBuffer(this.mJitterBuffer);
            this.mJitterBuffer = 0;
        }
        AppMethodBeat.m2505o(66628);
    }

    /* renamed from: a */
    public static void m73087a(Context context, int i) {
        AppMethodBeat.m2504i(66629);
        TXCTraeJNI.setContext(context);
        TXCTraeJNI.nativeSetAudioMode(i);
        AppMethodBeat.m2505o(66629);
    }

    public int startPlay() {
        AppMethodBeat.m2504i(66630);
        TXCLog.m15677i(f16903a, "start play audio!");
        int i;
        if (this.mIsPlaying) {
            TXCLog.m15676e(f16903a, "repeat start play audio, ignore it!");
            i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_REPEAT_OPTION;
            AppMethodBeat.m2505o(66630);
            return i;
        }
        super.startPlay();
        TXCLog.m15677i(f16903a, "finish start play audio!");
        i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
        AppMethodBeat.m2505o(66630);
        return i;
    }

    public int stopPlay() {
        AppMethodBeat.m2504i(66631);
        TXCLog.m15677i(f16903a, "stop play audio!");
        int i;
        if (this.mIsPlaying) {
            super.stopPlay();
            if (this.mJitterBuffer != 0) {
                nativeDestoryJitterBuffer(this.mJitterBuffer);
                this.mJitterBuffer = 0;
            }
            TXCTraeJNI.traeStopPlay();
            this.f16904b = null;
            TXCLog.m15677i(f16903a, "finish stop play audio!");
            i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
            AppMethodBeat.m2505o(66631);
            return i;
        }
        TXCLog.m15676e(f16903a, "repeat stop play audio, ignore it!");
        i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_REPEAT_OPTION;
        AppMethodBeat.m2505o(66631);
        return i;
    }

    public int playData(C25648a c25648a) {
        AppMethodBeat.m2504i(66632);
        int i;
        if (c25648a == null) {
            i = TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
            AppMethodBeat.m2505o(66632);
            return i;
        } else if (C41678a.f16929k == c25648a.f5248d || C41678a.f16930l == c25648a.f5248d || C41678a.f16931m == c25648a.f5248d) {
            if (C41678a.f16929k == c25648a.f5248d) {
                TXCLog.m15677i(f16903a, "soft dec, recv aac seq " + c25648a.f5250f);
            }
            if (this.mIsPlaying) {
                if (this.mJitterBuffer == 0) {
                    this.mJitterBuffer = nativeCreateJitterBuffer(false, this);
                    if (this.mJitterBuffer != 0) {
                        nativeSetSmoothMode(this.mJitterBuffer, (long) this.mSmoothMode);
                        nativeSetSmoothAdjust(this.mJitterBuffer, C45104b.m82752a().mo72874a("Audio", "SmoothAdjust"));
                        nativeSetCacheTime(this.mJitterBuffer, this.mCacheTime);
                        nativeSetMute(this.mJitterBuffer, this.mIsMute);
                        nativeEnableRealTimePlay(this.mJitterBuffer, this.mIsRealTimePlay);
                        nativeEnableAutoAdjustCache(this.mJitterBuffer, this.mIsAutoAdjustCache);
                        nativeSetAutoAdjustMaxCache(this.mJitterBuffer, this.mAutoAdjustMaxCache);
                        nativeSetAutoAdjustMinCache(this.mJitterBuffer, this.mAutoAdjustMinCache);
                        nativeSetSmoothSpeed(this.mJitterBuffer, C45104b.m82752a().mo72878b("Audio", "SmoothSpeed"));
                        nativeSetJitterCycle(this.mJitterBuffer, C45104b.m82752a().mo72874a("Audio", "LIVE_JitterCycle"));
                        nativeSetRealtimeJitterCycle(this.mJitterBuffer, C45104b.m82752a().mo72874a("Audio", "RTC_JitterCycle"));
                        nativeSetLoadingThreshold(this.mJitterBuffer, C45104b.m82752a().mo72874a("Audio", "LoadingThreshold"));
                        nativeSetRTCPlayHungryTimeThreshold(this.mJitterBuffer, (int) C45104b.m82752a().mo72874a("Audio", "RtcPlayHungryTimeThreshold"));
                    } else {
                        TXCLog.m15676e(f16903a, "soft dec, create jitterbuffer failed!!");
                    }
                    TXCLog.m15676e(f16903a, "soft dec, create jitterbuffer with id " + this.mJitterBuffer);
                }
                if (this.mJitterBuffer != 0) {
                    nativeAddData(this.mJitterBuffer, c25648a.f5250f, c25648a.f5248d, c25648a.f5249e);
                    C25648a c25648a2;
                    if (C41678a.f16929k == c25648a.f5248d) {
                        this.f16904b = new C25648a();
                        this.f16904b.f5245a = nativeGetSamplerate(this.mJitterBuffer);
                        this.f16904b.f5246b = nativeGetChannel(this.mJitterBuffer);
                        this.f16904b.f5247c = C8790b.f2446c;
                        this.f16904b.f5248d = C41678a.f16929k;
                        c25648a2 = new C25648a();
                        c25648a2.f5245a = TXRecordCommon.AUDIO_SAMPLERATE_48000;
                        c25648a2.f5246b = 2;
                        c25648a2.f5247c = 16;
                        c25648a2.f5248d = C41678a.f16929k;
                        onPlayAudioInfoChanged(this.f16904b, c25648a2);
                    } else if (C41678a.f16931m == c25648a.f5248d && this.f16904b == null) {
                        this.f16904b = new C25648a();
                        this.f16904b.f5245a = nativeGetSamplerate(this.mJitterBuffer);
                        this.f16904b.f5246b = nativeGetChannel(this.mJitterBuffer);
                        this.f16904b.f5247c = C8790b.f2446c;
                        this.f16904b.f5248d = C41678a.f16929k;
                        c25648a2 = new C25648a();
                        c25648a2.f5245a = TXRecordCommon.AUDIO_SAMPLERATE_48000;
                        c25648a2.f5246b = 2;
                        c25648a2.f5247c = 16;
                        c25648a2.f5248d = C41678a.f16929k;
                        onPlayAudioInfoChanged(this.f16904b, c25648a2);
                    }
                    i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
                    AppMethodBeat.m2505o(66632);
                    return i;
                }
                onPlayError(TXEAudioDef.TXE_AUDIO_PLAY_ERR_NOT_CREATE_JIT, "jitterbuf 还未创建");
                TXCLog.m15676e(f16903a, "soft dec, jitterbuffer not created yet!!");
                i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_NOT_CREATE_JIT;
                AppMethodBeat.m2505o(66632);
                return i;
            }
            onPlayError(TXEAudioDef.TXE_AUDIO_PLAY_ERR_INVALID_STATE, "播放器还没有启动");
            TXCLog.m15679w(f16903a, "sotf dec, invalid state. player not started yet!");
            i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_INVALID_STATE;
            AppMethodBeat.m2505o(66632);
            return i;
        } else {
            TXCLog.m15676e(f16903a, "soft dec, not support audio type , packet type : " + c25648a.f5248d);
            onPlayError(TXEAudioDef.TXE_AUDIO_PLAY_ERR_AUDIO_TYPE_NOT_SUPPORT, "解码器不支持当前音频格式，包类型:" + c25648a.f5248d);
            i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_AUDIO_TYPE_NOT_SUPPORT;
            AppMethodBeat.m2505o(66632);
            return i;
        }
    }

    public void onPlayAudioInfoChanged(C25648a c25648a, C25648a c25648a2) {
        AppMethodBeat.m2504i(66633);
        if (this.f16904b == null) {
            this.f16904b = c25648a;
        }
        if (this.mListener != null) {
            this.mListener.onPlayAudioInfoChanged(c25648a, c25648a2);
        }
        TXCTraeJNI.traeStartPlay(this.mContext);
        AppMethodBeat.m2505o(66633);
    }
}
