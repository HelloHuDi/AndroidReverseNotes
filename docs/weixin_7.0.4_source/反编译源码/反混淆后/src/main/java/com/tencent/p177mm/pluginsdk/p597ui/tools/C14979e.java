package com.tencent.p177mm.pluginsdk.p597ui.tools;

import android.content.Context;
import android.graphics.Bitmap;

/* renamed from: com.tencent.mm.pluginsdk.ui.tools.e */
public interface C14979e {

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.e$d */
    public interface C14978d {
        void akY();
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.e$e */
    public interface C14980e {
        void bQL();
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.e$a */
    public interface C14981a {
        /* renamed from: EA */
        void mo8553EA();

        /* renamed from: dG */
        int mo8554dG(int i, int i2);

        /* renamed from: dH */
        void mo8555dH(int i, int i2);

        void onError(int i, int i2);

        /* renamed from: pL */
        void mo8557pL();
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.e$c */
    public interface C14982c {
        /* renamed from: cU */
        void mo9067cU(boolean z);
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.e$b */
    public interface C14983b {
        /* renamed from: gO */
        void mo27219gO(int i, int i2);
    }

    /* renamed from: B */
    void mo9052B(double d);

    /* renamed from: d */
    void mo27356d(double d, boolean z);

    int getCurrentPosition();

    int getDuration();

    double getLastProgresstime();

    long getLastSurfaceUpdateTime();

    String getVideoPath();

    boolean isPlaying();

    void onDetach();

    void pause();

    void setLoop(boolean z);

    void setMute(boolean z);

    void setOnInfoCallback(C14983b c14983b);

    void setOnSeekCompleteCallback(C14982c c14982c);

    void setOnSurfaceCallback(C14978d c14978d);

    void setOneTimeVideoTextureUpdateCallback(C14980e c14980e);

    void setPlayProgressCallback(boolean z);

    void setThumb(Bitmap bitmap);

    void setVideoCallback(C14981a c14981a);

    void setVideoPath(String str);

    boolean start();

    void stop();

    /* renamed from: w */
    boolean mo27377w(Context context, boolean z);
}
