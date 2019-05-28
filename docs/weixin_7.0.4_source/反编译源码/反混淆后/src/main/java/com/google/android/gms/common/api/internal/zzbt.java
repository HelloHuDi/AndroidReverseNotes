package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;

public class zzbt extends zzk {
    private TaskCompletionSource<Void> zzln = new TaskCompletionSource();

    private zzbt(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        AppMethodBeat.m2504i(60848);
        this.mLifecycleFragment.addCallback("GmsAvailabilityHelper", this);
        AppMethodBeat.m2505o(60848);
    }

    public static zzbt zzd(Activity activity) {
        AppMethodBeat.m2504i(60847);
        LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
        zzbt zzbt = (zzbt) fragment.getCallbackOrNull("GmsAvailabilityHelper", zzbt.class);
        if (zzbt != null) {
            if (zzbt.zzln.getTask().isComplete()) {
                zzbt.zzln = new TaskCompletionSource();
            }
            AppMethodBeat.m2505o(60847);
            return zzbt;
        }
        zzbt = new zzbt(fragment);
        AppMethodBeat.m2505o(60847);
        return zzbt;
    }

    public final Task<Void> getTask() {
        AppMethodBeat.m2504i(60852);
        Task task = this.zzln.getTask();
        AppMethodBeat.m2505o(60852);
        return task;
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(60851);
        super.onDestroy();
        this.zzln.trySetException(new CancellationException("Host activity was destroyed before Google Play services could be made available."));
        AppMethodBeat.m2505o(60851);
    }

    /* Access modifiers changed, original: protected|final */
    public final void zza(ConnectionResult connectionResult, int i) {
        AppMethodBeat.m2504i(60849);
        this.zzln.setException(ApiExceptionUtil.fromConnectionResult(connectionResult));
        AppMethodBeat.m2505o(60849);
    }

    /* Access modifiers changed, original: protected|final */
    public final void zzr() {
        AppMethodBeat.m2504i(60850);
        int isGooglePlayServicesAvailable = this.zzdg.isGooglePlayServicesAvailable(this.mLifecycleFragment.getLifecycleActivity());
        if (isGooglePlayServicesAvailable == 0) {
            this.zzln.setResult(null);
            AppMethodBeat.m2505o(60850);
            return;
        }
        if (!this.zzln.getTask().isComplete()) {
            zzb(new ConnectionResult(isGooglePlayServicesAvailable, null), 0);
        }
        AppMethodBeat.m2505o(60850);
    }
}
