package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.atomic.AtomicReference;

public abstract class zzk extends LifecycleCallback implements OnCancelListener {
    protected volatile boolean mStarted;
    protected final GoogleApiAvailability zzdg;
    protected final AtomicReference<zzl> zzer;
    private final Handler zzes;

    protected zzk(LifecycleFragment lifecycleFragment) {
        this(lifecycleFragment, GoogleApiAvailability.getInstance());
    }

    @VisibleForTesting
    private zzk(LifecycleFragment lifecycleFragment, GoogleApiAvailability googleApiAvailability) {
        super(lifecycleFragment);
        this.zzer = new AtomicReference(null);
        this.zzes = new Handler(Looper.getMainLooper());
        this.zzdg = googleApiAvailability;
    }

    private static int zza(zzl zzl) {
        return zzl == null ? -1 : zzl.zzu();
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityResult(int i, int i2, Intent intent) {
        Object obj;
        int i3 = 13;
        zzl zzl = (zzl) this.zzer.get();
        switch (i) {
            case 1:
                if (i2 != -1) {
                    if (i2 == 0) {
                        if (intent != null) {
                            i3 = intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);
                        }
                        zzl zzl2 = new zzl(new ConnectionResult(i3, null), zza(zzl));
                        this.zzer.set(zzl2);
                        zzl = zzl2;
                        obj = null;
                        break;
                    }
                }
                i3 = 1;
                break;
            case 2:
                int isGooglePlayServicesAvailable = this.zzdg.isGooglePlayServicesAvailable(getActivity());
                obj = isGooglePlayServicesAvailable == 0 ? 1 : null;
                if (zzl == null) {
                    return;
                }
                if (zzl.getConnectionResult().getErrorCode() == 18 && isGooglePlayServicesAvailable == 18) {
                    return;
                }
            default:
                obj = null;
                break;
        }
        if (obj != null) {
            zzt();
        } else if (zzl != null) {
            zza(zzl.getConnectionResult(), zzl.zzu());
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        zza(new ConnectionResult(13, null), zza((zzl) this.zzer.get()));
        zzt();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.zzer.set(bundle.getBoolean("resolving_error", false) ? new zzl(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        zzl zzl = (zzl) this.zzer.get();
        if (zzl != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", zzl.zzu());
            bundle.putInt("failed_status", zzl.getConnectionResult().getErrorCode());
            bundle.putParcelable("failed_resolution", zzl.getConnectionResult().getResolution());
        }
    }

    public void onStart() {
        super.onStart();
        this.mStarted = true;
    }

    public void onStop() {
        super.onStop();
        this.mStarted = false;
    }

    public abstract void zza(ConnectionResult connectionResult, int i);

    public final void zzb(ConnectionResult connectionResult, int i) {
        zzl zzl = new zzl(connectionResult, i);
        if (this.zzer.compareAndSet(null, zzl)) {
            this.zzes.post(new zzm(this, zzl));
        }
    }

    public abstract void zzr();

    /* Access modifiers changed, original: protected|final */
    public final void zzt() {
        this.zzer.set(null);
        zzr();
    }
}
