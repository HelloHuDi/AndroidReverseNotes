package com.google.android.gms.common.api.internal;

import android.support.v4.f.a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.Set;

public final class zzj {
    private final a<zzh<?>, ConnectionResult> zzcc = new a();
    private final a<zzh<?>, String> zzei = new a();
    private final TaskCompletionSource<Map<zzh<?>, String>> zzej = new TaskCompletionSource();
    private int zzek;
    private boolean zzel = false;

    public zzj(Iterable<? extends GoogleApi<?>> iterable) {
        AppMethodBeat.i(60935);
        for (GoogleApi zzm : iterable) {
            this.zzcc.put(zzm.zzm(), null);
        }
        this.zzek = this.zzcc.keySet().size();
        AppMethodBeat.o(60935);
    }

    public final Task<Map<zzh<?>, String>> getTask() {
        AppMethodBeat.i(60937);
        Task task = this.zzej.getTask();
        AppMethodBeat.o(60937);
        return task;
    }

    public final void zza(zzh<?> zzh, ConnectionResult connectionResult, String str) {
        AppMethodBeat.i(60938);
        this.zzcc.put(zzh, connectionResult);
        this.zzei.put(zzh, str);
        this.zzek--;
        if (!connectionResult.isSuccess()) {
            this.zzel = true;
        }
        if (this.zzek == 0) {
            if (this.zzel) {
                this.zzej.setException(new AvailabilityException(this.zzcc));
                AppMethodBeat.o(60938);
                return;
            }
            this.zzej.setResult(this.zzei);
        }
        AppMethodBeat.o(60938);
    }

    public final Set<zzh<?>> zzs() {
        AppMethodBeat.i(60936);
        Set keySet = this.zzcc.keySet();
        AppMethodBeat.o(60936);
        return keySet;
    }
}
