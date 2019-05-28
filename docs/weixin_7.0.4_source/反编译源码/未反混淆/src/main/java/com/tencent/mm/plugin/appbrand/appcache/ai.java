package com.tencent.mm.plugin.appbrand.appcache;

public final class ai {
    private static int gTD;

    static synchronized void ns(int i) {
        synchronized (ai.class) {
            gTD = i;
        }
    }

    public static synchronized int avM() {
        int i;
        synchronized (ai.class) {
            i = gTD;
        }
        return i;
    }
}
