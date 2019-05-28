package android.support.p057v4.app;

import android.app.Service;
import android.content.ComponentName;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: android.support.v4.app.JobIntentService */
public abstract class JobIntentService extends Service {
    /* renamed from: Ef */
    static final HashMap<ComponentName, Object> f3878Ef = new HashMap();
    static final Object sLock = new Object();
    /* renamed from: Ed */
    boolean f3879Ed = false;
    /* renamed from: Ee */
    final ArrayList<Object> f3880Ee;
    boolean mDestroyed = false;
    boolean mStopped = false;

    public JobIntentService() {
        if (VERSION.SDK_INT >= 26) {
            this.f3880Ee = null;
        } else {
            this.f3880Ee = new ArrayList();
        }
    }
}
