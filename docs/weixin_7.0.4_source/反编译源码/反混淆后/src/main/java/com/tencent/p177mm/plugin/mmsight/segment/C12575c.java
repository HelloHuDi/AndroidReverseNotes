package com.tencent.p177mm.plugin.mmsight.segment;

/* renamed from: com.tencent.mm.plugin.mmsight.segment.c */
public interface C12575c {

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.c$a */
    public interface C12576a {
        /* renamed from: iY */
        void mo17640iY(boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.c$b */
    public interface C12577b {
        /* renamed from: U */
        void mo17633U(float f, float f2);

        /* renamed from: V */
        void mo17634V(float f, float f2);

        /* renamed from: W */
        void mo17635W(float f, float f2);

        void bQc();
    }

    /* renamed from: RO */
    void mo24502RO(String str);

    float bQa();

    float bQb();

    int getDurationMs();

    /* renamed from: iX */
    void mo24506iX(boolean z);

    void release();

    void setCurrentCursorPosition(float f);

    void setOnPreparedListener(C12576a c12576a);

    void setThumbBarSeekListener(C12577b c12577b);
}
