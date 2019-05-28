package com.tencent.liteav.audio.impl.Play;

import android.content.Context;
import com.tencent.liteav.audio.C8790b;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.impl.C17769b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.p1169f.C45104b;
import com.tencent.liteav.basic.p1587a.C41678a;
import com.tencent.liteav.basic.p811g.C25648a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ugc.TXRecordCommon;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.liteav.audio.impl.Play.b */
public class C41675b extends TXCAudioBasePlayController {
    /* renamed from: a */
    public static final String f16900a = ("AudioCenter:" + C41675b.class.getSimpleName());
    /* renamed from: b */
    private C41674a f16901b;
    /* renamed from: c */
    private C25648a f16902c;

    static {
        AppMethodBeat.m2504i(66603);
        AppMethodBeat.m2505o(66603);
    }

    public C41675b(Context context) {
        super(context);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.m2504i(66593);
        if (this.mJitterBuffer != 0) {
            nativeDestoryJitterBuffer(this.mJitterBuffer);
            this.mJitterBuffer = 0;
        }
        AppMethodBeat.m2505o(66593);
    }

    /* renamed from: a */
    public static void m73085a(Context context, int i) {
        AppMethodBeat.m2504i(66594);
        C45098d.m82718a().mo72861a(context, i);
        AppMethodBeat.m2505o(66594);
    }

    public long getCacheDuration() {
        AppMethodBeat.m2504i(66595);
        long a;
        if (this.mIsHWAcceleration) {
            a = this.f16901b.mo67216a() + nativeGetCacheDuration(this.mJitterBuffer);
            AppMethodBeat.m2505o(66595);
            return a;
        }
        a = nativeGetCacheDuration(this.mJitterBuffer);
        AppMethodBeat.m2505o(66595);
        return a;
    }

    public int startPlay() {
        AppMethodBeat.m2504i(66596);
        TXCLog.m15677i(f16900a, "start play audio!");
        int i;
        if (this.mIsPlaying) {
            TXCLog.m15676e(f16900a, "repeat start play audio, ignore it!");
            i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_REPEAT_OPTION;
            AppMethodBeat.m2505o(66596);
            return i;
        }
        if (this.mIsHWAcceleration) {
            this.f16901b = new C41674a();
            this.f16901b.mo67218a(new WeakReference(this));
        }
        this.mIsPlaying = true;
        TXCLog.m15677i(f16900a, "finish start play audio!");
        i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
        AppMethodBeat.m2505o(66596);
        return i;
    }

    public int stopPlay() {
        AppMethodBeat.m2504i(66597);
        TXCLog.m15677i(f16900a, "stop play audio!");
        int i;
        if (this.mIsPlaying) {
            super.stopPlay();
            if (this.mJitterBuffer != 0) {
                nativeDestoryJitterBuffer(this.mJitterBuffer);
                this.mJitterBuffer = 0;
            }
            if (TXCAudioBasePlayController.nativeIsTracksEmpty()) {
                C45098d.m82718a().mo72863c();
            }
            if (this.f16901b != null) {
                this.f16901b.mo67219b();
                this.f16901b = null;
            }
            this.f16902c = null;
            TXCLog.m15677i(f16900a, "finish stop play audio!");
            i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
            AppMethodBeat.m2505o(66597);
            return i;
        }
        TXCLog.m15676e(f16900a, "repeat stop play audio, ignore it!");
        i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_REPEAT_OPTION;
        AppMethodBeat.m2505o(66597);
        return i;
    }

    public int playData(C25648a c25648a) {
        AppMethodBeat.m2504i(66598);
        int b;
        if (this.mIsHWAcceleration) {
            b = m73086b(c25648a);
            AppMethodBeat.m2505o(66598);
            return b;
        }
        b = m73084a(c25648a);
        AppMethodBeat.m2505o(66598);
        return b;
    }

    /* renamed from: a */
    private int m73084a(C25648a c25648a) {
        AppMethodBeat.m2504i(66599);
        int i;
        if (c25648a == null) {
            i = TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
            AppMethodBeat.m2505o(66599);
            return i;
        }
        i = TXEAudioDef.TXE_AUDIO_TYPE_INVALID;
        if (C41678a.f16929k == c25648a.f5248d || C41678a.f16930l == c25648a.f5248d) {
            i = TXEAudioDef.TXE_AUDIO_TYPE_AAC;
        } else if (C41678a.f16931m == c25648a.f5248d) {
            i = TXEAudioDef.TXE_AUDIO_TYPE_MP3;
        } else {
            TXCLog.m15676e(f16900a, "soft dec, not support audio type , packet type : " + c25648a.f5248d);
            onPlayError(TXEAudioDef.TXE_AUDIO_PLAY_ERR_AUDIO_TYPE_NOT_SUPPORT, "解码器不支持当前音频格式，包类型:" + c25648a.f5248d);
            i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_AUDIO_TYPE_NOT_SUPPORT;
            AppMethodBeat.m2505o(66599);
            return i;
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
                    TXCLog.m15676e(f16900a, "soft dec, create jitterbuffer failed!!");
                }
                TXCLog.m15676e(f16900a, "soft dec, create jitterbuffer with id " + this.mJitterBuffer);
            }
            if (C41678a.f16929k == c25648a.f5248d) {
                TXCLog.m15677i(f16900a, "soft dec, recv aac seq " + C17769b.m27678a(c25648a.f5250f));
            }
            if (this.mJitterBuffer != 0) {
                nativeAddData(this.mJitterBuffer, c25648a.f5250f, c25648a.f5248d, c25648a.f5249e);
                C25648a c25648a2;
                if (C41678a.f16929k == c25648a.f5248d) {
                    this.f16902c = new C25648a();
                    this.f16902c.f5245a = nativeGetSamplerate(this.mJitterBuffer);
                    this.f16902c.f5246b = nativeGetChannel(this.mJitterBuffer);
                    this.f16902c.f5247c = C8790b.f2446c;
                    this.f16902c.f5248d = C41678a.f16929k;
                    c25648a2 = new C25648a();
                    c25648a2.f5245a = TXRecordCommon.AUDIO_SAMPLERATE_48000;
                    c25648a2.f5246b = 2;
                    c25648a2.f5247c = 16;
                    c25648a2.f5248d = C41678a.f16929k;
                    onPlayAudioInfoChanged(this.f16902c, c25648a2);
                } else if (C41678a.f16931m == c25648a.f5248d && this.f16902c == null) {
                    this.f16902c = new C25648a();
                    this.f16902c.f5245a = nativeGetSamplerate(this.mJitterBuffer);
                    this.f16902c.f5246b = nativeGetChannel(this.mJitterBuffer);
                    this.f16902c.f5247c = C8790b.f2446c;
                    this.f16902c.f5248d = C41678a.f16929k;
                    c25648a2 = new C25648a();
                    c25648a2.f5245a = TXRecordCommon.AUDIO_SAMPLERATE_48000;
                    c25648a2.f5246b = 2;
                    c25648a2.f5247c = 16;
                    c25648a2.f5248d = C41678a.f16929k;
                    onPlayAudioInfoChanged(this.f16902c, c25648a2);
                }
                i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
                AppMethodBeat.m2505o(66599);
                return i;
            }
            onPlayError(TXEAudioDef.TXE_AUDIO_PLAY_ERR_NOT_CREATE_JIT, "jitterbuf 还未创建");
            TXCLog.m15676e(f16900a, "soft dec, jitterbuffer not created yet!!");
            i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_NOT_CREATE_JIT;
            AppMethodBeat.m2505o(66599);
            return i;
        }
        onPlayError(TXEAudioDef.TXE_AUDIO_PLAY_ERR_INVALID_STATE, "播放器还没有启动");
        TXCLog.m15679w(f16900a, "sotf dec, invalid state. player not started yet!");
        i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_INVALID_STATE;
        AppMethodBeat.m2505o(66599);
        return i;
    }

    /* renamed from: b */
    private int m73086b(C25648a c25648a) {
        AppMethodBeat.m2504i(66600);
        int i;
        if (c25648a == null) {
            i = TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
            AppMethodBeat.m2505o(66600);
            return i;
        }
        i = TXEAudioDef.TXE_AUDIO_TYPE_INVALID;
        if (C41678a.f16929k == c25648a.f5248d || C41678a.f16930l == c25648a.f5248d) {
            i = TXEAudioDef.TXE_AUDIO_TYPE_AAC;
        } else if (C41678a.f16931m == c25648a.f5248d) {
            i = TXEAudioDef.TXE_AUDIO_TYPE_MP3;
        } else {
            TXCLog.m15676e(f16900a, "hw dec, not support audio type , packet type : " + c25648a.f5248d);
            onPlayError(TXEAudioDef.TXE_AUDIO_PLAY_ERR_AUDIO_TYPE_NOT_SUPPORT, "解码器不支持当前音频格式，包类型:" + c25648a.f5248d);
            i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_AUDIO_TYPE_NOT_SUPPORT;
            AppMethodBeat.m2505o(66600);
            return i;
        }
        if (this.mIsPlaying) {
            if (this.mJitterBuffer == 0) {
                this.mJitterBuffer = nativeCreateJitterBuffer(true, this);
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
                    TXCLog.m15676e(f16900a, "hw dec, create jitterbuffer failed!!");
                }
                TXCLog.m15676e(f16900a, "hw dec, create jitterbuffer with id " + this.mJitterBuffer);
            }
            if (C41678a.f16929k == c25648a.f5248d) {
                TXCLog.m15677i(f16900a, "soft dec, recv aac seq " + C17769b.m27678a(c25648a.f5250f));
            }
            if (this.f16901b != null) {
                this.f16901b.mo67217a(c25648a);
            }
            i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
            AppMethodBeat.m2505o(66600);
            return i;
        }
        onPlayError(TXEAudioDef.TXE_AUDIO_PLAY_ERR_INVALID_STATE, "播放器还没有启动");
        TXCLog.m15679w(f16900a, "hw dec, invalid state. player not started yet!");
        i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_INVALID_STATE;
        AppMethodBeat.m2505o(66600);
        return i;
    }

    public void onPlayAudioInfoChanged(C25648a c25648a, C25648a c25648a2) {
        AppMethodBeat.m2504i(66601);
        if (this.f16902c == null) {
            this.f16902c = c25648a;
        }
        if (this.mListener != null) {
            this.mListener.onPlayAudioInfoChanged(c25648a, c25648a2);
        }
        if (!TXCAudioBasePlayController.nativeIsTracksEmpty()) {
            C45098d.m82718a().mo72862b();
        }
        AppMethodBeat.m2505o(66601);
    }

    public void onPlayPcmData(byte[] bArr, long j) {
        AppMethodBeat.m2504i(66602);
        super.onPlayPcmData(bArr, j);
        if (this.mJitterBuffer != 0 && this.mIsHWAcceleration) {
            nativeAddData(this.mJitterBuffer, bArr, C41678a.f16932n, j);
        }
        AppMethodBeat.m2505o(66602);
    }
}
