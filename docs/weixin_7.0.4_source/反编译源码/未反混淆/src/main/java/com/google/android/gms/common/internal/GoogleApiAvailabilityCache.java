package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api.Client;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GoogleApiAvailabilityCache {
    private final SparseIntArray zzug;
    private GoogleApiAvailabilityLight zzuh;

    public GoogleApiAvailabilityCache() {
        this(GoogleApiAvailability.getInstance());
        AppMethodBeat.i(61347);
        AppMethodBeat.o(61347);
    }

    public GoogleApiAvailabilityCache(GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        AppMethodBeat.i(61348);
        this.zzug = new SparseIntArray();
        Preconditions.checkNotNull(googleApiAvailabilityLight);
        this.zzuh = googleApiAvailabilityLight;
        AppMethodBeat.o(61348);
    }

    public void flush() {
        AppMethodBeat.i(61350);
        this.zzug.clear();
        AppMethodBeat.o(61350);
    }

    public int getClientAvailability(Context context, Client client) {
        AppMethodBeat.i(61349);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(client);
        if (client.requiresGooglePlayServices()) {
            int minApkVersion = client.getMinApkVersion();
            int i = this.zzug.get(minApkVersion, -1);
            if (i != -1) {
                AppMethodBeat.o(61349);
                return i;
            }
            int i2;
            for (i2 = 0; i2 < this.zzug.size(); i2++) {
                int keyAt = this.zzug.keyAt(i2);
                if (keyAt > minApkVersion && this.zzug.get(keyAt) == 0) {
                    i2 = 0;
                    break;
                }
            }
            i2 = i;
            if (i2 == -1) {
                i2 = this.zzuh.isGooglePlayServicesAvailable(context, minApkVersion);
            }
            this.zzug.put(minApkVersion, i2);
            AppMethodBeat.o(61349);
            return i2;
        }
        AppMethodBeat.o(61349);
        return 0;
    }
}
