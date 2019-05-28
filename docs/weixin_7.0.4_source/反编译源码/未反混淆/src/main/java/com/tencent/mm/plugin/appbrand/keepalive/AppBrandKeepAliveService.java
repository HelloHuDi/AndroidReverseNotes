package com.tencent.mm.plugin.appbrand.keepalive;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class AppBrandKeepAliveService extends Service {
    public void onCreate() {
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }
}
