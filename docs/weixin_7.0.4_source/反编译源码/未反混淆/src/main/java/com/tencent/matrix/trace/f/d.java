package com.tencent.matrix.trace.f;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.c.b;
import com.tencent.matrix.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.config.SharePluginInfo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends e implements ActivityLifecycleCallbacks, com.tencent.matrix.trace.e.a {
    private final com.tencent.matrix.trace.a.a bYH;
    private long can = 0;
    private long cao = 0;
    private int cap;
    private boolean caq;
    private boolean car;
    private Set<String> cas;
    private long cat;
    private long cau;

    class a implements Runnable {
        long[] bZG;
        long can;
        long cav;
        long caw;
        boolean cax;
        int scene;

        a(long[] jArr, long j, long j2, long j3, boolean z, int i) {
            this.bZG = jArr;
            this.scene = i;
            this.cav = j;
            this.can = j2;
            this.caw = j3;
            this.cax = z;
        }

        public final void run() {
            b bVar;
            List linkedList = new LinkedList();
            if (this.bZG.length > 0) {
                com.tencent.matrix.trace.g.a.a(this.bZG, linkedList, false, -1);
                com.tencent.matrix.trace.g.a.a(linkedList, new com.tencent.matrix.trace.g.a.a() {
                    public final boolean c(long j, int i) {
                        return j < ((long) (i * 5));
                    }

                    public final void e(List<com.tencent.matrix.trace.d.a> list, int i) {
                        c.w("Matrix.StartupTracer", "[fallback] size:%s targetSize:%s stack:%s", Integer.valueOf(i), Integer.valueOf(30), list);
                        ListIterator listIterator = list.listIterator(Math.min(i, 30));
                        while (listIterator.hasNext()) {
                            listIterator.next();
                            listIterator.remove();
                        }
                    }
                });
            }
            StringBuilder stringBuilder = new StringBuilder();
            long max = Math.max(this.caw, com.tencent.matrix.trace.g.a.a(linkedList, stringBuilder, new StringBuilder()));
            String a = com.tencent.matrix.trace.g.a.a(linkedList, max);
            if ((this.caw > d.this.cat && !this.cax) || (this.caw > d.this.cau && this.cax)) {
                c.w("Matrix.StartupTracer", "stackKey:%s \n%s", a, r1.toString());
            }
            long j = this.cav;
            long j2 = this.can;
            boolean z = this.cax;
            int i = this.scene;
            com.tencent.matrix.trace.a aVar = (com.tencent.matrix.trace.a) com.tencent.matrix.a.yK().F(com.tencent.matrix.trace.a.class);
            try {
                JSONObject a2 = com.tencent.matrix.d.a.a(new JSONObject(), com.tencent.matrix.a.yK().application);
                a2.put("application_create", j);
                a2.put("application_create_scene", i);
                a2.put("first_activity_create", j2);
                a2.put("startup_duration", max);
                a2.put("is_warm_start_up", z);
                bVar = new b();
                bVar.tag = "Trace_StartUp";
                bVar.bWv = a2;
                aVar.onDetectIssue(bVar);
            } catch (JSONException e) {
                c.e("Matrix.StartupTracer", "[JSONException for StartUpReportTask error: %s", e);
            }
            if ((max > d.this.cat && !z) || (max > d.this.cau && z)) {
                try {
                    JSONObject a3 = com.tencent.matrix.d.a.a(new JSONObject(), com.tencent.matrix.a.yK().application);
                    a3.put("detail", com.tencent.matrix.trace.b.a.a.STARTUP);
                    a3.put("cost", max);
                    a3.put(SharePluginInfo.ISSUE_KEY_STACK, stringBuilder.toString());
                    a3.put("stackKey", a);
                    a3.put("subType", z ? 2 : 1);
                    bVar = new b();
                    bVar.tag = "Trace_EvilMethod";
                    bVar.bWv = a3;
                    aVar.onDetectIssue(bVar);
                } catch (JSONException e2) {
                    c.e("Matrix.StartupTracer", "[JSONException error: %s", e2);
                }
            }
        }
    }

    public d(com.tencent.matrix.trace.a.a aVar) {
        this.bYH = aVar;
        this.car = aVar.bYC;
        if (aVar.bYG == null) {
            Set hashSet;
            if (aVar.bWX == null) {
                hashSet = new HashSet(Arrays.asList(new String[]{aVar.bYF}));
            } else {
                hashSet = new HashSet(Arrays.asList(aVar.bWX.get(com.tencent.mrs.b.a.a.clicfg_matrix_trace_care_scene_set.name(), aVar.bYF).split(";")));
            }
            aVar.bYG = hashSet;
        }
        this.cas = aVar.bYG;
        this.cat = (long) (aVar.bWX == null ? Downloads.MIN_WAIT_FOR_NETWORK : aVar.bWX.get(com.tencent.mrs.b.a.a.clicfg_matrix_trace_app_start_up_threshold.name(), (int) Downloads.MIN_WAIT_FOR_NETWORK));
        this.cau = (long) (aVar.bWX == null ? WearableStatusCodes.TARGET_NODE_NOT_CONNECTED : aVar.bWX.get(com.tencent.mrs.b.a.a.clicfg_matrix_trace_warm_app_start_up_threshold.name(), (int) WearableStatusCodes.TARGET_NODE_NOT_CONNECTED));
    }

    /* Access modifiers changed, original: protected|final */
    public final void zC() {
        super.zC();
        c.i("Matrix.StartupTracer", "[onAlive] isStartupEnable:%s", Boolean.valueOf(this.car));
        if (this.car) {
            AppMethodBeat.getInstance().addListener(this);
            com.tencent.matrix.a.yK().application.registerActivityLifecycleCallbacks(this);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void zD() {
        super.zD();
        if (this.car) {
            AppMethodBeat.getInstance().removeListener(this);
            com.tencent.matrix.a.yK().application.unregisterActivityLifecycleCallbacks(this);
        }
    }

    public final void ch(String str) {
        boolean z;
        long uptimeMillis;
        boolean z2;
        if (this.cao == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (this.can == 0) {
                this.can = SystemClock.uptimeMillis() - com.tencent.matrix.trace.c.a.zA();
            }
            if (this.caq) {
                uptimeMillis = SystemClock.uptimeMillis() - com.tencent.matrix.trace.c.a.zA();
                this.cao = uptimeMillis;
                z2 = false;
            } else if (this.cas.contains(str)) {
                this.caq = true;
                z2 = false;
                uptimeMillis = 0;
            } else if (this.cas.isEmpty()) {
                c.i("Matrix.StartupTracer", "default care activity[%s]", str);
                uptimeMillis = this.can;
                this.cao = uptimeMillis;
                z2 = false;
            } else {
                c.w("Matrix.StartupTracer", "pass this activity[%s] in duration of startup!", str);
                z2 = false;
                uptimeMillis = 0;
            }
        } else {
            z2 = this.cap > 1 ? false : SystemClock.uptimeMillis() - com.tencent.matrix.trace.c.a.zB() <= 5000;
            uptimeMillis = z2 ? SystemClock.uptimeMillis() - com.tencent.matrix.trace.c.a.zB() : 0;
        }
        if (uptimeMillis > 0) {
            c.i("Matrix.StartupTracer", "[report] applicationCost:%s firstScreenCost:%s allCost:%s isWarmStartUp:%s", Long.valueOf(com.tencent.matrix.trace.c.a.zz()), Long.valueOf(this.can), Long.valueOf(uptimeMillis), Boolean.valueOf(z2));
            long[] jArr = new long[0];
            if (!z2 && uptimeMillis >= this.cat) {
                jArr = AppMethodBeat.getInstance().copyData(com.tencent.matrix.trace.c.a.bZo);
                com.tencent.matrix.trace.c.a.bZo.release();
            } else if (z2 && uptimeMillis >= this.cau) {
                jArr = AppMethodBeat.getInstance().copyData(com.tencent.matrix.trace.c.a.bZn);
                com.tencent.matrix.trace.c.a.bZn.release();
            }
            com.tencent.matrix.d.b.zM().post(new a(jArr, r4, r6, uptimeMillis, z2, com.tencent.matrix.trace.c.a.bZp));
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        this.cap++;
    }

    public final void onActivityDestroyed(Activity activity) {
        this.cap--;
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
