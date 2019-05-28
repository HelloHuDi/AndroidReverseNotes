package com.tencent.matrix.resource.p169e;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.os.Debug;
import com.tencent.matrix.p156c.C1062b;
import com.tencent.matrix.p156c.C6284a;
import com.tencent.matrix.p157d.C1068b;
import com.tencent.matrix.p157d.C1070c;
import com.tencent.matrix.resource.C7464b;
import com.tencent.matrix.resource.CanaryWorkerService;
import com.tencent.matrix.resource.analyzer.model.C1097a;
import com.tencent.matrix.resource.analyzer.model.DestroyedActivityInfo;
import com.tencent.matrix.resource.p163b.C1099a;
import com.tencent.matrix.resource.p169e.C1123c.C1122a;
import com.tencent.matrix.resource.p169e.C1129e.C1128a;
import com.tencent.matrix.resource.p169e.C1129e.C1128a.C1127a;
import com.tencent.mrs.p656b.C5774a.C5773a;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.matrix.resource.e.b */
public final class C7465b extends C6284a {
    public final C7464b bXR;
    public final C1129e bXS;
    final int bXT;
    private final C1125d bXU;
    final C1123c bXV;
    final C1122a bXW;
    final ConcurrentLinkedQueue<DestroyedActivityInfo> bXX;
    final AtomicLong bXY;
    public final ActivityLifecycleCallbacks bXZ;
    public final C1128a bYa;

    /* renamed from: com.tencent.matrix.resource.e.b$a */
    public static class C1117a {
        /* Access modifiers changed, original: protected */
        /* renamed from: aB */
        public C1125d mo4339aB(Context context) {
            return new C1125d(context);
        }

        /* Access modifiers changed, original: protected */
        /* renamed from: a */
        public C1123c mo4338a(Context context, C1125d c1125d) {
            return new C1123c(context, c1125d);
        }

        /* Access modifiers changed, original: protected */
        /* renamed from: a */
        public C1122a mo4337a(final Context context, C1099a c1099a) {
            return new C1122a() {
                /* renamed from: a */
                public final void mo4340a(C1097a c1097a) {
                    CanaryWorkerService.m10301a(context, c1097a);
                }
            };
        }
    }

    /* renamed from: com.tencent.matrix.resource.e.b$2 */
    class C62902 extends C1116a {
        private int bYc = 0;
        private int bYd = 0;

        C62902() {
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            C7465b.this.bXY.incrementAndGet();
        }

        public final void onActivityStarted(Activity activity) {
            if (this.bYc <= 0) {
                C1070c.m2368i("Matrix.ActivityRefWatcher", "we are in foreground, start watcher task.", new Object[0]);
                C7465b.this.bXS.mo4349a(C7465b.this.bYa, 0);
            }
            if (this.bYd < 0) {
                this.bYd++;
            } else {
                this.bYc++;
            }
        }

        public final void onActivityStopped(Activity activity) {
            if (activity.isChangingConfigurations()) {
                this.bYd--;
                return;
            }
            this.bYc--;
            if (this.bYc <= 0) {
                C1070c.m2368i("Matrix.ActivityRefWatcher", "we are in background, stop watcher task.", new Object[0]);
                C7465b.this.bXS.mo4350zu();
            }
        }

        public final void onActivityDestroyed(Activity activity) {
            C7465b c7465b = C7465b.this;
            String name = activity.getClass().getName();
            if (c7465b.mo4202cg(name)) {
                C1070c.m2366d("Matrix.ActivityRefWatcher", "activity leak with name %s had published, just ignore", name);
            } else {
                UUID randomUUID = UUID.randomUUID();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("MATRIX_RESCANARY_REFKEY_").append(name).append('_').append(Long.toHexString(randomUUID.getMostSignificantBits())).append(Long.toHexString(randomUUID.getLeastSignificantBits()));
                c7465b.bXX.add(new DestroyedActivityInfo(stringBuilder.toString(), activity, name, c7465b.bXY.get()));
            }
            synchronized (C7465b.this.bXX) {
                C7465b.this.bXX.notifyAll();
            }
        }
    }

    /* renamed from: com.tencent.matrix.resource.e.b$3 */
    class C62913 implements C1128a {
        C62913() {
        }

        /* renamed from: zr */
        public final C1127a mo4348zr() {
            while (C7465b.this.bXX.isEmpty()) {
                synchronized (C7465b.this.bXX) {
                    try {
                        C7465b.this.bXX.wait();
                    } catch (Throwable th) {
                    }
                }
            }
            if (!Debug.isDebuggerConnected() || C7465b.this.bXR.bWQ.bWW) {
                WeakReference weakReference = new WeakReference(new Object());
                C1070c.m2369v("Matrix.ActivityRefWatcher", "triggering gc...", new Object[0]);
                Runtime.getRuntime().gc();
                Runtime.getRuntime().runFinalization();
                C1070c.m2369v("Matrix.ActivityRefWatcher", "gc was triggered.", new Object[0]);
                if (weakReference.get() != null) {
                    C1070c.m2366d("Matrix.ActivityRefWatcher", "system ignore our gc request, wait for next detection.", new Object[0]);
                    return C1127a.RETRY;
                }
                Iterator it = C7465b.this.bXX.iterator();
                while (it.hasNext()) {
                    DestroyedActivityInfo destroyedActivityInfo = (DestroyedActivityInfo) it.next();
                    if (C7465b.this.mo4202cg(destroyedActivityInfo.mActivityName)) {
                        C1070c.m2369v("Matrix.ActivityRefWatcher", "activity with key [%s] was already published.", destroyedActivityInfo.mActivityName);
                        it.remove();
                    } else if (destroyedActivityInfo.mActivityRef.get() == null) {
                        C1070c.m2369v("Matrix.ActivityRefWatcher", "activity with key [%s] was already recycled.", destroyedActivityInfo.mKey);
                        it.remove();
                    } else {
                        destroyedActivityInfo.mDetectedCount++;
                        long j = C7465b.this.bXY.get() - destroyedActivityInfo.mLastCreatedActivityCount;
                        if (destroyedActivityInfo.mDetectedCount < C7465b.this.bXT || (j < 2 && !C7465b.this.bXR.bWQ.bWW)) {
                            C1070c.m2368i("Matrix.ActivityRefWatcher", "activity with key [%s] should be recycled but actually still \nexists in %s times detection with %s created activities during destroy, wait for next detection to confirm.", destroyedActivityInfo.mKey, Integer.valueOf(destroyedActivityInfo.mDetectedCount), Long.valueOf(j));
                        } else {
                            C1070c.m2368i("Matrix.ActivityRefWatcher", "activity with key [%s] was suspected to be a leaked instance.", destroyedActivityInfo.mKey);
                            if (C7465b.this.bXV != null) {
                                File zs = C7465b.this.bXV.mo4344zs();
                                if (zs != null) {
                                    C7465b.this.mo4201cf(destroyedActivityInfo.mActivityName);
                                    C7465b.this.bXW.mo4340a(new C1097a(zs, destroyedActivityInfo.mKey, destroyedActivityInfo.mActivityName));
                                    it.remove();
                                } else {
                                    C1070c.m2368i("Matrix.ActivityRefWatcher", "heap dump for further analyzing activity with key [%s] was failed, just ignore.", destroyedActivityInfo.mKey);
                                    it.remove();
                                }
                            } else {
                                C1070c.m2368i("Matrix.ActivityRefWatcher", "lightweight mode, just report leaked activity name.", new Object[0]);
                                C7465b.this.mo4201cf(destroyedActivityInfo.mActivityName);
                                if (C7465b.this.bXR != null) {
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("activity", destroyedActivityInfo.mActivityName);
                                    } catch (JSONException e) {
                                        C1070c.printErrStackTrace("Matrix.ActivityRefWatcher", e, "unexpected exception.", new Object[0]);
                                    }
                                    C7465b.this.bXR.onDetectIssue(new C1062b(jSONObject));
                                }
                            }
                        }
                    }
                }
                return C1127a.RETRY;
            }
            C1070c.m2370w("Matrix.ActivityRefWatcher", "debugger is connected, to avoid fake result, detection was delayed.", new Object[0]);
            return C1127a.RETRY;
        }
    }

    public C7465b(Application application, final C7464b c7464b) {
        this(application, c7464b, new C1117a() {
            /* Access modifiers changed, original: protected|final */
            /* renamed from: aB */
            public final C1125d mo4339aB(Context context) {
                if (c7464b.bWQ.bWV) {
                    return super.mo4339aB(context);
                }
                return null;
            }

            /* Access modifiers changed, original: protected|final */
            /* renamed from: a */
            public final C1123c mo4338a(Context context, C1125d c1125d) {
                if (c7464b.bWQ.bWV) {
                    return super.mo4338a(context, c1125d);
                }
                return null;
            }

            /* Access modifiers changed, original: protected|final */
            /* renamed from: a */
            public final C1122a mo4337a(Context context, C1099a c1099a) {
                if (c1099a.bWV) {
                    return super.mo4337a(context, c1099a);
                }
                return null;
            }
        });
    }

    private C7465b(Application application, C7464b c7464b, C1117a c1117a) {
        super(application, c7464b.getTag(), c7464b);
        this.bXZ = new C62902();
        this.bYa = new C62913();
        this.bXR = c7464b;
        C1099a c1099a = c7464b.bWQ;
        this.bXS = new C1129e(c1099a.bUG.get(C5773a.clicfg_matrix_resource_detect_interval_millis.name(), C1099a.bWU), C1068b.m2358zL());
        this.bXT = c1099a.bUG.get(C5773a.clicfg_matrix_resource_max_detect_times.name(), 3);
        this.bXU = c1117a.mo4339aB(application);
        this.bXV = c1117a.mo4338a((Context) application, this.bXU);
        this.bXW = c1117a.mo4337a((Context) application, c1099a);
        this.bXX = new ConcurrentLinkedQueue();
        this.bXY = new AtomicLong(0);
    }

    /* renamed from: zp */
    public final void mo16642zp() {
        Application application = this.bXR.getApplication();
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(this.bXZ);
            m12831zq();
        }
    }

    /* renamed from: zq */
    private void m12831zq() {
        this.bXS.mo4350zu();
        this.bXX.clear();
        this.bXY.set(0);
    }
}
