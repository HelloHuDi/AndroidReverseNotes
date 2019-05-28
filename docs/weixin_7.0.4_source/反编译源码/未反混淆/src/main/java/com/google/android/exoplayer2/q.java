package com.google.android.exoplayer2;

public interface q {

    public interface a {
        void a(e eVar);

        void a(p pVar);

        void aH(boolean z);

        void c(boolean z, int i);

        void qe();
    }

    void a(a aVar);

    void aE(boolean z);

    void b(a aVar);

    int getBufferedPercentage();

    long getBufferedPosition();

    long getCurrentPosition();

    long getDuration();

    boolean isLoading();

    int pO();

    boolean pP();

    void release();

    void seekTo(long j);

    void setRepeatMode(int i);

    void stop();
}
