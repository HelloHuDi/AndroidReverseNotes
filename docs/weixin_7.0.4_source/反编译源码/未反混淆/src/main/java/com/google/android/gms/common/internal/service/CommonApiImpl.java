package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class CommonApiImpl implements CommonApi {

    static class zza extends BaseCommonServiceCallbacks {
        private final ResultHolder<Status> mResultHolder;

        public zza(ResultHolder<Status> resultHolder) {
            this.mResultHolder = resultHolder;
        }

        public final void onDefaultAccountCleared(int i) {
            AppMethodBeat.i(61392);
            this.mResultHolder.setResult(new Status(i));
            AppMethodBeat.o(61392);
        }
    }

    public final PendingResult<Status> clearDefaultAccount(GoogleApiClient googleApiClient) {
        AppMethodBeat.i(61393);
        ApiMethodImpl execute = googleApiClient.execute(new zzb(this, googleApiClient));
        AppMethodBeat.o(61393);
        return execute;
    }
}
