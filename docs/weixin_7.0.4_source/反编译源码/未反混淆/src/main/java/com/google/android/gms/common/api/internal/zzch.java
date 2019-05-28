package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import javax.annotation.concurrent.GuardedBy;

public final class zzch<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {
    private final Object zzfa = new Object();
    private final WeakReference<GoogleApiClient> zzfc;
    private ResultTransform<? super R, ? extends Result> zzmd = null;
    private zzch<? extends Result> zzme = null;
    private volatile ResultCallbacks<? super R> zzmf = null;
    private PendingResult<R> zzmg = null;
    private Status zzmh = null;
    private final zzcj zzmi;
    private boolean zzmj = false;

    public zzch(WeakReference<GoogleApiClient> weakReference) {
        AppMethodBeat.i(60877);
        Preconditions.checkNotNull(weakReference, "GoogleApiClient reference must not be null");
        this.zzfc = weakReference;
        GoogleApiClient googleApiClient = (GoogleApiClient) this.zzfc.get();
        this.zzmi = new zzcj(this, googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
        AppMethodBeat.o(60877);
    }

    private static void zzb(Result result) {
        AppMethodBeat.i(60886);
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
                AppMethodBeat.o(60886);
                return;
            } catch (RuntimeException e) {
                String valueOf = String.valueOf(result);
                new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf);
            }
        }
        AppMethodBeat.o(60886);
    }

    @GuardedBy("mSyncToken")
    private final void zzcb() {
        AppMethodBeat.i(60882);
        if (this.zzmd == null && this.zzmf == null) {
            AppMethodBeat.o(60882);
            return;
        }
        GoogleApiClient googleApiClient = (GoogleApiClient) this.zzfc.get();
        if (!(this.zzmj || this.zzmd == null || googleApiClient == null)) {
            googleApiClient.zza(this);
            this.zzmj = true;
        }
        if (this.zzmh != null) {
            zze(this.zzmh);
            AppMethodBeat.o(60882);
            return;
        }
        if (this.zzmg != null) {
            this.zzmg.setResultCallback(this);
        }
        AppMethodBeat.o(60882);
    }

    @GuardedBy("mSyncToken")
    private final boolean zzcd() {
        AppMethodBeat.i(60885);
        GoogleApiClient googleApiClient = (GoogleApiClient) this.zzfc.get();
        if (this.zzmf == null || googleApiClient == null) {
            AppMethodBeat.o(60885);
            return false;
        }
        AppMethodBeat.o(60885);
        return true;
    }

    private final void zzd(Status status) {
        AppMethodBeat.i(60883);
        synchronized (this.zzfa) {
            try {
                this.zzmh = status;
                zze(this.zzmh);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(60883);
            }
        }
    }

    private final void zze(Status status) {
        AppMethodBeat.i(60884);
        synchronized (this.zzfa) {
            try {
                if (this.zzmd != null) {
                    Status onFailure = this.zzmd.onFailure(status);
                    Preconditions.checkNotNull(onFailure, "onFailure must not return null");
                    this.zzme.zzd(onFailure);
                } else if (zzcd()) {
                    this.zzmf.onFailure(status);
                }
            } finally {
                AppMethodBeat.o(60884);
            }
        }
    }

    public final void andFinally(ResultCallbacks<? super R> resultCallbacks) {
        boolean z = true;
        AppMethodBeat.i(60879);
        synchronized (this.zzfa) {
            try {
                Preconditions.checkState(this.zzmf == null, "Cannot call andFinally() twice.");
                if (this.zzmd != null) {
                    z = false;
                }
                Preconditions.checkState(z, "Cannot call then() and andFinally() on the same TransformedResult.");
                this.zzmf = resultCallbacks;
                zzcb();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(60879);
            }
        }
    }

    public final void onResult(R r) {
        AppMethodBeat.i(60880);
        synchronized (this.zzfa) {
            try {
                if (!r.getStatus().isSuccess()) {
                    zzd(r.getStatus());
                    zzb(r);
                } else if (this.zzmd != null) {
                    zzbw.zzbe().submit(new zzci(this, r));
                } else if (zzcd()) {
                    this.zzmf.onSuccess(r);
                }
            } finally {
                AppMethodBeat.o(60880);
            }
        }
    }

    public final <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        TransformedResult<S> zzch;
        boolean z = true;
        AppMethodBeat.i(60878);
        synchronized (this.zzfa) {
            try {
                Preconditions.checkState(this.zzmd == null, "Cannot call then() twice.");
                if (this.zzmf != null) {
                    z = false;
                }
                Preconditions.checkState(z, "Cannot call then() and andFinally() on the same TransformedResult.");
                this.zzmd = resultTransform;
                zzch = new zzch(this.zzfc);
                this.zzme = zzch;
                zzcb();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(60878);
            }
        }
        return zzch;
    }

    public final void zza(PendingResult<?> pendingResult) {
        AppMethodBeat.i(60881);
        synchronized (this.zzfa) {
            try {
                this.zzmg = pendingResult;
                zzcb();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(60881);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void zzcc() {
        this.zzmf = null;
    }
}
