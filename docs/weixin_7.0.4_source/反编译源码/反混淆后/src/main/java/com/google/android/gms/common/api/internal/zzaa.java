package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public final class zzaa {
    private final Map<BasePendingResult<?>, Boolean> zzgw = Collections.synchronizedMap(new WeakHashMap());
    private final Map<TaskCompletionSource<?>, Boolean> zzgx = Collections.synchronizedMap(new WeakHashMap());

    public zzaa() {
        AppMethodBeat.m2504i(60676);
        AppMethodBeat.m2505o(60676);
    }

    private final void zza(boolean z, Status status) {
        AppMethodBeat.m2504i(60682);
        synchronized (this.zzgw) {
            try {
                HashMap hashMap = new HashMap(this.zzgw);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(60682);
            }
        }
        synchronized (this.zzgx) {
            try {
                HashMap hashMap2 = new HashMap(this.zzgx);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(60682);
                }
            }
        }
        for (Entry entry : hashMap.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).zzb(status);
            }
        }
        for (Entry entry2 : hashMap2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((TaskCompletionSource) entry2.getKey()).trySetException(new ApiException(status));
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void zza(BasePendingResult<? extends Result> basePendingResult, boolean z) {
        AppMethodBeat.m2504i(60677);
        this.zzgw.put(basePendingResult, Boolean.valueOf(z));
        basePendingResult.addStatusListener(new zzab(this, basePendingResult));
        AppMethodBeat.m2505o(60677);
    }

    /* Access modifiers changed, original: final */
    public final <TResult> void zza(TaskCompletionSource<TResult> taskCompletionSource, boolean z) {
        AppMethodBeat.m2504i(60678);
        this.zzgx.put(taskCompletionSource, Boolean.valueOf(z));
        taskCompletionSource.getTask().addOnCompleteListener(new zzac(this, taskCompletionSource));
        AppMethodBeat.m2505o(60678);
    }

    /* Access modifiers changed, original: final */
    public final boolean zzaj() {
        AppMethodBeat.m2504i(60679);
        if (this.zzgw.isEmpty() && this.zzgx.isEmpty()) {
            AppMethodBeat.m2505o(60679);
            return false;
        }
        AppMethodBeat.m2505o(60679);
        return true;
    }

    public final void zzak() {
        AppMethodBeat.m2504i(60680);
        zza(false, GoogleApiManager.zzjj);
        AppMethodBeat.m2505o(60680);
    }

    public final void zzal() {
        AppMethodBeat.m2504i(60681);
        zza(true, zzck.zzmm);
        AppMethodBeat.m2505o(60681);
    }
}
