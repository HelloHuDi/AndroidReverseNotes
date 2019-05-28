package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.f;

public interface d {

    public interface a {
        void asv();
    }

    public interface b {
    }

    public enum c {
        WaitStart,
        Start,
        PrepareStop,
        WaitStop,
        Stop,
        WaitSend,
        Sent,
        Error,
        Initialized,
        Pause;

        static {
            AppMethodBeat.o(60315);
        }
    }

    String Aq();

    void G(int i, int i2, int i3);

    String WI();

    float WJ();

    long WK();

    c WL();

    int WM();

    Point WN();

    int WO();

    boolean WP();

    com.tencent.mm.audio.b.c.a WQ();

    void WR();

    String Wy();

    void a(a aVar);

    void af(float f);

    int b(int i, boolean z, int i2);

    void cancel();

    void clear();

    void cv(boolean z);

    String getFileName();

    String getFilePath();

    f getFrameDataCallback();

    boolean isLandscape();

    boolean ko(int i);

    void kp(int i);

    void mb(String str);

    void mc(String str);

    void pause();

    void reset();

    void s(int i, int i2, int i3, int i4);

    void setFilePath(String str);

    void setMute(boolean z);

    void v(Runnable runnable);
}
