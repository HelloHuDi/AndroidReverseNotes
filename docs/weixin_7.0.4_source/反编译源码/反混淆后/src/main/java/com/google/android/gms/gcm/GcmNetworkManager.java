package com.google.android.gms.gcm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.p057v4.p065f.C6197a;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.GmsVersion;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

public class GcmNetworkManager {
    public static final int RESULT_FAILURE = 2;
    public static final int RESULT_RESCHEDULE = 1;
    public static final int RESULT_SUCCESS = 0;
    @GuardedBy("GcmNetworkManager.class")
    private static GcmNetworkManager zzg;
    private final Context zzh;
    @GuardedBy("this")
    private final Map<String, Map<String, Boolean>> zzi = new C6197a();

    private GcmNetworkManager(Context context) {
        AppMethodBeat.m2504i(69936);
        this.zzh = context;
        AppMethodBeat.m2505o(69936);
    }

    public static GcmNetworkManager getInstance(Context context) {
        GcmNetworkManager gcmNetworkManager;
        AppMethodBeat.m2504i(69935);
        synchronized (GcmNetworkManager.class) {
            try {
                if (zzg == null) {
                    zzg = new GcmNetworkManager(context.getApplicationContext());
                }
                gcmNetworkManager = zzg;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(69935);
            }
        }
        return gcmNetworkManager;
    }

    private final zzn zzd() {
        AppMethodBeat.m2504i(69937);
        if (GoogleCloudMessaging.zzf(this.zzh) < GmsVersion.VERSION_LONGHORN) {
            zzo zzo = new zzo();
            AppMethodBeat.m2505o(69937);
            return zzo;
        }
        zzm zzm = new zzm(this.zzh);
        AppMethodBeat.m2505o(69937);
        return zzm;
    }

    static void zzd(String str) {
        AppMethodBeat.m2504i(69941);
        IllegalArgumentException illegalArgumentException;
        if (TextUtils.isEmpty(str)) {
            illegalArgumentException = new IllegalArgumentException("Must provide a valid tag.");
            AppMethodBeat.m2505o(69941);
            throw illegalArgumentException;
        } else if (100 < str.length()) {
            illegalArgumentException = new IllegalArgumentException("Tag is larger than max permissible tag length (100)");
            AppMethodBeat.m2505o(69941);
            throw illegalArgumentException;
        } else {
            AppMethodBeat.m2505o(69941);
        }
    }

    private final boolean zze(String str) {
        AppMethodBeat.m2504i(69942);
        Preconditions.checkNotNull(str, "GcmTaskService must not be null.");
        PackageManager packageManager = this.zzh.getPackageManager();
        Collection emptyList;
        if (packageManager == null) {
            emptyList = Collections.emptyList();
        } else {
            emptyList = packageManager.queryIntentServices(str != null ? new Intent(GcmTaskService.SERVICE_ACTION_EXECUTE_TASK).setClassName(this.zzh, str) : new Intent(GcmTaskService.SERVICE_ACTION_EXECUTE_TASK).setPackage(this.zzh.getPackageName()), 0);
        }
        if (CollectionUtils.isEmpty((Collection) emptyList)) {
            String.valueOf(str).concat(" is not available. This may cause the task to be lost.");
            AppMethodBeat.m2505o(69942);
        } else {
            for (ResolveInfo resolveInfo : emptyList) {
                if (resolveInfo.serviceInfo != null && resolveInfo.serviceInfo.enabled) {
                    AppMethodBeat.m2505o(69942);
                }
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 118).append("The GcmTaskService class you provided ").append(str).append(" does not seem to support receiving com.google.android.gms.gcm.ACTION_TASK_READY").toString());
            AppMethodBeat.m2505o(69942);
            throw illegalArgumentException;
        }
        return true;
    }

    public void cancelAllTasks(Class<? extends GcmTaskService> cls) {
        AppMethodBeat.m2504i(69940);
        ComponentName componentName = new ComponentName(this.zzh, cls);
        zze(componentName.getClassName());
        zzd().zzd(componentName);
        AppMethodBeat.m2505o(69940);
    }

    public void cancelTask(String str, Class<? extends GcmTaskService> cls) {
        AppMethodBeat.m2504i(69939);
        ComponentName componentName = new ComponentName(this.zzh, cls);
        zzd(str);
        zze(componentName.getClassName());
        zzd().zzd(componentName, str);
        AppMethodBeat.m2505o(69939);
    }

    public synchronized void schedule(Task task) {
        AppMethodBeat.m2504i(69938);
        zze(task.getServiceName());
        if (zzd().zzd(task)) {
            Map map = (Map) this.zzi.get(task.getServiceName());
            if (map != null && map.containsKey(task.getTag())) {
                map.put(task.getTag(), Boolean.TRUE);
            }
        }
        AppMethodBeat.m2505o(69938);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized boolean zzd(String str, String str2) {
        boolean z;
        AppMethodBeat.m2504i(69943);
        Map map = (Map) this.zzi.get(str2);
        if (map == null) {
            map = new C6197a();
            this.zzi.put(str2, map);
        }
        if (map.put(str, Boolean.FALSE) == null) {
            z = true;
            AppMethodBeat.m2505o(69943);
        } else {
            z = false;
            AppMethodBeat.m2505o(69943);
        }
        return z;
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void zze(String str, String str2) {
        AppMethodBeat.m2504i(69944);
        Map map = (Map) this.zzi.get(str2);
        if (map != null) {
            if ((map.remove(str) != null ? 1 : null) != null && map.isEmpty()) {
                this.zzi.remove(str2);
            }
        }
        AppMethodBeat.m2505o(69944);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized boolean zzf(String str) {
        boolean containsKey;
        AppMethodBeat.m2504i(69946);
        containsKey = this.zzi.containsKey(str);
        AppMethodBeat.m2505o(69946);
        return containsKey;
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized boolean zzf(String str, String str2) {
        boolean z;
        AppMethodBeat.m2504i(69945);
        Map map = (Map) this.zzi.get(str2);
        if (map != null) {
            Boolean bool = (Boolean) map.get(str);
            if (bool == null) {
                AppMethodBeat.m2505o(69945);
                z = false;
            } else {
                z = bool.booleanValue();
                AppMethodBeat.m2505o(69945);
            }
        } else {
            AppMethodBeat.m2505o(69945);
            z = false;
        }
        return z;
    }
}
