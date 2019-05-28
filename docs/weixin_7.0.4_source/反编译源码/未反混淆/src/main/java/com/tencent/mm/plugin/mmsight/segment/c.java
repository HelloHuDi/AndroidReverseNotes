package com.tencent.mm.plugin.mmsight.segment;

public interface c {

    public interface a {
        void iY(boolean z);
    }

    public interface b {
        void U(float f, float f2);

        void V(float f, float f2);

        void W(float f, float f2);

        void bQc();
    }

    void RO(String str);

    float bQa();

    float bQb();

    int getDurationMs();

    void iX(boolean z);

    void release();

    void setCurrentCursorPosition(float f);

    void setOnPreparedListener(a aVar);

    void setThumbBarSeekListener(b bVar);
}
