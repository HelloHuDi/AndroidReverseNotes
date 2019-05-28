package com.tencent.p177mm.plugin.appbrand.jsapi.video;

import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.d */
public interface C45630d {

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.d$f */
    public interface C10555f {
        /* renamed from: es */
        void mo22049es(boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.d$d */
    public interface C19512d {
        /* renamed from: dd */
        void mo34676dd(int i, int i2);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.d$e */
    public interface C27129e {
        void onVisibilityChanged(boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.d$g */
    public enum C27130g {
        DEFAULT,
        FILL,
        CONTAIN,
        COVER;

        static {
            AppMethodBeat.m2505o(126548);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.d$a */
    public interface C38399a {
        void aDF();

        void aEZ();

        boolean aFA();

        void aFD();

        void aFE();

        boolean aFF();

        void aFG();

        void aFH();

        boolean aFI();

        void aFN();

        void aFO();

        boolean aFR();

        void aFy();

        void hide();

        void onDestroy();

        void seek(int i);

        void setDanmakuBtnOnClickListener(C10555f c10555f);

        void setDanmakuBtnOpen(boolean z);

        void setExitFullScreenBtnOnClickListener(OnClickListener onClickListener);

        void setFullScreenBtnOnClickListener(OnClickListener onClickListener);

        void setIplaySeekCallback(C42594c c42594c);

        void setMuteBtnOnClickListener(OnClickListener onClickListener);

        void setMuteBtnState(boolean z);

        void setOnPlayButtonClickListener(OnClickListener onClickListener);

        void setOnUpdateProgressLenListener(C19512d c19512d);

        void setOnVisibilityChangedListener(C27129e c27129e);

        void setPlayBtnInCenterPosition(boolean z);

        void setShowControlProgress(boolean z);

        void setShowDanmakuBtn(boolean z);

        void setShowFullScreenBtn(boolean z);

        void setShowMuteBtn(boolean z);

        void setShowPlayBtn(boolean z);

        void setShowProgress(boolean z);

        void setStatePorter(C38400h c38400h);

        void setTitle(String str);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.d$h */
    public interface C38400h {
        int aFg();

        int aFh();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.d$b */
    public interface C42593b {
        /* renamed from: H */
        void mo34677H(String str, int i, int i2);

        void aFq();

        void aFr();

        void aFs();

        void aFt();

        void aFu();

        void aFv();

        /* renamed from: de */
        void mo34684de(int i, int i2);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.d$c */
    public interface C42594c {
        void aFw();

        /* renamed from: oA */
        void mo22044oA(int i);
    }

    void aEX();

    void akV();

    void akW();

    /* renamed from: as */
    boolean mo61579as(float f);

    /* renamed from: c */
    void mo61580c(boolean z, String str, int i);

    /* renamed from: e */
    boolean mo61581e(double d, boolean z);

    int getCacheTimeSec();

    int getCurrPosMs();

    int getCurrPosSec();

    int getVideoDurationSec();

    boolean isLive();

    boolean isPlaying();

    boolean pause();

    /* renamed from: s */
    boolean mo61590s(double d);

    void setControlBar(C38399a c38399a);

    void setIMMVideoViewCallback(C42593b c42593b);

    void setMute(boolean z);

    void setScaleType(C27130g c27130g);

    void setVideoSource(int i);

    void start();

    void stop();
}
