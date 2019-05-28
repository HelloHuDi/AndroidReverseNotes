package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall.Builder;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzcf extends TaskApiCall<A, ResultT> {
    private final /* synthetic */ Builder zzmc;

    zzcf(Builder builder, Feature[] featureArr, boolean z) {
        this.zzmc = builder;
        super(featureArr, z, null);
    }

    /* Access modifiers changed, original: protected|final */
    public final void doExecute(A a, TaskCompletionSource<ResultT> taskCompletionSource) {
        AppMethodBeat.m2504i(60875);
        this.zzmc.zzmb.accept(a, taskCompletionSource);
        AppMethodBeat.m2505o(60875);
    }
}
