package com.google.android.gms.internal.auth;

import android.os.IInterface;
import com.google.android.gms.auth.api.accounttransfer.DeviceMetaData;
import com.google.android.gms.auth.api.accounttransfer.zzo;
import com.google.android.gms.auth.api.accounttransfer.zzw;
import com.google.android.gms.common.api.Status;

public interface zzaa extends IInterface {
    void onFailure(Status status);

    void zzd(DeviceMetaData deviceMetaData);

    void zzd(Status status, zzo zzo);

    void zzd(Status status, zzw zzw);

    void zzd(byte[] bArr);

    void zze(Status status);

    void zzi();
}
