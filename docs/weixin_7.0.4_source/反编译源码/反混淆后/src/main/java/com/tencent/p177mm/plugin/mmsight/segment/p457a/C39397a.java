package com.tencent.p177mm.plugin.mmsight.segment.p457a;

import android.view.Surface;

/* renamed from: com.tencent.mm.plugin.mmsight.segment.a.a */
public interface C39397a {

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.a.a$a */
    public interface C21307a {
        /* renamed from: ey */
        boolean mo17632ey(int i, int i2);
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.a.a$b */
    public interface C28510b {
        /* renamed from: ce */
        void mo17631ce(Object obj);
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.a.a$c */
    public interface C39398c {
        /* renamed from: cf */
        void mo7952cf(Object obj);
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.a.a$d */
    public interface C39399d {
        /* renamed from: aa */
        void mo17622aa(int i, int i2, int i3);
    }

    /* renamed from: a */
    void mo46476a(C21307a c21307a);

    /* renamed from: a */
    void mo46477a(C28510b c28510b);

    /* renamed from: a */
    void mo46478a(C39398c c39398c);

    /* renamed from: a */
    void mo46479a(C39399d c39399d);

    int getCurrentPosition();

    int getDuration();

    boolean isPlaying();

    void pause();

    void prepareAsync();

    void release();

    void seekTo(int i);

    void setAudioStreamType(int i);

    void setDataSource(String str);

    void setLoop(int i, int i2);

    void setLooping(boolean z);

    void setSurface(Surface surface);

    void start();

    void stop();
}
