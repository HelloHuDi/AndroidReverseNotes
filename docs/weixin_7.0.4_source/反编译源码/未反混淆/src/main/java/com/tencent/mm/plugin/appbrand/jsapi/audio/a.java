package com.tencent.mm.plugin.appbrand.jsapi.audio;

public abstract class a implements c, Runnable {
    private long hzT = 0;
    private long hzU = 0;

    public void run() {
        this.hzU = System.currentTimeMillis();
        Dp();
    }

    public final void aCr() {
        this.hzT = System.currentTimeMillis();
        b.I(this);
    }

    public final void aCs() {
        this.hzT = System.currentTimeMillis();
        Dp();
    }

    public void wM() {
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
