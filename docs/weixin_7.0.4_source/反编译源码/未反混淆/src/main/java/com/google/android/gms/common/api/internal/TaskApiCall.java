package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepForSdk
public abstract class TaskApiCall<A extends AnyClient, ResultT> {
    private final Feature[] zzlz;
    private final boolean zzma;

    @KeepForSdk
    public static class Builder<A extends AnyClient, ResultT> {
        private Feature[] zzlz;
        private boolean zzma;
        private BiConsumer<A, TaskCompletionSource<ResultT>> zzmb;

        private Builder() {
            this.zzma = true;
        }

        /* synthetic */ Builder(zzce zzce) {
            this();
        }

        @KeepForSdk
        public TaskApiCall<A, ResultT> build() {
            AppMethodBeat.i(60663);
            if (this.zzmb == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("execute parameter required");
                AppMethodBeat.o(60663);
                throw illegalArgumentException;
            }
            zzcf zzcf = new zzcf(this, this.zzlz, this.zzma);
            AppMethodBeat.o(60663);
            return zzcf;
        }

        @KeepForSdk
        public Builder<A, ResultT> execute(BiConsumer<A, TaskCompletionSource<ResultT>> biConsumer) {
            this.zzmb = biConsumer;
            return this;
        }

        @KeepForSdk
        public Builder<A, ResultT> setAutoResolveMissingFeatures(boolean z) {
            this.zzma = z;
            return this;
        }

        @KeepForSdk
        public Builder<A, ResultT> setFeatures(Feature[] featureArr) {
            this.zzlz = featureArr;
            return this;
        }
    }

    @KeepForSdk
    @Deprecated
    public TaskApiCall() {
        this.zzlz = null;
        this.zzma = false;
    }

    @KeepForSdk
    private TaskApiCall(Feature[] featureArr, boolean z) {
        this.zzlz = featureArr;
        this.zzma = z;
    }

    /* synthetic */ TaskApiCall(Feature[] featureArr, boolean z, zzce zzce) {
        this(featureArr, z);
    }

    @KeepForSdk
    public static <A extends AnyClient, ResultT> Builder<A, ResultT> builder() {
        return new Builder();
    }

    @KeepForSdk
    public abstract void doExecute(A a, TaskCompletionSource<ResultT> taskCompletionSource);

    @KeepForSdk
    public boolean shouldAutoResolveMissingFeatures() {
        return this.zzma;
    }

    public final Feature[] zzca() {
        return this.zzlz;
    }
}
