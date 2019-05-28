package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.components.c;
import com.google.firebase.components.k;
import com.google.firebase.components.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.concurrent.GuardedBy;

public class a {
    private static final List<String> but = Arrays.asList(new String[]{"com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId"});
    private static final List<String> buu = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
    private static final List<String> buv = Arrays.asList(new String[]{"com.google.android.gms.measurement.AppMeasurement"});
    private static final List<String> buw = Arrays.asList(new String[0]);
    private static final Set<String> bux = Collections.emptySet();
    @GuardedBy("sLock")
    static final Map<String, a> buy = new android.support.v4.f.a();
    private static final Object sLock = new Object();
    private final b buA;
    private final n buB;
    private final AtomicBoolean buC = new AtomicBoolean(false);
    private final AtomicBoolean buD = new AtomicBoolean();
    private final List<Object> buE = new CopyOnWriteArrayList();
    private final List<Object> buF = new CopyOnWriteArrayList();
    private a buG;
    private final Context buz;
    private final String mName;
    private final List<Object> zzm = new CopyOnWriteArrayList();

    @TargetApi(24)
    static class b extends BroadcastReceiver {
        private static AtomicReference<b> buH = new AtomicReference();
        private final Context buz;

        static {
            AppMethodBeat.i(10576);
            AppMethodBeat.o(10576);
        }

        private b(Context context) {
            this.buz = context;
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(10574);
            synchronized (a.sLock) {
                try {
                    for (a a : a.buy.values()) {
                        a.a(a);
                    }
                } finally {
                    AppMethodBeat.o(10574);
                }
            }
            this.buz.unregisterReceiver(this);
        }

        static /* synthetic */ void al(Context context) {
            AppMethodBeat.i(10575);
            if (buH.get() == null) {
                b bVar = new b(context);
                if (buH.compareAndSet(null, bVar)) {
                    context.registerReceiver(bVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
            AppMethodBeat.o(10575);
        }
    }

    @KeepForSdk
    public interface a {
    }

    static {
        AppMethodBeat.i(10595);
        AppMethodBeat.o(10595);
    }

    private static a a(Context context, b bVar, String str) {
        Object context2;
        a aVar;
        AppMethodBeat.i(10585);
        com.google.firebase.b.b.uY();
        if (PlatformVersion.isAtLeastIceCreamSandwich() && (context2.getApplicationContext() instanceof Application)) {
            BackgroundDetector.initialize((Application) context2.getApplicationContext());
            BackgroundDetector.getInstance().addListener(new c());
        }
        String trim = str.trim();
        if (context2.getApplicationContext() != null) {
            context2 = context2.getApplicationContext();
        }
        synchronized (sLock) {
            try {
                Preconditions.checkState(!buy.containsKey(trim), new StringBuilder(String.valueOf(trim).length() + 33).append("FirebaseApp name ").append(trim).append(" already exists!").toString());
                Preconditions.checkNotNull(context2, "Application context cannot be null.");
                aVar = new a(context2, trim, bVar);
                buy.put(trim, aVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(10585);
            }
        }
        com.google.firebase.b.b.uZ();
        aVar.zzc();
        return aVar;
    }

    static /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(10594);
        aVar.zzc();
        AppMethodBeat.o(10594);
    }

    private static <T> void a(Class<T> cls, T t, Iterable<String> iterable, boolean z) {
        IllegalStateException illegalStateException;
        AppMethodBeat.i(10593);
        for (String str : iterable) {
            String str2;
            if (z) {
                try {
                    if (!buw.contains(str2)) {
                    }
                } catch (ClassNotFoundException e) {
                    if (bux.contains(str2)) {
                        illegalStateException = new IllegalStateException(String.valueOf(str2).concat(" is missing, but is required. Check if it has been removed by Proguard."));
                        AppMethodBeat.o(10593);
                        throw illegalStateException;
                    }
                    String.valueOf(str2).concat(" is not linked. Skipping initialization.");
                } catch (NoSuchMethodException e2) {
                    illegalStateException = new IllegalStateException(String.valueOf(str2).concat("#getInstance has been removed by Proguard. Add keep rule to prevent it."));
                    AppMethodBeat.o(10593);
                    throw illegalStateException;
                } catch (InvocationTargetException e3) {
                    Log.wtf("FirebaseApp", "Firebase API initialization failure.", e3);
                } catch (IllegalAccessException e4) {
                    String str3 = "FirebaseApp";
                    String str4 = "Failed to initialize ";
                    str2 = String.valueOf(str2);
                    Log.wtf(str3, str2.length() != 0 ? str4.concat(str2) : new String(str4), e4);
                }
            }
            Method method = Class.forName(str2).getMethod("getInstance", new Class[]{cls});
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
                method.invoke(null, new Object[]{t});
            }
        }
        AppMethodBeat.o(10593);
    }

    private String getName() {
        AppMethodBeat.i(10578);
        zza();
        String str = this.mName;
        AppMethodBeat.o(10578);
        return str;
    }

    public static a ut() {
        a aVar;
        AppMethodBeat.i(10583);
        synchronized (sLock) {
            try {
                aVar = (a) buy.get("[DEFAULT]");
                if (aVar == null) {
                    String myProcessName = ProcessUtils.getMyProcessName();
                    Object illegalStateException = new IllegalStateException(new StringBuilder(String.valueOf(myProcessName).length() + 116).append("Default FirebaseApp is not initialized in this process ").append(myProcessName).append(". Make sure to call FirebaseApp.initializeApp(Context) first.").toString());
                    throw illegalStateException;
                }
            } finally {
                AppMethodBeat.o(10583);
            }
        }
        AppMethodBeat.o(10583);
        return aVar;
    }

    @KeepForSdk
    public static void uu() {
        AppMethodBeat.i(10586);
        synchronized (sLock) {
            try {
                ArrayList arrayList = new ArrayList(buy.values());
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    a aVar = (a) obj;
                    if (aVar.buC.get()) {
                        aVar.uw();
                    }
                }
            } finally {
                AppMethodBeat.o(10586);
            }
        }
    }

    @KeepForSdk
    @VisibleForTesting
    private boolean uv() {
        AppMethodBeat.i(10590);
        boolean equals = "[DEFAULT]".equals(getName());
        AppMethodBeat.o(10590);
        return equals;
    }

    private final void uw() {
        AppMethodBeat.i(10591);
        Iterator it = this.zzm.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(10591);
    }

    private final void zza() {
        AppMethodBeat.i(10589);
        Preconditions.checkState(!this.buD.get(), "FirebaseApp was deleted");
        AppMethodBeat.o(10589);
    }

    private final void zzc() {
        AppMethodBeat.i(10592);
        boolean R = android.support.v4.content.b.R(this.buz);
        if (R) {
            b.al(this.buz);
        } else {
            this.buB.aS(uv());
        }
        a(a.class, this, but, R);
        if (uv()) {
            a(a.class, this, buu, R);
            a(Context.class, this.buz, buv, R);
        }
        AppMethodBeat.o(10592);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(10580);
        if (obj instanceof a) {
            boolean equals = this.mName.equals(((a) obj).getName());
            AppMethodBeat.o(10580);
            return equals;
        }
        AppMethodBeat.o(10580);
        return false;
    }

    public final Context getApplicationContext() {
        AppMethodBeat.i(10577);
        zza();
        Context context = this.buz;
        AppMethodBeat.o(10577);
        return context;
    }

    public int hashCode() {
        AppMethodBeat.i(10581);
        int hashCode = this.mName.hashCode();
        AppMethodBeat.o(10581);
        return hashCode;
    }

    public String toString() {
        AppMethodBeat.i(10582);
        String toStringHelper = Objects.toStringHelper(this).add("name", this.mName).add("options", this.buA).toString();
        AppMethodBeat.o(10582);
        return toStringHelper;
    }

    public final b us() {
        AppMethodBeat.i(10579);
        zza();
        b bVar = this.buA;
        AppMethodBeat.o(10579);
        return bVar;
    }

    public static a ak(Context context) {
        a ut;
        AppMethodBeat.i(10584);
        synchronized (sLock) {
            try {
                if (buy.containsKey("[DEFAULT]")) {
                    ut = ut();
                } else {
                    b am = b.am(context);
                    if (am == null) {
                        ut = null;
                        AppMethodBeat.o(10584);
                    } else {
                        ut = a(context, am, "[DEFAULT]");
                        AppMethodBeat.o(10584);
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(10584);
            }
        }
        return ut;
    }

    @KeepForSdk
    public final <T> T x(Class<T> cls) {
        AppMethodBeat.i(10587);
        zza();
        Object a = c.a(this.buB, cls);
        AppMethodBeat.o(10587);
        return a;
    }

    private a(Context context, String str, b bVar) {
        AppMethodBeat.i(10588);
        this.buz = (Context) Preconditions.checkNotNull(context);
        this.mName = Preconditions.checkNotEmpty(str);
        this.buA = (b) Preconditions.checkNotNull(bVar);
        this.buG = new com.google.firebase.b.a();
        k kVar = new k(this.buz);
        this.buB = new n(k.A(kVar.bvb.ao(kVar.mContext)), com.google.firebase.components.a.a(Context.class, this.buz), com.google.firebase.components.a.a(a.class, this), com.google.firebase.components.a.a(b.class, this.buA));
        AppMethodBeat.o(10588);
    }
}
