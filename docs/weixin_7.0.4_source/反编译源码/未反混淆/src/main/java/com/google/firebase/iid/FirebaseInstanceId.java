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
import com.google.firebase.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

public class FirebaseInstanceId {
    private static final long bvp = TimeUnit.HOURS.toSeconds(8);
    static p bvq;
    @GuardedBy("FirebaseInstanceId.class")
    @VisibleForTesting
    private static ScheduledThreadPoolExecutor bvr;
    final a bvs;
    final f bvt;
    final ae bvu;
    final i bvv;
    @GuardedBy("this")
    private boolean bvw;
    @GuardedBy("this")
    private boolean bvx;

    static {
        AppMethodBeat.i(108706);
        AppMethodBeat.o(108706);
    }

    FirebaseInstanceId(a aVar) {
        this(aVar, new f(aVar.getApplicationContext()));
        AppMethodBeat.i(108690);
        AppMethodBeat.o(108690);
    }

    private FirebaseInstanceId(a aVar, f fVar) {
        AppMethodBeat.i(108691);
        this.bvv = new i();
        this.bvw = false;
        if (f.b(aVar) == null) {
            IllegalStateException illegalStateException = new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
            AppMethodBeat.o(108691);
            throw illegalStateException;
        }
        synchronized (FirebaseInstanceId.class) {
            try {
                if (bvq == null) {
                    bvq = new p(aVar.getApplicationContext());
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(108691);
                }
            }
        }
        this.bvs = aVar;
        this.bvt = fVar;
        this.bvu = new ab(aVar, this, fVar);
        this.bvx = uJ();
        if (uL()) {
            uE();
        }
        AppMethodBeat.o(108691);
    }

    static <T> T a(Task<T> task) {
        IOException iOException;
        AppMethodBeat.i(108699);
        try {
            Object await = Tasks.await(task);
            AppMethodBeat.o(108699);
            return await;
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IOException) {
                iOException = (IOException) cause;
                AppMethodBeat.o(108699);
                throw iOException;
            } else if (cause instanceof RuntimeException) {
                IOException iOException2 = new IOException(cause);
                AppMethodBeat.o(108699);
                throw iOException2;
            } else {
                iOException = new IOException(e);
                AppMethodBeat.o(108699);
                throw iOException;
            }
        } catch (InterruptedException e2) {
            iOException = new IOException("SERVICE_NOT_AVAILABLE");
            AppMethodBeat.o(108699);
            throw iOException;
        }
    }

    static void c(Runnable runnable, long j) {
        AppMethodBeat.i(108695);
        synchronized (FirebaseInstanceId.class) {
            try {
                if (bvr == null) {
                    bvr = new ScheduledThreadPoolExecutor(1);
                }
                bvr.schedule(runnable, j, TimeUnit.SECONDS);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(108695);
            }
        }
    }

    @Keep
    public static synchronized FirebaseInstanceId getInstance(a aVar) {
        FirebaseInstanceId firebaseInstanceId;
        synchronized (FirebaseInstanceId.class) {
            AppMethodBeat.i(108689);
            firebaseInstanceId = (FirebaseInstanceId) aVar.x(FirebaseInstanceId.class);
            AppMethodBeat.o(108689);
        }
        return firebaseInstanceId;
    }

    public static FirebaseInstanceId uD() {
        AppMethodBeat.i(108688);
        FirebaseInstanceId instance = getInstance(a.ut());
        AppMethodBeat.o(108688);
        return instance;
    }

    static p uG() {
        return bvq;
    }

    static boolean uH() {
        AppMethodBeat.i(108701);
        if (Log.isLoggable("FirebaseInstanceId", 3) || (VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3))) {
            AppMethodBeat.o(108701);
            return true;
        }
        AppMethodBeat.o(108701);
        return false;
    }

    private final boolean uJ() {
        AppMethodBeat.i(108703);
        Context applicationContext = this.bvs.getApplicationContext();
        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("com.google.firebase.messaging", 0);
        boolean z;
        if (sharedPreferences.contains("auto_init")) {
            z = sharedPreferences.getBoolean("auto_init", true);
            AppMethodBeat.o(108703);
            return z;
        }
        try {
            PackageManager packageManager = applicationContext.getPackageManager();
            if (packageManager != null) {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128);
                if (!(applicationInfo == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("firebase_messaging_auto_init_enabled"))) {
                    z = applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled");
                    AppMethodBeat.o(108703);
                    return z;
                }
            }
        } catch (NameNotFoundException e) {
        }
        z = uK();
        AppMethodBeat.o(108703);
        return z;
    }

    private final boolean uK() {
        AppMethodBeat.i(108704);
        try {
            Class.forName("com.google.firebase.messaging.a");
            AppMethodBeat.o(108704);
            return true;
        } catch (ClassNotFoundException e) {
            Context applicationContext = this.bvs.getApplicationContext();
            Intent intent = new Intent("com.google.firebase.MESSAGING_EVENT");
            intent.setPackage(applicationContext.getPackageName());
            ResolveInfo resolveService = applicationContext.getPackageManager().resolveService(intent, 0);
            if (resolveService == null || resolveService.serviceInfo == null) {
                AppMethodBeat.o(108704);
                return false;
            }
            AppMethodBeat.o(108704);
            return true;
        }
    }

    @VisibleForTesting
    private synchronized boolean uL() {
        return this.bvx;
    }

    public final String getToken() {
        AppMethodBeat.i(108697);
        q uF = uF();
        if (uF == null || uF.bb(this.bvt.uO())) {
            startSync();
        }
        if (uF != null) {
            String str = uF.bwe;
            AppMethodBeat.o(108697);
            return str;
        }
        AppMethodBeat.o(108697);
        return null;
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void startSync() {
        AppMethodBeat.i(108693);
        if (!this.bvw) {
            zza(0);
        }
        AppMethodBeat.o(108693);
    }

    public final void uE() {
        AppMethodBeat.i(108692);
        q uF = uF();
        if (uF == null || uF.bb(this.bvt.uO()) || bvq.uT() != null) {
            startSync();
        }
        AppMethodBeat.o(108692);
    }

    /* Access modifiers changed, original: final */
    public final q uF() {
        AppMethodBeat.i(108698);
        q d = bvq.d("", f.b(this.bvs), "*");
        AppMethodBeat.o(108698);
        return d;
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void uI() {
        AppMethodBeat.i(108702);
        bvq.zzag();
        if (uL()) {
            startSync();
        }
        AppMethodBeat.o(108702);
    }

    @VisibleForTesting
    public final synchronized void uM() {
        AppMethodBeat.i(108705);
        Editor edit = this.bvs.getApplicationContext().getSharedPreferences("com.google.firebase.messaging", 0).edit();
        edit.putBoolean("auto_init", true);
        edit.apply();
        if (!this.bvx) {
            uE();
        }
        this.bvx = true;
        AppMethodBeat.o(108705);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void zza(long j) {
        AppMethodBeat.i(108694);
        c(new r(this, this.bvt, Math.min(Math.max(30, j << 1), bvp)), j);
        this.bvw = true;
        AppMethodBeat.o(108694);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void zza(boolean z) {
        this.bvw = z;
    }

    public static String zzf() {
        AppMethodBeat.i(108696);
        String a = f.a(bvq.aY("").bwM);
        AppMethodBeat.o(108696);
        return a;
    }

    /* Access modifiers changed, original: final */
    public final String b(String str, String str2, Bundle bundle) {
        AppMethodBeat.i(108700);
        ab abVar = (ab) this.bvu;
        abVar.c(str, str2, bundle);
        String h = abVar.h(abVar.bwH.f(bundle));
        AppMethodBeat.o(108700);
        return h;
    }
}
