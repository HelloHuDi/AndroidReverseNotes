package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.RemoteException;
import android.os.SystemClock;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.BlockingServiceConnection;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads_identifier.zze;
import com.google.android.gms.internal.ads_identifier.zzf;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
@ParametersAreNonnullByDefault
public class AdvertisingIdClient {
    @GuardedBy("this")
    private final Context mContext;
    @GuardedBy("this")
    private BlockingServiceConnection zze;
    @GuardedBy("this")
    private zze zzf;
    @GuardedBy("this")
    private boolean zzg;
    private final Object zzh;
    @GuardedBy("mAutoDisconnectTaskLock")
    private zza zzi;
    private final boolean zzj;
    private final long zzk;

    @VisibleForTesting
    static class zza extends Thread {
        private WeakReference<AdvertisingIdClient> zzm;
        private long zzn;
        CountDownLatch zzo = new CountDownLatch(1);
        boolean zzp = false;

        public zza(AdvertisingIdClient advertisingIdClient, long j) {
            AppMethodBeat.i(115323);
            this.zzm = new WeakReference(advertisingIdClient);
            this.zzn = j;
            start();
            AppMethodBeat.o(115323);
        }

        private final void disconnect() {
            AppMethodBeat.i(115324);
            AdvertisingIdClient advertisingIdClient = (AdvertisingIdClient) this.zzm.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.finish();
                this.zzp = true;
            }
            AppMethodBeat.o(115324);
        }

        public final void run() {
            AppMethodBeat.i(115325);
            try {
                if (!this.zzo.await(this.zzn, TimeUnit.MILLISECONDS)) {
                    disconnect();
                }
                AppMethodBeat.o(115325);
            } catch (InterruptedException e) {
                disconnect();
                AppMethodBeat.o(115325);
            }
        }
    }

    @KeepForSdkWithMembers
    public static final class Info {
        private final String zzq;
        private final boolean zzr;

        public Info(String str, boolean z) {
            this.zzq = str;
            this.zzr = z;
        }

        public final String getId() {
            return this.zzq;
        }

        public final boolean isLimitAdTrackingEnabled() {
            return this.zzr;
        }

        public final String toString() {
            AppMethodBeat.i(115322);
            String str = this.zzq;
            str = new StringBuilder(String.valueOf(str).length() + 7).append("{").append(str).append("}").append(this.zzr).toString();
            AppMethodBeat.o(115322);
            return str;
        }
    }

    @KeepForSdk
    public AdvertisingIdClient(Context context) {
        this(context, 30000, false, false);
    }

    @VisibleForTesting
    private AdvertisingIdClient(Context context, long j, boolean z, boolean z2) {
        AppMethodBeat.i(115326);
        this.zzh = new Object();
        Preconditions.checkNotNull(context);
        if (z) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            this.mContext = context;
        } else {
            this.mContext = context;
        }
        this.zzg = false;
        this.zzk = j;
        this.zzj = z2;
        AppMethodBeat.o(115326);
    }

    @KeepForSdk
    public static Info getAdvertisingIdInfo(Context context) {
        AppMethodBeat.i(115335);
        zzb zzb = new zzb(context);
        boolean z = zzb.getBoolean("gads:ad_id_app_context:enabled", false);
        float f = zzb.getFloat("gads:ad_id_app_context:ping_ratio", 0.0f);
        String string = zzb.getString("gads:ad_id_use_shared_preference:experiment_id", "");
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1, z, zzb.getBoolean("gads:ad_id_use_persistent_service:enabled", false));
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            advertisingIdClient.zza(false);
            Info info = advertisingIdClient.getInfo();
            advertisingIdClient.zza(info, z, f, SystemClock.elapsedRealtime() - elapsedRealtime, string, null);
            advertisingIdClient.finish();
            AppMethodBeat.o(115335);
            return info;
        } catch (Throwable th) {
            advertisingIdClient.finish();
            AppMethodBeat.o(115335);
        }
    }

    @KeepForSdk
    public static boolean getIsAdIdFakeForDebugLogging(Context context) {
        AppMethodBeat.i(115336);
        zzb zzb = new zzb(context);
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1, zzb.getBoolean("gads:ad_id_app_context:enabled", false), zzb.getBoolean("com.google.android.gms.ads.identifier.service.PERSISTENT_START", false));
        try {
            advertisingIdClient.zza(false);
            boolean zzb2 = advertisingIdClient.zzb();
            return zzb2;
        } finally {
            advertisingIdClient.finish();
            AppMethodBeat.o(115336);
        }
    }

    @KeepForSdk
    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
    }

    private static BlockingServiceConnection zza(Context context, boolean z) {
        AppMethodBeat.i(115334);
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            IOException iOException;
            switch (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, 12451000)) {
                case 0:
                case 2:
                    String str = z ? "com.google.android.gms.ads.identifier.service.PERSISTENT_START" : "com.google.android.gms.ads.identifier.service.START";
                    BlockingServiceConnection blockingServiceConnection = new BlockingServiceConnection();
                    Intent intent = new Intent(str);
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (ConnectionTracker.getInstance().bindService(context, intent, blockingServiceConnection, 1)) {
                            AppMethodBeat.o(115334);
                            return blockingServiceConnection;
                        }
                        iOException = new IOException("Connection failure");
                        AppMethodBeat.o(115334);
                        throw iOException;
                    } catch (Throwable th) {
                        IOException iOException2 = new IOException(th);
                        AppMethodBeat.o(115334);
                    }
                default:
                    iOException = new IOException("Google Play services not available");
                    AppMethodBeat.o(115334);
                    throw iOException;
            }
        } catch (NameNotFoundException e) {
            GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException = new GooglePlayServicesNotAvailableException(9);
            AppMethodBeat.o(115334);
            throw googlePlayServicesNotAvailableException;
        }
    }

    @VisibleForTesting
    private static zze zza(Context context, BlockingServiceConnection blockingServiceConnection) {
        AppMethodBeat.i(115338);
        try {
            zze zza = zzf.zza(blockingServiceConnection.getServiceWithTimeout(10000, TimeUnit.MILLISECONDS));
            AppMethodBeat.o(115338);
            return zza;
        } catch (InterruptedException e) {
            IOException iOException = new IOException("Interrupted exception");
            AppMethodBeat.o(115338);
            throw iOException;
        } catch (Throwable th) {
            IOException iOException2 = new IOException(th);
            AppMethodBeat.o(115338);
        }
    }

    private final void zza() {
        AppMethodBeat.i(115329);
        synchronized (this.zzh) {
            try {
                if (this.zzi != null) {
                    this.zzi.zzo.countDown();
                    try {
                        this.zzi.join();
                    } catch (InterruptedException e) {
                    }
                }
                if (this.zzk > 0) {
                    this.zzi = new zza(this, this.zzk);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(115329);
            }
        }
    }

    @VisibleForTesting
    private final void zza(boolean z) {
        AppMethodBeat.i(115328);
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.zzg) {
                    finish();
                }
                this.zze = zza(this.mContext, this.zzj);
                this.zzf = zza(this.mContext, this.zze);
                this.zzg = true;
                if (z) {
                    zza();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(115328);
            }
        }
    }

    @VisibleForTesting
    private final boolean zza(Info info, boolean z, float f, long j, String str, Throwable th) {
        AppMethodBeat.i(115337);
        if (Math.random() > ((double) f)) {
            AppMethodBeat.o(115337);
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("app_context", z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        if (info != null) {
            hashMap.put("limit_ad_tracking", info.isLimitAdTrackingEnabled() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        if (!(info == null || info.getId() == null)) {
            hashMap.put("ad_id_size", Integer.toString(info.getId().length()));
        }
        if (th != null) {
            hashMap.put("error", th.getClass().getName());
        }
        if (!(str == null || str.isEmpty())) {
            hashMap.put("experiment_id", str);
        }
        hashMap.put("tag", "AdvertisingIdClient");
        hashMap.put("time_spent", Long.toString(j));
        new zza(this, hashMap).start();
        AppMethodBeat.o(115337);
        return true;
    }

    private final boolean zzb() {
        boolean zzc;
        AppMethodBeat.i(115331);
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            IOException iOException;
            try {
                if (!this.zzg) {
                    synchronized (this.zzh) {
                        if (this.zzi == null || !this.zzi.zzp) {
                            iOException = new IOException("AdvertisingIdClient is not connected.");
                            AppMethodBeat.o(115331);
                            throw iOException;
                        }
                    }
                    zza(false);
                    if (!this.zzg) {
                        iOException = new IOException("AdvertisingIdClient cannot reconnect.");
                        AppMethodBeat.o(115331);
                        throw iOException;
                    }
                }
                Preconditions.checkNotNull(this.zze);
                Preconditions.checkNotNull(this.zzf);
                zzc = this.zzf.zzc();
            } catch (RemoteException e) {
                iOException = new IOException("Remote exception");
                AppMethodBeat.o(115331);
                throw iOException;
            } catch (Exception e2) {
                IOException iOException2 = new IOException("AdvertisingIdClient cannot reconnect.", e2);
                AppMethodBeat.o(115331);
                throw iOException2;
            } catch (Throwable th) {
                AppMethodBeat.o(115331);
                throw th;
            }
        }
        zza();
        AppMethodBeat.o(115331);
        return zzc;
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.i(115333);
        finish();
        super.finalize();
        AppMethodBeat.o(115333);
    }

    public final void finish() {
        AppMethodBeat.i(115332);
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.mContext == null || this.zze == null) {
                } else {
                    try {
                        if (this.zzg) {
                            ConnectionTracker.getInstance().unbindService(this.mContext, this.zze);
                        }
                    } catch (Throwable th) {
                    }
                    this.zzg = false;
                    this.zzf = null;
                    this.zze = null;
                    AppMethodBeat.o(115332);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(115332);
            }
        }
    }

    @KeepForSdk
    public Info getInfo() {
        Info info;
        AppMethodBeat.i(115330);
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            IOException iOException;
            try {
                if (!this.zzg) {
                    synchronized (this.zzh) {
                        if (this.zzi == null || !this.zzi.zzp) {
                            iOException = new IOException("AdvertisingIdClient is not connected.");
                            AppMethodBeat.o(115330);
                            throw iOException;
                        }
                    }
                    zza(false);
                    if (!this.zzg) {
                        iOException = new IOException("AdvertisingIdClient cannot reconnect.");
                        AppMethodBeat.o(115330);
                        throw iOException;
                    }
                }
                Preconditions.checkNotNull(this.zze);
                Preconditions.checkNotNull(this.zzf);
                info = new Info(this.zzf.getId(), this.zzf.zzb(true));
            } catch (RemoteException e) {
                iOException = new IOException("Remote exception");
                AppMethodBeat.o(115330);
                throw iOException;
            } catch (Exception e2) {
                IOException iOException2 = new IOException("AdvertisingIdClient cannot reconnect.", e2);
                AppMethodBeat.o(115330);
                throw iOException2;
            } catch (Throwable th) {
                AppMethodBeat.o(115330);
                throw th;
            }
        }
        zza();
        AppMethodBeat.o(115330);
        return info;
    }

    @KeepForSdk
    public void start() {
        AppMethodBeat.i(115327);
        zza(true);
        AppMethodBeat.o(115327);
    }
}
