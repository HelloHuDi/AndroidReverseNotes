package com.tencent.p177mm.booter.cache;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.booter.cache.CacheService */
public class CacheService extends Service {
    public void onCreate() {
        AppMethodBeat.m2504i(15882);
        super.onCreate();
        C25973a.prepare();
        AppMethodBeat.m2505o(15882);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(15883);
        super.onDestroy();
        C25973a.destroy();
        AppMethodBeat.m2505o(15883);
    }

    public IBinder onBind(Intent intent) {
        return C25973a.edm;
    }
}
