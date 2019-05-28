package com.google.android.exoplayer2;

/* renamed from: com.google.android.exoplayer2.q */
public interface C32067q {

    /* renamed from: com.google.android.exoplayer2.q$a */
    public interface C32068a {
        /* renamed from: a */
        void mo26014a(C25533e c25533e);

        /* renamed from: a */
        void mo26015a(C45045p c45045p);

        /* renamed from: aH */
        void mo26016aH(boolean z);

        /* renamed from: c */
        void mo26017c(boolean z, int i);

        /* renamed from: qe */
        void mo26018qe();
    }

    /* renamed from: a */
    void mo2615a(C32068a c32068a);

    /* renamed from: aE */
    void mo2618aE(boolean z);

    /* renamed from: b */
    void mo2619b(C32068a c32068a);

    int getBufferedPercentage();

    long getBufferedPosition();

    long getCurrentPosition();

    long getDuration();

    boolean isLoading();

    /* renamed from: pO */
    int mo2626pO();

    /* renamed from: pP */
    boolean mo2627pP();

    void release();

    void seekTo(long j);

    void setRepeatMode(int i);

    void stop();
}
