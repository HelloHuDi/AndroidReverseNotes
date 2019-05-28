package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class Batch extends BasePendingResult<BatchResult> {
    private final Object mLock;
    private int zzcd;
    private boolean zzce;
    private boolean zzcf;
    private final PendingResult<?>[] zzcg;

    public static final class Builder {
        private List<PendingResult<?>> zzci = new ArrayList();
        private GoogleApiClient zzcj;

        public Builder(GoogleApiClient googleApiClient) {
            AppMethodBeat.m2504i(60483);
            this.zzcj = googleApiClient;
            AppMethodBeat.m2505o(60483);
        }

        public final <R extends Result> BatchResultToken<R> add(PendingResult<R> pendingResult) {
            AppMethodBeat.m2504i(60484);
            BatchResultToken batchResultToken = new BatchResultToken(this.zzci.size());
            this.zzci.add(pendingResult);
            AppMethodBeat.m2505o(60484);
            return batchResultToken;
        }

        public final Batch build() {
            AppMethodBeat.m2504i(60485);
            Batch batch = new Batch(this.zzci, this.zzcj, null);
            AppMethodBeat.m2505o(60485);
            return batch;
        }
    }

    private Batch(List<PendingResult<?>> list, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        AppMethodBeat.m2504i(60486);
        this.mLock = new Object();
        this.zzcd = list.size();
        this.zzcg = new PendingResult[this.zzcd];
        if (list.isEmpty()) {
            setResult(new BatchResult(Status.RESULT_SUCCESS, this.zzcg));
            AppMethodBeat.m2505o(60486);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                PendingResult pendingResult = (PendingResult) list.get(i2);
                this.zzcg[i2] = pendingResult;
                pendingResult.addStatusListener(new zza(this));
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(60486);
                return;
            }
        }
    }

    /* synthetic */ Batch(List list, GoogleApiClient googleApiClient, zza zza) {
        this(list, googleApiClient);
    }

    static /* synthetic */ void zze(Batch batch) {
        AppMethodBeat.m2504i(60490);
        super.cancel();
        AppMethodBeat.m2505o(60490);
    }

    public final void cancel() {
        AppMethodBeat.m2504i(60487);
        super.cancel();
        for (PendingResult cancel : this.zzcg) {
            cancel.cancel();
        }
        AppMethodBeat.m2505o(60487);
    }

    public final BatchResult createFailedResult(Status status) {
        AppMethodBeat.m2504i(60488);
        BatchResult batchResult = new BatchResult(status, this.zzcg);
        AppMethodBeat.m2505o(60488);
        return batchResult;
    }
}
