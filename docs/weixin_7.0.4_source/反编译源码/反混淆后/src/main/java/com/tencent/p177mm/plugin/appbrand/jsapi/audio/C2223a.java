package com.tencent.p177mm.plugin.appbrand.jsapi.audio;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.a */
public abstract class C2223a implements C38260c, Runnable {
    private long hzT = 0;
    private long hzU = 0;

    public void run() {
        this.hzU = System.currentTimeMillis();
        mo21758Dp();
    }

    public final void aCr() {
        this.hzT = System.currentTimeMillis();
        C10304b.m17970I(this);
    }

    public final void aCs() {
        this.hzT = System.currentTimeMillis();
        mo21758Dp();
    }

    /* renamed from: wM */
    public void mo6087wM() {
        String name = getClass().getName();
        if (name.contains("$")) {
            name.substring(name.lastIndexOf("$") + 1);
            System.currentTimeMillis();
            System.currentTimeMillis();
            this.hzU = 0;
            this.hzT = 0;
        }
    }
}
