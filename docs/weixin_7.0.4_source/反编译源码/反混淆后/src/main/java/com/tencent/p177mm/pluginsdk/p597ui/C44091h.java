package com.tencent.p177mm.pluginsdk.p597ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.pluginsdk.ui.h */
public interface C44091h {

    /* renamed from: com.tencent.mm.pluginsdk.ui.h$a */
    public interface C23323a {
        /* renamed from: am */
        void mo39053am(String str, boolean z);
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.h$b */
    public interface C23324b {
        /* renamed from: c */
        void mo9209c(String str, String str2, String str3, int i, int i2);

        /* renamed from: cp */
        void mo9210cp(String str, String str2);

        /* renamed from: cq */
        void mo9211cq(String str, String str2);

        /* renamed from: cr */
        void mo9212cr(String str, String str2);

        /* renamed from: cs */
        void mo9213cs(String str, String str2);

        /* renamed from: ct */
        void mo9214ct(String str, String str2);

        /* renamed from: cu */
        void mo9215cu(String str, String str2);

        /* renamed from: d */
        void mo9216d(String str, String str2, int i, int i2);
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.h$c */
    public interface C23325c {
        /* renamed from: gp */
        void mo26918gp(long j);

        /* renamed from: wB */
        void mo26927wB(String str);
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.h$d */
    public enum C35873d {
        DEFAULT,
        FILL,
        CONTAIN,
        COVER;

        static {
            AppMethodBeat.m2505o(117961);
        }
    }

    void aEX();

    void akV();

    void akW();

    /* renamed from: as */
    boolean mo26910as(float f);

    /* renamed from: c */
    void mo9063c(boolean z, String str, int i);

    void cpU();

    /* renamed from: e */
    boolean mo26912e(double d, boolean z);

    int getCacheTimeSec();

    int getCurrPosMs();

    int getCurrPosSec();

    int getPlayerType();

    int getVideoDurationSec();

    boolean isLive();

    boolean isPlaying();

    boolean pause();

    /* renamed from: s */
    boolean mo26920s(double d);

    void setCover(Bitmap bitmap);

    void setFullDirection(int i);

    void setIsShowBasicControls(boolean z);

    void setMute(boolean z);

    void setScaleType(C35873d c35873d);

    void setVideoFooterView(C30135g c30135g);

    void start();

    void stop();
}
