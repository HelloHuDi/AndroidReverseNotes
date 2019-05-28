package com.google.android.gms.stats;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.providers.PooledExecutorsProvider;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class WakeLock {
    private static ScheduledExecutorService zzaeg;
    private static Configuration zzaeh = new zza();
    private final android.os.PowerManager.WakeLock zzadv;
    private WorkSource zzadw;
    private String zzadx;
    private final int zzady;
    private final String zzadz;
    private final String zzaea;
    private final String zzaeb;
    private boolean zzaec;
    private final Map<String, Integer[]> zzaed;
    private int zzaee;
    private AtomicInteger zzaef;
    private final Context zzjp;

    public class HeldLock {
        private boolean zzaek;
        private Future zzael;
        private final String zzaem;

        private HeldLock(String str) {
            this.zzaek = true;
            this.zzaem = str;
        }

        /* synthetic */ HeldLock(WakeLock wakeLock, String str, zza zza) {
            this(str);
        }

        public void finalize() {
            AppMethodBeat.m2504i(113948);
            if (this.zzaek) {
                String str = "HeldLock finalized while still holding the WakeLock! Reason: ";
                String valueOf = String.valueOf(this.zzaem);
                if (valueOf.length() != 0) {
                    str.concat(valueOf);
                } else {
                    valueOf = new String(str);
                }
                release(0);
            }
            AppMethodBeat.m2505o(113948);
        }

        public void release() {
            AppMethodBeat.m2504i(113946);
            release(0);
            AppMethodBeat.m2505o(113946);
        }

        public synchronized void release(int i) {
            AppMethodBeat.m2504i(113947);
            if (this.zzaek) {
                this.zzaek = false;
                if (this.zzael != null) {
                    this.zzael.cancel(false);
                    this.zzael = null;
                }
                WakeLock.zza(WakeLock.this, this.zzaem, i);
                AppMethodBeat.m2505o(113947);
            } else {
                AppMethodBeat.m2505o(113947);
            }
        }
    }

    public interface Configuration {
        long getMaximumTimeout(String str, String str2);

        boolean isWorkChainsEnabled();
    }

    static {
        AppMethodBeat.m2504i(113975);
        AppMethodBeat.m2505o(113975);
    }

    public WakeLock(Context context, int i, @Nonnull String str) {
        this(context, i, str, null, context == null ? null : context.getPackageName());
        AppMethodBeat.m2504i(113949);
        AppMethodBeat.m2505o(113949);
    }

    public WakeLock(Context context, int i, @Nonnull String str, @Nullable String str2) {
        this(context, i, str, str2, context == null ? null : context.getPackageName());
        AppMethodBeat.m2504i(113950);
        AppMethodBeat.m2505o(113950);
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public WakeLock(Context context, int i, @Nonnull String str, @Nullable String str2, @Nonnull String str3) {
        this(context, i, str, str2, str3, null);
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public WakeLock(Context context, int i, @Nonnull String str, @Nullable String str2, @Nonnull String str3, @Nullable String str4) {
        AppMethodBeat.m2504i(113951);
        this.zzaec = true;
        this.zzaed = new HashMap();
        this.zzaef = new AtomicInteger(0);
        Preconditions.checkNotEmpty(str, "Wake lock name can NOT be empty");
        this.zzady = i;
        this.zzaea = str2;
        this.zzaeb = str4;
        this.zzjp = context.getApplicationContext();
        if ("com.google.android.gms".equals(context.getPackageName())) {
            this.zzadz = str;
        } else {
            String valueOf = String.valueOf("*gcore*:");
            String valueOf2 = String.valueOf(str);
            this.zzadz = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        }
        this.zzadv = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (WorkSourceUtil.hasWorkSourcePermission(context)) {
            Object str32;
            if (Strings.isEmptyOrWhitespace(str32)) {
                str32 = context.getPackageName();
            }
            if (!zzaeh.isWorkChainsEnabled() || str32 == null || str4 == null) {
                this.zzadw = WorkSourceUtil.fromPackage(context, str32);
            } else {
                new StringBuilder((String.valueOf(str32).length() + 42) + String.valueOf(str4).length()).append("Using experimental Pi WorkSource chains: ").append(str32).append(",").append(str4);
                this.zzadx = str32;
                this.zzadw = WorkSourceUtil.fromPackageAndModuleExperimentalPi(context, str32, str4);
            }
            addWorkSource(this.zzadw);
        }
        if (zzaeg == null) {
            zzaeg = PooledExecutorsProvider.getInstance().newSingleThreadScheduledExecutor();
        }
        AppMethodBeat.m2505o(113951);
    }

    public static void setConfiguration(Configuration configuration) {
        zzaeh = configuration;
    }

    private final void zza(WorkSource workSource) {
        AppMethodBeat.m2504i(113970);
        try {
            this.zzadv.setWorkSource(workSource);
            AppMethodBeat.m2505o(113970);
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            Log.wtf("WakeLock", e.toString());
            AppMethodBeat.m2505o(113970);
        }
    }

    static /* synthetic */ void zza(WakeLock wakeLock, String str, int i) {
        AppMethodBeat.m2504i(113974);
        wakeLock.zzc(str, i);
        AppMethodBeat.m2505o(113974);
    }

    /* JADX WARNING: Missing block: B:15:0x0046, code skipped:
            if (r0 == null) goto L_0x0048;
     */
    /* JADX WARNING: Missing block: B:19:0x004e, code skipped:
            if (r12.zzaee == 0) goto L_0x0050;
     */
    /* JADX WARNING: Missing block: B:20:0x0050, code skipped:
            com.google.android.gms.common.stats.WakeLockTracker.getInstance().registerEvent(r12.zzjp, com.google.android.gms.common.stats.StatsUtils.getEventKey(r12.zzadv, r6), 7, r12.zzadz, r6, r12.zzaeb, r12.zzady, zzdo(), r14);
            r12.zzaee++;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @SuppressLint({"WakelockTimeout"})
    private final void zza(String str, long j) {
        AppMethodBeat.m2504i(113957);
        String zzn = zzn(str);
        synchronized (this) {
            try {
                if ((!this.zzaed.isEmpty() || this.zzaee > 0) && !this.zzadv.isHeld()) {
                    this.zzaed.clear();
                    this.zzaee = 0;
                }
                if (this.zzaec) {
                    Integer[] numArr = (Integer[]) this.zzaed.get(zzn);
                    Object obj;
                    if (numArr == null) {
                        this.zzaed.put(zzn, new Integer[]{Integer.valueOf(1)});
                        obj = 1;
                    } else {
                        numArr[0] = Integer.valueOf(numArr[0].intValue() + 1);
                        obj = null;
                    }
                }
                if (!this.zzaec) {
                }
            } catch (Throwable th) {
                AppMethodBeat.m2505o(113957);
            }
        }
        this.zzadv.acquire();
        if (j > 0) {
            zzaeg.schedule(new zzb(this), j, TimeUnit.MILLISECONDS);
            if (!PlatformVersion.isAtLeastIceCreamSandwich() && this.zzaec) {
                String str2 = "WakeLock";
                String str3 = "Do not acquire with timeout on reference counted wakeLocks before ICS. wakelock: ";
                String valueOf = String.valueOf(this.zzadz);
                Log.wtf(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            }
        }
        AppMethodBeat.m2505o(113957);
    }

    private final void zzb(String str, int i) {
        AppMethodBeat.m2504i(113963);
        this.zzaef.decrementAndGet();
        zzc(str, i);
        AppMethodBeat.m2505o(113963);
    }

    /* JADX WARNING: Missing block: B:8:0x001c, code skipped:
            if (r0 == null) goto L_0x001e;
     */
    /* JADX WARNING: Missing block: B:12:0x0024, code skipped:
            if (r10.zzaee == 1) goto L_0x0026;
     */
    /* JADX WARNING: Missing block: B:13:0x0026, code skipped:
            com.google.android.gms.common.stats.WakeLockTracker.getInstance().registerEvent(r10.zzjp, com.google.android.gms.common.stats.StatsUtils.getEventKey(r10.zzadv, r5), 8, r10.zzadz, r5, r10.zzaeb, r10.zzady, zzdo());
            r10.zzaee--;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzc(String str, int i) {
        AppMethodBeat.m2504i(113964);
        String zzn = zzn(str);
        synchronized (this) {
            try {
                if (this.zzaec) {
                    Integer[] numArr = (Integer[]) this.zzaed.get(zzn);
                    Object obj;
                    if (numArr == null) {
                        obj = null;
                    } else if (numArr[0].intValue() == 1) {
                        this.zzaed.remove(zzn);
                        int obj2 = 1;
                    } else {
                        numArr[0] = Integer.valueOf(numArr[0].intValue() - 1);
                        obj2 = null;
                    }
                }
                if (!this.zzaec) {
                }
            } finally {
                AppMethodBeat.m2505o(113964);
            }
        }
        zzn(i);
    }

    private final List<String> zzdo() {
        AppMethodBeat.m2504i(113952);
        List names = WorkSourceUtil.getNames(this.zzadw);
        if (this.zzadx == null) {
            AppMethodBeat.m2505o(113952);
            return names;
        }
        ArrayList arrayList = new ArrayList(names);
        arrayList.add(this.zzadx);
        AppMethodBeat.m2505o(113952);
        return arrayList;
    }

    private final String zzn(String str) {
        AppMethodBeat.m2504i(113966);
        if (!this.zzaec) {
            str = this.zzaea;
            AppMethodBeat.m2505o(113966);
            return str;
        } else if (TextUtils.isEmpty(str)) {
            str = this.zzaea;
            AppMethodBeat.m2505o(113966);
            return str;
        } else {
            AppMethodBeat.m2505o(113966);
            return str;
        }
    }

    private final void zzn(int i) {
        AppMethodBeat.m2504i(113965);
        if (this.zzadv.isHeld()) {
            try {
                if (VERSION.SDK_INT < 21 || i <= 0) {
                    this.zzadv.release();
                    AppMethodBeat.m2505o(113965);
                    return;
                }
                this.zzadv.release(i);
                AppMethodBeat.m2505o(113965);
                return;
            } catch (RuntimeException e) {
                if (e.getClass().equals(RuntimeException.class)) {
                    String.valueOf(this.zzadz).concat(" was already released!");
                    AppMethodBeat.m2505o(113965);
                    return;
                }
                AppMethodBeat.m2505o(113965);
                throw e;
            }
        }
        AppMethodBeat.m2505o(113965);
    }

    public void acquire() {
        AppMethodBeat.m2504i(113953);
        this.zzaef.incrementAndGet();
        zza(null, 0);
        AppMethodBeat.m2505o(113953);
    }

    public void acquire(long j) {
        AppMethodBeat.m2504i(113954);
        this.zzaef.incrementAndGet();
        zza(null, j);
        AppMethodBeat.m2505o(113954);
    }

    public void acquire(String str) {
        AppMethodBeat.m2504i(113955);
        this.zzaef.incrementAndGet();
        zza(str, 0);
        AppMethodBeat.m2505o(113955);
    }

    public void acquire(String str, long j) {
        AppMethodBeat.m2504i(113956);
        this.zzaef.incrementAndGet();
        zza(str, j);
        AppMethodBeat.m2505o(113956);
    }

    public HeldLock acquireLock(long j, String str) {
        AppMethodBeat.m2504i(113958);
        long min = Math.min(j, zzaeh.getMaximumTimeout(this.zzadz, str));
        HeldLock heldLock = new HeldLock(this, str, null);
        zza(str, 0);
        heldLock.zzael = zzaeg.schedule(new zzc(new WeakReference(heldLock)), min, TimeUnit.MILLISECONDS);
        AppMethodBeat.m2505o(113958);
        return heldLock;
    }

    public void addWorkSource(WorkSource workSource) {
        AppMethodBeat.m2504i(113969);
        if (workSource != null && WorkSourceUtil.hasWorkSourcePermission(this.zzjp)) {
            if (this.zzadw != null) {
                this.zzadw.add(workSource);
            } else {
                this.zzadw = workSource;
            }
            zza(this.zzadw);
        }
        AppMethodBeat.m2505o(113969);
    }

    public android.os.PowerManager.WakeLock getWakeLock() {
        return this.zzadv;
    }

    public boolean isHeld() {
        AppMethodBeat.m2504i(113968);
        boolean isHeld = this.zzadv.isHeld();
        AppMethodBeat.m2505o(113968);
        return isHeld;
    }

    public void release() {
        AppMethodBeat.m2504i(113959);
        zzb(null, 0);
        AppMethodBeat.m2505o(113959);
    }

    public void release(int i) {
        AppMethodBeat.m2504i(113960);
        zzb(null, i);
        AppMethodBeat.m2505o(113960);
    }

    public void release(String str) {
        AppMethodBeat.m2504i(113961);
        zzb(str, 0);
        AppMethodBeat.m2505o(113961);
    }

    public void release(String str, int i) {
        AppMethodBeat.m2504i(113962);
        zzb(str, i);
        AppMethodBeat.m2505o(113962);
    }

    public void removeWorkSource(WorkSource workSource) {
        AppMethodBeat.m2504i(113971);
        if (workSource != null && WorkSourceUtil.hasWorkSourcePermission(this.zzjp)) {
            try {
                if (this.zzadw != null) {
                    this.zzadw.remove(workSource);
                }
                zza(this.zzadw);
                AppMethodBeat.m2505o(113971);
                return;
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
        AppMethodBeat.m2505o(113971);
    }

    public void setReferenceCounted(boolean z) {
        AppMethodBeat.m2504i(113967);
        this.zzadv.setReferenceCounted(z);
        this.zzaec = z;
        AppMethodBeat.m2505o(113967);
    }

    public void setWorkSource(WorkSource workSource) {
        AppMethodBeat.m2504i(113972);
        if (WorkSourceUtil.hasWorkSourcePermission(this.zzjp)) {
            zza(workSource);
            this.zzadw = workSource;
            this.zzadx = null;
        }
        AppMethodBeat.m2505o(113972);
    }
}
