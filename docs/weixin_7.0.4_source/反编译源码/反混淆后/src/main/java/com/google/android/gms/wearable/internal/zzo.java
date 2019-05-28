package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.CapabilityApi.AddLocalCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.CapabilityApi.GetAllCapabilitiesResult;
import com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.RemoveLocalCapabilityResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzo implements CapabilityApi {
    private static PendingResult<Status> zza(GoogleApiClient googleApiClient, CapabilityListener capabilityListener, IntentFilter[] intentFilterArr) {
        AppMethodBeat.m2504i(71461);
        PendingResult zza = zzb.zza(googleApiClient, new zzt(intentFilterArr), capabilityListener);
        AppMethodBeat.m2505o(71461);
        return zza;
    }

    public final PendingResult<Status> addCapabilityListener(GoogleApiClient googleApiClient, CapabilityListener capabilityListener, String str) {
        String str2;
        AppMethodBeat.m2504i(71459);
        Asserts.checkNotNull(str, "capability must not be null");
        zzv zzv = new zzv(capabilityListener, str);
        IntentFilter zzc = zzgj.zzc("com.google.android.gms.wearable.CAPABILITY_CHANGED");
        if (str.startsWith("/")) {
            str2 = str;
        } else {
            String str3 = "/";
            str2 = String.valueOf(str);
            str2 = str2.length() != 0 ? str3.concat(str2) : new String(str3);
        }
        zzc.addDataPath(str2, 0);
        PendingResult zza = zza(googleApiClient, zzv, new IntentFilter[]{zzc});
        AppMethodBeat.m2505o(71459);
        return zza;
    }

    public final PendingResult<Status> addListener(GoogleApiClient googleApiClient, CapabilityListener capabilityListener, Uri uri, int i) {
        AppMethodBeat.m2504i(71460);
        Asserts.checkNotNull(uri, "uri must not be null");
        boolean z = i == 0 || i == 1;
        Preconditions.checkArgument(z, "invalid filter type");
        PendingResult zza = zza(googleApiClient, capabilityListener, new IntentFilter[]{zzgj.zza("com.google.android.gms.wearable.CAPABILITY_CHANGED", uri, i)});
        AppMethodBeat.m2505o(71460);
        return zza;
    }

    public final PendingResult<AddLocalCapabilityResult> addLocalCapability(GoogleApiClient googleApiClient, String str) {
        AppMethodBeat.m2504i(71457);
        ApiMethodImpl enqueue = googleApiClient.enqueue(new zzr(this, googleApiClient, str));
        AppMethodBeat.m2505o(71457);
        return enqueue;
    }

    public final PendingResult<GetAllCapabilitiesResult> getAllCapabilities(GoogleApiClient googleApiClient, int i) {
        boolean z = true;
        AppMethodBeat.m2504i(71456);
        if (!(i == 0 || i == 1)) {
            z = false;
        }
        Preconditions.checkArgument(z);
        ApiMethodImpl enqueue = googleApiClient.enqueue(new zzq(this, googleApiClient, i));
        AppMethodBeat.m2505o(71456);
        return enqueue;
    }

    public final PendingResult<GetCapabilityResult> getCapability(GoogleApiClient googleApiClient, String str, int i) {
        boolean z = true;
        AppMethodBeat.m2504i(71455);
        if (!(i == 0 || i == 1)) {
            z = false;
        }
        Preconditions.checkArgument(z);
        ApiMethodImpl enqueue = googleApiClient.enqueue(new zzp(this, googleApiClient, str, i));
        AppMethodBeat.m2505o(71455);
        return enqueue;
    }

    public final PendingResult<Status> removeCapabilityListener(GoogleApiClient googleApiClient, CapabilityListener capabilityListener, String str) {
        AppMethodBeat.m2504i(71462);
        ApiMethodImpl enqueue = googleApiClient.enqueue(new zzz(googleApiClient, new zzv(capabilityListener, str), null));
        AppMethodBeat.m2505o(71462);
        return enqueue;
    }

    public final PendingResult<Status> removeListener(GoogleApiClient googleApiClient, CapabilityListener capabilityListener) {
        AppMethodBeat.m2504i(71463);
        ApiMethodImpl enqueue = googleApiClient.enqueue(new zzz(googleApiClient, capabilityListener, null));
        AppMethodBeat.m2505o(71463);
        return enqueue;
    }

    public final PendingResult<RemoveLocalCapabilityResult> removeLocalCapability(GoogleApiClient googleApiClient, String str) {
        AppMethodBeat.m2504i(71458);
        ApiMethodImpl enqueue = googleApiClient.enqueue(new zzs(this, googleApiClient, str));
        AppMethodBeat.m2505o(71458);
        return enqueue;
    }
}
