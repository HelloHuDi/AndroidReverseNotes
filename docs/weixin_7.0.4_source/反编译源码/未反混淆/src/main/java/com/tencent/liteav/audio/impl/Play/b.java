package com.tencent.liteav.audio.impl.Play;

import android.content.Context;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.basic.g.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ugc.TXRecordCommon;
import java.lang.ref.WeakReference;

public class b extends TXCAudioBasePlayController {
    public static final String a = ("AudioCenter:" + b.class.getSimpleName());
    private a b;
    private a c;

    static {
        AppMethodBeat.i(66603);
        AppMethodBeat.o(66603);
    }

    public b(Context context) {
        super(context);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.i(66593);
        if (this.mJitterBuffer != 0) {
            nativeDestoryJitterBuffer(this.mJitterBuffer);
            this.mJitterBuffer = 0;
        }
        AppMethodBeat.o(66593);
    }

    public static void a(Context context, int i) {
        AppMethodBeat.i(66594);
        d.a().a(context, i);
        AppMethodBeat.o(66594);
    }

    public long getCacheDuration() {
        AppMethodBeat.i(66595);
        long a;
        if (this.mIsHWAcceleration) {
            a = this.b.a() + nativeGetCacheDuration(this.mJitterBuffer);
            AppMethodBeat.o(66595);
            return a;
        }
        a = nativeGetCacheDuration(this.mJitterBuffer);
        AppMethodBeat.o(66595);
        return a;
    }

    public int startPlay() {
        AppMethodBeat.i(66596);
        TXCLog.i(a, "start play audio!");
        int i;
        if (this.mIsPlaying) {
            TXCLog.e(a, "repeat start play audio, ignore it!");
            i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_REPEAT_OPTION;
            AppMethodBeat.o(66596);
            return i;
        }
        if (this.mIsHWAcceleration) {
            this.b = new a();
            this.b.a(new WeakReference(this));
        }
        this.mIsPlaying = true;
        TXCLog.i(a, "finish start play audio!");
        i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
        AppMethodBeat.o(66596);
        return i;
    }

    public int stopPlay() {
        AppMethodBeat.i(66597);
        TXCLog.i(a, "stop play audio!");
        int i;
        if (this.mIsPlaying) {
            super.stopPlay();
            if (this.mJitterBuffer != 0) {
                nativeDestoryJitterBuffer(this.mJitterBuffer);
                this.mJitterBuffer = 0;
            }
            if (TXCAudioBasePlayController.nativeIsTracksEmpty()) {
                d.a().c();
            }
            if (this.b != null) {
                this.b.b();
                this.b = null;
            }
            this.c = null;
            TXCLog.i(a, "finish stop play audio!");
            i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
            AppMethodBeat.o(66597);
            return i;
        }
        TXCLog.e(a, "repeat stop play audio, ignore it!");
        i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_REPEAT_OPTION;
        AppMethodBeat.o(66597);
        return i;
    }

    public int playData(a aVar) {
        AppMethodBeat.i(66598);
        int b;
        if (this.mIsHWAcceleration) {
            b = b(aVar);
            AppMethodBeat.o(66598);
            return b;
        }
        b = a(aVar);
        AppMethodBeat.o(66598);
        return b;
    }

    private int a(a aVar) {
        AppMethodBeat.i(66599);
        int i;
        if (aVar == null) {
            i = TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
            AppMethodBeat.o(66599);
            return i;
        }
        i = TXEAudioDef.TXE_AUDIO_TYPE_INVALID;
        if (com.tencent.liteav.basic.a.a.k == aVar.d || com.tencent.liteav.basic.a.a.l == aVar.d) {
            i = TXEAudioDef.TXE_AUDIO_TYPE_AAC;
        } else if (com.tencent.liteav.basic.a.a.m == aVar.d) {
            i = TXEAudioDef.TXE_AUDIO_TYPE_MP3;
        } else {
            TXCLog.e(a, "soft dec, not support audio type , packet type : " + aVar.d);
            onPlayError(TXEAudioDef.TXE_AUDIO_PLAY_ERR_AUDIO_TYPE_NOT_SUPPORT, "解码器不支持当前音频格式，包类型:" + aVar.d);
            i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_AUDIO_TYPE_NOT_SUPPORT;
            AppMethodBeat.o(66599);
            return i;
        }
        if (this.mIsPlaying) {
            if (this.mJitterBuffer == 0) {
                this.mJitterBuffer = nativeCreateJitterBuffer(false, this);
                if (this.mJitterBuffer != 0) {
                    nativeSetSmoothMode(this.mJitterBuffer, (long) this.mSmoothMode);
                    nativeSetSmoothAdjust(this.mJitterBuffer, com.tencent.liteav.basic.f.b.a().a("Audio", "SmoothAdjust"));
                    nativeSetCacheTime(this.mJitterBuffer, this.mCacheTime);
                    nativeSetMute(this.mJitterBuffer, this.mIsMute);
                    nativeEnableRealTimePlay(this.mJitterBuffer, this.mIsRealTimePlay);
                    nativeEnableAutoAdjustCache(this.mJitterBuffer, this.mIsAutoAdjustCache);
                    nativeSetAutoAdjustMaxCache(this.mJitterBuffer, this.mAutoAdjustMaxCache);
                    nativeSetAutoAdjustMinCache(this.mJitterBuffer, this.mAutoAdjustMinCache);
                    nativeSetSmoothSpeed(this.mJitterBuffer, com.tencent.liteav.basic.f.b.a().b("Audio", "SmoothSpeed"));
                    nativeSetJitterCycle(this.mJitterBuffer, com.tencent.liteav.basic.f.b.a().a("Audio", "LIVE_JitterCycle"));
                    nativeSetRealtimeJitterCycle(this.mJitterBuffer, com.tencent.liteav.basic.f.b.a().a("Audio", "RTC_JitterCycle"));
                    nativeSetLoadingThreshold(this.mJitterBuffer, com.tencent.liteav.basic.f.b.a().a("Audio", "LoadingThreshold"));
                    nativeSetRTCPlayHungryTimeThreshold(this.mJitterBuffer, (int) com.tencent.liteav.basic.f.b.a().a("Audio", "RtcPlayHungryTimeThreshold"));
                } else {
                    TXCLog.e(a, "soft dec, create jitterbuffer failed!!");
                }
                TXCLog.e(a, "soft dec, create jitterbuffer with id " + this.mJitterBuffer);
            }
            if (com.tencent.liteav.basic.a.a.k == aVar.d) {
                TXCLog.i(a, "soft dec, recv aac seq " + com.tencent.liteav.audio.impl.b.a(aVar.f));
            }
            if (this.mJitterBuffer != 0) {
                nativeAddData(this.mJitterBuffer, aVar.f, aVar.d, aVar.e);
                a aVar2;
                if (com.tencent.liteav.basic.a.a.k == aVar.d) {
                    this.c = new a();
                    this.c.a = nativeGetSamplerate(this.mJitterBuffer);
                    this.c.b = nativeGetChannel(this.mJitterBuffer);
                    this.c.c = com.tencent.liteav.audio.b.c;
                    this.c.d = com.tencent.liteav.basic.a.a.k;
                    aVar2 = new a();
                    aVar2.a = TXRecordCommon.AUDIO_SAMPLERATE_48000;
                    aVar2.b = 2;
                    aVar2.c = 16;
                    aVar2.d = com.tencent.liteav.basic.a.a.k;
                    onPlayAudioInfoChanged(this.c, aVar2);
                } else if (com.tencent.liteav.basic.a.a.m == aVar.d && this.c == null) {
                    this.c = new a();
                    this.c.a = nativeGetSamplerate(this.mJitterBuffer);
                    this.c.b = nativeGetChannel(this.mJitterBuffer);
                    this.c.c = com.tencent.liteav.audio.b.c;
                    this.c.d = com.tencent.liteav.basic.a.a.k;
                    aVar2 = new a();
                    aVar2.a = TXRecordCommon.AUDIO_SAMPLERATE_48000;
                    aVar2.b = 2;
                    aVar2.c = 16;
                    aVar2.d = com.tencent.liteav.basic.a.a.k;
                    onPlayAudioInfoChanged(this.c, aVar2);
                }
                i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
                AppMethodBeat.o(66599);
                return i;
            }
            onPlayError(TXEAudioDef.TXE_AUDIO_PLAY_ERR_NOT_CREATE_JIT, "jitterbuf 还未创建");
            TXCLog.e(a, "soft dec, jitterbuffer not created yet!!");
            i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_NOT_CREATE_JIT;
            AppMethodBeat.o(66599);
            return i;
        }
        onPlayError(TXEAudioDef.TXE_AUDIO_PLAY_ERR_INVALID_STATE, "播放器还没有启动");
        TXCLog.w(a, "sotf dec, invalid state. player not started yet!");
        i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_INVALID_STATE;
        AppMethodBeat.o(66599);
        return i;
    }

    private int b(a aVar) {
        AppMethodBeat.i(66600);
        int i;
        if (aVar == null) {
            i = TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
            AppMethodBeat.o(66600);
            return i;
        }
        i = TXEAudioDef.TXE_AUDIO_TYPE_INVALID;
        if (com.tencent.liteav.basic.a.a.k == aVar.d || com.tencent.liteav.basic.a.a.l == aVar.d) {
            i = TXEAudioDef.TXE_AUDIO_TYPE_AAC;
        } else if (com.tencent.liteav.basic.a.a.m == aVar.d) {
            i = TXEAudioDef.TXE_AUDIO_TYPE_MP3;
        } else {
            TXCLog.e(a, "hw dec, not support audio type , packet type : " + aVar.d);
            onPlayError(TXEAudioDef.TXE_AUDIO_PLAY_ERR_AUDIO_TYPE_NOT_SUPPORT, "解码器不支持当前音频格式，包类型:" + aVar.d);
            i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_AUDIO_TYPE_NOT_SUPPORT;
            AppMethodBeat.o(66600);
            return i;
        }
        if (this.mIsPlaying) {
            if (this.mJitterBuffer == 0) {
                this.mJitterBuffer = nativeCreateJitterBuffer(true, this);
                if (this.mJitterBuffer != 0) {
                    nativeSetSmoothMode(this.mJitterBuffer, (long) this.mSmoothMode);
                    nativeSetSmoothAdjust(this.mJitterBuffer, com.tencent.liteav.basic.f.b.a().a("Audio", "SmoothAdjust"));
                    nativeSetCacheTime(this.mJitterBuffer, this.mCacheTime);
                    nativeSetMute(this.mJitterBuffer, this.mIsMute);
                    nativeEnableRealTimePlay(this.mJitterBuffer, this.mIsRealTimePlay);
                    nativeEnableAutoAdjustCache(this.mJitterBuffer, this.mIsAutoAdjustCache);
                    nativeSetAutoAdjustMaxCache(this.mJitterBuffer, this.mAutoAdjustMaxCache);
                    nativeSetAutoAdjustMinCache(this.mJitterBuffer, this.mAutoAdjustMinCache);
                    nativeSetSmoothSpeed(this.mJitterBuffer, com.tencent.liteav.basic.f.b.a().b("Audio", "SmoothSpeed"));
                    nativeSetJitterCycle(this.mJitterBuffer, com.tencent.liteav.basic.f.b.a().a("Audio", "LIVE_JitterCycle"));
                    nativeSetRealtimeJitterCycle(this.mJitterBuffer, com.tencent.liteav.basic.f.b.a().a("Audio", "RTC_JitterCycle"));
                    nativeSetLoadingThreshold(this.mJitterBuffer, com.tencent.liteav.basic.f.b.a().a("Audio", "LoadingThreshold"));
                    nativeSetRTCPlayHungryTimeThreshold(this.mJitterBuffer, (int) com.tencent.liteav.basic.f.b.a().a("Audio", "RtcPlayHungryTimeThreshold"));
                } else {
                    TXCLog.e(a, "hw dec, create jitterbuffer failed!!");
                }
                TXCLog.e(a, "hw dec, create jitterbuffer with id " + this.mJitterBuffer);
            }
            if (com.tencent.liteav.basic.a.a.k == aVar.d) {
                TXCLog.i(a, "soft dec, recv aac seq " + com.tencent.liteav.audio.impl.b.a(aVar.f));
            }
            if (this.b != null) {
                this.b.a(aVar);
            }
            i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
            AppMethodBeat.o(66600);
            return i;
        }
        onPlayError(TXEAudioDef.TXE_AUDIO_PLAY_ERR_INVALID_STATE, "播放器还没有启动");
        TXCLog.w(a, "hw dec, invalid state. player not started yet!");
        i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_INVALID_STATE;
        AppMethodBeat.o(66600);
        return i;
    }

    public void onPlayAudioInfoChanged(a aVar, a aVar2) {
        AppMethodBeat.i(66601);
        if (this.c == null) {
            this.c = aVar;
        }
        if (this.mListener != null) {
            this.mListener.onPlayAudioInfoChanged(aVar, aVar2);
        }
        if (!TXCAudioBasePlayController.nativeIsTracksEmpty()) {
            d.a().b();
        }
        AppMethodBeat.o(66601);
    }

    public void onPlayPcmData(byte[] bArr, long j) {
        AppMethodBeat.i(66602);
        super.onPlayPcmData(bArr, j);
        if (this.mJitterBuffer != 0 && this.mIsHWAcceleration) {
            nativeAddData(this.mJitterBuffer, bArr, com.tencent.liteav.basic.a.a.n, j);
        }
        AppMethodBeat.o(66602);
    }
}
