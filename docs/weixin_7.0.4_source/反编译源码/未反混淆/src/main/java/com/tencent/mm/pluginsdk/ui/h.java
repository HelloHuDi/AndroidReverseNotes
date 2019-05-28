package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface h {

    public interface a {
        void am(String str, boolean z);
    }

    public interface b {
        void c(String str, String str2, String str3, int i, int i2);

        void cp(String str, String str2);

        void cq(String str, String str2);

        void cr(String str, String str2);

        void cs(String str, String str2);

        void ct(String str, String str2);

        void cu(String str, String str2);

        void d(String str, String str2, int i, int i2);
    }

    public interface c {
        void gp(long j);

        void wB(String str);
    }

    public enum d {
        DEFAULT,
        FILL,
        CONTAIN,
        COVER;

        static {
            AppMethodBeat.o(117961);
        }
    }

    void aEX();

    void akV();

    void akW();

    boolean as(float f);

    void c(boolean z, String str, int i);

    void cpU();

    boolean e(double d, boolean z);

    int getCacheTimeSec();

    int getCurrPosMs();

    int getCurrPosSec();

    int getPlayerType();

    int getVideoDurationSec();

    boolean isLive();

    boolean isPlaying();

    boolean pause();

    boolean s(double d);

    void setCover(Bitmap bitmap);

    void setFullDirection(int i);

    void setIsShowBasicControls(boolean z);

    void setMute(boolean z);

    void setScaleType(d dVar);

    void setVideoFooterView(g gVar);

    void start();

    void stop();
}
