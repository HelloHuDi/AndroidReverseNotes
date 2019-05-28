package com.tencent.liteav.audio.impl.Play;

import android.content.Context;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.impl.TXCTraeJNI;
import com.tencent.liteav.basic.f.b;
import com.tencent.liteav.basic.g.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ugc.TXRecordCommon;

public class c extends TXCAudioBasePlayController implements com.tencent.liteav.audio.c {
    private static final String a = ("AudioCenter:" + c.class.getSimpleName());
    private a b;

    static {
        AppMethodBeat.i(66634);
        AppMethodBeat.o(66634);
    }

    public c(Context context) {
        super(context);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.i(66628);
        if (this.mJitterBuffer != 0) {
            nativeDestoryJitterBuffer(this.mJitterBuffer);
            this.mJitterBuffer = 0;
        }
        AppMethodBeat.o(66628);
    }

    public static void a(Context context, int i) {
        AppMethodBeat.i(66629);
        TXCTraeJNI.setContext(context);
        TXCTraeJNI.nativeSetAudioMode(i);
        AppMethodBeat.o(66629);
    }

    public int startPlay() {
        AppMethodBeat.i(66630);
        TXCLog.i(a, "start play audio!");
        int i;
        if (this.mIsPlaying) {
            TXCLog.e(a, "repeat start play audio, ignore it!");
            i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_REPEAT_OPTION;
            AppMethodBeat.o(66630);
            return i;
        }
        super.startPlay();
        TXCLog.i(a, "finish start play audio!");
        i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
        AppMethodBeat.o(66630);
        return i;
    }

    public int stopPlay() {
        AppMethodBeat.i(66631);
        TXCLog.i(a, "stop play audio!");
        int i;
        if (this.mIsPlaying) {
            super.stopPlay();
            if (this.mJitterBuffer != 0) {
                nativeDestoryJitterBuffer(this.mJitterBuffer);
                this.mJitterBuffer = 0;
            }
            TXCTraeJNI.traeStopPlay();
            this.b = null;
            TXCLog.i(a, "finish stop play audio!");
            i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
            AppMethodBeat.o(66631);
            return i;
        }
        TXCLog.e(a, "repeat stop play audio, ignore it!");
        i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_REPEAT_OPTION;
        AppMethodBeat.o(66631);
        return i;
    }

    public int playData(a aVar) {
        AppMethodBeat.i(66632);
        int i;
        if (aVar == null) {
            i = TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
            AppMethodBeat.o(66632);
            return i;
        } else if (com.tencent.liteav.basic.a.a.k == aVar.d || com.tencent.liteav.basic.a.a.l == aVar.d || com.tencent.liteav.basic.a.a.m == aVar.d) {
            if (com.tencent.liteav.basic.a.a.k == aVar.d) {
                TXCLog.i(a, "soft dec, recv aac seq " + aVar.f);
            }
            if (this.mIsPlaying) {
                if (this.mJitterBuffer == 0) {
                    this.mJitterBuffer = nativeCreateJitterBuffer(false, this);
                    if (this.mJitterBuffer != 0) {
                        nativeSetSmoothMode(this.mJitterBuffer, (long) this.mSmoothMode);
                        nativeSetSmoothAdjust(this.mJitterBuffer, b.a().a("Audio", "SmoothAdjust"));
                        nativeSetCacheTime(this.mJitterBuffer, this.mCacheTime);
                        nativeSetMute(this.mJitterBuffer, this.mIsMute);
                        nativeEnableRealTimePlay(this.mJitterBuffer, this.mIsRealTimePlay);
                        nativeEnableAutoAdjustCache(this.mJitterBuffer, this.mIsAutoAdjustCache);
                        nativeSetAutoAdjustMaxCache(this.mJitterBuffer, this.mAutoAdjustMaxCache);
                        nativeSetAutoAdjustMinCache(this.mJitterBuffer, this.mAutoAdjustMinCache);
                        nativeSetSmoothSpeed(this.mJitterBuffer, b.a().b("Audio", "SmoothSpeed"));
                        nativeSetJitterCycle(this.mJitterBuffer, b.a().a("Audio", "LIVE_JitterCycle"));
                        nativeSetRealtimeJitterCycle(this.mJitterBuffer, b.a().a("Audio", "RTC_JitterCycle"));
                        nativeSetLoadingThreshold(this.mJitterBuffer, b.a().a("Audio", "LoadingThreshold"));
                        nativeSetRTCPlayHungryTimeThreshold(this.mJitterBuffer, (int) b.a().a("Audio", "RtcPlayHungryTimeThreshold"));
                    } else {
                        TXCLog.e(a, "soft dec, create jitterbuffer failed!!");
                    }
                    TXCLog.e(a, "soft dec, create jitterbuffer with id " + this.mJitterBuffer);
                }
                if (this.mJitterBuffer != 0) {
                    nativeAddData(this.mJitterBuffer, aVar.f, aVar.d, aVar.e);
                    a aVar2;
                    if (com.tencent.liteav.basic.a.a.k == aVar.d) {
                        this.b = new a();
                        this.b.a = nativeGetSamplerate(this.mJitterBuffer);
                        this.b.b = nativeGetChannel(this.mJitterBuffer);
                        this.b.c = com.tencent.liteav.audio.b.c;
                        this.b.d = com.tencent.liteav.basic.a.a.k;
                        aVar2 = new a();
                        aVar2.a = TXRecordCommon.AUDIO_SAMPLERATE_48000;
                        aVar2.b = 2;
                        aVar2.c = 16;
                        aVar2.d = com.tencent.liteav.basic.a.a.k;
                        onPlayAudioInfoChanged(this.b, aVar2);
                    } else if (com.tencent.liteav.basic.a.a.m == aVar.d && this.b == null) {
                        this.b = new a();
                        this.b.a = nativeGetSamplerate(this.mJitterBuffer);
                        this.b.b = nativeGetChannel(this.mJitterBuffer);
                        this.b.c = com.tencent.liteav.audio.b.c;
                        this.b.d = com.tencent.liteav.basic.a.a.k;
                        aVar2 = new a();
                        aVar2.a = TXRecordCommon.AUDIO_SAMPLERATE_48000;
                        aVar2.b = 2;
                        aVar2.c = 16;
                        aVar2.d = com.tencent.liteav.basic.a.a.k;
                        onPlayAudioInfoChanged(this.b, aVar2);
                    }
                    i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
                    AppMethodBeat.o(66632);
                    return i;
                }
                onPlayError(TXEAudioDef.TXE_AUDIO_PLAY_ERR_NOT_CREATE_JIT, "jitterbuf 还未创建");
                TXCLog.e(a, "soft dec, jitterbuffer not created yet!!");
                i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_NOT_CREATE_JIT;
                AppMethodBeat.o(66632);
                return i;
            }
            onPlayError(TXEAudioDef.TXE_AUDIO_PLAY_ERR_INVALID_STATE, "播放器还没有启动");
            TXCLog.w(a, "sotf dec, invalid state. player not started yet!");
            i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_INVALID_STATE;
            AppMethodBeat.o(66632);
            return i;
        } else {
            TXCLog.e(a, "soft dec, not support audio type , packet type : " + aVar.d);
            onPlayError(TXEAudioDef.TXE_AUDIO_PLAY_ERR_AUDIO_TYPE_NOT_SUPPORT, "解码器不支持当前音频格式，包类型:" + aVar.d);
            i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_AUDIO_TYPE_NOT_SUPPORT;
            AppMethodBeat.o(66632);
            return i;
        }
    }

    public void onPlayAudioInfoChanged(a aVar, a aVar2) {
        AppMethodBeat.i(66633);
        if (this.b == null) {
            this.b = aVar;
        }
        if (this.mListener != null) {
            this.mListener.onPlayAudioInfoChanged(aVar, aVar2);
        }
        TXCTraeJNI.traeStartPlay(this.mContext);
        AppMethodBeat.o(66633);
    }
}
