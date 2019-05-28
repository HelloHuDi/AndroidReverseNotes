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
import com.tencent.matrix.p157d.C1070c;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class MatrixJobIntentService extends Service {
    /* renamed from: Ef */
    static final HashMap<ComponentName, C1086h> f1216Ef = new HashMap();
    static final Object sLock = new Object();
    /* renamed from: Ed */
    boolean f1217Ed = false;
    /* renamed from: Ee */
    final ArrayList<C1088d> f1218Ee;
    C1086h bWA;
    C1083a bWB;
    C1084b bWz;
    boolean mDestroyed = false;
    boolean mStopped = false;

    /* renamed from: com.tencent.matrix.resource.MatrixJobIntentService$a */
    final class C1083a extends AsyncTask<Void, Void, Void> {
        C1083a() {
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onCancelled(Object obj) {
            MatrixJobIntentService.this.mo4295zh();
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            MatrixJobIntentService.this.mo4295zh();
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            while (true) {
                C1085e zi = MatrixJobIntentService.this.mo4296zi();
                if (zi == null) {
                    return null;
                }
                MatrixJobIntentService.this.mo4290l(zi.getIntent());
                zi.complete();
            }
        }
    }

    /* renamed from: com.tencent.matrix.resource.MatrixJobIntentService$b */
    interface C1084b {
        /* renamed from: zi */
        C1085e mo4280zi();

        /* renamed from: zj */
        IBinder mo4281zj();
    }

    /* renamed from: com.tencent.matrix.resource.MatrixJobIntentService$e */
    interface C1085e {
        void complete();

        Intent getIntent();
    }

    /* renamed from: com.tencent.matrix.resource.MatrixJobIntentService$h */
    static abstract class C1086h {
        boolean bWO;
        int bWP;
        final ComponentName mComponentName;

        /* renamed from: m */
        public abstract void mo4285m(Intent intent);

        C1086h(ComponentName componentName) {
            this.mComponentName = componentName;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: fV */
        public final void mo4284fV(int i) {
            if (!this.bWO) {
                this.bWO = true;
                this.bWP = i;
            } else if (this.bWP != i) {
                throw new IllegalArgumentException("Given job ID " + i + " is different than previous " + this.bWP);
            }
        }

        /* renamed from: zk */
        public void mo4286zk() {
        }

        /* renamed from: zl */
        public void mo4287zl() {
        }

        /* renamed from: zm */
        public void mo4288zm() {
        }
    }

    /* renamed from: com.tencent.matrix.resource.MatrixJobIntentService$c */
    static final class C1087c extends C1086h {
        private final WakeLock bWD;
        private final WakeLock bWE;
        boolean bWF;
        boolean bWG;
        private final Context mContext;

        C1087c(Context context, ComponentName componentName) {
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
            C1070c.m2370w("Matrix.JobIntentService", "it would be better to grant WAKE_LOCK permission to your app so that tinker can use WakeLock to keep system awake.", new Object[0]);
            this.bWE = null;
            this.bWD = null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: m */
        public final void mo4285m(Intent intent) {
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
                C1070c.printErrStackTrace("Matrix.JobIntentService", th, "Exception occurred.", new Object[0]);
            }
        }

        /* renamed from: zk */
        public final void mo4286zk() {
            synchronized (this) {
                this.bWF = false;
            }
        }

        /* renamed from: zl */
        public final void mo4287zl() {
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

        /* renamed from: zm */
        public final void mo4288zm() {
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

    /* renamed from: com.tencent.matrix.resource.MatrixJobIntentService$d */
    final class C1088d implements C1085e {
        final int bWH;
        final Intent mIntent;

        C1088d(Intent intent, int i) {
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

    /* renamed from: com.tencent.matrix.resource.MatrixJobIntentService$f */
    static final class C1089f extends JobServiceEngine implements C1084b {
        final MatrixJobIntentService bWI;
        JobParameters bWJ;
        final Object mLock = new Object();

        /* renamed from: com.tencent.matrix.resource.MatrixJobIntentService$f$a */
        final class C1090a implements C1085e {
            final JobWorkItem bWK;

            C1090a(JobWorkItem jobWorkItem) {
                this.bWK = jobWorkItem;
            }

            public final Intent getIntent() {
                return this.bWK.getIntent();
            }

            public final void complete() {
                synchronized (C1089f.this.mLock) {
                    if (C1089f.this.bWJ != null) {
                        C1089f.this.bWJ.completeWork(this.bWK);
                    }
                }
            }
        }

        C1089f(MatrixJobIntentService matrixJobIntentService) {
            super(matrixJobIntentService);
            this.bWI = matrixJobIntentService;
        }

        /* renamed from: zj */
        public final IBinder mo4281zj() {
            return getBinder();
        }

        public final boolean onStartJob(JobParameters jobParameters) {
            synchronized (this.mLock) {
                this.bWJ = jobParameters;
            }
            this.bWI.mo4289bb(false);
            return true;
        }

        public final boolean onStopJob(JobParameters jobParameters) {
            MatrixJobIntentService matrixJobIntentService = this.bWI;
            if (matrixJobIntentService.bWB != null) {
                matrixJobIntentService.bWB.cancel(matrixJobIntentService.f1217Ed);
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
            return new com.tencent.matrix.resource.MatrixJobIntentService.C1089f.C1090a(r6, r1);
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: zi */
        public final C1085e mo4280zi() {
            synchronized (this.mLock) {
                if (this.bWJ == null) {
                    return null;
                }
                try {
                    JobWorkItem dequeueWork = this.bWJ.dequeueWork();
                } catch (Throwable th) {
                    C1070c.printErrStackTrace("JobServiceEngineImpl", th, "exception occurred.", new Object[0]);
                    return null;
                }
            }
        }
    }

    /* renamed from: com.tencent.matrix.resource.MatrixJobIntentService$g */
    static final class C1091g extends C1086h {
        private final JobInfo bWM;
        private final JobScheduler bWN;

        C1091g(Context context, ComponentName componentName, int i) {
            super(componentName);
            mo4284fV(i);
            this.bWM = new Builder(i, this.mComponentName).setOverrideDeadline(0).build();
            this.bWN = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        /* Access modifiers changed, original: final */
        /* renamed from: m */
        public final void mo4285m(Intent intent) {
            this.bWN.enqueue(this.bWM, new JobWorkItem(intent));
        }
    }

    /* renamed from: l */
    public abstract void mo4290l(Intent intent);

    public MatrixJobIntentService() {
        if (VERSION.SDK_INT >= 26) {
            this.f1218Ee = null;
        } else {
            this.f1218Ee = new ArrayList();
        }
    }

    public void onCreate() {
        super.onCreate();
        if (VERSION.SDK_INT >= 26) {
            this.bWz = new C1089f(this);
            this.bWA = null;
            return;
        }
        this.bWz = null;
        this.bWA = m2394a((Context) this, new ComponentName(this, getClass()), false, 0);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (this.f1218Ee == null) {
            return 2;
        }
        this.bWA.mo4286zk();
        synchronized (this.f1218Ee) {
            ArrayList arrayList = this.f1218Ee;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new C1088d(intent, i2));
            mo4289bb(true);
        }
        return 3;
    }

    public IBinder onBind(Intent intent) {
        if (this.bWz != null) {
            return this.bWz.mo4281zj();
        }
        return null;
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.f1218Ee != null) {
            synchronized (this.f1218Ee) {
                this.mDestroyed = true;
                this.bWA.mo4288zm();
            }
        }
    }

    /* renamed from: a */
    public static void m2396a(Context context, Class cls, int i, Intent intent) {
        m2395a(context, new ComponentName(context, cls), i, intent);
    }

    /* renamed from: a */
    private static void m2395a(Context context, ComponentName componentName, int i, Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("work must not be null");
        }
        synchronized (sLock) {
            C1086h a = m2394a(context, componentName, true, i);
            a.mo4284fV(i);
            a.mo4285m(intent);
        }
    }

    /* renamed from: a */
    private static C1086h m2394a(Context context, ComponentName componentName, boolean z, int i) {
        C1086h c1086h = (C1086h) f1216Ef.get(componentName);
        if (c1086h == null) {
            if (VERSION.SDK_INT < 26) {
                c1086h = new C1087c(context, componentName);
            } else if (z) {
                c1086h = new C1091g(context, componentName, i);
            } else {
                throw new IllegalArgumentException("Can't be here without a job id");
            }
            f1216Ef.put(componentName, c1086h);
        }
        return c1086h;
    }

    /* Access modifiers changed, original: final */
    @TargetApi(11)
    /* renamed from: bb */
    public final void mo4289bb(boolean z) {
        if (this.bWB == null) {
            this.bWB = new C1083a();
            if (this.bWA != null && z) {
                this.bWA.mo4287zl();
            }
            this.bWB.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: zh */
    public final void mo4295zh() {
        if (this.f1218Ee != null) {
            synchronized (this.f1218Ee) {
                this.bWB = null;
                if (this.f1218Ee != null && !this.f1218Ee.isEmpty()) {
                    mo4289bb(false);
                } else if (!this.mDestroyed) {
                    this.bWA.mo4288zm();
                }
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: zi */
    public final C1085e mo4296zi() {
        if (this.bWz != null) {
            return this.bWz.mo4280zi();
        }
        if (this.f1218Ee == null) {
            return null;
        }
        synchronized (this.f1218Ee) {
            if (this.f1218Ee == null || this.f1218Ee.isEmpty()) {
                return null;
            }
            C1085e c1085e = (C1085e) this.f1218Ee.remove(0);
            return c1085e;
        }
    }
}
