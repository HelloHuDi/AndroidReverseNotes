package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.graphics.Bitmap;

public interface e {

    public interface d {
        void akY();
    }

    public interface e {
        void bQL();
    }

    public interface a {
        void EA();

        int dG(int i, int i2);

        void dH(int i, int i2);

        void onError(int i, int i2);

        void pL();
    }

    public interface c {
        void cU(boolean z);
    }

    public interface b {
        void gO(int i, int i2);
    }

    void B(double d);

    void d(double d, boolean z);

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

    void setOnInfoCallback(b bVar);

    void setOnSeekCompleteCallback(c cVar);

    void setOnSurfaceCallback(d dVar);

    void setOneTimeVideoTextureUpdateCallback(e eVar);

    void setPlayProgressCallback(boolean z);

    void setThumb(Bitmap bitmap);

    void setVideoCallback(a aVar);

    void setVideoPath(String str);

    boolean start();

    void stop();

    boolean w(Context context, boolean z);
}
