package com.tencent.mm.booter.cache;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CacheService extends Service {
    public void onCreate() {
        AppMethodBeat.i(15882);
        super.onCreate();
        a.prepare();
        AppMethodBeat.o(15882);
    }

    public void onDestroy() {
        AppMethodBeat.i(15883);
        super.onDestroy();
        a.destroy();
        AppMethodBeat.o(15883);
    }

    public IBinder onBind(Intent intent) {
        return a.edm;
    }
}
