package com.google.android.gms.iid;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;

public final class zzr {
    private final ScheduledExecutorService zzbz;
    @GuardedBy("this")
    private zzt zzca;
    @GuardedBy("this")
    private int zzcb;
    private final Context zzk;

    public zzr(Context context) {
        this(context, Executors.newSingleThreadScheduledExecutor());
        AppMethodBeat.m2504i(57599);
        AppMethodBeat.m2505o(57599);
    }

    private zzr(Context context, ScheduledExecutorService scheduledExecutorService) {
        AppMethodBeat.m2504i(57600);
        this.zzca = new zzt(this);
        this.zzcb = 1;
        this.zzk = context.getApplicationContext();
        this.zzbz = scheduledExecutorService;
        AppMethodBeat.m2505o(57600);
    }

    private final synchronized <T> Task<T> zzd(zzz<T> zzz) {
        Task task;
        AppMethodBeat.m2504i(57602);
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(zzz);
            new StringBuilder(String.valueOf(valueOf).length() + 9).append("Queueing ").append(valueOf);
        }
        if (!this.zzca.zze(zzz)) {
            this.zzca = new zzt(this);
            this.zzca.zze(zzz);
        }
        task = zzz.zzcl.getTask();
        AppMethodBeat.m2505o(57602);
        return task;
    }

    private final synchronized int zzq() {
        int i;
        i = this.zzcb;
        this.zzcb = i + 1;
        return i;
    }

    public final Task<Bundle> zzd(int i, Bundle bundle) {
        AppMethodBeat.m2504i(57601);
        Task zzd = zzd(new zzab(zzq(), 1, bundle));
        AppMethodBeat.m2505o(57601);
        return zzd;
    }
}
