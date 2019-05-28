package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface d {

    public interface f {
        void es(boolean z);
    }

    public interface d {
        void dd(int i, int i2);
    }

    public interface e {
        void onVisibilityChanged(boolean z);
    }

    public enum g {
        DEFAULT,
        FILL,
        CONTAIN,
        COVER;

        static {
            AppMethodBeat.o(126548);
        }
    }

    public interface a {
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

        void setDanmakuBtnOnClickListener(f fVar);

        void setDanmakuBtnOpen(boolean z);

        void setExitFullScreenBtnOnClickListener(OnClickListener onClickListener);

        void setFullScreenBtnOnClickListener(OnClickListener onClickListener);

        void setIplaySeekCallback(c cVar);

        void setMuteBtnOnClickListener(OnClickListener onClickListener);

        void setMuteBtnState(boolean z);

        void setOnPlayButtonClickListener(OnClickListener onClickListener);

        void setOnUpdateProgressLenListener(d dVar);

        void setOnVisibilityChangedListener(e eVar);

        void setPlayBtnInCenterPosition(boolean z);

        void setShowControlProgress(boolean z);

        void setShowDanmakuBtn(boolean z);

        void setShowFullScreenBtn(boolean z);

        void setShowMuteBtn(boolean z);

        void setShowPlayBtn(boolean z);

        void setShowProgress(boolean z);

        void setStatePorter(h hVar);

        void setTitle(String str);
    }

    public interface h {
        int aFg();

        int aFh();
    }

    public interface b {
        void H(String str, int i, int i2);

        void aFq();

        void aFr();

        void aFs();

        void aFt();

        void aFu();

        void aFv();

        void de(int i, int i2);
    }

    public interface c {
        void aFw();

        void oA(int i);
    }

    void aEX();

    void akV();

    void akW();

    boolean as(float f);

    void c(boolean z, String str, int i);

    boolean e(double d, boolean z);

    int getCacheTimeSec();

    int getCurrPosMs();

    int getCurrPosSec();

    int getVideoDurationSec();

    boolean isLive();

    boolean isPlaying();

    boolean pause();

    boolean s(double d);

    void setControlBar(a aVar);

    void setIMMVideoViewCallback(b bVar);

    void setMute(boolean z);

    void setScaleType(g gVar);

    void setVideoSource(int i);

    void start();

    void stop();
}
