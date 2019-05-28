package com.tencent.matrix.trace.p175f;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.C1060a;
import com.tencent.matrix.p156c.C1062b;
import com.tencent.matrix.p157d.C1067a;
import com.tencent.matrix.p157d.C1068b;
import com.tencent.matrix.p157d.C1070c;
import com.tencent.matrix.trace.C7466a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.p170a.C1133a;
import com.tencent.matrix.trace.p171b.C1135a.C1134a;
import com.tencent.matrix.trace.p172c.C1137a;
import com.tencent.matrix.trace.p173d.C1151a;
import com.tencent.matrix.trace.p174e.C1152a;
import com.tencent.matrix.trace.p176g.C1166a;
import com.tencent.matrix.trace.p176g.C1166a.C1165a;
import com.tencent.mrs.p656b.C5774a.C5773a;
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

/* renamed from: com.tencent.matrix.trace.f.d */
public final class C7470d extends C6293e implements ActivityLifecycleCallbacks, C1152a {
    private final C1133a bYH;
    private long can = 0;
    private long cao = 0;
    private int cap;
    private boolean caq;
    private boolean car;
    private Set<String> cas;
    private long cat;
    private long cau;

    /* renamed from: com.tencent.matrix.trace.f.d$a */
    class C1162a implements Runnable {
        long[] bZG;
        long can;
        long cav;
        long caw;
        boolean cax;
        int scene;

        /* renamed from: com.tencent.matrix.trace.f.d$a$1 */
        class C11631 implements C1165a {
            C11631() {
            }

            /* renamed from: c */
            public final boolean mo4391c(long j, int i) {
                return j < ((long) (i * 5));
            }

            /* renamed from: e */
            public final void mo4392e(List<C1151a> list, int i) {
                C1070c.m2370w("Matrix.StartupTracer", "[fallback] size:%s targetSize:%s stack:%s", Integer.valueOf(i), Integer.valueOf(30), list);
                ListIterator listIterator = list.listIterator(Math.min(i, 30));
                while (listIterator.hasNext()) {
                    listIterator.next();
                    listIterator.remove();
                }
            }
        }

        C1162a(long[] jArr, long j, long j2, long j3, boolean z, int i) {
            this.bZG = jArr;
            this.scene = i;
            this.cav = j;
            this.can = j2;
            this.caw = j3;
            this.cax = z;
        }

        public final void run() {
            C1062b c1062b;
            List linkedList = new LinkedList();
            if (this.bZG.length > 0) {
                C1166a.m2541a(this.bZG, linkedList, false, -1);
                C1166a.m2540a(linkedList, new C11631());
            }
            StringBuilder stringBuilder = new StringBuilder();
            long max = Math.max(this.caw, C1166a.m2538a(linkedList, stringBuilder, new StringBuilder()));
            String a = C1166a.m2539a(linkedList, max);
            if ((this.caw > C7470d.this.cat && !this.cax) || (this.caw > C7470d.this.cau && this.cax)) {
                C1070c.m2370w("Matrix.StartupTracer", "stackKey:%s \n%s", a, r1.toString());
            }
            long j = this.cav;
            long j2 = this.can;
            boolean z = this.cax;
            int i = this.scene;
            C7466a c7466a = (C7466a) C1060a.m2339yK().mo4192F(C7466a.class);
            try {
                JSONObject a2 = C1067a.m2349a(new JSONObject(), C1060a.m2339yK().application);
                a2.put("application_create", j);
                a2.put("application_create_scene", i);
                a2.put("first_activity_create", j2);
                a2.put("startup_duration", max);
                a2.put("is_warm_start_up", z);
                c1062b = new C1062b();
                c1062b.tag = "Trace_StartUp";
                c1062b.bWv = a2;
                c7466a.onDetectIssue(c1062b);
            } catch (JSONException e) {
                C1070c.m2367e("Matrix.StartupTracer", "[JSONException for StartUpReportTask error: %s", e);
            }
            if ((max > C7470d.this.cat && !z) || (max > C7470d.this.cau && z)) {
                try {
                    JSONObject a3 = C1067a.m2349a(new JSONObject(), C1060a.m2339yK().application);
                    a3.put("detail", C1134a.STARTUP);
                    a3.put("cost", max);
                    a3.put(SharePluginInfo.ISSUE_KEY_STACK, stringBuilder.toString());
                    a3.put("stackKey", a);
                    a3.put("subType", z ? 2 : 1);
                    c1062b = new C1062b();
                    c1062b.tag = "Trace_EvilMethod";
                    c1062b.bWv = a3;
                    c7466a.onDetectIssue(c1062b);
                } catch (JSONException e2) {
                    C1070c.m2367e("Matrix.StartupTracer", "[JSONException error: %s", e2);
                }
            }
        }
    }

    public C7470d(C1133a c1133a) {
        this.bYH = c1133a;
        this.car = c1133a.bYC;
        if (c1133a.bYG == null) {
            Set hashSet;
            if (c1133a.bWX == null) {
                hashSet = new HashSet(Arrays.asList(new String[]{c1133a.bYF}));
            } else {
                hashSet = new HashSet(Arrays.asList(c1133a.bWX.get(C5773a.clicfg_matrix_trace_care_scene_set.name(), c1133a.bYF).split(";")));
            }
            c1133a.bYG = hashSet;
        }
        this.cas = c1133a.bYG;
        this.cat = (long) (c1133a.bWX == null ? Downloads.MIN_WAIT_FOR_NETWORK : c1133a.bWX.get(C5773a.clicfg_matrix_trace_app_start_up_threshold.name(), (int) Downloads.MIN_WAIT_FOR_NETWORK));
        this.cau = (long) (c1133a.bWX == null ? WearableStatusCodes.TARGET_NODE_NOT_CONNECTED : c1133a.bWX.get(C5773a.clicfg_matrix_trace_warm_app_start_up_threshold.name(), (int) WearableStatusCodes.TARGET_NODE_NOT_CONNECTED));
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: zC */
    public final void mo14533zC() {
        super.mo14533zC();
        C1070c.m2368i("Matrix.StartupTracer", "[onAlive] isStartupEnable:%s", Boolean.valueOf(this.car));
        if (this.car) {
            AppMethodBeat.getInstance().addListener(this);
            C1060a.m2339yK().application.registerActivityLifecycleCallbacks(this);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: zD */
    public final void mo14534zD() {
        super.mo14534zD();
        if (this.car) {
            AppMethodBeat.getInstance().removeListener(this);
            C1060a.m2339yK().application.unregisterActivityLifecycleCallbacks(this);
        }
    }

    /* renamed from: ch */
    public final void mo4385ch(String str) {
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
                this.can = SystemClock.uptimeMillis() - C1137a.m2499zA();
            }
            if (this.caq) {
                uptimeMillis = SystemClock.uptimeMillis() - C1137a.m2499zA();
                this.cao = uptimeMillis;
                z2 = false;
            } else if (this.cas.contains(str)) {
                this.caq = true;
                z2 = false;
                uptimeMillis = 0;
            } else if (this.cas.isEmpty()) {
                C1070c.m2368i("Matrix.StartupTracer", "default care activity[%s]", str);
                uptimeMillis = this.can;
                this.cao = uptimeMillis;
                z2 = false;
            } else {
                C1070c.m2370w("Matrix.StartupTracer", "pass this activity[%s] in duration of startup!", str);
                z2 = false;
                uptimeMillis = 0;
            }
        } else {
            z2 = this.cap > 1 ? false : SystemClock.uptimeMillis() - C1137a.m2500zB() <= 5000;
            uptimeMillis = z2 ? SystemClock.uptimeMillis() - C1137a.m2500zB() : 0;
        }
        if (uptimeMillis > 0) {
            C1070c.m2368i("Matrix.StartupTracer", "[report] applicationCost:%s firstScreenCost:%s allCost:%s isWarmStartUp:%s", Long.valueOf(C1137a.m2502zz()), Long.valueOf(this.can), Long.valueOf(uptimeMillis), Boolean.valueOf(z2));
            long[] jArr = new long[0];
            if (!z2 && uptimeMillis >= this.cat) {
                jArr = AppMethodBeat.getInstance().copyData(C1137a.bZo);
                C1137a.bZo.release();
            } else if (z2 && uptimeMillis >= this.cau) {
                jArr = AppMethodBeat.getInstance().copyData(C1137a.bZn);
                C1137a.bZn.release();
            }
            C1068b.m2359zM().post(new C1162a(jArr, r4, r6, uptimeMillis, z2, C1137a.bZp));
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
