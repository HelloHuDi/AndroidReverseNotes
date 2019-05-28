package com.tencent.wcdb.database;

class WCDBInitializationProbe {
    static volatile long apiEnv = 0;
    static boolean libLoaded = false;

    private WCDBInitializationProbe() {
    }
}
