package com.tencent.matrix.resource;

import android.annotation.TargetApi;
import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class MatrixJobIntentService extends Service {
    static final HashMap<ComponentName, h> Ef = new HashMap();
    static final Object sLock = new Object();
    boolean Ed = false;
    final ArrayList<d> Ee;
    h bWA;
    a bWB;
    b bWz;
    boolean mDestroyed = false;
    boolean mStopped = false;

    final class a extends AsyncTask<Void, Void, Void> {
        a() {
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onCancelled(Object obj) {
            MatrixJobIntentService.this.zh();
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            MatrixJobIntentService.this.zh();
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            while (true) {
                e zi = MatrixJobIntentService.this.zi();
                if (zi == null) {
                    return null;
                }
                MatrixJobIntentService.this.l(zi.getIntent());
                zi.complete();
            }
        }
    }

    interface b {
        e zi();

        IBinder zj();
    }

    interface e {
        void complete();

        Intent getIntent();
    }

    static abstract class h {
        boolean bWO;
        int bWP;
        final ComponentName mComponentName;

        public abstract void m(Intent intent);

        h(ComponentName componentName) {
            this.mComponentName = componentName;
        }

        /* Access modifiers changed, original: final */
        public final void fV(int i) {
            if (!this.bWO) {
                this.bWO = true;
                this.bWP = i;
            } else if (this.bWP != i) {
                throw new IllegalArgumentException("Given job ID " + i + " is different than previous " + this.bWP);
            }
        }

        public void zk() {
        }

        public void zl() {
        }

        public void zm() {
        }
    }

    static final class c extends h {
        private final WakeLock bWD;
        private final WakeLock bWE;
        boolean bWF;
        boolean bWG;
        private final Context mContext;

        c(Context context, ComponentName componentName) {
            super(componentName);
            this.mContext = context.getApplicationContext();
            if (this.mContext.checkPermission("android.permission.WAKE_LOCK", Process.myPid(), Process.myUid()) == 0) {
                PowerManager powerManager = (PowerManager) context.getSystemService("power");
                this.bWD = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
                this.bWD.setReferenceCounted(false);
                this.bWE = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
                this.bWE.setReferenceCounted(false);
                return;
            }
            com.tencent.matrix.d.c.w("Matrix.JobIntentService", "it would be better to grant WAKE_LOCK permission to your app so that tinker can use WakeLock to keep system awake.", new Object[0]);
            this.bWE = null;
            this.bWD = null;
        }

        /* Access modifiers changed, original: final */
        public final void m(Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(this.mComponentName);
            try {
                if (this.mContext.startService(intent2) != null) {
                    synchronized (this) {
                        if (!this.bWF) {
                            this.bWF = true;
                            if (!(this.bWG || this.bWD == null)) {
                                this.bWD.acquire(60000);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                com.tencent.matrix.d.c.printErrStackTrace("Matrix.JobIntentService", th, "Exception occurred.", new Object[0]);
            }
        }

        public final void zk() {
            synchronized (this) {
                this.bWF = false;
            }
        }

        public final void zl() {
            synchronized (this) {
                if (!this.bWG) {
                    this.bWG = true;
                    if (this.bWE != null) {
                        this.bWE.acquire(600000);
                    }
                    if (this.bWD != null) {
                        this.bWD.release();
                    }
                }
            }
        }

        public final void zm() {
            synchronized (this) {
                if (this.bWG) {
                    if (this.bWF && this.bWD != null) {
                        this.bWD.acquire(60000);
                    }
                    this.bWG = false;
                    if (this.bWE != null) {
                        this.bWE.release();
                    }
                }
            }
        }
    }

    final class d implements e {
        final int bWH;
        final Intent mIntent;

        d(Intent intent, int i) {
            this.mIntent = intent;
            this.bWH = i;
        }

        public final Intent getIntent() {
            return this.mIntent;
        }

        public final void complete() {
            MatrixJobIntentService.this.stopSelf(this.bWH);
        }
    }

    static final class f extends JobServiceEngine implements b {
        final MatrixJobIntentService bWI;
        JobParameters bWJ;
        final Object mLock = new Object();

        final class a implements e {
            final JobWorkItem bWK;

            a(JobWorkItem jobWorkItem) {
                this.bWK = jobWorkItem;
            }

            public final Intent getIntent() {
                return this.bWK.getIntent();
            }

            public final void complete() {
                synchronized (f.this.mLock) {
                    if (f.this.bWJ != null) {
                        f.this.bWJ.completeWork(this.bWK);
                    }
                }
            }
        }

        f(MatrixJobIntentService matrixJobIntentService) {
            super(matrixJobIntentService);
            this.bWI = matrixJobIntentService;
        }

        public final IBinder zj() {
            return getBinder();
        }

        public final boolean onStartJob(JobParameters jobParameters) {
            synchronized (this.mLock) {
                this.bWJ = jobParameters;
            }
            this.bWI.bb(false);
            return true;
        }

        public final boolean onStopJob(JobParameters jobParameters) {
            MatrixJobIntentService matrixJobIntentService = this.bWI;
            if (matrixJobIntentService.bWB != null) {
                matrixJobIntentService.bWB.cancel(matrixJobIntentService.Ed);
            }
            matrixJobIntentService.mStopped = true;
            synchronized (this.mLock) {
                this.bWJ = null;
            }
            return true;
        }

        /* JADX WARNING: Missing block: B:10:0x0011, code skipped:
            if (r1 == null) goto L_?;
     */
        /* JADX WARNING: Missing block: B:12:0x0017, code skipped:
            if (r1.getIntent() == null) goto L_?;
     */
        /* JADX WARNING: Missing block: B:13:0x0019, code skipped:
            r1.getIntent().setExtrasClassLoader(r6.bWI.getClassLoader());
     */
        /* JADX WARNING: Missing block: B:23:?, code skipped:
            return null;
     */
        /* JADX WARNING: Missing block: B:24:?, code skipped:
            return null;
     */
        /* JADX WARNING: Missing block: B:25:?, code skipped:
            return new com.tencent.matrix.resource.MatrixJobIntentService.f.a(r6, r1);
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final e zi() {
            synchronized (this.mLock) {
                if (this.bWJ == null) {
                    return null;
                }
                try {
                    JobWorkItem dequeueWork = this.bWJ.dequeueWork();
                } catch (Throwable th) {
                    com.tencent.matrix.d.c.printErrStackTrace("JobServiceEngineImpl", th, "exception occurred.", new Object[0]);
                    return null;
                }
            }
        }
    }

    static final class g extends h {
        private final JobInfo bWM;
        private final JobScheduler bWN;

        g(Context context, ComponentName componentName, int i) {
            super(componentName);
            fV(i);
            this.bWM = new Builder(i, this.mComponentName).setOverrideDeadline(0).build();
            this.bWN = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        /* Access modifiers changed, original: final */
        public final void m(Intent intent) {
            this.bWN.enqueue(this.bWM, new JobWorkItem(intent));
        }
    }

    public abstract void l(Intent intent);

    public MatrixJobIntentService() {
        if (VERSION.SDK_INT >= 26) {
            this.Ee = null;
        } else {
            this.Ee = new ArrayList();
        }
    }

    public void onCreate() {
        super.onCreate();
        if (VERSION.SDK_INT >= 26) {
            this.bWz = new f(this);
            this.bWA = null;
            return;
        }
        this.bWz = null;
        this.bWA = a((Context) this, new ComponentName(this, getClass()), false, 0);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (this.Ee == null) {
            return 2;
        }
        this.bWA.zk();
        synchronized (this.Ee) {
            ArrayList arrayList = this.Ee;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new d(intent, i2));
            bb(true);
        }
        return 3;
    }

    public IBinder onBind(Intent intent) {
        if (this.bWz != null) {
            return this.bWz.zj();
        }
        return null;
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.Ee != null) {
            synchronized (this.Ee) {
                this.mDestroyed = true;
                this.bWA.zm();
            }
        }
    }

    public static void a(Context context, Class cls, int i, Intent intent) {
        a(context, new ComponentName(context, cls), i, intent);
    }

    private static void a(Context context, ComponentName componentName, int i, Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("work must not be null");
        }
        synchronized (sLock) {
            h a = a(context, componentName, true, i);
            a.fV(i);
            a.m(intent);
        }
    }

    private static h a(Context context, ComponentName componentName, boolean z, int i) {
        h hVar = (h) Ef.get(componentName);
        if (hVar == null) {
            if (VERSION.SDK_INT < 26) {
                hVar = new c(context, componentName);
            } else if (z) {
                hVar = new g(context, componentName, i);
            } else {
                throw new IllegalArgumentException("Can't be here without a job id");
            }
            Ef.put(componentName, hVar);
        }
        return hVar;
    }

    /* Access modifiers changed, original: final */
    @TargetApi(11)
    public final void bb(boolean z) {
        if (this.bWB == null) {
            this.bWB = new a();
            if (this.bWA != null && z) {
                this.bWA.zl();
            }
            this.bWB.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    /* Access modifiers changed, original: final */
    public final void zh() {
        if (this.Ee != null) {
            synchronized (this.Ee) {
                this.bWB = null;
                if (this.Ee != null && !this.Ee.isEmpty()) {
                    bb(false);
                } else if (!this.mDestroyed) {
                    this.bWA.zm();
                }
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final e zi() {
        if (this.bWz != null) {
            return this.bWz.zi();
        }
        if (this.Ee == null) {
            return null;
        }
        synchronized (this.Ee) {
            if (this.Ee == null || this.Ee.isEmpty()) {
                return null;
            }
            e eVar = (e) this.Ee.remove(0);
            return eVar;
        }
    }
}
