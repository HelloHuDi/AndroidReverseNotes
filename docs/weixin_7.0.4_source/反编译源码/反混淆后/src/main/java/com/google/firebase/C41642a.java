package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.p057v4.content.C0380b;
import android.support.p057v4.p065f.C6197a;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.components.C41645a;
import com.google.firebase.components.C41646c;
import com.google.firebase.components.C45070k;
import com.google.firebase.components.C8744n;
import com.google.firebase.p1522b.C37301b;
import com.google.firebase.p1522b.C45067a;
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

/* renamed from: com.google.firebase.a */
public class C41642a {
    private static final List<String> but = Arrays.asList(new String[]{"com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId"});
    private static final List<String> buu = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
    private static final List<String> buv = Arrays.asList(new String[]{"com.google.android.gms.measurement.AppMeasurement"});
    private static final List<String> buw = Arrays.asList(new String[0]);
    private static final Set<String> bux = Collections.emptySet();
    @GuardedBy("sLock")
    static final Map<String, C41642a> buy = new C6197a();
    private static final Object sLock = new Object();
    private final C41644b buA;
    private final C8744n buB;
    private final AtomicBoolean buC = new AtomicBoolean(false);
    private final AtomicBoolean buD = new AtomicBoolean();
    private final List<Object> buE = new CopyOnWriteArrayList();
    private final List<Object> buF = new CopyOnWriteArrayList();
    private C25578a buG;
    private final Context buz;
    private final String mName;
    private final List<Object> zzm = new CopyOnWriteArrayList();

    @TargetApi(24)
    /* renamed from: com.google.firebase.a$b */
    static class C17703b extends BroadcastReceiver {
        private static AtomicReference<C17703b> buH = new AtomicReference();
        private final Context buz;

        static {
            AppMethodBeat.m2504i(10576);
            AppMethodBeat.m2505o(10576);
        }

        private C17703b(Context context) {
            this.buz = context;
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(10574);
            synchronized (C41642a.sLock) {
                try {
                    for (C41642a a : C41642a.buy.values()) {
                        C41642a.m73003a(a);
                    }
                } finally {
                    AppMethodBeat.m2505o(10574);
                }
            }
            this.buz.unregisterReceiver(this);
        }

        /* renamed from: al */
        static /* synthetic */ void m27629al(Context context) {
            AppMethodBeat.m2504i(10575);
            if (buH.get() == null) {
                C17703b c17703b = new C17703b(context);
                if (buH.compareAndSet(null, c17703b)) {
                    context.registerReceiver(c17703b, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
            AppMethodBeat.m2505o(10575);
        }
    }

    @KeepForSdk
    /* renamed from: com.google.firebase.a$a */
    public interface C25578a {
    }

    static {
        AppMethodBeat.m2504i(10595);
        AppMethodBeat.m2505o(10595);
    }

    /* renamed from: a */
    private static C41642a m73002a(Context context, C41644b c41644b, String str) {
        Object context2;
        C41642a c41642a;
        AppMethodBeat.m2504i(10585);
        C37301b.m62703uY();
        if (PlatformVersion.isAtLeastIceCreamSandwich() && (context2.getApplicationContext() instanceof Application)) {
            BackgroundDetector.initialize((Application) context2.getApplicationContext());
            BackgroundDetector.getInstance().addListener(new C45068c());
        }
        String trim = str.trim();
        if (context2.getApplicationContext() != null) {
            context2 = context2.getApplicationContext();
        }
        synchronized (sLock) {
            try {
                Preconditions.checkState(!buy.containsKey(trim), new StringBuilder(String.valueOf(trim).length() + 33).append("FirebaseApp name ").append(trim).append(" already exists!").toString());
                Preconditions.checkNotNull(context2, "Application context cannot be null.");
                c41642a = new C41642a(context2, trim, c41644b);
                buy.put(trim, c41642a);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(10585);
            }
        }
        C37301b.m62704uZ();
        c41642a.zzc();
        return c41642a;
    }

    /* renamed from: a */
    static /* synthetic */ void m73003a(C41642a c41642a) {
        AppMethodBeat.m2504i(10594);
        c41642a.zzc();
        AppMethodBeat.m2505o(10594);
    }

    /* renamed from: a */
    private static <T> void m73004a(Class<T> cls, T t, Iterable<String> iterable, boolean z) {
        IllegalStateException illegalStateException;
        AppMethodBeat.m2504i(10593);
        for (String str : iterable) {
            String str2;
            if (z) {
                try {
                    if (!buw.contains(str2)) {
                    }
                } catch (ClassNotFoundException e) {
                    if (bux.contains(str2)) {
                        illegalStateException = new IllegalStateException(String.valueOf(str2).concat(" is missing, but is required. Check if it has been removed by Proguard."));
                        AppMethodBeat.m2505o(10593);
                        throw illegalStateException;
                    }
                    String.valueOf(str2).concat(" is not linked. Skipping initialization.");
                } catch (NoSuchMethodException e2) {
                    illegalStateException = new IllegalStateException(String.valueOf(str2).concat("#getInstance has been removed by Proguard. Add keep rule to prevent it."));
                    AppMethodBeat.m2505o(10593);
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
        AppMethodBeat.m2505o(10593);
    }

    private String getName() {
        AppMethodBeat.m2504i(10578);
        zza();
        String str = this.mName;
        AppMethodBeat.m2505o(10578);
        return str;
    }

    /* renamed from: ut */
    public static C41642a m73006ut() {
        C41642a c41642a;
        AppMethodBeat.m2504i(10583);
        synchronized (sLock) {
            try {
                c41642a = (C41642a) buy.get("[DEFAULT]");
                if (c41642a == null) {
                    String myProcessName = ProcessUtils.getMyProcessName();
                    Object illegalStateException = new IllegalStateException(new StringBuilder(String.valueOf(myProcessName).length() + 116).append("Default FirebaseApp is not initialized in this process ").append(myProcessName).append(". Make sure to call FirebaseApp.initializeApp(Context) first.").toString());
                    throw illegalStateException;
                }
            } finally {
                AppMethodBeat.m2505o(10583);
            }
        }
        AppMethodBeat.m2505o(10583);
        return c41642a;
    }

    @KeepForSdk
    /* renamed from: uu */
    public static void m73007uu() {
        AppMethodBeat.m2504i(10586);
        synchronized (sLock) {
            try {
                ArrayList arrayList = new ArrayList(buy.values());
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    C41642a c41642a = (C41642a) obj;
                    if (c41642a.buC.get()) {
                        c41642a.m73009uw();
                    }
                }
            } finally {
                AppMethodBeat.m2505o(10586);
            }
        }
    }

    @KeepForSdk
    @VisibleForTesting
    /* renamed from: uv */
    private boolean m73008uv() {
        AppMethodBeat.m2504i(10590);
        boolean equals = "[DEFAULT]".equals(getName());
        AppMethodBeat.m2505o(10590);
        return equals;
    }

    /* renamed from: uw */
    private final void m73009uw() {
        AppMethodBeat.m2504i(10591);
        Iterator it = this.zzm.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.m2505o(10591);
    }

    private final void zza() {
        AppMethodBeat.m2504i(10589);
        Preconditions.checkState(!this.buD.get(), "FirebaseApp was deleted");
        AppMethodBeat.m2505o(10589);
    }

    private final void zzc() {
        AppMethodBeat.m2504i(10592);
        boolean R = C0380b.m647R(this.buz);
        if (R) {
            C17703b.m27629al(this.buz);
        } else {
            this.buB.mo19761aS(m73008uv());
        }
        C41642a.m73004a(C41642a.class, this, but, R);
        if (m73008uv()) {
            C41642a.m73004a(C41642a.class, this, buu, R);
            C41642a.m73004a(Context.class, this.buz, buv, R);
        }
        AppMethodBeat.m2505o(10592);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(10580);
        if (obj instanceof C41642a) {
            boolean equals = this.mName.equals(((C41642a) obj).getName());
            AppMethodBeat.m2505o(10580);
            return equals;
        }
        AppMethodBeat.m2505o(10580);
        return false;
    }

    public final Context getApplicationContext() {
        AppMethodBeat.m2504i(10577);
        zza();
        Context context = this.buz;
        AppMethodBeat.m2505o(10577);
        return context;
    }

    public int hashCode() {
        AppMethodBeat.m2504i(10581);
        int hashCode = this.mName.hashCode();
        AppMethodBeat.m2505o(10581);
        return hashCode;
    }

    public String toString() {
        AppMethodBeat.m2504i(10582);
        String toStringHelper = Objects.toStringHelper(this).add("name", this.mName).add("options", this.buA).toString();
        AppMethodBeat.m2505o(10582);
        return toStringHelper;
    }

    /* renamed from: us */
    public final C41644b mo67040us() {
        AppMethodBeat.m2504i(10579);
        zza();
        C41644b c41644b = this.buA;
        AppMethodBeat.m2505o(10579);
        return c41644b;
    }

    /* renamed from: ak */
    public static C41642a m73005ak(Context context) {
        C41642a ut;
        AppMethodBeat.m2504i(10584);
        synchronized (sLock) {
            try {
                if (buy.containsKey("[DEFAULT]")) {
                    ut = C41642a.m73006ut();
                } else {
                    C41644b am = C41644b.m73013am(context);
                    if (am == null) {
                        ut = null;
                        AppMethodBeat.m2505o(10584);
                    } else {
                        ut = C41642a.m73002a(context, am, "[DEFAULT]");
                        AppMethodBeat.m2505o(10584);
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(10584);
            }
        }
        return ut;
    }

    @KeepForSdk
    /* renamed from: x */
    public final <T> T mo67041x(Class<T> cls) {
        AppMethodBeat.m2504i(10587);
        zza();
        Object a = C41646c.m73018a(this.buB, cls);
        AppMethodBeat.m2505o(10587);
        return a;
    }

    private C41642a(Context context, String str, C41644b c41644b) {
        AppMethodBeat.m2504i(10588);
        this.buz = (Context) Preconditions.checkNotNull(context);
        this.mName = Preconditions.checkNotEmpty(str);
        this.buA = (C41644b) Preconditions.checkNotNull(c41644b);
        this.buG = new C45067a();
        C45070k c45070k = new C45070k(this.buz);
        this.buB = new C8744n(C45070k.m82695A(c45070k.bvb.mo59989ao(c45070k.mContext)), C41645a.m73014a(Context.class, this.buz), C41645a.m73014a(C41642a.class, this), C41645a.m73014a(C41644b.class, this.buA));
        AppMethodBeat.m2505o(10588);
    }
}
