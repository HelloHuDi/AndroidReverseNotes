package com.tencent.p177mm.plugin.mmsight.model.p456a;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p195b.C1292c.C1293a;
import com.tencent.p177mm.plugin.mmsight.model.C39387f;

/* renamed from: com.tencent.mm.plugin.mmsight.model.a.d */
public interface C43304d {

    /* renamed from: com.tencent.mm.plugin.mmsight.model.a.d$a */
    public interface C12543a {
        void asv();
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.model.a.d$b */
    public interface C34542b {
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.model.a.d$c */
    public enum C34543c {
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
            AppMethodBeat.m2505o(60315);
        }
    }

    /* renamed from: Aq */
    String mo14833Aq();

    /* renamed from: G */
    void mo14834G(int i, int i2, int i3);

    /* renamed from: WI */
    String mo14835WI();

    /* renamed from: WJ */
    float mo14836WJ();

    /* renamed from: WK */
    long mo14837WK();

    /* renamed from: WL */
    C34543c mo14838WL();

    /* renamed from: WM */
    int mo14839WM();

    /* renamed from: WN */
    Point mo14840WN();

    /* renamed from: WO */
    int mo14841WO();

    /* renamed from: WP */
    boolean mo14842WP();

    /* renamed from: WQ */
    C1293a mo14843WQ();

    /* renamed from: WR */
    void mo14844WR();

    /* renamed from: Wy */
    String mo14845Wy();

    /* renamed from: a */
    void mo14846a(C12543a c12543a);

    /* renamed from: af */
    void mo14847af(float f);

    /* renamed from: b */
    int mo14848b(int i, boolean z, int i2);

    void cancel();

    void clear();

    /* renamed from: cv */
    void mo14851cv(boolean z);

    String getFileName();

    String getFilePath();

    C39387f getFrameDataCallback();

    boolean isLandscape();

    /* renamed from: ko */
    boolean mo14856ko(int i);

    /* renamed from: kp */
    void mo14857kp(int i);

    /* renamed from: mb */
    void mo14858mb(String str);

    /* renamed from: mc */
    void mo14859mc(String str);

    void pause();

    void reset();

    /* renamed from: s */
    void mo14862s(int i, int i2, int i3, int i4);

    void setFilePath(String str);

    void setMute(boolean z);

    /* renamed from: v */
    void mo14865v(Runnable runnable);
}
