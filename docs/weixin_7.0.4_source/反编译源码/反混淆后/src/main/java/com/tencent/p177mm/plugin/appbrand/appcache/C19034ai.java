package com.tencent.p177mm.plugin.appbrand.appcache;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.ai */
public final class C19034ai {
    private static int gTD;

    /* renamed from: ns */
    static synchronized void m29611ns(int i) {
        synchronized (C19034ai.class) {
            gTD = i;
        }
    }

    public static synchronized int avM() {
        int i;
        synchronized (C19034ai.class) {
            i = gTD;
        }
        return i;
    }
}
