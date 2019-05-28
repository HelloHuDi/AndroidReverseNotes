package com.google.android.gms.common.api;

import android.support.p057v4.p065f.C6197a;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.internal.zzh;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class AvailabilityException extends Exception {
    private final C6197a<zzh<?>, ConnectionResult> zzcc;

    public AvailabilityException(C6197a<zzh<?>, ConnectionResult> c6197a) {
        this.zzcc = c6197a;
    }

    public ConnectionResult getConnectionResult(GoogleApi<? extends ApiOptions> googleApi) {
        AppMethodBeat.m2504i(60481);
        zzh zzm = googleApi.zzm();
        Preconditions.checkArgument(this.zzcc.get(zzm) != null, "The given API was not part of the availability request.");
        ConnectionResult connectionResult = (ConnectionResult) this.zzcc.get(zzm);
        AppMethodBeat.m2505o(60481);
        return connectionResult;
    }

    public String getMessage() {
        String zzq;
        AppMethodBeat.m2504i(60482);
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
        AppMethodBeat.m2505o(60482);
        return zzq;
    }

    public final C6197a<zzh<?>, ConnectionResult> zzl() {
        return this.zzcc;
    }
}
