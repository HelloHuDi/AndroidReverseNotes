package com.tencent.p177mm.modelvideo;

/* renamed from: com.tencent.mm.modelvideo.b */
public interface C9715b {

    /* renamed from: com.tencent.mm.modelvideo.b$a */
    public interface C9714a {
        /* renamed from: ad */
        void mo9058ad(String str, int i);

        /* renamed from: h */
        void mo9075h(String str, int i, int i2);

        /* renamed from: ml */
        void mo21050ml(int i);

        void onDataAvailable(String str, int i, int i2);
    }

    /* renamed from: a */
    void mo8712a(C9714a c9714a);

    /* renamed from: dV */
    void mo8713dV(String str);

    boolean isVideoDataAvailable(String str, int i, int i2);

    /* renamed from: r */
    void mo8715r(String str, String str2, String str3);

    void requestVideoData(String str, int i, int i2);
}
