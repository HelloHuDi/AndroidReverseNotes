package android.support.v4.app;

import android.app.Service;
import android.content.ComponentName;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class JobIntentService extends Service {
    static final HashMap<ComponentName, Object> Ef = new HashMap();
    static final Object sLock = new Object();
    boolean Ed = false;
    final ArrayList<Object> Ee;
    boolean mDestroyed = false;
    boolean mStopped = false;

    public JobIntentService() {
        if (VERSION.SDK_INT >= 26) {
            this.Ee = null;
        } else {
            this.Ee = new ArrayList();
        }
    }
}
