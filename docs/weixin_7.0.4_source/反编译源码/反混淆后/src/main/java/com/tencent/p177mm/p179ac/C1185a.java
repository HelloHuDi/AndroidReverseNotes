package com.tencent.p177mm.p179ac;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.WeakHashMap;

/* renamed from: com.tencent.mm.ac.a */
public final class C1185a implements ActivityLifecycleCallbacks {
    private static final WeakHashMap<Activity, Integer> eOv = new WeakHashMap();

    static {
        AppMethodBeat.m2504i(115069);
        AppMethodBeat.m2505o(115069);
    }

    /* renamed from: SY */
    public static String m2613SY() {
        String stringBuilder;
        AppMethodBeat.m2504i(115062);
        synchronized (eOv) {
            StringBuilder stringBuilder2;
            try {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(eOv.size());
                ArrayList<Activity> arrayList = new ArrayList();
                arrayList.addAll(eOv.keySet());
            } catch (ConcurrentModificationException e) {
                C4990ab.m7420w("MicroMsg.ActivityRefDump", "ConcurrentModificationException occur.");
                stringBuilder2.append("concurrent modification exception");
            } catch (Throwable th) {
                AppMethodBeat.m2505o(115062);
            }
            for (Activity activity : arrayList) {
                if (activity != null) {
                    stringBuilder2.append("|");
                    stringBuilder2.append(activity.getClass().getSimpleName());
                    stringBuilder2.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                    stringBuilder2.append(eOv.get(activity));
                }
            }
            stringBuilder = stringBuilder2.toString();
        }
        AppMethodBeat.m2505o(115062);
        return stringBuilder;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(115063);
        synchronized (eOv) {
            try {
                eOv.put(activity, Integer.valueOf(0));
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(115063);
            }
        }
    }

    public final void onActivityDestroyed(Activity activity) {
        AppMethodBeat.m2504i(115064);
        synchronized (eOv) {
            try {
                eOv.put(activity, Integer.valueOf(5));
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(115064);
            }
        }
    }

    public final void onActivityStarted(Activity activity) {
        AppMethodBeat.m2504i(115065);
        synchronized (eOv) {
            try {
                eOv.put(activity, Integer.valueOf(1));
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(115065);
            }
        }
    }

    public final void onActivityResumed(Activity activity) {
        AppMethodBeat.m2504i(115066);
        synchronized (eOv) {
            try {
                eOv.put(activity, Integer.valueOf(2));
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(115066);
            }
        }
    }

    public final void onActivityPaused(Activity activity) {
        AppMethodBeat.m2504i(115067);
        synchronized (eOv) {
            try {
                eOv.put(activity, Integer.valueOf(3));
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(115067);
            }
        }
    }

    public final void onActivityStopped(Activity activity) {
        AppMethodBeat.m2504i(115068);
        synchronized (eOv) {
            try {
                eOv.put(activity, Integer.valueOf(4));
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(115068);
            }
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
