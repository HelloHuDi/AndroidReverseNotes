package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager.zza;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zzc<T> extends zzb {
    protected final TaskCompletionSource<T> zzdu;

    public zzc(int i, TaskCompletionSource<T> taskCompletionSource) {
        super(i);
        this.zzdu = taskCompletionSource;
    }

    public void zza(Status status) {
        this.zzdu.trySetException(new ApiException(status));
    }

    public final void zza(zza<?> zza) {
        try {
            zzb(zza);
        } catch (DeadObjectException e) {
            zza(zzb.zza((RemoteException) e));
            throw e;
        } catch (RemoteException e2) {
            zza(zzb.zza(e2));
        } catch (RuntimeException e3) {
            zza(e3);
        }
    }

    public void zza(zzaa zzaa, boolean z) {
    }

    public void zza(RuntimeException runtimeException) {
        this.zzdu.trySetException(runtimeException);
    }

    public abstract void zzb(zza<?> zza);
}
