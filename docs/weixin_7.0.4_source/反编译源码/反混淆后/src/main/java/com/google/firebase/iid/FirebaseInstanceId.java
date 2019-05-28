package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.C41642a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

public class FirebaseInstanceId {
    private static final long bvp = TimeUnit.HOURS.toSeconds(8);
    static C8748p bvq;
    @GuardedBy("FirebaseInstanceId.class")
    @VisibleForTesting
    private static ScheduledThreadPoolExecutor bvr;
    final C41642a bvs;
    final C32099f bvt;
    final C41649ae bvu;
    final C32100i bvv;
    @GuardedBy("this")
    private boolean bvw;
    @GuardedBy("this")
    private boolean bvx;

    static {
        AppMethodBeat.m2504i(108706);
        AppMethodBeat.m2505o(108706);
    }

    FirebaseInstanceId(C41642a c41642a) {
        this(c41642a, new C32099f(c41642a.getApplicationContext()));
        AppMethodBeat.m2504i(108690);
        AppMethodBeat.m2505o(108690);
    }

    private FirebaseInstanceId(C41642a c41642a, C32099f c32099f) {
        AppMethodBeat.m2504i(108691);
        this.bvv = new C32100i();
        this.bvw = false;
        if (C32099f.m52228b(c41642a) == null) {
            IllegalStateException illegalStateException = new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
            AppMethodBeat.m2505o(108691);
            throw illegalStateException;
        }
        synchronized (FirebaseInstanceId.class) {
            try {
                if (bvq == null) {
                    bvq = new C8748p(c41642a.getApplicationContext());
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(108691);
                }
            }
        }
        this.bvs = c41642a;
        this.bvt = c32099f;
        this.bvu = new C32095ab(c41642a, this, c32099f);
        this.bvx = m40570uJ();
        if (m40572uL()) {
            mo43237uE();
        }
        AppMethodBeat.m2505o(108691);
    }

    /* renamed from: a */
    static <T> T m40565a(Task<T> task) {
        IOException iOException;
        AppMethodBeat.m2504i(108699);
        try {
            Object await = Tasks.await(task);
            AppMethodBeat.m2505o(108699);
            return await;
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IOException) {
                iOException = (IOException) cause;
                AppMethodBeat.m2505o(108699);
                throw iOException;
            } else if (cause instanceof RuntimeException) {
                IOException iOException2 = new IOException(cause);
                AppMethodBeat.m2505o(108699);
                throw iOException2;
            } else {
                iOException = new IOException(e);
                AppMethodBeat.m2505o(108699);
                throw iOException;
            }
        } catch (InterruptedException e2) {
            iOException = new IOException("SERVICE_NOT_AVAILABLE");
            AppMethodBeat.m2505o(108699);
            throw iOException;
        }
    }

    /* renamed from: c */
    static void m40566c(Runnable runnable, long j) {
        AppMethodBeat.m2504i(108695);
        synchronized (FirebaseInstanceId.class) {
            try {
                if (bvr == null) {
                    bvr = new ScheduledThreadPoolExecutor(1);
                }
                bvr.schedule(runnable, j, TimeUnit.SECONDS);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(108695);
            }
        }
    }

    @Keep
    public static synchronized FirebaseInstanceId getInstance(C41642a c41642a) {
        FirebaseInstanceId firebaseInstanceId;
        synchronized (FirebaseInstanceId.class) {
            AppMethodBeat.m2504i(108689);
            firebaseInstanceId = (FirebaseInstanceId) c41642a.mo67041x(FirebaseInstanceId.class);
            AppMethodBeat.m2505o(108689);
        }
        return firebaseInstanceId;
    }

    /* renamed from: uD */
    public static FirebaseInstanceId m40567uD() {
        AppMethodBeat.m2504i(108688);
        FirebaseInstanceId instance = getInstance(C41642a.m73006ut());
        AppMethodBeat.m2505o(108688);
        return instance;
    }

    /* renamed from: uG */
    static C8748p m40568uG() {
        return bvq;
    }

    /* renamed from: uH */
    static boolean m40569uH() {
        AppMethodBeat.m2504i(108701);
        if (Log.isLoggable("FirebaseInstanceId", 3) || (VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3))) {
            AppMethodBeat.m2505o(108701);
            return true;
        }
        AppMethodBeat.m2505o(108701);
        return false;
    }

    /* renamed from: uJ */
    private final boolean m40570uJ() {
        AppMethodBeat.m2504i(108703);
        Context applicationContext = this.bvs.getApplicationContext();
        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("com.google.firebase.messaging", 0);
        boolean z;
        if (sharedPreferences.contains("auto_init")) {
            z = sharedPreferences.getBoolean("auto_init", true);
            AppMethodBeat.m2505o(108703);
            return z;
        }
        try {
            PackageManager packageManager = applicationContext.getPackageManager();
            if (packageManager != null) {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128);
                if (!(applicationInfo == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("firebase_messaging_auto_init_enabled"))) {
                    z = applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled");
                    AppMethodBeat.m2505o(108703);
                    return z;
                }
            }
        } catch (NameNotFoundException e) {
        }
        z = m40571uK();
        AppMethodBeat.m2505o(108703);
        return z;
    }

    /* renamed from: uK */
    private final boolean m40571uK() {
        AppMethodBeat.m2504i(108704);
        try {
            Class.forName("com.google.firebase.messaging.a");
            AppMethodBeat.m2505o(108704);
            return true;
        } catch (ClassNotFoundException e) {
            Context applicationContext = this.bvs.getApplicationContext();
            Intent intent = new Intent("com.google.firebase.MESSAGING_EVENT");
            intent.setPackage(applicationContext.getPackageName());
            ResolveInfo resolveService = applicationContext.getPackageManager().resolveService(intent, 0);
            if (resolveService == null || resolveService.serviceInfo == null) {
                AppMethodBeat.m2505o(108704);
                return false;
            }
            AppMethodBeat.m2505o(108704);
            return true;
        }
    }

    @VisibleForTesting
    /* renamed from: uL */
    private synchronized boolean m40572uL() {
        return this.bvx;
    }

    public final String getToken() {
        AppMethodBeat.m2504i(108697);
        C45074q uF = mo43238uF();
        if (uF == null || uF.mo72840bb(this.bvt.mo52664uO())) {
            startSync();
        }
        if (uF != null) {
            String str = uF.bwe;
            AppMethodBeat.m2505o(108697);
            return str;
        }
        AppMethodBeat.m2505o(108697);
        return null;
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void startSync() {
        AppMethodBeat.m2504i(108693);
        if (!this.bvw) {
            zza(0);
        }
        AppMethodBeat.m2505o(108693);
    }

    /* renamed from: uE */
    public final void mo43237uE() {
        AppMethodBeat.m2504i(108692);
        C45074q uF = mo43238uF();
        if (uF == null || uF.mo72840bb(this.bvt.mo52664uO()) || bvq.mo19770uT() != null) {
            startSync();
        }
        AppMethodBeat.m2505o(108692);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: uF */
    public final C45074q mo43238uF() {
        AppMethodBeat.m2504i(108698);
        C45074q d = bvq.mo19769d("", C32099f.m52228b(this.bvs), "*");
        AppMethodBeat.m2505o(108698);
        return d;
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    /* renamed from: uI */
    public final synchronized void mo43239uI() {
        AppMethodBeat.m2504i(108702);
        bvq.zzag();
        if (m40572uL()) {
            startSync();
        }
        AppMethodBeat.m2505o(108702);
    }

    @VisibleForTesting
    /* renamed from: uM */
    public final synchronized void mo43240uM() {
        AppMethodBeat.m2504i(108705);
        Editor edit = this.bvs.getApplicationContext().getSharedPreferences("com.google.firebase.messaging", 0).edit();
        edit.putBoolean("auto_init", true);
        edit.apply();
        if (!this.bvx) {
            mo43237uE();
        }
        this.bvx = true;
        AppMethodBeat.m2505o(108705);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void zza(long j) {
        AppMethodBeat.m2504i(108694);
        m40566c(new C41651r(this, this.bvt, Math.min(Math.max(30, j << 1), bvp)), j);
        this.bvw = true;
        AppMethodBeat.m2505o(108694);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void zza(boolean z) {
        this.bvw = z;
    }

    public static String zzf() {
        AppMethodBeat.m2504i(108696);
        String a = C32099f.m52226a(bvq.mo19766aY("").bwM);
        AppMethodBeat.m2505o(108696);
        return a;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final String mo43234b(String str, String str2, Bundle bundle) {
        AppMethodBeat.m2504i(108700);
        C32095ab c32095ab = (C32095ab) this.bvu;
        c32095ab.mo52657c(str, str2, bundle);
        String h = c32095ab.mo52658h(c32095ab.bwH.mo43246f(bundle));
        AppMethodBeat.m2505o(108700);
        return h;
    }
}
