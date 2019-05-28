package com.tencent.smtt.export.external;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;

public class DexClassLoaderProviderService extends Service {
    private static final String LOGTAG = "dexloader";

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        AppMethodBeat.m2504i(63752);
        super.onCreate();
        DexClassLoaderProvider.setForceLoadDexFlag(true, this);
        AppMethodBeat.m2505o(63752);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(63754);
        System.exit(0);
        AppMethodBeat.m2505o(63754);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        AppMethodBeat.m2504i(63753);
        if (intent == null) {
            AppMethodBeat.m2505o(63753);
        } else {
            try {
                ArrayList stringArrayListExtra = intent.getStringArrayListExtra("dex2oat");
                if (stringArrayListExtra == null) {
                    AppMethodBeat.m2505o(63753);
                } else {
                    stringArrayListExtra.get(0);
                    String str = (String) stringArrayListExtra.get(1);
                    String str2 = (String) stringArrayListExtra.get(2);
                    String str3 = (String) stringArrayListExtra.get(3);
                    ClassLoader classLoader = getClassLoader();
                    File file = new File(str2);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    DexClassLoaderProvider.createDexClassLoader(str, str2, str3, classLoader, getApplicationContext());
                    AppMethodBeat.m2505o(63753);
                }
            } catch (Exception e) {
            }
        }
        return 1;
    }
}
