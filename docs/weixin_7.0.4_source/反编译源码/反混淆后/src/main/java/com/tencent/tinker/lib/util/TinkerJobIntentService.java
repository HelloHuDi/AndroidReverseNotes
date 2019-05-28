package com.tencent.tinker.lib.util;

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

public abstract class TinkerJobIntentService extends Service {
    /* renamed from: Ef */
    static final HashMap<ComponentName, C5950h> f1678Ef = new HashMap();
    static final Object sLock = new Object();
    C5947b ACd;
    C5950h ACe;
    C5949a ACf;
    /* renamed from: Ed */
    boolean f1679Ed = false;
    /* renamed from: Ee */
    final ArrayList<C5944d> f1680Ee;
    boolean mDestroyed = false;
    boolean mStopped = false;

    /* renamed from: com.tencent.tinker.lib.util.TinkerJobIntentService$e */
    interface C5942e {
        void complete();

        Intent getIntent();
    }

    /* renamed from: com.tencent.tinker.lib.util.TinkerJobIntentService$g */
    static final class C5943g extends C5950h {
        private final JobInfo bWM;
        private final JobScheduler bWN;

        C5943g(Context context, ComponentName componentName, int i) {
            super(componentName);
            mo12650fV(i);
            this.bWM = new Builder(i, this.mComponentName).setOverrideDeadline(0).build();
            this.bWN = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        /* Access modifiers changed, original: final */
        /* renamed from: m */
        public final void mo12639m(Intent intent) {
            this.bWN.enqueue(this.bWM, new JobWorkItem(intent));
        }
    }

    /* renamed from: com.tencent.tinker.lib.util.TinkerJobIntentService$d */
    final class C5944d implements C5942e {
        final int bWH;
        final Intent mIntent;

        C5944d(Intent intent, int i) {
            this.mIntent = intent;
            this.bWH = i;
        }

        public final Intent getIntent() {
            return this.mIntent;
        }

        public final void complete() {
            TinkerJobIntentService.this.stopSelf(this.bWH);
        }
    }

    /* renamed from: com.tencent.tinker.lib.util.TinkerJobIntentService$f */
    static final class C5945f extends JobServiceEngine implements C5947b {
        final TinkerJobIntentService ACh;
        JobParameters bWJ;
        final Object mLock = new Object();

        /* renamed from: com.tencent.tinker.lib.util.TinkerJobIntentService$f$a */
        final class C5946a implements C5942e {
            final JobWorkItem bWK;

            C5946a(JobWorkItem jobWorkItem) {
                this.bWK = jobWorkItem;
            }

            public final Intent getIntent() {
                return this.bWK.getIntent();
            }

            public final void complete() {
                synchronized (C5945f.this.mLock) {
                    if (C5945f.this.bWJ != null) {
                        C5945f.this.bWJ.completeWork(this.bWK);
                    }
                }
            }
        }

        C5945f(TinkerJobIntentService tinkerJobIntentService) {
            super(tinkerJobIntentService);
            this.ACh = tinkerJobIntentService;
        }

        /* renamed from: zj */
        public final IBinder mo12643zj() {
            return getBinder();
        }

        public final boolean onStartJob(JobParameters jobParameters) {
            this.bWJ = jobParameters;
            this.ACh.mo12629bb(false);
            return true;
        }

        public final boolean onStopJob(JobParameters jobParameters) {
            TinkerJobIntentService tinkerJobIntentService = this.ACh;
            if (tinkerJobIntentService.ACf != null) {
                tinkerJobIntentService.ACf.cancel(tinkerJobIntentService.f1679Ed);
            }
            tinkerJobIntentService.mStopped = true;
            synchronized (this.mLock) {
                this.bWJ = null;
            }
            return true;
        }

        /* JADX WARNING: Missing block: B:8:0x0011, code skipped:
            if (r2 == null) goto L_?;
     */
        /* JADX WARNING: Missing block: B:9:0x0013, code skipped:
            r2.getIntent().setExtrasClassLoader(r3.ACh.getClassLoader());
     */
        /* JADX WARNING: Missing block: B:18:?, code skipped:
            return null;
     */
        /* JADX WARNING: Missing block: B:19:?, code skipped:
            return new com.tencent.tinker.lib.util.TinkerJobIntentService.C5945f.C5946a(r3, r2);
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final C5942e dSi() {
            synchronized (this.mLock) {
                if (this.bWJ == null) {
                    return null;
                }
                JobWorkItem dequeueWork = this.bWJ.dequeueWork();
            }
        }
    }

    /* renamed from: com.tencent.tinker.lib.util.TinkerJobIntentService$b */
    interface C5947b {
        C5942e dSi();

        /* renamed from: zj */
        IBinder mo12643zj();
    }

    /* renamed from: com.tencent.tinker.lib.util.TinkerJobIntentService$c */
    static final class C5948c extends C5950h {
        private final WakeLock bWD;
        private final WakeLock bWE;
        boolean bWF;
        boolean bWG;
        private final Context mContext;

        C5948c(Context context, ComponentName componentName) {
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
            C5952a.m9285w("TinkerJobIntentService", "it would be better to grant WAKE_LOCK permission to your app so that tinker can use WakeLock to keep system awake.", new Object[0]);
            this.bWE = null;
            this.bWD = null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: m */
        public final void mo12639m(Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(this.mComponentName);
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
        }

        /* renamed from: zk */
        public final void mo12644zk() {
            synchronized (this) {
                this.bWF = false;
            }
        }

        /* renamed from: zl */
        public final void mo12645zl() {
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
        public final void mo12646zm() {
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

    /* renamed from: com.tencent.tinker.lib.util.TinkerJobIntentService$a */
    final class C5949a extends AsyncTask<Void, Void, Void> {
        C5949a() {
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onCancelled(Object obj) {
            TinkerJobIntentService.this.mo12636zh();
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            TinkerJobIntentService.this.mo12636zh();
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            while (true) {
                C5942e dSi = TinkerJobIntentService.this.dSi();
                if (dSi == null) {
                    return null;
                }
                TinkerJobIntentService.this.mo12631l(dSi.getIntent());
                dSi.complete();
            }
        }
    }

    /* renamed from: com.tencent.tinker.lib.util.TinkerJobIntentService$h */
    static abstract class C5950h {
        boolean bWO;
        int bWP;
        final ComponentName mComponentName;

        /* renamed from: m */
        public abstract void mo12639m(Intent intent);

        C5950h(ComponentName componentName) {
            this.mComponentName = componentName;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: fV */
        public final void mo12650fV(int i) {
            if (!this.bWO) {
                this.bWO = true;
                this.bWP = i;
            } else if (this.bWP != i) {
                throw new IllegalArgumentException("Given job ID " + i + " is different than previous " + this.bWP);
            }
        }

        /* renamed from: zk */
        public void mo12644zk() {
        }

        /* renamed from: zl */
        public void mo12645zl() {
        }

        /* renamed from: zm */
        public void mo12646zm() {
        }
    }

    /* renamed from: l */
    public abstract void mo12631l(Intent intent);

    public TinkerJobIntentService() {
        if (VERSION.SDK_INT >= 26) {
            this.f1680Ee = null;
        } else {
            this.f1680Ee = new ArrayList();
        }
    }

    public void onCreate() {
        super.onCreate();
        if (VERSION.SDK_INT >= 26) {
            this.ACd = new C5945f(this);
            this.ACe = null;
            return;
        }
        this.ACd = null;
        this.ACe = m9263b(this, new ComponentName(this, getClass()), false, 0);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (this.f1680Ee == null) {
            return 2;
        }
        this.ACe.mo12644zk();
        synchronized (this.f1680Ee) {
            ArrayList arrayList = this.f1680Ee;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new C5944d(intent, i2));
            mo12629bb(true);
        }
        return 3;
    }

    public IBinder onBind(Intent intent) {
        if (this.ACd != null) {
            return this.ACd.mo12643zj();
        }
        return null;
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.f1680Ee != null) {
            synchronized (this.f1680Ee) {
                this.mDestroyed = true;
                this.ACe.mo12646zm();
            }
        }
    }

    /* renamed from: a */
    public static void m9262a(Context context, ComponentName componentName, int i, Intent intent) {
        synchronized (sLock) {
            C5950h b = m9263b(context, componentName, true, i);
            b.mo12650fV(i);
            b.mo12639m(intent);
        }
    }

    /* renamed from: b */
    private static C5950h m9263b(Context context, ComponentName componentName, boolean z, int i) {
        C5950h c5950h = (C5950h) f1678Ef.get(componentName);
        if (c5950h == null) {
            if (VERSION.SDK_INT < 26) {
                c5950h = new C5948c(context, componentName);
            } else if (z) {
                c5950h = new C5943g(context, componentName, i);
            } else {
                throw new IllegalArgumentException("Can't be here without a job id");
            }
            f1678Ef.put(componentName, c5950h);
        }
        return c5950h;
    }

    /* Access modifiers changed, original: final */
    @TargetApi(11)
    /* renamed from: bb */
    public final void mo12629bb(boolean z) {
        if (this.ACf == null) {
            this.ACf = new C5949a();
            if (this.ACe != null && z) {
                this.ACe.mo12645zl();
            }
            this.ACf.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: zh */
    public final void mo12636zh() {
        if (this.f1680Ee != null) {
            synchronized (this.f1680Ee) {
                this.ACf = null;
                if (this.f1680Ee != null && this.f1680Ee.size() > 0) {
                    mo12629bb(false);
                } else if (!this.mDestroyed) {
                    this.ACe.mo12646zm();
                }
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final C5942e dSi() {
        if (this.ACd != null) {
            return this.ACd.dSi();
        }
        synchronized (this.f1680Ee) {
            if (this.f1680Ee.size() > 0) {
                C5942e c5942e = (C5942e) this.f1680Ee.remove(0);
                return c5942e;
            }
            return null;
        }
    }
}
