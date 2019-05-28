package com.tencent.matrix.resource.e;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.os.Debug;
import com.tencent.matrix.d.c;
import com.tencent.matrix.resource.CanaryWorkerService;
import com.tencent.matrix.resource.analyzer.model.DestroyedActivityInfo;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends com.tencent.matrix.c.a {
    public final com.tencent.matrix.resource.b bXR;
    public final e bXS;
    final int bXT;
    private final d bXU;
    final c bXV;
    final com.tencent.matrix.resource.e.c.a bXW;
    final ConcurrentLinkedQueue<DestroyedActivityInfo> bXX;
    final AtomicLong bXY;
    public final ActivityLifecycleCallbacks bXZ;
    public final com.tencent.matrix.resource.e.e.a bYa;

    public static class a {
        /* Access modifiers changed, original: protected */
        public d aB(Context context) {
            return new d(context);
        }

        /* Access modifiers changed, original: protected */
        public c a(Context context, d dVar) {
            return new c(context, dVar);
        }

        /* Access modifiers changed, original: protected */
        public com.tencent.matrix.resource.e.c.a a(final Context context, com.tencent.matrix.resource.b.a aVar) {
            return new com.tencent.matrix.resource.e.c.a() {
                public final void a(com.tencent.matrix.resource.analyzer.model.a aVar) {
                    CanaryWorkerService.a(context, aVar);
                }
            };
        }
    }

    public b(Application application, final com.tencent.matrix.resource.b bVar) {
        this(application, bVar, new a() {
            /* Access modifiers changed, original: protected|final */
            public final d aB(Context context) {
                if (bVar.bWQ.bWV) {
                    return super.aB(context);
                }
                return null;
            }

            /* Access modifiers changed, original: protected|final */
            public final c a(Context context, d dVar) {
                if (bVar.bWQ.bWV) {
                    return super.a(context, dVar);
                }
                return null;
            }

            /* Access modifiers changed, original: protected|final */
            public final com.tencent.matrix.resource.e.c.a a(Context context, com.tencent.matrix.resource.b.a aVar) {
                if (aVar.bWV) {
                    return super.a(context, aVar);
                }
                return null;
            }
        });
    }

    private b(Application application, com.tencent.matrix.resource.b bVar, a aVar) {
        super(application, bVar.getTag(), bVar);
        this.bXZ = new a() {
            private int bYc = 0;
            private int bYd = 0;

            public final void onActivityCreated(Activity activity, Bundle bundle) {
                b.this.bXY.incrementAndGet();
            }

            public final void onActivityStarted(Activity activity) {
                if (this.bYc <= 0) {
                    c.i("Matrix.ActivityRefWatcher", "we are in foreground, start watcher task.", new Object[0]);
                    b.this.bXS.a(b.this.bYa, 0);
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
                    c.i("Matrix.ActivityRefWatcher", "we are in background, stop watcher task.", new Object[0]);
                    b.this.bXS.zu();
                }
            }

            public final void onActivityDestroyed(Activity activity) {
                b bVar = b.this;
                String name = activity.getClass().getName();
                if (bVar.cg(name)) {
                    c.d("Matrix.ActivityRefWatcher", "activity leak with name %s had published, just ignore", name);
                } else {
                    UUID randomUUID = UUID.randomUUID();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("MATRIX_RESCANARY_REFKEY_").append(name).append('_').append(Long.toHexString(randomUUID.getMostSignificantBits())).append(Long.toHexString(randomUUID.getLeastSignificantBits()));
                    bVar.bXX.add(new DestroyedActivityInfo(stringBuilder.toString(), activity, name, bVar.bXY.get()));
                }
                synchronized (b.this.bXX) {
                    b.this.bXX.notifyAll();
                }
            }
        };
        this.bYa = new com.tencent.matrix.resource.e.e.a() {
            public final com.tencent.matrix.resource.e.e.a.a zr() {
                while (b.this.bXX.isEmpty()) {
                    synchronized (b.this.bXX) {
                        try {
                            b.this.bXX.wait();
                        } catch (Throwable th) {
                        }
                    }
                }
                if (!Debug.isDebuggerConnected() || b.this.bXR.bWQ.bWW) {
                    WeakReference weakReference = new WeakReference(new Object());
                    c.v("Matrix.ActivityRefWatcher", "triggering gc...", new Object[0]);
                    Runtime.getRuntime().gc();
                    Runtime.getRuntime().runFinalization();
                    c.v("Matrix.ActivityRefWatcher", "gc was triggered.", new Object[0]);
                    if (weakReference.get() != null) {
                        c.d("Matrix.ActivityRefWatcher", "system ignore our gc request, wait for next detection.", new Object[0]);
                        return com.tencent.matrix.resource.e.e.a.a.RETRY;
                    }
                    Iterator it = b.this.bXX.iterator();
                    while (it.hasNext()) {
                        DestroyedActivityInfo destroyedActivityInfo = (DestroyedActivityInfo) it.next();
                        if (b.this.cg(destroyedActivityInfo.mActivityName)) {
                            c.v("Matrix.ActivityRefWatcher", "activity with key [%s] was already published.", destroyedActivityInfo.mActivityName);
                            it.remove();
                        } else if (destroyedActivityInfo.mActivityRef.get() == null) {
                            c.v("Matrix.ActivityRefWatcher", "activity with key [%s] was already recycled.", destroyedActivityInfo.mKey);
                            it.remove();
                        } else {
                            destroyedActivityInfo.mDetectedCount++;
                            long j = b.this.bXY.get() - destroyedActivityInfo.mLastCreatedActivityCount;
                            if (destroyedActivityInfo.mDetectedCount < b.this.bXT || (j < 2 && !b.this.bXR.bWQ.bWW)) {
                                c.i("Matrix.ActivityRefWatcher", "activity with key [%s] should be recycled but actually still \nexists in %s times detection with %s created activities during destroy, wait for next detection to confirm.", destroyedActivityInfo.mKey, Integer.valueOf(destroyedActivityInfo.mDetectedCount), Long.valueOf(j));
                            } else {
                                c.i("Matrix.ActivityRefWatcher", "activity with key [%s] was suspected to be a leaked instance.", destroyedActivityInfo.mKey);
                                if (b.this.bXV != null) {
                                    File zs = b.this.bXV.zs();
                                    if (zs != null) {
                                        b.this.cf(destroyedActivityInfo.mActivityName);
                                        b.this.bXW.a(new com.tencent.matrix.resource.analyzer.model.a(zs, destroyedActivityInfo.mKey, destroyedActivityInfo.mActivityName));
                                        it.remove();
                                    } else {
                                        c.i("Matrix.ActivityRefWatcher", "heap dump for further analyzing activity with key [%s] was failed, just ignore.", destroyedActivityInfo.mKey);
                                        it.remove();
                                    }
                                } else {
                                    c.i("Matrix.ActivityRefWatcher", "lightweight mode, just report leaked activity name.", new Object[0]);
                                    b.this.cf(destroyedActivityInfo.mActivityName);
                                    if (b.this.bXR != null) {
                                        JSONObject jSONObject = new JSONObject();
                                        try {
                                            jSONObject.put("activity", destroyedActivityInfo.mActivityName);
                                        } catch (JSONException e) {
                                            c.printErrStackTrace("Matrix.ActivityRefWatcher", e, "unexpected exception.", new Object[0]);
                                        }
                                        b.this.bXR.onDetectIssue(new com.tencent.matrix.c.b(jSONObject));
                                    }
                                }
                            }
                        }
                    }
                    return com.tencent.matrix.resource.e.e.a.a.RETRY;
                }
                c.w("Matrix.ActivityRefWatcher", "debugger is connected, to avoid fake result, detection was delayed.", new Object[0]);
                return com.tencent.matrix.resource.e.e.a.a.RETRY;
            }
        };
        this.bXR = bVar;
        com.tencent.matrix.resource.b.a aVar2 = bVar.bWQ;
        this.bXS = new e(aVar2.bUG.get(com.tencent.mrs.b.a.a.clicfg_matrix_resource_detect_interval_millis.name(), com.tencent.matrix.resource.b.a.bWU), com.tencent.matrix.d.b.zL());
        this.bXT = aVar2.bUG.get(com.tencent.mrs.b.a.a.clicfg_matrix_resource_max_detect_times.name(), 3);
        this.bXU = aVar.aB(application);
        this.bXV = aVar.a((Context) application, this.bXU);
        this.bXW = aVar.a((Context) application, aVar2);
        this.bXX = new ConcurrentLinkedQueue();
        this.bXY = new AtomicLong(0);
    }

    public final void zp() {
        Application application = this.bXR.getApplication();
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(this.bXZ);
            zq();
        }
    }

    private void zq() {
        this.bXS.zu();
        this.bXX.clear();
        this.bXY.set(0);
    }
}
