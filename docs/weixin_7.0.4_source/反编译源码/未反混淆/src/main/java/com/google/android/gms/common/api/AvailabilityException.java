package com.google.android.gms.common.api;

import android.support.v4.f.a;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.internal.zzh;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class AvailabilityException extends Exception {
    private final a<zzh<?>, ConnectionResult> zzcc;

    public AvailabilityException(a<zzh<?>, ConnectionResult> aVar) {
        this.zzcc = aVar;
    }

    public ConnectionResult getConnectionResult(GoogleApi<? extends ApiOptions> googleApi) {
        AppMethodBeat.i(60481);
        zzh zzm = googleApi.zzm();
        Preconditions.checkArgument(this.zzcc.get(zzm) != null, "The given API was not part of the availability request.");
        ConnectionResult connectionResult = (ConnectionResult) this.zzcc.get(zzm);
        AppMethodBeat.o(60481);
        return connectionResult;
    }

    public String getMessage() {
        String zzq;
        AppMethodBeat.i(60482);
        ArrayList arrayList = new ArrayList();
        Object obj = 1;
        for (zzh zzh : this.zzcc.keySet()) {
            ConnectionResult connectionResult = (ConnectionResult) this.zzcc.get(zzh);
            if (connectionResult.isSuccess()) {
                obj = null;
            }
            zzq = zzh.zzq();
            String valueOf = String.valueOf(connectionResult);
            arrayList.add(new StringBuilder((String.valueOf(zzq).length() + 2) + String.valueOf(valueOf).length()).append(zzq).append(": ").append(valueOf).toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (obj != null) {
            stringBuilder.append("None of the queried APIs are available. ");
        } else {
            stringBuilder.append("Some of the queried APIs are unavailable. ");
        }
        stringBuilder.append(TextUtils.join("; ", arrayList));
        zzq = stringBuilder.toString();
        AppMethodBeat.o(60482);
        return zzq;
    }

    public final a<zzh<?>, ConnectionResult> zzl() {
        return this.zzcc;
    }
}
