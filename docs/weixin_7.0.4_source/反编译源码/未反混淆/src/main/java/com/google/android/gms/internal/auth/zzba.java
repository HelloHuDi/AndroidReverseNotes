package com.google.android.gms.internal.auth;

import android.os.IInterface;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

public interface zzba extends IInterface {
    void zzd(Status status, Credential credential);

    void zzd(Status status, String str);

    void zze(Status status);
}
