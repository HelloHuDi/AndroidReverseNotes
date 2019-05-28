package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.OptionalPendingResultImpl;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepForSdk
public final class PendingResults {

    static final class zza<R extends Result> extends BasePendingResult<R> {
        private final R zzdl;

        public zza(R r) {
            super(Looper.getMainLooper());
            AppMethodBeat.i(60553);
            this.zzdl = r;
            AppMethodBeat.o(60553);
        }

        public final R createFailedResult(Status status) {
            AppMethodBeat.i(60554);
            if (status.getStatusCode() != this.zzdl.getStatus().getStatusCode()) {
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Creating failed results is not supported");
                AppMethodBeat.o(60554);
                throw unsupportedOperationException;
            }
            Result result = this.zzdl;
            AppMethodBeat.o(60554);
            return result;
        }
    }

    static final class zzb<R extends Result> extends BasePendingResult<R> {
        private final R zzdm;

        public zzb(GoogleApiClient googleApiClient, R r) {
            super(googleApiClient);
            this.zzdm = r;
        }

        public final R createFailedResult(Status status) {
            return this.zzdm;
        }
    }

    static final class zzc<R extends Result> extends BasePendingResult<R> {
        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public final R createFailedResult(Status status) {
            AppMethodBeat.i(60555);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Creating failed results is not supported");
            AppMethodBeat.o(60555);
            throw unsupportedOperationException;
        }
    }

    @KeepForSdk
    private PendingResults() {
    }

    public static PendingResult<Status> canceledPendingResult() {
        AppMethodBeat.i(60561);
        StatusPendingResult statusPendingResult = new StatusPendingResult(Looper.getMainLooper());
        statusPendingResult.cancel();
        AppMethodBeat.o(60561);
        return statusPendingResult;
    }

    public static <R extends Result> PendingResult<R> canceledPendingResult(R r) {
        AppMethodBeat.i(60562);
        Preconditions.checkNotNull(r, "Result must not be null");
        Preconditions.checkArgument(r.getStatus().getStatusCode() == 16, "Status code must be CommonStatusCodes.CANCELED");
        zza zza = new zza(r);
        zza.cancel();
        AppMethodBeat.o(60562);
        return zza;
    }

    @KeepForSdk
    public static <R extends Result> PendingResult<R> immediateFailedResult(R r, GoogleApiClient googleApiClient) {
        AppMethodBeat.i(60558);
        Preconditions.checkNotNull(r, "Result must not be null");
        Preconditions.checkArgument(!r.getStatus().isSuccess(), "Status code must not be SUCCESS");
        zzb zzb = new zzb(googleApiClient, r);
        zzb.setResult(r);
        AppMethodBeat.o(60558);
        return zzb;
    }

    @KeepForSdk
    public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R r) {
        AppMethodBeat.i(60559);
        Preconditions.checkNotNull(r, "Result must not be null");
        zzc zzc = new zzc(null);
        zzc.setResult(r);
        OptionalPendingResultImpl optionalPendingResultImpl = new OptionalPendingResultImpl(zzc);
        AppMethodBeat.o(60559);
        return optionalPendingResultImpl;
    }

    @KeepForSdk
    public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R r, GoogleApiClient googleApiClient) {
        AppMethodBeat.i(60560);
        Preconditions.checkNotNull(r, "Result must not be null");
        zzc zzc = new zzc(googleApiClient);
        zzc.setResult(r);
        OptionalPendingResultImpl optionalPendingResultImpl = new OptionalPendingResultImpl(zzc);
        AppMethodBeat.o(60560);
        return optionalPendingResultImpl;
    }

    @KeepForSdk
    public static PendingResult<Status> immediatePendingResult(Status status) {
        AppMethodBeat.i(60556);
        Preconditions.checkNotNull(status, "Result must not be null");
        StatusPendingResult statusPendingResult = new StatusPendingResult(Looper.getMainLooper());
        statusPendingResult.setResult(status);
        AppMethodBeat.o(60556);
        return statusPendingResult;
    }

    @KeepForSdk
    public static PendingResult<Status> immediatePendingResult(Status status, GoogleApiClient googleApiClient) {
        AppMethodBeat.i(60557);
        Preconditions.checkNotNull(status, "Result must not be null");
        StatusPendingResult statusPendingResult = new StatusPendingResult(googleApiClient);
        statusPendingResult.setResult(status);
        AppMethodBeat.o(60557);
        return statusPendingResult;
    }
}
